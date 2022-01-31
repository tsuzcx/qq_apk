package com.tencent.mobileqq.vaswebviewplugin;

import bdcd;
import becq;
import mqq.app.QQPermissionCallback;

class QWalletCommonJsPlugin$5
  implements QQPermissionCallback
{
  QWalletCommonJsPlugin$5(QWalletCommonJsPlugin paramQWalletCommonJsPlugin) {}
  
  public void deny(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    bdcd.a(this.this$0.mRuntime.a(), paramArrayOfString, paramArrayOfInt);
    this.this$0.callJs(QWalletCommonJsPlugin.access$200(this.this$0), new String[] { "{'result':-1, 'msg': 'no permission to read contact number'}" });
  }
  
  public void grant(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    QWalletCommonJsPlugin.access$1100(this.this$0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.vaswebviewplugin.QWalletCommonJsPlugin.5
 * JD-Core Version:    0.7.0.1
 */