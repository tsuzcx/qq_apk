package com.tencent.qa.apphook.util;

import com.android.dx.MethodId;
import com.android.dx.TypeId;

public class BasicTypeMethodUtil
{
  public static TypeId<Boolean> BooleanType;
  public static MethodId Boolean_value;
  public static TypeId<Byte> ByteType;
  public static MethodId Byte_value;
  public static MethodId Char_value;
  public static TypeId<Character> CharacterType;
  public static TypeId<Double> DoubleType;
  public static MethodId Double_value;
  public static TypeId<Float> FloatType;
  public static MethodId Float_value;
  public static TypeId<Integer> IntegerType = TypeId.get(Integer.class);
  public static MethodId Integer_value;
  public static TypeId<Long> LongType = TypeId.get(Long.class);
  public static MethodId Long_value;
  public static TypeId<Short> ShortType = TypeId.get(Short.class);
  public static MethodId Short_value;
  public static MethodId boolean_value;
  public static MethodId byte_value = ByteType.getMethod(TypeId.BYTE, "byteValue", new TypeId[0]);
  public static MethodId char_value = CharacterType.getMethod(TypeId.CHAR, "charValue", new TypeId[0]);
  public static MethodId double_value;
  public static MethodId float_value;
  public static MethodId int_value;
  public static MethodId long_value;
  public static MethodId short_value;
  
  static
  {
    DoubleType = TypeId.get(Double.class);
    BooleanType = TypeId.get(Boolean.class);
    FloatType = TypeId.get(Float.class);
    ByteType = TypeId.get(Byte.class);
    CharacterType = TypeId.get(Character.class);
    Integer_value = IntegerType.getMethod(IntegerType, "valueOf", new TypeId[] { TypeId.INT });
    Long_value = LongType.getMethod(LongType, "valueOf", new TypeId[] { TypeId.LONG });
    Short_value = ShortType.getMethod(ShortType, "valueOf", new TypeId[] { TypeId.SHORT });
    Double_value = DoubleType.getMethod(DoubleType, "valueOf", new TypeId[] { TypeId.DOUBLE });
    Boolean_value = BooleanType.getMethod(BooleanType, "valueOf", new TypeId[] { TypeId.BOOLEAN });
    Float_value = FloatType.getMethod(FloatType, "valueOf", new TypeId[] { TypeId.FLOAT });
    Byte_value = ByteType.getMethod(ByteType, "valueOf", new TypeId[] { TypeId.BYTE });
    Char_value = CharacterType.getMethod(CharacterType, "valueOf", new TypeId[] { TypeId.CHAR });
    int_value = IntegerType.getMethod(TypeId.INT, "intValue", new TypeId[0]);
    long_value = LongType.getMethod(TypeId.LONG, "longValue", new TypeId[0]);
    short_value = ShortType.getMethod(TypeId.SHORT, "shortValue", new TypeId[0]);
    double_value = DoubleType.getMethod(TypeId.DOUBLE, "doubleValue", new TypeId[0]);
    boolean_value = BooleanType.getMethod(TypeId.BOOLEAN, "booleanValue", new TypeId[0]);
    float_value = FloatType.getMethod(TypeId.FLOAT, "floatValue", new TypeId[0]);
  }
  
  public static BasicType getBasicTypeIfIs(Class<?> paramClass)
  {
    if (paramClass.equals(Boolean.TYPE)) {
      return BasicType.BOOLEAN;
    }
    if (paramClass.equals(Byte.TYPE)) {
      return BasicType.BYTE;
    }
    if (paramClass.equals(Character.TYPE)) {
      return BasicType.CHAR;
    }
    if (paramClass.equals(Short.TYPE)) {
      return BasicType.SHORT;
    }
    if (paramClass.equals(Integer.TYPE)) {
      return BasicType.INT;
    }
    if (paramClass.equals(Long.TYPE)) {
      return BasicType.LONG;
    }
    if (paramClass.equals(Float.TYPE)) {
      return BasicType.FLOAT;
    }
    if (paramClass.equals(Double.TYPE)) {
      return BasicType.DOUBLE;
    }
    if (paramClass.equals(Void.TYPE)) {
      return BasicType.VOID;
    }
    return null;
  }
  
