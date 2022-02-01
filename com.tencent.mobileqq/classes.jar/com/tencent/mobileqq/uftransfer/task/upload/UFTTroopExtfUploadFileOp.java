package com.tencent.mobileqq.uftransfer.task.upload;

import com.tencent.mobileqq.filemanager.excitingtransfer.excitingtransfersdk.ExcitingTransferUploadResultRp;
import com.tencent.mobileqq.uftransfer.api.UFTFileLocalInfo;
import com.tencent.mobileqq.uftransfer.api.UFTHost;
import com.tencent.mobileqq.uftransfer.api.UFTTransferConfig;
import com.tencent.mobileqq.uftransfer.api.UFTTransferConfig.UploadConfig;
import com.tencent.mobileqq.uftransfer.api.impl.UFTTransferKey;
import com.tencent.mobileqq.uftransfer.common.transfer.IUFTFileUploader;
import com.tencent.mobileqq.uftransfer.common.transfer.UFTFileTransferFactory;
import com.tencent.mobileqq.uftransfer.common.transfer.UFTFileUploaderProp.ExtfFUperProp;
import com.tencent.mobileqq.uftransfer.common.transfer.UFTFileUploaderProp.ExtfFileInfo;
import com.tencent.mobileqq.uftransfer.common.transfer.UFTFileUploaderProp.ExtfSvrInfo;
import com.tencent.mobileqq.uftransfer.depend.UFTDependFeatureApi;
import com.tencent.mobileqq.uftransfer.depend.UFTLog;
import com.tencent.mobileqq.uftransfer.task.taskinfo.UFTTroopUploadTaskInfo;
import com.tencent.mobileqq.uftransfer.task.taskinfo.UFTUploadSrvBusiProp.TroopUploadSrvBusiProp;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import mqq.app.AppRuntime;

