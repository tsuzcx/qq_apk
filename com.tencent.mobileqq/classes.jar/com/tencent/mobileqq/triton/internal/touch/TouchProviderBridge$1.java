package com.tencent.mobileqq.triton.internal.touch;

import com.tencent.mobileqq.triton.internal.lifecycle.ValueHolder;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "it", "Lkotlin/Function1;", "", "invoke"}, k=3, mv={1, 1, 16})
final class TouchProviderBridge$1
  extends Lambda
  implements Function1<Function1<? super String, ? extends Unit>, Unit>
{
  TouchProviderBridge$1(TouchProviderBridge paramTouchProviderBridge)
  {
    super(1);
  }
  
  public final void invoke(@Nullable Function1<? super String, Unit> paramFunction1)
  {
    if (paramFunction1 != null)
    {
      TouchProviderBridge.access$getLastClicksCallbackHolder$p(this.this$0).setValue(null);
      paramFunction1.invoke(TouchProviderBridge.access$getLastClicks(this.this$0));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.triton.internal.touch.TouchProviderBridge.1
 * JD-Core Version:    0.7.0.1
 */