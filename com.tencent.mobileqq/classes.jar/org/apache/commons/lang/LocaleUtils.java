package org.apache.commons.lang;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;

public class LocaleUtils
{
  private static List cAvailableLocaleList;
  private static Set cAvailableLocaleSet;
  private static final Map cCountriesByLanguage = Collections.synchronizedMap(new HashMap());
  private static final Map cLanguagesByCountry = Collections.synchronizedMap(new HashMap());
  
  public static List availableLocaleList()
  {
    if (cAvailableLocaleList == null) {
      initAvailableLocaleList();
    }
    return cAvailableLocaleList;
  }
  
  public static Set availableLocaleSet()
  {
    if (cAvailableLocaleSet == null) {
      initAvailableLocaleSet();
    }
    return cAvailableLocaleSet;
  }
  
  public static List countriesByLanguage(String paramString)
  {
    List localList = (List)cCountriesByLanguage.get(paramString);
    Object localObject = localList;
    if (localList == null)
    {
      if (paramString != null)
      {
        localObject = new ArrayList();
        localList = availableLocaleList();
        int i = 0;
        while (i < localList.size())
        {
          Locale localLocale = (Locale)localList.get(i);
          if ((paramString.equals(localLocale.getLanguage())) && (localLocale.getCountry().length() != 0) && (localLocale.getVariant().length() == 0)) {
            ((List)localObject).add(localLocale);
          }
          i += 1;
        }
        localObject = Collections.unmodifiableList((List)localObject);
      }
      else
      {
        localObject = Collections.EMPTY_LIST;
      }
      cCountriesByLanguage.put(paramString, localObject);
    }
    return localObject;
  }
  
  private static void initAvailableLocaleList()
  {
    try
    {
      if (cAvailableLocaleList == null) {
        cAvailableLocaleList = Collections.unmodifiableList(Arrays.asList(Locale.getAvailableLocales()));
      }
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  private static void initAvailableLocaleSet()
  {
    try
    {
      if (cAvailableLocaleSet == null) {
        cAvailableLocaleSet = Collections.unmodifiableSet(new HashSet(availableLocaleList()));
      }
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public static boolean isAvailableLocale(Locale paramLocale)
  {
    return availableLocaleList().contains(paramLocale);
  }
  
  public static List languagesByCountry(String paramString)
  {
    List localList = (List)cLanguagesByCountry.get(paramString);
    Object localObject = localList;
    if (localList == null)
    {
      if (paramString != null)
      {
        localObject = new ArrayList();
        localList = availableLocaleList();
        int i = 0;
        while (i < localList.size())
        {
          Locale localLocale = (Locale)localList.get(i);
          if ((paramString.equals(localLocale.getCountry())) && (localLocale.getVariant().length() == 0)) {
            ((List)localObject).add(localLocale);
          }
          i += 1;
        }
        localObject = Collections.unmodifiableList((List)localObject);
      }
      else
      {
        localObject = Collections.EMPTY_LIST;
      }
      cLanguagesByCountry.put(paramString, localObject);
    }
    return localObject;
  }
  
  public static List localeLookupList(Locale paramLocale)
  {
    return localeLookupList(paramLocale, paramLocale);
  }
  
  public static List localeLookupList(Locale paramLocale1, Locale paramLocale2)
  {
    ArrayList localArrayList = new ArrayList(4);
    if (paramLocale1 != null)
    {
      localArrayList.add(paramLocale1);
      if (paramLocale1.getVariant().length() > 0) {
        localArrayList.add(new Locale(paramLocale1.getLanguage(), paramLocale1.getCountry()));
      }
      if (paramLocale1.getCountry().length() > 0) {
        localArrayList.add(new Locale(paramLocale1.getLanguage(), ""));
      }
      if (!localArrayList.contains(paramLocale2)) {
        localArrayList.add(paramLocale2);
      }
    }
    return Collections.unmodifiableList(localArrayList);
  }
  
  public static Locale toLocale(String paramString)
  {
    if (paramString == null) {
      return null;
    }
    int i = paramString.length();
    if ((i != 2) && (i != 5) && (i < 7))
    {
      localStringBuffer = new StringBuffer();
      localStringBuffer.append("Invalid locale format: ");
      localStringBuffer.append(paramString);
      throw new IllegalArgumentException(localStringBuffer.toString());
    }
    int j = paramString.charAt(0);
    int k = paramString.charAt(1);
    if ((j >= 97) && (j <= 122) && (k >= 97) && (k <= 122))
    {
      if (i == 2) {
        return new Locale(paramString, "");
      }
      if (paramString.charAt(2) == '_')
      {
        j = paramString.charAt(3);
        if (j == 95) {
          return new Locale(paramString.substring(0, 2), "", paramString.substring(4));
        }
        k = paramString.charAt(4);
        if ((j >= 65) && (j <= 90) && (k >= 65) && (k <= 90))
        {
          if (i == 5) {
            return new Locale(paramString.substring(0, 2), paramString.substring(3, 5));
          }
          if (paramString.charAt(5) == '_') {
            return new Locale(paramString.substring(0, 2), paramString.substring(3, 5), paramString.substring(6));
          }
          localStringBuffer = new StringBuffer();
          localStringBuffer.append("Invalid locale format: ");
          localStringBuffer.append(paramString);
          throw new IllegalArgumentException(localStringBuffer.toString());
        }
        localStringBuffer = new StringBuffer();
        localStringBuffer.append("Invalid locale format: ");
        localStringBuffer.append(paramString);
        throw new IllegalArgumentException(localStringBuffer.toString());
      }
      localStringBuffer = new StringBuffer();
      localStringBuffer.append("Invalid locale format: ");
      localStringBuffer.append(paramString);
      throw new IllegalArgumentException(localStringBuffer.toString());
    }
    StringBuffer localStringBuffer = new StringBuffer();
    localStringBuffer.append("Invalid locale format: ");
    localStringBuffer.append(paramString);
    throw new IllegalArgumentException(localStringBuffer.toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     org.apache.commons.lang.LocaleUtils
 * JD-Core Version:    0.7.0.1
 */