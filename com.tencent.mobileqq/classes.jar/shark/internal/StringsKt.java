package shark.internal;

import java.nio.charset.Charset;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import kotlin.Metadata;
import kotlin.jvm.JvmField;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"UTF_8", "Ljava/nio/charset/Charset;", "createHash", "", "text", "algorithm", "createSHA1Hash", "getBytes", "", "lastSegment", "segmentingChar", "", "shark"}, k=2, mv={1, 4, 1})
public final class StringsKt
{
  @JvmField
  @NotNull
  public static final Charset a;
  
  static
  {
    Charset localCharset = Charset.forName("UTF-8");
    Intrinsics.checkExpressionValueIsNotNull(localCharset, "Charset.forName(\"UTF-8\")");
    a = localCharset;
  }
  
  @NotNull
  public static final String a(@NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "$this$createSHA1Hash");
    return a(paramString, "SHA-1");
  }
  
  @NotNull
  public static final String a(@NotNull String paramString, char paramChar)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "$this$lastSegment");
    int i = kotlin.text.StringsKt.lastIndexOf$default((CharSequence)paramString, paramChar, 0, false, 6, null);
    if (i == -1) {
      return paramString;
    }
    paramString = paramString.substring(i + 1);
    Intrinsics.checkExpressionValueIsNotNull(paramString, "(this as java.lang.String).substring(startIndex)");
    return paramString;
  }
  
  private static final String a(String paramString1, String paramString2)
  {
    try
    {
      Object localObject = MessageDigest.getInstance(paramString2);
      ((MessageDigest)localObject).update(b(paramString1));
      paramString1 = ((MessageDigest)localObject).digest();
      localObject = new StringBuilder();
      int j = paramString1.length;
      int i = 0;
      while (i < j)
      {
        ((StringBuilder)localObject).append(Integer.toHexString(paramString1[i] & 0xFF));
        i += 1;
      }
      paramString1 = ((StringBuilder)localObject).toString();
      Intrinsics.checkExpressionValueIsNotNull(paramString1, "hexString.toString()");
      return paramString1;
    }
    catch (NoSuchAlgorithmException paramString1)
    {
      label77:
      break label77;
    }
    paramString1 = new StringBuilder();
    paramString1.append("Unable to construct MessageDigest for ");
    paramString1.append(paramString2);
    paramString1 = (Throwable)new AssertionError(paramString1.toString());
    for (;;)
    {
      throw paramString1;
    }
  }
  
  @NotNull
  public static final byte[] b(@NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "$this$getBytes");
    paramString = paramString.getBytes(a);
    Intrinsics.checkExpressionValueIsNotNull(paramString, "(this as java.lang.String).getBytes(charset)");
    return paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     shark.internal.StringsKt
 * JD-Core Version:    0.7.0.1
 */