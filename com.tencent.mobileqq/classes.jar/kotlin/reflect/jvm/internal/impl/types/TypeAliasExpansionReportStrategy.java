package kotlin.reflect.jvm.internal.impl.types;

import kotlin.reflect.jvm.internal.impl.descriptors.TypeAliasDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.AnnotationDescriptor;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public abstract interface TypeAliasExpansionReportStrategy
{
  public abstract void boundsViolationInSubstitution(@NotNull KotlinType paramKotlinType1, @NotNull KotlinType paramKotlinType2, @NotNull KotlinType paramKotlinType3, @NotNull TypeParameterDescriptor paramTypeParameterDescriptor);
  
  public abstract void conflictingProjection(@NotNull TypeAliasDescriptor paramTypeAliasDescriptor, @Nullable TypeParameterDescriptor paramTypeParameterDescriptor, @NotNull KotlinType paramKotlinType);
  
  public abstract void recursiveTypeAlias(@NotNull TypeAliasDescriptor paramTypeAliasDescriptor);
  
  public abstract void repeatedAnnotation(@NotNull AnnotationDescriptor paramAnnotationDescriptor);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     kotlin.reflect.jvm.internal.impl.types.TypeAliasExpansionReportStrategy
 * JD-Core Version:    0.7.0.1
 */