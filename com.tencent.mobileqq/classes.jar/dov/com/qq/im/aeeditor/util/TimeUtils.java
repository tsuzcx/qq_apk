package dov.com.qq.im.aeeditor.util;

import android.support.annotation.NonNull;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Locale;

public class TimeUtils
{
  public static final DateFormat a = new SimpleDateFormat("mm:ss", Locale.CHINA);
  
  public static long a(long paramLong)
  {
    return Math.max(paramLong, 0L);
  }
  
  public static String a(long paramLong)
  {
    int m = 0;
    paramLong = a(paramLong);
    String str4 = "";
    int j = Math.round((float)(paramLong % 3600000L % 60000L) / 1000.0F);
    int i = (int)(paramLong % 3600000L) / 60000;
    int k = (int)(paramLong / 3600000L);
    if (j == 60)
    {
      i += 1;
      j = 0;
    }
    for (;;)
    {
      if (i == 60)
      {
        k += 1;
        i = m;
      }
      for (;;)
      {
        String str1;
        String str2;
        if (j < 10)
        {
          str1 = "0" + j;
          if (i >= 10) {
            break label239;
          }
          str2 = "0" + i;
          label128:
          if (k >= 10) {
            break label263;
          }
        }
        label263:
        for (String str3 = "0" + k;; str3 = "" + k)
        {
          if (k > 0) {
            str4 = str3 + ":";
          }
          return str4 + str2 + ":" + str1;
          str1 = "" + j;
          break;
          label239:
          str2 = "" + i;
          break label128;
        }
      }
    }
  }
  
  public static String a(@NonNull DateFormat paramDateFormat, long paramLong)
  {
    return paramDateFormat.format(Long.valueOf(a(paramLong)));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     dov.com.qq.im.aeeditor.util.TimeUtils
 * JD-Core Version:    0.7.0.1
 */