package com.tencent.qqlive.tvkplayer.vinfo.ckey.comm;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Locale;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Properties;
import java.util.Set;

public class VsUtils
{
  static final String dataFmStr = "yyyy-MM-dd HH:mm:ss";
  static final String onlyDayFmStr = "yyyy-MM-dd";
  
  public static byte[] decodeDatasByUnZipAndUnEncry(byte[] paramArrayOfByte, int paramInt1, int paramInt2, String paramString)
  {
    try
    {
      paramArrayOfByte = unzipDatas(unencryDatas(paramArrayOfByte, paramInt2, paramString), paramInt1);
      return paramArrayOfByte;
    }
    catch (Exception paramArrayOfByte)
    {
      VsLog.printStackTrace(paramArrayOfByte);
    }
    return null;
  }
  
  public static byte[] encodeDatasByZipAndEncry(byte[] paramArrayOfByte, int paramInt1, int paramInt2, String paramString)
  {
    if (paramArrayOfByte == null) {
      return null;
    }
    try
    {
      paramArrayOfByte = encryDatas(zipDatas(paramArrayOfByte, paramInt1), paramInt2, paramString);
      return paramArrayOfByte;
    }
    catch (Throwable paramArrayOfByte)
    {
      VsLog.printStackTrace(paramArrayOfByte);
    }
    return null;
  }
  
  public static byte[] encryDatas(byte[] paramArrayOfByte, int paramInt, String paramString)
  {
    if ((paramArrayOfByte == null) || (paramInt != 3)) {
      return paramArrayOfByte;
    }
    int i = paramString.length();
    while (i < 16)
    {
      paramString = paramString + "0";
      i += 1;
    }
    paramString = paramString.substring(0, 16);
    VsLog.debug("enD:} %d %d", new Object[] { Integer.valueOf(paramArrayOfByte.length), Integer.valueOf(paramInt) });
    try
    {
      paramArrayOfByte = VsEncryptUtil.VsAesEncrypt(paramString, paramArrayOfByte);
      return paramArrayOfByte;
    }
    catch (Throwable paramArrayOfByte)
    {
      VsLog.printStackTrace(paramArrayOfByte);
      VsLog.error("err enD: %s", new Object[] { paramArrayOfByte.toString() });
    }
    return null;
  }
  
  public static String getTime()
  {
    return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.US).format(new Date());
  }
  
  public static String getToday()
  {
    try
    {
      String str = new SimpleDateFormat("yyyy-MM-dd", Locale.US).format(new Date());
      return str;
    }
    catch (Throwable localThrowable)
    {
      VsLog.printStackTrace(localThrowable);
    }
    return "";
  }
  
  public static long getTodayTimes()
  {
    try
    {
      SimpleDateFormat localSimpleDateFormat = new SimpleDateFormat("yyyy-MM-dd", Locale.US);
      long l = localSimpleDateFormat.parse(localSimpleDateFormat.format(new Date())).getTime();
      return l;
    }
    catch (Throwable localThrowable)
    {
      VsLog.printStackTrace(localThrowable);
    }
    return -1L;
  }
  
  public static long parseCurrentToServerTime(long paramLong)
  {
    return new Date().getTime() + paramLong;
  }
  
  public static Date parseToDate(String paramString)
  {
    if ((paramString == null) || (paramString.trim().length() <= 0)) {
      return null;
    }
    try
    {
      paramString = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.US).parse(paramString);
      return paramString;
    }
    catch (ParseException paramString)
    {
      VsLog.printStackTrace(paramString);
    }
    return null;
  }
  
  private static Map<String, String> propertyToMap(Properties paramProperties)
  {
    HashMap localHashMap = new HashMap();
    paramProperties = paramProperties.entrySet().iterator();
    while (paramProperties.hasNext())
    {
      Object localObject2 = (Map.Entry)paramProperties.next();
      Object localObject1 = ((Map.Entry)localObject2).getKey();
      localObject2 = ((Map.Entry)localObject2).getValue();
      if (localObject2 == null) {
        localHashMap.put(localObject1.toString(), "");
      } else {
        localHashMap.put(localObject1.toString(), localObject2.toString());
      }
    }
    return localHashMap;
  }
  
  public static byte[] unencryDatas(byte[] paramArrayOfByte, int paramInt, String paramString)
  {
    if ((paramArrayOfByte == null) || (paramInt != 3)) {
      return paramArrayOfByte;
    }
    paramInt = paramString.length();
    while (paramInt < 16)
    {
      paramString = paramString + "0";
      paramInt += 1;
    }
    paramString = paramString.substring(0, 16);
    try
    {
      paramArrayOfByte = VsEncryptUtil.VsAesDecrypt(paramString, paramArrayOfByte);
      return paramArrayOfByte;
    }
    catch (Throwable paramArrayOfByte)
    {
      VsLog.printStackTrace(paramArrayOfByte);
      VsLog.error("err unD: %s", new Object[] { paramArrayOfByte.toString() });
    }
    return null;
  }
  
  public static byte[] unzipDatas(byte[] paramArrayOfByte, int paramInt)
  {
    if ((paramArrayOfByte == null) || (paramInt == -1)) {
      return paramArrayOfByte;
    }
    VsLog.debug("unzp: %s len: %s", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(paramArrayOfByte.length) });
    try
    {
      paramArrayOfByte = CompressUtil.uncompress(paramInt, paramArrayOfByte);
      return paramArrayOfByte;
    }
    catch (Throwable paramArrayOfByte)
    {
      VsLog.printStackTrace(paramArrayOfByte);
      VsLog.error("err unzp}" + paramArrayOfByte.toString(), new Object[0]);
    }
    return null;
  }
  
  public static byte[] zipDatas(byte[] paramArrayOfByte, int paramInt)
  {
    if ((paramArrayOfByte == null) || (paramInt == -1)) {
      return paramArrayOfByte;
    }
    VsLog.debug("zp: %s len: %s", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(paramArrayOfByte.length) });
    try
    {
      paramArrayOfByte = CompressUtil.compress(paramInt, paramArrayOfByte);
      return paramArrayOfByte;
    }
    catch (Throwable paramArrayOfByte)
    {
      VsLog.printStackTrace(paramArrayOfByte);
      VsLog.error("err zp : %s", new Object[] { paramArrayOfByte.toString() });
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.qqlive.tvkplayer.vinfo.ckey.comm.VsUtils
 * JD-Core Version:    0.7.0.1
 */