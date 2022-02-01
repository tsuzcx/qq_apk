package org.apache.commons.lang.time;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.TimeZone;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.text.StrBuilder;

public class DurationFormatUtils
{
  static final Object H;
  public static final String ISO_EXTENDED_FORMAT_PATTERN = "'P'yyyy'Y'M'M'd'DT'H'H'm'M's.S'S'";
  static final Object M;
  static final Object S = "S";
  static final Object d;
  static final Object m;
  static final Object s;
  static final Object y = "y";
  
  static
  {
    M = "M";
    d = "d";
    H = "H";
    m = "m";
    s = "s";
  }
  
  static String format(DurationFormatUtils.Token[] paramArrayOfToken, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, boolean paramBoolean)
  {
    StrBuilder localStrBuilder = new StrBuilder();
    int i1 = paramArrayOfToken.length;
    int j = 0;
    int k = 0;
    while (j < i1)
    {
      Object localObject1 = paramArrayOfToken[j];
      Object localObject2 = ((DurationFormatUtils.Token)localObject1).getValue();
      int i2 = ((DurationFormatUtils.Token)localObject1).getCount();
      int i;
      int n;
      if ((localObject2 instanceof StringBuffer))
      {
        localStrBuilder.append(localObject2.toString());
        i = k;
        n = paramInt7;
      }
      else
      {
        if (localObject2 == y)
        {
          if (paramBoolean) {
            localObject1 = StringUtils.leftPad(Integer.toString(paramInt1), i2, '0');
          } else {
            localObject1 = Integer.toString(paramInt1);
          }
          localStrBuilder.append((String)localObject1);
        }
        for (;;)
        {
          i = 0;
          n = paramInt7;
          break;
          if (localObject2 == M)
          {
            if (paramBoolean) {
              localObject1 = StringUtils.leftPad(Integer.toString(paramInt2), i2, '0');
            } else {
              localObject1 = Integer.toString(paramInt2);
            }
            localStrBuilder.append((String)localObject1);
          }
          else if (localObject2 == d)
          {
            if (paramBoolean) {
              localObject1 = StringUtils.leftPad(Integer.toString(paramInt3), i2, '0');
            } else {
              localObject1 = Integer.toString(paramInt3);
            }
            localStrBuilder.append((String)localObject1);
          }
          else if (localObject2 == H)
          {
            if (paramBoolean) {
              localObject1 = StringUtils.leftPad(Integer.toString(paramInt4), i2, '0');
            } else {
              localObject1 = Integer.toString(paramInt4);
            }
            localStrBuilder.append((String)localObject1);
          }
          else if (localObject2 == m)
          {
            if (paramBoolean) {
              localObject1 = StringUtils.leftPad(Integer.toString(paramInt5), i2, '0');
            } else {
              localObject1 = Integer.toString(paramInt5);
            }
            localStrBuilder.append((String)localObject1);
          }
          else
          {
            if (localObject2 == s)
            {
              if (paramBoolean) {
                localObject1 = StringUtils.leftPad(Integer.toString(paramInt6), i2, '0');
              } else {
                localObject1 = Integer.toString(paramInt6);
              }
              localStrBuilder.append((String)localObject1);
              i = 1;
              n = paramInt7;
              break;
            }
            i = k;
            n = paramInt7;
            if (localObject2 != S) {
              break;
            }
            if (k != 0)
            {
              paramInt7 += 1000;
              if (paramBoolean) {
                localObject1 = StringUtils.leftPad(Integer.toString(paramInt7), i2, '0');
              } else {
                localObject1 = Integer.toString(paramInt7);
              }
              localStrBuilder.append(((String)localObject1).substring(1));
            }
            else
            {
              if (paramBoolean) {
                localObject1 = StringUtils.leftPad(Integer.toString(paramInt7), i2, '0');
              } else {
                localObject1 = Integer.toString(paramInt7);
              }
              localStrBuilder.append((String)localObject1);
            }
          }
        }
      }
      j += 1;
      k = i;
      paramInt7 = n;
    }
    return localStrBuilder.toString();
  }
  
