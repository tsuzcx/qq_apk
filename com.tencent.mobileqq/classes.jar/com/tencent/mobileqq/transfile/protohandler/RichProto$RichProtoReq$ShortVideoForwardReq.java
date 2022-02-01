package com.tencent.mobileqq.transfile.protohandler;

import com.qq.taf.jce.HexUtil;

public class RichProto$RichProtoReq$ShortVideoForwardReq
  extends RichProto.RichProtoReq.ReqCommon
{
  public int agentType;
  public int clientType;
  public String fileName;
  public int fileResLength;
  public int fileResWidth;
  public long fileSize;
  public int fileTime;
  public int format;
  public int fromBusiType;
  public int fromChatType;
  public String fromUin;
  public byte[] md5;
  public int seq;
  public byte[] thumbFileMd5;
  public long thumbFileSize;
  public int toBusiType;
  public int toChatType;
  public String troopUin;
  public String uuid;
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(" fromChatType:");
    localStringBuilder.append(this.fromChatType);
    localStringBuilder.append(" toChatType:");
    localStringBuilder.append(this.toChatType);
    localStringBuilder.append(" fromBusiType:");
    localStringBuilder.append(this.fromBusiType);
    localStringBuilder.append(" toBusiType:");
    localStringBuilder.append(this.toBusiType);
    localStringBuilder.append(" md5:");
    localStringBuilder.append(HexUtil.bytes2HexStr(this.md5));
    localStringBuilder.append(" format:");
    localStringBuilder.append(this.format);
    localStringBuilder.append(" str_file_name:");
    localStringBuilder.append(this.fileName);
    localStringBuilder.append(" uint64_file_size:");
    localStringBuilder.append(this.fileSize);
    localStringBuilder.append(" fileTime:");
    localStringBuilder.append(this.fileTime);
    localStringBuilder.append(" uuid:");
    localStringBuilder.append(this.uuid);
    localStringBuilder.append(" fromUin:");
    localStringBuilder.append(this.fromUin);
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.transfile.protohandler.RichProto.RichProtoReq.ShortVideoForwardReq
 * JD-Core Version:    0.7.0.1
 */