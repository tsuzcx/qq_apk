package kotlin.collections;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lkotlin/collections/IndexedValue;", "T", "", "index", "", "value", "(ILjava/lang/Object;)V", "getIndex", "()I", "getValue", "()Ljava/lang/Object;", "Ljava/lang/Object;", "component1", "component2", "copy", "(ILjava/lang/Object;)Lkotlin/collections/IndexedValue;", "equals", "", "other", "hashCode", "toString", "", "kotlin-stdlib"}, k=1, mv={1, 1, 16})
public final class IndexedValue<T>
{
  private final int index;
  private final T value;
  
  public IndexedValue(int paramInt, T paramT)
  {
    this.index = paramInt;
    this.value = paramT;
  }
  
  public final int component1()
  {
    return this.index;
  }
  
  public final T component2()
  {
    return this.value;
  }
  
  @NotNull
  public final IndexedValue<T> copy(int paramInt, T paramT)
  {
    return new IndexedValue(paramInt, paramT);
  }
  
  public boolean equals(@Nullable Object paramObject)
  {
    if (this != paramObject) {
      if ((paramObject instanceof IndexedValue))
      {
        paramObject = (IndexedValue)paramObject;
        if ((this.index == paramObject.index) && (Intrinsics.areEqual(this.value, paramObject.value))) {}
      }
      else
      {
        return false;
      }
    }
    return true;
  }
  
  public final int getIndex()
  {
    return this.index;
  }
  
  public final T getValue()
  {
    return this.value;
  }
  
  public int hashCode()
  {
    int j = this.index;
    Object localObject = this.value;
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
    localStringBuilder.append("IndexedValue(index=");
    localStringBuilder.append(this.index);
    localStringBuilder.append(", value=");
    localStringBuilder.append(this.value);
    localStringBuilder.append(")");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     kotlin.collections.IndexedValue
 * JD-Core Version:    0.7.0.1
 */