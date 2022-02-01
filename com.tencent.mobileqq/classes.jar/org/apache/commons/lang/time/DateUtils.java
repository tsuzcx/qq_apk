package org.apache.commons.lang.time;

import java.text.ParseException;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.TimeZone;
import org.apache.commons.lang.StringUtils;

public class DateUtils
{
  public static final int MILLIS_IN_DAY = 86400000;
  public static final int MILLIS_IN_HOUR = 3600000;
  public static final int MILLIS_IN_MINUTE = 60000;
  public static final int MILLIS_IN_SECOND = 1000;
  public static final long MILLIS_PER_DAY = 86400000L;
  public static final long MILLIS_PER_HOUR = 3600000L;
  public static final long MILLIS_PER_MINUTE = 60000L;
  public static final long MILLIS_PER_SECOND = 1000L;
  private static final int MODIFY_CEILING = 2;
  private static final int MODIFY_ROUND = 1;
  private static final int MODIFY_TRUNCATE = 0;
  public static final int RANGE_MONTH_MONDAY = 6;
  public static final int RANGE_MONTH_SUNDAY = 5;
  public static final int RANGE_WEEK_CENTER = 4;
  public static final int RANGE_WEEK_MONDAY = 2;
  public static final int RANGE_WEEK_RELATIVE = 3;
  public static final int RANGE_WEEK_SUNDAY = 1;
  public static final int SEMI_MONTH = 1001;
  public static final TimeZone UTC_TIME_ZONE = TimeZone.getTimeZone("GMT");
  private static final int[][] fields;
  
  static
  {
    int[] arrayOfInt1 = { 14 };
    int[] arrayOfInt2 = { 13 };
    int[] arrayOfInt3 = { 12 };
    int[] arrayOfInt4 = { 2, 1001 };
    int[] arrayOfInt5 = { 1 };
    fields = new int[][] { arrayOfInt1, arrayOfInt2, arrayOfInt3, { 11, 10 }, { 5, 5, 9 }, arrayOfInt4, arrayOfInt5, { 0 } };
  }
  
  public static Date add(Date paramDate, int paramInt1, int paramInt2)
  {
    if (paramDate != null)
    {
      Calendar localCalendar = Calendar.getInstance();
      localCalendar.setTime(paramDate);
      localCalendar.add(paramInt1, paramInt2);
      return localCalendar.getTime();
    }
    throw new IllegalArgumentException("The date must not be null");
  }
  
  public static Date addDays(Date paramDate, int paramInt)
  {
    return add(paramDate, 5, paramInt);
  }
  
  public static Date addHours(Date paramDate, int paramInt)
  {
    return add(paramDate, 11, paramInt);
  }
  
  public static Date addMilliseconds(Date paramDate, int paramInt)
  {
    return add(paramDate, 14, paramInt);
  }
  
  public static Date addMinutes(Date paramDate, int paramInt)
  {
    return add(paramDate, 12, paramInt);
  }
  
  public static Date addMonths(Date paramDate, int paramInt)
  {
    return add(paramDate, 2, paramInt);
  }
  
  public static Date addSeconds(Date paramDate, int paramInt)
  {
    return add(paramDate, 13, paramInt);
  }
  
  public static Date addWeeks(Date paramDate, int paramInt)
  {
    return add(paramDate, 3, paramInt);
  }
  
  public static Date addYears(Date paramDate, int paramInt)
  {
    return add(paramDate, 1, paramInt);
  }
  
  public static Calendar ceiling(Calendar paramCalendar, int paramInt)
  {
    if (paramCalendar != null)
    {
      paramCalendar = (Calendar)paramCalendar.clone();
      modify(paramCalendar, paramInt, 2);
      return paramCalendar;
    }
    throw new IllegalArgumentException("The date must not be null");
  }
  
