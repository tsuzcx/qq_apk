package com.tencent.mobileqq.qqgamepub.data;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class GmpEnterInfoRsp
  extends JceStruct
{
  public String appid;
  public int bubbleAppear;
  public int bubbleDisappear;
  public String bubbleId = "";
  public String content = "";
  public String errStr = "";
  public String icon = "";
  public int retCode = 0;
  public int state = 0;
  public String tabGrayid;
  public String url = "";
  public int urlType = 0;
  
  public GmpEnterInfoRsp() {}
  
  public GmpEnterInfoRsp(int paramInt1, String paramString1, int paramInt2, String paramString2, String paramString3, String paramString4, int paramInt3, String paramString5, int paramInt4, int paramInt5, String paramString6, String paramString7)
  {
    this.retCode = paramInt1;
    this.errStr = paramString1;
    this.state = paramInt2;
    this.icon = paramString2;
    this.content = paramString3;
    this.url = paramString4;
    this.urlType = paramInt3;
    this.bubbleId = paramString5;
    this.bubbleAppear = paramInt4;
    this.bubbleDisappear = paramInt5;
    this.appid = paramString6;
    this.tabGrayid = paramString7;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.retCode = paramJceInputStream.read(this.retCode, 0, false);
    this.errStr = paramJceInputStream.readString(1, false);
    this.state = paramJceInputStream.read(this.state, 2, false);
    this.icon = paramJceInputStream.readString(3, false);
    this.content = paramJceInputStream.readString(4, false);
    this.url = paramJceInputStream.readString(5, false);
    this.urlType = paramJceInputStream.read(this.urlType, 6, false);
    this.bubbleId = paramJceInputStream.readString(7, false);
    this.bubbleAppear = paramJceInputStream.read(this.bubbleAppear, 8, false);
    this.bubbleDisappear = paramJceInputStream.read(this.bubbleDisappear, 9, false);
    this.appid = paramJceInputStream.readString(10, false);
    this.tabGrayid = paramJceInputStream.readString(11, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.retCode, 0);
    String str = this.errStr;
    if (str != null) {
      paramJceOutputStream.write(str, 1);
    }
    paramJceOutputStream.write(this.state, 2);
    str = this.icon;
    if (str != null) {
      paramJceOutputStream.write(str, 3);
    }
    str = this.content;
    if (str != null) {
      paramJceOutputStream.write(str, 4);
    }
    str = this.url;
    if (str != null) {
      paramJceOutputStream.write(str, 5);
    }
    paramJceOutputStream.write(this.urlType, 6);
    str = this.bubbleId;
    if (str != null) {
      paramJceOutputStream.write(str, 7);
    }
    paramJceOutputStream.write(this.bubbleAppear, 8);
    paramJceOutputStream.write(this.bubbleDisappear, 9);
    str = this.appid;
    if (str != null) {
      paramJceOutputStream.write(str, 10);
    }
    str = this.tabGrayid;
    if (str != null) {
      paramJceOutputStream.write(str, 11);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqgamepub.data.GmpEnterInfoRsp
 * JD-Core Version:    0.7.0.1
 */