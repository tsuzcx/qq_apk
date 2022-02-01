package com.tencent.mobileqq.teamwork.api;

import android.app.Activity;
import android.app.Dialog;
import android.view.View;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import com.tencent.mobileqq.teamwork.IShareUtils;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;

@QAPI(process={"all"})
public abstract interface ITeamWorkFacadeCreator
  extends QRouteApi
{
  public abstract ICameraHelper getCameraHelper(WebViewPlugin paramWebViewPlugin);
  
  public abstract String getExportHandlerName();
  
  public abstract String getGroupTeamWorkHandlerName();
  
  public abstract IVoiceInputHelper getIVoiceInputHelper(WebViewPlugin paramWebViewPlugin);
  
  public abstract String getImportHandlerName();
  
  public abstract IShareUtils getShareUtils(Activity paramActivity, AppInterface paramAppInterface);
  
  public abstract Class getTeamWorkHandlerClass();
  
  public abstract String getTeamWorkHandlerName();
  
  public abstract Dialog getTroopTeamWorkFileSearchDialog(Activity paramActivity, View paramView, AppInterface paramAppInterface, long paramLong);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.teamwork.api.ITeamWorkFacadeCreator
 * JD-Core Version:    0.7.0.1
 */