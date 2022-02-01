package external.org.apache.commons.lang3;

import external.org.apache.commons.lang3.exception.CloneFailedException;
import external.org.apache.commons.lang3.mutable.MutableInt;
import java.lang.reflect.Array;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeSet;

public class ObjectUtils
{
  public static final ObjectUtils.Null NULL = new ObjectUtils.Null();
  
  public static <T> T clone(T paramT)
  {
    if ((paramT instanceof Cloneable))
    {
      Object localObject1;
      if (paramT.getClass().isArray())
      {
        localObject1 = paramT.getClass().getComponentType();
        if (!((Class)localObject1).isPrimitive())
        {
          localObject1 = ((Object[])paramT).clone();
          return localObject1;
        }
        int i = Array.getLength(paramT);
        Object localObject2 = Array.newInstance((Class)localObject1, i);
        for (;;)
        {
          int j = i - 1;
          localObject1 = localObject2;
          if (i <= 0) {
            break;
          }
          Array.set(localObject2, j, Array.get(paramT, j));
          i = j;
        }
      }
      try
      {
        localObject1 = paramT.getClass().getMethod("clone", new Class[0]).invoke(paramT, new Object[0]);
        return localObject1;
      }
      catch (NoSuchMethodException localNoSuchMethodException)
      {
        throw new CloneFailedException("Cloneable type " + paramT.getClass().getName() + " has no clone method", localNoSuchMethodException);
      }
      catch (IllegalAccessException localIllegalAccessException)
      {
        throw new CloneFailedException("Cannot clone Cloneable type " + paramT.getClass().getName(), localIllegalAccessException);
      }
      catch (InvocationTargetException localInvocationTargetException)
      {
        throw new CloneFailedException("Exception cloning Cloneable type " + paramT.getClass().getName(), localInvocationTargetException.getCause());
      }
    }
    return null;
  }
  
  public static <T> T cloneIfPossible(T paramT)
  {
    Object localObject = clone(paramT);
    if (localObject == null) {
      return paramT;
    }
    return localObject;
  }
  
  public static <T extends Comparable<? super T>> int compare(T paramT1, T paramT2)
  {
    return compare(paramT1, paramT2, false);
  }
  
  public static <T extends Comparable<? super T>> int compare(T paramT1, T paramT2, boolean paramBoolean)
  {
    int i = 1;
    int j = -1;
    if (paramT1 == paramT2) {
      i = 0;
    }
    do
    {
      return i;
      if (paramT1 != null) {
        break;
      }
    } while (paramBoolean);
    return -1;
    if (paramT2 == null)
    {
      if (paramBoolean) {}
      for (i = j;; i = 1) {
        return i;
      }
    }
    return paramT1.compareTo(paramT2);
  }
  
  public static <T> T defaultIfNull(T paramT1, T paramT2)
  {
    if (paramT1 != null) {
      return paramT1;
    }
    return paramT2;
  }
  
  public static boolean equals(Object paramObject1, Object paramObject2)
  {
    if (paramObject1 == paramObject2) {
      return true;
    }
    if ((paramObject1 == null) || (paramObject2 == null)) {
      return false;
    }
    return paramObject1.equals(paramObject2);
  }
  
  public static <T> T firstNonNull(T... paramVarArgs)
  {
    if (paramVarArgs != null)
    {
      int j = paramVarArgs.length;
      int i = 0;
      while (i < j)
      {
        T ? = paramVarArgs[i];
        if (? != null) {
          return ?;
        }
        i += 1;
      }
    }
    return null;
  }
  
  public static int hashCode(Object paramObject)
  {
    if (paramObject == null) {
      return 0;
    }
    return paramObject.hashCode();
  }
  
  public static int hashCodeMulti(Object... paramVarArgs)
  {
    int k = 1;
    int i = 1;
    if (paramVarArgs != null)
    {
      int m = paramVarArgs.length;
      int j = 0;
      for (;;)
      {
        k = i;
        if (j >= m) {
          break;
        }
        k = hashCode(paramVarArgs[j]);
        j += 1;
        i = k + i * 31;
      }
    }
    return k;
  }
  
  public static String identityToString(Object paramObject)
  {
    if (paramObject == null) {
      return null;
    }
    StringBuffer localStringBuffer = new StringBuffer();
    identityToString(localStringBuffer, paramObject);
    return localStringBuffer.toString();
  }
  
