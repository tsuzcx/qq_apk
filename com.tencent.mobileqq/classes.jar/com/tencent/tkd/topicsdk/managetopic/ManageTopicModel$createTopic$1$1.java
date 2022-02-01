package com.tencent.tkd.topicsdk.managetopic;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Lambda;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "invoke"}, k=3, mv={1, 1, 16})
final class ManageTopicModel$createTopic$1$1
  extends Lambda
  implements Function0<Unit>
{
  ManageTopicModel$createTopic$1$1(ManageTopicModel.createTopic.1 param1, int paramInt, String paramString1, String paramString2, long paramLong)
  {
    super(0);
  }
  
  public final void invoke()
  {
    this.this$0.$callback.invoke(Integer.valueOf(this.$errorCode), this.$errorMsg, this.$tip, Long.valueOf(this.$topicId));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.tkd.topicsdk.managetopic.ManageTopicModel.createTopic.1.1
 * JD-Core Version:    0.7.0.1
 */