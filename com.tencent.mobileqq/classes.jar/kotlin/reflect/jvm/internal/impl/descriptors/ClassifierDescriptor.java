package kotlin.reflect.jvm.internal.impl.descriptors;

import kotlin.reflect.jvm.internal.impl.types.SimpleType;
import kotlin.reflect.jvm.internal.impl.types.TypeConstructor;
import org.jetbrains.annotations.NotNull;

public abstract interface ClassifierDescriptor
  extends DeclarationDescriptorNonRoot
{
  @NotNull
  public abstract SimpleType getDefaultType();
  
  @NotNull
  public abstract ClassifierDescriptor getOriginal();
  
  @NotNull
  public abstract TypeConstructor getTypeConstructor();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor
 * JD-Core Version:    0.7.0.1
 */