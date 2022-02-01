package org.apache.commons.lang.builder;

import java.lang.reflect.AccessibleObject;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;
import org.apache.commons.lang.ArrayUtils;

public class HashCodeBuilder
{
  private static final ThreadLocal REGISTRY = new ThreadLocal();
  static Class class$org$apache$commons$lang$builder$HashCodeBuilder;
  private final int iConstant;
  private int iTotal = 0;
  
  public HashCodeBuilder()
  {
    this.iConstant = 37;
    this.iTotal = 17;
  }
  
  public HashCodeBuilder(int paramInt1, int paramInt2)
  {
    if (paramInt1 != 0)
    {
      if (paramInt1 % 2 != 0)
      {
        if (paramInt2 != 0)
        {
          if (paramInt2 % 2 != 0)
          {
            this.iConstant = paramInt2;
            this.iTotal = paramInt1;
            return;
          }
          throw new IllegalArgumentException("HashCodeBuilder requires an odd multiplier");
        }
        throw new IllegalArgumentException("HashCodeBuilder requires a non zero multiplier");
      }
      throw new IllegalArgumentException("HashCodeBuilder requires an odd initial value");
    }
    throw new IllegalArgumentException("HashCodeBuilder requires a non zero initial value");
  }
  
  static Class class$(String paramString)
  {
    try
    {
      paramString = Class.forName(paramString);
      return paramString;
    }
    catch (ClassNotFoundException paramString)
    {
      throw new NoClassDefFoundError(paramString.getMessage());
    }
  }
  
  static Set getRegistry()
  {
    return (Set)REGISTRY.get();
  }
  
  static boolean isRegistered(Object paramObject)
  {
    Set localSet = getRegistry();
    return (localSet != null) && (localSet.contains(new IDKey(paramObject)));
  }
  
  private static void reflectionAppend(Object paramObject, Class paramClass, HashCodeBuilder paramHashCodeBuilder, boolean paramBoolean, String[] paramArrayOfString)
  {
    if (isRegistered(paramObject)) {
      return;
    }
    for (;;)
    {
      try
      {
        register(paramObject);
        paramClass = paramClass.getDeclaredFields();
        AccessibleObject.setAccessible(paramClass, true);
        i = 0;
        if (i < paramClass.length)
        {
          localObject = paramClass[i];
          if ((!ArrayUtils.contains(paramArrayOfString, localObject.getName())) && (localObject.getName().indexOf('$') == -1) && ((paramBoolean) || (!Modifier.isTransient(localObject.getModifiers()))))
          {
            boolean bool = Modifier.isStatic(localObject.getModifiers());
            if (bool) {}
          }
        }
      }
      finally
      {
        int i;
        Object localObject;
        unregister(paramObject);
        continue;
        throw paramClass;
        continue;
      }
      try
      {
        paramHashCodeBuilder.append(localObject.get(paramObject));
      }
      catch (IllegalAccessException paramClass)
      {
        continue;
      }
      throw new InternalError("Unexpected IllegalAccessException");
      i += 1;
    }
    unregister(paramObject);
  }
  
  public static int reflectionHashCode(int paramInt1, int paramInt2, Object paramObject)
  {
    return reflectionHashCode(paramInt1, paramInt2, paramObject, false, null, null);
  }
  
  public static int reflectionHashCode(int paramInt1, int paramInt2, Object paramObject, boolean paramBoolean)
  {
    return reflectionHashCode(paramInt1, paramInt2, paramObject, paramBoolean, null, null);
  }
  
  public static int reflectionHashCode(int paramInt1, int paramInt2, Object paramObject, boolean paramBoolean, Class paramClass)
  {
    return reflectionHashCode(paramInt1, paramInt2, paramObject, paramBoolean, paramClass, null);
  }
  
  public static int reflectionHashCode(int paramInt1, int paramInt2, Object paramObject, boolean paramBoolean, Class paramClass, String[] paramArrayOfString)
  {
    if (paramObject != null)
    {
      HashCodeBuilder localHashCodeBuilder = new HashCodeBuilder(paramInt1, paramInt2);
      Class localClass = paramObject.getClass();
      reflectionAppend(paramObject, localClass, localHashCodeBuilder, paramBoolean, paramArrayOfString);
      while ((localClass.getSuperclass() != null) && (localClass != paramClass))
      {
        localClass = localClass.getSuperclass();
        reflectionAppend(paramObject, localClass, localHashCodeBuilder, paramBoolean, paramArrayOfString);
      }
      return localHashCodeBuilder.toHashCode();
    }
    paramObject = new IllegalArgumentException("The object to build a hash code for must not be null");
    for (;;)
    {
      throw paramObject;
    }
  }
  