  public static Date ceiling(Object paramObject, int paramInt)
  {
    if (paramObject != null)
    {
      if ((paramObject instanceof Date)) {
        return ceiling((Date)paramObject, paramInt);
      }
      if ((paramObject instanceof Calendar)) {
        return ceiling((Calendar)paramObject, paramInt).getTime();
      }
      StringBuffer localStringBuffer = new StringBuffer();
      localStringBuffer.append("Could not find ceiling of for type: ");
      localStringBuffer.append(paramObject.getClass());
      throw new ClassCastException(localStringBuffer.toString());
    }
    throw new IllegalArgumentException("The date must not be null");
  }
  
  public static Date ceiling(Date paramDate, int paramInt)
  {
    if (paramDate != null)
    {
      Calendar localCalendar = Calendar.getInstance();
      localCalendar.setTime(paramDate);
      modify(localCalendar, paramInt, 2);
      return localCalendar.getTime();
    }
    throw new IllegalArgumentException("The date must not be null");
  }
  
  private static long getFragment(Calendar paramCalendar, int paramInt1, int paramInt2)
  {
    if (paramCalendar != null)
    {
      long l5 = getMillisPerUnit(paramInt2);
      long l1 = 0L;
      if (paramInt1 != 1)
      {
        if (paramInt1 != 2) {
          break label61;
        }
        l1 = paramCalendar.get(5) * 86400000L / l5;
      }
      else
      {
        l1 = paramCalendar.get(6) * 86400000L / l5;
      }
      l1 = 0L + l1;
      label61:
      long l2;
      long l3;
      long l4;
      if ((paramInt1 != 1) && (paramInt1 != 2) && (paramInt1 != 5) && (paramInt1 != 6))
      {
        l2 = l1;
        l3 = l1;
        l4 = l1;
      }
      switch (paramInt1)
      {
      default: 
        paramCalendar = new StringBuffer();
        paramCalendar.append("The fragment ");
        paramCalendar.append(paramInt1);
        paramCalendar.append(" is not supported");
        throw new IllegalArgumentException(paramCalendar.toString());
        l2 = l1 + paramCalendar.get(11) * 3600000L / l5;
      case 11: 
        l3 = l2 + paramCalendar.get(12) * 60000L / l5;
      case 12: 
        l4 = l3 + paramCalendar.get(13) * 1000L / l5;
      case 13: 
        l1 = l4 + paramCalendar.get(14) * 1 / l5;
      }
      return l1;
    }
    throw new IllegalArgumentException("The date must not be null");
  }
  
  private static long getFragment(Date paramDate, int paramInt1, int paramInt2)
  {
    if (paramDate != null)
    {
      Calendar localCalendar = Calendar.getInstance();
      localCalendar.setTime(paramDate);
      return getFragment(localCalendar, paramInt1, paramInt2);
    }
    throw new IllegalArgumentException("The date must not be null");
  }
  
  public static long getFragmentInDays(Calendar paramCalendar, int paramInt)
  {
    return getFragment(paramCalendar, paramInt, 6);
  }
  
  public static long getFragmentInDays(Date paramDate, int paramInt)
  {
    return getFragment(paramDate, paramInt, 6);
  }
  
  public static long getFragmentInHours(Calendar paramCalendar, int paramInt)
  {
    return getFragment(paramCalendar, paramInt, 11);
  }
  
  public static long getFragmentInHours(Date paramDate, int paramInt)
  {
    return getFragment(paramDate, paramInt, 11);
  }
  
  public static long getFragmentInMilliseconds(Calendar paramCalendar, int paramInt)
  {
    return getFragment(paramCalendar, paramInt, 14);
  }
  
  public static long getFragmentInMilliseconds(Date paramDate, int paramInt)
  {
    return getFragment(paramDate, paramInt, 14);
  }
  
  public static long getFragmentInMinutes(Calendar paramCalendar, int paramInt)
  {
    return getFragment(paramCalendar, paramInt, 12);
  }
  
  public static long getFragmentInMinutes(Date paramDate, int paramInt)
  {
    return getFragment(paramDate, paramInt, 12);
  }
  
  public static long getFragmentInSeconds(Calendar paramCalendar, int paramInt)
  {
    return getFragment(paramCalendar, paramInt, 13);
  }
  
