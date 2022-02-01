package kotlin;

import kotlin.internal.InlineOnly;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"hashCode", "", "", "kotlin-stdlib"}, k=2, mv={1, 1, 16})
public final class HashCodeKt
{
  @SinceKotlin(version="1.3")
  @InlineOnly
  private static final int hashCode(@Nullable Object paramObject)
  {
    if (paramObject != null) {
      return paramObject.hashCode();
    }
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     kotlin.HashCodeKt
 * JD-Core Version:    0.7.0.1
 */