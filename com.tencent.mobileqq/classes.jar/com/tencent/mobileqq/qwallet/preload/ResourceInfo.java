package com.tencent.mobileqq.qwallet.preload;

import java.io.Serializable;

public class ResourceInfo
  implements Serializable
{
  private static final long serialVersionUID = 1L;
  public long doneTime;
  public String fileMd5;
  public String filePath;
  public String folderPath;
  public String resId;
  public int type;
  public String url;
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("ResourceInfo{url='");
    localStringBuilder.append(this.url);
    localStringBuilder.append('\'');
    localStringBuilder.append(", filePath='");
    localStringBuilder.append(this.filePath);
    localStringBuilder.append('\'');
    localStringBuilder.append(", fileMd5='");
    localStringBuilder.append(this.fileMd5);
    localStringBuilder.append('\'');
    localStringBuilder.append(", doneTime=");
    localStringBuilder.append(this.doneTime);
    localStringBuilder.append(", type=");
    localStringBuilder.append(this.type);
    localStringBuilder.append(", folderPath='");
    localStringBuilder.append(this.folderPath);
    localStringBuilder.append('\'');
    localStringBuilder.append(", resId='");
    localStringBuilder.append(this.resId);
    localStringBuilder.append('\'');
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qwallet.preload.ResourceInfo
 * JD-Core Version:    0.7.0.1
 */