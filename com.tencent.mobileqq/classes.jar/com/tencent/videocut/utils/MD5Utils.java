package com.tencent.videocut.utils;

import java.nio.charset.Charset;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/videocut/utils/MD5Utils;", "", "()V", "MD5", "", "UTF8", "hexDigits", "", "getFileMd5", "fileName", "streamToMD5", "inputStream", "Ljava/io/InputStream;", "stringToMD5", "str", "toHexString", "md", "", "urlToMd5", "url", "lib_utils_release"}, k=1, mv={1, 4, 2})
public final class MD5Utils
{
  @NotNull
  public static final MD5Utils a = new MD5Utils();
  private static final char[] b = { 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 97, 98, 99, 100, 101, 102 };
  
  private final String a(byte[] paramArrayOfByte)
  {
    if (paramArrayOfByte == null) {
      return null;
    }
    int j = paramArrayOfByte.length;
    char[] arrayOfChar1 = new char[j * 2];
    int i = 0;
    while (i < j)
    {
      int k = paramArrayOfByte[i];
      int m = i * 2;
      char[] arrayOfChar2 = b;
      arrayOfChar1[m] = arrayOfChar2[(k >>> 4 & 0xF)];
      arrayOfChar1[(m + 1)] = arrayOfChar2[(k & 0xF)];
      i += 1;
    }
    return new String(arrayOfChar1);
  }
  
  @Nullable
  public final String a(@Nullable String paramString)
  {
    if (paramString == null) {
      return null;
    }
    try
    {
      Object localObject = Charset.defaultCharset();
      Intrinsics.checkNotNullExpressionValue(localObject, "Charset.defaultCharset()");
      paramString = paramString.getBytes((Charset)localObject);
      Intrinsics.checkNotNullExpressionValue(paramString, "(this as java.lang.String).getBytes(charset)");
      localObject = MessageDigest.getInstance("MD5");
      ((MessageDigest)localObject).update(paramString);
      paramString = a(((MessageDigest)localObject).digest());
      return paramString;
    }
    catch (NoSuchAlgorithmException paramString)
    {
      paramString.printStackTrace();
      return null;
    }
    catch (IllegalArgumentException paramString)
    {
      paramString.printStackTrace();
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.videocut.utils.MD5Utils
 * JD-Core Version:    0.7.0.1
 */