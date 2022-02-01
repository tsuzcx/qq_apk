package com.tencent.mobileqq.uftransfer.task.upload;

import com.tencent.mobileqq.filemanager.excitingtransfer.excitingtransfersdk.ExcitingTransferUploadResultRp;
import com.tencent.mobileqq.uftransfer.api.UFTFileLocalInfo;
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
import com.tencent.mobileqq.uftransfer.task.taskinfo.UFTC2CUploadTaskInfo;
import com.tencent.mobileqq.uftransfer.task.taskinfo.UFTUploadSrvBusiProp.C2CUploadSrvBusiProp;
import java.util.ArrayList;
import mqq.app.AppRuntime;

public class UFTC2CExtfUploadFileOp
  extends UFTC2CUploadFileOp
{
  protected ExcitingTransferUploadResultRp a;
  protected boolean c = false;
  protected boolean d = false;
  
  public UFTC2CExtfUploadFileOp(AppRuntime paramAppRuntime, UFTC2CUploadTaskInfo paramUFTC2CUploadTaskInfo, UFTTransferKey paramUFTTransferKey, UFTBaseUploadFileOp.UFTUploadFileOpCallback paramUFTUploadFileOpCallback)
  {
    super(paramAppRuntime, paramUFTC2CUploadTaskInfo, paramUFTTransferKey, paramUFTUploadFileOpCallback);
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerExcitingtransferExcitingtransfersdkExcitingTransferUploadResultRp = null;
  }
  
  protected int a(UFTC2CUploadTaskInfo paramUFTC2CUploadTaskInfo, UFTUploadSrvBusiProp.C2CUploadSrvBusiProp paramC2CUploadSrvBusiProp)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("TId[");
    ((StringBuilder)localObject).append(a());
    ((StringBuilder)localObject).append("] start c2c extf upload. useIPv6:");
    ((StringBuilder)localObject).append(this.c);
    ((StringBuilder)localObject).append(" useMediaPlat:");
    ((StringBuilder)localObject).append(this.d);
    UFTLog.b("[UFTTransfer] UFTC2CExtfUploadFileOp", 1, ((StringBuilder)localObject).toString());
    localObject = new UFTFileUploaderProp.ExtfFUperProp();
    ((UFTFileUploaderProp.ExtfFUperProp)localObject).a(paramUFTC2CUploadTaskInfo.a());
    ((UFTFileUploaderProp.ExtfFUperProp)localObject).a(paramUFTC2CUploadTaskInfo.a());
    ((UFTFileUploaderProp.ExtfFUperProp)localObject).b(Long.valueOf(paramUFTC2CUploadTaskInfo.d()).longValue());
    ((UFTFileUploaderProp.ExtfFUperProp)localObject).d(69);
    ((UFTFileUploaderProp.ExtfFUperProp)localObject).c(3);
    ((UFTFileUploaderProp.ExtfFUperProp)localObject).b(0);
    ((UFTFileUploaderProp.ExtfFUperProp)localObject).a(this.d);
    ((UFTFileUploaderProp.ExtfFUperProp)localObject).a(paramUFTC2CUploadTaskInfo.a().a().a());
    ((UFTFileUploaderProp.ExtfFUperProp)localObject).a().b(paramUFTC2CUploadTaskInfo.a().a());
    ((UFTFileUploaderProp.ExtfFUperProp)localObject).a().a(paramUFTC2CUploadTaskInfo.a().b());
    ((UFTFileUploaderProp.ExtfFUperProp)localObject).a().c(paramUFTC2CUploadTaskInfo.a().d());
    ((UFTFileUploaderProp.ExtfFUperProp)localObject).a().d(paramUFTC2CUploadTaskInfo.a().c());
    if (this.d) {
      ((UFTFileUploaderProp.ExtfFUperProp)localObject).a().f(paramC2CUploadSrvBusiProp.d());
    } else {
      ((UFTFileUploaderProp.ExtfFUperProp)localObject).a().f(paramC2CUploadSrvBusiProp.c());
    }
    ((UFTFileUploaderProp.ExtfFUperProp)localObject).a().e(paramC2CUploadSrvBusiProp.a());
    ((UFTFileUploaderProp.ExtfFUperProp)localObject).a().b(paramUFTC2CUploadTaskInfo.a());
    ((UFTFileUploaderProp.ExtfFUperProp)localObject).a().a(paramUFTC2CUploadTaskInfo.c());
    ((UFTFileUploaderProp.ExtfFUperProp)localObject).a().a(paramUFTC2CUploadTaskInfo.b());
    ((UFTFileUploaderProp.ExtfFUperProp)localObject).a().a(false);
    ((UFTFileUploaderProp.ExtfFUperProp)localObject).a().a(paramC2CUploadSrvBusiProp.e());
    paramUFTC2CUploadTaskInfo = new ArrayList();
    int i = UFTDependFeatureApi.a(this.jdField_a_of_type_MqqAppAppRuntime, this.c, 1, paramUFTC2CUploadTaskInfo);
    ((UFTFileUploaderProp.ExtfFUperProp)localObject).a().a(paramUFTC2CUploadTaskInfo);
    if ((i != 2) && (i != 3))
    {
      paramC2CUploadSrvBusiProp.b(false);
    }
    else
    {
      paramC2CUploadSrvBusiProp.b(true);
      paramC2CUploadSrvBusiProp.c(false);
      if (i == 3) {
        paramC2CUploadSrvBusiProp.c(true);
      }
    }
    paramC2CUploadSrvBusiProp.a(false);
    this.jdField_a_of_type_ComTencentMobileqqUftransferCommonTransferIUFTFileUploader = UFTFileTransferFactory.a(this.jdField_a_of_type_MqqAppAppRuntime, (UFTFileUploaderProp.ExtfFUperProp)localObject);
    if (this.jdField_a_of_type_ComTencentMobileqqUftransferCommonTransferIUFTFileUploader == null)
    {
      paramUFTC2CUploadTaskInfo = new StringBuilder();
      paramUFTC2CUploadTaskInfo.append("TId[");
      paramUFTC2CUploadTaskInfo.append(a());
      paramUFTC2CUploadTaskInfo.append("] upload error. cannot create extf uploader");
      UFTLog.d("[UFTTransfer] UFTC2CExtfUploadFileOp", 1, paramUFTC2CUploadTaskInfo.toString());
      c("file extf uploader can not create");
      return 9045;
    }
    this.jdField_a_of_type_ComTencentMobileqqUftransferCommonTransferIUFTFileUploader.a(this);
    if (!this.jdField_a_of_type_ComTencentMobileqqUftransferCommonTransferIUFTFileUploader.a(0L))
    {
      paramUFTC2CUploadTaskInfo = new StringBuilder();
      paramUFTC2CUploadTaskInfo.append("TId[");
      paramUFTC2CUploadTaskInfo.append(a());
      paramUFTC2CUploadTaskInfo.append("] upload error. extf uploader start fail");
      UFTLog.d("[UFTTransfer] UFTC2CExtfUploadFileOp", 1, paramUFTC2CUploadTaskInfo.toString());
      c("run extf upload file fail");
      return 9360;
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
    Object localObject = (UFTC2CUploadTaskInfo)this.jdField_a_of_type_ComTencentMobileqqUftransferTaskTaskinfoUFTBaseTaskInfo;
    this.c = ((UFTC2CUploadTaskInfo)localObject).a().a().d();
    localObject = ((UFTC2CUploadTaskInfo)localObject).a();
    if (localObject != null) {
      this.d = ((UFTUploadSrvBusiProp.C2CUploadSrvBusiProp)localObject).e();
    }
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
 * Qualified Name:     com.tencent.mobileqq.uftransfer.task.upload.UFTC2CExtfUploadFileOp
 * JD-Core Version:    0.7.0.1
 */