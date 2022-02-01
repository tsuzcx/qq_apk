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
    int i;
    if (this.this$0.isNewTest(paramDescription1)) {
      i = -1;
    }
    int j;
    do
    {
      return i;
      if (this.this$0.isNewTest(paramDescription2)) {
        return 1;
      }
      j = getFailure(paramDescription2).compareTo(getFailure(paramDescription1));
      i = j;
    } while (j != 0);
    return this.this$0.getTestDuration(paramDescription1).compareTo(this.this$0.getTestDuration(paramDescription2));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     org.junit.experimental.max.MaxHistory.TestComparator
 * JD-Core Version:    0.7.0.1
 */