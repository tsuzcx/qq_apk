package kotlin.text;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntRange;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lkotlin/text/MatchGroup;", "", "value", "", "range", "Lkotlin/ranges/IntRange;", "(Ljava/lang/String;Lkotlin/ranges/IntRange;)V", "getRange", "()Lkotlin/ranges/IntRange;", "getValue", "()Ljava/lang/String;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "kotlin-stdlib"}, k=1, mv={1, 1, 16})
public final class MatchGroup
{
  @NotNull
  private final IntRange range;
  @NotNull
  private final String value;
  
  public MatchGroup(@NotNull String paramString, @NotNull IntRange paramIntRange)
  {
    this.value = paramString;
    this.range = paramIntRange;
  }
  
  @NotNull
  public final String component1()
  {
    return this.value;
  }
  
  @NotNull
  public final IntRange component2()
  {
    return this.range;
  }
  
  @NotNull
  public final MatchGroup copy(@NotNull String paramString, @NotNull IntRange paramIntRange)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "value");
    Intrinsics.checkParameterIsNotNull(paramIntRange, "range");
    return new MatchGroup(paramString, paramIntRange);
  }
  
  public boolean equals(@Nullable Object paramObject)
  {
    if (this != paramObject)
    {
      if ((paramObject instanceof MatchGroup))
      {
        paramObject = (MatchGroup)paramObject;
        if ((!Intrinsics.areEqual(this.value, paramObject.value)) || (!Intrinsics.areEqual(this.range, paramObject.range))) {}
      }
    }
    else {
      return true;
    }
    return false;
  }
  
  @NotNull
  public final IntRange getRange()
  {
    return this.range;
  }
  
  @NotNull
  public final String getValue()
  {
    return this.value;
  }
  
  public int hashCode()
  {
    int j = 0;
    Object localObject = this.value;
    if (localObject != null) {}
    for (int i = localObject.hashCode();; i = 0)
    {
      localObject = this.range;
      if (localObject != null) {
        j = localObject.hashCode();
      }
      return i * 31 + j;
    }
  }
  
  @NotNull
  public String toString()
  {
    return "MatchGroup(value=" + this.value + ", range=" + this.range + ")";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     kotlin.text.MatchGroup
 * JD-Core Version:    0.7.0.1
 */