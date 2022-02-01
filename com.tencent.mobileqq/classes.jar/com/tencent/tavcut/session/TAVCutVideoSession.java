package com.tencent.tavcut.session;

import android.content.Context;
import android.graphics.Bitmap;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.util.Log;
import android.util.SparseArray;
import android.view.TextureView;
import android.view.ViewGroup;
import com.tencent.tav.core.AssetImageGenerator;
import com.tencent.tav.core.AssetImageGenerator.ApertureMode;
import com.tencent.tav.coremedia.CGSize;
import com.tencent.tav.coremedia.CMTime;
import com.tencent.tav.coremedia.CMTimeRange;
import com.tencent.tav.coremedia.TimeUtil;
import com.tencent.tav.decoder.DecoderUtils;
import com.tencent.tavcut.bean.CropConfig;
import com.tencent.tavcut.bean.ResInfoModel;
import com.tencent.tavcut.bean.Size;
import com.tencent.tavcut.cover.VideoImageExtractor;
import com.tencent.tavcut.exporter.VideoExportConfig;
import com.tencent.tavcut.exporter.VideoExporter;
import com.tencent.tavcut.player.MoviePlayer;
import com.tencent.tavcut.player.MoviePlayer.onVideoProgressListener;
import com.tencent.tavcut.session.callback.FrameExtractCallback;
import com.tencent.tavcut.session.config.SessionConfig;
import com.tencent.tavcut.util.BitmapUtil;
import com.tencent.tavcut.util.DurationUtil;
import com.tencent.tavcut.util.Logger;
import com.tencent.tavcut.util.VideoUtil;
import com.tencent.tavcut.view.TAVCutVideoView;
import com.tencent.tavkit.component.TAVSourceImageGenerator;
import com.tencent.tavkit.composition.TAVClip;
import com.tencent.tavkit.composition.TAVComposition;
import com.tencent.tavkit.composition.TAVSource;
import com.tencent.tavkit.composition.builder.TAVCompositionBuilder;
import com.tencent.tavkit.composition.model.TAVAudio;
import com.tencent.tavkit.composition.model.TAVAudioConfiguration;
import com.tencent.tavkit.composition.model.TAVTransitionableAudio;
import com.tencent.tavkit.composition.model.TAVVideoConfiguration;
import com.tencent.tavkit.composition.model.TAVVideoConfiguration.TAVVideoConfigurationContentMode;
import com.tencent.tavsticker.core.TAVStickerContext;
import com.tencent.tavsticker.core.TAVStickerEditView;
import com.tencent.tavsticker.model.TAVSticker;
import com.tencent.tavsticker.utils.CollectionUtil;
import com.tencent.ttpic.baseutils.collection.CollectionUtils;
import com.tencent.weseevideo.composition.VideoRenderChainConfigure;
import com.tencent.weseevideo.composition.VideoRenderChainManager;
import com.tencent.weseevideo.composition.VideoRenderChainManager.IStickerContextInterface;
import com.tencent.weseevideo.composition.builder.MediaBuilderFactory;
import com.tencent.weseevideo.composition.effectnode.CropEffectNode;
import com.tencent.weseevideo.editor.sticker.StickerController;
import com.tencent.weseevideo.editor.sticker.utils.StickerConverter;
import com.tencent.weseevideo.model.MediaModel;
import com.tencent.weseevideo.model.WSTemplateManager;
import com.tencent.weseevideo.model.data.MusicData;
import com.tencent.weseevideo.model.data.MusicMaterialMetaDataBean;
import com.tencent.weseevideo.model.effect.CropModel;
import com.tencent.weseevideo.model.effect.MediaEffectModel;
import com.tencent.weseevideo.model.effect.MusicModel;
import com.tencent.weseevideo.model.effect.StickerModel;
import com.tencent.weseevideo.model.effect.SubtitleModel;
import com.tencent.weseevideo.model.resource.MediaClipModel;
import com.tencent.weseevideo.model.resource.MediaResourceModel;
import com.tencent.weseevideo.model.resource.VideoConfigurationModel;
import com.tencent.weseevideo.model.resource.VideoResourceModel;
import com.tencent.weseevideo.model.template.MediaTemplateModel;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class TAVCutVideoSession
  extends TAVCutSession
  implements MoviePlayer.onVideoProgressListener
{
  private List<MoviePlayer> players = new ArrayList();
  private boolean preIsPlaying = false;
  protected TAVCutVideoView tavCutVideoView;
  private VideoImageExtractor videoImageExtractor = null;
  private String videoPath;
  
  private void addBaseMediaModel()
  {
    MediaModel localMediaModel = new MediaModel();
    ArrayList localArrayList = new ArrayList();
    Object localObject1 = new MediaClipModel();
    Object localObject2 = new VideoResourceModel();
    ((VideoResourceModel)localObject2).setPath(this.videoPath);
    ((VideoResourceModel)localObject2).setType(1);
    ((VideoResourceModel)localObject2).setSourceTimeDuration(DecoderUtils.getDuration(this.videoPath) / 1000L);
    if ((this.sessionConfig != null) && (this.sessionConfig.getVideoInitCropConfig() != null))
    {
      localObject3 = this.sessionConfig.getVideoInitCropConfig();
      CropModel localCropModel = new CropModel();
      localCropModel.setCropConfig((CropConfig)localObject3);
      localMediaModel.getMediaEffectModel().setCropModel(localCropModel);
    }
    Object localObject3 = VideoUtil.getVideoSize(this.videoPath);
    ((VideoResourceModel)localObject2).setWidth(((Size)localObject3).getWidth());
    ((VideoResourceModel)localObject2).setHeight(((Size)localObject3).getHeight());
    ((VideoResourceModel)localObject2).setRotate(0);
    ((MediaClipModel)localObject1).setResource((VideoResourceModel)localObject2);
    localObject2 = new VideoConfigurationModel();
    ((VideoConfigurationModel)localObject2).setRotate(0);
    if ((this.sessionConfig != null) && (this.sessionConfig.getContentMode() != null)) {
      ((VideoConfigurationModel)localObject2).setContentMode(this.sessionConfig.getContentMode().ordinal());
    }
    ((MediaClipModel)localObject1).setVideoConfigurationModel((VideoConfigurationModel)localObject2);
    localArrayList.add(localObject1);
    localObject1 = localMediaModel.getMediaResourceModel();
    ((MediaResourceModel)localObject1).setVideos(localArrayList);
    localMediaModel.setMediaResourceModel((MediaResourceModel)localObject1);
    this.mediaModels.add(localMediaModel);
  }
  
  private CropConfig findMultiCutCropByIndex(int paramInt)
  {
    MediaModel localMediaModel = getMediaModel();
    if ((localMediaModel != null) && (paramInt < localMediaModel.getMediaResourceModel().getVideos().size())) {
      return ((MediaClipModel)localMediaModel.getMediaResourceModel().getVideos().get(paramInt)).getConfig();
    }
    return new CropConfig(0.0F, 0.0F, 1.0F, 1.0F);
  }
  
  private CGSize getCroppedMultiCutRenderSize(@NonNull List<MediaClipModel> paramList)
  {
    Size localSize = getCroppedSizeByIndex(paramList, 0);
    paramList = getMultiMaxWidthHeight(paramList, localSize.getWidth(), localSize.getHeight());
    return constrainRenderSize(paramList.getWidth(), paramList.getHeight());
  }
  
  private Size getCroppedSizeByIndex(List<MediaClipModel> paramList, int paramInt)
  {
    if (paramList.size() <= paramInt) {
      return new Size(720, 1080);
    }
    CropConfig localCropConfig = findMultiCutCropByIndex(paramInt);
    int i = ((MediaClipModel)paramList.get(paramInt)).getResource().getWidth();
    paramInt = ((MediaClipModel)paramList.get(paramInt)).getResource().getHeight();
    if (localCropConfig == null) {
      return new Size(i, paramInt);
    }
    i = Math.round(i * localCropConfig.getWidth());
    float f = paramInt;
    return new Size(i, Math.round(localCropConfig.getHeight() * f));
  }
  
  private CGSize getMultiCutRenderSize(VideoRenderChainManager paramVideoRenderChainManager)
  {
    if ((paramVideoRenderChainManager == null) || (paramVideoRenderChainManager.getMediaModel() == null) || (paramVideoRenderChainManager.getMediaModel().getMediaResourceModel().getVideos().size() < 1)) {
      return null;
    }
    return getCroppedMultiCutRenderSize(paramVideoRenderChainManager.getMediaModel().getMediaResourceModel().getVideos());
  }
  
  private Size getMultiMaxWidthHeight(List<MediaClipModel> paramList, int paramInt1, int paramInt2)
  {
    int k = 0;
    if (paramList == null) {
      return new Size(paramInt1, paramInt2);
    }
    int i = 0;
    while (k < paramList.size())
    {
      Size localSize = getCroppedSizeByIndex(paramList, k);
      int j = i;
      if (localSize.getWidth() > i) {
        j = localSize.getWidth();
      }
      i = j;
      if (localSize.getHeight() > j) {
        i = localSize.getHeight();
      }
      k += 1;
    }
    if ((i < paramInt2) && (i < paramInt1)) {
      return new Size(paramInt1, paramInt2);
    }
    if (paramInt1 > paramInt2) {
      return new Size(i, Math.round(paramInt2 * 1.0F / paramInt1 * i));
    }
    return new Size(Math.round(paramInt1 * 1.0F / paramInt2 * i), i);
  }
  
  private VideoRenderChainManager getRenderChainManager()
  {
    if ((this.renderChainManagers != null) && (this.renderChainManagers.size() > 0)) {
      return (VideoRenderChainManager)this.renderChainManagers.get(0);
    }
    return null;
  }
  
  private TAVComposition getTAVComposition()
  {
    if ((this.tavCompositions != null) && (this.tavCompositions.size() > 0)) {
      return (TAVComposition)this.tavCompositions.get(0);
    }
    return null;
  }
  
  private boolean isAutoTemplate()
  {
    return (getMediaModel() != null) && (!getMediaModel().getMediaTemplateModel().isAutoTemplateEmpty());
  }
  
  private void mediaBuild(StickerController paramStickerController, VideoRenderChainConfigure paramVideoRenderChainConfigure, boolean paramBoolean)
  {
    MediaBuilderFactory.mediaBuilderAsync(getMediaModel(), this.context, paramStickerController, paramVideoRenderChainConfigure, new TAVCutVideoSession.11(this, paramBoolean));
  }
  
  private void refreshRenderTemplate()
  {
    initPlayer();
  }
  
  private void setVideoChangeConfigureRenderSize(VideoRenderChainConfigure paramVideoRenderChainConfigure)
  {
    Object localObject2 = null;
    Object localObject1 = localObject2;
    if (this.mediaModels != null)
    {
      localObject1 = localObject2;
      if (this.mediaModels.size() > 0) {
        localObject1 = (MediaModel)this.mediaModels.get(0);
      }
    }
    if (localObject1 == null) {
      return;
    }
    paramVideoRenderChainConfigure.setRenderSize(getCroppedMultiCutRenderSize(((MediaModel)localObject1).getMediaResourceModel().getVideos()));
  }
  
  private void updateComposition(MediaModel paramMediaModel)
  {
    MediaBuilderFactory.mediaBuilderAsync(paramMediaModel, this.context, null, new TAVCutVideoSession.15(this));
  }
  
  private void updateMultiCutCropModel(TAVComposition paramTAVComposition)
  {
    paramTAVComposition = paramTAVComposition.getVideoChannels();
    if (CollectionUtil.isEmptyList(paramTAVComposition)) {}
    for (;;)
    {
      return;
      paramTAVComposition = (List)paramTAVComposition.get(0);
      if (paramTAVComposition != null)
      {
        int i = 0;
        while (i < paramTAVComposition.size())
        {
          CropConfig localCropConfig = findMultiCutCropByIndex(i);
          TAVClip localTAVClip = (TAVClip)paramTAVComposition.get(i);
          List localList = localTAVClip.getVideoConfiguration().getEffects();
          if (localCropConfig != null)
          {
            CropEffectNode localCropEffectNode = new CropEffectNode();
            CropModel localCropModel = new CropModel();
            localCropModel.setCropConfig(localCropConfig);
            localCropEffectNode.setCropModel(localCropModel);
            localList.add(0, localCropEffectNode);
          }
          localTAVClip.getVideoConfiguration().setEffects(localList);
          i += 1;
        }
      }
    }
  }
  
  private void updatePlayer(MediaModel paramMediaModel, boolean paramBoolean)
  {
    if (getStickerController() != null) {
      getStickerController().destroy();
    }
    StickerController localStickerController = createStickerController();
    this.stickerControllers.put(0, localStickerController);
    new VideoRenderChainConfigure(true).setSceneType(0);
    MediaBuilderFactory.mediaBuilderAsync(paramMediaModel, this.context, localStickerController, new TAVCutVideoSession.14(this, paramBoolean));
    if (this.tavCutVideoView != null)
    {
      this.tavCutVideoView.getStickerContainer().removeAllViews();
      getStickerController().setStickerContainer(this.tavCutVideoView.getStickerContainer());
    }
    localStickerController.restoreSticker(new ArrayList(paramMediaModel.getMediaEffectModel().getStickerModelList()));
    if (paramMediaModel.getMediaEffectModel().getSubtitleModel() != null) {
      localStickerController.addSticker(StickerConverter.subtitleModel2TavSticker(paramMediaModel.getMediaEffectModel().getSubtitleModel()));
    }
    getRenderChainManager().updateRenderChain(paramMediaModel.getMediaEffectModel());
  }
  
  private void updateTemplateRenderChain(int paramInt, boolean paramBoolean1, boolean paramBoolean2)
  {
    if (this.renderChainManagers.size() > 0) {
      ((VideoRenderChainManager)this.renderChainManagers.get(0)).release();
    }
    StickerController localStickerController;
    VideoRenderChainConfigure localVideoRenderChainConfigure;
    if (this.stickerControllers.size() > 0)
    {
      localStickerController = (StickerController)this.stickerControllers.get(0);
      if ((localStickerController.getStickerContext() != null) && (localStickerController.getStickerContext().getCurrentStickerEditView() != null))
      {
        Log.d("sticker_size", "updateTemplateRenderChain: h=" + localStickerController.getStickerContext().getCurrentStickerEditView().getMeasuredHeight());
        Log.d("sticker_size", "updateTemplateRenderChain: w=" + localStickerController.getStickerContext().getCurrentStickerEditView().getMeasuredWidth());
      }
      localVideoRenderChainConfigure = new VideoRenderChainConfigure(true);
      setVideoChangeConfigureRenderSize(localVideoRenderChainConfigure);
      if (!paramBoolean1) {
        break label176;
      }
      localVideoRenderChainConfigure.setSceneType(paramInt);
    }
    for (;;)
    {
      mediaBuild(localStickerController, localVideoRenderChainConfigure, paramBoolean2);
      return;
      label176:
      localVideoRenderChainConfigure.setSceneType(0);
    }
  }
  
  public void addBaseMediaModel(String paramString, int paramInt, CropConfig paramCropConfig)
  {
    MediaModel localMediaModel = new MediaModel();
    MediaClipModel localMediaClipModel = new MediaClipModel();
    VideoResourceModel localVideoResourceModel = new VideoResourceModel();
    Size localSize;
    if (paramInt == 2)
    {
      localSize = BitmapUtil.getImageSize(paramString);
      localVideoResourceModel.setSelectTimeDuration(TimeUtil.second2Ms(2.0F));
      localVideoResourceModel.setSourceTimeDuration(3000L);
      localVideoResourceModel.setPath(paramString);
      localVideoResourceModel.setType(paramInt);
      localVideoResourceModel.setSelectTimeStart(0L);
      localVideoResourceModel.setScaleDuration(((float)localVideoResourceModel.getSelectTimeDuration() / 1.0F));
      localVideoResourceModel.setWidth(localSize.getWidth());
      localVideoResourceModel.setHeight(localSize.getHeight());
      localMediaClipModel.setResource(localVideoResourceModel);
      paramString = paramCropConfig;
      if (paramCropConfig == null) {
        paramString = new CropConfig(0.0F, 0.0F, 1.0F, 1.0F);
      }
      localMediaClipModel.setConfig(paramString);
      if ((this.mediaModels == null) || (this.mediaModels.size() <= 0)) {
        break label271;
      }
    }
    label271:
    for (paramString = ((MediaModel)this.mediaModels.get(0)).getMediaResourceModel().getVideos();; paramString = new ArrayList())
    {
      paramString.add(localMediaClipModel);
      paramCropConfig = localMediaModel.getMediaResourceModel();
      paramCropConfig.setVideos(paramString);
      localMediaModel.setMediaResourceModel(paramCropConfig);
      if (this.mediaModels == null) {
        this.mediaModels = new ArrayList();
      }
      this.mediaModels.add(localMediaModel);
      recordInitMediaModelsMD5();
      return;
      localSize = VideoUtil.getVideoSize(paramString);
      long l = DecoderUtils.getDuration(paramString) / 1000L;
      localVideoResourceModel.setSelectTimeDuration(l);
      localVideoResourceModel.setSourceTimeDuration(l);
      break;
    }
  }
  
  public void addPlayer(MoviePlayer paramMoviePlayer)
  {
    this.players.add(paramMoviePlayer);
  }
  
  public void addSticker(StickerModel paramStickerModel)
  {
    runTask(new TAVCutVideoSession.8(this, paramStickerModel));
  }
  
  public void applyCurrentSticker()
  {
    applyCurrentSticker(getStickerController());
  }
  
  public void clearAEKitModel()
  {
    clearAEKitModel(getMediaModel(), getRenderChainManager());
    refresh();
  }
  
  public boolean correctMediaResource(long paramLong)
  {
    if ((getMediaModel() == null) || (getMediaModel().getMediaResourceModel().getVideos().size() < 1)) {
      return false;
    }
    List localList = getMediaModel().getMediaResourceModel().getVideos();
    long l1 = 0L;
    int i = 0;
    Object localObject;
    long l2;
    if (i < localList.size())
    {
      localObject = (MediaClipModel)localList.get(i);
      if (localObject == null) {}
      do
      {
        i += 1;
        break;
        l2 = l1 + ((MediaClipModel)localObject).getResource().getScaleDuration();
        l1 = l2;
      } while (l2 < paramLong);
    }
    for (;;)
    {
      if (i == -1) {
        return false;
      }
      localObject = ((MediaClipModel)localList.get(i)).getResource();
      float f;
      if ((((VideoResourceModel)localObject).getSelectTimeDuration() == 0L) || (((VideoResourceModel)localObject).getScaleDuration() == 0L))
      {
        f = 1.0F;
        paramLong = ((VideoResourceModel)localObject).getScaleDuration() - (l2 - paramLong);
        ((MediaClipModel)localList.get(i)).getResource().setSelectTimeDuration((f * (float)paramLong), true);
        ((MediaClipModel)localList.get(i)).getResource().setScaleDuration(paramLong);
        i += 1;
        label217:
        if (i >= localList.size()) {
          break label298;
        }
        localObject = (MediaClipModel)localList.get(i);
        if (localObject != null) {
          break label276;
        }
      }
      for (;;)
      {
        i += 1;
        break label217;
        f = 1.0F * (float)((VideoResourceModel)localObject).getSelectTimeDuration() / (float)((VideoResourceModel)localObject).getScaleDuration();
        break;
        label276:
        ((MediaClipModel)localObject).getResource().setSelectTimeDuration(0L, true);
        ((MediaClipModel)localObject).getResource().setScaleDuration(0L);
      }
      label298:
      return true;
      i = -1;
      l2 = l1;
    }
  }
  
  public void deleteLyricSticker()
  {
    Object localObject = this.mediaModels.iterator();
    while (((Iterator)localObject).hasNext())
    {
      MediaModel localMediaModel = (MediaModel)((Iterator)localObject).next();
      if (localMediaModel.getMediaEffectModel().getSubtitleModel() != null)
      {
        localObject = localMediaModel.getMediaEffectModel().getSubtitleModel().getUniqueId();
        localMediaModel.getMediaEffectModel().setSubtitleModel(null);
      }
    }
    for (;;)
    {
      getStickerController().deleteLyricSticker();
      super.onDeleteButtonClick((String)localObject);
      refresh();
      return;
      localObject = "";
    }
  }
  
  public CMTime getDuration()
  {
    if (getTAVComposition() != null) {
      return getTAVComposition().getDuration();
    }
    return CMTime.CMTimeZero;
  }
  
  @Nullable
  public void getEffectVideoFrame(long paramLong, int paramInt, @NonNull FrameExtractCallback paramFrameExtractCallback)
  {
    TAVSourceImageGenerator localTAVSourceImageGenerator = new TAVSourceImageGenerator(new TAVCompositionBuilder(getTAVComposition()).buildSource(), getRenderChainManager().getComposition().getRenderSize());
    localTAVSourceImageGenerator.getAssetImageGenerator().setForceUseFbo(true);
    localTAVSourceImageGenerator.getAssetImageGenerator().setApertureMode(AssetImageGenerator.ApertureMode.aspectFill);
    localTAVSourceImageGenerator.generateThumbnailAtTime(new CMTime((float)paramLong / 1000.0F), new TAVCutVideoSession.16(this, paramInt, localTAVSourceImageGenerator, paramFrameExtractCallback));
  }
  
  public Size getExportMaxMediaSize()
  {
    List localList = getMediaModel().getMediaResourceModel().getVideos();
    Size localSize = getCroppedSizeByIndex(localList, 0);
    return getMultiMaxWidthHeight(localList, localSize.getWidth(), localSize.getHeight());
  }
  
  public VideoExporter getExporter(VideoExportConfig paramVideoExportConfig)
  {
    VideoExporter localVideoExporter = new VideoExporter();
    VideoRenderChainConfigure localVideoRenderChainConfigure = new VideoRenderChainConfigure(true);
    Object localObject = getMediaModel();
    if (localObject != null)
    {
      localObject = ((MediaModel)localObject).getMediaTemplateModel();
      if (((MediaTemplateModel)localObject).isAutoTemplateEmpty()) {
        break label78;
      }
      localVideoRenderChainConfigure.setSceneType(2);
      setVideoChangeConfigureRenderSize(localVideoRenderChainConfigure);
    }
    for (;;)
    {
      MediaBuilderFactory.mediaBuilderAsync(getMediaModel(), this.context, null, localVideoRenderChainConfigure, new TAVCutVideoSession.13(this, localVideoExporter, paramVideoExportConfig));
      return localVideoExporter;
      label78:
      if (!((MediaTemplateModel)localObject).isMovieTemplateEmpty()) {
        localVideoRenderChainConfigure.setSceneType(1);
      } else {
        localVideoRenderChainConfigure.setSceneType(0);
      }
    }
  }
  
  public MediaModel getMediaModel()
  {
    if ((this.mediaModels != null) && (!this.mediaModels.isEmpty())) {
      return (MediaModel)this.mediaModels.get(0);
    }
    return null;
  }
  
  public List<Bitmap> getMultiVideoFrame(List<Long> paramList, int paramInt)
  {
    TAVSource localTAVSource = getTAVSource();
    if ((localTAVSource == null) || (this.renderChainManagers.size() < 1))
    {
      Logger.i("Cover", "source = null");
      return new ArrayList();
    }
    CGSize localCGSize = getMultiCutRenderSize((VideoRenderChainManager)this.renderChainManagers.get(0));
    this.videoImageExtractor = new VideoImageExtractor();
    this.videoImageExtractor.initCoverProvider(paramList, localTAVSource, localCGSize, paramInt);
    return this.videoImageExtractor.extractImages();
  }
  
  protected MoviePlayer getPlayer()
  {
    if ((this.players != null) && (!this.players.isEmpty())) {
      return (MoviePlayer)this.players.get(0);
    }
    return null;
  }
  
  public CGSize getRenderSize()
  {
    return getRenderChainManager().getComposition().getRenderSize();
  }
  
  protected StickerController getStickerController()
  {
    if ((this.stickerControllers != null) && (this.stickerControllers.size() > 0)) {
      return (StickerController)this.stickerControllers.get(0);
    }
    return null;
  }
  
  public TAVSource getTAVSource()
  {
    TAVComposition localTAVComposition = (TAVComposition)this.tavCompositions.get(0);
    if (localTAVComposition == null)
    {
      Logger.i("Cover", "composition null");
      return null;
    }
    return new TAVCompositionBuilder(localTAVComposition).buildSource();
  }
  
  public TextureView getTexureView()
  {
    if ((this.players != null) && (this.players.size() > 0)) {
      return ((MoviePlayer)this.players.get(0)).getTextureView();
    }
    return null;
  }
  
  public List<Bitmap> getVideoFrame(List<Long> paramList)
  {
    return getVideoFrame(paramList, -1);
  }
  
  public List<Bitmap> getVideoFrame(List<Long> paramList, int paramInt)
  {
    TAVSource localTAVSource = getTAVSource();
    if (localTAVSource == null)
    {
      Logger.i("Cover", "source = null");
      return new ArrayList();
    }
    Object localObject = VideoUtil.getVideoSize(this.videoPath, true);
    localObject = new CGSize(((Size)localObject).getWidth(), ((Size)localObject).getHeight());
    this.videoImageExtractor = new VideoImageExtractor();
    this.videoImageExtractor.initCoverProvider(paramList, localTAVSource, (CGSize)localObject, paramInt);
    return this.videoImageExtractor.extractImages();
  }
  
  public int init(Context paramContext)
  {
    try
    {
      this.runAsync = false;
      super.init(paramContext);
      initMediaModel();
      initRenderEnvironment();
      initPlayer();
      return 0;
    }
    catch (Exception paramContext)
    {
      Logger.e(paramContext);
    }
    return -1;
  }
  
  protected void initMediaModel()
  {
    if (this.mediaModels == null)
    {
      this.mediaModels = new ArrayList();
      addBaseMediaModel();
    }
    recordInitMediaModelsMD5();
  }
  
  public void initMultiCutSession(Context paramContext, List<ResInfoModel> paramList)
  {
    try
    {
      this.runAsync = false;
      super.init(paramContext);
      if (paramList == null) {
        return;
      }
      paramContext = paramList.iterator();
      while (paramContext.hasNext())
      {
        paramList = (ResInfoModel)paramContext.next();
        if (paramList != null) {
          addBaseMediaModel(paramList.getResPath(), paramList.getType(), paramList.getCropConfig());
        }
      }
      initRenderEnvironment();
    }
    catch (Exception paramContext)
    {
      Logger.e(paramContext);
      return;
    }
    initPlayer();
  }
  
  protected void initPlayer()
  {
    if (getPlayer() != null) {
      if ((this.sessionConfig != null) && (!this.sessionConfig.isAutoPlayVideo())) {
        break label77;
      }
    }
    label77:
    for (boolean bool = true;; bool = false)
    {
      this.preIsPlaying = bool;
      CMTimeRange localCMTimeRange = new CMTimeRange(CMTime.CMTimeZero, getTAVComposition().getDuration());
      getPlayer().updateComposition(getTAVComposition(), localCMTimeRange.getStart(), this.preIsPlaying);
      getPlayer().setPlayRange(localCMTimeRange);
      return;
    }
  }
  
  protected void initRenderEnvironment()
  {
    StickerController localStickerController = createStickerController();
    this.stickerControllers.put(0, localStickerController);
    VideoRenderChainConfigure localVideoRenderChainConfigure = new VideoRenderChainConfigure(true);
    localVideoRenderChainConfigure.setSceneType(0);
    MediaBuilderFactory.mediaBuilderAsync(getMediaModel(), this.context, localStickerController, localVideoRenderChainConfigure, new TAVCutVideoSession.1(this));
    if (this.tavCutVideoView != null)
    {
      if (getPlayer() != null) {
        getPlayer().bindView(this.tavCutVideoView);
      }
      if (getStickerController() != null) {
        getStickerController().setStickerContainer(this.tavCutVideoView.getStickerContainer());
      }
    }
  }
  
  public void onDeleteButtonClick(String paramString)
  {
    super.onDeleteButtonClick(paramString);
    refresh();
  }
  
  public void onPause()
  {
    super.onPause();
    Iterator localIterator = this.players.iterator();
    while (localIterator.hasNext()) {
      ((MoviePlayer)localIterator.next()).pause();
    }
  }
  
  public void onResume()
  {
    super.onResume();
  }
  
  public void onStatusChanged(boolean paramBoolean)
  {
    MoviePlayer localMoviePlayer = getPlayer();
    if (localMoviePlayer == null) {
      return;
    }
    if (paramBoolean)
    {
      if (localMoviePlayer.isPlaying())
      {
        this.preIsPlaying = true;
        localMoviePlayer.pause();
        return;
      }
      this.preIsPlaying = false;
      localMoviePlayer.refresh();
      return;
    }
    if (this.preIsPlaying)
    {
      localMoviePlayer.play();
      return;
    }
    localMoviePlayer.refresh();
  }
  
  public void onStickerActive()
  {
    refresh();
  }
  
  public void onStickerResign(TAVSticker paramTAVSticker)
  {
    super.onStickerResign(paramTAVSticker);
    refresh();
  }
  
  protected void refresh()
  {
    if ((getPlayer() != null) && (!getPlayer().isPlaying())) {
      getPlayer().refresh();
    }
  }
  
  public void release()
  {
    DurationUtil.start("TAVCutVideoSession release");
    Iterator localIterator = this.players.iterator();
    while (localIterator.hasNext()) {
      ((MoviePlayer)localIterator.next()).release();
    }
    if (this.videoImageExtractor != null) {
      this.videoImageExtractor.release();
    }
    super.release();
    DurationUtil.end("TAVCutVideoSession release");
  }
  
  public void resetAEKitModel(float paramFloat1, String paramString1, float paramFloat2, Map<String, String> paramMap, String paramString2)
  {
    runTask(new TAVCutVideoSession.3(this, paramFloat1, paramString1, paramFloat2, paramMap, paramString2));
  }
  
  public void resetAEKitModel(String paramString, float paramFloat)
  {
    resetAEKitModel(getMediaModel(), getRenderChainManager(), paramString, paramFloat);
    refresh();
  }
  
  public void resetAEKitModelForAI(String paramString, float paramFloat1, HashMap<String, String> paramHashMap, int paramInt, float paramFloat2)
  {
    runTask(new TAVCutVideoSession.4(this, paramString, paramFloat1, paramHashMap, paramInt, paramFloat2));
  }
  
  public void resetAEKitModelForMultiAI(String paramString, float paramFloat1, HashMap<String, String> paramHashMap, int paramInt, float paramFloat2)
  {
    runTask(new TAVCutVideoSession.5(this, paramString, paramFloat1, paramHashMap, paramInt, paramFloat2));
  }
  
  public void restoreStickers(List<StickerModel> paramList)
  {
    runTask(new TAVCutVideoSession.9(this, paramList));
  }
  
  public void restoreStickersWithLyric(List<StickerModel> paramList)
  {
    runTask(new TAVCutVideoSession.10(this, paramList));
  }
  
  public SubtitleModel saveLyricSticker()
  {
    return getStickerController().saveLyricSticker();
  }
  
  public void setBgmMusic(MusicData paramMusicData, float paramFloat1, float paramFloat2, boolean paramBoolean)
  {
    if (paramMusicData == null)
    {
      paramMusicData = getMediaModel().getMediaEffectModel().getMusicModel();
      paramMusicData.setMetaDataBean(null);
      paramMusicData.setUserMetaDataBean(null);
      paramMusicData.setVolume(paramFloat1);
      paramMusicData.setBgmVolume(paramFloat2);
      updatePlayer(getMediaModel(), paramBoolean);
      return;
    }
    MusicMaterialMetaDataBean localMusicMaterialMetaDataBean = new MusicMaterialMetaDataBean();
    localMusicMaterialMetaDataBean.startTime = paramMusicData.getStartTime();
    localMusicMaterialMetaDataBean.mTotalTime = (paramMusicData.getTotalTime() / 1000);
    localMusicMaterialMetaDataBean.segDuration = paramMusicData.getSegDuration();
    localMusicMaterialMetaDataBean.path = paramMusicData.getPath();
    paramMusicData = getMediaModel().getMediaEffectModel().getMusicModel();
    paramMusicData.setVolume(paramFloat1);
    paramMusicData.setBgmVolume(paramFloat2);
    paramMusicData.setUserMetaDataBean(localMusicMaterialMetaDataBean);
    paramMusicData.setMetaDataBean(localMusicMaterialMetaDataBean);
    updatePlayer(getMediaModel(), paramBoolean);
  }
  
  public void setBgmMusicForMultiCut(MusicData paramMusicData, float paramFloat1, float paramFloat2, boolean paramBoolean)
  {
    if (paramMusicData == null)
    {
      paramMusicData = getMediaModel().getMediaEffectModel().getMusicModel();
      paramMusicData.setMetaDataBean(null);
      paramMusicData.setUserMetaDataBean(null);
      paramMusicData.setVolume(paramFloat1);
      paramMusicData.setBgmVolume(paramFloat2);
      return;
    }
    MusicMaterialMetaDataBean localMusicMaterialMetaDataBean = new MusicMaterialMetaDataBean();
    localMusicMaterialMetaDataBean.startTime = paramMusicData.getStartTime();
    localMusicMaterialMetaDataBean.mTotalTime = (paramMusicData.getTotalTime() / 1000);
    localMusicMaterialMetaDataBean.segDuration = paramMusicData.getSegDuration();
    localMusicMaterialMetaDataBean.path = paramMusicData.getPath();
    paramMusicData = getMediaModel().getMediaEffectModel().getMusicModel();
    paramMusicData.setVolume(paramFloat1);
    paramMusicData.setBgmVolume(paramFloat2);
    paramMusicData.setUserMetaDataBean(localMusicMaterialMetaDataBean);
    paramMusicData.setMetaDataBean(localMusicMaterialMetaDataBean);
  }
  
  public void setBgmRange(int paramInt1, int paramInt2)
  {
    MusicModel localMusicModel = getMediaModel().getMediaEffectModel().getMusicModel();
    localMusicModel.getUserMetaDataBean().startTime = paramInt1;
    localMusicModel.getUserMetaDataBean().mTotalTime = paramInt2;
    localMusicModel.getMetaDataBean().startTime = paramInt1;
    localMusicModel.getMetaDataBean().mTotalTime = paramInt2;
    updatePlayer(getMediaModel(), true);
  }
  
  public void setBgmVolume(float paramFloat)
  {
    getMediaModel().getMediaEffectModel().getMusicModel().setBgmVolume(paramFloat);
    Object localObject = getTAVComposition();
    if (localObject != null) {}
    for (localObject = ((TAVComposition)localObject).getAudios();; localObject = null)
    {
      if (!CollectionUtils.isEmpty((Collection)localObject))
      {
        int i = 0;
        while (i < ((List)localObject).size())
        {
          ((TAVAudio)((List)localObject).get(i)).getAudioConfiguration().setVolume(paramFloat);
          i += 1;
        }
      }
      return;
    }
  }
  
  public void setClip(Long paramLong1, Long paramLong2)
  {
    setClip(paramLong1, paramLong2, false);
  }
  
  public void setClip(Long paramLong1, Long paramLong2, boolean paramBoolean)
  {
    if ((paramLong1 != null) && (paramLong2 != null))
    {
      MediaClipModel localMediaClipModel = (MediaClipModel)getMediaModel().getMediaResourceModel().getVideos().get(0);
      localMediaClipModel.getResource().setSelectTimeStart(paramLong1.longValue());
      localMediaClipModel.getResource().setSelectTimeDuration(paramLong2.longValue());
    }
    for (;;)
    {
      if (paramBoolean) {
        updatePlayer(getMediaModel(), true);
      }
      return;
      paramLong1 = (MediaClipModel)getMediaModel().getMediaResourceModel().getVideos().get(0);
      long l = paramLong1.getResource().getSourceTimeDuration();
      paramLong1.getResource().setSelectTimeStart(0L);
      paramLong1.getResource().setSelectTimeDuration(l);
    }
  }
  
  public void setEffectStrength(float paramFloat)
  {
    runTask(new TAVCutVideoSession.6(this, paramFloat));
  }
  
  public void setLyricStartTime(int paramInt)
  {
    getStickerController().setLyricStartTime(paramInt);
  }
  
  public void setMainVolume(float paramFloat)
  {
    getMediaModel().getMediaEffectModel().getMusicModel().setVolume(paramFloat);
    Object localObject = getTAVComposition();
    if (localObject == null) {}
    for (;;)
    {
      return;
      localObject = ((TAVComposition)localObject).getAudioChannels();
      if ((!((List)localObject).isEmpty()) && (!((List)((List)localObject).get(0)).isEmpty()))
      {
        localObject = (List)((List)localObject).get(0);
        if (localObject != null)
        {
          localObject = ((List)localObject).iterator();
          while (((Iterator)localObject).hasNext())
          {
            TAVTransitionableAudio localTAVTransitionableAudio = (TAVTransitionableAudio)((Iterator)localObject).next();
            if ((localTAVTransitionableAudio instanceof TAVClip)) {
              localTAVTransitionableAudio.getAudioConfiguration().setVolume(paramFloat);
            }
          }
        }
      }
    }
  }
  
  @Deprecated
  public void setMaterial(@Nullable String paramString)
  {
    runTask(new TAVCutVideoSession.7(this, paramString));
  }
  
  public void setMediaModel(MediaModel paramMediaModel)
  {
    this.mediaModels = new ArrayList();
    this.mediaModels.add(paramMediaModel);
  }
  
  public void setRotate(int paramInt)
  {
    ((MediaClipModel)getMediaModel().getMediaResourceModel().getVideos().get(0)).getVideoConfigurationModel().setRotate(paramInt);
    if (getPlayer() != null) {
      getPlayer().rotate(paramInt % 4 * 90, false);
    }
  }
  
  public void setSpeed(float paramFloat)
  {
    setSpeed(paramFloat, false);
  }
  
  public void setSpeed(float paramFloat, boolean paramBoolean)
  {
    if (paramFloat <= 0.0F) {}
    do
    {
      return;
      ((MediaClipModel)getMediaModel().getMediaResourceModel().getVideos().get(0)).getResource().setSpeed(paramFloat);
    } while (!paramBoolean);
    updatePlayer(getMediaModel(), true);
  }
  
  public void setStickerTouchEnable(boolean paramBoolean)
  {
    if (getStickerController() != null) {
      getStickerController().setStickerTouchEnable(paramBoolean);
    }
  }
  
  public void setTAVCutVideoView(TAVCutVideoView paramTAVCutVideoView)
  {
    if (this.tavCutVideoView != null)
    {
      this.tavCutVideoView.getStickerContainer().removeAllViews();
      this.tavCutVideoView.removeAllViews();
      paramTAVCutVideoView.adjustStickerContainer(new Size(((MediaClipModel)getMediaModel().getMediaResourceModel().getVideos().get(0)).getResource().getWidth(), ((MediaClipModel)getMediaModel().getMediaResourceModel().getVideos().get(0)).getResource().getHeight()));
      getStickerController().setStickerContainer(paramTAVCutVideoView.getStickerContainer());
      getPlayer().release();
      getPlayer().bindView(paramTAVCutVideoView);
      initPlayer();
    }
    this.tavCutVideoView = paramTAVCutVideoView;
  }
  
  public void setTemplate(int paramInt, String paramString, boolean paramBoolean, String... paramVarArgs)
  {
    WSTemplateManager.updateTemplate(getMediaModel(), paramInt, paramString, paramBoolean, paramVarArgs);
    if (!TextUtils.isEmpty(paramString)) {}
    for (paramBoolean = true;; paramBoolean = false)
    {
      updateTemplateRenderChain(paramInt, paramBoolean, true);
      refreshRenderTemplate();
      return;
    }
  }
  
  public void setVideoPath(String paramString)
  {
    this.videoPath = paramString;
  }
  
  public void toggleAEKit(boolean paramBoolean)
  {
    runTask(new TAVCutVideoSession.2(this, paramBoolean));
  }
  
  public void updateComposition()
  {
    if (this.stickerControllers.size() < 1) {
      return;
    }
    MediaBuilderFactory.mediaBuilderAsync(getMediaModel(), this.context, (VideoRenderChainManager.IStickerContextInterface)this.stickerControllers.get(0), new TAVCutVideoSession.12(this));
  }
  
  public void updateTemplateComposition(boolean paramBoolean)
  {
    updateTemplateRenderChain(2, true, paramBoolean);
    refreshRenderTemplate();
  }
  
  public void updateVideoProgress(long paramLong)
  {
    getStickerController().setLyricProcess(paramLong);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.tavcut.session.TAVCutVideoSession
 * JD-Core Version:    0.7.0.1
 */