package com.tencent.mobileqq.uftransfer.task.upload;

import com.tencent.mobileqq.uftransfer.api.UFTFileLocalInfo;
import com.tencent.mobileqq.uftransfer.api.impl.UFTTransferKey;
import com.tencent.mobileqq.uftransfer.depend.UFTLog;
import com.tencent.mobileqq.uftransfer.proto.UFTC2CUploadReq;
import com.tencent.mobileqq.uftransfer.proto.UFTC2CUploadRsp;
import com.tencent.mobileqq.uftransfer.proto.UFTProtoRequestor;
import com.tencent.mobileqq.uftransfer.task.UFTBaseOp.OpRetData;
import com.tencent.mobileqq.uftransfer.task.UFTBaseOp.UFTOpCallback;
import com.tencent.mobileqq.uftransfer.task.taskinfo.UFTC2CUploadTaskInfo;
import com.tencent.mobileqq.uftransfer.task.taskinfo.UFTUploadSrvBusiProp.C2CUploadSrvBusiProp;
import mqq.app.AppRuntime;

public class UFTC2CFetchUploadUrlV2HitOp
  extends UFTC2CFetchUploadUrlOp
{
  public UFTC2CFetchUploadUrlV2HitOp(AppRuntime paramAppRuntime, UFTC2CUploadTaskInfo paramUFTC2CUploadTaskInfo, UFTTransferKey paramUFTTransferKey, UFTBaseOp.UFTOpCallback paramUFTOpCallback)
  {
    super(paramAppRuntime, paramUFTC2CUploadTaskInfo, paramUFTTransferKey, paramUFTOpCallback);
  }
  
  protected int a(UFTC2CUploadReq paramUFTC2CUploadReq)
  {
    int i = super.a(paramUFTC2CUploadReq);
    if (i != 0) {
      return i;
    }
    UFTC2CUploadTaskInfo localUFTC2CUploadTaskInfo = (UFTC2CUploadTaskInfo)this.h;
    paramUFTC2CUploadReq.e(localUFTC2CUploadTaskInfo.r().d());
    paramUFTC2CUploadReq.d(localUFTC2CUploadTaskInfo.r().e());
    return 0;
  }
  
  protected void a(UFTC2CUploadRsp paramUFTC2CUploadRsp)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("TId[");
    ((StringBuilder)localObject).append(i());
    ((StringBuilder)localObject).append("] request c2c upload url v2hit suc rsp:");
    ((StringBuilder)localObject).append(paramUFTC2CUploadRsp.toString());
    UFTLog.b("[UFTTransfer] UFTFetchC2CUploadUrlV2HitOp", 1, ((StringBuilder)localObject).toString());
    localObject = new UFTBaseOp.OpRetData();
    ((UFTBaseOp.OpRetData)localObject).a(1);
    if ((paramUFTC2CUploadRsp.a() == 0) && (paramUFTC2CUploadRsp.e() != null) && (paramUFTC2CUploadRsp.e().length > 0))
    {
      UFTUploadSrvBusiProp.C2CUploadSrvBusiProp localC2CUploadSrvBusiProp = new UFTUploadSrvBusiProp.C2CUploadSrvBusiProp(paramUFTC2CUploadRsp);
      localC2CUploadSrvBusiProp.d(true);
      a(localC2CUploadSrvBusiProp);
      ((UFTBaseOp.OpRetData)localObject).a(0);
    }
    ((UFTBaseOp.OpRetData)localObject).a(paramUFTC2CUploadRsp.b());
    a((UFTBaseOp.OpRetData)localObject);
  }
  
  protected void a(boolean paramBoolean, UFTC2CUploadRsp paramUFTC2CUploadRsp)
  {
    if (!paramBoolean)
    {
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append("TId[");
      ((StringBuilder)localObject).append(i());
      ((StringBuilder)localObject).append("] request c2c upload url v2hit fail. errCode:");
      ((StringBuilder)localObject).append(paramUFTC2CUploadRsp.a());
      UFTLog.d("[UFTTransfer] UFTFetchC2CUploadUrlV2HitOp", 1, ((StringBuilder)localObject).toString());
      localObject = new UFTBaseOp.OpRetData();
      ((UFTBaseOp.OpRetData)localObject).a(paramUFTC2CUploadRsp.a());
      ((UFTBaseOp.OpRetData)localObject).a(paramUFTC2CUploadRsp.b());
      a((UFTBaseOp.OpRetData)localObject);
      return;
    }
    a(paramUFTC2CUploadRsp);
  }
  
  protected boolean b(UFTC2CUploadReq paramUFTC2CUploadReq)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("TId[");
    localStringBuilder.append(i());
    localStringBuilder.append("] request c2c upload url v2hit.");
    UFTLog.b("[UFTTransfer] UFTFetchC2CUploadUrlV2HitOp", 1, localStringBuilder.toString());
    return UFTProtoRequestor.a().b(this.g, paramUFTC2CUploadReq, new UFTC2CFetchUploadUrlV2HitOp.1(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.uftransfer.task.upload.UFTC2CFetchUploadUrlV2HitOp
 * JD-Core Version:    0.7.0.1
 */