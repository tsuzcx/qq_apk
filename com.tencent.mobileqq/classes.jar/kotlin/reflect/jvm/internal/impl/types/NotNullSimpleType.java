package kotlin.reflect.jvm.internal.impl.types;

import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

final class NotNullSimpleType
  extends DelegatingSimpleTypeImpl
{
  public NotNullSimpleType(@NotNull SimpleType paramSimpleType)
  {
    super(paramSimpleType);
  }
  
  public boolean isMarkedNullable()
  {
    return false;
  }
  
  @NotNull
  public NotNullSimpleType replaceDelegate(@NotNull SimpleType paramSimpleType)
  {
    Intrinsics.checkParameterIsNotNull(paramSimpleType, "delegate");
    return new NotNullSimpleType(paramSimpleType);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     kotlin.reflect.jvm.internal.impl.types.NotNullSimpleType
 * JD-Core Version:    0.7.0.1
 */