package com.tencent.mobileqq.confess;

import com.tencent.biz.qrcode.util.QRUtils;
import com.tencent.qphone.base.util.QLog;

class ConfessPlugin$3
  implements Runnable
{
  ConfessPlugin$3(ConfessPlugin paramConfessPlugin, int paramInt1, int paramInt2) {}
  
  public void run()
  {
    try
    {
      QRUtils.a(this.a, this.b);
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
      QLog.d("ConfessPlugin", 1, "showQQToast error: " + localException.getMessage());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.confess.ConfessPlugin.3
 * JD-Core Version:    0.7.0.1
 */