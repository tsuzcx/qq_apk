package com.tencent.mobileqq.transfile.protohandler;

import com.tencent.mobileqq.transfile.ServerAddr;
import java.util.ArrayList;

public class RichProto$RichProtoResp$PicDownResp
  extends RichProto.RichProtoResp.RespCommon
{
  public String domain;
  public ArrayList<ServerAddr> mIpList = new ArrayList();
  public ArrayList<ServerAddr> mIpv6List = new ArrayList();
  public int protocolType;
  public String urlPath;
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.transfile.protohandler.RichProto.RichProtoResp.PicDownResp
 * JD-Core Version:    0.7.0.1
 */