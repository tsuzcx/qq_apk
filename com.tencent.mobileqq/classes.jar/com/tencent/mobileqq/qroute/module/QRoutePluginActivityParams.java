package com.tencent.mobileqq.qroute.module;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;

public class QRoutePluginActivityParams
{
  public String activityName;
  public Class activityProxy;
  public int activityRequestCode = -1;
  public Context context;
  public Dialog dialog;
  public Intent intent;
  public IQRoutePlugin.OnOpenResultListener openResultListener;
  public Object session;
  public String subModule = "";
  public int timeoutMills;
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.qroute.module.QRoutePluginActivityParams
 * JD-Core Version:    0.7.0.1
 */