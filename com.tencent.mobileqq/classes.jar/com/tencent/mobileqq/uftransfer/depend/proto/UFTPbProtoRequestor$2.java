package com.tencent.mobileqq.uftransfer.depend.proto;

import android.os.Bundle;
import com.tencent.mobileqq.app.StatictisInfo;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.transfile.api.impl.ProtoReqManagerImpl.IProtoRespBack;
import com.tencent.mobileqq.transfile.api.impl.ProtoReqManagerImpl.ProtoReq;
import com.tencent.mobileqq.transfile.api.impl.ProtoReqManagerImpl.ProtoResp;
import com.tencent.mobileqq.uftransfer.depend.UFTLog;
import com.tencent.mobileqq.uftransfer.proto.UFTC2CUploadRsp;
import com.tencent.mobileqq.uftransfer.proto.UFTProtoRequestor.C2CReqUploadResponseCallback;
import com.tencent.qphone.base.remote.FromServiceMsg;
import tencent.im.cs.cmd0x346.cmd0x346.ApplyUploadHitRspV2;
import tencent.im.cs.cmd0x346.cmd0x346.RspBody;

class UFTPbProtoRequestor$2
  implements ProtoReqManagerImpl.IProtoRespBack
{
  UFTPbProtoRequestor$2(UFTPbProtoRequestor paramUFTPbProtoRequestor, UFTProtoRequestor.C2CReqUploadResponseCallback paramC2CReqUploadResponseCallback) {}
  
  public void onProtoResp(ProtoReqManagerImpl.ProtoResp paramProtoResp, ProtoReqManagerImpl.ProtoReq paramProtoReq)
  {
    UFTLog.b("[UFTTransfer] UFTPbProtoRequestor", 1, "=_= ^> [CS Replay] response V2 Hit");
    paramProtoReq = new Bundle();
    boolean bool2 = UFTPbProtoRequestor.a(this.b, paramProtoResp, paramProtoReq);
    int i = 9045;
    boolean bool1 = false;
    UFTC2CUploadRsp localUFTC2CUploadRsp = null;
    cmd0x346.RspBody localRspBody;
    if (!bool2)
    {
      i = paramProtoReq.getInt("retCode");
      paramProtoReq = paramProtoReq.getString("retMsg");
    }
    else
    {
      paramProtoReq = paramProtoResp.resp.getWupBuffer();
      localRspBody = new cmd0x346.RspBody();
    }
    try
    {
      localRspBody.mergeFrom(paramProtoReq);
      if (!localRspBody.msg_apply_upload_hit_rsp_v2.has())
      {
        UFTLog.d("[UFTTransfer] UFTPbProtoRequestor", 1, "=_= ^! [CS Replay] response V2 Hit error. rspBody has not hasMsgApplyUploadRsp");
        paramProtoReq = "no msg_apply_upload_hit_rsp_v2 ";
      }
      else
      {
        localUFTC2CUploadRsp = UFTPbProtoHelper.a((cmd0x346.ApplyUploadHitRspV2)localRspBody.msg_apply_upload_hit_rsp_v2.get());
        localUFTC2CUploadRsp.d(paramProtoReq);
        paramProtoReq = "";
        i = 0;
      }
    }
    catch (InvalidProtocolBufferMicroException paramProtoReq)
    {
      label138:
      break label138;
    }
    UFTLog.d("[UFTTransfer] UFTPbProtoRequestor", 1, "=_= ^! [CS Replay] response V2 Hit error. parse reponseContent excption");
    paramProtoReq = "parse pbbuf fail";
    if (localUFTC2CUploadRsp != null)
    {
      bool1 = true;
    }
    else
    {
      localUFTC2CUploadRsp = new UFTC2CUploadRsp();
      localUFTC2CUploadRsp.a(i);
      localUFTC2CUploadRsp.a(paramProtoReq);
    }
    paramProtoReq = new StatictisInfo();
    paramProtoReq.b = i;
    paramProtoReq.c = paramProtoResp.freeRunnalbleIndex;
    paramProtoResp = new StringBuilder();
    paramProtoResp.append("[CS Replay] response V3. bReqSuc:");
    paramProtoResp.append(bool1);
    paramProtoResp.append(" ");
    paramProtoResp.append(localUFTC2CUploadRsp.toString());
    UFTLog.b("[UFTTransfer] UFTPbProtoRequestor", 1, paramProtoResp.toString());
    paramProtoResp = this.a;
    if (paramProtoResp != null) {
      paramProtoResp.a(bool1, localUFTC2CUploadRsp);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.uftransfer.depend.proto.UFTPbProtoRequestor.2
 * JD-Core Version:    0.7.0.1
 */