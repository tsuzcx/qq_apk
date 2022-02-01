package kotlin.reflect.jvm.internal.impl.load.java.lazy;

import java.util.EnumMap;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.load.java.AnnotationTypeQualifierResolver.QualifierApplicabilityType;
import kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.JavaTypeQualifiers;
import kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.NullabilityQualifierWithMigrationStatus;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class JavaTypeQualifiersByElementType
{
  @NotNull
  private final EnumMap<AnnotationTypeQualifierResolver.QualifierApplicabilityType, NullabilityQualifierWithMigrationStatus> nullabilityQualifiers;
  
  public JavaTypeQualifiersByElementType(@NotNull EnumMap<AnnotationTypeQualifierResolver.QualifierApplicabilityType, NullabilityQualifierWithMigrationStatus> paramEnumMap)
  {
    this.nullabilityQualifiers = paramEnumMap;
  }
  
  @Nullable
  public final JavaTypeQualifiers get(@Nullable AnnotationTypeQualifierResolver.QualifierApplicabilityType paramQualifierApplicabilityType)
  {
    paramQualifierApplicabilityType = (NullabilityQualifierWithMigrationStatus)this.nullabilityQualifiers.get(paramQualifierApplicabilityType);
    if (paramQualifierApplicabilityType != null)
    {
      Intrinsics.checkExpressionValueIsNotNull(paramQualifierApplicabilityType, "nullabilityQualifiers[ap…ilityType] ?: return null");
      return new JavaTypeQualifiers(paramQualifierApplicabilityType.getQualifier(), null, false, paramQualifierApplicabilityType.isForWarningOnly());
    }
    return null;
  }
  
  @NotNull
  public final EnumMap<AnnotationTypeQualifierResolver.QualifierApplicabilityType, NullabilityQualifierWithMigrationStatus> getNullabilityQualifiers()
  {
    return this.nullabilityQualifiers;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     kotlin.reflect.jvm.internal.impl.load.java.lazy.JavaTypeQualifiersByElementType
 * JD-Core Version:    0.7.0.1
 */