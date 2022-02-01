package com.tencent.rmonitor.common.util;

import com.tencent.rmonitor.common.logger.Logger;
import java.nio.charset.Charset;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/rmonitor/common/util/StringUtil;", "", "()V", "TAG", "", "digits", "", "bytes2HexStr", "bytes", "", "getMD5", "source", "isNullOrNil", "", "str", "nullAsNil", "parseHex", "", "valueStr", "replaceBlank", "rmonitor-base_release"}, k=1, mv={1, 1, 15})
public final class StringUtil
{
  public static final StringUtil a = new StringUtil();
  private static final char[] b = { 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 97, 98, 99, 100, 101, 102 };
  
  @JvmStatic
  @NotNull
  public static final String a(@Nullable String paramString)
  {
    String str = "";
    if (paramString != null)
    {
      str = Pattern.compile("[\t\r\n]").matcher((CharSequence)paramString).replaceAll("");
      Intrinsics.checkExpressionValueIsNotNull(str, "m.replaceAll(\"\")");
    }
    return str;
  }
  
  @JvmStatic
  @NotNull
  public static final String a(@Nullable byte[] paramArrayOfByte)
  {
    if (paramArrayOfByte != null)
    {
      int i = paramArrayOfByte.length;
      int j = 0;
      if (i == 0) {
        i = 1;
      } else {
        i = 0;
      }
      if (i == 0)
      {
        char[] arrayOfChar1 = new char[paramArrayOfByte.length * 2];
        int k = paramArrayOfByte.length;
        i = j;
        while (i < k)
        {
          j = paramArrayOfByte[i];
          int m = i * 2;
          char[] arrayOfChar2 = b;
          arrayOfChar1[(m + 1)] = arrayOfChar2[(j & 0xF)];
          arrayOfChar1[m] = arrayOfChar2[((byte)(j >>> 4) & 0xF)];
          i += 1;
        }
        return new String(arrayOfChar1);
      }
    }
    return "";
  }
  
  @JvmStatic
  @NotNull
  public static final String b(@Nullable String paramString)
  {
    if (paramString != null) {
      try
      {
        MessageDigest localMessageDigest = MessageDigest.getInstance("MD5");
        Charset localCharset = Charsets.UTF_8;
        if (paramString != null)
        {
          paramString = paramString.getBytes(localCharset);
          Intrinsics.checkExpressionValueIsNotNull(paramString, "(this as java.lang.String).getBytes(charset)");
          localMessageDigest.update(paramString);
          return a(localMessageDigest.digest());
        }
        throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
      }
      catch (NoSuchAlgorithmException paramString)
      {
        Logger.b.a("RMonitor_common_StringUtil", (Throwable)paramString);
      }
    }
    return "";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.rmonitor.common.util.StringUtil
 * JD-Core Version:    0.7.0.1
 */