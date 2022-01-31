package com.tencent.qqmini.sdk.core.plugins;

import bgkd;

class QQFriendJsPlugin$1
  implements QQFriendJsPlugin.IAddFriendCallBack
{
  QQFriendJsPlugin$1(QQFriendJsPlugin paramQQFriendJsPlugin, bgkd parambgkd) {}
  
  public void onAddFriendCallBack(String paramString1, boolean paramBoolean, String paramString2)
  {
    if (paramBoolean)
    {
      this.val$req.a();
      return;
    }
    this.val$req.a(paramString2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.qqmini.sdk.core.plugins.QQFriendJsPlugin.1
 * JD-Core Version:    0.7.0.1
 */