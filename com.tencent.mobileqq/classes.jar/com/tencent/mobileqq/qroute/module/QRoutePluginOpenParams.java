package com.tencent.mobileqq.qroute.module;

import android.content.Context;
import android.content.Intent;

public class QRoutePluginOpenParams
{
  public int activityRequestCode = -1;
  public String component;
  public Class componentContainer;
  public Context context;
  public Intent intent;
  public boolean isPreload = false;
  public IQRoutePlugin.OnOpenResultListener openResultListener;
  public String pluginName = "";
  public String subModule = "";
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.qroute.module.QRoutePluginOpenParams
 * JD-Core Version:    0.7.0.1
 */