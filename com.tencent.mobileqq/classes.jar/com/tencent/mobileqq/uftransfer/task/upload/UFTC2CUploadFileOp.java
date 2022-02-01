package com.tencent.mobileqq.uftransfer.task.upload;

import com.tencent.mobileqq.uftransfer.api.impl.UFTTransferKey;
import com.tencent.mobileqq.uftransfer.common.transfer.IUFTFileUploader;
import com.tencent.mobileqq.uftransfer.common.transfer.UFTFileTransferFactory;
import com.tencent.mobileqq.uftransfer.common.transfer.UFTFileUploaderProp.FtnMoreUrlFUperProp;
import com.tencent.mobileqq.uftransfer.common.transfer.UFTFileUploaderProp.FtnMoreUrlFUperPropV1;
import com.tencent.mobileqq.uftransfer.depend.UFTLog;
import com.tencent.mobileqq.uftransfer.task.taskinfo.UFTC2CUploadTaskInfo;
import com.tencent.mobileqq.uftransfer.task.taskinfo.UFTUploadSrvBusiProp.C2CUploadSrvBusiProp;
import java.util.List;
import mqq.app.AppRuntime;

public class UFTC2CUploadFileOp
  extends UFTBaseUploadFileOp
{
  public UFTC2CUploadFileOp(AppRuntime paramAppRuntime, UFTC2CUploadTaskInfo paramUFTC2CUploadTaskInfo, UFTTransferKey paramUFTTransferKey, UFTBaseUploadFileOp.UFTUploadFileOpCallback paramUFTUploadFileOpCallback)
  {
    super(paramAppRuntime, paramUFTC2CUploadTaskInfo, paramUFTTransferKey, paramUFTUploadFileOpCallback);
  }
  
  protected int a(UFTC2CUploadTaskInfo paramUFTC2CUploadTaskInfo, UFTUploadSrvBusiProp.C2CUploadSrvBusiProp paramC2CUploadSrvBusiProp)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("TId[");
    ((StringBuilder)localObject).append(i());
    ((StringBuilder)localObject).append("] start c2c ftn upload. ftn apiver:");
    ((StringBuilder)localObject).append(paramC2CUploadSrvBusiProp.l());
    UFTLog.b("[UFTTransfer] UFTC2CUploadFileOp", 1, ((StringBuilder)localObject).toString());
    if (paramC2CUploadSrvBusiProp.l() == 1)
    {
      localObject = new UFTFileUploaderProp.FtnMoreUrlFUperPropV1();
      ((UFTFileUploaderProp.FtnMoreUrlFUperPropV1)localObject).a(paramUFTC2CUploadTaskInfo.n());
      ((UFTFileUploaderProp.FtnMoreUrlFUperPropV1)localObject).a(paramUFTC2CUploadTaskInfo.b());
      ((UFTFileUploaderProp.FtnMoreUrlFUperPropV1)localObject).a(paramUFTC2CUploadTaskInfo.a());
      paramUFTC2CUploadTaskInfo = paramC2CUploadSrvBusiProp.a();
      ((UFTFileUploaderProp.FtnMoreUrlFUperPropV1)localObject).b(paramC2CUploadSrvBusiProp.c());
      ((UFTFileUploaderProp.FtnMoreUrlFUperPropV1)localObject).f(paramC2CUploadSrvBusiProp.d());
      if ((paramUFTC2CUploadTaskInfo != null) && (paramUFTC2CUploadTaskInfo.size() != 0))
      {
        ((UFTFileUploaderProp.FtnMoreUrlFUperPropV1)localObject).a(paramUFTC2CUploadTaskInfo);
        ((UFTFileUploaderProp.FtnMoreUrlFUperPropV1)localObject).e(paramC2CUploadSrvBusiProp.b());
        this.c = UFTFileTransferFactory.a(this.g, (UFTFileUploaderProp.FtnMoreUrlFUperPropV1)localObject);
      }
      else
      {
        paramUFTC2CUploadTaskInfo = new StringBuilder();
        paramUFTC2CUploadTaskInfo.append("TId[");
        paramUFTC2CUploadTaskInfo.append(i());
        paramUFTC2CUploadTaskInfo.append("] upload error. no host");
        UFTLog.d("[UFTTransfer] UFTC2CUploadFileOp", 1, paramUFTC2CUploadTaskInfo.toString());
        c("no host list");
        return 9048;
      }
    }
    else if (paramC2CUploadSrvBusiProp.l() == 2)
    {
      localObject = new UFTFileUploaderProp.FtnMoreUrlFUperProp();
      ((UFTFileUploaderProp.FtnMoreUrlFUperProp)localObject).a(paramUFTC2CUploadTaskInfo.n());
      ((UFTFileUploaderProp.FtnMoreUrlFUperProp)localObject).a(paramUFTC2CUploadTaskInfo.b());
      ((UFTFileUploaderProp.FtnMoreUrlFUperProp)localObject).a(paramUFTC2CUploadTaskInfo.a());
      ((UFTFileUploaderProp.FtnMoreUrlFUperProp)localObject).b(paramC2CUploadSrvBusiProp.c());
      ((UFTFileUploaderProp.FtnMoreUrlFUperProp)localObject).f(paramC2CUploadSrvBusiProp.d());
      ((UFTFileUploaderProp.FtnMoreUrlFUperProp)localObject).b(paramC2CUploadSrvBusiProp.k());
      ((UFTFileUploaderProp.FtnMoreUrlFUperProp)localObject).c(paramC2CUploadSrvBusiProp.j());
      paramUFTC2CUploadTaskInfo = paramC2CUploadSrvBusiProp.a();
      if ((paramUFTC2CUploadTaskInfo != null) && (paramUFTC2CUploadTaskInfo.size() != 0))
      {
        ((UFTFileUploaderProp.FtnMoreUrlFUperProp)localObject).a(paramUFTC2CUploadTaskInfo);
        ((UFTFileUploaderProp.FtnMoreUrlFUperProp)localObject).e(paramC2CUploadSrvBusiProp.b());
        this.c = UFTFileTransferFactory.a(this.g, (UFTFileUploaderProp.FtnMoreUrlFUperProp)localObject);
      }
      else
      {
        paramUFTC2CUploadTaskInfo = new StringBuilder();
        paramUFTC2CUploadTaskInfo.append("TId[");
        paramUFTC2CUploadTaskInfo.append(i());
        paramUFTC2CUploadTaskInfo.append("] upload error. no host");
        UFTLog.d("[UFTTransfer] UFTC2CUploadFileOp", 1, paramUFTC2CUploadTaskInfo.toString());
        c("no host list");
        return 9048;
      }
    }
    if (this.c == null)
    {
      paramUFTC2CUploadTaskInfo = new StringBuilder();
      paramUFTC2CUploadTaskInfo.append("TId[");
      paramUFTC2CUploadTaskInfo.append(i());
      paramUFTC2CUploadTaskInfo.append("] upload error. cannot create ftn uploader");
      UFTLog.d("[UFTTransfer] UFTC2CUploadFileOp", 1, paramUFTC2CUploadTaskInfo.toString());
      c("file uploader can not create");
      return 9045;
    }
    this.c.a(this);
    if (!this.c.a(0L))
    {
      paramUFTC2CUploadTaskInfo = new StringBuilder();
      paramUFTC2CUploadTaskInfo.append("TId[");
      paramUFTC2CUploadTaskInfo.append(i());
      paramUFTC2CUploadTaskInfo.append("] upload error. ftn uploader start fail");
      UFTLog.d("[UFTTransfer] UFTC2CUploadFileOp", 1, paramUFTC2CUploadTaskInfo.toString());
      c("run upload file fail");
      return 9360;
    }
    return 0;
  }
  
  public boolean a()
  {
    return false;
  }
  
  protected int c()
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("TId[");
    ((StringBuilder)localObject).append(i());
    ((StringBuilder)localObject).append("] do start c2c upload op");
    UFTLog.b("[UFTTransfer] UFTC2CUploadFileOp", 1, ((StringBuilder)localObject).toString());
    localObject = (UFTC2CUploadTaskInfo)this.h;
    UFTUploadSrvBusiProp.C2CUploadSrvBusiProp localC2CUploadSrvBusiProp = ((UFTC2CUploadTaskInfo)localObject).l();
    if (localC2CUploadSrvBusiProp == null)
    {
      c("upload file srv busi info is null");
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("TId[");
      ((StringBuilder)localObject).append(i());
      ((StringBuilder)localObject).append("] do start c2c upload fail. srv busi info is null");
      UFTLog.d("[UFTTransfer] UFTC2CUploadFileOp", 1, ((StringBuilder)localObject).toString());
      return 9005;
    }
    return a((UFTC2CUploadTaskInfo)localObject, localC2CUploadSrvBusiProp);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.uftransfer.task.upload.UFTC2CUploadFileOp
 * JD-Core Version:    0.7.0.1
 */