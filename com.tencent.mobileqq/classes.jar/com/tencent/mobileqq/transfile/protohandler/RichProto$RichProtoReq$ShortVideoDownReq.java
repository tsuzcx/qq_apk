package com.tencent.mobileqq.transfile.protohandler;

import com.qq.taf.jce.HexUtil;

public class RichProto$RichProtoReq$ShortVideoDownReq
  extends RichProto.RichProtoReq.ReqCommon
{
  public int agentType;
  public int busiType;
  public int chatType;
  public int clientType;
  public int downType;
  public String fileId;
  public int fileType;
  public byte[] md5;
  public int sceneType;
  public int seq;
  public int subBusiType;
  public String troopUin;
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(" chatType:");
    localStringBuilder.append(this.chatType);
    localStringBuilder.append(" clientType:");
    localStringBuilder.append(this.clientType);
    localStringBuilder.append(" seq:");
    localStringBuilder.append(this.seq);
    localStringBuilder.append(" fileId:");
    localStringBuilder.append(this.fileId);
    localStringBuilder.append(" troopUin:");
    localStringBuilder.append(this.troopUin);
    localStringBuilder.append(" agentType:");
    localStringBuilder.append(this.agentType);
    localStringBuilder.append(" md5:");
    localStringBuilder.append(HexUtil.bytes2HexStr(this.md5));
    localStringBuilder.append(" busiType:");
    localStringBuilder.append(this.busiType);
    localStringBuilder.append(" fileType:");
    localStringBuilder.append(this.fileType);
    localStringBuilder.append(" downType:");
    localStringBuilder.append(this.downType);
    localStringBuilder.append(" sceneType:");
    localStringBuilder.append(this.sceneType);
    localStringBuilder.append(" subBusiType:");
    localStringBuilder.append(this.subBusiType);
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.transfile.protohandler.RichProto.RichProtoReq.ShortVideoDownReq
 * JD-Core Version:    0.7.0.1
 */