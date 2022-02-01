package org.apache.commons.io.filefilter;

import java.io.File;
import java.io.Serializable;

public class NotFileFilter
  extends AbstractFileFilter
  implements Serializable
{
  private static final long serialVersionUID = 6131563330944994230L;
  private final IOFileFilter filter;
  
  public NotFileFilter(IOFileFilter paramIOFileFilter)
  {
    if (paramIOFileFilter != null)
    {
      this.filter = paramIOFileFilter;
      return;
    }
    throw new IllegalArgumentException("The filter must not be null");
  }
  
  public boolean accept(File paramFile)
  {
    return this.filter.accept(paramFile) ^ true;
  }
  
  public boolean accept(File paramFile, String paramString)
  {
    return this.filter.accept(paramFile, paramString) ^ true;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(super.toString());
    localStringBuilder.append("(");
    localStringBuilder.append(this.filter.toString());
    localStringBuilder.append(")");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     org.apache.commons.io.filefilter.NotFileFilter
 * JD-Core Version:    0.7.0.1
 */