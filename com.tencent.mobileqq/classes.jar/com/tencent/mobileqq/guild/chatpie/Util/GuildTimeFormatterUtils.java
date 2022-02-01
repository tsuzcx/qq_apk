package com.tencent.mobileqq.guild.chatpie.Util;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import com.tencent.mobileqq.utils.StringUtil;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class GuildTimeFormatterUtils
{
  private static Calendar a = ;
  private static final String b = GuildTimeFormatterUtils.class.getSimpleName();
  
  private static int a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6)
  {
    GregorianCalendar localGregorianCalendar1 = new GregorianCalendar(paramInt1, paramInt2, paramInt3);
    GregorianCalendar localGregorianCalendar2 = new GregorianCalendar(paramInt4, paramInt5, paramInt6);
    return (int)((localGregorianCalendar1.getTimeInMillis() - localGregorianCalendar2.getTimeInMillis()) / 1000L / 60L / 60L / 24L);
  }
  
  public static String a(Context paramContext, long paramLong)
  {
    a.setTimeInMillis(System.currentTimeMillis());
    int i = a.get(1);
    int k = a.get(2);
    int m = a.get(5);
    a.setTimeInMillis(paramLong);
    int j = a.get(1);
    k = a(i, k, m, j, a.get(2), a.get(5));
    StringBuilder localStringBuilder = new StringBuilder();
    if (k != 0) {
      if (k == 1) {
        localStringBuilder.append(paramContext.getString(2131897736));
      } else if (i == j) {
        localStringBuilder.append(new SimpleDateFormat("MM-dd", paramContext.getResources().getConfiguration().locale).format(new Date(paramLong)));
      } else {
        localStringBuilder.append(new SimpleDateFormat("yyyy-MM-dd", paramContext.getResources().getConfiguration().locale).format(new Date(paramLong)));
      }
    }
    if (!StringUtil.isEmpty(localStringBuilder.toString())) {
      localStringBuilder.append(" ");
    }
    localStringBuilder.append(new SimpleDateFormat("HH:mm", paramContext.getResources().getConfiguration().locale).format(new Date(paramLong)));
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.guild.chatpie.Util.GuildTimeFormatterUtils
 * JD-Core Version:    0.7.0.1
 */