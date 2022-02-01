package com.tencent.weseevideo.composition;

import android.support.annotation.NonNull;
import com.tencent.aekit.api.standard.filter.AEFilterManager;
import com.tencent.autotemplate.TAVAutomaticRenderContext;
import com.tencent.autotemplate.TAVAutomaticTemplate;
import com.tencent.tav.coremedia.CMTime;
import com.tencent.tav.decoder.logger.Logger;
import com.tencent.tavcut.aekit.AEKitModel;
import com.tencent.tavcut.aekit.PreSegModel;
import com.tencent.tavkit.component.effectchain.VideoEffectProxy;
import com.tencent.tavkit.component.effectchain.VideoMixEffectProxy;
import com.tencent.tavkit.composition.TAVClip;
import com.tencent.tavkit.composition.TAVComposition;
import com.tencent.tavkit.composition.video.TAVVideoEffect;
import com.tencent.tavkit.composition.video.TAVVideoMixEffect;
import com.tencent.tavsticker.core.TAVStickerRenderContext;
import com.tencent.tavsticker.model.TAVSticker;
import com.tencent.weishi.module.publisher.WSAudioEngine;
import com.tencent.weseevideo.composition.effectnode.AEKitNode;
import com.tencent.weseevideo.composition.effectnode.CropEffectNode;
import com.tencent.weseevideo.composition.effectnode.GestureNode;
import com.tencent.weseevideo.composition.effectnode.LightVideoRenderNote;
import com.tencent.weseevideo.composition.effectnode.PreSegNode;
import com.tencent.weseevideo.composition.effectnode.PreSegNode.PicSaveDelegate;
import com.tencent.weseevideo.composition.effectnode.VideoEffectNodeFactory;
import com.tencent.weseevideo.composition.effectnode.WSLutEffectNode;
import com.tencent.weseevideo.composition.effectnode.WSOverlayStickerMergedEffectNode;
import com.tencent.weseevideo.composition.effectnode.WSPagChainStickerMergedEffectNode;
import com.tencent.weseevideo.composition.interfaces.OnNodeRenderListener;
import com.tencent.weseevideo.editor.sticker.WsStickerRenderContext;
import com.tencent.weseevideo.model.MediaModel;
import com.tencent.weseevideo.model.ModelExtKt;
import com.tencent.weseevideo.model.effect.CropModel;
import com.tencent.weseevideo.model.effect.LutModel;
import com.tencent.weseevideo.model.effect.MediaEffectModel;
import com.tencent.weseevideo.model.effect.MusicModel;
import com.tencent.weseevideo.model.effect.StickerModel;
import com.tencent.weseevideo.model.effect.SubtitleModel;
import com.tencent.weseevideo.model.effect.VideoBeginModel;
import com.tencent.weseevideo.model.effect.VideoEndModel;
import com.tencent.weseevideo.model.effect.VideoFenWeiModel;
import com.tencent.weseevideo.model.template.MediaTemplateModel;
import com.tencent.weseevideo.model.template.auto.AEFrameModel;
import com.tencent.weseevideo.model.template.auto.AutomaticMediaTemplateModel;
import com.tencent.weseevideo.model.template.light.LightTemplate;
import com.tencent.weseevideo.model.utils.AudioUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import org.jetbrains.annotations.NotNull;
import org.light.LightEngine;

