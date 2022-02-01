package okio;

import kotlin.Metadata;
import kotlin.jvm.JvmName;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Okio", "Lokio/-DeprecatedOkio;", "getOkio", "()Lokio/-DeprecatedOkio;", "Utf8", "Lokio/-DeprecatedUtf8;", "getUtf8", "()Lokio/-DeprecatedUtf8;", "okio"}, k=2, mv={1, 1, 16})
@JvmName(name="-DeprecatedUpgrade")
public final class -DeprecatedUpgrade
{
  @NotNull
  private static final -DeprecatedOkio Okio = -DeprecatedOkio.INSTANCE;
  @NotNull
  private static final -DeprecatedUtf8 Utf8 = -DeprecatedUtf8.INSTANCE;
  
  @NotNull
  public static final -DeprecatedOkio getOkio()
  {
    return Okio;
  }
  
  @NotNull
  public static final -DeprecatedUtf8 getUtf8()
  {
    return Utf8;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     okio.-DeprecatedUpgrade
 * JD-Core Version:    0.7.0.1
 */