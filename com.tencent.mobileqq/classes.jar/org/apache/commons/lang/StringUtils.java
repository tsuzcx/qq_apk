package org.apache.commons.lang;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import org.apache.commons.lang.text.StrBuilder;

public class StringUtils
{
  public static final String EMPTY = "";
  public static final int INDEX_NOT_FOUND = -1;
  private static final int PAD_LIMIT = 8192;
  
  public static String abbreviate(String paramString, int paramInt)
  {
    return abbreviate(paramString, 0, paramInt);
  }
  
  public static String abbreviate(String paramString, int paramInt1, int paramInt2)
  {
    if (paramString == null) {
      return null;
    }
    if (paramInt2 >= 4)
    {
      if (paramString.length() <= paramInt2) {
        return paramString;
      }
      int i = paramInt1;
      if (paramInt1 > paramString.length()) {
        i = paramString.length();
      }
      int k = paramString.length();
      int j = paramInt2 - 3;
      paramInt1 = i;
      if (k - i < j) {
        paramInt1 = paramString.length() - j;
      }
      StringBuffer localStringBuffer;
      if (paramInt1 <= 4)
      {
        localStringBuffer = new StringBuffer();
        localStringBuffer.append(paramString.substring(0, j));
        localStringBuffer.append("...");
        return localStringBuffer.toString();
      }
      if (paramInt2 >= 7)
      {
        if (paramInt1 + j < paramString.length())
        {
          localStringBuffer = new StringBuffer();
          localStringBuffer.append("...");
          localStringBuffer.append(abbreviate(paramString.substring(paramInt1), j));
          return localStringBuffer.toString();
        }
        localStringBuffer = new StringBuffer();
        localStringBuffer.append("...");
        localStringBuffer.append(paramString.substring(paramString.length() - j));
        return localStringBuffer.toString();
      }
      throw new IllegalArgumentException("Minimum abbreviation width with offset is 7");
    }
    throw new IllegalArgumentException("Minimum abbreviation width is 4");
  }
  
  public static String abbreviateMiddle(String paramString1, String paramString2, int paramInt)
  {
    Object localObject = paramString1;
    if (!isEmpty(paramString1))
    {
      if (isEmpty(paramString2)) {
        return paramString1;
      }
      localObject = paramString1;
      if (paramInt < paramString1.length())
      {
        if (paramInt < paramString2.length() + 2) {
          return paramString1;
        }
        int i = paramInt - paramString2.length();
        int j = i / 2;
        int k = paramString1.length();
        localObject = new StrBuilder(paramInt);
        ((StrBuilder)localObject).append(paramString1.substring(0, i % 2 + j));
        ((StrBuilder)localObject).append(paramString2);
        ((StrBuilder)localObject).append(paramString1.substring(k - j));
        localObject = ((StrBuilder)localObject).toString();
      }
    }
    return localObject;
  }
  
  public static String capitalise(String paramString)
  {
    return capitalize(paramString);
  }
  
  public static String capitaliseAllWords(String paramString)
  {
    return WordUtils.capitalize(paramString);
  }
  
  public static String capitalize(String paramString)
  {
    String str = paramString;
    if (paramString != null)
    {
      int i = paramString.length();
      if (i == 0) {
        return paramString;
      }
      str = new StrBuilder(i).append(Character.toTitleCase(paramString.charAt(0))).append(paramString.substring(1)).toString();
    }
    return str;
  }
  
  public static String center(String paramString, int paramInt)
  {
    return center(paramString, paramInt, ' ');
  }
  
  public static String center(String paramString, int paramInt, char paramChar)
  {
    String str = paramString;
    if (paramString != null)
    {
      if (paramInt <= 0) {
        return paramString;
      }
      int i = paramString.length();
      int j = paramInt - i;
      if (j <= 0) {
        return paramString;
      }
      str = rightPad(leftPad(paramString, i + j / 2, paramChar), paramInt, paramChar);
    }
    return str;
  }
  
  public static String center(String paramString1, int paramInt, String paramString2)
  {
    String str = paramString1;
    if (paramString1 != null)
    {
      if (paramInt <= 0) {
        return paramString1;
      }
      str = paramString2;
      if (isEmpty(paramString2)) {
        str = " ";
      }
      int i = paramString1.length();
      int j = paramInt - i;
      if (j <= 0) {
        return paramString1;
      }
      str = rightPad(leftPad(paramString1, i + j / 2, str), paramInt, str);
    }
    return str;
  }
  
  public static String chomp(String paramString)
  {
    if (isEmpty(paramString)) {
      return paramString;
    }
    int i;
    if (paramString.length() == 1)
    {
      i = paramString.charAt(0);
      if ((i != 13) && (i != 10)) {
        return paramString;
      }
      return "";
    }
    int j = paramString.length() - 1;
    int k = paramString.charAt(j);
    if (k == 10)
    {
      i = j;
      if (paramString.charAt(j - 1) == '\r') {
        i = j - 1;
      }
    }
    else
    {
      i = j;
      if (k != 13) {
        i = j + 1;
      }
    }
    return paramString.substring(0, i);
  }
  
  public static String chomp(String paramString1, String paramString2)
  {
    String str = paramString1;
    if (!isEmpty(paramString1))
    {
      if (paramString2 == null) {
        return paramString1;
      }
      str = paramString1;
      if (paramString1.endsWith(paramString2)) {
        str = paramString1.substring(0, paramString1.length() - paramString2.length());
      }
    }
    return str;
  }
  
  public static String chompLast(String paramString)
  {
    return chompLast(paramString, "\n");
  }
  
  public static String chompLast(String paramString1, String paramString2)
  {
    if (paramString1.length() == 0) {
      return paramString1;
    }
    String str = paramString1;
    if (paramString2.equals(paramString1.substring(paramString1.length() - paramString2.length()))) {
      str = paramString1.substring(0, paramString1.length() - paramString2.length());
    }
    return str;
  }
  
  public static String chop(String paramString)
  {
    if (paramString == null) {
      return null;
    }
    int i = paramString.length();
    if (i < 2) {
      return "";
    }
    i -= 1;
    String str = paramString.substring(0, i);
    if (paramString.charAt(i) == '\n')
    {
      i -= 1;
      if (str.charAt(i) == '\r') {
        return str.substring(0, i);
      }
    }
    return str;
  }
  
  public static String chopNewline(String paramString)
  {
    int j = paramString.length() - 1;
    if (j <= 0) {
      return "";
    }
    int i;
    if (paramString.charAt(j) == '\n')
    {
      i = j;
      if (paramString.charAt(j - 1) == '\r') {
        i = j - 1;
      }
    }
    else
    {
      i = j + 1;
    }
    return paramString.substring(0, i);
  }
  
  public static String clean(String paramString)
  {
    if (paramString == null) {
      return "";
    }
    return paramString.trim();
  }
  
  public static String concatenate(Object[] paramArrayOfObject)
  {
    return join(paramArrayOfObject, null);
  }
  
  public static boolean contains(String paramString, char paramChar)
  {
    boolean bool2 = isEmpty(paramString);
    boolean bool1 = false;
    if (bool2) {
      return false;
    }
    if (paramString.indexOf(paramChar) >= 0) {
      bool1 = true;
    }
    return bool1;
  }
  
