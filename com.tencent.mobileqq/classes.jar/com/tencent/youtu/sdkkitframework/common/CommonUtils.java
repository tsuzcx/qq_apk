package com.tencent.youtu.sdkkitframework.common;

import android.util.Base64;
import com.tencent.youtu.sdkkitframework.framework.YtFSM;
import java.util.Random;
import java.util.concurrent.ConcurrentHashMap;
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import org.json.JSONObject;

public class CommonUtils
{
  public static final int MAX_TIMEOUT_MS = 30000;
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
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("benchMarkEnd -- ");
    localStringBuilder.append(paramString);
    localStringBuilder.append(" : ");
    localStringBuilder.append(localBenchMarkTime.cur);
    localStringBuilder.append("ms");
    YtLogger.d("CommonUtils", localStringBuilder.toString());
    return localBenchMarkTime.cur;
  }
  
  public static String getBenchMarkTime(String paramString)
  {
    if (!benchMarkMaps.containsKey(paramString)) {
      return "";
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("[");
    localStringBuilder.append(paramString);
    localStringBuilder.append("]");
    localStringBuilder.append(((CommonUtils.BenchMarkTime)benchMarkMaps.get(paramString)).getTime());
    return localStringBuilder.toString();
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
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("a=");
    localStringBuilder.append(paramString1);
    localStringBuilder.append("&k=");
    localStringBuilder.append(paramString2);
    localStringBuilder.append("&e=");
    localStringBuilder.append(2592000L + l);
    localStringBuilder.append("&t=");
    localStringBuilder.append(l);
    localStringBuilder.append("&r=");
    localStringBuilder.append(i);
    localStringBuilder.append("&u=");
    localStringBuilder.append(paramString4);
    localStringBuilder.append("&f=");
    paramString1 = localStringBuilder.toString();
    paramString2 = getSignature(paramString1, paramString3);
    paramString3 = new byte[paramString2.length + paramString1.getBytes().length];
    System.arraycopy(paramString2, 0, paramString3, 0, paramString2.length);
    System.arraycopy(paramString1.getBytes(), 0, paramString3, paramString2.length, paramString1.getBytes().length);
    return new String(Base64.encode(paramString3, 2));
  }
  
  public static String makeMessageJson(int paramInt, String paramString1, String paramString2)
  {
    try
    {
      new JSONObject(paramString2);
      return paramString2;
    }
    catch (Exception localException)
    {
      label11:
      StringBuilder localStringBuilder;
      break label11;
    }
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("{ \"errorcode\":");
    localStringBuilder.append(paramInt);
    localStringBuilder.append(",\"errormsg\": \"");
    localStringBuilder.append(paramString1);
    localStringBuilder.append("\",\"extrainfo\":\"");
    localStringBuilder.append(paramString2);
    localStringBuilder.append("\"}");
    return localStringBuilder.toString();
  }
  
  public static void reportException(String paramString, Exception paramException)
  {
    YtSDKStats localYtSDKStats = YtSDKStats.getInstance();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramString);
    localStringBuilder.append(" cause exception: ");
    localStringBuilder.append(paramException.getLocalizedMessage());
    localYtSDKStats.reportInfo(localStringBuilder.toString());
    YtFSM.getInstance().sendFSMEvent(new CommonUtils.1(paramException));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.youtu.sdkkitframework.common.CommonUtils
 * JD-Core Version:    0.7.0.1
 */