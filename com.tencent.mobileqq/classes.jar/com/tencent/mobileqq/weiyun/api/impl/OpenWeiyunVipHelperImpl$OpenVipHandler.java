package com.tencent.mobileqq.weiyun.api.impl;

import android.app.Activity;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.weiyun.api.IOpenWeiyunVipHelper;

class OpenWeiyunVipHelperImpl$OpenVipHandler
  extends Handler
{
  public OpenWeiyunVipHelperImpl$OpenVipHandler(Looper paramLooper)
  {
    super(paramLooper);
  }
  
  public void handleMessage(Message paramMessage)
  {
    int i = paramMessage.what;
    if (i != 3000)
    {
      if (i != 3001) {
        return;
      }
      OpenWeiyunVipHelperImpl.access$102(null);
      OpenWeiyunVipHelperImpl.access$202(SystemClock.uptimeMillis());
      return;
    }
    Activity localActivity = (Activity)paramMessage.obj;
    i = paramMessage.arg1;
    OpenWeiyunVipHelperImpl.access$000((OpenWeiyunVipHelperImpl)QRoute.api(IOpenWeiyunVipHelper.class), localActivity, i);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.weiyun.api.impl.OpenWeiyunVipHelperImpl.OpenVipHandler
 * JD-Core Version:    0.7.0.1
 */