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
    if (paramFile.exists())
    {
      if (doDelete(paramFile)) {
        return;
      }
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("Deletion failed: ");
      localStringBuilder.append(paramFile);
      throw new IOException(localStringBuilder.toString());
    }
  }
  
  public boolean deleteQuietly(File paramFile)
  {
    if ((paramFile != null) && (paramFile.exists())) {}
    try
    {
      boolean bool = doDelete(paramFile);
      return bool;
    }
    catch (IOException paramFile)
    {
      label22:
      break label22;
    }
    return false;
    return true;
  }
  
  protected boolean doDelete(File paramFile)
  {
    return paramFile.delete();
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("FileDeleteStrategy[");
    localStringBuilder.append(this.name);
    localStringBuilder.append("]");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     org.apache.commons.io.FileDeleteStrategy
 * JD-Core Version:    0.7.0.1
 */