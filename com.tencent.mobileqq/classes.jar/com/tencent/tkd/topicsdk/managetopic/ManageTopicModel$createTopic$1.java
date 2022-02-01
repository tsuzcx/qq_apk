package com.tencent.tkd.topicsdk.managetopic;

import com.tencent.tkd.topicsdk.framework.ThreadManagerKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "errorCode", "", "errorMsg", "", "tip", "topicId", "", "invoke"}, k=3, mv={1, 1, 16})
final class ManageTopicModel$createTopic$1
  extends Lambda
  implements Function4<Integer, String, String, Long, Unit>
{
  ManageTopicModel$createTopic$1(Function4 paramFunction4)
  {
    super(4);
  }
  
  public final void invoke(int paramInt, @NotNull String paramString1, @NotNull String paramString2, long paramLong)
  {
    Intrinsics.checkParameterIsNotNull(paramString1, "errorMsg");
    Intrinsics.checkParameterIsNotNull(paramString2, "tip");
    ThreadManagerKt.a((Function0)new ManageTopicModel.createTopic.1.1(this, paramInt, paramString1, paramString2, paramLong));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.tkd.topicsdk.managetopic.ManageTopicModel.createTopic.1
 * JD-Core Version:    0.7.0.1
 */