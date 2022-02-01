package org.apache.commons.io;

import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.Stack;

public class FilenameUtils
{
  public static final char EXTENSION_SEPARATOR = '.';
  public static final String EXTENSION_SEPARATOR_STR = Character.toString('.');
  private static final int NOT_FOUND = -1;
  private static final char OTHER_SEPARATOR = '\\';
  private static final char SYSTEM_SEPARATOR = File.separatorChar;
  private static final char UNIX_SEPARATOR = '/';
  private static final char WINDOWS_SEPARATOR = '\\';
  
  static
  {
    if (isSystemWindows())
    {
      OTHER_SEPARATOR = '/';
      return;
    }
  }
  
  public static String concat(String paramString1, String paramString2)
  {
    int i = getPrefixLength(paramString2);
    if (i < 0) {
      return null;
    }
    if (i > 0) {
      return normalize(paramString2);
    }
    if (paramString1 == null) {
      return null;
    }
    i = paramString1.length();
    if (i == 0) {
      return normalize(paramString2);
    }
    if (isSeparator(paramString1.charAt(i - 1)))
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramString1);
      localStringBuilder.append(paramString2);
      return normalize(localStringBuilder.toString());
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramString1);
    localStringBuilder.append('/');
    localStringBuilder.append(paramString2);
    return normalize(localStringBuilder.toString());
  }
  
  public static boolean directoryContains(String paramString1, String paramString2)
  {
    if (paramString1 != null)
    {
      if (paramString2 == null) {
        return false;
      }
      if (IOCase.SYSTEM.checkEquals(paramString1, paramString2)) {
        return false;
      }
      return IOCase.SYSTEM.checkStartsWith(paramString2, paramString1);
    }
    throw new IllegalArgumentException("Directory must not be null");
  }
  
  private static String doGetFullPath(String paramString, boolean paramBoolean)
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.copyTypes(TypeTransformer.java:311)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.fixTypes(TypeTransformer.java:226)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:207)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
  
  private static String doGetPath(String paramString, int paramInt)
  {
    if (paramString == null) {
      return null;
    }
    int i = getPrefixLength(paramString);
    if (i < 0) {
      return null;
    }
    int j = indexOfLastSeparator(paramString);
    paramInt += j;
    if ((i < paramString.length()) && (j >= 0) && (i < paramInt))
    {
      paramString = paramString.substring(i, paramInt);
      failIfNullBytePresent(paramString);
      return paramString;
    }
    return "";
  }
  
  private static String doNormalize(String paramString, char paramChar, boolean paramBoolean)
  {
    if (paramString == null) {
      return null;
    }
    failIfNullBytePresent(paramString);
    char c3 = paramString.length();
    if (c3 == 0) {
      return paramString;
    }
    char c8 = getPrefixLength(paramString);
    if (c8 < 0) {
      return null;
    }
    char[] arrayOfChar = new char[c3 + '\002'];
    paramString.getChars(0, paramString.length(), arrayOfChar, 0);
    char c2 = SYSTEM_SEPARATOR;
    char c1 = c2;
    if (paramChar == c2) {
      c1 = OTHER_SEPARATOR;
    }
    c2 = '\000';
    while (c2 < arrayOfChar.length)
    {
      if (arrayOfChar[c2] == c1) {
        arrayOfChar[c2] = paramChar;
      }
      c2 += '\001';
    }
    if (arrayOfChar[(c3 - '\001')] != paramChar)
    {
      c1 = c3 + '\001';
      arrayOfChar[c3] = paramChar;
      c2 = '\000';
      c3 = c1;
      c1 = c2;
    }
    else
    {
      c1 = '\001';
    }
    c2 = c8 + '\001';
    char c4 = c2;
    char c7;
    while (c4 < c3)
    {
      c6 = c4;
      c5 = c3;
      if (arrayOfChar[c4] == paramChar)
      {
        c7 = c4 - '\001';
        c6 = c4;
        c5 = c3;
        if (arrayOfChar[c7] == paramChar)
        {
          System.arraycopy(arrayOfChar, c4, arrayOfChar, c7, c3 - c4);
          c5 = c3 - '\001';
          c6 = c4 - '\001';
        }
      }
      c4 = c6 + '\001';
      c3 = c5;
    }
    c4 = c2;
    while (c4 < c3)
    {
      c7 = c4;
      c6 = c1;
      c5 = c3;
      if (arrayOfChar[c4] == paramChar)
      {
        int i = c4 - '\001';
        c7 = c4;
        c6 = c1;
        c5 = c3;
        if (arrayOfChar[i] == '.') {
          if (c4 != c2)
          {
            c7 = c4;
            c6 = c1;
            c5 = c3;
            if (arrayOfChar[(c4 - '\002')] != paramChar) {}
          }
          else
          {
            if (c4 == c3 - '\001') {
              c1 = '\001';
            }
            System.arraycopy(arrayOfChar, c4 + '\001', arrayOfChar, i, c3 - c4);
            c5 = c3 - '\002';
            c7 = c4 - '\001';
            c6 = c1;
          }
        }
      }
      c4 = c7 + '\001';
      c1 = c6;
      c3 = c5;
    }
    char c6 = c8 + '\002';
    c4 = c1;
    c1 = c6;
    char c5 = c3;
    while (c1 < c5)
    {
      if ((arrayOfChar[c1] == paramChar) && (arrayOfChar[(c1 - '\001')] == '.') && (arrayOfChar[(c1 - '\002')] == '.') && ((c1 == c6) || (arrayOfChar[(c1 - '\003')] == paramChar)))
      {
        if (c1 == c6) {
          return null;
        }
        c3 = c4;
        if (c1 == c5 - '\001') {
          c3 = '\001';
        }
        c4 = c1 - '\004';
        while (c4 >= c8)
        {
          if (arrayOfChar[c4] == paramChar)
          {
            c7 = c4 + '\001';
            System.arraycopy(arrayOfChar, c1 + '\001', arrayOfChar, c7, c5 - c1);
            c4 = c5 - (c1 - c4);
            c1 = c7;
            break label592;
          }
          c4 -= '\001';
        }
        c4 = c1 + '\001';
        System.arraycopy(arrayOfChar, c4, arrayOfChar, c8, c5 - c1);
        c4 = c5 - (c4 - c8);
        c1 = c2;
      }
      else
      {
        c3 = c4;
        c4 = c5;
      }
      label592:
      c1 += '\001';
      c5 = c4;
      c4 = c3;
    }
    if (c5 <= 0) {
      return "";
    }
    if (c5 <= c8) {
      return new String(arrayOfChar, 0, c5);
    }
    if ((c4 != 0) && (paramBoolean)) {
      return new String(arrayOfChar, 0, c5);
    }
    return new String(arrayOfChar, 0, c5 - '\001');
  }
  
  public static boolean equals(String paramString1, String paramString2)
  {
    return equals(paramString1, paramString2, false, IOCase.SENSITIVE);
  }
  
  public static boolean equals(String paramString1, String paramString2, boolean paramBoolean, IOCase paramIOCase)
  {
    if ((paramString1 != null) && (paramString2 != null))
    {
      String str1 = paramString1;
      String str2 = paramString2;
      if (paramBoolean)
      {
        str1 = normalize(paramString1);
        str2 = normalize(paramString2);
        if ((str1 == null) || (str2 == null)) {
          throw new NullPointerException("Error normalizing one or both of the file names");
        }
      }
      paramString1 = paramIOCase;
      if (paramIOCase == null) {
        paramString1 = IOCase.SENSITIVE;
      }
      return paramString1.checkEquals(str1, str2);
    }
    return (paramString1 == null) && (paramString2 == null);
  }
  
  public static boolean equalsNormalized(String paramString1, String paramString2)
  {
    return equals(paramString1, paramString2, true, IOCase.SENSITIVE);
  }
  
  public static boolean equalsNormalizedOnSystem(String paramString1, String paramString2)
  {
    return equals(paramString1, paramString2, true, IOCase.SYSTEM);
  }
  
  public static boolean equalsOnSystem(String paramString1, String paramString2)
  {
    return equals(paramString1, paramString2, false, IOCase.SYSTEM);
  }
  
  private static void failIfNullBytePresent(String paramString)
  {
    int j = paramString.length();
    int i = 0;
    while (i < j) {
      if (paramString.charAt(i) != 0) {
        i += 1;
      } else {
        throw new IllegalArgumentException("Null byte present in file/path name. There are no known legitimate use cases for such data, but several injection attacks may use it");
      }
    }
  }
  
  public static String getBaseName(String paramString)
  {
    return removeExtension(getName(paramString));
  }
  
  public static String getExtension(String paramString)
  {
    if (paramString == null) {
      return null;
    }
    int i = indexOfExtension(paramString);
    if (i == -1) {
      return "";
    }
    return paramString.substring(i + 1);
  }
  
  public static String getFullPath(String paramString)
  {
    return doGetFullPath(paramString, true);
  }
  
  public static String getFullPathNoEndSeparator(String paramString)
  {
    return doGetFullPath(paramString, false);
  }
  
  public static String getName(String paramString)
  {
    if (paramString == null) {
      return null;
    }
    failIfNullBytePresent(paramString);
    return paramString.substring(indexOfLastSeparator(paramString) + 1);
  }
  
  public static String getPath(String paramString)
  {
    return doGetPath(paramString, 1);
  }
  
  public static String getPathNoEndSeparator(String paramString)
  {
    return doGetPath(paramString, 0);
  }
  
  public static String getPrefix(String paramString)
  {
    if (paramString == null) {
      return null;
    }
    int i = getPrefixLength(paramString);
    if (i < 0) {
      return null;
    }
    if (i > paramString.length())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramString);
      localStringBuilder.append('/');
      failIfNullBytePresent(localStringBuilder.toString());
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramString);
      localStringBuilder.append('/');
      return localStringBuilder.toString();
    }
    paramString = paramString.substring(0, i);
    failIfNullBytePresent(paramString);
    return paramString;
  }
  
  public static int getPrefixLength(String paramString)
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.provideAs(TypeTransformer.java:780)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.enexpr(TypeTransformer.java:659)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:719)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.s1stmt(TypeTransformer.java:810)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.sxStmt(TypeTransformer.java:840)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:206)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
  
  public static int indexOfExtension(String paramString)
  {
    if (paramString == null) {
      return -1;
    }
    int i = paramString.lastIndexOf('.');
    if (indexOfLastSeparator(paramString) > i) {
      return -1;
    }
    return i;
  }
  
  public static int indexOfLastSeparator(String paramString)
  {
    if (paramString == null) {
      return -1;
    }
    return Math.max(paramString.lastIndexOf('/'), paramString.lastIndexOf('\\'));
  }
  
  public static boolean isExtension(String paramString1, String paramString2)
  {
    boolean bool = false;
    if (paramString1 == null) {
      return false;
    }
    failIfNullBytePresent(paramString1);
    if ((paramString2 != null) && (!paramString2.isEmpty())) {
      return getExtension(paramString1).equals(paramString2);
    }
    if (indexOfExtension(paramString1) == -1) {
      bool = true;
    }
    return bool;
  }
  
  public static boolean isExtension(String paramString, Collection<String> paramCollection)
  {
    boolean bool = false;
    if (paramString == null) {
      return false;
    }
    failIfNullBytePresent(paramString);
    if ((paramCollection != null) && (!paramCollection.isEmpty()))
    {
      paramString = getExtension(paramString);
      paramCollection = paramCollection.iterator();
      while (paramCollection.hasNext()) {
        if (paramString.equals((String)paramCollection.next())) {
          return true;
        }
      }
      return false;
    }
    if (indexOfExtension(paramString) == -1) {
      bool = true;
    }
    return bool;
  }
  
  public static boolean isExtension(String paramString, String[] paramArrayOfString)
  {
    boolean bool = false;
    if (paramString == null) {
      return false;
    }
    failIfNullBytePresent(paramString);
    if ((paramArrayOfString != null) && (paramArrayOfString.length != 0))
    {
      paramString = getExtension(paramString);
      int j = paramArrayOfString.length;
      int i = 0;
      while (i < j)
      {
        if (paramString.equals(paramArrayOfString[i])) {
          return true;
        }
        i += 1;
      }
      return false;
    }
    if (indexOfExtension(paramString) == -1) {
      bool = true;
    }
    return bool;
  }
  
  private static boolean isSeparator(char paramChar)
  {
    return (paramChar == '/') || (paramChar == '\\');
  }
  
  static boolean isSystemWindows()
  {
    return SYSTEM_SEPARATOR == '\\';
  }
  
  public static String normalize(String paramString)
  {
    return doNormalize(paramString, SYSTEM_SEPARATOR, true);
  }
  
  public static String normalize(String paramString, boolean paramBoolean)
  {
    char c;
    if (paramBoolean) {
      c = '/';
    } else {
      c = '\\';
    }
    return doNormalize(paramString, c, true);
  }
  
  public static String normalizeNoEndSeparator(String paramString)
  {
    return doNormalize(paramString, SYSTEM_SEPARATOR, false);
  }
  
  public static String normalizeNoEndSeparator(String paramString, boolean paramBoolean)
  {
    char c;
    if (paramBoolean) {
      c = '/';
    } else {
      c = '\\';
    }
    return doNormalize(paramString, c, false);
  }
  
  public static String removeExtension(String paramString)
  {
    if (paramString == null) {
      return null;
    }
    failIfNullBytePresent(paramString);
    int i = indexOfExtension(paramString);
    if (i == -1) {
      return paramString;
    }
    return paramString.substring(0, i);
  }
  
  public static String separatorsToSystem(String paramString)
  {
    if (paramString == null) {
      return null;
    }
    if (isSystemWindows()) {
      return separatorsToWindows(paramString);
    }
    return separatorsToUnix(paramString);
  }
  
  public static String separatorsToUnix(String paramString)
  {
    String str = paramString;
    if (paramString != null)
    {
      if (paramString.indexOf('\\') == -1) {
        return paramString;
      }
      str = paramString.replace('\\', '/');
    }
    return str;
  }
  
  public static String separatorsToWindows(String paramString)
  {
    String str = paramString;
    if (paramString != null)
    {
      if (paramString.indexOf('/') == -1) {
        return paramString;
      }
      str = paramString.replace('/', '\\');
    }
    return str;
  }
  
  static String[] splitOnTokens(String paramString)
  {
    if ((paramString.indexOf('?') == -1) && (paramString.indexOf('*') == -1)) {
      return new String[] { paramString };
    }
    paramString = paramString.toCharArray();
    ArrayList localArrayList = new ArrayList();
    StringBuilder localStringBuilder = new StringBuilder();
    int k = paramString.length;
    int i = 0;
    char c;
    for (int j = 0; i < k; j = c)
    {
      c = paramString[i];
      if ((c != '?') && (c != '*'))
      {
        localStringBuilder.append(c);
      }
      else
      {
        if (localStringBuilder.length() != 0)
        {
          localArrayList.add(localStringBuilder.toString());
          localStringBuilder.setLength(0);
        }
        if (c == '?') {
          localArrayList.add("?");
        } else if (j != 42) {
          localArrayList.add("*");
        }
      }
      i += 1;
    }
    if (localStringBuilder.length() != 0) {
      localArrayList.add(localStringBuilder.toString());
    }
    return (String[])localArrayList.toArray(new String[localArrayList.size()]);
  }
  
  public static boolean wildcardMatch(String paramString1, String paramString2)
  {
    return wildcardMatch(paramString1, paramString2, IOCase.SENSITIVE);
  }
  
  public static boolean wildcardMatch(String paramString1, String paramString2, IOCase paramIOCase)
  {
    if ((paramString1 == null) && (paramString2 == null)) {
      return true;
    }
    if (paramString1 != null)
    {
      if (paramString2 == null) {
        return false;
      }
      IOCase localIOCase = paramIOCase;
      if (paramIOCase == null) {
        localIOCase = IOCase.SENSITIVE;
      }
      paramString2 = splitOnTokens(paramString2);
      paramIOCase = new Stack();
      int j = 0;
      int i = 0;
      int m = 0;
      for (;;)
      {
        if (paramIOCase.size() > 0)
        {
          int[] arrayOfInt = (int[])paramIOCase.pop();
          m = arrayOfInt[0];
          i = arrayOfInt[1];
          j = 1;
        }
        int k;
        for (;;)
        {
          k = i;
          if (m >= paramString2.length) {
            break;
          }
          if (paramString2[m].equals("?"))
          {
            k = i + 1;
            i = k;
            if (k > paramString1.length()) {
              break;
            }
          }
          for (;;)
          {
            j = 0;
            break;
            if (paramString2[m].equals("*"))
            {
              if (m == paramString2.length - 1) {
                i = paramString1.length();
              }
              j = 1;
              break;
            }
            if (j != 0)
            {
              i = localIOCase.checkIndexOf(paramString1, i, paramString2[m]);
              if (i == -1)
              {
                k = i;
                break label289;
              }
              j = localIOCase.checkIndexOf(paramString1, i + 1, paramString2[m]);
              k = i;
              if (j >= 0)
              {
                paramIOCase.push(new int[] { m, j });
                k = i;
              }
            }
            else
            {
              k = i;
              if (!localIOCase.checkRegionMatches(paramString1, i, paramString2[m]))
              {
                k = i;
                break label289;
              }
            }
            i = k + paramString2[m].length();
          }
          m += 1;
        }
        label289:
        if ((m == paramString2.length) && (k == paramString1.length())) {
          return true;
        }
        if (paramIOCase.size() <= 0) {
          return false;
        }
        i = k;
      }
    }
    return false;
  }
  
  public static boolean wildcardMatchOnSystem(String paramString1, String paramString2)
  {
    return wildcardMatch(paramString1, paramString2, IOCase.SYSTEM);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     org.apache.commons.io.FilenameUtils
 * JD-Core Version:    0.7.0.1
 */