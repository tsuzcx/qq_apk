package kotlin.text;

import java.nio.charset.Charset;
import kotlin.Metadata;
import kotlin.jvm.JvmField;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lkotlin/text/Charsets;", "", "()V", "ISO_8859_1", "Ljava/nio/charset/Charset;", "US_ASCII", "UTF_16", "UTF_16BE", "UTF_16LE", "UTF_32", "UTF32", "()Ljava/nio/charset/Charset;", "UTF_32BE", "UTF32_BE", "UTF_32LE", "UTF32_LE", "UTF_8", "utf_32", "utf_32be", "utf_32le", "kotlin-stdlib"}, k=1, mv={1, 1, 16})
public final class Charsets
{
  public static final Charsets INSTANCE = new Charsets();
  @JvmField
  @NotNull
  public static final Charset ISO_8859_1;
  @JvmField
  @NotNull
  public static final Charset US_ASCII;
  @JvmField
  @NotNull
  public static final Charset UTF_16;
  @JvmField
  @NotNull
  public static final Charset UTF_16BE;
  @JvmField
  @NotNull
  public static final Charset UTF_16LE;
  @JvmField
  @NotNull
  public static final Charset UTF_8;
  private static Charset utf_32;
  private static Charset utf_32be;
  private static Charset utf_32le;
  
  static
  {
    Charset localCharset = Charset.forName("UTF-8");
    Intrinsics.checkExpressionValueIsNotNull(localCharset, "Charset.forName(\"UTF-8\")");
    UTF_8 = localCharset;
    localCharset = Charset.forName("UTF-16");
    Intrinsics.checkExpressionValueIsNotNull(localCharset, "Charset.forName(\"UTF-16\")");
    UTF_16 = localCharset;
    localCharset = Charset.forName("UTF-16BE");
    Intrinsics.checkExpressionValueIsNotNull(localCharset, "Charset.forName(\"UTF-16BE\")");
    UTF_16BE = localCharset;
    localCharset = Charset.forName("UTF-16LE");
    Intrinsics.checkExpressionValueIsNotNull(localCharset, "Charset.forName(\"UTF-16LE\")");
    UTF_16LE = localCharset;
    localCharset = Charset.forName("US-ASCII");
    Intrinsics.checkExpressionValueIsNotNull(localCharset, "Charset.forName(\"US-ASCII\")");
    US_ASCII = localCharset;
    localCharset = Charset.forName("ISO-8859-1");
    Intrinsics.checkExpressionValueIsNotNull(localCharset, "Charset.forName(\"ISO-8859-1\")");
    ISO_8859_1 = localCharset;
  }
  
  @JvmName(name="UTF32")
  @NotNull
  public final Charset UTF32()
  {
    Object localObject = utf_32;
    if (localObject != null) {
      return localObject;
    }
    localObject = (Charsets)this;
    localObject = Charset.forName("UTF-32");
    Intrinsics.checkExpressionValueIsNotNull(localObject, "Charset.forName(\"UTF-32\")");
    utf_32 = (Charset)localObject;
    return localObject;
  }
  
  @JvmName(name="UTF32_BE")
  @NotNull
  public final Charset UTF32_BE()
  {
    Object localObject = utf_32be;
    if (localObject != null) {
      return localObject;
    }
    localObject = (Charsets)this;
    localObject = Charset.forName("UTF-32BE");
    Intrinsics.checkExpressionValueIsNotNull(localObject, "Charset.forName(\"UTF-32BE\")");
    utf_32be = (Charset)localObject;
    return localObject;
  }
  
  @JvmName(name="UTF32_LE")
  @NotNull
  public final Charset UTF32_LE()
  {
    Object localObject = utf_32le;
    if (localObject != null) {
      return localObject;
    }
    localObject = (Charsets)this;
    localObject = Charset.forName("UTF-32LE");
    Intrinsics.checkExpressionValueIsNotNull(localObject, "Charset.forName(\"UTF-32LE\")");
    utf_32le = (Charset)localObject;
    return localObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     kotlin.text.Charsets
 * JD-Core Version:    0.7.0.1
 */