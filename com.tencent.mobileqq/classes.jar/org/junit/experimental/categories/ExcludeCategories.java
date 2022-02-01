package org.junit.experimental.categories;

import java.util.List;
import org.junit.runner.manipulation.Filter;

public final class ExcludeCategories
  extends CategoryFilterFactory
{
  protected Filter createFilter(List<Class<?>> paramList)
  {
    return new ExcludeCategories.ExcludesAny(paramList);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     org.junit.experimental.categories.ExcludeCategories
 * JD-Core Version:    0.7.0.1
 */