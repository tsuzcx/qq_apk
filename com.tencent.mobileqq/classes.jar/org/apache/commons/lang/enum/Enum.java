package org.apache.commons.lang.enum;

import java.io.Serializable;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.WeakHashMap;
import org.apache.commons.lang.ClassUtils;
import org.apache.commons.lang.StringUtils;

public abstract class Enum
  implements Serializable, Comparable
{
  private static final Map EMPTY_MAP = Collections.unmodifiableMap(new HashMap(0));
  private static Map cEnumClasses = new WeakHashMap();
  static Class class$org$apache$commons$lang$enum$Enum;
  static Class class$org$apache$commons$lang$enum$ValuedEnum;
  private static final long serialVersionUID = -487045951170455942L;
  private final transient int iHashCode;
  private final String iName;
  protected transient String iToString = null;
  
  protected Enum(String paramString)
  {
    init(paramString);
    this.iName = paramString;
    this.iHashCode = (getEnumClass().hashCode() + 7 + paramString.hashCode() * 3);
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
  
  private static Enum.Entry createEntry(Class paramClass)
  {
    Enum.Entry localEntry = new Enum.Entry();
    for (paramClass = paramClass.getSuperclass(); paramClass != null; paramClass = paramClass.getSuperclass())
    {
      Class localClass = class$org$apache$commons$lang$enum$Enum;
      Object localObject = localClass;
      if (localClass == null)
      {
        localObject = class$("org.apache.commons.lang.enum.Enum");
        class$org$apache$commons$lang$enum$Enum = (Class)localObject;
      }
      if (paramClass == localObject) {
        break;
      }
      localClass = class$org$apache$commons$lang$enum$ValuedEnum;
      localObject = localClass;
      if (localClass == null)
      {
        localObject = class$("org.apache.commons.lang.enum.ValuedEnum");
        class$org$apache$commons$lang$enum$ValuedEnum = (Class)localObject;
      }
      if (paramClass == localObject) {
        break;
      }
      localObject = (Enum.Entry)cEnumClasses.get(paramClass);
      if (localObject != null)
      {
        localEntry.list.addAll(((Enum.Entry)localObject).list);
        localEntry.map.putAll(((Enum.Entry)localObject).map);
        return localEntry;
      }
    }
    return localEntry;
  }
  
  private static Enum.Entry getEntry(Class paramClass)
  {
    Object localObject;
    if (paramClass != null)
    {
      Class localClass = class$org$apache$commons$lang$enum$Enum;
      localObject = localClass;
      if (localClass == null)
      {
        localObject = class$("org.apache.commons.lang.enum.Enum");
        class$org$apache$commons$lang$enum$Enum = (Class)localObject;
      }
      if (((Class)localObject).isAssignableFrom(paramClass))
      {
        localObject = (Enum.Entry)cEnumClasses.get(paramClass);
        if (localObject != null) {}
      }
    }
    try
    {
      Class.forName(paramClass.getName(), true, paramClass.getClassLoader());
      paramClass = (Enum.Entry)cEnumClasses.get(paramClass);
      return paramClass;
    }
    catch (Exception paramClass)
    {
      label77:
      break label77;
    }
    return localObject;
    throw new IllegalArgumentException("The Class must be a subclass of Enum");
    throw new IllegalArgumentException("The Enum Class must not be null");
  }
  
  protected static Enum getEnum(Class paramClass, String paramString)
  {
    paramClass = getEntry(paramClass);
    if (paramClass == null) {
      return null;
    }
    return (Enum)paramClass.map.get(paramString);
  }
  
  protected static List getEnumList(Class paramClass)
  {
    paramClass = getEntry(paramClass);
    if (paramClass == null) {
      return Collections.EMPTY_LIST;
    }
    return paramClass.unmodifiableList;
  }
  
  protected static Map getEnumMap(Class paramClass)
  {
    paramClass = getEntry(paramClass);
    if (paramClass == null) {
      return EMPTY_MAP;
    }
    return paramClass.unmodifiableMap;
  }
  
  private String getNameInOtherClassLoader(Object paramObject)
  {
    try
    {
      paramObject = (String)paramObject.getClass().getMethod("getName", null).invoke(paramObject, null);
      return paramObject;
    }
    catch (NoSuchMethodException|IllegalAccessException|InvocationTargetException paramObject)
    {
      label21:
      break label21;
    }
    throw new IllegalStateException("This should not happen");
  }
  
  private void init(String paramString)
  {
    if (!StringUtils.isEmpty(paramString))
    {
      Class localClass = getEnumClass();
      if (localClass != null)
      {
        Object localObject1 = getClass();
        int j = 0;
        int i;
        Object localObject3;
        Object localObject2;
        for (;;)
        {
          i = j;
          if (localObject1 == null) {
            break;
          }
          localObject3 = class$org$apache$commons$lang$enum$Enum;
          localObject2 = localObject3;
          if (localObject3 == null)
          {
            localObject2 = class$("org.apache.commons.lang.enum.Enum");
            class$org$apache$commons$lang$enum$Enum = (Class)localObject2;
          }
          i = j;
          if (localObject1 == localObject2) {
            break;
          }
          localObject3 = class$org$apache$commons$lang$enum$ValuedEnum;
          localObject2 = localObject3;
          if (localObject3 == null)
          {
            localObject2 = class$("org.apache.commons.lang.enum.ValuedEnum");
            class$org$apache$commons$lang$enum$ValuedEnum = (Class)localObject2;
          }
          i = j;
          if (localObject1 == localObject2) {
            break;
          }
          if (localObject1 == localClass)
          {
            i = 1;
            break;
          }
          localObject1 = ((Class)localObject1).getSuperclass();
        }
        if (i != 0)
        {
          localObject2 = class$org$apache$commons$lang$enum$Enum;
          localObject1 = localObject2;
          if (localObject2 == null)
          {
            localObject1 = class$("org.apache.commons.lang.enum.Enum");
            class$org$apache$commons$lang$enum$Enum = (Class)localObject1;
          }
          try
          {
            localObject3 = (Enum.Entry)cEnumClasses.get(localClass);
            localObject2 = localObject3;
            if (localObject3 == null)
            {
              localObject2 = createEntry(localClass);
              localObject3 = new WeakHashMap();
              ((Map)localObject3).putAll(cEnumClasses);
              ((Map)localObject3).put(localClass, localObject2);
              cEnumClasses = (Map)localObject3;
            }
            if (!((Enum.Entry)localObject2).map.containsKey(paramString))
            {
              ((Enum.Entry)localObject2).map.put(paramString, this);
              ((Enum.Entry)localObject2).list.add(this);
              return;
            }
            localObject1 = new StringBuffer();
            ((StringBuffer)localObject1).append("The Enum name must be unique, '");
            ((StringBuffer)localObject1).append(paramString);
            ((StringBuffer)localObject1).append("' has already been added");
            throw new IllegalArgumentException(((StringBuffer)localObject1).toString());
          }
          finally {}
        }
        throw new IllegalArgumentException("getEnumClass() must return a superclass of this class");
      }
      throw new IllegalArgumentException("getEnumClass() must not be null");
    }
    paramString = new IllegalArgumentException("The Enum name must not be empty or null");
    for (;;)
    {
      throw paramString;
    }
  }
  
  protected static Iterator iterator(Class paramClass)
  {
    return getEnumList(paramClass).iterator();
  }
  
  public int compareTo(Object paramObject)
  {
    if (paramObject == this) {
      return 0;
    }
    if (paramObject.getClass() != getClass())
    {
      if (paramObject.getClass().getName().equals(getClass().getName())) {
        return this.iName.compareTo(getNameInOtherClassLoader(paramObject));
      }
      StringBuffer localStringBuffer = new StringBuffer();
      localStringBuffer.append("Different enum class '");
      localStringBuffer.append(ClassUtils.getShortClassName(paramObject.getClass()));
      localStringBuffer.append("'");
      throw new ClassCastException(localStringBuffer.toString());
    }
    return this.iName.compareTo(((Enum)paramObject).iName);
  }
  
  public final boolean equals(Object paramObject)
  {
    if (paramObject == this) {
      return true;
    }
    if (paramObject == null) {
      return false;
    }
    if (paramObject.getClass() == getClass()) {
      return this.iName.equals(((Enum)paramObject).iName);
    }
    if (!paramObject.getClass().getName().equals(getClass().getName())) {
      return false;
    }
    return this.iName.equals(getNameInOtherClassLoader(paramObject));
  }
  
  public Class getEnumClass()
  {
    return getClass();
  }
  
  public final String getName()
  {
    return this.iName;
  }
  
  public final int hashCode()
  {
    return this.iHashCode;
  }
  
  protected Object readResolve()
  {
    Enum.Entry localEntry = (Enum.Entry)cEnumClasses.get(getEnumClass());
    if (localEntry == null) {
      return null;
    }
    return localEntry.map.get(getName());
  }
  
  public String toString()
  {
    if (this.iToString == null)
    {
      String str = ClassUtils.getShortClassName(getEnumClass());
      StringBuffer localStringBuffer = new StringBuffer();
      localStringBuffer.append(str);
      localStringBuffer.append("[");
      localStringBuffer.append(getName());
      localStringBuffer.append("]");
      this.iToString = localStringBuffer.toString();
    }
    return this.iToString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     org.apache.commons.lang.enum.Enum
 * JD-Core Version:    0.7.0.1
 */