  public static TypeId getClassTypeFromClass(Class paramClass)
  {
    if (paramClass.getName().equals(Integer.TYPE.getName())) {
      return IntegerType;
    }
    if (paramClass.getName().equals(Long.TYPE.getName())) {
      return LongType;
    }
    if (paramClass.getName().equals(Short.TYPE.getName())) {
      return ShortType;
    }
    if (paramClass.getName().equals(Double.TYPE.getName())) {
      return DoubleType;
    }
    if (paramClass.getName().equals(Boolean.TYPE.getName())) {
      return BooleanType;
    }
    if (paramClass.getName().equals(Float.TYPE.getName())) {
      return FloatType;
    }
    if (paramClass.getName().equals(Byte.TYPE.getName())) {
      return BooleanType;
    }
    if (paramClass.getName().equals(Character.TYPE.getName())) {
      return CharacterType;
    }
    return TypeId.get(paramClass);
  }
  
  public static Object getDefaultValue(Class paramClass)
  {
    if (paramClass.getName().equals(Integer.TYPE.getName())) {
      return Integer.valueOf(0);
    }
    if (paramClass.getName().equals(Long.TYPE.getName())) {
      return Long.valueOf(0L);
    }
    if (paramClass.getName().equals(Short.TYPE.getName())) {
      return Short.valueOf((short)0);
    }
    if (paramClass.getName().equals(Double.TYPE.getName())) {
      return Double.valueOf(0.0D);
    }
    if (paramClass.getName().equals(Boolean.TYPE.getName())) {
      return Boolean.FALSE;
    }
    if (paramClass.getName().equals(Float.TYPE.getName())) {
      return Float.valueOf(0.0F);
    }
    if (paramClass.getName().equals(Byte.TYPE.getName())) {
      return Byte.valueOf((byte)0);
    }
    if (paramClass.getName().equals(Character.TYPE.getName())) {
      return "";
    }
    return null;
  }
  
  public static TypeId getTypeIdFromClass(Class paramClass)
  {
    if (paramClass.getName().equals(Integer.TYPE.getName())) {
      return TypeId.INT;
    }
    if (paramClass.getName().equals(Long.TYPE.getName())) {
      return TypeId.LONG;
    }
    if (paramClass.getName().equals(Short.TYPE.getName())) {
      return TypeId.SHORT;
    }
    if (paramClass.getName().equals(Double.TYPE.getName())) {
      return TypeId.DOUBLE;
    }
    if (paramClass.getName().equals(Boolean.TYPE.getName())) {
      return TypeId.BOOLEAN;
    }
    if (paramClass.getName().equals(Float.TYPE.getName())) {
      return TypeId.FLOAT;
    }
    if (paramClass.getName().equals(Byte.TYPE.getName())) {
      return TypeId.BYTE;
    }
    if (paramClass.getName().equals(Character.TYPE.getName())) {
      return TypeId.CHAR;
    }
    if (paramClass.getName().equals(Void.TYPE.getName())) {
      return TypeId.VOID;
    }
    return TypeId.get(paramClass);
  }
  
  public static MethodId getValueFromClass(Class paramClass)
  {
    if (paramClass.getName().equals(Integer.TYPE.getName())) {
      return Integer_value;
    }
    if (paramClass.getName().equals(Long.TYPE.getName())) {
      return Long_value;
    }
    if (paramClass.getName().equals(Short.TYPE.getName())) {
      return Short_value;
    }
    if (paramClass.getName().equals(Double.TYPE.getName())) {
      return Double_value;
    }
    if (paramClass.getName().equals(Boolean.TYPE.getName())) {
      return Boolean_value;
    }
    if (paramClass.getName().equals(Float.TYPE.getName())) {
      return Float_value;
    }
    if (paramClass.getName().equals(Byte.TYPE.getName())) {
      return Byte_value;
    }
    if (paramClass.getName().equals(Character.TYPE.getName())) {
      return Char_value;
    }
    return null;
  }
  
  public static MethodId toValueFromClass(Class paramClass)
  {
    if (paramClass.getName().equals(Integer.TYPE.getName())) {
      return int_value;
    }
    if (paramClass.getName().equals(Long.TYPE.getName())) {
      return long_value;
    }
    if (paramClass.getName().equals(Short.TYPE.getName())) {
      return short_value;
    }
    if (paramClass.getName().equals(Double.TYPE.getName())) {
      return double_value;
    }
    if (paramClass.getName().equals(Boolean.TYPE.getName())) {
      return boolean_value;
    }
    if (paramClass.getName().equals(Float.TYPE.getName())) {
      return float_value;
    }
    if (paramClass.getName().equals(Byte.TYPE.getName())) {
      return byte_value;
    }
    if (paramClass.getName().equals(Character.TYPE.getName())) {
      return char_value;
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qa.apphook.util.BasicTypeMethodUtil
 * JD-Core Version:    0.7.0.1
 */