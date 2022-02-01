package org.apache.commons.io;

import java.io.File;

class FileDeleteStrategy$ForceFileDeleteStrategy
  extends FileDeleteStrategy
{
  FileDeleteStrategy$ForceFileDeleteStrategy()
  {
    super("Force");
  }
  
  protected boolean doDelete(File paramFile)
  {
    FileUtils.forceDelete(paramFile);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     org.apache.commons.io.FileDeleteStrategy.ForceFileDeleteStrategy
 * JD-Core Version:    0.7.0.1
 */