package com.tencent.mobileqq.teamwork.api;

import android.app.Activity;
import com.tencent.biz.ui.TouchWebView;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;

@QAPI(process={"all"})
public abstract interface IUniDownloadListenerProxy
  extends QRouteApi
{
  public abstract void onCreate(AppInterface paramAppInterface, Activity paramActivity, TouchWebView paramTouchWebView, boolean paramBoolean);
  
  public abstract void onDestroy();
  
  public abstract void setDownloadListener(TouchWebView paramTouchWebView);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.teamwork.api.IUniDownloadListenerProxy
 * JD-Core Version:    0.7.0.1
 */