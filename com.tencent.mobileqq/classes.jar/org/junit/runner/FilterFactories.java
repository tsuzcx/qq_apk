package org.junit.runner;

import java.lang.reflect.Constructor;
import org.junit.internal.Classes;
import org.junit.runner.manipulation.Filter;

class FilterFactories
{
  public static Filter createFilter(Class<? extends FilterFactory> paramClass, FilterFactoryParams paramFilterFactoryParams)
  {
    return createFilterFactory(paramClass).createFilter(paramFilterFactoryParams);
  }
  
  public static Filter createFilter(String paramString, FilterFactoryParams paramFilterFactoryParams)
  {
    return createFilterFactory(paramString).createFilter(paramFilterFactoryParams);
  }
  
  static FilterFactory createFilterFactory(Class<? extends FilterFactory> paramClass)
  {
    try
    {
      paramClass = (FilterFactory)paramClass.getConstructor(new Class[0]).newInstance(new Object[0]);
      return paramClass;
    }
    catch (Exception paramClass)
    {
      throw new FilterFactory.FilterNotCreatedException(paramClass);
    }
  }
  
  static FilterFactory createFilterFactory(String paramString)
  {
    try
    {
      paramString = Classes.getClass(paramString).asSubclass(FilterFactory.class);
      return createFilterFactory(paramString);
    }
    catch (Exception paramString)
    {
      throw new FilterFactory.FilterNotCreatedException(paramString);
    }
  }
  
  public static Filter createFilterFromFilterSpec(Request paramRequest, String paramString)
  {
    Description localDescription = paramRequest.getRunner().getDescription();
    if (paramString.contains("=")) {
      paramRequest = paramString.split("=", 2);
    } else {
      paramRequest = new String[] { paramString, "" };
    }
    return createFilter(paramRequest[0], new FilterFactoryParams(localDescription, paramRequest[1]));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     org.junit.runner.FilterFactories
 * JD-Core Version:    0.7.0.1
 */