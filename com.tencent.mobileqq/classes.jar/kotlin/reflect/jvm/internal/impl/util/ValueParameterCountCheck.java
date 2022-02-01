package kotlin.reflect.jvm.internal.impl.util;

import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public abstract class ValueParameterCountCheck
  implements Check
{
  @NotNull
  private final String description;
  
  private ValueParameterCountCheck(String paramString)
  {
    this.description = paramString;
  }
  
  @NotNull
  public String getDescription()
  {
    return this.description;
  }
  
  @Nullable
  public String invoke(@NotNull FunctionDescriptor paramFunctionDescriptor)
  {
    Intrinsics.checkParameterIsNotNull(paramFunctionDescriptor, "functionDescriptor");
    return Check.DefaultImpls.invoke(this, paramFunctionDescriptor);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     kotlin.reflect.jvm.internal.impl.util.ValueParameterCountCheck
 * JD-Core Version:    0.7.0.1
 */