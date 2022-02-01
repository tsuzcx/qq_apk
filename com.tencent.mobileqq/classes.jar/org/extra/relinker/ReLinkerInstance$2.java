package org.extra.relinker;

import java.io.File;
import java.io.FilenameFilter;

class ReLinkerInstance$2
  implements FilenameFilter
{
  ReLinkerInstance$2(ReLinkerInstance paramReLinkerInstance, String paramString) {}
  
  public boolean accept(File paramFile, String paramString)
  {
    return paramString.startsWith(this.val$mappedLibraryName);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     org.extra.relinker.ReLinkerInstance.2
 * JD-Core Version:    0.7.0.1
 */