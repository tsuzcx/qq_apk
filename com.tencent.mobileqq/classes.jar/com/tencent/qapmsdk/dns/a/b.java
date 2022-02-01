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
      Object localObject3 = ((Class)localObject1).getDeclaredField("value");
      ((Field)localObject3).setAccessible(true);
      this.b = ((Field)localObject3);
      localObject3 = ((Class)localObject1).getDeclaredField("expiryNanos");
      ((Field)localObject3).setAccessible(true);
      this.c = ((Field)localObject3);
      try
      {
        localObject3 = ((Class)localObject1).getDeclaredConstructor(new Class[] { Object.class });
        ((Constructor)localObject3).setAccessible(true);
        this.d = ((Constructor)localObject3);
      }
      catch (Exception localException2)
      {
        for (;;)
        {
          try
          {
            localObject1 = InetAddress.class.getDeclaredField("hostName");
            ((Field)localObject1).setAccessible(true);
            this.e = ((Field)localObject1);
            return;
          }
          catch (Exception localException1)
          {
            Object localObject2 = Class.forName("java.net.InetAddress$InetAddressHolder").getDeclaredField("hostName");
            ((Field)localObject2).setAccessible(true);
            this.f = ((Field)localObject2);
            localObject2 = InetAddress.class.getDeclaredMethod("holder", new Class[0]);
            ((Method)localObject2).setAccessible(true);
            this.g = ((Method)localObject2);
            return;
          }
          localException2 = localException2;
          localObject1 = ((Class)localObject1).getDeclaredConstructor(new Class[] { Object.class, Long.TYPE });
          ((Constructor)localObject1).setAccessible(true);
          this.d = ((Constructor)localObject1);
        }
      }
    }
    catch (Throwable localThrowable)
    {
      break label25;
    }
  }
  
  private List<String> a(InetAddress[] paramArrayOfInetAddress)
  {
    if ((paramArrayOfInetAddress == null) || (paramArrayOfInetAddress.length == 0)) {
      localObject = null;
    }
    ArrayList localArrayList;
    int j;
    int i;
    do
    {
      return localObject;
      localArrayList = new ArrayList();
      j = paramArrayOfInetAddress.length;
      i = 0;
      localObject = localArrayList;
    } while (i >= j);
    Object localObject = paramArrayOfInetAddress[i];
    if (localObject == null) {}
    for (;;)
    {
      i += 1;
      break;
      localObject = ((InetAddress)localObject).getHostAddress();
      if (!TextUtils.isEmpty((CharSequence)localObject)) {
        localArrayList.add(localObject);
      }
    }
  }
  
  private InetAddress[] a(String paramString)
  {
    Logger.INSTANCE.i(new String[] { "QAPM_DNS_DnsCacheWrapper", "try to lookup: " + paramString });
    long l = SystemClock.elapsedRealtime();
    Object localObject = c.a().a(paramString);
    if ((localObject != null) && (((List)localObject).size() > 0))
    {
      localObject = a(paramString, (List)localObject);
      l = SystemClock.elapsedRealtime() - l;
      com.tencent.qapmsdk.dns.d.b.a().a(a.b.a, paramString, (InetAddress[])localObject, l);
      Logger.INSTANCE.d(new String[] { "QAPM_DNS_DnsCacheWrapper", "[localdns] ", paramString, ", cost: ", String.valueOf(l), "ms" });
      return localObject;
    }
    localObject = System.getProperty("http.proxyHost");
    String str = System.getProperty("https.proxyHost");
    if ((!TextUtils.isEmpty((CharSequence)localObject)) || (!TextUtils.isEmpty(str)))
    {
      Logger.INSTANCE.d(new String[] { "QAPM_DNS_DnsCacheWrapper", "has system proxy, http: " + (String)localObject + ", https: " + str + ", fallback to system dns" });
      return null;
    }
    if (Patterns.IP_ADDRESS.matcher(paramString).matches())
    {
      Logger.INSTANCE.d(new String[] { "QAPM_DNS_DnsCacheWrapper", "host is ip! host: ", paramString, ", fallback to system dns" });
      return null;
    }
    localObject = a.a().a(paramString);
    if ((localObject != null) && (((List)localObject).size() > 0))
    {
      localObject = a(paramString, (List)localObject);
      l = SystemClock.elapsedRealtime() - l;
      com.tencent.qapmsdk.dns.d.b.a().a(a.b.b, paramString, (InetAddress[])localObject, l);
      Logger.INSTANCE.d(new String[] { "QAPM_DNS_DnsCacheWrapper", "[cachedns] ", paramString, ", cost: ", String.valueOf(l), "ms" });
      return localObject;
    }
    Logger.INSTANCE.d(new String[] { "QAPM_DNS_DnsCacheWrapper", paramString, " fallback to system dns" });
    return null;
  }
  
  @Nullable
  private InetAddress[] a(String paramString, List<String> paramList)
  {
    paramList = com.tencent.qapmsdk.dns.c.a.a().a(paramString, paramList);
    return a(paramString, (String[])paramList.toArray(new String[paramList.size()]));
  }
  
  /* Error */
  private InetAddress[] a(String paramString, String... paramVarArgs)
  {
    // Byte code:
    //   0: aload_2
    //   1: ifnull +8 -> 9
    //   4: aload_2
    //   5: arraylength
    //   6: ifne +5 -> 11
    //   9: aconst_null
    //   10: areturn
    //   11: new 99	java/util/ArrayList
    //   14: dup
    //   15: invokespecial 100	java/util/ArrayList:<init>	()V
    //   18: astore 5
    //   20: aload_2
    //   21: arraylength
    //   22: istore 4
    //   24: iconst_0
    //   25: istore_3
    //   26: iload_3
    //   27: iload 4
    //   29: if_icmpge +161 -> 190
    //   32: aload_2
    //   33: iload_3
    //   34: aaload
    //   35: astore 6
    //   37: aload 6
    //   39: invokestatic 264	com/tencent/qapmsdk/dns/d/b:a	(Ljava/lang/String;)Z
    //   42: ifeq +244 -> 286
    //   45: aload 6
    //   47: invokestatic 268	java/net/InetAddress:getByName	(Ljava/lang/String;)Ljava/net/InetAddress;
    //   50: astore 7
    //   52: aload 7
    //   54: ifnull +107 -> 161
    //   57: aload_0
    //   58: getfield 74	com/tencent/qapmsdk/dns/a/b:e	Ljava/lang/reflect/Field;
    //   61: ifnull +26 -> 87
    //   64: aload_0
    //   65: getfield 74	com/tencent/qapmsdk/dns/a/b:e	Ljava/lang/reflect/Field;
    //   68: aload 7
    //   70: aload_1
    //   71: invokevirtual 272	java/lang/reflect/Field:set	(Ljava/lang/Object;Ljava/lang/Object;)V
    //   74: aload 5
    //   76: aload 7
    //   78: invokeinterface 116 2 0
    //   83: pop
    //   84: goto +202 -> 286
    //   87: aload_0
    //   88: getfield 84	com/tencent/qapmsdk/dns/a/b:f	Ljava/lang/reflect/Field;
    //   91: ifnull -17 -> 74
    //   94: aload_0
    //   95: getfield 95	com/tencent/qapmsdk/dns/a/b:g	Ljava/lang/reflect/Method;
    //   98: ifnull -24 -> 74
    //   101: aload_0
    //   102: getfield 84	com/tencent/qapmsdk/dns/a/b:f	Ljava/lang/reflect/Field;
    //   105: aload_0
    //   106: getfield 95	com/tencent/qapmsdk/dns/a/b:g	Ljava/lang/reflect/Method;
    //   109: aload 7
    //   111: iconst_0
    //   112: anewarray 59	java/lang/Object
    //   115: invokevirtual 276	java/lang/reflect/Method:invoke	(Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
    //   118: aload_1
    //   119: invokevirtual 272	java/lang/reflect/Field:set	(Ljava/lang/Object;Ljava/lang/Object;)V
    //   122: goto -48 -> 74
    //   125: astore 7
    //   127: getstatic 125	com/tencent/qapmsdk/common/logger/Logger:INSTANCE	Lcom/tencent/qapmsdk/common/logger/Logger;
    //   130: ldc 129
    //   132: new 131	java/lang/StringBuilder
    //   135: dup
    //   136: invokespecial 132	java/lang/StringBuilder:<init>	()V
    //   139: ldc_w 278
    //   142: invokevirtual 138	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   145: aload 6
    //   147: invokevirtual 138	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   150: invokevirtual 141	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   153: aload 7
    //   155: invokevirtual 282	com/tencent/qapmsdk/common/logger/Logger:exception	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   158: goto +128 -> 286
    //   161: getstatic 125	com/tencent/qapmsdk/common/logger/Logger:INSTANCE	Lcom/tencent/qapmsdk/common/logger/Logger;
    //   164: iconst_3
    //   165: anewarray 127	java/lang/String
    //   168: dup
    //   169: iconst_0
    //   170: ldc 129
    //   172: aastore
    //   173: dup
    //   174: iconst_1
    //   175: ldc_w 284
    //   178: aastore
    //   179: dup
    //   180: iconst_2
    //   181: aload 6
    //   183: aastore
    //   184: invokevirtual 287	com/tencent/qapmsdk/common/logger/Logger:w	([Ljava/lang/String;)V
    //   187: goto +99 -> 286
    //   190: getstatic 125	com/tencent/qapmsdk/common/logger/Logger:INSTANCE	Lcom/tencent/qapmsdk/common/logger/Logger;
    //   193: bipush 7
    //   195: anewarray 127	java/lang/String
    //   198: dup
    //   199: iconst_0
    //   200: ldc 129
    //   202: aastore
    //   203: dup
    //   204: iconst_1
    //   205: ldc_w 289
    //   208: aastore
    //   209: dup
    //   210: iconst_2
    //   211: aload_2
    //   212: arraylength
    //   213: invokestatic 292	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   216: aastore
    //   217: dup
    //   218: iconst_3
    //   219: ldc_w 294
    //   222: aastore
    //   223: dup
    //   224: iconst_4
    //   225: aload_2
    //   226: invokestatic 299	java/util/Arrays:toString	([Ljava/lang/Object;)Ljava/lang/String;
    //   229: aastore
    //   230: dup
    //   231: iconst_5
    //   232: ldc_w 301
    //   235: aastore
    //   236: dup
    //   237: bipush 6
    //   239: aload 5
    //   241: invokeinterface 163 1 0
    //   246: invokestatic 292	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   249: aastore
    //   250: invokevirtual 193	com/tencent/qapmsdk/common/logger/Logger:d	([Ljava/lang/String;)V
    //   253: aload 5
    //   255: invokeinterface 163 1 0
    //   260: ifne +5 -> 265
    //   263: aconst_null
    //   264: areturn
    //   265: aload 5
    //   267: aload 5
    //   269: invokeinterface 163 1 0
    //   274: anewarray 70	java/net/InetAddress
    //   277: invokeinterface 254 2 0
    //   282: checkcast 303	[Ljava/net/InetAddress;
    //   285: areturn
    //   286: iload_3
    //   287: iconst_1
    //   288: iadd
    //   289: istore_3
    //   290: goto -264 -> 26
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	293	0	this	b
    //   0	293	1	paramString	String
    //   0	293	2	paramVarArgs	String[]
    //   25	265	3	i	int
    //   22	8	4	j	int
    //   18	250	5	localArrayList	ArrayList
    //   35	147	6	str	String
    //   50	60	7	localInetAddress	InetAddress
    //   125	29	7	localException	Exception
    // Exception table:
    //   from	to	target	type
    //   45	52	125	java/lang/Exception
    //   57	74	125	java/lang/Exception
    //   74	84	125	java/lang/Exception
    //   87	122	125	java/lang/Exception
    //   161	187	125	java/lang/Exception
  }
  
  public Object get(Object paramObject)
  {
    try
    {
      if (this.a != null) {
        paramObject = this.a.get(paramObject);
      }
      for (;;)
      {
        paramObject = a((String)paramObject);
        if ((paramObject != null) && (paramObject.length > 0))
        {
          if (this.d.getParameterTypes().length == 1) {}
          for (paramObject = this.d.newInstance(new Object[] { paramObject });; paramObject = this.d.newInstance(new Object[] { paramObject, Long.valueOf(9223372036854775807L) }))
          {
            this.c.set(paramObject, Long.valueOf(9223372036854775807L));
            return paramObject;
          }
        }
      }
    }
    catch (Exception paramObject)
    {
      Logger.INSTANCE.exception("QAPM_DNS_DnsCacheWrapper", "return AddressCacheEntry failed", paramObject);
      this.h = SystemClock.elapsedRealtime();
      return null;
    }
  }
  
  public Object put(Object paramObject1, Object paramObject2)
  {
    for (;;)
    {
      try
      {
        if (this.a == null) {
          continue;
        }
        paramObject1 = this.a.get(paramObject1);
        paramObject1 = (String)paramObject1;
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
        continue;
      }
      return null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.qapmsdk.dns.a.b
 * JD-Core Version:    0.7.0.1
 */