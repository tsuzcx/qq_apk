package com.tencent.open.wadl;

import alju;
import android.content.Intent;
import android.os.HandlerThread;
import android.os.IBinder;
import android.os.Looper;
import android.os.Message;
import com.tencent.common.app.BaseApplicationImpl;
import cooperation.wadl.ipc.WadlProxyServiceManager;
import cooperation.wadl.ipc.WadlProxyServiceUtil;
import cooperation.wadl.ipc.WadlProxyServiceWrap;
import mqq.app.AppRuntime;
import mqq.app.AppService;

public class WadlJsBridgeService
  extends AppService
{
  private static String jdField_a_of_type_JavaLangString = "WadlJsBridgeService";
  private alju jdField_a_of_type_Alju;
  private Looper jdField_a_of_type_AndroidOsLooper;
  private WadlProxyServiceWrap jdField_a_of_type_CooperationWadlIpcWadlProxyServiceWrap;
  
  public WadlJsBridgeService()
  {
    WLog.b(jdField_a_of_type_JavaLangString, "##@WadlJsBridgeService()");
  }
  
  private int a(String paramString)
  {
    WadlProxyServiceUtil.a(BaseApplicationImpl.getApplication().getRuntime());
    WLog.b(jdField_a_of_type_JavaLangString, "##@doWadlJob = " + paramString);
    if (paramString.equals("start")) {
      return 0;
    }
    if (paramString.equals("complete")) {
      return 1;
    }
    if (paramString.equals("open")) {
      return 2;
    }
    if (paramString.equals("restart")) {
      return 4;
    }
    if (paramString.equals("yyb")) {
      return 3;
    }
    if (paramString.equals("pause")) {
      return 5;
    }
    return -1;
  }
  
  public void onAccountChanged()
  {
    super.onAccountChanged();
    WLog.b(jdField_a_of_type_JavaLangString, "onAccountChanged start");
    AppRuntime localAppRuntime = BaseApplicationImpl.getApplication().getRuntime();
    if ((this.jdField_a_of_type_CooperationWadlIpcWadlProxyServiceWrap != null) && (this.jdField_a_of_type_CooperationWadlIpcWadlProxyServiceWrap.a != null)) {
      this.jdField_a_of_type_CooperationWadlIpcWadlProxyServiceWrap.a.a(localAppRuntime);
    }
  }
  
  public IBinder onBind(Intent paramIntent)
  {
    return null;
  }
  
  public void onCreate()
  {
    super.onCreate();
    WLog.b(jdField_a_of_type_JavaLangString, "wadlJsBridgeService onCreate()");
    Object localObject = new HandlerThread("WadlJsBridgeService.Thread", 10);
    ((HandlerThread)localObject).start();
    this.jdField_a_of_type_AndroidOsLooper = ((HandlerThread)localObject).getLooper();
    this.jdField_a_of_type_Alju = new alju(this, this.jdField_a_of_type_AndroidOsLooper);
    if (this.jdField_a_of_type_CooperationWadlIpcWadlProxyServiceWrap == null)
    {
      localObject = BaseApplicationImpl.getApplication().getRuntime();
      this.jdField_a_of_type_CooperationWadlIpcWadlProxyServiceWrap = new WadlProxyServiceWrap((AppRuntime)localObject);
      WLog.b(jdField_a_of_type_JavaLangString, "##@MessageService-->onCreate():" + this.jdField_a_of_type_CooperationWadlIpcWadlProxyServiceWrap + "," + localObject);
    }
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    WLog.b(jdField_a_of_type_JavaLangString, "Service is Destroyed");
  }
  
  public int onStartCommand(Intent paramIntent, int paramInt1, int paramInt2)
  {
    WLog.b(jdField_a_of_type_JavaLangString, "##@Service is Started():onStartCommand: ," + paramInt1 + "," + paramInt2 + ":" + paramIntent);
    if (paramIntent != null)
    {
      String str = paramIntent.getStringExtra("ACTIONNAME");
      paramIntent = paramIntent.getStringExtra("appid");
      WLog.b(jdField_a_of_type_JavaLangString, "##@ACTIONNAME = " + str + "," + paramIntent);
      Message localMessage = this.jdField_a_of_type_Alju.obtainMessage();
      localMessage.what = a(str);
      localMessage.obj = paramIntent;
      this.jdField_a_of_type_Alju.sendMessage(localMessage);
    }
    return 2;
  }
  
  public void setAppRuntime(AppRuntime paramAppRuntime)
  {
    super.setAppRuntime(paramAppRuntime);
    WLog.b(jdField_a_of_type_JavaLangString, "setAppRuntime appRuntime");
    if ((this.jdField_a_of_type_CooperationWadlIpcWadlProxyServiceWrap != null) && (this.jdField_a_of_type_CooperationWadlIpcWadlProxyServiceWrap.a != null)) {
      this.jdField_a_of_type_CooperationWadlIpcWadlProxyServiceWrap.a.a(paramAppRuntime);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.open.wadl.WadlJsBridgeService
 * JD-Core Version:    0.7.0.1
 */