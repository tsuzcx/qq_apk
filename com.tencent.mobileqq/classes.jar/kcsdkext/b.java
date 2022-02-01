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
      int i = Build.VERSION.SDK_INT;
      if (i >= 21) {
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
    int j = paramArrayOfObject.length;
    int i = 0;
    while (i < j)
    {
      arrayOfClass[i] = paramArrayOfObject[i].getClass();
      if (arrayOfClass[i] == Integer.class) {
        arrayOfClass[i] = Integer.TYPE;
      } else if (arrayOfClass[i] == Boolean.class) {
        arrayOfClass[i] = Boolean.TYPE;
      }
      i += 1;
    }
    return localClass.getMethod(paramString, arrayOfClass).invoke(paramObject, paramArrayOfObject);
  }
  
  public static Object a(String paramString)
  {
    try
    {
      int i = Build.VERSION.SDK_INT;
      if (i >= 21) {
        paramString = a("android.content.pm.PackageParser", null);
      } else {
        paramString = a("android.content.pm.PackageParser", new Object[] { paramString });
      }
    }
    catch (Throwable paramString)
    {
      paramString.printStackTrace();
      return null;
    }
    return paramString;
  }
  
  public static Object a(String paramString, Object[] paramArrayOfObject)
  {
    Class localClass = Class.forName(paramString);
    if (paramArrayOfObject == null)
    {
      paramString = null;
    }
    else
    {
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
    return localClass.getConstructor(paramString).newInstance(paramArrayOfObject);
  }
  
  public static String a(String paramString1, String paramString2)
  {
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("getSignatureMd5-apkPath:[");
    ((StringBuilder)localObject1).append(paramString1);
    ((StringBuilder)localObject1).append("]");
    Log.d("--PackageUtil--", ((StringBuilder)localObject1).toString());
    if (Build.VERSION.SDK_INT >= 27) {
      return paramString2;
    }
    localObject1 = "";
    label355:
    label357:
    for (;;)
    {
      try
      {
        Object localObject3 = a(paramString1);
        Object localObject2 = (PackageParser)localObject3;
        DisplayMetrics localDisplayMetrics = new DisplayMetrics();
        localDisplayMetrics.setToDefaults();
        localObject3 = (PackageParser.Package)a(localObject3, new File(paramString1), paramString1, localDisplayMetrics, 0);
        PackageParser.class.getMethod("collectCertificates", new Class[] { localObject3.getClass(), Integer.TYPE }).invoke(localObject2, new Object[] { localObject3, Integer.valueOf(0) });
        paramString1 = (String)localObject1;
        if (Build.VERSION.SDK_INT < 27)
        {
          localObject2 = (Signature[])localObject3.getClass().getDeclaredField("mSignatures").get(localObject3);
          paramString1 = (String)localObject1;
          if (localObject2 != null)
          {
            localObject2 = localObject2[0];
            paramString1 = (String)localObject1;
            if (localObject2 != null)
            {
              paramString1 = new ByteArrayInputStream(((Signature)localObject2).toByteArray());
              paramString1 = a.c(((X509Certificate)CertificateFactory.getInstance("X.509").generateCertificate(paramString1)).getEncoded());
              if (paramString1 == null) {
                break label355;
              }
              paramString1 = paramString1.toUpperCase();
              break label357;
            }
          }
        }
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("SignatureMd5:[");
        ((StringBuilder)localObject1).append(paramString1);
        ((StringBuilder)localObject1).append("]");
        Log.d("--PackageUtil--", ((StringBuilder)localObject1).toString());
        return paramString1;
      }
      catch (Throwable paramString1)
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("e:[");
        ((StringBuilder)localObject1).append(paramString1);
        ((StringBuilder)localObject1).append("]");
        Log.e("--PackageUtil--", ((StringBuilder)localObject1).toString());
        paramString1 = new StringBuilder();
        paramString1.append("SignatureMd5:[");
        paramString1.append(paramString2);
        paramString1.append("]");
        Log.d("--PackageUtil--", paramString1.toString());
        return paramString2;
      }
      paramString1 = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     kcsdkext.b
 * JD-Core Version:    0.7.0.1
 */