package kotlin;

import java.io.Serializable;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lkotlin/Triple;", "A", "B", "C", "Ljava/io/Serializable;", "Lkotlin/io/Serializable;", "first", "second", "third", "(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)V", "getFirst", "()Ljava/lang/Object;", "Ljava/lang/Object;", "getSecond", "getThird", "component1", "component2", "component3", "copy", "(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Lkotlin/Triple;", "equals", "", "other", "", "hashCode", "", "toString", "", "kotlin-stdlib"}, k=1, mv={1, 1, 16})
public final class Triple<A, B, C>
  implements Serializable
{
  private final A first;
  private final B second;
  private final C third;
  
  public Triple(A paramA, B paramB, C paramC)
  {
    this.first = paramA;
    this.second = paramB;
    this.third = paramC;
  }
  
  public final A component1()
  {
    return this.first;
  }
  
  public final B component2()
  {
    return this.second;
  }
  
  public final C component3()
  {
    return this.third;
  }
  
  @NotNull
  public final Triple<A, B, C> copy(A paramA, B paramB, C paramC)
  {
    return new Triple(paramA, paramB, paramC);
  }
  
  public boolean equals(@Nullable Object paramObject)
  {
    if (this != paramObject)
    {
      if ((paramObject instanceof Triple))
      {
        paramObject = (Triple)paramObject;
        if ((!Intrinsics.areEqual(this.first, paramObject.first)) || (!Intrinsics.areEqual(this.second, paramObject.second)) || (!Intrinsics.areEqual(this.third, paramObject.third))) {}
      }
    }
    else {
      return true;
    }
    return false;
  }
  
  public final A getFirst()
  {
    return this.first;
  }
  
  public final B getSecond()
  {
    return this.second;
  }
  
  public final C getThird()
  {
    return this.third;
  }
  
  public int hashCode()
  {
    int k = 0;
    Object localObject = this.first;
    int i;
    if (localObject != null)
    {
      i = localObject.hashCode();
      localObject = this.second;
      if (localObject == null) {
        break label70;
      }
    }
    label70:
    for (int j = localObject.hashCode();; j = 0)
    {
      localObject = this.third;
      if (localObject != null) {
        k = localObject.hashCode();
      }
      return (j + i * 31) * 31 + k;
      i = 0;
      break;
    }
  }
  
  @NotNull
  public String toString()
  {
    return '(' + this.first + ", " + this.second + ", " + this.third + ')';
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     kotlin.Triple
 * JD-Core Version:    0.7.0.1
 */