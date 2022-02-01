package kotlin.reflect.jvm.internal.impl.descriptors.impl;

import kotlin.reflect.jvm.internal.impl.descriptors.ClassConstructorDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ConstructorDescriptor;
import org.jetbrains.annotations.NotNull;

public abstract interface TypeAliasConstructorDescriptor
  extends ConstructorDescriptor
{
  @NotNull
  public abstract ClassConstructorDescriptor getUnderlyingConstructorDescriptor();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     kotlin.reflect.jvm.internal.impl.descriptors.impl.TypeAliasConstructorDescriptor
 * JD-Core Version:    0.7.0.1
 */