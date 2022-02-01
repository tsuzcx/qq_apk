package com.tencent.qcircle.shadow.core.runtime;

import android.content.ComponentCallbacks2;
import android.content.res.Configuration;

class ShadowApplication$1
  implements ComponentCallbacks2
{
  ShadowApplication$1(ShadowApplication paramShadowApplication) {}
  
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    this.this$0.onConfigurationChanged(paramConfiguration);
  }
  
  public void onLowMemory()
  {
    this.this$0.onLowMemory();
  }
  
  public void onTrimMemory(int paramInt)
  {
    this.this$0.onTrimMemory(paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qcircle.shadow.core.runtime.ShadowApplication.1
 * JD-Core Version:    0.7.0.1
 */