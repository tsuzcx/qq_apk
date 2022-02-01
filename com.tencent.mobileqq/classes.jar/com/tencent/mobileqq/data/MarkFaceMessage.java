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
  public long beginTime = 0L;
  public int cFaceInfo = 1;
  public int cSubType = 3;
  public String copywritingContent;
  public int copywritingType = 0;
  public int dwMSGItemType = 6;
  public int dwTabID;
  public long endTime = 0L;
  public String faceName = null;
  public String from;
  public boolean hasIpProduct = false;
  public int imageHeight = 0;
  public int imageWidth = 0;
  public long index = 0L;
  public boolean isAPNG = false;
  public boolean isReword = false;
  public String jumpUrl;
  public int mediaType = 0;
  public byte[] mobileparam;
  public byte[] resvAttr;
  public byte[] sbfKey;
  public byte[] sbufID;
  public boolean shouldDisplay = false;
  public boolean showIpProduct = false;
  public EmojiStickerManager.StickerInfo stickerInfo = null;
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