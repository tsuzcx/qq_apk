package kotlin.reflect.jvm.internal.impl.load.java;

public enum AnnotationTypeQualifierResolver$QualifierApplicabilityType
{
  static
  {
    QualifierApplicabilityType localQualifierApplicabilityType1 = new QualifierApplicabilityType("METHOD_RETURN_TYPE", 0);
    METHOD_RETURN_TYPE = localQualifierApplicabilityType1;
    QualifierApplicabilityType localQualifierApplicabilityType2 = new QualifierApplicabilityType("VALUE_PARAMETER", 1);
    VALUE_PARAMETER = localQualifierApplicabilityType2;
    QualifierApplicabilityType localQualifierApplicabilityType3 = new QualifierApplicabilityType("FIELD", 2);
    FIELD = localQualifierApplicabilityType3;
    QualifierApplicabilityType localQualifierApplicabilityType4 = new QualifierApplicabilityType("TYPE_USE", 3);
    TYPE_USE = localQualifierApplicabilityType4;
    $VALUES = new QualifierApplicabilityType[] { localQualifierApplicabilityType1, localQualifierApplicabilityType2, localQualifierApplicabilityType3, localQualifierApplicabilityType4 };
  }
  
  private AnnotationTypeQualifierResolver$QualifierApplicabilityType() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     kotlin.reflect.jvm.internal.impl.load.java.AnnotationTypeQualifierResolver.QualifierApplicabilityType
 * JD-Core Version:    0.7.0.1
 */