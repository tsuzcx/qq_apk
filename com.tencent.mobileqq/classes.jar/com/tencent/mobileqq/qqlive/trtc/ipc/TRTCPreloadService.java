package com.tencent.mobileqq.qqlive.trtc.ipc;

import android.content.Intent;
import android.os.IBinder;
import com.tencent.qphone.base.util.QLog;
import mqq.app.AppService;

public class TRTCPreloadService
  extends AppService
{
  public IBinder onBind(Intent paramIntent)
  {
    QLog.i("TRTCPreloadService", 2, "onBind");
    return null;
  }
  
  public void onCreate()
  {
    super.onCreate();
    QLog.d("TRTCPreloadService", 1, new Object[] { Integer.valueOf(1), "service oncreate" });
  }
  
  public void onDestroy()
  {
    QLog.i("TRTCPreloadService", 2, "onDestroy start");
    super.onDestroy();
  }
  
  public void onLowMemory()
  {
    super.onLowMemory();
    QLog.i("TRTCPreloadService", 2, "onLowMemory");
  }
  
  public int onStartCommand(Intent paramIntent, int paramInt1, int paramInt2)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onStartCommand ");
    localStringBuilder.append(paramIntent);
    QLog.d("TRTCPreloadService", 1, new Object[] { Integer.valueOf(1), localStringBuilder.toString() });
    if (paramIntent != null)
    {
      paramIntent.getStringExtra("key_trtc_so_path");
      TRTCClientIPCModule.a().a(this);
    }
    return 2;
  }
  
  public boolean onUnbind(Intent paramIntent)
  {
    QLog.i("TRTCPreloadService", 2, "onUnbind");
    return super.onUnbind(paramIntent);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqlive.trtc.ipc.TRTCPreloadService
 * JD-Core Version:    0.7.0.1
 */