  public static long getFragmentInSeconds(Date paramDate, int paramInt)
  {
    return getFragment(paramDate, paramInt, 13);
  }
  
  private static long getMillisPerUnit(int paramInt)
  {
    if ((paramInt != 5) && (paramInt != 6))
    {
      switch (paramInt)
      {
      default: 
        StringBuffer localStringBuffer = new StringBuffer();
        localStringBuffer.append("The unit ");
        localStringBuffer.append(paramInt);
        localStringBuffer.append(" cannot be represented is milleseconds");
        throw new IllegalArgumentException(localStringBuffer.toString());
      case 14: 
        return 1L;
      case 13: 
        return 1000L;
      case 12: 
        return 60000L;
      }
      return 3600000L;
    }
    return 86400000L;
  }
  
  private static int indexOfSignChars(String paramString, int paramInt)
  {
    int j = StringUtils.indexOf(paramString, '+', paramInt);
    int i = j;
    if (j < 0) {
      i = StringUtils.indexOf(paramString, '-', paramInt);
    }
    return i;
  }
  
  public static boolean isSameDay(Calendar paramCalendar1, Calendar paramCalendar2)
  {
    if ((paramCalendar1 != null) && (paramCalendar2 != null))
    {
      boolean bool2 = false;
      boolean bool1 = bool2;
      if (paramCalendar1.get(0) == paramCalendar2.get(0))
      {
        bool1 = bool2;
        if (paramCalendar1.get(1) == paramCalendar2.get(1))
        {
          bool1 = bool2;
          if (paramCalendar1.get(6) == paramCalendar2.get(6)) {
            bool1 = true;
          }
        }
      }
      return bool1;
    }
    throw new IllegalArgumentException("The date must not be null");
  }
  
  public static boolean isSameDay(Date paramDate1, Date paramDate2)
  {
    if ((paramDate1 != null) && (paramDate2 != null))
    {
      Calendar localCalendar = Calendar.getInstance();
      localCalendar.setTime(paramDate1);
      paramDate1 = Calendar.getInstance();
      paramDate1.setTime(paramDate2);
      return isSameDay(localCalendar, paramDate1);
    }
    throw new IllegalArgumentException("The date must not be null");
  }
  
  public static boolean isSameInstant(Calendar paramCalendar1, Calendar paramCalendar2)
  {
    if ((paramCalendar1 != null) && (paramCalendar2 != null)) {
      return paramCalendar1.getTime().getTime() == paramCalendar2.getTime().getTime();
    }
    throw new IllegalArgumentException("The date must not be null");
  }
  
  public static boolean isSameInstant(Date paramDate1, Date paramDate2)
  {
    if ((paramDate1 != null) && (paramDate2 != null)) {
      return paramDate1.getTime() == paramDate2.getTime();
    }
    throw new IllegalArgumentException("The date must not be null");
  }
  
  public static boolean isSameLocalTime(Calendar paramCalendar1, Calendar paramCalendar2)
  {
    if ((paramCalendar1 != null) && (paramCalendar2 != null)) {
      return (paramCalendar1.get(14) == paramCalendar2.get(14)) && (paramCalendar1.get(13) == paramCalendar2.get(13)) && (paramCalendar1.get(12) == paramCalendar2.get(12)) && (paramCalendar1.get(10) == paramCalendar2.get(10)) && (paramCalendar1.get(6) == paramCalendar2.get(6)) && (paramCalendar1.get(1) == paramCalendar2.get(1)) && (paramCalendar1.get(0) == paramCalendar2.get(0)) && (paramCalendar1.getClass() == paramCalendar2.getClass());
    }
    throw new IllegalArgumentException("The date must not be null");
  }
  
