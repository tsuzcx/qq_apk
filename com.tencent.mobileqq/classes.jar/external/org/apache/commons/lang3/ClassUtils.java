package external.org.apache.commons.lang3;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class ClassUtils
{
  public static final String INNER_CLASS_SEPARATOR;
  public static final char INNER_CLASS_SEPARATOR_CHAR = '$';
  public static final String PACKAGE_SEPARATOR = String.valueOf('.');
  public static final char PACKAGE_SEPARATOR_CHAR = '.';
  private static final Map<String, String> abbreviationMap;
  private static final Map<Class<?>, Class<?>> primitiveWrapperMap;
  private static final Map<String, String> reverseAbbreviationMap;
  private static final Map<Class<?>, Class<?>> wrapperPrimitiveMap;
  
  static
  {
    INNER_CLASS_SEPARATOR = String.valueOf('$');
    primitiveWrapperMap = new HashMap();
    primitiveWrapperMap.put(Boolean.TYPE, Boolean.class);
    primitiveWrapperMap.put(Byte.TYPE, Byte.class);
    primitiveWrapperMap.put(Character.TYPE, Character.class);
    primitiveWrapperMap.put(Short.TYPE, Short.class);
    primitiveWrapperMap.put(Integer.TYPE, Integer.class);
    primitiveWrapperMap.put(Long.TYPE, Long.class);
    primitiveWrapperMap.put(Double.TYPE, Double.class);
    primitiveWrapperMap.put(Float.TYPE, Float.class);
    primitiveWrapperMap.put(Void.TYPE, Void.TYPE);
    wrapperPrimitiveMap = new HashMap();
    Iterator localIterator = primitiveWrapperMap.keySet().iterator();
    while (localIterator.hasNext())
    {
      Class localClass1 = (Class)localIterator.next();
      Class localClass2 = (Class)primitiveWrapperMap.get(localClass1);
      if (!localClass1.equals(localClass2)) {
        wrapperPrimitiveMap.put(localClass2, localClass1);
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
  
  public static List<Class<?>> convertClassNamesToClasses(List<String> paramList)
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
        localArrayList.add(null);
      }
    }
    return localArrayList;
  }
  
  public static List<String> convertClassesToClassNames(List<Class<?>> paramList)
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
  
  public static List<Class<?>> getAllInterfaces(Class<?> paramClass)
  {
    if (paramClass == null) {
      return null;
    }
    LinkedHashSet localLinkedHashSet = new LinkedHashSet();
    getAllInterfaces(paramClass, localLinkedHashSet);
    return new ArrayList(localLinkedHashSet);
  }
  
  private static void getAllInterfaces(Class<?> paramClass, HashSet<Class<?>> paramHashSet)
  {
    while (paramClass != null)
    {
      Class[] arrayOfClass = paramClass.getInterfaces();
      int j = arrayOfClass.length;
      int i = 0;
      while (i < j)
      {
        Class localClass = arrayOfClass[i];
        if (paramHashSet.add(localClass)) {
          getAllInterfaces(localClass, paramHashSet);
        }
        i += 1;
      }
      paramClass = paramClass.getSuperclass();
    }
  }
  
  public static List<Class<?>> getAllSuperclasses(Class<?> paramClass)
  {
    if (paramClass == null)
    {
      paramClass = null;
      return paramClass;
    }
    ArrayList localArrayList = new ArrayList();
    for (Class localClass = paramClass.getSuperclass();; localClass = localClass.getSuperclass())
    {
      paramClass = localArrayList;
      if (localClass == null) {
        break;
      }
      localArrayList.add(localClass);
    }
  }
  
  private static String getCanonicalName(String paramString)
  {
    int k = 0;
    paramString = StringUtils.deleteWhitespace(paramString);
    String str;
    if (paramString == null) {
      str = null;
    }
    int i;
    do
    {
      return str;
      i = 0;
      while (paramString.startsWith("["))
      {
        paramString = paramString.substring(1);
        i += 1;
      }
      str = paramString;
    } while (i < 1);
    int j;
    if (paramString.startsWith("L")) {
      if (paramString.endsWith(";"))
      {
        j = paramString.length() - 1;
        paramString = paramString.substring(1, j);
      }
    }
    label152:
    for (;;)
    {
      label81:
      paramString = new StringBuilder(paramString);
      j = k;
      for (;;)
      {
        if (j < i)
        {
          paramString.append("[]");
          j += 1;
          continue;
          j = paramString.length();
          break;
          if (paramString.length() <= 0) {
            break label152;
          }
          paramString = (String)reverseAbbreviationMap.get(paramString.substring(0, 1));
          break label81;
        }
      }
      return paramString.toString();
    }
  }
  
  public static Class<?> getClass(ClassLoader paramClassLoader, String paramString)
  {
    return getClass(paramClassLoader, paramString, true);
  }
  
  public static Class<?> getClass(ClassLoader paramClassLoader, String paramString, boolean paramBoolean)
  {
    try
    {
      if (abbreviationMap.containsKey(paramString)) {
        return Class.forName("[" + (String)abbreviationMap.get(paramString), paramBoolean, paramClassLoader).getComponentType();
      }
      Class localClass = Class.forName(toCanonicalName(paramString), paramBoolean, paramClassLoader);
      return localClass;
    }
    catch (ClassNotFoundException localClassNotFoundException)
    {
      int i = paramString.lastIndexOf('.');
      if (i != -1) {
        try
        {
          paramClassLoader = getClass(paramClassLoader, paramString.substring(0, i) + '$' + paramString.substring(i + 1), paramBoolean);
          return paramClassLoader;
        }
        catch (ClassNotFoundException paramClassLoader) {}
      }
      throw localClassNotFoundException;
    }
  }
  
  public static Class<?> getClass(String paramString)
  {
    return getClass(paramString, true);
  }
  
  public static Class<?> getClass(String paramString, boolean paramBoolean)
  {
    ClassLoader localClassLoader2 = Thread.currentThread().getContextClassLoader();
    ClassLoader localClassLoader1 = localClassLoader2;
    if (localClassLoader2 == null) {
      localClassLoader1 = ClassUtils.class.getClassLoader();
    }
    return getClass(localClassLoader1, paramString, paramBoolean);
  }
  
  public static String getPackageCanonicalName(Class<?> paramClass)
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
  
  public static String getPackageName(Class<?> paramClass)
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
    String str;
    if (paramString != null)
    {
      str = paramString;
      if (paramString.length() != 0) {}
    }
    else
    {
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
  
  public static Method getPublicMethod(Class<?> paramClass, String paramString, Class<?>... paramVarArgs)
  {
    Object localObject = paramClass.getMethod(paramString, paramVarArgs);
    if (Modifier.isPublic(((Method)localObject).getDeclaringClass().getModifiers())) {
      return localObject;
    }
    localObject = new ArrayList();
    ((List)localObject).addAll(getAllInterfaces(paramClass));
    ((List)localObject).addAll(getAllSuperclasses(paramClass));
    paramClass = ((List)localObject).iterator();
    for (;;)
    {
      if (paramClass.hasNext())
      {
        localObject = (Class)paramClass.next();
        if (!Modifier.isPublic(((Class)localObject).getModifiers())) {}
      }
      else
      {
        try
        {
          localObject = ((Class)localObject).getMethod(paramString, paramVarArgs);
          if (!Modifier.isPublic(((Method)localObject).getDeclaringClass().getModifiers())) {
            continue;
          }
          return localObject;
        }
        catch (NoSuchMethodException localNoSuchMethodException) {}
        throw new NoSuchMethodException("Can't find a public method for " + paramString + " " + ArrayUtils.toString(paramVarArgs));
      }
    }
  }
  
  public static String getShortCanonicalName(Class<?> paramClass)
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
  
  public static String getShortClassName(Class<?> paramClass)
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
    int i = 0;
    if (paramString == null) {
      return "";
    }
    if (paramString.length() == 0) {
      return "";
    }
    StringBuilder localStringBuilder = new StringBuilder();
    String str = paramString;
    if (paramString.startsWith("["))
    {
      while (paramString.charAt(0) == '[')
      {
        paramString = paramString.substring(1);
        localStringBuilder.append("[]");
      }
      str = paramString;
      if (paramString.charAt(0) == 'L')
      {
        str = paramString;
        if (paramString.charAt(paramString.length() - 1) == ';') {
          str = paramString.substring(1, paramString.length() - 1);
        }
      }
    }
    if (reverseAbbreviationMap.containsKey(str)) {}
    for (paramString = (String)reverseAbbreviationMap.get(str);; paramString = str)
    {
      int j = paramString.lastIndexOf('.');
      if (j == -1) {}
      for (;;)
      {
        i = paramString.indexOf('$', i);
        str = paramString.substring(j + 1);
        paramString = str;
        if (i != -1) {
          paramString = str.replace('$', '.');
        }
        return paramString + localStringBuilder;
        i = j + 1;
      }
    }
  }
  
  public static String getSimpleName(Class<?> paramClass)
  {
    if (paramClass == null) {
      return "";
    }
    return paramClass.getSimpleName();
  }
  
  public static String getSimpleName(Object paramObject, String paramString)
  {
    if (paramObject == null) {
      return paramString;
    }
    return getSimpleName(paramObject.getClass());
  }
  
  public static boolean isAssignable(Class<?> paramClass1, Class<?> paramClass2)
  {
    return isAssignable(paramClass1, paramClass2, SystemUtils.isJavaVersionAtLeast(JavaVersion.JAVA_1_5));
  }
  
  public static boolean isAssignable(Class<?> paramClass1, Class<?> paramClass2, boolean paramBoolean)
  {
    boolean bool = true;
    if (paramClass2 == null) {}
    Object localObject2;
    label101:
    do
    {
      do
      {
        do
        {
          do
          {
            do
            {
              do
              {
                do
                {
                  do
                  {
                    Object localObject1;
                    do
                    {
                      return false;
                      if (paramClass1 == null)
                      {
                        if (!paramClass2.isPrimitive()) {}
                        for (paramBoolean = bool;; paramBoolean = false) {
                          return paramBoolean;
                        }
                      }
                      localObject2 = paramClass1;
                      if (!paramBoolean) {
                        break label101;
                      }
                      localObject1 = paramClass1;
                      if (!paramClass1.isPrimitive()) {
                        break;
                      }
                      localObject1 = paramClass1;
                      if (paramClass2.isPrimitive()) {
                        break;
                      }
                      localObject1 = primitiveToWrapper(paramClass1);
                    } while (localObject1 == null);
                    localObject2 = localObject1;
                    if (!paramClass2.isPrimitive()) {
                      break;
                    }
                    localObject2 = localObject1;
                    if (((Class)localObject1).isPrimitive()) {
                      break;
                    }
                    localObject2 = wrapperToPrimitive((Class)localObject1);
                  } while (localObject2 == null);
                  if (localObject2.equals(paramClass2)) {
                    return true;
                  }
                  if (!((Class)localObject2).isPrimitive()) {
                    break;
                  }
                } while (!paramClass2.isPrimitive());
                if (!Integer.TYPE.equals(localObject2)) {
                  break;
                }
              } while ((!Long.TYPE.equals(paramClass2)) && (!Float.TYPE.equals(paramClass2)) && (!Double.TYPE.equals(paramClass2)));
              return true;
              if (!Long.TYPE.equals(localObject2)) {
                break;
              }
            } while ((!Float.TYPE.equals(paramClass2)) && (!Double.TYPE.equals(paramClass2)));
            return true;
          } while ((Boolean.TYPE.equals(localObject2)) || (Double.TYPE.equals(localObject2)));
          if (Float.TYPE.equals(localObject2)) {
            return Double.TYPE.equals(paramClass2);
          }
          if (!Character.TYPE.equals(localObject2)) {
            break;
          }
        } while ((!Integer.TYPE.equals(paramClass2)) && (!Long.TYPE.equals(paramClass2)) && (!Float.TYPE.equals(paramClass2)) && (!Double.TYPE.equals(paramClass2)));
        return true;
        if (!Short.TYPE.equals(localObject2)) {
          break;
        }
      } while ((!Integer.TYPE.equals(paramClass2)) && (!Long.TYPE.equals(paramClass2)) && (!Float.TYPE.equals(paramClass2)) && (!Double.TYPE.equals(paramClass2)));
      return true;
    } while ((!Byte.TYPE.equals(localObject2)) || ((!Short.TYPE.equals(paramClass2)) && (!Integer.TYPE.equals(paramClass2)) && (!Long.TYPE.equals(paramClass2)) && (!Float.TYPE.equals(paramClass2)) && (!Double.TYPE.equals(paramClass2))));
    return true;
    return paramClass2.isAssignableFrom((Class)localObject2);
  }
  
  public static boolean isAssignable(Class<?>[] paramArrayOfClass1, Class<?>... paramVarArgs)
  {
    return isAssignable(paramArrayOfClass1, paramVarArgs, SystemUtils.isJavaVersionAtLeast(JavaVersion.JAVA_1_5));
  }
  
  public static boolean isAssignable(Class<?>[] paramArrayOfClass1, Class<?>[] paramArrayOfClass2, boolean paramBoolean)
  {
    if (!ArrayUtils.isSameLength(paramArrayOfClass1, paramArrayOfClass2)) {
      return false;
    }
    Object localObject = paramArrayOfClass1;
    if (paramArrayOfClass1 == null) {
      localObject = ArrayUtils.EMPTY_CLASS_ARRAY;
    }
    paramArrayOfClass1 = paramArrayOfClass2;
    if (paramArrayOfClass2 == null) {
      paramArrayOfClass1 = ArrayUtils.EMPTY_CLASS_ARRAY;
    }
    int i = 0;
    for (;;)
    {
      if (i >= localObject.length) {
        break label62;
      }
      if (!isAssignable(localObject[i], paramArrayOfClass1[i], paramBoolean)) {
        break;
      }
      i += 1;
    }
    label62:
    return true;
  }
  
  public static boolean isInnerClass(Class<?> paramClass)
  {
    return (paramClass != null) && (paramClass.getEnclosingClass() != null);
  }
  
  public static boolean isPrimitiveOrWrapper(Class<?> paramClass)
  {
    if (paramClass == null) {}
    while ((!paramClass.isPrimitive()) && (!isPrimitiveWrapper(paramClass))) {
      return false;
    }
    return true;
  }
  
  public static boolean isPrimitiveWrapper(Class<?> paramClass)
  {
    return wrapperPrimitiveMap.containsKey(paramClass);
  }
  
  public static Class<?> primitiveToWrapper(Class<?> paramClass)
  {
    Object localObject = paramClass;
    if (paramClass != null)
    {
      localObject = paramClass;
      if (paramClass.isPrimitive()) {
        localObject = (Class)primitiveWrapperMap.get(paramClass);
      }
    }
    return localObject;
  }
  
  public static Class<?>[] primitivesToWrappers(Class<?>... paramVarArgs)
  {
    if (paramVarArgs == null) {
      localObject = null;
    }
    do
    {
      return localObject;
      localObject = paramVarArgs;
    } while (paramVarArgs.length == 0);
    Object localObject = new Class[paramVarArgs.length];
    int i = 0;
    while (i < paramVarArgs.length)
    {
      localObject[i] = primitiveToWrapper(paramVarArgs[i]);
      i += 1;
    }
    return localObject;
  }
  
  private static String toCanonicalName(String paramString)
  {
    paramString = StringUtils.deleteWhitespace(paramString);
    if (paramString == null) {
      throw new NullPointerException("className must not be null.");
    }
    Object localObject = paramString;
    if (paramString.endsWith("[]"))
    {
      localObject = new StringBuilder();
      while (paramString.endsWith("[]"))
      {
        paramString = paramString.substring(0, paramString.length() - 2);
        ((StringBuilder)localObject).append("[");
      }
      String str = (String)abbreviationMap.get(paramString);
      if (str == null) {
        break label100;
      }
      ((StringBuilder)localObject).append(str);
    }
    for (;;)
    {
      localObject = ((StringBuilder)localObject).toString();
      return localObject;
      label100:
      ((StringBuilder)localObject).append("L").append(paramString).append(";");
    }
  }
  
  public static Class<?>[] toClass(Object... paramVarArgs)
  {
    if (paramVarArgs == null) {
      return null;
    }
    if (paramVarArgs.length == 0) {
      return ArrayUtils.EMPTY_CLASS_ARRAY;
    }
    Class[] arrayOfClass = new Class[paramVarArgs.length];
    int i = 0;
    if (i < paramVarArgs.length)
    {
      if (paramVarArgs[i] == null) {}
      for (Class localClass = null;; localClass = paramVarArgs[i].getClass())
      {
        arrayOfClass[i] = localClass;
        i += 1;
        break;
      }
    }
    return arrayOfClass;
  }
  
  public static Class<?> wrapperToPrimitive(Class<?> paramClass)
  {
    return (Class)wrapperPrimitiveMap.get(paramClass);
  }
  
  public static Class<?>[] wrappersToPrimitives(Class<?>... paramVarArgs)
  {
    if (paramVarArgs == null) {
      localObject = null;
    }
    do
    {
      return localObject;
      localObject = paramVarArgs;
    } while (paramVarArgs.length == 0);
    Object localObject = new Class[paramVarArgs.length];
    int i = 0;
    while (i < paramVarArgs.length)
    {
      localObject[i] = wrapperToPrimitive(paramVarArgs[i]);
      i += 1;
    }
    return localObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     external.org.apache.commons.lang3.ClassUtils
 * JD-Core Version:    0.7.0.1
 */