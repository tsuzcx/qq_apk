package kotlin.reflect.jvm.internal.impl.descriptors;

import java.util.Collection;
import java.util.List;
import kotlin.reflect.jvm.internal.impl.types.TypeSubstitutor;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public abstract interface PropertyDescriptor
  extends CallableMemberDescriptor, VariableDescriptorWithAccessors
{
  @NotNull
  public abstract List<PropertyAccessorDescriptor> getAccessors();
  
  @Nullable
  public abstract FieldDescriptor getBackingField();
  
  @Nullable
  public abstract FieldDescriptor getDelegateField();
  
  @Nullable
  public abstract PropertyGetterDescriptor getGetter();
  
  @NotNull
  public abstract PropertyDescriptor getOriginal();
  
  @NotNull
  public abstract Collection<? extends PropertyDescriptor> getOverriddenDescriptors();
  
  @Nullable
  public abstract PropertySetterDescriptor getSetter();
  
  public abstract PropertyDescriptor substitute(@NotNull TypeSubstitutor paramTypeSubstitutor);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     kotlin.reflect.jvm.internal.impl.descriptors.PropertyDescriptor
 * JD-Core Version:    0.7.0.1
 */