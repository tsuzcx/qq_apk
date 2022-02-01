package kcsdkext;

import android.content.pm.PackageParser;
import android.content.pm.PackageParser.Package;
import android.content.pm.Signature;
import android.os.Build.VERSION;
import android.util.DisplayMetrics;
import android.util.Log;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;

public class b
{
  public static Object a(Object paramObject, File paramFile, String paramString, DisplayMetrics paramDisplayMetrics, int paramInt)
  {
    try
    {
      if (Build.VERSION.SDK_INT >= 21) {
        return a(paramObject, "parsePackage", new Object[] { paramFile, Integer.valueOf(paramInt) });
      }
      paramObject = a(paramObject, "parsePackage", new Object[] { paramFile, paramString, paramDisplayMetrics, Integer.valueOf(paramInt) });
      return paramObject;
    }
    catch (Throwable paramObject)
    {
      paramObject.printStackTrace();
    }
    return null;
  }
  
  public static Object a(Object paramObject, String paramString, Object[] paramArrayOfObject)
  {
    Class localClass = paramObject.getClass();
    Class[] arrayOfClass = new Class[paramArrayOfObject.length];
    int i = 0;
    int j = paramArrayOfObject.length;
    if (i < j)
    {
      arrayOfClass[i] = paramArrayOfObject[i].getClass();
      if (arrayOfClass[i] == Integer.class) {
        arrayOfClass[i] = Integer.TYPE;
      }
      for (;;)
      {
        i += 1;
        break;
        if (arrayOfClass[i] == Boolean.class) {
          arrayOfClass[i] = Boolean.TYPE;
        }
      }
    }
    return localClass.getMethod(paramString, arrayOfClass).invoke(paramObject, paramArrayOfObject);
  }
  
  public static Object a(String paramString)
  {
    try
    {
      if (Build.VERSION.SDK_INT >= 21) {
        return a("android.content.pm.PackageParser", null);
      }
      paramString = a("android.content.pm.PackageParser", new Object[] { paramString });
      return paramString;
    }
    catch (Throwable paramString)
    {
      paramString.printStackTrace();
    }
    return null;
  }
  
  public static Object a(String paramString, Object[] paramArrayOfObject)
  {
    Class localClass = Class.forName(paramString);
    if (paramArrayOfObject == null)
    {
      paramString = null;
      return localClass.getConstructor(paramString).newInstance(paramArrayOfObject);
    }
    Class[] arrayOfClass = new Class[paramArrayOfObject.length];
    int i = 0;
    int j = paramArrayOfObject.length;
    for (;;)
    {
      paramString = arrayOfClass;
      if (i >= j) {
        break;
      }
      arrayOfClass[i] = paramArrayOfObject[i].getClass();
      i += 1;
    }
  }
  
  public static String a(String paramString1, String paramString2)
  {
    Log.d("--PackageUtil--", "getSignatureMd5-apkPath:[" + paramString1 + "]");
    if (Build.VERSION.SDK_INT >= 27) {
      return paramString2;
    }
    for (;;)
    {
      try
      {
        Object localObject = a(paramString1);
        PackageParser localPackageParser = (PackageParser)localObject;
        DisplayMetrics localDisplayMetrics = new DisplayMetrics();
        localDisplayMetrics.setToDefaults();
        paramString1 = (PackageParser.Package)a(localObject, new File(paramString1), paramString1, localDisplayMetrics, 0);
        PackageParser.class.getMethod("collectCertificates", new Class[] { paramString1.getClass(), Integer.TYPE }).invoke(localPackageParser, new Object[] { paramString1, Integer.valueOf(0) });
        if (Build.VERSION.SDK_INT < 27)
        {
          paramString1 = (Signature[])paramString1.getClass().getDeclaredField("mSignatures").get(paramString1);
          if (paramString1 != null)
          {
            paramString1 = paramString1[0];
            if (paramString1 != null)
            {
              paramString1 = new ByteArrayInputStream(paramString1.toByteArray());
              paramString1 = a.c(((X509Certificate)CertificateFactory.getInstance("X.509").generateCertificate(paramString1)).getEncoded());
              if (paramString1 != null)
              {
                paramString1 = paramString1.toUpperCase();
                Log.d("--PackageUtil--", "SignatureMd5:[" + paramString1 + "]");
                return paramString1;
              }
              paramString1 = null;
              continue;
            }
          }
        }
        paramString1 = "";
      }
      catch (Throwable paramString1)
      {
        Log.e("--PackageUtil--", "e:[" + paramString1 + "]");
        Log.d("--PackageUtil--", "SignatureMd5:[" + paramString2 + "]");
        return paramString2;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     kcsdkext.b
 * JD-Core Version:    0.7.0.1
 */