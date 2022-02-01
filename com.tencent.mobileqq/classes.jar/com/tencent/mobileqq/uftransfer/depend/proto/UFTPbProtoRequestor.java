package com.tencent.mobileqq.uftransfer.depend.proto;

import android.os.Bundle;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.transfile.api.IProtoReqManager;
import com.tencent.mobileqq.transfile.api.impl.ProtoReqManagerImpl.IProtoRespBack;
import com.tencent.mobileqq.transfile.api.impl.ProtoReqManagerImpl.ProtoReq;
import com.tencent.mobileqq.transfile.api.impl.ProtoReqManagerImpl.ProtoResp;
import com.tencent.mobileqq.uftransfer.depend.UFTLog;
import com.tencent.mobileqq.uftransfer.proto.UFTC2CSetUploadSucReq;
import com.tencent.mobileqq.uftransfer.proto.UFTC2CUploadBaseInfo;
import com.tencent.mobileqq.uftransfer.proto.UFTC2CUploadReq;
import com.tencent.mobileqq.uftransfer.proto.UFTDiscUploadReq;
import com.tencent.mobileqq.uftransfer.proto.UFTProtoRequestor.C2CReqUploadResponseCallback;
import com.tencent.mobileqq.uftransfer.proto.UFTProtoRequestor.C2CSetUploadSucResponseCallback;
import com.tencent.mobileqq.uftransfer.proto.UFTProtoRequestor.DiscReqUploadResponseCallback;
import com.tencent.qphone.base.remote.FromServiceMsg;
import mqq.app.AppRuntime;
import tencent.im.cs.cmd0x345.cmd0x345.ReqBody;
import tencent.im.cs.cmd0x345.cmd0x345.ReqBody.SubCmd0x1ReqBody;
import tencent.im.cs.cmd0x346.cmd0x346.ApplyUploadHitReqV2;
import tencent.im.cs.cmd0x346.cmd0x346.ApplyUploadReqV2;
import tencent.im.cs.cmd0x346.cmd0x346.ApplyUploadReqV3;
import tencent.im.cs.cmd0x346.cmd0x346.ExtensionReq;
import tencent.im.cs.cmd0x346.cmd0x346.ReqBody;
import tencent.im.cs.cmd0x346.cmd0x346.UploadSuccReq;

public class UFTPbProtoRequestor
{
  private static int a;
  
  private cmd0x346.ReqBody a(int paramInt, UFTC2CUploadBaseInfo paramUFTC2CUploadBaseInfo)
  {
    cmd0x346.ReqBody localReqBody = new cmd0x346.ReqBody();
    localReqBody.uint32_cmd.set(paramInt);
    localReqBody.uint32_business_id.set(3);
    localReqBody.uint32_client_type.set(104);
    Object localObject = localReqBody.uint32_seq;
    paramInt = a;
    a = paramInt + 1;
    ((PBUInt32Field)localObject).set(paramInt);
    if (paramUFTC2CUploadBaseInfo.e()) {
      localReqBody.uint32_flag_support_mediaplatform.set(1);
    }
    if (paramUFTC2CUploadBaseInfo.f() > 0L)
    {
      localObject = new cmd0x346.ExtensionReq();
      ((cmd0x346.ExtensionReq)localObject).uint64_id.set(3L);
      ((cmd0x346.ExtensionReq)localObject).uint64_type.set(paramUFTC2CUploadBaseInfo.f());
      if ((paramUFTC2CUploadBaseInfo.g() != null) && (paramUFTC2CUploadBaseInfo.g().length > 0)) {
        ((cmd0x346.ExtensionReq)localObject).bytes_sig.set(ByteStringMicro.copyFrom(paramUFTC2CUploadBaseInfo.g()));
      }
      if ((paramUFTC2CUploadBaseInfo.h() != null) && (paramUFTC2CUploadBaseInfo.h().length() > 0)) {
        ((cmd0x346.ExtensionReq)localObject).str_dst_phonenum.set(paramUFTC2CUploadBaseInfo.h());
      }
      localReqBody.msg_extension_req.set((MessageMicro)localObject);
    }
    return localReqBody;
  }
  
