package com.tencent.mobileqq.search.fragment.searchentry.hotword;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class SmartBox_HotWordsEgg
  extends JceStruct
{
  public long iEndTimeStamp = 0L;
  public int iExposureCount = 0;
  public int iId = 0;
  public int iWordId = 0;
  public String sAppend = "";
  public String sIcon = "";
  
  public SmartBox_HotWordsEgg() {}
  
  public SmartBox_HotWordsEgg(int paramInt1, String paramString1, int paramInt2, String paramString2, long paramLong, int paramInt3)
  {
    this.iId = paramInt1;
    this.sIcon = paramString1;
    this.iExposureCount = paramInt2;
    this.sAppend = paramString2;
    this.iEndTimeStamp = paramLong;
    this.iWordId = paramInt3;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.iId = paramJceInputStream.read(this.iId, 0, false);
    this.sIcon = paramJceInputStream.readString(1, false);
    this.iExposureCount = paramJceInputStream.read(this.iExposureCount, 2, false);
    this.sAppend = paramJceInputStream.readString(3, false);
    this.iEndTimeStamp = paramJceInputStream.read(this.iEndTimeStamp, 4, false);
    this.iWordId = paramJceInputStream.read(this.iWordId, 5, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.iId, 0);
    String str = this.sIcon;
    if (str != null) {
      paramJceOutputStream.write(str, 1);
    }
    paramJceOutputStream.write(this.iExposureCount, 2);
    str = this.sAppend;
    if (str != null) {
      paramJceOutputStream.write(str, 3);
    }
    paramJceOutputStream.write(this.iEndTimeStamp, 4);
    paramJceOutputStream.write(this.iWordId, 5);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.search.fragment.searchentry.hotword.SmartBox_HotWordsEgg
 * JD-Core Version:    0.7.0.1
 */