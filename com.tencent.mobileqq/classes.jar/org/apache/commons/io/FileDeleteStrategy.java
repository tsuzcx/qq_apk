package org.apache.commons.io;

import java.io.File;
import java.io.IOException;

public class FileDeleteStrategy
{
  public static final FileDeleteStrategy FORCE = new FileDeleteStrategy.ForceFileDeleteStrategy();
  public static final FileDeleteStrategy NORMAL = new FileDeleteStrategy("Normal");
  private final String name;
  
  protected FileDeleteStrategy(String paramString)
  {
    this.name = paramString;
  }
  
  public void delete(File paramFile)
  {
    if ((paramFile.exists()) && (!doDelete(paramFile))) {
      throw new IOException("Deletion failed: " + paramFile);
    }
  }
  
  public boolean deleteQuietly(File paramFile)
  {
    if ((paramFile == null) || (!paramFile.exists())) {
      return true;
    }
    try
    {
      boolean bool = doDelete(paramFile);
      return bool;
    }
    catch (IOException paramFile) {}
    return false;
  }
  
  protected boolean doDelete(File paramFile)
  {
    return paramFile.delete();
  }
  
  public String toString()
  {
    return "FileDeleteStrategy[" + this.name + "]";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     org.apache.commons.io.FileDeleteStrategy
 * JD-Core Version:    0.7.0.1
 */