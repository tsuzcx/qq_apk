package com.tencent.rmonitor.resource;

import android.app.Activity;
import android.support.annotation.NonNull;
import com.tencent.rmonitor.common.lifecycle.SimpleActivityStateCallback;

class ResourceMonitor$3
  extends SimpleActivityStateCallback
{
  ResourceMonitor$3(ResourceMonitor paramResourceMonitor) {}
  
  public void d(@NonNull Activity paramActivity)
  {
    ResourceMonitor.a(this.a, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.rmonitor.resource.ResourceMonitor.3
 * JD-Core Version:    0.7.0.1
 */