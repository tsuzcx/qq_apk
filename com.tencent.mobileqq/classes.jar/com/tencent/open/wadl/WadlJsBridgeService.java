package com.tencent.open.wadl;

import android.content.Intent;
import android.os.HandlerThread;
import android.os.IBinder;
import android.os.Looper;
import android.os.Message;
import bdot;
import bdpd;
import bicp;
import bicq;
import mqq.app.AppService;

public class WadlJsBridgeService
  extends AppService
{
  private static String jdField_a_of_type_JavaLangString = "WadlJsBridgeService";
  private Looper jdField_a_of_type_AndroidOsLooper;
  private bdpd jdField_a_of_type_Bdpd;
  private bicq jdField_a_of_type_Bicq;
  
  public WadlJsBridgeService()
  {
    bdot.b(jdField_a_of_type_JavaLangString, "##@WadlJsBridgeService()");
  }
  
  private int a(String paramString)
  {
    bicp.a();
    bdot.b(jdField_a_of_type_JavaLangString, "##@doWadlJob = " + paramString);
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
    bdot.b(jdField_a_of_type_JavaLangString, "wadlJsBridgeService onCreate()");
    HandlerThread localHandlerThread = new HandlerThread("WadlJsBridgeService.Thread", 10);
    localHandlerThread.start();
    this.jdField_a_of_type_AndroidOsLooper = localHandlerThread.getLooper();
    this.jdField_a_of_type_Bdpd = new bdpd(this, this.jdField_a_of_type_AndroidOsLooper);
    if (this.jdField_a_of_type_Bicq == null)
    {
      this.jdField_a_of_type_Bicq = new bicq();
      bdot.b(jdField_a_of_type_JavaLangString, "##@MessageService-->onCreate():" + this.jdField_a_of_type_Bicq + "," + this.app);
    }
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    if (this.jdField_a_of_type_Bicq != null) {
      this.jdField_a_of_type_Bicq.d();
    }
    bdot.b(jdField_a_of_type_JavaLangString, "Service is Destroyed");
  }
  
  public int onStartCommand(Intent paramIntent, int paramInt1, int paramInt2)
  {
    bdot.b(jdField_a_of_type_JavaLangString, "##@Service is Started():onStartCommand: ," + paramInt1 + "," + paramInt2 + ":" + paramIntent);
    if (paramIntent != null)
    {
      String str = paramIntent.getStringExtra("ACTIONNAME");
      paramIntent = paramIntent.getStringExtra("appid");
      bdot.b(jdField_a_of_type_JavaLangString, "##@ACTIONNAME = " + str + "," + paramIntent);
      Message localMessage = this.jdField_a_of_type_Bdpd.obtainMessage();
      localMessage.what = a(str);
      localMessage.obj = paramIntent;
      this.jdField_a_of_type_Bdpd.sendMessage(localMessage);
    }
    return 2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.open.wadl.WadlJsBridgeService
 * JD-Core Version:    0.7.0.1
 */