package kotlin.jvm.internal;

import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lkotlin/jvm/internal/FloatSpreadBuilder;", "Lkotlin/jvm/internal/PrimitiveSpreadBuilder;", "", "size", "", "(I)V", "values", "add", "", "value", "", "toArray", "getSize", "kotlin-stdlib"}, k=1, mv={1, 1, 16})
public final class FloatSpreadBuilder
  extends PrimitiveSpreadBuilder<float[]>
{
  private final float[] values;
  
  public FloatSpreadBuilder(int paramInt)
  {
    super(paramInt);
    this.values = new float[paramInt];
  }
  
  public final void add(float paramFloat)
  {
    float[] arrayOfFloat = this.values;
    int i = getPosition();
    setPosition(i + 1);
    arrayOfFloat[i] = paramFloat;
  }
  
  protected int getSize(@NotNull float[] paramArrayOfFloat)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfFloat, "$this$getSize");
    return paramArrayOfFloat.length;
  }
  
  @NotNull
  public final float[] toArray()
  {
    return (float[])toArray(this.values, new float[size()]);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     kotlin.jvm.internal.FloatSpreadBuilder
 * JD-Core Version:    0.7.0.1
 */