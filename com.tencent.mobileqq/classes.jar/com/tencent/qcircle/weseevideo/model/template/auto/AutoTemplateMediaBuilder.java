package com.tencent.qcircle.weseevideo.model.template.auto;

import android.content.Context;
import android.graphics.RectF;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import com.tencent.autotemplate.TAVAutomaticTemplate;
import com.tencent.autotemplate.TAVAutomaticTemplateParse;
import com.tencent.autotemplate.TAVRhythmAutomaticTemplate;
import com.tencent.autotemplate.TAVRhythmMovieSegment;
import com.tencent.autotemplate.model.TAVEffectParameter;
import com.tencent.autotemplate.model.TAVLUTAutomaticEffect;
import com.tencent.qcircle.tavcut.TAVCut;
import com.tencent.qcircle.weseevideo.composition.VideoRenderChainConfigure;
import com.tencent.qcircle.weseevideo.composition.VideoRenderChainManager;
import com.tencent.qcircle.weseevideo.composition.VideoRenderChainManager.IStickerContextInterface;
import com.tencent.qcircle.weseevideo.composition.builder.MediaBuilder;
import com.tencent.qcircle.weseevideo.composition.builder.MediaBuilderListener;
import com.tencent.qcircle.weseevideo.composition.builder.MediaBuilderOutput;
import com.tencent.qcircle.weseevideo.composition.interfaces.ITAVCompositionBuilderInterface;
import com.tencent.qcircle.weseevideo.model.MediaModel;
import com.tencent.qcircle.weseevideo.model.ModelExtKt;
import com.tencent.qcircle.weseevideo.model.data.MusicMaterialMetaDataBean;
import com.tencent.qcircle.weseevideo.model.effect.BeautyModel;
import com.tencent.qcircle.weseevideo.model.effect.LutModel;
import com.tencent.qcircle.weseevideo.model.effect.MediaEffectModel;
import com.tencent.qcircle.weseevideo.model.effect.MusicModel;
import com.tencent.qcircle.weseevideo.model.resource.MediaClipModel;
import com.tencent.qcircle.weseevideo.model.resource.MediaResourceModel;
import com.tencent.qcircle.weseevideo.model.resource.VideoResourceModel;
import com.tencent.qcircle.weseevideo.model.template.MediaTemplateModel;
import com.tencent.qcircle.weseevideo.model.template.movie.MovieSegmentModel;
import com.tencent.qcircle.weseevideo.model.utils.FileUtils;
import com.tencent.qcircle.weseevideo.model.utils.ModelAdaptUtils;
import com.tencent.qcircle.weseevideo.model.utils.Utils;
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
import com.tencent.tavsticker.model.TAVSticker;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.libpag.PAGComposition;
import org.libpag.PAGFile;
import org.libpag.PAGLayer;
import org.libpag.PAGRenderer;

public class AutoTemplateMediaBuilder
{
  public static final String TAG = "AutoTemplateMediaBuilder";
  
  @Nullable
  public static void build(@NonNull MediaModel paramMediaModel, Context paramContext, VideoRenderChainManager.IStickerContextInterface paramIStickerContextInterface, @NonNull VideoRenderChainConfigure paramVideoRenderChainConfigure, @NonNull MediaBuilderListener paramMediaBuilderListener)
  {
    if (paramVideoRenderChainConfigure.getRenderSize() == null) {
      paramVideoRenderChainConfigure.setRenderSize(new CGSize(720.0F, 1280.0F));
    }
    paramContext = buildAutomaticTemplate(paramContext, paramMediaModel, paramVideoRenderChainConfigure.getRenderSize());
    if (paramContext == null)
    {
      Logger.e(TAG, "build automaticTemplate failed.");
      if (paramMediaBuilderListener != null) {
        paramMediaBuilderListener.buildCompleted(-200, null, null);
      }
      return;
    }
    TAVComposition localTAVComposition = buildComposition(paramVideoRenderChainConfigure.getApplyType(), paramMediaModel, paramContext, null);
    if (localTAVComposition == null)
    {
      Logger.e(TAG, "build composition failed.");
      if (paramMediaBuilderListener != null) {
        paramMediaBuilderListener.buildCompleted(-201, null, null);
      }
      return;
    }
    AutomaticMediaTemplateModel localAutomaticMediaTemplateModel = paramMediaModel.getMediaTemplateModel().getAutomaticMediaTemplateModel();
    boolean bool = localAutomaticMediaTemplateModel.isSwitchToTemplateByUser();
    paramMediaModel = new VideoRenderChainManager(paramVideoRenderChainConfigure.getApplyType(), localTAVComposition, paramMediaModel, paramIStickerContextInterface, new AutoTemplateMediaBuilder.1(paramContext, localAutomaticMediaTemplateModel, bool, paramMediaModel), paramVideoRenderChainConfigure);
    if (paramMediaBuilderListener != null)
    {
      paramIStickerContextInterface = new MediaBuilderOutput();
      paramIStickerContextInterface.setAutomaticTemplate(paramContext);
      paramMediaBuilderListener.buildCompleted(0, paramMediaModel, paramIStickerContextInterface);
    }
  }
  
