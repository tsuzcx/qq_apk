package com.tencent.mobileqq.transfile.protohandler;

import com.tencent.mobileqq.transfile.ServerAddr;
import java.util.ArrayList;

public class RichProto$RichProtoResp$GroupPttUpResp
  extends RichProto.RichProtoResp.RespCommon
{
  public int blockSize;
  public long groupFileID;
  public byte[] groupFileKey;
  public ArrayList<ServerAddr> ipList = new ArrayList();
  public boolean isExist;
  public String mUkey;
  public int transferedSize;
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(super.toString());
    localStringBuilder.append(" fileID:");
    localStringBuilder.append(this.groupFileID);
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.transfile.protohandler.RichProto.RichProtoResp.GroupPttUpResp
 * JD-Core Version:    0.7.0.1
 */