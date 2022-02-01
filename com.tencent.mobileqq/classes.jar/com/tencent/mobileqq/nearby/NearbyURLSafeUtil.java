package com.tencent.mobileqq.nearby;

import android.text.TextUtils;
import com.tencent.mobileqq.util.Baze64;
import com.tencent.qphone.base.util.QLog;

public class NearbyURLSafeUtil
{
  public static boolean a(String paramString)
  {
    if (paramString != null) {
      return paramString.startsWith("*S1*");
    }
    throw new NullPointerException("isBase64 src should not be null");
  }
  
  public static String b(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return paramString;
    }
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("*S1*");
    ((StringBuilder)localObject).append(Baze64.b(paramString.getBytes(), 11));
    localObject = ((StringBuilder)localObject).toString();
    if (QLog.isDevelopLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("encode:");
      localStringBuilder.append(paramString);
      localStringBuilder.append(" to:");
      localStringBuilder.append((String)localObject);
      QLog.i("NearbyURLSafeUtil", 4, localStringBuilder.toString());
    }
    return localObject;
  }
  
  public static String c(String paramString)
  {
    if (paramString != null)
    {
      StringBuilder localStringBuilder;
      if (QLog.isDevelopLevel())
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("decode src:");
        localStringBuilder.append(paramString);
        QLog.i("NearbyURLSafeUtil", 4, localStringBuilder.toString());
      }
      if (a(paramString))
      {
        paramString = new String(Baze64.a(paramString.substring(4), 11));
        if (QLog.isDevelopLevel())
        {
          localStringBuilder = new StringBuilder();
          localStringBuilder.append("decode result:");
          localStringBuilder.append(paramString);
          QLog.i("NearbyURLSafeUtil", 4, localStringBuilder.toString());
        }
        return paramString;
      }
      return paramString;
    }
    throw new NullPointerException("decode src should not be null");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.NearbyURLSafeUtil
 * JD-Core Version:    0.7.0.1
 */