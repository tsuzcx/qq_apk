package com.tencent.mobileqq.uftransfer.depend.proto;

import android.os.Bundle;
import com.tencent.biz.ProtoUtils.TroopProtocolObserver;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.filemanager.api.ITroopFileProtoReq;
import com.tencent.mobileqq.filemanager.api.ITroopFileProtoReqMgr;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.uftransfer.depend.UFTLog;
import com.tencent.mobileqq.uftransfer.proto.UFTProtoRequestor.TroopReqUploadResponseCallback;
import com.tencent.mobileqq.uftransfer.proto.UFTTroopUploadReReq;
import com.tencent.mobileqq.uftransfer.proto.UFTTroopUploadReq;
import mqq.app.AppRuntime;
import tencent.im.oidb.cmd0x6d6.oidb_0x6d6.ReqBody;
import tencent.im.oidb.cmd0x6d6.oidb_0x6d6.ResendReqBody;
import tencent.im.oidb.cmd0x6d6.oidb_0x6d6.UploadFileReqBody;
import tencent.im.oidb.oidb_sso.OIDBSSOPkg;

public class UFTTroopPbProtoRequestor
{
  private Object a(AppRuntime paramAppRuntime, String paramString, int paramInt1, int paramInt2, byte[] paramArrayOfByte, Bundle paramBundle, ProtoUtils.TroopProtocolObserver paramTroopProtocolObserver)
  {
    if (paramAppRuntime == null)
    {
      UFTLog.d("[UFTTransfer] UFTTrpPbProtoRequestor", 1, "fail to send pb req. app=null");
      return null;
    }
    ITroopFileProtoReqMgr localITroopFileProtoReqMgr = (ITroopFileProtoReqMgr)paramAppRuntime.getRuntimeService(ITroopFileProtoReqMgr.class, "");
    if (localITroopFileProtoReqMgr == null)
    {
      UFTLog.d("[UFTTransfer] UFTTrpPbProtoRequestor", 1, "fail to send pb req. protoReqManager=null");
      return null;
    }
    oidb_sso.OIDBSSOPkg localOIDBSSOPkg = new oidb_sso.OIDBSSOPkg();
    localOIDBSSOPkg.uint32_command.set(paramInt1);
    localOIDBSSOPkg.uint32_service_type.set(paramInt2);
    localOIDBSSOPkg.bytes_bodybuffer.set(ByteStringMicro.copyFrom(paramArrayOfByte));
    localOIDBSSOPkg.str_client_version.set(AppSetting.h());
    paramAppRuntime = ((ITroopFileProtoReqMgr)paramAppRuntime.getRuntimeService(ITroopFileProtoReqMgr.class, "")).createProtoReq();
    paramAppRuntime.a(paramString);
    paramAppRuntime.a(localOIDBSSOPkg.toByteArray());
    paramAppRuntime.a(paramBundle);
    paramAppRuntime.a(paramTroopProtocolObserver);
    localITroopFileProtoReqMgr.sendProtoRequest(paramAppRuntime);
    return paramAppRuntime;
  }
  
  public Object a(AppRuntime paramAppRuntime, UFTTroopUploadReReq paramUFTTroopUploadReReq, UFTProtoRequestor.TroopReqUploadResponseCallback paramTroopReqUploadResponseCallback)
  {
    paramUFTTroopUploadReReq = UFTPbProtoHelper.a(paramUFTTroopUploadReReq);
    oidb_0x6d6.ReqBody localReqBody = new oidb_0x6d6.ReqBody();
    localReqBody.resend_file_req.set(paramUFTTroopUploadReReq);
    return a(paramAppRuntime, "OidbSvc.0x6d6_1", 1750, 1, localReqBody.toByteArray(), new Bundle(), new UFTTroopPbProtoRequestor.2(this, paramTroopReqUploadResponseCallback));
  }
  
  public Object a(AppRuntime paramAppRuntime, UFTTroopUploadReq paramUFTTroopUploadReq, UFTProtoRequestor.TroopReqUploadResponseCallback paramTroopReqUploadResponseCallback)
  {
    paramUFTTroopUploadReq = UFTPbProtoHelper.a(paramUFTTroopUploadReq);
    oidb_0x6d6.ReqBody localReqBody = new oidb_0x6d6.ReqBody();
    localReqBody.upload_file_req.set(paramUFTTroopUploadReq);
    return a(paramAppRuntime, "OidbSvc.0x6d6_0", 1750, 0, localReqBody.toByteArray(), new Bundle(), new UFTTroopPbProtoRequestor.1(this, paramTroopReqUploadResponseCallback));
  }
  
  public void a(AppRuntime paramAppRuntime, Object paramObject)
  {
    if ((paramObject != null) && ((paramObject instanceof ITroopFileProtoReq)))
    {
      paramAppRuntime = (ITroopFileProtoReqMgr)paramAppRuntime.getRuntimeService(ITroopFileProtoReqMgr.class, "");
      if (paramAppRuntime != null) {
        paramAppRuntime.cancelRequest((ITroopFileProtoReq)paramObject);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.uftransfer.depend.proto.UFTTroopPbProtoRequestor
 * JD-Core Version:    0.7.0.1
 */