  private static TAVAutomaticTemplate buildAutomaticTemplate(Context paramContext, MediaModel paramMediaModel, CGSize paramCGSize)
  {
    if (paramMediaModel == null) {
      return null;
    }
    Object localObject2 = paramMediaModel.getMediaTemplateModel().getAutomaticMediaTemplateModel();
    if (!TextUtils.isEmpty(((AutomaticMediaTemplateModel)localObject2).getTemplateDir())) {
      paramContext = TAVAutomaticTemplateParse.parseAutomaticTemplate(paramContext, ((AutomaticMediaTemplateModel)localObject2).getTemplateDir(), ((AutomaticMediaTemplateModel)localObject2).getTemplateFileName());
    } else {
      paramContext = null;
    }
    if (paramContext != null)
    {
      paramContext.setImagePagAssetDir(((AutomaticMediaTemplateModel)localObject2).getImagePagAssetDir());
      ModelExtKt.selectNearRatioPagFile(paramContext, (AutomaticMediaTemplateModel)localObject2, paramMediaModel);
      Object localObject3 = ((AutomaticMediaTemplateModel)localObject2).getAEFrameModel();
      Object localObject1;
      if ((localObject3 != null) && (((AEFrameModel)localObject3).getPagItems().size() > 0))
      {
        localObject1 = ((AEFramePAGItem)((AEFrameModel)localObject3).getPagItems().get(0)).getPagName();
        if (!((AEFrameModel)localObject3).getSelectedPAGName().isEmpty()) {
          localObject1 = ((AEFrameModel)localObject3).getSelectedPAGName();
        }
        localObject3 = new StringBuilder();
        ((StringBuilder)localObject3).append(((AutomaticMediaTemplateModel)localObject2).getTemplateDir());
        ((StringBuilder)localObject3).append("/");
        ((StringBuilder)localObject3).append((String)localObject1);
        localObject1 = PAGFile.Load(((StringBuilder)localObject3).toString());
        if ((localObject1 != null) && (!((AutomaticMediaTemplateModel)localObject2).getTemplateDir().equals(TAVCut.getPlaceHolderTemplatePath())) && (!((AutomaticMediaTemplateModel)localObject2).getAEFrameModel().isEmptyFrame()))
        {
          float f = ((PAGFile)localObject1).width() / ((PAGFile)localObject1).height();
          if (f > paramCGSize.width / paramCGSize.height) {
            paramCGSize.height = (paramCGSize.width / f);
          } else {
            paramCGSize.width = (paramCGSize.height * f);
          }
        }
      }
      paramContext.setRenderSize(paramCGSize);
      paramCGSize = paramMediaModel.getMediaEffectModel().getMusicModel();
      paramContext.setBgmVolume(paramCGSize.getBgmVolume());
      paramContext.setVolume(Utils.getPlayVolume(paramCGSize));
      localObject3 = paramCGSize.getMetaDataBean();
      if ((localObject3 != null) && (FileUtils.exists(((MusicMaterialMetaDataBean)localObject3).path)))
      {
        localObject1 = Utils.getPath((MusicMaterialMetaDataBean)localObject3);
        boolean bool = FileUtils.exists((String)localObject1);
        String str = TAG;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("build template, isRhythmMusic: ");
        localStringBuilder.append(((MusicMaterialMetaDataBean)localObject3).isStuckPoint);
        localStringBuilder.append(", isRhythmFileExist: ");
        localStringBuilder.append(bool);
        localStringBuilder.append(", muiscId: ");
        localStringBuilder.append(((MusicMaterialMetaDataBean)localObject3).id);
        Logger.i(str, localStringBuilder.toString());
        if (((paramContext instanceof TAVRhythmAutomaticTemplate)) && (((MusicMaterialMetaDataBean)localObject3).isStuckPoint) && (bool))
        {
          localObject3 = paramMediaModel.getMediaTemplateModel().getAutomaticMediaTemplateModel().getRhythmSecondEffectIndices();
          int i = ((AutomaticMediaTemplateModel)localObject2).getRandomIndex();
          localObject2 = (TAVRhythmAutomaticTemplate)paramContext;
          ((TAVRhythmAutomaticTemplate)localObject2).parseMusicRhythm(null, (String)localObject1, paramCGSize.getMetaDataBean().path, paramCGSize.getMetaDataBean().startTime, (List)localObject3, i);
          ((TAVRhythmAutomaticTemplate)localObject2).setTransitionEffects(paramMediaModel.getMediaTemplateModel().getAutomaticMediaTemplateModel().getTransitionEffects());
          return paramContext;
        }
        paramContext.configMusic(null, paramCGSize.getMetaDataBean().path, paramCGSize.getMetaDataBean().startTime);
      }
    }
    return paramContext;
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
    Object localObject = paramMediaModel.getMediaResourceModel().getVideos();
    if ((localObject != null) && (((List)localObject).size() != 0))
    {
      if (paramITAVCompositionBuilderInterface != null) {
        return paramITAVCompositionBuilderInterface.buildComposition((List)localObject);
      }
      boolean bool = paramTAVAutomaticTemplate.isRhythmTemplate();
      ArrayList localArrayList = new ArrayList();
      Iterator localIterator = ((List)localObject).iterator();
      while (localIterator.hasNext())
      {
        MediaClipModel localMediaClipModel = (MediaClipModel)localIterator.next();
        if ((localMediaClipModel.getResource().getSelectTimeDuration() != 0L) && (localMediaClipModel != null) && (localMediaClipModel.getResource() != null))
        {
          if ((localMediaClipModel.getResource().getType() != 1) && (localMediaClipModel.getResource().getType() != 3))
          {
            if ((localMediaClipModel.getResource().getType() != 2) && (localMediaClipModel.getResource().getType() != 4))
            {
              paramITAVCompositionBuilderInterface = null;
            }
            else
            {
              localObject = new TAVMovieImageResource(localMediaClipModel.getResource().getPath());
              ((TAVMovieResource)localObject).setTimeRange(new CMTimeRange(new CMTime((float)(localMediaClipModel.getResource().getSourceTimeStart() + localMediaClipModel.getResource().getSelectTimeStart()) / 1000.0F), new CMTime((float)localMediaClipModel.getResource().getSelectTimeDuration() / 1000.0F)));
              ((TAVMovieResource)localObject).setSourceTimeRange(((TAVMovieResource)localObject).getTimeRange());
              ((TAVMovieResource)localObject).setDuration(((TAVMovieResource)localObject).getTimeRange().getDuration());
              ((TAVMovieResource)localObject).setType(TAVMovieResource.TAVResourceType.TAVResourceTypePhoto);
              paramITAVCompositionBuilderInterface = (ITAVCompositionBuilderInterface)localObject;
              if (!bool)
              {
                paramITAVCompositionBuilderInterface = new TAVMovieTimeEffect();
                paramITAVCompositionBuilderInterface.setTimeRange(((TAVMovieResource)localObject).getTimeRange());
                paramITAVCompositionBuilderInterface.setSpeed((float)localMediaClipModel.getResource().getSelectTimeDuration() * 1.0F / (float)localMediaClipModel.getResource().getScaleDuration());
                ((TAVMovieResource)localObject).setTimeEffect(paramITAVCompositionBuilderInterface);
                paramITAVCompositionBuilderInterface = (ITAVCompositionBuilderInterface)localObject;
              }
            }
          }
          else
          {
            localObject = new TAVMovieTrackResource(localMediaClipModel.getResource().getPath());
            ((TAVMovieResource)localObject).setTimeRange(new CMTimeRange(new CMTime((float)(localMediaClipModel.getResource().getSourceTimeStart() + localMediaClipModel.getResource().getSelectTimeStart()) / 1000.0F), new CMTime((float)localMediaClipModel.getResource().getSelectTimeDuration() / 1000.0F)));
            ((TAVMovieResource)localObject).setSourceTimeRange(((TAVMovieResource)localObject).getTimeRange());
            ((TAVMovieResource)localObject).setDuration(((TAVMovieResource)localObject).getTimeRange().getDuration());
            if (localMediaClipModel.getResource().getType() == 1) {
              ((TAVMovieResource)localObject).setType(TAVMovieResource.TAVResourceType.TAVResourceTypeVideo);
            } else if (localMediaClipModel.getResource().getType() == 3) {
              ((TAVMovieResource)localObject).setType(TAVMovieResource.TAVResourceType.TAVResourceTypeAudio);
            }
            paramITAVCompositionBuilderInterface = (ITAVCompositionBuilderInterface)localObject;
            if (!bool)
            {
              paramITAVCompositionBuilderInterface = new TAVMovieTimeEffect();
              paramITAVCompositionBuilderInterface.setTimeRange(((TAVMovieResource)localObject).getTimeRange());
              paramITAVCompositionBuilderInterface.setSpeed((float)localMediaClipModel.getResource().getSelectTimeDuration() * 1.0F / (float)localMediaClipModel.getResource().getScaleDuration());
              ((TAVMovieResource)localObject).setTimeEffect(paramITAVCompositionBuilderInterface);
              paramITAVCompositionBuilderInterface = (ITAVCompositionBuilderInterface)localObject;
            }
          }
          if (paramITAVCompositionBuilderInterface != null)
          {
            localObject = new TAVMovieClip();
            ((TAVMovieClip)localObject).setResource(paramITAVCompositionBuilderInterface);
            if (localMediaClipModel.getVideoConfigurationModel() != null) {
              ((TAVMovieClip)localObject).setVideoConfiguration(ModelAdaptUtils.transformToTAVVideoConfiguration(localMediaClipModel.getVideoConfigurationModel()));
            }
            if (localMediaClipModel.getAudioConfigurationModel() != null) {
              ((TAVMovieClip)localObject).setAudioConfiguration(ModelAdaptUtils.transformToTAVAudioConfiguration(localMediaClipModel.getAudioConfigurationModel()));
            }
            localArrayList.add(localObject);
          }
        }
      }
      if (localArrayList.size() == 0)
      {
        Logger.e(TAG, "this TAVMovieClip list is empty.");
        return null;
      }
      paramITAVCompositionBuilderInterface = new TAVMovie();
      paramITAVCompositionBuilderInterface.setClips(localArrayList);
      paramITAVCompositionBuilderInterface = paramTAVAutomaticTemplate.buildBaseComposition(paramITAVCompositionBuilderInterface);
      if (paramTAVAutomaticTemplate.getMusicResource() != null)
      {
        if ((paramITAVCompositionBuilderInterface.getAudioChannels() != null) && (((List)paramITAVCompositionBuilderInterface.getAudioChannels().get(0)).size() > 0))
        {
          paramTAVAutomaticTemplate = ((List)paramITAVCompositionBuilderInterface.getAudioChannels().get(0)).iterator();
          while (paramTAVAutomaticTemplate.hasNext())
          {
            localObject = (TAVTransitionableAudio)paramTAVAutomaticTemplate.next();
            if ((localObject instanceof TAVClip)) {
              ((TAVTransitionableAudio)localObject).getAudioConfiguration().setVolume(Utils.getPlayVolume(paramMediaModel.getMediaEffectModel().getMusicModel()));
            }
          }
        }
        if (paramMediaModel.getMediaEffectModel().getMusicModel().getBgmVolume() >= 0.0F) {
          paramITAVCompositionBuilderInterface.setAudios(MediaBuilder.getAudioClips(paramITAVCompositionBuilderInterface, paramMediaModel));
        }
      }
      return paramITAVCompositionBuilderInterface;
    }
    Logger.e(TAG, "this MediaResourceModel's videos is empty.");
    return null;
  }
  
