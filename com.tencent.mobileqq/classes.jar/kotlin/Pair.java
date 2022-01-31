package kotlin;

import java.io.Serializable;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lkotlin/Pair;", "A", "B", "Ljava/io/Serializable;", "Lkotlin/io/Serializable;", "first", "second", "(Ljava/lang/Object;Ljava/lang/Object;)V", "getFirst", "()Ljava/lang/Object;", "Ljava/lang/Object;", "getSecond", "component1", "component2", "copy", "(Ljava/lang/Object;Ljava/lang/Object;)Lkotlin/Pair;", "equals", "", "other", "", "hashCode", "", "toString", "", "kotlin-stdlib"}, k=1, mv={1, 1, 16})
public final class Pair<A, B>
  implements Serializable
{
  private final A first;
  private final B second;
  
  public Pair(A paramA, B paramB)
  {
    this.first = paramA;
    this.second = paramB;
  }
  
  public final A component1()
  {
    return this.first;
  }
  
  public final B component2()
  {
    return this.second;
  }
  
  @NotNull
  public final Pair<A, B> copy(A paramA, B paramB)
  {
    return new Pair(paramA, paramB);
  }
  
  public boolean equals(@Nullable Object paramObject)
  {
    if (this != paramObject)
    {
      if ((paramObject instanceof Pair))
      {
        paramObject = (Pair)paramObject;
        if ((!Intrinsics.areEqual(this.first, paramObject.first)) || (!Intrinsics.areEqual(this.second, paramObject.second))) {}
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
  
  public int hashCode()
  {
    int j = 0;
    Object localObject = this.first;
    if (localObject != null) {}
    for (int i = localObject.hashCode();; i = 0)
    {
      localObject = this.second;
      if (localObject != null) {
        j = localObject.hashCode();
      }
      return i * 31 + j;
    }
  }
  
  @NotNull
  public String toString()
  {
    return '(' + this.first + ", " + this.second + ')';
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     kotlin.Pair
 * JD-Core Version:    0.7.0.1
 */