  public static int reflectionHashCode(Object paramObject)
  {
    return reflectionHashCode(17, 37, paramObject, false, null, null);
  }
  
  public static int reflectionHashCode(Object paramObject, Collection paramCollection)
  {
    return reflectionHashCode(paramObject, ReflectionToStringBuilder.toNoNullStringArray(paramCollection));
  }
  
  public static int reflectionHashCode(Object paramObject, boolean paramBoolean)
  {
    return reflectionHashCode(17, 37, paramObject, paramBoolean, null, null);
  }
  
  public static int reflectionHashCode(Object paramObject, String[] paramArrayOfString)
  {
    return reflectionHashCode(17, 37, paramObject, false, null, paramArrayOfString);
  }
  
  static void register(Object paramObject)
  {
    Class localClass2 = class$org$apache$commons$lang$builder$HashCodeBuilder;
    Class localClass1 = localClass2;
    if (localClass2 == null)
    {
      localClass1 = class$("org.apache.commons.lang.builder.HashCodeBuilder");
      class$org$apache$commons$lang$builder$HashCodeBuilder = localClass1;
    }
    try
    {
      if (getRegistry() == null) {
        REGISTRY.set(new HashSet());
      }
      getRegistry().add(new IDKey(paramObject));
      return;
    }
    finally {}
  }
  
  static void unregister(Object paramObject)
  {
    Object localObject1 = getRegistry();
    if (localObject1 != null)
    {
      ((Set)localObject1).remove(new IDKey(paramObject));
      localObject1 = class$org$apache$commons$lang$builder$HashCodeBuilder;
      paramObject = localObject1;
      if (localObject1 == null)
      {
        paramObject = class$("org.apache.commons.lang.builder.HashCodeBuilder");
        class$org$apache$commons$lang$builder$HashCodeBuilder = paramObject;
      }
      try
      {
        localObject1 = getRegistry();
        if ((localObject1 != null) && (((Set)localObject1).isEmpty())) {
          REGISTRY.set(null);
        }
        return;
      }
      finally {}
    }
  }
  
  public HashCodeBuilder append(byte paramByte)
  {
    this.iTotal = (this.iTotal * this.iConstant + paramByte);
    return this;
  }
  
  public HashCodeBuilder append(char paramChar)
  {
    this.iTotal = (this.iTotal * this.iConstant + paramChar);
    return this;
  }
  
  public HashCodeBuilder append(double paramDouble)
  {
    return append(Double.doubleToLongBits(paramDouble));
  }
  
  public HashCodeBuilder append(float paramFloat)
  {
    this.iTotal = (this.iTotal * this.iConstant + Float.floatToIntBits(paramFloat));
    return this;
  }
  
  public HashCodeBuilder append(int paramInt)
  {
    this.iTotal = (this.iTotal * this.iConstant + paramInt);
    return this;
  }
  
  public HashCodeBuilder append(long paramLong)
  {
    this.iTotal = (this.iTotal * this.iConstant + (int)(paramLong ^ paramLong >> 32));
    return this;
  }
  
  public HashCodeBuilder append(Object paramObject)
  {
    if (paramObject == null)
    {
      this.iTotal *= this.iConstant;
      return this;
    }
    if (paramObject.getClass().isArray())
    {
      if ((paramObject instanceof long[]))
      {
        append((long[])paramObject);
        return this;
      }
      if ((paramObject instanceof int[]))
      {
        append((int[])paramObject);
        return this;
      }
      if ((paramObject instanceof short[]))
      {
        append((short[])paramObject);
        return this;
      }
      if ((paramObject instanceof char[]))
      {
        append((char[])paramObject);
        return this;
      }
      if ((paramObject instanceof byte[]))
      {
        append((byte[])paramObject);
        return this;
      }
      if ((paramObject instanceof double[]))
      {
        append((double[])paramObject);
        return this;
      }
      if ((paramObject instanceof float[]))
      {
        append((float[])paramObject);
        return this;
      }
      if ((paramObject instanceof boolean[]))
      {
        append((boolean[])paramObject);
        return this;
      }
      append((Object[])paramObject);
      return this;
    }
    this.iTotal = (this.iTotal * this.iConstant + paramObject.hashCode());
    return this;
  }
  
