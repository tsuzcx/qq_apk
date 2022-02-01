package org.apache.commons.io.serialization;

import java.io.InputStream;
import java.io.InvalidClassException;
import java.io.ObjectInputStream;
import java.io.ObjectStreamClass;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Pattern;

public class ValidatingObjectInputStream
  extends ObjectInputStream
{
  private final List<ClassNameMatcher> acceptMatchers = new ArrayList();
  private final List<ClassNameMatcher> rejectMatchers = new ArrayList();
  
  public ValidatingObjectInputStream(InputStream paramInputStream)
  {
    super(paramInputStream);
  }
  
  private void validateClassName(String paramString)
  {
    Iterator localIterator = this.rejectMatchers.iterator();
    while (localIterator.hasNext()) {
      if (((ClassNameMatcher)localIterator.next()).matches(paramString)) {
        invalidClassNameFound(paramString);
      }
    }
    localIterator = this.acceptMatchers.iterator();
    do
    {
      if (!localIterator.hasNext()) {
        break;
      }
    } while (!((ClassNameMatcher)localIterator.next()).matches(paramString));
    for (int i = 1;; i = 0)
    {
      if (i == 0) {
        invalidClassNameFound(paramString);
      }
      return;
    }
  }
  
  public ValidatingObjectInputStream accept(Pattern paramPattern)
  {
    this.acceptMatchers.add(new RegexpClassNameMatcher(paramPattern));
    return this;
  }
  
  public ValidatingObjectInputStream accept(ClassNameMatcher paramClassNameMatcher)
  {
    this.acceptMatchers.add(paramClassNameMatcher);
    return this;
  }
  
  public ValidatingObjectInputStream accept(Class<?>... paramVarArgs)
  {
    int j = paramVarArgs.length;
    int i = 0;
    while (i < j)
    {
      Class<?> localClass = paramVarArgs[i];
      this.acceptMatchers.add(new FullClassNameMatcher(new String[] { localClass.getName() }));
      i += 1;
    }
    return this;
  }
  
  public ValidatingObjectInputStream accept(String... paramVarArgs)
  {
    int j = paramVarArgs.length;
    int i = 0;
    while (i < j)
    {
      String str = paramVarArgs[i];
      this.acceptMatchers.add(new WildcardClassNameMatcher(str));
      i += 1;
    }
    return this;
  }
  
  protected void invalidClassNameFound(String paramString)
  {
    throw new InvalidClassException("Class name not accepted: " + paramString);
  }
  
  public ValidatingObjectInputStream reject(Pattern paramPattern)
  {
    this.rejectMatchers.add(new RegexpClassNameMatcher(paramPattern));
    return this;
  }
  
  public ValidatingObjectInputStream reject(ClassNameMatcher paramClassNameMatcher)
  {
    this.rejectMatchers.add(paramClassNameMatcher);
    return this;
  }
  
  public ValidatingObjectInputStream reject(Class<?>... paramVarArgs)
  {
    int j = paramVarArgs.length;
    int i = 0;
    while (i < j)
    {
      Class<?> localClass = paramVarArgs[i];
      this.rejectMatchers.add(new FullClassNameMatcher(new String[] { localClass.getName() }));
      i += 1;
    }
    return this;
  }
  
  public ValidatingObjectInputStream reject(String... paramVarArgs)
  {
    int j = paramVarArgs.length;
    int i = 0;
    while (i < j)
    {
      String str = paramVarArgs[i];
      this.rejectMatchers.add(new WildcardClassNameMatcher(str));
      i += 1;
    }
    return this;
  }
  
  protected Class<?> resolveClass(ObjectStreamClass paramObjectStreamClass)
  {
    validateClassName(paramObjectStreamClass.getName());
    return super.resolveClass(paramObjectStreamClass);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     org.apache.commons.io.serialization.ValidatingObjectInputStream
 * JD-Core Version:    0.7.0.1
 */