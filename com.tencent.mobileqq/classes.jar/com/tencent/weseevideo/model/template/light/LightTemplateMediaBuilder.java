package com.tencent.weseevideo.model.template.light;

import android.support.annotation.VisibleForTesting;
import android.text.TextUtils;
import com.tencent.tav.coremedia.CGSize;
import com.tencent.tav.coremedia.CMTime;
import com.tencent.tav.coremedia.CMTimeRange;
import com.tencent.tav.coremedia.TimeUtil;
import com.tencent.tavcut.TAVCut;
import com.tencent.tavcut.util.Logger;
import com.tencent.tavkit.composition.TAVClip;
import com.tencent.tavkit.composition.TAVComposition;
import com.tencent.tavkit.composition.resource.TAVEmptyResource;
import com.tencent.tavkit.composition.resource.TAVResource;
import com.tencent.tavsticker.utils.CollectionUtil;
import com.tencent.weishi.module.publisher.entity.TemplateBean;
import com.tencent.weishi.module.publisher.interfaces.XffectsDownloadListener;
import com.tencent.weseevideo.composition.VideoRenderChainConfigure;
import com.tencent.weseevideo.composition.VideoRenderChainManager;
import com.tencent.weseevideo.composition.VideoRenderChainManager.IEffectNodeInterface;
import com.tencent.weseevideo.composition.VideoRenderChainManager.IStickerContextInterface;
import com.tencent.weseevideo.composition.builder.MediaBuilderListener;
import com.tencent.weseevideo.composition.builder.MediaBuilderOutput;
import com.tencent.weseevideo.model.MediaModel;
import com.tencent.weseevideo.model.data.MusicMaterialMetaDataBean;
import com.tencent.weseevideo.model.effect.MediaEffectModel;
import com.tencent.weseevideo.model.effect.MusicModel;
import com.tencent.weseevideo.model.resource.MediaResourceModel;
import com.tencent.weseevideo.model.resource.VideoResourceModel;
import com.tencent.weseevideo.model.template.MediaTemplateModel;
import com.tencent.weseevideo.model.template.movie.MovieSegmentModel;
import com.tencent.weseevideo.model.utils.AudioUtils;
import com.tencent.weseevideo.model.utils.MusicMaterialMataDataBeanUtils;
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

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/weseevideo/model/template/light/LightTemplateMediaBuilder;", "", "()V", "DEFAULT_FRAME_RATE", "", "DEFAULT_SEEK_TOLERANCE", "", "PLAYING_SEEK_TOLERANCE", "SECONDS_US", "TAG", "", "bindAudioPlaceHolder", "", "editorModel", "Lcom/tencent/weseevideo/model/MediaModel;", "lightTemplate", "Lcom/tencent/weseevideo/model/template/light/LightTemplate;", "lightTemplateModel", "Lcom/tencent/weseevideo/model/template/light/LightMediaTemplateModel;", "composition", "Lcom/tencent/tavkit/composition/TAVComposition;", "changeMusicByUser", "", "build", "model", "renderContextCreator", "Lcom/tencent/weseevideo/composition/VideoRenderChainManager$IStickerContextInterface;", "listener", "Lcom/tencent/weseevideo/composition/builder/MediaBuilderListener;", "configure", "Lcom/tencent/weseevideo/composition/VideoRenderChainConfigure;", "buildComposition", "renderSize", "Lcom/tencent/tav/coremedia/CGSize;", "createVideoRenderChainManager", "Lcom/tencent/weseevideo/composition/VideoRenderChainManager;", "applyType", "generateTAVComposition", "durationUs", "", "initBoundsRect", "initLightEngine", "isFullFilled", "cilpInfos", "", "Lorg/light/ClipInfo;", "clipPlaceHolders", "Lorg/light/ClipPlaceHolder;", "lightSegments", "", "Lcom/tencent/weseevideo/model/template/movie/MovieSegmentModel;", "([[Lorg/light/ClipInfo;[Lorg/light/ClipPlaceHolder;Ljava/util/List;)Z", "parseSegmentInfo", "replaceLightPresetData", "Ljava/util/HashMap;", "movieController", "Lorg/light/MovieController;", "filePath", "replaceLightTextData", "updateClipPlaceHolderInfo", "updateSegmentCount", "updateSegmentMinDuration", "updateSegmentTimeRange", "clipInfos", "([[Lorg/light/ClipInfo;Ljava/util/List;)V", "updateTemplateDuration", "libtavcut_debug"}, k=1, mv={1, 1, 16})
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
    if ((paramMediaModel.getMediaEffectModel().getMusicModel().getMetaDataBean() != null) && (paramBoolean)) {}
    label49:
    label312:
    for (;;)
    {
      return;
      paramLightTemplate = paramLightTemplate.getMovieController();
      Intrinsics.checkExpressionValueIsNotNull(paramLightTemplate, "lightTemplate.movieController");
      paramLightTemplate = paramLightTemplate.getAudioPlaceHolders();
      Intrinsics.checkExpressionValueIsNotNull(paramLightTemplate, "audioPlaceHolder");
      int i;
      int j;
      if (paramLightTemplate.length == 0)
      {
        i = 1;
        if (i != 0) {
          break label298;
        }
        j = paramLightTemplate.length;
        i = 0;
      }
      for (;;)
      {
        if (i >= j) {
          break label312;
        }
        paramTAVComposition = paramLightTemplate[i];
        if (!TextUtils.isEmpty((CharSequence)paramTAVComposition.path))
        {
          MusicMaterialMetaDataBean localMusicMaterialMetaDataBean = new MusicMaterialMetaDataBean(null, 0L, null, null, null, null, 0, 0, null, null, null, null, null, 0, null, 0, null, 0, 0, 0, 0, null, null, 0, 0, 0, 0, 0L, 0, 0, (byte)0, 0, null, null, null, null, null, null, null, null, 0, 0, 0, 0, 0, null, false, 0, 0, null, null, false, null, false, 0L, 0L, 0L, 0L, false, 0L, 0.0F, 0L, null, -1, 2147483647, null);
          paramLightTemplate = paramTAVComposition.musicID;
          Intrinsics.checkExpressionValueIsNotNull(paramLightTemplate, "audio.musicID");
          localMusicMaterialMetaDataBean.id = paramLightTemplate;
          localMusicMaterialMetaDataBean.path = paramTAVComposition.path;
          paramLightTemplate = paramLightMediaTemplateModel.getTemplateBean();
          if (paramLightTemplate != null) {}
          for (paramLightTemplate = paramLightTemplate.templateName;; paramLightTemplate = null)
          {
            localMusicMaterialMetaDataBean.name = paramLightTemplate;
            localMusicMaterialMetaDataBean.startTime = ((int)TimeUtil.us2Milli(paramTAVComposition.startOffset));
            localMusicMaterialMetaDataBean.mTotalTimeMs = AudioUtils.getDuration(paramTAVComposition.path);
            MusicMaterialMataDataBeanUtils.setStartInTime(localMusicMaterialMetaDataBean, TimeUtil.us2Milli(paramTAVComposition.fadeInDuration));
            MusicMaterialMataDataBeanUtils.setEndOutTime(localMusicMaterialMetaDataBean, TimeUtil.us2Milli(paramTAVComposition.fadeOutDuration));
            paramMediaModel.getMediaEffectModel().getMusicModel().setMetaDataBean(localMusicMaterialMetaDataBean);
            paramMediaModel.getMediaEffectModel().getMusicModel().setBgmVolume(paramTAVComposition.volume);
            return;
            i = 0;
            break label49;
            break;
          }
        }
        i += 1;
      }
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
    if (localObject1 != null)
    {
      localObject2 = new LightTemplate((String)localObject1);
      if (paramVideoRenderChainConfigure.getRenderSize() == null) {
        break label168;
      }
    }
    label168:
    for (localObject1 = paramVideoRenderChainConfigure.getRenderSize();; localObject1 = ((LightTemplate)localObject2).getRenderSize())
    {
      LightTemplateMediaBuilder localLightTemplateMediaBuilder = INSTANCE;
      Intrinsics.checkExpressionValueIsNotNull(localObject1, "renderSize");
      localObject1 = localLightTemplateMediaBuilder.buildComposition(paramMediaModel, (LightTemplate)localObject2, (CGSize)localObject1, paramVideoRenderChainConfigure, paramBoolean);
      if (localObject1 != null) {
        break label178;
      }
      paramMediaBuilderListener.buildCompleted(-306, null, null);
      return;
      localObject1 = "";
      break;
    }
    label178:
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
    boolean bool = false;
    int i;
    if (paramVideoRenderChainConfigure.getApplyType() == 100)
    {
      i = 120000;
      Logger.i("LightTemplateMediaBuilder", "开启LightSDK预解码，seekTolerance：" + 120000);
    }
    for (;;)
    {
      paramVideoRenderChainConfigure = new VideoOutputConfig(30.0F, i);
      AudioOutputConfig localAudioOutputConfig = new AudioOutputConfig();
      localAudioOutputConfig.sampleRate = 44100;
      localAudioOutputConfig.sampleCount = 2048;
      localAudioOutputConfig.channels = 1;
      RendererConfig localRendererConfig = new RendererConfig();
      localRendererConfig.bundlePath = TAVCut.getLightBundleResPath();
      paramVideoRenderChainConfigure = LightEngine.Make(paramVideoRenderChainConfigure, localAudioOutputConfig, localRendererConfig);
      if (paramVideoRenderChainConfigure != null)
      {
        paramLightTemplate.setLightEngine(paramVideoRenderChainConfigure);
        paramLightTemplate.setMovieController(paramVideoRenderChainConfigure.setAssetForMovie(paramLightTemplate.getLightAsset()));
        bool = true;
      }
      return bool;
      i = 0;
    }
  }
  
  @VisibleForTesting
  private final boolean parseSegmentInfo(LightMediaTemplateModel paramLightMediaTemplateModel, LightTemplate paramLightTemplate)
  {
    Object localObject = (Collection)paramLightMediaTemplateModel.getSegmentModels();
    if ((localObject == null) || (((Collection)localObject).isEmpty())) {}
    for (int i = 1; i == 0; i = 0)
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
        if (paramLightMediaTemplateModel == null) {
          throw new TypeCastException("null cannot be cast to non-null type kotlin.Array<T>");
        }
      }
      for (paramLightMediaTemplateModel = (ClipPlaceHolder[])paramLightMediaTemplateModel;; paramLightMediaTemplateModel = null)
      {
        paramLightTemplate.setSegments(((LightSegmentHelper)localObject).parseLightSegmentInfo(paramLightMediaTemplateModel));
        return false;
      }
    }
    paramLightMediaTemplateModel = LightSegmentHelper.INSTANCE;
    localObject = paramLightTemplate.getMovieController();
    Intrinsics.checkExpressionValueIsNotNull(localObject, "lightTemplate.movieController");
    paramLightTemplate.setSegments(paramLightMediaTemplateModel.parseLightSegmentInfo(((MovieController)localObject).getClipPlaceHolders()));
    return false;
  }
  
  private final void replaceLightTextData(LightMediaTemplateModel paramLightMediaTemplateModel, LightTemplate paramLightTemplate)
  {
    if (!paramLightMediaTemplateModel.getLightStickerTextModels().isEmpty()) {}
    for (int i = 1; i != 0; i = 0)
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
      if ((((Iterator)localObject1).hasNext()) && (i < k))
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
        for (;;)
        {
          i += 1;
          break;
          ((Iterator)localObject1).remove();
        }
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
    paramVideoRenderChainConfigure = LightSegmentHelper.INSTANCE;
    Object localObject = paramLightTemplate.getMovieController();
    Intrinsics.checkExpressionValueIsNotNull(localObject, "lightTemplate.movieController");
    paramLightTemplate.setNoDurationLimitTemplate(paramVideoRenderChainConfigure.isNoDurationLimitTemplate(((MovieController)localObject).getClipPlaceHolders()));
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
      paramVideoRenderChainConfigure = LightSegmentHelper.INSTANCE;
      localObject = paramLightTemplate.getLightSegments();
      Intrinsics.checkExpressionValueIsNotNull(localObject, "lightTemplate.lightSegments");
      paramVideoRenderChainConfigure = paramVideoRenderChainConfigure.fillSegmentToClipAsset((List)localObject, paramMediaModel.getMediaEffectModel().getMusicModel().getVolume());
    }
    for (;;)
    {
      localObject = paramLightTemplate.getMovieController();
      paramVideoRenderChainConfigure = ((Collection)paramVideoRenderChainConfigure).toArray(new ClipAsset[0]);
      if (paramVideoRenderChainConfigure != null) {
        break;
      }
      throw new TypeCastException("null cannot be cast to non-null type kotlin.Array<T>");
      List localList;
      if ((paramLightTemplate.isNoDurationLimitTemplate()) && (localLightMediaTemplateModel.getClipPlaceHolders() == null))
      {
        paramVideoRenderChainConfigure = LightSegmentHelper.INSTANCE;
        localObject = paramMediaModel.getMediaResourceModel().getVideos();
        localList = paramLightTemplate.getSegments();
        Intrinsics.checkExpressionValueIsNotNull(localList, "lightTemplate.segments");
        paramVideoRenderChainConfigure = paramVideoRenderChainConfigure.fillOriginClipsToEmptySegmentTemplate((List)localObject, localList, paramMediaModel.getMediaEffectModel().getMusicModel().getVolume());
      }
      else
      {
        float f = paramMediaModel.getMediaEffectModel().getMusicModel().getVolume();
        paramVideoRenderChainConfigure = LightSegmentHelper.INSTANCE;
        localObject = paramMediaModel.getMediaResourceModel().getVideos();
        localList = paramLightTemplate.getSegments();
        Intrinsics.checkExpressionValueIsNotNull(localList, "lightTemplate.segments");
        paramVideoRenderChainConfigure = paramVideoRenderChainConfigure.fillOriginResToClipAsset((List)localObject, localList, f, paramLightTemplate.getDuration());
      }
    }
    ((MovieController)localObject).setClipAssets((ClipAsset[])paramVideoRenderChainConfigure, localLightMediaTemplateModel.getBackgroundEffectPath());
    paramVideoRenderChainConfigure = paramLightTemplate.getMovieController();
    Intrinsics.checkExpressionValueIsNotNull(paramVideoRenderChainConfigure, "lightTemplate.movieController");
    paramVideoRenderChainConfigure = paramVideoRenderChainConfigure.getClipInfos();
    Intrinsics.checkExpressionValueIsNotNull(paramVideoRenderChainConfigure, "lightTemplate.movieController.clipInfos");
    if (((Object[])paramVideoRenderChainConfigure).length == 0) {}
    for (int i = 1; i != 0; i = 0)
    {
      Logger.e("LightTemplateMediaBuilder", "setClipAssets called but clipInfo is empty. Build failed!!");
      return null;
    }
    paramVideoRenderChainConfigure = paramLightTemplate.getMovieController();
    Intrinsics.checkExpressionValueIsNotNull(paramVideoRenderChainConfigure, "lightTemplate.movieController");
    paramVideoRenderChainConfigure = paramVideoRenderChainConfigure.getClipInfos();
    Intrinsics.checkExpressionValueIsNotNull(paramVideoRenderChainConfigure, "lightTemplate.movieController.clipInfos");
    localObject = paramLightTemplate.getLightSegments();
    Intrinsics.checkExpressionValueIsNotNull(localObject, "lightTemplate.lightSegments");
    updateSegmentTimeRange(paramVideoRenderChainConfigure, (List)localObject);
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
      l = ((VideoResourceModel)paramArrayOfClipInfo.next()).getSelectTimeDurationUs() + l;
    }
    return l >= paramArrayOfClipPlaceHolder[i].contentDuration;
  }
  
  @Nullable
  public final HashMap<String, String> replaceLightPresetData(@NotNull MovieController paramMovieController, @Nullable String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramMovieController, "movieController");
    HashMap localHashMap1 = paramMovieController.presetData();
    if ((localHashMap1 == null) || (localHashMap1.size() == 0)) {
      return null;
    }
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
  
  @VisibleForTesting
  public final void updateSegmentTimeRange(@NotNull ClipInfo[][] paramArrayOfClipInfo, @NotNull List<? extends MovieSegmentModel> paramList)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfClipInfo, "clipInfos");
    Intrinsics.checkParameterIsNotNull(paramList, "lightSegments");
    Object[] arrayOfObject = (Object[])paramArrayOfClipInfo;
    int n = arrayOfObject.length;
    int k = 0;
    int j = 0;
    Object localObject;
    long l2;
    long l1;
    int m;
    label66:
    MovieSegmentModel localMovieSegmentModel;
    label113:
    int i;
    label145:
    label177:
    label209:
    long l3;
    if (k < n)
    {
      localObject = (ClipInfo[])arrayOfObject[k];
      l2 = 9223372036854775807L;
      l1 = -9223372036854775808L;
      int i1 = localObject.length;
      m = 0;
      if (m < i1)
      {
        localMovieSegmentModel = localObject[m];
        StringBuilder localStringBuilder = new StringBuilder().append("clipInfo: sourceTimeRange:[");
        paramArrayOfClipInfo = localMovieSegmentModel.sourceTimeRange;
        if (paramArrayOfClipInfo != null)
        {
          paramArrayOfClipInfo = Long.valueOf(paramArrayOfClipInfo.startTime);
          localStringBuilder = localStringBuilder.append(paramArrayOfClipInfo).append(", ");
          paramArrayOfClipInfo = localMovieSegmentModel.sourceTimeRange;
          if (paramArrayOfClipInfo == null) {
            break label486;
          }
          paramArrayOfClipInfo = Long.valueOf(paramArrayOfClipInfo.duration);
          localStringBuilder = localStringBuilder.append(paramArrayOfClipInfo).append("], targetTimeRange:[");
          paramArrayOfClipInfo = localMovieSegmentModel.targetTimeRange;
          if (paramArrayOfClipInfo == null) {
            break label491;
          }
          paramArrayOfClipInfo = Long.valueOf(paramArrayOfClipInfo.startTime);
          localStringBuilder = localStringBuilder.append(paramArrayOfClipInfo).append(", ");
          paramArrayOfClipInfo = localMovieSegmentModel.targetTimeRange;
          if (paramArrayOfClipInfo == null) {
            break label496;
          }
          paramArrayOfClipInfo = Long.valueOf(paramArrayOfClipInfo.duration);
          Logger.i("miles", paramArrayOfClipInfo + "], path:" + localMovieSegmentModel.path);
          paramArrayOfClipInfo = ((MovieSegmentModel)paramList.get(j)).getVideoResourceModels();
          Intrinsics.checkExpressionValueIsNotNull(paramArrayOfClipInfo, "lightSegments[index].videoResourceModels");
          paramArrayOfClipInfo = (List)paramArrayOfClipInfo;
          i = 0;
          paramArrayOfClipInfo = paramArrayOfClipInfo.iterator();
          label274:
          if (!paramArrayOfClipInfo.hasNext()) {
            break label508;
          }
          if (!Intrinsics.areEqual(((VideoResourceModel)paramArrayOfClipInfo.next()).getPath(), localMovieSegmentModel.path)) {
            break label501;
          }
          label306:
          if (i == -1) {
            break label593;
          }
          paramArrayOfClipInfo = (VideoResourceModel)((MovieSegmentModel)paramList.get(j)).getVideoResourceModels().get(i);
          if (paramArrayOfClipInfo == null) {
            break label513;
          }
          l3 = localMovieSegmentModel.sourceTimeRange.startTime;
          long l4 = localMovieSegmentModel.sourceTimeRange.duration;
          paramArrayOfClipInfo = VideoResourceModel.copy$default(paramArrayOfClipInfo, null, localMovieSegmentModel.sourceTimeRange.duration / 1000, 0, 0L, 0L, l3, l4, 0L, 0L, 0, 0, 0, null, 8093, null);
          label393:
          ((MovieSegmentModel)paramList.get(j)).getVideoResourceModels().set(i, paramArrayOfClipInfo);
          l2 = RangesKt.coerceAtMost(l2, localMovieSegmentModel.targetTimeRange.startTime);
          l3 = RangesKt.coerceAtLeast(l1, localMovieSegmentModel.targetTimeRange.startTime + localMovieSegmentModel.targetTimeRange.duration);
          l1 = l2;
          l2 = l3;
        }
      }
    }
    for (;;)
    {
      l3 = l1;
      m += 1;
      l1 = l2;
      l2 = l3;
      break label66;
      paramArrayOfClipInfo = null;
      break label113;
      label486:
      paramArrayOfClipInfo = null;
      break label145;
      label491:
      paramArrayOfClipInfo = null;
      break label177;
      label496:
      paramArrayOfClipInfo = null;
      break label209;
      label501:
      i += 1;
      break label274;
      label508:
      i = -1;
      break label306;
      label513:
      paramArrayOfClipInfo = null;
      break label393;
      paramArrayOfClipInfo = new CMTime(l2, 1000000);
      localObject = new CMTime(l1 - l2, 1000000);
      localMovieSegmentModel = (MovieSegmentModel)CollectionsKt.getOrNull(paramList, j);
      if (localMovieSegmentModel != null) {
        localMovieSegmentModel.setTimeRange(new CMTimeRange(paramArrayOfClipInfo, (CMTime)localObject));
      }
      k += 1;
      j += 1;
      break;
      return;
      label593:
      l3 = l2;
      l2 = l1;
      l1 = l3;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.weseevideo.model.template.light.LightTemplateMediaBuilder
 * JD-Core Version:    0.7.0.1
 */