package kotlin.reflect.jvm.internal.impl.load.java;

import kotlin.reflect.jvm.internal.impl.name.FqName;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.resolve.jvm.JvmClassName;

public final class JvmAnnotationNames
{
  public static final Name DEFAULT_ANNOTATION_MEMBER_NAME;
  public static final FqName DEFAULT_NULL_FQ_NAME = new FqName("kotlin.annotations.jvm.internal.DefaultNull");
  public static final FqName DEFAULT_VALUE_FQ_NAME;
  public static final FqName ENHANCED_MUTABILITY_ANNOTATION;
  public static final FqName ENHANCED_NULLABILITY_ANNOTATION;
  public static final FqName JETBRAINS_MUTABLE_ANNOTATION;
  public static final FqName JETBRAINS_NOT_NULL_ANNOTATION;
  public static final FqName JETBRAINS_NULLABLE_ANNOTATION;
  public static final FqName JETBRAINS_READONLY_ANNOTATION;
  public static final String METADATA_DESC;
  public static final FqName METADATA_FQ_NAME = new FqName("kotlin.Metadata");
  public static final FqName MUTABLE_ANNOTATION;
  public static final FqName PARAMETER_NAME_FQ_NAME;
  public static final FqName PURELY_IMPLEMENTS_ANNOTATION;
  public static final FqName READONLY_ANNOTATION;
  
  static
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("L");
    localStringBuilder.append(JvmClassName.byFqNameWithoutInnerClasses(METADATA_FQ_NAME).getInternalName());
    localStringBuilder.append(";");
    METADATA_DESC = localStringBuilder.toString();
    DEFAULT_ANNOTATION_MEMBER_NAME = Name.identifier("value");
    JETBRAINS_NOT_NULL_ANNOTATION = new FqName("org.jetbrains.annotations.NotNull");
    JETBRAINS_NULLABLE_ANNOTATION = new FqName("org.jetbrains.annotations.Nullable");
    JETBRAINS_MUTABLE_ANNOTATION = new FqName("org.jetbrains.annotations.Mutable");
    JETBRAINS_READONLY_ANNOTATION = new FqName("org.jetbrains.annotations.ReadOnly");
    READONLY_ANNOTATION = new FqName("kotlin.annotations.jvm.ReadOnly");
    MUTABLE_ANNOTATION = new FqName("kotlin.annotations.jvm.Mutable");
    PURELY_IMPLEMENTS_ANNOTATION = new FqName("kotlin.jvm.PurelyImplements");
    ENHANCED_NULLABILITY_ANNOTATION = new FqName("kotlin.jvm.internal.EnhancedNullability");
    ENHANCED_MUTABILITY_ANNOTATION = new FqName("kotlin.jvm.internal.EnhancedMutability");
    PARAMETER_NAME_FQ_NAME = new FqName("kotlin.annotations.jvm.internal.ParameterName");
    DEFAULT_VALUE_FQ_NAME = new FqName("kotlin.annotations.jvm.internal.DefaultValue");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     kotlin.reflect.jvm.internal.impl.load.java.JvmAnnotationNames
 * JD-Core Version:    0.7.0.1
 */