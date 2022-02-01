package org.apache.commons.lang.time;

import java.io.ObjectInputStream;
import java.text.DateFormat;
import java.text.DateFormatSymbols;
import java.text.FieldPosition;
import java.text.Format;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.TimeZone;
import org.apache.commons.lang.text.StrBuilder;

public class FastDateFormat
  extends Format
{
  public static final int FULL = 0;
  public static final int LONG = 1;
  public static final int MEDIUM = 2;
  public static final int SHORT = 3;
  private static final Map cDateInstanceCache;
  private static final Map cDateTimeInstanceCache = new HashMap(7);
  private static String cDefaultPattern;
  private static final Map cInstanceCache = new HashMap(7);
  private static final Map cTimeInstanceCache;
  private static final Map cTimeZoneDisplayCache = new HashMap(7);
  private static final long serialVersionUID = 1L;
  private final Locale mLocale;
  private final boolean mLocaleForced;
  private transient int mMaxLengthEstimate;
  private final String mPattern;
  private transient FastDateFormat.Rule[] mRules;
  private final TimeZone mTimeZone;
  private final boolean mTimeZoneForced;
  
  static
  {
    cDateInstanceCache = new HashMap(7);
    cTimeInstanceCache = new HashMap(7);
  }
  
  protected FastDateFormat(String paramString, TimeZone paramTimeZone, Locale paramLocale)
  {
    if (paramString != null)
    {
      this.mPattern = paramString;
      boolean bool2 = true;
      boolean bool1;
      if (paramTimeZone != null) {
        bool1 = true;
      } else {
        bool1 = false;
      }
      this.mTimeZoneForced = bool1;
      paramString = paramTimeZone;
      if (paramTimeZone == null) {
        paramString = TimeZone.getDefault();
      }
      this.mTimeZone = paramString;
      if (paramLocale != null) {
        bool1 = bool2;
      } else {
        bool1 = false;
      }
      this.mLocaleForced = bool1;
      paramString = paramLocale;
      if (paramLocale == null) {
        paramString = Locale.getDefault();
      }
      this.mLocale = paramString;
      return;
    }
    throw new IllegalArgumentException("The pattern must not be null");
  }
  
  public static FastDateFormat getDateInstance(int paramInt)
  {
    return getDateInstance(paramInt, null, null);
  }
  
  public static FastDateFormat getDateInstance(int paramInt, Locale paramLocale)
  {
    return getDateInstance(paramInt, null, paramLocale);
  }
  
  public static FastDateFormat getDateInstance(int paramInt, TimeZone paramTimeZone)
  {
    return getDateInstance(paramInt, paramTimeZone, null);
  }
  
  public static FastDateFormat getDateInstance(int paramInt, TimeZone paramTimeZone, Locale paramLocale)
  {
    Object localObject1;
    FastDateFormat.Pair localPair;
    label107:
    try
    {
      localObject1 = new Integer(paramInt);
      Object localObject2 = localObject1;
      if (paramTimeZone != null) {
        localObject2 = new FastDateFormat.Pair(localObject1, paramTimeZone);
      }
      localObject1 = paramLocale;
      if (paramLocale == null) {
        localObject1 = Locale.getDefault();
      }
      localPair = new FastDateFormat.Pair(localObject2, localObject1);
      localObject2 = (FastDateFormat)cDateInstanceCache.get(localPair);
      paramLocale = (Locale)localObject2;
      if (localObject2 != null) {}
    }
    finally {}
    try
    {
      paramLocale = getInstance(((SimpleDateFormat)DateFormat.getDateInstance(paramInt, (Locale)localObject1)).toPattern(), paramTimeZone, (Locale)localObject1);
      cDateInstanceCache.put(localPair, paramLocale);
    }
    catch (ClassCastException paramTimeZone)
    {
      break label107;
    }
    paramTimeZone = new StringBuffer();
    paramTimeZone.append("No date pattern for locale: ");
    paramTimeZone.append(localObject1);
    throw new IllegalArgumentException(paramTimeZone.toString());
    return paramLocale;
  }
  
  public static FastDateFormat getDateTimeInstance(int paramInt1, int paramInt2)
  {
    return getDateTimeInstance(paramInt1, paramInt2, null, null);
  }
  
  public static FastDateFormat getDateTimeInstance(int paramInt1, int paramInt2, Locale paramLocale)
  {
    return getDateTimeInstance(paramInt1, paramInt2, null, paramLocale);
  }
  
  public static FastDateFormat getDateTimeInstance(int paramInt1, int paramInt2, TimeZone paramTimeZone)
  {
    return getDateTimeInstance(paramInt1, paramInt2, paramTimeZone, null);
  }
  
  public static FastDateFormat getDateTimeInstance(int paramInt1, int paramInt2, TimeZone paramTimeZone, Locale paramLocale)
  {
    Object localObject1;
    FastDateFormat.Pair localPair;
    label131:
    try
    {
      localObject1 = new FastDateFormat.Pair(new Integer(paramInt1), new Integer(paramInt2));
      Object localObject2 = localObject1;
      if (paramTimeZone != null) {
        localObject2 = new FastDateFormat.Pair(localObject1, paramTimeZone);
      }
      localObject1 = paramLocale;
      if (paramLocale == null) {
        localObject1 = Locale.getDefault();
      }
      localPair = new FastDateFormat.Pair(localObject2, localObject1);
      localObject2 = (FastDateFormat)cDateTimeInstanceCache.get(localPair);
      paramLocale = (Locale)localObject2;
      if (localObject2 != null) {}
    }
    finally {}
    try
    {
      paramLocale = getInstance(((SimpleDateFormat)DateFormat.getDateTimeInstance(paramInt1, paramInt2, (Locale)localObject1)).toPattern(), paramTimeZone, (Locale)localObject1);
      cDateTimeInstanceCache.put(localPair, paramLocale);
    }
    catch (ClassCastException paramTimeZone)
    {
      break label131;
    }
    paramTimeZone = new StringBuffer();
    paramTimeZone.append("No date time pattern for locale: ");
    paramTimeZone.append(localObject1);
    throw new IllegalArgumentException(paramTimeZone.toString());
    return paramLocale;
  }
  
  private static String getDefaultPattern()
  {
    try
    {
      if (cDefaultPattern == null) {
        cDefaultPattern = new SimpleDateFormat().toPattern();
      }
      String str = cDefaultPattern;
      return str;
    }
    finally {}
  }
  
  public static FastDateFormat getInstance()
  {
    return getInstance(getDefaultPattern(), null, null);
  }
  
  public static FastDateFormat getInstance(String paramString)
  {
    return getInstance(paramString, null, null);
  }
  
  public static FastDateFormat getInstance(String paramString, Locale paramLocale)
  {
    return getInstance(paramString, null, paramLocale);
  }
  
  public static FastDateFormat getInstance(String paramString, TimeZone paramTimeZone)
  {
    return getInstance(paramString, paramTimeZone, null);
  }
  
  public static FastDateFormat getInstance(String paramString, TimeZone paramTimeZone, Locale paramLocale)
  {
    try
    {
      paramTimeZone = new FastDateFormat(paramString, paramTimeZone, paramLocale);
      paramLocale = (FastDateFormat)cInstanceCache.get(paramTimeZone);
      paramString = paramLocale;
      if (paramLocale == null)
      {
        paramTimeZone.init();
        cInstanceCache.put(paramTimeZone, paramTimeZone);
        paramString = paramTimeZone;
      }
      return paramString;
    }
    finally {}
  }
  
  public static FastDateFormat getTimeInstance(int paramInt)
  {
    return getTimeInstance(paramInt, null, null);
  }
  
  public static FastDateFormat getTimeInstance(int paramInt, Locale paramLocale)
  {
    return getTimeInstance(paramInt, null, paramLocale);
  }
  
  public static FastDateFormat getTimeInstance(int paramInt, TimeZone paramTimeZone)
  {
    return getTimeInstance(paramInt, paramTimeZone, null);
  }
  
  public static FastDateFormat getTimeInstance(int paramInt, TimeZone paramTimeZone, Locale paramLocale)
  {
    Object localObject2;
    Object localObject1;
    label116:
    try
    {
      localObject2 = new Integer(paramInt);
      localObject1 = localObject2;
      if (paramTimeZone != null) {
        localObject1 = new FastDateFormat.Pair(localObject2, paramTimeZone);
      }
      localObject2 = localObject1;
      if (paramLocale != null) {
        localObject2 = new FastDateFormat.Pair(localObject1, paramLocale);
      }
      FastDateFormat localFastDateFormat = (FastDateFormat)cTimeInstanceCache.get(localObject2);
      localObject1 = localFastDateFormat;
      if (localFastDateFormat == null)
      {
        localObject1 = paramLocale;
        if (paramLocale == null) {
          localObject1 = Locale.getDefault();
        }
      }
    }
    finally {}
    try
    {
      paramTimeZone = getInstance(((SimpleDateFormat)DateFormat.getTimeInstance(paramInt, (Locale)localObject1)).toPattern(), paramTimeZone, (Locale)localObject1);
      cTimeInstanceCache.put(localObject2, paramTimeZone);
      localObject1 = paramTimeZone;
    }
    catch (ClassCastException paramTimeZone)
    {
      break label116;
    }
    paramTimeZone = new StringBuffer();
    paramTimeZone.append("No date pattern for locale: ");
    paramTimeZone.append(localObject1);
    throw new IllegalArgumentException(paramTimeZone.toString());
    return localObject1;
  }
  
  static String getTimeZoneDisplay(TimeZone paramTimeZone, boolean paramBoolean, int paramInt, Locale paramLocale)
  {
    try
    {
      FastDateFormat.TimeZoneDisplayKey localTimeZoneDisplayKey = new FastDateFormat.TimeZoneDisplayKey(paramTimeZone, paramBoolean, paramInt, paramLocale);
      String str2 = (String)cTimeZoneDisplayCache.get(localTimeZoneDisplayKey);
      String str1 = str2;
      if (str2 == null)
      {
        str1 = paramTimeZone.getDisplayName(paramBoolean, paramInt, paramLocale);
        cTimeZoneDisplayCache.put(localTimeZoneDisplayKey, str1);
      }
      return str1;
    }
    finally {}
  }
  
  private void readObject(ObjectInputStream paramObjectInputStream)
  {
    paramObjectInputStream.defaultReadObject();
    init();
  }
  
  protected StringBuffer applyRules(Calendar paramCalendar, StringBuffer paramStringBuffer)
  {
    FastDateFormat.Rule[] arrayOfRule = this.mRules;
    int j = arrayOfRule.length;
    int i = 0;
    while (i < j)
    {
      arrayOfRule[i].appendTo(paramStringBuffer, paramCalendar);
      i += 1;
    }
    return paramStringBuffer;
  }
  
  public boolean equals(Object paramObject)
  {
    if (!(paramObject instanceof FastDateFormat)) {
      return false;
    }
    paramObject = (FastDateFormat)paramObject;
    Object localObject1 = this.mPattern;
    Object localObject2 = paramObject.mPattern;
    if ((localObject1 == localObject2) || (((String)localObject1).equals(localObject2)))
    {
      localObject1 = this.mTimeZone;
      localObject2 = paramObject.mTimeZone;
      if ((localObject1 == localObject2) || (localObject1.equals(localObject2)))
      {
        localObject1 = this.mLocale;
        localObject2 = paramObject.mLocale;
        if (((localObject1 == localObject2) || (((Locale)localObject1).equals(localObject2))) && (this.mTimeZoneForced == paramObject.mTimeZoneForced) && (this.mLocaleForced == paramObject.mLocaleForced)) {
          return true;
        }
      }
    }
    return false;
  }
  
  public String format(long paramLong)
  {
    return format(new Date(paramLong));
  }
  
  public String format(Calendar paramCalendar)
  {
    return format(paramCalendar, new StringBuffer(this.mMaxLengthEstimate)).toString();
  }
  
  public String format(Date paramDate)
  {
    GregorianCalendar localGregorianCalendar = new GregorianCalendar(this.mTimeZone, this.mLocale);
    localGregorianCalendar.setTime(paramDate);
    return applyRules(localGregorianCalendar, new StringBuffer(this.mMaxLengthEstimate)).toString();
  }
  
  public StringBuffer format(long paramLong, StringBuffer paramStringBuffer)
  {
    return format(new Date(paramLong), paramStringBuffer);
  }
  
  public StringBuffer format(Object paramObject, StringBuffer paramStringBuffer, FieldPosition paramFieldPosition)
  {
    if ((paramObject instanceof Date)) {
      return format((Date)paramObject, paramStringBuffer);
    }
    if ((paramObject instanceof Calendar)) {
      return format((Calendar)paramObject, paramStringBuffer);
    }
    if ((paramObject instanceof Long)) {
      return format(((Long)paramObject).longValue(), paramStringBuffer);
    }
    paramStringBuffer = new StringBuffer();
    paramStringBuffer.append("Unknown class: ");
    if (paramObject == null) {
      paramObject = "<null>";
    } else {
      paramObject = paramObject.getClass().getName();
    }
    paramStringBuffer.append(paramObject);
    throw new IllegalArgumentException(paramStringBuffer.toString());
  }
  
  public StringBuffer format(Calendar paramCalendar, StringBuffer paramStringBuffer)
  {
    Calendar localCalendar = paramCalendar;
    if (this.mTimeZoneForced)
    {
      paramCalendar.getTime();
      localCalendar = (Calendar)paramCalendar.clone();
      localCalendar.setTimeZone(this.mTimeZone);
    }
    return applyRules(localCalendar, paramStringBuffer);
  }
  
  public StringBuffer format(Date paramDate, StringBuffer paramStringBuffer)
  {
    GregorianCalendar localGregorianCalendar = new GregorianCalendar(this.mTimeZone);
    localGregorianCalendar.setTime(paramDate);
    return applyRules(localGregorianCalendar, paramStringBuffer);
  }
  
  public Locale getLocale()
  {
    return this.mLocale;
  }
  
  public int getMaxLengthEstimate()
  {
    return this.mMaxLengthEstimate;
  }
  
  public String getPattern()
  {
    return this.mPattern;
  }
  
  public TimeZone getTimeZone()
  {
    return this.mTimeZone;
  }
  
  public boolean getTimeZoneOverridesCalendar()
  {
    return this.mTimeZoneForced;
  }
  
  public int hashCode()
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.provideAs(TypeTransformer.java:780)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.e1expr(TypeTransformer.java:496)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:713)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.e2expr(TypeTransformer.java:632)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:716)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.e2expr(TypeTransformer.java:629)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:716)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.e2expr(TypeTransformer.java:629)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:716)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.s1stmt(TypeTransformer.java:810)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.sxStmt(TypeTransformer.java:840)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:206)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
  
  protected void init()
  {
    List localList = parsePattern();
    this.mRules = ((FastDateFormat.Rule[])localList.toArray(new FastDateFormat.Rule[localList.size()]));
    int j = this.mRules.length;
    int i = 0;
    for (;;)
    {
      j -= 1;
      if (j < 0) {
        break;
      }
      i += this.mRules[j].estimateLength();
    }
    this.mMaxLengthEstimate = i;
  }
  
  public Object parseObject(String paramString, ParsePosition paramParsePosition)
  {
    paramParsePosition.setIndex(0);
    paramParsePosition.setErrorIndex(0);
    return null;
  }
  
  protected List parsePattern()
  {
    Object localObject1 = new DateFormatSymbols(this.mLocale);
    ArrayList localArrayList = new ArrayList();
    String[] arrayOfString2 = ((DateFormatSymbols)localObject1).getEras();
    String[] arrayOfString3 = ((DateFormatSymbols)localObject1).getMonths();
    String[] arrayOfString4 = ((DateFormatSymbols)localObject1).getShortMonths();
    Object localObject2 = ((DateFormatSymbols)localObject1).getWeekdays();
    String[] arrayOfString1 = ((DateFormatSymbols)localObject1).getShortWeekdays();
    String[] arrayOfString5 = ((DateFormatSymbols)localObject1).getAmPmStrings();
    int j = this.mPattern.length();
    int[] arrayOfInt = new int[1];
    int i = 0;
    while (i < j)
    {
      arrayOfInt[0] = i;
      localObject1 = parseToken(this.mPattern, arrayOfInt);
      i = arrayOfInt[0];
      int k = ((String)localObject1).length();
      if (k == 0) {
        return localArrayList;
      }
      int m = ((String)localObject1).charAt(0);
      if (m != 121)
      {
        if (m != 122) {
          switch (m)
          {
          default: 
            switch (m)
            {
            default: 
              localObject2 = new StringBuffer();
              ((StringBuffer)localObject2).append("Illegal pattern component: ");
              ((StringBuffer)localObject2).append((String)localObject1);
              throw new IllegalArgumentException(((StringBuffer)localObject2).toString());
            case 72: 
              localObject1 = selectNumberRule(11, k);
              break;
            case 71: 
              localObject1 = new FastDateFormat.TextField(0, arrayOfString2);
              break;
            case 70: 
              localObject1 = selectNumberRule(8, k);
              break;
            case 69: 
              if (k < 4) {
                localObject1 = arrayOfString1;
              } else {
                localObject1 = localObject2;
              }
              localObject1 = new FastDateFormat.TextField(7, (String[])localObject1);
              break;
            case 68: 
              localObject1 = selectNumberRule(6, k);
            }
            break;
          }
        }
        for (;;)
        {
          break label756;
          localObject1 = selectNumberRule(3, k);
          continue;
          localObject1 = selectNumberRule(13, k);
          continue;
          localObject1 = selectNumberRule(12, k);
          continue;
          localObject1 = new FastDateFormat.TwentyFourHourField(selectNumberRule(11, k));
          continue;
          localObject1 = new FastDateFormat.TwelveHourField(selectNumberRule(10, k));
          continue;
          localObject1 = selectNumberRule(5, k);
          continue;
          localObject1 = new FastDateFormat.TextField(9, arrayOfString5);
          continue;
          if (k == 1)
          {
            localObject1 = FastDateFormat.TimeZoneNumberRule.INSTANCE_NO_COLON;
          }
          else
          {
            localObject1 = FastDateFormat.TimeZoneNumberRule.INSTANCE_COLON;
            continue;
            localObject1 = selectNumberRule(4, k);
            continue;
            localObject1 = selectNumberRule(14, k);
            continue;
            if (k >= 4)
            {
              localObject1 = new FastDateFormat.TextField(2, arrayOfString3);
            }
            else if (k == 3)
            {
              localObject1 = new FastDateFormat.TextField(2, arrayOfString4);
            }
            else if (k == 2)
            {
              localObject1 = FastDateFormat.TwoDigitMonthField.INSTANCE;
            }
            else
            {
              localObject1 = FastDateFormat.UnpaddedMonthField.INSTANCE;
              continue;
              localObject1 = selectNumberRule(10, k);
              continue;
              localObject1 = ((String)localObject1).substring(1);
              if (((String)localObject1).length() == 1)
              {
                localObject1 = new FastDateFormat.CharacterLiteral(((String)localObject1).charAt(0));
              }
              else
              {
                localObject1 = new FastDateFormat.StringLiteral((String)localObject1);
                continue;
                if (k < 4) {
                  break;
                }
                localObject1 = new FastDateFormat.TimeZoneNameRule(this.mTimeZone, this.mTimeZoneForced, this.mLocale, 1);
              }
            }
          }
        }
        localObject1 = new FastDateFormat.TimeZoneNameRule(this.mTimeZone, this.mTimeZoneForced, this.mLocale, 0);
      }
      else if (k >= 4)
      {
        localObject1 = selectNumberRule(1, k);
      }
      else
      {
        localObject1 = FastDateFormat.TwoDigitYearField.INSTANCE;
      }
      label756:
      localArrayList.add(localObject1);
      i += 1;
    }
    return localArrayList;
  }
  
  protected String parseToken(String paramString, int[] paramArrayOfInt)
  {
    StrBuilder localStrBuilder = new StrBuilder();
    int i = paramArrayOfInt[0];
    int m = paramString.length();
    char c = paramString.charAt(i);
    int j;
    if (((c >= 'A') && (c <= 'Z')) || ((c >= 'a') && (c <= 'z')))
    {
      localStrBuilder.append(c);
      for (;;)
      {
        k = i + 1;
        j = i;
        if (k >= m) {
          break;
        }
        j = i;
        if (paramString.charAt(k) != c) {
          break;
        }
        localStrBuilder.append(c);
        i = k;
      }
    }
    localStrBuilder.append('\'');
    int k = 0;
    for (;;)
    {
      j = i;
      if (i >= m) {
        break;
      }
      c = paramString.charAt(i);
      if (c == '\'')
      {
        j = i + 1;
        if ((j < m) && (paramString.charAt(j) == '\''))
        {
          localStrBuilder.append(c);
          i = j;
        }
        else
        {
          k ^= 0x1;
        }
      }
      else
      {
        if ((k == 0) && (((c >= 'A') && (c <= 'Z')) || ((c >= 'a') && (c <= 'z'))))
        {
          j = i - 1;
          break;
        }
        localStrBuilder.append(c);
      }
      i += 1;
    }
    paramArrayOfInt[0] = j;
    return localStrBuilder.toString();
  }
  
  protected FastDateFormat.NumberRule selectNumberRule(int paramInt1, int paramInt2)
  {
    if (paramInt2 != 1)
    {
      if (paramInt2 != 2) {
        return new FastDateFormat.PaddedNumberField(paramInt1, paramInt2);
      }
      return new FastDateFormat.TwoDigitNumberField(paramInt1);
    }
    return new FastDateFormat.UnpaddedNumberField(paramInt1);
  }
  
  public String toString()
  {
    StringBuffer localStringBuffer = new StringBuffer();
    localStringBuffer.append("FastDateFormat[");
    localStringBuffer.append(this.mPattern);
    localStringBuffer.append("]");
    return localStringBuffer.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     org.apache.commons.lang.time.FastDateFormat
 * JD-Core Version:    0.7.0.1
 */