  public static String formatDuration(long paramLong, String paramString)
  {
    return formatDuration(paramLong, paramString, true);
  }
  
  public static String formatDuration(long paramLong, String paramString, boolean paramBoolean)
  {
    paramString = lexx(paramString);
    int i;
    if (DurationFormatUtils.Token.containsTokenWithValue(paramString, d))
    {
      i = (int)(paramLong / 86400000L);
      paramLong -= i * 86400000L;
    }
    else
    {
      i = 0;
    }
    int j;
    if (DurationFormatUtils.Token.containsTokenWithValue(paramString, H))
    {
      j = (int)(paramLong / 3600000L);
      paramLong -= j * 3600000L;
    }
    else
    {
      j = 0;
    }
    int k;
    if (DurationFormatUtils.Token.containsTokenWithValue(paramString, m))
    {
      k = (int)(paramLong / 60000L);
      paramLong -= k * 60000L;
    }
    else
    {
      k = 0;
    }
    int n;
    if (DurationFormatUtils.Token.containsTokenWithValue(paramString, s))
    {
      n = (int)(paramLong / 1000L);
      paramLong -= n * 1000L;
    }
    else
    {
      n = 0;
    }
    int i1;
    if (DurationFormatUtils.Token.containsTokenWithValue(paramString, S)) {
      i1 = (int)paramLong;
    } else {
      i1 = 0;
    }
    return format(paramString, 0, 0, i, j, k, n, i1, paramBoolean);
  }
  
  public static String formatDurationHMS(long paramLong)
  {
    return formatDuration(paramLong, "H:mm:ss.SSS");
  }
  
  public static String formatDurationISO(long paramLong)
  {
    return formatDuration(paramLong, "'P'yyyy'Y'M'M'd'DT'H'H'm'M's.S'S'", false);
  }
  
  public static String formatDurationWords(long paramLong, boolean paramBoolean1, boolean paramBoolean2)
  {
    Object localObject1 = formatDuration(paramLong, "d' days 'H' hours 'm' minutes 's' seconds'");
    Object localObject2 = localObject1;
    String str;
    if (paramBoolean1)
    {
      localObject2 = new StringBuffer();
      ((StringBuffer)localObject2).append(" ");
      ((StringBuffer)localObject2).append((String)localObject1);
      str = ((StringBuffer)localObject2).toString();
      localObject2 = StringUtils.replaceOnce(str, " 0 days", "");
      localObject1 = str;
      if (((String)localObject2).length() != str.length())
      {
        localObject1 = StringUtils.replaceOnce((String)localObject2, " 0 hours", "");
        if (((String)localObject1).length() != ((String)localObject2).length())
        {
          localObject2 = StringUtils.replaceOnce((String)localObject1, " 0 minutes", "");
          localObject1 = localObject2;
          if (((String)localObject2).length() != ((String)localObject2).length()) {
            localObject1 = StringUtils.replaceOnce((String)localObject2, " 0 seconds", "");
          }
        }
        else
        {
          localObject1 = localObject2;
        }
      }
      localObject2 = localObject1;
      if (((String)localObject1).length() != 0) {
        localObject2 = ((String)localObject1).substring(1);
      }
    }
    localObject1 = localObject2;
    if (paramBoolean2)
    {
      str = StringUtils.replaceOnce((String)localObject2, " 0 seconds", "");
      localObject1 = localObject2;
      if (str.length() != ((String)localObject2).length())
      {
        localObject2 = StringUtils.replaceOnce(str, " 0 minutes", "");
        if (((String)localObject2).length() != str.length())
        {
          str = StringUtils.replaceOnce((String)localObject2, " 0 hours", "");
          localObject1 = localObject2;
          if (str.length() != ((String)localObject2).length()) {
            localObject1 = StringUtils.replaceOnce(str, " 0 days", "");
          }
        }
        else
        {
          localObject1 = str;
        }
      }
    }
    localObject2 = new StringBuffer();
    ((StringBuffer)localObject2).append(" ");
    ((StringBuffer)localObject2).append((String)localObject1);
    return StringUtils.replaceOnce(StringUtils.replaceOnce(StringUtils.replaceOnce(StringUtils.replaceOnce(((StringBuffer)localObject2).toString(), " 1 seconds", " 1 second"), " 1 minutes", " 1 minute"), " 1 hours", " 1 hour"), " 1 days", " 1 day").trim();
  }
  
