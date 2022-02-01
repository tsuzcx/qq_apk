package com.tencent.mobileqq.utils;

import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;

public class StringUtil
{
  public static int a(String paramString)
  {
    int j = 0;
    if (paramString == null) {
      return 0;
    }
    int i = 0;
    while (j < paramString.length())
    {
      int k = paramString.charAt(j);
      if ((k >= 0) && (k <= 255)) {
        i += 1;
      } else {
        i += 2;
      }
      j += 1;
    }
    return i;
  }
  
  public static long a(String paramString1, String paramString2)
  {
    try
    {
      long l = Long.parseLong(paramString2);
      return l;
    }
    catch (Exception localException)
    {
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("stringToLong Exception, value[");
        localStringBuilder.append(paramString2);
        localStringBuilder.append("]");
        QLog.w(paramString1, 1, localStringBuilder.toString(), localException);
      }
    }
    return 0L;
  }
  
  public static String a(String paramString)
  {
    String str = "";
    if (paramString == null) {
      return "";
    }
    int i1 = 0;
    int i = 0;
    int k = 1;
    int m;
    int n;
    for (int j = 0;; j = n)
    {
      m = i1;
      if (i >= paramString.length()) {
        break;
      }
      if (k != 0)
      {
        m = k;
        n = j;
        if (a(paramString.charAt(i)))
        {
          n = i;
          m = 0;
        }
      }
      else
      {
        m = k;
        n = j;
        if (a(paramString.charAt(i))) {
          if (paramString.length() - 1 != i)
          {
            m = k;
            n = j;
            if (a(paramString.charAt(i + 1))) {}
          }
          else
          {
            m = i;
            break;
          }
        }
      }
      i += 1;
      k = m;
    }
    i = m + 1;
    if (j < i)
    {
      if (i >= paramString.length()) {
        i = paramString.length();
      }
      str = paramString.substring(j, i);
    }
    return str;
  }
  
  public static String a(String paramString, int paramInt)
  {
    if (TextUtils.isEmpty(paramString)) {
      return "";
    }
    int i = 0;
    float f = 0.0F;
    while (i < paramString.length())
    {
      double d2 = f;
      double d1;
      if (c(paramString.charAt(i))) {
        d1 = 2.0D;
      } else {
        d1 = 1.5D;
      }
      Double.isNaN(d2);
      f = (float)(d2 + d1);
      if (f > paramInt)
      {
        paramInt = 1;
        break label90;
      }
      i += 1;
    }
    paramInt = 0;
    label90:
    Object localObject = paramString;
    if (paramInt != 0)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(paramString.substring(0, i));
      ((StringBuilder)localObject).append("…");
      localObject = ((StringBuilder)localObject).toString();
    }
    return localObject;
  }
  
  public static String a(String paramString, int paramInt1, int paramInt2)
  {
    if (paramString == null) {
      return null;
    }
    int j = 0;
    StringBuffer localStringBuffer = new StringBuffer(paramInt2);
    int i = paramInt1;
    paramInt1 = j;
    while (i < paramString.length())
    {
      char c = paramString.charAt(i);
      if ((c >= 0) && (c <= 'ÿ')) {
        paramInt1 += 1;
      } else {
        paramInt1 += 2;
      }
      if (paramInt1 > paramInt2) {
        break;
      }
      localStringBuffer.append(c);
      i += 1;
    }
    return localStringBuffer.toString();
  }
  
  public static String a(String paramString1, int paramInt1, int paramInt2, String paramString2)
  {
    if (paramString1 == null) {
      return null;
    }
    int j = 0;
    StringBuffer localStringBuffer = new StringBuffer();
    int i = paramInt1;
    paramInt1 = j;
    while (i < paramString1.length())
    {
      char c = paramString1.charAt(i);
      if ((c >= 0) && (c <= 'ÿ')) {
        paramInt1 += 1;
      } else {
        paramInt1 += 2;
      }
      if (paramInt1 > paramInt2)
      {
        localStringBuffer.append(paramString2);
        break;
      }
      localStringBuffer.append(c);
      i += 1;
    }
    return localStringBuffer.toString();
  }
  
  public static String a(String paramString1, String paramString2, String paramString3)
  {
    if ((paramString1 != null) && (paramString2 != null))
    {
      if (paramString3 == null) {
        return null;
      }
      int i = paramString1.indexOf(paramString2);
      if (i < 0) {
        return null;
      }
      int j = paramString1.indexOf(paramString3, paramString2.length() + i);
      if (j < 0) {
        return null;
      }
      return paramString1.substring(i + paramString2.length(), j);
    }
    return null;
  }
  
  public static String a(List<? extends Object> paramList, String paramString)
  {
    if ((paramList != null) && (paramList.size() != 0))
    {
      StringBuffer localStringBuffer = new StringBuffer();
      int i = 0;
      while (i < paramList.size())
      {
        localStringBuffer.append(paramList.get(i).toString());
        localStringBuffer.append(paramString);
        i += 1;
      }
      localStringBuffer.delete(localStringBuffer.lastIndexOf(paramString), localStringBuffer.length());
      return localStringBuffer.toString();
    }
    return "";
  }
  
  public static String a(Object... paramVarArgs)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("[");
    int j = paramVarArgs.length;
    int i = 0;
    while (i < j)
    {
      Object localObject = paramVarArgs[i];
      if (localObject != null) {
        localObject = localObject.toString();
      } else {
        localObject = null;
      }
      localStringBuilder.append((String)localObject);
      localStringBuilder.append(" , ");
      i += 1;
    }
    localStringBuilder.append("]");
    return localStringBuilder.toString();
  }
  
  public static boolean a(char paramChar)
  {
    return (!Character.isISOControl(paramChar)) || (Character.isLetterOrDigit(paramChar)) || (Character.isSpace(paramChar)) || (Character.isSpaceChar(paramChar));
  }
  
  public static boolean a(String paramString)
  {
    return (paramString == null) || (paramString.length() == 0);
  }
  
  public static String[] a(String paramString, char paramChar)
  {
    if (paramString == null) {
      return null;
    }
    int m = paramString.length();
    if (m == 0) {
      return new String[] { paramString };
    }
    ArrayList localArrayList = new ArrayList(50);
    char[] arrayOfChar = paramString.toCharArray();
    int i = 0;
    int j = 0;
    int k = 0;
    while (i < m) {
      if (arrayOfChar[i] == paramChar)
      {
        localArrayList.add(paramString.substring(k, i));
        k = i + 1;
        i = k;
        j = 1;
      }
      else
      {
        i += 1;
        j = 0;
      }
    }
    if (j == 0) {
      localArrayList.add(paramString.substring(k, i));
    }
    return (String[])localArrayList.toArray(new String[localArrayList.size()]);
  }
  
  public static String b(String paramString)
  {
    if (paramString != null)
    {
      if ("".equals(paramString)) {
        return "";
      }
      StringBuffer localStringBuffer = new StringBuffer();
      paramString = paramString.getBytes();
      int i = 0;
      while (i < paramString.length)
      {
        localStringBuffer.append(Integer.toHexString(new Integer(paramString[i] & 0xFF).intValue()));
        localStringBuffer.append(" ");
        i += 1;
      }
      return localStringBuffer.toString();
    }
    return "";
  }
  
  public static boolean b(char paramChar)
  {
    return ((paramChar >= 'A') && (paramChar <= 'Z')) || ((paramChar >= 'a') && (paramChar <= 'z'));
  }
  
  public static boolean b(String paramString)
  {
    boolean bool = false;
    try
    {
      long l = Long.valueOf(Long.parseLong(paramString)).longValue();
      if (l > 10000L) {
        bool = true;
      }
      return bool;
    }
    catch (Exception paramString) {}
    return false;
  }
  
  public static String c(String paramString)
  {
    paramString = paramString.toCharArray();
    int i = 0;
    while (i < paramString.length)
    {
      if (paramString[i] == '　') {
        paramString[i] = 32;
      } else if ((paramString[i] > 65280) && (paramString[i] < 65375)) {
        paramString[i] = ((char)(paramString[i] - 65248));
      }
      i += 1;
    }
    return String.valueOf(paramString);
  }
  
  public static boolean c(char paramChar)
  {
    Character.UnicodeBlock localUnicodeBlock = Character.UnicodeBlock.of(paramChar);
    return (localUnicodeBlock == Character.UnicodeBlock.CJK_UNIFIED_IDEOGRAPHS) || (localUnicodeBlock == Character.UnicodeBlock.CJK_COMPATIBILITY_IDEOGRAPHS) || (localUnicodeBlock == Character.UnicodeBlock.CJK_UNIFIED_IDEOGRAPHS_EXTENSION_A) || (localUnicodeBlock == Character.UnicodeBlock.GENERAL_PUNCTUATION) || (localUnicodeBlock == Character.UnicodeBlock.CJK_SYMBOLS_AND_PUNCTUATION) || (localUnicodeBlock == Character.UnicodeBlock.HALFWIDTH_AND_FULLWIDTH_FORMS);
  }
  
  public static boolean c(String paramString)
  {
    boolean bool = false;
    if (paramString != null)
    {
      if ("".equals(paramString.trim())) {
        return false;
      }
      paramString = paramString.trim();
      int j = paramString.length();
      if (j < 5) {
        return false;
      }
      int i = 0;
      while (i < j)
      {
        if (!Character.isDigit(paramString.charAt(i))) {
          return false;
        }
        i += 1;
      }
      bool = true;
    }
    return bool;
  }
  
  public static String d(String paramString)
  {
    String str = paramString;
    if (paramString != null)
    {
      if ("".equals(paramString)) {
        return paramString;
      }
      paramString = new StringBuffer(paramString);
      while ((paramString.length() > 0) && ((Character.isWhitespace(paramString.charAt(0))) || (paramString.charAt(0) == 0))) {
        paramString.deleteCharAt(0);
      }
      for (int i = paramString.length(); i > 0; i = paramString.length())
      {
        i -= 1;
        if ((!Character.isWhitespace(paramString.charAt(i))) && (paramString.charAt(0) != 0)) {
          break;
        }
        paramString.deleteCharAt(i);
      }
      str = paramString.toString();
    }
    return str;
  }
  
  public static boolean d(String paramString)
  {
    return (paramString != null) && (!"".equals(paramString.trim())) && (paramString.trim().startsWith("+"));
  }
  
  public static String e(String paramString)
  {
    String str = paramString;
    if (!TextUtils.isEmpty(paramString))
    {
      if (paramString.length() <= 4) {
        return paramString;
      }
      str = a(paramString, paramString.length() - 4, paramString.length());
    }
    return str;
  }
  
  public static String f(String paramString)
  {
    paramString = paramString.toCharArray();
    int i = 0;
    while (i < paramString.length)
    {
      if (paramString[i] == '　') {
        paramString[i] = 32;
      } else if ((paramString[i] > 65280) && (paramString[i] < 65375)) {
        paramString[i] = ((char)(paramString[i] - 65248));
      }
      i += 1;
    }
    return new String(paramString);
  }
  
  public static String g(String paramString)
  {
    String str = paramString;
    if (paramString != null)
    {
      if (paramString.length() < 2) {
        return paramString;
      }
      int j = paramString.length() - 1;
      int i = j;
      if (j == 1) {
        i = 2;
      }
      paramString = new StringBuffer(paramString);
      paramString.replace(1, i, "*");
      str = paramString.toString();
    }
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.utils.StringUtil
 * JD-Core Version:    0.7.0.1
 */