package com.tencent.mobileqq.transfile.protohandler;

public class RichProto$RichProtoReq$ShortVideoUpReq
  extends RichProto.RichProtoReq.ReqCommon
{
  public int agentType;
  public int busiType;
  public int chatType;
  public int clientType;
  public String fileName;
  public int fileResLength;
  public int fileResWidth;
  public long fileSize;
  public int fileTime;
  public int format;
  public byte[] md5;
  public int seq;
  public int subBusiType;
  public byte[] thumbFileMd5;
  public long thumbFileSize;
  public String troopUin;
  public int userCnt;
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(" chatType:");
    localStringBuilder.append(this.chatType);
    localStringBuilder.append(" md5:");
    localStringBuilder.append(this.md5);
    localStringBuilder.append(" format:");
    localStringBuilder.append(this.format);
    localStringBuilder.append(" str_file_name:");
    localStringBuilder.append(this.fileName);
    localStringBuilder.append(" uint64_file_size:");
    localStringBuilder.append(this.fileSize);
    localStringBuilder.append(" fileTime:");
    localStringBuilder.append(this.fileTime);
    localStringBuilder.append(" busiType:");
    localStringBuilder.append(this.busiType);
    localStringBuilder.append(" subBusiType:");
    localStringBuilder.append(this.subBusiType);
    localStringBuilder.append(" userCnt:");
    localStringBuilder.append(this.userCnt);
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.transfile.protohandler.RichProto.RichProtoReq.ShortVideoUpReq
 * JD-Core Version:    0.7.0.1
 */