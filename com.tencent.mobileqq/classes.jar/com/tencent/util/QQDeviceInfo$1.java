package com.tencent.util;

import android.content.Intent;
import com.tencent.qphone.base.util.BaseApplication;

final class QQDeviceInfo$1
  implements Runnable
{
  public void run()
  {
    QQDeviceInfo.1.1 local1 = new QQDeviceInfo.1.1(this);
    Intent localIntent = new Intent("com.uodis.opendevice.OPENIDS_SERVICE");
    localIntent.setPackage("com.huawei.hwid");
    BaseApplication.getContext().bindService(localIntent, local1, 1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.util.QQDeviceInfo.1
 * JD-Core Version:    0.7.0.1
 */