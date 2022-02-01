package kotlin.ranges;

import kotlin.ExperimentalUnsignedTypes;
import kotlin.Metadata;
import kotlin.SinceKotlin;
import kotlin.ULong;
import kotlin.UnsignedKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lkotlin/ranges/ULongRange;", "Lkotlin/ranges/ULongProgression;", "Lkotlin/ranges/ClosedRange;", "Lkotlin/ULong;", "start", "endInclusive", "(JJLkotlin/jvm/internal/DefaultConstructorMarker;)V", "getEndInclusive", "()Lkotlin/ULong;", "getStart", "contains", "", "value", "contains-VKZWuLQ", "(J)Z", "equals", "other", "", "hashCode", "", "isEmpty", "toString", "", "Companion", "kotlin-stdlib"}, k=1, mv={1, 1, 16})
@ExperimentalUnsignedTypes
@SinceKotlin(version="1.3")
public final class ULongRange
  extends ULongProgression
  implements ClosedRange<ULong>
{
  public static final ULongRange.Companion Companion = new ULongRange.Companion(null);
  @NotNull
  private static final ULongRange EMPTY = new ULongRange(-1L, 0L, null);
  
  private ULongRange(long paramLong1, long paramLong2)
  {
    super(paramLong1, paramLong2, 1L, null);
  }
  
  public boolean contains-VKZWuLQ(long paramLong)
  {
    return (UnsignedKt.ulongCompare(getFirst(), paramLong) <= 0) && (UnsignedKt.ulongCompare(paramLong, getLast()) <= 0);
  }
  
  public boolean equals(@Nullable Object paramObject)
  {
    if ((paramObject instanceof ULongRange)) {
      if ((!isEmpty()) || (!((ULongRange)paramObject).isEmpty()))
      {
        long l = getFirst();
        paramObject = (ULongRange)paramObject;
        if ((l != paramObject.getFirst()) || (getLast() != paramObject.getLast())) {}
      }
      else
      {
        return true;
      }
    }
    return false;
  }
  
  @NotNull
  public ULong getEndInclusive()
  {
    return ULong.box-impl(getLast());
  }
  
  @NotNull
  public ULong getStart()
  {
    return ULong.box-impl(getFirst());
  }
  
  public int hashCode()
  {
    if (isEmpty()) {
      return -1;
    }
    int i = (int)ULong.constructor-impl(getFirst() ^ ULong.constructor-impl(getFirst() >>> 32));
    return (int)ULong.constructor-impl(getLast() ^ ULong.constructor-impl(getLast() >>> 32)) + i * 31;
  }
  
  public boolean isEmpty()
  {
    return UnsignedKt.ulongCompare(getFirst(), getLast()) > 0;
  }
  
  @NotNull
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(ULong.toString-impl(getFirst()));
    localStringBuilder.append("..");
    localStringBuilder.append(ULong.toString-impl(getLast()));
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     kotlin.ranges.ULongRange
 * JD-Core Version:    0.7.0.1
 */