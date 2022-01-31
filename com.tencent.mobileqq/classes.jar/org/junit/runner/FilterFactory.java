package org.junit.runner;

import org.junit.runner.manipulation.Filter;

public abstract interface FilterFactory
{
  public abstract Filter createFilter(FilterFactoryParams paramFilterFactoryParams);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     org.junit.runner.FilterFactory
 * JD-Core Version:    0.7.0.1
 */