package kotlin.text;

import java.io.Serializable;
import java.util.regex.Pattern;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lkotlin/text/Regex$Serialized;", "Ljava/io/Serializable;", "Lkotlin/io/Serializable;", "pattern", "", "flags", "", "(Ljava/lang/String;I)V", "getFlags", "()I", "getPattern", "()Ljava/lang/String;", "readResolve", "", "Companion", "kotlin-stdlib"}, k=1, mv={1, 1, 16})
final class Regex$Serialized
  implements Serializable
{
  public static final Regex.Serialized.Companion Companion = new Regex.Serialized.Companion(null);
  private static final long serialVersionUID = 0L;
  private final int flags;
  @NotNull
  private final String pattern;
  
  public Regex$Serialized(@NotNull String paramString, int paramInt)
  {
    this.pattern = paramString;
    this.flags = paramInt;
  }
  
  private final Object readResolve()
  {
    Pattern localPattern = Pattern.compile(this.pattern, this.flags);
    Intrinsics.checkExpressionValueIsNotNull(localPattern, "Pattern.compile(pattern, flags)");
    return new Regex(localPattern);
  }
  
  public final int getFlags()
  {
    return this.flags;
  }
  
  @NotNull
  public final String getPattern()
  {
    return this.pattern;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     kotlin.text.Regex.Serialized
 * JD-Core Version:    0.7.0.1
 */