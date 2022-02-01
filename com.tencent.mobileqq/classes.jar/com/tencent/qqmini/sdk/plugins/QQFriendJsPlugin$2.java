package com.tencent.qqmini.sdk.plugins;

import com.tencent.qqmini.sdk.launcher.core.model.RequestEvent;

class QQFriendJsPlugin$2
  implements QQFriendJsPlugin.IAddFriendCallBack
{
  QQFriendJsPlugin$2(QQFriendJsPlugin paramQQFriendJsPlugin, RequestEvent paramRequestEvent) {}
  
  public void onAddFriendCallBack(String paramString1, boolean paramBoolean, String paramString2)
  {
    if (paramBoolean)
    {
      this.val$req.ok();
      return;
    }
    this.val$req.fail(paramString2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.qqmini.sdk.plugins.QQFriendJsPlugin.2
 * JD-Core Version:    0.7.0.1
 */