package com.tencent.mobileqq.uftransfer.depend.proto;

import android.os.Bundle;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.transfile.api.impl.ProtoReqManagerImpl.IProtoRespBack;
import com.tencent.mobileqq.transfile.api.impl.ProtoReqManagerImpl.ProtoReq;
import com.tencent.mobileqq.transfile.api.impl.ProtoReqManagerImpl.ProtoResp;
import com.tencent.mobileqq.uftransfer.depend.UFTLog;
import com.tencent.mobileqq.uftransfer.proto.UFTDiscUploadRsp;
import com.tencent.mobileqq.uftransfer.proto.UFTProtoRequestor.DiscReqUploadResponseCallback;
import com.tencent.qphone.base.remote.FromServiceMsg;
import tencent.im.cs.cmd0x345.cmd0x345.RspBody;
import tencent.im.cs.cmd0x345.cmd0x345.RspBody.SubCmd0x1RspBody;

class UFTPbProtoRequestor$5
  implements ProtoReqManagerImpl.IProtoRespBack
{
  UFTPbProtoRequestor$5(UFTPbProtoRequestor paramUFTPbProtoRequestor, UFTProtoRequestor.DiscReqUploadResponseCallback paramDiscReqUploadResponseCallback) {}
  
  public void onProtoResp(ProtoReqManagerImpl.ProtoResp paramProtoResp, ProtoReqManagerImpl.ProtoReq paramProtoReq)
  {
    UFTLog.b("[UFTTransfer] UFTPbProtoRequestor", 1, "=_= ^> [CS Replay] requestDiscUpload");
    Object localObject = new Bundle();
    boolean bool2 = UFTPbProtoRequestor.a(this.b, paramProtoResp, (Bundle)localObject);
    int j = 9045;
    boolean bool1 = false;
    paramProtoReq = null;
    if (!bool2)
    {
      i = ((Bundle)localObject).getInt("retCode");
      paramProtoResp = ((Bundle)localObject).getString("retMsg");
    }
    else
    {
      paramProtoResp = paramProtoResp.resp.getWupBuffer();
      localObject = new cmd0x345.RspBody();
    }
    try
    {
      ((cmd0x345.RspBody)localObject).mergeFrom(paramProtoResp);
      if (((cmd0x345.RspBody)localObject).uint32_return_code.has()) {
        i = ((cmd0x345.RspBody)localObject).uint32_return_code.get();
      } else {
        i = 0;
      }
      if (!((cmd0x345.RspBody)localObject).msg_subcmd_0x1_rsp_body.has())
      {
        UFTLog.d("[UFTTransfer] UFTPbProtoRequestor", 1, "=_= ^! [CS Replay] requestDiscUpload error. rspBody has not hasMsgApplyUploadRsp");
        paramProtoResp = "no msg_subcmd_0x1_rsp_body ";
        i = j;
      }
      else
      {
        paramProtoReq = UFTPbProtoHelper.a((cmd0x345.RspBody.SubCmd0x1RspBody)((cmd0x345.RspBody)localObject).msg_subcmd_0x1_rsp_body.get());
        paramProtoResp = paramProtoReq.f();
        paramProtoReq.a(i);
      }
    }
    catch (InvalidProtocolBufferMicroException paramProtoResp)
    {
      label168:
      break label168;
    }
    UFTLog.d("[UFTTransfer] UFTPbProtoRequestor", 1, "=_= ^! [CS Replay] requestDiscUpload error. parse reponseContent excption");
    paramProtoResp = "parse pbbuf fail";
    int i = j;
    if (paramProtoReq != null)
    {
      bool1 = true;
    }
    else
    {
      paramProtoReq = new UFTDiscUploadRsp();
      paramProtoReq.a(i);
      paramProtoReq.f(paramProtoResp);
    }
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("[CS Replay] requestDiscUpload. bReqSuc:");
    ((StringBuilder)localObject).append(bool1);
    ((StringBuilder)localObject).append(" retCode:");
    ((StringBuilder)localObject).append(i);
    ((StringBuilder)localObject).append(" retMsg:");
    ((StringBuilder)localObject).append(paramProtoResp);
    UFTLog.b("[UFTTransfer] UFTPbProtoRequestor", 1, ((StringBuilder)localObject).toString());
    paramProtoResp = this.a;
    if (paramProtoResp != null) {
      paramProtoResp.a(bool1, paramProtoReq);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.uftransfer.depend.proto.UFTPbProtoRequestor.5
 * JD-Core Version:    0.7.0.1
 */