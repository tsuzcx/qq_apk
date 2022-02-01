package com.tencent.mobileqq.mini.appbrand.jsapi.plugins;

import com.tencent.mobileqq.mini.webview.JsRuntime;

class QQFriendsJsPlugin$1
  implements QQFriendsJsPlugin.IAddFriendCallBack
{
  QQFriendsJsPlugin$1(QQFriendsJsPlugin paramQQFriendsJsPlugin, JsRuntime paramJsRuntime, int paramInt) {}
  
  public void onAddFriendCallBack(String paramString1, boolean paramBoolean, String paramString2)
  {
    if (paramBoolean)
    {
      this.this$0.jsPluginEngine.callbackJsEventOK(this.val$webview, paramString1, null, this.val$callbackId);
      return;
    }
    this.this$0.jsPluginEngine.callbackJsEventFail(this.val$webview, paramString1, null, paramString2, this.val$callbackId);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.mini.appbrand.jsapi.plugins.QQFriendsJsPlugin.1
 * JD-Core Version:    0.7.0.1
 */