  public static boolean contains(String paramString1, String paramString2)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (paramString1 != null)
    {
      if (paramString2 == null) {
        return false;
      }
      bool1 = bool2;
      if (paramString1.indexOf(paramString2) >= 0) {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  public static boolean containsAny(String paramString1, String paramString2)
  {
    if (paramString2 == null) {
      return false;
    }
    return containsAny(paramString1, paramString2.toCharArray());
  }
  
  public static boolean containsAny(String paramString, char[] paramArrayOfChar)
  {
    if (!isEmpty(paramString))
    {
      if (ArrayUtils.isEmpty(paramArrayOfChar)) {
        return false;
      }
      int k = paramString.length();
      int m = paramArrayOfChar.length;
      int i = 0;
      while (i < k)
      {
        char c = paramString.charAt(i);
        int j = 0;
        while (j < m)
        {
          if (paramArrayOfChar[j] == c) {
            if (CharUtils.isHighSurrogate(c))
            {
              if (j == m - 1) {
                return true;
              }
              if ((i >= k - 1) || (paramArrayOfChar[(j + 1)] != paramString.charAt(i + 1))) {}
            }
            else
            {
              return true;
            }
          }
          j += 1;
        }
        i += 1;
      }
    }
    return false;
  }
  
  public static boolean containsIgnoreCase(String paramString1, String paramString2)
  {
    if (paramString1 != null)
    {
      if (paramString2 == null) {
        return false;
      }
      int j = paramString2.length();
      int k = paramString1.length();
      int i = 0;
      while (i <= k - j)
      {
        if (paramString1.regionMatches(true, i, paramString2, 0, j)) {
          return true;
        }
        i += 1;
      }
    }
    return false;
  }
  
  public static boolean containsNone(String paramString1, String paramString2)
  {
    if ((paramString1 != null) && (paramString2 != null)) {
      return containsNone(paramString1, paramString2.toCharArray());
    }
    return true;
  }
  
  public static boolean containsNone(String paramString, char[] paramArrayOfChar)
  {
    if (paramString != null)
    {
      if (paramArrayOfChar == null) {
        return true;
      }
      int k = paramString.length();
      int m = paramArrayOfChar.length;
      int i = 0;
      while (i < k)
      {
        char c = paramString.charAt(i);
        int j = 0;
        while (j < m)
        {
          if (paramArrayOfChar[j] == c) {
            if (CharUtils.isHighSurrogate(c))
            {
              if (j == m - 1) {
                return false;
              }
              if ((i >= k - 1) || (paramArrayOfChar[(j + 1)] != paramString.charAt(i + 1))) {}
            }
            else
            {
              return false;
            }
          }
          j += 1;
        }
        i += 1;
      }
    }
    return true;
  }
  
  public static boolean containsOnly(String paramString1, String paramString2)
  {
    if ((paramString1 != null) && (paramString2 != null)) {
      return containsOnly(paramString1, paramString2.toCharArray());
    }
    return false;
  }
  
  public static boolean containsOnly(String paramString, char[] paramArrayOfChar)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (paramArrayOfChar != null)
    {
      if (paramString == null) {
        return false;
      }
      if (paramString.length() == 0) {
        return true;
      }
      if (paramArrayOfChar.length == 0) {
        return false;
      }
      bool1 = bool2;
      if (indexOfAnyBut(paramString, paramArrayOfChar) == -1) {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  public static int countMatches(String paramString1, String paramString2)
  {
    boolean bool = isEmpty(paramString1);
    int j = 0;
    if (!bool)
    {
      if (isEmpty(paramString2)) {
        return 0;
      }
      int i = 0;
      for (;;)
      {
        j = paramString1.indexOf(paramString2, j);
        if (j == -1) {
          break;
        }
        i += 1;
        j += paramString2.length();
      }
      return i;
    }
    return 0;
  }
  
  public static String defaultIfBlank(String paramString1, String paramString2)
  {
    String str = paramString1;
    if (isBlank(paramString1)) {
      str = paramString2;
    }
    return str;
  }
  
  public static String defaultIfEmpty(String paramString1, String paramString2)
  {
    String str = paramString1;
    if (isEmpty(paramString1)) {
      str = paramString2;
    }
    return str;
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
    String str = paramString1;
    if (paramString1 == null) {
      str = paramString2;
    }
    return str;
  }
  
  public static String deleteSpaces(String paramString)
  {
    if (paramString == null) {
      return null;
    }
    return CharSetUtils.delete(paramString, " \t\r\n\b");
  }
  
  public static String deleteWhitespace(String paramString)
  {
    if (isEmpty(paramString)) {
      return paramString;
    }
    int m = paramString.length();
    char[] arrayOfChar = new char[m];
    int i = 0;
    int k;
    for (int j = 0; i < m; j = k)
    {
      k = j;
      if (!Character.isWhitespace(paramString.charAt(i)))
      {
        arrayOfChar[j] = paramString.charAt(i);
        k = j + 1;
      }
      i += 1;
    }
    if (j == m) {
      return paramString;
    }
    return new String(arrayOfChar, 0, j);
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
  
  public static boolean endsWith(String paramString1, String paramString2)
  {
    return endsWith(paramString1, paramString2, false);
  }
  
  private static boolean endsWith(String paramString1, String paramString2, boolean paramBoolean)
  {
    boolean bool = false;
    if ((paramString1 != null) && (paramString2 != null))
    {
      if (paramString2.length() > paramString1.length()) {
        return false;
      }
      return paramString1.regionMatches(paramBoolean, paramString1.length() - paramString2.length(), paramString2, 0, paramString2.length());
    }
    paramBoolean = bool;
    if (paramString1 == null)
    {
      paramBoolean = bool;
      if (paramString2 == null) {
        paramBoolean = true;
      }
    }
    return paramBoolean;
  }
  
  public static boolean endsWithAny(String paramString, String[] paramArrayOfString)
  {
    if (!isEmpty(paramString))
    {
      if (ArrayUtils.isEmpty(paramArrayOfString)) {
        return false;
      }
      int i = 0;
      while (i < paramArrayOfString.length)
      {
        if (endsWith(paramString, paramArrayOfString[i])) {
          return true;
        }
        i += 1;
      }
    }
    return false;
  }
  
  public static boolean endsWithIgnoreCase(String paramString1, String paramString2)
  {
    return endsWith(paramString1, paramString2, true);
  }
  
  public static boolean equals(String paramString1, String paramString2)
  {
    if (paramString1 == null) {
      return paramString2 == null;
    }
    return paramString1.equals(paramString2);
  }
  
  public static boolean equalsIgnoreCase(String paramString1, String paramString2)
  {
    if (paramString1 == null) {
      return paramString2 == null;
    }
    return paramString1.equalsIgnoreCase(paramString2);
  }
  
  public static String escape(String paramString)
  {
    return StringEscapeUtils.escapeJava(paramString);
  }
  
  public static String getChomp(String paramString1, String paramString2)
  {
    int i = paramString1.lastIndexOf(paramString2);
    if (i == paramString1.length() - paramString2.length()) {
      return paramString2;
    }
    if (i != -1) {
      return paramString1.substring(i);
    }
    return "";
  }
  
  public static String getCommonPrefix(String[] paramArrayOfString)
  {
    if (paramArrayOfString != null)
    {
      if (paramArrayOfString.length == 0) {
        return "";
      }
      int i = indexOfDifference(paramArrayOfString);
      if (i == -1)
      {
        if (paramArrayOfString[0] == null) {
          return "";
        }
        return paramArrayOfString[0];
      }
      if (i == 0) {
        return "";
      }
      return paramArrayOfString[0].substring(0, i);
    }
    return "";
  }
  
  public static int getLevenshteinDistance(String paramString1, String paramString2)
  {
    if ((paramString1 != null) && (paramString2 != null))
    {
      int i = paramString1.length();
      int j = paramString2.length();
      if (i == 0) {
        return j;
      }
      if (j == 0) {
        return i;
      }
      String str1;
      String str2;
      if (i > j)
      {
        k = paramString1.length();
        i = j;
        j = k;
        str1 = paramString1;
        str2 = paramString2;
      }
      else
      {
        str2 = paramString1;
        str1 = paramString2;
      }
      int k = i + 1;
      paramString1 = new int[k];
      paramString2 = new int[k];
      k = 0;
      while (k <= i)
      {
        paramString1[k] = k;
        k += 1;
      }
      k = 1;
      for (;;)
      {
        String str3 = paramString2;
        if (k > j) {
          break;
        }
        int i1 = str1.charAt(k - 1);
        str3[0] = k;
        int m = 1;
        while (m <= i)
        {
          int i2 = m - 1;
          int n;
          if (str2.charAt(i2) == i1) {
            n = 0;
          } else {
            n = 1;
          }
          str3[m] = Math.min(Math.min(str3[i2] + 1, paramString1[m] + 1), paramString1[i2] + n);
          m += 1;
        }
        k += 1;
        paramString2 = paramString1;
        paramString1 = str3;
      }
      return paramString1[i];
    }
    paramString1 = new IllegalArgumentException("Strings must not be null");
    for (;;)
    {
      throw paramString1;
    }
  }
  
  public static String getNestedString(String paramString1, String paramString2)
  {
    return substringBetween(paramString1, paramString2, paramString2);
  }
  
  public static String getNestedString(String paramString1, String paramString2, String paramString3)
  {
    return substringBetween(paramString1, paramString2, paramString3);
  }
  
  public static String getPrechomp(String paramString1, String paramString2)
  {
    int i = paramString1.indexOf(paramString2);
    if (i == -1) {
      return "";
    }
    return paramString1.substring(0, i + paramString2.length());
  }
  
  public static int indexOf(String paramString, char paramChar)
  {
    if (isEmpty(paramString)) {
      return -1;
    }
    return paramString.indexOf(paramChar);
  }
  
  public static int indexOf(String paramString, char paramChar, int paramInt)
  {
    if (isEmpty(paramString)) {
      return -1;
    }
    return paramString.indexOf(paramChar, paramInt);
  }
  
  public static int indexOf(String paramString1, String paramString2)
  {
    if ((paramString1 != null) && (paramString2 != null)) {
      return paramString1.indexOf(paramString2);
    }
    return -1;
  }
  
  public static int indexOf(String paramString1, String paramString2, int paramInt)
  {
    if ((paramString1 != null) && (paramString2 != null))
    {
      if ((paramString2.length() == 0) && (paramInt >= paramString1.length())) {
        return paramString1.length();
      }
      return paramString1.indexOf(paramString2, paramInt);
    }
    return -1;
  }
  
  public static int indexOfAny(String paramString1, String paramString2)
  {
    if ((!isEmpty(paramString1)) && (!isEmpty(paramString2))) {
      return indexOfAny(paramString1, paramString2.toCharArray());
    }
    return -1;
  }
  
  public static int indexOfAny(String paramString, char[] paramArrayOfChar)
  {
    if (!isEmpty(paramString))
    {
      if (ArrayUtils.isEmpty(paramArrayOfChar)) {
        return -1;
      }
      int k = paramString.length();
      int m = paramArrayOfChar.length;
      int i = 0;
      while (i < k)
      {
        char c = paramString.charAt(i);
        int j = 0;
        while (j < m)
        {
          if ((paramArrayOfChar[j] == c) && ((i >= k - 1) || (j >= m - 1) || (!CharUtils.isHighSurrogate(c)) || (paramArrayOfChar[(j + 1)] == paramString.charAt(i + 1)))) {
            return i;
          }
          j += 1;
        }
        i += 1;
      }
    }
    return -1;
  }
  
  public static int indexOfAny(String paramString, String[] paramArrayOfString)
  {
    int i = -1;
    if (paramString != null)
    {
      if (paramArrayOfString == null) {
        return -1;
      }
      int n = paramArrayOfString.length;
      int j = 0;
      int k;
      for (i = 2147483647; j < n; i = k)
      {
        String str = paramArrayOfString[j];
        if (str == null)
        {
          k = i;
        }
        else
        {
          int m = paramString.indexOf(str);
          if (m == -1)
          {
            k = i;
          }
          else
          {
            k = i;
            if (m < i) {
              k = m;
            }
          }
        }
        j += 1;
      }
      if (i == 2147483647) {
        return -1;
      }
    }
    return i;
  }
  
  public static int indexOfAnyBut(String paramString1, String paramString2)
  {
    if (!isEmpty(paramString1))
    {
      if (isEmpty(paramString2)) {
        return -1;
      }
      int m = paramString1.length();
      int k;
      for (int i = 0; i < m; i = k)
      {
        char c = paramString1.charAt(i);
        int j;
        if (paramString2.indexOf(c) >= 0) {
          j = 1;
        } else {
          j = 0;
        }
        k = i + 1;
        if ((k < m) && (CharUtils.isHighSurrogate(c)))
        {
          int n = paramString1.charAt(k);
          if ((j != 0) && (paramString2.indexOf(n) < 0)) {
            return i;
          }
        }
        else if (j == 0)
        {
          return i;
        }
      }
    }
    return -1;
  }
  
  public static int indexOfAnyBut(String paramString, char[] paramArrayOfChar)
  {
    if (!isEmpty(paramString))
    {
      if (ArrayUtils.isEmpty(paramArrayOfChar)) {
        return -1;
      }
      int k = paramString.length();
      int m = paramArrayOfChar.length;
      int i = 0;
      if (i < k)
      {
        char c = paramString.charAt(i);
        int j = 0;
        for (;;)
        {
          if (j >= m) {
            break label114;
          }
          if ((paramArrayOfChar[j] == c) && ((i >= k - 1) || (j >= m - 1) || (!CharUtils.isHighSurrogate(c)) || (paramArrayOfChar[(j + 1)] == paramString.charAt(i + 1))))
          {
            i += 1;
            break;
          }
          j += 1;
        }
        label114:
        return i;
      }
    }
    return -1;
  }
  
  public static int indexOfDifference(String paramString1, String paramString2)
  {
    if (paramString1 == paramString2) {
      return -1;
    }
    int j = 0;
    int i = 0;
    if (paramString1 != null)
    {
      if (paramString2 == null) {
        return 0;
      }
      while ((i < paramString1.length()) && (i < paramString2.length()) && (paramString1.charAt(i) == paramString2.charAt(i))) {
        i += 1;
      }
      j = i;
      if (i >= paramString2.length())
      {
        if (i < paramString1.length()) {
          return i;
        }
        return -1;
      }
    }
    return j;
  }
  
  public static int indexOfDifference(String[] paramArrayOfString)
  {
    if (paramArrayOfString != null)
    {
      if (paramArrayOfString.length <= 1) {
        return -1;
      }
      int i2 = paramArrayOfString.length;
      int j = 0;
      int i1 = 1;
      int m = 0;
      int n = 2147483647;
      int k;
      for (int i = 0; j < i2; i = k)
      {
        if (paramArrayOfString[j] == null)
        {
          i = 0;
          k = 1;
        }
        else
        {
          k = Math.min(paramArrayOfString[j].length(), n);
          n = Math.max(paramArrayOfString[j].length(), m);
          m = k;
          i1 = 0;
          k = i;
          i = m;
          m = n;
        }
        j += 1;
        n = i;
      }
      if (i1 == 0)
      {
        if ((m == 0) && (i == 0)) {
          return -1;
        }
        if (n == 0) {
          return 0;
        }
        i = 0;
        for (j = -1;; j = k)
        {
          k = j;
          if (i >= n) {
            break;
          }
          int i3 = paramArrayOfString[0].charAt(i);
          i1 = 1;
          for (;;)
          {
            k = j;
            if (i1 >= i2) {
              break;
            }
            if (paramArrayOfString[i1].charAt(i) != i3)
            {
              k = i;
              break;
            }
            i1 += 1;
          }
          if (k != -1) {
            break;
          }
          i += 1;
        }
        if ((k == -1) && (n != m)) {
          return n;
        }
        return k;
      }
    }
    return -1;
  }
  
  public static int indexOfIgnoreCase(String paramString1, String paramString2)
  {
    return indexOfIgnoreCase(paramString1, paramString2, 0);
  }
  
  public static int indexOfIgnoreCase(String paramString1, String paramString2, int paramInt)
  {
    if (paramString1 != null)
    {
      if (paramString2 == null) {
        return -1;
      }
      int i = paramInt;
      if (paramInt < 0) {
        i = 0;
      }
      int j = paramString1.length() - paramString2.length() + 1;
      if (i > j) {
        return -1;
      }
      paramInt = i;
      if (paramString2.length() == 0) {
        return i;
      }
      while (paramInt < j)
      {
        if (paramString1.regionMatches(true, paramInt, paramString2, 0, paramString2.length())) {
          return paramInt;
        }
        paramInt += 1;
      }
    }
    return -1;
  }
  
  public static boolean isAllLowerCase(String paramString)
  {
    if (paramString != null)
    {
      if (isEmpty(paramString)) {
        return false;
      }
      int j = paramString.length();
      int i = 0;
      while (i < j)
      {
        if (!Character.isLowerCase(paramString.charAt(i))) {
          return false;
        }
        i += 1;
      }
      return true;
    }
    return false;
  }
  
  public static boolean isAllUpperCase(String paramString)
  {
    if (paramString != null)
    {
      if (isEmpty(paramString)) {
        return false;
      }
      int j = paramString.length();
      int i = 0;
      while (i < j)
      {
        if (!Character.isUpperCase(paramString.charAt(i))) {
          return false;
        }
        i += 1;
      }
      return true;
    }
    return false;
  }
  
  public static boolean isAlpha(String paramString)
  {
    if (paramString == null) {
      return false;
    }
    int j = paramString.length();
    int i = 0;
    while (i < j)
    {
      if (!Character.isLetter(paramString.charAt(i))) {
        return false;
      }
      i += 1;
    }
    return true;
  }
  
  public static boolean isAlphaSpace(String paramString)
  {
    if (paramString == null) {
      return false;
    }
    int j = paramString.length();
    int i = 0;
    while (i < j)
    {
      if ((!Character.isLetter(paramString.charAt(i))) && (paramString.charAt(i) != ' ')) {
        return false;
      }
      i += 1;
    }
    return true;
  }
  
  public static boolean isAlphanumeric(String paramString)
  {
    if (paramString == null) {
      return false;
    }
    int j = paramString.length();
    int i = 0;
    while (i < j)
    {
      if (!Character.isLetterOrDigit(paramString.charAt(i))) {
        return false;
      }
      i += 1;
    }
    return true;
  }
  
  public static boolean isAlphanumericSpace(String paramString)
  {
    if (paramString == null) {
      return false;
    }
    int j = paramString.length();
    int i = 0;
    while (i < j)
    {
      if ((!Character.isLetterOrDigit(paramString.charAt(i))) && (paramString.charAt(i) != ' ')) {
        return false;
      }
      i += 1;
    }
    return true;
  }
  
  public static boolean isAsciiPrintable(String paramString)
  {
    if (paramString == null) {
      return false;
    }
    int j = paramString.length();
    int i = 0;
    while (i < j)
    {
      if (!CharUtils.isAsciiPrintable(paramString.charAt(i))) {
        return false;
      }
      i += 1;
    }
    return true;
  }
  
  public static boolean isBlank(String paramString)
  {
    if (paramString != null)
    {
      int j = paramString.length();
      if (j == 0) {
        return true;
      }
      int i = 0;
      while (i < j)
      {
        if (!Character.isWhitespace(paramString.charAt(i))) {
          return false;
        }
        i += 1;
      }
    }
    return true;
  }
  
  public static boolean isEmpty(String paramString)
  {
    return (paramString == null) || (paramString.length() == 0);
  }
  
  public static boolean isNotBlank(String paramString)
  {
    return isBlank(paramString) ^ true;
  }
  
  public static boolean isNotEmpty(String paramString)
  {
    return isEmpty(paramString) ^ true;
  }
  
  public static boolean isNumeric(String paramString)
  {
    if (paramString == null) {
      return false;
    }
    int j = paramString.length();
    int i = 0;
    while (i < j)
    {
      if (!Character.isDigit(paramString.charAt(i))) {
        return false;
      }
      i += 1;
    }
    return true;
  }
  
  public static boolean isNumericSpace(String paramString)
  {
    if (paramString == null) {
      return false;
    }
    int j = paramString.length();
    int i = 0;
    while (i < j)
    {
      if ((!Character.isDigit(paramString.charAt(i))) && (paramString.charAt(i) != ' ')) {
        return false;
      }
      i += 1;
    }
    return true;
  }
  
  public static boolean isWhitespace(String paramString)
  {
    if (paramString == null) {
      return false;
    }
    int j = paramString.length();
    int i = 0;
    while (i < j)
    {
      if (!Character.isWhitespace(paramString.charAt(i))) {
        return false;
      }
      i += 1;
    }
    return true;
  }
  
  public static String join(Collection paramCollection, char paramChar)
  {
    if (paramCollection == null) {
      return null;
    }
    return join(paramCollection.iterator(), paramChar);
  }
  
  public static String join(Collection paramCollection, String paramString)
  {
    if (paramCollection == null) {
      return null;
    }
    return join(paramCollection.iterator(), paramString);
  }
  
  public static String join(Iterator paramIterator, char paramChar)
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
    StrBuilder localStrBuilder = new StrBuilder(256);
    if (localObject != null) {
      localStrBuilder.append(localObject);
    }
    while (paramIterator.hasNext())
    {
      localStrBuilder.append(paramChar);
      localObject = paramIterator.next();
      if (localObject != null) {
        localStrBuilder.append(localObject);
      }
    }
    return localStrBuilder.toString();
  }
  
  public static String join(Iterator paramIterator, String paramString)
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
    StrBuilder localStrBuilder = new StrBuilder(256);
    if (localObject != null) {
      localStrBuilder.append(localObject);
    }
    while (paramIterator.hasNext())
    {
      if (paramString != null) {
        localStrBuilder.append(paramString);
      }
      localObject = paramIterator.next();
      if (localObject != null) {
        localStrBuilder.append(localObject);
      }
    }
    return localStrBuilder.toString();
  }
  
  public static String join(Object[] paramArrayOfObject)
  {
    return join(paramArrayOfObject, null);
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
    int j = paramInt2 - paramInt1;
    if (j <= 0) {
      return "";
    }
    if (paramArrayOfObject[paramInt1] == null) {
      i = 16;
    } else {
      i = paramArrayOfObject[paramInt1].toString().length();
    }
    StrBuilder localStrBuilder = new StrBuilder(j * (i + 1));
    int i = paramInt1;
    while (i < paramInt2)
    {
      if (i > paramInt1) {
        localStrBuilder.append(paramChar);
      }
      if (paramArrayOfObject[i] != null) {
        localStrBuilder.append(paramArrayOfObject[i]);
      }
      i += 1;
    }
    return localStrBuilder.toString();
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
    int j = paramInt2 - paramInt1;
    if (j <= 0) {
      return "";
    }
    if (paramArrayOfObject[paramInt1] == null) {
      i = 16;
    } else {
      i = paramArrayOfObject[paramInt1].toString().length();
    }
    paramString = new StrBuilder(j * (i + str.length()));
    int i = paramInt1;
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
  
  public static int lastIndexOf(String paramString, char paramChar)
  {
    if (isEmpty(paramString)) {
      return -1;
    }
    return paramString.lastIndexOf(paramChar);
  }
  
  public static int lastIndexOf(String paramString, char paramChar, int paramInt)
  {
    if (isEmpty(paramString)) {
      return -1;
    }
    return paramString.lastIndexOf(paramChar, paramInt);
  }
  
  public static int lastIndexOf(String paramString1, String paramString2)
  {
    if ((paramString1 != null) && (paramString2 != null)) {
      return paramString1.lastIndexOf(paramString2);
    }
    return -1;
  }
  
  public static int lastIndexOf(String paramString1, String paramString2, int paramInt)
  {
    if ((paramString1 != null) && (paramString2 != null)) {
      return paramString1.lastIndexOf(paramString2, paramInt);
    }
    return -1;
  }
  
  public static int lastIndexOfAny(String paramString, String[] paramArrayOfString)
  {
    int i = -1;
    int k = i;
    if (paramString != null)
    {
      if (paramArrayOfString == null) {
        return -1;
      }
      int n = paramArrayOfString.length;
      int j = 0;
      for (;;)
      {
        k = i;
        if (j >= n) {
          break;
        }
        String str = paramArrayOfString[j];
        if (str == null)
        {
          k = i;
        }
        else
        {
          int m = paramString.lastIndexOf(str);
          k = i;
          if (m > i) {
            k = m;
          }
        }
        j += 1;
        i = k;
      }
    }
    return k;
  }
  
  public static int lastIndexOfIgnoreCase(String paramString1, String paramString2)
  {
    if ((paramString1 != null) && (paramString2 != null)) {
      return lastIndexOfIgnoreCase(paramString1, paramString2, paramString1.length());
    }
    return -1;
  }
  
  public static int lastIndexOfIgnoreCase(String paramString1, String paramString2, int paramInt)
  {
    if (paramString1 != null)
    {
      if (paramString2 == null) {
        return -1;
      }
      int i = paramInt;
      if (paramInt > paramString1.length() - paramString2.length()) {
        i = paramString1.length() - paramString2.length();
      }
      if (i < 0) {
        return -1;
      }
      paramInt = i;
      if (paramString2.length() == 0) {
        return i;
      }
      while (paramInt >= 0)
      {
        if (paramString1.regionMatches(true, paramInt, paramString2, 0, paramString2.length())) {
          return paramInt;
        }
        paramInt -= 1;
      }
    }
    return -1;
  }
  
  public static int lastOrdinalIndexOf(String paramString1, String paramString2, int paramInt)
  {
    return ordinalIndexOf(paramString1, paramString2, paramInt, true);
  }
  
  public static String left(String paramString, int paramInt)
  {
    if (paramString == null) {
      return null;
    }
    if (paramInt < 0) {
      return "";
    }
    if (paramString.length() <= paramInt) {
      return paramString;
    }
    return paramString.substring(0, paramInt);
  }
  
  public static String leftPad(String paramString, int paramInt)
  {
    return leftPad(paramString, paramInt, ' ');
  }
  
  public static String leftPad(String paramString, int paramInt, char paramChar)
  {
    if (paramString == null) {
      return null;
    }
    int i = paramInt - paramString.length();
    if (i <= 0) {
      return paramString;
    }
    if (i > 8192) {
      return leftPad(paramString, paramInt, String.valueOf(paramChar));
    }
    return padding(i, paramChar).concat(paramString);
  }
  
  public static String leftPad(String paramString1, int paramInt, String paramString2)
  {
    if (paramString1 == null) {
      return null;
    }
    Object localObject = paramString2;
    if (isEmpty(paramString2)) {
      localObject = " ";
    }
    int j = ((String)localObject).length();
    int k = paramInt - paramString1.length();
    if (k <= 0) {
      return paramString1;
    }
    int i = 0;
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
    localObject = ((String)localObject).toCharArray();
    paramInt = i;
    while (paramInt < k)
    {
      paramString2[paramInt] = localObject[(paramInt % j)];
      paramInt += 1;
    }
    return new String(paramString2).concat(paramString1);
  }
  
  public static int length(String paramString)
  {
    if (paramString == null) {
      return 0;
    }
    return paramString.length();
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
    if ((paramInt2 >= 0) && (paramInt1 <= paramString.length()))
    {
      int i = paramInt1;
      if (paramInt1 < 0) {
        i = 0;
      }
      paramInt1 = paramString.length();
      paramInt2 += i;
      if (paramInt1 <= paramInt2) {
        return paramString.substring(i);
      }
      return paramString.substring(i, paramInt2);
    }
    return "";
  }
  
  public static String normalizeSpace(String paramString)
  {
    String str = strip(paramString);
    paramString = str;
    if (str != null)
    {
      if (str.length() <= 2) {
        return str;
      }
      paramString = new StrBuilder(str.length());
      int i = 0;
      while (i < str.length())
      {
        char c = str.charAt(i);
        if (Character.isWhitespace(c))
        {
          if ((i > 0) && (!Character.isWhitespace(str.charAt(i - 1)))) {
            paramString.append(' ');
          }
        }
        else {
          paramString.append(c);
        }
        i += 1;
      }
      paramString = paramString.toString();
    }
    return paramString;
  }
  
  public static int ordinalIndexOf(String paramString1, String paramString2, int paramInt)
  {
    return ordinalIndexOf(paramString1, paramString2, paramInt, false);
  }
  
  private static int ordinalIndexOf(String paramString1, String paramString2, int paramInt, boolean paramBoolean)
  {
    int j = -1;
    int i = j;
    if (paramString1 != null)
    {
      i = j;
      if (paramString2 != null)
      {
        if (paramInt <= 0) {
          return -1;
        }
        int m = paramString2.length();
        i = 0;
        int k = 0;
        if (m == 0)
        {
          paramInt = k;
          if (paramBoolean) {
            paramInt = paramString1.length();
          }
          return paramInt;
        }
        k = i;
        if (paramBoolean)
        {
          j = paramString1.length();
          k = i;
        }
        do
        {
          if (paramBoolean) {
            i = paramString1.lastIndexOf(paramString2, j - 1);
          } else {
            i = paramString1.indexOf(paramString2, j + 1);
          }
          if (i < 0) {
            return i;
          }
          m = k + 1;
          j = i;
          k = m;
        } while (m < paramInt);
      }
    }
    return i;
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
    int i = paramInt1;
    if (paramInt1 < 0) {
      i = 0;
    }
    paramInt1 = i;
    if (i > j) {
      paramInt1 = j;
    }
    i = paramInt2;
    if (paramInt2 < 0) {
      i = 0;
    }
    paramInt2 = i;
    if (i > j) {
      paramInt2 = j;
    }
    int k = paramInt1;
    i = paramInt2;
    if (paramInt1 > paramInt2)
    {
      i = paramInt1;
      k = paramInt2;
    }
    return new StrBuilder(j + k - i + str.length() + 1).append(paramString1.substring(0, k)).append(str).append(paramString1.substring(i)).toString();
  }
  
  public static String overlayString(String paramString1, String paramString2, int paramInt1, int paramInt2)
  {
    return new StrBuilder(paramString2.length() + paramInt1 + paramString1.length() - paramInt2 + 1).append(paramString1.substring(0, paramInt1)).append(paramString2).append(paramString1.substring(paramInt2)).toString();
  }
  
  private static String padding(int paramInt, char paramChar)
  {
    if (paramInt >= 0)
    {
      localObject = new char[paramInt];
      paramInt = 0;
      while (paramInt < localObject.length)
      {
        localObject[paramInt] = paramChar;
        paramInt += 1;
      }
      return new String((char[])localObject);
    }
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("Cannot pad a negative amount: ");
    ((StringBuffer)localObject).append(paramInt);
    localObject = new IndexOutOfBoundsException(((StringBuffer)localObject).toString());
    for (;;)
    {
      throw ((Throwable)localObject);
    }
  }
  
  public static String prechomp(String paramString1, String paramString2)
  {
    int i = paramString1.indexOf(paramString2);
    if (i == -1) {
      return paramString1;
    }
    return paramString1.substring(i + paramString2.length());
  }
  
  public static String remove(String paramString, char paramChar)
  {
    if (!isEmpty(paramString))
    {
      if (paramString.indexOf(paramChar) == -1) {
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
    return paramString;
  }
  
  public static String remove(String paramString1, String paramString2)
  {
    String str = paramString1;
    if (!isEmpty(paramString1))
    {
      if (isEmpty(paramString2)) {
        return paramString1;
      }
      str = replace(paramString1, paramString2, "", -1);
    }
    return str;
  }
  
  public static String removeEnd(String paramString1, String paramString2)
  {
    String str = paramString1;
    if (!isEmpty(paramString1))
    {
      if (isEmpty(paramString2)) {
        return paramString1;
      }
      str = paramString1;
      if (paramString1.endsWith(paramString2)) {
        str = paramString1.substring(0, paramString1.length() - paramString2.length());
      }
    }
    return str;
  }
  
  public static String removeEndIgnoreCase(String paramString1, String paramString2)
  {
    String str = paramString1;
    if (!isEmpty(paramString1))
    {
      if (isEmpty(paramString2)) {
        return paramString1;
      }
      str = paramString1;
      if (endsWithIgnoreCase(paramString1, paramString2)) {
        str = paramString1.substring(0, paramString1.length() - paramString2.length());
      }
    }
    return str;
  }
  
  public static String removeStart(String paramString1, String paramString2)
  {
    String str = paramString1;
    if (!isEmpty(paramString1))
    {
      if (isEmpty(paramString2)) {
        return paramString1;
      }
      str = paramString1;
      if (paramString1.startsWith(paramString2)) {
        str = paramString1.substring(paramString2.length());
      }
    }
    return str;
  }
  
  public static String removeStartIgnoreCase(String paramString1, String paramString2)
  {
    String str = paramString1;
    if (!isEmpty(paramString1))
    {
      if (isEmpty(paramString2)) {
        return paramString1;
      }
      str = paramString1;
      if (startsWithIgnoreCase(paramString1, paramString2)) {
        str = paramString1.substring(paramString2.length());
      }
    }
    return str;
  }
  
  public static String repeat(String paramString, int paramInt)
  {
    if (paramString == null) {
      return null;
    }
    if (paramInt <= 0) {
      return "";
    }
    int m = paramString.length();
    Object localObject = paramString;
    if (paramInt != 1)
    {
      if (m == 0) {
        return paramString;
      }
      int k = 0;
      if ((m == 1) && (paramInt <= 8192)) {
        return padding(paramInt, paramString.charAt(0));
      }
      int n = m * paramInt;
      if (m != 1)
      {
        if (m != 2)
        {
          localObject = new StrBuilder(n);
          while (k < paramInt)
          {
            ((StrBuilder)localObject).append(paramString);
            k += 1;
          }
          return ((StrBuilder)localObject).toString();
        }
        i = paramString.charAt(0);
        int j = paramString.charAt(1);
        paramString = new char[n];
        for (paramInt = paramInt * 2 - 2; paramInt >= 0; paramInt = paramInt - 1 - 1)
        {
          paramString[paramInt] = i;
          paramString[(paramInt + 1)] = j;
        }
        return new String(paramString);
      }
      int i = paramString.charAt(0);
      paramString = new char[n];
      paramInt -= 1;
      while (paramInt >= 0)
      {
        paramString[paramInt] = i;
        paramInt -= 1;
      }
      localObject = new String(paramString);
    }
    return localObject;
  }
  
  public static String repeat(String paramString1, String paramString2, int paramInt)
  {
    if ((paramString1 != null) && (paramString2 != null))
    {
      StringBuffer localStringBuffer = new StringBuffer();
      localStringBuffer.append(paramString1);
      localStringBuffer.append(paramString2);
      return removeEnd(repeat(localStringBuffer.toString(), paramInt), paramString2);
    }
    return repeat(paramString1, paramInt);
  }
  
  public static String replace(String paramString1, String paramString2, String paramString3)
  {
    return replace(paramString1, paramString2, paramString3, -1);
  }
  
  public static String replace(String paramString1, String paramString2, String paramString3, int paramInt)
  {
    Object localObject = paramString1;
    if (!isEmpty(paramString1))
    {
      localObject = paramString1;
      if (!isEmpty(paramString2))
      {
        localObject = paramString1;
        if (paramString3 != null)
        {
          if (paramInt == 0) {
            return paramString1;
          }
          int k = 0;
          int m = paramString1.indexOf(paramString2, 0);
          if (m == -1) {
            return paramString1;
          }
          int n = paramString2.length();
          int i = paramString3.length() - n;
          int j = i;
          if (i < 0) {
            j = 0;
          }
          i = 64;
          if (paramInt < 0) {
            i = 16;
          } else if (paramInt <= 64) {
            i = paramInt;
          }
          localObject = new StrBuilder(paramString1.length() + j * i);
          i = paramInt;
          j = m;
          paramInt = k;
          for (;;)
          {
            k = paramInt;
            if (j == -1) {
              break;
            }
            ((StrBuilder)localObject).append(paramString1.substring(paramInt, j)).append(paramString3);
            paramInt = j + n;
            i -= 1;
            if (i == 0)
            {
              k = paramInt;
              break;
            }
            j = paramString1.indexOf(paramString2, paramInt);
          }
          ((StrBuilder)localObject).append(paramString1.substring(k));
          localObject = ((StrBuilder)localObject).toString();
        }
      }
    }
    return localObject;
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
    String str = paramString1;
    if (!isEmpty(paramString1))
    {
      if (isEmpty(paramString2)) {
        return paramString1;
      }
      str = paramString3;
      if (paramString3 == null) {
        str = "";
      }
      int k = str.length();
      int m = paramString1.length();
      paramString3 = new StrBuilder(m);
      int i = 0;
      int j = 0;
      while (i < m)
      {
        char c = paramString1.charAt(i);
        int n = paramString2.indexOf(c);
        if (n >= 0)
        {
          if (n < k) {
            paramString3.append(str.charAt(n));
          }
          j = 1;
        }
        else
        {
          paramString3.append(c);
        }
        i += 1;
      }
      str = paramString1;
      if (j != 0) {
        str = paramString3.toString();
      }
    }
    return str;
  }
  
  public static String replaceEach(String paramString, String[] paramArrayOfString1, String[] paramArrayOfString2)
  {
    return replaceEach(paramString, paramArrayOfString1, paramArrayOfString2, false, 0);
  }
  
  private static String replaceEach(String paramString, String[] paramArrayOfString1, String[] paramArrayOfString2, boolean paramBoolean, int paramInt)
  {
    if ((paramString != null) && (paramString.length() != 0) && (paramArrayOfString1 != null) && (paramArrayOfString1.length != 0) && (paramArrayOfString2 != null))
    {
      if (paramArrayOfString2.length == 0) {
        return paramString;
      }
      if (paramInt >= 0)
      {
        int i3 = paramArrayOfString1.length;
        int i = paramArrayOfString2.length;
        if (i3 == i)
        {
          boolean[] arrayOfBoolean = new boolean[i3];
          int k = 0;
          i = -1;
          int n;
          int i1;
          for (int j = -1; k < i3; j = m)
          {
            n = i;
            m = j;
            if (arrayOfBoolean[k] == 0)
            {
              n = i;
              m = j;
              if (paramArrayOfString1[k] != null)
              {
                n = i;
                m = j;
                if (paramArrayOfString1[k].length() != 0) {
                  if (paramArrayOfString2[k] == null)
                  {
                    n = i;
                    m = j;
                  }
                  else
                  {
                    i1 = paramString.indexOf(paramArrayOfString1[k]);
                    if (i1 == -1)
                    {
                      arrayOfBoolean[k] = true;
                      n = i;
                      m = j;
                    }
                    else if (i != -1)
                    {
                      n = i;
                      m = j;
                      if (i1 >= i) {}
                    }
                    else
                    {
                      m = k;
                      n = i1;
                    }
                  }
                }
              }
            }
            k += 1;
            i = n;
          }
          if (i == -1) {
            return paramString;
          }
          k = 0;
          for (int m = 0; k < paramArrayOfString1.length; m = n)
          {
            n = m;
            if (paramArrayOfString1[k] != null) {
              if (paramArrayOfString2[k] == null)
              {
                n = m;
              }
              else
              {
                i1 = paramArrayOfString2[k].length() - paramArrayOfString1[k].length();
                n = m;
                if (i1 > 0) {
                  n = m + i1 * 3;
                }
              }
            }
            k += 1;
          }
          k = Math.min(m, paramString.length() / 5);
          StrBuilder localStrBuilder = new StrBuilder(paramString.length() + k);
          m = 0;
          k = j;
          j = i;
          for (i = m; j != -1; i = i1)
          {
            while (i < j)
            {
              localStrBuilder.append(paramString.charAt(i));
              i += 1;
            }
            localStrBuilder.append(paramArrayOfString2[k]);
            i1 = paramArrayOfString1[k].length() + j;
            j = 0;
            k = -1;
            for (i = -1; j < i3; i = m)
            {
              n = k;
              m = i;
              if (arrayOfBoolean[j] == 0)
              {
                n = k;
                m = i;
                if (paramArrayOfString1[j] != null)
                {
                  n = k;
                  m = i;
                  if (paramArrayOfString1[j].length() != 0) {
                    if (paramArrayOfString2[j] == null)
                    {
                      n = k;
                      m = i;
                    }
                    else
                    {
                      int i2 = paramString.indexOf(paramArrayOfString1[j], i1);
                      if (i2 == -1)
                      {
                        arrayOfBoolean[j] = true;
                        n = k;
                        m = i;
                      }
                      else if (k != -1)
                      {
                        n = k;
                        m = i;
                        if (i2 >= k) {}
                      }
                      else
                      {
                        m = j;
                        n = i2;
                      }
                    }
                  }
                }
              }
              j += 1;
              k = n;
            }
            j = k;
            k = i;
          }
          j = paramString.length();
          while (i < j)
          {
            localStrBuilder.append(paramString.charAt(i));
            i += 1;
          }
          paramString = localStrBuilder.toString();
          if (!paramBoolean) {
            return paramString;
          }
          return replaceEach(paramString, paramArrayOfString1, paramArrayOfString2, paramBoolean, paramInt - 1);
        }
        paramString = new StringBuffer();
        paramString.append("Search and Replace array lengths don't match: ");
        paramString.append(i3);
        paramString.append(" vs ");
        paramString.append(i);
        throw new IllegalArgumentException(paramString.toString());
      }
      paramArrayOfString1 = new StringBuffer();
      paramArrayOfString1.append("TimeToLive of ");
      paramArrayOfString1.append(paramInt);
      paramArrayOfString1.append(" is less than 0: ");
      paramArrayOfString1.append(paramString);
      throw new IllegalStateException(paramArrayOfString1.toString());
    }
    return paramString;
  }
  
  public static String replaceEachRepeatedly(String paramString, String[] paramArrayOfString1, String[] paramArrayOfString2)
  {
    int i;
    if (paramArrayOfString1 == null) {
      i = 0;
    } else {
      i = paramArrayOfString1.length;
    }
    return replaceEach(paramString, paramArrayOfString1, paramArrayOfString2, true, i);
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
    return new StrBuilder(paramString).reverse().toString();
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
  
  public static String reverseDelimitedString(String paramString1, String paramString2)
  {
    if (paramString1 == null) {
      return null;
    }
    paramString1 = split(paramString1, paramString2);
    ArrayUtils.reverse(paramString1);
    if (paramString2 == null) {
      return join(paramString1, ' ');
    }
    return join(paramString1, paramString2);
  }
  
  public static String right(String paramString, int paramInt)
  {
    if (paramString == null) {
      return null;
    }
    if (paramInt < 0) {
      return "";
    }
    if (paramString.length() <= paramInt) {
      return paramString;
    }
    return paramString.substring(paramString.length() - paramInt);
  }
  
  public static String rightPad(String paramString, int paramInt)
  {
    return rightPad(paramString, paramInt, ' ');
  }
  
  public static String rightPad(String paramString, int paramInt, char paramChar)
  {
    if (paramString == null) {
      return null;
    }
    int i = paramInt - paramString.length();
    if (i <= 0) {
      return paramString;
    }
    if (i > 8192) {
      return rightPad(paramString, paramInt, String.valueOf(paramChar));
    }
    return paramString.concat(padding(i, paramChar));
  }
  
  public static String rightPad(String paramString1, int paramInt, String paramString2)
  {
    if (paramString1 == null) {
      return null;
    }
    Object localObject = paramString2;
    if (isEmpty(paramString2)) {
      localObject = " ";
    }
    int j = ((String)localObject).length();
    int k = paramInt - paramString1.length();
    if (k <= 0) {
      return paramString1;
    }
    int i = 0;
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
    localObject = ((String)localObject).toCharArray();
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
    int j = 1;
    int k = 0;
    while (j < paramString.length)
    {
      int m = Character.getType(paramString[j]);
      if (m == i)
      {
        m = i;
      }
      else
      {
        if ((paramBoolean) && (m == 2) && (i == 1))
        {
          int n = j - 1;
          i = k;
          if (n != k)
          {
            localArrayList.add(new String(paramString, k, n - k));
            i = n;
          }
        }
        else
        {
          localArrayList.add(new String(paramString, k, j - k));
          i = j;
        }
        k = i;
      }
      j += 1;
      i = m;
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
    if (paramString1 == null) {
      return null;
    }
    int m = paramString1.length();
    if (m == 0) {
      return ArrayUtils.EMPTY_STRING_ARRAY;
    }
    if ((paramString2 != null) && (!"".equals(paramString2)))
    {
      int i2 = paramString2.length();
      ArrayList localArrayList = new ArrayList();
      int j = 0;
      int n = 0;
      int i = 0;
      while (j < m)
      {
        int i1 = paramString1.indexOf(paramString2, n);
        if (i1 > -1)
        {
          int k;
          if (i1 > n)
          {
            k = i + 1;
            if (k == paramInt)
            {
              localArrayList.add(paramString1.substring(n));
              i = k;
              break label223;
            }
            localArrayList.add(paramString1.substring(n, i1));
            j = i1;
          }
          else
          {
            j = i1;
            k = i;
            if (paramBoolean)
            {
              k = i + 1;
              if (k == paramInt)
              {
                localArrayList.add(paramString1.substring(n));
                j = m;
              }
              else
              {
                localArrayList.add("");
                j = i1;
              }
            }
          }
          n = j + i2;
          i = k;
        }
        else
        {
          localArrayList.add(paramString1.substring(n));
        }
        label223:
        j = m;
      }
      return (String[])localArrayList.toArray(new String[localArrayList.size()]);
    }
    return splitWorker(paramString1, null, paramInt, paramBoolean);
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
    int i = 0;
    int j = 0;
    int k = 0;
    int m = 0;
    while (i < n) {
      if (paramString.charAt(i) == paramChar)
      {
        if ((j != 0) || (paramBoolean))
        {
          localArrayList.add(paramString.substring(m, i));
          j = 0;
          k = 1;
        }
        m = i + 1;
        i = m;
      }
      else
      {
        i += 1;
        j = 1;
        k = 0;
      }
    }
    if ((j != 0) || ((paramBoolean) && (k != 0))) {
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
    int i;
    int j;
    int k;
    int n;
    int i1;
    int i2;
    int i3;
    int i4;
    if (paramString2 == null)
    {
      i = 0;
      j = 0;
      k = 0;
      n = 0;
      i1 = 1;
      while (i < m) {
        if (Character.isWhitespace(paramString1.charAt(i)))
        {
          if (j == 0)
          {
            i2 = i1;
            i3 = i;
            if (!paramBoolean) {}
          }
          else
          {
            if (i1 == paramInt)
            {
              j = m;
              i = 0;
            }
            else
            {
              k = 1;
              j = i;
              i = k;
            }
            localArrayList.add(paramString1.substring(n, j));
            i2 = i1 + 1;
            n = 0;
            i3 = j;
            k = i;
            j = n;
          }
          n = i3 + 1;
          i = n;
          i1 = i2;
        }
        else
        {
          i += 1;
          j = 1;
          k = 0;
        }
      }
      i1 = i;
      i2 = j;
      i3 = k;
      i4 = n;
    }
    else
    {
      if (paramString2.length() == 1)
      {
        int i6 = paramString2.charAt(0);
        i = 0;
        j = 0;
        k = 0;
        n = 0;
        i5 = 1;
        for (;;)
        {
          i1 = i;
          i2 = j;
          i3 = k;
          i4 = n;
          if (i >= m) {
            break;
          }
          if (paramString1.charAt(i) == i6)
          {
            if (j == 0)
            {
              i2 = i;
              i1 = i5;
              if (!paramBoolean) {}
            }
            else
            {
              if (i5 == paramInt)
              {
                i = m;
                j = 0;
              }
              else
              {
                j = 1;
              }
              localArrayList.add(paramString1.substring(n, i));
              i1 = i5 + 1;
              n = 0;
              k = j;
              j = n;
              i2 = i;
            }
            n = i2 + 1;
            i = n;
            i5 = i1;
          }
          else
          {
            i += 1;
            j = 1;
            k = 0;
          }
        }
      }
      i = 0;
      j = 0;
      k = 0;
      n = 0;
      int i5 = 1;
      for (;;)
      {
        i1 = i;
        i2 = j;
        i3 = k;
        i4 = n;
        if (i >= m) {
          break;
        }
        if (paramString2.indexOf(paramString1.charAt(i)) >= 0)
        {
          if (j == 0)
          {
            i2 = i;
            i1 = i5;
            if (!paramBoolean) {}
          }
          else
          {
            if (i5 == paramInt)
            {
              i = m;
              j = 0;
            }
            else
            {
              j = 1;
            }
            localArrayList.add(paramString1.substring(n, i));
            i1 = i5 + 1;
            n = 0;
            k = j;
            j = n;
            i2 = i;
          }
          n = i2 + 1;
          i = n;
          i5 = i1;
        }
        else
        {
          i += 1;
          j = 1;
          k = 0;
        }
      }
    }
    if ((i2 != 0) || ((paramBoolean) && (i3 != 0))) {
      localArrayList.add(paramString1.substring(i4, i1));
    }
    return (String[])localArrayList.toArray(new String[localArrayList.size()]);
  }
  
  public static boolean startsWith(String paramString1, String paramString2)
  {
    return startsWith(paramString1, paramString2, false);
  }
  
  private static boolean startsWith(String paramString1, String paramString2, boolean paramBoolean)
  {
    boolean bool = false;
    if ((paramString1 != null) && (paramString2 != null))
    {
      if (paramString2.length() > paramString1.length()) {
        return false;
      }
      return paramString1.regionMatches(paramBoolean, 0, paramString2, 0, paramString2.length());
    }
    paramBoolean = bool;
    if (paramString1 == null)
    {
      paramBoolean = bool;
      if (paramString2 == null) {
        paramBoolean = true;
      }
    }
    return paramBoolean;
  }
  
  public static boolean startsWithAny(String paramString, String[] paramArrayOfString)
  {
    if (!isEmpty(paramString))
    {
      if (ArrayUtils.isEmpty(paramArrayOfString)) {
        return false;
      }
      int i = 0;
      while (i < paramArrayOfString.length)
      {
        if (startsWith(paramString, paramArrayOfString[i])) {
          return true;
        }
        i += 1;
      }
    }
    return false;
  }
  
  public static boolean startsWithIgnoreCase(String paramString1, String paramString2)
  {
    return startsWith(paramString1, paramString2, true);
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
  
  public static String[] stripAll(String[] paramArrayOfString)
  {
    return stripAll(paramArrayOfString, null);
  }
  
  public static String[] stripAll(String[] paramArrayOfString, String paramString)
  {
    if (paramArrayOfString != null)
    {
      int j = paramArrayOfString.length;
      if (j == 0) {
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
    return paramArrayOfString;
  }
  
  public static String stripEnd(String paramString1, String paramString2)
  {
    String str = paramString1;
    if (paramString1 != null)
    {
      int i = paramString1.length();
      if (i == 0) {
        return paramString1;
      }
      int j;
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
      if (paramString2.length() == 0) {
        return paramString1;
      }
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
      str = paramString1.substring(0, j);
    }
    return str;
  }
  
  public static String stripStart(String paramString1, String paramString2)
  {
    String str = paramString1;
    if (paramString1 != null)
    {
      int k = paramString1.length();
      if (k == 0) {
        return paramString1;
      }
      int j = 0;
      int i = 0;
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
      i = j;
      if (paramString2.length() == 0) {
        return paramString1;
      }
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
      str = paramString1.substring(j);
    }
    return str;
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
    if (paramString == null) {
      return null;
    }
    String str = strip(paramString, null);
    paramString = str;
    if (str.length() == 0) {
      paramString = null;
    }
    return paramString;
  }
  
  public static String substring(String paramString, int paramInt)
  {
    if (paramString == null) {
      return null;
    }
    int i = paramInt;
    if (paramInt < 0) {
      i = paramInt + paramString.length();
    }
    paramInt = i;
    if (i < 0) {
      paramInt = 0;
    }
    if (paramInt > paramString.length()) {
      return "";
    }
    return paramString.substring(paramInt);
  }
  
  public static String substring(String paramString, int paramInt1, int paramInt2)
  {
    if (paramString == null) {
      return null;
    }
    int i = paramInt2;
    if (paramInt2 < 0) {
      i = paramInt2 + paramString.length();
    }
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
    paramInt2 = paramInt1;
    if (paramInt1 < 0) {
      paramInt2 = 0;
    }
    return paramString.substring(i, paramInt2);
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
    if (i != -1)
    {
      if (i == paramString1.length() - paramString2.length()) {
        return "";
      }
      return paramString1.substring(i + paramString2.length());
    }
    return "";
  }
  
  public static String substringBefore(String paramString1, String paramString2)
  {
    String str = paramString1;
    if (!isEmpty(paramString1))
    {
      if (paramString2 == null) {
        return paramString1;
      }
      if (paramString2.length() == 0) {
        return "";
      }
      int i = paramString1.indexOf(paramString2);
      if (i == -1) {
        return paramString1;
      }
      str = paramString1.substring(0, i);
    }
    return str;
  }
  
  public static String substringBeforeLast(String paramString1, String paramString2)
  {
    String str = paramString1;
    if (!isEmpty(paramString1))
    {
      if (isEmpty(paramString2)) {
        return paramString1;
      }
      int i = paramString1.lastIndexOf(paramString2);
      if (i == -1) {
        return paramString1;
      }
      str = paramString1.substring(0, i);
    }
    return str;
  }
  
  public static String substringBetween(String paramString1, String paramString2)
  {
    return substringBetween(paramString1, paramString2, paramString2);
  }
  
  public static String substringBetween(String paramString1, String paramString2, String paramString3)
  {
    if ((paramString1 != null) && (paramString2 != null))
    {
      if (paramString3 == null) {
        return null;
      }
      int i = paramString1.indexOf(paramString2);
      if (i != -1)
      {
        int j = paramString1.indexOf(paramString3, paramString2.length() + i);
        if (j != -1) {
          return paramString1.substring(i + paramString2.length(), j);
        }
      }
    }
    return null;
  }
  
  public static String[] substringsBetween(String paramString1, String paramString2, String paramString3)
  {
    if ((paramString1 != null) && (!isEmpty(paramString2)))
    {
      if (isEmpty(paramString3)) {
        return null;
      }
      int j = paramString1.length();
      if (j == 0) {
        return ArrayUtils.EMPTY_STRING_ARRAY;
      }
      int k = paramString3.length();
      int m = paramString2.length();
      ArrayList localArrayList = new ArrayList();
      int n;
      for (int i = 0; i < j - k; i = n + k)
      {
        i = paramString1.indexOf(paramString2, i);
        if (i < 0) {
          break;
        }
        i += m;
        n = paramString1.indexOf(paramString3, i);
        if (n < 0) {
          break;
        }
        localArrayList.add(paramString1.substring(i, n));
      }
      if (localArrayList.isEmpty()) {
        return null;
      }
      return (String[])localArrayList.toArray(new String[localArrayList.size()]);
    }
    return null;
  }
  
  public static String swapCase(String paramString)
  {
    Object localObject = paramString;
    if (paramString != null)
    {
      int j = paramString.length();
      if (j == 0) {
        return paramString;
      }
      localObject = new StrBuilder(j);
      int i = 0;
      while (i < j)
      {
        char c2 = paramString.charAt(i);
        char c1;
        if (Character.isUpperCase(c2))
        {
          c1 = Character.toLowerCase(c2);
        }
        else if (Character.isTitleCase(c2))
        {
          c1 = Character.toLowerCase(c2);
        }
        else
        {
          c1 = c2;
          if (Character.isLowerCase(c2)) {
            c1 = Character.toUpperCase(c2);
          }
        }
        ((StrBuilder)localObject).append(c1);
        i += 1;
      }
      localObject = ((StrBuilder)localObject).toString();
    }
    return localObject;
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
  
  public static String uncapitalise(String paramString)
  {
    return uncapitalize(paramString);
  }
  
  public static String uncapitalize(String paramString)
  {
    String str = paramString;
    if (paramString != null)
    {
      int i = paramString.length();
      if (i == 0) {
        return paramString;
      }
      str = new StrBuilder(i).append(Character.toLowerCase(paramString.charAt(0))).append(paramString.substring(1)).toString();
    }
    return str;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     org.apache.commons.lang.StringUtils
 * JD-Core Version:    0.7.0.1
 */