package org.apache.commons.lang.text;

import java.util.ArrayList;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;

public class StrSubstitutor
{
  public static final char DEFAULT_ESCAPE = '$';
  public static final StrMatcher DEFAULT_PREFIX = StrMatcher.stringMatcher("${");
  public static final StrMatcher DEFAULT_SUFFIX = StrMatcher.stringMatcher("}");
  private boolean enableSubstitutionInVariables;
  private char escapeChar;
  private StrMatcher prefixMatcher;
  private StrMatcher suffixMatcher;
  private StrLookup variableResolver;
  
  public StrSubstitutor()
  {
    this((StrLookup)null, DEFAULT_PREFIX, DEFAULT_SUFFIX, '$');
  }
  
  public StrSubstitutor(Map paramMap)
  {
    this(StrLookup.mapLookup(paramMap), DEFAULT_PREFIX, DEFAULT_SUFFIX, '$');
  }
  
  public StrSubstitutor(Map paramMap, String paramString1, String paramString2)
  {
    this(StrLookup.mapLookup(paramMap), paramString1, paramString2, '$');
  }
  
  public StrSubstitutor(Map paramMap, String paramString1, String paramString2, char paramChar)
  {
    this(StrLookup.mapLookup(paramMap), paramString1, paramString2, paramChar);
  }
  
  public StrSubstitutor(StrLookup paramStrLookup)
  {
    this(paramStrLookup, DEFAULT_PREFIX, DEFAULT_SUFFIX, '$');
  }
  
  public StrSubstitutor(StrLookup paramStrLookup, String paramString1, String paramString2, char paramChar)
  {
    setVariableResolver(paramStrLookup);
    setVariablePrefix(paramString1);
    setVariableSuffix(paramString2);
    setEscapeChar(paramChar);
  }
  
  public StrSubstitutor(StrLookup paramStrLookup, StrMatcher paramStrMatcher1, StrMatcher paramStrMatcher2, char paramChar)
  {
    setVariableResolver(paramStrLookup);
    setVariablePrefixMatcher(paramStrMatcher1);
    setVariableSuffixMatcher(paramStrMatcher2);
    setEscapeChar(paramChar);
  }
  
  private void checkCyclicSubstitution(String paramString, List paramList)
  {
    if (!paramList.contains(paramString)) {
      return;
    }
    paramString = new StrBuilder(256);
    paramString.append("Infinite loop in property interpolation of ");
    paramString.append(paramList.remove(0));
    paramString.append(": ");
    paramString.appendWithSeparators(paramList, "->");
    throw new IllegalStateException(paramString.toString());
  }
  
  public static String replace(Object paramObject, Map paramMap)
  {
    return new StrSubstitutor(paramMap).replace(paramObject);
  }
  
  public static String replace(Object paramObject, Map paramMap, String paramString1, String paramString2)
  {
    return new StrSubstitutor(paramMap, paramString1, paramString2).replace(paramObject);
  }
  
  public static String replace(Object paramObject, Properties paramProperties)
  {
    if (paramProperties == null) {
      return paramObject.toString();
    }
    HashMap localHashMap = new HashMap();
    Enumeration localEnumeration = paramProperties.propertyNames();
    while (localEnumeration.hasMoreElements())
    {
      String str = (String)localEnumeration.nextElement();
      localHashMap.put(str, paramProperties.getProperty(str));
    }
    return replace(paramObject, localHashMap);
  }
  
  public static String replaceSystemProperties(Object paramObject)
  {
    return new StrSubstitutor(StrLookup.systemPropertiesLookup()).replace(paramObject);
  }
  
