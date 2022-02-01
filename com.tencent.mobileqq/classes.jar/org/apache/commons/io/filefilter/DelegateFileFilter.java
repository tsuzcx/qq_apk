package org.apache.commons.io.filefilter;

import java.io.File;
import java.io.FileFilter;
import java.io.FilenameFilter;
import java.io.Serializable;

public class DelegateFileFilter
  extends AbstractFileFilter
  implements Serializable
{
  private static final long serialVersionUID = -8723373124984771318L;
  private final FileFilter fileFilter;
  private final FilenameFilter filenameFilter;
  
  public DelegateFileFilter(FileFilter paramFileFilter)
  {
    if (paramFileFilter != null)
    {
      this.fileFilter = paramFileFilter;
      this.filenameFilter = null;
      return;
    }
    throw new IllegalArgumentException("The FileFilter must not be null");
  }
  
  public DelegateFileFilter(FilenameFilter paramFilenameFilter)
  {
    if (paramFilenameFilter != null)
    {
      this.filenameFilter = paramFilenameFilter;
      this.fileFilter = null;
      return;
    }
    throw new IllegalArgumentException("The FilenameFilter must not be null");
  }
  
  public boolean accept(File paramFile)
  {
    FileFilter localFileFilter = this.fileFilter;
    if (localFileFilter != null) {
      return localFileFilter.accept(paramFile);
    }
    return super.accept(paramFile);
  }
  
  public boolean accept(File paramFile, String paramString)
  {
    FilenameFilter localFilenameFilter = this.filenameFilter;
    if (localFilenameFilter != null) {
      return localFilenameFilter.accept(paramFile, paramString);
    }
    return super.accept(paramFile, paramString);
  }
  
  public String toString()
  {
    Object localObject = this.fileFilter;
    if (localObject == null) {
      localObject = this.filenameFilter;
    }
    localObject = localObject.toString();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(super.toString());
    localStringBuilder.append("(");
    localStringBuilder.append((String)localObject);
    localStringBuilder.append(")");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     org.apache.commons.io.filefilter.DelegateFileFilter
 * JD-Core Version:    0.7.0.1
 */