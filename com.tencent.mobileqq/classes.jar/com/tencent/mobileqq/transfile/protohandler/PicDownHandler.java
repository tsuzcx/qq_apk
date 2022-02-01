package com.tencent.mobileqq.transfile.protohandler;

import com.tencent.mobileqq.app.BaseMessageHandler;
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
    byte[] arrayOfByte = paramProtoResp.resp.getWupBuffer();
    RichProto.RichProtoReq localRichProtoReq = (RichProto.RichProtoReq)paramProtoReq.busiData;
    RichProto.RichProtoResp localRichProtoResp = localRichProtoReq.resp;
    StatictisInfo localStatictisInfo = paramProtoResp.statisInfo;
    boolean bool;
    if (localFromServiceMsg.getResultCode() != 1000)
    {
      int i = localFromServiceMsg.getResultCode();
      if ((i != 1002) && (i != 1013))
      {
        paramProtoReq = BaseMessageHandler.a(localFromServiceMsg);
        paramProtoResp = localFromServiceMsg.getBusinessFailMsg();
        if (paramProtoResp == null) {
          paramProtoResp = "";
        }
        setResult(-1, 9044, paramProtoReq, paramProtoResp, localStatictisInfo, localRichProtoResp.resps);
      }
      else
      {
        paramProtoReq = BaseMessageHandler.a(localFromServiceMsg);
        paramProtoResp = localFromServiceMsg.getBusinessFailMsg();
        if (paramProtoResp == null) {
          paramProtoResp = "";
        }
        setResult(-1, 9311, paramProtoReq, paramProtoResp, localStatictisInfo, localRichProtoResp.resps);
      }
      bool = true;
    }
    else
    {
      bool = handleSucResponse(paramProtoResp, paramProtoReq, localFromServiceMsg, arrayOfByte, localRichProtoReq, localRichProtoResp, localStatictisInfo);
    }
    if (bool) {
      RichProtoProc.onBusiProtoResp(localRichProtoReq, localRichProtoResp);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.transfile.protohandler.PicDownHandler
 * JD-Core Version:    0.7.0.1
 */