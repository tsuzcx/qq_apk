package com.tencent.mobileqq.troop.api.essence.data;

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
    return "EssenceMsgContent{msgType=" + this.msgType + ", text='" + this.text + '\'' + ", faceIndext=" + this.faceIndext + ", faceText='" + this.faceText + '\'' + ", imageUrl='" + this.imageUrl + '\'' + ", imageThumbnailUrl='" + this.imageThumbnailUrl + '\'' + ", shareTitle='" + this.shareTitle + '\'' + ", shareSummary='" + this.shareSummary + '\'' + ", shareBrief='" + this.shareBrief + '\'' + ", shareUrl='" + this.shareUrl + '\'' + ", shareAction='" + this.shareAction + '\'' + ", shareSource='" + this.shareSource + '\'' + ", shareImageUrl='" + this.shareImageUrl + '\'' + ", fileName='" + this.fileName + '\'' + ", fileSize=" + this.fileSize + ", fileThumbnailUrl='" + this.fileThumbnailUrl + '\'' + ", jumpUrlForMore='" + this.jumpUrlForMore + '\'' + '}';
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.troop.api.essence.data.TroopCardEssenceMsg.EssenceMsgContent
 * JD-Core Version:    0.7.0.1
 */