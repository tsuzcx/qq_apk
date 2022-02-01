package kotlin.reflect.jvm.internal.impl.types;

public enum AbstractTypeCheckerContext$LowerCapturedTypePolicy
{
  static
  {
    LowerCapturedTypePolicy localLowerCapturedTypePolicy1 = new LowerCapturedTypePolicy("CHECK_ONLY_LOWER", 0);
    CHECK_ONLY_LOWER = localLowerCapturedTypePolicy1;
    LowerCapturedTypePolicy localLowerCapturedTypePolicy2 = new LowerCapturedTypePolicy("CHECK_SUBTYPE_AND_LOWER", 1);
    CHECK_SUBTYPE_AND_LOWER = localLowerCapturedTypePolicy2;
    LowerCapturedTypePolicy localLowerCapturedTypePolicy3 = new LowerCapturedTypePolicy("SKIP_LOWER", 2);
    SKIP_LOWER = localLowerCapturedTypePolicy3;
    $VALUES = new LowerCapturedTypePolicy[] { localLowerCapturedTypePolicy1, localLowerCapturedTypePolicy2, localLowerCapturedTypePolicy3 };
  }
  
  private AbstractTypeCheckerContext$LowerCapturedTypePolicy() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     kotlin.reflect.jvm.internal.impl.types.AbstractTypeCheckerContext.LowerCapturedTypePolicy
 * JD-Core Version:    0.7.0.1
 */