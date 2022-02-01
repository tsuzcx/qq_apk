package shark;

import kotlin.Metadata;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lshark/LeakTraceReference$ReferenceType;", "", "(Ljava/lang/String;I)V", "INSTANCE_FIELD", "STATIC_FIELD", "LOCAL", "ARRAY_ENTRY", "shark"}, k=1, mv={1, 4, 1})
public enum LeakTraceReference$ReferenceType
{
  static
  {
    ReferenceType localReferenceType1 = new ReferenceType("INSTANCE_FIELD", 0);
    INSTANCE_FIELD = localReferenceType1;
    ReferenceType localReferenceType2 = new ReferenceType("STATIC_FIELD", 1);
    STATIC_FIELD = localReferenceType2;
    ReferenceType localReferenceType3 = new ReferenceType("LOCAL", 2);
    LOCAL = localReferenceType3;
    ReferenceType localReferenceType4 = new ReferenceType("ARRAY_ENTRY", 3);
    ARRAY_ENTRY = localReferenceType4;
    $VALUES = new ReferenceType[] { localReferenceType1, localReferenceType2, localReferenceType3, localReferenceType4 };
  }
  
  private LeakTraceReference$ReferenceType() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     shark.LeakTraceReference.ReferenceType
 * JD-Core Version:    0.7.0.1
 */