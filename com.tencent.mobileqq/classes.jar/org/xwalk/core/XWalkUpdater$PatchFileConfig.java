package org.xwalk.core;

public class XWalkUpdater$PatchFileConfig
{
  public String originalFileName;
  public int originalFileType;
  public String patchEndFileMd5;
  public String patchFileName;
  public int type;
  
  public boolean isExtractedFile()
  {
    return this.originalFileType == 2;
  }
  
  public boolean isOriginalFileTypeApk()
  {
    return this.originalFileType == 1;
  }
  
  public boolean isTypeAdd()
  {
    return this.type == 1;
  }
  
  public boolean isTypeModify()
  {
    return this.type == 2;
  }
  
  public boolean isTypeRemove()
  {
    return this.type == 3;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("PatchFileConfig type:");
    localStringBuilder.append(this.type);
    localStringBuilder.append(",originalFileType:");
    localStringBuilder.append(this.originalFileType);
    localStringBuilder.append(",originalFileName:");
    localStringBuilder.append(this.originalFileName);
    localStringBuilder.append(",patchFileName:");
    localStringBuilder.append(this.patchFileName);
    localStringBuilder.append(",patchEndFileMd5:");
    localStringBuilder.append(this.patchEndFileMd5);
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     org.xwalk.core.XWalkUpdater.PatchFileConfig
 * JD-Core Version:    0.7.0.1
 */