package com.tencent.weishi.module.edit.cut;

import com.tencent.weseevideo.camera.mvauto.redo.CutModelKt;
import com.tencent.weseevideo.camera.mvauto.redo.VideoResourceModelKt;
import com.tencent.weseevideo.model.effect.VideoTransitionModel;
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

@Metadata(bv={1, 0, 3}, d1={""}, d2={"calculateClipSeek", "", "clips", "", "Lcom/tencent/weseevideo/camera/mvauto/redo/CutModelKt;", "transitions", "Lcom/tencent/weseevideo/model/effect/VideoTransitionModel;", "clipUuid", "", "calculateDeleteSeek", "deleteUuid", "calculateReorderSeek", "uuid", "targetIndex", "", "calculateSpeedSeek", "speedUuid", "getIndexdTransition", "getLocateClip", "indicatorTimeMs", "libtavcut_debug"}, k=2, mv={1, 1, 16})
public final class CutExtKt
{
  public static final long calculateClipSeek(@NotNull List<CutModelKt> paramList, @NotNull List<? extends VideoTransitionModel> paramList1, @NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramList, "clips");
    Intrinsics.checkParameterIsNotNull(paramList1, "transitions");
    Intrinsics.checkParameterIsNotNull(paramString, "clipUuid");
    Iterator localIterator1 = ((Iterable)paramList).iterator();
    long l = 0L;
    int i = 0;
    if (localIterator1.hasNext())
    {
      paramList = localIterator1.next();
      if (i < 0) {
        CollectionsKt.throwIndexOverflow();
      }
      paramList = (CutModelKt)paramList;
      if (Intrinsics.areEqual(paramList.getUuid(), paramString)) {
        return l;
      }
      l += paramList.getResource().getScaleDuration();
      Iterator localIterator2 = ((Iterable)paramList1).iterator();
      label101:
      int j;
      if (localIterator2.hasNext())
      {
        paramList = localIterator2.next();
        if (((VideoTransitionModel)paramList).getTransitionPosition() == i)
        {
          j = 1;
          label133:
          if (j == 0) {
            break label174;
          }
          label138:
          paramList = (VideoTransitionModel)paramList;
          if (paramList == null) {
            break label181;
          }
          l -= (int)(paramList.getOverlapTime() / paramList.getSpeed());
        }
      }
      label174:
      label181:
      for (;;)
      {
        i += 1;
        break;
        j = 0;
        break label133;
        break label101;
        paramList = null;
        break label138;
      }
    }
    return -1L;
  }
  
  public static final long calculateDeleteSeek(@NotNull List<CutModelKt> paramList, @NotNull List<? extends VideoTransitionModel> paramList1, @NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramList, "clips");
    Intrinsics.checkParameterIsNotNull(paramList1, "transitions");
    Intrinsics.checkParameterIsNotNull(paramString, "deleteUuid");
    Object localObject = (CutModelKt)CollectionsKt.lastOrNull(paramList);
    long l2;
    if (localObject != null)
    {
      localObject = ((CutModelKt)localObject).getUuid();
      if (!Intrinsics.areEqual(localObject, paramString)) {
        break label62;
      }
      l2 = -1L;
    }
    label62:
    long l1;
    int i;
    do
    {
      return l2;
      localObject = null;
      break;
      localObject = ((Iterable)paramList).iterator();
      l1 = 0L;
      i = 0;
      if (!((Iterator)localObject).hasNext()) {
        break label229;
      }
      paramList = ((Iterator)localObject).next();
      if (i < 0) {
        CollectionsKt.throwIndexOverflow();
      }
      paramList = (CutModelKt)paramList;
      l2 = l1;
    } while (Intrinsics.areEqual(paramList.getUuid(), paramString));
    l1 += paramList.getResource().getScaleDuration();
    Iterator localIterator = ((Iterable)paramList1).iterator();
    label146:
    int j;
    if (localIterator.hasNext())
    {
      paramList = localIterator.next();
      if (((VideoTransitionModel)paramList).getTransitionPosition() == i)
      {
        j = 1;
        label178:
        if (j == 0) {
          break label219;
        }
        label183:
        paramList = (VideoTransitionModel)paramList;
        if (paramList == null) {
          break label226;
        }
        l1 -= (int)(paramList.getOverlapTime() / paramList.getSpeed());
      }
    }
    label219:
    label226:
    for (;;)
    {
      i += 1;
      break;
      j = 0;
      break label178;
      break label146;
      paramList = null;
      break label183;
    }
    label229:
    return -1L;
  }
  
  public static final long calculateReorderSeek(@NotNull List<CutModelKt> paramList, @NotNull List<? extends VideoTransitionModel> paramList1, @NotNull String paramString, int paramInt)
  {
    Intrinsics.checkParameterIsNotNull(paramList, "clips");
    Intrinsics.checkParameterIsNotNull(paramList1, "transitions");
    Intrinsics.checkParameterIsNotNull(paramString, "uuid");
    Object localObject = paramList.iterator();
    int i = 0;
    label59:
    label68:
    label111:
    CutModelKt localCutModelKt;
    if (((Iterator)localObject).hasNext()) {
      if (Intrinsics.areEqual(((CutModelKt)((Iterator)localObject).next()).getUuid(), paramString))
      {
        if (i >= paramInt) {
          break label230;
        }
        i = 1;
        paramList = (Iterable)paramList.subList(0, i + paramInt);
        localObject = (Collection)new ArrayList(CollectionsKt.collectionSizeOrDefault(paramList, 10));
        Iterator localIterator1 = paramList.iterator();
        paramInt = 0;
        if (!localIterator1.hasNext()) {
          break label247;
        }
        paramList = localIterator1.next();
        if (paramInt < 0) {
          CollectionsKt.throwIndexOverflow();
        }
        localCutModelKt = (CutModelKt)paramList;
        Iterator localIterator2 = ((Iterable)paramList1).iterator();
        label153:
        if (!localIterator2.hasNext()) {
          break label242;
        }
        paramList = localIterator2.next();
        if (((VideoTransitionModel)paramList).getTransitionPosition() != paramInt) {
          break label236;
        }
        i = 1;
        label185:
        if (i == 0) {
          break label240;
        }
      }
    }
    for (;;)
    {
      ((Collection)localObject).add(new Pair(localCutModelKt, paramList));
      paramInt += 1;
      break label111;
      i += 1;
      break;
      i = -1;
      break label59;
      label230:
      i = 0;
      break label68;
      label236:
      i = 0;
      break label185;
      label240:
      break label153;
      label242:
      paramList = null;
    }
    label247:
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
    long l1 = 0L;
    if (paramList.hasNext())
    {
      paramList1 = (Pair)paramList.next();
      paramString = (VideoTransitionModel)paramList1.getSecond();
      if (paramString != null) {}
      for (long l2 = (paramString.getOverlapTime() / paramString.getSpeed());; l2 = 0L)
      {
        l1 = ((CutModelKt)paramList1.getFirst()).getResource().getScaleDuration() + l1 - l2;
        break;
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
    long l = 0L;
    int i = 0;
    if (localIterator1.hasNext())
    {
      paramList = localIterator1.next();
      if (i < 0) {
        CollectionsKt.throwIndexOverflow();
      }
      paramList = (CutModelKt)paramList;
      if (Intrinsics.areEqual(paramList.getUuid(), paramString)) {
        return l;
      }
      l += paramList.getResource().getScaleDuration();
      Iterator localIterator2 = ((Iterable)paramList1).iterator();
      label101:
      int j;
      if (localIterator2.hasNext())
      {
        paramList = localIterator2.next();
        if (((VideoTransitionModel)paramList).getTransitionPosition() == i)
        {
          j = 1;
          label133:
          if (j == 0) {
            break label174;
          }
          label138:
          paramList = (VideoTransitionModel)paramList;
          if (paramList == null) {
            break label181;
          }
          l -= (int)(paramList.getOverlapTime() / paramList.getSpeed());
        }
      }
      label174:
      label181:
      for (;;)
      {
        i += 1;
        break;
        j = 0;
        break label133;
        break label101;
        paramList = null;
        break label138;
      }
    }
    return -1L;
  }
  
  @Nullable
  public static final VideoTransitionModel getIndexdTransition(@NotNull List<? extends VideoTransitionModel> paramList, int paramInt)
  {
    Intrinsics.checkParameterIsNotNull(paramList, "transitions");
    Iterator localIterator = ((Iterable)paramList).iterator();
    int i;
    if (localIterator.hasNext())
    {
      paramList = localIterator.next();
      if (((VideoTransitionModel)paramList).getTransitionPosition() == paramInt)
      {
        i = 1;
        label45:
        if (i == 0) {
          break label57;
        }
      }
    }
    for (;;)
    {
      return (VideoTransitionModel)paramList;
      i = 0;
      break label45;
      label57:
      break;
      paramList = null;
    }
  }
  
  @Nullable
  public static final CutModelKt getLocateClip(long paramLong, @NotNull List<CutModelKt> paramList, @NotNull List<? extends VideoTransitionModel> paramList1)
  {
    Intrinsics.checkParameterIsNotNull(paramList, "clips");
    Intrinsics.checkParameterIsNotNull(paramList1, "transitions");
    Iterator localIterator1 = ((Iterable)paramList).iterator();
    int i = 0;
    while (localIterator1.hasNext())
    {
      paramList = localIterator1.next();
      if (i < 0) {
        CollectionsKt.throwIndexOverflow();
      }
      CutModelKt localCutModelKt = (CutModelKt)paramList;
      Iterator localIterator2 = ((Iterable)paramList1).iterator();
      int j;
      if (localIterator2.hasNext())
      {
        paramList = localIterator2.next();
        if (((VideoTransitionModel)paramList).getTransitionPosition() == i)
        {
          j = 1;
          label102:
          if (j == 0) {
            break label155;
          }
        }
      }
      long l;
      for (;;)
      {
        paramList = (VideoTransitionModel)paramList;
        l = paramLong;
        if (paramList != null) {
          l = paramLong + (int)(paramList.getOverlapTime() / paramList.getSpeed());
        }
        if (localCutModelKt.getResource().getScaleDuration() < l) {
          break label162;
        }
        return localCutModelKt;
        j = 0;
        break label102;
        label155:
        break;
        paramList = null;
      }
      label162:
      paramLong = l - localCutModelKt.getResource().getScaleDuration();
      i += 1;
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.weishi.module.edit.cut.CutExtKt
 * JD-Core Version:    0.7.0.1
 */