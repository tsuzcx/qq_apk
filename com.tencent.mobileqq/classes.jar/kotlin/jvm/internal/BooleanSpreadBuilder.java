package kotlin.jvm.internal;

import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lkotlin/jvm/internal/BooleanSpreadBuilder;", "Lkotlin/jvm/internal/PrimitiveSpreadBuilder;", "", "size", "", "(I)V", "values", "add", "", "value", "", "toArray", "getSize", "kotlin-stdlib"}, k=1, mv={1, 1, 16})
public final class BooleanSpreadBuilder
  extends PrimitiveSpreadBuilder<boolean[]>
{
  private final boolean[] values;
  
  public BooleanSpreadBuilder(int paramInt)
  {
    super(paramInt);
    this.values = new boolean[paramInt];
  }
  
  public final void add(boolean paramBoolean)
  {
    boolean[] arrayOfBoolean = this.values;
    int i = getPosition();
    setPosition(i + 1);
    arrayOfBoolean[i] = paramBoolean;
  }
  
  protected int getSize(@NotNull boolean[] paramArrayOfBoolean)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfBoolean, "$this$getSize");
    return paramArrayOfBoolean.length;
  }
  
  @NotNull
  public final boolean[] toArray()
  {
    return (boolean[])toArray(this.values, new boolean[size()]);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     kotlin.jvm.internal.BooleanSpreadBuilder
 * JD-Core Version:    0.7.0.1
 */