  public static Iterator iterator(Object paramObject, int paramInt)
  {
    if (paramObject != null)
    {
      if ((paramObject instanceof Date)) {
        return iterator((Date)paramObject, paramInt);
      }
      if ((paramObject instanceof Calendar)) {
        return iterator((Calendar)paramObject, paramInt);
      }
      StringBuffer localStringBuffer = new StringBuffer();
      localStringBuffer.append("Could not iterate based on ");
      localStringBuffer.append(paramObject);
      throw new ClassCastException(localStringBuffer.toString());
    }
    throw new IllegalArgumentException("The date must not be null");
  }
  
  public static Iterator iterator(Calendar paramCalendar, int paramInt)
  {
    if (paramCalendar != null)
    {
      int i = 2;
      switch (paramInt)
      {
      default: 
        paramCalendar = new StringBuffer();
        paramCalendar.append("The range style ");
        paramCalendar.append(paramInt);
        paramCalendar.append(" is not valid.");
        throw new IllegalArgumentException(paramCalendar.toString());
      case 5: 
      case 6: 
        paramCalendar = truncate(paramCalendar, 2);
        localObject1 = (Calendar)paramCalendar.clone();
        ((Calendar)localObject1).add(2, 1);
        ((Calendar)localObject1).add(5, -1);
        if (paramInt == 6) {
          localObject2 = paramCalendar;
        }
        break;
      }
      Calendar localCalendar1;
      Calendar localCalendar2;
      do
      {
        paramInt = 1;
        break label249;
        i = 1;
        paramInt = 7;
        localObject2 = paramCalendar;
        break label249;
        localCalendar1 = truncate(paramCalendar, 5);
        localCalendar2 = truncate(paramCalendar, 5);
        if (paramInt == 1) {
          break;
        }
        localObject2 = localCalendar1;
        localObject1 = localCalendar2;
      } while (paramInt == 2);
      if (paramInt != 3)
      {
        if (paramInt == 4)
        {
          i = paramCalendar.get(7);
          paramInt = paramCalendar.get(7) + 3;
          i -= 3;
          localObject2 = localCalendar1;
          localObject1 = localCalendar2;
          break label249;
        }
      }
      else
      {
        i = paramCalendar.get(7);
        paramInt = i - 1;
        localObject2 = localCalendar1;
        localObject1 = localCalendar2;
        break label249;
      }
      paramInt = 7;
      i = 1;
      Object localObject1 = localCalendar2;
      Object localObject2 = localCalendar1;
      label249:
      int j = i;
      if (i < 1) {
        j = i + 7;
      }
      int k = j;
      if (j > 7) {
        k = j - 7;
      }
      i = paramInt;
      if (paramInt < 1) {
        i = paramInt + 7;
      }
      paramInt = i;
      if (i > 7) {
        paramInt = i - 7;
      }
      while (((Calendar)localObject2).get(7) != k) {
        ((Calendar)localObject2).add(5, -1);
      }
      while (((Calendar)localObject1).get(7) != paramInt) {
        ((Calendar)localObject1).add(5, 1);
      }
      return new DateUtils.DateIterator((Calendar)localObject2, (Calendar)localObject1);
    }
    paramCalendar = new IllegalArgumentException("The date must not be null");
    for (;;)
    {
      throw paramCalendar;
    }
  }
  
  public static Iterator iterator(Date paramDate, int paramInt)
  {
    if (paramDate != null)
    {
      Calendar localCalendar = Calendar.getInstance();
      localCalendar.setTime(paramDate);
      return iterator(localCalendar, paramInt);
    }
    throw new IllegalArgumentException("The date must not be null");
  }
  
