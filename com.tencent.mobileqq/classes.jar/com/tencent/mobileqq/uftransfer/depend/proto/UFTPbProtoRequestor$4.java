package com.tencent.mobileqq.uftransfer.depend.proto;

import android.os.Bundle;
import com.tencent.mobileqq.app.StatictisInfo;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.transfile.api.impl.ProtoReqManagerImpl.IProtoRespBack;
import com.tencent.mobileqq.transfile.api.impl.ProtoReqManagerImpl.ProtoReq;
import com.tencent.mobileqq.transfile.api.impl.ProtoReqManagerImpl.ProtoResp;
import com.tencent.mobileqq.uftransfer.depend.UFTLog;
import com.tencent.mobileqq.uftransfer.proto.UFTProtoRequestor.C2CSetUploadSucResponseCallback;
import com.tencent.qphone.base.remote.FromServiceMsg;
import tencent.im.cs.cmd0x346.cmd0x346.RspBody;
import tencent.im.cs.cmd0x346.cmd0x346.UploadSuccRsp;

class UFTPbProtoRequestor$4
  implements ProtoReqManagerImpl.IProtoRespBack
{
  UFTPbProtoRequestor$4(UFTPbProtoRequestor paramUFTPbProtoRequestor, UFTProtoRequestor.C2CSetUploadSucResponseCallback paramC2CSetUploadSucResponseCallback) {}
  
  public void onProtoResp(ProtoReqManagerImpl.ProtoResp paramProtoResp, ProtoReqManagerImpl.ProtoReq paramProtoReq)
  {
    UFTLog.b("[UFTTransfer] UFTPbProtoRequestor", 1, "=_= ^> [CS Replay] setc2cuploadsuc");
    paramProtoReq = new Bundle();
    boolean bool2 = UFTPbProtoRequestor.a(this.jdField_a_of_type_ComTencentMobileqqUftransferDependProtoUFTPbProtoRequestor, paramProtoResp, paramProtoReq);
    int i = 9045;
    boolean bool1 = false;
    if (!bool2)
    {
      i = paramProtoReq.getInt("retCode");
      paramProtoReq = paramProtoReq.getString("retMsg");
    }
    else
    {
      paramProtoReq = paramProtoResp.resp.getWupBuffer();
      localObject = new cmd0x346.RspBody();
    }
    try
    {
      ((cmd0x346.RspBody)localObject).mergeFrom(paramProtoReq);
      if (!((cmd0x346.RspBody)localObject).msg_upload_succ_rsp.has())
      {
        UFTLog.d("[UFTTransfer] UFTPbProtoRequestor", 1, "=_= ^! [CS Replay] setc2cuploadsuc error. rspBody has not hasMsgApplyUploadRsp");
        paramProtoReq = "no msg_upload_succ_rsp ";
      }
      else
      {
        paramProtoReq = (cmd0x346.UploadSuccRsp)((cmd0x346.RspBody)localObject).msg_upload_succ_rsp.get();
        if (paramProtoReq.int32_ret_code.has()) {
          i = paramProtoReq.int32_ret_code.get();
        } else {
          i = 0;
        }
        if (paramProtoReq.str_ret_msg.has()) {
          paramProtoReq = paramProtoReq.str_ret_msg.get();
        } else {
          paramProtoReq = "";
        }
        bool1 = true;
      }
    }
    catch (InvalidProtocolBufferMicroException paramProtoReq)
    {
      label170:
      break label170;
    }
    UFTLog.d("[UFTTransfer] UFTPbProtoRequestor", 1, "=_= ^! [CS Replay] setc2cuploadsuc error. parse reponseContent excption");
    paramProtoReq = "parse pbbuf fail";
    Object localObject = new StatictisInfo();
    ((StatictisInfo)localObject).b = i;
    ((StatictisInfo)localObject).c = paramProtoResp.freeRunnalbleIndex;
    paramProtoResp = new StringBuilder();
    paramProtoResp.append("[CS Replay] setc2cuploadsuc. bReqSuc:");
    paramProtoResp.append(bool1);
    paramProtoResp.append(" retCode:");
    paramProtoResp.append(i);
    paramProtoResp.append(" retMsg:");
    paramProtoResp.append(paramProtoReq);
    UFTLog.b("[UFTTransfer] UFTPbProtoRequestor", 1, paramProtoResp.toString());
    paramProtoResp = this.jdField_a_of_type_ComTencentMobileqqUftransferProtoUFTProtoRequestor$C2CSetUploadSucResponseCallback;
    if (paramProtoResp != null) {
      paramProtoResp.a(bool1, i, paramProtoReq);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.uftransfer.depend.proto.UFTPbProtoRequestor.4
 * JD-Core Version:    0.7.0.1
 */