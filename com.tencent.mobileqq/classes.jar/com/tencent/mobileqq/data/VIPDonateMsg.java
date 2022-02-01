package com.tencent.mobileqq.data;

import java.io.Serializable;

public class VIPDonateMsg
  implements Serializable
{
  public static final long serialVersionUID = 1L;
  public String brief;
  public String footer;
  public String jumpUrl;
  public String subTitle;
  public String title;
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("VIPDonateMsg [title=");
    localStringBuilder.append(this.title);
    localStringBuilder.append(", subTitle=");
    localStringBuilder.append(this.subTitle);
    localStringBuilder.append(", footer=");
    localStringBuilder.append(this.footer);
    localStringBuilder.append(", jumpUrl=");
    localStringBuilder.append(this.jumpUrl);
    localStringBuilder.append(", brief=");
    localStringBuilder.append(this.brief);
    localStringBuilder.append("]");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.data.VIPDonateMsg
 * JD-Core Version:    0.7.0.1
 */