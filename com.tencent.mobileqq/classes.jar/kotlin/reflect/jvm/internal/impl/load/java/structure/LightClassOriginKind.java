package kotlin.reflect.jvm.internal.impl.load.java.structure;

public enum LightClassOriginKind
{
  static
  {
    LightClassOriginKind localLightClassOriginKind1 = new LightClassOriginKind("SOURCE", 0);
    SOURCE = localLightClassOriginKind1;
    LightClassOriginKind localLightClassOriginKind2 = new LightClassOriginKind("BINARY", 1);
    BINARY = localLightClassOriginKind2;
    $VALUES = new LightClassOriginKind[] { localLightClassOriginKind1, localLightClassOriginKind2 };
  }
  
  private LightClassOriginKind() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     kotlin.reflect.jvm.internal.impl.load.java.structure.LightClassOriginKind
 * JD-Core Version:    0.7.0.1
 */