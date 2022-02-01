package com.tencent.open.wadl;

import android.content.Intent;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.HandlerThread;
import android.os.IBinder;
import android.os.Looper;
import android.os.Message;
import bkad;
import bnyp;
import bnyq;
import cooperation.wadl.ipc.WadlParams;
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
    bkad.c(jdField_a_of_type_JavaLangString, "WadlJsBridgeService new instance");
  }
  
  private int a(String paramString)
  {
    
    if ("start".equals(paramString)) {
      return 0;
    }
    if ("complete".equals(paramString)) {
      return 1;
    }
    if ("open".equals(paramString)) {
      return 2;
    }
    if ("restart".equals(paramString)) {
      return 4;
    }
    if ("pause".equals(paramString)) {
      return 5;
    }
    return -1;
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    String str = (String)paramMessage.obj;
    bkad.c(jdField_a_of_type_JavaLangString, "handleMessage what=" + paramMessage.what + "," + paramMessage.obj);
    switch (paramMessage.what)
    {
    case 2: 
    case 3: 
    default: 
    case 0: 
    case 4: 
      for (;;)
      {
        stopSelf(paramMessage.arg1);
        return false;
        bnyp.a().b(4, str);
      }
    case 5: 
      bnyp.a().a(4, str);
      return false;
    }
    paramMessage = new WadlParams(str, "");
    paramMessage.d = 4;
    paramMessage.p = "biz_src_zf_games";
    bnyp.a().b(paramMessage);
    return false;
  }
  
  public IBinder onBind(Intent paramIntent)
  {
    return null;
  }
  
  public void onCreate()
  {
    super.onCreate();
    bkad.c(jdField_a_of_type_JavaLangString, "onCreate...");
    HandlerThread localHandlerThread = new HandlerThread(this.b, 10);
    localHandlerThread.start();
    this.jdField_a_of_type_AndroidOsLooper = localHandlerThread.getLooper();
    this.jdField_a_of_type_AndroidOsHandler = new Handler(this.jdField_a_of_type_AndroidOsLooper, this);
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    bkad.c(jdField_a_of_type_JavaLangString, "Service is Destroyed");
  }
  
  public int onStartCommand(Intent paramIntent, int paramInt1, int paramInt2)
  {
    bkad.c(jdField_a_of_type_JavaLangString, "onStartCommand flags=," + paramInt1 + ",startId=" + paramInt2 + ",intent=" + paramIntent);
    if (paramIntent != null)
    {
      String str = paramIntent.getStringExtra("ACTIONNAME");
      paramIntent = paramIntent.getStringExtra("appid");
      bkad.c(jdField_a_of_type_JavaLangString, "onStartCommand actionName= " + str + ",appId=" + paramIntent);
      Message localMessage = this.jdField_a_of_type_AndroidOsHandler.obtainMessage();
      localMessage.what = a(str);
      localMessage.obj = paramIntent;
      this.jdField_a_of_type_AndroidOsHandler.sendMessage(localMessage);
    }
    return 2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.open.wadl.WadlJsBridgeService
 * JD-Core Version:    0.7.0.1
 */