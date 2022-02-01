package kotlin.reflect.jvm.internal.impl.load.java;

import org.jetbrains.annotations.Nullable;

public enum BuiltinMethodsWithSpecialGenericSignature$TypeSafeBarrierDescription
{
  @Nullable
  private final Object defaultValue;
  
  static
  {
    TypeSafeBarrierDescription localTypeSafeBarrierDescription1 = new TypeSafeBarrierDescription("NULL", 0, null);
    NULL = localTypeSafeBarrierDescription1;
    TypeSafeBarrierDescription localTypeSafeBarrierDescription2 = new TypeSafeBarrierDescription("INDEX", 1, Integer.valueOf(-1));
    INDEX = localTypeSafeBarrierDescription2;
    TypeSafeBarrierDescription localTypeSafeBarrierDescription3 = new TypeSafeBarrierDescription("FALSE", 2, Boolean.valueOf(false));
    FALSE = localTypeSafeBarrierDescription3;
    BuiltinMethodsWithSpecialGenericSignature.TypeSafeBarrierDescription.MAP_GET_OR_DEFAULT localMAP_GET_OR_DEFAULT = new BuiltinMethodsWithSpecialGenericSignature.TypeSafeBarrierDescription.MAP_GET_OR_DEFAULT("MAP_GET_OR_DEFAULT", 3);
    MAP_GET_OR_DEFAULT = localMAP_GET_OR_DEFAULT;
    $VALUES = new TypeSafeBarrierDescription[] { localTypeSafeBarrierDescription1, localTypeSafeBarrierDescription2, localTypeSafeBarrierDescription3, localMAP_GET_OR_DEFAULT };
  }
  
  private BuiltinMethodsWithSpecialGenericSignature$TypeSafeBarrierDescription(Object paramObject)
  {
    this.defaultValue = paramObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     kotlin.reflect.jvm.internal.impl.load.java.BuiltinMethodsWithSpecialGenericSignature.TypeSafeBarrierDescription
 * JD-Core Version:    0.7.0.1
 */