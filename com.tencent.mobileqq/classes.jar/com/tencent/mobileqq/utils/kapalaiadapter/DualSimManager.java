package com.tencent.mobileqq.utils.kapalaiadapter;

import android.os.IBinder;
import android.telephony.TelephonyManager;
import com.android.internal.telephony.ISms;
import com.android.internal.telephony.ISms.Stub;
import com.tencent.qphone.base.util.BaseApplication;
import java.lang.reflect.Method;

public class DualSimManager
{
  public static int a;
  private static DualSimManager jdField_a_of_type_ComTencentMobileqqUtilsKapalaiadapterDualSimManager = null;
  public static String a;
  public static String b;
  public static String c = "1";
  private Object jdField_a_of_type_JavaLangObject = null;
  private TelephonyManager[] jdField_a_of_type_ArrayOfAndroidTelephonyTelephonyManager = null;
  private ISms[] jdField_a_of_type_ArrayOfComAndroidInternalTelephonyISms = null;
  private Object b;
  
  static
  {
    jdField_a_of_type_Int = -1;
    jdField_a_of_type_JavaLangString = null;
    jdField_b_of_type_JavaLangString = "0";
  }
  
  private DualSimManager()
  {
    this.jdField_b_of_type_JavaLangObject = null;
    try
    {
      a();
      return;
    }
    catch (Throwable localThrowable)
    {
      localThrowable.printStackTrace();
    }
  }
  
  public static DualSimManager a()
  {
    if (jdField_a_of_type_ComTencentMobileqqUtilsKapalaiadapterDualSimManager == null) {}
    try
    {
      jdField_a_of_type_ComTencentMobileqqUtilsKapalaiadapterDualSimManager = new DualSimManager();
      return jdField_a_of_type_ComTencentMobileqqUtilsKapalaiadapterDualSimManager;
    }
    finally {}
  }
  
  private void a()
  {
    this.jdField_a_of_type_ArrayOfComAndroidInternalTelephonyISms = new ISms[2];
    switch (jdField_a_of_type_Int)
    {
    case 0: 
    case 1: 
    case 4: 
    default: 
    case 2: 
    case 3: 
      for (;;)
      {
        return;
        try
        {
          this.jdField_a_of_type_JavaLangObject = ReflecterHelper.a("android.telephony.MSimTelephonyManager", "getDefault", null, null);
          this.jdField_b_of_type_JavaLangObject = ReflecterHelper.a("android.telephony.MSimSmsManager", "getDefault", null, null);
          return;
        }
        catch (Exception localException1)
        {
          localException1.printStackTrace();
          return;
        }
        try
        {
          this.jdField_a_of_type_ArrayOfComAndroidInternalTelephonyISms[0] = ISms.Stub.a(ServiceManager.a("isms"));
          this.jdField_a_of_type_ArrayOfComAndroidInternalTelephonyISms[1] = ISms.Stub.a(ServiceManager.a("isms2"));
          if (this.jdField_a_of_type_ArrayOfAndroidTelephonyTelephonyManager == null)
          {
            this.jdField_a_of_type_ArrayOfAndroidTelephonyTelephonyManager = new TelephonyManager[2];
            this.jdField_a_of_type_ArrayOfAndroidTelephonyTelephonyManager[0] = ((TelephonyManager)ReflecterHelper.a("android.telephony.TelephonyManager", "getDefault"));
            this.jdField_a_of_type_ArrayOfAndroidTelephonyTelephonyManager[1] = ((TelephonyManager)ReflecterHelper.a("android.telephony.TelephonyManager", "getSecondary"));
            return;
          }
        }
        catch (Exception localException2)
        {
          localException2.printStackTrace();
          return;
        }
        catch (Error localError)
        {
          localError.printStackTrace();
          return;
        }
      }
    }
    try
    {
      this.jdField_a_of_type_JavaLangObject = BaseApplication.getContext().getSystemService("phone");
      ISms localISms = ISms.Stub.a((IBinder)Class.forName("android.os.ServiceManager").getMethod("getService", new Class[] { String.class }).invoke(null, new Object[] { "isms" }));
      this.jdField_a_of_type_ArrayOfComAndroidInternalTelephonyISms[0] = localISms;
      return;
    }
    catch (Throwable localThrowable)
    {
      localThrowable.printStackTrace();
    }
  }
  
  public int a(int paramInt)
  {
    int i = 1;
    switch (jdField_a_of_type_Int)
    {
    }
    for (;;)
    {
      return 0;
      if (this.jdField_a_of_type_JavaLangObject == null) {
        continue;
      }
      try
      {
        paramInt = ((Integer)ReflecterHelper.a(this.jdField_a_of_type_JavaLangObject, "getSimState", new Object[] { Integer.valueOf(paramInt) })).intValue();
        return paramInt;
      }
      catch (Exception localException1)
      {
        localException1.printStackTrace();
      }
      continue;
      if (this.jdField_a_of_type_ArrayOfAndroidTelephonyTelephonyManager == null) {
        continue;
      }
      return this.jdField_a_of_type_ArrayOfAndroidTelephonyTelephonyManager[paramInt].getSimState();
      if (this.jdField_a_of_type_JavaLangObject == null) {
        continue;
      }
      try
      {
        Object localObject = this.jdField_a_of_type_JavaLangObject;
        if (paramInt == 0) {}
        for (paramInt = i;; paramInt = 5)
        {
          paramInt = ((Integer)ReflecterHelper.a(localObject, "getIccState", new Object[] { Integer.valueOf(paramInt) })).intValue();
          return paramInt;
        }
      }
      catch (Exception localException2)
      {
        localException2.printStackTrace();
      }
    }
  }
  
  public boolean a(int paramInt)
  {
    return a(paramInt) == 5;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.utils.kapalaiadapter.DualSimManager
 * JD-Core Version:    0.7.0.1
 */