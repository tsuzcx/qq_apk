package com.tencent.mobileqq.campuscircle;

import java.io.Serializable;

public class CampusCircleManager$PicInfo
  implements Serializable
{
  public String md5 = "";
  public String path = "";
  public String url = "";
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("\nPicInfo");
    localStringBuilder.append("\n |-").append("path:").append(this.path);
    localStringBuilder.append("\n |-").append("md5:").append(this.md5);
    localStringBuilder.append("\n |-").append("url:").append(this.url);
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.mobileqq.campuscircle.CampusCircleManager.PicInfo
 * JD-Core Version:    0.7.0.1
 */