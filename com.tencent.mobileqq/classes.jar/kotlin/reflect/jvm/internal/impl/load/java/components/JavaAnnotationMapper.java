package kotlin.reflect.jvm.internal.impl.load.java.components;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;
import java.util.Map;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.builtins.KotlinBuiltIns;
import kotlin.reflect.jvm.internal.impl.builtins.KotlinBuiltIns.FqNames;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.AnnotationDescriptor;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.LazyJavaResolverContext;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaAnnotationDescriptor;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaAnnotation;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaAnnotationOwner;
import kotlin.reflect.jvm.internal.impl.name.ClassId;
import kotlin.reflect.jvm.internal.impl.name.FqName;
import kotlin.reflect.jvm.internal.impl.name.Name;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class JavaAnnotationMapper
{
  @NotNull
  private static final Name DEPRECATED_ANNOTATION_MESSAGE;
  public static final JavaAnnotationMapper INSTANCE = new JavaAnnotationMapper();
  private static final FqName JAVA_DEPRECATED_FQ_NAME;
  private static final FqName JAVA_DOCUMENTED_FQ_NAME;
  private static final FqName JAVA_REPEATABLE_FQ_NAME;
  private static final FqName JAVA_RETENTION_FQ_NAME;
  private static final FqName JAVA_TARGET_FQ_NAME = new FqName(Target.class.getCanonicalName());
  @NotNull
  private static final Name RETENTION_ANNOTATION_VALUE;
  @NotNull
  private static final Name TARGET_ANNOTATION_ALLOWED_TARGETS;
  @NotNull
  private static final Map<FqName, FqName> javaToKotlinNameMap = MapsKt.mapOf(new Pair[] { TuplesKt.to(JAVA_TARGET_FQ_NAME, KotlinBuiltIns.FQ_NAMES.target), TuplesKt.to(JAVA_RETENTION_FQ_NAME, KotlinBuiltIns.FQ_NAMES.retention), TuplesKt.to(JAVA_DEPRECATED_FQ_NAME, KotlinBuiltIns.FQ_NAMES.deprecated), TuplesKt.to(JAVA_REPEATABLE_FQ_NAME, KotlinBuiltIns.FQ_NAMES.repeatable), TuplesKt.to(JAVA_DOCUMENTED_FQ_NAME, KotlinBuiltIns.FQ_NAMES.mustBeDocumented) });
  private static final Map<FqName, FqName> kotlinToJavaNameMap;
  
  static
  {
    JAVA_RETENTION_FQ_NAME = new FqName(Retention.class.getCanonicalName());
    JAVA_DEPRECATED_FQ_NAME = new FqName(Deprecated.class.getCanonicalName());
    JAVA_DOCUMENTED_FQ_NAME = new FqName(Documented.class.getCanonicalName());
    JAVA_REPEATABLE_FQ_NAME = new FqName("java.lang.annotation.Repeatable");
    Name localName = Name.identifier("message");
    Intrinsics.checkExpressionValueIsNotNull(localName, "Name.identifier(\"message\")");
    DEPRECATED_ANNOTATION_MESSAGE = localName;
    localName = Name.identifier("allowedTargets");
    Intrinsics.checkExpressionValueIsNotNull(localName, "Name.identifier(\"allowedTargets\")");
    TARGET_ANNOTATION_ALLOWED_TARGETS = localName;
    localName = Name.identifier("value");
    Intrinsics.checkExpressionValueIsNotNull(localName, "Name.identifier(\"value\")");
    RETENTION_ANNOTATION_VALUE = localName;
    kotlinToJavaNameMap = MapsKt.mapOf(new Pair[] { TuplesKt.to(KotlinBuiltIns.FQ_NAMES.target, JAVA_TARGET_FQ_NAME), TuplesKt.to(KotlinBuiltIns.FQ_NAMES.retention, JAVA_RETENTION_FQ_NAME), TuplesKt.to(KotlinBuiltIns.FQ_NAMES.repeatable, JAVA_REPEATABLE_FQ_NAME), TuplesKt.to(KotlinBuiltIns.FQ_NAMES.mustBeDocumented, JAVA_DOCUMENTED_FQ_NAME) });
  }
  
  @Nullable
  public final AnnotationDescriptor findMappedJavaAnnotation(@NotNull FqName paramFqName, @NotNull JavaAnnotationOwner paramJavaAnnotationOwner, @NotNull LazyJavaResolverContext paramLazyJavaResolverContext)
  {
    Intrinsics.checkParameterIsNotNull(paramFqName, "kotlinName");
    Intrinsics.checkParameterIsNotNull(paramJavaAnnotationOwner, "annotationOwner");
    Intrinsics.checkParameterIsNotNull(paramLazyJavaResolverContext, "c");
    if (Intrinsics.areEqual(paramFqName, KotlinBuiltIns.FQ_NAMES.deprecated))
    {
      localJavaAnnotation = paramJavaAnnotationOwner.findAnnotation(JAVA_DEPRECATED_FQ_NAME);
      if ((localJavaAnnotation != null) || (paramJavaAnnotationOwner.isDeprecatedInJavaDoc())) {
        return (AnnotationDescriptor)new JavaDeprecatedAnnotationDescriptor(localJavaAnnotation, paramLazyJavaResolverContext);
      }
    }
    FqName localFqName = (FqName)kotlinToJavaNameMap.get(paramFqName);
    JavaAnnotation localJavaAnnotation = null;
    paramFqName = localJavaAnnotation;
    if (localFqName != null)
    {
      paramJavaAnnotationOwner = paramJavaAnnotationOwner.findAnnotation(localFqName);
      paramFqName = localJavaAnnotation;
      if (paramJavaAnnotationOwner != null) {
        paramFqName = INSTANCE.mapOrResolveJavaAnnotation(paramJavaAnnotationOwner, paramLazyJavaResolverContext);
      }
    }
    return paramFqName;
  }
  
  @NotNull
  public final Name getDEPRECATED_ANNOTATION_MESSAGE$descriptors_jvm()
  {
    return DEPRECATED_ANNOTATION_MESSAGE;
  }
  
  @NotNull
  public final Name getRETENTION_ANNOTATION_VALUE$descriptors_jvm()
  {
    return RETENTION_ANNOTATION_VALUE;
  }
  
  @NotNull
  public final Name getTARGET_ANNOTATION_ALLOWED_TARGETS$descriptors_jvm()
  {
    return TARGET_ANNOTATION_ALLOWED_TARGETS;
  }
  
  @Nullable
  public final AnnotationDescriptor mapOrResolveJavaAnnotation(@NotNull JavaAnnotation paramJavaAnnotation, @NotNull LazyJavaResolverContext paramLazyJavaResolverContext)
  {
    Intrinsics.checkParameterIsNotNull(paramJavaAnnotation, "annotation");
    Intrinsics.checkParameterIsNotNull(paramLazyJavaResolverContext, "c");
    Object localObject = paramJavaAnnotation.getClassId();
    if (Intrinsics.areEqual(localObject, ClassId.topLevel(JAVA_TARGET_FQ_NAME))) {
      return (AnnotationDescriptor)new JavaTargetAnnotationDescriptor(paramJavaAnnotation, paramLazyJavaResolverContext);
    }
    if (Intrinsics.areEqual(localObject, ClassId.topLevel(JAVA_RETENTION_FQ_NAME))) {
      return (AnnotationDescriptor)new JavaRetentionAnnotationDescriptor(paramJavaAnnotation, paramLazyJavaResolverContext);
    }
    if (Intrinsics.areEqual(localObject, ClassId.topLevel(JAVA_REPEATABLE_FQ_NAME)))
    {
      localObject = KotlinBuiltIns.FQ_NAMES.repeatable;
      Intrinsics.checkExpressionValueIsNotNull(localObject, "KotlinBuiltIns.FQ_NAMES.repeatable");
      return (AnnotationDescriptor)new JavaAnnotationDescriptor(paramLazyJavaResolverContext, paramJavaAnnotation, (FqName)localObject);
    }
    if (Intrinsics.areEqual(localObject, ClassId.topLevel(JAVA_DOCUMENTED_FQ_NAME)))
    {
      localObject = KotlinBuiltIns.FQ_NAMES.mustBeDocumented;
      Intrinsics.checkExpressionValueIsNotNull(localObject, "KotlinBuiltIns.FQ_NAMES.mustBeDocumented");
      return (AnnotationDescriptor)new JavaAnnotationDescriptor(paramLazyJavaResolverContext, paramJavaAnnotation, (FqName)localObject);
    }
    if (Intrinsics.areEqual(localObject, ClassId.topLevel(JAVA_DEPRECATED_FQ_NAME))) {
      return null;
    }
    return (AnnotationDescriptor)new LazyJavaAnnotationDescriptor(paramLazyJavaResolverContext, paramJavaAnnotation);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     kotlin.reflect.jvm.internal.impl.load.java.components.JavaAnnotationMapper
 * JD-Core Version:    0.7.0.1
 */