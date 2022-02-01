package com.tencent.oskplayer.util;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.net.Uri.Builder;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.util.Log;
import android.webkit.URLUtil;
import com.tencent.oskplayer.PlayerConfig;
import com.tencent.oskplayer.proxy.DefaultVideoKeyGenerator;
import com.tencent.oskplayer.proxy.VideoKeyGenerator;
import com.tencent.oskplayer.proxy.VideoManager;
import com.tencent.oskplayer.service.DNSService;
import com.tencent.oskplayer.support.util.OskDebug;
import com.tencent.oskplayer.support.util.OskFile;
import java.io.File;
import java.lang.reflect.Method;
import java.net.InetAddress;
import java.net.MalformedURLException;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.net.URL;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Formatter;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PlayerUtils
{
  public static final int DnsServiceModePrependIp = 1;
  public static final int DnsServiceModeReplaceDomain = 0;
  private static volatile int H265_REPORT_KEY_VERSION = 0;
  private static final Pattern IPV4_ADDR_PATTERN;
  private static final Object LOCK_0;
  public static final int LOG_TEXT_MAX_LENGTH = 1000;
  static final int PROXY_SUB_ERROR_CODE_BASE = -20000;
  static final int SUB_ERROR_CODE_NOT_PARSED = -1;
  private static final String TAG = "PlayerUtils";
  private static String h265MobileDetailInfoKey;
  private static final char[] hexArray = "0123456789ABCDEF".toCharArray();
  private static String htmlMagic = "<html";
  private static String mobile_detail_info;
  public static HashMap<String, Boolean> sIsHLSStreamCacheMap = new HashMap();
  private static final AtomicInteger sNextGeneratedId;
  public static HashMap<String, String> sVideoKeyCacheMap;
  
  static
  {
    IPV4_ADDR_PATTERN = Pattern.compile("^(([01]?\\d\\d?|2[0-4]\\d|25[0-5])\\.){3}([01]?\\d\\d?|2[0-4]\\d|25[0-5])$");
    sVideoKeyCacheMap = new HashMap();
    mobile_detail_info = null;
    LOCK_0 = new Object();
    H265_REPORT_KEY_VERSION = 1;
    h265MobileDetailInfoKey = null;
    sNextGeneratedId = new AtomicInteger(1);
  }
  
  public static String bytesToHex(byte[] paramArrayOfByte, int paramInt)
  {
    Object localObject1 = "";
    int i = Math.min(paramInt, paramArrayOfByte.length);
    char[] arrayOfChar = new char[i * 2];
    paramInt = 0;
    while (paramInt < i)
    {
      localObject2 = localObject1;
      if (paramInt % 16 == 0)
      {
        localObject2 = localObject1;
        if (paramInt != 0) {
          localObject2 = (String)localObject1 + "\n";
        }
      }
      localObject1 = localObject2;
      if (paramInt % 16 == 0) {
        localObject1 = (String)localObject2 + String.format("%2s:", new Object[] { Integer.toHexString(paramInt) });
      }
      localObject2 = localObject1;
      if (paramInt % 2 == 0) {
        localObject2 = (String)localObject1 + " ";
      }
      int j = paramArrayOfByte[paramInt] & 0xFF;
      arrayOfChar[(paramInt * 2)] = hexArray[(j >>> 4)];
      localObject1 = (String)localObject2 + arrayOfChar[(paramInt * 2)];
      arrayOfChar[(paramInt * 2 + 1)] = hexArray[(j & 0xF)];
      localObject1 = (String)localObject1 + arrayOfChar[(paramInt * 2 + 1)];
      paramInt += 1;
    }
    Object localObject2 = localObject1;
    if (paramArrayOfByte.length > i) {
      localObject2 = (String)localObject1 + " ....";
    }
    return localObject2;
  }
  
  private static int count(String paramString, char paramChar)
  {
    int i = 0;
    int k = 0;
    if (paramString == null) {
      return k;
    }
    int m = paramString.length();
    int j = 0;
    for (;;)
    {
      k = i;
      if (j >= m) {
        break;
      }
      k = i;
      if (paramChar == paramString.charAt(j)) {
        k = i + 1;
      }
      j += 1;
      i = k;
    }
  }
  
  private static String doGetMobileDetailInfo()
  {
    if (h265MobileDetailInfoKey == null)
    {
      String str = "" + Build.MODEL;
      str = str + "&";
      str = str + Build.VERSION.RELEASE;
      str = str + "&";
      str = str + Build.VERSION.SDK_INT;
      str = str + "&";
      str = str + getNumberOfCores();
      str = str + "&";
      h265MobileDetailInfoKey = str + H265_REPORT_KEY_VERSION;
    }
    return h265MobileDetailInfoKey;
  }
  
  /* Error */
  public static int findFreePort()
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_2
    //   2: new 167	java/net/ServerSocket
    //   5: dup
    //   6: iconst_0
    //   7: invokespecial 168	java/net/ServerSocket:<init>	(I)V
    //   10: astore_1
    //   11: aload_1
    //   12: iconst_1
    //   13: invokevirtual 172	java/net/ServerSocket:setReuseAddress	(Z)V
    //   16: aload_1
    //   17: invokevirtual 175	java/net/ServerSocket:getLocalPort	()I
    //   20: istore_0
    //   21: aload_1
    //   22: invokevirtual 178	java/net/ServerSocket:close	()V
    //   25: aload_1
    //   26: ifnull +7 -> 33
    //   29: aload_1
    //   30: invokevirtual 178	java/net/ServerSocket:close	()V
    //   33: iload_0
    //   34: ireturn
    //   35: astore_1
    //   36: aconst_null
    //   37: astore_1
    //   38: aload_1
    //   39: ifnull +7 -> 46
    //   42: aload_1
    //   43: invokevirtual 178	java/net/ServerSocket:close	()V
    //   46: new 180	java/lang/IllegalStateException
    //   49: dup
    //   50: ldc 182
    //   52: invokespecial 185	java/lang/IllegalStateException:<init>	(Ljava/lang/String;)V
    //   55: athrow
    //   56: astore_1
    //   57: aload_2
    //   58: ifnull +7 -> 65
    //   61: aload_2
    //   62: invokevirtual 178	java/net/ServerSocket:close	()V
    //   65: aload_1
    //   66: athrow
    //   67: astore_2
    //   68: goto -43 -> 25
    //   71: astore_1
    //   72: iload_0
    //   73: ireturn
    //   74: astore_1
    //   75: goto -29 -> 46
    //   78: astore_2
    //   79: goto -14 -> 65
    //   82: astore_3
    //   83: aload_1
    //   84: astore_2
    //   85: aload_3
    //   86: astore_1
    //   87: goto -30 -> 57
    //   90: astore_2
    //   91: goto -53 -> 38
    // Local variable table:
    //   start	length	slot	name	signature
    //   20	53	0	i	int
    //   10	20	1	localServerSocket	java.net.ServerSocket
    //   35	1	1	localIOException1	java.io.IOException
    //   37	6	1	localObject1	Object
    //   56	10	1	localObject2	Object
    //   71	1	1	localIOException2	java.io.IOException
    //   74	10	1	localIOException3	java.io.IOException
    //   86	1	1	localObject3	Object
    //   1	61	2	localObject4	Object
    //   67	1	2	localIOException4	java.io.IOException
    //   78	1	2	localIOException5	java.io.IOException
    //   84	1	2	localObject5	Object
    //   90	1	2	localIOException6	java.io.IOException
    //   82	4	3	localObject6	Object
    // Exception table:
    //   from	to	target	type
    //   2	11	35	java/io/IOException
    //   2	11	56	finally
    //   21	25	67	java/io/IOException
    //   29	33	71	java/io/IOException
    //   42	46	74	java/io/IOException
    //   61	65	78	java/io/IOException
    //   11	21	82	finally
    //   21	25	82	finally
    //   11	21	90	java/io/IOException
  }
  
  public static int findFreePort(int paramInt)
  {
    try
    {
      i = findFreePort();
      return i;
    }
    catch (IllegalStateException localIllegalStateException1)
    {
      int i = 0;
      while (i < paramInt) {
        try
        {
          int j = findFreePort();
          return j;
        }
        catch (IllegalStateException localIllegalStateException2)
        {
          log(5, "PlayerUtils", "retry findFreePort i=" + i);
          i += 1;
        }
      }
      throw new IllegalStateException("Could not find a free TCP/IP port to start video proxy, maxRetry=" + paramInt);
    }
  }
  
  public static String formatVideoTime(long paramLong)
  {
    long l2 = Math.round(paramLong * 1.0D / 1000.0D);
    paramLong = l2 % 60L;
    long l1 = l2 / 60L % 60L;
    l2 /= 3600L;
    StringBuilder localStringBuilder = new StringBuilder();
    Formatter localFormatter = new Formatter(localStringBuilder, Locale.getDefault());
    localStringBuilder.setLength(0);
    if (l2 > 0L) {
      return localFormatter.format("%d:%02d:%02d", new Object[] { Long.valueOf(l2), Long.valueOf(l1), Long.valueOf(paramLong) }).toString();
    }
    return localFormatter.format("%02d:%02d", new Object[] { Long.valueOf(l1), Long.valueOf(paramLong) }).toString();
  }
  
  public static int generateViewId()
  {
    int k;
    int i;
    do
    {
      k = sNextGeneratedId.get();
      int j = k + 1;
      i = j;
      if (j > 16777215) {
        i = 1;
      }
    } while (!sNextGeneratedId.compareAndSet(k, i));
    return k;
  }
  
  public static String getAbsoluteUrl(String paramString1, String paramString2)
  {
    Object localObject;
    if ((TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString2))) {
      localObject = paramString1;
    }
    do
    {
      return localObject;
      localObject = paramString2;
    } while (paramString2.startsWith("http"));
    try
    {
      localObject = new URL(new URL(paramString1), paramString2);
      if (localObject != null) {
        return ((URL)localObject).toString();
      }
    }
    catch (MalformedURLException localMalformedURLException)
    {
      return getAbsoluteUrl2(paramString1, paramString2);
    }
    return null;
  }
  
  private static String getAbsoluteUrl2(String paramString1, String paramString2)
  {
    String str = paramString1;
    if (paramString1.endsWith("/")) {
      str = paramString1.substring(0, paramString1.length() - 1);
    }
    int i = str.lastIndexOf('/');
    paramString1 = str;
    if (i > 0) {
      paramString1 = str.substring(0, i);
    }
    return paramString1 + paramString2;
  }
  
  public static String getConnectionTypeStr(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return "TYPE_UNKNOWN";
    case 0: 
      return "TYPE_MOBILE";
    }
    return "TYPE_WIFI";
  }
  
  public static long getDownloadResponseCode(long paramLong1, long paramLong2)
  {
    int i = -2;
    String[] arrayOfString = getUserProxy();
    if (arrayOfString != null)
    {
      i = -3;
      log(4, "PlayerUtils", "proxy setting " + join(Arrays.asList(arrayOfString).iterator(), "|"));
    }
    return (paramLong1 - paramLong2 - i * 100000000) / 100000L;
  }
  
  public static long getDownloadRetCode(long paramLong1, long paramLong2)
  {
    int i = -2;
    String[] arrayOfString = getUserProxy();
    if (arrayOfString != null)
    {
      i = -3;
      log(4, "PlayerUtils", "proxy setting " + join(Arrays.asList(arrayOfString).iterator(), "|"));
    }
    return i * 100000000 + 100000L * paramLong1 + paramLong2;
  }
  
  public static int getH265ReportedKeyVersion()
  {
    return H265_REPORT_KEY_VERSION;
  }
  
  public static String getMobileDetailInfo()
  {
    synchronized (LOCK_0)
    {
      if (mobile_detail_info == null) {
        mobile_detail_info = doGetMobileDetailInfo();
      }
      String str = mobile_detail_info;
      return str;
    }
  }
  
  private static int getNumCoresOldPhones()
  {
    try
    {
      int i = new File("/sys/devices/system/cpu/").listFiles(new PlayerUtils.1CpuFilter()).length;
      return i;
    }
    catch (Exception localException) {}
    return 1;
  }
  
  private static int getNumberOfCores()
  {
    if (Build.VERSION.SDK_INT >= 17) {
      return Runtime.getRuntime().availableProcessors();
    }
    return getNumCoresOldPhones();
  }
  
  public static long getPlayVideoRetCode(int paramInt, long paramLong, String paramString)
  {
    long l2 = 0L;
    long l1 = l2;
    if (!TextUtils.isEmpty(paramString))
    {
      l1 = l2;
      if (paramString.equals("liveVideo")) {
        l1 = -10000000000L;
      }
    }
    return l1 - 200000000L + 100000 * paramInt + paramLong;
  }
  
  public static String getPrintableStackTrace(Throwable paramThrowable)
  {
    return OskDebug.getPrintableStackTrace(paramThrowable);
  }
  
  public static String getStackTrace()
  {
    return OskDebug.getStackTrace();
  }
  
  public static long getSubErrorCode(Map<String, List<String>> paramMap)
  {
    if (paramMap != null)
    {
      long l1 = parseErrorList((List)paramMap.get("x-server-error"));
      if ((l1 != -1L) && (l1 != 0L)) {}
      long l2;
      do
      {
        return l1;
        l1 = parseErrorList((List)paramMap.get("x-proxy-error"));
        if (l1 != -1L) {
          return l1 - 20000L;
        }
        l2 = parseErrorList((List)paramMap.get("error"));
        l1 = l2;
      } while (l2 != -1L);
    }
    return -99999L;
  }
  
  public static String getUrlFileName(String paramString)
  {
    if (!TextUtils.isEmpty(paramString)) {
      return Uri.parse(paramString).getLastPathSegment();
    }
    return null;
  }
  
  public static String[] getUserProxy()
  {
    try
    {
      Object localObject = ConnectivityManager.class.getMethod("getProxy", new Class[0]);
      try
      {
        localObject = ((Method)localObject).invoke((ConnectivityManager)PlayerConfig.g().getAppContext().getSystemService("connectivity"), new Object[0]);
        if (localObject == null) {
          return null;
        }
        localObject = getUserProxy(localObject);
        return localObject;
      }
      catch (Exception localException1)
      {
        return null;
      }
      return null;
    }
    catch (NoSuchMethodException localNoSuchMethodException)
    {
      return null;
    }
    catch (Exception localException2) {}
  }
  
  private static String[] getUserProxy(Object paramObject)
  {
    String[] arrayOfString = new String[3];
    Class localClass = Class.forName("android.net.ProxyProperties");
    arrayOfString[0] = ((String)localClass.getMethod("getHost", new Class[0]).invoke(paramObject, new Object[0]));
    arrayOfString[1] = String.valueOf((Integer)localClass.getMethod("getPort", new Class[0]).invoke(paramObject, new Object[0]));
    arrayOfString[2] = ((String)localClass.getMethod("getExclusionList", new Class[0]).invoke(paramObject, new Object[0]));
    if (arrayOfString[0] != null) {
      return arrayOfString;
    }
    return null;
  }
  
  public static String getVideoUuidFromVideoUrl(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    if (isLocalFile(paramString)) {
      return "local";
    }
    if (isNoProxyUrl(paramString)) {
      return "noproxy";
    }
    Map localMap = HttpParser.parseParams(paramString);
    if ((localMap == null) || (localMap.isEmpty()))
    {
      log(6, "PlayerUtils", "getVideoUuidFromVideoUrl fail " + paramString);
      return null;
    }
    return (String)localMap.get("uuid");
  }
  
  public static String guessExtension(String paramString)
  {
    String str = OskFile.getFileExtension(getUrlFileName(paramString));
    paramString = str;
    if (TextUtils.isEmpty(str)) {
      paramString = "unknown";
    }
    return paramString;
  }
  
  public static boolean isAssetsUri(String paramString)
  {
    return (!TextUtils.isEmpty(paramString)) && (paramString.startsWith("file:///android_asset"));
  }
  
  public static boolean isContentHtml(byte[] paramArrayOfByte)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (paramArrayOfByte != null)
    {
      bool1 = bool2;
      if (paramArrayOfByte.length > 100)
      {
        byte[] arrayOfByte = new byte[100];
        System.arraycopy(paramArrayOfByte, 0, arrayOfByte, 0, 100);
        bool1 = new String(arrayOfByte).toLowerCase().replaceAll("\\s", "").contains(htmlMagic);
      }
    }
    return bool1;
  }
  
  public static boolean isHLSStream(String paramString)
  {
    bool2 = false;
    if (TextUtils.isEmpty(paramString)) {
      return false;
    }
    if (sIsHLSStreamCacheMap.containsKey(paramString)) {
      return ((Boolean)sIsHLSStreamCacheMap.get(paramString)).booleanValue();
    }
    try
    {
      String str = new URL(paramString).getPath();
      bool1 = bool2;
      if (!TextUtils.isEmpty(str))
      {
        boolean bool3 = str.toLowerCase().endsWith(".m3u8");
        bool1 = bool2;
        if (bool3) {
          bool1 = true;
        }
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        log(5, "PlayerUtils", "isHLSStream illegal url " + paramString);
        boolean bool1 = bool2;
      }
    }
    sIsHLSStreamCacheMap.put(paramString, Boolean.valueOf(bool1));
    return bool1;
  }
  
  public static boolean isIPV4(String paramString)
  {
    if (!TextUtils.isEmpty(paramString)) {
      return IPV4_ADDR_PATTERN.matcher(paramString).matches();
    }
    return false;
  }
  
  public static boolean isIPV4Address(String paramString)
  {
    if (paramString != null) {
      try
      {
        if (paramString.isEmpty()) {
          return false;
        }
        String[] arrayOfString = paramString.split("\\.");
        if (arrayOfString.length == 4)
        {
          int j = arrayOfString.length;
          int i = 0;
          while (i < j)
          {
            int k = Integer.parseInt(arrayOfString[i]);
            if ((k < 0) || (k > 255)) {
              break label83;
            }
            i += 1;
          }
          boolean bool = paramString.endsWith(".");
          if (!bool) {
            return true;
          }
        }
      }
      catch (NumberFormatException paramString) {}
    }
    label83:
    return false;
  }
  
  public static boolean isIPV6(String paramString)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (!TextUtils.isEmpty(paramString))
    {
      bool1 = bool2;
      if (count(paramString, ':') >= 2) {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  public static boolean isLocalFile(String paramString)
  {
    return (!TextUtils.isEmpty(paramString)) && ((paramString.startsWith("/")) || (paramString.startsWith("file:")));
  }
  
  public static boolean isNetworkAvailable()
  {
    Object localObject = (ConnectivityManager)PlayerConfig.g().getAppContext().getSystemService("connectivity");
    if (localObject != null)
    {
      localObject = ((ConnectivityManager)localObject).getActiveNetworkInfo();
      return (localObject != null) && (((NetworkInfo)localObject).isConnected());
    }
    log(5, "PlayerUtils", "isNetworkAvailable cant access ConnectivityManager missing permission?");
    return false;
  }
  
  public static boolean isNoProxyUrl(String paramString)
  {
    return (!TextUtils.isEmpty(paramString)) && (!paramString.startsWith(VideoManager.getInstance().getLocalServerPrefix()));
  }
  
  public static boolean isOnMainThread()
  {
    return Looper.getMainLooper().getThread() == Thread.currentThread();
  }
  
  public static boolean isRawResourceUri(String paramString)
  {
    return (!TextUtils.isEmpty(paramString)) && (paramString.startsWith("android.resource://"));
  }
  
  public static boolean isRubbishPhoneMobile()
  {
    String str = Build.MODEL;
    return ("M040".equals(str)) || ("MX4".equals(str)) || ("MX4 Pro".equals(str)) || ("m2 note".equals(str));
  }
  
  public static String join(Iterator<String> paramIterator, String paramString)
  {
    Object localObject1 = "";
    Object localObject2 = localObject1;
    if (paramIterator != null) {
      for (;;)
      {
        localObject2 = localObject1;
        if (!paramIterator.hasNext()) {
          break;
        }
        localObject2 = (String)localObject1 + (String)paramIterator.next();
        localObject1 = localObject2;
        if (paramIterator.hasNext()) {
          localObject1 = (String)localObject2 + paramString;
        }
      }
    }
    return localObject2;
  }
  
  public static String join(List<String> paramList)
  {
    return join(paramList, "|");
  }
  
  public static String join(List<String> paramList, String paramString)
  {
    if (paramList != null) {
      return join(paramList.iterator(), paramString);
    }
    return "";
  }
  
  public static void log(int paramInt, String paramString1, String paramString2)
  {
    log(paramInt, paramString1, paramString2, null);
  }
  
  public static void log(int paramInt, String paramString1, String paramString2, Throwable paramThrowable)
  {
    String str = paramString2;
    if (paramThrowable != null) {
      str = paramString2 + ":" + getPrintableStackTrace(paramThrowable);
    }
    if (str.length() > 1000)
    {
      log(paramInt, paramString1, splitEqually(str, 1000));
      return;
    }
    paramString2 = PlayerConfig.g().getLogger();
    if (paramString2 == null)
    {
      switch (paramInt)
      {
      default: 
        return;
      case 2: 
        Log.v(paramString1, str);
        return;
      case 3: 
        Log.d(paramString1, str);
        return;
      case 6: 
        Log.e(paramString1, str);
        return;
      case 4: 
        Log.i(paramString1, str);
        return;
      }
      Log.w(paramString1, str);
      return;
    }
    switch (paramInt)
    {
    default: 
      return;
    case 2: 
      paramString2.v(paramString1, str);
      return;
    case 3: 
      paramString2.d(paramString1, str);
      return;
    case 6: 
      paramString2.e(paramString1, str);
      return;
    case 4: 
      paramString2.i(paramString1, str);
      return;
    }
    paramString2.w(paramString1, str);
  }
  
  public static void log(int paramInt, String paramString, List<String> paramList)
  {
    paramList = paramList.iterator();
    while (paramList.hasNext()) {
      log(paramInt, paramString, (String)paramList.next());
    }
  }
  
  public static String parseDomain(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      paramString = null;
    }
    for (;;)
    {
      return paramString;
      try
      {
        String str = new URL(paramString).getAuthority();
        paramString = str;
        if (!TextUtils.isEmpty(str))
        {
          int i = str.indexOf(":");
          paramString = str;
          if (i >= 0)
          {
            paramString = str;
            if (i < str.length())
            {
              paramString = str.substring(0, i);
              return paramString;
            }
          }
        }
      }
      catch (MalformedURLException paramString) {}
    }
    return null;
  }
  
  private static long parseErrorList(List<String> paramList)
  {
    if ((paramList != null) && (!paramList.isEmpty()))
    {
      paramList = (String)paramList.get(0);
      if (!TextUtils.isEmpty(paramList)) {
        try
        {
          long l = Long.parseLong(paramList);
          return l;
        }
        catch (NumberFormatException paramList)
        {
          log(6, "PlayerUtils", "getSubErrorCode: long string is ill-format");
        }
      }
    }
    return -1L;
  }
  
  public static int parseM3u8Number(String paramString)
  {
    paramString = parseM3u8Option(paramString);
    int j;
    if (TextUtils.isEmpty(paramString)) {
      j = -1;
    }
    int i;
    for (;;)
    {
      return j;
      try
      {
        i = Integer.parseInt(paramString);
        j = i;
        if (i != -1) {}
      }
      catch (Exception localException)
      {
        for (;;)
        {
          try
          {
            float f = Float.parseFloat(paramString);
            return (int)f;
          }
          catch (Exception paramString)
          {
            log(6, "PlayerUtils", "parseM3u8Number error " + paramString);
          }
          localException = localException;
          log(6, "PlayerUtils", "parseM3u8Number error " + localException);
          i = -1;
        }
      }
    }
    return i;
  }
  
  public static String parseM3u8Option(String paramString)
  {
    String str2 = "";
    String str1;
    if (TextUtils.isEmpty(paramString)) {
      str1 = str2;
    }
    do
    {
      int i;
      do
      {
        do
        {
          return str1;
          str1 = str2;
        } while (!paramString.startsWith("#"));
        i = paramString.indexOf(":");
        str1 = str2;
      } while (i == -1);
      str2 = paramString.substring(i + 1);
      str1 = str2;
    } while (paramString.lastIndexOf(",") == -1);
    return str2.substring(0, str2.length() - 1);
  }
  
  public static String parseVideoFileName(String paramString)
  {
    if (!URLUtil.isNetworkUrl(paramString)) {
      return "";
    }
    try
    {
      paramString = Uri.parse(paramString);
      return paramString.getLastPathSegment();
    }
    catch (Exception paramString) {}
    return "";
  }
  
  public static String parseVideoKey(String paramString)
  {
    if (!TextUtils.isEmpty(paramString))
    {
      localObject = (String)sVideoKeyCacheMap.get(paramString);
      if (!TextUtils.isEmpty((CharSequence)localObject)) {
        return localObject;
      }
    }
    VideoKeyGenerator localVideoKeyGenerator = PlayerConfig.g().getVideoKeyGenerator();
    Object localObject = localVideoKeyGenerator;
    if (localVideoKeyGenerator == null) {
      localObject = new DefaultVideoKeyGenerator();
    }
    localObject = ((VideoKeyGenerator)localObject).generate(paramString);
    sVideoKeyCacheMap.put(paramString, localObject);
    return localObject;
  }
  
  /* Error */
  public static String probeRealUrl(String paramString1, DNSService paramDNSService, int paramInt, String paramString2)
  {
    // Byte code:
    //   0: new 263	java/net/URL
    //   3: dup
    //   4: aload_0
    //   5: invokespecial 264	java/net/URL:<init>	(Ljava/lang/String;)V
    //   8: astore 6
    //   10: iconst_0
    //   11: istore 4
    //   13: iconst_4
    //   14: aload_3
    //   15: new 100	java/lang/StringBuilder
    //   18: dup
    //   19: invokespecial 101	java/lang/StringBuilder:<init>	()V
    //   22: ldc_w 748
    //   25: invokevirtual 105	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   28: aload 6
    //   30: invokevirtual 751	java/net/URL:toExternalForm	()Ljava/lang/String;
    //   33: invokevirtual 105	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   36: invokevirtual 111	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   39: invokestatic 194	com/tencent/oskplayer/util/PlayerUtils:log	(ILjava/lang/String;Ljava/lang/String;)V
    //   42: iload 4
    //   44: iconst_1
    //   45: iadd
    //   46: istore 5
    //   48: iload 4
    //   50: bipush 20
    //   52: if_icmpgt +478 -> 530
    //   55: aload_1
    //   56: ifnull +502 -> 558
    //   59: iconst_4
    //   60: aload_3
    //   61: new 100	java/lang/StringBuilder
    //   64: dup
    //   65: invokespecial 101	java/lang/StringBuilder:<init>	()V
    //   68: ldc_w 753
    //   71: invokevirtual 105	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   74: iload_2
    //   75: invokevirtual 159	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   78: invokevirtual 111	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   81: invokestatic 194	com/tencent/oskplayer/util/PlayerUtils:log	(ILjava/lang/String;Ljava/lang/String;)V
    //   84: iload_2
    //   85: iconst_1
    //   86: if_icmpne +170 -> 256
    //   89: new 263	java/net/URL
    //   92: dup
    //   93: aload_1
    //   94: aload 6
    //   96: invokevirtual 751	java/net/URL:toExternalForm	()Ljava/lang/String;
    //   99: ldc2_w 754
    //   102: invokestatic 759	com/tencent/oskplayer/util/PlayerUtils:replaceDomainPrependIp	(Lcom/tencent/oskplayer/service/DNSService;Ljava/lang/String;J)Ljava/lang/String;
    //   105: invokespecial 264	java/net/URL:<init>	(Ljava/lang/String;)V
    //   108: astore 6
    //   110: aload 6
    //   112: invokestatic 763	com/tencent/oskplayer/util/PlayerUtils:shouldByPassProxySetting	(Ljava/net/URL;)Z
    //   115: ifeq +198 -> 313
    //   118: aload 6
    //   120: getstatic 769	java/net/Proxy:NO_PROXY	Ljava/net/Proxy;
    //   123: invokevirtual 773	java/net/URL:openConnection	(Ljava/net/Proxy;)Ljava/net/URLConnection;
    //   126: checkcast 775	java/net/HttpURLConnection
    //   129: astore 7
    //   131: aload 7
    //   133: sipush 30000
    //   136: invokevirtual 778	java/net/HttpURLConnection:setConnectTimeout	(I)V
    //   139: aload 7
    //   141: sipush 12000
    //   144: invokevirtual 781	java/net/HttpURLConnection:setReadTimeout	(I)V
    //   147: aload 7
    //   149: iconst_0
    //   150: invokevirtual 784	java/net/HttpURLConnection:setDoOutput	(Z)V
    //   153: aload 7
    //   155: iconst_0
    //   156: invokevirtual 787	java/net/HttpURLConnection:setInstanceFollowRedirects	(Z)V
    //   159: aload 7
    //   161: invokevirtual 790	java/net/HttpURLConnection:connect	()V
    //   164: new 792	com/tencent/oskplayer/datasource/DefaultHttpDataSource$GetResponseCodeCallable
    //   167: dup
    //   168: aload 7
    //   170: invokespecial 795	com/tencent/oskplayer/datasource/DefaultHttpDataSource$GetResponseCodeCallable:<init>	(Ljava/net/HttpURLConnection;)V
    //   173: sipush 12000
    //   176: iconst_1
    //   177: ldc_w 797
    //   180: new 100	java/lang/StringBuilder
    //   183: dup
    //   184: invokespecial 101	java/lang/StringBuilder:<init>	()V
    //   187: aload_3
    //   188: invokevirtual 105	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   191: ldc_w 799
    //   194: invokevirtual 105	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   197: invokevirtual 111	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   200: invokestatic 805	com/tencent/oskplayer/util/ThreadUtils:submitTask	(Ljava/util/concurrent/Callable;IZLjava/lang/String;Ljava/lang/String;)Ljava/lang/Object;
    //   203: astore 8
    //   205: aload 8
    //   207: ifnonnull +119 -> 326
    //   210: aload 7
    //   212: invokevirtual 808	java/net/HttpURLConnection:disconnect	()V
    //   215: bipush 6
    //   217: ldc 24
    //   219: ldc_w 810
    //   222: invokestatic 194	com/tencent/oskplayer/util/PlayerUtils:log	(ILjava/lang/String;Ljava/lang/String;)V
    //   225: aconst_null
    //   226: areturn
    //   227: astore_0
    //   228: bipush 6
    //   230: aload_3
    //   231: new 100	java/lang/StringBuilder
    //   234: dup
    //   235: invokespecial 101	java/lang/StringBuilder:<init>	()V
    //   238: ldc_w 812
    //   241: invokevirtual 105	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   244: aload_0
    //   245: invokevirtual 717	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   248: invokevirtual 111	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   251: invokestatic 194	com/tencent/oskplayer/util/PlayerUtils:log	(ILjava/lang/String;Ljava/lang/String;)V
    //   254: aconst_null
    //   255: areturn
    //   256: iload_2
    //   257: ifne +27 -> 284
    //   260: new 263	java/net/URL
    //   263: dup
    //   264: aload_1
    //   265: aload 6
    //   267: invokevirtual 751	java/net/URL:toExternalForm	()Ljava/lang/String;
    //   270: ldc2_w 754
    //   273: invokestatic 815	com/tencent/oskplayer/util/PlayerUtils:replaceDomain	(Lcom/tencent/oskplayer/service/DNSService;Ljava/lang/String;J)Ljava/lang/String;
    //   276: invokespecial 264	java/net/URL:<init>	(Ljava/lang/String;)V
    //   279: astore 6
    //   281: goto -171 -> 110
    //   284: iconst_5
    //   285: aload_3
    //   286: new 100	java/lang/StringBuilder
    //   289: dup
    //   290: invokespecial 101	java/lang/StringBuilder:<init>	()V
    //   293: ldc_w 817
    //   296: invokevirtual 105	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   299: iload 5
    //   301: invokevirtual 159	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   304: invokevirtual 111	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   307: invokestatic 194	com/tencent/oskplayer/util/PlayerUtils:log	(ILjava/lang/String;Ljava/lang/String;)V
    //   310: goto +248 -> 558
    //   313: aload 6
    //   315: invokevirtual 820	java/net/URL:openConnection	()Ljava/net/URLConnection;
    //   318: checkcast 775	java/net/HttpURLConnection
    //   321: astore 7
    //   323: goto -192 -> 131
    //   326: aload 8
    //   328: checkcast 115	java/lang/Integer
    //   331: invokevirtual 823	java/lang/Integer:intValue	()I
    //   334: istore 4
    //   336: iload 4
    //   338: sipush 300
    //   341: if_icmpeq +43 -> 384
    //   344: iload 4
    //   346: sipush 301
    //   349: if_icmpeq +35 -> 384
    //   352: iload 4
    //   354: sipush 302
    //   357: if_icmpeq +27 -> 384
    //   360: iload 4
    //   362: sipush 303
    //   365: if_icmpeq +19 -> 384
    //   368: iload 4
    //   370: sipush 307
    //   373: if_icmpeq +11 -> 384
    //   376: iload 4
    //   378: sipush 308
    //   381: if_icmpne +60 -> 441
    //   384: aload 7
    //   386: ldc_w 825
    //   389: invokevirtual 828	java/net/HttpURLConnection:getHeaderField	(Ljava/lang/String;)Ljava/lang/String;
    //   392: astore 8
    //   394: iconst_4
    //   395: aload_3
    //   396: new 100	java/lang/StringBuilder
    //   399: dup
    //   400: invokespecial 101	java/lang/StringBuilder:<init>	()V
    //   403: ldc_w 830
    //   406: invokevirtual 105	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   409: aload 8
    //   411: invokevirtual 105	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   414: invokevirtual 111	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   417: invokestatic 194	com/tencent/oskplayer/util/PlayerUtils:log	(ILjava/lang/String;Ljava/lang/String;)V
    //   420: aload 7
    //   422: invokevirtual 808	java/net/HttpURLConnection:disconnect	()V
    //   425: aload 6
    //   427: aload 8
    //   429: invokestatic 836	com/tencent/oskplayer/datasource/DefaultHttpDataSource:handleRedirect	(Ljava/net/URL;Ljava/lang/String;)Ljava/net/URL;
    //   432: astore 6
    //   434: iload 5
    //   436: istore 4
    //   438: goto -396 -> 42
    //   441: iconst_4
    //   442: aload_3
    //   443: new 100	java/lang/StringBuilder
    //   446: dup
    //   447: invokespecial 101	java/lang/StringBuilder:<init>	()V
    //   450: ldc_w 838
    //   453: invokevirtual 105	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   456: aload_0
    //   457: invokevirtual 105	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   460: ldc_w 840
    //   463: invokevirtual 105	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   466: aload 6
    //   468: invokevirtual 751	java/net/URL:toExternalForm	()Ljava/lang/String;
    //   471: invokevirtual 105	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   474: ldc_w 842
    //   477: invokevirtual 105	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   480: iload 5
    //   482: invokevirtual 159	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   485: invokevirtual 111	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   488: invokestatic 194	com/tencent/oskplayer/util/PlayerUtils:log	(ILjava/lang/String;Ljava/lang/String;)V
    //   491: aload 6
    //   493: invokevirtual 751	java/net/URL:toExternalForm	()Ljava/lang/String;
    //   496: astore_0
    //   497: aload_0
    //   498: areturn
    //   499: astore_0
    //   500: iconst_5
    //   501: aload_3
    //   502: new 100	java/lang/StringBuilder
    //   505: dup
    //   506: invokespecial 101	java/lang/StringBuilder:<init>	()V
    //   509: ldc_w 844
    //   512: invokevirtual 105	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   515: aload_0
    //   516: invokestatic 647	com/tencent/oskplayer/util/PlayerUtils:getPrintableStackTrace	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   519: invokevirtual 105	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   522: invokevirtual 111	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   525: invokestatic 194	com/tencent/oskplayer/util/PlayerUtils:log	(ILjava/lang/String;Ljava/lang/String;)V
    //   528: aconst_null
    //   529: areturn
    //   530: iconst_5
    //   531: aload_3
    //   532: new 100	java/lang/StringBuilder
    //   535: dup
    //   536: invokespecial 101	java/lang/StringBuilder:<init>	()V
    //   539: ldc_w 846
    //   542: invokevirtual 105	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   545: iload 5
    //   547: invokevirtual 159	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   550: invokevirtual 111	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   553: invokestatic 194	com/tencent/oskplayer/util/PlayerUtils:log	(ILjava/lang/String;Ljava/lang/String;)V
    //   556: aconst_null
    //   557: areturn
    //   558: goto -448 -> 110
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	561	0	paramString1	String
    //   0	561	1	paramDNSService	DNSService
    //   0	561	2	paramInt	int
    //   0	561	3	paramString2	String
    //   11	426	4	i	int
    //   46	500	5	j	int
    //   8	484	6	localURL	URL
    //   129	292	7	localHttpURLConnection	java.net.HttpURLConnection
    //   203	225	8	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   0	10	227	java/net/MalformedURLException
    //   59	84	499	java/lang/Exception
    //   89	110	499	java/lang/Exception
    //   110	131	499	java/lang/Exception
    //   131	205	499	java/lang/Exception
    //   210	225	499	java/lang/Exception
    //   260	281	499	java/lang/Exception
    //   284	310	499	java/lang/Exception
    //   313	323	499	java/lang/Exception
    //   326	336	499	java/lang/Exception
    //   384	434	499	java/lang/Exception
    //   441	497	499	java/lang/Exception
  }
  
  public static String removeLineBreaks(String paramString1, String paramString2)
  {
    String str = paramString2;
    if (paramString2 == null) {
      str = "|";
    }
    paramString2 = paramString1;
    if (paramString1 != null) {
      paramString2 = paramString1.replaceAll("\\r\\n", str).replaceAll("\\r|\\n", str);
    }
    return paramString2;
  }
  
  public static String replaceDomain(DNSService paramDNSService, String paramString, long paramLong)
  {
    if (TextUtils.isEmpty(paramString)) {}
    for (;;)
    {
      return paramString;
      String str = parseDomain(paramString);
      if ((!TextUtils.isEmpty(str)) && (!isIPV4(str)) && (!isIPV6(str)))
      {
        if (paramLong > 0L) {}
        for (paramDNSService = paramDNSService.resolve(str, paramLong, TimeUnit.MILLISECONDS); !TextUtils.isEmpty(paramDNSService); paramDNSService = paramDNSService.resolve(str)) {
          return paramString.replaceFirst(str, paramDNSService);
        }
      }
    }
  }
  
  public static String replaceDomainPrependIp(DNSService paramDNSService, String paramString, long paramLong)
  {
    if (TextUtils.isEmpty(paramString)) {}
    label132:
    for (;;)
    {
      return paramString;
      Object localObject = parseDomain(paramString);
      if ((!TextUtils.isEmpty((CharSequence)localObject)) && (!isIPV4((String)localObject)) && (!isIPV6((String)localObject)))
      {
        if (paramLong > 0L) {}
        for (paramDNSService = paramDNSService.resolve((String)localObject, paramLong, TimeUnit.MILLISECONDS);; paramDNSService = paramDNSService.resolve((String)localObject))
        {
          if (TextUtils.isEmpty(paramDNSService)) {
            break label132;
          }
          localObject = paramString.split("://");
          if (localObject.length <= 1) {
            break;
          }
          return localObject[0] + "://" + paramDNSService + "/" + localObject[1];
        }
      }
    }
  }
  
  public static Uri replaceUriParameter(Uri paramUri, String paramString1, String paramString2)
  {
    Object localObject = paramUri.getQueryParameterNames();
    Uri.Builder localBuilder = paramUri.buildUpon().clearQuery();
    Iterator localIterator = ((Set)localObject).iterator();
    if (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      if (str.equals(paramString1)) {}
      for (localObject = paramString2;; localObject = paramUri.getQueryParameter(str))
      {
        localBuilder.appendQueryParameter(str, (String)localObject);
        break;
      }
    }
    return localBuilder.build();
  }
  
  public static int rubbishPhoneOffset()
  {
    String str = Build.MODEL;
    int i = 0;
    if (("M040".equals(str)) || ("MX4".equals(str)) || ("m2 note".equals(str))) {
      i = 1;
    }
    return i;
  }
  
  public static void runOnUiThread(Runnable paramRunnable)
  {
    runOnUiThread(paramRunnable, 0);
  }
  
  public static void runOnUiThread(Runnable paramRunnable, int paramInt)
  {
    Looper localLooper = Looper.getMainLooper();
    Handler localHandler = new Handler(localLooper);
    if (localLooper.getThread() != Thread.currentThread())
    {
      if (paramInt > 0)
      {
        localHandler.postDelayed(paramRunnable, paramInt);
        return;
      }
      localHandler.post(paramRunnable);
      return;
    }
    if (paramInt > 0)
    {
      localHandler.postDelayed(paramRunnable, paramInt);
      return;
    }
    paramRunnable.run();
  }
  
  public static void runOnUiThreadDelay(Runnable paramRunnable, long paramLong)
  {
    new Handler(Looper.getMainLooper()).postDelayed(paramRunnable, paramLong);
  }
  
  public static void setH265ReportKeyVersion(int paramInt)
  {
    H265_REPORT_KEY_VERSION = paramInt;
  }
  
  public static boolean shouldByPassProxySetting(URL paramURL)
  {
    Object localObject = null;
    boolean bool = true;
    try
    {
      paramURL = paramURL.getHost();
      if (paramURL == null) {
        return false;
      }
    }
    catch (Exception paramURL)
    {
      for (;;)
      {
        paramURL = null;
        continue;
        try
        {
          paramURL = InetAddress.getByName(paramURL);
          if (paramURL != null) {
            if ((paramURL.isAnyLocalAddress()) || (paramURL.isLoopbackAddress())) {
              return true;
            }
          }
        }
        catch (UnknownHostException paramURL)
        {
          try
          {
            paramURL = NetworkInterface.getByInetAddress(paramURL);
            if (paramURL != null) {}
            for (;;)
            {
              return bool;
              bool = false;
            }
            paramURL = paramURL;
            paramURL = localObject;
          }
          catch (SocketException paramURL) {}
        }
      }
    }
    return false;
  }
  
  public static List<String> splitEqually(String paramString, int paramInt)
  {
    ArrayList localArrayList = new ArrayList((paramString.length() + paramInt - 1) / paramInt);
    int i = 0;
    while (i < paramString.length())
    {
      localArrayList.add(paramString.substring(i, Math.min(paramString.length(), i + paramInt)));
      i += paramInt;
    }
    return localArrayList;
  }
  
  public static String toString(Object paramObject)
  {
    if (paramObject == null) {
      return "null";
    }
    return paramObject.toString();
  }
  
  public static String wrapFileScheme(String paramString)
  {
    String str = paramString;
    if (!TextUtils.isEmpty(paramString))
    {
      str = paramString;
      if (paramString.startsWith("/")) {
        str = "file://" + paramString;
      }
    }
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.oskplayer.util.PlayerUtils
 * JD-Core Version:    0.7.0.1
 */