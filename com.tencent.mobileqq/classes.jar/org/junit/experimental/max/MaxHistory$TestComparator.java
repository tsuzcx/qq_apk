package org.junit.experimental.max;

import java.util.Comparator;
import org.junit.runner.Description;

class MaxHistory$TestComparator
  implements Comparator<Description>
{
  private MaxHistory$TestComparator(MaxHistory paramMaxHistory) {}
  
  private Long getFailure(Description paramDescription)
  {
    Long localLong = this.this$0.getFailureTimestamp(paramDescription);
    paramDescription = localLong;
    if (localLong == null) {
      paramDescription = Long.valueOf(0L);
    }
    return paramDescription;
  }
  
  public int compare(Description paramDescription1, Description paramDescription2)
  {
    if (this.this$0.isNewTest(paramDescription1)) {
      return -1;
    }
    if (this.this$0.isNewTest(paramDescription2)) {
      return 1;
    }
    int i = getFailure(paramDescription2).compareTo(getFailure(paramDescription1));
    if (i != 0) {
      return i;
    }
    return this.this$0.getTestDuration(paramDescription1).compareTo(this.this$0.getTestDuration(paramDescription2));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     org.junit.experimental.max.MaxHistory.TestComparator
 * JD-Core Version:    0.7.0.1
 */