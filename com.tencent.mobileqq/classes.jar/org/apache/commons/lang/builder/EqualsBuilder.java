package org.apache.commons.lang.builder;

import java.lang.reflect.AccessibleObject;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.Collection;
import org.apache.commons.lang.ArrayUtils;

public class EqualsBuilder
{
  private boolean isEquals = true;
  
  private static void reflectionAppend(Object paramObject1, Object paramObject2, Class paramClass, EqualsBuilder paramEqualsBuilder, boolean paramBoolean, String[] paramArrayOfString)
  {
    paramClass = paramClass.getDeclaredFields();
    AccessibleObject.setAccessible(paramClass, true);
    int i = 0;
    while ((i < paramClass.length) && (paramEqualsBuilder.isEquals))
    {
      Object localObject = paramClass[i];
      if ((!ArrayUtils.contains(paramArrayOfString, localObject.getName())) && (localObject.getName().indexOf('$') == -1) && ((paramBoolean) || (!Modifier.isTransient(localObject.getModifiers()))) && (!Modifier.isStatic(localObject.getModifiers()))) {}
      try
      {
        paramEqualsBuilder.append(localObject.get(paramObject1), localObject.get(paramObject2));
      }
      catch (IllegalAccessException paramObject1)
      {
        label107:
        break label107;
      }
      throw new InternalError("Unexpected IllegalAccessException");
      i += 1;
    }
  }
  
  public static boolean reflectionEquals(Object paramObject1, Object paramObject2)
  {
    return reflectionEquals(paramObject1, paramObject2, false, null, null);
  }
  
  public static boolean reflectionEquals(Object paramObject1, Object paramObject2, Collection paramCollection)
  {
    return reflectionEquals(paramObject1, paramObject2, ReflectionToStringBuilder.toNoNullStringArray(paramCollection));
  }
  
  public static boolean reflectionEquals(Object paramObject1, Object paramObject2, boolean paramBoolean)
  {
    return reflectionEquals(paramObject1, paramObject2, paramBoolean, null, null);
  }
  
  public static boolean reflectionEquals(Object paramObject1, Object paramObject2, boolean paramBoolean, Class paramClass)
  {
    return reflectionEquals(paramObject1, paramObject2, paramBoolean, paramClass, null);
  }
  
  public static boolean reflectionEquals(Object paramObject1, Object paramObject2, boolean paramBoolean, Class paramClass, String[] paramArrayOfString)
  {
    if (paramObject1 == paramObject2) {
      return true;
    }
    Object localObject1;
    Object localObject2;
    if (paramObject1 != null)
    {
      if (paramObject2 == null) {
        return false;
      }
      localObject1 = paramObject1.getClass();
      localObject2 = paramObject2.getClass();
      if (((Class)localObject1).isInstance(paramObject2))
      {
        if (((Class)localObject2).isInstance(paramObject1)) {
          break label75;
        }
      }
      else
      {
        if (!((Class)localObject2).isInstance(paramObject1)) {
          break label138;
        }
        if (!((Class)localObject1).isInstance(paramObject2)) {
          break label75;
        }
      }
      localObject1 = localObject2;
      label75:
      localObject2 = new EqualsBuilder();
    }
    label138:
    try
    {
      reflectionAppend(paramObject1, paramObject2, (Class)localObject1, (EqualsBuilder)localObject2, paramBoolean, paramArrayOfString);
      while ((((Class)localObject1).getSuperclass() != null) && (localObject1 != paramClass))
      {
        localObject1 = ((Class)localObject1).getSuperclass();
        reflectionAppend(paramObject1, paramObject2, (Class)localObject1, (EqualsBuilder)localObject2, paramBoolean, paramArrayOfString);
      }
      return ((EqualsBuilder)localObject2).isEquals();
    }
    catch (IllegalArgumentException paramObject1) {}
    return false;
    return false;
  }
  
