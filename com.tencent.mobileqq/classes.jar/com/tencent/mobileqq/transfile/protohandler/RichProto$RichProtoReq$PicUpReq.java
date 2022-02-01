package com.tencent.mobileqq.transfile.protohandler;

import com.qq.taf.jce.HexUtil;

public class RichProto$RichProtoReq$PicUpReq
  extends RichProto.RichProtoReq.ReqCommon
{
  public int busiType;
  public String fileName;
  public long fileSize;
  public int height;
  public boolean isContact;
  public boolean isRaw;
  public boolean isSnapChat;
  public byte[] md5;
  public int picType;
  public String transferUrl;
  public int typeHotPic;
  public int width;
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(" name:");
    localStringBuilder.append(this.fileName);
    localStringBuilder.append(" width:");
    localStringBuilder.append(this.width);
    localStringBuilder.append(" height:");
    localStringBuilder.append(this.height);
    localStringBuilder.append(" size:");
    localStringBuilder.append(this.fileSize);
    localStringBuilder.append(" isRaw:");
    localStringBuilder.append(this.isRaw);
    localStringBuilder.append(" isContant:");
    localStringBuilder.append(this.isContact);
    localStringBuilder.append(" md5:");
    localStringBuilder.append(HexUtil.bytes2HexStr(this.md5));
    localStringBuilder.append(" picType:");
    localStringBuilder.append(this.picType);
    localStringBuilder.append(" busiType:");
    localStringBuilder.append(this.busiType);
    localStringBuilder.append("typeHotPic:");
    localStringBuilder.append(this.typeHotPic);
    localStringBuilder.append("transferUrl:");
    localStringBuilder.append(this.transferUrl);
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.transfile.protohandler.RichProto.RichProtoReq.PicUpReq
 * JD-Core Version:    0.7.0.1
 */