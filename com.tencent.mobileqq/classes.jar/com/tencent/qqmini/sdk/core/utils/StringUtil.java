package com.tencent.qqmini.sdk.core.utils;

import android.text.TextUtils;
import com.tencent.qqmini.sdk.annotation.MiniKeep;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.json.JSONObject;

@MiniKeep
public class StringUtil
{
  private static final String ELIPSE_CHARACTOR = "…";
  public static final int ERR_ACC_INVALID = 4;
  public static final int ERR_UIN_EMPTY = 3;
  public static final int ERR_UIN_INVALID_EMAIL = 2;
  public static final int ERR_UIN_TOO_LONG = 1;
  public static final int ERR_UIN_TOO_SHORT = 0;
  public static final int RES_VALID_UIN = -1;
  
  public static String byte2HexString(byte[] paramArrayOfByte)
  {
    StringBuffer localStringBuffer = new StringBuffer();
    int i = 0;
    while (i < paramArrayOfByte.length)
    {
      if (Integer.toHexString(paramArrayOfByte[i] & 0xFF).length() == 1)
      {
        localStringBuffer.append("0");
        localStringBuffer.append(Integer.toHexString(paramArrayOfByte[i] & 0xFF));
      }
      else
      {
        localStringBuffer.append(Integer.toHexString(paramArrayOfByte[i] & 0xFF));
      }
      i += 1;
    }
    return localStringBuffer.toString();
  }
  
  public static String crypticCenter(String paramString)
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
  
