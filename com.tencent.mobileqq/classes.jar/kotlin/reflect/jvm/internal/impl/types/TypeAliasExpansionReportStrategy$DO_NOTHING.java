package kotlin.reflect.jvm.internal.impl.types;

import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeAliasDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.AnnotationDescriptor;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class TypeAliasExpansionReportStrategy$DO_NOTHING
  implements TypeAliasExpansionReportStrategy
{
  public static final DO_NOTHING INSTANCE = new DO_NOTHING();
  
  public void boundsViolationInSubstitution(@NotNull KotlinType paramKotlinType1, @NotNull KotlinType paramKotlinType2, @NotNull KotlinType paramKotlinType3, @NotNull TypeParameterDescriptor paramTypeParameterDescriptor)
  {
    Intrinsics.checkParameterIsNotNull(paramKotlinType1, "bound");
    Intrinsics.checkParameterIsNotNull(paramKotlinType2, "unsubstitutedArgument");
    Intrinsics.checkParameterIsNotNull(paramKotlinType3, "argument");
    Intrinsics.checkParameterIsNotNull(paramTypeParameterDescriptor, "typeParameter");
  }
  
  public void conflictingProjection(@NotNull TypeAliasDescriptor paramTypeAliasDescriptor, @Nullable TypeParameterDescriptor paramTypeParameterDescriptor, @NotNull KotlinType paramKotlinType)
  {
    Intrinsics.checkParameterIsNotNull(paramTypeAliasDescriptor, "typeAlias");
    Intrinsics.checkParameterIsNotNull(paramKotlinType, "substitutedArgument");
  }
  
  public void recursiveTypeAlias(@NotNull TypeAliasDescriptor paramTypeAliasDescriptor)
  {
    Intrinsics.checkParameterIsNotNull(paramTypeAliasDescriptor, "typeAlias");
  }
  
  public void repeatedAnnotation(@NotNull AnnotationDescriptor paramAnnotationDescriptor)
  {
    Intrinsics.checkParameterIsNotNull(paramAnnotationDescriptor, "annotation");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     kotlin.reflect.jvm.internal.impl.types.TypeAliasExpansionReportStrategy.DO_NOTHING
 * JD-Core Version:    0.7.0.1
 */