package com.tencent.mobileqq.leba.feed;

import android.content.Context;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import mqq.app.AppRuntime;

@QAPI(process={"all"})
public abstract interface ILebaPluginFeedApi
  extends QRouteApi
{
  public abstract ILebaPluginFeedController getLebaPluginFeedController(Context paramContext, AppRuntime paramAppRuntime, QBaseActivity paramQBaseActivity);
  
  public abstract boolean isNeedShowPluginInTab(AppRuntime paramAppRuntime);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.leba.feed.ILebaPluginFeedApi
 * JD-Core Version:    0.7.0.1
 */