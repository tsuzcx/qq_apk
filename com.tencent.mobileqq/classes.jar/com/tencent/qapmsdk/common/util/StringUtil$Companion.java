package com.tencent.qapmsdk.common.util;

import com.tencent.qapmsdk.common.logger.Logger;
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

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/qapmsdk/common/util/StringUtil$Companion;", "", "()V", "TAG", "", "digits", "", "bytes2HexStr", "bytes", "", "getMD5", "source", "isNullOrNil", "", "str", "nullAsNil", "parseHex", "", "valueStr", "replaceBlank", "common_release"}, k=1, mv={1, 1, 15})
public final class StringUtil$Companion
{
  @JvmStatic
  @NotNull
  public final String bytes2HexStr(@Nullable byte[] paramArrayOfByte)
  {
    int j = 0;
    if (paramArrayOfByte != null) {
      if (paramArrayOfByte.length != 0) {
        break label20;
      }
    }
    label20:
    for (int i = 1; i != 0; i = 0) {
      return "";
    }
    char[] arrayOfChar = new char[paramArrayOfByte.length * 2];
    int k = paramArrayOfByte.length;
    i = j;
    while (i < k)
    {
      j = paramArrayOfByte[i];
      arrayOfChar[(i * 2 + 1)] = StringUtil.access$getDigits$cp()[(j & 0xF)];
      j = (byte)(j >>> 4);
      arrayOfChar[(i * 2)] = StringUtil.access$getDigits$cp()[(j & 0xF)];
      i += 1;
    }
    return new String(arrayOfChar);
  }
  
  @JvmStatic
  @NotNull
  public final String getMD5(@Nullable String paramString)
  {
    if (paramString != null)
    {
      MessageDigest localMessageDigest;
      Charset localCharset;
      try
      {
        localMessageDigest = MessageDigest.getInstance("MD5");
        localCharset = Charsets.UTF_8;
        if (paramString == null) {
          throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
        }
      }
      catch (NoSuchAlgorithmException paramString)
      {
        Logger.INSTANCE.exception("QAPM_common_StringUtil", (Throwable)paramString);
        paramString = "";
      }
      for (;;)
      {
        return paramString;
        paramString = paramString.getBytes(localCharset);
        Intrinsics.checkExpressionValueIsNotNull(paramString, "(this as java.lang.String).getBytes(charset)");
        localMessageDigest.update(paramString);
        paramString = StringUtil.Companion.bytes2HexStr(localMessageDigest.digest());
      }
    }
    return "";
  }
  
  @JvmStatic
  public final boolean isNullOrNil(@Nullable String paramString)
  {
    return (paramString == null) || (((CharSequence)paramString).length() == 0);
  }
  
  @JvmStatic
  @NotNull
  public final String nullAsNil(@Nullable String paramString)
  {
    if (paramString != null) {
      return paramString;
    }
    return "";
  }
  
  @JvmStatic
  public final long parseHex(@NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "valueStr");
    try
    {
      long l = Long.parseLong(paramString, 16);
      return l;
    }
    catch (Exception paramString) {}
    return 0L;
  }
  
  @JvmStatic
  @NotNull
  public final String replaceBlank(@Nullable String paramString)
  {
    String str = "";
    if (paramString != null)
    {
      str = Pattern.compile("[\t\r\n]").matcher((CharSequence)paramString).replaceAll("");
      Intrinsics.checkExpressionValueIsNotNull(str, "m.replaceAll(\"\")");
    }
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.qapmsdk.common.util.StringUtil.Companion
 * JD-Core Version:    0.7.0.1
 */