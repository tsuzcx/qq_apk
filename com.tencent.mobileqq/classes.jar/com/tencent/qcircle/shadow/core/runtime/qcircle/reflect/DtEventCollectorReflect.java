package com.tencent.qcircle.shadow.core.runtime.qcircle.reflect;

import android.app.Activity;
import android.view.MotionEvent;
import com.tencent.qcircle.shadow.core.runtime.PluginActivity;
import com.tencent.qcircle.shadow.core.runtime.qcircle.container.HostActivityDelegator;
import java.lang.reflect.Method;
import java.util.HashMap;

public class DtEventCollectorReflect
  extends DtBaseReflect
{
  public static final String className = "com.tencent.qqlive.module.videoreport.collect.EventCollector";
  private static volatile DtEventCollectorReflect sReflect;
  
  public static DtEventCollectorReflect g()
  {
    if (sReflect == null) {
      try
      {
        if (sReflect == null) {
          sReflect = new DtEventCollectorReflect();
        }
      }
      finally {}
    }
    return sReflect;
  }
  
  protected void initObject(Activity paramActivity)
  {
    getInstance(paramActivity, "com.tencent.qqlive.module.videoreport.collect.EventCollector", "getInstance");
  }
  
  public void invokeOnActivityDispatchTouchEvent(PluginActivity paramPluginActivity, MotionEvent paramMotionEvent, boolean paramBoolean1, boolean paramBoolean2)
  {
    if (paramPluginActivity == null) {
      return;
    }
    try
    {
      if (paramPluginActivity.getHostActivityDelegator() != null)
      {
        if (paramPluginActivity.getHostActivityDelegator().getHostActivity() == null) {
          return;
        }
        Activity localActivity = (Activity)paramPluginActivity.getHostActivityDelegator().getHostActivity();
        Object localObject = getObject(localActivity);
        Method localMethod = (Method)this.mMethodMap.get("onActivityDispatchTouchEvent");
        paramPluginActivity = localMethod;
        if (localMethod == null)
        {
          paramPluginActivity = loadClass(localActivity, "com.tencent.qqlive.module.videoreport.collect.EventCollector");
          if (paramPluginActivity == null) {
            return;
          }
          paramPluginActivity = paramPluginActivity.getMethod("onActivityDispatchTouchEvent", new Class[] { Activity.class, MotionEvent.class, Boolean.TYPE, Boolean.TYPE });
          this.mMethodMap.put("onActivityDispatchTouchEvent", paramPluginActivity);
        }
        paramPluginActivity.invoke(localObject, new Object[] { localActivity, paramMotionEvent, Boolean.valueOf(paramBoolean1), Boolean.valueOf(paramBoolean2) });
        return;
      }
      return;
    }
    catch (Exception paramPluginActivity)
    {
      paramPluginActivity.printStackTrace();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.qcircle.shadow.core.runtime.qcircle.reflect.DtEventCollectorReflect
 * JD-Core Version:    0.7.0.1
 */