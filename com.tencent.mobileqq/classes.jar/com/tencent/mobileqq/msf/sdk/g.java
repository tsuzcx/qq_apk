package com.tencent.mobileqq.msf.sdk;

import android.telephony.TelephonyManager;
import com.tencent.qphone.base.util.QLog;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class g
{
  private static String a = "MSF.D.AppNetSubscriptionManager";
  
  public static int a(TelephonyManager paramTelephonyManager, int paramInt)
  {
    try
    {
      Method localMethod = TelephonyManager.class.getDeclaredMethod("getNetworkClass", new Class[] { Integer.TYPE });
      localMethod.setAccessible(true);
      paramInt = ((Integer)localMethod.invoke(paramTelephonyManager, new Object[] { Integer.valueOf(paramInt) })).intValue();
      return paramInt;
    }
    catch (Exception paramTelephonyManager)
    {
      QLog.e(a, 1, "getSystemNetworkClass excep!", paramTelephonyManager);
    }
    return 1;
  }
  
  public static int a(Object paramObject)
  {
    if (paramObject == null) {
      return -1;
    }
    try
    {
      localMethod = paramObject.getClass().getDeclaredMethod("getDefaultDataSubId", new Class[0]);
      localMethod.setAccessible(true);
      i = ((Integer)localMethod.invoke(paramObject, new Object[0])).intValue();
      return i;
    }
    catch (Exception paramObject)
    {
      Method localMethod;
      int i;
      if (QLog.isColorLevel())
      {
        QLog.w(a, 2, "getDefaultDataSubId excep!", paramObject);
        return -1;
      }
      QLog.w(a, 2, "getDefaultDataSubId excep!");
      return -1;
      try
      {
        localMethod = paramObject.getClass().getDeclaredMethod("getDefaultDataSubscriptionId", new Class[0]);
        localMethod.setAccessible(true);
        i = ((Integer)localMethod.invoke(paramObject, new Object[0])).intValue();
        return i;
      }
      catch (Exception paramObject)
      {
        if (QLog.isColorLevel())
        {
          QLog.w(a, 2, "getDefaultDataSubscriptionId excep!", paramObject);
          return -1;
        }
        QLog.w(a, 2, "getDefaultDataSubscriptionId excep!");
        return -1;
      }
    }
    catch (NoSuchMethodException localNoSuchMethodException)
    {
      label73:
      break label73;
    }
  }
  
  public static Object a(TelephonyManager paramTelephonyManager)
  {
    try
    {
      Field localField = TelephonyManager.class.getDeclaredField("mSubscriptionManager");
      localField.setAccessible(true);
      paramTelephonyManager = localField.get(paramTelephonyManager);
      return paramTelephonyManager;
    }
    catch (Exception paramTelephonyManager)
    {
      if (QLog.isColorLevel()) {
        QLog.w(a, 2, "getSubscriptionManager excep!", paramTelephonyManager);
      } else {
        QLog.w(a, 2, "getSubscriptionManager excep!");
      }
    }
    return null;
  }
  
  public static int b(TelephonyManager paramTelephonyManager)
  {
    long l = System.currentTimeMillis();
    int k = a(a(paramTelephonyManager));
    if (k == -1) {
      return paramTelephonyManager.getNetworkType();
    }
    int i = 0;
    int j;
    try
    {
      Method localMethod = TelephonyManager.class.getDeclaredMethod("getNetworkType", new Class[] { Integer.TYPE });
      localMethod.setAccessible(true);
      j = ((Integer)localMethod.invoke(paramTelephonyManager, new Object[] { Integer.valueOf(k) })).intValue();
      i = j;
    }
    catch (Exception localException)
    {
      QLog.e(a, 1, "getNetworkType excep!", localException);
    }
    try
    {
      j = paramTelephonyManager.getNetworkType();
      i = j;
    }
    catch (SecurityException paramTelephonyManager)
    {
      label102:
      StringBuilder localStringBuilder;
      break label102;
    }
    QLog.e(a, 1, "getNetworkType se", localException);
    i = y.a(i);
    if (QLog.isColorLevel())
    {
      paramTelephonyManager = a;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("getNetworkType:");
      localStringBuilder.append(i);
      localStringBuilder.append(" ,simID:");
      localStringBuilder.append(k);
      localStringBuilder.append(" ,cost:");
      localStringBuilder.append(System.currentTimeMillis() - l);
      QLog.d(paramTelephonyManager, 2, localStringBuilder.toString());
    }
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.msf.sdk.g
 * JD-Core Version:    0.7.0.1
 */