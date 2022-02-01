package org.junit.experimental.categories;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import org.junit.runner.Description;
import org.junit.runner.manipulation.NoTestsRemainException;
import org.junit.runners.Suite;
import org.junit.runners.model.InitializationError;
import org.junit.runners.model.RunnerBuilder;

public class Categories
  extends Suite
{
  public Categories(Class<?> paramClass, RunnerBuilder paramRunnerBuilder)
  {
    super(paramClass, paramRunnerBuilder);
    try
    {
      paramRunnerBuilder = getIncludedCategory(paramClass);
      Set localSet = getExcludedCategory(paramClass);
      filter(Categories.CategoryFilter.categoryFilter(isAnyIncluded(paramClass), paramRunnerBuilder, isAnyExcluded(paramClass), localSet));
      assertNoCategorizedDescendentsOfUncategorizeableParents(getDescription());
      return;
    }
    catch (NoTestsRemainException paramClass)
    {
      throw new InitializationError(paramClass);
    }
  }
  
  private static void assertNoCategorizedDescendentsOfUncategorizeableParents(Description paramDescription)
  {
    if (!canHaveCategorizedChildren(paramDescription)) {
      assertNoDescendantsHaveCategoryAnnotations(paramDescription);
    }
    paramDescription = paramDescription.getChildren().iterator();
    while (paramDescription.hasNext()) {
      assertNoCategorizedDescendentsOfUncategorizeableParents((Description)paramDescription.next());
    }
  }
  
  private static void assertNoDescendantsHaveCategoryAnnotations(Description paramDescription)
  {
    paramDescription = paramDescription.getChildren().iterator();
    while (paramDescription.hasNext())
    {
      Description localDescription = (Description)paramDescription.next();
      if (localDescription.getAnnotation(Category.class) == null) {
        assertNoDescendantsHaveCategoryAnnotations(localDescription);
      } else {
        throw new InitializationError("Category annotations on Parameterized classes are not supported on individual methods.");
      }
    }
  }
  
  private static boolean canHaveCategorizedChildren(Description paramDescription)
  {
    paramDescription = paramDescription.getChildren().iterator();
    while (paramDescription.hasNext()) {
      if (((Description)paramDescription.next()).getTestClass() == null) {
        return false;
      }
    }
    return true;
  }
  
  private static Set<Class<?>> createSet(Class<?>... paramVarArgs)
  {
    HashSet localHashSet = new HashSet();
    if (paramVarArgs != null) {
      Collections.addAll(localHashSet, paramVarArgs);
    }
    return localHashSet;
  }
  
  private static Set<Class<?>> getExcludedCategory(Class<?> paramClass)
  {
    paramClass = (Categories.ExcludeCategory)paramClass.getAnnotation(Categories.ExcludeCategory.class);
    if (paramClass == null) {
      paramClass = null;
    } else {
      paramClass = paramClass.value();
    }
    return createSet(paramClass);
  }
  
  private static Set<Class<?>> getIncludedCategory(Class<?> paramClass)
  {
    paramClass = (Categories.IncludeCategory)paramClass.getAnnotation(Categories.IncludeCategory.class);
    if (paramClass == null) {
      paramClass = null;
    } else {
      paramClass = paramClass.value();
    }
    return createSet(paramClass);
  }
  
  private static boolean hasAssignableTo(Set<Class<?>> paramSet, Class<?> paramClass)
  {
    paramSet = paramSet.iterator();
    while (paramSet.hasNext()) {
      if (paramClass.isAssignableFrom((Class)paramSet.next())) {
        return true;
      }
    }
    return false;
  }
  
  private static boolean isAnyExcluded(Class<?> paramClass)
  {
    paramClass = (Categories.ExcludeCategory)paramClass.getAnnotation(Categories.ExcludeCategory.class);
    return (paramClass == null) || (paramClass.matchAny());
  }
  
  private static boolean isAnyIncluded(Class<?> paramClass)
  {
    paramClass = (Categories.IncludeCategory)paramClass.getAnnotation(Categories.IncludeCategory.class);
    return (paramClass == null) || (paramClass.matchAny());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     org.junit.experimental.categories.Categories
 * JD-Core Version:    0.7.0.1
 */