  public static boolean reflectionEquals(Object paramObject1, Object paramObject2, String[] paramArrayOfString)
  {
    return reflectionEquals(paramObject1, paramObject2, false, null, paramArrayOfString);
  }
  
  public EqualsBuilder append(byte paramByte1, byte paramByte2)
  {
    if (!this.isEquals) {
      return this;
    }
    boolean bool;
    if (paramByte1 == paramByte2) {
      bool = true;
    } else {
      bool = false;
    }
    this.isEquals = bool;
    return this;
  }
  
  public EqualsBuilder append(char paramChar1, char paramChar2)
  {
    if (!this.isEquals) {
      return this;
    }
    boolean bool;
    if (paramChar1 == paramChar2) {
      bool = true;
    } else {
      bool = false;
    }
    this.isEquals = bool;
    return this;
  }
  
  public EqualsBuilder append(double paramDouble1, double paramDouble2)
  {
    if (!this.isEquals) {
      return this;
    }
    return append(Double.doubleToLongBits(paramDouble1), Double.doubleToLongBits(paramDouble2));
  }
  
  public EqualsBuilder append(float paramFloat1, float paramFloat2)
  {
    if (!this.isEquals) {
      return this;
    }
    return append(Float.floatToIntBits(paramFloat1), Float.floatToIntBits(paramFloat2));
  }
  
  public EqualsBuilder append(int paramInt1, int paramInt2)
  {
    if (!this.isEquals) {
      return this;
    }
    boolean bool;
    if (paramInt1 == paramInt2) {
      bool = true;
    } else {
      bool = false;
    }
    this.isEquals = bool;
    return this;
  }
  
  public EqualsBuilder append(long paramLong1, long paramLong2)
  {
    if (!this.isEquals) {
      return this;
    }
    boolean bool;
    if (paramLong1 == paramLong2) {
      bool = true;
    } else {
      bool = false;
    }
    this.isEquals = bool;
    return this;
  }
  
  public EqualsBuilder append(Object paramObject1, Object paramObject2)
  {
    if (!this.isEquals) {
      return this;
    }
    if (paramObject1 == paramObject2) {
      return this;
    }
    if ((paramObject1 != null) && (paramObject2 != null))
    {
      if (!paramObject1.getClass().isArray())
      {
        this.isEquals = paramObject1.equals(paramObject2);
        return this;
      }
      if (paramObject1.getClass() != paramObject2.getClass())
      {
        setEquals(false);
        return this;
      }
      if ((paramObject1 instanceof long[]))
      {
        append((long[])paramObject1, (long[])paramObject2);
        return this;
      }
      if ((paramObject1 instanceof int[]))
      {
        append((int[])paramObject1, (int[])paramObject2);
        return this;
      }
      if ((paramObject1 instanceof short[]))
      {
        append((short[])paramObject1, (short[])paramObject2);
        return this;
      }
      if ((paramObject1 instanceof char[]))
      {
        append((char[])paramObject1, (char[])paramObject2);
        return this;
      }
      if ((paramObject1 instanceof byte[]))
      {
        append((byte[])paramObject1, (byte[])paramObject2);
        return this;
      }
      if ((paramObject1 instanceof double[]))
      {
        append((double[])paramObject1, (double[])paramObject2);
        return this;
      }
      if ((paramObject1 instanceof float[]))
      {
        append((float[])paramObject1, (float[])paramObject2);
        return this;
      }
      if ((paramObject1 instanceof boolean[]))
      {
        append((boolean[])paramObject1, (boolean[])paramObject2);
        return this;
      }
      append((Object[])paramObject1, (Object[])paramObject2);
      return this;
    }
    setEquals(false);
    return this;
  }
  
  public EqualsBuilder append(short paramShort1, short paramShort2)
  {
    if (!this.isEquals) {
      return this;
    }
    boolean bool;
    if (paramShort1 == paramShort2) {
      bool = true;
    } else {
      bool = false;
    }
    this.isEquals = bool;
    return this;
  }
  
