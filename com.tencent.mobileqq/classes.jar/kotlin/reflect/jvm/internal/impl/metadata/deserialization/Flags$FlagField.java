package kotlin.reflect.jvm.internal.impl.metadata.deserialization;

import kotlin.reflect.jvm.internal.impl.protobuf.Internal.EnumLite;

public abstract class Flags$FlagField<E>
{
  public final int bitWidth;
  public final int offset;
  
  private Flags$FlagField(int paramInt1, int paramInt2)
  {
    this.offset = paramInt1;
    this.bitWidth = paramInt2;
  }
  
  public static <E extends Internal.EnumLite> FlagField<E> after(FlagField<?> paramFlagField, E[] paramArrayOfE)
  {
    return new Flags.EnumLiteFlagField(paramFlagField.offset + paramFlagField.bitWidth, paramArrayOfE);
  }
  
  public static Flags.BooleanFlagField booleanAfter(FlagField<?> paramFlagField)
  {
    return new Flags.BooleanFlagField(paramFlagField.offset + paramFlagField.bitWidth);
  }
  
  public static Flags.BooleanFlagField booleanFirst()
  {
    return new Flags.BooleanFlagField(0);
  }
  
  public abstract E get(int paramInt);
  
  public abstract int toFlags(E paramE);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     kotlin.reflect.jvm.internal.impl.metadata.deserialization.Flags.FlagField
 * JD-Core Version:    0.7.0.1
 */