package com.tencent.mobileqq.uftransfer.task.upload;

import com.tencent.mobileqq.uftransfer.api.UFTFileLocalInfo;
import com.tencent.mobileqq.uftransfer.api.impl.UFTTransferKey;
import com.tencent.mobileqq.uftransfer.depend.UFTDependFeatureApi;
import com.tencent.mobileqq.uftransfer.depend.UFTLog;
import com.tencent.mobileqq.uftransfer.proto.UFTC2CUploadReq;
import com.tencent.mobileqq.uftransfer.proto.UFTC2CUploadRsp;
import com.tencent.mobileqq.uftransfer.proto.UFTProtoRequestor;
import com.tencent.mobileqq.uftransfer.task.UFTBaseOp.OpRetData;
import com.tencent.mobileqq.uftransfer.task.UFTBaseOp.UFTOpCallback;
import com.tencent.mobileqq.uftransfer.task.taskinfo.UFTBaseTaskInfo;
import com.tencent.mobileqq.uftransfer.task.taskinfo.UFTC2CUploadTaskInfo;
import com.tencent.mobileqq.uftransfer.task.taskinfo.UFTUploadSrvBusiProp.C2CUploadSrvBusiProp;
import mqq.app.AppRuntime;

public class UFTC2CFetchUploadUrlV2Op
  extends UFTC2CFetchUploadUrlOp
{
  public UFTC2CFetchUploadUrlV2Op(AppRuntime paramAppRuntime, UFTC2CUploadTaskInfo paramUFTC2CUploadTaskInfo, UFTTransferKey paramUFTTransferKey, UFTBaseOp.UFTOpCallback paramUFTOpCallback)
  {
    super(paramAppRuntime, paramUFTC2CUploadTaskInfo, paramUFTTransferKey, paramUFTOpCallback);
  }
  
  protected int a(UFTC2CUploadReq paramUFTC2CUploadReq)
  {
    int i = super.a(paramUFTC2CUploadReq);
    if (i != 0) {
      return i;
    }
    paramUFTC2CUploadReq.e(this.h.r().d());
    return 0;
  }
  
  protected void a(UFTC2CUploadRsp paramUFTC2CUploadRsp)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("TId[");
    ((StringBuilder)localObject).append(i());
    ((StringBuilder)localObject).append("] request c2c upload url v2 suc rsp:");
    ((StringBuilder)localObject).append(paramUFTC2CUploadRsp.toString());
    UFTLog.b("[UFTTransfer] UFTFetchC2CUploadUrlV2Op", 1, ((StringBuilder)localObject).toString());
    localObject = new UFTBaseOp.OpRetData();
    ((UFTBaseOp.OpRetData)localObject).a(0);
    UFTUploadSrvBusiProp.C2CUploadSrvBusiProp localC2CUploadSrvBusiProp = new UFTUploadSrvBusiProp.C2CUploadSrvBusiProp(paramUFTC2CUploadRsp);
    if (!this.c)
    {
      UFTC2CFetchUploadUrlOp.UrlHostInfo localUrlHostInfo = b(paramUFTC2CUploadRsp);
      String str = UFTDependFeatureApi.a(paramUFTC2CUploadRsp.f());
      if (paramUFTC2CUploadRsp.i() == 1)
      {
        paramUFTC2CUploadRsp = new StringBuilder();
        paramUFTC2CUploadRsp.append("/?ver=2&ukey=");
        paramUFTC2CUploadRsp.append(str);
        paramUFTC2CUploadRsp.append("&filekey=");
        paramUFTC2CUploadRsp.append(this.e);
        paramUFTC2CUploadRsp.append("&filesize=");
        paramUFTC2CUploadRsp.append(this.h.p());
        paramUFTC2CUploadRsp = paramUFTC2CUploadRsp.toString();
        localC2CUploadSrvBusiProp.a(localUrlHostInfo.b);
        localC2CUploadSrvBusiProp.b(localUrlHostInfo.c);
        localC2CUploadSrvBusiProp.a(localUrlHostInfo.a);
        localC2CUploadSrvBusiProp.a(paramUFTC2CUploadRsp);
        localC2CUploadSrvBusiProp.b(localUrlHostInfo.d);
      }
      else if (paramUFTC2CUploadRsp.i() == 2)
      {
        localC2CUploadSrvBusiProp.a(localUrlHostInfo.b);
        localC2CUploadSrvBusiProp.b(localUrlHostInfo.c);
        localC2CUploadSrvBusiProp.a(localUrlHostInfo.a);
        localC2CUploadSrvBusiProp.a("/ftn_handler");
        localC2CUploadSrvBusiProp.b(localUrlHostInfo.d);
        localC2CUploadSrvBusiProp.d(str);
      }
      else
      {
        ((UFTBaseOp.OpRetData)localObject).a(9045);
        ((UFTBaseOp.OpRetData)localObject).a("upload param error");
      }
    }
    a(localC2CUploadSrvBusiProp);
    a((UFTBaseOp.OpRetData)localObject);
  }
  
  protected void a(UFTUploadSrvBusiProp.C2CUploadSrvBusiProp paramC2CUploadSrvBusiProp)
  {
    if ((paramC2CUploadSrvBusiProp != null) && (paramC2CUploadSrvBusiProp.i() != null) && (paramC2CUploadSrvBusiProp.i().length > 0)) {
      this.h.r().d(paramC2CUploadSrvBusiProp.i());
    }
    super.a(paramC2CUploadSrvBusiProp);
  }
  
  protected boolean b(UFTC2CUploadReq paramUFTC2CUploadReq)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("TId[");
    localStringBuilder.append(i());
    localStringBuilder.append("] request c2c upload url v2.");
    UFTLog.b("[UFTTransfer] UFTFetchC2CUploadUrlV2Op", 1, localStringBuilder.toString());
    return UFTProtoRequestor.a().a(this.g, paramUFTC2CUploadReq, new UFTC2CFetchUploadUrlV2Op.1(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.uftransfer.task.upload.UFTC2CFetchUploadUrlV2Op
 * JD-Core Version:    0.7.0.1
 */