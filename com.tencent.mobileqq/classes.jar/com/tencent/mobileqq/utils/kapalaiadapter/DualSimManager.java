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
  public static String b;
  public static String c = "0";
  public static String d = "1";
  private static DualSimManager e;
  private Object f = null;
  private TelephonyManager[] g = null;
  private Object h = null;
  private ISms[] i = null;
  
  private DualSimManager()
  {
    try
    {
      b();
      return;
    }
    catch (Throwable localThrowable)
    {
      localThrowable.printStackTrace();
    }
  }
  
  public static DualSimManager a()
  {
    if (e == null) {
      try
      {
        e = new DualSimManager();
      }
      finally {}
    }
    return e;
  }
  
  private void b()
  {
    this.i = new ISms[2];
    int j = a;
    if ((j != 0) && (j != 1)) {
      if (j != 2)
      {
        if (j != 3)
        {
          if (j == 4) {
            return;
          }
          if (j != 5) {
            return;
          }
          try
          {
            this.f = BaseApplication.getContext().getSystemService("phone");
            ISms localISms = ISms.Stub.a((IBinder)Class.forName("android.os.ServiceManager").getMethod("getService", new Class[] { String.class }).invoke(null, new Object[] { "isms" }));
            this.i[0] = localISms;
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
          this.i[0] = ISms.Stub.a(ServiceManager.a("isms"));
          this.i[1] = ISms.Stub.a(ServiceManager.a("isms2"));
          if (this.g != null) {
            return;
          }
          this.g = new TelephonyManager[2];
          this.g[0] = ((TelephonyManager)ReflecterHelper.a("android.telephony.TelephonyManager", "getDefault"));
          this.g[1] = ((TelephonyManager)ReflecterHelper.a("android.telephony.TelephonyManager", "getSecondary"));
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
          this.f = ReflecterHelper.a("android.telephony.MSimTelephonyManager", "getDefault", null, null);
          this.h = ReflecterHelper.a("android.telephony.MSimSmsManager", "getDefault", null, null);
          return;
        }
        catch (Exception localException2)
        {
          localException2.printStackTrace();
        }
      }
    }
  }
  
  public boolean a(int paramInt)
  {
    return b(paramInt) == 5;
  }
  
  public int b(int paramInt)
  {
    int k = a;
    Object localObject1;
    if (k != 0)
    {
      int j = 1;
      if (k != 1) {
        if (k != 2) {
          if (k != 3)
          {
            if (k == 4) {
              break label157;
            }
            if (k != 5) {
              return 0;
            }
            localObject1 = this.f;
            if (localObject1 == null) {
              break label157;
            }
            if (paramInt != 0) {
              break label159;
            }
            paramInt = j;
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
      Object localObject2 = this.g;
      if (localObject2 != null)
      {
        return localObject2[paramInt].getSimState();
        localObject2 = this.f;
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
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.utils.kapalaiadapter.DualSimManager
 * JD-Core Version:    0.7.0.1
 */