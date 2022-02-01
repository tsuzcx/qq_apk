package com.tencent.qcircle.weseevideo.model.template.light;

import android.support.annotation.VisibleForTesting;
import android.text.TextUtils;
import com.tencent.qcircle.tavcut.TAVCut;
import com.tencent.qcircle.tavcut.util.Logger;
import com.tencent.qcircle.weishi.module.publisher.entity.TemplateBean;
import com.tencent.qcircle.weishi.module.publisher.interfaces.XffectsDownloadListener;
import com.tencent.qcircle.weseevideo.composition.VideoRenderChainConfigure;
import com.tencent.qcircle.weseevideo.composition.VideoRenderChainManager;
import com.tencent.qcircle.weseevideo.composition.VideoRenderChainManager.IEffectNodeInterface;
import com.tencent.qcircle.weseevideo.composition.VideoRenderChainManager.IStickerContextInterface;
import com.tencent.qcircle.weseevideo.composition.builder.MediaBuilderListener;
import com.tencent.qcircle.weseevideo.composition.builder.MediaBuilderOutput;
import com.tencent.qcircle.weseevideo.model.MediaModel;
import com.tencent.qcircle.weseevideo.model.data.MusicMaterialMetaDataBean;
import com.tencent.qcircle.weseevideo.model.effect.MediaEffectModel;
import com.tencent.qcircle.weseevideo.model.effect.MusicModel;
import com.tencent.qcircle.weseevideo.model.resource.MediaResourceModel;
import com.tencent.qcircle.weseevideo.model.resource.VideoResourceModel;
import com.tencent.qcircle.weseevideo.model.template.MediaTemplateModel;
import com.tencent.qcircle.weseevideo.model.template.movie.MovieSegmentModel;
import com.tencent.qcircle.weseevideo.model.utils.AudioUtils;
import com.tencent.qcircle.weseevideo.model.utils.MusicMaterialMataDataBeanUtils;
import com.tencent.tav.coremedia.CGSize;
import com.tencent.tav.coremedia.CMTime;
import com.tencent.tav.coremedia.CMTimeRange;
import com.tencent.tav.coremedia.TimeUtil;
import com.tencent.tavkit.composition.TAVClip;
import com.tencent.tavkit.composition.TAVComposition;
import com.tencent.tavkit.composition.resource.TAVEmptyResource;
import com.tencent.tavkit.composition.resource.TAVResource;
import com.tencent.tavsticker.utils.CollectionUtil;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.light.AudioOutputConfig;
import org.light.AudioPlaceHolder;
import org.light.ClipAsset;
import org.light.ClipInfo;
import org.light.ClipPlaceHolder;
import org.light.LightAsset;
import org.light.LightEngine;
import org.light.MovieController;
import org.light.RendererConfig;
import org.light.TextAsset;
import org.light.TimeRange;
import org.light.VideoOutputConfig;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/qcircle/weseevideo/model/template/light/LightTemplateMediaBuilder;", "", "()V", "DEFAULT_FRAME_RATE", "", "DEFAULT_SEEK_TOLERANCE", "", "PLAYING_SEEK_TOLERANCE", "SECONDS_US", "TAG", "", "bindAudioPlaceHolder", "", "editorModel", "Lcom/tencent/qcircle/weseevideo/model/MediaModel;", "lightTemplate", "Lcom/tencent/qcircle/weseevideo/model/template/light/LightTemplate;", "lightTemplateModel", "Lcom/tencent/qcircle/weseevideo/model/template/light/LightMediaTemplateModel;", "composition", "Lcom/tencent/tavkit/composition/TAVComposition;", "changeMusicByUser", "", "build", "model", "renderContextCreator", "Lcom/tencent/qcircle/weseevideo/composition/VideoRenderChainManager$IStickerContextInterface;", "listener", "Lcom/tencent/qcircle/weseevideo/composition/builder/MediaBuilderListener;", "configure", "Lcom/tencent/qcircle/weseevideo/composition/VideoRenderChainConfigure;", "buildComposition", "renderSize", "Lcom/tencent/tav/coremedia/CGSize;", "createVideoRenderChainManager", "Lcom/tencent/qcircle/weseevideo/composition/VideoRenderChainManager;", "applyType", "generateTAVComposition", "durationUs", "", "initBoundsRect", "initLightEngine", "isFullFilled", "cilpInfos", "", "Lorg/light/ClipInfo;", "clipPlaceHolders", "Lorg/light/ClipPlaceHolder;", "lightSegments", "", "Lcom/tencent/qcircle/weseevideo/model/template/movie/MovieSegmentModel;", "([[Lorg/light/ClipInfo;[Lorg/light/ClipPlaceHolder;Ljava/util/List;)Z", "parseSegmentInfo", "replaceLightPresetData", "Ljava/util/HashMap;", "movieController", "Lorg/light/MovieController;", "filePath", "replaceLightTextData", "updateClipPlaceHolderInfo", "updateSegmentCount", "updateSegmentMinDuration", "updateSegmentTimeRange", "clipInfos", "([[Lorg/light/ClipInfo;Ljava/util/List;)V", "updateTemplateDuration", "libtavcut_debug"}, k=1, mv={1, 1, 16})
public final class LightTemplateMediaBuilder
{
  private static final float DEFAULT_FRAME_RATE = 30.0F;
  private static final int DEFAULT_SEEK_TOLERANCE = 0;
  public static final LightTemplateMediaBuilder INSTANCE = new LightTemplateMediaBuilder();
  private static final int PLAYING_SEEK_TOLERANCE = 120000;
  public static final int SECONDS_US = 1000000;
  @NotNull
  public static final String TAG = "LightTemplateMediaBuilder";
  
  private final void bindAudioPlaceHolder(MediaModel paramMediaModel, LightTemplate paramLightTemplate, LightMediaTemplateModel paramLightMediaTemplateModel, TAVComposition paramTAVComposition, boolean paramBoolean)
  {
    if ((paramMediaModel.getMediaEffectModel().getMusicModel().getMetaDataBean() != null) && (paramBoolean)) {
      return;
    }
    paramLightTemplate = paramLightTemplate.getMovieController();
    Intrinsics.checkExpressionValueIsNotNull(paramLightTemplate, "lightTemplate.movieController");
    paramLightTemplate = paramLightTemplate.getAudioPlaceHolders();
    Intrinsics.checkExpressionValueIsNotNull(paramLightTemplate, "audioPlaceHolder");
    int i = paramLightTemplate.length;
    int j = 0;
    if (i == 0) {
      i = 1;
    } else {
      i = 0;
    }
    if (i != 0) {
      return;
    }
    int k = paramLightTemplate.length;
    i = j;
    while (i < k)
    {
      paramTAVComposition = paramLightTemplate[i];
      if (!TextUtils.isEmpty((CharSequence)paramTAVComposition.path))
      {
        MusicMaterialMetaDataBean localMusicMaterialMetaDataBean = new MusicMaterialMetaDataBean(null, 0L, null, null, null, null, 0, 0, null, null, null, null, null, 0, null, 0, null, 0, 0, 0, 0, null, null, 0, 0, 0, 0, 0L, 0, 0, (byte)0, 0, null, null, null, null, null, null, null, null, 0, 0, 0, 0, 0, null, false, 0, 0, null, null, false, null, false, 0L, 0L, 0L, 0L, false, 0L, 0.0F, 0L, null, -1, 2147483647, null);
        paramLightTemplate = paramTAVComposition.musicID;
        Intrinsics.checkExpressionValueIsNotNull(paramLightTemplate, "audio.musicID");
        localMusicMaterialMetaDataBean.id = paramLightTemplate;
        localMusicMaterialMetaDataBean.path = paramTAVComposition.path;
        paramLightTemplate = paramLightMediaTemplateModel.getTemplateBean();
        if (paramLightTemplate != null) {
          paramLightTemplate = paramLightTemplate.templateName;
        } else {
          paramLightTemplate = null;
        }
        localMusicMaterialMetaDataBean.name = paramLightTemplate;
        localMusicMaterialMetaDataBean.startTime = ((int)TimeUtil.us2Milli(paramTAVComposition.startOffset));
        localMusicMaterialMetaDataBean.mTotalTimeMs = AudioUtils.getDuration(paramTAVComposition.path);
        MusicMaterialMataDataBeanUtils.setStartInTime(localMusicMaterialMetaDataBean, TimeUtil.us2Milli(paramTAVComposition.fadeInDuration));
        MusicMaterialMataDataBeanUtils.setEndOutTime(localMusicMaterialMetaDataBean, TimeUtil.us2Milli(paramTAVComposition.fadeOutDuration));
        paramMediaModel.getMediaEffectModel().getMusicModel().setMetaDataBean(localMusicMaterialMetaDataBean);
        paramMediaModel.getMediaEffectModel().getMusicModel().setBgmVolume(paramTAVComposition.volume);
        return;
      }
      i += 1;
    }
  }
  
  @JvmStatic
  public static final void build(@NotNull MediaModel paramMediaModel, @Nullable VideoRenderChainManager.IStickerContextInterface paramIStickerContextInterface, @NotNull MediaBuilderListener paramMediaBuilderListener, @NotNull VideoRenderChainConfigure paramVideoRenderChainConfigure, boolean paramBoolean)
  {
    Intrinsics.checkParameterIsNotNull(paramMediaModel, "model");
    Intrinsics.checkParameterIsNotNull(paramMediaBuilderListener, "listener");
    Intrinsics.checkParameterIsNotNull(paramVideoRenderChainConfigure, "configure");
    Object localObject1 = paramMediaModel.getMediaTemplateModel();
    Object localObject2 = ((MediaTemplateModel)localObject1).getLightMediaTemplateModel();
    if (((LightMediaTemplateModel)localObject2).isEmpty())
    {
      paramMediaBuilderListener.buildCompleted(-304, null, null);
      Logger.e("LightTemplateMediaBuilder", "LightMediaTemplateModel is empty. template path is null or template file is not exist");
      return;
    }
    if (((MediaTemplateModel)localObject1).getOriginMediaResourceModel() == null) {
      ((MediaTemplateModel)localObject1).setOriginMediaResourceModel(paramMediaModel.getMediaResourceModel().deepCopy());
    }
    localObject1 = ((LightMediaTemplateModel)localObject2).getFilePath();
    if (localObject1 == null) {
      localObject1 = "";
    }
    localObject2 = new LightTemplate((String)localObject1);
    if (paramVideoRenderChainConfigure.getRenderSize() != null) {
      localObject1 = paramVideoRenderChainConfigure.getRenderSize();
    } else {
      localObject1 = ((LightTemplate)localObject2).getRenderSize();
    }
    LightTemplateMediaBuilder localLightTemplateMediaBuilder = INSTANCE;
    Intrinsics.checkExpressionValueIsNotNull(localObject1, "renderSize");
    localObject1 = localLightTemplateMediaBuilder.buildComposition(paramMediaModel, (LightTemplate)localObject2, (CGSize)localObject1, paramVideoRenderChainConfigure, paramBoolean);
    if (localObject1 == null)
    {
      paramMediaBuilderListener.buildCompleted(-306, null, null);
      return;
    }
    paramMediaModel = INSTANCE.createVideoRenderChainManager(paramVideoRenderChainConfigure.getApplyType(), (TAVComposition)localObject1, paramMediaModel, paramIStickerContextInterface, paramVideoRenderChainConfigure, (LightTemplate)localObject2);
    paramIStickerContextInterface = new MediaBuilderOutput();
    paramIStickerContextInterface.setLightTemplate((LightTemplate)localObject2);
    paramMediaBuilderListener.buildCompleted(0, paramMediaModel, paramIStickerContextInterface);
  }
  
  private final VideoRenderChainManager createVideoRenderChainManager(int paramInt, TAVComposition paramTAVComposition, MediaModel paramMediaModel, VideoRenderChainManager.IStickerContextInterface paramIStickerContextInterface, VideoRenderChainConfigure paramVideoRenderChainConfigure, LightTemplate paramLightTemplate)
  {
    return new VideoRenderChainManager(paramInt, paramTAVComposition, paramMediaModel, paramIStickerContextInterface, (VideoRenderChainManager.IEffectNodeInterface)new LightTemplateMediaBuilder.createVideoRenderChainManager.1(paramLightTemplate, paramMediaModel, paramTAVComposition), paramVideoRenderChainConfigure);
  }
  
  private final void initBoundsRect(LightTemplate paramLightTemplate)
  {
    paramLightTemplate.getBoundsRect().clear();
    Object localObject = paramLightTemplate.getLightAsset();
    Intrinsics.checkExpressionValueIsNotNull(localObject, "lightTemplate.lightAsset");
    localObject = ((LightAsset)localObject).getBoundsTrackerPlaceHolders();
    int j = localObject.length;
    int i = 0;
    while (i < j)
    {
      String str = localObject[i];
      HashMap localHashMap = paramLightTemplate.getBoundsRect();
      Intrinsics.checkExpressionValueIsNotNull(localHashMap, "lightTemplate.boundsRect");
      ((Map)localHashMap).put(str, paramLightTemplate.getMovieController().getBoundsByKey(str));
      i += 1;
    }
  }
  
  private final boolean initLightEngine(VideoRenderChainConfigure paramVideoRenderChainConfigure, LightTemplate paramLightTemplate)
  {
    int i;
    if (paramVideoRenderChainConfigure.getApplyType() == 100)
    {
      i = 120000;
      paramVideoRenderChainConfigure = new StringBuilder();
      paramVideoRenderChainConfigure.append("开启LightSDK预解码，seekTolerance：");
      paramVideoRenderChainConfigure.append(120000);
      Logger.i("LightTemplateMediaBuilder", paramVideoRenderChainConfigure.toString());
    }
    else
    {
      i = 0;
    }
    paramVideoRenderChainConfigure = new VideoOutputConfig(30.0F, i);
    AudioOutputConfig localAudioOutputConfig = new AudioOutputConfig();
    localAudioOutputConfig.sampleRate = 44100;
    localAudioOutputConfig.sampleCount = 2048;
    localAudioOutputConfig.channels = 1;
    RendererConfig localRendererConfig = new RendererConfig(TAVCut.getLightBundleResPath());
    localRendererConfig.initMode = 1;
    paramVideoRenderChainConfigure = LightEngine.Make(paramVideoRenderChainConfigure, localAudioOutputConfig, localRendererConfig);
    if (paramVideoRenderChainConfigure != null)
    {
      paramLightTemplate.setLightEngine(paramVideoRenderChainConfigure);
      paramLightTemplate.setMovieController(paramVideoRenderChainConfigure.setAssetForMovie(paramLightTemplate.getLightAsset()));
      return true;
    }
    return false;
  }
  
  @VisibleForTesting
  private final boolean parseSegmentInfo(LightMediaTemplateModel paramLightMediaTemplateModel, LightTemplate paramLightTemplate)
  {
    Object localObject = (Collection)paramLightMediaTemplateModel.getSegmentModels();
    int i;
    if ((localObject != null) && (!((Collection)localObject).isEmpty())) {
      i = 0;
    } else {
      i = 1;
    }
    if (i == 0)
    {
      paramLightTemplate.setSegments(paramLightMediaTemplateModel.getSegmentModels());
      return true;
    }
    if ((paramLightMediaTemplateModel.getClipPlaceHolders() != null) && (paramLightTemplate.isNoDurationLimitTemplate()))
    {
      localObject = LightSegmentHelper.INSTANCE;
      paramLightMediaTemplateModel = paramLightMediaTemplateModel.getClipPlaceHolders();
      if (paramLightMediaTemplateModel != null)
      {
        paramLightMediaTemplateModel = ((Collection)paramLightMediaTemplateModel).toArray(new ClipPlaceHolder[0]);
        if (paramLightMediaTemplateModel != null) {
          paramLightMediaTemplateModel = (ClipPlaceHolder[])paramLightMediaTemplateModel;
        } else {
          throw new TypeCastException("null cannot be cast to non-null type kotlin.Array<T>");
        }
      }
      else
      {
        paramLightMediaTemplateModel = null;
      }
      paramLightTemplate.setSegments(((LightSegmentHelper)localObject).parseLightSegmentInfo(paramLightMediaTemplateModel));
      return false;
    }
    paramLightMediaTemplateModel = LightSegmentHelper.INSTANCE;
    localObject = paramLightTemplate.getMovieController();
    Intrinsics.checkExpressionValueIsNotNull(localObject, "lightTemplate.movieController");
    paramLightTemplate.setSegments(paramLightMediaTemplateModel.parseLightSegmentInfo(((MovieController)localObject).getClipPlaceHolders()));
    return false;
  }
  
  private final void replaceLightTextData(LightMediaTemplateModel paramLightMediaTemplateModel, LightTemplate paramLightTemplate)
  {
    if ((paramLightMediaTemplateModel.getLightStickerTextModels().isEmpty() ^ true))
    {
      paramLightMediaTemplateModel = paramLightMediaTemplateModel.getLightStickerTextModels().entrySet().iterator();
      while (paramLightMediaTemplateModel.hasNext())
      {
        Map.Entry localEntry = (Map.Entry)paramLightMediaTemplateModel.next();
        paramLightTemplate.getMovieController().setTextAsset((String)localEntry.getKey(), new TextAsset(((LightStickerTextModel)localEntry.getValue()).getStickerTextContent(), ((LightStickerTextModel)localEntry.getValue()).getStickerTextColor()));
      }
    }
  }
  
  private final void updateClipPlaceHolderInfo(LightTemplate paramLightTemplate, LightMediaTemplateModel paramLightMediaTemplateModel)
  {
    if ((paramLightTemplate.isNoDurationLimitTemplate()) && (paramLightMediaTemplateModel.getClipPlaceHolders() == null))
    {
      Object localObject1 = paramLightTemplate.getLightSegments();
      Intrinsics.checkExpressionValueIsNotNull(localObject1, "lightTemplate.lightSegments");
      Object localObject2 = (Iterable)localObject1;
      localObject1 = (Collection)new ArrayList(CollectionsKt.collectionSizeOrDefault((Iterable)localObject2, 10));
      localObject2 = ((Iterable)localObject2).iterator();
      int i = 0;
      while (((Iterator)localObject2).hasNext())
      {
        Object localObject3 = ((Iterator)localObject2).next();
        if (i < 0) {
          CollectionsKt.throwIndexOverflow();
        }
        localObject3 = (MovieSegmentModel)localObject3;
        MovieController localMovieController = paramLightTemplate.getMovieController();
        Intrinsics.checkExpressionValueIsNotNull(localMovieController, "lightTemplate.movieController");
        int j = localMovieController.getClipPlaceHolders()[i].fillMode;
        localMovieController = paramLightTemplate.getMovieController();
        Intrinsics.checkExpressionValueIsNotNull(localMovieController, "lightTemplate.movieController");
        int k = localMovieController.getClipPlaceHolders()[i].width;
        localMovieController = paramLightTemplate.getMovieController();
        Intrinsics.checkExpressionValueIsNotNull(localMovieController, "lightTemplate.movieController");
        int m = localMovieController.getClipPlaceHolders()[i].height;
        localMovieController = paramLightTemplate.getMovieController();
        Intrinsics.checkExpressionValueIsNotNull(localMovieController, "lightTemplate.movieController");
        float f = localMovieController.getClipPlaceHolders()[i].volume;
        Intrinsics.checkExpressionValueIsNotNull(localObject3, "it");
        ((Collection)localObject1).add(new ClipPlaceHolder(((VideoResourceModel)((MovieSegmentModel)localObject3).getVideoResourceModels().get(0)).getSelectTimeDurationUs(), j, k, m, f));
        i += 1;
      }
      paramLightMediaTemplateModel.setClipPlaceHolders((List)localObject1);
    }
  }
  
  private final void updateSegmentCount(LightTemplate paramLightTemplate)
  {
    Object localObject = paramLightTemplate.getMovieController();
    Intrinsics.checkExpressionValueIsNotNull(localObject, "lightTemplate.movieController");
    if (((Object[])((MovieController)localObject).getClipInfos()).length < paramLightTemplate.getLightSegments().size())
    {
      localObject = paramLightTemplate.getLightSegments();
      Intrinsics.checkExpressionValueIsNotNull(localObject, "lightTemplate.lightSegments");
      localObject = (List)localObject;
      int i = paramLightTemplate.getLightSegments().size();
      MovieController localMovieController = paramLightTemplate.getMovieController();
      Intrinsics.checkExpressionValueIsNotNull(localMovieController, "lightTemplate.movieController");
      paramLightTemplate.setLightSegments(new ArrayList((Collection)CollectionsKt.dropLast((List)localObject, i - ((Object[])localMovieController.getClipInfos()).length)));
    }
  }
  
  private final void updateSegmentMinDuration(LightTemplate paramLightTemplate)
  {
    if (paramLightTemplate.isNoDurationLimitTemplate())
    {
      Object localObject1 = paramLightTemplate.getMovieController();
      Intrinsics.checkExpressionValueIsNotNull(localObject1, "lightTemplate.movieController");
      int k = ((Object[])((MovieController)localObject1).getClipInfos()).length;
      localObject1 = paramLightTemplate.getLightSegments().iterator();
      Intrinsics.checkExpressionValueIsNotNull(localObject1, "lightTemplate.lightSegments.iterator()");
      int i = 0;
      while ((((Iterator)localObject1).hasNext()) && (i < k))
      {
        MovieSegmentModel localMovieSegmentModel = (MovieSegmentModel)((Iterator)localObject1).next();
        Intrinsics.checkExpressionValueIsNotNull(localMovieSegmentModel, "currentSegment");
        Object localObject2 = localMovieSegmentModel.getTimeRange();
        Intrinsics.checkExpressionValueIsNotNull(localObject2, "currentSegment.timeRange");
        localObject2 = ((CMTimeRange)localObject2).getDuration();
        Intrinsics.checkExpressionValueIsNotNull(localObject2, "currentSegment.timeRange.duration");
        if (((CMTime)localObject2).getTimeUs() != 0L)
        {
          localObject2 = paramLightTemplate.getMovieController();
          Intrinsics.checkExpressionValueIsNotNull(localObject2, "lightTemplate.movieController");
          localObject2 = localObject2.getClipInfos()[i];
          Intrinsics.checkExpressionValueIsNotNull(localObject2, "lightTemplate.movieController.clipInfos[i]");
          int m = localObject2.length;
          long l = 0L;
          int j = 0;
          while (j < m)
          {
            l += localObject2[j].sourceTimeRange.duration;
            j += 1;
          }
          localMovieSegmentModel.setMinDuration(CMTime.fromUs(l));
        }
        else
        {
          ((Iterator)localObject1).remove();
        }
        i += 1;
      }
    }
  }
  
  private final void updateTemplateDuration(LightTemplate paramLightTemplate)
  {
    Object localObject1 = paramLightTemplate.getMovieController();
    Intrinsics.checkExpressionValueIsNotNull(localObject1, "lightTemplate.movieController");
    localObject1 = ((MovieController)localObject1).getClipInfos();
    Intrinsics.checkExpressionValueIsNotNull(localObject1, "lightTemplate.movieController.clipInfos");
    Object localObject2 = paramLightTemplate.getMovieController();
    Intrinsics.checkExpressionValueIsNotNull(localObject2, "lightTemplate.movieController");
    localObject2 = ((MovieController)localObject2).getClipPlaceHolders();
    Intrinsics.checkExpressionValueIsNotNull(localObject2, "lightTemplate.movieController.clipPlaceHolders");
    ArrayList localArrayList = paramLightTemplate.getLightSegments();
    Intrinsics.checkExpressionValueIsNotNull(localArrayList, "lightTemplate.lightSegments");
    if ((!isFullFilled((ClipInfo[][])localObject1, (ClipPlaceHolder[])localObject2, (List)localArrayList)) || (paramLightTemplate.isNoDurationLimitTemplate()))
    {
      localObject1 = paramLightTemplate.getLightSegments().get(paramLightTemplate.getLightSegments().size() - 1);
      Intrinsics.checkExpressionValueIsNotNull(localObject1, "lightTemplate.lightSegme…e.lightSegments.size - 1]");
      localObject1 = ((MovieSegmentModel)localObject1).getTimeRange();
      Intrinsics.checkExpressionValueIsNotNull(localObject1, "lightTemplate.lightSegme…ments.size - 1].timeRange");
      paramLightTemplate.setDuration(((CMTimeRange)localObject1).getEndUs());
    }
  }
  
  @VisibleForTesting
  @Nullable
  public final TAVComposition buildComposition(@NotNull MediaModel paramMediaModel, @NotNull LightTemplate paramLightTemplate, @NotNull CGSize paramCGSize, @NotNull VideoRenderChainConfigure paramVideoRenderChainConfigure, boolean paramBoolean)
  {
    Intrinsics.checkParameterIsNotNull(paramMediaModel, "editorModel");
    Intrinsics.checkParameterIsNotNull(paramLightTemplate, "lightTemplate");
    Intrinsics.checkParameterIsNotNull(paramCGSize, "renderSize");
    Intrinsics.checkParameterIsNotNull(paramVideoRenderChainConfigure, "configure");
    if (CollectionUtil.isEmptyList(paramMediaModel.getMediaResourceModel().getVideos()))
    {
      Logger.e("LightTemplateMediaBuilder", "LightTemplate segments is empty.");
      return null;
    }
    LightMediaTemplateModel localLightMediaTemplateModel = paramMediaModel.getMediaTemplateModel().getLightMediaTemplateModel();
    if (!initLightEngine(paramVideoRenderChainConfigure, paramLightTemplate)) {
      return null;
    }
    Object localObject1 = LightSegmentHelper.INSTANCE;
    Object localObject2 = paramLightTemplate.getMovieController();
    Intrinsics.checkExpressionValueIsNotNull(localObject2, "lightTemplate.movieController");
    paramLightTemplate.setNoDurationLimitTemplate(((LightSegmentHelper)localObject1).isNoDurationLimitTemplate(((MovieController)localObject2).getClipPlaceHolders()));
    Intrinsics.checkExpressionValueIsNotNull(localLightMediaTemplateModel, "lightTemplateModel");
    boolean bool = parseSegmentInfo(localLightMediaTemplateModel, paramLightTemplate);
    if (CollectionUtil.isEmptyList(paramLightTemplate.getSegments()))
    {
      Logger.e("LightTemplateMediaBuilder", "LightTemplate segments is empty.");
      return null;
    }
    paramLightTemplate.setDuration(paramLightTemplate.getMovieController().duration());
    if (bool)
    {
      localObject1 = LightSegmentHelper.INSTANCE;
      localObject2 = paramLightTemplate.getLightSegments();
      Intrinsics.checkExpressionValueIsNotNull(localObject2, "lightTemplate.lightSegments");
      localObject1 = ((LightSegmentHelper)localObject1).fillSegmentToClipAsset((List)localObject2, paramMediaModel.getMediaEffectModel().getMusicModel().getVolume());
    }
    else
    {
      List localList;
      if ((paramLightTemplate.isNoDurationLimitTemplate()) && (localLightMediaTemplateModel.getClipPlaceHolders() == null))
      {
        localObject1 = LightSegmentHelper.INSTANCE;
        localObject2 = paramMediaModel.getMediaResourceModel().getVideos();
        localList = paramLightTemplate.getSegments();
        Intrinsics.checkExpressionValueIsNotNull(localList, "lightTemplate.segments");
        localObject1 = ((LightSegmentHelper)localObject1).fillOriginClipsToEmptySegmentTemplate((List)localObject2, localList, paramMediaModel.getMediaEffectModel().getMusicModel().getVolume());
      }
      else
      {
        float f = paramMediaModel.getMediaEffectModel().getMusicModel().getVolume();
        localObject1 = LightSegmentHelper.INSTANCE;
        localObject2 = paramMediaModel.getMediaResourceModel().getVideos();
        localList = paramLightTemplate.getSegments();
        Intrinsics.checkExpressionValueIsNotNull(localList, "lightTemplate.segments");
        localObject1 = ((LightSegmentHelper)localObject1).fillOriginResToClipAsset((List)localObject2, localList, f, paramLightTemplate.getDuration());
      }
    }
    localObject2 = paramLightTemplate.getMovieController();
    localObject1 = (Collection)localObject1;
    int i = 0;
    localObject1 = ((Collection)localObject1).toArray(new ClipAsset[0]);
    if (localObject1 != null)
    {
      ((MovieController)localObject2).setClipAssets((ClipAsset[])localObject1, localLightMediaTemplateModel.getBackgroundEffectPath(), paramVideoRenderChainConfigure.isModifyClip());
      paramVideoRenderChainConfigure = paramLightTemplate.getMovieController();
      Intrinsics.checkExpressionValueIsNotNull(paramVideoRenderChainConfigure, "lightTemplate.movieController");
      paramVideoRenderChainConfigure = paramVideoRenderChainConfigure.getClipInfos();
      Intrinsics.checkExpressionValueIsNotNull(paramVideoRenderChainConfigure, "lightTemplate.movieController.clipInfos");
      if (((Object[])paramVideoRenderChainConfigure).length == 0) {
        i = 1;
      }
      if (i != 0)
      {
        Logger.e("LightTemplateMediaBuilder", "setClipAssets called but clipInfo is empty. Build failed!!");
        return null;
      }
      paramVideoRenderChainConfigure = paramLightTemplate.getMovieController();
      Intrinsics.checkExpressionValueIsNotNull(paramVideoRenderChainConfigure, "lightTemplate.movieController");
      paramVideoRenderChainConfigure = paramVideoRenderChainConfigure.getClipInfos();
      Intrinsics.checkExpressionValueIsNotNull(paramVideoRenderChainConfigure, "lightTemplate.movieController.clipInfos");
      localObject1 = paramLightTemplate.getLightSegments();
      Intrinsics.checkExpressionValueIsNotNull(localObject1, "lightTemplate.lightSegments");
      updateSegmentTimeRange(paramVideoRenderChainConfigure, (List)localObject1);
      updateSegmentCount(paramLightTemplate);
      if (localLightMediaTemplateModel.getClipPlaceHolders() == null) {
        updateSegmentMinDuration(paramLightTemplate);
      }
      updateTemplateDuration(paramLightTemplate);
      updateClipPlaceHolderInfo(paramLightTemplate, localLightMediaTemplateModel);
      paramVideoRenderChainConfigure = paramLightTemplate.getMovieController();
      Intrinsics.checkExpressionValueIsNotNull(paramVideoRenderChainConfigure, "lightTemplate.movieController");
      replaceLightPresetData(paramVideoRenderChainConfigure, paramLightTemplate.getFilePath());
      replaceLightTextData(localLightMediaTemplateModel, paramLightTemplate);
      initBoundsRect(paramLightTemplate);
      paramCGSize = generateTAVComposition(paramCGSize, paramLightTemplate.getDuration());
      bindAudioPlaceHolder(paramMediaModel, paramLightTemplate, localLightMediaTemplateModel, paramCGSize, paramBoolean);
      return paramCGSize;
    }
    throw new TypeCastException("null cannot be cast to non-null type kotlin.Array<T>");
  }
  
  @VisibleForTesting
  @NotNull
  public final TAVComposition generateTAVComposition(@NotNull CGSize paramCGSize, long paramLong)
  {
    Intrinsics.checkParameterIsNotNull(paramCGSize, "renderSize");
    TAVComposition localTAVComposition = new TAVComposition();
    localTAVComposition.setRenderSize(paramCGSize);
    paramCGSize = new ArrayList();
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(new TAVClip((TAVResource)new TAVEmptyResource(CMTime.fromUs(paramLong), true, true)));
    paramCGSize.add(localArrayList);
    localTAVComposition.setVideoChannels((List)paramCGSize);
    return localTAVComposition;
  }
  
  @VisibleForTesting
  public final boolean isFullFilled(@NotNull ClipInfo[][] paramArrayOfClipInfo, @NotNull ClipPlaceHolder[] paramArrayOfClipPlaceHolder, @NotNull List<? extends MovieSegmentModel> paramList)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfClipInfo, "cilpInfos");
    Intrinsics.checkParameterIsNotNull(paramArrayOfClipPlaceHolder, "clipPlaceHolders");
    Intrinsics.checkParameterIsNotNull(paramList, "lightSegments");
    if (paramList.size() < paramArrayOfClipPlaceHolder.length) {
      return false;
    }
    int i = ((Object[])paramArrayOfClipInfo).length - 1;
    long l = 0L;
    paramArrayOfClipInfo = ((MovieSegmentModel)paramList.get(i)).getVideoResourceModels();
    Intrinsics.checkExpressionValueIsNotNull(paramArrayOfClipInfo, "lightSegments[lastIndex].videoResourceModels");
    paramArrayOfClipInfo = ((Iterable)paramArrayOfClipInfo).iterator();
    while (paramArrayOfClipInfo.hasNext()) {
      l += ((VideoResourceModel)paramArrayOfClipInfo.next()).getSelectTimeDurationUs();
    }
    return l >= paramArrayOfClipPlaceHolder[i].contentDuration;
  }
  
  @Nullable
  public final HashMap<String, String> replaceLightPresetData(@NotNull MovieController paramMovieController, @Nullable String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramMovieController, "movieController");
    HashMap localHashMap1 = paramMovieController.presetData();
    if ((localHashMap1 != null) && (localHashMap1.size() != 0))
    {
      HashMap localHashMap2 = new HashMap();
      LightPatterHelper.fillNickName(localHashMap1, localHashMap2);
      LightPatterHelper.fillDate(localHashMap1, localHashMap2);
      LightPatterHelper.fillLocation(localHashMap1, localHashMap2);
      LightPatterHelper.fillWeather(localHashMap1, localHashMap2);
      LightPatterHelper.fillWatermark(localHashMap1, localHashMap2);
      LightPatterHelper.fillAvatar(localHashMap1, localHashMap2, paramString, (XffectsDownloadListener)new LightTemplateMediaBuilder.replaceLightPresetData.1(localHashMap2, paramMovieController));
      paramMovieController.setPresetData(localHashMap2);
      return localHashMap2;
    }
    return null;
  }
  
  @VisibleForTesting
  public final void updateSegmentTimeRange(@NotNull ClipInfo[][] paramArrayOfClipInfo, @NotNull List<? extends MovieSegmentModel> paramList)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfClipInfo, "clipInfos");
    Intrinsics.checkParameterIsNotNull(paramList, "lightSegments");
    Object[] arrayOfObject = (Object[])paramArrayOfClipInfo;
    int i = arrayOfObject.length;
    int j = 0;
    int k = 0;
    while (j < i)
    {
      paramArrayOfClipInfo = (ClipInfo[])arrayOfObject[j];
      int i1 = paramArrayOfClipInfo.length;
      long l1 = -9223372036854775808L;
      long l2 = 9223372036854775807L;
      int n = 0;
      int m = j;
      while (n < i1)
      {
        ClipInfo[] arrayOfClipInfo = paramArrayOfClipInfo[n];
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("clipInfo: sourceTimeRange:[");
        localObject = arrayOfClipInfo.sourceTimeRange;
        localMovieSegmentModel = null;
        if (localObject != null) {
          localObject = Long.valueOf(((TimeRange)localObject).startTime);
        } else {
          localObject = null;
        }
        localStringBuilder.append(localObject);
        localStringBuilder.append(", ");
        localObject = arrayOfClipInfo.sourceTimeRange;
        if (localObject != null) {
          localObject = Long.valueOf(((TimeRange)localObject).duration);
        } else {
          localObject = null;
        }
        localStringBuilder.append(localObject);
        localStringBuilder.append("], targetTimeRange:[");
        localObject = arrayOfClipInfo.targetTimeRange;
        if (localObject != null) {
          localObject = Long.valueOf(((TimeRange)localObject).startTime);
        } else {
          localObject = null;
        }
        localStringBuilder.append(localObject);
        localStringBuilder.append(", ");
        localObject = arrayOfClipInfo.targetTimeRange;
        if (localObject != null) {
          localObject = Long.valueOf(((TimeRange)localObject).duration);
        } else {
          localObject = null;
        }
        localStringBuilder.append(localObject);
        localStringBuilder.append("], path:");
        localStringBuilder.append(arrayOfClipInfo.path);
        Logger.i("miles", localStringBuilder.toString());
        localObject = ((MovieSegmentModel)paramList.get(k)).getVideoResourceModels();
        Intrinsics.checkExpressionValueIsNotNull(localObject, "lightSegments[index].videoResourceModels");
        localObject = ((List)localObject).iterator();
        j = 0;
        while (((Iterator)localObject).hasNext())
        {
          if (Intrinsics.areEqual(((VideoResourceModel)((Iterator)localObject).next()).getPath(), arrayOfClipInfo.path)) {
            break label390;
          }
          j += 1;
        }
        j = -1;
        label390:
        long l3;
        if (j != -1)
        {
          localObject = (VideoResourceModel)((MovieSegmentModel)paramList.get(k)).getVideoResourceModels().get(j);
          if (localObject != null)
          {
            l3 = arrayOfClipInfo.sourceTimeRange.startTime;
            long l4 = arrayOfClipInfo.sourceTimeRange.duration;
            localObject = VideoResourceModel.copy$default((VideoResourceModel)localObject, null, arrayOfClipInfo.sourceTimeRange.duration / 1000, 0, 0L, 0L, l3, l4, 0L, 0L, 0, 0, 0, null, 8093, null);
          }
          else
          {
            localObject = localMovieSegmentModel;
          }
          ((MovieSegmentModel)paramList.get(k)).getVideoResourceModels().set(j, localObject);
          l2 = RangesKt.coerceAtMost(l2, arrayOfClipInfo.targetTimeRange.startTime);
          l3 = RangesKt.coerceAtLeast(l1, arrayOfClipInfo.targetTimeRange.startTime + arrayOfClipInfo.targetTimeRange.duration);
          l1 = l2;
          l2 = l3;
          l3 = l2;
        }
        else
        {
          l3 = l1;
          l1 = l2;
        }
        n += 1;
        l2 = l1;
        l1 = l3;
      }
      paramArrayOfClipInfo = new CMTime(l2, 1000000);
      Object localObject = new CMTime(l1 - l2, 1000000);
      MovieSegmentModel localMovieSegmentModel = (MovieSegmentModel)CollectionsKt.getOrNull(paramList, k);
      if (localMovieSegmentModel != null) {
        localMovieSegmentModel.setTimeRange(new CMTimeRange(paramArrayOfClipInfo, (CMTime)localObject));
      }
      k += 1;
      j = m + 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.qcircle.weseevideo.model.template.light.LightTemplateMediaBuilder
 * JD-Core Version:    0.7.0.1
 */