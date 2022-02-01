package com.tencent.tkd.topicsdk;

import java.lang.ref.WeakReference;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "it", "Ljava/lang/ref/WeakReference;", "Lcom/tencent/tkd/topicsdk/TopicConfig$TopicListener;", "kotlin.jvm.PlatformType", "invoke"}, k=3, mv={1, 1, 16})
final class TopicConfig$removeListener$1
  extends Lambda
  implements Function1<WeakReference<TopicConfig.TopicListener>, Boolean>
{
  TopicConfig$removeListener$1(TopicConfig.TopicListener paramTopicListener)
  {
    super(1);
  }
  
  public final boolean invoke(WeakReference<TopicConfig.TopicListener> paramWeakReference)
  {
    return Intrinsics.areEqual((TopicConfig.TopicListener)paramWeakReference.get(), this.$listener);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.tkd.topicsdk.TopicConfig.removeListener.1
 * JD-Core Version:    0.7.0.1
 */