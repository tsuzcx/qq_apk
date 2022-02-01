package org.aspectj.runtime.internal;

public final class Conversions
{
  public static Object booleanObject(boolean paramBoolean)
  {
    return new Boolean(paramBoolean);
  }
  
  public static boolean booleanValue(Object paramObject)
  {
    if (paramObject == null) {
      return false;
    }
    if ((paramObject instanceof Boolean)) {
      return ((Boolean)paramObject).booleanValue();
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramObject.getClass().getName());
    localStringBuilder.append(" can not be converted to boolean");
    throw new ClassCastException(localStringBuilder.toString());
  }
  
  public static Object byteObject(byte paramByte)
  {
    return new Byte(paramByte);
  }
  
  public static byte byteValue(Object paramObject)
  {
    if (paramObject == null) {
      return 0;
    }
    if ((paramObject instanceof Number)) {
      return ((Number)paramObject).byteValue();
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramObject.getClass().getName());
    localStringBuilder.append(" can not be converted to byte");
    throw new ClassCastException(localStringBuilder.toString());
  }
  
  public static Object charObject(char paramChar)
  {
    return new Character(paramChar);
  }
  
  public static char charValue(Object paramObject)
  {
    if (paramObject == null) {
      return '\000';
    }
    if ((paramObject instanceof Character)) {
      return ((Character)paramObject).charValue();
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramObject.getClass().getName());
    localStringBuilder.append(" can not be converted to char");
    throw new ClassCastException(localStringBuilder.toString());
  }
  
  public static Object doubleObject(double paramDouble)
  {
    return new Double(paramDouble);
  }
  
  public static double doubleValue(Object paramObject)
  {
    if (paramObject == null) {
      return 0.0D;
    }
    if ((paramObject instanceof Number)) {
      return ((Number)paramObject).doubleValue();
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramObject.getClass().getName());
    localStringBuilder.append(" can not be converted to double");
    throw new ClassCastException(localStringBuilder.toString());
  }
  
  public static Object floatObject(float paramFloat)
  {
    return new Float(paramFloat);
  }
  
  public static float floatValue(Object paramObject)
  {
    if (paramObject == null) {
      return 0.0F;
    }
    if ((paramObject instanceof Number)) {
      return ((Number)paramObject).floatValue();
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramObject.getClass().getName());
    localStringBuilder.append(" can not be converted to float");
    throw new ClassCastException(localStringBuilder.toString());
  }
  
  public static Object intObject(int paramInt)
  {
    return new Integer(paramInt);
  }
  
  public static int intValue(Object paramObject)
  {
    if (paramObject == null) {
      return 0;
    }
    if ((paramObject instanceof Number)) {
      return ((Number)paramObject).intValue();
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramObject.getClass().getName());
    localStringBuilder.append(" can not be converted to int");
    throw new ClassCastException(localStringBuilder.toString());
  }
  
  public static Object longObject(long paramLong)
  {
    return new Long(paramLong);
  }
  
  public static long longValue(Object paramObject)
  {
    if (paramObject == null) {
      return 0L;
    }
    if ((paramObject instanceof Number)) {
      return ((Number)paramObject).longValue();
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramObject.getClass().getName());
    localStringBuilder.append(" can not be converted to long");
    throw new ClassCastException(localStringBuilder.toString());
  }
  
  public static Object shortObject(short paramShort)
  {
    return new Short(paramShort);
  }
  
  public static short shortValue(Object paramObject)
  {
    if (paramObject == null) {
      return 0;
    }
    if ((paramObject instanceof Number)) {
      return ((Number)paramObject).shortValue();
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramObject.getClass().getName());
    localStringBuilder.append(" can not be converted to short");
    throw new ClassCastException(localStringBuilder.toString());
  }
  
  public static Object voidObject()
  {
    return null;
  }
  
  public static Object voidValue(Object paramObject)
  {
    if (paramObject == null) {}
    return paramObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     org.aspectj.runtime.internal.Conversions
 * JD-Core Version:    0.7.0.1
 */