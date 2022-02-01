package com.tencent.qcircle.shadow.core.runtime;

import android.app.Activity;
import android.app.Instrumentation;
import com.tencent.qcircle.shadow.core.runtime.qcircle.container.HostActivityDelegator;

public class ShadowInstrumentation
  extends Instrumentation
{
  public void callActivityOnDestroy(ShadowActivity paramShadowActivity)
  {
    super.callActivityOnDestroy((Activity)paramShadowActivity.mHostActivityDelegator.getHostActivity());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qcircle.shadow.core.runtime.ShadowInstrumentation
 * JD-Core Version:    0.7.0.1
 */