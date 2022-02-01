package org.junit.runner.manipulation;

import java.util.ArrayList;
import java.util.Iterator;
import org.junit.runner.Description;

class Filter$2
  extends Filter
{
  Filter$2(Description paramDescription) {}
  
  public String describe()
  {
    return String.format("Method %s", new Object[] { this.val$desiredDescription.getDisplayName() });
  }
  
  public boolean shouldRun(Description paramDescription)
  {
    if (paramDescription.isTest()) {
      return this.val$desiredDescription.equals(paramDescription);
    }
    paramDescription = paramDescription.getChildren().iterator();
    while (paramDescription.hasNext()) {
      if (shouldRun((Description)paramDescription.next())) {
        return true;
      }
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     org.junit.runner.manipulation.Filter.2
 * JD-Core Version:    0.7.0.1
 */