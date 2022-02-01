package kotlin.reflect.jvm.internal.impl.load.java;

import org.jetbrains.annotations.Nullable;

public enum BuiltinMethodsWithSpecialGenericSignature$SpecialSignatureInfo
{
  private final boolean isObjectReplacedWithTypeParameter;
  @Nullable
  private final String valueParametersSignature;
  
  static
  {
    SpecialSignatureInfo localSpecialSignatureInfo1 = new SpecialSignatureInfo("ONE_COLLECTION_PARAMETER", 0, "Ljava/util/Collection<+Ljava/lang/Object;>;", false);
    ONE_COLLECTION_PARAMETER = localSpecialSignatureInfo1;
    SpecialSignatureInfo localSpecialSignatureInfo2 = new SpecialSignatureInfo("OBJECT_PARAMETER_NON_GENERIC", 1, null, true);
    OBJECT_PARAMETER_NON_GENERIC = localSpecialSignatureInfo2;
    SpecialSignatureInfo localSpecialSignatureInfo3 = new SpecialSignatureInfo("OBJECT_PARAMETER_GENERIC", 2, "Ljava/lang/Object;", true);
    OBJECT_PARAMETER_GENERIC = localSpecialSignatureInfo3;
    $VALUES = new SpecialSignatureInfo[] { localSpecialSignatureInfo1, localSpecialSignatureInfo2, localSpecialSignatureInfo3 };
  }
  
  private BuiltinMethodsWithSpecialGenericSignature$SpecialSignatureInfo(String paramString, boolean paramBoolean)
  {
    this.valueParametersSignature = paramString;
    this.isObjectReplacedWithTypeParameter = paramBoolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     kotlin.reflect.jvm.internal.impl.load.java.BuiltinMethodsWithSpecialGenericSignature.SpecialSignatureInfo
 * JD-Core Version:    0.7.0.1
 */