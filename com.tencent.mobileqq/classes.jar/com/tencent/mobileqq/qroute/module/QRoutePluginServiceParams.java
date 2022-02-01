package com.tencent.mobileqq.qroute.module;

import android.content.Context;
import android.content.Intent;

public class QRoutePluginServiceParams
{
  public Context context;
  public Intent intent;
  public boolean isPreload = false;
  public IQRoutePlugin.OnOpenResultListener openResultListener;
  public String serviceName;
  public Class serviceProxy;
  public Object session;
  public String subModule = "";
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.qroute.module.QRoutePluginServiceParams
 * JD-Core Version:    0.7.0.1
 */