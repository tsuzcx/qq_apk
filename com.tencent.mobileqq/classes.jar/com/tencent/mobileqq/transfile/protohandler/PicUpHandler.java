package com.tencent.mobileqq.transfile.protohandler;

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
    byte[] arrayOfByte = paramProtoResp.resp.getWupBuffer();
    RichProto.RichProtoReq localRichProtoReq = (RichProto.RichProtoReq)paramProtoReq.busiData;
    RichProto.RichProtoResp localRichProtoResp = localRichProtoReq.resp;
    StatictisInfo localStatictisInfo = paramProtoResp.statisInfo;
    if (localFromServiceMsg.getResultCode() != 1000)
    {
      paramProtoResp = (String)localFromServiceMsg.getAttribute("_tag_socket_connerror", "");
      if ((!paramProtoResp.equals("conSucc")) && (!paramProtoResp.equals("")))
      {
        setResult(-1, 9313, paramProtoResp, localFromServiceMsg.getBusinessFailMsg(), localStatictisInfo, localRichProtoResp.resps);
      }
      else
      {
        int i = localFromServiceMsg.getResultCode();
        if ((i != 1002) && (i != 1013))
        {
          paramProtoResp = localFromServiceMsg.getBusinessFailMsg();
          if (paramProtoResp == null) {
            paramProtoResp = "";
          }
          setResult(-1, 9044, String.valueOf(i), paramProtoResp, localStatictisInfo, localRichProtoResp.resps);
        }
        else
        {
          paramProtoReq = BaseHandler.getTimeoutReasonForRichMedia(localFromServiceMsg);
          paramProtoResp = localFromServiceMsg.getBusinessFailMsg();
          if (paramProtoResp == null) {
            paramProtoResp = "";
          }
          setResult(-1, 9311, paramProtoReq, paramProtoResp, localStatictisInfo, localRichProtoResp.resps);
        }
      }
    }
    else
    {
      handleSucResp(localFromServiceMsg, arrayOfByte, localRichProtoReq, localRichProtoResp, localStatictisInfo, paramProtoResp, paramProtoReq);
    }
    RichProtoProc.onBusiProtoResp(localRichProtoReq, localRichProtoResp);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.transfile.protohandler.PicUpHandler
 * JD-Core Version:    0.7.0.1
 */