public class VideoRenderChainManager
{
  public static final String TAG = "VideoRenderChainManager";
  private OnNodeRenderListener lightNodeRenderListener = new VideoRenderChainManager.4(this);
  private AEKitNode mAEKitNode;
  private VideoEffectProxy mAfterVideoEffectProxy = new VideoEffectProxy();
  private CopyOnWriteArrayList<TAVVideoEffect> mAfterVideoEffects = new CopyOnWriteArrayList();
  private int mApplyType = -1;
  private TAVAutomaticTemplate mAutomaticTemplate;
  private VideoEffectProxy mBeforeVideoEffectProxy = new VideoEffectProxy();
  private CopyOnWriteArrayList<TAVVideoEffect> mBeforeVideoEffects = new CopyOnWriteArrayList();
  private TAVComposition mComposition;
  private VideoRenderChainConfigure mConfigure;
  private CropEffectNode mCropEffectNode;
  private VideoRenderChainManager.IEffectNodeInterface mEffectNodeInterface;
  private GestureNode mGestureNode;
  private LightTemplate mLightTemplate;
  private LightVideoRenderNote mLightVideoRenderNote;
  private WSLutEffectNode mLutEffectNode;
  private MediaModel mMediaModel;
  private TAVVideoMixEffect mPagChainMergedEffect;
  private WSOverlayStickerMergedEffectNode mPagOverlayMergedEffect;
  private PreSegNode mPreSegNode;
  private VideoRenderChainManager.IStickerContextInterface mRenderContextCreator;
  private TAVStickerRenderContext mSharePagChainRenderContext;
  private TAVStickerRenderContext mSharePagOverlayStickerContext;
  private VideoMixEffectProxy mVideoMixEffectProxy = new VideoMixEffectProxy();
  private CopyOnWriteArrayList<TAVVideoMixEffect> mVideoMixEffects = new CopyOnWriteArrayList();
  private WSAudioEngine mWsAudioEngine;
  private VideoRenderChainManager.ShouldRenderStickerAdapter shouldRenderStickerAdapter;
  
  public VideoRenderChainManager(int paramInt, @NonNull TAVComposition paramTAVComposition, MediaModel paramMediaModel, VideoRenderChainManager.IStickerContextInterface paramIStickerContextInterface)
  {
    this(paramInt, paramTAVComposition, paramMediaModel, paramIStickerContextInterface, null);
  }
  
  public VideoRenderChainManager(int paramInt, @NonNull TAVComposition paramTAVComposition, MediaModel paramMediaModel, VideoRenderChainManager.IStickerContextInterface paramIStickerContextInterface, VideoRenderChainManager.IEffectNodeInterface paramIEffectNodeInterface)
  {
    this(paramInt, paramTAVComposition, paramMediaModel, paramIStickerContextInterface, paramIEffectNodeInterface, null);
  }
  
  public VideoRenderChainManager(int paramInt, @NonNull TAVComposition paramTAVComposition, MediaModel paramMediaModel, VideoRenderChainManager.IStickerContextInterface paramIStickerContextInterface, VideoRenderChainManager.IEffectNodeInterface paramIEffectNodeInterface, VideoRenderChainConfigure paramVideoRenderChainConfigure)
  {
    this.mApplyType = paramInt;
    this.mComposition = paramTAVComposition;
    this.mMediaModel = paramMediaModel;
    this.mRenderContextCreator = paramIStickerContextInterface;
    this.mEffectNodeInterface = paramIEffectNodeInterface;
    this.mConfigure = paramVideoRenderChainConfigure;
    initOverlayStickerContext();
    initPagChainStickerContext(paramMediaModel);
    updateVideoRenderChain();
  }
  
  public VideoRenderChainManager(@NonNull TAVComposition paramTAVComposition, MediaModel paramMediaModel)
  {
    this(-1, paramTAVComposition, paramMediaModel, null);
  }
  
  private boolean checkOverlayMergedEffect()
  {
    if (this.mPagOverlayMergedEffect == null)
    {
      TAVStickerRenderContext localTAVStickerRenderContext = this.mSharePagOverlayStickerContext;
      VideoRenderChainManager.IStickerContextInterface localIStickerContextInterface = this.mRenderContextCreator;
      boolean bool;
      if (this.mConfigure.mApplyType != 101) {
        bool = true;
      } else {
        bool = false;
      }
      this.mPagOverlayMergedEffect = VideoEffectNodeFactory.createPagOverlayEffect(localTAVStickerRenderContext, localIStickerContextInterface, bool);
      this.mAfterVideoEffects.add(this.mPagOverlayMergedEffect);
    }
    return this.mPagOverlayMergedEffect instanceof WSOverlayStickerMergedEffectNode;
  }
  
  private TAVVideoMixEffect checkPagChainMergedEffect()
  {
    if (this.mPagChainMergedEffect == null)
    {
      this.mPagChainMergedEffect = VideoEffectNodeFactory.createPagChainEffect(this.mSharePagChainRenderContext);
      this.mVideoMixEffects.add(this.mPagChainMergedEffect);
    }
    return this.mPagChainMergedEffect;
  }
  
