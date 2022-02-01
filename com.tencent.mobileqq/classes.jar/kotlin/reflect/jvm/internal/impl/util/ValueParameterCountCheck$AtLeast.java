package kotlin.reflect.jvm.internal.impl.util;

import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor;
import org.jetbrains.annotations.NotNull;

public final class ValueParameterCountCheck$AtLeast
  extends ValueParameterCountCheck
{
  private final int n;
  
  public ValueParameterCountCheck$AtLeast(int paramInt)
  {
    super(localStringBuilder.toString(), null);
    this.n = paramInt;
  }
  
  public boolean check(@NotNull FunctionDescriptor paramFunctionDescriptor)
  {
    Intrinsics.checkParameterIsNotNull(paramFunctionDescriptor, "functionDescriptor");
    return paramFunctionDescriptor.getValueParameters().size() >= this.n;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     kotlin.reflect.jvm.internal.impl.util.ValueParameterCountCheck.AtLeast
 * JD-Core Version:    0.7.0.1
 */