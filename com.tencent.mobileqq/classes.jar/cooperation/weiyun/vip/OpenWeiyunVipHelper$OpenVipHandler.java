package cooperation.weiyun.vip;

import android.app.Activity;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;

class OpenWeiyunVipHelper$OpenVipHandler
  extends Handler
{
  public OpenWeiyunVipHelper$OpenVipHandler(Looper paramLooper)
  {
    super(paramLooper);
  }
  
  public void handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    default: 
      return;
    case 3000: 
      OpenWeiyunVipHelper.c((Activity)paramMessage.obj, paramMessage.arg1);
      return;
    }
    OpenWeiyunVipHelper.a(null);
    OpenWeiyunVipHelper.a(SystemClock.uptimeMillis());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     cooperation.weiyun.vip.OpenWeiyunVipHelper.OpenVipHandler
 * JD-Core Version:    0.7.0.1
 */