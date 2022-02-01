package org.apache.commons.io.filefilter;

import java.io.File;
import java.io.Serializable;

public class SizeFileFilter
  extends AbstractFileFilter
  implements Serializable
{
  private static final long serialVersionUID = 7388077430788600069L;
  private final boolean acceptLarger;
  private final long size;
  
  public SizeFileFilter(long paramLong)
  {
    this(paramLong, true);
  }
  
  public SizeFileFilter(long paramLong, boolean paramBoolean)
  {
    if (paramLong >= 0L)
    {
      this.size = paramLong;
      this.acceptLarger = paramBoolean;
      return;
    }
    throw new IllegalArgumentException("The size must be non-negative");
  }
  
  public boolean accept(File paramFile)
  {
    boolean bool;
    if (paramFile.length() < this.size) {
      bool = true;
    } else {
      bool = false;
    }
    if (this.acceptLarger) {
      return !bool;
    }
    return bool;
  }
  
  public String toString()
  {
    String str;
    if (this.acceptLarger) {
      str = ">=";
    } else {
      str = "<";
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(super.toString());
    localStringBuilder.append("(");
    localStringBuilder.append(str);
    localStringBuilder.append(this.size);
    localStringBuilder.append(")");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     org.apache.commons.io.filefilter.SizeFileFilter
 * JD-Core Version:    0.7.0.1
 */