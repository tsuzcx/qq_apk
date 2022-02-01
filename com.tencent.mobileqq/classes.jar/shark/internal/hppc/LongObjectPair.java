package shark.internal.hppc;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lshark/internal/hppc/LongObjectPair;", "B", "", "first", "", "second", "(JLjava/lang/Object;)V", "getFirst", "()J", "getSecond", "()Ljava/lang/Object;", "Ljava/lang/Object;", "component1", "component2", "copy", "(JLjava/lang/Object;)Lshark/internal/hppc/LongObjectPair;", "equals", "", "other", "hashCode", "", "toString", "", "shark-graph"}, k=1, mv={1, 4, 1})
public final class LongObjectPair<B>
{
  private final long a;
  private final B b;
  
  public LongObjectPair(long paramLong, B paramB)
  {
    this.a = paramLong;
    this.b = paramB;
  }
  
  public final long a()
  {
    return this.a;
  }
  
  public final B b()
  {
    return this.b;
  }
  
  public boolean equals(@Nullable Object paramObject)
  {
    if (this != paramObject) {
      if ((paramObject instanceof LongObjectPair))
      {
        paramObject = (LongObjectPair)paramObject;
        if ((this.a == paramObject.a) && (Intrinsics.areEqual(this.b, paramObject.b))) {}
      }
      else
      {
        return false;
      }
    }
    return true;
  }
  
  public int hashCode()
  {
    long l = this.a;
    int j = (int)(l ^ l >>> 32);
    Object localObject = this.b;
    int i;
    if (localObject != null) {
      i = localObject.hashCode();
    } else {
      i = 0;
    }
    return j * 31 + i;
  }
  
  @NotNull
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("LongObjectPair(first=");
    localStringBuilder.append(this.a);
    localStringBuilder.append(", second=");
    localStringBuilder.append(this.b);
    localStringBuilder.append(")");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     shark.internal.hppc.LongObjectPair
 * JD-Core Version:    0.7.0.1
 */