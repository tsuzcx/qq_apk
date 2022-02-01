package kotlin.reflect.jvm.internal.impl.descriptors;

import java.util.List;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.types.TypeSubstitutor;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public abstract interface ConstructorDescriptor
  extends FunctionDescriptor
{
  @NotNull
  public abstract ClassDescriptor getConstructedClass();
  
  @NotNull
  public abstract ClassifierDescriptorWithTypeParameters getContainingDeclaration();
  
  @NotNull
  public abstract KotlinType getReturnType();
  
  @NotNull
  public abstract List<TypeParameterDescriptor> getTypeParameters();
  
  public abstract boolean isPrimary();
  
  @Nullable
  public abstract ConstructorDescriptor substitute(@NotNull TypeSubstitutor paramTypeSubstitutor);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     kotlin.reflect.jvm.internal.impl.descriptors.ConstructorDescriptor
 * JD-Core Version:    0.7.0.1
 */