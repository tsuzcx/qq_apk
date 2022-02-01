package com.tencent.mobileqq.transfile.protohandler;

import com.tencent.mobileqq.transfile.ServerAddr;
import java.util.ArrayList;

public class RichProto$RichProtoResp$MultiMsgUpResp
  extends RichProto.RichProtoResp.RespCommon
{
  public int blockSize;
  public ArrayList<ServerAddr> ipList = new ArrayList();
  public byte[] msgKey;
  public byte[] msgSig;
  public byte[] resId;
  public int transferedSize;
  public byte[] ukey;
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.transfile.protohandler.RichProto.RichProtoResp.MultiMsgUpResp
 * JD-Core Version:    0.7.0.1
 */