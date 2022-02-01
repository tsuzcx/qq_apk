package com.tencent.mobileqq.richmedia;

import com.tencent.mobileqq.msf.sdk.AppNetConnInfo;
import com.tencent.mobileqq.utils.DeviceInfoUtil;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;

public class RichMediaIpSaver
  implements IRichMediaIpSaver
{
  public String a;
  protected boolean a;
  public String b = null;
  public String c = null;
  protected String d = null;
  
  public RichMediaIpSaver()
  {
    this.jdField_a_of_type_JavaLangString = null;
    this.jdField_a_of_type_Boolean = true;
    AppNetConnInfo.registerConnectionChangeReceiver(BaseApplication.getContext(), this);
    b();
  }
  
  public static String b()
  {
    return "XGIdentifier";
  }
  
  public String a()
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
  
  public void a()
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
  
  public void a(int paramInt)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("clear ip:");
      localStringBuilder.append(paramInt);
      QLog.e("PttIpSaver", 2, localStringBuilder.toString());
    }
    if (paramInt == -1)
    {
      this.jdField_a_of_type_JavaLangString = null;
      this.b = null;
      this.c = null;
      return;
    }
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
    if (paramInt == 2) {
      this.c = null;
    }
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
  
  public void b()
  {
    try
    {
      this.d = DeviceInfoUtil.b(BaseApplication.getContext());
      this.jdField_a_of_type_Boolean = true;
      if (this.d == null)
      {
        this.d = b();
        this.jdField_a_of_type_Boolean = false;
      }
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("onNetMobile2Wifi  ");
        localStringBuilder.append(this.d);
        QLog.e("PttIpSaver", 2, localStringBuilder.toString());
      }
      return;
    }
    finally {}
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
      this.d = DeviceInfoUtil.b(BaseApplication.getContext());
      a(-1);
      if (QLog.isColorLevel())
      {
        paramString = new StringBuilder();
        paramString.append("onNetMobile2Wifi  ");
        paramString.append(this.d);
        QLog.e("PttIpSaver", 2, paramString.toString());
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
      this.d = b();
      this.jdField_a_of_type_Boolean = false;
      a(-1);
      if (QLog.isColorLevel())
      {
        paramString = new StringBuilder();
        paramString.append("onNetNone2Mobile  ");
        paramString.append(this.d);
        QLog.e("PttIpSaver", 2, paramString.toString());
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
      this.d = DeviceInfoUtil.b(BaseApplication.getContext());
      this.jdField_a_of_type_Boolean = true;
      a(-1);
      if (QLog.isColorLevel())
      {
        paramString = new StringBuilder();
        paramString.append("onNetNone2Wifi  ");
        paramString.append(this.d);
        QLog.e("PttIpSaver", 2, paramString.toString());
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
      this.d = b();
      this.jdField_a_of_type_Boolean = false;
      a(-1);
      if (QLog.isColorLevel())
      {
        paramString = new StringBuilder();
        paramString.append("onNetWifi2Mobile  ");
        paramString.append(this.d);
        QLog.e("PttIpSaver", 2, paramString.toString());
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.richmedia.RichMediaIpSaver
 * JD-Core Version:    0.7.0.1
 */