package kotlin.reflect.jvm.internal.impl.descriptors;

public enum Modality
{
  public static final Modality.Companion Companion = new Modality.Companion(null);
  
  static
  {
    Modality localModality1 = new Modality("FINAL", 0);
    FINAL = localModality1;
    Modality localModality2 = new Modality("SEALED", 1);
    SEALED = localModality2;
    Modality localModality3 = new Modality("OPEN", 2);
    OPEN = localModality3;
    Modality localModality4 = new Modality("ABSTRACT", 3);
    ABSTRACT = localModality4;
    $VALUES = new Modality[] { localModality1, localModality2, localModality3, localModality4 };
  }
  
  private Modality() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     kotlin.reflect.jvm.internal.impl.descriptors.Modality
 * JD-Core Version:    0.7.0.1
 */