  private static void modify(Calendar paramCalendar, int paramInt1, int paramInt2)
  {
    if (paramCalendar.get(1) <= 280000000)
    {
      if (paramInt1 == 14) {
        return;
      }
      Object localObject = paramCalendar.getTime();
      long l2 = ((Date)localObject).getTime();
      int i = paramCalendar.get(14);
      if (paramInt2 != 0)
      {
        l1 = l2;
        if (i >= 500) {}
      }
      else
      {
        l1 = l2 - i;
      }
      if (paramInt1 == 13) {
        i = 1;
      } else {
        i = 0;
      }
      int j = paramCalendar.get(13);
      l2 = l1;
      if (i == 0) {
        if (paramInt2 != 0)
        {
          l2 = l1;
          if (j >= 30) {}
        }
        else
        {
          l2 = l1 - j * 1000L;
        }
      }
      if (paramInt1 == 12) {
        i = 1;
      }
      j = paramCalendar.get(12);
      long l1 = l2;
      if (i == 0) {
        if (paramInt2 != 0)
        {
          l1 = l2;
          if (j >= 30) {}
        }
        else
        {
          l1 = l2 - j * 60000L;
        }
      }
      if (((Date)localObject).getTime() != l1)
      {
        ((Date)localObject).setTime(l1);
        paramCalendar.setTime((Date)localObject);
      }
      int k = 0;
      i = 0;
      while (k < fields.length)
      {
        j = 0;
        for (;;)
        {
          localObject = fields;
          if (j >= localObject[k].length) {
            break;
          }
          if (localObject[k][j] == paramInt1)
          {
            if ((paramInt2 == 2) || ((paramInt2 == 1) && (i != 0)))
            {
              if (paramInt1 == 1001)
              {
                if (paramCalendar.get(5) == 1)
                {
                  paramCalendar.add(5, 15);
                  return;
                }
                paramCalendar.add(5, -15);
                paramCalendar.add(2, 1);
                return;
              }
              if (paramInt1 == 9)
              {
                if (paramCalendar.get(11) == 0)
                {
                  paramCalendar.add(11, 12);
                  return;
                }
                paramCalendar.add(11, -12);
                paramCalendar.add(5, 1);
                return;
              }
              paramCalendar.add(fields[k][0], 1);
            }
            return;
          }
          j += 1;
        }
        if (paramInt1 != 9)
        {
          if ((paramInt1 != 1001) || (localObject[k][0] != 5)) {
            break label487;
          }
          j = paramCalendar.get(5) - 1;
          i = j;
          if (j >= 15) {
            i = j - 15;
          }
          j = i;
          i = j;
          if (j <= 7) {
            break label478;
          }
          i = j;
        }
        else
        {
          if (localObject[k][0] != 11) {
            break label487;
          }
          j = paramCalendar.get(11);
          i = j;
          if (j >= 12) {
            i = j - 12;
          }
          j = i;
          i = j;
          if (j < 6) {
            break label478;
          }
          i = j;
        }
        j = 1;
        break label481;
        label478:
        j = 0;
        label481:
        int m = 1;
        break label495;
        label487:
        j = i;
        m = 0;
        i = 0;
        label495:
        if (m == 0)
        {
          i = paramCalendar.getActualMinimum(fields[k][0]);
          j = paramCalendar.getActualMaximum(fields[k][0]);
          m = paramCalendar.get(fields[k][0]) - i;
          if (m > (j - i) / 2) {
            i = 1;
          } else {
            i = 0;
          }
        }
        else
        {
          m = i;
          i = j;
        }
        if (m != 0)
        {
          localObject = fields;
          paramCalendar.set(localObject[k][0], paramCalendar.get(localObject[k][0]) - m);
        }
        k += 1;
      }
      paramCalendar = new StringBuffer();
      paramCalendar.append("The field ");
      paramCalendar.append(paramInt1);
      paramCalendar.append(" is not supported");
      throw new IllegalArgumentException(paramCalendar.toString());
    }
    paramCalendar = new ArithmeticException("Calendar value too large for accurate calculations");
    for (;;)
    {
      throw paramCalendar;
    }
  }
  
  public static Date parseDate(String paramString, String[] paramArrayOfString)
  {
    return parseDateWithLeniency(paramString, paramArrayOfString, true);
  }
  
  public static Date parseDateStrictly(String paramString, String[] paramArrayOfString)
  {
    return parseDateWithLeniency(paramString, paramArrayOfString, false);
  }
  