  public EqualsBuilder append(boolean paramBoolean1, boolean paramBoolean2)
  {
    if (!this.isEquals) {
      return this;
    }
    if (paramBoolean1 == paramBoolean2) {
      paramBoolean1 = true;
    } else {
      paramBoolean1 = false;
    }
    this.isEquals = paramBoolean1;
    return this;
  }
  
  public EqualsBuilder append(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2)
  {
    if (!this.isEquals) {
      return this;
    }
    if (paramArrayOfByte1 == paramArrayOfByte2) {
      return this;
    }
    int i = 0;
    if ((paramArrayOfByte1 != null) && (paramArrayOfByte2 != null))
    {
      if (paramArrayOfByte1.length != paramArrayOfByte2.length)
      {
        setEquals(false);
        return this;
      }
      while ((i < paramArrayOfByte1.length) && (this.isEquals))
      {
        append(paramArrayOfByte1[i], paramArrayOfByte2[i]);
        i += 1;
      }
      return this;
    }
    setEquals(false);
    return this;
  }
  
  public EqualsBuilder append(char[] paramArrayOfChar1, char[] paramArrayOfChar2)
  {
    if (!this.isEquals) {
      return this;
    }
    if (paramArrayOfChar1 == paramArrayOfChar2) {
      return this;
    }
    int i = 0;
    if ((paramArrayOfChar1 != null) && (paramArrayOfChar2 != null))
    {
      if (paramArrayOfChar1.length != paramArrayOfChar2.length)
      {
        setEquals(false);
        return this;
      }
      while ((i < paramArrayOfChar1.length) && (this.isEquals))
      {
        append(paramArrayOfChar1[i], paramArrayOfChar2[i]);
        i += 1;
      }
      return this;
    }
    setEquals(false);
    return this;
  }
  
  public EqualsBuilder append(double[] paramArrayOfDouble1, double[] paramArrayOfDouble2)
  {
    if (!this.isEquals) {
      return this;
    }
    if (paramArrayOfDouble1 == paramArrayOfDouble2) {
      return this;
    }
    int i = 0;
    if ((paramArrayOfDouble1 != null) && (paramArrayOfDouble2 != null))
    {
      if (paramArrayOfDouble1.length != paramArrayOfDouble2.length)
      {
        setEquals(false);
        return this;
      }
      while ((i < paramArrayOfDouble1.length) && (this.isEquals))
      {
        append(paramArrayOfDouble1[i], paramArrayOfDouble2[i]);
        i += 1;
      }
      return this;
    }
    setEquals(false);
    return this;
  }
  
  public EqualsBuilder append(float[] paramArrayOfFloat1, float[] paramArrayOfFloat2)
  {
    if (!this.isEquals) {
      return this;
    }
    if (paramArrayOfFloat1 == paramArrayOfFloat2) {
      return this;
    }
    int i = 0;
    if ((paramArrayOfFloat1 != null) && (paramArrayOfFloat2 != null))
    {
      if (paramArrayOfFloat1.length != paramArrayOfFloat2.length)
      {
        setEquals(false);
        return this;
      }
      while ((i < paramArrayOfFloat1.length) && (this.isEquals))
      {
        append(paramArrayOfFloat1[i], paramArrayOfFloat2[i]);
        i += 1;
      }
      return this;
    }
    setEquals(false);
    return this;
  }
  
  public EqualsBuilder append(int[] paramArrayOfInt1, int[] paramArrayOfInt2)
  {
    if (!this.isEquals) {
      return this;
    }
    if (paramArrayOfInt1 == paramArrayOfInt2) {
      return this;
    }
    int i = 0;
    if ((paramArrayOfInt1 != null) && (paramArrayOfInt2 != null))
    {
      if (paramArrayOfInt1.length != paramArrayOfInt2.length)
      {
        setEquals(false);
        return this;
      }
      while ((i < paramArrayOfInt1.length) && (this.isEquals))
      {
        append(paramArrayOfInt1[i], paramArrayOfInt2[i]);
        i += 1;
      }
      return this;
    }
    setEquals(false);
    return this;
  }
  
