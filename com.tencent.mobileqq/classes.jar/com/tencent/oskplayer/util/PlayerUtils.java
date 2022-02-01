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
import com.tencent.oskplayer.datasource.DefaultHttpDataSource;
import com.tencent.oskplayer.datasource.DefaultHttpDataSource.GetResponseCodeCallable;
import com.tencent.oskplayer.proxy.DefaultVideoKeyGenerator;
import com.tencent.oskplayer.proxy.VideoKeyGenerator;
import com.tencent.oskplayer.proxy.VideoManager;
import com.tencent.oskplayer.service.DNSService;
import com.tencent.oskplayer.support.util.OskDebug;
import com.tencent.oskplayer.support.util.OskFile;
import java.io.File;
import java.lang.reflect.Method;
import java.net.HttpURLConnection;
import java.net.InetAddress;
import java.net.MalformedURLException;
import java.net.NetworkInterface;
import java.net.Proxy;
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
import java.util.concurrent.Callable;
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
    int i = Math.min(paramInt, paramArrayOfByte.length);
    char[] arrayOfChar = new char[i * 2];
    Object localObject1 = "";
    paramInt = 0;
    while (paramInt < i)
    {
      int j = paramInt % 16;
      localObject2 = localObject1;
      if (j == 0)
      {
        localObject2 = localObject1;
        if (paramInt != 0)
        {
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append((String)localObject1);
          ((StringBuilder)localObject2).append("\n");
          localObject2 = ((StringBuilder)localObject2).toString();
        }
      }
      localObject1 = localObject2;
      if (j == 0)
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append((String)localObject2);
        ((StringBuilder)localObject1).append(String.format("%2s:", new Object[] { Integer.toHexString(paramInt) }));
        localObject1 = ((StringBuilder)localObject1).toString();
      }
      localObject2 = localObject1;
      if (paramInt % 2 == 0)
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append((String)localObject1);
        ((StringBuilder)localObject2).append(" ");
        localObject2 = ((StringBuilder)localObject2).toString();
      }
      j = paramArrayOfByte[paramInt] & 0xFF;
      int k = paramInt * 2;
      arrayOfChar[k] = hexArray[(j >>> 4)];
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append((String)localObject2);
      ((StringBuilder)localObject1).append(arrayOfChar[k]);
      localObject1 = ((StringBuilder)localObject1).toString();
      k += 1;
      arrayOfChar[k] = hexArray[(j & 0xF)];
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append((String)localObject1);
      ((StringBuilder)localObject2).append(arrayOfChar[k]);
      localObject1 = ((StringBuilder)localObject2).toString();
      paramInt += 1;
    }
    Object localObject2 = localObject1;
    if (paramArrayOfByte.length > i)
    {
      paramArrayOfByte = new StringBuilder();
      paramArrayOfByte.append((String)localObject1);
      paramArrayOfByte.append(" ....");
      localObject2 = paramArrayOfByte.toString();
    }
    return localObject2;
  }
  
  private static int count(String paramString, char paramChar)
  {
    int i = 0;
    if (paramString == null) {
      return 0;
    }
    int m = paramString.length();
    int k;
    for (int j = 0; i < m; j = k)
    {
      k = j;
      if (paramChar == paramString.charAt(i)) {
        k = j + 1;
      }
      i += 1;
    }
    return j;
  }
  
  private static String doGetMobileDetailInfo()
  {
    if (h265MobileDetailInfoKey == null)
    {
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append("");
      ((StringBuilder)localObject).append(Build.MODEL);
      localObject = ((StringBuilder)localObject).toString();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append((String)localObject);
      localStringBuilder.append("&");
      localObject = localStringBuilder.toString();
      localStringBuilder = new StringBuilder();
      localStringBuilder.append((String)localObject);
      localStringBuilder.append(Build.VERSION.RELEASE);
      localObject = localStringBuilder.toString();
      localStringBuilder = new StringBuilder();
      localStringBuilder.append((String)localObject);
      localStringBuilder.append("&");
      localObject = localStringBuilder.toString();
      localStringBuilder = new StringBuilder();
      localStringBuilder.append((String)localObject);
      localStringBuilder.append(Build.VERSION.SDK_INT);
      localObject = localStringBuilder.toString();
      localStringBuilder = new StringBuilder();
      localStringBuilder.append((String)localObject);
      localStringBuilder.append("&");
      localObject = localStringBuilder.toString();
      localStringBuilder = new StringBuilder();
      localStringBuilder.append((String)localObject);
      localStringBuilder.append(getNumberOfCores());
      localObject = localStringBuilder.toString();
      localStringBuilder = new StringBuilder();
      localStringBuilder.append((String)localObject);
      localStringBuilder.append("&");
      localObject = localStringBuilder.toString();
      localStringBuilder = new StringBuilder();
      localStringBuilder.append((String)localObject);
      localStringBuilder.append(H265_REPORT_KEY_VERSION);
      h265MobileDetailInfoKey = localStringBuilder.toString();
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
    //   26: invokevirtual 178	java/net/ServerSocket:close	()V
    //   29: iload_0
    //   30: ireturn
    //   31: astore_2
    //   32: goto +9 -> 41
    //   35: goto +16 -> 51
    //   38: astore_2
    //   39: aconst_null
    //   40: astore_1
    //   41: aload_1
    //   42: ifnull +7 -> 49
    //   45: aload_1
    //   46: invokevirtual 178	java/net/ServerSocket:close	()V
    //   49: aload_2
    //   50: athrow
    //   51: aload_1
    //   52: ifnull +7 -> 59
    //   55: aload_1
    //   56: invokevirtual 178	java/net/ServerSocket:close	()V
    //   59: new 180	java/lang/IllegalStateException
    //   62: dup
    //   63: ldc 182
    //   65: invokespecial 185	java/lang/IllegalStateException:<init>	(Ljava/lang/String;)V
    //   68: athrow
    //   69: astore_1
    //   70: aload_2
    //   71: astore_1
    //   72: goto -21 -> 51
    //   75: astore_2
    //   76: goto -41 -> 35
    //   79: astore_2
    //   80: goto -55 -> 25
    //   83: astore_1
    //   84: iload_0
    //   85: ireturn
    //   86: astore_1
    //   87: goto -38 -> 49
    //   90: astore_1
    //   91: goto -32 -> 59
    // Local variable table:
    //   start	length	slot	name	signature
    //   20	65	0	i	int
    //   10	46	1	localServerSocket	java.net.ServerSocket
    //   69	1	1	localIOException1	java.io.IOException
    //   71	1	1	localObject1	Object
    //   83	1	1	localIOException2	java.io.IOException
    //   86	1	1	localIOException3	java.io.IOException
    //   90	1	1	localIOException4	java.io.IOException
    //   1	1	2	localObject2	Object
    //   31	1	2	localObject3	Object
    //   38	33	2	localObject4	Object
    //   75	1	2	localIOException5	java.io.IOException
    //   79	1	2	localIOException6	java.io.IOException
    // Exception table:
    //   from	to	target	type
    //   11	21	31	finally
    //   21	25	31	finally
    //   2	11	38	finally
    //   2	11	69	java/io/IOException
    //   11	21	75	java/io/IOException
    //   21	25	79	java/io/IOException
    //   25	29	83	java/io/IOException
    //   45	49	86	java/io/IOException
    //   55	59	90	java/io/IOException
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
      int i;
      label6:
      label19:
      break label6;
    }
    i = 0;
    while (i < paramInt)
    {
      try
      {
        int j = findFreePort();
        return j;
      }
      catch (IllegalStateException localIllegalStateException2)
      {
        Object localObject;
        break label19;
      }
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("retry findFreePort i=");
      ((StringBuilder)localObject).append(i);
      log(5, "PlayerUtils", ((StringBuilder)localObject).toString());
      i += 1;
    }
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("Could not find a free TCP/IP port to start video proxy, maxRetry=");
    ((StringBuilder)localObject).append(paramInt);
    localObject = new IllegalStateException(((StringBuilder)localObject).toString());
    for (;;)
    {
      throw ((Throwable)localObject);
    }
  }
  
  public static String formatVideoTime(long paramLong)
  {
    double d = paramLong;
    Double.isNaN(d);
    long l2 = Math.round(d * 1.0D / 1000.0D);
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
    Object localObject = paramString1;
    if (!TextUtils.isEmpty(paramString1))
    {
      if (TextUtils.isEmpty(paramString2)) {
        return paramString1;
      }
      if (paramString2.startsWith("http")) {
        return paramString2;
      }
    }
    try
    {
      localObject = new URL(new URL(paramString1), paramString2);
      return ((URL)localObject).toString();
    }
    catch (MalformedURLException localMalformedURLException)
    {
      label52:
      break label52;
    }
    localObject = getAbsoluteUrl2(paramString1, paramString2);
    return localObject;
  }
  
  private static String getAbsoluteUrl2(String paramString1, String paramString2)
  {
    Object localObject = paramString1;
    if (paramString1.endsWith("/")) {
      localObject = paramString1.substring(0, paramString1.length() - 1);
    }
    int i = ((String)localObject).lastIndexOf('/');
    paramString1 = (String)localObject;
    if (i > 0) {
      paramString1 = ((String)localObject).substring(0, i);
    }
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append(paramString1);
    ((StringBuilder)localObject).append(paramString2);
    return ((StringBuilder)localObject).toString();
  }
  
  public static String getConnectionTypeStr(int paramInt)
  {
    if (paramInt != 0)
    {
      if (paramInt != 1) {
        return "TYPE_UNKNOWN";
      }
      return "TYPE_WIFI";
    }
    return "TYPE_MOBILE";
  }
  
  public static long getDownloadResponseCode(long paramLong1, long paramLong2)
  {
    String[] arrayOfString = getUserProxy();
    int i;
    if (arrayOfString != null)
    {
      i = -3;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("proxy setting ");
      localStringBuilder.append(join(Arrays.asList(arrayOfString).iterator(), "|"));
      log(4, "PlayerUtils", localStringBuilder.toString());
    }
    else
    {
      i = -2;
    }
    return (paramLong1 - paramLong2 - i * 100000000) / 100000L;
  }
  
  public static long getDownloadRetCode(long paramLong1, long paramLong2)
  {
    String[] arrayOfString = getUserProxy();
    int i;
    if (arrayOfString != null)
    {
      i = -3;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("proxy setting ");
      localStringBuilder.append(join(Arrays.asList(arrayOfString).iterator(), "|"));
      log(4, "PlayerUtils", localStringBuilder.toString());
    }
    else
    {
      i = -2;
    }
    return i * 100000000 + paramLong1 * 100000L + paramLong2;
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
    catch (Exception localException)
    {
      label24:
      break label24;
    }
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
    long l;
    if ((!TextUtils.isEmpty(paramString)) && (paramString.equals("liveVideo"))) {
      l = -10000000000L;
    } else {
      l = 0L;
    }
    return l - 200000000L + paramInt * 100000 + paramLong;
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
      long l = parseErrorList((List)paramMap.get("x-server-error"));
      if ((l != -1L) && (l != 0L)) {
        return l;
      }
      l = parseErrorList((List)paramMap.get("x-proxy-error"));
      if (l != -1L) {
        return l - 20000L;
      }
      l = parseErrorList((List)paramMap.get("error"));
      if (l != -1L) {
        return l;
      }
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
      localObject = ((Method)localObject).invoke((ConnectivityManager)PlayerConfig.g().getAppContext().getSystemService("connectivity"), new Object[0]);
      if (localObject == null) {
        return null;
      }
      localObject = getUserProxy(localObject);
      return localObject;
    }
    catch (NoSuchMethodException|Exception localNoSuchMethodException) {}
    return null;
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
    Object localObject = HttpParser.parseParams(paramString);
    if ((localObject != null) && (!((Map)localObject).isEmpty())) {
      return (String)((Map)localObject).get("uuid");
    }
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("getVideoUuidFromVideoUrl fail ");
    ((StringBuilder)localObject).append(paramString);
    log(6, "PlayerUtils", ((StringBuilder)localObject).toString());
    return null;
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
    if ((paramArrayOfByte != null) && (paramArrayOfByte.length > 100))
    {
      byte[] arrayOfByte = new byte[100];
      System.arraycopy(paramArrayOfByte, 0, arrayOfByte, 0, 100);
      return new String(arrayOfByte).toLowerCase().replaceAll("\\s", "").contains(htmlMagic);
    }
    return false;
  }
  
  public static boolean isHLSStream(String paramString)
  {
    boolean bool1 = TextUtils.isEmpty(paramString);
    boolean bool2 = false;
    if (bool1) {
      return false;
    }
    if (sIsHLSStreamCacheMap.containsKey(paramString)) {
      return ((Boolean)sIsHLSStreamCacheMap.get(paramString)).booleanValue();
    }
    try
    {
      localObject = new URL(paramString).getPath();
      bool1 = bool2;
      if (TextUtils.isEmpty((CharSequence)localObject)) {
        break label121;
      }
      boolean bool3 = ((String)localObject).toLowerCase().endsWith(".m3u8");
      bool1 = bool2;
      if (!bool3) {
        break label121;
      }
      bool1 = true;
    }
    catch (Exception localException)
    {
      Object localObject;
      label83:
      break label83;
    }
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("isHLSStream illegal url ");
    ((StringBuilder)localObject).append(paramString);
    log(5, "PlayerUtils", ((StringBuilder)localObject).toString());
    bool1 = bool2;
    label121:
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
    if (paramString != null) {}
    for (;;)
    {
      int i;
      try
      {
        if (paramString.isEmpty()) {
          return false;
        }
        String[] arrayOfString = paramString.split("\\.");
        if (arrayOfString.length != 4) {
          return false;
        }
        int j = arrayOfString.length;
        i = 0;
        if (i < j)
        {
          int k = Integer.parseInt(arrayOfString[i]);
          if (k < 0) {
            break;
          }
          if (k <= 255) {
            break label86;
          }
          return false;
        }
        boolean bool = paramString.endsWith(".");
        return !bool;
      }
      catch (NumberFormatException paramString)
      {
        return false;
      }
      return false;
      label86:
      i += 1;
    }
    return false;
  }
  
  public static boolean isIPV6(String paramString)
  {
    boolean bool3 = TextUtils.isEmpty(paramString);
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (!bool3)
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
    boolean bool2 = false;
    if (localObject != null)
    {
      localObject = ((ConnectivityManager)localObject).getActiveNetworkInfo();
      boolean bool1 = bool2;
      if (localObject != null)
      {
        bool1 = bool2;
        if (((NetworkInfo)localObject).isConnected()) {
          bool1 = true;
        }
      }
      return bool1;
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
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append((String)localObject1);
        ((StringBuilder)localObject2).append((String)paramIterator.next());
        localObject2 = ((StringBuilder)localObject2).toString();
        localObject1 = localObject2;
        if (paramIterator.hasNext())
        {
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append((String)localObject2);
          ((StringBuilder)localObject1).append(paramString);
          localObject1 = ((StringBuilder)localObject1).toString();
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
    Object localObject = paramString2;
    if (paramThrowable != null)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(paramString2);
      ((StringBuilder)localObject).append(":");
      ((StringBuilder)localObject).append(getPrintableStackTrace(paramThrowable));
      localObject = ((StringBuilder)localObject).toString();
    }
    if (((String)localObject).length() > 1000)
    {
      log(paramInt, paramString1, splitEqually((String)localObject, 1000));
      return;
    }
    paramString2 = PlayerConfig.g().getLogger();
    if (paramString2 == null)
    {
      if (paramInt != 2)
      {
        if (paramInt != 3)
        {
          if (paramInt != 4)
          {
            if (paramInt != 5)
            {
              if (paramInt != 6) {
                return;
              }
              Log.e(paramString1, (String)localObject);
              return;
            }
            Log.w(paramString1, (String)localObject);
            return;
          }
          Log.i(paramString1, (String)localObject);
          return;
        }
        Log.d(paramString1, (String)localObject);
        return;
      }
      Log.v(paramString1, (String)localObject);
      return;
    }
    if (paramInt != 2)
    {
      if (paramInt != 3)
      {
        if (paramInt != 4)
        {
          if (paramInt != 5)
          {
            if (paramInt != 6) {
              return;
            }
            paramString2.e(paramString1, (String)localObject);
            return;
          }
          paramString2.w(paramString1, (String)localObject);
          return;
        }
        paramString2.i(paramString1, (String)localObject);
        return;
      }
      paramString2.d(paramString1, (String)localObject);
      return;
    }
    paramString2.v(paramString1, (String)localObject);
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
      return null;
    }
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
          if (i < str.length()) {
            paramString = str.substring(0, i);
          }
        }
      }
      return paramString;
    }
    catch (MalformedURLException paramString) {}
    return null;
  }
  
  private static long parseErrorList(List<String> paramList)
  {
    if ((paramList != null) && (!paramList.isEmpty()))
    {
      paramList = (String)paramList.get(0);
      if (TextUtils.isEmpty(paramList)) {}
    }
    try
    {
      long l = Long.parseLong(paramList);
      return l;
    }
    catch (NumberFormatException paramList)
    {
      label38:
      break label38;
    }
    log(6, "PlayerUtils", "getSubErrorCode: long string is ill-format");
    return -1L;
  }
  
  public static int parseM3u8Number(String paramString)
  {
    paramString = parseM3u8Option(paramString);
    if (TextUtils.isEmpty(paramString)) {
      return -1;
    }
    int i;
    try
    {
      i = Integer.parseInt(paramString);
    }
    catch (Exception localException)
    {
      StringBuilder localStringBuilder2 = new StringBuilder();
      localStringBuilder2.append("parseM3u8Number error ");
      localStringBuilder2.append(localException);
      log(6, "PlayerUtils", localStringBuilder2.toString());
      i = -1;
    }
    if (i == -1) {
      try
      {
        float f = Float.parseFloat(paramString);
        return (int)f;
      }
      catch (Exception paramString)
      {
        StringBuilder localStringBuilder1 = new StringBuilder();
        localStringBuilder1.append("parseM3u8Number error ");
        localStringBuilder1.append(paramString);
        log(6, "PlayerUtils", localStringBuilder1.toString());
      }
    }
    return i;
  }
  
  public static String parseM3u8Option(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return "";
    }
    if (!paramString.startsWith("#")) {
      return "";
    }
    int i = paramString.indexOf(":");
    if (i == -1) {
      return "";
    }
    String str2 = paramString.substring(i + 1);
    String str1 = str2;
    if (paramString.lastIndexOf(",") != -1) {
      str1 = str2.substring(0, str2.length() - 1);
    }
    return str1;
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
  
  public static String probeRealUrl(String paramString1, DNSService paramDNSService, int paramInt, String paramString2)
  {
    label648:
    for (;;)
    {
      try
      {
        URL localURL = new URL(paramString1);
        Object localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("probeRealUrl ");
        ((StringBuilder)localObject1).append(localURL.toExternalForm());
        log(4, paramString2, ((StringBuilder)localObject1).toString());
        int i = 0;
        int j = i + 1;
        if (i <= 20)
        {
          if (paramDNSService != null) {
            try
            {
              localObject1 = new StringBuilder();
              ((StringBuilder)localObject1).append("probeRealUrl DnsServiceMode=");
              ((StringBuilder)localObject1).append(paramInt);
              log(4, paramString2, ((StringBuilder)localObject1).toString());
              if (paramInt == 1)
              {
                localURL = new URL(replaceDomainPrependIp(paramDNSService, localURL.toExternalForm(), 2000L));
              }
              else if (paramInt == 0)
              {
                localURL = new URL(replaceDomain(paramDNSService, localURL.toExternalForm(), 2000L));
              }
              else
              {
                localObject1 = new StringBuilder();
                ((StringBuilder)localObject1).append("Unknown DnsServiceOpType: ");
                ((StringBuilder)localObject1).append(j);
                log(5, paramString2, ((StringBuilder)localObject1).toString());
                break label648;
              }
              if (shouldByPassProxySetting(localURL)) {
                localObject1 = (HttpURLConnection)localURL.openConnection(Proxy.NO_PROXY);
              } else {
                localObject1 = (HttpURLConnection)localURL.openConnection();
              }
              ((HttpURLConnection)localObject1).setConnectTimeout(30000);
              ((HttpURLConnection)localObject1).setReadTimeout(12000);
              ((HttpURLConnection)localObject1).setDoOutput(false);
              ((HttpURLConnection)localObject1).setInstanceFollowRedirects(false);
              ((HttpURLConnection)localObject1).connect();
              Object localObject2 = new DefaultHttpDataSource.GetResponseCodeCallable((HttpURLConnection)localObject1);
              StringBuilder localStringBuilder = new StringBuilder();
              localStringBuilder.append(paramString2);
              localStringBuilder.append(".probeRealUrl");
              localObject2 = ThreadUtils.submitTask((Callable)localObject2, 12000, true, "GetResponseCodeCallable", localStringBuilder.toString());
              if (localObject2 == null)
              {
                ((HttpURLConnection)localObject1).disconnect();
                log(6, "PlayerUtils", "getResponseCode Timeout");
                return null;
              }
              i = ((Integer)localObject2).intValue();
              if ((i != 300) && (i != 301) && (i != 302) && (i != 303) && (i != 307) && (i != 308))
              {
                paramDNSService = new StringBuilder();
                paramDNSService.append("probeRealUrl success:sourceUrl=");
                paramDNSService.append(paramString1);
                paramDNSService.append(",realUrl=");
                paramDNSService.append(localURL.toExternalForm());
                paramDNSService.append(",redirectCount=");
                paramDNSService.append(j);
                log(4, paramString2, paramDNSService.toString());
                return localURL.toExternalForm();
              }
              localObject2 = ((HttpURLConnection)localObject1).getHeaderField("Location");
              localStringBuilder = new StringBuilder();
              localStringBuilder.append("probeRealUrl redirectTo=");
              localStringBuilder.append((String)localObject2);
              log(4, paramString2, localStringBuilder.toString());
              ((HttpURLConnection)localObject1).disconnect();
              localURL = DefaultHttpDataSource.handleRedirect(localURL, (String)localObject2);
              i = j;
            }
            catch (Exception paramString1)
            {
              paramDNSService = new StringBuilder();
              paramDNSService.append("Caught Exception while probeRealUrl: ");
              paramDNSService.append(getPrintableStackTrace(paramString1));
              log(5, paramString2, paramDNSService.toString());
              return null;
            }
          }
        }
        else
        {
          paramString1 = new StringBuilder();
          paramString1.append("Too many redirects: ");
          paramString1.append(j);
          log(5, paramString2, paramString1.toString());
          return null;
        }
      }
      catch (MalformedURLException paramString1)
      {
        paramDNSService = new StringBuilder();
        paramDNSService.append("probeRealUrl failed ");
        paramDNSService.append(paramString1);
        log(6, paramString2, paramDNSService.toString());
        return null;
      }
    }
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
    if (TextUtils.isEmpty(paramString)) {
      return paramString;
    }
    String str2 = parseDomain(paramString);
    String str1 = paramString;
    if (!TextUtils.isEmpty(str2))
    {
      str1 = paramString;
      if (!isIPV4(str2))
      {
        str1 = paramString;
        if (!isIPV6(str2))
        {
          if (paramLong > 0L) {
            paramDNSService = paramDNSService.resolve(str2, paramLong, TimeUnit.MILLISECONDS);
          } else {
            paramDNSService = paramDNSService.resolve(str2);
          }
          str1 = paramString;
          if (!TextUtils.isEmpty(paramDNSService)) {
            str1 = paramString.replaceFirst(str2, paramDNSService);
          }
        }
      }
    }
    return str1;
  }
  
  public static String replaceDomainPrependIp(DNSService paramDNSService, String paramString, long paramLong)
  {
    if (TextUtils.isEmpty(paramString)) {
      return paramString;
    }
    Object localObject = parseDomain(paramString);
    String str = paramString;
    if (!TextUtils.isEmpty((CharSequence)localObject))
    {
      str = paramString;
      if (!isIPV4((String)localObject))
      {
        str = paramString;
        if (!isIPV6((String)localObject))
        {
          if (paramLong > 0L) {
            paramDNSService = paramDNSService.resolve((String)localObject, paramLong, TimeUnit.MILLISECONDS);
          } else {
            paramDNSService = paramDNSService.resolve((String)localObject);
          }
          str = paramString;
          if (!TextUtils.isEmpty(paramDNSService))
          {
            localObject = paramString.split("://");
            str = paramString;
            if (localObject.length > 1)
            {
              paramString = new StringBuilder();
              paramString.append(localObject[0]);
              paramString.append("://");
              paramString.append(paramDNSService);
              paramString.append("/");
              paramString.append(localObject[1]);
              str = paramString.toString();
            }
          }
        }
      }
    }
    return str;
  }
  
  public static Uri replaceUriParameter(Uri paramUri, String paramString1, String paramString2)
  {
    Object localObject = paramUri.getQueryParameterNames();
    Uri.Builder localBuilder = paramUri.buildUpon().clearQuery();
    Iterator localIterator = ((Set)localObject).iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      if (str.equals(paramString1)) {
        localObject = paramString2;
      } else {
        localObject = paramUri.getQueryParameter(str);
      }
      localBuilder.appendQueryParameter(str, (String)localObject);
    }
    return localBuilder.build();
  }
  
  public static int rubbishPhoneOffset()
  {
    String str = Build.MODEL;
    if ((!"M040".equals(str)) && (!"MX4".equals(str)) && (!"m2 note".equals(str))) {
      return 0;
    }
    return 1;
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
    localObject = null;
    try
    {
      paramURL = paramURL.getHost();
    }
    catch (Exception paramURL)
    {
      try
      {
        boolean bool;
        paramURL = InetAddress.getByName(paramURL);
        if (paramURL != null) {
          break label31;
        }
        return false;
        if (paramURL.isAnyLocalAddress()) {
          break label60;
        }
        if (!paramURL.isLoopbackAddress()) {
          break label47;
        }
        return true;
        try
        {
          paramURL = NetworkInterface.getByInetAddress(paramURL);
          if (paramURL != null) {
            bool = true;
          }
          return bool;
        }
        catch (SocketException paramURL) {}
        return true;
        paramURL = paramURL;
      }
      catch (UnknownHostException paramURL)
      {
        for (;;)
        {
          paramURL = localObject;
        }
      }
    }
    paramURL = null;
    bool = false;
    return paramURL != null;
  }
  
  public static List<String> splitEqually(String paramString, int paramInt)
  {
    ArrayList localArrayList = new ArrayList((paramString.length() + paramInt - 1) / paramInt);
    int j;
    for (int i = 0; i < paramString.length(); i = j)
    {
      int k = paramString.length();
      j = i + paramInt;
      localArrayList.add(paramString.substring(i, Math.min(k, j)));
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
    Object localObject = paramString;
    if (!TextUtils.isEmpty(paramString))
    {
      localObject = paramString;
      if (paramString.startsWith("/"))
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("file://");
        ((StringBuilder)localObject).append(paramString);
        localObject = ((StringBuilder)localObject).toString();
      }
    }
    return localObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.oskplayer.util.PlayerUtils
 * JD-Core Version:    0.7.0.1
 */