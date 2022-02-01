package com.tencent.mobileqq.transfile.protohandler;

import com.tencent.mobileqq.app.MessageHandler;
import com.tencent.mobileqq.app.StatictisInfo;
import com.tencent.mobileqq.transfile.api.impl.ProtoReqManagerImpl.ProtoReq;
import com.tencent.mobileqq.transfile.api.impl.ProtoReqManagerImpl.ProtoResp;
import com.tencent.qphone.base.remote.FromServiceMsg;

public abstract class PicDownHandler
  extends BaseHandler
{
  protected void handleRespIp() {}
  
  protected abstract boolean handleSucResponse(ProtoReqManagerImpl.ProtoResp paramProtoResp, ProtoReqManagerImpl.ProtoReq paramProtoReq, FromServiceMsg paramFromServiceMsg, byte[] paramArrayOfByte, RichProto.RichProtoReq paramRichProtoReq, RichProto.RichProtoResp paramRichProtoResp, StatictisInfo paramStatictisInfo);
  
  public void onProtoResp(ProtoReqManagerImpl.ProtoResp paramProtoResp, ProtoReqManagerImpl.ProtoReq paramProtoReq)
  {
    FromServiceMsg localFromServiceMsg = paramProtoResp.resp;
    Object localObject = paramProtoResp.resp.getWupBuffer();
    RichProto.RichProtoReq localRichProtoReq = (RichProto.RichProtoReq)paramProtoReq.busiData;
    RichProto.RichProtoResp localRichProtoResp = localRichProtoReq.resp;
    StatictisInfo localStatictisInfo = paramProtoResp.statisInfo;
    if (localFromServiceMsg.getResultCode() != 1000)
    {
      int i = localFromServiceMsg.getResultCode();
      if ((i == 1002) || (i == 1013))
      {
        localObject = MessageHandler.a(localFromServiceMsg);
        paramProtoReq = localFromServiceMsg.getBusinessFailMsg();
        paramProtoResp = paramProtoReq;
        if (paramProtoReq == null) {
          paramProtoResp = "";
        }
        setResult(-1, 9311, (String)localObject, paramProtoResp, localStatictisInfo, localRichProtoResp.resps);
      }
    }
    for (boolean bool = true;; bool = handleSucResponse(paramProtoResp, paramProtoReq, localFromServiceMsg, (byte[])localObject, localRichProtoReq, localRichProtoResp, localStatictisInfo))
    {
      if (bool) {
        RichProtoProc.onBusiProtoResp(localRichProtoReq, localRichProtoResp);
      }
      return;
      localObject = MessageHandler.a(localFromServiceMsg);
      paramProtoReq = localFromServiceMsg.getBusinessFailMsg();
      paramProtoResp = paramProtoReq;
      if (paramProtoReq == null) {
        paramProtoResp = "";
      }
      setResult(-1, 9044, (String)localObject, paramProtoResp, localStatictisInfo, localRichProtoResp.resps);
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.transfile.protohandler.PicDownHandler
 * JD-Core Version:    0.7.0.1
 */