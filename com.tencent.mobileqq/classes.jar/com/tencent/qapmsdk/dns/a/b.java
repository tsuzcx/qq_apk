package com.tencent.qapmsdk.dns.a;

import android.os.SystemClock;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.util.Patterns;
import com.tencent.qapmsdk.common.logger.Logger;
import com.tencent.qapmsdk.dns.a.a;
import com.tencent.qapmsdk.dns.a.b;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.net.InetAddress;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class b
  extends LinkedHashMap
{
  private Field a;
  private Field b;
  private Field c;
  private Constructor<?> d;
  private Field e;
  private Field f;
  private Method g;
  private long h;
  
  public b()
  {
    try
    {
      Object localObject1 = Class.forName("java.net.AddressCache$AddressCacheKey").getDeclaredField("mHostname");
      ((Field)localObject1).setAccessible(true);
      this.a = ((Field)localObject1);
      label25:
      localObject1 = Class.forName("java.net.AddressCache$AddressCacheEntry");
      Object localObject2 = ((Class)localObject1).getDeclaredField("value");
      ((Field)localObject2).setAccessible(true);
      this.b = ((Field)localObject2);
      localObject2 = ((Class)localObject1).getDeclaredField("expiryNanos");
      ((Field)localObject2).setAccessible(true);
      this.c = ((Field)localObject2);
      label141:
      try
      {
        localObject2 = ((Class)localObject1).getDeclaredConstructor(new Class[] { Object.class });
        ((Constructor)localObject2).setAccessible(true);
        this.d = ((Constructor)localObject2);
      }
      catch (Exception localException2)
      {
        label92:
        break label92;
      }
      localObject1 = ((Class)localObject1).getDeclaredConstructor(new Class[] { Object.class, Long.TYPE });
      ((Constructor)localObject1).setAccessible(true);
      this.d = ((Constructor)localObject1);
      try
      {
        localObject1 = InetAddress.class.getDeclaredField("hostName");
        ((Field)localObject1).setAccessible(true);
        this.e = ((Field)localObject1);
        return;
      }
      catch (Exception localException1)
      {
        break label141;
      }
      localObject1 = Class.forName("java.net.InetAddress$InetAddressHolder").getDeclaredField("hostName");
      ((Field)localObject1).setAccessible(true);
      this.f = ((Field)localObject1);
      localObject1 = InetAddress.class.getDeclaredMethod("holder", new Class[0]);
      ((Method)localObject1).setAccessible(true);
      this.g = ((Method)localObject1);
      return;
    }
    catch (Throwable localThrowable)
    {
      break label25;
    }
  }
  
  private List<String> a(InetAddress[] paramArrayOfInetAddress)
  {
    if ((paramArrayOfInetAddress != null) && (paramArrayOfInetAddress.length != 0))
    {
      ArrayList localArrayList = new ArrayList();
      int j = paramArrayOfInetAddress.length;
      int i = 0;
      while (i < j)
      {
        Object localObject = paramArrayOfInetAddress[i];
        if (localObject != null)
        {
          localObject = ((InetAddress)localObject).getHostAddress();
          if (!TextUtils.isEmpty((CharSequence)localObject)) {
            localArrayList.add(localObject);
          }
        }
        i += 1;
      }
      return localArrayList;
    }
    return null;
  }
  
  private InetAddress[] a(String paramString)
  {
    Object localObject1 = Logger.INSTANCE;
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("try to lookup: ");
    ((StringBuilder)localObject2).append(paramString);
    ((Logger)localObject1).i(new String[] { "QAPM_DNS_DnsCacheWrapper", ((StringBuilder)localObject2).toString() });
    long l = SystemClock.elapsedRealtime();
    localObject1 = c.a().a(paramString);
    if ((localObject1 != null) && (((List)localObject1).size() > 0))
    {
      localObject1 = a(paramString, (List)localObject1);
      l = SystemClock.elapsedRealtime() - l;
      com.tencent.qapmsdk.dns.d.b.a().a(a.b.a, paramString, (InetAddress[])localObject1, l);
      Logger.INSTANCE.d(new String[] { "QAPM_DNS_DnsCacheWrapper", "[localdns] ", paramString, ", cost: ", String.valueOf(l), "ms" });
      return localObject1;
    }
    localObject1 = System.getProperty("http.proxyHost");
    localObject2 = System.getProperty("https.proxyHost");
    if ((TextUtils.isEmpty((CharSequence)localObject1)) && (TextUtils.isEmpty((CharSequence)localObject2)))
    {
      if (Patterns.IP_ADDRESS.matcher(paramString).matches())
      {
        Logger.INSTANCE.d(new String[] { "QAPM_DNS_DnsCacheWrapper", "host is ip! host: ", paramString, ", fallback to system dns" });
        return null;
      }
      localObject1 = a.a().a(paramString);
      if ((localObject1 != null) && (((List)localObject1).size() > 0))
      {
        localObject1 = a(paramString, (List)localObject1);
        l = SystemClock.elapsedRealtime() - l;
        com.tencent.qapmsdk.dns.d.b.a().a(a.b.b, paramString, (InetAddress[])localObject1, l);
        Logger.INSTANCE.d(new String[] { "QAPM_DNS_DnsCacheWrapper", "[cachedns] ", paramString, ", cost: ", String.valueOf(l), "ms" });
        return localObject1;
      }
      Logger.INSTANCE.d(new String[] { "QAPM_DNS_DnsCacheWrapper", paramString, " fallback to system dns" });
      return null;
    }
    paramString = Logger.INSTANCE;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("has system proxy, http: ");
    localStringBuilder.append((String)localObject1);
    localStringBuilder.append(", https: ");
    localStringBuilder.append((String)localObject2);
    localStringBuilder.append(", fallback to system dns");
    paramString.d(new String[] { "QAPM_DNS_DnsCacheWrapper", localStringBuilder.toString() });
    return null;
  }
  
  @Nullable
  private InetAddress[] a(String paramString, List<String> paramList)
  {
    paramList = com.tencent.qapmsdk.dns.c.a.a().a(paramString, paramList);
    return a(paramString, (String[])paramList.toArray(new String[paramList.size()]));
  }
  
  private InetAddress[] a(String paramString, String... paramVarArgs)
  {
    Object localObject = null;
    if (paramVarArgs != null)
    {
      if (paramVarArgs.length == 0) {
        return null;
      }
      localObject = new ArrayList();
      int j = paramVarArgs.length;
      int i = 0;
      while (i < j)
      {
        String str = paramVarArgs[i];
        if (com.tencent.qapmsdk.dns.d.b.a(str)) {
          try
          {
            InetAddress localInetAddress = InetAddress.getByName(str);
            if (localInetAddress != null)
            {
              if (this.e != null) {
                this.e.set(localInetAddress, paramString);
              } else if ((this.f != null) && (this.g != null)) {
                this.f.set(this.g.invoke(localInetAddress, new Object[0]), paramString);
              }
              ((List)localObject).add(localInetAddress);
            }
            else
            {
              Logger.INSTANCE.w(new String[] { "QAPM_DNS_DnsCacheWrapper", "getByName null, ip: ", str });
            }
          }
          catch (Exception localException)
          {
            Logger localLogger = Logger.INSTANCE;
            StringBuilder localStringBuilder = new StringBuilder();
            localStringBuilder.append("getByName failed, ip: ");
            localStringBuilder.append(str);
            localLogger.exception("QAPM_DNS_DnsCacheWrapper", localStringBuilder.toString(), localException);
          }
        }
        i += 1;
      }
      Logger.INSTANCE.d(new String[] { "QAPM_DNS_DnsCacheWrapper", "getInetAddresses, ipSize: ", String.valueOf(paramVarArgs.length), ", ips: ", Arrays.toString(paramVarArgs), ", InetAddressSize: ", String.valueOf(((List)localObject).size()) });
      if (((List)localObject).size() == 0) {
        return null;
      }
      localObject = (InetAddress[])((List)localObject).toArray(new InetAddress[((List)localObject).size()]);
    }
    return localObject;
  }
  
  public Object get(Object paramObject)
  {
    Object localObject = paramObject;
    try
    {
      if (this.a != null) {
        localObject = this.a.get(paramObject);
      }
      paramObject = a((String)localObject);
      if ((paramObject != null) && (paramObject.length > 0))
      {
        if (this.d.getParameterTypes().length == 1) {
          paramObject = this.d.newInstance(new Object[] { paramObject });
        } else {
          paramObject = this.d.newInstance(new Object[] { paramObject, Long.valueOf(9223372036854775807L) });
        }
        this.c.set(paramObject, Long.valueOf(9223372036854775807L));
        return paramObject;
      }
    }
    catch (Exception paramObject)
    {
      Logger.INSTANCE.exception("QAPM_DNS_DnsCacheWrapper", "return AddressCacheEntry failed", paramObject);
      this.h = SystemClock.elapsedRealtime();
    }
    return null;
  }
  
  public Object put(Object paramObject1, Object paramObject2)
  {
    Object localObject = paramObject1;
    try
    {
      if (this.a != null) {
        localObject = this.a.get(paramObject1);
      }
      paramObject1 = (String)localObject;
      paramObject2 = this.b.get(paramObject2);
      if ((paramObject2 instanceof InetAddress[]))
      {
        paramObject2 = (InetAddress[])paramObject2;
        long l = SystemClock.elapsedRealtime() - this.h;
        com.tencent.qapmsdk.dns.d.b.a().a(a.b.c, paramObject1, paramObject2, l);
        Logger.INSTANCE.i(new String[] { "QAPM_DNS_DnsCacheWrapper", "[systemdns] ", paramObject1, ", cost: ", String.valueOf(l), "ms" });
        paramObject2 = a(paramObject2);
        if ((paramObject2 != null) && (paramObject2.size() > 0)) {
          a.a().a(paramObject1, paramObject2, 600L, 2);
        }
      }
    }
    catch (Exception paramObject1)
    {
      Logger.INSTANCE.exception("QAPM_DNS_DnsCacheWrapper", "update system dns cache failed", paramObject1);
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.qapmsdk.dns.a.b
 * JD-Core Version:    0.7.0.1
 */