  private static TAVComposition buildCompositionFromSegment(int paramInt, @NonNull MediaModel paramMediaModel, @NonNull TAVAutomaticTemplate paramTAVAutomaticTemplate, ITAVCompositionBuilderInterface paramITAVCompositionBuilderInterface)
  {
    if (paramMediaModel.getMediaResourceModel() == null)
    {
      Logger.e(TAG, "this MediaResourceModel is empty.");
      return null;
    }
    paramMediaModel = paramMediaModel.getMediaResourceModel().getVideos();
    if ((paramMediaModel != null) && (paramMediaModel.size() != 0))
    {
      if (paramITAVCompositionBuilderInterface != null) {
        return paramITAVCompositionBuilderInterface.buildComposition(paramMediaModel);
      }
      return null;
    }
    Logger.e(TAG, "this MediaResourceModel's videos is empty.");
    return null;
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
    else if (i == 2)
    {
      localObject = new TAVMovieImageResource(paramVideoResourceModel.getPath());
      ((TAVMovieResource)localObject).setType(TAVMovieResource.TAVResourceType.TAVResourceTypePhoto);
    }
    else
    {
      localObject = null;
    }
    if (localObject == null) {
      return null;
    }
    TAVMovieClip localTAVMovieClip = new TAVMovieClip();
    ((TAVMovieResource)localObject).setTimeRange(new CMTimeRange(new CMTime(paramVideoResourceModel.getSourceTimeStartUs() + paramVideoResourceModel.getSelectTimeStartUs(), 1000000), new CMTime(paramVideoResourceModel.getSelectTimeDurationUs(), 1000000)));
    ((TAVMovieResource)localObject).setSourceTimeRange(new CMTimeRange(new CMTime(paramVideoResourceModel.getSourceTimeStartUs(), 1000000), new CMTime(paramVideoResourceModel.getSourceTimeDurationUs(), 1000000)));
    ((TAVMovieResource)localObject).setDuration(((TAVMovieResource)localObject).getSourceTimeRange().getDuration());
    localTAVMovieClip.setResource((TAVMovieResource)localObject);
    return localTAVMovieClip;
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
  
  private static CGSize getTAVStickerFrameRenderSize(TAVSticker paramTAVSticker)
  {
    PAGRenderer localPAGRenderer = new PAGRenderer();
    localPAGRenderer.setFile(paramTAVSticker.getPagFile());
    paramTAVSticker = localPAGRenderer.getRootComposition().getLayersByName("mid_photo");
    Object localObject2 = null;
    if ((paramTAVSticker != null) && (paramTAVSticker.length > 0)) {
      paramTAVSticker = paramTAVSticker[0];
    } else {
      paramTAVSticker = null;
    }
    Object localObject1 = paramTAVSticker;
    if (paramTAVSticker == null) {
      localObject1 = localPAGRenderer.getRootComposition().getLayerAt(0);
    }
    paramTAVSticker = localObject2;
    if (localObject1 != null) {
      paramTAVSticker = new CGSize(((PAGLayer)localObject1).getBounds().width(), ((PAGLayer)localObject1).getBounds().height());
    }
    return paramTAVSticker;
  }
  
  public static long multiClipsAdjustTimeRange(List<TAVMovieClip> paramList, VideoResourceModel paramVideoResourceModel, TAVMovieClip paramTAVMovieClip, float paramFloat, long paramLong1, long paramLong2, long paramLong3)
  {
    long l3 = paramLong2 - paramLong1;
    long l2 = 0L;
    long l1 = l3;
    if (l3 < 0L) {
      l1 = 0L;
    }
    if (paramVideoResourceModel.getScaleDuration() != 0L) {
      paramFloat = (float)paramVideoResourceModel.getSelectTimeDuration() * paramFloat / (float)paramVideoResourceModel.getScaleDuration();
    }
    if (paramVideoResourceModel.getType() == 1)
    {
      l3 = ((float)(paramVideoResourceModel.getSelectTimeDuration() * 1000L) / paramFloat);
      l2 = l3 - l1;
      if ((l2 > 0L) && (paramLong1 < paramLong3))
      {
        if (paramLong1 + l3 >= paramLong3) {
          l2 = paramLong3 - paramLong1 - l1;
        }
        CMTime localCMTime = new CMTime(l2, 1000000);
        paramTAVMovieClip.getResource().setTimeRange(new CMTimeRange(new CMTime(((float)((paramVideoResourceModel.getSourceTimeStart() + paramVideoResourceModel.getSelectTimeStart()) * 1000L) + (float)l1 * paramFloat) / 1000000.0F), localCMTime.multi(paramFloat)));
        paramList.add(paramTAVMovieClip);
      }
      paramLong1 += l3;
      l1 = l3;
    }
    else if (paramVideoResourceModel.getType() == 2)
    {
      l2 = ((float)(paramVideoResourceModel.getSelectTimeDuration() * 1000L) / paramFloat);
      l3 = l2 - l1;
      if ((l3 > 0L) && (paramLong1 < paramLong3))
      {
        if (paramLong1 + l2 < paramLong3) {
          l1 = l3;
        } else {
          l1 = paramLong3 - paramLong1 - l1;
        }
        paramVideoResourceModel = new CMTime(l1, 1000000);
        paramTAVMovieClip.getResource().setTimeRange(new CMTimeRange(CMTime.CMTimeZero, paramVideoResourceModel.multi(paramFloat)));
        paramList.add(paramTAVMovieClip);
      }
      paramLong1 += l2;
      l1 = l2;
    }
    else
    {
      l1 = l2;
    }
    paramList = TAG;
    paramVideoResourceModel = new StringBuilder();
    paramVideoResourceModel.append("multiClipsAdjustTimeRange: rangeStartUs-");
    paramVideoResourceModel.append(paramLong2);
    paramVideoResourceModel.append(", rangeEndUs-");
    paramVideoResourceModel.append(paramLong3);
    paramVideoResourceModel.append(", speed-");
    paramVideoResourceModel.append(paramFloat);
    paramVideoResourceModel.append(", itemScaleUs-");
    paramVideoResourceModel.append(l1);
    Logger.e(paramList, paramVideoResourceModel.toString());
    return paramLong1;
  }
  
  private static void updateLutModel(@NonNull MediaEffectModel paramMediaEffectModel, @NonNull TAVAutomaticTemplate paramTAVAutomaticTemplate, boolean paramBoolean, CMTime paramCMTime)
  {
    LutModel localLutModel = paramMediaEffectModel.getLutModel();
    TAVLUTAutomaticEffect localTAVLUTAutomaticEffect = paramTAVAutomaticTemplate.getLutEffect();
    CMTimeRange localCMTimeRange = null;
    if (localTAVLUTAutomaticEffect != null)
    {
      paramTAVAutomaticTemplate = localCMTimeRange;
      if (!TextUtils.isEmpty(localTAVLUTAutomaticEffect.fileDir))
      {
        paramTAVAutomaticTemplate = localCMTimeRange;
        if (localTAVLUTAutomaticEffect.parameter != null)
        {
          paramTAVAutomaticTemplate = localCMTimeRange;
          if (!TextUtils.isEmpty(localTAVLUTAutomaticEffect.parameter.filePath))
          {
            paramTAVAutomaticTemplate = new StringBuilder();
            paramTAVAutomaticTemplate.append(localTAVLUTAutomaticEffect.fileDir);
            paramTAVAutomaticTemplate.append(File.separator);
            paramTAVAutomaticTemplate.append(localTAVLUTAutomaticEffect.parameter.filePath);
            paramTAVAutomaticTemplate = paramTAVAutomaticTemplate.toString();
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
    }
    else
    {
      paramMediaEffectModel.setLutModel(null);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.qcircle.weseevideo.model.template.auto.AutoTemplateMediaBuilder
 * JD-Core Version:    0.7.0.1
 */