package org.junit.runner.manipulation;

import org.junit.runner.Description;

class Filter$1
  extends Filter
{
  public void apply(Object paramObject) {}
  
  public String describe()
  {
    return "all tests";
  }
  
  public Filter intersect(Filter paramFilter)
  {
    return paramFilter;
  }
  
  public boolean shouldRun(Description paramDescription)
  {
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     org.junit.runner.manipulation.Filter.1
 * JD-Core Version:    0.7.0.1
 */