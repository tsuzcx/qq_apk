package com.tencent.mobileqq.msf.core.net;

import android.os.Handler;
import android.os.Looper;
import android.widget.Toast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;

class r
  extends Thread
{
  r(n paramn) {}
  
  public void a()
  {
    Looper.myLooper().quit();
  }
  
  public void run()
  {
    try
    {
      
      if (QLog.isColorLevel()) {
        QLog.d("MSF.C.NetConnTag", 2, "tcpdump Report show toast begin");
      }
      Toast.makeText(BaseApplication.getContext(), "有网络异常抓包文件，请rtx bobbyzhang,thx!", 1).show();
      new Handler().postDelayed(new s(this), 20000L);
      Looper.loop();
      if (QLog.isColorLevel()) {
        QLog.d("MSF.C.NetConnTag", 2, "tcpdump Report show toast end");
      }
    }
    catch (Exception localException)
    {
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("tcpdump Report exception");
        localStringBuilder.append(localException);
        QLog.d("MSF.C.NetConnTag", 2, localStringBuilder.toString(), localException);
      }
    }
    n.b(this.a, false);
    n.b(this.a, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.msf.core.net.r
 * JD-Core Version:    0.7.0.1
 */