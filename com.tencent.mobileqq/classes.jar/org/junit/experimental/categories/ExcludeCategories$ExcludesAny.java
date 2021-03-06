package org.junit.experimental.categories;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

class ExcludeCategories$ExcludesAny
  extends Categories.CategoryFilter
{
  public ExcludeCategories$ExcludesAny(List<Class<?>> paramList)
  {
    this(new HashSet(paramList));
  }
  
  public ExcludeCategories$ExcludesAny(Set<Class<?>> paramSet)
  {
    super(true, null, true, paramSet);
  }
  
  public String describe()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("excludes ");
    localStringBuilder.append(super.describe());
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     org.junit.experimental.categories.ExcludeCategories.ExcludesAny
 * JD-Core Version:    0.7.0.1
 */