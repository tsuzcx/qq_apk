package org.apache.commons.io.filefilter;

import java.io.File;
import java.io.Serializable;

public class EmptyFileFilter
  extends AbstractFileFilter
  implements Serializable
{
  public static final IOFileFilter EMPTY = new EmptyFileFilter();
  public static final IOFileFilter NOT_EMPTY = new NotFileFilter(EMPTY);
  private static final long serialVersionUID = 3631422087512832211L;
  
  public boolean accept(File paramFile)
  {
    boolean bool2 = paramFile.isDirectory();
    boolean bool1 = true;
    if (bool2)
    {
      paramFile = paramFile.listFiles();
      if (paramFile != null)
      {
        if (paramFile.length == 0) {
          return true;
        }
        bool1 = false;
      }
      return bool1;
    }
    return paramFile.length() == 0L;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     org.apache.commons.io.filefilter.EmptyFileFilter
 * JD-Core Version:    0.7.0.1
 */