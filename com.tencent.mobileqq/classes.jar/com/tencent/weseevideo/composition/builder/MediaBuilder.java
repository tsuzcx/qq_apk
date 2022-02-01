package com.tencent.weseevideo.composition.builder;

import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.tencent.tav.asset.URLAsset;
import com.tencent.tav.coremedia.CGSize;
import com.tencent.tav.coremedia.CMTime;
import com.tencent.tav.coremedia.CMTimeRange;
import com.tencent.tav.decoder.logger.Logger;
import com.tencent.tavkit.composition.TAVClip;
import com.tencent.tavkit.composition.TAVComposition;
import com.tencent.tavkit.composition.model.TAVAudioConfiguration;
import com.tencent.tavkit.composition.model.TAVVideoConfiguration;
import com.tencent.tavkit.composition.resource.TAVResource;
import com.tencent.tavkit.utils.CompositionUtils;
import com.tencent.tavmovie.base.TAVMovieAudioConfiguration;
import com.tencent.tavmovie.base.TAVMovieVideoConfiguration;
import com.tencent.weseevideo.composition.VideoRenderChainConfigure;
import com.tencent.weseevideo.composition.VideoRenderChainManager;
import com.tencent.weseevideo.composition.VideoRenderChainManager.IStickerContextInterface;
import com.tencent.weseevideo.composition.interfaces.ITAVCompositionBuilderInterface;
import com.tencent.weseevideo.model.MediaModel;
import com.tencent.weseevideo.model.data.MusicMaterialMetaDataBean;
import com.tencent.weseevideo.model.effect.MediaEffectModel;
import com.tencent.weseevideo.model.effect.MusicModel;
import com.tencent.weseevideo.model.resource.MediaClipModel;
import com.tencent.weseevideo.model.resource.MediaResourceModel;
import com.tencent.weseevideo.model.resource.VideoConfigurationModel;
import com.tencent.weseevideo.model.resource.VideoResourceModel;
import com.tencent.weseevideo.model.utils.ModelAdaptUtils;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

public class MediaBuilder
{
  public static final String TAG = MediaBuilder.class.getSimpleName();
  
  public static void build(@NonNull MediaModel paramMediaModel, VideoRenderChainManager.IStickerContextInterface paramIStickerContextInterface, @NonNull MediaBuilderListener paramMediaBuilderListener, @NonNull VideoRenderChainConfigure paramVideoRenderChainConfigure)
  {
    TAVComposition localTAVComposition = buildComposition(paramVideoRenderChainConfigure.getApplyType(), paramMediaModel, null);
    if (localTAVComposition == null)
    {
      Logger.e(TAG, "VideoRenderChainManager build fail for composition is null.");
      if (paramMediaBuilderListener != null) {
        paramMediaBuilderListener.buildCompleted(-101, null, null);
      }
      return;
    }
    if ((paramVideoRenderChainConfigure.getRenderSize() != null) && (paramVideoRenderChainConfigure.getRenderSize().height > 0.0F) && (paramVideoRenderChainConfigure.getRenderSize().width > 0.0F)) {
      localTAVComposition.setRenderSize(paramVideoRenderChainConfigure.getRenderSize());
    }
    paramMediaBuilderListener.buildCompleted(0, new VideoRenderChainManager(paramVideoRenderChainConfigure.getApplyType(), localTAVComposition, paramMediaModel, paramIStickerContextInterface, null, paramVideoRenderChainConfigure), null);
  }
  
