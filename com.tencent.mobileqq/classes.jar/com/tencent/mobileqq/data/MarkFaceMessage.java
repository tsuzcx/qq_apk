package com.tencent.mobileqq.data;

import com.tencent.mobileqq.emoticon.EmojiStickerManager.StickerInfo;
import java.io.Serializable;
import java.util.Arrays;
import java.util.List;

public class MarkFaceMessage
  implements Serializable
{
  public static final long serialVersionUID = 102222L;
  public String backColor;
  public long beginTime;
  public int cFaceInfo = 1;
  public int cSubType = 3;
  public String copywritingContent;
  public int copywritingType;
  public int dwMSGItemType = 6;
  public int dwTabID;
  public long endTime;
  public String faceName;
  public String from;
  public boolean hasIpProduct;
  public int imageHeight;
  public int imageWidth;
  public long index;
  public boolean isAPNG;
  public boolean isReword;
  public String jumpUrl;
  public int mediaType;
  public byte[] mobileparam;
  public byte[] resvAttr;
  public byte[] sbfKey;
  public byte[] sbufID;
  public boolean shouldDisplay;
  public boolean showIpProduct;
  public EmojiStickerManager.StickerInfo stickerInfo;
  public List<Integer> voicePrintItems;
  public String volumeColor;
  public int wSize = 37;
  
  public String toString()
  {
    return "MarkFaceMessage{index=" + this.index + ", faceName='" + this.faceName + '\'' + ", dwMSGItemType=" + this.dwMSGItemType + ", cFaceInfo=" + this.cFaceInfo + ", wSize=" + this.wSize + ", sbufID=" + Arrays.toString(this.sbufID) + ", dwTabID=" + this.dwTabID + ", cSubType=" + this.cSubType + ", hasIpProduct=" + this.hasIpProduct + ", showIpProduct=" + this.showIpProduct + ", sbfKey=" + Arrays.toString(this.sbfKey) + ", mediaType=" + this.mediaType + ", imageWidth=" + this.imageWidth + ", imageHeight=" + this.imageHeight + ", mobileparam=" + Arrays.toString(this.mobileparam) + ", resvAttr=" + Arrays.toString(this.resvAttr) + ", isReword=" + this.isReword + ", copywritingType=" + this.copywritingType + ", copywritingContent='" + this.copywritingContent + '\'' + ", jumpUrl='" + this.jumpUrl + '\'' + ", shouldDisplay=" + this.shouldDisplay + ", stickerInfo=" + this.stickerInfo + '}';
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.data.MarkFaceMessage
 * JD-Core Version:    0.7.0.1
 */