package com.tencent.tavcut.operator;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "it", "Lcom/tencent/tavcut/operator/IClipSourceOperator$InvalidStatus;", "invoke"}, k=3, mv={1, 1, 16})
final class ClipSourceOperator$errorCallBack$1
  extends Lambda
  implements Function1<IClipSourceOperator.InvalidStatus, Unit>
{
  public static final 1 INSTANCE = new 1();
  
  ClipSourceOperator$errorCallBack$1()
  {
    super(1);
  }
  
  public final void invoke(@NotNull IClipSourceOperator.InvalidStatus paramInvalidStatus)
  {
    Intrinsics.checkParameterIsNotNull(paramInvalidStatus, "it");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.tavcut.operator.ClipSourceOperator.errorCallBack.1
 * JD-Core Version:    0.7.0.1
 */