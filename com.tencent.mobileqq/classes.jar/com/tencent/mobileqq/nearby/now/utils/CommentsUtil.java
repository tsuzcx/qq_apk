package com.tencent.mobileqq.nearby.now.utils;

import android.content.SharedPreferences;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.statistics.ReportController;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class CommentsUtil
{
  public static int a(CharSequence paramCharSequence)
  {
    int i = 0;
    if (paramCharSequence == null) {
      return 0;
    }
    int m = paramCharSequence.length();
    int j = 0;
    while (i < m)
    {
      int k;
      if (paramCharSequence.charAt(i) < '') {
        k = 1;
      } else {
        k = 2;
      }
      j += k;
      i += 1;
    }
    return j;
  }
  
  public static int a(String paramString)
  {
    int j = 0;
    if (paramString == null) {
      return 0;
    }
    int i = 0;
    while (j < paramString.length())
    {
      if (a(paramString.charAt(j))) {
        i += 2;
      } else {
        i += 1;
      }
      j += 1;
    }
    return i;
  }
  
  public static CharSequence a(CharSequence paramCharSequence, int paramInt1, int paramInt2)
  {
    int m = paramCharSequence.length();
    int i = paramInt1;
    int j = 0;
    while (i < m)
    {
      int k;
      if (paramCharSequence.charAt(i) < '') {
        k = 1;
      } else {
        k = 2;
      }
      j += k;
      if (j > paramInt2)
      {
        paramInt2 = i;
        if (i > 0)
        {
          paramInt2 = i;
          if (Character.isHighSurrogate(paramCharSequence.charAt(i - 1))) {
            paramInt2 = i - 1;
          }
        }
        return paramCharSequence.subSequence(paramInt1, paramInt2);
      }
      i += 1;
    }
    return paramCharSequence;
  }
  
  private static String a(int paramInt1, int paramInt2)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    Object localObject;
    if (paramInt1 < 10)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("0");
      ((StringBuilder)localObject).append(paramInt1);
      localObject = ((StringBuilder)localObject).toString();
    }
    else
    {
      localObject = String.valueOf(paramInt1);
    }
    localStringBuilder.append((String)localObject);
    localStringBuilder.append(":");
    if (paramInt2 < 10)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("0");
      ((StringBuilder)localObject).append(paramInt2);
      localObject = ((StringBuilder)localObject).toString();
    }
    else
    {
      localObject = String.valueOf(paramInt2);
    }
    localStringBuilder.append((String)localObject);
    return localStringBuilder.toString();
  }
  
  public static String a(long paramLong)
  {
    paramLong = System.currentTimeMillis() - paramLong;
    if (paramLong < 3600000L)
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramLong / 60L / 1000L + 1L);
      localStringBuilder.append(HardCodeUtil.a(2131702394));
      return localStringBuilder.toString();
    }
    if (paramLong < 86400000L)
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramLong / 60L / 60L / 1000L);
      localStringBuilder.append(HardCodeUtil.a(2131702401));
      return localStringBuilder.toString();
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramLong / 24L / 60L / 60L / 1000L);
    localStringBuilder.append(HardCodeUtil.a(2131702393));
    return localStringBuilder.toString();
  }
  
  public static String a(byte[] paramArrayOfByte)
  {
    if ((paramArrayOfByte != null) && (paramArrayOfByte.length > 0))
    {
      StringBuilder localStringBuilder = new StringBuilder(paramArrayOfByte.length * 2);
      int i = 0;
      while (i < paramArrayOfByte.length)
      {
        localStringBuilder.append(String.format("%02x", new Object[] { Integer.valueOf(paramArrayOfByte[i] & 0xFF) }));
        i += 1;
      }
      return localStringBuilder.toString();
    }
    return "";
  }
  
  public static void a(QQAppInterface paramQQAppInterface, String paramString)
  {
    a(paramQQAppInterface, paramString, "");
  }
  
  public static void a(QQAppInterface paramQQAppInterface, String paramString1, String paramString2)
  {
    if (paramString1 != null)
    {
      if (paramString1.isEmpty()) {
        return;
      }
      Object localObject1 = BaseApplicationImpl.getApplication();
      Object localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("self_info");
      ((StringBuilder)localObject2).append(paramQQAppInterface.getCurrentAccountUin());
      paramQQAppInterface = ((BaseApplicationImpl)localObject1).getSharedPreferences(((StringBuilder)localObject2).toString(), 4);
      if (paramQQAppInterface != null)
      {
        int i = paramQQAppInterface.getInt("charm_level", 0);
        int j = paramQQAppInterface.getInt("gender", 0);
        localObject2 = String.valueOf(paramQQAppInterface.getInt("age", 0));
        localObject1 = String.valueOf(i);
        paramQQAppInterface = String.valueOf(j);
      }
      else
      {
        localObject1 = "";
        paramQQAppInterface = (QQAppInterface)localObject1;
        localObject2 = paramQQAppInterface;
      }
      ReportController.b(null, "dc02676", "grp_lbs", "", "video", paramString1, 0, 0, (String)localObject1, paramQQAppInterface, (String)localObject2, paramString2);
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("|");
    localStringBuilder.append(paramString2);
    localStringBuilder.append("|");
    localStringBuilder.append(paramString3);
    localStringBuilder.append("|");
    localStringBuilder.append(paramString4);
    localStringBuilder.append("|");
    localStringBuilder.append(paramString5);
    localStringBuilder.append("|");
    localStringBuilder.append(paramString6);
    a(paramQQAppInterface, paramString1, localStringBuilder.toString());
  }
  
  public static boolean a(char paramChar)
  {
    return (paramChar >= 'ÿ') || (paramChar < 0);
  }
  
  public static String b(long paramLong)
  {
    Calendar localCalendar1 = Calendar.getInstance();
    Date localDate = new Date(paramLong);
    localCalendar1.setTime(localDate);
    Calendar localCalendar2 = Calendar.getInstance();
    localCalendar2.setTimeInMillis(System.currentTimeMillis());
    if ((localCalendar1.get(1) == localCalendar2.get(1)) && (localCalendar1.get(6) == localCalendar2.get(6))) {
      return a(localCalendar1.get(11), localCalendar1.get(12));
    }
    if ((localCalendar1.get(1) == localCalendar2.get(1)) && (localCalendar1.get(6) + 1 == localCalendar2.get(6))) {
      return HardCodeUtil.a(2131702391);
    }
    if ((localCalendar1.get(1) == localCalendar2.get(1)) && (localCalendar1.get(6) > localCalendar2.get(6) - 7)) {
      switch (localCalendar1.get(7))
      {
      default: 
        break;
      case 7: 
        return HardCodeUtil.a(2131702397);
      case 6: 
        return HardCodeUtil.a(2131702392);
      case 5: 
        return HardCodeUtil.a(2131702398);
      case 4: 
        return HardCodeUtil.a(2131702400);
      case 3: 
        return HardCodeUtil.a(2131702395);
      case 2: 
        return HardCodeUtil.a(2131702396);
      case 1: 
        return HardCodeUtil.a(2131702399);
      }
    }
    return new SimpleDateFormat("yy/MM/dd").format(localDate);
  }
  
  public static String c(long paramLong)
  {
    if (paramLong < 10000L) {
      return Long.toString(paramLong);
    }
    if (paramLong > 100000L) {
      return "9.9万+";
    }
    double d = paramLong;
    Double.isNaN(d);
    return String.format("%.1f万", new Object[] { Double.valueOf(d / 10000.0D) });
  }
  
  public static String d(long paramLong)
  {
    if (paramLong < 10000L) {
      return Long.toString(paramLong);
    }
    if ((paramLong > 10000L) && (paramLong < 10000000L))
    {
      double d = paramLong;
      Double.isNaN(d);
      return String.format("%.1f万", new Object[] { Double.valueOf(d / 10000.0D) });
    }
    return String.format("%d千万", new Object[] { Long.valueOf(paramLong / 10000000L) });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.now.utils.CommentsUtil
 * JD-Core Version:    0.7.0.1
 */