  public static String formatSize(long paramLong)
  {
    Object localObject2 = new StringBuilder();
    Object localObject1 = "";
    ((StringBuilder)localObject2).append("");
    ((StringBuilder)localObject2).append(paramLong);
    localObject2 = ((StringBuilder)localObject2).toString();
    if ((paramLong >= 0L) && (paramLong < 1024L))
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append((String)localObject2);
      ((StringBuilder)localObject1).append("B");
      return ((StringBuilder)localObject1).toString();
    }
    if ((paramLong >= 1024L) && (paramLong < 1048576L))
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append(Long.toString(paramLong / 1024L));
      ((StringBuilder)localObject1).append("KB");
      return ((StringBuilder)localObject1).toString();
    }
    if ((paramLong >= 1048576L) && (paramLong < 1073741824L))
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append(Long.toString(paramLong / 1048576L));
      ((StringBuilder)localObject1).append("MB");
      return ((StringBuilder)localObject1).toString();
    }
    if (paramLong >= 1073741824L)
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append(Long.toString(paramLong / 1073741824L));
      ((StringBuilder)localObject1).append("GB");
      localObject1 = ((StringBuilder)localObject1).toString();
    }
    return localObject1;
  }
  
  public static String getElipseStringWide(String paramString, int paramInt)
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
      if (isChinese(paramString.charAt(i))) {
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
  
  public static String getIPFromUrl(String paramString)
  {
    String str = "";
    if (paramString == null) {
      return "";
    }
    Matcher localMatcher = Pattern.compile("\\b(25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\\.(25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\\.(25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\\.(25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\\b").matcher(paramString);
    if (localMatcher.find()) {
      return localMatcher.group();
    }
    localMatcher = Pattern.compile("(?<=http://)[\\w\\.]+[^/]", 2).matcher(paramString);
    paramString = str;
    if (localMatcher.find()) {
      paramString = localMatcher.group();
    }
    return paramString;
  }
  
  public static String getSimpleUinForPrint(String paramString)
  {
    String str = paramString;
    if (!TextUtils.isEmpty(paramString))
    {
      if (paramString.length() <= 4) {
        return paramString;
      }
      str = substring(paramString, paramString.length() - 4, paramString.length());
    }
    return str;
  }
  
  public static int getWordCount(String paramString)
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
  
  public static int getWordCountNeo(String paramString)
  {
    int j = 0;
    if (paramString == null) {
      return 0;
    }
    int k = paramString.length();
    int i = 0;
    while (j < k)
    {
      int m = paramString.codePointAt(j);
      if ((m >= 0) && (m <= 255)) {
        i += 1;
      } else {
        i += 2;
      }
      j += Character.charCount(m);
    }
    return i;
  }
  
  public static byte[] hexStr2Bytes(String paramString)
  {
    paramString = paramString.toCharArray();
    int m = paramString.length / 2;
    byte[] arrayOfByte = new byte[m];
    int i = 0;
    while (i < m)
    {
      int j = i * 2;
      int k = Character.digit(paramString[j], 16);
      k = Character.digit(paramString[(j + 1)], 16) | k << 4;
      j = k;
      if (k > 127) {
        j = k - 256;
      }
      arrayOfByte[i] = ((byte)j);
      i += 1;
    }
    return arrayOfByte;
  }
  
  public static int hexToInt(String paramString, int paramInt1, int paramInt2)
  {
    long l = 0L;
    while (paramInt1 < paramInt2)
    {
      int i = paramInt1 + 1;
      l = l * 16L + Integer.parseInt(paramString.substring(paramInt1, i), 16);
      paramInt1 = i;
    }
    return (int)l;
  }
  
  public static boolean isAlphaDigit(char paramChar)
  {
    return (Character.isDigit(paramChar)) || ((paramChar >= 'A') && (paramChar <= 'Z')) || ((paramChar >= 'a') && (paramChar <= 'z'));
  }
  
  public static boolean isAsciiAlpha(char paramChar)
  {
    return ((paramChar >= 'A') && (paramChar <= 'Z')) || ((paramChar >= 'a') && (paramChar <= 'z'));
  }
  
  public static boolean isChinese(char paramChar)
  {
    Character.UnicodeBlock localUnicodeBlock = Character.UnicodeBlock.of(paramChar);
    return (localUnicodeBlock == Character.UnicodeBlock.CJK_UNIFIED_IDEOGRAPHS) || (localUnicodeBlock == Character.UnicodeBlock.CJK_COMPATIBILITY_IDEOGRAPHS) || (localUnicodeBlock == Character.UnicodeBlock.CJK_UNIFIED_IDEOGRAPHS_EXTENSION_A) || (localUnicodeBlock == Character.UnicodeBlock.GENERAL_PUNCTUATION) || (localUnicodeBlock == Character.UnicodeBlock.CJK_SYMBOLS_AND_PUNCTUATION) || (localUnicodeBlock == Character.UnicodeBlock.HALFWIDTH_AND_FULLWIDTH_FORMS);
  }
  
  public static boolean isEmpty(String paramString)
  {
    return (paramString == null) || (paramString.length() == 0);
  }
  
  public static boolean isNoneOutOfDateMobileNum(String paramString)
  {
    boolean bool = false;
    if (paramString != null)
    {
      if ("".equals(paramString.trim())) {
        return false;
      }
      if (paramString.trim().equals("0")) {
        return false;
      }
      bool = true;
    }
    return bool;
  }
  
  public static boolean isReadableChar(char paramChar)
  {
    return (!Character.isISOControl(paramChar)) || (Character.isLetterOrDigit(paramChar)) || (Character.isSpace(paramChar)) || (Character.isSpaceChar(paramChar));
  }
  
  public static boolean isValidEmail(String paramString)
  {
    return Pattern.compile("^[\\w\\-]([\\.\\w])+[\\w]+@([\\w\\-]+\\.)+[A-Z]{2,4}$", 2).matcher(paramString).matches();
  }
  
  public static boolean isValidMobileNumForHead(String paramString)
  {
    return (paramString != null) && (!"".equals(paramString.trim())) && (paramString.trim().startsWith("+"));
  }
  
  public static boolean isValideUin(String paramString)
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
  
  public static HashMap<String, String> json2map(JSONObject paramJSONObject)
  {
    HashMap localHashMap = new HashMap();
    if (paramJSONObject == null) {
      return localHashMap;
    }
    try
    {
      Iterator localIterator = paramJSONObject.keys();
      while (localIterator.hasNext())
      {
        String str = (String)localIterator.next();
        localHashMap.put(str, paramJSONObject.getString(str));
      }
      return localHashMap;
    }
    catch (Exception paramJSONObject) {}
    return localHashMap;
  }
  
  public static String listToString(List<? extends Object> paramList, String paramString)
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
  
  public static String longToString(long paramLong)
  {
    BigInteger localBigInteger2 = BigInteger.valueOf(paramLong);
    BigInteger localBigInteger1 = localBigInteger2;
    if (localBigInteger2.signum() < 0) {
      localBigInteger1 = localBigInteger2.add(BigInteger.ONE.shiftLeft(64));
    }
    return localBigInteger1.toString();
  }
  
  public static String makeLogMsg(Object... paramVarArgs)
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
  
  public static String[] split(String paramString, char paramChar)
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
  
  public static String stringFilter(String paramString)
  {
    paramString = paramString.replaceAll("【", "[").replaceAll("】", "]").replaceAll("！", "!").replaceAll("：", ":");
    return Pattern.compile("[『』]").matcher(paramString).replaceAll("").trim();
  }
  
  public static long stringToLong(String paramString1, String paramString2)
  {
    try
    {
      long l = Long.parseLong(paramString2);
      return l;
    }
    catch (Exception paramString1)
    {
      label7:
      break label7;
    }
    return 0L;
  }
  
  public static String substring(String paramString, int paramInt1, int paramInt2)
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
  
  public static String substring(String paramString1, int paramInt1, int paramInt2, String paramString2)
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
  
  public static String substring(String paramString1, String paramString2, String paramString3)
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
  
  public static String substringNeo(String paramString, int paramInt1, int paramInt2)
  {
    if (paramString == null) {
      return null;
    }
    StringBuffer localStringBuffer = new StringBuffer(paramInt2);
    while (paramInt1 < paramString.length())
    {
      char c = paramString.charAt(paramInt1);
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(localStringBuffer.toString());
      localStringBuilder.append(c);
      if (getWordCountNeo(localStringBuilder.toString()) > paramInt2) {
        break;
      }
      localStringBuffer.append(c);
      paramInt1 += 1;
    }
    return localStringBuffer.toString();
  }
  
  public static String to8BitAsciiString(byte[] paramArrayOfByte)
  {
    StringBuilder localStringBuilder = new StringBuilder(paramArrayOfByte.length);
    int j = paramArrayOfByte.length;
    int i = 0;
    while (i < j)
    {
      localStringBuilder.appendCodePoint(paramArrayOfByte[i] & 0xFF);
      i += 1;
    }
    return localStringBuilder.toString();
  }
  
  public static String toDBC(String paramString)
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
  
  public static String toHexString(String paramString)
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
  
  public static String toNoSpaceHexString(String paramString)
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
        i += 1;
      }
      return localStringBuffer.toString();
    }
    return "";
  }
  
  public static String toSemiAngleString(String paramString)
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
  
  public static String trim(String paramString)
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
  
  public static String trimUnreadableInFriendRequest(String paramString)
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
        if (isReadableChar(paramString.charAt(i)))
        {
          n = i;
          m = 0;
        }
      }
      else
      {
        m = k;
        n = j;
        if (isReadableChar(paramString.charAt(i))) {
          if (paramString.length() - 1 != i)
          {
            m = k;
            n = j;
            if (isReadableChar(paramString.charAt(i + 1))) {}
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
  
  public static int validateAccount(String paramString)
  {
    if ((paramString != null) && (!"".equals(paramString.trim())))
    {
      paramString = paramString.trim();
      int k = paramString.length();
      int i = 0;
      int j = 1;
      while (i < k)
      {
        if (!Character.isDigit(paramString.charAt(i))) {
          j = 0;
        }
        i += 1;
      }
      if (j != 0)
      {
        if (k < 5) {
          return 0;
        }
        if (k > 15) {
          return 1;
        }
      }
      else
      {
        if (!paramString.contains("@")) {
          break label98;
        }
        if (!isValidEmail(paramString)) {
          break label96;
        }
      }
      return -1;
      label96:
      return 2;
      label98:
      return 4;
    }
    return 3;
  }
  
  public static boolean verifyUin(String paramString)
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
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.qqmini.sdk.core.utils.StringUtil
 * JD-Core Version:    0.7.0.1
 */