  public static String formatPeriod(long paramLong1, long paramLong2, String paramString)
  {
    return formatPeriod(paramLong1, paramLong2, paramString, true, TimeZone.getDefault());
  }
  
  public static String formatPeriod(long paramLong1, long paramLong2, String paramString, boolean paramBoolean, TimeZone paramTimeZone)
  {
    paramString = lexx(paramString);
    Calendar localCalendar = Calendar.getInstance(paramTimeZone);
    localCalendar.setTime(new Date(paramLong1));
    paramTimeZone = Calendar.getInstance(paramTimeZone);
    paramTimeZone.setTime(new Date(paramLong2));
    int k = paramTimeZone.get(14) - localCalendar.get(14);
    int j = paramTimeZone.get(13) - localCalendar.get(13);
    int i1 = paramTimeZone.get(12) - localCalendar.get(12);
    int i2 = paramTimeZone.get(11) - localCalendar.get(11);
    int i3 = paramTimeZone.get(5) - localCalendar.get(5);
    int i4 = paramTimeZone.get(2) - localCalendar.get(2);
    int i5 = paramTimeZone.get(1) - localCalendar.get(1);
    int n;
    for (;;)
    {
      n = j;
      i = i1;
      if (k >= 0) {
        break;
      }
      k += 1000;
      j -= 1;
    }
    for (;;)
    {
      i1 = i;
      j = i2;
      if (n >= 0) {
        break;
      }
      n += 60;
      i -= 1;
    }
    for (;;)
    {
      i2 = j;
      i = i3;
      if (i1 >= 0) {
        break;
      }
      i1 += 60;
      j -= 1;
    }
    while (i2 < 0)
    {
      i2 += 24;
      i -= 1;
    }
    boolean bool = DurationFormatUtils.Token.containsTokenWithValue(paramString, M);
    int i7 = 0;
    int i6;
    if (bool)
    {
      i3 = i;
      for (;;)
      {
        i = i4;
        j = i5;
        if (i3 >= 0) {
          break;
        }
        i3 += localCalendar.getActualMaximum(5);
        i4 -= 1;
        localCalendar.add(2, 1);
      }
      while (i < 0)
      {
        i += 12;
        j -= 1;
      }
      i5 = i;
      i4 = j;
      if (!DurationFormatUtils.Token.containsTokenWithValue(paramString, y))
      {
        i5 = i;
        i4 = j;
        if (j != 0) {
          for (;;)
          {
            i5 = i;
            i4 = j;
            if (j == 0) {
              break;
            }
            i += j * 12;
            j = 0;
          }
        }
      }
      i6 = i5;
      i5 = i4;
      i = i3;
    }
    else
    {
      j = i;
      i3 = i5;
      if (!DurationFormatUtils.Token.containsTokenWithValue(paramString, y))
      {
        i5 = paramTimeZone.get(1);
        j = i;
        i3 = i5;
        if (i4 < 0) {
          i3 = i5 - 1;
        }
        for (j = i; localCalendar.get(1) != i3; j = i + localCalendar.get(6))
        {
          j += localCalendar.getActualMaximum(6) - localCalendar.get(6);
          i = j;
          if ((localCalendar instanceof GregorianCalendar))
          {
            i = j;
            if (localCalendar.get(2) == 1)
            {
              i = j;
              if (localCalendar.get(5) == 29) {
                i = j + 1;
              }
            }
          }
          localCalendar.add(1, 1);
        }
        i3 = 0;
      }
      while (localCalendar.get(2) != paramTimeZone.get(2))
      {
        j += localCalendar.getActualMaximum(5);
        localCalendar.add(2, 1);
      }
      i = 0;
      i4 = j;
      j = i;
      for (;;)
      {
        i6 = j;
        i = i4;
        i5 = i3;
        if (i4 >= 0) {
          break;
        }
        i4 += localCalendar.getActualMaximum(5);
        j -= 1;
        localCalendar.add(2, 1);
      }
    }
    if (!DurationFormatUtils.Token.containsTokenWithValue(paramString, d))
    {
      i2 += i * 24;
      i3 = 0;
    }
    else
    {
      i3 = i;
    }
    int i = i1;
    i4 = i2;
    if (!DurationFormatUtils.Token.containsTokenWithValue(paramString, H))
    {
      i = i1 + i2 * 60;
      i4 = 0;
    }
    j = n;
    i1 = i;
    if (!DurationFormatUtils.Token.containsTokenWithValue(paramString, m))
    {
      j = n + i * 60;
      i1 = 0;
    }
    if (!DurationFormatUtils.Token.containsTokenWithValue(paramString, s))
    {
      k += j * 1000;
      i = i7;
    }
    else
    {
      i = j;
    }
    return format(paramString, i5, i6, i3, i4, i1, i, k, paramBoolean);
  }
  