  private void initOverlayStickerContext()
  {
    VideoRenderChainManager.IStickerContextInterface localIStickerContextInterface = this.mRenderContextCreator;
    if (localIStickerContextInterface != null) {
      this.mSharePagOverlayStickerContext = localIStickerContextInterface.createStickerContext(this.mConfigure.isImageMode());
    }
    if (this.mSharePagOverlayStickerContext == null)
    {
      if (needBlur())
      {
        this.mSharePagOverlayStickerContext = new WsStickerRenderContext();
        return;
      }
      this.mSharePagOverlayStickerContext = new TAVStickerRenderContext();
    }
  }
  
  private void initPagChainStickerContext(MediaModel paramMediaModel)
  {
    if (this.mSharePagChainRenderContext == null)
    {
      int j = this.mConfigure.getSceneType();
      int i = 1;
      if (j == 1)
      {
        this.mSharePagChainRenderContext = new TAVStickerRenderContext();
      }
      else if ((ModelExtKt.isImageMode(paramMediaModel)) && (this.mConfigure.isImageMode()))
      {
        this.mSharePagChainRenderContext = new TAVAutomaticTransRenderContext(paramMediaModel);
        AEFrameModel localAEFrameModel = paramMediaModel.getMediaTemplateModel().getAutomaticMediaTemplateModel().getAEFrameModel();
        if (localAEFrameModel != null) {
          i = localAEFrameModel.getPagFillMode();
        }
        ((TAVAutomaticTransRenderContext)this.mSharePagChainRenderContext).a(i);
        ((TAVAutomaticTransRenderContext)this.mSharePagChainRenderContext).a(this.mConfigure.getScreenSize());
      }
      else
      {
        this.mSharePagChainRenderContext = new TAVAutomaticRenderContext();
      }
    }
    if (ModelExtKt.isImageMode(paramMediaModel))
    {
      this.mSharePagChainRenderContext.setTavRenderContextDataSource(new VideoRenderChainManager.1(this));
      if (this.mApplyType == 101) {
        this.mSharePagOverlayStickerContext.setTavRenderContextDataSource(new VideoRenderChainManager.2(this));
      }
    }
  }
  
  private boolean needBlur()
  {
    Iterator localIterator = this.mMediaModel.getMediaEffectModel().getStickerModelList().iterator();
    while (localIterator.hasNext()) {
      if ("blur".equals(((StickerModel)localIterator.next()).getType())) {
        return true;
      }
    }
    return false;
  }
  
  private void updateAEKit(AEKitModel paramAEKitModel)
  {
    if (this.mAEKitNode == null)
    {
      this.mAEKitNode = new AEKitNode();
      this.mBeforeVideoEffects.add(this.mAEKitNode);
    }
    this.mAEKitNode.setAEKitModel(paramAEKitModel);
  }
  
  private void updateCropEffect(CropModel paramCropModel)
  {
    if (paramCropModel == null)
    {
      paramCropModel = this.mCropEffectNode;
      if (paramCropModel != null)
      {
        this.mBeforeVideoEffects.remove(paramCropModel);
        this.mCropEffectNode = null;
      }
    }
    else
    {
      CropEffectNode localCropEffectNode = this.mCropEffectNode;
      if (localCropEffectNode == null)
      {
        this.mCropEffectNode = VideoEffectNodeFactory.createCropEffectNode(paramCropModel);
        this.mBeforeVideoEffects.add(this.mCropEffectNode);
        return;
      }
      localCropEffectNode.setCropModel(paramCropModel);
    }
  }
  
  private void updateLutEffect(LutModel paramLutModel)
  {
    Object localObject = this.mConfigure;
    if ((localObject != null) && (!((VideoRenderChainConfigure)localObject).isOpenLutEffect())) {
      return;
    }
    if (paramLutModel == null)
    {
      paramLutModel = this.mLutEffectNode;
      if (paramLutModel != null)
      {
        this.mBeforeVideoEffects.remove(paramLutModel);
        this.mLutEffectNode = null;
      }
    }
    else
    {
      localObject = this.mLutEffectNode;
      if (localObject == null)
      {
        this.mLutEffectNode = VideoEffectNodeFactory.createLutEffectNode(paramLutModel);
        this.mBeforeVideoEffects.add(this.mLutEffectNode);
        return;
      }
      ((WSLutEffectNode)localObject).setLutMode(paramLutModel);
    }
  }
  