public class UFTTroopExtfUploadFileOp
  extends UFTTroopUploadFileOp
{
  protected ExcitingTransferUploadResultRp a;
  protected boolean c = false;
  
  public UFTTroopExtfUploadFileOp(AppRuntime paramAppRuntime, UFTTroopUploadTaskInfo paramUFTTroopUploadTaskInfo, UFTTransferKey paramUFTTransferKey, UFTBaseUploadFileOp.UFTUploadFileOpCallback paramUFTUploadFileOpCallback)
  {
    super(paramAppRuntime, paramUFTTroopUploadTaskInfo, paramUFTTransferKey, paramUFTUploadFileOpCallback);
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerExcitingtransferExcitingtransfersdkExcitingTransferUploadResultRp = null;
  }
  
  protected int a(UFTTroopUploadTaskInfo paramUFTTroopUploadTaskInfo, UFTUploadSrvBusiProp.TroopUploadSrvBusiProp paramTroopUploadSrvBusiProp)
  {
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("TId[");
    ((StringBuilder)localObject1).append(a());
    ((StringBuilder)localObject1).append("] start troop extf upload. useIPv6:");
    ((StringBuilder)localObject1).append(this.c);
    UFTLog.b("[UFTTransfer] UFTTroopExtfUploadFileOp", 1, ((StringBuilder)localObject1).toString());
    localObject1 = new UFTFileUploaderProp.ExtfFUperProp();
    ((UFTFileUploaderProp.ExtfFUperProp)localObject1).a(paramUFTTroopUploadTaskInfo.a());
    ((UFTFileUploaderProp.ExtfFUperProp)localObject1).a(paramUFTTroopUploadTaskInfo.a());
    ((UFTFileUploaderProp.ExtfFUperProp)localObject1).b(Long.valueOf(paramUFTTroopUploadTaskInfo.c()).longValue());
    ((UFTFileUploaderProp.ExtfFUperProp)localObject1).d(71);
    ((UFTFileUploaderProp.ExtfFUperProp)localObject1).c(102);
    ((UFTFileUploaderProp.ExtfFUperProp)localObject1).b(1);
    ((UFTFileUploaderProp.ExtfFUperProp)localObject1).c(Long.valueOf(paramUFTTroopUploadTaskInfo.c()).longValue());
    ((UFTFileUploaderProp.ExtfFUperProp)localObject1).a().b(paramUFTTroopUploadTaskInfo.a().a());
    ((UFTFileUploaderProp.ExtfFUperProp)localObject1).a().a(paramUFTTroopUploadTaskInfo.a().b());
    ((UFTFileUploaderProp.ExtfFUperProp)localObject1).a().c(paramUFTTroopUploadTaskInfo.a().d());
    ((UFTFileUploaderProp.ExtfFUperProp)localObject1).a().d(paramUFTTroopUploadTaskInfo.a().c());
    ((UFTFileUploaderProp.ExtfFUperProp)localObject1).a().f(paramTroopUploadSrvBusiProp.a());
    ((UFTFileUploaderProp.ExtfFUperProp)localObject1).a().e(paramTroopUploadSrvBusiProp.b());
    ((UFTFileUploaderProp.ExtfFUperProp)localObject1).a().b(paramUFTTroopUploadTaskInfo.a());
    ((UFTFileUploaderProp.ExtfFUperProp)localObject1).a().a(paramUFTTroopUploadTaskInfo.d());
    ((UFTFileUploaderProp.ExtfFUperProp)localObject1).a().a(paramUFTTroopUploadTaskInfo.b());
    ((UFTFileUploaderProp.ExtfFUperProp)localObject1).a().a(false);
    paramUFTTroopUploadTaskInfo = new ArrayList();
    int i = UFTDependFeatureApi.a(this.jdField_a_of_type_MqqAppAppRuntime, this.c, 3, paramUFTTroopUploadTaskInfo);
    ((UFTFileUploaderProp.ExtfFUperProp)localObject1).a().a(paramUFTTroopUploadTaskInfo);
    paramUFTTroopUploadTaskInfo = new ArrayList();
    Object localObject2 = paramTroopUploadSrvBusiProp.b();
    int j = paramTroopUploadSrvBusiProp.a();
    if ((localObject2 != null) && (((List)localObject2).size() > 0))
    {
      localObject2 = ((List)localObject2).iterator();
      while (((Iterator)localObject2).hasNext()) {
        paramUFTTroopUploadTaskInfo.add(new UFTHost((String)((Iterator)localObject2).next(), j));
      }
    }
    ((UFTFileUploaderProp.ExtfFUperProp)localObject1).a().b(paramUFTTroopUploadTaskInfo);
    paramUFTTroopUploadTaskInfo = new ArrayList();
    localObject2 = paramTroopUploadSrvBusiProp.c();
    if ((localObject2 != null) && (((List)localObject2).size() > 0))
    {
      localObject2 = ((List)localObject2).iterator();
      while (((Iterator)localObject2).hasNext()) {
        paramUFTTroopUploadTaskInfo.add(new UFTHost((String)((Iterator)localObject2).next(), j));
      }
    }
    ((UFTFileUploaderProp.ExtfFUperProp)localObject1).a().c(paramUFTTroopUploadTaskInfo);
    if ((i != 2) && (i != 3))
    {
      paramTroopUploadSrvBusiProp.b(false);
    }
    else
    {
      paramTroopUploadSrvBusiProp.b(true);
      paramTroopUploadSrvBusiProp.c(false);
      if (i == 3) {
        paramTroopUploadSrvBusiProp.c(true);
      }
    }
    paramTroopUploadSrvBusiProp.a(false);
    this.jdField_a_of_type_ComTencentMobileqqUftransferCommonTransferIUFTFileUploader = UFTFileTransferFactory.a(this.jdField_a_of_type_MqqAppAppRuntime, (UFTFileUploaderProp.ExtfFUperProp)localObject1);
    if (this.jdField_a_of_type_ComTencentMobileqqUftransferCommonTransferIUFTFileUploader == null)
    {
      paramUFTTroopUploadTaskInfo = new StringBuilder();
      paramUFTTroopUploadTaskInfo.append("TId[");
      paramUFTTroopUploadTaskInfo.append(a());
      paramUFTTroopUploadTaskInfo.append("] upload error. cannot create extf uploader");
      UFTLog.d("[UFTTransfer] UFTTroopExtfUploadFileOp", 1, paramUFTTroopUploadTaskInfo.toString());
      c("file uploader cannt create");
      return 3;
    }
    this.jdField_a_of_type_ComTencentMobileqqUftransferCommonTransferIUFTFileUploader.a(this);
    if (!this.jdField_a_of_type_ComTencentMobileqqUftransferCommonTransferIUFTFileUploader.a(0L))
    {
      paramUFTTroopUploadTaskInfo = new StringBuilder();
      paramUFTTroopUploadTaskInfo.append("TId[");
      paramUFTTroopUploadTaskInfo.append(a());
      paramUFTTroopUploadTaskInfo.append("] upload error. extf uploader start fail");
      UFTLog.d("[UFTTransfer] UFTTroopExtfUploadFileOp", 1, paramUFTTroopUploadTaskInfo.toString());
      c("run upload file fail");
      return 4;
    }
    return 0;
  }
  
  protected void a(UFTBaseUploadFileOp.UploadFileOpRetData paramUploadFileOpRetData)
  {
    if ((paramUploadFileOpRetData.a() != null) && ((paramUploadFileOpRetData.a() instanceof ExcitingTransferUploadResultRp))) {
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerExcitingtransferExcitingtransfersdkExcitingTransferUploadResultRp = ((ExcitingTransferUploadResultRp)paramUploadFileOpRetData.a());
    }
    super.a(paramUploadFileOpRetData);
  }
  
  public boolean a()
  {
    return true;
  }
  
  protected int b()
  {
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerExcitingtransferExcitingtransfersdkExcitingTransferUploadResultRp = null;
    this.c = ((UFTTroopUploadTaskInfo)this.jdField_a_of_type_ComTencentMobileqqUftransferTaskTaskinfoUFTBaseTaskInfo).a().a().d();
    return super.b();
  }
  
  public long d()
  {
    ExcitingTransferUploadResultRp localExcitingTransferUploadResultRp = this.jdField_a_of_type_ComTencentMobileqqFilemanagerExcitingtransferExcitingtransfersdkExcitingTransferUploadResultRp;
    if (localExcitingTransferUploadResultRp != null) {
      return localExcitingTransferUploadResultRp.mu64HttpTime;
    }
    return super.d();
  }
  
  public long e()
  {
    ExcitingTransferUploadResultRp localExcitingTransferUploadResultRp = this.jdField_a_of_type_ComTencentMobileqqFilemanagerExcitingtransferExcitingtransfersdkExcitingTransferUploadResultRp;
    if (localExcitingTransferUploadResultRp != null) {
      return localExcitingTransferUploadResultRp.mu64TransferSpeed;
    }
    return super.e();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.uftransfer.task.upload.UFTTroopExtfUploadFileOp
 * JD-Core Version:    0.7.0.1
 */