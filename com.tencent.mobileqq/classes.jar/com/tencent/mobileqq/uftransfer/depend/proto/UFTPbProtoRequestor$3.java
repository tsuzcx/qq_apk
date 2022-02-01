package com.tencent.mobileqq.uftransfer.depend.proto;

import android.os.Bundle;
import com.tencent.mobileqq.app.StatictisInfo;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.transfile.api.impl.ProtoReqManagerImpl.IProtoRespBack;
import com.tencent.mobileqq.transfile.api.impl.ProtoReqManagerImpl.ProtoReq;
import com.tencent.mobileqq.transfile.api.impl.ProtoReqManagerImpl.ProtoResp;
import com.tencent.mobileqq.uftransfer.depend.UFTLog;
import com.tencent.mobileqq.uftransfer.proto.UFTC2CUploadRsp;
import com.tencent.mobileqq.uftransfer.proto.UFTProtoRequestor.C2CReqUploadResponseCallback;
import com.tencent.qphone.base.remote.FromServiceMsg;
import tencent.im.cs.cmd0x346.cmd0x346.ApplyUploadRspV3;
import tencent.im.cs.cmd0x346.cmd0x346.ReqBody;
import tencent.im.cs.cmd0x346.cmd0x346.RspBody;

class UFTPbProtoRequestor$3
  implements ProtoReqManagerImpl.IProtoRespBack
{
  UFTPbProtoRequestor$3(UFTPbProtoRequestor paramUFTPbProtoRequestor, cmd0x346.ReqBody paramReqBody, UFTProtoRequestor.C2CReqUploadResponseCallback paramC2CReqUploadResponseCallback) {}
  
  public void onProtoResp(ProtoReqManagerImpl.ProtoResp paramProtoResp, ProtoReqManagerImpl.ProtoReq paramProtoReq)
  {
    UFTLog.b("[UFTTransfer] UFTPbProtoRequestor", 1, "=_= ^> [CS Replay] response V3");
    paramProtoReq = new Bundle();
    boolean bool1 = UFTPbProtoRequestor.a(this.jdField_a_of_type_ComTencentMobileqqUftransferDependProtoUFTPbProtoRequestor, paramProtoResp, paramProtoReq);
    int i = 9045;
    boolean bool2 = false;
    Object localObject = null;
    cmd0x346.RspBody localRspBody;
    if (!bool1)
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
      if (!localRspBody.msg_apply_upload_rsp_v3.has())
      {
        UFTLog.d("[UFTTransfer] UFTPbProtoRequestor", 1, "=_= ^! [CS Replay] response V3 error. rspBody has not hasMsgApplyUploadRsp");
        paramProtoReq = "no msg_apply_upload_rsp_v3 ";
      }
      else
      {
        if (localRspBody.uint32_flag_use_media_platform.has())
        {
          if (localRspBody.uint32_flag_use_media_platform.get() == 1) {
            bool1 = true;
          } else {
            bool1 = false;
          }
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("[CS Replay] response V3: bUseMediaPlatform ");
          ((StringBuilder)localObject).append(bool1);
          UFTLog.b("[UFTTransfer] UFTPbProtoRequestor", 1, ((StringBuilder)localObject).toString());
        }
        else
        {
          if (this.jdField_a_of_type_TencentImCsCmd0x346Cmd0x346$ReqBody.uint32_flag_support_mediaplatform.get() == 1) {
            UFTLog.d("[UFTTransfer] UFTPbProtoRequestor", 1, "[CS Replay] response V3: uint32_flag_use_media_platform is false !!!");
          }
          bool1 = false;
        }
        localObject = UFTPbProtoHelper.a((cmd0x346.ApplyUploadRspV3)localRspBody.msg_apply_upload_rsp_v3.get(), bool1);
        ((UFTC2CUploadRsp)localObject).d(paramProtoReq);
        ((UFTC2CUploadRsp)localObject).c(2);
        paramProtoReq = "";
        i = 0;
      }
    }
    catch (InvalidProtocolBufferMicroException paramProtoReq)
    {
      label242:
      break label242;
    }
    UFTLog.d("[UFTTransfer] UFTPbProtoRequestor", 1, "=_= ^! [CS Replay] response V3 error. parse reponseContent excption");
    paramProtoReq = "parse pbbuf fail";
    if (localObject != null)
    {
      bool1 = true;
    }
    else
    {
      localObject = new UFTC2CUploadRsp();
      ((UFTC2CUploadRsp)localObject).a(i);
      ((UFTC2CUploadRsp)localObject).a(paramProtoReq);
      bool1 = bool2;
    }
    paramProtoReq = new StatictisInfo();
    paramProtoReq.b = i;
    paramProtoReq.c = paramProtoResp.freeRunnalbleIndex;
    paramProtoResp = new StringBuilder();
    paramProtoResp.append("[CS Replay] response V3. bReqSuc:");
    paramProtoResp.append(bool1);
    paramProtoResp.append(" ");
    paramProtoResp.append(((UFTC2CUploadRsp)localObject).toString());
    UFTLog.b("[UFTTransfer] UFTPbProtoRequestor", 1, paramProtoResp.toString());
    paramProtoResp = this.jdField_a_of_type_ComTencentMobileqqUftransferProtoUFTProtoRequestor$C2CReqUploadResponseCallback;
    if (paramProtoResp != null) {
      paramProtoResp.a(bool1, (UFTC2CUploadRsp)localObject);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.uftransfer.depend.proto.UFTPbProtoRequestor.3
 * JD-Core Version:    0.7.0.1
 */