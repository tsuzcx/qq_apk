package kotlin.reflect.jvm.internal.impl.load.java;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.AnnotationDescriptor;
import org.jetbrains.annotations.NotNull;

public final class AnnotationTypeQualifierResolver$TypeQualifierWithApplicability
{
  private final int applicability;
  private final AnnotationDescriptor typeQualifier;
  
  public AnnotationTypeQualifierResolver$TypeQualifierWithApplicability(@NotNull AnnotationDescriptor paramAnnotationDescriptor, int paramInt)
  {
    this.typeQualifier = paramAnnotationDescriptor;
    this.applicability = paramInt;
  }
  
  private final boolean isApplicableConsideringMask(AnnotationTypeQualifierResolver.QualifierApplicabilityType paramQualifierApplicabilityType)
  {
    int i = this.applicability;
    return (1 << paramQualifierApplicabilityType.ordinal() & i) != 0;
  }
  
  private final boolean isApplicableTo(AnnotationTypeQualifierResolver.QualifierApplicabilityType paramQualifierApplicabilityType)
  {
    return (isApplicableConsideringMask(AnnotationTypeQualifierResolver.QualifierApplicabilityType.TYPE_USE)) || (isApplicableConsideringMask(paramQualifierApplicabilityType));
  }
  
  @NotNull
  public final AnnotationDescriptor component1()
  {
    return this.typeQualifier;
  }
  
  @NotNull
  public final List<AnnotationTypeQualifierResolver.QualifierApplicabilityType> component2()
  {
    AnnotationTypeQualifierResolver.QualifierApplicabilityType[] arrayOfQualifierApplicabilityType = AnnotationTypeQualifierResolver.QualifierApplicabilityType.values();
    Collection localCollection = (Collection)new ArrayList();
    int j = arrayOfQualifierApplicabilityType.length;
    int i = 0;
    while (i < j)
    {
      AnnotationTypeQualifierResolver.QualifierApplicabilityType localQualifierApplicabilityType = arrayOfQualifierApplicabilityType[i];
      if (((TypeQualifierWithApplicability)this).isApplicableTo(localQualifierApplicabilityType)) {
        localCollection.add(localQualifierApplicabilityType);
      }
      i += 1;
    }
    return (List)localCollection;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     kotlin.reflect.jvm.internal.impl.load.java.AnnotationTypeQualifierResolver.TypeQualifierWithApplicability
 * JD-Core Version:    0.7.0.1
 */