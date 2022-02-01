package com.tencent.tavkit.composition.resource;

import android.util.SparseArray;
import com.tencent.tav.coremedia.CGSize;
import com.tencent.tav.coremedia.CMTime;
import com.tencent.tav.coremedia.CMTimeRange;
import com.tencent.tavkit.ciimage.CIImage;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/tavkit/composition/resource/TAVLoopImageResource;", "Lcom/tencent/tavkit/composition/resource/TAVResource;", "images", "", "Lcom/tencent/tavkit/ciimage/CIImage;", "interval", "Lcom/tencent/tav/coremedia/CMTime;", "duration", "(Ljava/util/List;Lcom/tencent/tav/coremedia/CMTime;Lcom/tencent/tav/coremedia/CMTime;)V", "ciImageHashMap", "Ljava/lang/ThreadLocal;", "Landroid/util/SparseArray;", "clone", "imageAtTime", "time", "renderSize", "Lcom/tencent/tav/coremedia/CGSize;", "tavkit_release"}, k=1, mv={1, 1, 15})
public final class TAVLoopImageResource
  extends TAVResource
{
  private final ThreadLocal<SparseArray<CIImage>> ciImageHashMap;
  private final List<CIImage> images;
  private final CMTime interval;
  
  public TAVLoopImageResource(@NotNull List<? extends CIImage> paramList, @NotNull CMTime paramCMTime1, @NotNull CMTime paramCMTime2)
  {
    this.images = paramList;
    this.interval = paramCMTime1;
    this.ciImageHashMap = new ThreadLocal();
    setDuration(paramCMTime2);
    setSourceTimeRange(new CMTimeRange(CMTime.CMTimeZero, paramCMTime2));
  }
  
  @NotNull
  public TAVResource clone()
  {
    List localList = this.images;
    CMTime localCMTime1 = this.interval;
    CMTime localCMTime2 = this.duration;
    Intrinsics.checkExpressionValueIsNotNull(localCMTime2, "duration");
    return (TAVResource)new TAVLoopImageResource(localList, localCMTime1, localCMTime2);
  }
  
  @Nullable
  public CIImage imageAtTime(@NotNull CMTime paramCMTime, @NotNull CGSize paramCGSize)
  {
    Intrinsics.checkParameterIsNotNull(paramCMTime, "time");
    Intrinsics.checkParameterIsNotNull(paramCGSize, "renderSize");
    if (!this.sourceTimeRange.containsTime(paramCMTime)) {}
    while (this.images.isEmpty()) {
      return null;
    }
    ThreadLocal localThreadLocal = this.ciImageHashMap;
    paramCGSize = localThreadLocal.get();
    if (paramCGSize != null) {}
    int i;
    for (;;)
    {
      paramCGSize = (SparseArray)paramCGSize;
      i = (int)(paramCMTime.getTimeUs() / this.interval.getTimeUs() % this.images.size());
      paramCMTime = (CIImage)paramCGSize.get(i);
      if (paramCMTime == null) {
        break;
      }
      paramCMTime.reset();
      return paramCMTime;
      paramCGSize = new SparseArray();
      localThreadLocal.set(paramCGSize);
    }
    paramCGSize.put(i, ((CIImage)this.images.get(i)).clone());
    return (CIImage)paramCGSize.get(i);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.tavkit.composition.resource.TAVLoopImageResource
 * JD-Core Version:    0.7.0.1
 */