  private static Date parseDateWithLeniency(String paramString, String[] paramArrayOfString, boolean paramBoolean)
  {
    if ((paramString != null) && (paramArrayOfString != null))
    {
      SimpleDateFormat localSimpleDateFormat = new SimpleDateFormat();
      localSimpleDateFormat.setLenient(paramBoolean);
      ParsePosition localParsePosition = new ParsePosition(0);
      int i = 0;
      while (i < paramArrayOfString.length)
      {
        Object localObject2 = paramArrayOfString[i];
        Object localObject1 = localObject2;
        if (paramArrayOfString[i].endsWith("ZZ")) {
          localObject1 = ((String)localObject2).substring(0, ((String)localObject2).length() - 1);
        }
        localSimpleDateFormat.applyPattern((String)localObject1);
        localParsePosition.setIndex(0);
        if (paramArrayOfString[i].endsWith("ZZ"))
        {
          int j = indexOfSignChars(paramString, 0);
          localObject1 = paramString;
          for (;;)
          {
            localObject2 = localObject1;
            if (j < 0) {
              break;
            }
            localObject1 = reformatTimezone((String)localObject1, j);
            j = indexOfSignChars((String)localObject1, j + 1);
          }
        }
        localObject2 = paramString;
        localObject1 = localSimpleDateFormat.parse((String)localObject2, localParsePosition);
        if ((localObject1 != null) && (localParsePosition.getIndex() == ((String)localObject2).length())) {
          return localObject1;
        }
        i += 1;
      }
      paramArrayOfString = new StringBuffer();
      paramArrayOfString.append("Unable to parse the date: ");
      paramArrayOfString.append(paramString);
      throw new ParseException(paramArrayOfString.toString(), -1);
    }
    paramString = new IllegalArgumentException("Date and Patterns must not be null");
    for (;;)
    {
      throw paramString;
    }
  }
  
  private static String reformatTimezone(String paramString, int paramInt)
  {
    Object localObject = paramString;
    if (paramInt >= 0)
    {
      int i = paramInt + 5;
      localObject = paramString;
      if (i < paramString.length())
      {
        localObject = paramString;
        if (Character.isDigit(paramString.charAt(paramInt + 1)))
        {
          localObject = paramString;
          if (Character.isDigit(paramString.charAt(paramInt + 2)))
          {
            int j = paramInt + 3;
            localObject = paramString;
            if (paramString.charAt(j) == ':')
            {
              paramInt += 4;
              localObject = paramString;
              if (Character.isDigit(paramString.charAt(paramInt)))
              {
                localObject = paramString;
                if (Character.isDigit(paramString.charAt(i)))
                {
                  localObject = new StringBuffer();
                  ((StringBuffer)localObject).append(paramString.substring(0, j));
                  ((StringBuffer)localObject).append(paramString.substring(paramInt));
                  localObject = ((StringBuffer)localObject).toString();
                }
              }
            }
          }
        }
      }
    }
    return localObject;
  }
  
  public static Calendar round(Calendar paramCalendar, int paramInt)
  {
    if (paramCalendar != null)
    {
      paramCalendar = (Calendar)paramCalendar.clone();
      modify(paramCalendar, paramInt, 1);
      return paramCalendar;
    }
    throw new IllegalArgumentException("The date must not be null");
  }
  
  public static Date round(Object paramObject, int paramInt)
  {
    if (paramObject != null)
    {
      if ((paramObject instanceof Date)) {
        return round((Date)paramObject, paramInt);
      }
      if ((paramObject instanceof Calendar)) {
        return round((Calendar)paramObject, paramInt).getTime();
      }
      StringBuffer localStringBuffer = new StringBuffer();
      localStringBuffer.append("Could not round ");
      localStringBuffer.append(paramObject);
      throw new ClassCastException(localStringBuffer.toString());
    }
    throw new IllegalArgumentException("The date must not be null");
  }
  
  public static Date round(Date paramDate, int paramInt)
  {
    if (paramDate != null)
    {
      Calendar localCalendar = Calendar.getInstance();
      localCalendar.setTime(paramDate);
      modify(localCalendar, paramInt, 1);
      return localCalendar.getTime();
    }
    throw new IllegalArgumentException("The date must not be null");
  }
  
