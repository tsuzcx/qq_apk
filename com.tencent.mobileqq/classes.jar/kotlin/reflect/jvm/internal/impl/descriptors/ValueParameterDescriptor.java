package kotlin.reflect.jvm.internal.impl.descriptors;

import java.util.Collection;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public abstract interface ValueParameterDescriptor
  extends ParameterDescriptor, VariableDescriptor
{
  @NotNull
  public abstract ValueParameterDescriptor copy(@NotNull CallableDescriptor paramCallableDescriptor, @NotNull Name paramName, int paramInt);
  
  public abstract boolean declaresDefaultValue();
  
  @NotNull
  public abstract CallableDescriptor getContainingDeclaration();
  
  public abstract int getIndex();
  
  @NotNull
  public abstract ValueParameterDescriptor getOriginal();
  
  @NotNull
  public abstract Collection<ValueParameterDescriptor> getOverriddenDescriptors();
  
  @Nullable
  public abstract KotlinType getVarargElementType();
  
  public abstract boolean isCrossinline();
  
  public abstract boolean isNoinline();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     kotlin.reflect.jvm.internal.impl.descriptors.ValueParameterDescriptor
 * JD-Core Version:    0.7.0.1
 */