  public static TAVComposition buildComposition(int paramInt, @NonNull MediaModel paramMediaModel, ITAVCompositionBuilderInterface paramITAVCompositionBuilderInterface)
  {
    Object localObject2 = paramMediaModel.getMediaResourceModel().getVideos();
    if (((List)localObject2).size() == 0)
    {
      Logger.e(TAG, "this MediaResourceModel's videos is empty.");
      return null;
    }
    Object localObject1 = new ArrayList();
    if (paramITAVCompositionBuilderInterface != null) {
      return paramITAVCompositionBuilderInterface.buildComposition((List)localObject2);
    }
    paramITAVCompositionBuilderInterface = ((List)localObject2).iterator();
    long l = 0L;
    while (paramITAVCompositionBuilderInterface.hasNext())
    {
      localObject2 = (MediaClipModel)paramITAVCompositionBuilderInterface.next();
      if ((localObject2 != null) && (((MediaClipModel)localObject2).getResource() != null))
      {
        Object localObject3 = ModelAdaptUtils.transformToTAVResource(((MediaClipModel)localObject2).getResource());
        if (localObject3 != null)
        {
          localObject3 = new TAVClip((TAVResource)localObject3);
          if (((MediaClipModel)localObject2).getVideoConfigurationModel() != null)
          {
            TAVVideoConfiguration localTAVVideoConfiguration = ModelAdaptUtils.transformToTAVVideoConfiguration(((MediaClipModel)localObject2).getVideoConfigurationModel()).convertToConfiguration();
            localTAVVideoConfiguration.setPreferRotation(((MediaClipModel)localObject2).getVideoConfigurationModel().getRotate());
            if ((((MediaClipModel)localObject2).getResource().getType() == 1) && (!localTAVVideoConfiguration.frameEnable())) {
              localTAVVideoConfiguration.setFrame(TAVVideoConfiguration.FIX_RENDER_SIZE);
            }
            ((TAVClip)localObject3).setVideoConfiguration(localTAVVideoConfiguration);
          }
          if (((MediaClipModel)localObject2).getAudioConfigurationModel() != null) {
            ((TAVClip)localObject3).setAudioConfiguration(ModelAdaptUtils.transformToTAVAudioConfiguration(((MediaClipModel)localObject2).getAudioConfigurationModel()).convertToConfiguration());
          }
          if (0 != 0) {
            l = multiClipsAdjustTimeRange((List)localObject1, ((MediaClipModel)localObject2).getResource(), (TAVClip)localObject3, 1.0F, l, 0L, 0L);
          } else {
            ((List)localObject1).add(localObject3);
          }
        }
      }
    }
    localObject2 = new ArrayList();
    paramITAVCompositionBuilderInterface = new TAVComposition();
    paramITAVCompositionBuilderInterface.addVideoChannel((List)localObject1);
    paramITAVCompositionBuilderInterface.addAudioChannel((List)localObject1);
    ((List)localObject2).addAll((Collection)localObject1);
    localObject1 = ((List)localObject2).iterator();
    while (((Iterator)localObject1).hasNext()) {
      ((TAVClip)((Iterator)localObject1).next()).getAudioConfiguration().setVolume(getPlayVolume(paramMediaModel.getMediaEffectModel().getMusicModel()));
    }
    if (paramMediaModel.getMediaEffectModel().getMusicModel().getBgmVolume() >= 0.0F) {
      paramITAVCompositionBuilderInterface.setAudios(getAudioClips(paramITAVCompositionBuilderInterface, paramMediaModel));
    }
    return paramITAVCompositionBuilderInterface;
  }
  
  public static ArrayList<TAVClip> getAudioClips(@NonNull TAVComposition paramTAVComposition, @NonNull MediaModel paramMediaModel)
  {
    ArrayList localArrayList = new ArrayList();
    Object localObject2 = paramMediaModel.getMediaEffectModel().getMusicModel();
    Object localObject1 = localObject2;
    if (localObject2 == null)
    {
      localObject1 = new MusicModel();
      paramMediaModel.getMediaEffectModel().setMusicModel((MusicModel)localObject1);
    }
    localObject1 = ((MusicModel)localObject1).getMetaDataBean();
    float f2;
    if ((localObject1 != null) && (paramTAVComposition != null) && (!TextUtils.isEmpty(((MusicMaterialMetaDataBean)localObject1).path)))
    {
      f1 = ((MusicMaterialMetaDataBean)localObject1).startTime;
      f2 = ((MusicMaterialMetaDataBean)localObject1).mTotalTime * 1000;
      if (f2 <= 0.0F) {
        break label213;
      }
    }
    label213:
    for (float f1 = f2 - f1;; f1 = ((MusicMaterialMetaDataBean)localObject1).segDuration)
    {
      f2 = (float)paramTAVComposition.getDuration().getTimeUs() / 1000.0F;
      if ((f2 >= f1) && (f1 > 0.0F)) {
        break;
      }
      paramTAVComposition = paramTAVComposition.getDuration();
      localObject2 = new TAVClip(new URLAsset(((MusicMaterialMetaDataBean)localObject1).path));
      ((TAVClip)localObject2).getAudioConfiguration().setVolume(paramMediaModel.getMediaEffectModel().getMusicModel().getBgmVolume());
      ((TAVClip)localObject2).getResource().setSourceTimeRange(new CMTimeRange(new CMTime(((MusicMaterialMetaDataBean)localObject1).startTime / 1000.0F), paramTAVComposition));
      localArrayList.add(localObject2);
      return localArrayList;
    }
    paramTAVComposition = new TAVClip(new URLAsset(((MusicMaterialMetaDataBean)localObject1).path));
    localObject2 = new CMTime(f1 / 1000.0F);
    int i = 0;
    while (f2 > 0.0F)
    {
      TAVClip localTAVClip = paramTAVComposition.clone();
      localTAVClip.getAudioConfiguration().setVolume(paramMediaModel.getMediaEffectModel().getMusicModel().getBgmVolume());
      localTAVClip.getResource().setSourceTimeRange(new CMTimeRange(new CMTime(((MusicMaterialMetaDataBean)localObject1).startTime / 1000.0F), (CMTime)localObject2));
      localTAVClip.setStartTime(((CMTime)localObject2).multi(i));
      localArrayList.add(localTAVClip);
      f2 -= f1;
      i += 1;
    }
    CompositionUtils.reloadAudioStartTimeWithTransitionableAudio(localArrayList);
    return localArrayList;
  }
  
