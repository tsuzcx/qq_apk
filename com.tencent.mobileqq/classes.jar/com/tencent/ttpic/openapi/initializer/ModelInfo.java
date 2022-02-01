package com.tencent.ttpic.openapi.initializer;

import com.tencent.ttpic.baseutils.io.FileUtils;
import java.io.File;

public class ModelInfo
  extends AEResourceInfo
{
  public String assetsDir;
  private boolean isEncrypted = false;
  private boolean mustUseSDCardPath = false;
  
  public ModelInfo(String paramString1, String paramString2)
  {
    this(false, false, paramString1, paramString2, 0);
  }
  
  public ModelInfo(String paramString1, String paramString2, int paramInt)
  {
    this(false, false, paramString1, paramString2, paramInt);
  }
  
  public ModelInfo(boolean paramBoolean, String paramString1, String paramString2)
  {
    this(paramBoolean, false, paramString1, paramString2, 0);
  }
  
  public ModelInfo(boolean paramBoolean, String paramString1, String paramString2, int paramInt)
  {
    this(paramBoolean, false, paramString1, paramString2, paramInt);
  }
  
  public ModelInfo(boolean paramBoolean1, boolean paramBoolean2, String paramString1, String paramString2, int paramInt)
  {
    if ((!paramString1.endsWith(File.separator)) && (!paramString1.equals(""))) {
      this.assetsDir = FileUtils.genSeperateFileDir(paramString1);
    } else {
      this.assetsDir = paramString1;
    }
    this.fileName = paramString2;
    this.mustUseSDCardPath = paramBoolean1;
    this.fileSizeBytes = paramInt;
    this.isEncrypted = paramBoolean2;
  }
  
  public String getAssetsDir()
  {
    return this.assetsDir;
  }
  
  public String getFullAssetsPathNoPrefix()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(getAssetsDir());
    localStringBuilder.append(this.fileName);
    return localStringBuilder.toString().replace("assets://", "");
  }
  
  public String getFullAssetsPathWithPrefix()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("assets://");
    localStringBuilder.append(getAssetsDir());
    localStringBuilder.append(this.fileName);
    return localStringBuilder.toString();
  }
  
  public boolean isEncrypted()
  {
    return this.isEncrypted;
  }
  
  public boolean isMustUseSDCardPath()
  {
    return this.mustUseSDCardPath;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.ttpic.openapi.initializer.ModelInfo
 * JD-Core Version:    0.7.0.1
 */