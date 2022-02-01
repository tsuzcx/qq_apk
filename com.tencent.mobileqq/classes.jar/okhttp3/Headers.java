package okhttp3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;
import javax.annotation.Nullable;
import okhttp3.internal.Util;
import okhttp3.internal.http.HttpDate;

public final class Headers
{
  private final String[] namesAndValues;
  
  Headers(Headers.Builder paramBuilder)
  {
    this.namesAndValues = ((String[])paramBuilder.namesAndValues.toArray(new String[paramBuilder.namesAndValues.size()]));
  }
  
  private Headers(String[] paramArrayOfString)
  {
    this.namesAndValues = paramArrayOfString;
  }
  
  static void checkName(String paramString)
  {
    if (paramString != null)
    {
      if (!paramString.isEmpty())
      {
        int j = paramString.length();
        int i = 0;
        while (i < j)
        {
          int k = paramString.charAt(i);
          if ((k > 32) && (k < 127)) {
            i += 1;
          } else {
            throw new IllegalArgumentException(Util.format("Unexpected char %#04x at %d in header name: %s", new Object[] { Integer.valueOf(k), Integer.valueOf(i), paramString }));
          }
        }
        return;
      }
      throw new IllegalArgumentException("name is empty");
    }
    paramString = new NullPointerException("name == null");
    for (;;)
    {
      throw paramString;
    }
  }
  
  static void checkValue(String paramString1, String paramString2)
  {
    if (paramString1 != null)
    {
      int j = paramString1.length();
      int i = 0;
      while (i < j)
      {
        int k = paramString1.charAt(i);
        if (((k > 31) || (k == 9)) && (k < 127)) {
          i += 1;
        } else {
          throw new IllegalArgumentException(Util.format("Unexpected char %#04x at %d in %s value: %s", new Object[] { Integer.valueOf(k), Integer.valueOf(i), paramString2, paramString1 }));
        }
      }
      return;
    }
    paramString1 = new StringBuilder();
    paramString1.append("value for name ");
    paramString1.append(paramString2);
    paramString1.append(" == null");
    paramString1 = new NullPointerException(paramString1.toString());
    for (;;)
    {
      throw paramString1;
    }
  }
  
  private static String get(String[] paramArrayOfString, String paramString)
  {
    int i = paramArrayOfString.length - 2;
    while (i >= 0)
    {
      if (paramString.equalsIgnoreCase(paramArrayOfString[i])) {
        return paramArrayOfString[(i + 1)];
      }
      i -= 2;
    }
    return null;
  }
  
  public static Headers of(Map<String, String> paramMap)
  {
    if (paramMap != null)
    {
      String[] arrayOfString = new String[paramMap.size() * 2];
      int i = 0;
      paramMap = paramMap.entrySet().iterator();
      while (paramMap.hasNext())
      {
        Object localObject = (Map.Entry)paramMap.next();
        if ((((Map.Entry)localObject).getKey() != null) && (((Map.Entry)localObject).getValue() != null))
        {
          String str = ((String)((Map.Entry)localObject).getKey()).trim();
          localObject = ((String)((Map.Entry)localObject).getValue()).trim();
          checkName(str);
          checkValue((String)localObject, str);
          arrayOfString[i] = str;
          arrayOfString[(i + 1)] = localObject;
          i += 2;
        }
        else
        {
          throw new IllegalArgumentException("Headers cannot be null");
        }
      }
      return new Headers(arrayOfString);
    }
    paramMap = new NullPointerException("headers == null");
    for (;;)
    {
      throw paramMap;
    }
  }
  
