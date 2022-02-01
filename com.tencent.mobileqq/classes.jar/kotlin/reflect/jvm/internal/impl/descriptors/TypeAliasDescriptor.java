package kotlin.reflect.jvm.internal.impl.descriptors;

import kotlin.reflect.jvm.internal.impl.types.SimpleType;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public abstract interface TypeAliasDescriptor
  extends ClassifierDescriptorWithTypeParameters
{
  @Nullable
  public abstract ClassDescriptor getClassDescriptor();
  
  @NotNull
  public abstract SimpleType getExpandedType();
  
  @NotNull
  public abstract SimpleType getUnderlyingType();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     kotlin.reflect.jvm.internal.impl.descriptors.TypeAliasDescriptor
 * JD-Core Version:    0.7.0.1
 */