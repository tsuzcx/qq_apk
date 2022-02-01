package org.junit.runner.manipulation;

import org.junit.runner.Description;

public abstract class Filter
{
  public static final Filter ALL = new Filter.1();
  
  public static Filter matchMethodDescription(Description paramDescription)
  {
    return new Filter.2(paramDescription);
  }
  
  public void apply(Object paramObject)
  {
    if (!(paramObject instanceof Filterable)) {
      return;
    }
    ((Filterable)paramObject).filter(this);
  }
  
  public abstract String describe();
  
  public Filter intersect(Filter paramFilter)
  {
    if ((paramFilter == this) || (paramFilter == ALL)) {
      return this;
    }
    return new Filter.3(this, this, paramFilter);
  }
  
  public abstract boolean shouldRun(Description paramDescription);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     org.junit.runner.manipulation.Filter
 * JD-Core Version:    0.7.0.1
 */