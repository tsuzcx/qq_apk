package kotlin.reflect.jvm.internal.impl.util;

import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor;
import org.jetbrains.annotations.NotNull;

public final class ValueParameterCountCheck$SingleValueParameter
  extends ValueParameterCountCheck
{
  public static final SingleValueParameter INSTANCE = new SingleValueParameter();
  
  private ValueParameterCountCheck$SingleValueParameter()
  {
    super("must have a single value parameter", null);
  }
  
  public boolean check(@NotNull FunctionDescriptor paramFunctionDescriptor)
  {
    Intrinsics.checkParameterIsNotNull(paramFunctionDescriptor, "functionDescriptor");
    return paramFunctionDescriptor.getValueParameters().size() == 1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     kotlin.reflect.jvm.internal.impl.util.ValueParameterCountCheck.SingleValueParameter
 * JD-Core Version:    0.7.0.1
 */