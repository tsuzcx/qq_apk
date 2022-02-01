package com.tencent.tavcut.session;

import android.content.Context;
import android.graphics.Bitmap;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.util.SparseArray;
import android.view.TextureView;
import android.view.ViewGroup;
import com.tencent.tav.core.AssetImageGenerator;
import com.tencent.tav.core.AssetImageGenerator.ApertureMode;
import com.tencent.tav.coremedia.CGSize;
import com.tencent.tav.coremedia.CMTime;
import com.tencent.tav.coremedia.CMTimeRange;
import com.tencent.tav.decoder.DecoderUtils;
import com.tencent.tavcut.bean.CropConfig;
import com.tencent.tavcut.bean.Size;
import com.tencent.tavcut.cover.VideoImageExtractor;
import com.tencent.tavcut.exporter.VideoExportConfig;
import com.tencent.tavcut.exporter.VideoExporter;
import com.tencent.tavcut.player.MoviePlayer;
import com.tencent.tavcut.player.MoviePlayer.onVideoProgressListener;
import com.tencent.tavcut.session.callback.FrameExtractCallback;
import com.tencent.tavcut.session.config.SessionConfig;
import com.tencent.tavcut.util.DurationUtil;
import com.tencent.tavcut.util.Logger;
import com.tencent.tavcut.util.VideoUtil;
import com.tencent.tavcut.view.TAVCutVideoView;
import com.tencent.tavkit.component.TAVSourceImageGenerator;
import com.tencent.tavkit.composition.TAVComposition;
import com.tencent.tavkit.composition.TAVSource;
import com.tencent.tavkit.composition.builder.TAVCompositionBuilder;
import com.tencent.tavkit.composition.model.TAVAudio;
import com.tencent.tavkit.composition.model.TAVAudioConfiguration;
import com.tencent.tavkit.composition.model.TAVTransitionableAudio;
import com.tencent.tavkit.composition.model.TAVVideoConfiguration.TAVVideoConfigurationContentMode;
import com.tencent.tavsticker.model.TAVSticker;
import com.tencent.ttpic.baseutils.collection.CollectionUtils;
import com.tencent.weseevideo.composition.VideoRenderChainConfigure;
import com.tencent.weseevideo.composition.VideoRenderChainManager;
import com.tencent.weseevideo.composition.builder.MediaBuilderFactory;
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
  
  private void mediaBuild(StickerController paramStickerController, VideoRenderChainConfigure paramVideoRenderChainConfigure)
  {
    MediaBuilderFactory.mediaBuilderAsync(getMediaModel(), paramStickerController, paramVideoRenderChainConfigure, new TAVCutVideoSession.8(this));
  }
  
  private void refreshRenderTemplate()
  {
    initPlayer();
  }
  
  private void updateComposition(MediaModel paramMediaModel)
  {
    MediaBuilderFactory.mediaBuilderAsync(paramMediaModel, null, new TAVCutVideoSession.11(this));
  }
  
  private void updatePlayer(MediaModel paramMediaModel, boolean paramBoolean)
  {
    if (getStickerController() != null) {
      getStickerController().destroy();
    }
    StickerController localStickerController = createStickerController();
    this.stickerControllers.put(0, localStickerController);
    new VideoRenderChainConfigure(true).setSceneType(0);
    MediaBuilderFactory.mediaBuilderAsync(paramMediaModel, localStickerController, new TAVCutVideoSession.10(this, paramBoolean));
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
  
  private void updateTemplateRenderChain(int paramInt, boolean paramBoolean)
  {
    if ((this.renderChainManagers != null) && (this.renderChainManagers.size() > 0)) {
      ((VideoRenderChainManager)this.renderChainManagers.get(0)).release();
    }
    StickerController localStickerController;
    VideoRenderChainConfigure localVideoRenderChainConfigure;
    if ((this.stickerControllers != null) && (this.stickerControllers.size() > 0))
    {
      localStickerController = (StickerController)this.stickerControllers.get(0);
      localVideoRenderChainConfigure = new VideoRenderChainConfigure(true);
      if (!paramBoolean) {
        break label88;
      }
      localVideoRenderChainConfigure.setSceneType(paramInt);
    }
    for (;;)
    {
      mediaBuild(localStickerController, localVideoRenderChainConfigure);
      return;
      label88:
      localVideoRenderChainConfigure.setSceneType(0);
    }
  }
  
  public void addPlayer(MoviePlayer paramMoviePlayer)
  {
    this.players.add(paramMoviePlayer);
  }
  
  public void addSticker(StickerModel paramStickerModel)
  {
    runTask(new TAVCutVideoSession.7(this, paramStickerModel));
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
    localTAVSourceImageGenerator.getAssetImageGenerator().setApertureMode(AssetImageGenerator.ApertureMode.aspectFill);
    localTAVSourceImageGenerator.generateThumbnailAtTime(new CMTime((float)paramLong / 1000.0F), new TAVCutVideoSession.12(this, paramInt, localTAVSourceImageGenerator, paramFrameExtractCallback));
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
        break label69;
      }
      localVideoRenderChainConfigure.setSceneType(2);
    }
    for (;;)
    {
      MediaBuilderFactory.mediaBuilderAsync(getMediaModel(), null, localVideoRenderChainConfigure, new TAVCutVideoSession.9(this, localVideoExporter, paramVideoExportConfig));
      return localVideoExporter;
      label69:
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
    MediaBuilderFactory.mediaBuilderAsync(getMediaModel(), localStickerController, localVideoRenderChainConfigure, new TAVCutVideoSession.1(this));
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
  
  public void restoreStickers(List<StickerModel> paramList)
  {
    getStickerController().restoreSticker(paramList);
    getMediaModel().getMediaEffectModel().setStickerModelList(paramList);
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
    runTask(new TAVCutVideoSession.5(this, paramFloat));
  }
  
  public void setLyricStartTime(int paramInt)
  {
    getStickerController().setLyricStartTime(paramInt);
  }
  
  public void setMainVolume(float paramFloat)
  {
    getMediaModel().getMediaEffectModel().getMusicModel().setVolume(paramFloat);
    List localList = getTAVComposition().getAudioChannels();
    if ((!localList.isEmpty()) && (!((List)localList.get(0)).isEmpty())) {
      ((TAVTransitionableAudio)((List)localList.get(0)).get(0)).getAudioConfiguration().setVolume(paramFloat);
    }
  }
  
  @Deprecated
  public void setMaterial(@Nullable String paramString)
  {
    runTask(new TAVCutVideoSession.6(this, paramString));
  }
  
  public void setMediaModel(MediaModel paramMediaModel)
  {
    this.mediaModels = new ArrayList();
    this.mediaModels.add(paramMediaModel);
  }
  
  public void setRotate(int paramInt)
  {
    ((MediaClipModel)getMediaModel().getMediaResourceModel().getVideos().get(0)).getVideoConfigurationModel().setRotate(paramInt);
    getPlayer().rotate(paramInt % 4 * 90, false);
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
      updateTemplateRenderChain(paramInt, paramBoolean);
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
  
  public void updateVideoProgress(long paramLong)
  {
    getStickerController().setLyricProcess(paramLong);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.tavcut.session.TAVCutVideoSession
 * JD-Core Version:    0.7.0.1
 */