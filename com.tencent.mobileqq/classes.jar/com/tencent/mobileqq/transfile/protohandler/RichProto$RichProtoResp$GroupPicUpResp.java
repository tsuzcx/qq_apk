package com.tencent.mobileqq.transfile.protohandler;

import com.tencent.mobileqq.transfile.ServerAddr;
import java.util.ArrayList;

public class RichProto$RichProtoResp$GroupPicUpResp
  extends RichProto.RichProtoResp.RespCommon
{
  public int blockSize;
  public long groupFileID;
  public boolean isExist;
  public boolean isUseBdh = false;
  public ArrayList<ServerAddr> mIpList = new ArrayList();
  public String mUkey;
  public boolean networkChange = false;
  public long startOffset = 0L;
  public int transferedSize;
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(super.toString());
    localStringBuilder.append(" fileID:");
    localStringBuilder.append(this.groupFileID);
    localStringBuilder.append(" isExist:");
    localStringBuilder.append(this.isExist);
    localStringBuilder.append(" blockSize:");
    localStringBuilder.append(this.blockSize);
    localStringBuilder.append(" netChg:");
    localStringBuilder.append(this.networkChange);
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.transfile.protohandler.RichProto.RichProtoResp.GroupPicUpResp
 * JD-Core Version:    0.7.0.1
 */