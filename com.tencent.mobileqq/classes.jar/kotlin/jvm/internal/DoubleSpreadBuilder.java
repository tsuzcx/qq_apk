package kotlin.jvm.internal;

import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lkotlin/jvm/internal/DoubleSpreadBuilder;", "Lkotlin/jvm/internal/PrimitiveSpreadBuilder;", "", "size", "", "(I)V", "values", "add", "", "value", "", "toArray", "getSize", "kotlin-stdlib"}, k=1, mv={1, 1, 16})
public final class DoubleSpreadBuilder
  extends PrimitiveSpreadBuilder<double[]>
{
  private final double[] values;
  
  public DoubleSpreadBuilder(int paramInt)
  {
    super(paramInt);
    this.values = new double[paramInt];
  }
  
  public final void add(double paramDouble)
  {
    double[] arrayOfDouble = this.values;
    int i = getPosition();
    setPosition(i + 1);
    arrayOfDouble[i] = paramDouble;
  }
  
  protected int getSize(@NotNull double[] paramArrayOfDouble)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfDouble, "$this$getSize");
    return paramArrayOfDouble.length;
  }
  
  @NotNull
  public final double[] toArray()
  {
    return (double[])toArray(this.values, new double[size()]);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     kotlin.jvm.internal.DoubleSpreadBuilder
 * JD-Core Version:    0.7.0.1
 */