  private void updatePreSeg(PreSegModel paramPreSegModel, CropModel paramCropModel)
  {
    if (this.mPreSegNode == null)
    {
      this.mPreSegNode = new PreSegNode();
      this.mBeforeVideoEffects.add(this.mPreSegNode);
    }
    this.mPreSegNode.a(paramPreSegModel);
    this.mPreSegNode.a(paramCropModel);
  }
  
  private void updateStickerEffect(List<StickerModel> paramList)
  {
    VideoRenderChainConfigure localVideoRenderChainConfigure = this.mConfigure;
    if ((localVideoRenderChainConfigure != null) && (!localVideoRenderChainConfigure.isOpenStickerEffect())) {
      return;
    }
    if (checkOverlayMergedEffect()) {
      this.mPagOverlayMergedEffect.setStickerModels(paramList, this.mComposition.getRenderSize());
    }
  }
  
  private void updateStickerForTimeLineChanged()
  {
    VideoRenderChainManager.IStickerContextInterface localIStickerContextInterface = this.mRenderContextCreator;
    if (localIStickerContextInterface != null)
    {
      TAVComposition localTAVComposition = this.mComposition;
      if (localTAVComposition != null) {
        localIStickerContextInterface.alignStickers(localTAVComposition.getDuration().getTimeUs());
      }
    }
  }
  
  private void updateSubtitleEffect(SubtitleModel paramSubtitleModel)
  {
    VideoRenderChainConfigure localVideoRenderChainConfigure = this.mConfigure;
    if ((localVideoRenderChainConfigure != null) && (!localVideoRenderChainConfigure.isOpenSubtitleEffect())) {
      return;
    }
    if (checkOverlayMergedEffect()) {
      this.mPagOverlayMergedEffect.setSubtitleModel(paramSubtitleModel, this.mComposition.getRenderSize());
    }
  }
  
  private void updateVideoBeginEffect(VideoBeginModel paramVideoBeginModel)
  {
    Object localObject = this.mConfigure;
    if ((localObject != null) && (!((VideoRenderChainConfigure)localObject).isOpenVideoBeginEffect())) {
      return;
    }
    localObject = checkPagChainMergedEffect();
    if ((localObject instanceof WSPagChainStickerMergedEffectNode)) {
      ((WSPagChainStickerMergedEffectNode)localObject).setVideoBeginModel(paramVideoBeginModel);
    }
  }
  
  private void updateVideoEndEffect(VideoEndModel paramVideoEndModel)
  {
    Object localObject = this.mConfigure;
    if ((localObject != null) && (!((VideoRenderChainConfigure)localObject).isOpenVideoEndEffect())) {
      return;
    }
    localObject = checkPagChainMergedEffect();
    if ((localObject instanceof WSPagChainStickerMergedEffectNode))
    {
      TAVComposition localTAVComposition = this.mComposition;
      if ((localTAVComposition != null) && (paramVideoEndModel != null)) {
        paramVideoEndModel.setCompositionDuration((float)(localTAVComposition.getDuration().getTimeUs() / 1000L));
      }
      ((WSPagChainStickerMergedEffectNode)localObject).setVideoEndModel(paramVideoEndModel);
    }
  }
  
  private void updateVideoFenWeiEffect(VideoFenWeiModel paramVideoFenWeiModel)
  {
    Object localObject = this.mConfigure;
    if ((localObject != null) && (!((VideoRenderChainConfigure)localObject).isOpenVideoFenWeiEffect())) {
      return;
    }
    localObject = checkPagChainMergedEffect();
    if ((localObject instanceof WSPagChainStickerMergedEffectNode)) {
      ((WSPagChainStickerMergedEffectNode)localObject).setVideoFenWeiModel(paramVideoFenWeiModel);
    }
  }
  
  public void addBgmEffect(@NonNull TAVClip paramTAVClip)
  {
    Object localObject = this.mComposition;
    if (localObject == null)
    {
      Logger.e(TAG, "this mComposition is null.");
      return;
    }
    List localList = ((TAVComposition)localObject).getAudios();
    localObject = localList;
    if (localList == null)
    {
      localObject = new ArrayList();
      this.mComposition.setAudios((List)localObject);
    }
    ((List)localObject).add(paramTAVClip);
  }
  
  public TAVComposition getComposition()
  {
    return this.mComposition;
  }
  
