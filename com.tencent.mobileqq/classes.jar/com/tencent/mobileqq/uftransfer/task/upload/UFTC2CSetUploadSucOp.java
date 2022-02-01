package com.tencent.mobileqq.uftransfer.task.upload;

import com.tencent.mobileqq.uftransfer.api.impl.UFTTransferKey;
import com.tencent.mobileqq.uftransfer.depend.UFTLog;
import com.tencent.mobileqq.uftransfer.proto.UFTC2CSetUploadSucReq;
import com.tencent.mobileqq.uftransfer.proto.UFTProtoRequestor;
import com.tencent.mobileqq.uftransfer.task.UFTBaseOp;
import com.tencent.mobileqq.uftransfer.task.UFTBaseOp.UFTOpCallback;
import com.tencent.mobileqq.uftransfer.task.taskinfo.UFTC2CUploadTaskInfo;
import mqq.app.AppRuntime;

public class UFTC2CSetUploadSucOp
  extends UFTBaseOp
{
  public UFTC2CSetUploadSucOp(AppRuntime paramAppRuntime, UFTC2CUploadTaskInfo paramUFTC2CUploadTaskInfo, UFTTransferKey paramUFTTransferKey, UFTBaseOp.UFTOpCallback paramUFTOpCallback)
  {
    super(paramAppRuntime, paramUFTC2CUploadTaskInfo, paramUFTTransferKey, paramUFTOpCallback);
  }
  
  protected int c()
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("TId[");
    ((StringBuilder)localObject).append(i());
    ((StringBuilder)localObject).append("] do set upload suc op");
    UFTLog.b("[UFTTransfer] UFTC2CSetUploadSucOp", 1, ((StringBuilder)localObject).toString());
    localObject = (UFTC2CUploadTaskInfo)this.h;
    UFTC2CSetUploadSucReq localUFTC2CSetUploadSucReq = new UFTC2CSetUploadSucReq();
    try
    {
      l = Long.parseLong(this.g.getCurrentAccountUin());
    }
    catch (NumberFormatException localNumberFormatException)
    {
      long l;
      label72:
      StringBuilder localStringBuilder;
      break label72;
    }
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("TId[");
    localStringBuilder.append(i());
    localStringBuilder.append("] send uin err.");
    UFTLog.d("[UFTTransfer] UFTC2CSetUploadSucOp", 1, localStringBuilder.toString());
    l = 0L;
    localUFTC2CSetUploadSucReq.a(l);
    localUFTC2CSetUploadSucReq.b(Long.parseLong(((UFTC2CUploadTaskInfo)localObject).c().replace("+", "")));
    localUFTC2CSetUploadSucReq.c(((UFTC2CUploadTaskInfo)localObject).d());
    localUFTC2CSetUploadSucReq.b(((UFTC2CUploadTaskInfo)localObject).e());
    localUFTC2CSetUploadSucReq.b(((UFTC2CUploadTaskInfo)localObject).f());
    if (((UFTC2CUploadTaskInfo)localObject).q() == null)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("TId[");
      ((StringBuilder)localObject).append(i());
      ((StringBuilder)localObject).append("] do set upload suc fail. file id is null");
      UFTLog.d("[UFTTransfer] UFTC2CSetUploadSucOp", 1, ((StringBuilder)localObject).toString());
      c("uuid is null");
      return 9005;
    }
    localUFTC2CSetUploadSucReq.a(((UFTC2CUploadTaskInfo)localObject).q().getBytes());
    localUFTC2CSetUploadSucReq.a(((UFTC2CUploadTaskInfo)localObject).g());
    if (!UFTProtoRequestor.a().a(this.g, localUFTC2CSetUploadSucReq, new UFTC2CSetUploadSucOp.1(this)))
    {
      c("request set upload suc fail");
      return 9001;
    }
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.uftransfer.task.upload.UFTC2CSetUploadSucOp
 * JD-Core Version:    0.7.0.1
 */