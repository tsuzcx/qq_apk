package external.org.apache.commons.lang3.builder;

import external.org.apache.commons.lang3.ArrayUtils;
import java.lang.reflect.AccessibleObject;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.Collection;
import java.util.Comparator;

public class CompareToBuilder
  implements Builder<Integer>
{
  private int comparison = 0;
  
  private static void reflectionAppend(Object paramObject1, Object paramObject2, Class<?> paramClass, CompareToBuilder paramCompareToBuilder, boolean paramBoolean, String[] paramArrayOfString)
  {
    paramClass = paramClass.getDeclaredFields();
    AccessibleObject.setAccessible(paramClass, true);
    int i = 0;
    while ((i < paramClass.length) && (paramCompareToBuilder.comparison == 0))
    {
      Object localObject = paramClass[i];
      if ((!ArrayUtils.contains(paramArrayOfString, localObject.getName())) && (localObject.getName().indexOf('$') == -1) && ((paramBoolean) || (!Modifier.isTransient(localObject.getModifiers()))) && (!Modifier.isStatic(localObject.getModifiers()))) {}
      try
      {
        paramCompareToBuilder.append(localObject.get(paramObject1), localObject.get(paramObject2));
        i += 1;
      }
      catch (IllegalAccessException paramObject1)
      {
        throw new InternalError("Unexpected IllegalAccessException");
      }
    }
  }
  
  public static int reflectionCompare(Object paramObject1, Object paramObject2)
  {
    return reflectionCompare(paramObject1, paramObject2, false, null, new String[0]);
  }
  
  public static int reflectionCompare(Object paramObject1, Object paramObject2, Collection<String> paramCollection)
  {
    return reflectionCompare(paramObject1, paramObject2, ReflectionToStringBuilder.toNoNullStringArray(paramCollection));
  }
  
  public static int reflectionCompare(Object paramObject1, Object paramObject2, boolean paramBoolean)
  {
    return reflectionCompare(paramObject1, paramObject2, paramBoolean, null, new String[0]);
  }
  
  public static int reflectionCompare(Object paramObject1, Object paramObject2, boolean paramBoolean, Class<?> paramClass, String... paramVarArgs)
  {
    if (paramObject1 == paramObject2) {
      return 0;
    }
    if ((paramObject1 == null) || (paramObject2 == null)) {
      throw new NullPointerException();
    }
    Class localClass = paramObject1.getClass();
    if (!localClass.isInstance(paramObject2)) {
      throw new ClassCastException();
    }
    CompareToBuilder localCompareToBuilder = new CompareToBuilder();
    reflectionAppend(paramObject1, paramObject2, localClass, localCompareToBuilder, paramBoolean, paramVarArgs);
    while ((localClass.getSuperclass() != null) && (localClass != paramClass))
    {
      localClass = localClass.getSuperclass();
      reflectionAppend(paramObject1, paramObject2, localClass, localCompareToBuilder, paramBoolean, paramVarArgs);
    }
    return localCompareToBuilder.toComparison();
  }
  
  public static int reflectionCompare(Object paramObject1, Object paramObject2, String... paramVarArgs)
  {
    return reflectionCompare(paramObject1, paramObject2, false, null, paramVarArgs);
  }
  
  public CompareToBuilder append(byte paramByte1, byte paramByte2)
  {
    if (this.comparison != 0) {
      return this;
    }
    if (paramByte1 < paramByte2) {
      paramByte1 = -1;
    }
    for (;;)
    {
      this.comparison = paramByte1;
      return this;
      if (paramByte1 > paramByte2) {
        paramByte1 = 1;
      } else {
        paramByte1 = 0;
      }
    }
  }
  
  public CompareToBuilder append(char paramChar1, char paramChar2)
  {
    if (this.comparison != 0) {
      return this;
    }
    if (paramChar1 < paramChar2) {
      paramChar1 = 'ð¿¿';
    }
    for (;;)
    {
      this.comparison = paramChar1;
      return this;
      if (paramChar1 > paramChar2) {
        paramChar1 = '\001';
      } else {
        paramChar1 = '\000';
      }
    }
  }
  
  public CompareToBuilder append(double paramDouble1, double paramDouble2)
  {
    if (this.comparison != 0) {
      return this;
    }
    this.comparison = Double.compare(paramDouble1, paramDouble2);
    return this;
  }
  
  public CompareToBuilder append(float paramFloat1, float paramFloat2)
  {
    if (this.comparison != 0) {
      return this;
    }
    this.comparison = Float.compare(paramFloat1, paramFloat2);
    return this;
  }
  
  public CompareToBuilder append(int paramInt1, int paramInt2)
  {
    if (this.comparison != 0) {
      return this;
    }
    if (paramInt1 < paramInt2) {
      paramInt1 = -1;
    }
    for (;;)
    {
      this.comparison = paramInt1;
      return this;
      if (paramInt1 > paramInt2) {
        paramInt1 = 1;
      } else {
        paramInt1 = 0;
      }
    }
  }
  
  public CompareToBuilder append(long paramLong1, long paramLong2)
  {
    if (this.comparison != 0) {
      return this;
    }
    int i;
    if (paramLong1 < paramLong2) {
      i = -1;
    }
    for (;;)
    {
      this.comparison = i;
      return this;
      if (paramLong1 > paramLong2) {
        i = 1;
      } else {
        i = 0;
      }
    }
  }
  
  public CompareToBuilder append(Object paramObject1, Object paramObject2)
  {
    return append(paramObject1, paramObject2, null);
  }
  
  public CompareToBuilder append(Object paramObject1, Object paramObject2, Comparator<?> paramComparator)
  {
    if (this.comparison != 0) {}
    while (paramObject1 == paramObject2) {
      return this;
    }
    if (paramObject1 == null)
    {
      this.comparison = -1;
      return this;
    }
    if (paramObject2 == null)
    {
      this.comparison = 1;
      return this;
    }
    if (paramObject1.getClass().isArray())
    {
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
      append((Object[])paramObject1, (Object[])paramObject2, paramComparator);
      return this;
    }
    if (paramComparator == null)
    {
      this.comparison = ((Comparable)paramObject1).compareTo(paramObject2);
      return this;
    }
    this.comparison = paramComparator.compare(paramObject1, paramObject2);
    return this;
  }
  
  public CompareToBuilder append(short paramShort1, short paramShort2)
  {
    if (this.comparison != 0) {
      return this;
    }
    if (paramShort1 < paramShort2) {
      paramShort1 = -1;
    }
    for (;;)
    {
      this.comparison = paramShort1;
      return this;
      if (paramShort1 > paramShort2) {
        paramShort1 = 1;
      } else {
        paramShort1 = 0;
      }
    }
  }
  
  public CompareToBuilder append(boolean paramBoolean1, boolean paramBoolean2)
  {
    if (this.comparison != 0) {}
    while (paramBoolean1 == paramBoolean2) {
      return this;
    }
    if (!paramBoolean1)
    {
      this.comparison = -1;
      return this;
    }
    this.comparison = 1;
    return this;
  }
  
  public CompareToBuilder append(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2)
  {
    int i = -1;
    if (this.comparison != 0) {}
    for (;;)
    {
      return this;
      if (paramArrayOfByte1 != paramArrayOfByte2)
      {
        if (paramArrayOfByte1 == null)
        {
          this.comparison = -1;
          return this;
        }
        if (paramArrayOfByte2 == null)
        {
          this.comparison = 1;
          return this;
        }
        if (paramArrayOfByte1.length != paramArrayOfByte2.length)
        {
          if (paramArrayOfByte1.length < paramArrayOfByte2.length) {}
          for (;;)
          {
            this.comparison = i;
            return this;
            i = 1;
          }
        }
        i = 0;
        while ((i < paramArrayOfByte1.length) && (this.comparison == 0))
        {
          append(paramArrayOfByte1[i], paramArrayOfByte2[i]);
          i += 1;
        }
      }
    }
  }
  
  public CompareToBuilder append(char[] paramArrayOfChar1, char[] paramArrayOfChar2)
  {
    int i = -1;
    if (this.comparison != 0) {}
    for (;;)
    {
      return this;
      if (paramArrayOfChar1 != paramArrayOfChar2)
      {
        if (paramArrayOfChar1 == null)
        {
          this.comparison = -1;
          return this;
        }
        if (paramArrayOfChar2 == null)
        {
          this.comparison = 1;
          return this;
        }
        if (paramArrayOfChar1.length != paramArrayOfChar2.length)
        {
          if (paramArrayOfChar1.length < paramArrayOfChar2.length) {}
          for (;;)
          {
            this.comparison = i;
            return this;
            i = 1;
          }
        }
        i = 0;
        while ((i < paramArrayOfChar1.length) && (this.comparison == 0))
        {
          append(paramArrayOfChar1[i], paramArrayOfChar2[i]);
          i += 1;
        }
      }
    }
  }
  
  public CompareToBuilder append(double[] paramArrayOfDouble1, double[] paramArrayOfDouble2)
  {
    int i = -1;
    if (this.comparison != 0) {}
    for (;;)
    {
      return this;
      if (paramArrayOfDouble1 != paramArrayOfDouble2)
      {
        if (paramArrayOfDouble1 == null)
        {
          this.comparison = -1;
          return this;
        }
        if (paramArrayOfDouble2 == null)
        {
          this.comparison = 1;
          return this;
        }
        if (paramArrayOfDouble1.length != paramArrayOfDouble2.length)
        {
          if (paramArrayOfDouble1.length < paramArrayOfDouble2.length) {}
          for (;;)
          {
            this.comparison = i;
            return this;
            i = 1;
          }
        }
        i = 0;
        while ((i < paramArrayOfDouble1.length) && (this.comparison == 0))
        {
          append(paramArrayOfDouble1[i], paramArrayOfDouble2[i]);
          i += 1;
        }
      }
    }
  }
  
  public CompareToBuilder append(float[] paramArrayOfFloat1, float[] paramArrayOfFloat2)
  {
    int i = -1;
    if (this.comparison != 0) {}
    for (;;)
    {
      return this;
      if (paramArrayOfFloat1 != paramArrayOfFloat2)
      {
        if (paramArrayOfFloat1 == null)
        {
          this.comparison = -1;
          return this;
        }
        if (paramArrayOfFloat2 == null)
        {
          this.comparison = 1;
          return this;
        }
        if (paramArrayOfFloat1.length != paramArrayOfFloat2.length)
        {
          if (paramArrayOfFloat1.length < paramArrayOfFloat2.length) {}
          for (;;)
          {
            this.comparison = i;
            return this;
            i = 1;
          }
        }
        i = 0;
        while ((i < paramArrayOfFloat1.length) && (this.comparison == 0))
        {
          append(paramArrayOfFloat1[i], paramArrayOfFloat2[i]);
          i += 1;
        }
      }
    }
  }
  
  public CompareToBuilder append(int[] paramArrayOfInt1, int[] paramArrayOfInt2)
  {
    int i = -1;
    if (this.comparison != 0) {}
    for (;;)
    {
      return this;
      if (paramArrayOfInt1 != paramArrayOfInt2)
      {
        if (paramArrayOfInt1 == null)
        {
          this.comparison = -1;
          return this;
        }
        if (paramArrayOfInt2 == null)
        {
          this.comparison = 1;
          return this;
        }
        if (paramArrayOfInt1.length != paramArrayOfInt2.length)
        {
          if (paramArrayOfInt1.length < paramArrayOfInt2.length) {}
          for (;;)
          {
            this.comparison = i;
            return this;
            i = 1;
          }
        }
        i = 0;
        while ((i < paramArrayOfInt1.length) && (this.comparison == 0))
        {
          append(paramArrayOfInt1[i], paramArrayOfInt2[i]);
          i += 1;
        }
      }
    }
  }
  
  public CompareToBuilder append(long[] paramArrayOfLong1, long[] paramArrayOfLong2)
  {
    int i = -1;
    if (this.comparison != 0) {}
    for (;;)
    {
      return this;
      if (paramArrayOfLong1 != paramArrayOfLong2)
      {
        if (paramArrayOfLong1 == null)
        {
          this.comparison = -1;
          return this;
        }
        if (paramArrayOfLong2 == null)
        {
          this.comparison = 1;
          return this;
        }
        if (paramArrayOfLong1.length != paramArrayOfLong2.length)
        {
          if (paramArrayOfLong1.length < paramArrayOfLong2.length) {}
          for (;;)
          {
            this.comparison = i;
            return this;
            i = 1;
          }
        }
        i = 0;
        while ((i < paramArrayOfLong1.length) && (this.comparison == 0))
        {
          append(paramArrayOfLong1[i], paramArrayOfLong2[i]);
          i += 1;
        }
      }
    }
  }
  
  public CompareToBuilder append(Object[] paramArrayOfObject1, Object[] paramArrayOfObject2)
  {
    return append(paramArrayOfObject1, paramArrayOfObject2, null);
  }
  
  public CompareToBuilder append(Object[] paramArrayOfObject1, Object[] paramArrayOfObject2, Comparator<?> paramComparator)
  {
    int i = -1;
    if (this.comparison != 0) {}
    for (;;)
    {
      return this;
      if (paramArrayOfObject1 != paramArrayOfObject2)
      {
        if (paramArrayOfObject1 == null)
        {
          this.comparison = -1;
          return this;
        }
        if (paramArrayOfObject2 == null)
        {
          this.comparison = 1;
          return this;
        }
        if (paramArrayOfObject1.length != paramArrayOfObject2.length)
        {
          if (paramArrayOfObject1.length < paramArrayOfObject2.length) {}
          for (;;)
          {
            this.comparison = i;
            return this;
            i = 1;
          }
        }
        i = 0;
        while ((i < paramArrayOfObject1.length) && (this.comparison == 0))
        {
          append(paramArrayOfObject1[i], paramArrayOfObject2[i], paramComparator);
          i += 1;
        }
      }
    }
  }
  
  public CompareToBuilder append(short[] paramArrayOfShort1, short[] paramArrayOfShort2)
  {
    int i = -1;
    if (this.comparison != 0) {}
    for (;;)
    {
      return this;
      if (paramArrayOfShort1 != paramArrayOfShort2)
      {
        if (paramArrayOfShort1 == null)
        {
          this.comparison = -1;
          return this;
        }
        if (paramArrayOfShort2 == null)
        {
          this.comparison = 1;
          return this;
        }
        if (paramArrayOfShort1.length != paramArrayOfShort2.length)
        {
          if (paramArrayOfShort1.length < paramArrayOfShort2.length) {}
          for (;;)
          {
            this.comparison = i;
            return this;
            i = 1;
          }
        }
        i = 0;
        while ((i < paramArrayOfShort1.length) && (this.comparison == 0))
        {
          append(paramArrayOfShort1[i], paramArrayOfShort2[i]);
          i += 1;
        }
      }
    }
  }
  
  public CompareToBuilder append(boolean[] paramArrayOfBoolean1, boolean[] paramArrayOfBoolean2)
  {
    int i = -1;
    if (this.comparison != 0) {}
    for (;;)
    {
      return this;
      if (paramArrayOfBoolean1 != paramArrayOfBoolean2)
      {
        if (paramArrayOfBoolean1 == null)
        {
          this.comparison = -1;
          return this;
        }
        if (paramArrayOfBoolean2 == null)
        {
          this.comparison = 1;
          return this;
        }
        if (paramArrayOfBoolean1.length != paramArrayOfBoolean2.length)
        {
          if (paramArrayOfBoolean1.length < paramArrayOfBoolean2.length) {}
          for (;;)
          {
            this.comparison = i;
            return this;
            i = 1;
          }
        }
        i = 0;
        while ((i < paramArrayOfBoolean1.length) && (this.comparison == 0))
        {
          append(paramArrayOfBoolean1[i], paramArrayOfBoolean2[i]);
          i += 1;
        }
      }
    }
  }
  
  public CompareToBuilder appendSuper(int paramInt)
  {
    if (this.comparison != 0) {
      return this;
    }
    this.comparison = paramInt;
    return this;
  }
  
  public Integer build()
  {
    return Integer.valueOf(toComparison());
  }
  
  public int toComparison()
  {
    return this.comparison;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     external.org.apache.commons.lang3.builder.CompareToBuilder
 * JD-Core Version:    0.7.0.1
 */