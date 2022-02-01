package org.apache.commons.io.filefilter;

import java.io.File;
import java.io.Serializable;
import java.util.Date;
import org.apache.commons.io.FileUtils;

public class AgeFileFilter
  extends AbstractFileFilter
  implements Serializable
{
  private static final long serialVersionUID = -2132740084016138541L;
  private final boolean acceptOlder;
  private final long cutoff;
  
  public AgeFileFilter(long paramLong)
  {
    this(paramLong, true);
  }
  
  public AgeFileFilter(long paramLong, boolean paramBoolean)
  {
    this.acceptOlder = paramBoolean;
    this.cutoff = paramLong;
  }
  
  public AgeFileFilter(File paramFile)
  {
    this(paramFile, true);
  }
  
  public AgeFileFilter(File paramFile, boolean paramBoolean)
  {
    this(paramFile.lastModified(), paramBoolean);
  }
  
  public AgeFileFilter(Date paramDate)
  {
    this(paramDate, true);
  }
  
  public AgeFileFilter(Date paramDate, boolean paramBoolean)
  {
    this(paramDate.getTime(), paramBoolean);
  }
  
  public boolean accept(File paramFile)
  {
    boolean bool2 = FileUtils.isFileNewer(paramFile, this.cutoff);
    boolean bool1 = bool2;
    if (this.acceptOlder)
    {
      if (!bool2) {
        return true;
      }
      bool1 = false;
    }
    return bool1;
  }
  
  public String toString()
  {
    String str;
    if (this.acceptOlder) {
      str = "<=";
    } else {
      str = ">";
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(super.toString());
    localStringBuilder.append("(");
    localStringBuilder.append(str);
    localStringBuilder.append(this.cutoff);
    localStringBuilder.append(")");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     org.apache.commons.io.filefilter.AgeFileFilter
 * JD-Core Version:    0.7.0.1
 */