package kotlin.reflect.jvm.internal.impl.descriptors.deserialization;

import java.util.Collection;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.name.ClassId;
import kotlin.reflect.jvm.internal.impl.name.FqName;
import kotlin.reflect.jvm.internal.impl.name.Name;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public abstract interface ClassDescriptorFactory
{
  @Nullable
  public abstract ClassDescriptor createClass(@NotNull ClassId paramClassId);
  
  @NotNull
  public abstract Collection<ClassDescriptor> getAllContributedClassesIfPossible(@NotNull FqName paramFqName);
  
  public abstract boolean shouldCreateClass(@NotNull FqName paramFqName, @NotNull Name paramName);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     kotlin.reflect.jvm.internal.impl.descriptors.deserialization.ClassDescriptorFactory
 * JD-Core Version:    0.7.0.1
 */