  public static String formatPeriodISO(long paramLong1, long paramLong2)
  {
    return formatPeriod(paramLong1, paramLong2, "'P'yyyy'Y'M'M'd'DT'H'H'm'M's.S'S'", false, TimeZone.getDefault());
  }
  
  static DurationFormatUtils.Token[] lexx(String paramString)
  {
    char[] arrayOfChar = paramString.toCharArray();
    ArrayList localArrayList = new ArrayList(arrayOfChar.length);
    int n = arrayOfChar.length;
    Object localObject1 = null;
    Object localObject2 = localObject1;
    int j = 0;
    int i = 0;
    while (j < n)
    {
      char c = arrayOfChar[j];
      int k;
      Object localObject3;
      if ((i != 0) && (c != '\''))
      {
        ((StringBuffer)localObject1).append(c);
        k = i;
        localObject3 = localObject2;
      }
      else
      {
        if (c != '\'')
        {
          if (c != 'H')
          {
            if (c != 'M')
            {
              if (c != 'S')
              {
                if (c != 'd')
                {
                  if (c != 'm')
                  {
                    if (c != 's')
                    {
                      if (c != 'y')
                      {
                        paramString = (String)localObject1;
                        if (localObject1 == null)
                        {
                          paramString = new StringBuffer();
                          localArrayList.add(new DurationFormatUtils.Token(paramString));
                        }
                        paramString.append(c);
                        localObject3 = null;
                        localObject1 = paramString;
                        paramString = localObject3;
                      }
                      else
                      {
                        paramString = y;
                      }
                    }
                    else {
                      paramString = s;
                    }
                  }
                  else {
                    paramString = m;
                  }
                }
                else {
                  paramString = d;
                }
              }
              else {
                paramString = S;
              }
            }
            else {
              paramString = M;
            }
          }
          else {
            paramString = H;
          }
        }
        else if (i != 0)
        {
          localObject1 = null;
          paramString = (String)localObject1;
          i = 0;
        }
        else
        {
          localObject1 = new StringBuffer();
          localArrayList.add(new DurationFormatUtils.Token(localObject1));
          paramString = null;
          i = 1;
        }
        k = i;
        localObject3 = localObject2;
        if (paramString != null)
        {
          if ((localObject2 != null) && (((DurationFormatUtils.Token)localObject2).getValue() == paramString))
          {
            ((DurationFormatUtils.Token)localObject2).increment();
          }
          else
          {
            localObject2 = new DurationFormatUtils.Token(paramString);
            localArrayList.add(localObject2);
          }
          localObject1 = null;
          localObject3 = localObject2;
          k = i;
        }
      }
      j += 1;
      i = k;
      localObject2 = localObject3;
    }
    return (DurationFormatUtils.Token[])localArrayList.toArray(new DurationFormatUtils.Token[localArrayList.size()]);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     org.apache.commons.lang.time.DurationFormatUtils
 * JD-Core Version:    0.7.0.1
 */