  private int substitute(StrBuilder paramStrBuilder, int paramInt1, int paramInt2, List paramList)
  {
    Object localObject1 = getVariablePrefixMatcher();
    Object localObject3 = getVariableSuffixMatcher();
    int i5 = getEscapeChar();
    int i2;
    if (paramList == null) {
      i2 = 1;
    } else {
      i2 = 0;
    }
    char[] arrayOfChar = paramStrBuilder.buffer;
    int k = paramInt1 + paramInt2;
    int j = 0;
    int m = 0;
    int i3 = paramInt1;
    Object localObject2 = paramList;
    paramList = (List)localObject3;
    while (i3 < k)
    {
      int i4 = ((StrMatcher)localObject1).isMatch(arrayOfChar, i3, paramInt1, k);
      int i;
      if (i4 == 0)
      {
        i = i3 + 1;
        localObject3 = paramList;
        paramList = (List)localObject1;
        localObject1 = localObject3;
      }
      else
      {
        if (i3 > paramInt1)
        {
          i = i3 - 1;
          if (arrayOfChar[i] == i5)
          {
            paramStrBuilder.deleteCharAt(i);
            arrayOfChar = paramStrBuilder.buffer;
            j -= 1;
            k -= 1;
            localObject3 = paramList;
            m = 1;
            i = i3;
            paramList = (List)localObject1;
            localObject1 = localObject3;
            break label568;
          }
        }
        int i1 = i3 + i4;
        i = i1;
        int n = 0;
        while (i < k)
        {
          if (isEnableSubstitutionInVariables())
          {
            i6 = ((StrMatcher)localObject1).isMatch(arrayOfChar, i, paramInt1, k);
            if (i6 != 0)
            {
              n += 1;
              i += i6;
              continue;
            }
          }
          int i6 = paramList.isMatch(arrayOfChar, i, paramInt1, k);
          if (i6 == 0)
          {
            i += 1;
          }
          else
          {
            if (n == 0)
            {
              localObject3 = paramList;
              String str = new String(arrayOfChar, i1, i - i3 - i4);
              if (isEnableSubstitutionInVariables())
              {
                paramList = new StrBuilder(str);
                substitute(paramList, 0, paramList.length());
                str = paramList.toString();
              }
              i4 = i + i6;
              paramList = (List)localObject2;
              if (localObject2 == null)
              {
                paramList = new ArrayList();
                paramList.add(new String(arrayOfChar, paramInt1, paramInt2));
              }
              checkCyclicSubstitution(str, paramList);
              paramList.add(str);
              localObject2 = resolveVariable(str, paramStrBuilder, i3, i4);
              i = i4;
              i1 = k;
              n = j;
              if (localObject2 != null)
              {
                i = ((String)localObject2).length();
                paramStrBuilder.replace(i3, i4, (String)localObject2);
                m = substitute(paramStrBuilder, i3, i, paramList) + (i - (i4 - i3));
                i = i4 + m;
                i1 = k + m;
                n = j + m;
                arrayOfChar = paramStrBuilder.buffer;
                m = 1;
              }
              paramList.remove(paramList.size() - 1);
              k = i1;
              j = n;
              localObject2 = paramList;
              paramList = (List)localObject1;
              localObject1 = localObject3;
              break label568;
            }
            n -= 1;
            i += i6;
          }
        }
        localObject3 = localObject1;
        localObject1 = paramList;
        paramList = (List)localObject3;
      }
      label568:
      localObject3 = localObject1;
      localObject1 = paramList;
      paramList = (List)localObject3;
      i3 = i;
    }
    if (i2 != 0) {
      return m;
    }
    return j;
  }
  
  public char getEscapeChar()
  {
    return this.escapeChar;
  }
  
  public StrMatcher getVariablePrefixMatcher()
  {
    return this.prefixMatcher;
  }
  
  public StrLookup getVariableResolver()
  {
    return this.variableResolver;
  }
  
  public StrMatcher getVariableSuffixMatcher()
  {
    return this.suffixMatcher;
  }
  
  public boolean isEnableSubstitutionInVariables()
  {
    return this.enableSubstitutionInVariables;
  }
  
  public String replace(Object paramObject)
  {
    if (paramObject == null) {
      return null;
    }
    paramObject = new StrBuilder().append(paramObject);
    substitute(paramObject, 0, paramObject.length());
    return paramObject.toString();
  }
  
  public String replace(String paramString)
  {
    if (paramString == null) {
      return null;
    }
    StrBuilder localStrBuilder = new StrBuilder(paramString);
    if (!substitute(localStrBuilder, 0, paramString.length())) {
      return paramString;
    }
    return localStrBuilder.toString();
  }
  
  public String replace(String paramString, int paramInt1, int paramInt2)
  {
    if (paramString == null) {
      return null;
    }
    StrBuilder localStrBuilder = new StrBuilder(paramInt2).append(paramString, paramInt1, paramInt2);
    if (!substitute(localStrBuilder, 0, paramInt2)) {
      return paramString.substring(paramInt1, paramInt2 + paramInt1);
    }
    return localStrBuilder.toString();
  }
  
  public String replace(StringBuffer paramStringBuffer)
  {
    if (paramStringBuffer == null) {
      return null;
    }
    paramStringBuffer = new StrBuilder(paramStringBuffer.length()).append(paramStringBuffer);
    substitute(paramStringBuffer, 0, paramStringBuffer.length());
    return paramStringBuffer.toString();
  }
  
  public String replace(StringBuffer paramStringBuffer, int paramInt1, int paramInt2)
  {
    if (paramStringBuffer == null) {
      return null;
    }
    paramStringBuffer = new StrBuilder(paramInt2).append(paramStringBuffer, paramInt1, paramInt2);
    substitute(paramStringBuffer, 0, paramInt2);
    return paramStringBuffer.toString();
  }
  
  public String replace(StrBuilder paramStrBuilder)
  {
    if (paramStrBuilder == null) {
      return null;
    }
    paramStrBuilder = new StrBuilder(paramStrBuilder.length()).append(paramStrBuilder);
    substitute(paramStrBuilder, 0, paramStrBuilder.length());
    return paramStrBuilder.toString();
  }
  
