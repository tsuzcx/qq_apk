package kotlin.reflect.jvm.internal.impl.util;

import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor;
import org.jetbrains.annotations.NotNull;

public final class ValueParameterCountCheck$NoValueParameters
  extends ValueParameterCountCheck
{
  public static final NoValueParameters INSTANCE = new NoValueParameters();
  
  private ValueParameterCountCheck$NoValueParameters()
  {
    super("must have no value parameters", null);
  }
  
  public boolean check(@NotNull FunctionDescriptor paramFunctionDescriptor)
  {
    Intrinsics.checkParameterIsNotNull(paramFunctionDescriptor, "functionDescriptor");
    return paramFunctionDescriptor.getValueParameters().isEmpty();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     kotlin.reflect.jvm.internal.impl.util.ValueParameterCountCheck.NoValueParameters
 * JD-Core Version:    0.7.0.1
 */