  private static float getPlayVolume(MusicModel paramMusicModel)
  {
    if (paramMusicModel == null) {
      return 0.0F;
    }
    if ((paramMusicModel.getMetaDataBean() == null) && (!paramMusicModel.isManuallyChangedVolume())) {
      return 1.0F;
    }
    return paramMusicModel.getVolume();
  }
  
  public static long multiClipsAdjustTimeRange(List<TAVClip> paramList, VideoResourceModel paramVideoResourceModel, TAVClip paramTAVClip, float paramFloat, long paramLong1, long paramLong2, long paramLong3)
  {
    long l1;
    float f;
    long l3;
    long l2;
    if (paramLong2 - paramLong1 < 0L)
    {
      l1 = 0L;
      f = paramFloat;
      if (paramVideoResourceModel.getScaleDuration() != 0L) {
        f = (float)paramVideoResourceModel.getSelectTimeDuration() * paramFloat / (float)paramVideoResourceModel.getScaleDuration();
      }
      if (paramVideoResourceModel.getType() != 1) {
        break label283;
      }
      l3 = ((float)(paramVideoResourceModel.getSelectTimeDuration() * 1000L) / f);
      l2 = l3 - l1;
      if ((l2 > 0L) && (paramLong1 < paramLong3))
      {
        if (paramLong1 + l3 >= paramLong3) {
          break label270;
        }
        label96:
        CMTime localCMTime = new CMTime(l2, 1000000);
        TAVResource localTAVResource = paramTAVClip.getResource();
        paramFloat = (float)((paramVideoResourceModel.getSourceTimeStart() + paramVideoResourceModel.getSelectTimeStart()) * 1000L);
        localTAVResource.setSourceTimeRange(new CMTimeRange(new CMTime(((float)l1 * f + paramFloat) / 1000000.0F), localCMTime.multi(f)));
        paramTAVClip.getResource().setScaledDuration(localCMTime);
        paramList.add(paramTAVClip);
      }
      paramLong1 += l3;
      l1 = l3;
    }
    for (;;)
    {
      Logger.e(TAG, "multiClipsAdjustTimeRange: rangeStartUs-" + paramLong2 + ", rangeEndUs-" + paramLong3 + ", speed-" + f + ", itemScaleUs-" + l1);
      return paramLong1;
      l1 = paramLong2 - paramLong1;
      break;
      label270:
      l2 = paramLong3 - paramLong1 - l1;
      break label96;
      label283:
      if ((paramVideoResourceModel.getType() == 2) || (paramVideoResourceModel.getType() == 4))
      {
        l2 = ((float)(paramVideoResourceModel.getSelectTimeDuration() * 1000L) / f);
        l3 = l2 - l1;
        if ((l3 > 0L) && (paramLong1 < paramLong3)) {
          if (paramLong1 + l2 >= paramLong3) {
            break label404;
          }
        }
        for (l1 = l3;; l1 = paramLong3 - paramLong1 - l1)
        {
          paramVideoResourceModel = new CMTime(l1, 1000000);
          paramTAVClip.setDuration(paramVideoResourceModel.multi(f));
          paramTAVClip.getResource().setScaledDuration(paramVideoResourceModel);
          paramList.add(paramTAVClip);
          paramLong1 += l2;
          l1 = l2;
          break;
        }
      }
      label404:
      l1 = 0L;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.weseevideo.composition.builder.MediaBuilder
 * JD-Core Version:    0.7.0.1
 */