package org.junit.runner.manipulation;

import org.junit.runner.Description;

class Filter$3
  extends Filter
{
  Filter$3(Filter paramFilter1, Filter paramFilter2, Filter paramFilter3) {}
  
  public String describe()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(this.val$first.describe());
    localStringBuilder.append(" and ");
    localStringBuilder.append(this.val$second.describe());
    return localStringBuilder.toString();
  }
  
  public boolean shouldRun(Description paramDescription)
  {
    return (this.val$first.shouldRun(paramDescription)) && (this.val$second.shouldRun(paramDescription));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     org.junit.runner.manipulation.Filter.3
 * JD-Core Version:    0.7.0.1
 */