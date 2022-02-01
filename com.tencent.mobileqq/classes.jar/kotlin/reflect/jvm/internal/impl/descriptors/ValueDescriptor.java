package kotlin.reflect.jvm.internal.impl.descriptors;

import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import org.jetbrains.annotations.NotNull;

public abstract interface ValueDescriptor
  extends CallableDescriptor
{
  @NotNull
  public abstract DeclarationDescriptor getContainingDeclaration();
  
  @NotNull
  public abstract KotlinType getType();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     kotlin.reflect.jvm.internal.impl.descriptors.ValueDescriptor
 * JD-Core Version:    0.7.0.1
 */