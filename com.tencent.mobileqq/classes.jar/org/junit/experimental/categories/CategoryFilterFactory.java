package org.junit.experimental.categories;

import java.util.ArrayList;
import java.util.List;
import org.junit.internal.Classes;
import org.junit.runner.FilterFactory;
import org.junit.runner.FilterFactory.FilterNotCreatedException;
import org.junit.runner.FilterFactoryParams;
import org.junit.runner.manipulation.Filter;

abstract class CategoryFilterFactory
  implements FilterFactory
{
  private List<Class<?>> parseCategories(String paramString)
  {
    ArrayList localArrayList = new ArrayList();
    paramString = paramString.split(",");
    int j = paramString.length;
    int i = 0;
    while (i < j)
    {
      localArrayList.add(Classes.getClass(paramString[i]));
      i += 1;
    }
    return localArrayList;
  }
  
  protected abstract Filter createFilter(List<Class<?>> paramList);
  
  public Filter createFilter(FilterFactoryParams paramFilterFactoryParams)
  {
    try
    {
      paramFilterFactoryParams = createFilter(parseCategories(paramFilterFactoryParams.getArgs()));
      return paramFilterFactoryParams;
    }
    catch (ClassNotFoundException paramFilterFactoryParams)
    {
      throw new FilterFactory.FilterNotCreatedException(paramFilterFactoryParams);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     org.junit.experimental.categories.CategoryFilterFactory
 * JD-Core Version:    0.7.0.1
 */