  public HashCodeBuilder append(short paramShort)
  {
    this.iTotal = (this.iTotal * this.iConstant + paramShort);
    return this;
  }
  
  public HashCodeBuilder append(boolean paramBoolean)
  {
    this.iTotal = (this.iTotal * this.iConstant + (paramBoolean ^ true));
    return this;
  }
  
  public HashCodeBuilder append(byte[] paramArrayOfByte)
  {
    if (paramArrayOfByte == null)
    {
      this.iTotal *= this.iConstant;
      return this;
    }
    int i = 0;
    while (i < paramArrayOfByte.length)
    {
      append(paramArrayOfByte[i]);
      i += 1;
    }
    return this;
  }
  
  public HashCodeBuilder append(char[] paramArrayOfChar)
  {
    if (paramArrayOfChar == null)
    {
      this.iTotal *= this.iConstant;
      return this;
    }
    int i = 0;
    while (i < paramArrayOfChar.length)
    {
      append(paramArrayOfChar[i]);
      i += 1;
    }
    return this;
  }
  
  public HashCodeBuilder append(double[] paramArrayOfDouble)
  {
    if (paramArrayOfDouble == null)
    {
      this.iTotal *= this.iConstant;
      return this;
    }
    int i = 0;
    while (i < paramArrayOfDouble.length)
    {
      append(paramArrayOfDouble[i]);
      i += 1;
    }
    return this;
  }
  
  public HashCodeBuilder append(float[] paramArrayOfFloat)
  {
    if (paramArrayOfFloat == null)
    {
      this.iTotal *= this.iConstant;
      return this;
    }
    int i = 0;
    while (i < paramArrayOfFloat.length)
    {
      append(paramArrayOfFloat[i]);
      i += 1;
    }
    return this;
  }
  
  public HashCodeBuilder append(int[] paramArrayOfInt)
  {
    if (paramArrayOfInt == null)
    {
      this.iTotal *= this.iConstant;
      return this;
    }
    int i = 0;
    while (i < paramArrayOfInt.length)
    {
      append(paramArrayOfInt[i]);
      i += 1;
    }
    return this;
  }
  
  public HashCodeBuilder append(long[] paramArrayOfLong)
  {
    if (paramArrayOfLong == null)
    {
      this.iTotal *= this.iConstant;
      return this;
    }
    int i = 0;
    while (i < paramArrayOfLong.length)
    {
      append(paramArrayOfLong[i]);
      i += 1;
    }
    return this;
  }
  
  public HashCodeBuilder append(Object[] paramArrayOfObject)
  {
    if (paramArrayOfObject == null)
    {
      this.iTotal *= this.iConstant;
      return this;
    }
    int i = 0;
    while (i < paramArrayOfObject.length)
    {
      append(paramArrayOfObject[i]);
      i += 1;
    }
    return this;
  }
  
  public HashCodeBuilder append(short[] paramArrayOfShort)
  {
    if (paramArrayOfShort == null)
    {
      this.iTotal *= this.iConstant;
      return this;
    }
    int i = 0;
    while (i < paramArrayOfShort.length)
    {
      append(paramArrayOfShort[i]);
      i += 1;
    }
    return this;
  }
  
  public HashCodeBuilder append(boolean[] paramArrayOfBoolean)
  {
    if (paramArrayOfBoolean == null)
    {
      this.iTotal *= this.iConstant;
      return this;
    }
    int i = 0;
    while (i < paramArrayOfBoolean.length)
    {
      append(paramArrayOfBoolean[i]);
      i += 1;
    }
    return this;
  }
  
  public HashCodeBuilder appendSuper(int paramInt)
  {
    this.iTotal = (this.iTotal * this.iConstant + paramInt);
    return this;
  }
  
  public int hashCode()
  {
    return toHashCode();
  }
  
  public int toHashCode()
  {
    return this.iTotal;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     org.apache.commons.lang.builder.HashCodeBuilder
 * JD-Core Version:    0.7.0.1
 */