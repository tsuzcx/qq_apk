package org.apache.commons.lang;

import java.io.Serializable;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class CharSet
  implements Serializable
{
  public static final CharSet ASCII_ALPHA;
  public static final CharSet ASCII_ALPHA_LOWER;
  public static final CharSet ASCII_ALPHA_UPPER;
  public static final CharSet ASCII_NUMERIC;
  protected static final Map COMMON;
  public static final CharSet EMPTY = new CharSet((String)null);
  private static final long serialVersionUID = 5947847346149275958L;
  private final Set set = Collections.synchronizedSet(new HashSet());
  
  static
  {
    ASCII_ALPHA = new CharSet("a-zA-Z");
    ASCII_ALPHA_LOWER = new CharSet("a-z");
    ASCII_ALPHA_UPPER = new CharSet("A-Z");
    ASCII_NUMERIC = new CharSet("0-9");
    COMMON = Collections.synchronizedMap(new HashMap());
    COMMON.put(null, EMPTY);
    COMMON.put("", EMPTY);
    COMMON.put("a-zA-Z", ASCII_ALPHA);
    COMMON.put("A-Za-z", ASCII_ALPHA);
    COMMON.put("a-z", ASCII_ALPHA_LOWER);
    COMMON.put("A-Z", ASCII_ALPHA_UPPER);
    COMMON.put("0-9", ASCII_NUMERIC);
  }
  
  protected CharSet(String paramString)
  {
    add(paramString);
  }
  
  protected CharSet(String[] paramArrayOfString)
  {
    int j = paramArrayOfString.length;
    int i = 0;
    while (i < j)
    {
      add(paramArrayOfString[i]);
      i += 1;
    }
  }
  
  public static CharSet getInstance(String paramString)
  {
    Object localObject = COMMON.get(paramString);
    if (localObject != null) {
      return (CharSet)localObject;
    }
    return new CharSet(paramString);
  }
  
  public static CharSet getInstance(String[] paramArrayOfString)
  {
    if (paramArrayOfString == null) {
      return null;
    }
    return new CharSet(paramArrayOfString);
  }
  
  protected void add(String paramString)
  {
    if (paramString == null) {
      return;
    }
    int j = paramString.length();
    int i = 0;
    while (i < j)
    {
      int k = j - i;
      if ((k >= 4) && (paramString.charAt(i) == '^') && (paramString.charAt(i + 2) == '-'))
      {
        this.set.add(CharRange.isNotIn(paramString.charAt(i + 1), paramString.charAt(i + 3)));
        i += 4;
      }
      else if ((k >= 3) && (paramString.charAt(i + 1) == '-'))
      {
        this.set.add(CharRange.isIn(paramString.charAt(i), paramString.charAt(i + 2)));
        i += 3;
      }
      else if ((k >= 2) && (paramString.charAt(i) == '^'))
      {
        this.set.add(CharRange.isNot(paramString.charAt(i + 1)));
        i += 2;
      }
      else
      {
        this.set.add(CharRange.is(paramString.charAt(i)));
        i += 1;
      }
    }
  }
  
  public boolean contains(char paramChar)
  {
    Iterator localIterator = this.set.iterator();
    while (localIterator.hasNext()) {
      if (((CharRange)localIterator.next()).contains(paramChar)) {
        return true;
      }
    }
    return false;
  }
  
  public boolean equals(Object paramObject)
  {
    if (paramObject == this) {
      return true;
    }
    if (!(paramObject instanceof CharSet)) {
      return false;
    }
    paramObject = (CharSet)paramObject;
    return this.set.equals(paramObject.set);
  }
  
  public CharRange[] getCharRanges()
  {
    Set localSet = this.set;
    return (CharRange[])localSet.toArray(new CharRange[localSet.size()]);
  }
  
  public int hashCode()
  {
    return this.set.hashCode() + 89;
  }
  
  public String toString()
  {
    return this.set.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     org.apache.commons.lang.CharSet
 * JD-Core Version:    0.7.0.1
 */