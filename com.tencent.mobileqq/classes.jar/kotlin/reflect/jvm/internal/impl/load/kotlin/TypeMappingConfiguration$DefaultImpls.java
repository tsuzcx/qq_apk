package kotlin.reflect.jvm.internal.impl.load.kotlin;

import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class TypeMappingConfiguration$DefaultImpls
{
  @Nullable
  public static <T> String getPredefinedFullInternalNameForClass(TypeMappingConfiguration<? extends T> paramTypeMappingConfiguration, @NotNull ClassDescriptor paramClassDescriptor)
  {
    Intrinsics.checkParameterIsNotNull(paramClassDescriptor, "classDescriptor");
    return null;
  }
  
  @Nullable
  public static <T> KotlinType preprocessType(TypeMappingConfiguration<? extends T> paramTypeMappingConfiguration, @NotNull KotlinType paramKotlinType)
  {
    Intrinsics.checkParameterIsNotNull(paramKotlinType, "kotlinType");
    return null;
  }
  
  public static <T> boolean releaseCoroutines(TypeMappingConfiguration<? extends T> paramTypeMappingConfiguration)
  {
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     kotlin.reflect.jvm.internal.impl.load.kotlin.TypeMappingConfiguration.DefaultImpls
 * JD-Core Version:    0.7.0.1
 */