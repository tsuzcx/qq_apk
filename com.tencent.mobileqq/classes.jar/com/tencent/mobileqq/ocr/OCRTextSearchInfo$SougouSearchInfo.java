package com.tencent.mobileqq.ocr;

import java.io.Serializable;
import java.util.List;

public class OCRTextSearchInfo$SougouSearchInfo
  implements Serializable
{
  public String abstractStr = "";
  public List<String> abstractStrKeyWords;
  public String jumpURL = "";
  public String keyWord = "";
  public String sourceFrom = "";
  public String stype = "";
  public String summaryPic = "";
  public String title = "";
  public List<String> titleKeyWords;
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("\nSougouSearchInfo");
    localStringBuilder.append("\n |-");
    localStringBuilder.append("title:");
    localStringBuilder.append(this.title);
    localStringBuilder.append("\n |-");
    localStringBuilder.append("jumpURL:");
    localStringBuilder.append(this.jumpURL);
    localStringBuilder.append("\n |-");
    localStringBuilder.append("summaryPic:");
    localStringBuilder.append(this.summaryPic);
    localStringBuilder.append("\n |-");
    localStringBuilder.append("titleKeyWords:");
    localStringBuilder.append(this.titleKeyWords);
    localStringBuilder.append("\n |-");
    localStringBuilder.append("abstractStrKeyWords:");
    localStringBuilder.append(this.abstractStrKeyWords);
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.ocr.OCRTextSearchInfo.SougouSearchInfo
 * JD-Core Version:    0.7.0.1
 */