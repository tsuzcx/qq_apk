package com.tencent.mobileqq.troop.essence.data;

import java.io.Serializable;

public class TroopCardEssenceMsg$EssenceMsgContent
  implements Serializable
{
  public int faceIndext;
  public String faceText;
  public String fileName;
  public long fileSize;
  public String fileThumbnailUrl;
  public String imageThumbnailUrl;
  public String imageUrl;
  public String jumpUrlForMore;
  public int msgType;
  public String shareAction;
  public String shareBrief;
  public String shareImageUrl;
  public String shareSource;
  public String shareSummary;
  public String shareTitle;
  public String shareUrl;
  public String text;
  
  public TroopCardEssenceMsg$EssenceMsgContent(TroopCardEssenceMsg paramTroopCardEssenceMsg) {}
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("EssenceMsgContent{msgType=");
    localStringBuilder.append(this.msgType);
    localStringBuilder.append(", text='");
    localStringBuilder.append(this.text);
    localStringBuilder.append('\'');
    localStringBuilder.append(", faceIndext=");
    localStringBuilder.append(this.faceIndext);
    localStringBuilder.append(", faceText='");
    localStringBuilder.append(this.faceText);
    localStringBuilder.append('\'');
    localStringBuilder.append(", imageUrl='");
    localStringBuilder.append(this.imageUrl);
    localStringBuilder.append('\'');
    localStringBuilder.append(", imageThumbnailUrl='");
    localStringBuilder.append(this.imageThumbnailUrl);
    localStringBuilder.append('\'');
    localStringBuilder.append(", shareTitle='");
    localStringBuilder.append(this.shareTitle);
    localStringBuilder.append('\'');
    localStringBuilder.append(", shareSummary='");
    localStringBuilder.append(this.shareSummary);
    localStringBuilder.append('\'');
    localStringBuilder.append(", shareBrief='");
    localStringBuilder.append(this.shareBrief);
    localStringBuilder.append('\'');
    localStringBuilder.append(", shareUrl='");
    localStringBuilder.append(this.shareUrl);
    localStringBuilder.append('\'');
    localStringBuilder.append(", shareAction='");
    localStringBuilder.append(this.shareAction);
    localStringBuilder.append('\'');
    localStringBuilder.append(", shareSource='");
    localStringBuilder.append(this.shareSource);
    localStringBuilder.append('\'');
    localStringBuilder.append(", shareImageUrl='");
    localStringBuilder.append(this.shareImageUrl);
    localStringBuilder.append('\'');
    localStringBuilder.append(", fileName='");
    localStringBuilder.append(this.fileName);
    localStringBuilder.append('\'');
    localStringBuilder.append(", fileSize=");
    localStringBuilder.append(this.fileSize);
    localStringBuilder.append(", fileThumbnailUrl='");
    localStringBuilder.append(this.fileThumbnailUrl);
    localStringBuilder.append('\'');
    localStringBuilder.append(", jumpUrlForMore='");
    localStringBuilder.append(this.jumpUrlForMore);
    localStringBuilder.append('\'');
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.troop.essence.data.TroopCardEssenceMsg.EssenceMsgContent
 * JD-Core Version:    0.7.0.1
 */