  public MediaModel getMediaModel()
  {
    return this.mMediaModel;
  }
  
  public TAVStickerRenderContext getPagChainRenderContext()
  {
    return this.mSharePagChainRenderContext;
  }
  
  public TAVStickerRenderContext getStickerRenderContext()
  {
    if (this.mSharePagOverlayStickerContext == null) {
      initOverlayStickerContext();
    }
    return this.mSharePagOverlayStickerContext;
  }
  
  public void release()
  {
    Object localObject = this.mSharePagChainRenderContext;
    if (localObject != null)
    {
      ((TAVStickerRenderContext)localObject).release();
      this.mSharePagChainRenderContext = null;
    }
    localObject = this.mRenderContextCreator;
    if (localObject != null) {
      ((VideoRenderChainManager.IStickerContextInterface)localObject).releaseStickerContext();
    }
    if (this.mRenderContextCreator == null)
    {
      localObject = this.mSharePagOverlayStickerContext;
      if (localObject != null)
      {
        ((TAVStickerRenderContext)localObject).release();
        this.mSharePagOverlayStickerContext = null;
      }
    }
  }
  
  public void releaseAndKeepStickerContext()
  {
    TAVStickerRenderContext localTAVStickerRenderContext = this.mSharePagChainRenderContext;
    if (localTAVStickerRenderContext != null)
    {
      localTAVStickerRenderContext.release();
      this.mSharePagChainRenderContext = null;
    }
    if (this.mRenderContextCreator == null)
    {
      localTAVStickerRenderContext = this.mSharePagOverlayStickerContext;
      if (localTAVStickerRenderContext != null)
      {
        localTAVStickerRenderContext.release();
        this.mSharePagOverlayStickerContext = null;
      }
    }
  }
  
  public void setBasePicActive(boolean paramBoolean)
  {
    AEKitNode localAEKitNode = this.mAEKitNode;
    if (localAEKitNode != null) {
      localAEKitNode.setBasePicActive(paramBoolean);
    }
  }
  
  public void setCachePicDelegate(PreSegNode.PicSaveDelegate paramPicSaveDelegate)
  {
    this.mPreSegNode.a(paramPicSaveDelegate);
  }
  
  public void setComposition(TAVComposition paramTAVComposition)
  {
    this.mComposition = paramTAVComposition;
  }
  
  public void setFilterManager(AEFilterManager paramAEFilterManager)
  {
    Object localObject = this.mAEKitNode;
    if (localObject != null) {
      ((AEKitNode)localObject).setFilterManager(paramAEFilterManager);
    }
    localObject = this.mPreSegNode;
    if (localObject != null) {
      ((PreSegNode)localObject).a(paramAEFilterManager);
    }
  }
  
  public void setNeedRenderOverlayStickerMergedEffectNode(boolean paramBoolean)
  {
    this.mPagOverlayMergedEffect.setNeedRender(paramBoolean);
    this.mSharePagOverlayStickerContext.setTavRenderContextDataSource(new VideoRenderChainManager.3(this));
  }
  
  public void setShouldRenderStickerAdapter(VideoRenderChainManager.ShouldRenderStickerAdapter paramShouldRenderStickerAdapter)
  {
    this.shouldRenderStickerAdapter = paramShouldRenderStickerAdapter;
  }
  
  public void updateBgmVolume(float paramFloat)
  {
    WSAudioEngine localWSAudioEngine = this.mWsAudioEngine;
    if (localWSAudioEngine != null) {
      localWSAudioEngine.updateBgmVolume(paramFloat);
    }
  }
  
  public void updateLightAudioRender(LightTemplate paramLightTemplate, TAVComposition paramTAVComposition, MediaModel paramMediaModel)
  {
    this.mWsAudioEngine = new WSAudioEngine(paramTAVComposition, paramLightTemplate.getLightEngine().audioOutput());
    paramLightTemplate = paramMediaModel.getMediaEffectModel().getMusicModel();
    this.mWsAudioEngine.initEmptyClip(paramLightTemplate.getVolume());
    paramTAVComposition = AudioUtils.getBGMAudioClips(paramTAVComposition.getDuration().getTimeUs() / 1000L, paramLightTemplate.getMetaDataBean(), paramLightTemplate.getBgmVolume());
    this.mWsAudioEngine.initBgm(paramTAVComposition, paramLightTemplate.getBgmVolume());
  }
  
