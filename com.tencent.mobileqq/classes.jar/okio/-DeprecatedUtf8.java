package okio;

import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Deprecated(message="changed in Okio 2.x")
@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lokio/-DeprecatedUtf8;", "", "()V", "size", "", "string", "", "beginIndex", "", "endIndex", "okio"}, k=1, mv={1, 1, 16})
public final class -DeprecatedUtf8
{
  public static final -DeprecatedUtf8 INSTANCE = new -DeprecatedUtf8();
  
  @Deprecated(level=DeprecationLevel.ERROR, message="moved to extension function", replaceWith=@ReplaceWith(expression="string.utf8Size()", imports={"okio.utf8Size"}))
  public final long size(@NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "string");
    return Utf8.size$default(paramString, 0, 0, 3, null);
  }
  
  @Deprecated(level=DeprecationLevel.ERROR, message="moved to extension function", replaceWith=@ReplaceWith(expression="string.utf8Size(beginIndex, endIndex)", imports={"okio.utf8Size"}))
  public final long size(@NotNull String paramString, int paramInt1, int paramInt2)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "string");
    return Utf8.size(paramString, paramInt1, paramInt2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     okio.-DeprecatedUtf8
 * JD-Core Version:    0.7.0.1
 */