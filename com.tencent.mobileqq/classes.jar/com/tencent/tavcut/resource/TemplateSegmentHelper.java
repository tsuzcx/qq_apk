package com.tencent.tavcut.resource;

import android.text.TextUtils;
import com.tencent.tavcut.model.ClipSource;
import com.tencent.tavcut.model.ClipSource.ClipType;
import com.tencent.tavcut.model.Painting;
import com.tencent.tavcut.render.RenderConfig;
import com.tencent.tavcut.render.builder.light.LightEntityTransHelper;
import com.tencent.tavcut.rendermodel.RenderModel;
import com.tencent.tavcut.rendermodel.parser.TemplateParser;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.List<Lcom.tencent.tavcut.model.ClipSource;>;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.light.AudioOutputConfig;
import org.light.ClipAsset;
import org.light.ClipInfo;
import org.light.ClipPlaceHolder;
import org.light.LightAsset;
import org.light.LightEngine;
import org.light.MovieController;
import org.light.RendererConfig;
import org.light.TimeRange;
import org.light.VideoOutputConfig;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/tavcut/resource/TemplateSegmentHelper;", "", "()V", "fillClips", "", "segment", "Lcom/tencent/tavcut/resource/TemplateSegmentHelper$SegmentModel;", "musicVolume", "", "clips", "", "Lcom/tencent/tavcut/model/ClipSource;", "fillOriginClipsToEmptySegmentTemplate", "", "originClips", "lightSegments", "fillOriginResToClipAsset", "duration", "", "fillPhotoClips", "videoRes", "fillPhotoSegment", "mediaClip", "fillSegmentToClipAsset", "fillSegments", "", "remainClips", "mNeedCycleFill", "fillTemplate", "Lcom/tencent/tavcut/rendermodel/RenderModel;", "renderModel", "fillVideoClips", "fillVideoSegment", "isAllPhotoClip", "isAllVideoClip", "movieClips", "isFullFilled", "clipPlaceHolders", "", "Lorg/light/ClipPlaceHolder;", "segments", "([Lorg/light/ClipPlaceHolder;Ljava/util/List;)Z", "isNeedCycleFill", "isNoDurationLimitTemplate", "clipHolders", "([Lorg/light/ClipPlaceHolder;)Z", "isSingleVideo", "parseLightSegmentInfo", "([Lorg/light/ClipPlaceHolder;)Ljava/util/List;", "separateClip", "clip", "mLightSegments", "separateClips", "sumOf", "T", "selector", "Lkotlin/Function1;", "([Ljava/lang/Object;Lkotlin/jvm/functions/Function1;)J", "SegmentModel", "SegmentTimeRange", "lib_tavcut_release"}, k=1, mv={1, 1, 16})
public final class TemplateSegmentHelper
{
  public static final TemplateSegmentHelper a = new TemplateSegmentHelper();
  
  private final List<ClipSource> a(ClipSource paramClipSource, List<TemplateSegmentHelper.SegmentModel> paramList)
  {
    List localList = (List)new ArrayList();
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      Object localObject = (TemplateSegmentHelper.SegmentModel)paramList.next();
      if (localObject != null)
      {
        if (((TemplateSegmentHelper.SegmentModel)localObject).a().a() >= paramClipSource.duration)
        {
          localList.add(paramClipSource);
          return localList;
        }
        localObject = ClipSource.copy$default(paramClipSource, null, null, null, ((TemplateSegmentHelper.SegmentModel)localObject).a().a(), null, null, paramClipSource.startOffset, null, null, null, null, null, 4023, null);
        localList.add(localObject);
        long l2 = paramClipSource.duration;
        long l3 = ((ClipSource)localObject).duration;
        Long localLong = ((ClipSource)localObject).startOffset;
        long l1;
        if (localLong != null) {
          l1 = localLong.longValue();
        } else {
          l1 = 0L;
        }
        paramClipSource = ClipSource.copy$default(paramClipSource, null, null, null, l2 - l3, null, null, Long.valueOf(l1 + ((ClipSource)localObject).duration), null, null, null, null, null, 4023, null);
      }
    }
    return localList;
  }
  
  private final List<ClipSource> a(List<TemplateSegmentHelper.SegmentModel> paramList, float paramFloat)
  {
    List localList = (List)new ArrayList();
    paramList = paramList.iterator();
    while (paramList.hasNext()) {
      a((TemplateSegmentHelper.SegmentModel)paramList.next(), paramFloat, localList);
    }
    return localList;
  }
  
  private final List<ClipSource> a(List<ClipSource> paramList, List<TemplateSegmentHelper.SegmentModel> paramList1, float paramFloat, long paramLong)
  {
    Object localObject = CollectionsKt.toMutableList((Collection)paramList);
    boolean bool = a((List)localObject);
    if ((bool) && (paramList1.size() > 1))
    {
      paramList = a((ClipSource)((List)localObject).get(0), paramList1);
    }
    else
    {
      paramList = (List<ClipSource>)localObject;
      if (c((List)localObject))
      {
        paramList = (List<ClipSource>)localObject;
        if (((List)localObject).size() < paramList1.size())
        {
          paramList = (List<ClipSource>)localObject;
          if (!bool) {
            paramList = a((List)localObject, paramList1, paramLong);
          }
        }
      }
    }
    bool = d(paramList);
    localObject = paramList1.iterator();
    while (((Iterator)localObject).hasNext())
    {
      TemplateSegmentHelper.SegmentModel localSegmentModel = (TemplateSegmentHelper.SegmentModel)((Iterator)localObject).next();
      if (paramList.isEmpty()) {
        break;
      }
      a(localSegmentModel, paramList, bool);
    }
    return a(paramList1, paramFloat);
  }
  
  private final List<ClipSource> a(List<ClipSource> paramList, List<TemplateSegmentHelper.SegmentModel> paramList1, long paramLong)
  {
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
      localObject2 = (ClipSource)((Iterator)localObject1).next();
      if ((localObject2 != null) && (((ClipSource)localObject2).duration != 0L)) {
        l1 += ((ClipSource)localObject2).duration;
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
      localObject1 = (ClipSource)((Iterator)localObject2).next();
      long l4 = ((ClipSource)localObject1).duration;
      long l5 = l4 * paramLong / l1;
      l2 = l5;
      if (l4 < l5) {
        l2 = l4;
      }
      localObject1 = ((ClipSource)localObject1).path;
      if (localObject1 == null) {
        localObject1 = "";
      }
      localMap.put(localObject1, Long.valueOf(l2));
    }
    int j = ((Collection)paramList1).size();
    int i = 0;
    l1 = l3;
    while (i < j)
    {
      if (paramList.isEmpty()) {
        return localList;
      }
      paramLong = ((TemplateSegmentHelper.SegmentModel)paramList1.get(i)).a().a();
      while ((paramLong > l1) && ((((Collection)paramList).isEmpty() ^ true)))
      {
        localObject1 = (ClipSource)paramList.remove(0);
        l3 = ((ClipSource)localObject1).duration;
        localObject2 = localList.iterator();
        while (((Iterator)localObject2).hasNext())
        {
          ClipSource localClipSource = (ClipSource)((Iterator)localObject2).next();
          l2 = l1;
          if (TextUtils.equals((CharSequence)localClipSource.path, (CharSequence)((ClipSource)localObject1).path)) {
            l2 = l1 + localClipSource.duration;
          }
          l1 = l2;
        }
        localObject2 = localMap.get(((ClipSource)localObject1).path);
        if (localObject2 == null) {
          Intrinsics.throwNpe();
        }
        if ((l1 <= ((Number)localObject2).longValue()) && (l3 > 0L))
        {
          if ((l1 != 0L) && (l3 < paramLong)) {
            break label594;
          }
          if (l3 > paramLong) {
            l1 = paramLong;
          } else {
            l1 = l3;
          }
          localList.add(ClipSource.copy$default((ClipSource)localObject1, null, null, null, l1, null, null, null, null, null, null, null, null, 4087, null));
          l2 = l3 - paramLong;
          if (l2 > 0L)
          {
            localObject2 = ((ClipSource)localObject1).startOffset;
            if (localObject2 != null) {
              l1 = ((Long)localObject2).longValue();
            } else {
              l1 = 0L;
            }
            paramList.add(0, ClipSource.copy$default((ClipSource)localObject1, null, null, null, l2, null, null, Long.valueOf(l1 + paramLong), null, null, null, null, null, 4023, null));
          }
          paramLong -= l3;
        }
        label594:
        l1 = 0L;
      }
      i += 1;
    }
    return localList;
  }
  
  private final void a(ClipSource paramClipSource, float paramFloat, List<ClipSource> paramList)
  {
    if (paramClipSource == null) {
      return;
    }
    ClipSource.ClipType localClipType = ClipSource.ClipType.VIDEO;
    String str = paramClipSource.path;
    Float localFloat = paramClipSource.volume;
    Long localLong = paramClipSource.startOffset;
    paramList.add(new ClipSource(null, str, localClipType, paramClipSource.duration, paramClipSource.speed, localFloat, localLong, null, null, null, null, null, 3969, null));
  }
  
  private final void a(ClipSource paramClipSource, TemplateSegmentHelper.SegmentModel paramSegmentModel)
  {
    paramClipSource = ClipSource.copy$default(paramClipSource, null, null, null, paramSegmentModel.a().a(), null, null, null, null, null, null, null, null, 4087, null);
    paramSegmentModel.b().add(paramClipSource);
  }
  
  private final void a(ClipSource paramClipSource, TemplateSegmentHelper.SegmentModel paramSegmentModel, List<ClipSource> paramList)
  {
    List localList = (List)new ArrayList();
    long l1 = paramSegmentModel.a().a();
    while (l1 > 0L)
    {
      long l2 = paramClipSource.duration;
      ClipSource.ClipType localClipType = paramClipSource.type;
      int i;
      if ((localList.isEmpty()) && (localClipType == ClipSource.ClipType.VIDEO) && (l2 > l1)) {
        i = 1;
      } else {
        i = 0;
      }
      Object localObject;
      long l3;
      if (i != 0)
      {
        long l4 = (l2 - l1) / 2;
        localObject = paramClipSource.startOffset;
        if (localObject != null) {
          l3 = ((Long)localObject).longValue();
        } else {
          l3 = 0L;
        }
        paramClipSource = ClipSource.copy$default(paramClipSource, null, null, null, l1, null, null, Long.valueOf(l3 + l4), null, null, null, null, null, 4023, null);
        l3 = l2;
      }
      else
      {
        localObject = paramClipSource;
        if (localClipType == ClipSource.ClipType.PHOTO)
        {
          localObject = ClipSource.copy$default(paramClipSource, null, null, null, l1, null, null, Long.valueOf(0L), null, null, null, null, null, 4023, null);
          l2 = l1;
        }
        paramClipSource = (ClipSource)localObject;
        l3 = l2;
        if (l1 < l2)
        {
          paramClipSource = ClipSource.copy$default((ClipSource)localObject, null, null, null, l1, null, null, ((ClipSource)localObject).startOffset, null, null, null, null, null, 4023, null);
          l3 = l2;
        }
      }
      localList.add(paramClipSource);
      l1 -= l3;
      if (l1 > 0L)
      {
        if (paramList.size() == 0) {
          break;
        }
        paramClipSource = (ClipSource)paramList.remove(0);
      }
    }
    paramClipSource = (List)new ArrayList();
    paramList = localList.iterator();
    while (paramList.hasNext()) {
      paramClipSource.add((ClipSource)paramList.next());
    }
    paramSegmentModel.a(paramClipSource);
  }
  
  private final void a(TemplateSegmentHelper.SegmentModel paramSegmentModel, float paramFloat, List<ClipSource> paramList)
  {
    paramSegmentModel = paramSegmentModel.b().iterator();
    while (paramSegmentModel.hasNext())
    {
      ClipSource localClipSource = (ClipSource)paramSegmentModel.next();
      if (localClipSource.type == ClipSource.ClipType.VIDEO) {
        a(localClipSource, paramFloat, paramList);
      } else if (localClipSource.type == ClipSource.ClipType.PHOTO) {
        b(localClipSource, paramList);
      }
    }
  }
  
  private final boolean a(TemplateSegmentHelper.SegmentModel paramSegmentModel, List<ClipSource> paramList, boolean paramBoolean)
  {
    if (paramSegmentModel != null)
    {
      if (paramList.isEmpty()) {
        return false;
      }
      ClipSource localClipSource;
      if (paramBoolean)
      {
        localClipSource = (ClipSource)paramList.remove(0);
        paramList.add(ClipSource.copy$default(localClipSource, null, null, null, 0L, null, null, null, null, null, null, null, null, 4095, null));
      }
      else
      {
        localClipSource = (ClipSource)paramList.remove(0);
      }
      ClipSource.ClipType localClipType = localClipSource.type;
      if (localClipType == null) {
        return true;
      }
      int i = TemplateSegmentHelper.WhenMappings.$EnumSwitchMapping$0[localClipType.ordinal()];
      if (i != 1)
      {
        if (i != 2) {
          return true;
        }
        a(localClipSource, paramSegmentModel, paramList);
        return true;
      }
      a(localClipSource, paramSegmentModel);
      return true;
    }
    return false;
  }
  
  private final boolean a(List<ClipSource> paramList)
  {
    return (paramList != null) && (paramList.size() == 1) && (((ClipSource)paramList.get(0)).type == ClipSource.ClipType.VIDEO);
  }
  
  private final List<TemplateSegmentHelper.SegmentModel> b(ClipPlaceHolder[] paramArrayOfClipPlaceHolder)
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
          TemplateSegmentHelper.SegmentModel localSegmentModel = new TemplateSegmentHelper.SegmentModel();
          localSegmentModel.a(new TemplateSegmentHelper.SegmentTimeRange(0L, localClipPlaceHolder.contentDuration));
          localSegmentModel.a(localClipPlaceHolder.contentDuration);
          localArrayList.add(localSegmentModel);
          i += 1;
        }
        return (List)localArrayList;
      }
    }
    return CollectionsKt.emptyList();
  }
  
  private final void b(ClipSource paramClipSource, List<ClipSource> paramList)
  {
    if (paramClipSource == null) {
      return;
    }
    ClipSource.ClipType localClipType = ClipSource.ClipType.PHOTO;
    paramList.add(new ClipSource(null, paramClipSource.path, localClipType, paramClipSource.duration, null, null, null, null, null, null, null, null, 4081, null));
  }
  
  private final boolean b(List<ClipSource> paramList)
  {
    if (paramList.isEmpty()) {
      return false;
    }
    paramList = (Iterable)paramList;
    boolean bool1 = paramList instanceof Collection;
    boolean bool2 = true;
    if ((bool1) && (((Collection)paramList).isEmpty())) {
      return true;
    }
    paramList = paramList.iterator();
    int i;
    do
    {
      bool1 = bool2;
      if (!paramList.hasNext()) {
        break;
      }
      if (((ClipSource)paramList.next()).type == ClipSource.ClipType.PHOTO) {
        i = 1;
      } else {
        i = 0;
      }
    } while (i != 0);
    bool1 = false;
    return bool1;
  }
  
  private final boolean c(List<ClipSource> paramList)
  {
    if (paramList.isEmpty()) {
      return false;
    }
    paramList = (Iterable)paramList;
    boolean bool1 = paramList instanceof Collection;
    boolean bool2 = true;
    if ((bool1) && (((Collection)paramList).isEmpty())) {
      return true;
    }
    paramList = paramList.iterator();
    int i;
    do
    {
      bool1 = bool2;
      if (!paramList.hasNext()) {
        break;
      }
      if (((ClipSource)paramList.next()).type == ClipSource.ClipType.VIDEO) {
        i = 1;
      } else {
        i = 0;
      }
    } while (i != 0);
    bool1 = false;
    return bool1;
  }
  
  private final boolean d(List<ClipSource> paramList)
  {
    return b(paramList);
  }
  
  @Nullable
  public final RenderModel a(@Nullable RenderModel paramRenderModel)
  {
    if (paramRenderModel == null) {
      return null;
    }
    paramRenderModel.getMaxDuration();
    Object localObject1 = paramRenderModel.getClipsAssets();
    Object localObject2 = LightAsset.LoadFromString("/", TemplateParser.INSTANCE.dumpJson(RenderModel.copy$default(paramRenderModel, null, null, null, null, CollectionsKt.emptyList(), false, 0, null, null, null, 0L, 0, null, 8175, null)), 0);
    LightEngine localLightEngine = LightEngine.Make(new VideoOutputConfig(30.0F, 0), new AudioOutputConfig(), new RendererConfig(RenderConfig.a.a()));
    localLightEngine.setBGMusicHidden(false);
    localObject2 = localLightEngine.setAssetForMovie((LightAsset)localObject2);
    Intrinsics.checkExpressionValueIsNotNull(localObject2, "movieController");
    boolean bool = a(((MovieController)localObject2).getClipPlaceHolders());
    Object localObject3 = b(((MovieController)localObject2).getClipPlaceHolders());
    if (!bool) {
      localObject1 = a(paramRenderModel.getClipsAssets(), (List)localObject3, 0.0F, ((MovieController)localObject2).duration());
    }
    Object localObject4 = ((Collection)LightEntityTransHelper.a((List)localObject1)).toArray(new ClipAsset[0]);
    if (localObject4 != null)
    {
      ((MovieController)localObject2).setClipAssets((ClipAsset[])localObject4, paramRenderModel.getPainting().pagPath);
      long l1 = ((MovieController)localObject2).duration();
      if (!bool)
      {
        localObject4 = ((MovieController)localObject2).getClipPlaceHolders();
        Intrinsics.checkExpressionValueIsNotNull(localObject4, "movieController.clipPlaceHolders");
        if (!a((ClipPlaceHolder[])localObject4, (List)localObject3))
        {
          localObject3 = ((MovieController)localObject2).getClipInfos();
          Intrinsics.checkExpressionValueIsNotNull(localObject3, "movieController.clipInfos");
          localObject3 = ArraysKt.last((Object[])localObject3);
          Intrinsics.checkExpressionValueIsNotNull(localObject3, "movieController.clipInfos.last()");
          localObject3 = (ClipInfo)ArraysKt.last((Object[])localObject3);
          if (localObject3 != null) {
            l1 = ((ClipInfo)localObject3).targetTimeRange.startTime + ((ClipInfo)localObject3).targetTimeRange.duration;
          } else {
            l1 = -1L;
          }
        }
      }
      if (bool)
      {
        localObject3 = (Iterable)localObject1;
        localObject1 = (Collection)new ArrayList(CollectionsKt.collectionSizeOrDefault((Iterable)localObject3, 10));
        localObject3 = ((Iterable)localObject3).iterator();
        int i = 0;
        while (((Iterator)localObject3).hasNext())
        {
          localObject4 = ((Iterator)localObject3).next();
          if (i < 0) {
            CollectionsKt.throwIndexOverflow();
          }
          localObject4 = (ClipSource)localObject4;
          Object localObject5 = a;
          localObject5 = localObject2.getClipInfos()[i];
          Intrinsics.checkExpressionValueIsNotNull(localObject5, "movieController.clipInfos[index]");
          int k = localObject5.length;
          long l2 = 0L;
          int j = 0;
          while (j < k)
          {
            l2 += localObject5[j].sourceTimeRange.duration;
            j += 1;
          }
          ((Collection)localObject1).add(ClipSource.copy$default((ClipSource)localObject4, null, null, null, l2, null, null, null, null, null, null, null, null, 4087, null));
          i += 1;
        }
        localObject1 = (List)localObject1;
      }
      ((MovieController)localObject2).resetAsset();
      localLightEngine.release();
      return RenderModel.copy$default(paramRenderModel, null, null, null, null, (List)localObject1, false, 0, null, null, null, l1, 0, null, 7151, null);
    }
    paramRenderModel = new TypeCastException("null cannot be cast to non-null type kotlin.Array<T>");
    for (;;)
    {
      throw paramRenderModel;
    }
  }
  
  public final boolean a(@Nullable ClipPlaceHolder[] paramArrayOfClipPlaceHolder)
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
  
  public final boolean a(@NotNull ClipPlaceHolder[] paramArrayOfClipPlaceHolder, @NotNull List<TemplateSegmentHelper.SegmentModel> paramList)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfClipPlaceHolder, "clipPlaceHolders");
    Intrinsics.checkParameterIsNotNull(paramList, "segments");
    if (paramList.size() < paramArrayOfClipPlaceHolder.length) {
      return false;
    }
    paramList = (TemplateSegmentHelper.SegmentModel)CollectionsKt.lastOrNull(paramList);
    long l1 = 0L;
    long l2 = l1;
    if (paramList != null)
    {
      paramList = paramList.b();
      l2 = l1;
      if (paramList != null)
      {
        paramList = ((Iterable)paramList).iterator();
        for (;;)
        {
          l2 = l1;
          if (!paramList.hasNext()) {
            break;
          }
          l1 += ((ClipSource)paramList.next()).duration;
        }
      }
    }
    return l2 >= ((ClipPlaceHolder)ArraysKt.last(paramArrayOfClipPlaceHolder)).contentDuration;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.tavcut.resource.TemplateSegmentHelper
 * JD-Core Version:    0.7.0.1
 */