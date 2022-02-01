package com.tencent.xaction.apng;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "it", "Lcom/tencent/xaction/apng/ApngDrawable;", "invoke"}, k=3, mv={1, 1, 16})
final class XAApngView$decor$1$bindData$1
  extends Lambda
  implements Function1<ApngDrawable, Unit>
{
  XAApngView$decor$1$bindData$1(XAApngView.decor.1 param1)
  {
    super(1);
  }
  
  public final void invoke(@NotNull ApngDrawable paramApngDrawable)
  {
    Intrinsics.checkParameterIsNotNull(paramApngDrawable, "it");
    this.this$0.a.post((Runnable)new XAApngView.decor.1.bindData.1.1(this, paramApngDrawable));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.xaction.apng.XAApngView.decor.1.bindData.1
 * JD-Core Version:    0.7.0.1
 */