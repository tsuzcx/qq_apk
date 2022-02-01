package cooperation.qlink;

import android.content.Intent;
import android.net.wifi.WifiManager;
import android.os.Bundle;
import com.qq.jce.wup.BasicClassTypeUtil;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qphone.base.util.BaseApplication;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.URLDecoder;

public class QlinkHelper
{
  public static Intent a()
  {
    Intent localIntent = new Intent();
    QlinkPluginProxyActivity.a(localIntent, "com.tencent.qlink.activity.QlinkProxyActivity");
    return localIntent;
  }
  
  public static AppInterface a(BaseApplicationImpl paramBaseApplicationImpl, String paramString)
  {
    if (paramBaseApplicationImpl != null)
    {
      if (paramString == null) {
        return null;
      }
      for (;;)
      {
        try
        {
          try
          {
            localClass = Class.forName("com.tencent.qlink.app.QlinkAppInterface");
          }
          catch (Exception paramBaseApplicationImpl) {}catch (NoSuchMethodException paramBaseApplicationImpl) {}catch (InvocationTargetException paramBaseApplicationImpl) {}catch (InstantiationException paramBaseApplicationImpl) {}catch (IllegalAccessException paramBaseApplicationImpl) {}catch (IllegalArgumentException paramBaseApplicationImpl) {}
        }
        catch (ClassNotFoundException localClassNotFoundException)
        {
          Class localClass;
          ClassLoader localClassLoader;
          continue;
          if (localClassNotFoundException != null) {
            continue;
          }
        }
        try
        {
          localClassLoader = QlinkPluginProxyActivity.a(paramBaseApplicationImpl);
          localClass = localClassLoader.loadClass("com.tencent.qlink.app.QlinkAppInterface");
          BasicClassTypeUtil.setClassLoader(true, localClassLoader);
        }
        catch (ClassNotFoundException paramBaseApplicationImpl)
        {
          paramBaseApplicationImpl.printStackTrace();
        }
      }
      paramBaseApplicationImpl = localClass.getDeclaredConstructor(new Class[] { paramBaseApplicationImpl.getClass(), paramString.getClass() }).newInstance(new Object[] { paramBaseApplicationImpl, paramString });
      if ((paramBaseApplicationImpl != null) && ((paramBaseApplicationImpl instanceof AppInterface)))
      {
        paramBaseApplicationImpl = (AppInterface)paramBaseApplicationImpl;
        return paramBaseApplicationImpl;
        paramBaseApplicationImpl.printStackTrace();
        return null;
        paramBaseApplicationImpl.printStackTrace();
        return null;
        paramBaseApplicationImpl.printStackTrace();
        return null;
        paramBaseApplicationImpl.printStackTrace();
        return null;
        paramBaseApplicationImpl.printStackTrace();
        return null;
        paramBaseApplicationImpl.printStackTrace();
        return null;
      }
    }
    return null;
    return null;
  }
  
  public static QlinkHelper.QRScanInfo a(String paramString)
  {
    if (paramString == null) {
      return null;
    }
    QlinkHelper.QRScanInfo localQRScanInfo = new QlinkHelper.QRScanInfo();
    Object localObject;
    int j;
    int i;
    String str2;
    try
    {
      if (!paramString.startsWith("qqf2f://qf/?")) {
        return null;
      }
      localObject = paramString.substring(12, paramString.length()).split("&");
      paramString = new Bundle();
      j = localObject.length;
      i = 0;
    }
    catch (Exception paramString)
    {
      int k;
      String str1;
      paramString.printStackTrace();
      return null;
    }
    k = str2.indexOf("=");
    if (-1 != k)
    {
      k += 1;
      str1 = str2.substring(0, k);
      str2 = str2.substring(k, str2.length());
      if ((str1 != null) && (str2 != null)) {
        paramString.putString(str1, str2);
      }
    }
    label301:
    for (;;)
    {
      localQRScanInfo.a = paramString.getString("k=");
      localQRScanInfo.b = d(paramString.getString("u="));
      localObject = b(paramString.getString("n="));
      if (localObject != null)
      {
        localQRScanInfo.c = URLDecoder.decode((String)localObject, "UTF-8");
        if (localQRScanInfo.c == null) {
          localQRScanInfo.c = localQRScanInfo.b;
        }
      }
      else
      {
        localQRScanInfo.c = localQRScanInfo.b;
      }
      localQRScanInfo.d = paramString.getString("o=");
      localQRScanInfo.e = paramString.getString("p=");
      localQRScanInfo.f = paramString.getString("d=");
      if ((localQRScanInfo.a != null) && (localQRScanInfo.b != null))
      {
        paramString = localQRScanInfo.d;
        if (paramString == null) {
          return null;
        }
        return localQRScanInfo;
      }
      return null;
      for (;;)
      {
        if (i >= j) {
          break label301;
        }
        str2 = localObject[i];
        if (str2 != null) {
          break;
        }
        i += 1;
      }
    }
  }
  