  public static Headers of(String... paramVarArgs)
  {
    if (paramVarArgs != null)
    {
      if (paramVarArgs.length % 2 == 0)
      {
        paramVarArgs = (String[])paramVarArgs.clone();
        int k = 0;
        int i = 0;
        int j;
        for (;;)
        {
          j = k;
          if (i >= paramVarArgs.length) {
            break label63;
          }
          if (paramVarArgs[i] == null) {
            break;
          }
          paramVarArgs[i] = paramVarArgs[i].trim();
          i += 1;
        }
        throw new IllegalArgumentException("Headers cannot be null");
        label63:
        while (j < paramVarArgs.length)
        {
          String str1 = paramVarArgs[j];
          String str2 = paramVarArgs[(j + 1)];
          checkName(str1);
          checkValue(str2, str1);
          j += 2;
        }
        return new Headers(paramVarArgs);
      }
      throw new IllegalArgumentException("Expected alternating header names and values");
    }
    paramVarArgs = new NullPointerException("namesAndValues == null");
    for (;;)
    {
      throw paramVarArgs;
    }
  }
  
  public long byteCount()
  {
    String[] arrayOfString = this.namesAndValues;
    long l = arrayOfString.length * 2;
    int j = arrayOfString.length;
    int i = 0;
    while (i < j)
    {
      l += this.namesAndValues[i].length();
      i += 1;
    }
    return l;
  }
  
  public boolean equals(@Nullable Object paramObject)
  {
    return ((paramObject instanceof Headers)) && (Arrays.equals(((Headers)paramObject).namesAndValues, this.namesAndValues));
  }
  
  @Nullable
  public String get(String paramString)
  {
    return get(this.namesAndValues, paramString);
  }
  
  @Nullable
  public Date getDate(String paramString)
  {
    paramString = get(paramString);
    if (paramString != null) {
      return HttpDate.parse(paramString);
    }
    return null;
  }
  
  public int hashCode()
  {
    return Arrays.hashCode(this.namesAndValues);
  }
  
  public String name(int paramInt)
  {
    return this.namesAndValues[(paramInt * 2)];
  }
  
  public Set<String> names()
  {
    TreeSet localTreeSet = new TreeSet(String.CASE_INSENSITIVE_ORDER);
    int j = size();
    int i = 0;
    while (i < j)
    {
      localTreeSet.add(name(i));
      i += 1;
    }
    return Collections.unmodifiableSet(localTreeSet);
  }
  
  public Headers.Builder newBuilder()
  {
    Headers.Builder localBuilder = new Headers.Builder();
    Collections.addAll(localBuilder.namesAndValues, this.namesAndValues);
    return localBuilder;
  }
  
  public int size()
  {
    return this.namesAndValues.length / 2;
  }
  
  public Map<String, List<String>> toMultimap()
  {
    TreeMap localTreeMap = new TreeMap(String.CASE_INSENSITIVE_ORDER);
    int j = size();
    int i = 0;
    while (i < j)
    {
      String str = name(i).toLowerCase(Locale.US);
      List localList = (List)localTreeMap.get(str);
      Object localObject = localList;
      if (localList == null)
      {
        localObject = new ArrayList(2);
        localTreeMap.put(str, localObject);
      }
      ((List)localObject).add(value(i));
      i += 1;
    }
    return localTreeMap;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    int j = size();
    int i = 0;
    while (i < j)
    {
      localStringBuilder.append(name(i));
      localStringBuilder.append(": ");
      localStringBuilder.append(value(i));
      localStringBuilder.append("\n");
      i += 1;
    }
    return localStringBuilder.toString();
  }
  
  public String value(int paramInt)
  {
    return this.namesAndValues[(paramInt * 2 + 1)];
  }
  
  public List<String> values(String paramString)
  {
    int j = size();
    Object localObject1 = null;
    int i = 0;
    while (i < j)
    {
      Object localObject2 = localObject1;
      if (paramString.equalsIgnoreCase(name(i)))
      {
        localObject2 = localObject1;
        if (localObject1 == null) {
          localObject2 = new ArrayList(2);
        }
        ((List)localObject2).add(value(i));
      }
      i += 1;
      localObject1 = localObject2;
    }
    if (localObject1 != null) {
      return Collections.unmodifiableList(localObject1);
    }
    return Collections.emptyList();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     okhttp3.Headers
 * JD-Core Version:    0.7.0.1
 */