package com.tencent.weseevideo.model.template.movie;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import com.tencent.tav.coremedia.CMTime;
import com.tencent.tav.coremedia.CMTimeRange;
import com.tencent.tav.coremedia.TimeUtil;
import com.tencent.tav.decoder.logger.Logger;
import com.tencent.tavkit.composition.TAVComposition;
import com.tencent.tavmovie.TAVMovie;
import com.tencent.tavmovie.base.TAVMovieAudioConfiguration;
import com.tencent.tavmovie.base.TAVMovieClip;
import com.tencent.tavmovie.base.TAVMovieVideoConfiguration;
import com.tencent.tavmovie.resource.TAVMovieImageResource;
import com.tencent.tavmovie.resource.TAVMovieResource;
import com.tencent.tavmovie.resource.TAVMovieResource.TAVResourceType;
import com.tencent.tavmovie.resource.TAVMovieTrackResource;
import com.tencent.tavsticker.utils.CollectionUtil;
import com.tencent.weseevideo.composition.VideoRenderChainConfigure;
import com.tencent.weseevideo.composition.VideoRenderChainManager;
import com.tencent.weseevideo.composition.VideoRenderChainManager.IStickerContextInterface;
import com.tencent.weseevideo.composition.builder.MediaBuilderListener;
import com.tencent.weseevideo.composition.builder.MediaBuilderOutput;
import com.tencent.weseevideo.model.MediaModel;
import com.tencent.weseevideo.model.data.MusicMaterialMetaDataBean;
import com.tencent.weseevideo.model.effect.MediaEffectModel;
import com.tencent.weseevideo.model.effect.MusicModel;
import com.tencent.weseevideo.model.resource.MediaClipModel;
import com.tencent.weseevideo.model.resource.MediaResourceModel;
import com.tencent.weseevideo.model.resource.VideoConfigurationModel;
import com.tencent.weseevideo.model.resource.VideoResourceModel;
import com.tencent.weseevideo.model.template.MediaTemplateModel;
import com.tencent.weseevideo.model.utils.FileUtils;
import com.tencent.weseevideo.model.utils.Utils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class MovieTemplateMediaBuilder
{
  public static final String TAG = "MovieTemplateMediaBuilder";
  
  public static void build(@NonNull MediaModel paramMediaModel, VideoRenderChainManager.IStickerContextInterface paramIStickerContextInterface, @NonNull MediaBuilderListener paramMediaBuilderListener, VideoRenderChainConfigure paramVideoRenderChainConfigure)
  {
    Object localObject1 = paramMediaModel.getMediaTemplateModel().getMovieMediaTemplateModel();
    if (((MovieMediaTemplateModel)localObject1).isEmpty())
    {
      paramMediaBuilderListener.buildCompleted(-303, null, null);
      Logger.e("MovieTemplateMediaBuilder", "MovieMediaTemplateModel is empty.");
    }
    Object localObject2 = FileUtils.getFilePathBySuffix(((MovieMediaTemplateModel)localObject1).getFilePath(), ".pag");
    if ((TextUtils.isEmpty((CharSequence)localObject2)) || (!FileUtils.exists((String)localObject2)))
    {
      paramMediaBuilderListener.buildCompleted(-300, null, null);
      Logger.e("MovieTemplateMediaBuilder", "templatePAGPath is null or template file is not exist");
    }
    localObject1 = new MovieTemplate((String)localObject2, ((MovieMediaTemplateModel)localObject1).isAsset());
    localObject2 = buildCompositionAsync(paramMediaModel, (MovieTemplate)localObject1);
    if (localObject2 == null)
    {
      paramMediaBuilderListener.buildCompleted(-301, null, null);
      return;
    }
    paramMediaModel = createVideoRenderChainManager(paramVideoRenderChainConfigure.getApplyType(), (TAVComposition)localObject2, paramMediaModel, paramIStickerContextInterface, paramVideoRenderChainConfigure, (MovieTemplate)localObject1);
    paramIStickerContextInterface = new MediaBuilderOutput();
    paramIStickerContextInterface.setMovieTemplate((MovieTemplate)localObject1);
    paramMediaBuilderListener.buildCompleted(0, paramMediaModel, paramIStickerContextInterface);
  }
  
  private static TAVComposition buildCompositionAsync(@NonNull MediaModel paramMediaModel, @NonNull MovieTemplate paramMovieTemplate)
  {
    if (CollectionUtil.isEmptyList(paramMovieTemplate.getSegments()))
    {
      Logger.e("MovieTemplateMediaBuilder", "MovieTemplate segments is empty.");
      return null;
    }
    Object localObject;
    if (paramMediaModel.getMediaTemplateModel().getMovieMediaTemplateModel().isContainSegments())
    {
      localObject = getClipsFromDraft(paramMediaModel);
      paramMovieTemplate.setFirstFill(false);
    }
    else
    {
      localObject = getClipsFromSource(paramMediaModel, paramMovieTemplate);
      paramMovieTemplate.setFirstFill(true);
    }
    if (CollectionUtil.isEmptyList((List)localObject))
    {
      Logger.e("MovieTemplateMediaBuilder", "MediaResourceModel build MovieClips is empty.");
      return null;
    }
    TAVMovie localTAVMovie = new TAVMovie();
    localTAVMovie.setClips((List)localObject);
    localTAVMovie.setMovieTemplate(paramMovieTemplate);
    localTAVMovie.setRenderSize(paramMovieTemplate.getRenderSize());
    paramMovieTemplate = generateBGMClip(paramMediaModel, paramMovieTemplate);
    paramMediaModel = localTAVMovie.convertToComposition();
    if (paramMovieTemplate != null)
    {
      paramMovieTemplate = paramMovieTemplate.convertToClip();
      if (paramMovieTemplate != null)
      {
        localObject = new ArrayList();
        ((List)localObject).add(paramMovieTemplate);
        paramMediaModel.setAudios((List)localObject);
      }
    }
    return paramMediaModel;
  }
  
  private static VideoRenderChainManager createVideoRenderChainManager(int paramInt, @NonNull TAVComposition paramTAVComposition, @NonNull MediaModel paramMediaModel, VideoRenderChainManager.IStickerContextInterface paramIStickerContextInterface, VideoRenderChainConfigure paramVideoRenderChainConfigure, MovieTemplate paramMovieTemplate)
  {
    return new VideoRenderChainManager(paramInt, paramTAVComposition, paramMediaModel, paramIStickerContextInterface, new MovieTemplateMediaBuilder.1(paramMovieTemplate), paramVideoRenderChainConfigure);
  }
  
  @Nullable
  private static TAVMovieClip generateBGMClip(@NonNull MediaModel paramMediaModel, @NonNull MovieTemplate paramMovieTemplate)
  {
    paramMovieTemplate.getBackgroundMusic();
    paramMovieTemplate = paramMediaModel.getMediaEffectModel().getMusicModel();
    Object localObject1 = paramMovieTemplate.getMetaDataBean();
    paramMediaModel = null;
    if (localObject1 == null) {
      return null;
    }
    Object localObject2 = ((MusicMaterialMetaDataBean)localObject1).path;
    if (!TextUtils.isEmpty((CharSequence)localObject2))
    {
      if (!FileUtils.exists((String)localObject2)) {
        return null;
      }
      paramMediaModel = new TAVMovieClip();
      localObject2 = new TAVMovieTrackResource((String)localObject2);
      ((TAVMovieTrackResource)localObject2).setType(TAVMovieResource.TAVResourceType.TAVResourceTypeAudio);
      CMTimeRange localCMTimeRange = ((TAVMovieTrackResource)localObject2).getTimeRange();
      localObject1 = new CMTime(((MusicMaterialMetaDataBean)localObject1).startTime / 1000.0F);
      CMTime localCMTime = localCMTimeRange.getDuration().sub((CMTime)localObject1);
      localCMTimeRange.setStart((CMTime)localObject1);
      localCMTimeRange.setDuration(localCMTime);
      ((TAVMovieTrackResource)localObject2).setTimeRange(localCMTimeRange);
      paramMediaModel.setResource((TAVMovieResource)localObject2);
      localObject1 = new TAVMovieAudioConfiguration();
      ((TAVMovieAudioConfiguration)localObject1).setVolume(paramMovieTemplate.getBgmVolume());
      paramMediaModel.setAudioConfiguration((TAVMovieAudioConfiguration)localObject1);
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
    localTAVMovieClip.getVideoConfiguration().setPreferRotation(paramVideoResourceModel.getRotate());
    return localTAVMovieClip;
  }
  
  private static List<TAVMovieClip> getClipsFromDraft(@NonNull MediaModel paramMediaModel)
  {
    Object localObject1 = paramMediaModel.getMediaTemplateModel().getMovieMediaTemplateModel().getMovieSegmentModels();
    Object localObject2 = new ArrayList();
    localObject1 = ((ArrayList)localObject1).iterator();
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
  
  private static List<TAVMovieClip> getClipsFromSource(@NonNull MediaModel paramMediaModel, @NonNull MovieTemplate paramMovieTemplate)
  {
    Object localObject1 = paramMediaModel.getMediaTemplateModel().getMovieMediaTemplateModel().getAiAbilityModel();
    Object localObject2 = paramMediaModel.getMediaResourceModel();
    if (((AIAbilityModel)localObject1).getAiAbilityType() == AIAbilityModel.AIAbilityType.ORDINARY) {
      localObject1 = ((MediaResourceModel)localObject2).getVideos();
    } else {
      localObject1 = ((AIAbilityModel)localObject1).getAfterAiProcessClips();
    }
    if (CollectionUtil.isEmptyList((List)localObject1))
    {
      Logger.e("MovieTemplateMediaBuilder", "MediaResourceModel videos is empty.");
      return null;
    }
    int n = paramMovieTemplate.getSegments().size();
    paramMovieTemplate = new ArrayList();
    localObject1 = ((List)localObject1).iterator();
    int k = 0;
    int i = 1;
    while (((Iterator)localObject1).hasNext())
    {
      Object localObject3 = (MediaClipModel)((Iterator)localObject1).next();
      if (localObject3 != null)
      {
        localObject2 = new TAVMovieClip();
        Object localObject5;
        int m;
        int j;
        if (((MediaClipModel)localObject3).getResource().getType() == 1)
        {
          localObject4 = new TAVMovieTrackResource(((MediaClipModel)localObject3).getResource().getPath());
          ((TAVMovieResource)localObject4).setType(TAVMovieResource.TAVResourceType.TAVResourceTypeVideo);
          localObject5 = new CMTimeRange(new CMTime(((MediaClipModel)localObject3).getResource().getSourceTimeStart(), 1000000), new CMTime(TimeUtil.milli2Us(((MediaClipModel)localObject3).getResource().getSourceTimeDuration()), 1000000));
          CMTimeRange localCMTimeRange = ((CMTimeRange)localObject5).clone();
          localCMTimeRange.setStart(new CMTime(TimeUtil.milli2Us(((MediaClipModel)localObject3).getResource().getSourceTimeStart() + ((MediaClipModel)localObject3).getResource().getSelectTimeStart()), 1000000));
          localCMTimeRange.setDuration(new CMTime(TimeUtil.milli2Us(((MediaClipModel)localObject3).getResource().getSelectTimeDuration()), 1000000));
          ((TAVMovieResource)localObject4).setTimeRange(localCMTimeRange);
          ((TAVMovieResource)localObject4).setSourceTimeRange((CMTimeRange)localObject5);
          ((TAVMovieResource)localObject4).setDuration(((TAVMovieResource)localObject4).getSourceTimeRange().getDuration());
          ((TAVMovieClip)localObject2).setResource((TAVMovieResource)localObject4);
          m = 0;
          j = k;
        }
        else
        {
          j = k;
          m = i;
          if (((MediaClipModel)localObject3).getResource().getType() == 2)
          {
            localObject4 = new TAVMovieImageResource(((MediaClipModel)localObject3).getResource().getPath());
            localObject5 = new CMTime(600000000L, 60);
            ((TAVMovieResource)localObject4).setTimeRange(new CMTimeRange(CMTime.CMTimeZero, (CMTime)localObject5));
            ((TAVMovieResource)localObject4).setSourceTimeRange(((TAVMovieResource)localObject4).getTimeRange());
            ((TAVMovieResource)localObject4).setDuration((CMTime)localObject5);
            ((TAVMovieResource)localObject4).setType(TAVMovieResource.TAVResourceType.TAVResourceTypePhoto);
            ((TAVMovieClip)localObject2).setResource((TAVMovieResource)localObject4);
            k += 1;
            j = k;
            m = i;
            if (k > n)
            {
              j = k;
              m = i;
              if (i != 0)
              {
                paramMediaModel = new StringBuilder();
                paramMediaModel.append("fillData: imageCount ");
                paramMediaModel.append(k);
                Logger.d("MovieTemplateMediaBuilder", paramMediaModel.toString());
                return paramMovieTemplate;
              }
            }
          }
        }
        Object localObject4 = new TAVMovieVideoConfiguration();
        ((TAVMovieVideoConfiguration)localObject4).setPreferRotation(((MediaClipModel)localObject3).getVideoConfigurationModel().getRotate());
        ((TAVMovieClip)localObject2).setVideoConfiguration((TAVMovieVideoConfiguration)localObject4);
        localObject3 = new TAVMovieAudioConfiguration();
        ((TAVMovieAudioConfiguration)localObject3).setVolume(Utils.getPlayVolume(paramMediaModel.getMediaEffectModel().getMusicModel()));
        ((TAVMovieClip)localObject2).setAudioConfiguration((TAVMovieAudioConfiguration)localObject3);
        paramMovieTemplate.add(localObject2);
        k = j;
        i = m;
      }
    }
    return paramMovieTemplate;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.weseevideo.model.template.movie.MovieTemplateMediaBuilder
 * JD-Core Version:    0.7.0.1
 */