  public String replace(StrBuilder paramStrBuilder, int paramInt1, int paramInt2)
  {
    if (paramStrBuilder == null) {
      return null;
    }
    paramStrBuilder = new StrBuilder(paramInt2).append(paramStrBuilder, paramInt1, paramInt2);
    substitute(paramStrBuilder, 0, paramInt2);
    return paramStrBuilder.toString();
  }
  
  public String replace(char[] paramArrayOfChar)
  {
    if (paramArrayOfChar == null) {
      return null;
    }
    StrBuilder localStrBuilder = new StrBuilder(paramArrayOfChar.length).append(paramArrayOfChar);
    substitute(localStrBuilder, 0, paramArrayOfChar.length);
    return localStrBuilder.toString();
  }
  
  public String replace(char[] paramArrayOfChar, int paramInt1, int paramInt2)
  {
    if (paramArrayOfChar == null) {
      return null;
    }
    paramArrayOfChar = new StrBuilder(paramInt2).append(paramArrayOfChar, paramInt1, paramInt2);
    substitute(paramArrayOfChar, 0, paramInt2);
    return paramArrayOfChar.toString();
  }
  
  public boolean replaceIn(StringBuffer paramStringBuffer)
  {
    if (paramStringBuffer == null) {
      return false;
    }
    return replaceIn(paramStringBuffer, 0, paramStringBuffer.length());
  }
  
  public boolean replaceIn(StringBuffer paramStringBuffer, int paramInt1, int paramInt2)
  {
    if (paramStringBuffer == null) {
      return false;
    }
    StrBuilder localStrBuilder = new StrBuilder(paramInt2).append(paramStringBuffer, paramInt1, paramInt2);
    if (!substitute(localStrBuilder, 0, paramInt2)) {
      return false;
    }
    paramStringBuffer.replace(paramInt1, paramInt2 + paramInt1, localStrBuilder.toString());
    return true;
  }
  
  public boolean replaceIn(StrBuilder paramStrBuilder)
  {
    if (paramStrBuilder == null) {
      return false;
    }
    return substitute(paramStrBuilder, 0, paramStrBuilder.length());
  }
  
  public boolean replaceIn(StrBuilder paramStrBuilder, int paramInt1, int paramInt2)
  {
    if (paramStrBuilder == null) {
      return false;
    }
    return substitute(paramStrBuilder, paramInt1, paramInt2);
  }
  
  protected String resolveVariable(String paramString, StrBuilder paramStrBuilder, int paramInt1, int paramInt2)
  {
    paramStrBuilder = getVariableResolver();
    if (paramStrBuilder == null) {
      return null;
    }
    return paramStrBuilder.lookup(paramString);
  }
  
  public void setEnableSubstitutionInVariables(boolean paramBoolean)
  {
    this.enableSubstitutionInVariables = paramBoolean;
  }
  
  public void setEscapeChar(char paramChar)
  {
    this.escapeChar = paramChar;
  }
  
  public StrSubstitutor setVariablePrefix(char paramChar)
  {
    return setVariablePrefixMatcher(StrMatcher.charMatcher(paramChar));
  }
  
  public StrSubstitutor setVariablePrefix(String paramString)
  {
    if (paramString != null) {
      return setVariablePrefixMatcher(StrMatcher.stringMatcher(paramString));
    }
    throw new IllegalArgumentException("Variable prefix must not be null!");
  }
  
  public StrSubstitutor setVariablePrefixMatcher(StrMatcher paramStrMatcher)
  {
    if (paramStrMatcher != null)
    {
      this.prefixMatcher = paramStrMatcher;
      return this;
    }
    throw new IllegalArgumentException("Variable prefix matcher must not be null!");
  }
  
  public void setVariableResolver(StrLookup paramStrLookup)
  {
    this.variableResolver = paramStrLookup;
  }
  
  public StrSubstitutor setVariableSuffix(char paramChar)
  {
    return setVariableSuffixMatcher(StrMatcher.charMatcher(paramChar));
  }
  
  public StrSubstitutor setVariableSuffix(String paramString)
  {
    if (paramString != null) {
      return setVariableSuffixMatcher(StrMatcher.stringMatcher(paramString));
    }
    throw new IllegalArgumentException("Variable suffix must not be null!");
  }
  
  public StrSubstitutor setVariableSuffixMatcher(StrMatcher paramStrMatcher)
  {
    if (paramStrMatcher != null)
    {
      this.suffixMatcher = paramStrMatcher;
      return this;
    }
    throw new IllegalArgumentException("Variable suffix matcher must not be null!");
  }
  
  protected boolean substitute(StrBuilder paramStrBuilder, int paramInt1, int paramInt2)
  {
    return substitute(paramStrBuilder, paramInt1, paramInt2, null) > 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     org.apache.commons.lang.text.StrSubstitutor
 * JD-Core Version:    0.7.0.1
 */