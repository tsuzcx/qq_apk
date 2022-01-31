package org.junit.runner;

import java.io.Serializable;
import java.lang.annotation.Annotation;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Description
  implements Serializable
{
  public static final Description EMPTY = new Description(null, "No Tests", new Annotation[0]);
  private static final Pattern METHOD_AND_CLASS_NAME_PATTERN = Pattern.compile("([\\s\\S]*)\\((.*)\\)");
  public static final Description TEST_MECHANISM = new Description(null, "Test mechanism", new Annotation[0]);
  private static final long serialVersionUID = 1L;
  private final Annotation[] fAnnotations;
  private final Collection<Description> fChildren = new ConcurrentLinkedQueue();
  private final String fDisplayName;
  private volatile Class<?> fTestClass;
  private final Serializable fUniqueId;
  
  private Description(Class<?> paramClass, String paramString, Serializable paramSerializable, Annotation... paramVarArgs)
  {
    if ((paramString == null) || (paramString.length() == 0)) {
      throw new IllegalArgumentException("The display name must not be empty.");
    }
    if (paramSerializable == null) {
      throw new IllegalArgumentException("The unique id must not be null.");
    }
    this.fTestClass = paramClass;
    this.fDisplayName = paramString;
    this.fUniqueId = paramSerializable;
    this.fAnnotations = paramVarArgs;
  }
  
  private Description(Class<?> paramClass, String paramString, Annotation... paramVarArgs)
  {
    this(paramClass, paramString, paramString, paramVarArgs);
  }
  
  public static Description createSuiteDescription(Class<?> paramClass)
  {
    return new Description(paramClass, paramClass.getName(), paramClass.getAnnotations());
  }
  
  public static Description createSuiteDescription(String paramString, Serializable paramSerializable, Annotation... paramVarArgs)
  {
    return new Description(null, paramString, paramSerializable, paramVarArgs);
  }
  
  public static Description createSuiteDescription(String paramString, Annotation... paramVarArgs)
  {
    return new Description(null, paramString, paramVarArgs);
  }
  
  public static Description createTestDescription(Class<?> paramClass, String paramString)
  {
    return new Description(paramClass, formatDisplayName(paramString, paramClass.getName()), new Annotation[0]);
  }
  
  public static Description createTestDescription(Class<?> paramClass, String paramString, Annotation... paramVarArgs)
  {
    return new Description(paramClass, formatDisplayName(paramString, paramClass.getName()), paramVarArgs);
  }
  
  public static Description createTestDescription(String paramString1, String paramString2, Serializable paramSerializable)
  {
    return new Description(null, formatDisplayName(paramString2, paramString1), paramSerializable, new Annotation[0]);
  }
  
  public static Description createTestDescription(String paramString1, String paramString2, Annotation... paramVarArgs)
  {
    return new Description(null, formatDisplayName(paramString2, paramString1), paramVarArgs);
  }
  
  private static String formatDisplayName(String paramString1, String paramString2)
  {
    return String.format("%s(%s)", new Object[] { paramString1, paramString2 });
  }
  
  private String methodAndClassNamePatternGroupOrDefault(int paramInt, String paramString)
  {
    Matcher localMatcher = METHOD_AND_CLASS_NAME_PATTERN.matcher(toString());
    if (localMatcher.matches()) {
      paramString = localMatcher.group(paramInt);
    }
    return paramString;
  }
  
  public void addChild(Description paramDescription)
  {
    this.fChildren.add(paramDescription);
  }
  
  public Description childlessCopy()
  {
    return new Description(this.fTestClass, this.fDisplayName, this.fAnnotations);
  }
  
  public boolean equals(Object paramObject)
  {
    if (!(paramObject instanceof Description)) {
      return false;
    }
    paramObject = (Description)paramObject;
    return this.fUniqueId.equals(paramObject.fUniqueId);
  }
  
  public <T extends Annotation> T getAnnotation(Class<T> paramClass)
  {
    Annotation[] arrayOfAnnotation = this.fAnnotations;
    int j = arrayOfAnnotation.length;
    int i = 0;
    while (i < j)
    {
      Annotation localAnnotation = arrayOfAnnotation[i];
      if (localAnnotation.annotationType().equals(paramClass)) {
        return (Annotation)paramClass.cast(localAnnotation);
      }
      i += 1;
    }
    return null;
  }
  
  public Collection<Annotation> getAnnotations()
  {
    return Arrays.asList(this.fAnnotations);
  }
  
  public ArrayList<Description> getChildren()
  {
    return new ArrayList(this.fChildren);
  }
  
  public String getClassName()
  {
    if (this.fTestClass != null) {
      return this.fTestClass.getName();
    }
    return methodAndClassNamePatternGroupOrDefault(2, toString());
  }
  
  public String getDisplayName()
  {
    return this.fDisplayName;
  }
  
  public String getMethodName()
  {
    return methodAndClassNamePatternGroupOrDefault(1, null);
  }
  
  public Class<?> getTestClass()
  {
    Class localClass = null;
    if (this.fTestClass != null) {
      localClass = this.fTestClass;
    }
    String str;
    do
    {
      return localClass;
      str = getClassName();
    } while (str == null);
    try
    {
      this.fTestClass = Class.forName(str, false, getClass().getClassLoader());
      localClass = this.fTestClass;
      return localClass;
    }
    catch (ClassNotFoundException localClassNotFoundException) {}
    return null;
  }
  
  public int hashCode()
  {
    return this.fUniqueId.hashCode();
  }
  
  public boolean isEmpty()
  {
    return equals(EMPTY);
  }
  
  public boolean isSuite()
  {
    return !isTest();
  }
  
  public boolean isTest()
  {
    return this.fChildren.isEmpty();
  }
  
  public int testCount()
  {
    int j;
    if (isTest())
    {
      j = 1;
      return j;
    }
    Iterator localIterator = this.fChildren.iterator();
    for (int i = 0;; i = ((Description)localIterator.next()).testCount() + i)
    {
      j = i;
      if (!localIterator.hasNext()) {
        break;
      }
    }
  }
  
  public String toString()
  {
    return getDisplayName();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     org.junit.runner.Description
 * JD-Core Version:    0.7.0.1
 */