  private static Date set(Date paramDate, int paramInt1, int paramInt2)
  {
    if (paramDate != null)
    {
      Calendar localCalendar = Calendar.getInstance();
      localCalendar.setLenient(false);
      localCalendar.setTime(paramDate);
      localCalendar.set(paramInt1, paramInt2);
      return localCalendar.getTime();
    }
    throw new IllegalArgumentException("The date must not be null");
  }
  
  public static Date setDays(Date paramDate, int paramInt)
  {
    return set(paramDate, 5, paramInt);
  }
  
  public static Date setHours(Date paramDate, int paramInt)
  {
    return set(paramDate, 11, paramInt);
  }
  
  public static Date setMilliseconds(Date paramDate, int paramInt)
  {
    return set(paramDate, 14, paramInt);
  }
  
  public static Date setMinutes(Date paramDate, int paramInt)
  {
    return set(paramDate, 12, paramInt);
  }
  
  public static Date setMonths(Date paramDate, int paramInt)
  {
    return set(paramDate, 2, paramInt);
  }
  
  public static Date setSeconds(Date paramDate, int paramInt)
  {
    return set(paramDate, 13, paramInt);
  }
  
  public static Date setYears(Date paramDate, int paramInt)
  {
    return set(paramDate, 1, paramInt);
  }
  
  public static Calendar toCalendar(Date paramDate)
  {
    Calendar localCalendar = Calendar.getInstance();
    localCalendar.setTime(paramDate);
    return localCalendar;
  }
  
  public static Calendar truncate(Calendar paramCalendar, int paramInt)
  {
    if (paramCalendar != null)
    {
      paramCalendar = (Calendar)paramCalendar.clone();
      modify(paramCalendar, paramInt, 0);
      return paramCalendar;
    }
    throw new IllegalArgumentException("The date must not be null");
  }
  
  public static Date truncate(Object paramObject, int paramInt)
  {
    if (paramObject != null)
    {
      if ((paramObject instanceof Date)) {
        return truncate((Date)paramObject, paramInt);
      }
      if ((paramObject instanceof Calendar)) {
        return truncate((Calendar)paramObject, paramInt).getTime();
      }
      StringBuffer localStringBuffer = new StringBuffer();
      localStringBuffer.append("Could not truncate ");
      localStringBuffer.append(paramObject);
      throw new ClassCastException(localStringBuffer.toString());
    }
    throw new IllegalArgumentException("The date must not be null");
  }
  
  public static Date truncate(Date paramDate, int paramInt)
  {
    if (paramDate != null)
    {
      Calendar localCalendar = Calendar.getInstance();
      localCalendar.setTime(paramDate);
      modify(localCalendar, paramInt, 0);
      return localCalendar.getTime();
    }
    throw new IllegalArgumentException("The date must not be null");
  }
  
  public static int truncatedCompareTo(Calendar paramCalendar1, Calendar paramCalendar2, int paramInt)
  {
    paramCalendar1 = truncate(paramCalendar1, paramInt);
    paramCalendar2 = truncate(paramCalendar2, paramInt);
    return paramCalendar1.getTime().compareTo(paramCalendar2.getTime());
  }
  
  public static int truncatedCompareTo(Date paramDate1, Date paramDate2, int paramInt)
  {
    return truncate(paramDate1, paramInt).compareTo(truncate(paramDate2, paramInt));
  }
  
  public static boolean truncatedEquals(Calendar paramCalendar1, Calendar paramCalendar2, int paramInt)
  {
    return truncatedCompareTo(paramCalendar1, paramCalendar2, paramInt) == 0;
  }
  
  public static boolean truncatedEquals(Date paramDate1, Date paramDate2, int paramInt)
  {
    return truncatedCompareTo(paramDate1, paramDate2, paramInt) == 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     org.apache.commons.lang.time.DateUtils
 * JD-Core Version:    0.7.0.1
 */