package com.tencent.util;

import android.content.Intent;
import bhsq;
import com.tencent.common.app.BaseApplicationImpl;

public final class QQDeviceInfo$1
  implements Runnable
{
  public void run()
  {
    bhsq localbhsq = new bhsq(this);
    Intent localIntent = new Intent("com.uodis.opendevice.OPENIDS_SERVICE");
    localIntent.setPackage("com.huawei.hwid");
    BaseApplicationImpl.getApplication().bindService(localIntent, localbhsq, 1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.util.QQDeviceInfo.1
 * JD-Core Version:    0.7.0.1
 */