package org.junit.experimental.categories;

import java.util.List;
import org.junit.runner.manipulation.Filter;

public final class IncludeCategories
  extends CategoryFilterFactory
{
  protected Filter createFilter(List<Class<?>> paramList)
  {
    return new IncludeCategories.IncludesAny(paramList);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     org.junit.experimental.categories.IncludeCategories
 * JD-Core Version:    0.7.0.1
 */