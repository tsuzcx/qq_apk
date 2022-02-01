package org.apache.commons.lang;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.apache.commons.lang.text.StrBuilder;

public class ClassUtils
{
  public static final String INNER_CLASS_SEPARATOR;
  public static final char INNER_CLASS_SEPARATOR_CHAR = '$';
  public static final String PACKAGE_SEPARATOR = String.valueOf('.');
  public static final char PACKAGE_SEPARATOR_CHAR = '.';
  private static final Map abbreviationMap;
  static Class class$java$lang$Boolean;
  static Class class$java$lang$Byte;
  static Class class$java$lang$Character;
  static Class class$java$lang$Double;
  static Class class$java$lang$Float;
  static Class class$java$lang$Integer;
  static Class class$java$lang$Long;
  static Class class$java$lang$Short;
  static Class class$org$apache$commons$lang$ClassUtils;
  private static final Map primitiveWrapperMap;
  private static final Map reverseAbbreviationMap;
  private static final Map wrapperPrimitiveMap;
  
  static
  {
    INNER_CLASS_SEPARATOR = String.valueOf('$');
    primitiveWrapperMap = new HashMap();
    Object localObject2 = primitiveWrapperMap;
    Class localClass2 = Boolean.TYPE;
    Class localClass1 = class$java$lang$Boolean;
    Object localObject1 = localClass1;
    if (localClass1 == null)
    {
      localObject1 = class$("java.lang.Boolean");
      class$java$lang$Boolean = (Class)localObject1;
    }
    ((Map)localObject2).put(localClass2, localObject1);
    localObject2 = primitiveWrapperMap;
    localClass2 = Byte.TYPE;
    localClass1 = class$java$lang$Byte;
    localObject1 = localClass1;
    if (localClass1 == null)
    {
      localObject1 = class$("java.lang.Byte");
      class$java$lang$Byte = (Class)localObject1;
    }
    ((Map)localObject2).put(localClass2, localObject1);
    localObject2 = primitiveWrapperMap;
    localClass2 = Character.TYPE;
    localClass1 = class$java$lang$Character;
    localObject1 = localClass1;
    if (localClass1 == null)
    {
      localObject1 = class$("java.lang.Character");
      class$java$lang$Character = (Class)localObject1;
    }
    ((Map)localObject2).put(localClass2, localObject1);
    localObject2 = primitiveWrapperMap;
    localClass2 = Short.TYPE;
    localClass1 = class$java$lang$Short;
    localObject1 = localClass1;
    if (localClass1 == null)
    {
      localObject1 = class$("java.lang.Short");
      class$java$lang$Short = (Class)localObject1;
    }
    ((Map)localObject2).put(localClass2, localObject1);
    localObject2 = primitiveWrapperMap;
    localClass2 = Integer.TYPE;
    localClass1 = class$java$lang$Integer;
    localObject1 = localClass1;
    if (localClass1 == null)
    {
      localObject1 = class$("java.lang.Integer");
      class$java$lang$Integer = (Class)localObject1;
    }
    ((Map)localObject2).put(localClass2, localObject1);
    localObject2 = primitiveWrapperMap;
    localClass2 = Long.TYPE;
    localClass1 = class$java$lang$Long;
    localObject1 = localClass1;
    if (localClass1 == null)
    {
      localObject1 = class$("java.lang.Long");
      class$java$lang$Long = (Class)localObject1;
    }
    ((Map)localObject2).put(localClass2, localObject1);
    localObject2 = primitiveWrapperMap;
    localClass2 = Double.TYPE;
    localClass1 = class$java$lang$Double;
    localObject1 = localClass1;
    if (localClass1 == null)
    {
      localObject1 = class$("java.lang.Double");
      class$java$lang$Double = (Class)localObject1;
    }
    ((Map)localObject2).put(localClass2, localObject1);
    localObject2 = primitiveWrapperMap;
    localClass2 = Float.TYPE;
    localClass1 = class$java$lang$Float;
    localObject1 = localClass1;
    if (localClass1 == null)
    {
      localObject1 = class$("java.lang.Float");
      class$java$lang$Float = (Class)localObject1;
    }
    ((Map)localObject2).put(localClass2, localObject1);
    primitiveWrapperMap.put(Void.TYPE, Void.TYPE);
    wrapperPrimitiveMap = new HashMap();
    localObject1 = primitiveWrapperMap.keySet().iterator();
    while (((Iterator)localObject1).hasNext())
    {
      localClass1 = (Class)((Iterator)localObject1).next();
      localObject2 = (Class)primitiveWrapperMap.get(localClass1);
      if (!localClass1.equals(localObject2)) {
        wrapperPrimitiveMap.put(localObject2, localClass1);
      }
    }
    abbreviationMap = new HashMap();
    reverseAbbreviationMap = new HashMap();
    addAbbreviation("int", "I");
    addAbbreviation("boolean", "Z");
    addAbbreviation("float", "F");
    addAbbreviation("long", "J");
    addAbbreviation("short", "S");
    addAbbreviation("byte", "B");
    addAbbreviation("double", "D");
    addAbbreviation("char", "C");
  }
  
