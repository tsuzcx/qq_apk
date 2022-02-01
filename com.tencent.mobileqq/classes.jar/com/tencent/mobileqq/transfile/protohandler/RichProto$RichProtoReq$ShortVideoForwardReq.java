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
    localStringBuilder.append(" fromChatType:").append(this.fromChatType);
    localStringBuilder.append(" toChatType:").append(this.toChatType);
    localStringBuilder.append(" fromBusiType:").append(this.fromBusiType);
    localStringBuilder.append(" toBusiType:").append(this.toBusiType);
    localStringBuilder.append(" md5:").append(HexUtil.bytes2HexStr(this.md5));
    localStringBuilder.append(" format:").append(this.format);
    localStringBuilder.append(" str_file_name:").append(this.fileName);
    localStringBuilder.append(" uint64_file_size:").append(this.fileSize);
    localStringBuilder.append(" fileTime:").append(this.fileTime);
    localStringBuilder.append(" uuid:").append(this.uuid);
    localStringBuilder.append(" fromUin:").append(this.fromUin);
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.transfile.protohandler.RichProto.RichProtoReq.ShortVideoForwardReq
 * JD-Core Version:    0.7.0.1
 */