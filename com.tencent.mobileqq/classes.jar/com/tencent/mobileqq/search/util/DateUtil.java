package com.tencent.mobileqq.search.util;

import com.tencent.mobileqq.app.HardCodeUtil;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

public class DateUtil
{
  public static final String a = HardCodeUtil.a(2131702837);
  public static final String b = HardCodeUtil.a(2131702864);
  public static final String c = HardCodeUtil.a(2131702836);
  public static final String d = HardCodeUtil.a(2131702835);
  
  public static String a(long paramLong)
  {
    long l = System.currentTimeMillis() / 1000L - paramLong;
    if ((l >= 0L) && (l < 60L)) {
      return a;
    }
    if ((l >= 60L) && (l < 3600L)) {
      return l / 60L + b;
    }
    if ((l >= 3600L) && (l < 86400L)) {
      return l / 3600L + c;
    }
    if ((l >= 86400L) && (l < 432000L)) {
      return l / 86400L + d;
    }
    return new SimpleDateFormat("yyyy-MM-dd").format(Long.valueOf(paramLong * 1000L));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.search.util.DateUtil
 * JD-Core Version:    0.7.0.1
 */