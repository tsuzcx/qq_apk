package com.tencent.mobileqq.winkpublish.request.result;

import android.text.TextUtils;
import com.qq.taf.jce.JceDisplayer;
import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public class UploadFileResponse
  extends JceStruct
{
  private static final long serialVersionUID = -7484888819743554568L;
  public String albumId;
  public String clientFakeKey;
  public int height;
  public String md5;
  public int oheight;
  public String originId;
  public String originUploadUrl;
  public int owidth;
  public String photoId;
  public int picType;
  public String qunCode;
  public String slocId;
  public long uploadTime;
  public String url;
  public int width;
  
  public void display(StringBuilder paramStringBuilder, int paramInt)
  {
    paramStringBuilder = new JceDisplayer(paramStringBuilder, paramInt);
    paramStringBuilder.display(this.url, "appid");
    paramStringBuilder.display(this.albumId, "albumId");
    paramStringBuilder.display(this.photoId, "photoId");
    paramStringBuilder.display(this.slocId, "slocId");
    paramStringBuilder.display(this.width, "width");
    paramStringBuilder.display(this.height, "height");
    paramStringBuilder.display(this.owidth, "owidth");
    paramStringBuilder.display(this.oheight, "oheight");
    paramStringBuilder.display(this.picType, "picType");
    paramStringBuilder.display(this.clientFakeKey, "clientFakeKey");
    paramStringBuilder.display(this.uploadTime, "uploadTime");
    paramStringBuilder.display(this.originUploadUrl, "originUploadUrl");
    paramStringBuilder.display(this.md5, "md5");
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.url = paramJceInputStream.read(this.url, 0, false);
    this.albumId = paramJceInputStream.read(this.albumId, 1, false);
    this.photoId = paramJceInputStream.read(this.photoId, 2, false);
    this.slocId = paramJceInputStream.read(this.slocId, 3, false);
    this.width = paramJceInputStream.read(this.width, 4, false);
    this.height = paramJceInputStream.read(this.height, 5, false);
    this.owidth = paramJceInputStream.read(this.owidth, 6, false);
    this.oheight = paramJceInputStream.read(this.oheight, 7, false);
    this.picType = paramJceInputStream.read(this.picType, 8, false);
    this.clientFakeKey = paramJceInputStream.read(this.clientFakeKey, 9, false);
    this.uploadTime = paramJceInputStream.read(this.uploadTime, 10, false);
    this.originUploadUrl = paramJceInputStream.read(this.originUploadUrl, 11, false);
    this.qunCode = paramJceInputStream.read(this.qunCode, 12, false);
    this.md5 = paramJceInputStream.read(this.md5, 13, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    boolean bool = TextUtils.isEmpty(this.url);
    String str2 = "";
    String str1;
    if (bool) {
      str1 = "";
    } else {
      str1 = this.url;
    }
    paramJceOutputStream.write(str1, 0);
    if (TextUtils.isEmpty(this.albumId)) {
      str1 = "";
    } else {
      str1 = this.albumId;
    }
    paramJceOutputStream.write(str1, 1);
    if (TextUtils.isEmpty(this.photoId)) {
      str1 = "";
    } else {
      str1 = this.photoId;
    }
    paramJceOutputStream.write(str1, 2);
    if (TextUtils.isEmpty(this.slocId)) {
      str1 = "";
    } else {
      str1 = this.slocId;
    }
    paramJceOutputStream.write(str1, 3);
    paramJceOutputStream.write(this.width, 4);
    paramJceOutputStream.write(this.height, 5);
    paramJceOutputStream.write(this.owidth, 6);
    paramJceOutputStream.write(this.oheight, 7);
    paramJceOutputStream.write(this.picType, 8);
    if (TextUtils.isEmpty(this.clientFakeKey)) {
      str1 = "";
    } else {
      str1 = this.clientFakeKey;
    }
    paramJceOutputStream.write(str1, 9);
    paramJceOutputStream.write(this.uploadTime, 10);
    if (TextUtils.isEmpty(this.originUploadUrl)) {
      str1 = "";
    } else {
      str1 = this.originUploadUrl;
    }
    paramJceOutputStream.write(str1, 11);
    if (TextUtils.isEmpty(this.qunCode)) {
      str1 = "";
    } else {
      str1 = this.qunCode;
    }
    paramJceOutputStream.write(str1, 12);
    if (TextUtils.isEmpty(this.md5)) {
      str1 = str2;
    } else {
      str1 = this.md5;
    }
    paramJceOutputStream.write(str1, 13);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mobileqq.winkpublish.request.result.UploadFileResponse
 * JD-Core Version:    0.7.0.1
 */