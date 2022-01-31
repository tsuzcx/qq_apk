package com.tencent.open.wadl;

import android.content.Intent;
import android.os.HandlerThread;
import android.os.IBinder;
import android.os.Looper;
import android.os.Message;
import bfnq;
import bfoa;
import bkel;
import bkem;
import mqq.app.AppService;

public class WadlJsBridgeService
  extends AppService
{
  private static String jdField_a_of_type_JavaLangString = "WadlJsBridgeService";
  private Looper jdField_a_of_type_AndroidOsLooper;
  private bfoa jdField_a_of_type_Bfoa;
  private bkem jdField_a_of_type_Bkem;
  
  public WadlJsBridgeService()
  {
    bfnq.c(jdField_a_of_type_JavaLangString, "##@WadlJsBridgeService()");
  }
  
  private int a(String paramString)
  {
    bkel.a();
    bfnq.c(jdField_a_of_type_JavaLangString, "##@doWadlJob = " + paramString);
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
  
  public IBinder onBind(Intent paramIntent)
  {
    return null;
  }
  
  public void onCreate()
  {
    super.onCreate();
    bfnq.c(jdField_a_of_type_JavaLangString, "wadlJsBridgeService onCreate()");
    HandlerThread localHandlerThread = new HandlerThread("WadlJsBridgeService.Thread", 10);
    localHandlerThread.start();
    this.jdField_a_of_type_AndroidOsLooper = localHandlerThread.getLooper();
    this.jdField_a_of_type_Bfoa = new bfoa(this, this.jdField_a_of_type_AndroidOsLooper);
    if (this.jdField_a_of_type_Bkem == null)
    {
      this.jdField_a_of_type_Bkem = new bkem();
      bfnq.c(jdField_a_of_type_JavaLangString, "##@MessageService-->onCreate():" + this.jdField_a_of_type_Bkem + "," + this.app);
    }
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    if (this.jdField_a_of_type_Bkem != null) {
      this.jdField_a_of_type_Bkem.d();
    }
    bfnq.c(jdField_a_of_type_JavaLangString, "Service is Destroyed");
  }
  
  public int onStartCommand(Intent paramIntent, int paramInt1, int paramInt2)
  {
    bfnq.c(jdField_a_of_type_JavaLangString, "##@Service is Started():onStartCommand: ," + paramInt1 + "," + paramInt2 + ":" + paramIntent);
    if (paramIntent != null)
    {
      String str = paramIntent.getStringExtra("ACTIONNAME");
      paramIntent = paramIntent.getStringExtra("appid");
      bfnq.c(jdField_a_of_type_JavaLangString, "##@ACTIONNAME = " + str + "," + paramIntent);
      Message localMessage = this.jdField_a_of_type_Bfoa.obtainMessage();
      localMessage.what = a(str);
      localMessage.obj = paramIntent;
      this.jdField_a_of_type_Bfoa.sendMessage(localMessage);
    }
    return 2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.open.wadl.WadlJsBridgeService
 * JD-Core Version:    0.7.0.1
 */