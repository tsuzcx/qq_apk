package com.tencent.mobileqq.triton.internal.debug;

import com.tencent.mobileqq.triton.statistic.GetTraceInfoCallback;
import com.tencent.mobileqq.triton.statistic.TraceStatistics;
import com.tencent.mobileqq.triton.statistic.TraceStatistics.Record;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Executor;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.IntIterator;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "run"}, k=3, mv={1, 1, 16})
final class JankCanaryAgent$getTraceInfo$1
  implements Runnable
{
  JankCanaryAgent$getTraceInfo$1(JankCanaryAgent paramJankCanaryAgent, GetTraceInfoCallback paramGetTraceInfoCallback) {}
  
  public final void run()
  {
    Object localObject2 = JankCanaryAgent.Companion.access$nativeGetBriefTraceInfo(JankCanaryAgent.Companion, JankCanaryAgent.access$getNativeInstancePointer$p(this.this$0), Object.class);
    Collection localCollection;
    if (localObject2 != null)
    {
      localObject1 = localObject2[0];
      if (localObject1 == null) {
        throw new TypeCastException("null cannot be cast to non-null type kotlin.Array<kotlin.Any>");
      }
      localObject1 = (Object[])localObject1;
      localObject2 = localObject2[1];
      if (localObject2 == null) {
        throw new TypeCastException("null cannot be cast to non-null type kotlin.LongArray");
      }
      localObject2 = (long[])localObject2;
      Object localObject3 = (Iterable)ArraysKt.getIndices((Object[])localObject1);
      localCollection = (Collection)new ArrayList(CollectionsKt.collectionSizeOrDefault((Iterable)localObject3, 10));
      localObject3 = ((Iterable)localObject3).iterator();
      while (((Iterator)localObject3).hasNext())
      {
        int i = ((IntIterator)localObject3).nextInt();
        Object localObject4 = localObject1[i];
        if (localObject4 == null) {
          throw new TypeCastException("null cannot be cast to non-null type kotlin.String");
        }
        localCollection.add(new TraceStatistics.Record((String)localObject4, localObject2[i]));
      }
    }
    for (Object localObject1 = new TraceStatistics((List)localCollection);; localObject1 = new TraceStatistics(CollectionsKt.emptyList()))
    {
      JankCanaryAgent.access$getMainThreadExecutor$p(this.this$0).execute((Runnable)new JankCanaryAgent.getTraceInfo.1.1(this, (TraceStatistics)localObject1));
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.triton.internal.debug.JankCanaryAgent.getTraceInfo.1
 * JD-Core Version:    0.7.0.1
 */