  private static void addAbbreviation(String paramString1, String paramString2)
  {
    abbreviationMap.put(paramString1, paramString2);
    reverseAbbreviationMap.put(paramString2, paramString1);
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
  
  public static List convertClassNamesToClasses(List paramList)
  {
    if (paramList == null) {
      return null;
    }
    ArrayList localArrayList = new ArrayList(paramList.size());
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      String str = (String)paramList.next();
      try
      {
        localArrayList.add(Class.forName(str));
      }
      catch (Exception localException)
      {
        label60:
        break label60;
      }
      localArrayList.add(null);
    }
    return localArrayList;
  }
  
  public static List convertClassesToClassNames(List paramList)
  {
    if (paramList == null) {
      return null;
    }
    ArrayList localArrayList = new ArrayList(paramList.size());
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      Class localClass = (Class)paramList.next();
      if (localClass == null) {
        localArrayList.add(null);
      } else {
        localArrayList.add(localClass.getName());
      }
    }
    return localArrayList;
  }
  
  public static List getAllInterfaces(Class paramClass)
  {
    if (paramClass == null) {
      return null;
    }
    ArrayList localArrayList = new ArrayList();
    getAllInterfaces(paramClass, localArrayList);
    return localArrayList;
  }
  
  private static void getAllInterfaces(Class paramClass, List paramList)
  {
    while (paramClass != null)
    {
      Class[] arrayOfClass = paramClass.getInterfaces();
      int i = 0;
      while (i < arrayOfClass.length)
      {
        if (!paramList.contains(arrayOfClass[i]))
        {
          paramList.add(arrayOfClass[i]);
          getAllInterfaces(arrayOfClass[i], paramList);
        }
        i += 1;
      }
      paramClass = paramClass.getSuperclass();
    }
  }
  
  public static List getAllSuperclasses(Class paramClass)
  {
    if (paramClass == null) {
      return null;
    }
    ArrayList localArrayList = new ArrayList();
    for (paramClass = paramClass.getSuperclass(); paramClass != null; paramClass = paramClass.getSuperclass()) {
      localArrayList.add(paramClass);
    }
    return localArrayList;
  }
  
  private static String getCanonicalName(String paramString)
  {
    paramString = StringUtils.deleteWhitespace(paramString);
    if (paramString == null) {
      return null;
    }
    int k = 0;
    int i = 0;
    while (paramString.startsWith("["))
    {
      i += 1;
      paramString = paramString.substring(1);
    }
    if (i < 1) {
      return paramString;
    }
    String str;
    if (paramString.startsWith("L"))
    {
      if (paramString.endsWith(";")) {
        j = paramString.length() - 1;
      } else {
        j = paramString.length();
      }
      str = paramString.substring(1, j);
    }
    else
    {
      str = paramString;
      if (paramString.length() > 0) {
        str = (String)reverseAbbreviationMap.get(paramString.substring(0, 1));
      }
    }
    paramString = new StrBuilder(str);
    int j = k;
    while (j < i)
    {
      paramString.append("[]");
      j += 1;
    }
    return paramString.toString();
  }
  
  public static Class getClass(ClassLoader paramClassLoader, String paramString)
  {
    return getClass(paramClassLoader, paramString, true);
  }
  
  public static Class getClass(ClassLoader paramClassLoader, String paramString, boolean paramBoolean)
  {
    int i;
    try
    {
      if (abbreviationMap.containsKey(paramString))
      {
        localObject = new StringBuffer();
        ((StringBuffer)localObject).append("[");
        ((StringBuffer)localObject).append(abbreviationMap.get(paramString));
        return Class.forName(((StringBuffer)localObject).toString(), paramBoolean, paramClassLoader).getComponentType();
      }
      Object localObject = Class.forName(toCanonicalName(paramString), paramBoolean, paramClassLoader);
      return localObject;
    }
    catch (ClassNotFoundException localClassNotFoundException)
    {
      i = paramString.lastIndexOf('.');
      if (i == -1) {}
    }
    try
    {
      StringBuffer localStringBuffer = new StringBuffer();
      localStringBuffer.append(paramString.substring(0, i));
      localStringBuffer.append('$');
      localStringBuffer.append(paramString.substring(i + 1));
      paramClassLoader = getClass(paramClassLoader, localStringBuffer.toString(), paramBoolean);
      return paramClassLoader;
    }
    catch (ClassNotFoundException paramClassLoader)
    {
      label141:
      break label141;
    }
    throw localClassNotFoundException;
  }
  
  public static Class getClass(String paramString)
  {
    return getClass(paramString, true);
  }
  
  public static Class getClass(String paramString, boolean paramBoolean)
  {
    Object localObject2 = Thread.currentThread().getContextClassLoader();
    Object localObject1 = localObject2;
    if (localObject2 == null)
    {
      localObject2 = class$org$apache$commons$lang$ClassUtils;
      localObject1 = localObject2;
      if (localObject2 == null)
      {
        localObject1 = class$("org.apache.commons.lang.ClassUtils");
        class$org$apache$commons$lang$ClassUtils = (Class)localObject1;
      }
      localObject1 = ((Class)localObject1).getClassLoader();
    }
    return getClass((ClassLoader)localObject1, paramString, paramBoolean);
  }
  
  public static String getPackageCanonicalName(Class paramClass)
  {
    if (paramClass == null) {
      return "";
    }
    return getPackageCanonicalName(paramClass.getName());
  }
  
  public static String getPackageCanonicalName(Object paramObject, String paramString)
  {
    if (paramObject == null) {
      return paramString;
    }
    return getPackageCanonicalName(paramObject.getClass().getName());
  }
  
  public static String getPackageCanonicalName(String paramString)
  {
    return getPackageName(getCanonicalName(paramString));
  }
  
  public static String getPackageName(Class paramClass)
  {
    if (paramClass == null) {
      return "";
    }
    return getPackageName(paramClass.getName());
  }
  
  public static String getPackageName(Object paramObject, String paramString)
  {
    if (paramObject == null) {
      return paramString;
    }
    return getPackageName(paramObject.getClass());
  }
  
  public static String getPackageName(String paramString)
  {
    if (paramString != null)
    {
      String str = paramString;
      if (paramString.length() == 0) {
        return "";
      }
      while (str.charAt(0) == '[') {
        str = str.substring(1);
      }
      paramString = str;
      if (str.charAt(0) == 'L')
      {
        paramString = str;
        if (str.charAt(str.length() - 1) == ';') {
          paramString = str.substring(1);
        }
      }
      int i = paramString.lastIndexOf('.');
      if (i == -1) {
        return "";
      }
      return paramString.substring(0, i);
    }
    return "";
  }
  
  public static Method getPublicMethod(Class paramClass, String paramString, Class[] paramArrayOfClass)
  {
    Object localObject = paramClass.getMethod(paramString, paramArrayOfClass);
    if (Modifier.isPublic(((Method)localObject).getDeclaringClass().getModifiers())) {
      return localObject;
    }
    localObject = new ArrayList();
    ((List)localObject).addAll(getAllInterfaces(paramClass));
    ((List)localObject).addAll(getAllSuperclasses(paramClass));
    paramClass = ((List)localObject).iterator();
    while (paramClass.hasNext())
    {
      localObject = (Class)paramClass.next();
      if (Modifier.isPublic(((Class)localObject).getModifiers())) {}
      try
      {
        localObject = ((Class)localObject).getMethod(paramString, paramArrayOfClass);
        if (Modifier.isPublic(((Method)localObject).getDeclaringClass().getModifiers())) {
          return localObject;
        }
      }
      catch (NoSuchMethodException localNoSuchMethodException)
      {
        label113:
        break label113;
      }
    }
    paramClass = new StringBuffer();
    paramClass.append("Can't find a public method for ");
    paramClass.append(paramString);
    paramClass.append(" ");
    paramClass.append(ArrayUtils.toString(paramArrayOfClass));
    paramClass = new NoSuchMethodException(paramClass.toString());
    for (;;)
    {
      throw paramClass;
    }
  }
  
  public static String getShortCanonicalName(Class paramClass)
  {
    if (paramClass == null) {
      return "";
    }
    return getShortCanonicalName(paramClass.getName());
  }
  
  public static String getShortCanonicalName(Object paramObject, String paramString)
  {
    if (paramObject == null) {
      return paramString;
    }
    return getShortCanonicalName(paramObject.getClass().getName());
  }
  
  public static String getShortCanonicalName(String paramString)
  {
    return getShortClassName(getCanonicalName(paramString));
  }
  
  public static String getShortClassName(Class paramClass)
  {
    if (paramClass == null) {
      return "";
    }
    return getShortClassName(paramClass.getName());
  }
  
  public static String getShortClassName(Object paramObject, String paramString)
  {
    if (paramObject == null) {
      return paramString;
    }
    return getShortClassName(paramObject.getClass());
  }
  
  public static String getShortClassName(String paramString)
  {
    if (paramString == null) {
      return "";
    }
    if (paramString.length() == 0) {
      return "";
    }
    StrBuilder localStrBuilder = new StrBuilder();
    boolean bool = paramString.startsWith("[");
    int i = 0;
    Object localObject = paramString;
    if (bool)
    {
      while (paramString.charAt(0) == '[')
      {
        paramString = paramString.substring(1);
        localStrBuilder.append("[]");
      }
      localObject = paramString;
      if (paramString.charAt(0) == 'L')
      {
        localObject = paramString;
        if (paramString.charAt(paramString.length() - 1) == ';') {
          localObject = paramString.substring(1, paramString.length() - 1);
        }
      }
    }
    paramString = (String)localObject;
    if (reverseAbbreviationMap.containsKey(localObject)) {
      paramString = (String)reverseAbbreviationMap.get(localObject);
    }
    int j = paramString.lastIndexOf('.');
    if (j != -1) {
      i = j + 1;
    }
    i = paramString.indexOf('$', i);
    localObject = paramString.substring(j + 1);
    paramString = (String)localObject;
    if (i != -1) {
      paramString = ((String)localObject).replace('$', '.');
    }
    localObject = new StringBuffer();
    ((StringBuffer)localObject).append(paramString);
    ((StringBuffer)localObject).append(localStrBuilder);
    return ((StringBuffer)localObject).toString();
  }
  
  public static boolean isAssignable(Class paramClass1, Class paramClass2)
  {
    return isAssignable(paramClass1, paramClass2, false);
  }
  
  public static boolean isAssignable(Class paramClass1, Class paramClass2, boolean paramBoolean)
  {
    boolean bool3 = false;
    boolean bool4 = false;
    boolean bool5 = false;
    boolean bool1 = false;
    boolean bool2 = false;
    if (paramClass2 == null) {
      return false;
    }
    if (paramClass1 == null) {
      return paramClass2.isPrimitive() ^ true;
    }
    Object localObject = paramClass1;
    if (paramBoolean)
    {
      Class localClass = paramClass1;
      if (paramClass1.isPrimitive())
      {
        localClass = paramClass1;
        if (!paramClass2.isPrimitive())
        {
          paramClass1 = primitiveToWrapper(paramClass1);
          localClass = paramClass1;
          if (paramClass1 == null) {
            return false;
          }
        }
      }
      localObject = localClass;
      if (paramClass2.isPrimitive())
      {
        localObject = localClass;
        if (!localClass.isPrimitive())
        {
          paramClass1 = wrapperToPrimitive(localClass);
          localObject = paramClass1;
          if (paramClass1 == null) {
            return false;
          }
        }
      }
    }
    if (localObject.equals(paramClass2)) {
      return true;
    }
    if (((Class)localObject).isPrimitive())
    {
      if (!paramClass2.isPrimitive()) {
        return false;
      }
      if (Integer.TYPE.equals(localObject))
      {
        if ((!Long.TYPE.equals(paramClass2)) && (!Float.TYPE.equals(paramClass2)))
        {
          paramBoolean = bool2;
          if (!Double.TYPE.equals(paramClass2)) {}
        }
        else
        {
          paramBoolean = true;
        }
        return paramBoolean;
      }
      if (Long.TYPE.equals(localObject))
      {
        if (!Float.TYPE.equals(paramClass2))
        {
          paramBoolean = bool3;
          if (!Double.TYPE.equals(paramClass2)) {}
        }
        else
        {
          paramBoolean = true;
        }
        return paramBoolean;
      }
      if (Boolean.TYPE.equals(localObject)) {
        return false;
      }
      if (Double.TYPE.equals(localObject)) {
        return false;
      }
      if (Float.TYPE.equals(localObject)) {
        return Double.TYPE.equals(paramClass2);
      }
      if (Character.TYPE.equals(localObject))
      {
        if ((!Integer.TYPE.equals(paramClass2)) && (!Long.TYPE.equals(paramClass2)) && (!Float.TYPE.equals(paramClass2)))
        {
          paramBoolean = bool4;
          if (!Double.TYPE.equals(paramClass2)) {}
        }
        else
        {
          paramBoolean = true;
        }
        return paramBoolean;
      }
      if (Short.TYPE.equals(localObject))
      {
        if ((!Integer.TYPE.equals(paramClass2)) && (!Long.TYPE.equals(paramClass2)) && (!Float.TYPE.equals(paramClass2)))
        {
          paramBoolean = bool5;
          if (!Double.TYPE.equals(paramClass2)) {}
        }
        else
        {
          paramBoolean = true;
        }
        return paramBoolean;
      }
      paramBoolean = bool1;
      if (Byte.TYPE.equals(localObject)) {
        if ((!Short.TYPE.equals(paramClass2)) && (!Integer.TYPE.equals(paramClass2)) && (!Long.TYPE.equals(paramClass2)) && (!Float.TYPE.equals(paramClass2)))
        {
          paramBoolean = bool1;
          if (!Double.TYPE.equals(paramClass2)) {}
        }
        else
        {
          paramBoolean = true;
        }
      }
      return paramBoolean;
    }
    return paramClass2.isAssignableFrom((Class)localObject);
  }
  
  public static boolean isAssignable(Class[] paramArrayOfClass1, Class[] paramArrayOfClass2)
  {
    return isAssignable(paramArrayOfClass1, paramArrayOfClass2, false);
  }
  
  public static boolean isAssignable(Class[] paramArrayOfClass1, Class[] paramArrayOfClass2, boolean paramBoolean)
  {
    if (!ArrayUtils.isSameLength(paramArrayOfClass1, paramArrayOfClass2)) {
      return false;
    }
    Class[] arrayOfClass = paramArrayOfClass1;
    if (paramArrayOfClass1 == null) {
      arrayOfClass = ArrayUtils.EMPTY_CLASS_ARRAY;
    }
    paramArrayOfClass1 = paramArrayOfClass2;
    if (paramArrayOfClass2 == null) {
      paramArrayOfClass1 = ArrayUtils.EMPTY_CLASS_ARRAY;
    }
    int i = 0;
    while (i < arrayOfClass.length)
    {
      if (!isAssignable(arrayOfClass[i], paramArrayOfClass1[i], paramBoolean)) {
        return false;
      }
      i += 1;
    }
    return true;
  }
  
  public static boolean isInnerClass(Class paramClass)
  {
    boolean bool = false;
    if (paramClass == null) {
      return false;
    }
    if (paramClass.getName().indexOf('$') >= 0) {
      bool = true;
    }
    return bool;
  }
  
  public static Class primitiveToWrapper(Class paramClass)
  {
    Class localClass = paramClass;
    if (paramClass != null)
    {
      localClass = paramClass;
      if (paramClass.isPrimitive()) {
        localClass = (Class)primitiveWrapperMap.get(paramClass);
      }
    }
    return localClass;
  }
  
  public static Class[] primitivesToWrappers(Class[] paramArrayOfClass)
  {
    if (paramArrayOfClass == null) {
      return null;
    }
    if (paramArrayOfClass.length == 0) {
      return paramArrayOfClass;
    }
    Class[] arrayOfClass = new Class[paramArrayOfClass.length];
    int i = 0;
    while (i < paramArrayOfClass.length)
    {
      arrayOfClass[i] = primitiveToWrapper(paramArrayOfClass[i]);
      i += 1;
    }
    return arrayOfClass;
  }
  
  private static String toCanonicalName(String paramString)
  {
    paramString = StringUtils.deleteWhitespace(paramString);
    if (paramString != null)
    {
      Object localObject = paramString;
      if (paramString.endsWith("[]"))
      {
        localObject = new StrBuilder();
        while (paramString.endsWith("[]"))
        {
          paramString = paramString.substring(0, paramString.length() - 2);
          ((StrBuilder)localObject).append("[");
        }
        String str = (String)abbreviationMap.get(paramString);
        if (str != null) {
          ((StrBuilder)localObject).append(str);
        } else {
          ((StrBuilder)localObject).append("L").append(paramString).append(";");
        }
        localObject = ((StrBuilder)localObject).toString();
      }
      return localObject;
    }
    paramString = new NullArgumentException("className");
    for (;;)
    {
      throw paramString;
    }
  }
  
  public static Class[] toClass(Object[] paramArrayOfObject)
  {
    if (paramArrayOfObject == null) {
      return null;
    }
    if (paramArrayOfObject.length == 0) {
      return ArrayUtils.EMPTY_CLASS_ARRAY;
    }
    Class[] arrayOfClass = new Class[paramArrayOfObject.length];
    int i = 0;
    while (i < paramArrayOfObject.length)
    {
      Class localClass;
      if (paramArrayOfObject[i] == null) {
        localClass = null;
      } else {
        localClass = paramArrayOfObject[i].getClass();
      }
      arrayOfClass[i] = localClass;
      i += 1;
    }
    return arrayOfClass;
  }
  
  public static Class wrapperToPrimitive(Class paramClass)
  {
    return (Class)wrapperPrimitiveMap.get(paramClass);
  }
  
  public static Class[] wrappersToPrimitives(Class[] paramArrayOfClass)
  {
    if (paramArrayOfClass == null) {
      return null;
    }
    if (paramArrayOfClass.length == 0) {
      return paramArrayOfClass;
    }
    Class[] arrayOfClass = new Class[paramArrayOfClass.length];
    int i = 0;
    while (i < paramArrayOfClass.length)
    {
      arrayOfClass[i] = wrapperToPrimitive(paramArrayOfClass[i]);
      i += 1;
    }
    return arrayOfClass;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     org.apache.commons.lang.ClassUtils
 * JD-Core Version:    0.7.0.1
 */