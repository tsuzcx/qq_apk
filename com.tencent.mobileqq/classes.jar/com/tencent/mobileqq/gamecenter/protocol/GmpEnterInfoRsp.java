package com.tencent.mobileqq.gamecenter.protocol;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class GmpEnterInfoRsp
  extends JceStruct
{
  public String appid;
  public int bubble_appear;
  public int bubble_disappear;
  public String bubble_id = "";
  public String content = "";
  public String err_str = "";
  public String icon = "";
  public int ret_code = 0;
  public int state = 0;
  public String tab_grayid;
  public String url = "";
  public int url_type = 0;
  
  public GmpEnterInfoRsp() {}
  
  public GmpEnterInfoRsp(int paramInt1, String paramString1, int paramInt2, String paramString2, String paramString3, String paramString4, int paramInt3, String paramString5, int paramInt4, int paramInt5, String paramString6, String paramString7)
  {
    this.ret_code = paramInt1;
    this.err_str = paramString1;
    this.state = paramInt2;
    this.icon = paramString2;
    this.content = paramString3;
    this.url = paramString4;
    this.url_type = paramInt3;
    this.bubble_id = paramString5;
    this.bubble_appear = paramInt4;
    this.bubble_disappear = paramInt5;
    this.appid = paramString6;
    this.tab_grayid = paramString7;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.ret_code = paramJceInputStream.read(this.ret_code, 0, false);
    this.err_str = paramJceInputStream.readString(1, false);
    this.state = paramJceInputStream.read(this.state, 2, false);
    this.icon = paramJceInputStream.readString(3, false);
    this.content = paramJceInputStream.readString(4, false);
    this.url = paramJceInputStream.readString(5, false);
    this.url_type = paramJceInputStream.read(this.url_type, 6, false);
    this.bubble_id = paramJceInputStream.readString(7, false);
    this.bubble_appear = paramJceInputStream.read(this.bubble_appear, 8, false);
    this.bubble_disappear = paramJceInputStream.read(this.bubble_disappear, 9, false);
    this.appid = paramJceInputStream.readString(10, false);
    this.tab_grayid = paramJceInputStream.readString(11, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.ret_code, 0);
    if (this.err_str != null) {
      paramJceOutputStream.write(this.err_str, 1);
    }
    paramJceOutputStream.write(this.state, 2);
    if (this.icon != null) {
      paramJceOutputStream.write(this.icon, 3);
    }
    if (this.content != null) {
      paramJceOutputStream.write(this.content, 4);
    }
    if (this.url != null) {
      paramJceOutputStream.write(this.url, 5);
    }
    paramJceOutputStream.write(this.url_type, 6);
    if (this.bubble_id != null) {
      paramJceOutputStream.write(this.bubble_id, 7);
    }
    paramJceOutputStream.write(this.bubble_appear, 8);
    paramJceOutputStream.write(this.bubble_disappear, 9);
    if (this.appid != null) {
      paramJceOutputStream.write(this.appid, 10);
    }
    if (this.tab_grayid != null) {
      paramJceOutputStream.write(this.tab_grayid, 11);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.gamecenter.protocol.GmpEnterInfoRsp
 * JD-Core Version:    0.7.0.1
 */