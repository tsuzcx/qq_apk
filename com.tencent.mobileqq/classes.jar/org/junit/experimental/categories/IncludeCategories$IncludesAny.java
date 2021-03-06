package org.junit.experimental.categories;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

class IncludeCategories$IncludesAny
  extends Categories.CategoryFilter
{
  public IncludeCategories$IncludesAny(List<Class<?>> paramList)
  {
    this(new HashSet(paramList));
  }
  
  public IncludeCategories$IncludesAny(Set<Class<?>> paramSet)
  {
    super(true, paramSet, true, null);
  }
  
  public String describe()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("includes ");
    localStringBuilder.append(super.describe());
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     org.junit.experimental.categories.IncludeCategories.IncludesAny
 * JD-Core Version:    0.7.0.1
 */