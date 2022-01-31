package com.tencent.qapmsdk.dns.logic;

import android.os.SystemClock;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.util.Patterns;
import com.tencent.qapmsdk.common.logger.Logger;
import com.tencent.qapmsdk.dns.HttpDns.Callback;
import com.tencent.qapmsdk.dns.HttpDns.DnsType;
import com.tencent.qapmsdk.dns.policy.IpPolicy;
import com.tencent.qapmsdk.dns.utils.Utils;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.net.InetAddress;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DnsCacheWrapper
  extends LinkedHashMap
{
  private static final String TAG = "QAPM_DNS_DnsCacheWrapper";
  private Constructor<?> constructorAddressCacheEntry;
  private Field fieldAddressCacheEntryExpiryNanos;
  private Field fieldAddressCacheEntryValue;
  private Field fieldAddressCacheKeyHostname;
  private Field fieldAddressHolderHostname;
  private Field fieldAddressHostname;
  private Method methodAddressHolder;
  private long startTime;
  
  public DnsCacheWrapper()
  {
    try
    {
      Object localObject1 = Class.forName("java.net.AddressCache$AddressCacheKey").getDeclaredField("mHostname");
      ((Field)localObject1).setAccessible(true);
      this.fieldAddressCacheKeyHostname = ((Field)localObject1);
      label25:
      localObject1 = Class.forName("java.net.AddressCache$AddressCacheEntry");
      Object localObject3 = ((Class)localObject1).getDeclaredField("value");
      ((Field)localObject3).setAccessible(true);
      this.fieldAddressCacheEntryValue = ((Field)localObject3);
      localObject3 = ((Class)localObject1).getDeclaredField("expiryNanos");
      ((Field)localObject3).setAccessible(true);
      this.fieldAddressCacheEntryExpiryNanos = ((Field)localObject3);
      try
      {
        localObject3 = ((Class)localObject1).getDeclaredConstructor(new Class[] { Object.class });
        ((Constructor)localObject3).setAccessible(true);
        this.constructorAddressCacheEntry = ((Constructor)localObject3);
      }
      catch (Exception localException2)
      {
        for (;;)
        {
          try
          {
            localObject1 = InetAddress.class.getDeclaredField("hostName");
            ((Field)localObject1).setAccessible(true);
            this.fieldAddressHostname = ((Field)localObject1);
            return;
          }
          catch (Exception localException1)
          {
            Object localObject2 = Class.forName("java.net.InetAddress$InetAddressHolder").getDeclaredField("hostName");
            ((Field)localObject2).setAccessible(true);
            this.fieldAddressHolderHostname = ((Field)localObject2);
            localObject2 = InetAddress.class.getDeclaredMethod("holder", new Class[0]);
            ((Method)localObject2).setAccessible(true);
            this.methodAddressHolder = ((Method)localObject2);
            return;
          }
          localException2 = localException2;
          localObject1 = ((Class)localObject1).getDeclaredConstructor(new Class[] { Object.class, Long.TYPE });
          ((Constructor)localObject1).setAccessible(true);
          this.constructorAddressCacheEntry = ((Constructor)localObject1);
        }
      }
    }
    catch (Throwable localThrowable)
    {
      break label25;
    }
  }
  
  /* Error */
  private InetAddress[] getInetAddresses(String paramString, String... paramVarArgs)
  {
    // Byte code:
    //   0: aload_2
    //   1: ifnull +8 -> 9
    //   4: aload_2
    //   5: arraylength
    //   6: ifne +5 -> 11
    //   9: aconst_null
    //   10: areturn
    //   11: new 104	java/util/ArrayList
    //   14: dup
    //   15: invokespecial 105	java/util/ArrayList:<init>	()V
    //   18: astore 5
    //   20: aload_2
    //   21: arraylength
    //   22: istore 4
    //   24: iconst_0
    //   25: istore_3
    //   26: iload_3
    //   27: iload 4
    //   29: if_icmpge +159 -> 188
    //   32: aload_2
    //   33: iload_3
    //   34: aaload
    //   35: astore 6
    //   37: aload 6
    //   39: invokestatic 111	com/tencent/qapmsdk/dns/utils/Utils:isIp	(Ljava/lang/String;)Z
    //   42: ifeq +239 -> 281
    //   45: aload 6
    //   47: invokestatic 115	java/net/InetAddress:getByName	(Ljava/lang/String;)Ljava/net/InetAddress;
    //   50: astore 7
    //   52: aload 7
    //   54: ifnull +106 -> 160
    //   57: aload_0
    //   58: getfield 78	com/tencent/qapmsdk/dns/logic/DnsCacheWrapper:fieldAddressHostname	Ljava/lang/reflect/Field;
    //   61: ifnull +26 -> 87
    //   64: aload_0
    //   65: getfield 78	com/tencent/qapmsdk/dns/logic/DnsCacheWrapper:fieldAddressHostname	Ljava/lang/reflect/Field;
    //   68: aload 7
    //   70: aload_1
    //   71: invokevirtual 119	java/lang/reflect/Field:set	(Ljava/lang/Object;Ljava/lang/Object;)V
    //   74: aload 5
    //   76: aload 7
    //   78: invokeinterface 125 2 0
    //   83: pop
    //   84: goto +197 -> 281
    //   87: aload_0
    //   88: getfield 88	com/tencent/qapmsdk/dns/logic/DnsCacheWrapper:fieldAddressHolderHostname	Ljava/lang/reflect/Field;
    //   91: ifnull -17 -> 74
    //   94: aload_0
    //   95: getfield 99	com/tencent/qapmsdk/dns/logic/DnsCacheWrapper:methodAddressHolder	Ljava/lang/reflect/Method;
    //   98: ifnull -24 -> 74
    //   101: aload_0
    //   102: getfield 88	com/tencent/qapmsdk/dns/logic/DnsCacheWrapper:fieldAddressHolderHostname	Ljava/lang/reflect/Field;
    //   105: aload_0
    //   106: getfield 99	com/tencent/qapmsdk/dns/logic/DnsCacheWrapper:methodAddressHolder	Ljava/lang/reflect/Method;
    //   109: aload 7
    //   111: iconst_0
    //   112: anewarray 63	java/lang/Object
    //   115: invokevirtual 129	java/lang/reflect/Method:invoke	(Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
    //   118: aload_1
    //   119: invokevirtual 119	java/lang/reflect/Field:set	(Ljava/lang/Object;Ljava/lang/Object;)V
    //   122: goto -48 -> 74
    //   125: astore 7
    //   127: getstatic 135	com/tencent/qapmsdk/common/logger/Logger:INSTANCE	Lcom/tencent/qapmsdk/common/logger/Logger;
    //   130: ldc 8
    //   132: new 137	java/lang/StringBuilder
    //   135: dup
    //   136: invokespecial 138	java/lang/StringBuilder:<init>	()V
    //   139: ldc 140
    //   141: invokevirtual 144	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   144: aload 6
    //   146: invokevirtual 144	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   149: invokevirtual 148	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   152: aload 7
    //   154: invokevirtual 152	com/tencent/qapmsdk/common/logger/Logger:exception	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   157: goto +124 -> 281
    //   160: getstatic 135	com/tencent/qapmsdk/common/logger/Logger:INSTANCE	Lcom/tencent/qapmsdk/common/logger/Logger;
    //   163: iconst_3
    //   164: anewarray 154	java/lang/String
    //   167: dup
    //   168: iconst_0
    //   169: ldc 8
    //   171: aastore
    //   172: dup
    //   173: iconst_1
    //   174: ldc 156
    //   176: aastore
    //   177: dup
    //   178: iconst_2
    //   179: aload 6
    //   181: aastore
    //   182: invokevirtual 160	com/tencent/qapmsdk/common/logger/Logger:w	([Ljava/lang/String;)V
    //   185: goto +96 -> 281
    //   188: getstatic 135	com/tencent/qapmsdk/common/logger/Logger:INSTANCE	Lcom/tencent/qapmsdk/common/logger/Logger;
    //   191: bipush 7
    //   193: anewarray 154	java/lang/String
    //   196: dup
    //   197: iconst_0
    //   198: ldc 8
    //   200: aastore
    //   201: dup
    //   202: iconst_1
    //   203: ldc 162
    //   205: aastore
    //   206: dup
    //   207: iconst_2
    //   208: aload_2
    //   209: arraylength
    //   210: invokestatic 166	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   213: aastore
    //   214: dup
    //   215: iconst_3
    //   216: ldc 168
    //   218: aastore
    //   219: dup
    //   220: iconst_4
    //   221: aload_2
    //   222: invokestatic 173	java/util/Arrays:toString	([Ljava/lang/Object;)Ljava/lang/String;
    //   225: aastore
    //   226: dup
    //   227: iconst_5
    //   228: ldc 175
    //   230: aastore
    //   231: dup
    //   232: bipush 6
    //   234: aload 5
    //   236: invokeinterface 179 1 0
    //   241: invokestatic 166	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   244: aastore
    //   245: invokevirtual 182	com/tencent/qapmsdk/common/logger/Logger:d	([Ljava/lang/String;)V
    //   248: aload 5
    //   250: invokeinterface 179 1 0
    //   255: ifne +5 -> 260
    //   258: aconst_null
    //   259: areturn
    //   260: aload 5
    //   262: aload 5
    //   264: invokeinterface 179 1 0
    //   269: anewarray 74	java/net/InetAddress
    //   272: invokeinterface 186 2 0
    //   277: checkcast 188	[Ljava/net/InetAddress;
    //   280: areturn
    //   281: iload_3
    //   282: iconst_1
    //   283: iadd
    //   284: istore_3
    //   285: goto -259 -> 26
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	288	0	this	DnsCacheWrapper
    //   0	288	1	paramString	String
    //   0	288	2	paramVarArgs	String[]
    //   25	260	3	i	int
    //   22	8	4	j	int
    //   18	245	5	localArrayList	ArrayList
    //   35	145	6	str	String
    //   50	60	7	localInetAddress	InetAddress
    //   125	28	7	localException	Exception
    // Exception table:
    //   from	to	target	type
    //   45	52	125	java/lang/Exception
    //   57	74	125	java/lang/Exception
    //   74	84	125	java/lang/Exception
    //   87	122	125	java/lang/Exception
    //   160	185	125	java/lang/Exception
  }
  
  private List<String> getIps(InetAddress[] paramArrayOfInetAddress)
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
  
  @Nullable
  private InetAddress[] getSortedInetAddresses(String paramString, List<String> paramList)
  {
    paramList = IpPolicy.getPolicy().sort(paramString, paramList);
    return getInetAddresses(paramString, (String[])paramList.toArray(new String[paramList.size()]));
  }
  
  private InetAddress[] lookup(String paramString)
  {
    Logger.INSTANCE.i(new String[] { "QAPM_DNS_DnsCacheWrapper", "try to lookup: " + paramString });
    long l = SystemClock.elapsedRealtime();
    Object localObject = LocalDnsManager.getInstance().getIpList(paramString);
    if ((localObject != null) && (((List)localObject).size() > 0))
    {
      localObject = getSortedInetAddresses(paramString, (List)localObject);
      l = SystemClock.elapsedRealtime() - l;
      Utils.getAsyncCallbackWrapper().onResolveDns(HttpDns.DnsType.LOCAL, paramString, (InetAddress[])localObject, l);
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
    localObject = DnsCacheManager.getInstance().getIpList(paramString);
    if ((localObject != null) && (((List)localObject).size() > 0))
    {
      localObject = getSortedInetAddresses(paramString, (List)localObject);
      l = SystemClock.elapsedRealtime() - l;
      Utils.getAsyncCallbackWrapper().onResolveDns(HttpDns.DnsType.CACHE, paramString, (InetAddress[])localObject, l);
      Logger.INSTANCE.d(new String[] { "QAPM_DNS_DnsCacheWrapper", "[cachedns] ", paramString, ", cost: ", String.valueOf(l), "ms" });
      return localObject;
    }
    Logger.INSTANCE.d(new String[] { "QAPM_DNS_DnsCacheWrapper", paramString, " fallback to system dns" });
    return null;
  }
  
  public Object get(Object paramObject)
  {
    try
    {
      if (this.fieldAddressCacheKeyHostname != null) {
        paramObject = this.fieldAddressCacheKeyHostname.get(paramObject);
      }
      for (;;)
      {
        paramObject = lookup((String)paramObject);
        if ((paramObject != null) && (paramObject.length > 0))
        {
          if (this.constructorAddressCacheEntry.getParameterTypes().length == 1) {}
          for (paramObject = this.constructorAddressCacheEntry.newInstance(new Object[] { paramObject });; paramObject = this.constructorAddressCacheEntry.newInstance(new Object[] { paramObject, Long.valueOf(9223372036854775807L) }))
          {
            this.fieldAddressCacheEntryExpiryNanos.set(paramObject, Long.valueOf(9223372036854775807L));
            return paramObject;
          }
        }
      }
    }
    catch (Exception paramObject)
    {
      Logger.INSTANCE.exception("QAPM_DNS_DnsCacheWrapper", "return AddressCacheEntry failed", paramObject);
      this.startTime = SystemClock.elapsedRealtime();
      return null;
    }
  }
  
  public Object put(Object paramObject1, Object paramObject2)
  {
    for (;;)
    {
      try
      {
        if (this.fieldAddressCacheKeyHostname == null) {
          continue;
        }
        paramObject1 = this.fieldAddressCacheKeyHostname.get(paramObject1);
        paramObject1 = (String)paramObject1;
        paramObject2 = this.fieldAddressCacheEntryValue.get(paramObject2);
        if ((paramObject2 instanceof InetAddress[]))
        {
          paramObject2 = (InetAddress[])paramObject2;
          long l = SystemClock.elapsedRealtime() - this.startTime;
          Utils.getAsyncCallbackWrapper().onResolveDns(HttpDns.DnsType.SYSTEM, paramObject1, paramObject2, l);
          Logger.INSTANCE.i(new String[] { "QAPM_DNS_DnsCacheWrapper", "[systemdns] ", paramObject1, ", cost: ", String.valueOf(l), "ms" });
          paramObject2 = getIps(paramObject2);
          if ((paramObject2 != null) && (paramObject2.size() > 0)) {
            DnsCacheManager.getInstance().update(paramObject1, paramObject2, 600L, 2);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.qapmsdk.dns.logic.DnsCacheWrapper
 * JD-Core Version:    0.7.0.1
 */