package kotlin.reflect.jvm.internal.impl.load.java.lazy;

import java.util.Collection;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.load.java.AnnotationTypeQualifierResolver.QualifierApplicabilityType;
import kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.NullabilityQualifierWithMigrationStatus;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class NullabilityQualifierWithApplicability
{
  @NotNull
  private final NullabilityQualifierWithMigrationStatus nullabilityQualifier;
  @NotNull
  private final Collection<AnnotationTypeQualifierResolver.QualifierApplicabilityType> qualifierApplicabilityTypes;
  
  public NullabilityQualifierWithApplicability(@NotNull NullabilityQualifierWithMigrationStatus paramNullabilityQualifierWithMigrationStatus, @NotNull Collection<? extends AnnotationTypeQualifierResolver.QualifierApplicabilityType> paramCollection)
  {
    this.nullabilityQualifier = paramNullabilityQualifierWithMigrationStatus;
    this.qualifierApplicabilityTypes = paramCollection;
  }
  
  @NotNull
  public final NullabilityQualifierWithMigrationStatus component1()
  {
    return this.nullabilityQualifier;
  }
  
  @NotNull
  public final Collection<AnnotationTypeQualifierResolver.QualifierApplicabilityType> component2()
  {
    return this.qualifierApplicabilityTypes;
  }
  
  public boolean equals(@Nullable Object paramObject)
  {
    if (this != paramObject) {
      if ((paramObject instanceof NullabilityQualifierWithApplicability))
      {
        paramObject = (NullabilityQualifierWithApplicability)paramObject;
        if ((Intrinsics.areEqual(this.nullabilityQualifier, paramObject.nullabilityQualifier)) && (Intrinsics.areEqual(this.qualifierApplicabilityTypes, paramObject.qualifierApplicabilityTypes))) {}
      }
      else
      {
        return false;
      }
    }
    return true;
  }
  
  public int hashCode()
  {
    Object localObject = this.nullabilityQualifier;
    int j = 0;
    int i;
    if (localObject != null) {
      i = localObject.hashCode();
    } else {
      i = 0;
    }
    localObject = this.qualifierApplicabilityTypes;
    if (localObject != null) {
      j = localObject.hashCode();
    }
    return i * 31 + j;
  }
  
  @NotNull
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("NullabilityQualifierWithApplicability(nullabilityQualifier=");
    localStringBuilder.append(this.nullabilityQualifier);
    localStringBuilder.append(", qualifierApplicabilityTypes=");
    localStringBuilder.append(this.qualifierApplicabilityTypes);
    localStringBuilder.append(")");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     kotlin.reflect.jvm.internal.impl.load.java.lazy.NullabilityQualifierWithApplicability
 * JD-Core Version:    0.7.0.1
 */