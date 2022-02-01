package com.tencent.mobileqq.mini.share;

import com.tencent.mobileqq.persistence.Entity;
import java.io.Serializable;

public class MiniProgramArkShareLocalImageEntity
  extends Entity
  implements Serializable
{
  public String arkPath;
  public String localPath;
  
  public MiniProgramArkShareLocalImageEntity() {}
  
  public MiniProgramArkShareLocalImageEntity(String paramString1, String paramString2)
  {
    this.arkPath = paramString1;
    this.localPath = paramString2;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("MiniProgramArkShareLocalImageEntity{arkPath='");
    localStringBuilder.append(this.arkPath);
    localStringBuilder.append('\'');
    localStringBuilder.append(", localPath='");
    localStringBuilder.append(this.localPath);
    localStringBuilder.append('\'');
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.mini.share.MiniProgramArkShareLocalImageEntity
 * JD-Core Version:    0.7.0.1
 */