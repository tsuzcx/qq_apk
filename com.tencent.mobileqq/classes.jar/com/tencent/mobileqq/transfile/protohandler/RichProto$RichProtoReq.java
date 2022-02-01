package com.tencent.mobileqq.transfile.protohandler;

import com.tencent.mobileqq.transfile.ProtoReqManager;
import com.tencent.mobileqq.transfile.ProtoReqManager.ProtoReq;
import java.util.ArrayList;
import java.util.List;

public class RichProto$RichProtoReq
{
  public RichProtoProc.RichProtoCallback callback;
  public int commandId;
  public byte[] extention;
  public String protoKey;
  public ProtoReqManager.ProtoReq protoReq;
  public ProtoReqManager protoReqMgr;
  public List<RichProto.RichProtoReq.ReqCommon> reqs = new ArrayList();
  RichProto.RichProtoResp resp = new RichProto.RichProtoResp();
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    int i = 0;
    while (i < this.reqs.size())
    {
      localStringBuilder.append("index:");
      localStringBuilder.append(i);
      localStringBuilder.append(" ");
      localStringBuilder.append(((RichProto.RichProtoReq.ReqCommon)this.reqs.get(i)).toString());
      i += 1;
    }
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.transfile.protohandler.RichProto.RichProtoReq
 * JD-Core Version:    0.7.0.1
 */