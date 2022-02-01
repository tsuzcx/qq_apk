package com.tencent.mobileqq.qqgamepub.api;

import android.app.Activity;
import android.content.Context;
import com.tencent.ark.ArkViewImplement.LoadCallback;
import com.tencent.ark.open.ArkView;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.qqgamepub.data.QQGameMsgInfo;
import com.tencent.mobileqq.qqgamepub.view.IHeaderView;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import com.tencent.mobileqq.qroute.route.ActivityURIRequest;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;
import com.tencent.mobileqq.webview.swift.WebViewPlugin.PluginRuntime;
import java.util.ArrayList;
import java.util.Map;
import mqq.app.AppRuntime;

@QAPI(process={"all"})
public abstract interface IQQGameTempRelyApi
  extends QRouteApi
{
  public abstract void addNightModeMask(Activity paramActivity);
  
  public abstract void bindQQGameWebViewBuilderJavaScript(ArrayList<WebViewPlugin> paramArrayList);
  
  public abstract IHeaderView createHeader(MessageRecord paramMessageRecord, Activity paramActivity);
  
  public abstract IHeaderView createHeader(QQGameMsgInfo paramQQGameMsgInfo, Activity paramActivity);
  
  public abstract void exePublicAccountTianshuReport(int paramInt1, int paramInt2, String paramString1, String paramString2);
  
  public abstract void exitVideoFullScreen();
  
  public abstract Context getCurrentContext(WebViewPlugin.PluginRuntime paramPluginRuntime);
  
  public abstract Map<String, String> getGameMsgInfoMap();
  
  public abstract void handleGcArkDeleteMsg(String paramString);
  
  public abstract String init(ArkView paramArkView, MessageRecord paramMessageRecord, ArkViewImplement.LoadCallback paramLoadCallback);
  
  public abstract void initPublicAccountChatPieIntent(ActivityURIRequest paramActivityURIRequest);
  
  public abstract boolean isInNightMode();
  
  public abstract boolean isToolAppRuntime(AppRuntime paramAppRuntime);
  
  public abstract boolean isVideoFullScreenMode();
  
  public abstract void publicAccountExposureReport(String paramString, long paramLong);
  
  public abstract void stopVideo();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.qqgamepub.api.IQQGameTempRelyApi
 * JD-Core Version:    0.7.0.1
 */