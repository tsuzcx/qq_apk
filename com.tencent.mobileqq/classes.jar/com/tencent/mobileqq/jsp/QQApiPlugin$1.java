package com.tencent.mobileqq.jsp;

import android.content.Intent;
import android.text.TextUtils;

class QQApiPlugin$1
  implements ShareMsgImpl.ShareMsgImplListener
{
  QQApiPlugin$1(QQApiPlugin paramQQApiPlugin) {}
  
  public void onSharMsgcallback(String paramString1, String paramString2)
  {
    if (!TextUtils.isEmpty(paramString1))
    {
      this.a.callJs(paramString1, new String[] { paramString2 });
      return;
    }
    this.a.callJs4OpenApiIfNeeded("shareMsg", 0, paramString2);
  }
  
  public void startActivityForResult(Intent paramIntent, byte paramByte)
  {
    this.a.startActivityForResult(paramIntent, paramByte);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.jsp.QQApiPlugin.1
 * JD-Core Version:    0.7.0.1
 */