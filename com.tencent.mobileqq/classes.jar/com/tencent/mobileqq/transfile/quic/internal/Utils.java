package com.tencent.mobileqq.transfile.quic.internal;

import android.os.Build.VERSION;
import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;
import java.lang.reflect.Method;

public class Utils
{
  public static final String TAG = "quic";
  
  public static boolean checkIfCPUx86()
  {
    if (Build.VERSION.SDK_INT > 27) {}
    String str;
    do
    {
      return false;
      str = getSystemProperty("ro.product.cpu.abi", "arm");
    } while (TextUtils.isEmpty(str));
    return str.contains("x86");
  }
  
  private static String getSystemProperty(String paramString1, String paramString2)
  {
    try
    {
      Class localClass = Class.forName("android.os.SystemProperties");
      paramString1 = (String)localClass.getMethod("get", new Class[] { String.class, String.class }).invoke(localClass, new Object[] { paramString1, "" });
      return paramString1;
    }
    catch (Exception paramString1)
    {
      QLog.e("quic", 4, paramString1, new Object[0]);
    }
    return paramString2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.transfile.quic.internal.Utils
 * JD-Core Version:    0.7.0.1
 */