  private boolean a(ProtoReqManagerImpl.ProtoResp paramProtoResp)
  {
    return (paramProtoResp.resp.getResultCode() == 1002) || (paramProtoResp.resp.getResultCode() == 1013);
  }
  
  private boolean a(ProtoReqManagerImpl.ProtoResp paramProtoResp, Bundle paramBundle)
  {
    int i = -100002;
    int j = 0;
    if ((paramProtoResp != null) && (paramProtoResp.resp != null))
    {
      StringBuilder localStringBuilder;
      if (a(paramProtoResp))
      {
        i = 9043;
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("=_= ^! proto rsp  is timeout[");
        localStringBuilder.append(paramProtoResp.resp.getResultCode());
        localStringBuilder.append("]");
        UFTLog.d("[UFTTransfer] UFTPbProtoRequestor", 1, localStringBuilder.toString());
        paramProtoResp = "msf timeout";
      }
      else if (paramProtoResp.resp.getResultCode() != 1000)
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("=_= ^! proto rsp  is failed[");
        localStringBuilder.append(paramProtoResp.resp.getResultCode());
        localStringBuilder.append("]");
        UFTLog.d("[UFTTransfer] UFTPbProtoRequestor", 1, localStringBuilder.toString());
        paramProtoResp = " req resp is 1000 OK";
      }
      else
      {
        paramProtoResp = "";
        i = 0;
        break label177;
      }
    }
    else
    {
      UFTLog.d("[UFTTransfer] UFTPbProtoRequestor", 1, "=_= ^! proto rsp is null");
      paramProtoResp = "proto rsp is null";
    }
    j = 1;
    label177:
    if ((j != 0) && (paramBundle != null))
    {
      paramBundle.putInt("retCode", i);
      paramBundle.putString("retMsg", paramProtoResp);
    }
    return j ^ 0x1;
  }
  
  private boolean a(AppRuntime paramAppRuntime, ProtoReqManagerImpl.ProtoReq paramProtoReq)
  {
    if (paramAppRuntime == null)
    {
      UFTLog.d("[UFTTransfer] UFTPbProtoRequestor", 1, "fail to send pb req. app=null");
      return false;
    }
    paramAppRuntime = (IProtoReqManager)paramAppRuntime.getRuntimeService(IProtoReqManager.class, "");
    if (paramAppRuntime == null)
    {
      UFTLog.d("[UFTTransfer] UFTPbProtoRequestor", 1, "fail to send pb req. protoReqManager=null");
      return false;
    }
    paramAppRuntime.sendProtoReq(paramProtoReq);
    return true;
  }
  
  private boolean a(AppRuntime paramAppRuntime, String paramString, byte[] paramArrayOfByte, UFTPbProtoBusiData paramUFTPbProtoBusiData, ProtoReqManagerImpl.IProtoRespBack paramIProtoRespBack)
  {
    ProtoReqManagerImpl.ProtoReq localProtoReq = new ProtoReqManagerImpl.ProtoReq();
    localProtoReq.ssoCmd = paramString;
    localProtoReq.reqBody = paramArrayOfByte;
    localProtoReq.busiData = paramUFTPbProtoBusiData;
    localProtoReq.callback = paramIProtoRespBack;
    return a(paramAppRuntime, localProtoReq);
  }
  
  public boolean a(AppRuntime paramAppRuntime, UFTC2CSetUploadSucReq paramUFTC2CSetUploadSucReq, UFTProtoRequestor.C2CSetUploadSucResponseCallback paramC2CSetUploadSucResponseCallback)
  {
    cmd0x346.ReqBody localReqBody = a(800, paramUFTC2CSetUploadSucReq);
    paramUFTC2CSetUploadSucReq = UFTPbProtoHelper.a(paramUFTC2CSetUploadSucReq);
    localReqBody.msg_upload_succ_req.set(paramUFTC2CSetUploadSucReq);
    return a(paramAppRuntime, "OfflineFilleHandleSvr.pb_ftn_CMD_REQ_UPLOAD_SUCC-800", localReqBody.toByteArray(), null, new UFTPbProtoRequestor.4(this, paramC2CSetUploadSucResponseCallback));
  }
  
  public boolean a(AppRuntime paramAppRuntime, UFTC2CUploadReq paramUFTC2CUploadReq, UFTProtoRequestor.C2CReqUploadResponseCallback paramC2CReqUploadResponseCallback)
  {
    cmd0x346.ReqBody localReqBody = a(1600, paramUFTC2CUploadReq);
    paramUFTC2CUploadReq = UFTPbProtoHelper.a(paramUFTC2CUploadReq);
    localReqBody.msg_apply_upload_req_v2.set(paramUFTC2CUploadReq);
    return a(paramAppRuntime, "OfflineFilleHandleSvr.pb_ftn_CMD_REQ_APPLY_UPLOAD_V2-1600", localReqBody.toByteArray(), null, new UFTPbProtoRequestor.1(this, paramC2CReqUploadResponseCallback));
  }
  
  public boolean a(AppRuntime paramAppRuntime, UFTDiscUploadReq paramUFTDiscUploadReq, UFTProtoRequestor.DiscReqUploadResponseCallback paramDiscReqUploadResponseCallback)
  {
    cmd0x345.ReqBody localReqBody = new cmd0x345.ReqBody();
    paramUFTDiscUploadReq = UFTPbProtoHelper.a(paramUFTDiscUploadReq);
    localReqBody.msg_subcmd_0x1_req_body.set(paramUFTDiscUploadReq);
    localReqBody.uint32_sub_cmd.set(1);
    return a(paramAppRuntime, "GTalkFileAppSvr.CMD_DISCUSS_FILE", localReqBody.toByteArray(), null, new UFTPbProtoRequestor.5(this, paramDiscReqUploadResponseCallback));
  }
  
  public boolean b(AppRuntime paramAppRuntime, UFTC2CUploadReq paramUFTC2CUploadReq, UFTProtoRequestor.C2CReqUploadResponseCallback paramC2CReqUploadResponseCallback)
  {
    cmd0x346.ReqBody localReqBody = a(1800, paramUFTC2CUploadReq);
    paramUFTC2CUploadReq = UFTPbProtoHelper.b(paramUFTC2CUploadReq);
    localReqBody.msg_apply_upload_hit_req_v2.set(paramUFTC2CUploadReq);
    return a(paramAppRuntime, "OfflineFilleHandleSvr.pb_ftn_CMD_REQ_APPLY_UPLOAD_HIT_V2-1800", localReqBody.toByteArray(), null, new UFTPbProtoRequestor.2(this, paramC2CReqUploadResponseCallback));
  }
  
  public boolean c(AppRuntime paramAppRuntime, UFTC2CUploadReq paramUFTC2CUploadReq, UFTProtoRequestor.C2CReqUploadResponseCallback paramC2CReqUploadResponseCallback)
  {
    cmd0x346.ReqBody localReqBody = a(1700, paramUFTC2CUploadReq);
    paramUFTC2CUploadReq = UFTPbProtoHelper.c(paramUFTC2CUploadReq);
    localReqBody.msg_apply_upload_req_v3.set(paramUFTC2CUploadReq);
    return a(paramAppRuntime, "OfflineFilleHandleSvr.pb_ftn_CMD_REQ_APPLY_UPLOAD_V3-1700", localReqBody.toByteArray(), null, new UFTPbProtoRequestor.3(this, localReqBody, paramC2CReqUploadResponseCallback));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.uftransfer.depend.proto.UFTPbProtoRequestor
 * JD-Core Version:    0.7.0.1
 */