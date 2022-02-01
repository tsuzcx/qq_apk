package com.tencent.weseevideo.model.template.auto;

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
import com.tencent.tavkit.composition.TAVComposition;
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
  public static void build(@NonNull MediaModel paramMediaModel, VideoRenderChainManager.IStickerContextInterface paramIStickerContextInterface, @NonNull VideoRenderChainConfigure paramVideoRenderChainConfigure, @NonNull MediaBuilderListener paramMediaBuilderListener)
  {
    TAVAutomaticTemplate localTAVAutomaticTemplate;
    if (paramVideoRenderChainConfigure.getRenderSize() == null)
    {
      if (paramVideoRenderChainConfigure.getApplyType() > 200) {
        paramVideoRenderChainConfigure.setRenderSize(new CGSize(720.0F, 1280.0F));
      }
    }
    else
    {
      localTAVAutomaticTemplate = buildAutomaticTemplate(paramMediaModel, paramVideoRenderChainConfigure.getRenderSize());
      if (localTAVAutomaticTemplate != null) {
        break label89;
      }
      Logger.e(TAG, "build automaticTemplate failed.");
      if (paramMediaBuilderListener != null) {
        paramMediaBuilderListener.buildCompleted(-200, null, null);
      }
    }
    label89:
    do
    {
      TAVComposition localTAVComposition;
      do
      {
        return;
        paramVideoRenderChainConfigure.setRenderSize(new CGSize(720.0F, 1280.0F));
        break;
        localTAVComposition = buildComposition(paramVideoRenderChainConfigure.getApplyType(), paramMediaModel, localTAVAutomaticTemplate, null);
        if (localTAVComposition != null) {
          break label131;
        }
        Logger.e(TAG, "build composition failed.");
      } while (paramMediaBuilderListener == null);
      paramMediaBuilderListener.buildCompleted(-201, null, null);
      return;
      boolean bool = paramMediaModel.getMediaTemplateModel().getAutomaticMediaTemplateModel().isSwitchToTemplateByUser();
      paramMediaModel = new VideoRenderChainManager(paramVideoRenderChainConfigure.getApplyType(), localTAVComposition, paramMediaModel, paramIStickerContextInterface, new AutoTemplateMediaBuilder.1(localTAVAutomaticTemplate, bool, paramMediaModel), paramVideoRenderChainConfigure);
      paramMediaModel.setAutomaticTemplate(localTAVAutomaticTemplate);
    } while (paramMediaBuilderListener == null);
    label131:
    paramIStickerContextInterface = new MediaBuilderOutput();
    paramIStickerContextInterface.setAutomaticTemplate(localTAVAutomaticTemplate);
    paramMediaBuilderListener.buildCompleted(0, paramMediaModel, paramIStickerContextInterface);
  }
  
  private static TAVAutomaticTemplate buildAutomaticTemplate(@NonNull MediaModel paramMediaModel, CGSize paramCGSize)
  {
    AutomaticMediaTemplateModel localAutomaticMediaTemplateModel = paramMediaModel.getMediaTemplateModel().getAutomaticMediaTemplateModel();
    if ((localAutomaticMediaTemplateModel != null) && (!TextUtils.isEmpty(localAutomaticMediaTemplateModel.getTemplateDir()))) {}
    for (TAVAutomaticTemplate localTAVAutomaticTemplate = TAVAutomaticTemplateParse.parseAutomaticTemplate(localAutomaticMediaTemplateModel.getTemplateDir(), localAutomaticMediaTemplateModel.getTemplateFileName());; localTAVAutomaticTemplate = null)
    {
      if (localTAVAutomaticTemplate != null)
      {
        localTAVAutomaticTemplate.setRenderSize(paramCGSize);
        localTAVAutomaticTemplate.setImagePagAssetDir(localAutomaticMediaTemplateModel.getImagePagAssetDir());
        paramCGSize = paramMediaModel.getMediaEffectModel().getMusicModel();
        if (paramCGSize != null)
        {
          localTAVAutomaticTemplate.setBgmVolume(paramCGSize.getBgmVolume());
          localTAVAutomaticTemplate.setVolume(Utils.getPlayVolume(paramCGSize));
          Object localObject = paramCGSize.getMetaDataBean();
          if ((localObject != null) && (FileUtils.exists(((MusicMaterialMetaDataBean)localObject).path)))
          {
            String str = Utils.getPath((MusicMaterialMetaDataBean)localObject);
            boolean bool = FileUtils.exists(str);
            Logger.i(TAG, "build template, isRhythmMusic: " + ((MusicMaterialMetaDataBean)localObject).isStuckPoint + ", isRhythmFileExist: " + bool + ", muiscId: " + ((MusicMaterialMetaDataBean)localObject).id, new Object[0]);
            if ((!(localTAVAutomaticTemplate instanceof TAVRhythmAutomaticTemplate)) || (!((MusicMaterialMetaDataBean)localObject).isStuckPoint) || (!bool)) {
              break label271;
            }
            localObject = paramMediaModel.getMediaTemplateModel().getAutomaticMediaTemplateModel().getRhythmSecondEffectIndices();
            int i = localAutomaticMediaTemplateModel.getRandomIndex();
            ((TAVRhythmAutomaticTemplate)localTAVAutomaticTemplate).parseMusicRhythm(null, str, paramCGSize.getMetaDataBean().path, paramCGSize.getMetaDataBean().startTime, (List)localObject, i);
            paramMediaModel = paramMediaModel.getMediaTemplateModel().getAutomaticMediaTemplateModel().getTransitionEffects();
            ((TAVRhythmAutomaticTemplate)localTAVAutomaticTemplate).setTransitionEffects(paramMediaModel);
          }
        }
      }
      return localTAVAutomaticTemplate;
      label271:
      localTAVAutomaticTemplate.configMusic(null, paramCGSize.getMetaDataBean().path, paramCGSize.getMetaDataBean().startTime);
      return localTAVAutomaticTemplate;
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
    paramMediaModel = paramMediaModel.getMediaResourceModel().getVideos();
    if ((paramMediaModel == null) || (paramMediaModel.size() == 0))
    {
      Logger.e(TAG, "this MediaResourceModel's videos is empty.");
      return null;
    }
    if (paramITAVCompositionBuilderInterface != null) {
      return paramITAVCompositionBuilderInterface.buildComposition(paramMediaModel);
    }
    long l = 0L;
    boolean bool = paramTAVAutomaticTemplate.isRhythmTemplate();
    paramITAVCompositionBuilderInterface = new ArrayList();
    Iterator localIterator = paramMediaModel.iterator();
    label273:
    label684:
    label689:
    label690:
    for (;;)
    {
      MediaClipModel localMediaClipModel;
      Object localObject;
      if (localIterator.hasNext())
      {
        localMediaClipModel = (MediaClipModel)localIterator.next();
        if ((localMediaClipModel.getResource().getSelectTimeDuration() == 0L) || (localMediaClipModel == null) || (localMediaClipModel.getResource() == null)) {
          continue;
        }
        if ((localMediaClipModel.getResource().getType() == 1) || (localMediaClipModel.getResource().getType() == 3))
        {
          paramMediaModel = new TAVMovieTrackResource(localMediaClipModel.getResource().getPath());
          paramMediaModel.setTimeRange(new CMTimeRange(new CMTime((float)(localMediaClipModel.getResource().getSourceTimeStart() + localMediaClipModel.getResource().getSelectTimeStart()) / 1000.0F), new CMTime((float)localMediaClipModel.getResource().getSelectTimeDuration() / 1000.0F)));
          paramMediaModel.setSourceTimeRange(paramMediaModel.getTimeRange());
          paramMediaModel.setDuration(paramMediaModel.getTimeRange().getDuration());
          if (localMediaClipModel.getResource().getType() == 1)
          {
            paramMediaModel.setType(TAVMovieResource.TAVResourceType.TAVResourceTypeVideo);
            if (bool) {
              break label689;
            }
            localObject = new TAVMovieTimeEffect();
            ((TAVMovieTimeEffect)localObject).setTimeRange(paramMediaModel.getTimeRange());
            ((TAVMovieTimeEffect)localObject).setSpeed((float)localMediaClipModel.getResource().getSelectTimeDuration() * 1.0F / (float)localMediaClipModel.getResource().getScaleDuration());
            paramMediaModel.setTimeEffect((TAVMovieTimeEffect)localObject);
          }
        }
      }
      for (;;)
      {
        if (paramMediaModel == null) {
          break label690;
        }
        localObject = new TAVMovieClip();
        ((TAVMovieClip)localObject).setResource(paramMediaModel);
        if (localMediaClipModel.getVideoConfigurationModel() != null) {
          ((TAVMovieClip)localObject).setVideoConfiguration(ModelAdaptUtils.transformToTAVVideoConfiguration(localMediaClipModel.getVideoConfigurationModel()));
        }
        if (localMediaClipModel.getAudioConfigurationModel() != null) {
          ((TAVMovieClip)localObject).setAudioConfiguration(ModelAdaptUtils.transformToTAVAudioConfiguration(localMediaClipModel.getAudioConfigurationModel()));
        }
        if (0 != 0)
        {
          l = multiClipsAdjustTimeRange(paramITAVCompositionBuilderInterface, localMediaClipModel.getResource(), (TAVMovieClip)localObject, 1.0F, l, 0L, 0L);
          break;
          if (localMediaClipModel.getResource().getType() != 3) {
            break label273;
          }
          paramMediaModel.setType(TAVMovieResource.TAVResourceType.TAVResourceTypeAudio);
          break label273;
          if ((localMediaClipModel.getResource().getType() != 2) && (localMediaClipModel.getResource().getType() != 4)) {
            break label684;
          }
          paramMediaModel = new TAVMovieImageResource(localMediaClipModel.getResource().getPath());
          paramMediaModel.setTimeRange(new CMTimeRange(new CMTime((float)(localMediaClipModel.getResource().getSourceTimeStart() + localMediaClipModel.getResource().getSelectTimeStart()) / 1000.0F), new CMTime((float)localMediaClipModel.getResource().getSelectTimeDuration() / 1000.0F)));
          paramMediaModel.setSourceTimeRange(paramMediaModel.getTimeRange());
          paramMediaModel.setDuration(paramMediaModel.getTimeRange().getDuration());
          paramMediaModel.setType(TAVMovieResource.TAVResourceType.TAVResourceTypePhoto);
          if (!bool)
          {
            localObject = new TAVMovieTimeEffect();
            ((TAVMovieTimeEffect)localObject).setTimeRange(paramMediaModel.getTimeRange());
            ((TAVMovieTimeEffect)localObject).setSpeed((float)localMediaClipModel.getResource().getSelectTimeDuration() * 1.0F / (float)localMediaClipModel.getResource().getScaleDuration());
            paramMediaModel.setTimeEffect((TAVMovieTimeEffect)localObject);
          }
          continue;
        }
        paramITAVCompositionBuilderInterface.add(localObject);
        break;
        if (paramITAVCompositionBuilderInterface.size() == 0)
        {
          Logger.e(TAG, "this TAVMovieClip list is empty.");
          return null;
        }
        paramMediaModel = new TAVMovie();
        paramMediaModel.setClips(paramITAVCompositionBuilderInterface);
        if (0 != 0) {
          paramMediaModel.setTimeEffects(getSpeedTimeEffect(1.0F, null));
        }
        return paramTAVAutomaticTemplate.buildBaseComposition(paramMediaModel);
        paramMediaModel = null;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.weseevideo.model.template.auto.AutoTemplateMediaBuilder
 * JD-Core Version:    0.7.0.1
 */