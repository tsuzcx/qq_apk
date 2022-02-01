package external.org.apache.commons.lang3.builder;

import external.org.apache.commons.lang3.ArrayUtils;
import java.lang.reflect.AccessibleObject;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

public class ReflectionToStringBuilder
  extends ToStringBuilder
{
  private boolean appendStatics = false;
  private boolean appendTransients = false;
  protected String[] excludeFieldNames;
  private Class<?> upToClass = null;
  
  public ReflectionToStringBuilder(Object paramObject)
  {
    super(paramObject);
  }
  
  public ReflectionToStringBuilder(Object paramObject, ToStringStyle paramToStringStyle)
  {
    super(paramObject, paramToStringStyle);
  }
  
  public ReflectionToStringBuilder(Object paramObject, ToStringStyle paramToStringStyle, StringBuffer paramStringBuffer)
  {
    super(paramObject, paramToStringStyle, paramStringBuffer);
  }
  
  public <T> ReflectionToStringBuilder(T paramT, ToStringStyle paramToStringStyle, StringBuffer paramStringBuffer, Class<? super T> paramClass, boolean paramBoolean1, boolean paramBoolean2)
  {
    super(paramT, paramToStringStyle, paramStringBuffer);
    setUpToClass(paramClass);
    setAppendTransients(paramBoolean1);
    setAppendStatics(paramBoolean2);
  }
  
  static String[] toNoNullStringArray(Collection<String> paramCollection)
  {
    if (paramCollection == null) {
      return ArrayUtils.EMPTY_STRING_ARRAY;
    }
    return toNoNullStringArray(paramCollection.toArray());
  }
  
  static String[] toNoNullStringArray(Object[] paramArrayOfObject)
  {
    ArrayList localArrayList = new ArrayList(paramArrayOfObject.length);
    int j = paramArrayOfObject.length;
    int i = 0;
    while (i < j)
    {
      Object localObject = paramArrayOfObject[i];
      if (localObject != null) {
        localArrayList.add(localObject.toString());
      }
      i += 1;
    }
    return (String[])localArrayList.toArray(ArrayUtils.EMPTY_STRING_ARRAY);
  }
  
  public static String toString(Object paramObject)
  {
    return toString(paramObject, null, false, false, null);
  }
  
  public static String toString(Object paramObject, ToStringStyle paramToStringStyle)
  {
    return toString(paramObject, paramToStringStyle, false, false, null);
  }
  
  public static String toString(Object paramObject, ToStringStyle paramToStringStyle, boolean paramBoolean)
  {
    return toString(paramObject, paramToStringStyle, paramBoolean, false, null);
  }
  
  public static String toString(Object paramObject, ToStringStyle paramToStringStyle, boolean paramBoolean1, boolean paramBoolean2)
  {
    return toString(paramObject, paramToStringStyle, paramBoolean1, paramBoolean2, null);
  }
  
  public static <T> String toString(T paramT, ToStringStyle paramToStringStyle, boolean paramBoolean1, boolean paramBoolean2, Class<? super T> paramClass)
  {
    return new ReflectionToStringBuilder(paramT, paramToStringStyle, null, paramClass, paramBoolean1, paramBoolean2).toString();
  }
  
  public static String toStringExclude(Object paramObject, Collection<String> paramCollection)
  {
    return toStringExclude(paramObject, toNoNullStringArray(paramCollection));
  }
  
  public static String toStringExclude(Object paramObject, String... paramVarArgs)
  {
    return new ReflectionToStringBuilder(paramObject).setExcludeFieldNames(paramVarArgs).toString();
  }
  
  protected boolean accept(Field paramField)
  {
    if (paramField.getName().indexOf('$') != -1) {}
    while (((Modifier.isTransient(paramField.getModifiers())) && (!isAppendTransients())) || ((Modifier.isStatic(paramField.getModifiers())) && (!isAppendStatics())) || ((this.excludeFieldNames != null) && (Arrays.binarySearch(this.excludeFieldNames, paramField.getName()) >= 0))) {
      return false;
    }
    return true;
  }
  
  protected void appendFieldsIn(Class<?> paramClass)
  {
    if (paramClass.isArray())
    {
      reflectionAppendArray(getObject());
      return;
    }
    paramClass = paramClass.getDeclaredFields();
    AccessibleObject.setAccessible(paramClass, true);
    int j = paramClass.length;
    int i = 0;
    while (i < j)
    {
      Field localField = paramClass[i];
      String str = localField.getName();
      if (accept(localField)) {}
      try
      {
        append(str, getValue(localField));
        i += 1;
      }
      catch (IllegalAccessException paramClass)
      {
        throw new InternalError("Unexpected IllegalAccessException: " + paramClass.getMessage());
      }
    }
  }
  
  public String[] getExcludeFieldNames()
  {
    return (String[])this.excludeFieldNames.clone();
  }
  
  public Class<?> getUpToClass()
  {
    return this.upToClass;
  }
  
  protected Object getValue(Field paramField)
  {
    return paramField.get(getObject());
  }
  
  public boolean isAppendStatics()
  {
    return this.appendStatics;
  }
  
  public boolean isAppendTransients()
  {
    return this.appendTransients;
  }
  
  public ReflectionToStringBuilder reflectionAppendArray(Object paramObject)
  {
    getStyle().reflectionAppendArrayDetail(getStringBuffer(), null, paramObject);
    return this;
  }
  
  public void setAppendStatics(boolean paramBoolean)
  {
    this.appendStatics = paramBoolean;
  }
  
  public void setAppendTransients(boolean paramBoolean)
  {
    this.appendTransients = paramBoolean;
  }
  
  public ReflectionToStringBuilder setExcludeFieldNames(String... paramVarArgs)
  {
    if (paramVarArgs == null)
    {
      this.excludeFieldNames = null;
      return this;
    }
    this.excludeFieldNames = toNoNullStringArray(paramVarArgs);
    Arrays.sort(this.excludeFieldNames);
    return this;
  }
  
  public void setUpToClass(Class<?> paramClass)
  {
    if (paramClass != null)
    {
      Object localObject = getObject();
      if ((localObject != null) && (!paramClass.isInstance(localObject))) {
        throw new IllegalArgumentException("Specified class is not a superclass of the object");
      }
    }
    this.upToClass = paramClass;
  }
  
  public String toString()
  {
    if (getObject() == null) {
      return getStyle().getNullText();
    }
    Class localClass = getObject().getClass();
    appendFieldsIn(localClass);
    while ((localClass.getSuperclass() != null) && (localClass != getUpToClass()))
    {
      localClass = localClass.getSuperclass();
      appendFieldsIn(localClass);
    }
    return super.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     external.org.apache.commons.lang3.builder.ReflectionToStringBuilder
 * JD-Core Version:    0.7.0.1
 */