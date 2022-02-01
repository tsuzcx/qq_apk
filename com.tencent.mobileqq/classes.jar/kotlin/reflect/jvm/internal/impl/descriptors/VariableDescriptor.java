package kotlin.reflect.jvm.internal.impl.descriptors;

import kotlin.reflect.jvm.internal.impl.resolve.constants.ConstantValue;
import org.jetbrains.annotations.Nullable;

public abstract interface VariableDescriptor
  extends ValueDescriptor
{
  @Nullable
  public abstract ConstantValue<?> getCompileTimeInitializer();
  
  public abstract boolean isConst();
  
  public abstract boolean isLateInit();
  
  public abstract boolean isVar();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     kotlin.reflect.jvm.internal.impl.descriptors.VariableDescriptor
 * JD-Core Version:    0.7.0.1
 */