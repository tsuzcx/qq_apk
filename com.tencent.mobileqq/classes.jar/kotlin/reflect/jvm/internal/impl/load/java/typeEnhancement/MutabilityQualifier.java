package kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement;

public enum MutabilityQualifier
{
  static
  {
    MutabilityQualifier localMutabilityQualifier1 = new MutabilityQualifier("READ_ONLY", 0);
    READ_ONLY = localMutabilityQualifier1;
    MutabilityQualifier localMutabilityQualifier2 = new MutabilityQualifier("MUTABLE", 1);
    MUTABLE = localMutabilityQualifier2;
    $VALUES = new MutabilityQualifier[] { localMutabilityQualifier1, localMutabilityQualifier2 };
  }
  
  private MutabilityQualifier() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.MutabilityQualifier
 * JD-Core Version:    0.7.0.1
 */