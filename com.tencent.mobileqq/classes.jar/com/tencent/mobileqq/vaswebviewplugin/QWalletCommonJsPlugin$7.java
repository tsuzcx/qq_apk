package com.tencent.mobileqq.vaswebviewplugin;

import bdcd;
import becq;
import com.tencent.qphone.base.util.QLog;
import mqq.app.QQPermissionCallback;

class QWalletCommonJsPlugin$7
  implements QQPermissionCallback
{
  QWalletCommonJsPlugin$7(QWalletCommonJsPlugin paramQWalletCommonJsPlugin) {}
  
  public void deny(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QWalletCommonJsPlugin", 1, "CheckPermission user denied");
    }
    bdcd.a(this.this$0.mRuntime.a(), paramArrayOfString, paramArrayOfInt);
    this.this$0.callJs(QWalletCommonJsPlugin.access$200(this.this$0), new String[] { "{'result':-1, 'msg': 'no permission to read contact number'}" });
  }
  
  public void grant(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QWalletCommonJsPlugin", 1, "CheckPermission user grant");
    }
    new QWalletCommonJsPlugin.GetAllContactTask(this.this$0).execute(new Void[0]);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.vaswebviewplugin.QWalletCommonJsPlugin.7
 * JD-Core Version:    0.7.0.1
 */