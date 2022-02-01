package com.tencent.open.wadl;

import android.content.Intent;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.HandlerThread;
import android.os.IBinder;
import android.os.Looper;
import android.os.Message;
import com.tencent.gamecenter.wadl.biz.entity.WadlParams;
import com.tencent.gamecenter.wadl.util.WLog;
import cooperation.wadl.ipc.WadlProxyServiceUtil;
import cooperation.wadl.ipc.WadlProxyServiceWrap;
import mqq.app.AppService;

public class WadlJsBridgeService
  extends AppService
  implements Handler.Callback
{
  private static String jdField_a_of_type_JavaLangString = "WadlJsBridgeService";
  private Handler jdField_a_of_type_AndroidOsHandler;
  private Looper jdField_a_of_type_AndroidOsLooper;
  private String b = "WadlJsBridgeService.Thread";
  
  public WadlJsBridgeService()
  {
    WLog.c(jdField_a_of_type_JavaLangString, "WadlJsBridgeService new instance");
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    String str = (String)paramMessage.obj;
    WLog.c(jdField_a_of_type_JavaLangString, "handleMessage what=" + paramMessage.what + "," + paramMessage.obj);
    switch (paramMessage.what)
    {
    }
    for (;;)
    {
      stopSelf(paramMessage.arg1);
      return false;
      WadlProxyServiceUtil.a().b(4, str);
      continue;
      WadlProxyServiceUtil.a().a(4, str);
      return false;
      paramMessage = new WadlParams(str, "");
      paramMessage.d = 4;
      paramMessage.p = "biz_src_zf_games";
      WadlProxyServiceUtil.a().c(paramMessage);
      return false;
      WadlProxyServiceUtil.a().c(str);
      continue;
      WadlProxyServiceUtil.a().b(str);
    }
  }
  
  public IBinder onBind(Intent paramIntent)
  {
    return null;
  }
  
  public void onCreate()
  {
    super.onCreate();
    WLog.c(jdField_a_of_type_JavaLangString, "onCreate...");
    HandlerThread localHandlerThread = new HandlerThread(this.b, 10);
    localHandlerThread.start();
    this.jdField_a_of_type_AndroidOsLooper = localHandlerThread.getLooper();
    this.jdField_a_of_type_AndroidOsHandler = new Handler(this.jdField_a_of_type_AndroidOsLooper, this);
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    WLog.c(jdField_a_of_type_JavaLangString, "Service is Destroyed");
  }
  
  public int onStartCommand(Intent paramIntent, int paramInt1, int paramInt2)
  {
    WLog.c(jdField_a_of_type_JavaLangString, "onStartCommand flags=," + paramInt1 + ",startId=" + paramInt2 + ",intent=" + paramIntent);
    if (paramIntent != null)
    {
      paramInt1 = paramIntent.getIntExtra("ACTIONNAME", 0);
      paramIntent = paramIntent.getStringExtra("id");
      WLog.c(jdField_a_of_type_JavaLangString, "onStartCommand action= " + paramInt1 + ",id=" + paramIntent);
      Message localMessage = this.jdField_a_of_type_AndroidOsHandler.obtainMessage();
      localMessage.what = paramInt1;
      localMessage.obj = paramIntent;
      this.jdField_a_of_type_AndroidOsHandler.sendMessage(localMessage);
    }
    return 2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.open.wadl.WadlJsBridgeService
 * JD-Core Version:    0.7.0.1
 */