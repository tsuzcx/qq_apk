package kotlin.ranges;

import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lkotlin/ranges/CharRange;", "Lkotlin/ranges/CharProgression;", "Lkotlin/ranges/ClosedRange;", "", "start", "endInclusive", "(CC)V", "getEndInclusive", "()Ljava/lang/Character;", "getStart", "contains", "", "value", "equals", "other", "", "hashCode", "", "isEmpty", "toString", "", "Companion", "kotlin-stdlib"}, k=1, mv={1, 1, 16})
public final class CharRange
  extends CharProgression
  implements ClosedRange<Character>
{
  public static final CharRange.Companion Companion = new CharRange.Companion(null);
  @NotNull
  private static final CharRange EMPTY = new CharRange((char)1, (char)0);
  
  public CharRange(char paramChar1, char paramChar2)
  {
    super(paramChar1, paramChar2, 1);
  }
  
  public boolean contains(char paramChar)
  {
    return (getFirst() <= paramChar) && (paramChar <= getLast());
  }
  
  public boolean equals(@Nullable Object paramObject)
  {
    return ((paramObject instanceof CharRange)) && (((isEmpty()) && (((CharRange)paramObject).isEmpty())) || ((getFirst() == ((CharRange)paramObject).getFirst()) && (getLast() == ((CharRange)paramObject).getLast())));
  }
  
  @NotNull
  public Character getEndInclusive()
  {
    return Character.valueOf(getLast());
  }
  
  @NotNull
  public Character getStart()
  {
    return Character.valueOf(getFirst());
  }
  
  public int hashCode()
  {
    if (isEmpty()) {
      return -1;
    }
    return getFirst() * '\037' + getLast();
  }
  
  public boolean isEmpty()
  {
    return getFirst() > getLast();
  }
  
  @NotNull
  public String toString()
  {
    return getFirst() + ".." + getLast();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     kotlin.ranges.CharRange
 * JD-Core Version:    0.7.0.1
 */