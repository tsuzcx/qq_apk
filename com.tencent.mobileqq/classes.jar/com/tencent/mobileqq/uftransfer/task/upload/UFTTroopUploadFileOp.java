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
    ((StringBuilder)localObject).append(a());
    ((StringBuilder)localObject).append("] start troop ftn upload.");
    UFTLog.b("[UFTTransfer] UFTTroopUploadFileOp", 1, ((StringBuilder)localObject).toString());
    localObject = new UFTFileUploaderProp.FtnMoreUrlFUperProp();
    ((UFTFileUploaderProp.FtnMoreUrlFUperProp)localObject).a(paramUFTTroopUploadTaskInfo.a());
    ((UFTFileUploaderProp.FtnMoreUrlFUperProp)localObject).a(paramUFTTroopUploadTaskInfo.a());
    ((UFTFileUploaderProp.FtnMoreUrlFUperProp)localObject).a(paramUFTTroopUploadTaskInfo.d());
    ((UFTFileUploaderProp.FtnMoreUrlFUperProp)localObject).b(paramTroopUploadSrvBusiProp.a());
    ((UFTFileUploaderProp.FtnMoreUrlFUperProp)localObject).f(paramTroopUploadSrvBusiProp.b());
    ((UFTFileUploaderProp.FtnMoreUrlFUperProp)localObject).b(paramTroopUploadSrvBusiProp.c());
    ((UFTFileUploaderProp.FtnMoreUrlFUperProp)localObject).c(paramTroopUploadSrvBusiProp.d());
    ((UFTFileUploaderProp.FtnMoreUrlFUperProp)localObject).d("TroopFile");
    ((UFTFileUploaderProp.FtnMoreUrlFUperProp)localObject).a(true);
    paramUFTTroopUploadTaskInfo = paramTroopUploadSrvBusiProp.a();
    if ((paramUFTTroopUploadTaskInfo != null) && (paramUFTTroopUploadTaskInfo.size() != 0))
    {
      ((UFTFileUploaderProp.FtnMoreUrlFUperProp)localObject).a(paramUFTTroopUploadTaskInfo);
      ((UFTFileUploaderProp.FtnMoreUrlFUperProp)localObject).e(paramTroopUploadSrvBusiProp.a());
      this.jdField_a_of_type_ComTencentMobileqqUftransferCommonTransferIUFTFileUploader = UFTFileTransferFactory.a(this.jdField_a_of_type_MqqAppAppRuntime, (UFTFileUploaderProp.FtnMoreUrlFUperProp)localObject);
      if (this.jdField_a_of_type_ComTencentMobileqqUftransferCommonTransferIUFTFileUploader == null)
      {
        paramUFTTroopUploadTaskInfo = new StringBuilder();
        paramUFTTroopUploadTaskInfo.append("TId[");
        paramUFTTroopUploadTaskInfo.append(a());
        paramUFTTroopUploadTaskInfo.append("] upload error. cannot create ftn uploader");
        UFTLog.d("[UFTTransfer] UFTTroopUploadFileOp", 1, paramUFTTroopUploadTaskInfo.toString());
        c("ftn fileUploader cannot create");
        return 3;
      }
      this.jdField_a_of_type_ComTencentMobileqqUftransferCommonTransferIUFTFileUploader.a(this);
      if (!this.jdField_a_of_type_ComTencentMobileqqUftransferCommonTransferIUFTFileUploader.a(0L))
      {
        paramUFTTroopUploadTaskInfo = new StringBuilder();
        paramUFTTroopUploadTaskInfo.append("TId[");
        paramUFTTroopUploadTaskInfo.append(a());
        paramUFTTroopUploadTaskInfo.append("] upload error. ftn uploader start fail");
        UFTLog.d("[UFTTransfer] UFTTroopUploadFileOp", 1, paramUFTTroopUploadTaskInfo.toString());
        c("run upload file fail");
        return 4;
      }
      return 0;
    }
    paramUFTTroopUploadTaskInfo = new StringBuilder();
    paramUFTTroopUploadTaskInfo.append("TId[");
    paramUFTTroopUploadTaskInfo.append(a());
    paramUFTTroopUploadTaskInfo.append("] upload error. no host");
    UFTLog.d("[UFTTransfer] UFTTroopUploadFileOp", 1, paramUFTTroopUploadTaskInfo.toString());
    c("no host list");
    return 2;
  }
  
  public boolean a()
  {
    return false;
  }
  
  protected int b()
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("TId[");
    ((StringBuilder)localObject).append(a());
    ((StringBuilder)localObject).append("] do start troop upload op");
    UFTLog.b("[UFTTransfer] UFTTroopUploadFileOp", 1, ((StringBuilder)localObject).toString());
    localObject = (UFTTroopUploadTaskInfo)this.jdField_a_of_type_ComTencentMobileqqUftransferTaskTaskinfoUFTBaseTaskInfo;
    UFTUploadSrvBusiProp.TroopUploadSrvBusiProp localTroopUploadSrvBusiProp = ((UFTTroopUploadTaskInfo)localObject).a();
    if (localTroopUploadSrvBusiProp == null)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("TId[");
      ((StringBuilder)localObject).append(a());
      ((StringBuilder)localObject).append("] do start troop upload fail. srv busi info is null");
      UFTLog.d("[UFTTransfer] UFTTroopUploadFileOp", 1, ((StringBuilder)localObject).toString());
      c("upload file srv busi info is null");
      return 1;
    }
    return a((UFTTroopUploadTaskInfo)localObject, localTroopUploadSrvBusiProp);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.uftransfer.task.upload.UFTTroopUploadFileOp
 * JD-Core Version:    0.7.0.1
 */