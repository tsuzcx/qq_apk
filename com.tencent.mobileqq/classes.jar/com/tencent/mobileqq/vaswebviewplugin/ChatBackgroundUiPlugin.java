package com.tencent.mobileqq.vaswebviewplugin;

import android.os.Bundle;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.emosm.OnRemoteRespObserver;
import com.tencent.mobileqq.emosm.api.IWebIPCOperatorApi;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.webview.swift.WebViewPlugin.PluginRuntime;
import com.tencent.mobileqq.webview.swift.WebViewProvider;
import java.util.Map;

public class ChatBackgroundUiPlugin
  extends VasWebviewUiPlugin
{
  private static final String TAG = "ChatBackgroundUiPlugin";
  OnRemoteRespObserver mOnRemoteResp = new ChatBackgroundUiPlugin.1(this);
  private Bundle mReqBundle;
  private String uin;
  
  void OnActivityCreate()
  {
    super.OnActivityCreate();
    this.mReqBundle = new Bundle();
    this.uin = this.mRuntime.b().getAccount();
    WebViewProvider localWebViewProvider = this.mRuntime.f();
    if (localWebViewProvider != null) {
      localWebViewProvider.setCurUrl(super.decodeUrl(localWebViewProvider.getCurrentUrl()));
    }
    ((IWebIPCOperatorApi)QRoute.api(IWebIPCOperatorApi.class)).registerObserver(this.mOnRemoteResp);
  }
  
  void OnActivityDestroy()
  {
    super.OnActivityDestroy();
    ((IWebIPCOperatorApi)QRoute.api(IWebIPCOperatorApi.class)).unRegisterObserver(this.mOnRemoteResp);
  }
  
  protected boolean excuteEvent(String paramString, long paramLong, Map<String, Object> paramMap)
  {
    return false;
  }
  
  protected long getPluginBusiness()
  {
    return 33554432L;
  }
  
  public long getWebViewEventByNameSpace(String paramString)
  {
    return 3L;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.vaswebviewplugin.ChatBackgroundUiPlugin
 * JD-Core Version:    0.7.0.1
 */