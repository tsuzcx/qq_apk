package org.apache.commons.io.comparator;

import java.io.File;
import java.io.Serializable;
import java.util.Comparator;

class ReverseComparator
  extends AbstractFileComparator
  implements Serializable
{
  private static final long serialVersionUID = -4808255005272229056L;
  private final Comparator<File> delegate;
  
  public ReverseComparator(Comparator<File> paramComparator)
  {
    if (paramComparator != null)
    {
      this.delegate = paramComparator;
      return;
    }
    throw new IllegalArgumentException("Delegate comparator is missing");
  }
  
  public int compare(File paramFile1, File paramFile2)
  {
    return this.delegate.compare(paramFile2, paramFile1);
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(super.toString());
    localStringBuilder.append("[");
    localStringBuilder.append(this.delegate.toString());
    localStringBuilder.append("]");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     org.apache.commons.io.comparator.ReverseComparator
 * JD-Core Version:    0.7.0.1
 */