  public EqualsBuilder append(long[] paramArrayOfLong1, long[] paramArrayOfLong2)
  {
    if (!this.isEquals) {
      return this;
    }
    if (paramArrayOfLong1 == paramArrayOfLong2) {
      return this;
    }
    int i = 0;
    if ((paramArrayOfLong1 != null) && (paramArrayOfLong2 != null))
    {
      if (paramArrayOfLong1.length != paramArrayOfLong2.length)
      {
        setEquals(false);
        return this;
      }
      while ((i < paramArrayOfLong1.length) && (this.isEquals))
      {
        append(paramArrayOfLong1[i], paramArrayOfLong2[i]);
        i += 1;
      }
      return this;
    }
    setEquals(false);
    return this;
  }
  
  public EqualsBuilder append(Object[] paramArrayOfObject1, Object[] paramArrayOfObject2)
  {
    if (!this.isEquals) {
      return this;
    }
    if (paramArrayOfObject1 == paramArrayOfObject2) {
      return this;
    }
    int i = 0;
    if ((paramArrayOfObject1 != null) && (paramArrayOfObject2 != null))
    {
      if (paramArrayOfObject1.length != paramArrayOfObject2.length)
      {
        setEquals(false);
        return this;
      }
      while ((i < paramArrayOfObject1.length) && (this.isEquals))
      {
        append(paramArrayOfObject1[i], paramArrayOfObject2[i]);
        i += 1;
      }
      return this;
    }
    setEquals(false);
    return this;
  }
  
  public EqualsBuilder append(short[] paramArrayOfShort1, short[] paramArrayOfShort2)
  {
    if (!this.isEquals) {
      return this;
    }
    if (paramArrayOfShort1 == paramArrayOfShort2) {
      return this;
    }
    int i = 0;
    if ((paramArrayOfShort1 != null) && (paramArrayOfShort2 != null))
    {
      if (paramArrayOfShort1.length != paramArrayOfShort2.length)
      {
        setEquals(false);
        return this;
      }
      while ((i < paramArrayOfShort1.length) && (this.isEquals))
      {
        append(paramArrayOfShort1[i], paramArrayOfShort2[i]);
        i += 1;
      }
      return this;
    }
    setEquals(false);
    return this;
  }
  
  public EqualsBuilder append(boolean[] paramArrayOfBoolean1, boolean[] paramArrayOfBoolean2)
  {
    if (!this.isEquals) {
      return this;
    }
    if (paramArrayOfBoolean1 == paramArrayOfBoolean2) {
      return this;
    }
    int i = 0;
    if ((paramArrayOfBoolean1 != null) && (paramArrayOfBoolean2 != null))
    {
      if (paramArrayOfBoolean1.length != paramArrayOfBoolean2.length)
      {
        setEquals(false);
        return this;
      }
      while ((i < paramArrayOfBoolean1.length) && (this.isEquals))
      {
        append(paramArrayOfBoolean1[i], paramArrayOfBoolean2[i]);
        i += 1;
      }
      return this;
    }
    setEquals(false);
    return this;
  }
  
  public EqualsBuilder appendSuper(boolean paramBoolean)
  {
    if (!this.isEquals) {
      return this;
    }
    this.isEquals = paramBoolean;
    return this;
  }
  
  public boolean isEquals()
  {
    return this.isEquals;
  }
  
  public void reset()
  {
    this.isEquals = true;
  }
  
  protected void setEquals(boolean paramBoolean)
  {
    this.isEquals = paramBoolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     org.apache.commons.lang.builder.EqualsBuilder
 * JD-Core Version:    0.7.0.1
 */