  public static String a(String paramString)
  {
    if (paramString == null) {
      return null;
    }
    Object localObject = paramString.getBytes();
    paramString = new byte[localObject.length];
    int j = 0;
    int i = 0;
    while (i < localObject.length)
    {
      paramString[i] = ((byte)((byte)((byte)(localObject[i] ^ 0xFFFFFFA2) ^ 0x68) ^ 0x1B));
      i += 1;
    }
    localObject = new StringBuilder(paramString.length * 2);
    i = j;
    while (i < paramString.length)
    {
      ((StringBuilder)localObject).append(Integer.toHexString((paramString[i] & 0xF0) >> 4));
      ((StringBuilder)localObject).append(Integer.toHexString(paramString[i] & 0xF));
      i += 1;
    }
    return ((StringBuilder)localObject).toString();
  }
  
  public static boolean a()
  {
    try
    {
      WifiManager localWifiManager = (WifiManager)BaseApplicationImpl.getContext().getSystemService("wifi");
      Method localMethod = localWifiManager.getClass().getMethod("isWifiApEnabled", new Class[0]);
      localMethod.setAccessible(true);
      boolean bool = ((Boolean)localMethod.invoke(localWifiManager, new Object[0])).booleanValue();
      return bool;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
      return false;
    }
    catch (NoSuchMethodException localNoSuchMethodException)
    {
      localNoSuchMethodException.printStackTrace();
    }
    return false;
  }
  
  public static String b(String paramString)
  {
    if (paramString == null) {
      return null;
    }
    int k = paramString.length() / 2;
    byte[] arrayOfByte = new byte[k];
    int j = 0;
    int i = 0;
    while (i < k)
    {
      int m = i * 2;
      try
      {
        arrayOfByte[i] = Integer.valueOf(paramString.substring(m, m + 2), 16).byteValue();
        i += 1;
      }
      catch (NumberFormatException paramString)
      {
        paramString.printStackTrace();
        return null;
      }
    }
    paramString = new byte[k];
    i = j;
    while (i < arrayOfByte.length)
    {
      paramString[i] = ((byte)((byte)((byte)(arrayOfByte[i] ^ 0x1B) ^ 0x68) ^ 0xFFFFFFA2));
      i += 1;
    }
    try
    {
      paramString = new String(paramString, "UTF-8");
      return paramString;
    }
    catch (Exception paramString)
    {
      paramString.printStackTrace();
    }
    return null;
  }
  
  public static String c(String paramString)
  {
    try
    {
      long l = Long.valueOf(paramString).longValue();
      return String.valueOf(l ^ 0x3702D1C2 ^ 0x5891625D ^ 0xCF267E29);
    }
    catch (Exception paramString)
    {
      label25:
      break label25;
    }
    return null;
  }
  
  public static String d(String paramString)
  {
    try
    {
      long l = Long.valueOf(paramString).longValue();
      return String.valueOf(l ^ 0xCF267E29 ^ 0x5891625D ^ 0x3702D1C2);
    }
    catch (Exception paramString)
    {
      label25:
      break label25;
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     cooperation.qlink.QlinkHelper
 * JD-Core Version:    0.7.0.1
 */