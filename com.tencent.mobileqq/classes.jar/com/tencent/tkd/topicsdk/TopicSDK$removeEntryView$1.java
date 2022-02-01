package com.tencent.tkd.topicsdk;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "resultId", "", "invoke"}, k=3, mv={1, 1, 16})
final class TopicSDK$removeEntryView$1
  extends Lambda
  implements Function1<String, Unit>
{
  TopicSDK$removeEntryView$1(Function1 paramFunction1)
  {
    super(1);
  }
  
  public final void invoke(@NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "resultId");
    Function1 localFunction1 = this.$callback;
    if (localFunction1 != null) {
      paramString = (Unit)localFunction1.invoke(paramString);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.tkd.topicsdk.TopicSDK.removeEntryView.1
 * JD-Core Version:    0.7.0.1
 */