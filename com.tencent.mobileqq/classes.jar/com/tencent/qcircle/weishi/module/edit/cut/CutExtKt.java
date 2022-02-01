package com.tencent.qcircle.weishi.module.edit.cut;

import com.tencent.qcircle.weseevideo.camera.mvauto.redo.CutModelKt;
import com.tencent.qcircle.weseevideo.camera.mvauto.redo.VideoResourceModelKt;
import com.tencent.qcircle.weseevideo.model.effect.VideoTransitionModel;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"calculateClipSeek", "", "clips", "", "Lcom/tencent/qcircle/weseevideo/camera/mvauto/redo/CutModelKt;", "transitions", "Lcom/tencent/qcircle/weseevideo/model/effect/VideoTransitionModel;", "clipUuid", "", "calculateDeleteSeek", "deleteUuid", "calculateReorderSeek", "uuid", "targetIndex", "", "calculateSpeedSeek", "speedUuid", "getIndexdTransition", "getLocateClip", "indicatorTimeMs", "libtavcut_debug"}, k=2, mv={1, 1, 16})
public final class CutExtKt
{
  public static final long calculateClipSeek(@NotNull List<CutModelKt> paramList, @NotNull List<? extends VideoTransitionModel> paramList1, @NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramList, "clips");
    Intrinsics.checkParameterIsNotNull(paramList1, "transitions");
    Intrinsics.checkParameterIsNotNull(paramString, "clipUuid");
    Iterator localIterator1 = ((Iterable)paramList).iterator();
    long l1 = 0L;
    int i = 0;
    while (localIterator1.hasNext())
    {
      paramList = localIterator1.next();
      if (i < 0) {
        CollectionsKt.throwIndexOverflow();
      }
      paramList = (CutModelKt)paramList;
      if (Intrinsics.areEqual(paramList.getUuid(), paramString)) {
        return l1;
      }
      long l2 = l1 + paramList.getResource().getScaleDuration();
      Iterator localIterator2 = ((Iterable)paramList1).iterator();
      while (localIterator2.hasNext())
      {
        paramList = localIterator2.next();
        int j;
        if (((VideoTransitionModel)paramList).getTransitionPosition() == i) {
          j = 1;
        } else {
          j = 0;
        }
        if (j != 0) {
          break label149;
        }
      }
      paramList = null;
      label149:
      paramList = (VideoTransitionModel)paramList;
      l1 = l2;
      if (paramList != null) {
        l1 = l2 - (int)(paramList.getOverlapTime() / paramList.getSpeed());
      }
      i += 1;
    }
    return -1L;
  }
  
  public static final long calculateDeleteSeek(@NotNull List<CutModelKt> paramList, @NotNull List<? extends VideoTransitionModel> paramList1, @NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramList, "clips");
    Intrinsics.checkParameterIsNotNull(paramList1, "transitions");
    Intrinsics.checkParameterIsNotNull(paramString, "deleteUuid");
    Object localObject = (CutModelKt)CollectionsKt.lastOrNull(paramList);
    if (localObject != null) {
      localObject = ((CutModelKt)localObject).getUuid();
    } else {
      localObject = null;
    }
    if (Intrinsics.areEqual(localObject, paramString)) {
      return -1L;
    }
    localObject = ((Iterable)paramList).iterator();
    long l1 = 0L;
    int i = 0;
    while (((Iterator)localObject).hasNext())
    {
      paramList = ((Iterator)localObject).next();
      if (i < 0) {
        CollectionsKt.throwIndexOverflow();
      }
      paramList = (CutModelKt)paramList;
      if (Intrinsics.areEqual(paramList.getUuid(), paramString)) {
        return l1;
      }
      long l2 = l1 + paramList.getResource().getScaleDuration();
      Iterator localIterator = ((Iterable)paramList1).iterator();
      while (localIterator.hasNext())
      {
        paramList = localIterator.next();
        int j;
        if (((VideoTransitionModel)paramList).getTransitionPosition() == i) {
          j = 1;
        } else {
          j = 0;
        }
        if (j != 0) {
          break label189;
        }
      }
      paramList = null;
      label189:
      paramList = (VideoTransitionModel)paramList;
      l1 = l2;
      if (paramList != null) {
        l1 = l2 - (int)(paramList.getOverlapTime() / paramList.getSpeed());
      }
      i += 1;
    }
    return -1L;
  }
  
  public static final long calculateReorderSeek(@NotNull List<CutModelKt> paramList, @NotNull List<? extends VideoTransitionModel> paramList1, @NotNull String paramString, int paramInt)
  {
    Intrinsics.checkParameterIsNotNull(paramList, "clips");
    Intrinsics.checkParameterIsNotNull(paramList1, "transitions");
    Intrinsics.checkParameterIsNotNull(paramString, "uuid");
    Object localObject = paramList.iterator();
    int i = 0;
    while (((Iterator)localObject).hasNext())
    {
      if (Intrinsics.areEqual(((CutModelKt)((Iterator)localObject).next()).getUuid(), paramString)) {
        break label74;
      }
      i += 1;
    }
    i = -1;
    label74:
    if (i < paramInt) {
      i = 1;
    } else {
      i = 0;
    }
    paramList = (Iterable)paramList.subList(0, paramInt + i);
    localObject = (Collection)new ArrayList(CollectionsKt.collectionSizeOrDefault(paramList, 10));
    Iterator localIterator1 = paramList.iterator();
    paramInt = 0;
    while (localIterator1.hasNext())
    {
      paramList = localIterator1.next();
      if (paramInt < 0) {
        CollectionsKt.throwIndexOverflow();
      }
      CutModelKt localCutModelKt = (CutModelKt)paramList;
      Iterator localIterator2 = ((Iterable)paramList1).iterator();
      while (localIterator2.hasNext())
      {
        paramList = localIterator2.next();
        if (((VideoTransitionModel)paramList).getTransitionPosition() == paramInt) {
          i = 1;
        } else {
          i = 0;
        }
        if (i != 0) {
          break label222;
        }
      }
      paramList = null;
      label222:
      ((Collection)localObject).add(new Pair(localCutModelKt, paramList));
      paramInt += 1;
    }
    paramList1 = (Iterable)localObject;
    paramList = (Collection)new ArrayList();
    paramList1 = paramList1.iterator();
    while (paramList1.hasNext())
    {
      localObject = paramList1.next();
      if ((Intrinsics.areEqual(((CutModelKt)((Pair)localObject).getFirst()).getUuid(), paramString) ^ true)) {
        paramList.add(localObject);
      }
    }
    paramList = ((Iterable)paramList).iterator();
    long l2;
    for (long l1 = 0L; paramList.hasNext(); l1 = l1 + ((CutModelKt)paramList1.getFirst()).getResource().getScaleDuration() - l2)
    {
      paramList1 = (Pair)paramList.next();
      paramString = (VideoTransitionModel)paramList1.getSecond();
      if (paramString != null) {
        l2 = (paramString.getOverlapTime() / paramString.getSpeed());
      } else {
        l2 = 0L;
      }
    }
    return l1;
  }
  
  public static final long calculateSpeedSeek(@NotNull List<CutModelKt> paramList, @NotNull List<? extends VideoTransitionModel> paramList1, @NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramList, "clips");
    Intrinsics.checkParameterIsNotNull(paramList1, "transitions");
    Intrinsics.checkParameterIsNotNull(paramString, "speedUuid");
    Iterator localIterator1 = ((Iterable)paramList).iterator();
    long l1 = 0L;
    int i = 0;
    while (localIterator1.hasNext())
    {
      paramList = localIterator1.next();
      if (i < 0) {
        CollectionsKt.throwIndexOverflow();
      }
      paramList = (CutModelKt)paramList;
      if (Intrinsics.areEqual(paramList.getUuid(), paramString)) {
        return l1;
      }
      long l2 = l1 + paramList.getResource().getScaleDuration();
      Iterator localIterator2 = ((Iterable)paramList1).iterator();
      while (localIterator2.hasNext())
      {
        paramList = localIterator2.next();
        int j;
        if (((VideoTransitionModel)paramList).getTransitionPosition() == i) {
          j = 1;
        } else {
          j = 0;
        }
        if (j != 0) {
          break label149;
        }
      }
      paramList = null;
      label149:
      paramList = (VideoTransitionModel)paramList;
      l1 = l2;
      if (paramList != null) {
        l1 = l2 - (int)(paramList.getOverlapTime() / paramList.getSpeed());
      }
      i += 1;
    }
    return -1L;
  }
  
  @Nullable
  public static final VideoTransitionModel getIndexdTransition(@NotNull List<? extends VideoTransitionModel> paramList, int paramInt)
  {
    Intrinsics.checkParameterIsNotNull(paramList, "transitions");
    Iterator localIterator = ((Iterable)paramList).iterator();
    while (localIterator.hasNext())
    {
      paramList = localIterator.next();
      int i;
      if (((VideoTransitionModel)paramList).getTransitionPosition() == paramInt) {
        i = 1;
      } else {
        i = 0;
      }
      if (i != 0) {
        break label59;
      }
    }
    paramList = null;
    label59:
    return (VideoTransitionModel)paramList;
  }
  
  @Nullable
  public static final CutModelKt getLocateClip(long paramLong, @NotNull List<CutModelKt> paramList, @NotNull List<? extends VideoTransitionModel> paramList1)
  {
    Intrinsics.checkParameterIsNotNull(paramList, "clips");
    Intrinsics.checkParameterIsNotNull(paramList1, "transitions");
    Iterator localIterator1 = ((Iterable)paramList).iterator();
    int i = 0;
    for (;;)
    {
      boolean bool = localIterator1.hasNext();
      Object localObject = null;
      if (!bool) {
        break;
      }
      paramList = localIterator1.next();
      if (i < 0) {
        CollectionsKt.throwIndexOverflow();
      }
      CutModelKt localCutModelKt = (CutModelKt)paramList;
      Iterator localIterator2 = ((Iterable)paramList1).iterator();
      int j;
      do
      {
        paramList = localObject;
        if (!localIterator2.hasNext()) {
          break;
        }
        paramList = localIterator2.next();
        if (((VideoTransitionModel)paramList).getTransitionPosition() == i) {
          j = 1;
        } else {
          j = 0;
        }
      } while (j == 0);
      paramList = (VideoTransitionModel)paramList;
      long l = paramLong;
      if (paramList != null) {
        l = paramLong + (int)(paramList.getOverlapTime() / paramList.getSpeed());
      }
      if (localCutModelKt.getResource().getScaleDuration() >= l) {
        return localCutModelKt;
      }
      paramLong = l - localCutModelKt.getResource().getScaleDuration();
      i += 1;
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.qcircle.weishi.module.edit.cut.CutExtKt
 * JD-Core Version:    0.7.0.1
 */