  public static void identityToString(StringBuffer paramStringBuffer, Object paramObject)
  {
    if (paramObject == null) {
      throw new NullPointerException("Cannot get the toString of a null identity");
    }
    paramStringBuffer.append(paramObject.getClass().getName()).append('@').append(Integer.toHexString(System.identityHashCode(paramObject)));
  }
  
  public static <T extends Comparable<? super T>> T max(T... paramVarArgs)
  {
    Object localObject2 = null;
    Object localObject1 = null;
    int i;
    if (paramVarArgs != null)
    {
      int j = paramVarArgs.length;
      i = 0;
      localObject2 = localObject1;
      if (i < j)
      {
        localObject2 = paramVarArgs[i];
        if (compare((Comparable)localObject2, (Comparable)localObject1, false) <= 0) {
          break label50;
        }
        localObject1 = localObject2;
      }
    }
    label50:
    for (;;)
    {
      i += 1;
      break;
      return localObject2;
    }
  }
  
  public static <T extends Comparable<? super T>> T median(T... paramVarArgs)
  {
    Validate.notEmpty(paramVarArgs);
    Validate.noNullElements(paramVarArgs);
    TreeSet localTreeSet = new TreeSet();
    Collections.addAll(localTreeSet, paramVarArgs);
    return (Comparable)localTreeSet.toArray()[((localTreeSet.size() - 1) / 2)];
  }
  
  public static <T> T median(Comparator<T> paramComparator, T... paramVarArgs)
  {
    Validate.notEmpty(paramVarArgs, "null/empty items", new Object[0]);
    Validate.noNullElements(paramVarArgs);
    Validate.notNull(paramComparator, "null comparator", new Object[0]);
    paramComparator = new TreeSet(paramComparator);
    Collections.addAll(paramComparator, paramVarArgs);
    return paramComparator.toArray()[((paramComparator.size() - 1) / 2)];
  }
  
  public static <T extends Comparable<? super T>> T min(T... paramVarArgs)
  {
    Object localObject2 = null;
    Object localObject1 = null;
    int i;
    if (paramVarArgs != null)
    {
      int j = paramVarArgs.length;
      i = 0;
      localObject2 = localObject1;
      if (i < j)
      {
        localObject2 = paramVarArgs[i];
        if (compare((Comparable)localObject2, (Comparable)localObject1, true) >= 0) {
          break label50;
        }
        localObject1 = localObject2;
      }
    }
    label50:
    for (;;)
    {
      i += 1;
      break;
      return localObject2;
    }
  }
  
  public static <T> T mode(T... paramVarArgs)
  {
    int j = 0;
    Object localObject1;
    int i;
    if (ArrayUtils.isNotEmpty(paramVarArgs))
    {
      localObject1 = new HashMap(paramVarArgs.length);
      int k = paramVarArgs.length;
      i = 0;
      if (i < k)
      {
        localObject2 = paramVarArgs[i];
        MutableInt localMutableInt = (MutableInt)((HashMap)localObject1).get(localObject2);
        if (localMutableInt == null) {
          ((HashMap)localObject1).put(localObject2, new MutableInt(1));
        }
        for (;;)
        {
          i += 1;
          break;
          localMutableInt.increment();
        }
      }
      Object localObject2 = ((HashMap)localObject1).entrySet().iterator();
      paramVarArgs = null;
      i = j;
      localObject1 = paramVarArgs;
      if (!((Iterator)localObject2).hasNext()) {
        break label169;
      }
      localObject1 = (Map.Entry)((Iterator)localObject2).next();
      j = ((MutableInt)((Map.Entry)localObject1).getValue()).intValue();
      if (j == i) {
        paramVarArgs = null;
      }
    }
    for (;;)
    {
      break;
      if (j > i)
      {
        paramVarArgs = ((Map.Entry)localObject1).getKey();
        i = j;
        continue;
        localObject1 = null;
        label169:
        return localObject1;
      }
    }
  }
  
  public static boolean notEqual(Object paramObject1, Object paramObject2)
  {
    return !equals(paramObject1, paramObject2);
  }
  
  public static String toString(Object paramObject)
  {
    if (paramObject == null) {
      return "";
    }
    return paramObject.toString();
  }
  
  public static String toString(Object paramObject, String paramString)
  {
    if (paramObject == null) {
      return paramString;
    }
    return paramObject.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     external.org.apache.commons.lang3.ObjectUtils
 * JD-Core Version:    0.7.0.1
 */