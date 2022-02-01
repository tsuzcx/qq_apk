package com.tencent.mobileqq.data;

import com.tencent.mobileqq.emoticon.StickerInfo;
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
  public StickerInfo stickerInfo = null;
  public List<Integer> voicePrintItems;
  public String volumeColor;
  public int wSize = 37;
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("MarkFaceMessage{index=");
    localStringBuilder.append(this.index);
    localStringBuilder.append(", faceName='");
    localStringBuilder.append(this.faceName);
    localStringBuilder.append('\'');
    localStringBuilder.append(", dwMSGItemType=");
    localStringBuilder.append(this.dwMSGItemType);
    localStringBuilder.append(", cFaceInfo=");
    localStringBuilder.append(this.cFaceInfo);
    localStringBuilder.append(", wSize=");
    localStringBuilder.append(this.wSize);
    localStringBuilder.append(", sbufID=");
    localStringBuilder.append(Arrays.toString(this.sbufID));
    localStringBuilder.append(", dwTabID=");
    localStringBuilder.append(this.dwTabID);
    localStringBuilder.append(", cSubType=");
    localStringBuilder.append(this.cSubType);
    localStringBuilder.append(", hasIpProduct=");
    localStringBuilder.append(this.hasIpProduct);
    localStringBuilder.append(", showIpProduct=");
    localStringBuilder.append(this.showIpProduct);
    localStringBuilder.append(", sbfKey=");
    localStringBuilder.append(Arrays.toString(this.sbfKey));
    localStringBuilder.append(", mediaType=");
    localStringBuilder.append(this.mediaType);
    localStringBuilder.append(", imageWidth=");
    localStringBuilder.append(this.imageWidth);
    localStringBuilder.append(", imageHeight=");
    localStringBuilder.append(this.imageHeight);
    localStringBuilder.append(", mobileparam=");
    localStringBuilder.append(Arrays.toString(this.mobileparam));
    localStringBuilder.append(", resvAttr=");
    localStringBuilder.append(Arrays.toString(this.resvAttr));
    localStringBuilder.append(", isReword=");
    localStringBuilder.append(this.isReword);
    localStringBuilder.append(", copywritingType=");
    localStringBuilder.append(this.copywritingType);
    localStringBuilder.append(", copywritingContent='");
    localStringBuilder.append(this.copywritingContent);
    localStringBuilder.append('\'');
    localStringBuilder.append(", jumpUrl='");
    localStringBuilder.append(this.jumpUrl);
    localStringBuilder.append('\'');
    localStringBuilder.append(", shouldDisplay=");
    localStringBuilder.append(this.shouldDisplay);
    localStringBuilder.append(", stickerInfo=");
    localStringBuilder.append(this.stickerInfo);
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.data.MarkFaceMessage
 * JD-Core Version:    0.7.0.1
 */