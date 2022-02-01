package com.tencent.mobileqq.transfile.protohandler;

import com.tencent.mobileqq.transfile.ServerAddr;
import java.util.ArrayList;

public class RichProto$RichProtoResp$GroupPttDownResp
  extends RichProto.RichProtoResp.RespCommon
{
  public String domainV4V6;
  public ArrayList<ServerAddr> mIpList = new ArrayList();
  public ArrayList<ServerAddr> mIpv6List = new ArrayList();
  public boolean mIsHttps;
  public String urlPath;
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.transfile.protohandler.RichProto.RichProtoResp.GroupPttDownResp
 * JD-Core Version:    0.7.0.1
 */