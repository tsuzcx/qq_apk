package com.tencent.mobileqq.uftransfer.task.upload;

import com.tencent.mobileqq.uftransfer.api.impl.UFTTransferKey;
import com.tencent.mobileqq.uftransfer.common.transfer.IUFTFileUploader;
import com.tencent.mobileqq.uftransfer.common.transfer.UFTFileTransferFactory;
import com.tencent.mobileqq.uftransfer.common.transfer.UFTFileUploaderProp.FtnMoreUrlFUperProp;
import com.tencent.mobileqq.uftransfer.depend.UFTLog;
import com.tencent.mobileqq.uftransfer.task.taskinfo.UFTDiscUploadTaskInfo;
import com.tencent.mobileqq.uftransfer.task.taskinfo.UFTUploadSrvBusiProp.DiscUploadSrvBusiProp;
import java.util.List;
import mqq.app.AppRuntime;

public class UFTDiscUploadFileOp
  extends UFTBaseUploadFileOp
{
  public UFTDiscUploadFileOp(AppRuntime paramAppRuntime, UFTDiscUploadTaskInfo paramUFTDiscUploadTaskInfo, UFTTransferKey paramUFTTransferKey, UFTBaseUploadFileOp.UFTUploadFileOpCallback paramUFTUploadFileOpCallback)
  {
    super(paramAppRuntime, paramUFTDiscUploadTaskInfo, paramUFTTransferKey, paramUFTUploadFileOpCallback);
  }
  
  private int a(UFTDiscUploadTaskInfo paramUFTDiscUploadTaskInfo, UFTUploadSrvBusiProp.DiscUploadSrvBusiProp paramDiscUploadSrvBusiProp)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("TId[");
    ((StringBuilder)localObject).append(i());
    ((StringBuilder)localObject).append("] start disc ftn upload.");
    UFTLog.b("[UFTTransfer] UFTDiscUploadFileOp", 1, ((StringBuilder)localObject).toString());
    localObject = new UFTFileUploaderProp.FtnMoreUrlFUperProp();
    ((UFTFileUploaderProp.FtnMoreUrlFUperProp)localObject).a(paramUFTDiscUploadTaskInfo.n());
    ((UFTFileUploaderProp.FtnMoreUrlFUperProp)localObject).a(paramUFTDiscUploadTaskInfo.b());
    ((UFTFileUploaderProp.FtnMoreUrlFUperProp)localObject).a(paramUFTDiscUploadTaskInfo.a());
    ((UFTFileUploaderProp.FtnMoreUrlFUperProp)localObject).b(paramDiscUploadSrvBusiProp.c());
    ((UFTFileUploaderProp.FtnMoreUrlFUperProp)localObject).f(paramDiscUploadSrvBusiProp.d());
    ((UFTFileUploaderProp.FtnMoreUrlFUperProp)localObject).b(paramDiscUploadSrvBusiProp.g());
    ((UFTFileUploaderProp.FtnMoreUrlFUperProp)localObject).c(paramDiscUploadSrvBusiProp.h());
    paramUFTDiscUploadTaskInfo = paramDiscUploadSrvBusiProp.a();
    if ((paramUFTDiscUploadTaskInfo != null) && (paramUFTDiscUploadTaskInfo.size() != 0))
    {
      ((UFTFileUploaderProp.FtnMoreUrlFUperProp)localObject).a(paramUFTDiscUploadTaskInfo);
      ((UFTFileUploaderProp.FtnMoreUrlFUperProp)localObject).e(paramDiscUploadSrvBusiProp.b());
      this.c = UFTFileTransferFactory.a(this.g, (UFTFileUploaderProp.FtnMoreUrlFUperProp)localObject);
      if (this.c == null)
      {
        paramUFTDiscUploadTaskInfo = new StringBuilder();
        paramUFTDiscUploadTaskInfo.append("TId[");
        paramUFTDiscUploadTaskInfo.append(i());
        paramUFTDiscUploadTaskInfo.append("] upload error. cannot create ftn uploader");
        UFTLog.d("[UFTTransfer] UFTDiscUploadFileOp", 1, paramUFTDiscUploadTaskInfo.toString());
        c("file uploader can not create");
        return 9045;
      }
      this.c.a(this);
      if (!this.c.a(0L))
      {
        paramUFTDiscUploadTaskInfo = new StringBuilder();
        paramUFTDiscUploadTaskInfo.append("TId[");
        paramUFTDiscUploadTaskInfo.append(i());
        paramUFTDiscUploadTaskInfo.append("] upload error. ftn uploader start fail");
        UFTLog.d("[UFTTransfer] UFTDiscUploadFileOp", 1, paramUFTDiscUploadTaskInfo.toString());
        c("run upload file fail");
        return 9360;
      }
      return 0;
    }
    paramUFTDiscUploadTaskInfo = new StringBuilder();
    paramUFTDiscUploadTaskInfo.append("TId[");
    paramUFTDiscUploadTaskInfo.append(i());
    paramUFTDiscUploadTaskInfo.append("] upload error. no host");
    UFTLog.d("[UFTTransfer] UFTDiscUploadFileOp", 1, paramUFTDiscUploadTaskInfo.toString());
    c("no host list");
    return 9048;
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
    ((StringBuilder)localObject).append("] do start disc upload op");
    UFTLog.b("[UFTTransfer] UFTDiscUploadFileOp", 1, ((StringBuilder)localObject).toString());
    localObject = (UFTDiscUploadTaskInfo)this.h;
    UFTUploadSrvBusiProp.DiscUploadSrvBusiProp localDiscUploadSrvBusiProp = ((UFTDiscUploadTaskInfo)localObject).f();
    if (localDiscUploadSrvBusiProp == null)
    {
      c("upload file srv busi info is null");
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("TId[");
      ((StringBuilder)localObject).append(i());
      ((StringBuilder)localObject).append("] do start disc upload fail. srv busi info is null");
      UFTLog.d("[UFTTransfer] UFTDiscUploadFileOp", 1, ((StringBuilder)localObject).toString());
      return 9005;
    }
    return a((UFTDiscUploadTaskInfo)localObject, localDiscUploadSrvBusiProp);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.uftransfer.task.upload.UFTDiscUploadFileOp
 * JD-Core Version:    0.7.0.1
 */