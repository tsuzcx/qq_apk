package shark;

import kotlin.Metadata;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lshark/LeakTraceObject$ObjectType;", "", "(Ljava/lang/String;I)V", "CLASS", "ARRAY", "INSTANCE", "shark"}, k=1, mv={1, 4, 1})
public enum LeakTraceObject$ObjectType
{
  static
  {
    ObjectType localObjectType1 = new ObjectType("CLASS", 0);
    CLASS = localObjectType1;
    ObjectType localObjectType2 = new ObjectType("ARRAY", 1);
    ARRAY = localObjectType2;
    ObjectType localObjectType3 = new ObjectType("INSTANCE", 2);
    INSTANCE = localObjectType3;
    $VALUES = new ObjectType[] { localObjectType1, localObjectType2, localObjectType3 };
  }
  
  private LeakTraceObject$ObjectType() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     shark.LeakTraceObject.ObjectType
 * JD-Core Version:    0.7.0.1
 */