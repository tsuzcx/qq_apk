package com.tencent.youtu.sdkkitframework.common;

import android.util.Base64;
import java.util.Random;
import java.util.concurrent.ConcurrentHashMap;
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;

public class CommonUtils
{
  public static final int MAX_TIMEOUT_MS = 20000;
  public static final int MIN_TIMEOUT_MS = 0;
  private static final String TAG = "CommonUtils";
  private static ConcurrentHashMap<String, CommonUtils.BenchMarkTime> benchMarkMaps = new ConcurrentHashMap();
  
  public static void benchMarkBegin(String paramString)
  {
    if (!benchMarkMaps.containsKey(paramString)) {
      benchMarkMaps.put(paramString, new CommonUtils.BenchMarkTime());
    }
    ((CommonUtils.BenchMarkTime)benchMarkMaps.get(paramString)).begin();
  }
  
  public static long benchMarkEnd(String paramString)
  {
    if (!benchMarkMaps.containsKey(paramString)) {
      return 0L;
    }
    CommonUtils.BenchMarkTime localBenchMarkTime = (CommonUtils.BenchMarkTime)benchMarkMaps.get(paramString);
    localBenchMarkTime.end();
    YtLogger.d("CommonUtils", "benchMarkEnd -- " + paramString + " : " + localBenchMarkTime.cur);
    return localBenchMarkTime.cur;
  }
  
  public static String getBenchMarkTime(String paramString)
  {
    if (!benchMarkMaps.containsKey(paramString)) {
      return "";
    }
    return "[" + paramString + "]" + ((CommonUtils.BenchMarkTime)benchMarkMaps.get(paramString)).getTime();
  }
  
  private static byte[] getSignature(String paramString1, String paramString2)
  {
    Mac localMac = Mac.getInstance("HmacSHA1");
    localMac.init(new SecretKeySpec(paramString2.getBytes(), localMac.getAlgorithm()));
    return localMac.doFinal(paramString1.getBytes());
  }
  
  public static String getYoutuOpenAppSign(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    long l = System.currentTimeMillis() / 1000L;
    int i = Math.abs(new Random().nextInt());
    paramString1 = "a=" + paramString1 + "&k=" + paramString2 + "&e=" + (2592000L + l) + "&t=" + l + "&r=" + i + "&u=" + paramString4 + "&f=";
    paramString2 = getSignature(paramString1, paramString3);
    paramString3 = new byte[paramString2.length + paramString1.getBytes().length];
    System.arraycopy(paramString2, 0, paramString3, 0, paramString2.length);
    System.arraycopy(paramString1.getBytes(), 0, paramString3, paramString2.length, paramString1.getBytes().length);
    return new String(Base64.encode(paramString3, 2));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.youtu.sdkkitframework.common.CommonUtils
 * JD-Core Version:    0.7.0.1
 */