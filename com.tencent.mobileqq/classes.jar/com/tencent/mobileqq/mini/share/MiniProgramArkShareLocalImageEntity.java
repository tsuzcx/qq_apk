package com.tencent.mobileqq.mini.share;

import aukm;
import java.io.Serializable;

public class MiniProgramArkShareLocalImageEntity
  extends aukm
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
    return "MiniProgramArkShareLocalImageEntity{arkPath='" + this.arkPath + '\'' + ", localPath='" + this.localPath + '\'' + '}';
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.mini.share.MiniProgramArkShareLocalImageEntity
 * JD-Core Version:    0.7.0.1
 */