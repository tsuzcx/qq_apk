package com.tencent.mobileqq.transfile.protohandler;

import com.tencent.mobileqq.transfile.ServerAddr;
import java.util.ArrayList;

public class RichProto$RichProtoResp$MultiMsgDownResp
  extends RichProto.RichProtoResp.RespCommon
{
  public ArrayList<ServerAddr> ipList = new ArrayList();
  public int mChannelType;
  public ArrayList<ServerAddr> mIpv6List = new ArrayList();
  public byte[] msgkey;
  public byte[] resId;
  public String urlParam;
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(super.toString());
    localStringBuilder.append(" urlParam:");
    localStringBuilder.append(this.urlParam);
    localStringBuilder.append(" msgUkey:");
    localStringBuilder.append(this.msgkey);
    localStringBuilder.append(" ipList:");
    localStringBuilder.append(this.ipList);
    localStringBuilder.append(" mIpv6List:");
    localStringBuilder.append(this.mIpv6List);
    localStringBuilder.append(" resId:");
    localStringBuilder.append(this.resId);
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.transfile.protohandler.RichProto.RichProtoResp.MultiMsgDownResp
 * JD-Core Version:    0.7.0.1
 */