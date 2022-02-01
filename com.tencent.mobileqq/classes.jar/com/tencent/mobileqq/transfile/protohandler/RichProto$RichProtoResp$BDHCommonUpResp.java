package com.tencent.mobileqq.transfile.protohandler;

import com.tencent.mobileqq.transfile.ServerAddr;
import java.util.ArrayList;

public class RichProto$RichProtoResp$BDHCommonUpResp
  extends RichProto.RichProtoResp.RespCommon
{
  public String bigDownUrl = "";
  public int blockSize;
  public String downDomain = "";
  public long groupFileID;
  public boolean isExist;
  public boolean isUseBdh = false;
  public ArrayList<ServerAddr> mIpList = new ArrayList();
  public String mUkey;
  public boolean networkChange = false;
  public String orgiDownUrl = "";
  public String resid = "";
  public long startOffset = 0L;
  public String thumbDownUrl = "";
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
    localStringBuilder.append(" downDomain:");
    localStringBuilder.append(this.downDomain);
    localStringBuilder.append(" thumbDownUrl");
    localStringBuilder.append(this.thumbDownUrl);
    localStringBuilder.append(" bigDownUrl:");
    localStringBuilder.append(this.bigDownUrl);
    localStringBuilder.append(" orgiDownUrl:");
    localStringBuilder.append(this.orgiDownUrl);
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.transfile.protohandler.RichProto.RichProtoResp.BDHCommonUpResp
 * JD-Core Version:    0.7.0.1
 */