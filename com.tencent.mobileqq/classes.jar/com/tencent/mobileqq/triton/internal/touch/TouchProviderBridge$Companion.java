package com.tencent.mobileqq.triton.internal.touch;

import com.tencent.mobileqq.triton.internal.debug.JankCanaryAgent;
import com.tencent.mobileqq.triton.touch.TTTouchEvents;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/triton/internal/touch/TouchProviderBridge$Companion;", "", "()V", "nativeCreate", "", "jankCanaryAgent", "Lcom/tencent/mobileqq/triton/internal/debug/JankCanaryAgent;", "nativeOnTouchEvent", "", "nativeInstance", "touchEvents", "Ljava/util/ArrayList;", "Lcom/tencent/mobileqq/triton/touch/TTTouchEvents;", "Triton_release"}, k=1, mv={1, 1, 16})
public final class TouchProviderBridge$Companion
{
  @JvmStatic
  private final long nativeCreate(JankCanaryAgent paramJankCanaryAgent)
  {
    return TouchProviderBridge.access$nativeCreate(paramJankCanaryAgent);
  }
  
  @JvmStatic
  private final void nativeOnTouchEvent(long paramLong, ArrayList<TTTouchEvents> paramArrayList)
  {
    TouchProviderBridge.access$nativeOnTouchEvent(paramLong, paramArrayList);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.triton.internal.touch.TouchProviderBridge.Companion
 * JD-Core Version:    0.7.0.1
 */