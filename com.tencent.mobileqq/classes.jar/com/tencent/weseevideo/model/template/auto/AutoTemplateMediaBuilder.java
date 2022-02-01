package com.tencent.weseevideo.model.template.auto;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import com.tencent.autotemplate.TAVAutomaticTemplate;
import com.tencent.autotemplate.TAVAutomaticTemplateParse;
import com.tencent.autotemplate.TAVRhythmAutomaticTemplate;
import com.tencent.autotemplate.TAVRhythmMovieSegment;
import com.tencent.autotemplate.model.TAVEffectParameter;
import com.tencent.autotemplate.model.TAVLUTAutomaticEffect;
import com.tencent.tav.coremedia.CGSize;
import com.tencent.tav.coremedia.CMTime;
import com.tencent.tav.coremedia.CMTimeRange;
import com.tencent.tav.decoder.logger.Logger;
import com.tencent.tavkit.composition.TAVClip;
import com.tencent.tavkit.composition.TAVComposition;
import com.tencent.tavkit.composition.model.TAVAudioConfiguration;
import com.tencent.tavkit.composition.model.TAVTransitionableAudio;
import com.tencent.tavmovie.TAVMovie;
import com.tencent.tavmovie.base.TAVMovieAudioConfiguration;
import com.tencent.tavmovie.base.TAVMovieClip;
import com.tencent.tavmovie.base.TAVMovieTimeEffect;
import com.tencent.tavmovie.resource.TAVMovieImageResource;
import com.tencent.tavmovie.resource.TAVMovieResource;
import com.tencent.tavmovie.resource.TAVMovieResource.TAVResourceType;
import com.tencent.tavmovie.resource.TAVMovieTrackResource;
import com.tencent.weseevideo.composition.VideoRenderChainConfigure;
import com.tencent.weseevideo.composition.VideoRenderChainManager;
import com.tencent.weseevideo.composition.VideoRenderChainManager.IStickerContextInterface;
import com.tencent.weseevideo.composition.builder.MediaBuilder;
import com.tencent.weseevideo.composition.builder.MediaBuilderListener;
import com.tencent.weseevideo.composition.builder.MediaBuilderOutput;
import com.tencent.weseevideo.composition.interfaces.ITAVCompositionBuilderInterface;
import com.tencent.weseevideo.model.MediaModel;
import com.tencent.weseevideo.model.data.MusicMaterialMetaDataBean;
import com.tencent.weseevideo.model.effect.BeautyModel;
import com.tencent.weseevideo.model.effect.LutModel;
import com.tencent.weseevideo.model.effect.MediaEffectModel;
import com.tencent.weseevideo.model.effect.MusicModel;
import com.tencent.weseevideo.model.resource.MediaClipModel;
import com.tencent.weseevideo.model.resource.MediaResourceModel;
import com.tencent.weseevideo.model.resource.VideoResourceModel;
import com.tencent.weseevideo.model.template.MediaTemplateModel;
import com.tencent.weseevideo.model.template.movie.MovieSegmentModel;
import com.tencent.weseevideo.model.utils.FileUtils;
import com.tencent.weseevideo.model.utils.ModelAdaptUtils;
import com.tencent.weseevideo.model.utils.Utils;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class AutoTemplateMediaBuilder
{
  public static final String TAG = AutoTemplateMediaBuilder.class.getSimpleName();
  
  @Nullable
  public static void build(@NonNull MediaModel paramMediaModel, Context paramContext, VideoRenderChainManager.IStickerContextInterface paramIStickerContextInterface, @NonNull VideoRenderChainConfigure paramVideoRenderChainConfigure, @NonNull MediaBuilderListener paramMediaBuilderListener)
  {
    if (paramVideoRenderChainConfigure.getRenderSize() == null)
    {
      if (paramVideoRenderChainConfigure.getApplyType() > 200) {
        paramVideoRenderChainConfigure.setRenderSize(new CGSize(720.0F, 1280.0F));
      }
    }
    else
    {
      paramContext = buildAutomaticTemplate(paramContext, paramMediaModel, paramVideoRenderChainConfigure.getRenderSize());
      if (paramContext != null) {
        break label90;
      }
      Logger.e(TAG, "build automaticTemplate failed.");
      if (paramMediaBuilderListener != null) {
        paramMediaBuilderListener.buildCompleted(-200, null, null);
      }
    }
    label90:
    do
    {
      TAVComposition localTAVComposition;
      do
      {
        return;
        paramVideoRenderChainConfigure.setRenderSize(new CGSize(720.0F, 1280.0F));
        break;
        localTAVComposition = buildComposition(paramVideoRenderChainConfigure.getApplyType(), paramMediaModel, paramContext, null);
        if (localTAVComposition != null) {
          break label133;
        }
        Logger.e(TAG, "build composition failed.");
      } while (paramMediaBuilderListener == null);
      paramMediaBuilderListener.buildCompleted(-201, null, null);
      return;
      boolean bool = paramMediaModel.getMediaTemplateModel().getAutomaticMediaTemplateModel().isSwitchToTemplateByUser();
      paramMediaModel = new VideoRenderChainManager(paramVideoRenderChainConfigure.getApplyType(), localTAVComposition, paramMediaModel, paramIStickerContextInterface, new AutoTemplateMediaBuilder.1(paramContext, bool, paramMediaModel), paramVideoRenderChainConfigure);
      paramMediaModel.setAutomaticTemplate(paramContext);
    } while (paramMediaBuilderListener == null);
    label133:
    paramIStickerContextInterface = new MediaBuilderOutput();
    paramIStickerContextInterface.setAutomaticTemplate(paramContext);
    paramMediaBuilderListener.buildCompleted(0, paramMediaModel, paramIStickerContextInterface);
  }
  
  private static TAVAutomaticTemplate buildAutomaticTemplate(Context paramContext, MediaModel paramMediaModel, CGSize paramCGSize)
  {
    if (paramMediaModel == null) {
      return null;
    }
    AutomaticMediaTemplateModel localAutomaticMediaTemplateModel = paramMediaModel.getMediaTemplateModel().getAutomaticMediaTemplateModel();
    if (!TextUtils.isEmpty(localAutomaticMediaTemplateModel.getTemplateDir())) {}
    for (paramContext = TAVAutomaticTemplateParse.parseAutomaticTemplate(paramContext, localAutomaticMediaTemplateModel.getTemplateDir(), localAutomaticMediaTemplateModel.getTemplateFileName());; paramContext = null)
    {
      if (paramContext != null)
      {
        paramContext.setRenderSize(paramCGSize);
        paramContext.setImagePagAssetDir(localAutomaticMediaTemplateModel.getImagePagAssetDir());
        paramCGSize = paramMediaModel.getMediaEffectModel().getMusicModel();
        paramContext.setBgmVolume(paramCGSize.getBgmVolume());
        paramContext.setVolume(Utils.getPlayVolume(paramCGSize));
        Object localObject = paramCGSize.getMetaDataBean();
        if ((localObject != null) && (FileUtils.exists(((MusicMaterialMetaDataBean)localObject).path)))
        {
          String str = Utils.getPath((MusicMaterialMetaDataBean)localObject);
          boolean bool = FileUtils.exists(str);
          Logger.i(TAG, "build template, isRhythmMusic: " + ((MusicMaterialMetaDataBean)localObject).isStuckPoint + ", isRhythmFileExist: " + bool + ", muiscId: " + ((MusicMaterialMetaDataBean)localObject).id);
          if ((!(paramContext instanceof TAVRhythmAutomaticTemplate)) || (!((MusicMaterialMetaDataBean)localObject).isStuckPoint) || (!bool)) {
            break label258;
          }
          localObject = paramMediaModel.getMediaTemplateModel().getAutomaticMediaTemplateModel().getRhythmSecondEffectIndices();
          int i = localAutomaticMediaTemplateModel.getRandomIndex();
          ((TAVRhythmAutomaticTemplate)paramContext).parseMusicRhythm(null, str, paramCGSize.getMetaDataBean().path, paramCGSize.getMetaDataBean().startTime, (List)localObject, i);
          paramMediaModel = paramMediaModel.getMediaTemplateModel().getAutomaticMediaTemplateModel().getTransitionEffects();
          ((TAVRhythmAutomaticTemplate)paramContext).setTransitionEffects(paramMediaModel);
        }
      }
      for (;;)
      {
        return paramContext;
        label258:
        paramContext.configMusic(null, paramCGSize.getMetaDataBean().path, paramCGSize.getMetaDataBean().startTime);
      }
    }
  }
  
  private static TAVComposition buildComposition(int paramInt, @NonNull MediaModel paramMediaModel, @NonNull TAVAutomaticTemplate paramTAVAutomaticTemplate, ITAVCompositionBuilderInterface paramITAVCompositionBuilderInterface)
  {
    if (paramMediaModel.getMediaTemplateModel().getAutomaticMediaTemplateModel().isContainSegments()) {
      return buildCompositionFromSegment(paramInt, paramMediaModel, paramTAVAutomaticTemplate, paramITAVCompositionBuilderInterface);
    }
    return buildCompositionFromResource(paramInt, paramMediaModel, paramTAVAutomaticTemplate, paramITAVCompositionBuilderInterface);
  }
  
  private static TAVComposition buildCompositionFromResource(int paramInt, @NonNull MediaModel paramMediaModel, @NonNull TAVAutomaticTemplate paramTAVAutomaticTemplate, ITAVCompositionBuilderInterface paramITAVCompositionBuilderInterface)
  {
    if (paramMediaModel.getMediaResourceModel() == null)
    {
      Logger.e(TAG, "this MediaResourceModel is empty.");
      return null;
    }
    Object localObject2 = paramMediaModel.getMediaResourceModel().getVideos();
    if ((localObject2 == null) || (((List)localObject2).size() == 0))
    {
      Logger.e(TAG, "this MediaResourceModel's videos is empty.");
      return null;
    }
    if (paramITAVCompositionBuilderInterface != null) {
      return paramITAVCompositionBuilderInterface.buildComposition((List)localObject2);
    }
    long l = 0L;
    boolean bool = paramTAVAutomaticTemplate.isRhythmTemplate();
    Object localObject1 = new ArrayList();
    localObject2 = ((List)localObject2).iterator();
    label279:
    label825:
    label830:
    label831:
    for (;;)
    {
      MediaClipModel localMediaClipModel;
      Object localObject3;
      if (((Iterator)localObject2).hasNext())
      {
        localMediaClipModel = (MediaClipModel)((Iterator)localObject2).next();
        if ((localMediaClipModel.getResource().getSelectTimeDuration() == 0L) || (localMediaClipModel == null) || (localMediaClipModel.getResource() == null)) {
          continue;
        }
        if ((localMediaClipModel.getResource().getType() == 1) || (localMediaClipModel.getResource().getType() == 3))
        {
          paramITAVCompositionBuilderInterface = new TAVMovieTrackResource(localMediaClipModel.getResource().getPath());
          paramITAVCompositionBuilderInterface.setTimeRange(new CMTimeRange(new CMTime((float)(localMediaClipModel.getResource().getSourceTimeStart() + localMediaClipModel.getResource().getSelectTimeStart()) / 1000.0F), new CMTime((float)localMediaClipModel.getResource().getSelectTimeDuration() / 1000.0F)));
          paramITAVCompositionBuilderInterface.setSourceTimeRange(paramITAVCompositionBuilderInterface.getTimeRange());
          paramITAVCompositionBuilderInterface.setDuration(paramITAVCompositionBuilderInterface.getTimeRange().getDuration());
          if (localMediaClipModel.getResource().getType() == 1)
          {
            paramITAVCompositionBuilderInterface.setType(TAVMovieResource.TAVResourceType.TAVResourceTypeVideo);
            if (bool) {
              break label830;
            }
            localObject3 = new TAVMovieTimeEffect();
            ((TAVMovieTimeEffect)localObject3).setTimeRange(paramITAVCompositionBuilderInterface.getTimeRange());
            ((TAVMovieTimeEffect)localObject3).setSpeed((float)localMediaClipModel.getResource().getSelectTimeDuration() * 1.0F / (float)localMediaClipModel.getResource().getScaleDuration());
            paramITAVCompositionBuilderInterface.setTimeEffect((TAVMovieTimeEffect)localObject3);
          }
        }
      }
      for (;;)
      {
        if (paramITAVCompositionBuilderInterface == null) {
          break label831;
        }
        localObject3 = new TAVMovieClip();
        ((TAVMovieClip)localObject3).setResource(paramITAVCompositionBuilderInterface);
        if (localMediaClipModel.getVideoConfigurationModel() != null) {
          ((TAVMovieClip)localObject3).setVideoConfiguration(ModelAdaptUtils.transformToTAVVideoConfiguration(localMediaClipModel.getVideoConfigurationModel()));
        }
        if (localMediaClipModel.getAudioConfigurationModel() != null) {
          ((TAVMovieClip)localObject3).setAudioConfiguration(ModelAdaptUtils.transformToTAVAudioConfiguration(localMediaClipModel.getAudioConfigurationModel()));
        }
        if (0 != 0)
        {
          l = multiClipsAdjustTimeRange((List)localObject1, localMediaClipModel.getResource(), (TAVMovieClip)localObject3, 1.0F, l, 0L, 0L);
          break;
          if (localMediaClipModel.getResource().getType() != 3) {
            break label279;
          }
          paramITAVCompositionBuilderInterface.setType(TAVMovieResource.TAVResourceType.TAVResourceTypeAudio);
          break label279;
          if ((localMediaClipModel.getResource().getType() != 2) && (localMediaClipModel.getResource().getType() != 4)) {
            break label825;
          }
          paramITAVCompositionBuilderInterface = new TAVMovieImageResource(localMediaClipModel.getResource().getPath());
          paramITAVCompositionBuilderInterface.setTimeRange(new CMTimeRange(new CMTime((float)(localMediaClipModel.getResource().getSourceTimeStart() + localMediaClipModel.getResource().getSelectTimeStart()) / 1000.0F), new CMTime((float)localMediaClipModel.getResource().getSelectTimeDuration() / 1000.0F)));
          paramITAVCompositionBuilderInterface.setSourceTimeRange(paramITAVCompositionBuilderInterface.getTimeRange());
          paramITAVCompositionBuilderInterface.setDuration(paramITAVCompositionBuilderInterface.getTimeRange().getDuration());
          paramITAVCompositionBuilderInterface.setType(TAVMovieResource.TAVResourceType.TAVResourceTypePhoto);
          if (!bool)
          {
            localObject3 = new TAVMovieTimeEffect();
            ((TAVMovieTimeEffect)localObject3).setTimeRange(paramITAVCompositionBuilderInterface.getTimeRange());
            ((TAVMovieTimeEffect)localObject3).setSpeed((float)localMediaClipModel.getResource().getSelectTimeDuration() * 1.0F / (float)localMediaClipModel.getResource().getScaleDuration());
            paramITAVCompositionBuilderInterface.setTimeEffect((TAVMovieTimeEffect)localObject3);
          }
          continue;
        }
        ((List)localObject1).add(localObject3);
        break;
        if (((List)localObject1).size() == 0)
        {
          Logger.e(TAG, "this TAVMovieClip list is empty.");
          return null;
        }
        paramITAVCompositionBuilderInterface = new TAVMovie();
        paramITAVCompositionBuilderInterface.setClips((List)localObject1);
        if (0 != 0) {
          paramITAVCompositionBuilderInterface.setTimeEffects(getSpeedTimeEffect(1.0F, null));
        }
        paramITAVCompositionBuilderInterface = paramTAVAutomaticTemplate.buildBaseComposition(paramITAVCompositionBuilderInterface);
        if (paramTAVAutomaticTemplate.getMusicResource() != null)
        {
          if ((paramITAVCompositionBuilderInterface.getAudioChannels() != null) && (((List)paramITAVCompositionBuilderInterface.getAudioChannels().get(0)).size() > 0))
          {
            paramTAVAutomaticTemplate = ((List)paramITAVCompositionBuilderInterface.getAudioChannels().get(0)).iterator();
            while (paramTAVAutomaticTemplate.hasNext())
            {
              localObject1 = (TAVTransitionableAudio)paramTAVAutomaticTemplate.next();
              if ((localObject1 instanceof TAVClip)) {
                ((TAVTransitionableAudio)localObject1).getAudioConfiguration().setVolume(Utils.getPlayVolume(paramMediaModel.getMediaEffectModel().getMusicModel()));
              }
            }
          }
          if (paramMediaModel.getMediaEffectModel().getMusicModel().getBgmVolume() >= 0.0F) {
            paramITAVCompositionBuilderInterface.setAudios(MediaBuilder.getAudioClips(paramITAVCompositionBuilderInterface, paramMediaModel));
          }
        }
        return paramITAVCompositionBuilderInterface;
        paramITAVCompositionBuilderInterface = null;
      }
    }
  }
  
  private static TAVComposition buildCompositionFromSegment(int paramInt, @NonNull MediaModel paramMediaModel, @NonNull TAVAutomaticTemplate paramTAVAutomaticTemplate, ITAVCompositionBuilderInterface paramITAVCompositionBuilderInterface)
  {
    if (paramMediaModel.getMediaResourceModel() == null) {
      Logger.e(TAG, "this MediaResourceModel is empty.");
    }
    do
    {
      return null;
      paramMediaModel = paramMediaModel.getMediaResourceModel().getVideos();
      if ((paramMediaModel == null) || (paramMediaModel.size() == 0))
      {
        Logger.e(TAG, "this MediaResourceModel's videos is empty.");
        return null;
      }
    } while (paramITAVCompositionBuilderInterface == null);
    return paramITAVCompositionBuilderInterface.buildComposition(paramMediaModel);
  }
  
  private static List<TAVMovieClip> buildMovieClipsFromSegmentModel(@NonNull MediaModel paramMediaModel)
  {
    Object localObject1 = paramMediaModel.getMediaTemplateModel().getAutomaticMediaTemplateModel().getRhythmSegmentModels();
    Object localObject2 = new ArrayList();
    localObject1 = ((List)localObject1).iterator();
    Object localObject3;
    while (((Iterator)localObject1).hasNext())
    {
      localObject3 = (MovieSegmentModel)((Iterator)localObject1).next();
      if ((localObject3 != null) && (!((MovieSegmentModel)localObject3).getVideoResourceModels().isEmpty())) {
        ((List)localObject2).addAll(((MovieSegmentModel)localObject3).getVideoResourceModels());
      }
    }
    localObject1 = new ArrayList();
    localObject2 = ((List)localObject2).iterator();
    while (((Iterator)localObject2).hasNext())
    {
      localObject3 = (VideoResourceModel)((Iterator)localObject2).next();
      if (localObject3 != null)
      {
        localObject3 = generateMovieClip((VideoResourceModel)localObject3);
        if (localObject3 != null)
        {
          TAVMovieAudioConfiguration localTAVMovieAudioConfiguration = new TAVMovieAudioConfiguration();
          localTAVMovieAudioConfiguration.setVolume(Utils.getPlayVolume(paramMediaModel.getMediaEffectModel().getMusicModel()));
          ((TAVMovieClip)localObject3).setAudioConfiguration(localTAVMovieAudioConfiguration);
          ((List)localObject1).add(localObject3);
        }
      }
    }
    return localObject1;
  }
  
  private static List<TAVRhythmMovieSegment> buildRhythmSegmentFromSegmentModel(@NonNull MediaModel paramMediaModel)
  {
    Object localObject = paramMediaModel.getMediaTemplateModel().getAutomaticMediaTemplateModel().getRhythmSegmentModels();
    paramMediaModel = new ArrayList();
    localObject = ((List)localObject).iterator();
    while (((Iterator)localObject).hasNext())
    {
      MovieSegmentModel localMovieSegmentModel = (MovieSegmentModel)((Iterator)localObject).next();
      TAVRhythmMovieSegment localTAVRhythmMovieSegment = new TAVRhythmMovieSegment();
      localTAVRhythmMovieSegment.setTimeRange(localMovieSegmentModel.getTimeRange());
      paramMediaModel.add(localTAVRhythmMovieSegment);
    }
    return paramMediaModel;
  }
  
  private static TAVMovieClip generateMovieClip(@NonNull VideoResourceModel paramVideoResourceModel)
  {
    int i = paramVideoResourceModel.getType();
    Object localObject;
    if (i == 1)
    {
      localObject = new TAVMovieTrackResource(paramVideoResourceModel.getPath());
      ((TAVMovieResource)localObject).setType(TAVMovieResource.TAVResourceType.TAVResourceTypeVideo);
    }
    for (;;)
    {
      if (localObject == null)
      {
        return null;
        if (i == 2)
        {
          localObject = new TAVMovieImageResource(paramVideoResourceModel.getPath());
          ((TAVMovieResource)localObject).setType(TAVMovieResource.TAVResourceType.TAVResourceTypePhoto);
        }
      }
      else
      {
        TAVMovieClip localTAVMovieClip = new TAVMovieClip();
        ((TAVMovieResource)localObject).setTimeRange(new CMTimeRange(new CMTime(paramVideoResourceModel.getSourceTimeStartUs() + paramVideoResourceModel.getSelectTimeStartUs(), 1000000), new CMTime(paramVideoResourceModel.getSelectTimeDurationUs(), 1000000)));
        ((TAVMovieResource)localObject).setSourceTimeRange(new CMTimeRange(new CMTime(paramVideoResourceModel.getSourceTimeStartUs(), 1000000), new CMTime(paramVideoResourceModel.getSourceTimeDurationUs(), 1000000)));
        ((TAVMovieResource)localObject).setDuration(((TAVMovieResource)localObject).getSourceTimeRange().getDuration());
        localTAVMovieClip.setResource((TAVMovieResource)localObject);
        return localTAVMovieClip;
      }
      localObject = null;
    }
  }
  
  private static List<TAVMovieTimeEffect> getSpeedTimeEffect(float paramFloat, CMTimeRange paramCMTimeRange)
  {
    ArrayList localArrayList = new ArrayList();
    TAVMovieTimeEffect localTAVMovieTimeEffect = new TAVMovieTimeEffect();
    localTAVMovieTimeEffect.setSourceTimeRange(paramCMTimeRange);
    localTAVMovieTimeEffect.setTimeRange(paramCMTimeRange);
    localTAVMovieTimeEffect.setLoop(1);
    localTAVMovieTimeEffect.setSpeed(paramFloat);
    localArrayList.add(localTAVMovieTimeEffect);
    return localArrayList;
  }
  
  public static long multiClipsAdjustTimeRange(List<TAVMovieClip> paramList, VideoResourceModel paramVideoResourceModel, TAVMovieClip paramTAVMovieClip, float paramFloat, long paramLong1, long paramLong2, long paramLong3)
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
        break label274;
      }
      l3 = ((float)(paramVideoResourceModel.getSelectTimeDuration() * 1000L) / f);
      l2 = l3 - l1;
      if ((l2 > 0L) && (paramLong1 < paramLong3))
      {
        if (paramLong1 + l3 >= paramLong3) {
          break label261;
        }
        label96:
        CMTime localCMTime = new CMTime(l2, 1000000);
        TAVMovieResource localTAVMovieResource = paramTAVMovieClip.getResource();
        paramFloat = (float)((paramVideoResourceModel.getSourceTimeStart() + paramVideoResourceModel.getSelectTimeStart()) * 1000L);
        localTAVMovieResource.setTimeRange(new CMTimeRange(new CMTime(((float)l1 * f + paramFloat) / 1000000.0F), localCMTime.multi(f)));
        paramList.add(paramTAVMovieClip);
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
      label261:
      l2 = paramLong3 - paramLong1 - l1;
      break label96;
      label274:
      if (paramVideoResourceModel.getType() == 2)
      {
        l2 = ((float)(paramVideoResourceModel.getSelectTimeDuration() * 1000L) / f);
        l3 = l2 - l1;
        if ((l3 > 0L) && (paramLong1 < paramLong3)) {
          if (paramLong1 + l2 >= paramLong3) {
            break label392;
          }
        }
        for (l1 = l3;; l1 = paramLong3 - paramLong1 - l1)
        {
          paramVideoResourceModel = new CMTime(l1, 1000000);
          paramTAVMovieClip.getResource().setTimeRange(new CMTimeRange(CMTime.CMTimeZero, paramVideoResourceModel.multi(f)));
          paramList.add(paramTAVMovieClip);
          paramLong1 += l2;
          l1 = l2;
          break;
        }
      }
      label392:
      l1 = 0L;
    }
  }
  
  private static void updateLutModel(@NonNull MediaEffectModel paramMediaEffectModel, @NonNull TAVAutomaticTemplate paramTAVAutomaticTemplate, boolean paramBoolean, CMTime paramCMTime)
  {
    CMTimeRange localCMTimeRange = null;
    LutModel localLutModel = paramMediaEffectModel.getLutModel();
    TAVLUTAutomaticEffect localTAVLUTAutomaticEffect = paramTAVAutomaticTemplate.getLutEffect();
    if (localTAVLUTAutomaticEffect != null)
    {
      paramTAVAutomaticTemplate = localCMTimeRange;
      if (!TextUtils.isEmpty(localTAVLUTAutomaticEffect.fileDir))
      {
        paramTAVAutomaticTemplate = localCMTimeRange;
        if (localTAVLUTAutomaticEffect.parameter != null)
        {
          paramTAVAutomaticTemplate = localCMTimeRange;
          if (!TextUtils.isEmpty(localTAVLUTAutomaticEffect.parameter.filePath)) {
            paramTAVAutomaticTemplate = localTAVLUTAutomaticEffect.fileDir + File.separator + localTAVLUTAutomaticEffect.parameter.filePath;
          }
        }
      }
      if (!TextUtils.isEmpty(paramTAVAutomaticTemplate))
      {
        localCMTimeRange = localTAVLUTAutomaticEffect.getLutTimeRange((float)(paramCMTime.getTimeUs() / 1000L));
        paramCMTime = localLutModel;
        if (localLutModel == null)
        {
          paramCMTime = new LutModel();
          paramMediaEffectModel.setLutModel(paramCMTime);
        }
        paramCMTime.setLutBitmap(paramTAVAutomaticTemplate);
        paramCMTime.setLutStartTime(localCMTimeRange.getStartUs() / 1000L);
        paramCMTime.setLutDuration(localCMTimeRange.getDurationUs() / 1000L);
        if (paramBoolean)
        {
          paramMediaEffectModel = paramMediaEffectModel.getBeautyModel();
          if (paramMediaEffectModel != null) {
            paramMediaEffectModel.clearFilter();
          }
        }
      }
      return;
    }
    paramMediaEffectModel.setLutModel(null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.weseevideo.model.template.auto.AutoTemplateMediaBuilder
 * JD-Core Version:    0.7.0.1
 */