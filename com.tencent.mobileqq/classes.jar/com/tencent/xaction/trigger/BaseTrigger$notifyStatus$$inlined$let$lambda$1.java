package com.tencent.xaction.trigger;

import android.view.View;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "status", "", "invoke", "com/tencent/xaction/trigger/BaseTrigger$notifyStatus$1$1"}, k=3, mv={1, 1, 16})
final class BaseTrigger$notifyStatus$$inlined$let$lambda$1
  extends Lambda
  implements Function1<String, Unit>
{
  BaseTrigger$notifyStatus$$inlined$let$lambda$1(BaseTrigger paramBaseTrigger, Object paramObject, String paramString, View paramView)
  {
    super(1);
  }
  
  public final void invoke(@NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "status");
    this.this$0.updateStatus(this.$view$inlined, paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.xaction.trigger.BaseTrigger.notifyStatus..inlined.let.lambda.1
 * JD-Core Version:    0.7.0.1
 */