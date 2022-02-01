package kotlin.reflect.jvm.internal.impl.descriptors.deserialization;

import java.util.Collection;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassConstructorDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.SimpleFunctionDescriptor;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import org.jetbrains.annotations.NotNull;

public abstract interface AdditionalClassPartsProvider
{
  @NotNull
  public abstract Collection<ClassConstructorDescriptor> getConstructors(@NotNull ClassDescriptor paramClassDescriptor);
  
  @NotNull
  public abstract Collection<SimpleFunctionDescriptor> getFunctions(@NotNull Name paramName, @NotNull ClassDescriptor paramClassDescriptor);
  
  @NotNull
  public abstract Collection<Name> getFunctionsNames(@NotNull ClassDescriptor paramClassDescriptor);
  
  @NotNull
  public abstract Collection<KotlinType> getSupertypes(@NotNull ClassDescriptor paramClassDescriptor);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     kotlin.reflect.jvm.internal.impl.descriptors.deserialization.AdditionalClassPartsProvider
 * JD-Core Version:    0.7.0.1
 */