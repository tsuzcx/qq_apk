package kotlin.jvm.internal;

import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lkotlin/jvm/internal/IntSpreadBuilder;", "Lkotlin/jvm/internal/PrimitiveSpreadBuilder;", "", "size", "", "(I)V", "values", "add", "", "value", "toArray", "getSize", "kotlin-stdlib"}, k=1, mv={1, 1, 16})
public final class IntSpreadBuilder
  extends PrimitiveSpreadBuilder<int[]>
{
  private final int[] values;
  
  public IntSpreadBuilder(int paramInt)
  {
    super(paramInt);
    this.values = new int[paramInt];
  }
  
  public final void add(int paramInt)
  {
    int[] arrayOfInt = this.values;
    int i = getPosition();
    setPosition(i + 1);
    arrayOfInt[i] = paramInt;
  }
  
  protected int getSize(@NotNull int[] paramArrayOfInt)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfInt, "$this$getSize");
    return paramArrayOfInt.length;
  }
  
  @NotNull
  public final int[] toArray()
  {
    return (int[])toArray(this.values, new int[size()]);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     kotlin.jvm.internal.IntSpreadBuilder
 * JD-Core Version:    0.7.0.1
 */