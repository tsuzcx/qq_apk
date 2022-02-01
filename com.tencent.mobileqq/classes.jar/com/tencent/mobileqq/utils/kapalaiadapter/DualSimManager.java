package com.tencent.mobileqq.utils.kapalaiadapter;

import android.os.IBinder;
import android.telephony.TelephonyManager;
import com.android.internal.telephony.ISms;
import com.android.internal.telephony.ISms.Stub;
import com.tencent.qphone.base.util.BaseApplication;
import java.lang.reflect.Method;

public class DualSimManager
{
  public static int a = -1;
  private static DualSimManager jdField_a_of_type_ComTencentMobileqqUtilsKapalaiadapterDualSimManager;
  public static String a;
  public static String b = "0";
  public static String c = "1";
  private Object jdField_a_of_type_JavaLangObject = null;
  private TelephonyManager[] jdField_a_of_type_ArrayOfAndroidTelephonyTelephonyManager = null;
  private ISms[] jdField_a_of_type_ArrayOfComAndroidInternalTelephonyISms = null;
  private Object b = null;
  
  private DualSimManager()
  {
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
    if (jdField_a_of_type_ComTencentMobileqqUtilsKapalaiadapterDualSimManager == null) {
      try
      {
        jdField_a_of_type_ComTencentMobileqqUtilsKapalaiadapterDualSimManager = new DualSimManager();
      }
      finally {}
    }
    return jdField_a_of_type_ComTencentMobileqqUtilsKapalaiadapterDualSimManager;
  }
  
  private void a()
  {
    this.jdField_a_of_type_ArrayOfComAndroidInternalTelephonyISms = new ISms[2];
    int i = jdField_a_of_type_Int;
    if ((i != 0) && (i != 1)) {
      if (i != 2)
      {
        if (i != 3)
        {
          if (i == 4) {
            return;
          }
          if (i != 5) {
            return;
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
            return;
          }
        }
        try
        {
          this.jdField_a_of_type_ArrayOfComAndroidInternalTelephonyISms[0] = ISms.Stub.a(ServiceManager.a("isms"));
          this.jdField_a_of_type_ArrayOfComAndroidInternalTelephonyISms[1] = ISms.Stub.a(ServiceManager.a("isms2"));
          if (this.jdField_a_of_type_ArrayOfAndroidTelephonyTelephonyManager != null) {
            return;
          }
          this.jdField_a_of_type_ArrayOfAndroidTelephonyTelephonyManager = new TelephonyManager[2];
          this.jdField_a_of_type_ArrayOfAndroidTelephonyTelephonyManager[0] = ((TelephonyManager)ReflecterHelper.a("android.telephony.TelephonyManager", "getDefault"));
          this.jdField_a_of_type_ArrayOfAndroidTelephonyTelephonyManager[1] = ((TelephonyManager)ReflecterHelper.a("android.telephony.TelephonyManager", "getSecondary"));
          return;
        }
        catch (Error localError)
        {
          localError.printStackTrace();
          return;
        }
        catch (Exception localException1)
        {
          localException1.printStackTrace();
          return;
        }
      }
      else
      {
        try
        {
          this.jdField_a_of_type_JavaLangObject = ReflecterHelper.a("android.telephony.MSimTelephonyManager", "getDefault", null, null);
          this.b = ReflecterHelper.a("android.telephony.MSimSmsManager", "getDefault", null, null);
          return;
        }
        catch (Exception localException2)
        {
          localException2.printStackTrace();
        }
      }
    }
  }
  
  public int a(int paramInt)
  {
    int j = jdField_a_of_type_Int;
    Object localObject1;
    if (j != 0)
    {
      int i = 1;
      if (j != 1) {
        if (j != 2) {
          if (j != 3)
          {
            if (j == 4) {
              break label157;
            }
            if (j != 5) {
              return 0;
            }
            localObject1 = this.jdField_a_of_type_JavaLangObject;
            if (localObject1 == null) {
              break label157;
            }
            if (paramInt != 0) {
              break label159;
            }
            paramInt = i;
          }
        }
      }
    }
    for (;;)
    {
      try
      {
        paramInt = ((Integer)ReflecterHelper.a(localObject1, "getIccState", new Object[] { Integer.valueOf(paramInt) })).intValue();
        return paramInt;
      }
      catch (Exception localException1)
      {
        localException1.printStackTrace();
        return 0;
      }
      Object localObject2 = this.jdField_a_of_type_ArrayOfAndroidTelephonyTelephonyManager;
      if (localObject2 != null)
      {
        return localObject2[paramInt].getSimState();
        localObject2 = this.jdField_a_of_type_JavaLangObject;
        if (localObject2 != null) {
          try
          {
            paramInt = ((Integer)ReflecterHelper.a(localObject2, "getSimState", new Object[] { Integer.valueOf(paramInt) })).intValue();
            return paramInt;
          }
          catch (Exception localException2)
          {
            localException2.printStackTrace();
          }
        }
      }
      label157:
      return 0;
      label159:
      paramInt = 5;
    }
  }
  
  public boolean a(int paramInt)
  {
    return a(paramInt) == 5;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.utils.kapalaiadapter.DualSimManager
 * JD-Core Version:    0.7.0.1
 */