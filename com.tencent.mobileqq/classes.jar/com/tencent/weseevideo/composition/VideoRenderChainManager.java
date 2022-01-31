package com.tencent.weseevideo.composition;

import android.support.annotation.NonNull;
import com.tencent.autotemplate.TAVAutomaticTemplate;
import com.tencent.tav.coremedia.CMTime;
import com.tencent.tavcut.aekit.AEKitModel;
import com.tencent.tavcut.aifilter.AIFilterModel;
import com.tencent.tavkit.component.effectchain.VideoEffectProxy;
import com.tencent.tavkit.component.effectchain.VideoMixEffectProxy;
import com.tencent.tavkit.composition.TAVClip;
import com.tencent.tavkit.composition.TAVComposition;
import com.tencent.tavkit.composition.video.TAVVideoEffect;
import com.tencent.tavkit.composition.video.TAVVideoMixEffect;
import com.tencent.tavsticker.core.TAVStickerRenderContext;
import com.tencent.weseevideo.composition.effectnode.AEKitNode;
import com.tencent.weseevideo.composition.effectnode.CropEffectNode;
import com.tencent.weseevideo.composition.effectnode.VideoEffectNodeFactory;
import com.tencent.weseevideo.composition.effectnode.WSLutEffectNode;
import com.tencent.weseevideo.composition.effectnode.WSOverlayStickerMergedEffectNode;
import com.tencent.weseevideo.model.MediaModel;
import com.tencent.weseevideo.model.effect.CropModel;
import com.tencent.weseevideo.model.effect.LutModel;
import com.tencent.weseevideo.model.effect.MediaEffectModel;
import com.tencent.weseevideo.model.effect.StickerModel;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class VideoRenderChainManager
{
  public static final String TAG = VideoRenderChainManager.class.getSimpleName();
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
  private WSLutEffectNode mLutEffectNode;
  private MediaModel mMediaModel;
  private TAVVideoEffect mPagOverlayMergedEffect;
  private VideoRenderChainManager.IStickerContextInterface mRenderContextCreator;
  private TAVStickerRenderContext mSharePagChainRenderContext;
  private TAVStickerRenderContext mSharePagOverlayStickerContext;
  private VideoMixEffectProxy mVideoMixEffectProxy = new VideoMixEffectProxy();
  private CopyOnWriteArrayList<TAVVideoMixEffect> mVideoMixEffects = new CopyOnWriteArrayList();
  
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
      this.mPagOverlayMergedEffect = VideoEffectNodeFactory.createPagOverlayEffect(this.mSharePagOverlayStickerContext, this.mRenderContextCreator);
      this.mAfterVideoEffects.add(this.mPagOverlayMergedEffect);
    }
    return this.mPagOverlayMergedEffect instanceof WSOverlayStickerMergedEffectNode;
  }
  
  private void initOverlayStickerContext()
  {
    if (this.mRenderContextCreator != null) {
      this.mSharePagOverlayStickerContext = this.mRenderContextCreator.createStickerContext();
    }
    if (this.mSharePagOverlayStickerContext == null) {
      this.mSharePagOverlayStickerContext = new TAVStickerRenderContext();
    }
  }
  
  private void updateAEKit(AEKitModel paramAEKitModel)
  {
    com.tencent.tavcut.util.Logger.i("AEKitNode", "update");
    if (paramAEKitModel == null)
    {
      if (this.mAEKitNode != null)
      {
        this.mBeforeVideoEffects.remove(this.mAEKitNode);
        this.mAEKitNode = null;
      }
      return;
    }
    if (this.mAEKitNode == null)
    {
      this.mAEKitNode = VideoEffectNodeFactory.createAEKitNode(paramAEKitModel);
      this.mBeforeVideoEffects.add(this.mAEKitNode);
      return;
    }
    this.mAEKitNode.setAEKitModel(paramAEKitModel);
  }
  
  private void updateAIFilter(AIFilterModel paramAIFilterModel) {}
  
  private void updateCropEffect(CropModel paramCropModel)
  {
    if (paramCropModel == null)
    {
      if (this.mCropEffectNode != null)
      {
        this.mBeforeVideoEffects.remove(this.mCropEffectNode);
        this.mCropEffectNode = null;
      }
      return;
    }
    if (this.mCropEffectNode == null)
    {
      this.mCropEffectNode = VideoEffectNodeFactory.createCropEffectNode(paramCropModel);
      this.mBeforeVideoEffects.add(this.mCropEffectNode);
      return;
    }
    this.mCropEffectNode.setCropModel(paramCropModel);
  }
  
  private void updateLutEffect(LutModel paramLutModel)
  {
    if (paramLutModel == null)
    {
      if (this.mLutEffectNode != null)
      {
        this.mBeforeVideoEffects.remove(this.mLutEffectNode);
        this.mLutEffectNode = null;
      }
      return;
    }
    if (this.mLutEffectNode == null)
    {
      this.mLutEffectNode = VideoEffectNodeFactory.createLutEffectNode(paramLutModel);
      this.mBeforeVideoEffects.add(this.mLutEffectNode);
      return;
    }
    this.mLutEffectNode.setLutMode(paramLutModel);
  }
  
  private void updateStickerEffect(List<StickerModel> paramList)
  {
    if ((this.mConfigure != null) && (!this.mConfigure.isOpenStickerEffect())) {}
    while (!checkOverlayMergedEffect()) {
      return;
    }
    ((WSOverlayStickerMergedEffectNode)this.mPagOverlayMergedEffect).setStickerModels(paramList, this.mComposition.getRenderSize());
  }
  
  private void updateStickerForTimeLineChanged()
  {
    if ((this.mRenderContextCreator != null) && (this.mComposition != null)) {
      this.mRenderContextCreator.alignStickers(this.mComposition.getDuration().getTimeUs());
    }
  }
  
  public void addBgmEffect(@NonNull TAVClip paramTAVClip)
  {
    if (this.mComposition == null)
    {
      com.tencent.tav.decoder.logger.Logger.e(TAG, "this mComposition is null.");
      return;
    }
    List localList = this.mComposition.getAudios();
    Object localObject = localList;
    if (localList == null)
    {
      localObject = new ArrayList();
      this.mComposition.setAudios((List)localObject);
    }
    ((List)localObject).add(paramTAVClip);
  }
  
  public TAVAutomaticTemplate getAutomaticTemplate()
  {
    return this.mAutomaticTemplate;
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
    if (this.mSharePagChainRenderContext != null)
    {
      this.mSharePagChainRenderContext.release();
      this.mSharePagChainRenderContext = null;
    }
    if (this.mRenderContextCreator != null) {
      this.mRenderContextCreator.releaseStickerContext();
    }
    if ((this.mRenderContextCreator == null) && (this.mSharePagOverlayStickerContext != null))
    {
      this.mSharePagOverlayStickerContext.release();
      this.mSharePagOverlayStickerContext = null;
    }
  }
  
  public void setAutomaticTemplate(TAVAutomaticTemplate paramTAVAutomaticTemplate)
  {
    this.mAutomaticTemplate = paramTAVAutomaticTemplate;
  }
  
  public void setComposition(TAVComposition paramTAVComposition)
  {
    this.mComposition = paramTAVComposition;
  }
  
  public TAVComposition updateRenderChain(@NonNull MediaEffectModel paramMediaEffectModel)
  {
    if (paramMediaEffectModel == null)
    {
      com.tencent.tav.decoder.logger.Logger.e(TAG, "updateVideoRenderChain---this mMediaEffectModel is null.");
      return this.mComposition;
    }
    updateCropEffect(paramMediaEffectModel.getCropModel());
    updateAEKit(paramMediaEffectModel.getAeKitModel());
    updateStickerEffect(paramMediaEffectModel.getStickerModelList());
    this.mComposition.attachVideoEffectChain(new VideoRenderChainManager.WSVideoEffectContext(this, null));
    return this.mComposition;
  }
  
  public TAVComposition updateVideoRenderChain()
  {
    if (this.mComposition == null)
    {
      com.tencent.tav.decoder.logger.Logger.e(TAG, "updateVideoRenderChain---this mComposition is null.");
      return null;
    }
    if (this.mEffectNodeInterface != null) {
      this.mEffectNodeInterface.insertEffectNode(this, this.mMediaModel.getMediaEffectModel());
    }
    if ((this.mMediaModel == null) || (this.mMediaModel.getMediaEffectModel() == null))
    {
      com.tencent.tav.decoder.logger.Logger.e(TAG, "updateVideoRenderChain---this mMediaEffectModel is null.");
      return this.mComposition;
    }
    updateStickerForTimeLineChanged();
    return updateRenderChain(this.mMediaModel.getMediaEffectModel());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.weseevideo.composition.VideoRenderChainManager
 * JD-Core Version:    0.7.0.1
 */