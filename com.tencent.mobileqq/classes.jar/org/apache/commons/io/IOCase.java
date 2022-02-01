package org.apache.commons.io;

import java.io.Serializable;

public enum IOCase
  implements Serializable
{
  private static final long serialVersionUID = -6343169151696340687L;
  private final String name;
  private final transient boolean sensitive;
  
  static
  {
    INSENSITIVE = new IOCase("INSENSITIVE", 1, "Insensitive", false);
    if (!FilenameUtils.isSystemWindows()) {}
    for (boolean bool = true;; bool = false)
    {
      SYSTEM = new IOCase("SYSTEM", 2, "System", bool);
      $VALUES = new IOCase[] { SENSITIVE, INSENSITIVE, SYSTEM };
      return;
    }
  }
  
  private IOCase(String paramString, boolean paramBoolean)
  {
    this.name = paramString;
    this.sensitive = paramBoolean;
  }
  
  public static IOCase forName(String paramString)
  {
    IOCase[] arrayOfIOCase = values();
    int j = arrayOfIOCase.length;
    int i = 0;
    while (i < j)
    {
      IOCase localIOCase = arrayOfIOCase[i];
      if (localIOCase.getName().equals(paramString)) {
        return localIOCase;
      }
      i += 1;
    }
    throw new IllegalArgumentException("Invalid IOCase name: " + paramString);
  }
  
  private Object readResolve()
  {
    return forName(this.name);
  }
  
  public int checkCompareTo(String paramString1, String paramString2)
  {
    if ((paramString1 == null) || (paramString2 == null)) {
      throw new NullPointerException("The strings must not be null");
    }
    if (this.sensitive) {
      return paramString1.compareTo(paramString2);
    }
    return paramString1.compareToIgnoreCase(paramString2);
  }
  
  public boolean checkEndsWith(String paramString1, String paramString2)
  {
    int i = paramString2.length();
    if (!this.sensitive) {}
    for (boolean bool = true;; bool = false) {
      return paramString1.regionMatches(bool, paramString1.length() - i, paramString2, 0, i);
    }
  }
  
  public boolean checkEquals(String paramString1, String paramString2)
  {
    if ((paramString1 == null) || (paramString2 == null)) {
      throw new NullPointerException("The strings must not be null");
    }
    if (this.sensitive) {
      return paramString1.equals(paramString2);
    }
    return paramString1.equalsIgnoreCase(paramString2);
  }
  
  public int checkIndexOf(String paramString1, int paramInt, String paramString2)
  {
    int i = paramString1.length() - paramString2.length();
    if (i >= paramInt) {
      while (paramInt <= i)
      {
        if (checkRegionMatches(paramString1, paramInt, paramString2)) {
          return paramInt;
        }
        paramInt += 1;
      }
    }
    return -1;
  }
  
  public boolean checkRegionMatches(String paramString1, int paramInt, String paramString2)
  {
    if (!this.sensitive) {}
    for (boolean bool = true;; bool = false) {
      return paramString1.regionMatches(bool, paramInt, paramString2, 0, paramString2.length());
    }
  }
  
  public boolean checkStartsWith(String paramString1, String paramString2)
  {
    if (!this.sensitive) {}
    for (boolean bool = true;; bool = false) {
      return paramString1.regionMatches(bool, 0, paramString2, 0, paramString2.length());
    }
  }
  
  public String getName()
  {
    return this.name;
  }
  
  public boolean isCaseSensitive()
  {
    return this.sensitive;
  }
  
  public String toString()
  {
    return this.name;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     org.apache.commons.io.IOCase
 * JD-Core Version:    0.7.0.1
 */