package com.tencent.qapmsdk.dns.d;

import android.util.Patterns;
import com.tencent.qapmsdk.common.logger.Logger;
import com.tencent.qapmsdk.dns.a.a;
import java.lang.reflect.Method;
import java.net.InetAddress;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class b
{
  private static Method a;
  private static b.a b = new b.a(null);
  
  public static a.a a()
  {
    return b;
  }
  
  public static void a(a.a parama)
  {
    b.a(parama);
  }
  
  public static boolean a(String paramString)
  {
    try
    {
      if (a == null)
      {
        localObject = InetAddress.class.getDeclaredMethod("isNumeric", new Class[] { String.class });
        ((Method)localObject).setAccessible(true);
        a = (Method)localObject;
      }
      Object localObject = a.invoke(null, new Object[] { paramString });
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
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.qapmsdk.dns.d.b
 * JD-Core Version:    0.7.0.1
 */