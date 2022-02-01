package com.tencent.tavcut.session;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.util.SparseArray;
import com.tencent.tav.coremedia.CGSize;
import com.tencent.tavcut.bean.CropConfig;
import com.tencent.tavcut.bean.TextEditorData;
import com.tencent.tavcut.exporter.ImageExportConfig;
import com.tencent.tavcut.exporter.ImageExporter;
import com.tencent.tavcut.util.BitmapUtil;
import com.tencent.tavcut.view.TAVCutImageView;
import com.tencent.tavsticker.model.TAVSticker;
import com.tencent.weseevideo.composition.VideoRenderChainConfigure;
import com.tencent.weseevideo.composition.VideoRenderChainManager;
import com.tencent.weseevideo.composition.VideoRenderChainManager.IStickerContextInterface;
import com.tencent.weseevideo.composition.builder.MediaBuilderFactory;
import com.tencent.weseevideo.composition.image.WSImageRender;
import com.tencent.weseevideo.editor.sticker.StickerController;
import com.tencent.weseevideo.model.MediaModel;
import com.tencent.weseevideo.model.WSTemplateManager;
import com.tencent.weseevideo.model.effect.CropModel;
import com.tencent.weseevideo.model.effect.MediaEffectModel;
import com.tencent.weseevideo.model.effect.StickerModel;
import com.tencent.weseevideo.model.resource.MediaClipModel;
import com.tencent.weseevideo.model.resource.MediaResourceModel;
import com.tencent.weseevideo.model.resource.VideoResourceModel;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TAVCutImageSession
  extends TAVCutSession
{
  private static final String TAG = TAVCutImageSession.class.getSimpleName();
  private SparseArray<VideoRenderChainConfigure> chainConfigs = new SparseArray();
  private List<String> imagePaths;
  private SparseArray<WSImageRender> imageRenderers = new SparseArray();
  private SparseArray<WeakReference<TAVCutImageView>> tavCutImageViews = new SparseArray();
  
  private CGSize calculateRenderSize(MediaModel paramMediaModel, String paramString)
  {
    MediaEffectModel localMediaEffectModel = paramMediaModel.getMediaEffectModel();
    int k = ((MediaClipModel)paramMediaModel.getMediaResourceModel().getVideos().get(0)).getResource().getWidth();
    int m = ((MediaClipModel)paramMediaModel.getMediaResourceModel().getVideos().get(0)).getResource().getHeight();
    int i;
    if ("1".equals(localMediaEffectModel.getParam("FRAME_PARAMS_KEY_IS_ON")))
    {
      i = Math.max(k, m);
      return constrainRenderSize(i, i);
    }
    int n = BitmapUtil.getImageRotation(paramString);
    int j;
    if (n != 90)
    {
      i = m;
      j = k;
      if (n != 270) {}
    }
    else
    {
      j = m;
      i = k;
    }
    paramMediaModel = paramMediaModel.getMediaEffectModel().getCropModel();
    m = i;
    k = j;
    if (paramMediaModel != null)
    {
      m = i;
      k = j;
      if (paramMediaModel.getCropConfig() != null)
      {
        k = (int)(j * paramMediaModel.getCropConfig().getWidth());
        m = (int)(i * paramMediaModel.getCropConfig().getHeight());
      }
    }
    return constrainRenderSize(k, m);
  }
  
  private void initMediaModel()
  {
    runTask(new TAVCutImageSession.1(this));
  }
  
  private void initRenderEnvironment(int paramInt)
  {
    Object localObject2 = (StickerController)this.stickerControllers.get(paramInt);
    Object localObject1 = localObject2;
    if (localObject2 == null)
    {
      localObject1 = createStickerController();
      this.stickerControllers.put(paramInt, localObject1);
    }
    localObject2 = (VideoRenderChainConfigure)this.chainConfigs.get(paramInt);
    if (localObject2 == null)
    {
      localObject2 = new VideoRenderChainConfigure(true);
      this.chainConfigs.put(paramInt, localObject2);
    }
    for (;;)
    {
      MediaModel localMediaModel = (MediaModel)this.mediaModels.get(paramInt);
      CGSize localCGSize = calculateRenderSize(localMediaModel, (String)this.imagePaths.get(paramInt));
      ((VideoRenderChainConfigure)localObject2).setRenderSize(localCGSize);
      MediaBuilderFactory.mediaBuilderAsync(localMediaModel, this.context, (VideoRenderChainManager.IStickerContextInterface)localObject1, (VideoRenderChainConfigure)localObject2, new TAVCutImageSession.3(this, paramInt, localCGSize));
      runOnMainThread(new TAVCutImageSession.4(this, paramInt, (StickerController)localObject1), true);
      return;
    }
  }
  
  private void releaseWork(int paramInt)
  {
    if (this.renderChainManagers.get(paramInt) != null)
    {
      ((VideoRenderChainManager)this.renderChainManagers.get(paramInt)).release();
      this.renderChainManagers.remove(paramInt);
    }
    if (this.imageRenderers.get(paramInt) != null) {
      ((WSImageRender)this.imageRenderers.get(paramInt)).release();
    }
    this.tavCompositions.remove(paramInt);
  }
  
  private void updateTemplateRenderChain(int paramInt1, int paramInt2, boolean paramBoolean)
  {
    releaseWork(paramInt1);
    VideoRenderChainConfigure localVideoRenderChainConfigure2 = (VideoRenderChainConfigure)this.chainConfigs.get(paramInt1);
    VideoRenderChainConfigure localVideoRenderChainConfigure1 = localVideoRenderChainConfigure2;
    if (localVideoRenderChainConfigure2 == null)
    {
      localVideoRenderChainConfigure1 = new VideoRenderChainConfigure(true);
      this.chainConfigs.put(paramInt1, localVideoRenderChainConfigure1);
    }
    if (paramBoolean)
    {
      localVideoRenderChainConfigure1.setSceneType(paramInt2);
      return;
    }
    localVideoRenderChainConfigure1.setSceneType(0);
  }
  
  public void addFrame(int paramInt, String paramString1, String paramString2)
  {
    runTask(new TAVCutImageSession.17(this, paramInt, paramString2, paramString1));
  }
  
  public void addSticker(int paramInt, @NonNull StickerModel paramStickerModel)
  {
    runTask(new TAVCutImageSession.20(this, paramInt, paramStickerModel));
  }
  
  public void applyCurrentSticker(int paramInt)
  {
    runTask(new TAVCutImageSession.21(this, paramInt));
  }
  
  public void clearAEKitModel(int paramInt)
  {
    runTask(new TAVCutImageSession.11(this, paramInt));
  }
  
  public ImageExporter getExporter(ImageExportConfig paramImageExportConfig)
  {
    ImageExporter localImageExporter = new ImageExporter();
    localImageExporter.setContext(this.context);
    localImageExporter.setImageExportConfig(paramImageExportConfig);
    localImageExporter.setMediaModels(this.mediaModels);
    return localImageExporter;
  }
  
  public SparseArray<WSImageRender> getImageRenderers()
  {
    return this.imageRenderers;
  }
  
  public List<MediaModel> getMediaModels()
  {
    return this.mediaModels;
  }
  
  public int init(Context paramContext)
  {
    this.runAsync = true;
    super.init(paramContext);
    initMediaModel();
    return 0;
  }
  
  public void onDeleteButtonClick(String paramString)
  {
    super.onDeleteButtonClick(paramString);
    render(this.currentIndex);
  }
  
  public void onStickerActive()
  {
    render(this.currentIndex);
  }
  
  public void onStickerResign(TAVSticker paramTAVSticker)
  {
    super.onStickerResign(paramTAVSticker);
    render(this.currentIndex);
  }
  
  public void release()
  {
    runTask(new TAVCutImageSession.23(this));
    super.release();
  }
  
  public void releaseTAVCutImageView(int paramInt)
  {
    runTask(new TAVCutImageSession.5(this, paramInt));
  }
  
  public void removeFrame(int paramInt)
  {
    runTask(new TAVCutImageSession.18(this, paramInt));
  }
  
  public void render(int paramInt)
  {
    runTask(new TAVCutImageSession.22(this, paramInt));
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
  
  public void setCrop(int paramInt, CropConfig paramCropConfig)
  {
    runTask(new TAVCutImageSession.19(this, paramInt, paramCropConfig));
  }
  
  public void setEffectStrength(int paramInt, float paramFloat)
  {
    runTask(new TAVCutImageSession.14(this, paramInt, paramFloat));
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
  
  public void setTAVCutImageView(int paramInt, TAVCutImageView paramTAVCutImageView)
  {
    runTask(new TAVCutImageSession.2(this, paramInt, paramTAVCutImageView));
  }
  
  public void setTemplate(int paramInt1, int paramInt2, String paramString, boolean paramBoolean, String... paramVarArgs)
  {
    WSTemplateManager.updateTemplate((MediaModel)this.mediaModels.get(paramInt1), paramInt2, paramString, paramBoolean, paramVarArgs);
    if (!TextUtils.isEmpty(paramString)) {}
    for (paramBoolean = true;; paramBoolean = false)
    {
      updateTemplateRenderChain(paramInt1, paramInt2, paramBoolean);
      render(paramInt1);
      return;
    }
  }
  
  public void toggleAEKit(int paramInt, boolean paramBoolean)
  {
    runTask(new TAVCutImageSession.7(this, paramInt, paramBoolean));
  }
  
  public void updateTextSticker(TextEditorData paramTextEditorData)
  {
    super.updateTextSticker(paramTextEditorData);
    render(this.currentIndex);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.tavcut.session.TAVCutImageSession
 * JD-Core Version:    0.7.0.1
 */