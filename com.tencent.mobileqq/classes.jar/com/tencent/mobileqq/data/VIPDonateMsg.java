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
    return "VIPDonateMsg [title=" + this.title + ", subTitle=" + this.subTitle + ", footer=" + this.footer + ", jumpUrl=" + this.jumpUrl + ", brief=" + this.brief + "]";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.data.VIPDonateMsg
 * JD-Core Version:    0.7.0.1
 */