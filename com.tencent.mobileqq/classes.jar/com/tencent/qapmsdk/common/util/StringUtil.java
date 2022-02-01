package com.tencent.qapmsdk.common.util;

import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/qapmsdk/common/util/StringUtil;", "", "()V", "Companion", "common_release"}, k=1, mv={1, 1, 15})
public final class StringUtil
{
  public static final StringUtil.Companion Companion = new StringUtil.Companion(null);
  @NotNull
  public static final String TAG = "QAPM_common_StringUtil";
  private static final char[] digits = { 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 97, 98, 99, 100, 101, 102 };
  
  @JvmStatic
  @NotNull
  public static final String bytes2HexStr(@Nullable byte[] paramArrayOfByte)
  {
    return Companion.bytes2HexStr(paramArrayOfByte);
  }
  
  @JvmStatic
  @NotNull
  public static final String getMD5(@Nullable String paramString)
  {
    return Companion.getMD5(paramString);
  }
  
  @JvmStatic
  public static final boolean isNullOrNil(@Nullable String paramString)
  {
    return Companion.isNullOrNil(paramString);
  }
  
  @JvmStatic
  @NotNull
  public static final String nullAsNil(@Nullable String paramString)
  {
    return Companion.nullAsNil(paramString);
  }
  
  @JvmStatic
  public static final long parseHex(@NotNull String paramString)
  {
    return Companion.parseHex(paramString);
  }
  
  @JvmStatic
  @NotNull
  public static final String replaceBlank(@Nullable String paramString)
  {
    return Companion.replaceBlank(paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.qapmsdk.common.util.StringUtil
 * JD-Core Version:    0.7.0.1
 */