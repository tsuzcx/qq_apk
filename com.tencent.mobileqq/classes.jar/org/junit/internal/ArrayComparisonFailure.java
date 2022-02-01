package org.junit.internal;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ArrayComparisonFailure
  extends AssertionError
{
  private static final long serialVersionUID = 1L;
  private final List<Integer> fIndices = new ArrayList();
  private final String fMessage;
  
  public ArrayComparisonFailure(String paramString, AssertionError paramAssertionError, int paramInt)
  {
    this.fMessage = paramString;
    initCause(paramAssertionError);
    addDimension(paramInt);
  }
  
  public void addDimension(int paramInt)
  {
    this.fIndices.add(0, Integer.valueOf(paramInt));
  }
  
  public String getMessage()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    Object localObject = this.fMessage;
    if (localObject != null) {
      localStringBuilder.append((String)localObject);
    }
    localStringBuilder.append("arrays first differed at element ");
    localObject = this.fIndices.iterator();
    while (((Iterator)localObject).hasNext())
    {
      int i = ((Integer)((Iterator)localObject).next()).intValue();
      localStringBuilder.append("[");
      localStringBuilder.append(i);
      localStringBuilder.append("]");
    }
    localStringBuilder.append("; ");
    localStringBuilder.append(getCause().getMessage());
    return localStringBuilder.toString();
  }
  
  public String toString()
  {
    return getMessage();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     org.junit.internal.ArrayComparisonFailure
 * JD-Core Version:    0.7.0.1
 */