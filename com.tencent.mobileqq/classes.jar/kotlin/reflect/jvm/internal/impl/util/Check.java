package kotlin.reflect.jvm.internal.impl.util;

import kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public abstract interface Check
{
  public abstract boolean check(@NotNull FunctionDescriptor paramFunctionDescriptor);
  
  @NotNull
  public abstract String getDescription();
  
  @Nullable
  public abstract String invoke(@NotNull FunctionDescriptor paramFunctionDescriptor);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     kotlin.reflect.jvm.internal.impl.util.Check
 * JD-Core Version:    0.7.0.1
 */