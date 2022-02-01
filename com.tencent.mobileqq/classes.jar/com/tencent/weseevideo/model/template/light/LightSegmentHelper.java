package com.tencent.weseevideo.model.template.light;

import android.support.annotation.VisibleForTesting;
import android.text.TextUtils;
import com.tencent.tav.coremedia.CMTime;
import com.tencent.tav.coremedia.CMTimeRange;
import com.tencent.tavcut.util.Logger;
import com.tencent.weseevideo.model.resource.MediaClipModel;
import com.tencent.weseevideo.model.resource.VideoResourceModel;
import com.tencent.weseevideo.model.template.movie.MovieSegmentModel;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.List<Lcom.tencent.weseevideo.model.resource.MediaClipModel;>;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.light.ClipAsset;
import org.light.ClipPlaceHolder;
import org.light.PhotoClip;
import org.light.VideoClip;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/weseevideo/model/template/light/LightSegmentHelper;", "", "()V", "TAG", "", "fillClips", "", "segment", "Lcom/tencent/weseevideo/model/template/movie/MovieSegmentModel;", "musicVolume", "", "clips", "Ljava/util/ArrayList;", "Lorg/light/ClipAsset;", "Lkotlin/collections/ArrayList;", "fillOriginClipsToEmptySegmentTemplate", "originClips", "", "Lcom/tencent/weseevideo/model/resource/MediaClipModel;", "lightSegments", "fillOriginResToClipAsset", "duration", "", "fillPhotoClips", "videoRes", "Lcom/tencent/weseevideo/model/resource/VideoResourceModel;", "fillPhotoSegment", "mediaClip", "fillSegmentToClipAsset", "fillSegments", "", "remainClips", "", "mNeedCycleFill", "fillVideoClips", "fillVideoSegment", "isAllPhotoClip", "isAllVideoClip", "movieClips", "isNeedCycleFill", "isNoDurationLimitTemplate", "clipHolders", "", "Lorg/light/ClipPlaceHolder;", "([Lorg/light/ClipPlaceHolder;)Z", "isSingleVideo", "parseLightSegmentInfo", "clipPlaceHolders", "([Lorg/light/ClipPlaceHolder;)Ljava/util/List;", "separateClip", "clip", "mLightSegments", "separateClips", "libtavcut_debug"}, k=1, mv={1, 1, 16})
public final class LightSegmentHelper
{
  public static final LightSegmentHelper INSTANCE = new LightSegmentHelper();
  @NotNull
  public static final String TAG = "LightSegmentHelper";
  
  private final void fillClips(MovieSegmentModel paramMovieSegmentModel, float paramFloat, ArrayList<ClipAsset> paramArrayList)
  {
    paramMovieSegmentModel = paramMovieSegmentModel.getVideoResourceModels().iterator();
    while (paramMovieSegmentModel.hasNext())
    {
      VideoResourceModel localVideoResourceModel = (VideoResourceModel)paramMovieSegmentModel.next();
      if (localVideoResourceModel.getType() == 1)
      {
        Intrinsics.checkExpressionValueIsNotNull(localVideoResourceModel, "videoRes");
        fillVideoClips(localVideoResourceModel, paramFloat, paramArrayList);
      }
      else if (localVideoResourceModel.getType() == 2)
      {
        Intrinsics.checkExpressionValueIsNotNull(localVideoResourceModel, "videoRes");
        fillPhotoClips(localVideoResourceModel, paramArrayList);
      }
    }
  }
  
  private final void fillPhotoClips(VideoResourceModel paramVideoResourceModel, ArrayList<ClipAsset> paramArrayList)
  {
    PhotoClip localPhotoClip = new PhotoClip();
    localPhotoClip.path = paramVideoResourceModel.getPath();
    localPhotoClip.duration = paramVideoResourceModel.getSelectTimeDurationUs();
    paramArrayList.add(localPhotoClip);
  }
  
  private final void fillPhotoSegment(MediaClipModel paramMediaClipModel, MovieSegmentModel paramMovieSegmentModel)
  {
    paramMediaClipModel = paramMediaClipModel.getResource();
    Logger.d("LightSegmentHelper", "begin--fillClipsPhoto photo path: " + paramMediaClipModel.getPath());
    CMTimeRange localCMTimeRange = paramMovieSegmentModel.getTimeRange();
    Intrinsics.checkExpressionValueIsNotNull(localCMTimeRange, "segment.timeRange");
    paramMediaClipModel = VideoResourceModel.copy$default(paramMediaClipModel, null, 0L, 0, 0L, 0L, 0L, localCMTimeRange.getDurationUs(), 0L, 0L, 0, 0, 0, null, 8127, null);
    paramMovieSegmentModel.getVideoResourceModels().add(paramMediaClipModel);
    Logger.d("LightSegmentHelper", "end--fillClipsPhoto photo path: " + paramMediaClipModel.getPath());
  }
  
  private final void fillVideoClips(VideoResourceModel paramVideoResourceModel, float paramFloat, ArrayList<ClipAsset> paramArrayList)
  {
    VideoClip localVideoClip = new VideoClip();
    localVideoClip.path = paramVideoResourceModel.getPath();
    localVideoClip.speed = 1.0F;
    localVideoClip.startOffset = paramVideoResourceModel.getSelectTimeStartUs();
    localVideoClip.volume = paramFloat;
    localVideoClip.duration = paramVideoResourceModel.getSelectTimeDurationUs();
    paramArrayList.add(localVideoClip);
  }
  
  private final void fillVideoSegment(MediaClipModel paramMediaClipModel, MovieSegmentModel paramMovieSegmentModel, List<MediaClipModel> paramList)
  {
    List localList = (List)new ArrayList();
    Object localObject = paramMovieSegmentModel.getTimeRange();
    Intrinsics.checkExpressionValueIsNotNull(localObject, "segment.timeRange");
    long l2 = ((CMTimeRange)localObject).getDurationUs();
    long l1;
    int j;
    int i;
    label84:
    long l3;
    if (l2 > 0L)
    {
      l1 = paramMediaClipModel.getResource().getSelectTimeDurationUs();
      j = paramMediaClipModel.getResource().getType();
      if ((!localList.isEmpty()) || (j != 1) || (l1 <= l2)) {
        break label229;
      }
      i = 1;
      if (i == 0) {
        break label235;
      }
      l3 = (l1 - l2) / 2;
      paramMediaClipModel = MediaClipModel.copy$default(paramMediaClipModel, VideoResourceModel.copy$default(paramMediaClipModel.getResource(), null, l2 / 1000, 0, 0L, 0L, l3 + paramMediaClipModel.getResource().getSelectTimeStartUs(), l2, 0L, 0L, 0, 0, 0, null, 8093, null), null, null, null, null, null, 62, null);
    }
    for (;;)
    {
      localList.add(paramMediaClipModel);
      l2 -= l1;
      if (l2 > 0L)
      {
        if (paramList.size() == 0)
        {
          paramMediaClipModel = new ArrayList();
          paramList = localList.iterator();
          while (paramList.hasNext()) {
            paramMediaClipModel.add(((MediaClipModel)paramList.next()).getResource());
          }
          label229:
          i = 0;
          break label84;
          label235:
          localObject = paramMediaClipModel;
          if (j == 2)
          {
            localObject = MediaClipModel.copy$default(paramMediaClipModel, VideoResourceModel.copy$default(paramMediaClipModel.getResource(), null, l2 / 1000, 0, 0L, 0L, 0L, l2, 0L, 0L, 0, 0, 0, null, 8093, null), null, null, null, null, null, 62, null);
            l1 = l2;
          }
          if (l2 >= l1) {
            break label386;
          }
          paramMediaClipModel = ((MediaClipModel)localObject).getResource();
          l3 = ((MediaClipModel)localObject).getResource().getSelectTimeStartUs();
          paramMediaClipModel = MediaClipModel.copy$default((MediaClipModel)localObject, VideoResourceModel.copy$default(paramMediaClipModel, null, l2 / 1000, 0, 0L, 0L, l3, l2, 0L, 0L, 0, 0, 0, null, 8093, null), null, null, null, null, null, 62, null);
          continue;
        }
        paramMediaClipModel = (MediaClipModel)paramList.remove(0);
        break;
        paramMovieSegmentModel.setVideoResourceModels(paramMediaClipModel);
        return;
      }
      break;
      label386:
      paramMediaClipModel = (MediaClipModel)localObject;
    }
  }
  
  private final boolean isAllPhotoClip(List<MediaClipModel> paramList)
  {
    if ((paramList != null) && (!paramList.isEmpty()))
    {
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        MediaClipModel localMediaClipModel = (MediaClipModel)paramList.next();
        if ((localMediaClipModel != null) && (localMediaClipModel.getResource().getType() != 2)) {
          return false;
        }
      }
      return true;
    }
    return false;
  }
  
  private final boolean isSingleVideo(List<MediaClipModel> paramList)
  {
    return (paramList != null) && (paramList.size() == 1) && (((MediaClipModel)paramList.get(0)).getResource().getType() == 1);
  }
  
  @NotNull
  public final ArrayList<ClipAsset> fillOriginClipsToEmptySegmentTemplate(@NotNull List<MediaClipModel> paramList, @NotNull List<? extends MovieSegmentModel> paramList1, float paramFloat)
  {
    Intrinsics.checkParameterIsNotNull(paramList, "originClips");
    Intrinsics.checkParameterIsNotNull(paramList1, "lightSegments");
    ArrayList localArrayList = new ArrayList();
    int j = RangesKt.coerceAtMost(paramList.size(), paramList1.size());
    int i = 0;
    if (i < j)
    {
      MediaClipModel localMediaClipModel = (MediaClipModel)paramList.get(i);
      if (localMediaClipModel.getResource().getType() == 2) {
        fillPhotoClips(localMediaClipModel.getResource(), localArrayList);
      }
      for (;;)
      {
        ((MovieSegmentModel)paramList1.get(i)).getVideoResourceModels().add(localMediaClipModel.getResource());
        i += 1;
        break;
        if (localMediaClipModel.getResource().getType() == 1) {
          fillVideoClips(localMediaClipModel.getResource(), paramFloat, localArrayList);
        }
      }
    }
    return localArrayList;
  }
  
  @NotNull
  public final ArrayList<ClipAsset> fillOriginResToClipAsset(@NotNull List<MediaClipModel> paramList, @NotNull List<? extends MovieSegmentModel> paramList1, float paramFloat, long paramLong)
  {
    Intrinsics.checkParameterIsNotNull(paramList, "clips");
    Intrinsics.checkParameterIsNotNull(paramList1, "lightSegments");
    Object localObject = (List)new ArrayList();
    paramList = paramList.iterator();
    while (paramList.hasNext()) {
      ((List)localObject).add(((MediaClipModel)paramList.next()).deepCopy());
    }
    boolean bool = isSingleVideo((List)localObject);
    if ((bool) && (paramList1.size() > 1)) {
      paramList = separateClip((MediaClipModel)((List)localObject).get(0), paramList1);
    }
    for (;;)
    {
      bool = isNeedCycleFill(paramList);
      localObject = paramList1.iterator();
      for (;;)
      {
        MovieSegmentModel localMovieSegmentModel;
        if (((Iterator)localObject).hasNext())
        {
          localMovieSegmentModel = (MovieSegmentModel)((Iterator)localObject).next();
          if ((paramList != null) && (!paramList.isEmpty())) {}
        }
        else
        {
          return fillSegmentToClipAsset(paramList1, paramFloat);
          if ((!isAllVideoClip((List)localObject)) || (((List)localObject).size() >= paramList1.size()) || (bool)) {
            break label232;
          }
          paramList = separateClips((List)localObject, paramList1, paramLong);
          break;
        }
        Logger.d("LightSegmentHelper", "fillSegments begin");
        fillSegments(localMovieSegmentModel, paramList, bool);
        Logger.d("LightSegmentHelper", "fillSegments end");
      }
      label232:
      paramList = (List<MediaClipModel>)localObject;
    }
  }
  
  @NotNull
  public final ArrayList<ClipAsset> fillSegmentToClipAsset(@NotNull List<? extends MovieSegmentModel> paramList, float paramFloat)
  {
    Intrinsics.checkParameterIsNotNull(paramList, "lightSegments");
    ArrayList localArrayList = new ArrayList();
    paramList = paramList.iterator();
    while (paramList.hasNext()) {
      fillClips((MovieSegmentModel)paramList.next(), paramFloat, localArrayList);
    }
    return localArrayList;
  }
  
  public final boolean fillSegments(@Nullable MovieSegmentModel paramMovieSegmentModel, @Nullable List<MediaClipModel> paramList, boolean paramBoolean)
  {
    if ((paramMovieSegmentModel == null) || (paramList == null) || (paramList.isEmpty())) {
      return false;
    }
    MediaClipModel localMediaClipModel;
    if (paramBoolean)
    {
      localMediaClipModel = (MediaClipModel)paramList.remove(0);
      paramList.add(localMediaClipModel.deepCopy());
    }
    while (localMediaClipModel == null)
    {
      return false;
      localMediaClipModel = (MediaClipModel)paramList.remove(0);
    }
    switch (localMediaClipModel.getResource().getType())
    {
    }
    for (;;)
    {
      return true;
      fillPhotoSegment(localMediaClipModel, paramMovieSegmentModel);
      continue;
      fillVideoSegment(localMediaClipModel, paramMovieSegmentModel, paramList);
    }
  }
  
  public final boolean isAllVideoClip(@Nullable List<MediaClipModel> paramList)
  {
    if ((paramList != null) && (!paramList.isEmpty()))
    {
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        MediaClipModel localMediaClipModel = (MediaClipModel)paramList.next();
        if ((localMediaClipModel != null) && (localMediaClipModel.getResource().getType() != 1)) {
          return false;
        }
      }
      return true;
    }
    return false;
  }
  
  public final boolean isNeedCycleFill(@Nullable List<MediaClipModel> paramList)
  {
    return isAllPhotoClip(paramList);
  }
  
  public final boolean isNoDurationLimitTemplate(@Nullable ClipPlaceHolder[] paramArrayOfClipPlaceHolder)
  {
    if (paramArrayOfClipPlaceHolder != null) {
      if (paramArrayOfClipPlaceHolder.length != 0) {
        break label17;
      }
    }
    label17:
    for (int i = 1; i != 0; i = 0) {
      return false;
    }
    int j = paramArrayOfClipPlaceHolder.length;
    i = 0;
    for (;;)
    {
      if (i >= j) {
        break label50;
      }
      if (paramArrayOfClipPlaceHolder[i].contentDuration != 0L) {
        break;
      }
      i += 1;
    }
    label50:
    return true;
  }
  
  @VisibleForTesting
  @NotNull
  public final List<MovieSegmentModel> parseLightSegmentInfo(@Nullable ClipPlaceHolder[] paramArrayOfClipPlaceHolder)
  {
    int j = 0;
    if (paramArrayOfClipPlaceHolder != null) {
      if (paramArrayOfClipPlaceHolder.length != 0) {
        break label21;
      }
    }
    label21:
    for (int i = 1; i != 0; i = 0) {
      return CollectionsKt.emptyList();
    }
    ArrayList localArrayList = new ArrayList();
    int k = paramArrayOfClipPlaceHolder.length;
    i = j;
    while (i < k)
    {
      ClipPlaceHolder localClipPlaceHolder = paramArrayOfClipPlaceHolder[i];
      MovieSegmentModel localMovieSegmentModel = new MovieSegmentModel();
      localMovieSegmentModel.setTimeRange(CMTimeRange.fromUs(0L, localClipPlaceHolder.contentDuration));
      localMovieSegmentModel.setMinDuration(CMTime.fromUs(localClipPlaceHolder.contentDuration));
      localArrayList.add(localMovieSegmentModel);
      i += 1;
    }
    return (List)localArrayList;
  }
  
  @Nullable
  public final List<MediaClipModel> separateClip(@NotNull MediaClipModel paramMediaClipModel, @NotNull List<? extends MovieSegmentModel> paramList)
  {
    Intrinsics.checkParameterIsNotNull(paramMediaClipModel, "clip");
    Intrinsics.checkParameterIsNotNull(paramList, "mLightSegments");
    List localList = (List)new ArrayList();
    paramList = paramList.iterator();
    for (;;)
    {
      if (paramList.hasNext())
      {
        localObject1 = (MovieSegmentModel)paramList.next();
        if (localObject1 == null) {
          continue;
        }
        localObject2 = ((MovieSegmentModel)localObject1).getTimeRange();
        Intrinsics.checkExpressionValueIsNotNull(localObject2, "segment.timeRange");
        if (((CMTimeRange)localObject2).getDurationUs() >= paramMediaClipModel.getResource().getSelectTimeDurationUs()) {
          localList.add(paramMediaClipModel);
        }
      }
      else
      {
        return localList;
      }
      Object localObject2 = paramMediaClipModel.getResource();
      CMTimeRange localCMTimeRange = ((MovieSegmentModel)localObject1).getTimeRange();
      Intrinsics.checkExpressionValueIsNotNull(localCMTimeRange, "segment.timeRange");
      long l1 = localCMTimeRange.getDurationUs();
      Object localObject1 = ((MovieSegmentModel)localObject1).getTimeRange();
      Intrinsics.checkExpressionValueIsNotNull(localObject1, "segment.timeRange");
      localObject1 = MediaClipModel.copy$default(paramMediaClipModel, VideoResourceModel.copy$default((VideoResourceModel)localObject2, null, ((CMTimeRange)localObject1).getDurationUs() / 1000, 0, 0L, 0L, paramMediaClipModel.getResource().getSelectTimeStartUs(), l1, 0L, 0L, 0, 0, 0, null, 8093, null), null, null, null, null, null, 62, null);
      localList.add(localObject1);
      l1 = paramMediaClipModel.getResource().getSelectTimeDurationUs() - ((MediaClipModel)localObject1).getResource().getSelectTimeDurationUs();
      localObject2 = paramMediaClipModel.getResource();
      long l2 = ((MediaClipModel)localObject1).getResource().getSelectTimeStartUs();
      long l3 = ((MediaClipModel)localObject1).getResource().getSelectTimeDurationUs();
      paramMediaClipModel = MediaClipModel.copy$default(paramMediaClipModel, VideoResourceModel.copy$default((VideoResourceModel)localObject2, null, l1 / 1000, 0, 0L, 0L, l2 + l3, l1, 0L, 0L, 0, 0, 0, null, 8093, null), null, null, null, null, null, 62, null);
    }
  }
  
  @Nullable
  public final List<MediaClipModel> separateClips(@Nullable List<MediaClipModel> paramList, @NotNull List<? extends MovieSegmentModel> paramList1, long paramLong)
  {
    Intrinsics.checkParameterIsNotNull(paramList1, "lightSegments");
    List localList = (List)new ArrayList();
    Map localMap = (Map)new ConcurrentHashMap(16);
    if (paramLong <= 0L) {}
    Object localObject1;
    long l1;
    do
    {
      return localList;
      if (paramList == null) {
        Intrinsics.throwNpe();
      }
      localObject1 = paramList.iterator();
      l1 = 0L;
      if (((Iterator)localObject1).hasNext())
      {
        localObject2 = (MediaClipModel)((Iterator)localObject1).next();
        if ((localObject2 == null) || (((MediaClipModel)localObject2).getResource().getSelectTimeDurationUs() == 0L)) {
          ((Iterator)localObject1).remove();
        }
        for (;;)
        {
          break;
          l1 = ((MediaClipModel)localObject2).getResource().getSelectTimeDurationUs() + l1;
        }
      }
    } while (l1 <= 0L);
    Object localObject2 = paramList.iterator();
    long l2;
    long l3;
    if (((Iterator)localObject2).hasNext())
    {
      localObject1 = (MediaClipModel)((Iterator)localObject2).next();
      l2 = ((MediaClipModel)localObject1).getResource().getSelectTimeDurationUs();
      l3 = l2 * paramLong / l1;
      if (l2 >= l3) {
        break label645;
      }
    }
    for (;;)
    {
      localObject1 = ((MediaClipModel)localObject1).getResource().getPath();
      if (localObject1 != null) {}
      for (;;)
      {
        localMap.put(localObject1, Long.valueOf(l2));
        break;
        localObject1 = "";
      }
      int k = ((Collection)paramList1).size();
      int i = 0;
      label244:
      int j;
      if ((i < k) && (!paramList.isEmpty()))
      {
        localObject1 = ((MovieSegmentModel)paramList1.get(i)).getTimeRange();
        Intrinsics.checkExpressionValueIsNotNull(localObject1, "segment.timeRange");
        paramLong = ((CMTimeRange)localObject1).getDurationUs();
        label289:
        if (paramLong > 0L) {
          if (!((Collection)paramList).isEmpty())
          {
            j = 1;
            label310:
            if (j == 0) {
              break label633;
            }
            localObject1 = (MediaClipModel)paramList.remove(0);
            l2 = ((MediaClipModel)localObject1).getResource().getSelectTimeDurationUs();
            localObject2 = localList.iterator();
            l1 = 0L;
            label349:
            if (!((Iterator)localObject2).hasNext()) {
              break label421;
            }
            MediaClipModel localMediaClipModel = (MediaClipModel)((Iterator)localObject2).next();
            if (!TextUtils.equals((CharSequence)localMediaClipModel.getResource().getPath(), (CharSequence)((MediaClipModel)localObject1).getResource().getPath())) {
              break label642;
            }
            l1 = localMediaClipModel.getResource().getSelectTimeDurationUs() + l1;
          }
        }
      }
      label642:
      for (;;)
      {
        break label349;
        j = 0;
        break label310;
        label421:
        localObject2 = localMap.get(((MediaClipModel)localObject1).getResource().getPath());
        if (localObject2 == null) {
          Intrinsics.throwNpe();
        }
        if ((l1 > ((Number)localObject2).longValue()) || (l2 <= 0L) || ((l1 != 0L) && (l2 < paramLong))) {
          break label289;
        }
        if (l2 > paramLong) {}
        for (l1 = paramLong;; l1 = l2)
        {
          localList.add(MediaClipModel.copy$default((MediaClipModel)localObject1, VideoResourceModel.copy$default(((MediaClipModel)localObject1).getResource(), null, l1 / 1000, 0, 0L, 0L, 0L, l1, 0L, 0L, 0, 0, 0, null, 8125, null), null, null, null, null, null, 62, null));
          l1 = l2 - paramLong;
          if (l1 > 0L) {
            paramList.add(0, MediaClipModel.copy$default((MediaClipModel)localObject1, VideoResourceModel.copy$default(((MediaClipModel)localObject1).getResource(), null, l1 / 1000, 0, 0L, 0L, ((MediaClipModel)localObject1).getResource().getSelectTimeStartUs() + paramLong, l1, 0L, 0L, 0, 0, 0, null, 8093, null), null, null, null, null, null, 62, null));
          }
          paramLong -= l2;
          break;
        }
        label633:
        i += 1;
        break label244;
        break;
      }
      label645:
      l2 = l3;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.weseevideo.model.template.light.LightSegmentHelper
 * JD-Core Version:    0.7.0.1
 */