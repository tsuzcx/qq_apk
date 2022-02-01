package com.tencent.qcircle.weseevideo.model.template.light;

import android.support.annotation.VisibleForTesting;
import android.text.TextUtils;
import com.tencent.qcircle.tavcut.util.Logger;
import com.tencent.qcircle.weseevideo.model.resource.MediaClipModel;
import com.tencent.qcircle.weseevideo.model.resource.VideoResourceModel;
import com.tencent.qcircle.weseevideo.model.template.movie.MovieSegmentModel;
import com.tencent.tav.coremedia.CMTime;
import com.tencent.tav.coremedia.CMTimeRange;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.List<Lcom.tencent.qcircle.weseevideo.model.resource.MediaClipModel;>;
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

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/qcircle/weseevideo/model/template/light/LightSegmentHelper;", "", "()V", "TAG", "", "fillClips", "", "segment", "Lcom/tencent/qcircle/weseevideo/model/template/movie/MovieSegmentModel;", "musicVolume", "", "clips", "Ljava/util/ArrayList;", "Lorg/light/ClipAsset;", "Lkotlin/collections/ArrayList;", "fillOriginClipsToEmptySegmentTemplate", "originClips", "", "Lcom/tencent/qcircle/weseevideo/model/resource/MediaClipModel;", "lightSegments", "fillOriginResToClipAsset", "duration", "", "fillPhotoClips", "videoRes", "Lcom/tencent/qcircle/weseevideo/model/resource/VideoResourceModel;", "fillPhotoSegment", "mediaClip", "fillSegmentToClipAsset", "fillSegments", "", "remainClips", "", "mNeedCycleFill", "fillVideoClips", "fillVideoSegment", "isAllPhotoClip", "isAllVideoClip", "movieClips", "isNeedCycleFill", "isNoDurationLimitTemplate", "clipHolders", "", "Lorg/light/ClipPlaceHolder;", "([Lorg/light/ClipPlaceHolder;)Z", "isSingleVideo", "parseLightSegmentInfo", "clipPlaceHolders", "([Lorg/light/ClipPlaceHolder;)Ljava/util/List;", "separateClip", "clip", "mLightSegments", "separateClips", "libtavcut_debug"}, k=1, mv={1, 1, 16})
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
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("begin--fillClipsPhoto photo path: ");
    ((StringBuilder)localObject).append(paramMediaClipModel.getPath());
    Logger.d("LightSegmentHelper", ((StringBuilder)localObject).toString());
    localObject = paramMovieSegmentModel.getTimeRange();
    Intrinsics.checkExpressionValueIsNotNull(localObject, "segment.timeRange");
    paramMediaClipModel = VideoResourceModel.copy$default(paramMediaClipModel, null, 0L, 0, 0L, 0L, 0L, ((CMTimeRange)localObject).getDurationUs(), 0L, 0L, 0, 0, 0, null, 8127, null);
    paramMovieSegmentModel.getVideoResourceModels().add(paramMediaClipModel);
    paramMovieSegmentModel = new StringBuilder();
    paramMovieSegmentModel.append("end--fillClipsPhoto photo path: ");
    paramMovieSegmentModel.append(paramMediaClipModel.getPath());
    Logger.d("LightSegmentHelper", paramMovieSegmentModel.toString());
  }
  
  private final void fillVideoClips(VideoResourceModel paramVideoResourceModel, float paramFloat, ArrayList<ClipAsset> paramArrayList)
  {
    VideoClip localVideoClip = new VideoClip();
    localVideoClip.path = paramVideoResourceModel.getPath();
    localVideoClip.speed = paramVideoResourceModel.getSpeed();
    localVideoClip.startOffset = paramVideoResourceModel.getSelectTimeStartUs();
    localVideoClip.volume = paramFloat;
    localVideoClip.duration = paramVideoResourceModel.getSelectTimeDurationUs();
    paramArrayList.add(localVideoClip);
  }
  
  private final void fillVideoSegment(MediaClipModel paramMediaClipModel, MovieSegmentModel paramMovieSegmentModel, List<MediaClipModel> paramList)
  {
    Object localObject2 = (List)new ArrayList();
    Object localObject1 = paramMovieSegmentModel.getTimeRange();
    Intrinsics.checkExpressionValueIsNotNull(localObject1, "segment.timeRange");
    long l1 = ((CMTimeRange)localObject1).getDurationUs();
    localObject1 = paramMediaClipModel;
    paramMediaClipModel = (MediaClipModel)localObject2;
    for (;;)
    {
      localObject2 = paramMediaClipModel;
      if (l1 <= 0L) {
        break;
      }
      long l2 = ((MediaClipModel)localObject1).getResource().getSelectTimeDurationUs();
      int j = ((MediaClipModel)localObject1).getResource().getType();
      boolean bool = paramMediaClipModel.isEmpty();
      int i = 1;
      if ((!bool) || (j != 1) || (l2 <= l1)) {
        i = 0;
      }
      long l3;
      if (i != 0)
      {
        l3 = (l2 - l1) / 2;
        localObject1 = MediaClipModel.copy$default((MediaClipModel)localObject1, VideoResourceModel.copy$default(((MediaClipModel)localObject1).getResource(), null, l1 / 1000, 0, 0L, 0L, l3 + ((MediaClipModel)localObject1).getResource().getSelectTimeStartUs(), l1, 0L, 0L, 0, 0, 0, null, 8093, null), null, null, null, null, 0L, null, 126, null);
      }
      else
      {
        if (j == 2)
        {
          localObject1 = MediaClipModel.copy$default((MediaClipModel)localObject1, VideoResourceModel.copy$default(((MediaClipModel)localObject1).getResource(), null, l1 / 1000, 0, 0L, 0L, 0L, l1, 0L, 0L, 0, 0, 0, null, 8093, null), null, null, null, null, 0L, null, 126, null);
          l2 = l1;
        }
        if (l1 < l2)
        {
          localObject2 = ((MediaClipModel)localObject1).getResource();
          l3 = ((MediaClipModel)localObject1).getResource().getSelectTimeStartUs();
          localObject1 = MediaClipModel.copy$default((MediaClipModel)localObject1, VideoResourceModel.copy$default((VideoResourceModel)localObject2, null, l1 / 1000, 0, 0L, 0L, l3, l1, 0L, 0L, 0, 0, 0, null, 8093, null), null, null, null, null, 0L, null, 126, null);
        }
      }
      paramMediaClipModel.add(localObject1);
      l1 -= l2;
      if (l1 > 0L)
      {
        if (paramList.size() == 0)
        {
          localObject2 = paramMediaClipModel;
          break;
        }
        localObject1 = (MediaClipModel)paramList.remove(0);
      }
    }
    paramMediaClipModel = new ArrayList();
    paramList = ((List)localObject2).iterator();
    while (paramList.hasNext()) {
      paramMediaClipModel.add(((MediaClipModel)paramList.next()).getResource());
    }
    paramMovieSegmentModel.setVideoResourceModels(paramMediaClipModel);
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
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (paramList != null)
    {
      bool1 = bool2;
      if (paramList.size() == 1)
      {
        bool1 = bool2;
        if (((MediaClipModel)paramList.get(0)).getResource().getType() == 1) {
          bool1 = true;
        }
      }
    }
    return bool1;
  }
  
  @NotNull
  public final ArrayList<ClipAsset> fillOriginClipsToEmptySegmentTemplate(@NotNull List<MediaClipModel> paramList, @NotNull List<? extends MovieSegmentModel> paramList1, float paramFloat)
  {
    Intrinsics.checkParameterIsNotNull(paramList, "originClips");
    Intrinsics.checkParameterIsNotNull(paramList1, "lightSegments");
    ArrayList localArrayList = new ArrayList();
    int j = RangesKt.coerceAtMost(paramList.size(), paramList1.size());
    int i = 0;
    while (i < j)
    {
      MediaClipModel localMediaClipModel = (MediaClipModel)paramList.get(i);
      if (localMediaClipModel.getResource().getType() == 2) {
        fillPhotoClips(localMediaClipModel.getResource(), localArrayList);
      } else if (localMediaClipModel.getResource().getType() == 1) {
        fillVideoClips(localMediaClipModel.getResource(), paramFloat, localArrayList);
      }
      ((MovieSegmentModel)paramList1.get(i)).getVideoResourceModels().add(localMediaClipModel.getResource());
      i += 1;
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
    if ((bool) && (paramList1.size() > 1))
    {
      paramList = separateClip((MediaClipModel)((List)localObject).get(0), paramList1);
    }
    else
    {
      paramList = (List<MediaClipModel>)localObject;
      if (isAllVideoClip((List)localObject))
      {
        paramList = (List<MediaClipModel>)localObject;
        if (((List)localObject).size() < paramList1.size())
        {
          paramList = (List<MediaClipModel>)localObject;
          if (!bool) {
            paramList = separateClips((List)localObject, paramList1, paramLong);
          }
        }
      }
    }
    bool = isNeedCycleFill(paramList);
    localObject = paramList1.iterator();
    while (((Iterator)localObject).hasNext())
    {
      MovieSegmentModel localMovieSegmentModel = (MovieSegmentModel)((Iterator)localObject).next();
      if ((paramList == null) || (paramList.isEmpty())) {
        break;
      }
      Logger.d("LightSegmentHelper", "fillSegments begin");
      fillSegments(localMovieSegmentModel, paramList, bool);
      Logger.d("LightSegmentHelper", "fillSegments end");
    }
    return fillSegmentToClipAsset(paramList1, paramFloat);
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
    if ((paramMovieSegmentModel != null) && (paramList != null))
    {
      if (paramList.isEmpty()) {
        return false;
      }
      MediaClipModel localMediaClipModel;
      if (paramBoolean)
      {
        localMediaClipModel = (MediaClipModel)paramList.remove(0);
        paramList.add(localMediaClipModel.deepCopy());
      }
      else
      {
        localMediaClipModel = (MediaClipModel)paramList.remove(0);
      }
      if (localMediaClipModel == null) {
        return false;
      }
      int i = localMediaClipModel.getResource().getType();
      if (i != 1)
      {
        if (i != 2) {
          return true;
        }
        fillPhotoSegment(localMediaClipModel, paramMovieSegmentModel);
        return true;
      }
      fillVideoSegment(localMediaClipModel, paramMovieSegmentModel, paramList);
      return true;
    }
    return false;
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
    if (paramArrayOfClipPlaceHolder != null)
    {
      if (paramArrayOfClipPlaceHolder.length == 0) {
        i = 1;
      } else {
        i = 0;
      }
      if (i != 0) {
        return false;
      }
      int j = paramArrayOfClipPlaceHolder.length;
      int i = 0;
      while (i < j)
      {
        if (paramArrayOfClipPlaceHolder[i].contentDuration != 0L) {
          return false;
        }
        i += 1;
      }
      return true;
    }
    return false;
  }
  
  @VisibleForTesting
  @NotNull
  public final List<MovieSegmentModel> parseLightSegmentInfo(@Nullable ClipPlaceHolder[] paramArrayOfClipPlaceHolder)
  {
    if (paramArrayOfClipPlaceHolder != null)
    {
      int i = paramArrayOfClipPlaceHolder.length;
      int j = 0;
      if (i == 0) {
        i = 1;
      } else {
        i = 0;
      }
      if (i == 0)
      {
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
    }
    return CollectionsKt.emptyList();
  }
  
  @Nullable
  public final List<MediaClipModel> separateClip(@NotNull MediaClipModel paramMediaClipModel, @NotNull List<? extends MovieSegmentModel> paramList)
  {
    Intrinsics.checkParameterIsNotNull(paramMediaClipModel, "clip");
    Intrinsics.checkParameterIsNotNull(paramList, "mLightSegments");
    List localList = (List)new ArrayList();
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      Object localObject1 = (MovieSegmentModel)paramList.next();
      if (localObject1 != null)
      {
        Object localObject2 = ((MovieSegmentModel)localObject1).getTimeRange();
        Intrinsics.checkExpressionValueIsNotNull(localObject2, "segment.timeRange");
        if (((CMTimeRange)localObject2).getDurationUs() >= paramMediaClipModel.getResource().getSelectTimeDurationUs())
        {
          localList.add(paramMediaClipModel);
          return localList;
        }
        localObject2 = paramMediaClipModel.getResource();
        CMTimeRange localCMTimeRange = ((MovieSegmentModel)localObject1).getTimeRange();
        Intrinsics.checkExpressionValueIsNotNull(localCMTimeRange, "segment.timeRange");
        long l2 = localCMTimeRange.getDurationUs();
        localObject1 = ((MovieSegmentModel)localObject1).getTimeRange();
        Intrinsics.checkExpressionValueIsNotNull(localObject1, "segment.timeRange");
        long l3 = ((CMTimeRange)localObject1).getDurationUs();
        long l1 = 1000;
        localObject1 = MediaClipModel.copy$default(paramMediaClipModel, VideoResourceModel.copy$default((VideoResourceModel)localObject2, null, l3 / l1, 0, 0L, 0L, paramMediaClipModel.getResource().getSelectTimeStartUs(), l2, 0L, 0L, 0, 0, 0, null, 8093, null), null, null, null, null, 0L, null, 126, null);
        localList.add(localObject1);
        l2 = paramMediaClipModel.getResource().getSelectTimeDurationUs() - ((MediaClipModel)localObject1).getResource().getSelectTimeDurationUs();
        localObject2 = paramMediaClipModel.getResource();
        l3 = ((MediaClipModel)localObject1).getResource().getSelectTimeStartUs();
        long l4 = ((MediaClipModel)localObject1).getResource().getSelectTimeDurationUs();
        paramMediaClipModel = MediaClipModel.copy$default(paramMediaClipModel, VideoResourceModel.copy$default((VideoResourceModel)localObject2, null, l2 / l1, 0, 0L, 0L, l3 + l4, l2, 0L, 0L, 0, 0, 0, null, 8093, null), null, null, null, null, 0L, null, 126, null);
      }
    }
    return localList;
  }
  
  @Nullable
  public final List<MediaClipModel> separateClips(@Nullable List<MediaClipModel> paramList, @NotNull List<? extends MovieSegmentModel> paramList1, long paramLong)
  {
    Intrinsics.checkParameterIsNotNull(paramList1, "lightSegments");
    List localList = (List)new ArrayList();
    Map localMap = (Map)new ConcurrentHashMap(16);
    long l3 = 0L;
    if (paramLong <= 0L) {
      return localList;
    }
    if (paramList == null) {
      Intrinsics.throwNpe();
    }
    Object localObject1 = paramList.iterator();
    long l1 = 0L;
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (MediaClipModel)((Iterator)localObject1).next();
      if ((localObject2 != null) && (((MediaClipModel)localObject2).getResource().getSelectTimeDurationUs() != 0L)) {
        l1 += ((MediaClipModel)localObject2).getResource().getSelectTimeDurationUs();
      } else {
        ((Iterator)localObject1).remove();
      }
    }
    if (l1 <= 0L) {
      return localList;
    }
    Object localObject2 = paramList.iterator();
    long l2;
    while (((Iterator)localObject2).hasNext())
    {
      localObject1 = (MediaClipModel)((Iterator)localObject2).next();
      long l4 = ((MediaClipModel)localObject1).getResource().getSelectTimeDurationUs();
      long l5 = l4 * paramLong / l1;
      l2 = l5;
      if (l4 < l5) {
        l2 = l4;
      }
      localObject1 = ((MediaClipModel)localObject1).getResource().getPath();
      if (localObject1 == null) {
        localObject1 = "";
      }
      localMap.put(localObject1, Long.valueOf(l2));
    }
    int j = ((Collection)paramList1).size();
    int i = 0;
    paramLong = l3;
    while (i < j)
    {
      if (paramList.isEmpty()) {
        return localList;
      }
      localObject1 = ((MovieSegmentModel)paramList1.get(i)).getTimeRange();
      Intrinsics.checkExpressionValueIsNotNull(localObject1, "segment.timeRange");
      l1 = ((CMTimeRange)localObject1).getDurationUs();
      while ((l1 > paramLong) && ((((Collection)paramList).isEmpty() ^ true)))
      {
        localObject1 = (MediaClipModel)paramList.remove(0);
        l3 = ((MediaClipModel)localObject1).getResource().getSelectTimeDurationUs();
        localObject2 = localList.iterator();
        while (((Iterator)localObject2).hasNext())
        {
          MediaClipModel localMediaClipModel = (MediaClipModel)((Iterator)localObject2).next();
          l2 = paramLong;
          if (TextUtils.equals((CharSequence)localMediaClipModel.getResource().getPath(), (CharSequence)((MediaClipModel)localObject1).getResource().getPath())) {
            l2 = paramLong + localMediaClipModel.getResource().getSelectTimeDurationUs();
          }
          paramLong = l2;
        }
        localObject2 = localMap.get(((MediaClipModel)localObject1).getResource().getPath());
        if (localObject2 == null) {
          Intrinsics.throwNpe();
        }
        if ((paramLong <= ((Number)localObject2).longValue()) && (l3 > 0L) && ((paramLong == 0L) || (l3 >= l1)))
        {
          if (l3 > l1) {
            paramLong = l1;
          } else {
            paramLong = l3;
          }
          localObject2 = ((MediaClipModel)localObject1).getResource();
          l2 = 1000;
          localList.add(MediaClipModel.copy$default((MediaClipModel)localObject1, VideoResourceModel.copy$default((VideoResourceModel)localObject2, null, paramLong / l2, 0, 0L, 0L, 0L, paramLong, 0L, 0L, 0, 0, 0, null, 8125, null), null, null, null, null, 0L, null, 126, null));
          paramLong = l3 - l1;
          if (paramLong > 0L) {
            paramList.add(0, MediaClipModel.copy$default((MediaClipModel)localObject1, VideoResourceModel.copy$default(((MediaClipModel)localObject1).getResource(), null, paramLong / l2, 0, 0L, 0L, ((MediaClipModel)localObject1).getResource().getSelectTimeStartUs() + l1, paramLong, 0L, 0L, 0, 0, 0, null, 8093, null), null, null, null, null, 0L, null, 126, null));
          }
          l1 -= l3;
        }
        paramLong = 0L;
      }
      i += 1;
    }
    return localList;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.qcircle.weseevideo.model.template.light.LightSegmentHelper
 * JD-Core Version:    0.7.0.1
 */