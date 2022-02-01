package com.tencent.mobileqq.intervideo;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.mobileqq.intervideo.groupvideo.IVPluginDataReporter;
import com.tencent.mobileqq.intervideo.huayang.Monitor;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import com.tencent.shadow.dynamic.host.DynamicPluginManager;
import com.tencent.shadow.dynamic.host.EnterCallback;
import com.tencent.shadow.dynamic.host.PluginManagerUpdater;

public class PluginManagerWrapper
  implements IVPluginManager
{
  private final String a = "shadow::PluginManagerWrapper";
  private final PluginManagerUpdater b;
  private final String c;
  private IVPluginDataReporter d = new IVPluginDataReporter();
  private DynamicPluginManager e;
  
  public PluginManagerWrapper(String paramString, PluginManagerUpdater paramPluginManagerUpdater)
  {
    this.b = paramPluginManagerUpdater;
    this.c = paramString;
    this.e = new DynamicPluginManager(paramPluginManagerUpdater);
  }
  
  public void a(Context paramContext, long paramLong, Bundle paramBundle, EnterCallback paramEnterCallback)
  {
    boolean bool = TextUtils.isEmpty(((IPluginEnterManager)QRoute.api(IPluginEnterManager.class)).getLastBizType());
    String str;
    if (bool) {
      str = "idle";
    } else {
      str = "busy";
    }
    QLog.i("shadow::PluginManagerWrapper", 1, String.format("doPreLoad pps status is %s ", new Object[] { str }));
    if (bool) {
      enter(paramContext, paramLong, paramBundle, paramEnterCallback);
    }
  }
  
  public void enter(Context paramContext, long paramLong, Bundle paramBundle, EnterCallback paramEnterCallback)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder1 = new StringBuilder();
      localStringBuilder1.append("enter formId:");
      localStringBuilder1.append(paramLong);
      localStringBuilder1.append(" enterCallback:");
      localStringBuilder1.append(paramEnterCallback);
      QLog.i("shadow::PluginManagerWrapper", 2, localStringBuilder1.toString());
    }
    ((IPluginEnterManager)QRoute.api(IPluginEnterManager.class)).switchBiz(this.c, this.e);
    try
    {
      this.e.enter(paramContext, paramLong, paramBundle, paramEnterCallback);
    }
    catch (Exception localException)
    {
      StringBuilder localStringBuilder2 = new StringBuilder();
      localStringBuilder2.append("enter exception :");
      localStringBuilder2.append(localException.getMessage());
      QLog.i("shadow::PluginManagerWrapper", 2, localStringBuilder2.toString());
      this.e = new DynamicPluginManager(this.b);
      ((IPluginEnterManager)QRoute.api(IPluginEnterManager.class)).switchBiz(this.c, this.e);
      this.e.enter(paramContext, paramLong, paramBundle, paramEnterCallback);
    }
    if ("Now".equals(this.c)) {
      paramContext = "33669800";
    } else {
      paramContext = "33669805";
    }
    Monitor.b(paramContext);
    paramContext = this.d.opDepartment("shadow").opName(this.c).opType("enter");
    paramBundle = new StringBuilder();
    paramBundle.append(paramLong);
    paramBundle.append("");
    paramContext.d1(paramBundle.toString()).report();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.intervideo.PluginManagerWrapper
 * JD-Core Version:    0.7.0.1
 */