package com.tencent.mobileqq.kandian.biz.publisher.impls;

import com.tencent.tkd.topicsdk.framework.eventdispatch.IEvent;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/kandian/biz/publisher/impls/TopicCoverChangeEvent;", "Lcom/tencent/tkd/topicsdk/framework/eventdispatch/IEvent;", "coverPath", "", "(Ljava/lang/String;)V", "getCoverPath", "()Ljava/lang/String;", "setCoverPath", "kandian_feature_impl_release"}, k=1, mv={1, 1, 16})
public final class TopicCoverChangeEvent
  implements IEvent
{
  @Nullable
  private String a;
  
  public TopicCoverChangeEvent(@Nullable String paramString)
  {
    this.a = paramString;
  }
  
  @Nullable
  public final String a()
  {
    return this.a;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.publisher.impls.TopicCoverChangeEvent
 * JD-Core Version:    0.7.0.1
 */