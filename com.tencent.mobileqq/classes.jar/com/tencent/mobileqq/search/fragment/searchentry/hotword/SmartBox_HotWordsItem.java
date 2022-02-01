package com.tencent.mobileqq.search.fragment.searchentry.hotword;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class SmartBox_HotWordsItem
  extends JceStruct
{
  public int bubbleCanClose = 1;
  public int iBubbleStyle = 0;
  public int iClickCount = 0;
  public int iDisplayPosition = -1;
  public int iDuration = 0;
  public long iEndTimeStamp = 0L;
  public int iExposureCount = 0;
  public int iId = 0;
  public int iIsForcedInsertion = 0;
  public int iSubType = 0;
  public int iType = 0;
  public int iWordSource = 0;
  public String sAppend = "";
  public String sIcon = "";
  public String sItemExtInfo = "";
  public String sShowTitle = "";
  public String sSubShowTitle = "";
  public String sTagUrl = "";
  public String sTextColor = "";
  public String sTextSize = "";
  public String sTitle = "";
  public String sUrl = "";
  public String symbolUrl = "";
  
  public SmartBox_HotWordsItem() {}
  
  public SmartBox_HotWordsItem(String paramString1, int paramInt1, int paramInt2, String paramString2, String paramString3, String paramString4, int paramInt3, int paramInt4, String paramString5, int paramInt5, String paramString6, int paramInt6, int paramInt7, long paramLong, String paramString7, int paramInt8, int paramInt9, int paramInt10, int paramInt11, String paramString8, String paramString9, String paramString10, String paramString11)
  {
    this.sTitle = paramString1;
    this.iType = paramInt1;
    this.iId = paramInt2;
    this.sShowTitle = paramString2;
    this.sIcon = paramString3;
    this.sUrl = paramString4;
    this.iExposureCount = paramInt3;
    this.iClickCount = paramInt4;
    this.sAppend = paramString5;
    this.iSubType = paramInt5;
    this.sSubShowTitle = paramString6;
    this.iBubbleStyle = paramInt6;
    this.iDuration = paramInt7;
    this.iEndTimeStamp = paramLong;
    this.symbolUrl = paramString7;
    this.bubbleCanClose = paramInt8;
    this.iDisplayPosition = paramInt9;
    this.iIsForcedInsertion = paramInt10;
    this.iWordSource = paramInt11;
    this.sItemExtInfo = paramString8;
    this.sTextSize = paramString9;
    this.sTextColor = paramString10;
    this.sTagUrl = paramString11;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.sTitle = paramJceInputStream.readString(0, false);
    this.iType = paramJceInputStream.read(this.iType, 1, false);
    this.iId = paramJceInputStream.read(this.iId, 2, false);
    this.sShowTitle = paramJceInputStream.readString(3, false);
    this.sIcon = paramJceInputStream.readString(4, false);
    this.sUrl = paramJceInputStream.readString(5, false);
    this.iExposureCount = paramJceInputStream.read(this.iExposureCount, 6, false);
    this.iClickCount = paramJceInputStream.read(this.iClickCount, 7, false);
    this.sAppend = paramJceInputStream.readString(8, false);
    this.iSubType = paramJceInputStream.read(this.iSubType, 9, false);
    this.sSubShowTitle = paramJceInputStream.readString(10, false);
    this.iBubbleStyle = paramJceInputStream.read(this.iBubbleStyle, 11, false);
    this.iDuration = paramJceInputStream.read(this.iDuration, 12, false);
    this.iEndTimeStamp = paramJceInputStream.read(this.iEndTimeStamp, 13, false);
    this.symbolUrl = paramJceInputStream.readString(14, false);
    this.bubbleCanClose = paramJceInputStream.read(this.bubbleCanClose, 15, false);
    this.iDisplayPosition = paramJceInputStream.read(this.iDisplayPosition, 16, false);
    this.iIsForcedInsertion = paramJceInputStream.read(this.iIsForcedInsertion, 17, false);
    this.iWordSource = paramJceInputStream.read(this.iWordSource, 18, false);
    this.sItemExtInfo = paramJceInputStream.readString(19, false);
    this.sTextSize = paramJceInputStream.readString(20, false);
    this.sTextColor = paramJceInputStream.readString(21, false);
    this.sTagUrl = paramJceInputStream.readString(22, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    if (this.sTitle != null) {
      paramJceOutputStream.write(this.sTitle, 0);
    }
    paramJceOutputStream.write(this.iType, 1);
    paramJceOutputStream.write(this.iId, 2);
    if (this.sShowTitle != null) {
      paramJceOutputStream.write(this.sShowTitle, 3);
    }
    if (this.sIcon != null) {
      paramJceOutputStream.write(this.sIcon, 4);
    }
    if (this.sUrl != null) {
      paramJceOutputStream.write(this.sUrl, 5);
    }
    paramJceOutputStream.write(this.iExposureCount, 6);
    paramJceOutputStream.write(this.iClickCount, 7);
    if (this.sAppend != null) {
      paramJceOutputStream.write(this.sAppend, 8);
    }
    paramJceOutputStream.write(this.iSubType, 9);
    if (this.sSubShowTitle != null) {
      paramJceOutputStream.write(this.sSubShowTitle, 10);
    }
    paramJceOutputStream.write(this.iBubbleStyle, 11);
    paramJceOutputStream.write(this.iDuration, 12);
    paramJceOutputStream.write(this.iEndTimeStamp, 13);
    if (this.symbolUrl != null) {
      paramJceOutputStream.write(this.symbolUrl, 14);
    }
    paramJceOutputStream.write(this.bubbleCanClose, 15);
    paramJceOutputStream.write(this.iDisplayPosition, 16);
    paramJceOutputStream.write(this.iIsForcedInsertion, 17);
    paramJceOutputStream.write(this.iWordSource, 18);
    if (this.sItemExtInfo != null) {
      paramJceOutputStream.write(this.sItemExtInfo, 19);
    }
    if (this.sTextSize != null) {
      paramJceOutputStream.write(this.sTextSize, 20);
    }
    if (this.sTextColor != null) {
      paramJceOutputStream.write(this.sTextColor, 21);
    }
    if (this.sTagUrl != null) {
      paramJceOutputStream.write(this.sTagUrl, 22);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.search.fragment.searchentry.hotword.SmartBox_HotWordsItem
 * JD-Core Version:    0.7.0.1
 */