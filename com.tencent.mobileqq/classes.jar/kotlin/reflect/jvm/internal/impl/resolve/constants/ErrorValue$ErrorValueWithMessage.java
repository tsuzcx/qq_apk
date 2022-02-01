package kotlin.reflect.jvm.internal.impl.resolve.constants;

import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.ModuleDescriptor;
import kotlin.reflect.jvm.internal.impl.types.ErrorUtils;
import kotlin.reflect.jvm.internal.impl.types.SimpleType;
import org.jetbrains.annotations.NotNull;

public final class ErrorValue$ErrorValueWithMessage
  extends ErrorValue
{
  @NotNull
  private final String message;
  
  public ErrorValue$ErrorValueWithMessage(@NotNull String paramString)
  {
    this.message = paramString;
  }
  
  @NotNull
  public SimpleType getType(@NotNull ModuleDescriptor paramModuleDescriptor)
  {
    Intrinsics.checkParameterIsNotNull(paramModuleDescriptor, "module");
    paramModuleDescriptor = ErrorUtils.createErrorType(this.message);
    Intrinsics.checkExpressionValueIsNotNull(paramModuleDescriptor, "ErrorUtils.createErrorType(message)");
    return paramModuleDescriptor;
  }
  
  @NotNull
  public String toString()
  {
    return this.message;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     kotlin.reflect.jvm.internal.impl.resolve.constants.ErrorValue.ErrorValueWithMessage
 * JD-Core Version:    0.7.0.1
 */