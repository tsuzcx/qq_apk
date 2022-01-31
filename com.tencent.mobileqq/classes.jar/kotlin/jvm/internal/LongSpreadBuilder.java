package kotlin.jvm.internal;

import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lkotlin/jvm/internal/LongSpreadBuilder;", "Lkotlin/jvm/internal/PrimitiveSpreadBuilder;", "", "size", "", "(I)V", "values", "add", "", "value", "", "toArray", "getSize", "kotlin-stdlib"}, k=1, mv={1, 1, 16})
public final class LongSpreadBuilder
  extends PrimitiveSpreadBuilder<long[]>
{
  private final long[] values;
  
  public LongSpreadBuilder(int paramInt)
  {
    super(paramInt);
    this.values = new long[paramInt];
  }
  
  public final void add(long paramLong)
  {
    long[] arrayOfLong = this.values;
    int i = getPosition();
    setPosition(i + 1);
    arrayOfLong[i] = paramLong;
  }
  
  protected int getSize(@NotNull long[] paramArrayOfLong)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfLong, "$this$getSize");
    return paramArrayOfLong.length;
  }
  
  @NotNull
  public final long[] toArray()
  {
    return (long[])toArray(this.values, new long[size()]);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     kotlin.jvm.internal.LongSpreadBuilder
 * JD-Core Version:    0.7.0.1
 */