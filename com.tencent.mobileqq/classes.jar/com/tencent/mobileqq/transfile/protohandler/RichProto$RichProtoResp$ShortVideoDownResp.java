package com.tencent.mobileqq.transfile.protohandler;

import com.qq.taf.jce.HexUtil;
import com.tencent.mobileqq.transfile.ServerAddr;
import java.util.ArrayList;

public class RichProto$RichProtoResp$ShortVideoDownResp
  extends RichProto.RichProtoResp.RespCommon
{
  public String mDomain;
  public int mHostType;
  public ArrayList<ServerAddr> mIpList = new ArrayList();
  public ArrayList<ServerAddr> mIpv6List = new ArrayList();
  public boolean mIsHttps;
  public boolean mIsQuicEncryption;
  public boolean mIsSupportQuic;
  public int mQuicFec;
  public String mUkey;
  public String mUrl;
  public byte[] md5;
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(super.toString());
    localStringBuilder.append(" mUkey:");
    localStringBuilder.append(this.mUkey);
    localStringBuilder.append(" mIpList:").append(this.mIpList.toString());
    localStringBuilder.append(" mIpv6List:").append(this.mIpv6List.toString());
    localStringBuilder.append(" md5:").append(HexUtil.bytes2HexStr(this.md5));
    localStringBuilder.append(" mIsSupportQuic:").append(this.mIsSupportQuic);
    localStringBuilder.append(" mIsQuicEncryption:").append(this.mIsQuicEncryption);
    localStringBuilder.append(" mQuicFec:").append(this.mQuicFec);
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.transfile.protohandler.RichProto.RichProtoResp.ShortVideoDownResp
 * JD-Core Version:    0.7.0.1
 */