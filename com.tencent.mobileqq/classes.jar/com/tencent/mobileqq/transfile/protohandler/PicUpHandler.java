package com.tencent.mobileqq.transfile.protohandler;

import com.tencent.mobileqq.app.MessageHandler;
import com.tencent.mobileqq.app.StatictisInfo;
import com.tencent.mobileqq.transfile.api.impl.ProtoReqManagerImpl.ProtoReq;
import com.tencent.mobileqq.transfile.api.impl.ProtoReqManagerImpl.ProtoResp;
import com.tencent.qphone.base.remote.FromServiceMsg;

public abstract class PicUpHandler
  extends BaseHandler
{
  protected abstract void handleSucResp(FromServiceMsg paramFromServiceMsg, byte[] paramArrayOfByte, RichProto.RichProtoReq paramRichProtoReq, RichProto.RichProtoResp paramRichProtoResp, StatictisInfo paramStatictisInfo, ProtoReqManagerImpl.ProtoResp paramProtoResp, ProtoReqManagerImpl.ProtoReq paramProtoReq);
  
  public void onProtoResp(ProtoReqManagerImpl.ProtoResp paramProtoResp, ProtoReqManagerImpl.ProtoReq paramProtoReq)
  {
    FromServiceMsg localFromServiceMsg = paramProtoResp.resp;
    Object localObject = paramProtoResp.resp.getWupBuffer();
    RichProto.RichProtoReq localRichProtoReq = (RichProto.RichProtoReq)paramProtoReq.busiData;
    RichProto.RichProtoResp localRichProtoResp = localRichProtoReq.resp;
    StatictisInfo localStatictisInfo = paramProtoResp.statisInfo;
    int i;
    if (localFromServiceMsg.getResultCode() != 1000)
    {
      paramProtoResp = (String)localFromServiceMsg.getAttribute("_tag_socket_connerror", "");
      if ((paramProtoResp.equals("conSucc")) || (paramProtoResp.equals("")))
      {
        i = localFromServiceMsg.getResultCode();
        if ((i == 1002) || (i == 1013))
        {
          localObject = MessageHandler.b(localFromServiceMsg);
          paramProtoReq = localFromServiceMsg.getBusinessFailMsg();
          paramProtoResp = paramProtoReq;
          if (paramProtoReq == null) {
            paramProtoResp = "";
          }
          setResult(-1, 9311, (String)localObject, paramProtoResp, localStatictisInfo, localRichProtoResp.resps);
        }
      }
    }
    for (;;)
    {
      RichProtoProc.onBusiProtoResp(localRichProtoReq, localRichProtoResp);
      return;
      paramProtoReq = localFromServiceMsg.getBusinessFailMsg();
      paramProtoResp = paramProtoReq;
      if (paramProtoReq == null) {
        paramProtoResp = "";
      }
      setResult(-1, 9044, String.valueOf(i), paramProtoResp, localStatictisInfo, localRichProtoResp.resps);
      continue;
      setResult(-1, 9313, paramProtoResp, localFromServiceMsg.getBusinessFailMsg(), localStatictisInfo, localRichProtoResp.resps);
      continue;
      handleSucResp(localFromServiceMsg, (byte[])localObject, localRichProtoReq, localRichProtoResp, localStatictisInfo, paramProtoResp, paramProtoReq);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.transfile.protohandler.PicUpHandler
 * JD-Core Version:    0.7.0.1
 */