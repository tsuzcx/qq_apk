package com.tencent.tavcut.session;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.PointF;
import android.opengl.EGLContext;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.SparseArray;
import android.view.MotionEvent;
import android.view.ViewGroup;
import com.tencent.aekit.api.standard.filter.AEFilterManager;
import com.tencent.tav.coremedia.CGSize;
import com.tencent.tav.decoder.RenderContext;
import com.tencent.tavcut.TAVCut;
import com.tencent.tavcut.aekit.AEKitModel;
import com.tencent.tavcut.bean.CropConfig;
import com.tencent.tavcut.bean.TextEditorData;
import com.tencent.tavcut.exporter.ImageExportConfig;
import com.tencent.tavcut.exporter.ImageExporter;
import com.tencent.tavcut.session.config.SessionConfig;
import com.tencent.tavcut.session.config.StickerEditViewIconConfig;
import com.tencent.tavcut.util.BitmapUtil;
import com.tencent.tavcut.view.TAVCutImageView;
import com.tencent.tavcut.view.ext.OnRenderFinishListener;
import com.tencent.tavsticker.core.TAVStickerContext;
import com.tencent.tavsticker.model.TAVSticker;
import com.tencent.ttpic.baseutils.gles.EglCore;
import com.tencent.weseevideo.composition.VideoRenderChainConfigure;
import com.tencent.weseevideo.composition.VideoRenderChainManager;
import com.tencent.weseevideo.composition.VideoRenderChainManager.IStickerContextInterface;
import com.tencent.weseevideo.composition.builder.MediaBuilderFactory;
import com.tencent.weseevideo.composition.effectnode.PreSegNode.PicSaveDelegate;
import com.tencent.weseevideo.composition.image.AssetImageGenerator.ImageGeneratorThread;
import com.tencent.weseevideo.composition.image.WSImageRender;
import com.tencent.weseevideo.editor.sticker.PicStickerController;
import com.tencent.weseevideo.editor.sticker.StickerController;
import com.tencent.weseevideo.editor.sticker.WsStickerContext;
import com.tencent.weseevideo.model.MediaModel;
import com.tencent.weseevideo.model.ModelExtKt;
import com.tencent.weseevideo.model.WSTemplateManager;
import com.tencent.weseevideo.model.effect.CropModel;
import com.tencent.weseevideo.model.effect.GestureModel;
import com.tencent.weseevideo.model.effect.MediaEffectModel;
import com.tencent.weseevideo.model.effect.StickerModel;
import com.tencent.weseevideo.model.effect.TAVStickerExKt;
import com.tencent.weseevideo.model.resource.MediaClipModel;
import com.tencent.weseevideo.model.resource.MediaResourceModel;
import com.tencent.weseevideo.model.resource.VideoResourceModel;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class TAVCutImageSession
  extends TAVCutSession
{
  private static final int MAX_CACHE_SIZE = 1024;
  private static final String TAG = "TAVCutImageSession";
  private boolean addingMultiStickers = false;
  private AEFilterManager aeFilterManager = new AEFilterManager();
  private SparseArray<Bitmap> cacheBitmap = new SparseArray();
  private PreSegNode.PicSaveDelegate cachePicDelegate;
  private SparseArray<List<PointF>> cachePointFList = new SparseArray();
  private SparseArray<VideoRenderChainConfigure> chainConfigs = new SparseArray();
  private EGLContext eglContext;
  private EglCore eglCore;
  private List<String> imagePaths;
  private AssetImageGenerator.ImageGeneratorThread imageProcessThread;
  private SparseArray<WSImageRender> imageRenderers = new SparseArray();
  private RenderContext renderContext;
  private CGSize screenSize;
  private SparseArray<WeakReference<TAVCutImageView>> tavCutImageViews = new SparseArray();
  
  private CGSize calculateRenderSize(MediaModel paramMediaModel, String paramString)
  {
    paramMediaModel.getMediaEffectModel();
    int m = ((MediaClipModel)paramMediaModel.getMediaResourceModel().getVideos().get(0)).getResource().getWidth();
    int k = ((MediaClipModel)paramMediaModel.getMediaResourceModel().getVideos().get(0)).getResource().getHeight();
    paramMediaModel = paramMediaModel.getMediaEffectModel().getCropModel();
    int j = k;
    int i = m;
    if (paramMediaModel != null)
    {
      j = k;
      i = m;
      if (paramMediaModel.getCropConfig() != null)
      {
        i = (int)(m * paramMediaModel.getCropConfig().getWidth());
        j = (int)(k * paramMediaModel.getCropConfig().getHeight());
      }
    }
    return constrainRenderSize(i, j);
  }
  
  private VideoRenderChainConfigure getRenderChainConfig(int paramInt)
  {
    if (this.chainConfigs.get(paramInt) == null) {
      this.chainConfigs.put(paramInt, new VideoRenderChainConfigure(true));
    }
    return (VideoRenderChainConfigure)this.chainConfigs.get(paramInt);
  }
  
  private void initAEFilterManager()
  {
    this.aeFilterManager = new AEFilterManager();
    this.aeFilterManager.defineFiltersAndOrder(new int[] { 300, 100 });
    this.aeFilterManager.setFilterInSmooth(true);
  }
  
  private void initGLContext()
  {
    this.eglCore = new EglCore();
    this.eglContext = this.eglCore.getEGLContext();
    initAEFilterManager();
  }
  
  private void initMediaModel()
  {
    runTask(new TAVCutImageSession.2(this));
  }
  
  private void initRenderEnvironment(int paramInt)
  {
    if ((!ModelExtKt.isAutoTemplate((MediaModel)this.mediaModels.get(paramInt))) || (!"1".equals(((MediaModel)this.mediaModels.get(paramInt)).getMediaEffectModel().getParam("FRAME_PARAMS_KEY_IS_ON")))) {
      ((MediaModel)this.mediaModels.get(paramInt)).getMediaEffectModel().putParam("FRAME_PARAMS_KEY_IS_ON", "0");
    }
    updateTemplateRenderChain(paramInt, true);
  }
  
  private void refreshStickerContainerSize(ViewGroup paramViewGroup, int paramInt)
  {
    if (this.stickerControllers.get(paramInt) != null) {
      ((StickerController)this.stickerControllers.get(paramInt)).checkContainerSize(paramViewGroup);
    }
  }
  
  private void releaseWork(int paramInt, boolean paramBoolean)
  {
    if (this.renderChainManagers.get(paramInt) != null)
    {
      if (paramBoolean) {
        ((VideoRenderChainManager)this.renderChainManagers.get(paramInt)).releaseAndKeepStickerContext();
      } else {
        ((VideoRenderChainManager)this.renderChainManagers.get(paramInt)).release();
      }
      this.renderChainManagers.remove(paramInt);
    }
    if (this.imageRenderers.get(paramInt) != null) {
      ((WSImageRender)this.imageRenderers.get(paramInt)).release();
    }
    this.tavCompositions.remove(paramInt);
  }
  
  private void saveBitmapToCache(int paramInt, Bitmap paramBitmap, List<PointF> paramList)
  {
    if (BitmapUtil.isValidBitmap(paramBitmap))
    {
      this.cacheBitmap.put(paramInt, paramBitmap.copy(Bitmap.Config.ARGB_4444, true));
      this.cachePointFList.put(paramInt, paramList);
    }
  }
  
  private void setStickerVisible(int paramInt)
  {
    runOnMainThread(new TAVCutImageSession.29(this, paramInt));
  }
  
  private void updateTemplateRenderChain(int paramInt, boolean paramBoolean)
  {
    releaseWork(paramInt, true);
    VideoRenderChainConfigure localVideoRenderChainConfigure = getRenderChainConfig(paramInt);
    if (localVideoRenderChainConfigure == null) {
      return;
    }
    if (!paramBoolean) {
      return;
    }
    Object localObject2 = (StickerController)this.stickerControllers.get(paramInt);
    Object localObject1 = localObject2;
    if (localObject2 == null)
    {
      localObject1 = createStickerController();
      this.stickerControllers.put(paramInt, localObject1);
    }
    localObject2 = (MediaModel)this.mediaModels.get(paramInt);
    CGSize localCGSize = calculateRenderSize((MediaModel)localObject2, (String)this.imagePaths.get(paramInt));
    localVideoRenderChainConfigure.setRenderSize(localCGSize);
    localVideoRenderChainConfigure.setScreenSize(this.screenSize);
    int i;
    if (ModelExtKt.isAutoTemplate((MediaModel)localObject2)) {
      i = 2;
    } else {
      i = 0;
    }
    localVideoRenderChainConfigure.setSceneType(i);
    localVideoRenderChainConfigure.setImageMode(true);
    if (!this.addingMultiStickers) {
      localVideoRenderChainConfigure.setApplyType(101);
    } else {
      localVideoRenderChainConfigure.setApplyType(100);
    }
    this.addingMultiStickers = false;
    MediaBuilderFactory.mediaBuilderSync((MediaModel)localObject2, this.context, (VideoRenderChainManager.IStickerContextInterface)localObject1, localVideoRenderChainConfigure, new TAVCutImageSession.21(this, paramInt, localCGSize));
    runOnMainThread(new TAVCutImageSession.22(this, paramInt), true);
  }
  
  public void activeBasePicCallback(int paramInt, boolean paramBoolean, MotionEvent paramMotionEvent)
  {
    if (this.stickerControllers.get(paramInt) != null) {
      ((StickerController)this.stickerControllers.get(paramInt)).setNeedOperate(paramBoolean ^ true, paramMotionEvent);
    }
    if (this.renderChainManagers.get(paramInt) != null) {
      ((VideoRenderChainManager)this.renderChainManagers.get(paramInt)).setBasePicActive(paramBoolean);
    }
  }
  
  public void addFrame(int paramInt, String paramString)
  {
    addFrame(paramInt, paramString, null);
  }
  
  public void addFrame(int paramInt, String paramString1, String paramString2)
  {
    runTask(new TAVCutImageSession.17(this, paramInt, paramString2, paramString1));
  }
  
  public void addFrameEmpty(int paramInt)
  {
    addFrame(paramInt, TAVCut.getPlaceHolderTemplatePath());
  }
  
  public void addSticker(int paramInt, @NonNull StickerModel paramStickerModel)
  {
    addSticker(paramInt, paramStickerModel, true);
  }
  
  public void addSticker(int paramInt, @NonNull StickerModel paramStickerModel, boolean paramBoolean)
  {
    StickerController localStickerController2 = (StickerController)this.stickerControllers.get(paramInt);
    StickerController localStickerController1 = localStickerController2;
    if (localStickerController2 == null)
    {
      localStickerController1 = createStickerController();
      this.stickerControllers.put(paramInt, localStickerController1);
    }
    super.addSticker(localStickerController1, paramStickerModel, paramBoolean);
    setBasePicActive(false);
  }
  
  public void applyCurrentSticker(int paramInt)
  {
    runTask(new TAVCutImageSession.24(this, paramInt));
  }
  
  public void applyPreSeg(int paramInt, String paramString)
  {
    runTask(new TAVCutImageSession.37(this, paramInt, paramString));
  }
  
  public void clearAEKitModel(int paramInt)
  {
    runTask(new TAVCutImageSession.11(this, paramInt));
  }
  
  public void clearAll(int paramInt)
  {
    ((MediaModel)this.mediaModels.get(paramInt)).getMediaEffectModel().getStickerModelList().clear();
    ((StickerController)this.stickerControllers.get(paramInt)).removeAllStickers();
    MediaModel localMediaModel = (MediaModel)this.mediaModels.get(paramInt);
    localMediaModel.getMediaEffectModel().putParam("FRAME_PARAMS_KEY_IS_ON", "0");
    localMediaModel.getMediaEffectModel().putParam("FRAME_PARAMS_KEY_COLOR", null);
    localMediaModel.getMediaEffectModel().getGestureModel().reset();
    WSTemplateManager.clearMediaTemplateModel(localMediaModel);
    updateTemplateRenderChain(paramInt, true);
    clearAEKitModel((MediaModel)this.mediaModels.get(paramInt), (VideoRenderChainManager)this.renderChainManagers.get(paramInt));
  }
  
  public void clearAllWithoutUpdate(int paramInt)
  {
    ((MediaModel)this.mediaModels.get(paramInt)).getMediaEffectModel().getStickerModelList().clear();
    if (this.stickerControllers.get(paramInt) != null) {
      ((StickerController)this.stickerControllers.get(paramInt)).removeAllStickers();
    }
    MediaModel localMediaModel = (MediaModel)this.mediaModels.get(paramInt);
    localMediaModel.getMediaEffectModel().putParam("FRAME_PARAMS_KEY_IS_ON", "0");
    localMediaModel.getMediaEffectModel().putParam("FRAME_PARAMS_KEY_COLOR", null);
    localMediaModel.getMediaEffectModel().getGestureModel().reset();
    localMediaModel.getMediaEffectModel().setPreSegModel(null);
    WSTemplateManager.clearMediaTemplateModel(localMediaModel);
    ((MediaModel)this.mediaModels.get(paramInt)).getMediaEffectModel().setAeKitModel(null);
  }
  
  protected StickerController createStickerController()
  {
    Context localContext = this.context;
    if (this.sessionConfig != null) {
      localObject = this.sessionConfig.getStickerEditViewIconConfig();
    } else {
      localObject = null;
    }
    Object localObject = new PicStickerController(localContext, (StickerEditViewIconConfig)localObject);
    ((StickerController)localObject).setStickerOperationCallback(this);
    ((StickerController)localObject).setStickerStateCallback(this);
    ((StickerController)localObject).setStickerLyricCallback(this);
    ((StickerController)localObject).setInterceptTouchDelegate(new TAVCutImageSession.34(this));
    return localObject;
  }
  
  public AEFilterManager getAeFilterManager()
  {
    return this.aeFilterManager;
  }
  
  public EGLContext getEglContext()
  {
    return this.eglContext;
  }
  
  public ImageExporter getExporter(ImageExportConfig paramImageExportConfig)
  {
    ImageExporter localImageExporter = new ImageExporter();
    localImageExporter.setContext(this.context);
    localImageExporter.setImageExportConfig(paramImageExportConfig);
    localImageExporter.setMediaModels(this.mediaModels);
    localImageExporter.setMediaModelsMd5(this.mediaModelsMD5);
    return localImageExporter;
  }
  
  public AssetImageGenerator.ImageGeneratorThread getImageProcessThread()
  {
    return this.imageProcessThread;
  }
  
  public SparseArray<WSImageRender> getImageRenderers()
  {
    return this.imageRenderers;
  }
  
  public List<MediaModel> getMediaModels()
  {
    return this.mediaModels;
  }
  
  public RenderContext getRenderContext()
  {
    return this.renderContext;
  }
  
  public int init(Context paramContext)
  {
    this.runAsync = true;
    super.init(paramContext);
    initMediaModel();
    return 0;
  }
  
  public void initSingleLightNode()
  {
    initGLContext();
    this.imageProcessThread = new AssetImageGenerator.ImageGeneratorThread("image_generator");
    this.imageProcessThread.start();
    this.imageProcessThread.initHandler();
    this.imageProcessThread.getHandler().post(new TAVCutImageSession.1(this));
  }
  
  public void loadFromCache(int paramInt)
  {
    runTask(new TAVCutImageSession.35(this, paramInt));
  }
  
  public void onDeleteButtonClick(String paramString)
  {
    super.onDeleteButtonClick(paramString);
  }
  
  public void onStickerActive()
  {
    setBasePicActive(false);
    Object localObject = (ArrayList)this.bulkStickers.get(this.currentIndex);
    StickerController localStickerController = (StickerController)this.stickerControllers.get(this.currentIndex);
    if (localStickerController != null)
    {
      if (localObject != null)
      {
        Iterator localIterator = ((ArrayList)localObject).iterator();
        while (localIterator.hasNext())
        {
          TAVSticker localTAVSticker = (TAVSticker)localIterator.next();
          if (localTAVSticker.getStickerId().equals(localStickerController.getCurrentSticker().getStickerId()))
          {
            ((ArrayList)localObject).remove(localTAVSticker);
            render(this.currentIndex);
            return;
          }
        }
      }
      if (localStickerController.getCurrentSticker() != null)
      {
        localObject = TAVStickerExKt.getExtraStickerType(localStickerController.getCurrentSticker());
        if ((localObject != null) && (((String)localObject).equals("blur"))) {
          render(this.currentIndex);
        }
      }
    }
  }
  
  public void onStickerResign(TAVSticker paramTAVSticker)
  {
    super.onStickerResign(paramTAVSticker);
    if (WsStickerContext.isBlurSticker(paramTAVSticker)) {
      render(this.currentIndex);
    }
  }
  
  public void postRotation(int paramInt, float paramFloat1, float paramFloat2, float paramFloat3)
  {
    runTask(new TAVCutImageSession.33(this, paramInt, paramFloat3, paramFloat1, paramFloat2));
  }
  
  public void postScale(int paramInt, float paramFloat1, float paramFloat2, float paramFloat3)
  {
    runTask(new TAVCutImageSession.32(this, paramInt, paramFloat3, paramFloat1, paramFloat2));
  }
  
  public void postTranslate(int paramInt, float paramFloat1, float paramFloat2)
  {
    runTask(new TAVCutImageSession.31(this, paramInt, paramFloat1, paramFloat2));
  }
  
  public void release()
  {
    runTask(new TAVCutImageSession.30(this));
    super.release();
  }
  
  public void releaseTAVCutImageView(int paramInt)
  {
    runTask(new TAVCutImageSession.4(this, paramInt));
  }
  
  public void releaseTAVCutWithoutView(int paramInt)
  {
    runTask(new TAVCutImageSession.5(this, paramInt));
  }
  
  public void removeAllStickers(int paramInt)
  {
    runTask(new TAVCutImageSession.25(this, paramInt));
  }
  
  public void removeAllViews()
  {
    ((StickerController)this.stickerControllers.get(this.currentIndex)).getStickerContext().removeAllViews();
  }
  
  public void removeFrame(int paramInt)
  {
    runTask(new TAVCutImageSession.18(this, paramInt));
  }
  
  public void render(int paramInt)
  {
    VideoRenderChainManager localVideoRenderChainManager = (VideoRenderChainManager)this.renderChainManagers.get(this.currentIndex);
    ArrayList localArrayList = (ArrayList)this.bulkStickers.get(this.currentIndex);
    if ((localVideoRenderChainManager != null) && (localArrayList != null) && (!localArrayList.isEmpty())) {
      localVideoRenderChainManager.setNeedRenderOverlayStickerMergedEffectNode(true);
    }
    render(paramInt, null);
  }
  
  public void render(int paramInt, OnRenderFinishListener paramOnRenderFinishListener)
  {
    runTask(new TAVCutImageSession.27(this, paramInt, paramOnRenderFinishListener));
  }
  
  public void resetAEKitModel(int paramInt, float paramFloat1, String paramString1, float paramFloat2, Map<String, String> paramMap, String paramString2)
  {
    runTask(new TAVCutImageSession.9(this, paramInt, paramFloat1, paramString1, paramFloat2, paramMap, paramString2));
  }
  
  public void resetAEKitModel(int paramInt, @Nullable String paramString, float paramFloat)
  {
    runTask(new TAVCutImageSession.10(this, paramInt, paramString, paramFloat));
  }
  
  public void resetAEKitModelForAI(int paramInt1, @Nullable String paramString, float paramFloat1, HashMap<String, String> paramHashMap, int paramInt2, float paramFloat2)
  {
    runTask(new TAVCutImageSession.12(this, paramInt1, paramString, paramFloat1, paramHashMap, paramInt2, paramFloat2));
  }
  
  public void resetAEKitNodeForAIWithoutRender(int paramInt1, @Nullable String paramString, float paramFloat1, HashMap<String, String> paramHashMap, int paramInt2, float paramFloat2)
  {
    runTask(new TAVCutImageSession.13(this, paramInt1, paramString, paramFloat1, paramHashMap, paramInt2, paramFloat2));
  }
  
  public void resetAllAeKitModelWithOutRender(float paramFloat1, String paramString1, float paramFloat2, Map<String, String> paramMap, String paramString2)
  {
    runTask(new TAVCutImageSession.8(this, paramFloat1, paramString1, paramFloat2, paramMap, paramString2));
  }
  
  public void resizeUI(int paramInt)
  {
    runOnMainThread(new TAVCutImageSession.28(this, paramInt));
  }
  
  public void setAddingMultiStickers(int paramInt, boolean paramBoolean)
  {
    this.addingMultiStickers = true;
    StickerController localStickerController = (StickerController)this.stickerControllers.get(paramInt);
    if ((localStickerController instanceof PicStickerController)) {
      ((PicStickerController)localStickerController).a(paramBoolean);
    }
  }
  
  public void setBasePicActive(boolean paramBoolean)
  {
    ((TAVCutImageView)((WeakReference)this.tavCutImageViews.get(this.currentIndex)).get()).setBasePicActive(paramBoolean);
    activeBasePicCallback(this.currentIndex, paramBoolean, null);
  }
  
  public void setCachePicDelegate(PreSegNode.PicSaveDelegate paramPicSaveDelegate)
  {
    this.cachePicDelegate = paramPicSaveDelegate;
  }
  
  public void setCrop(int paramInt, CropConfig paramCropConfig)
  {
    runTask(new TAVCutImageSession.23(this, paramInt, paramCropConfig));
  }
  
  public void setEffectStrength(int paramInt, float paramFloat)
  {
    runTask(new TAVCutImageSession.14(this, paramInt, paramFloat));
  }
  
  public void setImageContainerSize(CGSize paramCGSize)
  {
    this.screenSize = paramCGSize;
  }
  
  public void setImagePaths(List<String> paramList)
  {
    runTask(new TAVCutImageSession.6(this, paramList));
  }
  
  @Deprecated
  public void setMaterial(int paramInt, @Nullable String paramString)
  {
    runTask(new TAVCutImageSession.16(this, paramInt, paramString));
  }
  
  public void setMediaModels(List<MediaModel> paramList)
  {
    this.mediaModels = paramList;
  }
  
  public void setOverlayImage(int paramInt, @Nullable String paramString)
  {
    runTask(new TAVCutImageSession.15(this, paramInt, paramString));
  }
  
  public void setPreSeg(int paramInt, String paramString)
  {
    runTask(new TAVCutImageSession.36(this, paramInt, paramString));
  }
  
  public void setTAVCutImageView(int paramInt, TAVCutImageView paramTAVCutImageView)
  {
    runTask(new TAVCutImageSession.3(this, paramInt, paramTAVCutImageView));
  }
  
  public void toggleAEKit(int paramInt, boolean paramBoolean)
  {
    runTask(new TAVCutImageSession.7(this, paramInt, paramBoolean));
  }
  
  public void updateAndRenderTemplate(int paramInt)
  {
    updateAndRenderTemplate(paramInt, false, null);
  }
  
  public void updateAndRenderTemplate(int paramInt, boolean paramBoolean, OnRenderFinishListener paramOnRenderFinishListener)
  {
    if (!paramBoolean) {
      setAddingMultiStickers(paramInt, true);
    }
    updateTemplateRenderChain(paramInt, true);
    if (!paramBoolean) {
      setAddingMultiStickers(paramInt, true);
    }
    VideoRenderChainManager localVideoRenderChainManager = (VideoRenderChainManager)this.renderChainManagers.get(paramInt);
    if (localVideoRenderChainManager != null) {
      localVideoRenderChainManager.setNeedRenderOverlayStickerMergedEffectNode(true);
    }
    runTask(new TAVCutImageSession.26(this, paramInt, paramOnRenderFinishListener));
  }
  
  public void updateEmptyFrame(int paramInt)
  {
    updateTemplateFrame(paramInt, TAVCut.getPlaceHolderTemplatePath());
  }
  
  public void updateFrameColor(int paramInt1, int paramInt2)
  {
    runTask(new TAVCutImageSession.19(this, paramInt1, paramInt2));
  }
  
  public void updateFrameFillMode(int paramInt1, int paramInt2)
  {
    runTask(new TAVCutImageSession.20(this, paramInt1, paramInt2));
  }
  
  public void updateTemplateAEKitModel(int paramInt, float paramFloat1, String paramString1, float paramFloat2, Map<String, String> paramMap, String paramString2)
  {
    AEKitModel localAEKitModel = new AEKitModel(1);
    localAEKitModel.setEffectStrength(paramFloat1);
    localAEKitModel.setLutPath(paramString1);
    localAEKitModel.setGlowAlpha(paramFloat2);
    localAEKitModel.setAdjustParams(paramMap);
    localAEKitModel.setMaterial(paramString2);
    ((MediaModel)this.mediaModels.get(paramInt)).getMediaEffectModel().setAeKitModel(localAEKitModel);
  }
  
  public void updateTemplateCrop(int paramInt, CropConfig paramCropConfig)
  {
    setCrop((MediaModel)this.mediaModels.get(paramInt), (VideoRenderChainManager)this.renderChainManagers.get(paramInt), paramCropConfig);
    ((MediaModel)this.mediaModels.get(paramInt)).getMediaEffectModel().getGestureModel().reset();
  }
  
  public void updateTemplateFrame(int paramInt, String paramString)
  {
    updateTemplateFrame(paramInt, paramString, null);
  }
  
  public void updateTemplateFrame(int paramInt, String paramString1, String paramString2)
  {
    MediaModel localMediaModel = (MediaModel)this.mediaModels.get(paramInt);
    localMediaModel.getMediaEffectModel().putParam("FRAME_PARAMS_KEY_IS_ON", "1");
    localMediaModel.getMediaEffectModel().putParam("FRAME_PARAMS_KEY_COLOR", paramString2);
    localMediaModel.getMediaEffectModel().getGestureModel().reset();
    WSTemplateManager.updateTemplate(localMediaModel, 2, paramString1, true, new String[] { "ae_editor_board_template.json" });
    setBasePicActive(false);
  }
  
  public void updateTextSticker(TextEditorData paramTextEditorData)
  {
    super.updateTextSticker(paramTextEditorData);
    render(this.currentIndex);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.tavcut.session.TAVCutImageSession
 * JD-Core Version:    0.7.0.1
 */