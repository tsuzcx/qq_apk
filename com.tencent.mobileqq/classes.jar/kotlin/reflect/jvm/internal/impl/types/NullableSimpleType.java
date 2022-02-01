package kotlin.reflect.jvm.internal.impl.types;

import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

final class NullableSimpleType
  extends DelegatingSimpleTypeImpl
{
  public NullableSimpleType(@NotNull SimpleType paramSimpleType)
  {
    super(paramSimpleType);
  }
  
  public boolean isMarkedNullable()
  {
    return true;
  }
  
  @NotNull
  public NullableSimpleType replaceDelegate(@NotNull SimpleType paramSimpleType)
  {
    Intrinsics.checkParameterIsNotNull(paramSimpleType, "delegate");
    return new NullableSimpleType(paramSimpleType);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     kotlin.reflect.jvm.internal.impl.types.NullableSimpleType
 * JD-Core Version:    0.7.0.1
 */