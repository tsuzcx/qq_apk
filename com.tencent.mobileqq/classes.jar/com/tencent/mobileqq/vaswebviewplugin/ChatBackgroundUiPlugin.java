package com.tencent.mobileqq.vaswebviewplugin;

import android.os.Bundle;
import ascz;
import ashz;
import bifw;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.webview.swift.WebViewFragment;
import java.util.Map;

public class ChatBackgroundUiPlugin
  extends VasWebviewUiPlugin
{
  private static final String TAG = "ChatBackgroundUiPlugin";
  ascz mOnRemoteResp = new ChatBackgroundUiPlugin.1(this);
  private Bundle mReqBundle;
  private String uin;
  
  void OnActivityCreate()
  {
    super.OnActivityCreate();
    this.mReqBundle = new Bundle();
    this.uin = this.mRuntime.a().getAccount();
    WebViewFragment localWebViewFragment = this.mRuntime.a();
    if (localWebViewFragment != null) {
      localWebViewFragment.mUrl = super.decodeUrl(localWebViewFragment.mUrl);
    }
    ashz.a().a(this.mOnRemoteResp);
  }
  
  void OnActivityDestroy()
  {
    super.OnActivityDestroy();
    ashz.a().b(this.mOnRemoteResp);
  }
  
  protected boolean excuteEvent(String paramString, long paramLong, Map<String, Object> paramMap)
  {
    return false;
  }
  
  protected long getPluginBusiness()
  {
    return 33554432L;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.vaswebviewplugin.ChatBackgroundUiPlugin
 * JD-Core Version:    0.7.0.1
 */