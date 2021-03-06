package org.junit.experimental.categories;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import org.junit.runner.Description;
import org.junit.runner.manipulation.Filter;

public class Categories$CategoryFilter
  extends Filter
{
  private final Set<Class<?>> excluded;
  private final boolean excludedAny;
  private final Set<Class<?>> included;
  private final boolean includedAny;
  
  protected Categories$CategoryFilter(boolean paramBoolean1, Set<Class<?>> paramSet1, boolean paramBoolean2, Set<Class<?>> paramSet2)
  {
    this.includedAny = paramBoolean1;
    this.excludedAny = paramBoolean2;
    this.included = copyAndRefine(paramSet1);
    this.excluded = copyAndRefine(paramSet2);
  }
  
  private static Set<Class<?>> categories(Description paramDescription)
  {
    HashSet localHashSet = new HashSet();
    Collections.addAll(localHashSet, directCategories(paramDescription));
    Collections.addAll(localHashSet, directCategories(parentDescription(paramDescription)));
    return localHashSet;
  }
  
  public static CategoryFilter categoryFilter(boolean paramBoolean1, Set<Class<?>> paramSet1, boolean paramBoolean2, Set<Class<?>> paramSet2)
  {
    return new CategoryFilter(paramBoolean1, paramSet1, paramBoolean2, paramSet2);
  }
  
  private static Set<Class<?>> copyAndRefine(Set<Class<?>> paramSet)
  {
    HashSet localHashSet = new HashSet();
    if (paramSet != null) {
      localHashSet.addAll(paramSet);
    }
    localHashSet.remove(null);
    return localHashSet;
  }
  
  private static Class<?>[] directCategories(Description paramDescription)
  {
    if (paramDescription == null) {
      return new Class[0];
    }
    paramDescription = (Category)paramDescription.getAnnotation(Category.class);
    if (paramDescription == null) {
      return new Class[0];
    }
    return paramDescription.value();
  }
  
  public static CategoryFilter exclude(Class<?> paramClass)
  {
    return exclude(true, new Class[] { paramClass });
  }
  
  public static CategoryFilter exclude(boolean paramBoolean, Class<?>... paramVarArgs)
  {
    if (!hasNull(paramVarArgs)) {
      return categoryFilter(true, null, paramBoolean, Categories.access$000(paramVarArgs));
    }
    throw new NullPointerException("has null category");
  }
  
  public static CategoryFilter exclude(Class<?>... paramVarArgs)
  {
    return exclude(true, paramVarArgs);
  }
  
  private boolean hasCorrectCategoryAnnotation(Description paramDescription)
  {
    paramDescription = categories(paramDescription);
    if (paramDescription.isEmpty()) {
      return this.included.isEmpty();
    }
    if (!this.excluded.isEmpty()) {
      if (this.excludedAny)
      {
        if (matchesAnyParentCategories(paramDescription, this.excluded)) {
          return false;
        }
      }
      else if (matchesAllParentCategories(paramDescription, this.excluded)) {
        return false;
      }
    }
    if (this.included.isEmpty()) {
      return true;
    }
    if (this.includedAny) {
      return matchesAnyParentCategories(paramDescription, this.included);
    }
    return matchesAllParentCategories(paramDescription, this.included);
  }
  
  private static boolean hasNull(Class<?>... paramVarArgs)
  {
    if (paramVarArgs == null) {
      return false;
    }
    int j = paramVarArgs.length;
    int i = 0;
    while (i < j)
    {
      if (paramVarArgs[i] == null) {
        return true;
      }
      i += 1;
    }
    return false;
  }
  
  public static CategoryFilter include(Class<?> paramClass)
  {
    return include(true, new Class[] { paramClass });
  }
  
  public static CategoryFilter include(boolean paramBoolean, Class<?>... paramVarArgs)
  {
    if (!hasNull(paramVarArgs)) {
      return categoryFilter(paramBoolean, Categories.access$000(paramVarArgs), true, null);
    }
    throw new NullPointerException("has null category");
  }
  
  public static CategoryFilter include(Class<?>... paramVarArgs)
  {
    return include(true, paramVarArgs);
  }
  
  private boolean matchesAllParentCategories(Set<Class<?>> paramSet1, Set<Class<?>> paramSet2)
  {
    paramSet2 = paramSet2.iterator();
    while (paramSet2.hasNext()) {
      if (!Categories.access$100(paramSet1, (Class)paramSet2.next())) {
        return false;
      }
    }
    return true;
  }
  
  private boolean matchesAnyParentCategories(Set<Class<?>> paramSet1, Set<Class<?>> paramSet2)
  {
    paramSet2 = paramSet2.iterator();
    while (paramSet2.hasNext()) {
      if (Categories.access$100(paramSet1, (Class)paramSet2.next())) {
        return true;
      }
    }
    return false;
  }
  
  private static Description parentDescription(Description paramDescription)
  {
    paramDescription = paramDescription.getTestClass();
    if (paramDescription == null) {
      return null;
    }
    return Description.createSuiteDescription(paramDescription);
  }
  
  public String describe()
  {
    return toString();
  }
  
  public boolean shouldRun(Description paramDescription)
  {
    if (hasCorrectCategoryAnnotation(paramDescription)) {
      return true;
    }
    paramDescription = paramDescription.getChildren().iterator();
    while (paramDescription.hasNext()) {
      if (shouldRun((Description)paramDescription.next())) {
        return true;
      }
    }
    return false;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder("categories ");
    Object localObject;
    if (this.included.isEmpty()) {
      localObject = "[all]";
    } else {
      localObject = this.included;
    }
    localStringBuilder.append(localObject);
    if (!this.excluded.isEmpty())
    {
      localStringBuilder.append(" - ");
      localStringBuilder.append(this.excluded);
    }
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     org.junit.experimental.categories.Categories.CategoryFilter
 * JD-Core Version:    0.7.0.1
 */