package com.tencent.mobileqq.triton.internal.touch;

import com.tencent.mobileqq.triton.touch.TTTouchEvents;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "it", "Ljava/util/ArrayList;", "Lcom/tencent/mobileqq/triton/touch/TTTouchEvents;", "invoke"}, k=3, mv={1, 1, 16})
final class TouchProviderBridge$attachView$1
  extends Lambda
  implements Function1<ArrayList<TTTouchEvents>, Unit>
{
  TouchProviderBridge$attachView$1(TouchProviderBridge paramTouchProviderBridge)
  {
    super(1);
  }
  
  public final void invoke(@NotNull ArrayList<TTTouchEvents> paramArrayList)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayList, "it");
    try
    {
      TouchProviderBridge.Companion.access$nativeOnTouchEvent(TouchProviderBridge.Companion, TouchProviderBridge.access$getNativeInstance$p(this.this$0), paramArrayList);
      Unit localUnit = Unit.INSTANCE;
      return;
    }
    catch (UnsatisfiedLinkError localUnsatisfiedLinkError)
    {
      label25:
      break label25;
    }
    TouchProviderBridge.Companion.access$nativeOnTouchEvent(TouchProviderBridge.Companion, TouchProviderBridge.access$getNativeInstance$p(this.this$0), paramArrayList);
    paramArrayList = Unit.INSTANCE;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.triton.internal.touch.TouchProviderBridge.attachView.1
 * JD-Core Version:    0.7.0.1
 */