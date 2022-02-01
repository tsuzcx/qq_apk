package com.tencent.mobileqq.triton.internal.touch;

import android.view.MotionEvent;
import com.tencent.mobileqq.triton.engine.EngineState;
import com.tencent.mobileqq.triton.internal.lifecycle.LifeCycleOwner;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "event", "Landroid/view/MotionEvent;", "invoke"}, k=3, mv={1, 1, 16})
final class TouchProviderBridge$attachView$2
  extends Lambda
  implements Function1<MotionEvent, Boolean>
{
  TouchProviderBridge$attachView$2(TouchProviderBridge paramTouchProviderBridge)
  {
    super(1);
  }
  
  public final boolean invoke(@NotNull MotionEvent paramMotionEvent)
  {
    Intrinsics.checkParameterIsNotNull(paramMotionEvent, "event");
    if (TouchProviderBridge.access$getLifeCycleOwner$p(this.this$0).getEngineState() == EngineState.STARTED)
    {
      TouchEventManager localTouchEventManager = TouchProviderBridge.access$getManager$p(this.this$0);
      if (localTouchEventManager != null) {
        localTouchEventManager.onTouchEvent(paramMotionEvent);
      }
      return true;
    }
    paramMotionEvent = TouchProviderBridge.access$getManager$p(this.this$0);
    if (paramMotionEvent != null) {
      paramMotionEvent.clear();
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.triton.internal.touch.TouchProviderBridge.attachView.2
 * JD-Core Version:    0.7.0.1
 */