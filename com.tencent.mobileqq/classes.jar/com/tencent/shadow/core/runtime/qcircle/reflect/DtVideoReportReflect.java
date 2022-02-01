package com.tencent.shadow.core.runtime.qcircle.reflect;

import android.app.Activity;
import java.lang.reflect.Method;
import java.util.HashMap;

public class DtVideoReportReflect
  extends DtBaseReflect
{
  public static final String className = "com.tencent.qqlive.module.videoreport.VideoReport";
  private static volatile DtVideoReportReflect sReflect;
  
  public static DtVideoReportReflect g()
  {
    if (sReflect == null) {
      try
      {
        if (sReflect == null) {
          sReflect = new DtVideoReportReflect();
        }
      }
      finally {}
    }
    return sReflect;
  }
  
  protected void initObject(Activity paramActivity)
  {
    newInstance(paramActivity, "com.tencent.qqlive.module.videoreport.VideoReport");
  }
  
  public void invokeAddToDetectionWhitelist(Activity paramActivity)
  {
    try
    {
      Object localObject2 = getObject(paramActivity);
      Method localMethod = (Method)this.mMethodMap.get("addToDetectionWhitelist");
      Object localObject1 = localMethod;
      if (localMethod == null)
      {
        localObject1 = loadClass(paramActivity, "com.tencent.qqlive.module.videoreport.VideoReport");
        if (localObject1 == null) {
          return;
        }
        localObject1 = ((Class)localObject1).getMethod("addToDetectionWhitelist", new Class[] { Activity.class });
        this.mMethodMap.put("addToDetectionWhitelist", localObject1);
      }
      ((Method)localObject1).invoke(localObject2, new Object[] { paramActivity });
      return;
    }
    catch (Exception paramActivity)
    {
      paramActivity.printStackTrace();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.shadow.core.runtime.qcircle.reflect.DtVideoReportReflect
 * JD-Core Version:    0.7.0.1
 */