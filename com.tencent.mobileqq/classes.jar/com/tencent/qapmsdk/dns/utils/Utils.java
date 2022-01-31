package com.tencent.qapmsdk.dns.utils;

import android.util.Patterns;
import com.tencent.qapmsdk.common.logger.Logger;
import com.tencent.qapmsdk.dns.HttpDns.Callback;
import java.lang.reflect.Method;
import java.net.InetAddress;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Utils
{
  private static final String TAG = "QAPM_DNS_Utils";
  private static Utils.AsyncCallbackWrapper sAsyncCallbackWrapper = new Utils.AsyncCallbackWrapper(null);
  private static Method sMethod_InetAddress_isNumeric;
  
  public static String dumpInetAddresses(InetAddress... paramVarArgs)
  {
    if ((paramVarArgs == null) || (paramVarArgs.length == 0)) {
      return null;
    }
    StringBuilder localStringBuilder = new StringBuilder(paramVarArgs.length * 17 + 2);
    localStringBuilder.append("[");
    int i = 0;
    if (i < paramVarArgs.length)
    {
      if (i != 0) {
        localStringBuilder.append(", ");
      }
      if (paramVarArgs[i] != null) {}
      for (String str = paramVarArgs[i].getHostAddress();; str = null)
      {
        localStringBuilder.append(str);
        i += 1;
        break;
      }
    }
    localStringBuilder.append("]");
    return localStringBuilder.toString();
  }
  
  public static HttpDns.Callback getAsyncCallbackWrapper()
  {
    return sAsyncCallbackWrapper;
  }
  
  public static boolean isIp(String paramString)
  {
    try
    {
      if (sMethod_InetAddress_isNumeric == null)
      {
        localObject = InetAddress.class.getDeclaredMethod("isNumeric", new Class[] { String.class });
        ((Method)localObject).setAccessible(true);
        sMethod_InetAddress_isNumeric = (Method)localObject;
      }
      Object localObject = sMethod_InetAddress_isNumeric.invoke(null, new Object[] { paramString });
      if (localObject != null)
      {
        boolean bool = ((Boolean)localObject).booleanValue();
        return bool;
      }
    }
    catch (Exception localException)
    {
      Logger.INSTANCE.exception("QAPM_DNS_Utils", "invoke isNumeric failed", localException);
    }
    return Patterns.IP_ADDRESS.matcher(paramString).matches();
  }
  
  public static void setCallback(HttpDns.Callback paramCallback)
  {
    sAsyncCallbackWrapper.setCallback(paramCallback);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.qapmsdk.dns.utils.Utils
 * JD-Core Version:    0.7.0.1
 */