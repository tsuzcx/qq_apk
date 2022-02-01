package shark.internal.hppc;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lshark/internal/hppc/IntObjectPair;", "B", "", "first", "", "second", "(ILjava/lang/Object;)V", "getFirst", "()I", "getSecond", "()Ljava/lang/Object;", "Ljava/lang/Object;", "component1", "component2", "copy", "(ILjava/lang/Object;)Lshark/internal/hppc/IntObjectPair;", "equals", "", "other", "hashCode", "toString", "", "shark-graph"}, k=1, mv={1, 4, 1})
public final class IntObjectPair<B>
{
  private final int a;
  private final B b;
  
  public IntObjectPair(int paramInt, B paramB)
  {
    this.a = paramInt;
    this.b = paramB;
  }
  
  public final int a()
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
      if ((paramObject instanceof IntObjectPair))
      {
        paramObject = (IntObjectPair)paramObject;
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
    int j = this.a;
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
    localStringBuilder.append("IntObjectPair(first=");
    localStringBuilder.append(this.a);
    localStringBuilder.append(", second=");
    localStringBuilder.append(this.b);
    localStringBuilder.append(")");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     shark.internal.hppc.IntObjectPair
 * JD-Core Version:    0.7.0.1
 */