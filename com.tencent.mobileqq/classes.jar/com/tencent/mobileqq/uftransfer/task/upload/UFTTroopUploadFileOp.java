package com.tencent.mobileqq.uftransfer.task.upload;

import com.tencent.mobileqq.uftransfer.api.impl.UFTTransferKey;
import com.tencent.mobileqq.uftransfer.common.transfer.IUFTFileUploader;
import com.tencent.mobileqq.uftransfer.common.transfer.UFTFileTransferFactory;
import com.tencent.mobileqq.uftransfer.common.transfer.UFTFileUploaderProp.FtnMoreUrlFUperProp;
import com.tencent.mobileqq.uftransfer.depend.UFTLog;
import com.tencent.mobileqq.uftransfer.task.taskinfo.UFTTroopUploadTaskInfo;
import com.tencent.mobileqq.uftransfer.task.taskinfo.UFTUploadSrvBusiProp.TroopUploadSrvBusiProp;
import java.util.List;
import mqq.app.AppRuntime;

public class UFTTroopUploadFileOp
  extends UFTBaseUploadFileOp
{
  public UFTTroopUploadFileOp(AppRuntime paramAppRuntime, UFTTroopUploadTaskInfo paramUFTTroopUploadTaskInfo, UFTTransferKey paramUFTTransferKey, UFTBaseUploadFileOp.UFTUploadFileOpCallback paramUFTUploadFileOpCallback)
  {
    super(paramAppRuntime, paramUFTTroopUploadTaskInfo, paramUFTTransferKey, paramUFTUploadFileOpCallback);
  }
  
  protected int a(UFTTroopUploadTaskInfo paramUFTTroopUploadTaskInfo, UFTUploadSrvBusiProp.TroopUploadSrvBusiProp paramTroopUploadSrvBusiProp)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("TId[");
    ((StringBuilder)localObject).append(i());
    ((StringBuilder)localObject).append("] start troop ftn upload.");
    UFTLog.b("[UFTTransfer] UFTTroopUploadFileOp", 1, ((StringBuilder)localObject).toString());
    localObject = new UFTFileUploaderProp.FtnMoreUrlFUperProp();
    ((UFTFileUploaderProp.FtnMoreUrlFUperProp)localObject).a(paramUFTTroopUploadTaskInfo.n());
    ((UFTFileUploaderProp.FtnMoreUrlFUperProp)localObject).a(paramUFTTroopUploadTaskInfo.c());
    ((UFTFileUploaderProp.FtnMoreUrlFUperProp)localObject).a(paramUFTTroopUploadTaskInfo.b());
    ((UFTFileUploaderProp.FtnMoreUrlFUperProp)localObject).b(paramTroopUploadSrvBusiProp.c());
    ((UFTFileUploaderProp.FtnMoreUrlFUperProp)localObject).f(paramTroopUploadSrvBusiProp.d());
    ((UFTFileUploaderProp.FtnMoreUrlFUperProp)localObject).b(paramTroopUploadSrvBusiProp.g());
    ((UFTFileUploaderProp.FtnMoreUrlFUperProp)localObject).c(paramTroopUploadSrvBusiProp.h());
    ((UFTFileUploaderProp.FtnMoreUrlFUperProp)localObject).d("TroopFile");
    ((UFTFileUploaderProp.FtnMoreUrlFUperProp)localObject).a(true);
    paramUFTTroopUploadTaskInfo = paramTroopUploadSrvBusiProp.a();
    if ((paramUFTTroopUploadTaskInfo != null) && (paramUFTTroopUploadTaskInfo.size() != 0))
    {
      ((UFTFileUploaderProp.FtnMoreUrlFUperProp)localObject).a(paramUFTTroopUploadTaskInfo);
      ((UFTFileUploaderProp.FtnMoreUrlFUperProp)localObject).e(paramTroopUploadSrvBusiProp.b());
      this.c = UFTFileTransferFactory.a(this.g, (UFTFileUploaderProp.FtnMoreUrlFUperProp)localObject);
      if (this.c == null)
      {
        paramUFTTroopUploadTaskInfo = new StringBuilder();
        paramUFTTroopUploadTaskInfo.append("TId[");
        paramUFTTroopUploadTaskInfo.append(i());
        paramUFTTroopUploadTaskInfo.append("] upload error. cannot create ftn uploader");
        UFTLog.d("[UFTTransfer] UFTTroopUploadFileOp", 1, paramUFTTroopUploadTaskInfo.toString());
        c("ftn fileUploader cannot create");
        return 3;
      }
      this.c.a(this);
      if (!this.c.a(0L))
      {
        paramUFTTroopUploadTaskInfo = new StringBuilder();
        paramUFTTroopUploadTaskInfo.append("TId[");
        paramUFTTroopUploadTaskInfo.append(i());
        paramUFTTroopUploadTaskInfo.append("] upload error. ftn uploader start fail");
        UFTLog.d("[UFTTransfer] UFTTroopUploadFileOp", 1, paramUFTTroopUploadTaskInfo.toString());
        c("run upload file fail");
        return 4;
      }
      return 0;
    }
    paramUFTTroopUploadTaskInfo = new StringBuilder();
    paramUFTTroopUploadTaskInfo.append("TId[");
    paramUFTTroopUploadTaskInfo.append(i());
    paramUFTTroopUploadTaskInfo.append("] upload error. no host");
    UFTLog.d("[UFTTransfer] UFTTroopUploadFileOp", 1, paramUFTTroopUploadTaskInfo.toString());
    c("no host list");
    return 2;
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
    ((StringBuilder)localObject).append("] do start troop upload op");
    UFTLog.b("[UFTTransfer] UFTTroopUploadFileOp", 1, ((StringBuilder)localObject).toString());
    localObject = (UFTTroopUploadTaskInfo)this.h;
    UFTUploadSrvBusiProp.TroopUploadSrvBusiProp localTroopUploadSrvBusiProp = ((UFTTroopUploadTaskInfo)localObject).l();
    if (localTroopUploadSrvBusiProp == null)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("TId[");
      ((StringBuilder)localObject).append(i());
      ((StringBuilder)localObject).append("] do start troop upload fail. srv busi info is null");
      UFTLog.d("[UFTTransfer] UFTTroopUploadFileOp", 1, ((StringBuilder)localObject).toString());
      c("upload file srv busi info is null");
      return 1;
    }
    return a((UFTTroopUploadTaskInfo)localObject, localTroopUploadSrvBusiProp);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.uftransfer.task.upload.UFTTroopUploadFileOp
 * JD-Core Version:    0.7.0.1
 */