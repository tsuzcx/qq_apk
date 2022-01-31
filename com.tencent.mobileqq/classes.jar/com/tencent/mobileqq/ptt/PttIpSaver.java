package com.tencent.mobileqq.ptt;

import android.content.Context;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.msf.sdk.AppNetConnInfo;
import com.tencent.mobileqq.msf.sdk.handler.INetInfoHandler;
import com.tencent.mobileqq.transfile.ServerAddr;
import com.tencent.qphone.base.util.QLog;

public class PttIpSaver
  implements INetInfoHandler
{
  public String a;
  private boolean a;
  public String b;
  public String c;
  private String d;
  
  public PttIpSaver()
  {
    this.jdField_a_of_type_Boolean = true;
    AppNetConnInfo.registerConnectionChangeReceiver(BaseApplicationImpl.getApplication(), this);
    a();
  }
  
  public static String a()
  {
    return "XGIdentifier";
  }
  
  public static String a(Context paramContext)
  {
    try
    {
      long l = System.nanoTime();
      paramContext = ((WifiManager)paramContext.getSystemService("wifi")).getConnectionInfo();
      if (paramContext != null)
      {
        paramContext = paramContext.getBSSID();
        if (QLog.isColorLevel()) {
          QLog.e("PttIpSaver", 2, "getWifiMac " + paramContext + " time=" + (System.nanoTime() - l) / 1000000L);
        }
        return paramContext;
      }
    }
    catch (Throwable paramContext) {}
    return null;
  }
  
  public String a(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.e("PttIpSaver", 2, "getIp:" + paramInt);
    }
    if (paramInt == 0) {
      return this.jdField_a_of_type_JavaLangString;
    }
    if (paramInt == 1) {
      return this.b;
    }
    if (paramInt == 2) {
      return this.c;
    }
    return null;
  }
  
  public void a()
  {
    try
    {
      this.d = a(BaseApplicationImpl.getContext());
      this.jdField_a_of_type_Boolean = true;
      if (this.d == null)
      {
        this.d = a();
        this.jdField_a_of_type_Boolean = false;
      }
      if (QLog.isColorLevel()) {
        QLog.e("PttIpSaver", 2, "onNetMobile2Wifi  " + this.d);
      }
      return;
    }
    finally {}
  }
  
  public void a(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.e("PttIpSaver", 2, "clear ip:" + paramInt);
    }
    if (paramInt == -1)
    {
      this.jdField_a_of_type_JavaLangString = null;
      this.b = null;
      this.c = null;
    }
    do
    {
      return;
      if (paramInt == 0)
      {
        this.jdField_a_of_type_JavaLangString = null;
        return;
      }
      if (paramInt == 1)
      {
        this.b = null;
        return;
      }
    } while (paramInt != 2);
    this.c = null;
  }
  
  public void a(ServerAddr paramServerAddr, int paramInt)
  {
    Object localObject = null;
    if (paramServerAddr != null)
    {
      localObject = new StringBuffer(200);
      ((StringBuffer)localObject).append("http://").append(paramServerAddr.jdField_a_of_type_JavaLangString);
      if (paramServerAddr.jdField_a_of_type_Int != 80) {
        ((StringBuffer)localObject).append(":").append(paramServerAddr.jdField_a_of_type_Int);
      }
      ((StringBuffer)localObject).append("/");
      localObject = ((StringBuffer)localObject).toString();
    }
    a((String)localObject, paramInt);
  }
  
  public void a(String paramString, int paramInt)
  {
    if (paramString == null) {}
    do
    {
      return;
      String str = paramString;
      if (!paramString.startsWith("http://")) {
        str = "http://" + paramString;
      }
      paramString = str;
      if (!str.endsWith("/")) {
        paramString = str + "/";
      }
      if (QLog.isColorLevel()) {
        QLog.e("PttIpSaver", 2, "saveIp:" + paramInt + " " + paramString);
      }
      if (paramInt == 0)
      {
        this.jdField_a_of_type_JavaLangString = paramString;
        return;
      }
      if (paramInt == 1)
      {
        this.b = paramString;
        return;
      }
    } while (paramInt != 2);
    this.c = paramString;
  }
  
  public boolean a()
  {
    try
    {
      boolean bool = this.jdField_a_of_type_Boolean;
      return bool;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public String b()
  {
    try
    {
      String str = this.d;
      return str;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public void b()
  {
    try
    {
      AppNetConnInfo.unregisterNetInfoHandler(this);
      return;
    }
    catch (Throwable localThrowable)
    {
      localThrowable.printStackTrace();
    }
  }
  
  public void onNetMobile2None()
  {
    try
    {
      a(-1);
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public void onNetMobile2Wifi(String paramString)
  {
    try
    {
      this.d = a(BaseApplicationImpl.getContext());
      a(-1);
      if (QLog.isColorLevel()) {
        QLog.e("PttIpSaver", 2, "onNetMobile2Wifi  " + this.d);
      }
      return;
    }
    finally
    {
      paramString = finally;
      throw paramString;
    }
  }
  
  public void onNetNone2Mobile(String paramString)
  {
    try
    {
      this.d = a();
      this.jdField_a_of_type_Boolean = false;
      a(-1);
      if (QLog.isColorLevel()) {
        QLog.e("PttIpSaver", 2, "onNetNone2Mobile  " + this.d);
      }
      return;
    }
    finally
    {
      paramString = finally;
      throw paramString;
    }
  }
  
  public void onNetNone2Wifi(String paramString)
  {
    try
    {
      this.d = a(BaseApplicationImpl.getContext());
      this.jdField_a_of_type_Boolean = true;
      a(-1);
      if (QLog.isColorLevel()) {
        QLog.e("PttIpSaver", 2, "onNetNone2Wifi  " + this.d);
      }
      return;
    }
    finally
    {
      paramString = finally;
      throw paramString;
    }
  }
  
  public void onNetWifi2Mobile(String paramString)
  {
    try
    {
      this.d = a();
      this.jdField_a_of_type_Boolean = false;
      a(-1);
      if (QLog.isColorLevel()) {
        QLog.e("PttIpSaver", 2, "onNetWifi2Mobile  " + this.d);
      }
      return;
    }
    finally
    {
      paramString = finally;
      throw paramString;
    }
  }
  
  public void onNetWifi2None()
  {
    try
    {
      a(-1);
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\a.jar
 * Qualified Name:     com.tencent.mobileqq.ptt.PttIpSaver
 * JD-Core Version:    0.7.0.1
 */