  public void updateLightVideoRender(@NotNull LightTemplate paramLightTemplate, MediaModel paramMediaModel)
  {
    if ((paramMediaModel != null) && (paramLightTemplate.getLightAsset() != null) && (paramLightTemplate.getLightEngine() != null))
    {
      this.mLightTemplate = paramLightTemplate;
      paramMediaModel = this.mLightVideoRenderNote;
      if (paramMediaModel != null) {
        this.mBeforeVideoEffects.remove(paramMediaModel);
      }
      this.mLightVideoRenderNote = new LightVideoRenderNote(paramLightTemplate.getLightEngine());
      this.mLightVideoRenderNote.a(paramLightTemplate.getLightAsset());
      this.mLightVideoRenderNote.a(this.lightNodeRenderListener);
      this.mBeforeVideoEffects.add(this.mLightVideoRenderNote);
      return;
    }
    Logger.e(TAG, "updateLightVideoRender error!! some variable is NULL!");
  }
  
  public void updateMovieTemplateEffect(TAVSticker paramTAVSticker)
  {
    VideoRenderChainConfigure localVideoRenderChainConfigure = this.mConfigure;
    if ((localVideoRenderChainConfigure != null) && (!localVideoRenderChainConfigure.isOpenMovieTemplateEffect())) {
      return;
    }
    this.mSharePagChainRenderContext.loadSticker(paramTAVSticker, false);
  }
  
  public TAVComposition updateRenderChain(@NonNull MediaEffectModel paramMediaEffectModel)
  {
    boolean bool;
    if (this.mApplyType != 101) {
      bool = true;
    } else {
      bool = false;
    }
    return updateRenderChain(paramMediaEffectModel, bool);
  }
  
  public TAVComposition updateRenderChain(@NonNull MediaEffectModel paramMediaEffectModel, boolean paramBoolean)
  {
    if (paramMediaEffectModel == null)
    {
      Logger.e(TAG, "updateVideoRenderChain---this mMediaEffectModel is null.");
      return this.mComposition;
    }
    updateCropEffect(paramMediaEffectModel.getCropModel());
    updatePreSeg(paramMediaEffectModel.getPreSegModel(), paramMediaEffectModel.getCropModel());
    updateVideoBeginEffect(paramMediaEffectModel.getVideoBeginModel());
    updateVideoFenWeiEffect(paramMediaEffectModel.getVideoFenWeiModel());
    updateVideoEndEffect(paramMediaEffectModel.getVideoEndModel());
    updateLutEffect(paramMediaEffectModel.getLutModel());
    updateAEKit(paramMediaEffectModel.getAeKitModel());
    if (paramBoolean) {
      updateStickerEffect(paramMediaEffectModel.getStickerModelList());
    }
    updateSubtitleEffect(paramMediaEffectModel.getSubtitleModel());
    this.mComposition.attachVideoEffectChain(new VideoRenderChainManager.WSVideoEffectContext(this, null));
    return this.mComposition;
  }
  
  public TAVComposition updateVideoRenderChain()
  {
    if (this.mComposition == null)
    {
      Logger.e(TAG, "updateVideoRenderChain---this mComposition is null.");
      return null;
    }
    Object localObject = this.mEffectNodeInterface;
    if (localObject != null) {
      ((VideoRenderChainManager.IEffectNodeInterface)localObject).insertEffectNode(this, this.mMediaModel.getMediaEffectModel());
    }
    localObject = this.mMediaModel;
    if ((localObject != null) && (((MediaModel)localObject).getMediaEffectModel() != null))
    {
      updateStickerForTimeLineChanged();
      return updateRenderChain(this.mMediaModel.getMediaEffectModel());
    }
    Logger.e(TAG, "updateVideoRenderChain---this mMediaEffectModel is null.");
    return this.mComposition;
  }
  
  public void updateVideoVolume(float paramFloat)
  {
    WSAudioEngine localWSAudioEngine = this.mWsAudioEngine;
    if (localWSAudioEngine != null) {
      localWSAudioEngine.updateVideoVolume(paramFloat);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.weseevideo.composition.VideoRenderChainManager
 * JD-Core Version:    0.7.0.1
 */