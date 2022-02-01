package external.org.apache.commons.lang3;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringUtils
{
  public static final String EMPTY = "";
  public static final int INDEX_NOT_FOUND = -1;
  private static final int PAD_LIMIT = 8192;
  private static final Pattern WHITESPACE_BLOCK = Pattern.compile("\\s+");
  
  public static String abbreviate(String paramString, int paramInt)
  {
    return abbreviate(paramString, 0, paramInt);
  }
  
  public static String abbreviate(String paramString, int paramInt1, int paramInt2)
  {
    String str;
    if (paramString == null) {
      str = null;
    }
    do
    {
      return str;
      if (paramInt2 < 4) {
        throw new IllegalArgumentException("Minimum abbreviation width is 4");
      }
      str = paramString;
    } while (paramString.length() <= paramInt2);
    int i = paramInt1;
    if (paramInt1 > paramString.length()) {
      i = paramString.length();
    }
    paramInt1 = i;
    if (paramString.length() - i < paramInt2 - 3) {
      paramInt1 = paramString.length() - (paramInt2 - 3);
    }
    if (paramInt1 <= 4) {
      return paramString.substring(0, paramInt2 - 3) + "...";
    }
    if (paramInt2 < 7) {
      throw new IllegalArgumentException("Minimum abbreviation width with offset is 7");
    }
    if (paramInt1 + paramInt2 - 3 < paramString.length()) {
      return "..." + abbreviate(paramString.substring(paramInt1), paramInt2 - 3);
    }
    return "..." + paramString.substring(paramString.length() - (paramInt2 - 3));
  }
  
  public static String abbreviateMiddle(String paramString1, String paramString2, int paramInt)
  {
    if ((isEmpty(paramString1)) || (isEmpty(paramString2))) {}
    while ((paramInt >= paramString1.length()) || (paramInt < paramString2.length() + 2)) {
      return paramString1;
    }
    int i = paramInt - paramString2.length();
    int j = i / 2;
    int k = paramString1.length();
    int m = i / 2;
    StringBuilder localStringBuilder = new StringBuilder(paramInt);
    localStringBuilder.append(paramString1.substring(0, j + i % 2));
    localStringBuilder.append(paramString2);
    localStringBuilder.append(paramString1.substring(k - m));
    return localStringBuilder.toString();
  }
  
  public static String capitalize(String paramString)
  {
    int i;
    if (paramString != null)
    {
      i = paramString.length();
      if (i != 0) {}
    }
    else
    {
      return paramString;
    }
    return i + Character.toTitleCase(paramString.charAt(0)) + paramString.substring(1);
  }
  
  public static String center(String paramString, int paramInt)
  {
    return center(paramString, paramInt, ' ');
  }
  
  public static String center(String paramString, int paramInt, char paramChar)
  {
    if ((paramString == null) || (paramInt <= 0)) {}
    int i;
    int j;
    do
    {
      return paramString;
      i = paramString.length();
      j = paramInt - i;
    } while (j <= 0);
    return rightPad(leftPad(paramString, i + j / 2, paramChar), paramInt, paramChar);
  }
  
  public static String center(String paramString1, int paramInt, String paramString2)
  {
    if ((paramString1 == null) || (paramInt <= 0)) {}
    String str;
    int i;
    int j;
    do
    {
      return paramString1;
      str = paramString2;
      if (isEmpty(paramString2)) {
        str = " ";
      }
      i = paramString1.length();
      j = paramInt - i;
    } while (j <= 0);
    return rightPad(leftPad(paramString1, i + j / 2, str), paramInt, str);
  }
  
  public static String chomp(String paramString)
  {
    if (isEmpty(paramString)) {}
    int i;
    do
    {
      return paramString;
      if (paramString.length() != 1) {
        break;
      }
      i = paramString.charAt(0);
    } while ((i != 13) && (i != 10));
    return "";
    int j = paramString.length() - 1;
    int k = paramString.charAt(j);
    if (k == 10)
    {
      i = j;
      if (paramString.charAt(j - 1) == '\r') {
        i = j - 1;
      }
    }
    for (;;)
    {
      return paramString.substring(0, i);
      i = j;
      if (k != 13) {
        i = j + 1;
      }
    }
  }
  
  @Deprecated
  public static String chomp(String paramString1, String paramString2)
  {
    return removeEnd(paramString1, paramString2);
  }
  
  public static String chop(String paramString)
  {
    Object localObject;
    if (paramString == null) {
      localObject = null;
    }
    int i;
    String str;
    do
    {
      do
      {
        return localObject;
        i = paramString.length();
        if (i < 2) {
          return "";
        }
        i -= 1;
        str = paramString.substring(0, i);
        localObject = str;
      } while (paramString.charAt(i) != '\n');
      localObject = str;
    } while (str.charAt(i - 1) != '\r');
    return str.substring(0, i - 1);
  }
  
  public static boolean contains(CharSequence paramCharSequence, int paramInt)
  {
    if (isEmpty(paramCharSequence)) {}
    while (CharSequenceUtils.indexOf(paramCharSequence, paramInt, 0) < 0) {
      return false;
    }
    return true;
  }
  
  public static boolean contains(CharSequence paramCharSequence1, CharSequence paramCharSequence2)
  {
    if ((paramCharSequence1 == null) || (paramCharSequence2 == null)) {}
    while (CharSequenceUtils.indexOf(paramCharSequence1, paramCharSequence2, 0) < 0) {
      return false;
    }
    return true;
  }
  
  public static boolean containsAny(CharSequence paramCharSequence1, CharSequence paramCharSequence2)
  {
    if (paramCharSequence2 == null) {
      return false;
    }
    return containsAny(paramCharSequence1, CharSequenceUtils.toCharArray(paramCharSequence2));
  }
  
  public static boolean containsAny(CharSequence paramCharSequence, char... paramVarArgs)
  {
    boolean bool2 = true;
    boolean bool1;
    if ((isEmpty(paramCharSequence)) || (ArrayUtils.isEmpty(paramVarArgs)))
    {
      bool1 = false;
      return bool1;
    }
    int k = paramCharSequence.length();
    int m = paramVarArgs.length;
    int i = 0;
    for (;;)
    {
      if (i >= k) {
        break label139;
      }
      char c = paramCharSequence.charAt(i);
      int j = 0;
      for (;;)
      {
        if (j >= m) {
          break label132;
        }
        if (paramVarArgs[j] == c)
        {
          bool1 = bool2;
          if (!Character.isHighSurrogate(c)) {
            break;
          }
          bool1 = bool2;
          if (j == m - 1) {
            break;
          }
          if (i < k - 1)
          {
            bool1 = bool2;
            if (paramVarArgs[(j + 1)] == paramCharSequence.charAt(i + 1)) {
              break;
            }
          }
        }
        j += 1;
      }
      label132:
      i += 1;
    }
    label139:
    return false;
  }
  
  public static boolean containsIgnoreCase(CharSequence paramCharSequence1, CharSequence paramCharSequence2)
  {
    if ((paramCharSequence1 == null) || (paramCharSequence2 == null)) {}
    for (;;)
    {
      return false;
      int j = paramCharSequence2.length();
      int k = paramCharSequence1.length();
      int i = 0;
      while (i <= k - j)
      {
        if (CharSequenceUtils.regionMatches(paramCharSequence1, true, i, paramCharSequence2, 0, j)) {
          return true;
        }
        i += 1;
      }
    }
  }
  
  public static boolean containsNone(CharSequence paramCharSequence, String paramString)
  {
    if ((paramCharSequence == null) || (paramString == null)) {
      return true;
    }
    return containsNone(paramCharSequence, paramString.toCharArray());
  }
  
  public static boolean containsNone(CharSequence paramCharSequence, char... paramVarArgs)
  {
    boolean bool2 = false;
    boolean bool1;
    if ((paramCharSequence == null) || (paramVarArgs == null))
    {
      bool1 = true;
      return bool1;
    }
    int k = paramCharSequence.length();
    int m = paramVarArgs.length;
    int i = 0;
    for (;;)
    {
      if (i >= k) {
        break label133;
      }
      char c = paramCharSequence.charAt(i);
      int j = 0;
      for (;;)
      {
        if (j >= m) {
          break label126;
        }
        if (paramVarArgs[j] == c)
        {
          bool1 = bool2;
          if (!Character.isHighSurrogate(c)) {
            break;
          }
          bool1 = bool2;
          if (j == m - 1) {
            break;
          }
          if (i < k - 1)
          {
            bool1 = bool2;
            if (paramVarArgs[(j + 1)] == paramCharSequence.charAt(i + 1)) {
              break;
            }
          }
        }
        j += 1;
      }
      label126:
      i += 1;
    }
    label133:
    return true;
  }
  
  public static boolean containsOnly(CharSequence paramCharSequence, String paramString)
  {
    if ((paramCharSequence == null) || (paramString == null)) {
      return false;
    }
    return containsOnly(paramCharSequence, paramString.toCharArray());
  }
  
  public static boolean containsOnly(CharSequence paramCharSequence, char... paramVarArgs)
  {
    boolean bool2 = true;
    boolean bool1;
    if ((paramVarArgs == null) || (paramCharSequence == null)) {
      bool1 = false;
    }
    do
    {
      do
      {
        return bool1;
        bool1 = bool2;
      } while (paramCharSequence.length() == 0);
      if (paramVarArgs.length == 0) {
        return false;
      }
      bool1 = bool2;
    } while (indexOfAnyBut(paramCharSequence, paramVarArgs) == -1);
    return false;
  }
  
  public static boolean containsWhitespace(CharSequence paramCharSequence)
  {
    if (isEmpty(paramCharSequence)) {}
    for (;;)
    {
      return false;
      int j = paramCharSequence.length();
      int i = 0;
      while (i < j)
      {
        if (Character.isWhitespace(paramCharSequence.charAt(i))) {
          return true;
        }
        i += 1;
      }
    }
  }
  
  public static int countMatches(CharSequence paramCharSequence1, CharSequence paramCharSequence2)
  {
    int j = 0;
    if ((isEmpty(paramCharSequence1)) || (isEmpty(paramCharSequence2)))
    {
      j = 0;
      return j;
    }
    int i = 0;
    for (;;)
    {
      int k = CharSequenceUtils.indexOf(paramCharSequence1, paramCharSequence2, j);
      j = i;
      if (k == -1) {
        break;
      }
      i += 1;
      j = k + paramCharSequence2.length();
    }
  }
  
  public static <T extends CharSequence> T defaultIfBlank(T paramT1, T paramT2)
  {
    if (isBlank(paramT1)) {
      return paramT2;
    }
    return paramT1;
  }
  
  public static <T extends CharSequence> T defaultIfEmpty(T paramT1, T paramT2)
  {
    if (isEmpty(paramT1)) {
      return paramT2;
    }
    return paramT1;
  }
  
  public static String defaultString(String paramString)
  {
    String str = paramString;
    if (paramString == null) {
      str = "";
    }
    return str;
  }
  
  public static String defaultString(String paramString1, String paramString2)
  {
    if (paramString1 == null) {
      return paramString2;
    }
    return paramString1;
  }
  
  public static String deleteWhitespace(String paramString)
  {
    if (isEmpty(paramString)) {
      return paramString;
    }
    int m = paramString.length();
    char[] arrayOfChar = new char[m];
    int j = 0;
    int i = 0;
    label25:
    if (j < m)
    {
      if (Character.isWhitespace(paramString.charAt(j))) {
        break label82;
      }
      int k = i + 1;
      arrayOfChar[i] = paramString.charAt(j);
      i = k;
    }
    label82:
    for (;;)
    {
      j += 1;
      break label25;
      if (i == m) {
        break;
      }
      return new String(arrayOfChar, 0, i);
    }
  }
  
  public static String difference(String paramString1, String paramString2)
  {
    if (paramString1 == null) {
      return paramString2;
    }
    if (paramString2 == null) {
      return paramString1;
    }
    int i = indexOfDifference(paramString1, paramString2);
    if (i == -1) {
      return "";
    }
    return paramString2.substring(i);
  }
  
  public static boolean endsWith(CharSequence paramCharSequence1, CharSequence paramCharSequence2)
  {
    return endsWith(paramCharSequence1, paramCharSequence2, false);
  }
  
  private static boolean endsWith(CharSequence paramCharSequence1, CharSequence paramCharSequence2, boolean paramBoolean)
  {
    boolean bool2 = false;
    boolean bool1;
    if ((paramCharSequence1 == null) || (paramCharSequence2 == null))
    {
      bool1 = bool2;
      if (paramCharSequence1 == null)
      {
        bool1 = bool2;
        if (paramCharSequence2 == null) {
          bool1 = true;
        }
      }
    }
    do
    {
      return bool1;
      bool1 = bool2;
    } while (paramCharSequence2.length() > paramCharSequence1.length());
    return CharSequenceUtils.regionMatches(paramCharSequence1, paramBoolean, paramCharSequence1.length() - paramCharSequence2.length(), paramCharSequence2, 0, paramCharSequence2.length());
  }
  
  public static boolean endsWithAny(CharSequence paramCharSequence, CharSequence... paramVarArgs)
  {
    if ((isEmpty(paramCharSequence)) || (ArrayUtils.isEmpty(paramVarArgs))) {}
    for (;;)
    {
      return false;
      int j = paramVarArgs.length;
      int i = 0;
      while (i < j)
      {
        if (endsWith(paramCharSequence, paramVarArgs[i])) {
          return true;
        }
        i += 1;
      }
    }
  }
  
  public static boolean endsWithIgnoreCase(CharSequence paramCharSequence1, CharSequence paramCharSequence2)
  {
    return endsWith(paramCharSequence1, paramCharSequence2, true);
  }
  
  public static boolean equals(CharSequence paramCharSequence1, CharSequence paramCharSequence2)
  {
    if (paramCharSequence1 == null) {
      return paramCharSequence2 == null;
    }
    return paramCharSequence1.equals(paramCharSequence2);
  }
  
  public static boolean equalsIgnoreCase(CharSequence paramCharSequence1, CharSequence paramCharSequence2)
  {
    if ((paramCharSequence1 == null) || (paramCharSequence2 == null)) {
      return paramCharSequence1 == paramCharSequence2;
    }
    return CharSequenceUtils.regionMatches(paramCharSequence1, true, 0, paramCharSequence2, 0, Math.max(paramCharSequence1.length(), paramCharSequence2.length()));
  }
  
  public static String getCommonPrefix(String... paramVarArgs)
  {
    if ((paramVarArgs == null) || (paramVarArgs.length == 0)) {
      return "";
    }
    int i = indexOfDifference(paramVarArgs);
    if (i == -1)
    {
      if (paramVarArgs[0] == null) {
        return "";
      }
      return paramVarArgs[0];
    }
    if (i == 0) {
      return "";
    }
    return paramVarArgs[0].substring(0, i);
  }
  
  public static int getLevenshteinDistance(CharSequence paramCharSequence1, CharSequence paramCharSequence2)
  {
    if ((paramCharSequence1 == null) || (paramCharSequence2 == null)) {
      throw new IllegalArgumentException("Strings must not be null");
    }
    int k = paramCharSequence1.length();
    int j = paramCharSequence2.length();
    if (k == 0) {
      return j;
    }
    if (j == 0) {
      return k;
    }
    int i;
    CharSequence localCharSequence2;
    CharSequence localCharSequence1;
    if (k > j)
    {
      i = paramCharSequence1.length();
      localCharSequence2 = paramCharSequence2;
      localCharSequence1 = paramCharSequence1;
    }
    for (;;)
    {
      paramCharSequence2 = new int[j + 1];
      paramCharSequence1 = new int[j + 1];
      k = 0;
      while (k <= j)
      {
        paramCharSequence2[k] = k;
        k += 1;
      }
      k = 1;
      CharSequence localCharSequence3;
      for (;;)
      {
        localCharSequence3 = paramCharSequence2;
        if (k > i) {
          break;
        }
        int i1 = localCharSequence1.charAt(k - 1);
        paramCharSequence1[0] = k;
        int m = 1;
        if (m <= j)
        {
          if (localCharSequence2.charAt(m - 1) == i1) {}
          for (int n = 0;; n = 1)
          {
            paramCharSequence1[m] = Math.min(Math.min(paramCharSequence1[(m - 1)] + 1, localCharSequence3[m] + 1), n + localCharSequence3[(m - 1)]);
            m += 1;
            break;
          }
        }
        k += 1;
        paramCharSequence2 = paramCharSequence1;
        paramCharSequence1 = localCharSequence3;
      }
      return localCharSequence3[j];
      i = j;
      j = k;
      localCharSequence1 = paramCharSequence2;
      localCharSequence2 = paramCharSequence1;
    }
  }
  
  public static int getLevenshteinDistance(CharSequence paramCharSequence1, CharSequence paramCharSequence2, int paramInt)
  {
    if ((paramCharSequence1 == null) || (paramCharSequence2 == null)) {
      throw new IllegalArgumentException("Strings must not be null");
    }
    if (paramInt < 0) {
      throw new IllegalArgumentException("Threshold must not be negative");
    }
    int j = paramCharSequence1.length();
    int i = paramCharSequence2.length();
    if (j == 0)
    {
      if (i <= paramInt) {
        return i;
      }
      return -1;
    }
    if (i == 0)
    {
      if (j <= paramInt) {
        return j;
      }
      return -1;
    }
    int k;
    CharSequence localCharSequence2;
    CharSequence localCharSequence1;
    if (j > i)
    {
      k = paramCharSequence1.length();
      localCharSequence2 = paramCharSequence2;
      localCharSequence1 = paramCharSequence1;
      j = i;
      i = k;
    }
    for (;;)
    {
      paramCharSequence2 = new int[j + 1];
      paramCharSequence1 = new int[j + 1];
      int m = Math.min(j, paramInt) + 1;
      k = 0;
      while (k < m)
      {
        paramCharSequence2[k] = k;
        k += 1;
      }
      Arrays.fill(paramCharSequence2, m, paramCharSequence2.length, 2147483647);
      Arrays.fill(paramCharSequence1, 2147483647);
      k = 1;
      CharSequence localCharSequence3;
      for (;;)
      {
        localCharSequence3 = paramCharSequence2;
        if (k > i) {
          break;
        }
        int i1 = localCharSequence1.charAt(k - 1);
        paramCharSequence1[0] = k;
        int n = Math.max(1, k - paramInt);
        int i2 = Math.min(j, k + paramInt);
        if (n > i2) {
          return -1;
        }
        m = n;
        if (n > 1)
        {
          paramCharSequence1[(n - 1)] = 2147483647;
          m = n;
        }
        if (m <= i2)
        {
          if (localCharSequence2.charAt(m - 1) == i1) {
            paramCharSequence1[m] = localCharSequence3[(m - 1)];
          }
          for (;;)
          {
            m += 1;
            break;
            paramCharSequence1[m] = (Math.min(Math.min(paramCharSequence1[(m - 1)], localCharSequence3[m]), localCharSequence3[(m - 1)]) + 1);
          }
        }
        k += 1;
        paramCharSequence2 = paramCharSequence1;
        paramCharSequence1 = localCharSequence3;
      }
      if (localCharSequence3[j] <= paramInt) {
        return localCharSequence3[j];
      }
      return -1;
      localCharSequence1 = paramCharSequence2;
      localCharSequence2 = paramCharSequence1;
    }
  }
  
  public static int indexOf(CharSequence paramCharSequence, int paramInt)
  {
    if (isEmpty(paramCharSequence)) {
      return -1;
    }
    return CharSequenceUtils.indexOf(paramCharSequence, paramInt, 0);
  }
  
  public static int indexOf(CharSequence paramCharSequence, int paramInt1, int paramInt2)
  {
    if (isEmpty(paramCharSequence)) {
      return -1;
    }
    return CharSequenceUtils.indexOf(paramCharSequence, paramInt1, paramInt2);
  }
  
  public static int indexOf(CharSequence paramCharSequence1, CharSequence paramCharSequence2)
  {
    if ((paramCharSequence1 == null) || (paramCharSequence2 == null)) {
      return -1;
    }
    return CharSequenceUtils.indexOf(paramCharSequence1, paramCharSequence2, 0);
  }
  
  public static int indexOf(CharSequence paramCharSequence1, CharSequence paramCharSequence2, int paramInt)
  {
    if ((paramCharSequence1 == null) || (paramCharSequence2 == null)) {
      return -1;
    }
    return CharSequenceUtils.indexOf(paramCharSequence1, paramCharSequence2, paramInt);
  }
  
  public static int indexOfAny(CharSequence paramCharSequence, String paramString)
  {
    if ((isEmpty(paramCharSequence)) || (isEmpty(paramString))) {
      return -1;
    }
    return indexOfAny(paramCharSequence, paramString.toCharArray());
  }
  
  public static int indexOfAny(CharSequence paramCharSequence, char... paramVarArgs)
  {
    int j;
    if ((isEmpty(paramCharSequence)) || (ArrayUtils.isEmpty(paramVarArgs)))
    {
      j = -1;
      return j;
    }
    int m = paramCharSequence.length();
    int n = paramVarArgs.length;
    int i = 0;
    for (;;)
    {
      if (i >= m) {
        break label136;
      }
      char c = paramCharSequence.charAt(i);
      int k = 0;
      for (;;)
      {
        if (k >= n) {
          break label129;
        }
        if (paramVarArgs[k] == c)
        {
          j = i;
          if (i >= m - 1) {
            break;
          }
          j = i;
          if (k >= n - 1) {
            break;
          }
          j = i;
          if (!Character.isHighSurrogate(c)) {
            break;
          }
          j = i;
          if (paramVarArgs[(k + 1)] == paramCharSequence.charAt(i + 1)) {
            break;
          }
        }
        k += 1;
      }
      label129:
      i += 1;
    }
    label136:
    return -1;
  }
  
  public static int indexOfAny(CharSequence paramCharSequence, CharSequence... paramVarArgs)
  {
    int j;
    if ((paramCharSequence == null) || (paramVarArgs == null)) {
      j = -1;
    }
    int i;
    do
    {
      return j;
      int n = paramVarArgs.length;
      j = 0;
      i = 2147483647;
      if (j < n)
      {
        CharSequence localCharSequence = paramVarArgs[j];
        int k;
        if (localCharSequence == null) {
          k = i;
        }
        for (;;)
        {
          j += 1;
          i = k;
          break;
          int m = CharSequenceUtils.indexOf(paramCharSequence, localCharSequence, 0);
          k = i;
          if (m != -1)
          {
            k = i;
            if (m < i) {
              k = m;
            }
          }
        }
      }
      j = i;
    } while (i != 2147483647);
    return -1;
  }
  
  public static int indexOfAnyBut(CharSequence paramCharSequence1, CharSequence paramCharSequence2)
  {
    int j;
    if ((isEmpty(paramCharSequence1)) || (isEmpty(paramCharSequence2))) {
      j = -1;
    }
    int i;
    label56:
    do
    {
      return j;
      int k = paramCharSequence1.length();
      i = 0;
      if (i >= k) {
        break label120;
      }
      char c = paramCharSequence1.charAt(i);
      if (CharSequenceUtils.indexOf(paramCharSequence2, c, 0) < 0) {
        break label107;
      }
      j = 1;
      if ((i + 1 >= k) || (!Character.isHighSurrogate(c))) {
        break label113;
      }
      m = paramCharSequence1.charAt(i + 1);
      if (j == 0) {
        break;
      }
      j = i;
    } while (CharSequenceUtils.indexOf(paramCharSequence2, m, 0) < 0);
    label107:
    label113:
    while (j != 0)
    {
      int m;
      i += 1;
      break;
      j = 0;
      break label56;
    }
    return i;
    label120:
    return -1;
  }
  
  public static int indexOfAnyBut(CharSequence paramCharSequence, char... paramVarArgs)
  {
    int j;
    if ((isEmpty(paramCharSequence)) || (ArrayUtils.isEmpty(paramVarArgs)))
    {
      j = -1;
      return j;
    }
    int m = paramCharSequence.length();
    int n = paramVarArgs.length;
    int i = 0;
    label34:
    if (i < m)
    {
      char c = paramCharSequence.charAt(i);
      int k = 0;
      for (;;)
      {
        j = i;
        if (k >= n) {
          break;
        }
        if ((paramVarArgs[k] == c) && ((i >= m - 1) || (k >= n - 1) || (!Character.isHighSurrogate(c)) || (paramVarArgs[(k + 1)] == paramCharSequence.charAt(i + 1))))
        {
          i += 1;
          break label34;
        }
        k += 1;
      }
    }
    return -1;
  }
  
  public static int indexOfDifference(CharSequence paramCharSequence1, CharSequence paramCharSequence2)
  {
    int k = 0;
    int j = 0;
    int i;
    if (paramCharSequence1 == paramCharSequence2) {
      i = -1;
    }
    do
    {
      do
      {
        return i;
        i = j;
      } while (paramCharSequence1 == null);
      i = j;
    } while (paramCharSequence2 == null);
    j = k;
    for (;;)
    {
      if ((j >= paramCharSequence1.length()) || (j >= paramCharSequence2.length()) || (paramCharSequence1.charAt(j) != paramCharSequence2.charAt(j)))
      {
        i = j;
        if (j < paramCharSequence2.length()) {
          break;
        }
        i = j;
        if (j < paramCharSequence1.length()) {
          break;
        }
        return -1;
      }
      j += 1;
    }
  }
  
  public static int indexOfDifference(CharSequence... paramVarArgs)
  {
    int i2 = 0;
    if ((paramVarArgs == null) || (paramVarArgs.length <= 1)) {
      i = -1;
    }
    int i4;
    int n;
    int i1;
    int m;
    int k;
    do
    {
      return i;
      i4 = paramVarArgs.length;
      n = 2147483647;
      i1 = 0;
      m = 0;
      j = 1;
      i = 0;
      if (i1 < i4)
      {
        if (paramVarArgs[i1] == null)
        {
          k = j;
          j = 1;
          i = 0;
        }
        for (;;)
        {
          int i3 = i1 + 1;
          n = j;
          i1 = i;
          j = k;
          i = n;
          n = i1;
          i1 = i3;
          break;
          k = Math.min(paramVarArgs[i1].length(), n);
          m = Math.max(paramVarArgs[i1].length(), m);
          j = i;
          n = 0;
          i = k;
          k = n;
        }
      }
      if ((j != 0) || ((m == 0) && (i == 0))) {
        return -1;
      }
      i = i2;
    } while (n == 0);
    int i = 0;
    int j = -1;
    label154:
    if (i < n)
    {
      i2 = paramVarArgs[0].charAt(i);
      i1 = 1;
      label174:
      k = j;
      if (i1 < i4)
      {
        if (paramVarArgs[i1].charAt(i) != i2) {
          k = i;
        }
      }
      else
      {
        if (k == -1) {
          break label235;
        }
        j = k;
      }
    }
    for (;;)
    {
      i = j;
      if (j != -1) {
        break;
      }
      i = j;
      if (n == m) {
        break;
      }
      return n;
      i1 += 1;
      break label174;
      label235:
      i += 1;
      j = k;
      break label154;
    }
  }
  
  public static int indexOfIgnoreCase(CharSequence paramCharSequence1, CharSequence paramCharSequence2)
  {
    return indexOfIgnoreCase(paramCharSequence1, paramCharSequence2, 0);
  }
  
  public static int indexOfIgnoreCase(CharSequence paramCharSequence1, CharSequence paramCharSequence2, int paramInt)
  {
    if ((paramCharSequence1 == null) || (paramCharSequence2 == null)) {
      paramInt = -1;
    }
    int i;
    int j;
    do
    {
      return paramInt;
      i = paramInt;
      if (paramInt < 0) {
        i = 0;
      }
      j = paramCharSequence1.length() - paramCharSequence2.length() + 1;
      if (i > j) {
        return -1;
      }
      paramInt = i;
    } while (paramCharSequence2.length() == 0);
    while (i < j)
    {
      if (CharSequenceUtils.regionMatches(paramCharSequence1, true, i, paramCharSequence2, 0, paramCharSequence2.length())) {
        return i;
      }
      i += 1;
    }
    return -1;
  }
  
  public static boolean isAllLowerCase(CharSequence paramCharSequence)
  {
    if ((paramCharSequence == null) || (isEmpty(paramCharSequence))) {
      return false;
    }
    int j = paramCharSequence.length();
    int i = 0;
    for (;;)
    {
      if (i >= j) {
        break label47;
      }
      if (!Character.isLowerCase(paramCharSequence.charAt(i))) {
        break;
      }
      i += 1;
    }
    label47:
    return true;
  }
  
  public static boolean isAllUpperCase(CharSequence paramCharSequence)
  {
    if ((paramCharSequence == null) || (isEmpty(paramCharSequence))) {
      return false;
    }
    int j = paramCharSequence.length();
    int i = 0;
    for (;;)
    {
      if (i >= j) {
        break label47;
      }
      if (!Character.isUpperCase(paramCharSequence.charAt(i))) {
        break;
      }
      i += 1;
    }
    label47:
    return true;
  }
  
  public static boolean isAlpha(CharSequence paramCharSequence)
  {
    if ((paramCharSequence == null) || (paramCharSequence.length() == 0)) {
      return false;
    }
    int j = paramCharSequence.length();
    int i = 0;
    for (;;)
    {
      if (i >= j) {
        break label49;
      }
      if (!Character.isLetter(paramCharSequence.charAt(i))) {
        break;
      }
      i += 1;
    }
    label49:
    return true;
  }
  
  public static boolean isAlphaSpace(CharSequence paramCharSequence)
  {
    if (paramCharSequence == null) {
      return false;
    }
    int j = paramCharSequence.length();
    int i = 0;
    for (;;)
    {
      if (i >= j) {
        break label52;
      }
      if ((!Character.isLetter(paramCharSequence.charAt(i))) && (paramCharSequence.charAt(i) != ' ')) {
        break;
      }
      i += 1;
    }
    label52:
    return true;
  }
  
  public static boolean isAlphanumeric(CharSequence paramCharSequence)
  {
    if ((paramCharSequence == null) || (paramCharSequence.length() == 0)) {
      return false;
    }
    int j = paramCharSequence.length();
    int i = 0;
    for (;;)
    {
      if (i >= j) {
        break label49;
      }
      if (!Character.isLetterOrDigit(paramCharSequence.charAt(i))) {
        break;
      }
      i += 1;
    }
    label49:
    return true;
  }
  
  public static boolean isAlphanumericSpace(CharSequence paramCharSequence)
  {
    if (paramCharSequence == null) {
      return false;
    }
    int j = paramCharSequence.length();
    int i = 0;
    for (;;)
    {
      if (i >= j) {
        break label52;
      }
      if ((!Character.isLetterOrDigit(paramCharSequence.charAt(i))) && (paramCharSequence.charAt(i) != ' ')) {
        break;
      }
      i += 1;
    }
    label52:
    return true;
  }
  
  public static boolean isAsciiPrintable(CharSequence paramCharSequence)
  {
    if (paramCharSequence == null) {
      return false;
    }
    int j = paramCharSequence.length();
    int i = 0;
    for (;;)
    {
      if (i >= j) {
        break label40;
      }
      if (!CharUtils.isAsciiPrintable(paramCharSequence.charAt(i))) {
        break;
      }
      i += 1;
    }
    label40:
    return true;
  }
  
  public static boolean isBlank(CharSequence paramCharSequence)
  {
    boolean bool2 = false;
    int j;
    boolean bool1;
    if (paramCharSequence != null)
    {
      j = paramCharSequence.length();
      if (j != 0) {}
    }
    else
    {
      bool1 = true;
      return bool1;
    }
    int i = 0;
    for (;;)
    {
      if (i >= j) {
        break label52;
      }
      bool1 = bool2;
      if (!Character.isWhitespace(paramCharSequence.charAt(i))) {
        break;
      }
      i += 1;
    }
    label52:
    return true;
  }
  
  public static boolean isEmpty(CharSequence paramCharSequence)
  {
    return (paramCharSequence == null) || (paramCharSequence.length() == 0);
  }
  
  public static boolean isNotBlank(CharSequence paramCharSequence)
  {
    return !isBlank(paramCharSequence);
  }
  
  public static boolean isNotEmpty(CharSequence paramCharSequence)
  {
    return !isEmpty(paramCharSequence);
  }
  
  public static boolean isNumeric(CharSequence paramCharSequence)
  {
    if ((paramCharSequence == null) || (paramCharSequence.length() == 0)) {
      return false;
    }
    int j = paramCharSequence.length();
    int i = 0;
    for (;;)
    {
      if (i >= j) {
        break label49;
      }
      if (!Character.isDigit(paramCharSequence.charAt(i))) {
        break;
      }
      i += 1;
    }
    label49:
    return true;
  }
  
  public static boolean isNumericSpace(CharSequence paramCharSequence)
  {
    if (paramCharSequence == null) {
      return false;
    }
    int j = paramCharSequence.length();
    int i = 0;
    for (;;)
    {
      if (i >= j) {
        break label52;
      }
      if ((!Character.isDigit(paramCharSequence.charAt(i))) && (paramCharSequence.charAt(i) != ' ')) {
        break;
      }
      i += 1;
    }
    label52:
    return true;
  }
  
  public static boolean isWhitespace(CharSequence paramCharSequence)
  {
    if (paramCharSequence == null) {
      return false;
    }
    int j = paramCharSequence.length();
    int i = 0;
    for (;;)
    {
      if (i >= j) {
        break label40;
      }
      if (!Character.isWhitespace(paramCharSequence.charAt(i))) {
        break;
      }
      i += 1;
    }
    label40:
    return true;
  }
  
  public static String join(Iterable<?> paramIterable, char paramChar)
  {
    if (paramIterable == null) {
      return null;
    }
    return join(paramIterable.iterator(), paramChar);
  }
  
  public static String join(Iterable<?> paramIterable, String paramString)
  {
    if (paramIterable == null) {
      return null;
    }
    return join(paramIterable.iterator(), paramString);
  }
  
  public static String join(Iterator<?> paramIterator, char paramChar)
  {
    if (paramIterator == null) {
      return null;
    }
    if (!paramIterator.hasNext()) {
      return "";
    }
    Object localObject = paramIterator.next();
    if (!paramIterator.hasNext()) {
      return ObjectUtils.toString(localObject);
    }
    StringBuilder localStringBuilder = new StringBuilder(256);
    if (localObject != null) {
      localStringBuilder.append(localObject);
    }
    while (paramIterator.hasNext())
    {
      localStringBuilder.append(paramChar);
      localObject = paramIterator.next();
      if (localObject != null) {
        localStringBuilder.append(localObject);
      }
    }
    return localStringBuilder.toString();
  }
  
  public static String join(Iterator<?> paramIterator, String paramString)
  {
    if (paramIterator == null) {
      return null;
    }
    if (!paramIterator.hasNext()) {
      return "";
    }
    Object localObject = paramIterator.next();
    if (!paramIterator.hasNext()) {
      return ObjectUtils.toString(localObject);
    }
    StringBuilder localStringBuilder = new StringBuilder(256);
    if (localObject != null) {
      localStringBuilder.append(localObject);
    }
    while (paramIterator.hasNext())
    {
      if (paramString != null) {
        localStringBuilder.append(paramString);
      }
      localObject = paramIterator.next();
      if (localObject != null) {
        localStringBuilder.append(localObject);
      }
    }
    return localStringBuilder.toString();
  }
  
  public static <T> String join(T... paramVarArgs)
  {
    return join(paramVarArgs, null);
  }
  
  public static String join(Object[] paramArrayOfObject, char paramChar)
  {
    if (paramArrayOfObject == null) {
      return null;
    }
    return join(paramArrayOfObject, paramChar, 0, paramArrayOfObject.length);
  }
  
  public static String join(Object[] paramArrayOfObject, char paramChar, int paramInt1, int paramInt2)
  {
    if (paramArrayOfObject == null) {
      return null;
    }
    int i = paramInt2 - paramInt1;
    if (i <= 0) {
      return "";
    }
    StringBuilder localStringBuilder = new StringBuilder(i * 16);
    i = paramInt1;
    while (i < paramInt2)
    {
      if (i > paramInt1) {
        localStringBuilder.append(paramChar);
      }
      if (paramArrayOfObject[i] != null) {
        localStringBuilder.append(paramArrayOfObject[i]);
      }
      i += 1;
    }
    return localStringBuilder.toString();
  }
  
  public static String join(Object[] paramArrayOfObject, String paramString)
  {
    if (paramArrayOfObject == null) {
      return null;
    }
    return join(paramArrayOfObject, paramString, 0, paramArrayOfObject.length);
  }
  
  public static String join(Object[] paramArrayOfObject, String paramString, int paramInt1, int paramInt2)
  {
    if (paramArrayOfObject == null) {
      return null;
    }
    String str = paramString;
    if (paramString == null) {
      str = "";
    }
    int i = paramInt2 - paramInt1;
    if (i <= 0) {
      return "";
    }
    paramString = new StringBuilder(i * 16);
    i = paramInt1;
    while (i < paramInt2)
    {
      if (i > paramInt1) {
        paramString.append(str);
      }
      if (paramArrayOfObject[i] != null) {
        paramString.append(paramArrayOfObject[i]);
      }
      i += 1;
    }
    return paramString.toString();
  }
  
  public static int lastIndexOf(CharSequence paramCharSequence, int paramInt)
  {
    if (isEmpty(paramCharSequence)) {
      return -1;
    }
    return CharSequenceUtils.lastIndexOf(paramCharSequence, paramInt, paramCharSequence.length());
  }
  
  public static int lastIndexOf(CharSequence paramCharSequence, int paramInt1, int paramInt2)
  {
    if (isEmpty(paramCharSequence)) {
      return -1;
    }
    return CharSequenceUtils.lastIndexOf(paramCharSequence, paramInt1, paramInt2);
  }
  
  public static int lastIndexOf(CharSequence paramCharSequence1, CharSequence paramCharSequence2)
  {
    if ((paramCharSequence1 == null) || (paramCharSequence2 == null)) {
      return -1;
    }
    return CharSequenceUtils.lastIndexOf(paramCharSequence1, paramCharSequence2, paramCharSequence1.length());
  }
  
  public static int lastIndexOf(CharSequence paramCharSequence1, CharSequence paramCharSequence2, int paramInt)
  {
    if ((paramCharSequence1 == null) || (paramCharSequence2 == null)) {
      return -1;
    }
    return CharSequenceUtils.lastIndexOf(paramCharSequence1, paramCharSequence2, paramInt);
  }
  
  public static int lastIndexOfAny(CharSequence paramCharSequence, CharSequence... paramVarArgs)
  {
    int i = -1;
    int k = i;
    if (paramCharSequence != null)
    {
      if (paramVarArgs != null) {
        break label19;
      }
      k = i;
    }
    label19:
    int n;
    int j;
    do
    {
      return k;
      n = paramVarArgs.length;
      j = 0;
      k = i;
    } while (j >= n);
    CharSequence localCharSequence = paramVarArgs[j];
    if (localCharSequence == null) {
      k = i;
    }
    for (;;)
    {
      j += 1;
      i = k;
      break;
      int m = CharSequenceUtils.lastIndexOf(paramCharSequence, localCharSequence, paramCharSequence.length());
      k = i;
      if (m > i) {
        k = m;
      }
    }
  }
  
  public static int lastIndexOfIgnoreCase(CharSequence paramCharSequence1, CharSequence paramCharSequence2)
  {
    if ((paramCharSequence1 == null) || (paramCharSequence2 == null)) {
      return -1;
    }
    return lastIndexOfIgnoreCase(paramCharSequence1, paramCharSequence2, paramCharSequence1.length());
  }
  
  public static int lastIndexOfIgnoreCase(CharSequence paramCharSequence1, CharSequence paramCharSequence2, int paramInt)
  {
    int i;
    if ((paramCharSequence1 == null) || (paramCharSequence2 == null))
    {
      i = -1;
      return i;
    }
    if (paramInt > paramCharSequence1.length() - paramCharSequence2.length()) {
      paramInt = paramCharSequence1.length() - paramCharSequence2.length();
    }
    for (;;)
    {
      if (paramInt < 0) {
        return -1;
      }
      i = paramInt;
      if (paramCharSequence2.length() == 0) {
        break;
      }
      for (;;)
      {
        if (paramInt < 0) {
          break label90;
        }
        i = paramInt;
        if (CharSequenceUtils.regionMatches(paramCharSequence1, true, paramInt, paramCharSequence2, 0, paramCharSequence2.length())) {
          break;
        }
        paramInt -= 1;
      }
      label90:
      return -1;
    }
  }
  
  public static int lastOrdinalIndexOf(CharSequence paramCharSequence1, CharSequence paramCharSequence2, int paramInt)
  {
    return ordinalIndexOf(paramCharSequence1, paramCharSequence2, paramInt, true);
  }
  
  public static String left(String paramString, int paramInt)
  {
    String str;
    if (paramString == null) {
      str = null;
    }
    do
    {
      return str;
      if (paramInt < 0) {
        return "";
      }
      str = paramString;
    } while (paramString.length() <= paramInt);
    return paramString.substring(0, paramInt);
  }
  
  public static String leftPad(String paramString, int paramInt)
  {
    return leftPad(paramString, paramInt, ' ');
  }
  
  public static String leftPad(String paramString, int paramInt, char paramChar)
  {
    String str;
    if (paramString == null) {
      str = null;
    }
    int i;
    do
    {
      return str;
      i = paramInt - paramString.length();
      str = paramString;
    } while (i <= 0);
    if (i > 8192) {
      return leftPad(paramString, paramInt, String.valueOf(paramChar));
    }
    return repeat(paramChar, i).concat(paramString);
  }
  
  public static String leftPad(String paramString1, int paramInt, String paramString2)
  {
    int i = 0;
    if (paramString1 == null) {
      paramString2 = null;
    }
    int j;
    int k;
    do
    {
      return paramString2;
      localObject = paramString2;
      if (isEmpty(paramString2)) {
        localObject = " ";
      }
      j = ((String)localObject).length();
      k = paramInt - paramString1.length();
      paramString2 = paramString1;
    } while (k <= 0);
    if ((j == 1) && (k <= 8192)) {
      return leftPad(paramString1, paramInt, ((String)localObject).charAt(0));
    }
    if (k == j) {
      return ((String)localObject).concat(paramString1);
    }
    if (k < j) {
      return ((String)localObject).substring(0, k).concat(paramString1);
    }
    paramString2 = new char[k];
    Object localObject = ((String)localObject).toCharArray();
    paramInt = i;
    while (paramInt < k)
    {
      paramString2[paramInt] = localObject[(paramInt % j)];
      paramInt += 1;
    }
    return new String(paramString2).concat(paramString1);
  }
  
  public static int length(CharSequence paramCharSequence)
  {
    if (paramCharSequence == null) {
      return 0;
    }
    return paramCharSequence.length();
  }
  
  public static String lowerCase(String paramString)
  {
    if (paramString == null) {
      return null;
    }
    return paramString.toLowerCase();
  }
  
  public static String lowerCase(String paramString, Locale paramLocale)
  {
    if (paramString == null) {
      return null;
    }
    return paramString.toLowerCase(paramLocale);
  }
  
  public static String mid(String paramString, int paramInt1, int paramInt2)
  {
    if (paramString == null) {
      return null;
    }
    if ((paramInt2 < 0) || (paramInt1 > paramString.length())) {
      return "";
    }
    int i = paramInt1;
    if (paramInt1 < 0) {
      i = 0;
    }
    if (paramString.length() <= i + paramInt2) {
      return paramString.substring(i);
    }
    return paramString.substring(i, i + paramInt2);
  }
  
  public static String normalizeSpace(String paramString)
  {
    if (paramString == null) {
      return null;
    }
    return WHITESPACE_BLOCK.matcher(trim(paramString)).replaceAll(" ");
  }
  
  public static int ordinalIndexOf(CharSequence paramCharSequence1, CharSequence paramCharSequence2, int paramInt)
  {
    return ordinalIndexOf(paramCharSequence1, paramCharSequence2, paramInt, false);
  }
  
  private static int ordinalIndexOf(CharSequence paramCharSequence1, CharSequence paramCharSequence2, int paramInt, boolean paramBoolean)
  {
    int j = 0;
    int i = -1;
    if ((paramCharSequence1 == null) || (paramCharSequence2 == null) || (paramInt <= 0)) {
      j = -1;
    }
    do
    {
      return j;
      if (paramCharSequence2.length() != 0) {
        break;
      }
    } while (!paramBoolean);
    return paramCharSequence1.length();
    if (paramBoolean) {
      i = paramCharSequence1.length();
    }
    int k = 0;
    label59:
    if (paramBoolean) {}
    for (i = CharSequenceUtils.lastIndexOf(paramCharSequence1, paramCharSequence2, i - 1);; i = CharSequenceUtils.indexOf(paramCharSequence1, paramCharSequence2, i + 1))
    {
      j = i;
      if (i < 0) {
        break;
      }
      k += 1;
      j = i;
      if (k >= paramInt) {
        break;
      }
      break label59;
    }
  }
  
  public static String overlay(String paramString1, String paramString2, int paramInt1, int paramInt2)
  {
    if (paramString1 == null) {
      return null;
    }
    String str = paramString2;
    if (paramString2 == null) {
      str = "";
    }
    int j = paramString1.length();
    if (paramInt1 < 0) {}
    for (int i = 0;; i = paramInt1)
    {
      paramInt1 = i;
      if (i > j) {
        paramInt1 = j;
      }
      if (paramInt2 < 0) {}
      for (i = 0;; i = paramInt2)
      {
        paramInt2 = i;
        if (i > j) {
          paramInt2 = j;
        }
        if (paramInt1 > paramInt2)
        {
          i = paramInt2;
          paramInt2 = paramInt1;
        }
        for (;;)
        {
          return j + i - paramInt2 + str.length() + 1 + paramString1.substring(0, i) + str + paramString1.substring(paramInt2);
          i = paramInt1;
        }
      }
    }
  }
  
  public static String remove(String paramString, char paramChar)
  {
    if ((isEmpty(paramString)) || (paramString.indexOf(paramChar) == -1)) {
      return paramString;
    }
    paramString = paramString.toCharArray();
    int i = 0;
    int k;
    for (int j = 0; i < paramString.length; j = k)
    {
      k = j;
      if (paramString[i] != paramChar)
      {
        paramString[j] = paramString[i];
        k = j + 1;
      }
      i += 1;
    }
    return new String(paramString, 0, j);
  }
  
  public static String remove(String paramString1, String paramString2)
  {
    if ((isEmpty(paramString1)) || (isEmpty(paramString2))) {
      return paramString1;
    }
    return replace(paramString1, paramString2, "", -1);
  }
  
  private static String removeAccentsJava6(CharSequence paramCharSequence)
  {
    if ((StringUtils.InitStripAccents.access$000() == null) || (StringUtils.InitStripAccents.access$400() == null)) {
      throw new IllegalStateException("java.text.Normalizer is not available", StringUtils.InitStripAccents.access$200());
    }
    paramCharSequence = (String)StringUtils.InitStripAccents.access$000().invoke(null, new Object[] { paramCharSequence, StringUtils.InitStripAccents.access$400() });
    return StringUtils.InitStripAccents.access$500().matcher(paramCharSequence).replaceAll("");
  }
  
  private static String removeAccentsSUN(CharSequence paramCharSequence)
  {
    if (StringUtils.InitStripAccents.access$100() == null) {
      throw new IllegalStateException("sun.text.Normalizer is not available", StringUtils.InitStripAccents.access$300());
    }
    paramCharSequence = (String)StringUtils.InitStripAccents.access$100().invoke(null, new Object[] { paramCharSequence, Boolean.FALSE, Integer.valueOf(0) });
    return StringUtils.InitStripAccents.access$600().matcher(paramCharSequence).replaceAll("");
  }
  
  public static String removeEnd(String paramString1, String paramString2)
  {
    if ((isEmpty(paramString1)) || (isEmpty(paramString2))) {}
    while (!paramString1.endsWith(paramString2)) {
      return paramString1;
    }
    return paramString1.substring(0, paramString1.length() - paramString2.length());
  }
  
  public static String removeEndIgnoreCase(String paramString1, String paramString2)
  {
    if ((isEmpty(paramString1)) || (isEmpty(paramString2))) {}
    while (!endsWithIgnoreCase(paramString1, paramString2)) {
      return paramString1;
    }
    return paramString1.substring(0, paramString1.length() - paramString2.length());
  }
  
  public static String removeStart(String paramString1, String paramString2)
  {
    if ((isEmpty(paramString1)) || (isEmpty(paramString2))) {}
    while (!paramString1.startsWith(paramString2)) {
      return paramString1;
    }
    return paramString1.substring(paramString2.length());
  }
  
  public static String removeStartIgnoreCase(String paramString1, String paramString2)
  {
    if ((isEmpty(paramString1)) || (isEmpty(paramString2))) {}
    while (!startsWithIgnoreCase(paramString1, paramString2)) {
      return paramString1;
    }
    return paramString1.substring(paramString2.length());
  }
  
  public static String repeat(char paramChar, int paramInt)
  {
    char[] arrayOfChar = new char[paramInt];
    paramInt -= 1;
    while (paramInt >= 0)
    {
      arrayOfChar[paramInt] = paramChar;
      paramInt -= 1;
    }
    return new String(arrayOfChar);
  }
  
  public static String repeat(String paramString, int paramInt)
  {
    int k = 0;
    Object localObject;
    if (paramString == null) {
      localObject = null;
    }
    int m;
    do
    {
      do
      {
        return localObject;
        if (paramInt <= 0) {
          return "";
        }
        m = paramString.length();
        localObject = paramString;
      } while (paramInt == 1);
      localObject = paramString;
    } while (m == 0);
    if ((m == 1) && (paramInt <= 8192)) {
      return repeat(paramString.charAt(0), paramInt);
    }
    int n = m * paramInt;
    switch (m)
    {
    default: 
      localObject = new StringBuilder(n);
    }
    while (k < paramInt)
    {
      ((StringBuilder)localObject).append(paramString);
      k += 1;
      continue;
      return repeat(paramString.charAt(0), paramInt);
      int i = paramString.charAt(0);
      int j = paramString.charAt(1);
      paramString = new char[n];
      for (paramInt = paramInt * 2 - 2; paramInt >= 0; paramInt = paramInt - 1 - 1)
      {
        paramString[paramInt] = i;
        paramString[(paramInt + 1)] = j;
      }
      return new String(paramString);
    }
    return ((StringBuilder)localObject).toString();
  }
  
  public static String repeat(String paramString1, String paramString2, int paramInt)
  {
    if ((paramString1 == null) || (paramString2 == null)) {
      return repeat(paramString1, paramInt);
    }
    return removeEnd(repeat(paramString1 + paramString2, paramInt), paramString2);
  }
  
  public static String replace(String paramString1, String paramString2, String paramString3)
  {
    return replace(paramString1, paramString2, paramString3, -1);
  }
  
  public static String replace(String paramString1, String paramString2, String paramString3, int paramInt)
  {
    int i = 64;
    if ((isEmpty(paramString1)) || (isEmpty(paramString2)) || (paramString3 == null) || (paramInt == 0)) {}
    int k;
    do
    {
      return paramString1;
      k = paramString1.indexOf(paramString2, 0);
    } while (k == -1);
    int n = paramString2.length();
    int m = paramString3.length() - n;
    int j = m;
    if (m < 0) {
      j = 0;
    }
    StringBuilder localStringBuilder;
    if (paramInt < 0)
    {
      i = 16;
      localStringBuilder = new StringBuilder(i * j + paramString1.length());
      m = 0;
      i = paramInt;
      j = k;
      paramInt = m;
    }
    for (;;)
    {
      k = paramInt;
      if (j != -1)
      {
        localStringBuilder.append(paramString1.substring(paramInt, j)).append(paramString3);
        paramInt = j + n;
        i -= 1;
        if (i == 0) {
          k = paramInt;
        }
      }
      else
      {
        localStringBuilder.append(paramString1.substring(k));
        return localStringBuilder.toString();
        if (paramInt > 64) {
          break;
        }
        i = paramInt;
        break;
      }
      j = paramString1.indexOf(paramString2, paramInt);
    }
  }
  
  public static String replaceChars(String paramString, char paramChar1, char paramChar2)
  {
    if (paramString == null) {
      return null;
    }
    return paramString.replace(paramChar1, paramChar2);
  }
  
  public static String replaceChars(String paramString1, String paramString2, String paramString3)
  {
    int j = 0;
    if ((isEmpty(paramString1)) || (isEmpty(paramString2))) {}
    do
    {
      return paramString1;
      String str = paramString3;
      if (paramString3 == null) {
        str = "";
      }
      int m = str.length();
      int n = paramString1.length();
      paramString3 = new StringBuilder(n);
      int i = 0;
      if (i < n)
      {
        char c = paramString1.charAt(i);
        int i1 = paramString2.indexOf(c);
        if (i1 >= 0)
        {
          int k = 1;
          j = k;
          if (i1 < m)
          {
            paramString3.append(str.charAt(i1));
            j = k;
          }
        }
        for (;;)
        {
          i += 1;
          break;
          paramString3.append(c);
        }
      }
    } while (j == 0);
    return paramString3.toString();
  }
  
  public static String replaceEach(String paramString, String[] paramArrayOfString1, String[] paramArrayOfString2)
  {
    return replaceEach(paramString, paramArrayOfString1, paramArrayOfString2, false, 0);
  }
  
  private static String replaceEach(String paramString, String[] paramArrayOfString1, String[] paramArrayOfString2, boolean paramBoolean, int paramInt)
  {
    Object localObject = paramString;
    if (paramString != null)
    {
      localObject = paramString;
      if (paramString.length() != 0)
      {
        localObject = paramString;
        if (paramArrayOfString1 != null)
        {
          localObject = paramString;
          if (paramArrayOfString1.length != 0)
          {
            localObject = paramString;
            if (paramArrayOfString2 != null)
            {
              if (paramArrayOfString2.length != 0) {
                break label50;
              }
              localObject = paramString;
            }
          }
        }
      }
    }
    label50:
    label224:
    do
    {
      int i3;
      boolean[] arrayOfBoolean;
      int n;
      int i1;
      do
      {
        return localObject;
        if (paramInt < 0) {
          throw new IllegalStateException("Aborting to protect against StackOverflowError - output of one loop is the input of another");
        }
        i3 = paramArrayOfString1.length;
        i = paramArrayOfString2.length;
        if (i3 != i) {
          throw new IllegalArgumentException("Search and Replace array lengths don't match: " + i3 + " vs " + i);
        }
        arrayOfBoolean = new boolean[i3];
        k = 0;
        j = -1;
        i = -1;
        if (k < i3)
        {
          m = j;
          n = i;
          if (arrayOfBoolean[k] == 0)
          {
            m = j;
            n = i;
            if (paramArrayOfString1[k] != null)
            {
              m = j;
              n = i;
              if (paramArrayOfString1[k].length() != 0)
              {
                if (paramArrayOfString2[k] != null) {
                  break label224;
                }
                n = i;
                m = j;
              }
            }
          }
          for (;;)
          {
            k += 1;
            j = m;
            i = n;
            break;
            i1 = paramString.indexOf(paramArrayOfString1[k]);
            if (i1 == -1)
            {
              arrayOfBoolean[k] = true;
              m = j;
              n = i;
            }
            else if (i != -1)
            {
              m = j;
              n = i;
              if (i1 >= i) {}
            }
            else
            {
              m = k;
              n = i1;
            }
          }
        }
        localObject = paramString;
      } while (i == -1);
      int k = 0;
      int m = 0;
      if (k < paramArrayOfString1.length)
      {
        n = m;
        if (paramArrayOfString1[k] != null)
        {
          if (paramArrayOfString2[k] != null) {
            break label346;
          }
          n = m;
        }
        for (;;)
        {
          k += 1;
          m = n;
          break;
          i1 = paramArrayOfString2[k].length() - paramArrayOfString1[k].length();
          n = m;
          if (i1 > 0) {
            n = m + i1 * 3;
          }
        }
      }
      localObject = new StringBuilder(Math.min(m, paramString.length() / 5) + paramString.length());
      k = j;
      m = 0;
      int j = i;
      for (int i = m; j != -1; i = i1)
      {
        while (i < j)
        {
          ((StringBuilder)localObject).append(paramString.charAt(i));
          i += 1;
        }
        ((StringBuilder)localObject).append(paramArrayOfString2[k]);
        i1 = j + paramArrayOfString1[k].length();
        i = 0;
        k = -1;
        j = -1;
        if (i < i3)
        {
          m = k;
          n = j;
          if (arrayOfBoolean[i] == 0)
          {
            m = k;
            n = j;
            if (paramArrayOfString1[i] != null)
            {
              m = k;
              n = j;
              if (paramArrayOfString1[i].length() != 0)
              {
                if (paramArrayOfString2[i] != null) {
                  break label577;
                }
                n = j;
                m = k;
              }
            }
          }
          for (;;)
          {
            i += 1;
            k = m;
            j = n;
            break;
            int i2 = paramString.indexOf(paramArrayOfString1[i], i1);
            if (i2 == -1)
            {
              arrayOfBoolean[i] = true;
              m = k;
              n = j;
            }
            else if (j != -1)
            {
              m = k;
              n = j;
              if (i2 >= j) {}
            }
            else
            {
              m = i;
              n = i2;
            }
          }
        }
      }
      j = paramString.length();
      while (i < j)
      {
        ((StringBuilder)localObject).append(paramString.charAt(i));
        i += 1;
      }
      paramString = ((StringBuilder)localObject).toString();
      localObject = paramString;
    } while (!paramBoolean);
    label346:
    return replaceEach(paramString, paramArrayOfString1, paramArrayOfString2, paramBoolean, paramInt - 1);
  }
  
  public static String replaceEachRepeatedly(String paramString, String[] paramArrayOfString1, String[] paramArrayOfString2)
  {
    if (paramArrayOfString1 == null) {}
    for (int i = 0;; i = paramArrayOfString1.length) {
      return replaceEach(paramString, paramArrayOfString1, paramArrayOfString2, true, i);
    }
  }
  
  public static String replaceOnce(String paramString1, String paramString2, String paramString3)
  {
    return replace(paramString1, paramString2, paramString3, 1);
  }
  
  public static String reverse(String paramString)
  {
    if (paramString == null) {
      return null;
    }
    return new StringBuilder(paramString).reverse().toString();
  }
  
  public static String reverseDelimited(String paramString, char paramChar)
  {
    if (paramString == null) {
      return null;
    }
    paramString = split(paramString, paramChar);
    ArrayUtils.reverse(paramString);
    return join(paramString, paramChar);
  }
  
  public static String right(String paramString, int paramInt)
  {
    String str;
    if (paramString == null) {
      str = null;
    }
    do
    {
      return str;
      if (paramInt < 0) {
        return "";
      }
      str = paramString;
    } while (paramString.length() <= paramInt);
    return paramString.substring(paramString.length() - paramInt);
  }
  
  public static String rightPad(String paramString, int paramInt)
  {
    return rightPad(paramString, paramInt, ' ');
  }
  
  public static String rightPad(String paramString, int paramInt, char paramChar)
  {
    String str;
    if (paramString == null) {
      str = null;
    }
    int i;
    do
    {
      return str;
      i = paramInt - paramString.length();
      str = paramString;
    } while (i <= 0);
    if (i > 8192) {
      return rightPad(paramString, paramInt, String.valueOf(paramChar));
    }
    return paramString.concat(repeat(paramChar, i));
  }
  
  public static String rightPad(String paramString1, int paramInt, String paramString2)
  {
    int i = 0;
    if (paramString1 == null) {
      paramString2 = null;
    }
    int j;
    int k;
    do
    {
      return paramString2;
      localObject = paramString2;
      if (isEmpty(paramString2)) {
        localObject = " ";
      }
      j = ((String)localObject).length();
      k = paramInt - paramString1.length();
      paramString2 = paramString1;
    } while (k <= 0);
    if ((j == 1) && (k <= 8192)) {
      return rightPad(paramString1, paramInt, ((String)localObject).charAt(0));
    }
    if (k == j) {
      return paramString1.concat((String)localObject);
    }
    if (k < j) {
      return paramString1.concat(((String)localObject).substring(0, k));
    }
    paramString2 = new char[k];
    Object localObject = ((String)localObject).toCharArray();
    paramInt = i;
    while (paramInt < k)
    {
      paramString2[paramInt] = localObject[(paramInt % j)];
      paramInt += 1;
    }
    return paramString1.concat(new String(paramString2));
  }
  
  public static String[] split(String paramString)
  {
    return split(paramString, null, -1);
  }
  
  public static String[] split(String paramString, char paramChar)
  {
    return splitWorker(paramString, paramChar, false);
  }
  
  public static String[] split(String paramString1, String paramString2)
  {
    return splitWorker(paramString1, paramString2, -1, false);
  }
  
  public static String[] split(String paramString1, String paramString2, int paramInt)
  {
    return splitWorker(paramString1, paramString2, paramInt, false);
  }
  
  public static String[] splitByCharacterType(String paramString)
  {
    return splitByCharacterType(paramString, false);
  }
  
  private static String[] splitByCharacterType(String paramString, boolean paramBoolean)
  {
    if (paramString == null) {
      return null;
    }
    if (paramString.length() == 0) {
      return ArrayUtils.EMPTY_STRING_ARRAY;
    }
    paramString = paramString.toCharArray();
    ArrayList localArrayList = new ArrayList();
    int i = Character.getType(paramString[0]);
    int k = 0;
    int j = 1;
    while (j < paramString.length)
    {
      int m = Character.getType(paramString[j]);
      if (m == i)
      {
        m = k;
        k = i;
        j += 1;
        i = k;
        k = m;
      }
      else
      {
        int n;
        if ((paramBoolean) && (m == 2) && (i == 1))
        {
          n = j - 1;
          i = k;
          if (n != k) {
            localArrayList.add(new String(paramString, k, n - k));
          }
        }
        for (i = n;; i = j)
        {
          k = m;
          m = i;
          break;
          localArrayList.add(new String(paramString, k, j - k));
        }
      }
    }
    localArrayList.add(new String(paramString, k, paramString.length - k));
    return (String[])localArrayList.toArray(new String[localArrayList.size()]);
  }
  
  public static String[] splitByCharacterTypeCamelCase(String paramString)
  {
    return splitByCharacterType(paramString, true);
  }
  
  public static String[] splitByWholeSeparator(String paramString1, String paramString2)
  {
    return splitByWholeSeparatorWorker(paramString1, paramString2, -1, false);
  }
  
  public static String[] splitByWholeSeparator(String paramString1, String paramString2, int paramInt)
  {
    return splitByWholeSeparatorWorker(paramString1, paramString2, paramInt, false);
  }
  
  public static String[] splitByWholeSeparatorPreserveAllTokens(String paramString1, String paramString2)
  {
    return splitByWholeSeparatorWorker(paramString1, paramString2, -1, true);
  }
  
  public static String[] splitByWholeSeparatorPreserveAllTokens(String paramString1, String paramString2, int paramInt)
  {
    return splitByWholeSeparatorWorker(paramString1, paramString2, paramInt, true);
  }
  
  private static String[] splitByWholeSeparatorWorker(String paramString1, String paramString2, int paramInt, boolean paramBoolean)
  {
    int j = 0;
    if (paramString1 == null) {
      return null;
    }
    int k = paramString1.length();
    if (k == 0) {
      return ArrayUtils.EMPTY_STRING_ARRAY;
    }
    if ((paramString2 == null) || ("".equals(paramString2))) {
      return splitWorker(paramString1, null, paramInt, paramBoolean);
    }
    int i2 = paramString2.length();
    ArrayList localArrayList = new ArrayList();
    int i = 0;
    int m = 0;
    while (i < k)
    {
      int n = paramString1.indexOf(paramString2, m);
      if (n > -1)
      {
        if (n > m)
        {
          i = j + 1;
          if (i == paramInt)
          {
            localArrayList.add(paramString1.substring(m));
            j = k;
            n = i;
            i = j;
            j = n;
          }
          else
          {
            localArrayList.add(paramString1.substring(m, n));
            m = n + i2;
            j = i;
            i = n;
          }
        }
        else
        {
          i = n;
          int i1 = j;
          if (paramBoolean)
          {
            i1 = j + 1;
            if (i1 != paramInt) {
              break label224;
            }
            localArrayList.add(paramString1.substring(m));
          }
          for (i = k;; i = n)
          {
            m = i + i2;
            j = i1;
            break;
            label224:
            localArrayList.add("");
          }
        }
      }
      else
      {
        localArrayList.add(paramString1.substring(m));
        i = k;
      }
    }
    return (String[])localArrayList.toArray(new String[localArrayList.size()]);
  }
  
  public static String[] splitPreserveAllTokens(String paramString)
  {
    return splitWorker(paramString, null, -1, true);
  }
  
  public static String[] splitPreserveAllTokens(String paramString, char paramChar)
  {
    return splitWorker(paramString, paramChar, true);
  }
  
  public static String[] splitPreserveAllTokens(String paramString1, String paramString2)
  {
    return splitWorker(paramString1, paramString2, -1, true);
  }
  
  public static String[] splitPreserveAllTokens(String paramString1, String paramString2, int paramInt)
  {
    return splitWorker(paramString1, paramString2, paramInt, true);
  }
  
  private static String[] splitWorker(String paramString, char paramChar, boolean paramBoolean)
  {
    if (paramString == null) {
      return null;
    }
    int n = paramString.length();
    if (n == 0) {
      return ArrayUtils.EMPTY_STRING_ARRAY;
    }
    ArrayList localArrayList = new ArrayList();
    int j = 0;
    int k = 0;
    int m = 0;
    int i = 0;
    while (i < n) {
      if (paramString.charAt(i) == paramChar)
      {
        if ((k != 0) || (paramBoolean))
        {
          localArrayList.add(paramString.substring(m, i));
          j = 1;
          k = 0;
        }
        m = i + 1;
        i = m;
      }
      else
      {
        k = 1;
        i += 1;
        j = 0;
      }
    }
    if ((k != 0) || ((paramBoolean) && (j != 0))) {
      localArrayList.add(paramString.substring(m, i));
    }
    return (String[])localArrayList.toArray(new String[localArrayList.size()]);
  }
  
  private static String[] splitWorker(String paramString1, String paramString2, int paramInt, boolean paramBoolean)
  {
    if (paramString1 == null) {
      return null;
    }
    int m = paramString1.length();
    if (m == 0) {
      return ArrayUtils.EMPTY_STRING_ARRAY;
    }
    ArrayList localArrayList = new ArrayList();
    int j;
    int k;
    int n;
    int i;
    int i5;
    int i4;
    int i2;
    int i1;
    int i3;
    if (paramString2 == null)
    {
      j = 0;
      k = 0;
      n = 0;
      i = 0;
      i5 = 1;
      i4 = i;
      i2 = j;
      i1 = k;
      i3 = n;
      if (i >= m) {
        break label521;
      }
      if (Character.isWhitespace(paramString1.charAt(i)))
      {
        if ((k == 0) && (!paramBoolean)) {
          break label597;
        }
        if (i5 != paramInt) {
          break label587;
        }
        i = 0;
        j = m;
        label106:
        localArrayList.add(paramString1.substring(n, j));
        i5 += 1;
        n = 0;
        k = j;
        j = n;
      }
    }
    for (;;)
    {
      n = k + 1;
      k = j;
      j = i;
      i = n;
      break;
      i += 1;
      j = 0;
      k = 1;
      break;
      if (paramString2.length() == 1)
      {
        i2 = paramString2.charAt(0);
        j = 0;
        k = 0;
        n = 0;
        i = 0;
        i1 = 1;
        while (i < m) {
          if (paramString1.charAt(i) == i2)
          {
            if ((k == 0) && (!paramBoolean)) {
              break label550;
            }
            if (i1 != paramInt) {
              break label540;
            }
            i = 0;
            j = m;
            localArrayList.add(paramString1.substring(n, j));
            i1 += 1;
            n = 0;
            k = j;
            j = n;
            label278:
            n = k + 1;
            k = j;
            j = i;
            i = n;
          }
          else
          {
            i += 1;
            j = 0;
            k = 1;
          }
        }
        label314:
        if ((k != 0) || ((paramBoolean) && (j != 0))) {
          localArrayList.add(paramString1.substring(n, i));
        }
        return (String[])localArrayList.toArray(new String[localArrayList.size()]);
      }
      for (;;)
      {
        i4 = i;
        i2 = j;
        i1 = k;
        i3 = n;
        if (i < m)
        {
          if (paramString2.indexOf(paramString1.charAt(i)) >= 0)
          {
            if ((k == 0) && (!paramBoolean)) {
              break label502;
            }
            if (i5 != paramInt) {
              break label492;
            }
            i = 0;
            j = m;
            label423:
            localArrayList.add(paramString1.substring(n, j));
            i5 += 1;
            n = 0;
            k = j;
            j = n;
          }
          for (;;)
          {
            n = k + 1;
            k = j;
            j = i;
            i = n;
            break;
            i += 1;
            j = 0;
            k = 1;
            break;
            label492:
            j = i;
            i = 1;
            break label423;
            label502:
            n = i;
            i = j;
            j = k;
            k = n;
          }
        }
        label521:
        i = i4;
        n = i3;
        j = i2;
        k = i1;
        break label314;
        label540:
        j = i;
        i = 1;
        break;
        label550:
        n = i;
        i = j;
        j = k;
        k = n;
        break label278;
        j = 0;
        k = 0;
        n = 0;
        i = 0;
        i5 = 1;
      }
      label587:
      j = i;
      i = 1;
      break label106;
      label597:
      n = i;
      i = j;
      j = k;
      k = n;
    }
  }
  
  public static boolean startsWith(CharSequence paramCharSequence1, CharSequence paramCharSequence2)
  {
    return startsWith(paramCharSequence1, paramCharSequence2, false);
  }
  
  private static boolean startsWith(CharSequence paramCharSequence1, CharSequence paramCharSequence2, boolean paramBoolean)
  {
    boolean bool2 = false;
    boolean bool1;
    if ((paramCharSequence1 == null) || (paramCharSequence2 == null))
    {
      bool1 = bool2;
      if (paramCharSequence1 == null)
      {
        bool1 = bool2;
        if (paramCharSequence2 == null) {
          bool1 = true;
        }
      }
    }
    do
    {
      return bool1;
      bool1 = bool2;
    } while (paramCharSequence2.length() > paramCharSequence1.length());
    return CharSequenceUtils.regionMatches(paramCharSequence1, paramBoolean, 0, paramCharSequence2, 0, paramCharSequence2.length());
  }
  
  public static boolean startsWithAny(CharSequence paramCharSequence, CharSequence... paramVarArgs)
  {
    if ((isEmpty(paramCharSequence)) || (ArrayUtils.isEmpty(paramVarArgs))) {}
    for (;;)
    {
      return false;
      int j = paramVarArgs.length;
      int i = 0;
      while (i < j)
      {
        if (startsWith(paramCharSequence, paramVarArgs[i])) {
          return true;
        }
        i += 1;
      }
    }
  }
  
  public static boolean startsWithIgnoreCase(CharSequence paramCharSequence1, CharSequence paramCharSequence2)
  {
    return startsWith(paramCharSequence1, paramCharSequence2, true);
  }
  
  public static String strip(String paramString)
  {
    return strip(paramString, null);
  }
  
  public static String strip(String paramString1, String paramString2)
  {
    if (isEmpty(paramString1)) {
      return paramString1;
    }
    return stripEnd(stripStart(paramString1, paramString2), paramString2);
  }
  
  public static String stripAccents(String paramString)
  {
    if (paramString == null) {
      return null;
    }
    try
    {
      if (StringUtils.InitStripAccents.access$000() != null) {
        return removeAccentsJava6(paramString);
      }
      if (StringUtils.InitStripAccents.access$100() != null) {
        return removeAccentsSUN(paramString);
      }
      throw new UnsupportedOperationException("The stripAccents(CharSequence) method requires at least Java6, but got: " + StringUtils.InitStripAccents.access$200() + "; or a Sun JVM: " + StringUtils.InitStripAccents.access$300());
    }
    catch (IllegalArgumentException paramString)
    {
      throw new RuntimeException("IllegalArgumentException occurred", paramString);
    }
    catch (IllegalAccessException paramString)
    {
      throw new RuntimeException("IllegalAccessException occurred", paramString);
    }
    catch (InvocationTargetException paramString)
    {
      throw new RuntimeException("InvocationTargetException occurred", paramString);
    }
    catch (SecurityException paramString)
    {
      throw new RuntimeException("SecurityException occurred", paramString);
    }
  }
  
  public static String[] stripAll(String... paramVarArgs)
  {
    return stripAll(paramVarArgs, null);
  }
  
  public static String[] stripAll(String[] paramArrayOfString, String paramString)
  {
    int j;
    if (paramArrayOfString != null)
    {
      j = paramArrayOfString.length;
      if (j != 0) {}
    }
    else
    {
      return paramArrayOfString;
    }
    String[] arrayOfString = new String[j];
    int i = 0;
    while (i < j)
    {
      arrayOfString[i] = strip(paramArrayOfString[i], paramString);
      i += 1;
    }
    return arrayOfString;
  }
  
  public static String stripEnd(String paramString1, String paramString2)
  {
    int i;
    if (paramString1 != null)
    {
      i = paramString1.length();
      if (i != 0) {
        break label15;
      }
    }
    label15:
    int j;
    do
    {
      return paramString1;
      if (paramString2 == null) {
        for (;;)
        {
          j = i;
          if (i == 0) {
            break;
          }
          j = i;
          if (!Character.isWhitespace(paramString1.charAt(i - 1))) {
            break;
          }
          i -= 1;
        }
      }
    } while (paramString2.length() == 0);
    for (;;)
    {
      j = i;
      if (i == 0) {
        break;
      }
      j = i;
      if (paramString2.indexOf(paramString1.charAt(i - 1)) == -1) {
        break;
      }
      i -= 1;
    }
    return paramString1.substring(0, j);
  }
  
  public static String stripStart(String paramString1, String paramString2)
  {
    int k;
    if (paramString1 != null)
    {
      k = paramString1.length();
      if (k != 0) {
        break label17;
      }
    }
    label17:
    int j;
    do
    {
      return paramString1;
      j = 0;
      i = 0;
      if (paramString2 == null) {
        for (;;)
        {
          j = i;
          if (i == k) {
            break;
          }
          j = i;
          if (!Character.isWhitespace(paramString1.charAt(i))) {
            break;
          }
          i += 1;
        }
      }
    } while (paramString2.length() == 0);
    int i = j;
    for (;;)
    {
      j = i;
      if (i == k) {
        break;
      }
      j = i;
      if (paramString2.indexOf(paramString1.charAt(i)) == -1) {
        break;
      }
      i += 1;
    }
    return paramString1.substring(j);
  }
  
  public static String stripToEmpty(String paramString)
  {
    if (paramString == null) {
      return "";
    }
    return strip(paramString, null);
  }
  
  public static String stripToNull(String paramString)
  {
    if (paramString == null) {}
    do
    {
      return null;
      paramString = strip(paramString, null);
    } while (paramString.length() == 0);
    return paramString;
  }
  
  public static String substring(String paramString, int paramInt)
  {
    if (paramString == null) {
      return null;
    }
    if (paramInt < 0) {
      paramInt = paramString.length() + paramInt;
    }
    for (;;)
    {
      int i = paramInt;
      if (paramInt < 0) {
        i = 0;
      }
      if (i > paramString.length()) {
        return "";
      }
      return paramString.substring(i);
    }
  }
  
  public static String substring(String paramString, int paramInt1, int paramInt2)
  {
    int j = 0;
    if (paramString == null) {
      return null;
    }
    if (paramInt2 < 0) {}
    for (int i = paramString.length() + paramInt2;; i = paramInt2)
    {
      paramInt2 = paramInt1;
      if (paramInt1 < 0) {
        paramInt2 = paramInt1 + paramString.length();
      }
      paramInt1 = i;
      if (i > paramString.length()) {
        paramInt1 = paramString.length();
      }
      if (paramInt2 > paramInt1) {
        return "";
      }
      i = paramInt2;
      if (paramInt2 < 0) {
        i = 0;
      }
      if (paramInt1 < 0) {
        paramInt1 = j;
      }
      for (;;)
      {
        return paramString.substring(i, paramInt1);
      }
    }
  }
  
  public static String substringAfter(String paramString1, String paramString2)
  {
    if (isEmpty(paramString1)) {
      return paramString1;
    }
    if (paramString2 == null) {
      return "";
    }
    int i = paramString1.indexOf(paramString2);
    if (i == -1) {
      return "";
    }
    return paramString1.substring(i + paramString2.length());
  }
  
  public static String substringAfterLast(String paramString1, String paramString2)
  {
    if (isEmpty(paramString1)) {
      return paramString1;
    }
    if (isEmpty(paramString2)) {
      return "";
    }
    int i = paramString1.lastIndexOf(paramString2);
    if ((i == -1) || (i == paramString1.length() - paramString2.length())) {
      return "";
    }
    return paramString1.substring(i + paramString2.length());
  }
  
  public static String substringBefore(String paramString1, String paramString2)
  {
    if ((isEmpty(paramString1)) || (paramString2 == null)) {}
    int i;
    do
    {
      return paramString1;
      if (paramString2.length() == 0) {
        return "";
      }
      i = paramString1.indexOf(paramString2);
    } while (i == -1);
    return paramString1.substring(0, i);
  }
  
  public static String substringBeforeLast(String paramString1, String paramString2)
  {
    if ((isEmpty(paramString1)) || (isEmpty(paramString2))) {}
    int i;
    do
    {
      return paramString1;
      i = paramString1.lastIndexOf(paramString2);
    } while (i == -1);
    return paramString1.substring(0, i);
  }
  
  public static String substringBetween(String paramString1, String paramString2)
  {
    return substringBetween(paramString1, paramString2, paramString2);
  }
  
  public static String substringBetween(String paramString1, String paramString2, String paramString3)
  {
    if ((paramString1 == null) || (paramString2 == null) || (paramString3 == null)) {}
    int i;
    int j;
    do
    {
      do
      {
        return null;
        i = paramString1.indexOf(paramString2);
      } while (i == -1);
      j = paramString1.indexOf(paramString3, paramString2.length() + i);
    } while (j == -1);
    return paramString1.substring(paramString2.length() + i, j);
  }
  
  public static String[] substringsBetween(String paramString1, String paramString2, String paramString3)
  {
    label18:
    int j;
    int k;
    int m;
    ArrayList localArrayList;
    if ((paramString1 == null) || (isEmpty(paramString2)) || (isEmpty(paramString3)))
    {
      break label78;
      return null;
    }
    else
    {
      j = paramString1.length();
      if (j == 0) {
        return ArrayUtils.EMPTY_STRING_ARRAY;
      }
      k = paramString3.length();
      m = paramString2.length();
      localArrayList = new ArrayList();
    }
    label78:
    int n;
    for (int i = 0;; i = n + k)
    {
      if (i < j - k)
      {
        i = paramString1.indexOf(paramString2, i);
        if (i >= 0) {}
      }
      else
      {
        if (localArrayList.isEmpty()) {
          break label18;
        }
        return (String[])localArrayList.toArray(new String[localArrayList.size()]);
      }
      i += m;
      n = paramString1.indexOf(paramString3, i);
      if (n < 0) {
        break;
      }
      localArrayList.add(paramString1.substring(i, n));
    }
  }
  
  public static String swapCase(String paramString)
  {
    if (isEmpty(paramString)) {
      return paramString;
    }
    paramString = paramString.toCharArray();
    int i = 0;
    if (i < paramString.length)
    {
      char c = paramString[i];
      if (Character.isUpperCase(c)) {
        paramString[i] = Character.toLowerCase(c);
      }
      for (;;)
      {
        i += 1;
        break;
        if (Character.isTitleCase(c)) {
          paramString[i] = Character.toLowerCase(c);
        } else if (Character.isLowerCase(c)) {
          paramString[i] = Character.toUpperCase(c);
        }
      }
    }
    return new String(paramString);
  }
  
  public static String toString(byte[] paramArrayOfByte, String paramString)
  {
    if (paramString == null) {
      return new String(paramArrayOfByte);
    }
    return new String(paramArrayOfByte, paramString);
  }
  
  public static String trim(String paramString)
  {
    if (paramString == null) {
      return null;
    }
    return paramString.trim();
  }
  
  public static String trimToEmpty(String paramString)
  {
    if (paramString == null) {
      return "";
    }
    return paramString.trim();
  }
  
  public static String trimToNull(String paramString)
  {
    String str = trim(paramString);
    paramString = str;
    if (isEmpty(str)) {
      paramString = null;
    }
    return paramString;
  }
  
  public static String uncapitalize(String paramString)
  {
    int i;
    if (paramString != null)
    {
      i = paramString.length();
      if (i != 0) {}
    }
    else
    {
      return paramString;
    }
    return i + Character.toLowerCase(paramString.charAt(0)) + paramString.substring(1);
  }
  
  public static String upperCase(String paramString)
  {
    if (paramString == null) {
      return null;
    }
    return paramString.toUpperCase();
  }
  
  public static String upperCase(String paramString, Locale paramLocale)
  {
    if (paramString == null) {
      return null;
    }
    return paramString.toUpperCase(paramLocale);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     external.org.apache.commons.lang3.StringUtils
 * JD-Core Version:    0.7.0.1
 */