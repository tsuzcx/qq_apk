package com.tencent.mobileqq.qqgift.updatasystem.data;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;

public class QQGiftResConfigInfo
  implements Serializable
{
  @SerializedName("bg")
  public ResConfigDetailInfo bg = new ResConfigDetailInfo();
  @SerializedName("thumb")
  public ResConfigDetailInfo thumb = new ResConfigDetailInfo();
  
  public QQGiftResConfigInfo() {}
  
  public QQGiftResConfigInfo(ResConfigDetailInfo paramResConfigDetailInfo1, ResConfigDetailInfo paramResConfigDetailInfo2)
  {
    this.thumb = paramResConfigDetailInfo1;
    this.bg = paramResConfigDetailInfo2;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("QQGiftResConfigInfo{thumb=");
    localStringBuilder.append(this.thumb);
    localStringBuilder.append(", bg=");
    localStringBuilder.append(this.bg);
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqgift.updatasystem.data.QQGiftResConfigInfo
 * JD-Core Version:    0.7.0.1
 */