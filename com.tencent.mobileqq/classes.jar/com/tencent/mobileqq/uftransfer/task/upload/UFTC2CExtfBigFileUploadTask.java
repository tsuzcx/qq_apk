package com.tencent.mobileqq.uftransfer.task.upload;

import com.tencent.mobileqq.uftransfer.api.IUFTUploadCallback;
import com.tencent.mobileqq.uftransfer.api.UFTFileLocalInfo;
import com.tencent.mobileqq.uftransfer.api.impl.UFTTransferKey;
import com.tencent.mobileqq.uftransfer.depend.UFTLog;
import com.tencent.mobileqq.uftransfer.task.IUFTTaskCallback;
import com.tencent.mobileqq.uftransfer.task.commonop.UFTCalcHashOp;
import com.tencent.mobileqq.uftransfer.task.taskinfo.UFTBaseTaskInfo;
import com.tencent.mobileqq.uftransfer.task.taskinfo.UFTC2CUploadTaskInfo;
import mqq.app.AppRuntime;

public class UFTC2CExtfBigFileUploadTask
  extends UFTC2CExtfUploadTask
{
  protected UFTCalcHashOp a;
  protected UFTC2CFetchUploadUrlV2HitOp a;
  
  protected UFTC2CExtfBigFileUploadTask(AppRuntime paramAppRuntime, UFTTransferKey paramUFTTransferKey, UFTC2CUploadTaskInfo paramUFTC2CUploadTaskInfo, IUFTTaskCallback paramIUFTTaskCallback, IUFTUploadCallback paramIUFTUploadCallback)
  {
    super(paramAppRuntime, paramUFTTransferKey, paramUFTC2CUploadTaskInfo, paramIUFTTaskCallback, paramIUFTUploadCallback);
  }
  
  public static UFTC2CExtfBigFileUploadTask a(AppRuntime paramAppRuntime, UFTTransferKey paramUFTTransferKey, UFTC2CUploadTaskInfo paramUFTC2CUploadTaskInfo, IUFTTaskCallback paramIUFTTaskCallback, IUFTUploadCallback paramIUFTUploadCallback)
  {
    if (a(paramAppRuntime, paramUFTTransferKey, paramUFTC2CUploadTaskInfo, paramIUFTTaskCallback, "[UFTTransfer] UFTC2CBigFileUploadTask")) {
      return new UFTC2CExtfBigFileUploadTask(paramAppRuntime, paramUFTTransferKey, paramUFTC2CUploadTaskInfo, paramIUFTTaskCallback, paramIUFTUploadCallback);
    }
    return null;
  }
  
  protected UFTC2CUploadTask a(IUFTTaskCallback paramIUFTTaskCallback, IUFTUploadCallback paramIUFTUploadCallback)
  {
    return UFTC2CBigFileUploadTask.a(this.jdField_a_of_type_MqqAppAppRuntime, this.jdField_a_of_type_ComTencentMobileqqUftransferApiImplUFTTransferKey, (UFTC2CUploadTaskInfo)this.jdField_a_of_type_ComTencentMobileqqUftransferTaskTaskinfoUFTBaseTaskInfo, paramIUFTTaskCallback, paramIUFTUploadCallback);
  }
  
  protected void a()
  {
    if (this.jdField_b_of_type_Boolean)
    {
      super.a();
      return;
    }
    if (this.jdField_b_of_type_ComTencentMobileqqUftransferTaskCommonopUFTCalcHashOp != null)
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("TId[");
      localStringBuilder.append(a());
      localStringBuilder.append("] CalcHashOp had do");
      UFTLog.d("[UFTTransfer] UFTC2CBigFileUploadTask", 1, localStringBuilder.toString());
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("TId[");
    localStringBuilder.append(a());
    localStringBuilder.append("] doCalcHashOp...");
    UFTLog.b("[UFTTransfer] UFTC2CBigFileUploadTask", 1, localStringBuilder.toString());
    this.jdField_b_of_type_ComTencentMobileqqUftransferTaskCommonopUFTCalcHashOp = new UFTCalcHashOp(this.jdField_a_of_type_MqqAppAppRuntime, this.jdField_a_of_type_ComTencentMobileqqUftransferTaskTaskinfoUFTBaseTaskInfo, this.jdField_a_of_type_ComTencentMobileqqUftransferApiImplUFTTransferKey, a(), 21L, new UFTC2CExtfBigFileUploadTask.1(this));
    int i = this.jdField_b_of_type_ComTencentMobileqqUftransferTaskCommonopUFTCalcHashOp.a();
    if (i != 0) {
      c(i);
    }
  }
  
  protected void a(int paramInt, String paramString)
  {
    if (this.jdField_b_of_type_Boolean)
    {
      super.a(paramInt, paramString);
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("TId[");
    localStringBuilder.append(a());
    localStringBuilder.append("] onFetchUrlOpDone errCode:");
    localStringBuilder.append(paramInt);
    localStringBuilder.append(" errMsg:");
    localStringBuilder.append(paramString);
    UFTLog.b("[UFTTransfer] UFTC2CBigFileUploadTask", 1, localStringBuilder.toString());
    if (paramInt != 0)
    {
      a(paramInt, a(3, paramString));
      return;
    }
    j();
    if ((this.jdField_a_of_type_ComTencentMobileqqUftransferTaskTaskinfoUFTBaseTaskInfo.a().d() != null) && (this.jdField_a_of_type_ComTencentMobileqqUftransferTaskTaskinfoUFTBaseTaskInfo.a().d().length > 0))
    {
      paramString = new StringBuilder();
      paramString.append("TId[");
      paramString.append(a());
      paramString.append("] onFetchUrlOpDone getted sha and do hit");
      UFTLog.b("[UFTTransfer] UFTC2CBigFileUploadTask", 1, paramString.toString());
      this.jdField_a_of_type_ComTencentMobileqqUftransferTaskUploadUFTUploadCbWrapper.a(this.jdField_a_of_type_ComTencentMobileqqUftransferApiImplUFTTransferKey, this.jdField_a_of_type_ComTencentMobileqqUftransferTaskTaskinfoUFTBaseTaskInfo.a());
      paramString = this.jdField_a_of_type_ComTencentMobileqqUftransferTaskCommonopUFTCalcHashOp;
      if (paramString != null)
      {
        paramString.a();
        this.jdField_a_of_type_ComTencentMobileqqUftransferTaskCommonopUFTCalcHashOp = null;
      }
      d();
      g();
    }
  }
  
  protected void a(UFTBaseUploadFileOp.UploadFileOpRetData paramUploadFileOpRetData)
  {
    if (!this.jdField_b_of_type_Boolean)
    {
      Object localObject = this.jdField_a_of_type_ComTencentMobileqqUftransferTaskCommonopUFTCalcHashOp;
      if (localObject != null)
      {
        ((UFTCalcHashOp)localObject).a();
        this.jdField_a_of_type_ComTencentMobileqqUftransferTaskCommonopUFTCalcHashOp = null;
      }
      localObject = this.jdField_a_of_type_ComTencentMobileqqUftransferTaskUploadUFTC2CFetchUploadUrlV2HitOp;
      if (localObject != null)
      {
        ((UFTC2CFetchUploadUrlV2HitOp)localObject).a();
        this.jdField_a_of_type_ComTencentMobileqqUftransferTaskUploadUFTC2CFetchUploadUrlV2HitOp = null;
      }
    }
    super.a(paramUploadFileOpRetData);
  }
  
  protected void a(boolean paramBoolean)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("TId[");
    ((StringBuilder)localObject).append(a());
    ((StringBuilder)localObject).append("] onUploadHitOpDone hit:");
    ((StringBuilder)localObject).append(paramBoolean);
    UFTLog.d("[UFTTransfer] UFTC2CBigFileUploadTask", 1, ((StringBuilder)localObject).toString());
    if (!paramBoolean) {
      return;
    }
    j();
    localObject = this.jdField_a_of_type_ComTencentMobileqqUftransferTaskCommonopUFTCalcHashOp;
    if (localObject != null)
    {
      ((UFTCalcHashOp)localObject).a();
      this.jdField_a_of_type_ComTencentMobileqqUftransferTaskCommonopUFTCalcHashOp = null;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqUftransferTaskUploadUFTC2CUploadFileOp != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqUftransferTaskUploadUFTC2CUploadFileOp.a();
      this.jdField_a_of_type_ComTencentMobileqqUftransferTaskUploadUFTC2CUploadFileOp = null;
    }
    k();
  }
  
  protected void b()
  {
    if (this.jdField_b_of_type_Boolean)
    {
      super.b();
      return;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqUftransferTaskUploadUFTC2CFetchUploadUrlOp != null)
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("TId[");
      localStringBuilder.append(a());
      localStringBuilder.append("] FetchUrlOp had do");
      UFTLog.d("[UFTTransfer] UFTC2CBigFileUploadTask", 1, localStringBuilder.toString());
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("TId[");
    localStringBuilder.append(a());
    localStringBuilder.append("] doFetchUrlOp...");
    UFTLog.b("[UFTTransfer] UFTC2CBigFileUploadTask", 1, localStringBuilder.toString());
    this.jdField_a_of_type_ComTencentMobileqqUftransferTaskUploadUFTC2CFetchUploadUrlOp = new UFTC2CFetchUploadUrlV2Op(this.jdField_a_of_type_MqqAppAppRuntime, (UFTC2CUploadTaskInfo)this.jdField_a_of_type_ComTencentMobileqqUftransferTaskTaskinfoUFTBaseTaskInfo, this.jdField_a_of_type_ComTencentMobileqqUftransferApiImplUFTTransferKey, new UFTC2CExtfBigFileUploadTask.2(this));
    int i = this.jdField_a_of_type_ComTencentMobileqqUftransferTaskUploadUFTC2CFetchUploadUrlOp.a();
    if (i != 0) {
      a(i, this.jdField_a_of_type_ComTencentMobileqqUftransferTaskUploadUFTC2CFetchUploadUrlOp.a());
    }
  }
  
  protected void c()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqUftransferTaskCommonopUFTCalcHashOp != null)
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("TId[");
      localStringBuilder.append(a());
      localStringBuilder.append("] CalcFullShaOp had do");
      UFTLog.d("[UFTTransfer] UFTC2CBigFileUploadTask", 1, localStringBuilder.toString());
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("TId[");
    localStringBuilder.append(a());
    localStringBuilder.append("] doCalcFullShaOp...");
    UFTLog.b("[UFTTransfer] UFTC2CBigFileUploadTask", 1, localStringBuilder.toString());
    this.jdField_a_of_type_ComTencentMobileqqUftransferTaskCommonopUFTCalcHashOp = new UFTCalcHashOp(this.jdField_a_of_type_MqqAppAppRuntime, this.jdField_a_of_type_ComTencentMobileqqUftransferTaskTaskinfoUFTBaseTaskInfo, this.jdField_a_of_type_ComTencentMobileqqUftransferApiImplUFTTransferKey, a(), 8L, new UFTC2CExtfBigFileUploadTask.3(this));
    int i = this.jdField_a_of_type_ComTencentMobileqqUftransferTaskCommonopUFTCalcHashOp.a();
    if (i != 0) {
      d(i);
    }
  }
  
  protected void c(int paramInt)
  {
    super.c(paramInt);
    if (this.jdField_b_of_type_Boolean) {
      return;
    }
    if (paramInt == 0) {
      c();
    }
  }
  
  protected void d()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqUftransferTaskUploadUFTC2CFetchUploadUrlV2HitOp != null)
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("TId[");
      localStringBuilder.append(a());
      localStringBuilder.append("] UploadHitOp had do");
      UFTLog.d("[UFTTransfer] UFTC2CBigFileUploadTask", 1, localStringBuilder.toString());
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("TId[");
    localStringBuilder.append(a());
    localStringBuilder.append("] doUploadHitOp...");
    UFTLog.b("[UFTTransfer] UFTC2CBigFileUploadTask", 1, localStringBuilder.toString());
    this.jdField_a_of_type_ComTencentMobileqqUftransferTaskUploadUFTC2CFetchUploadUrlV2HitOp = new UFTC2CFetchUploadUrlV2HitOp(this.jdField_a_of_type_MqqAppAppRuntime, (UFTC2CUploadTaskInfo)this.jdField_a_of_type_ComTencentMobileqqUftransferTaskTaskinfoUFTBaseTaskInfo, this.jdField_a_of_type_ComTencentMobileqqUftransferApiImplUFTTransferKey, new UFTC2CExtfBigFileUploadTask.4(this));
    this.jdField_a_of_type_ComTencentMobileqqUftransferTaskUploadUFTC2CFetchUploadUrlV2HitOp.a();
  }
  
  protected void d(int paramInt)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("TId[");
    localStringBuilder.append(a());
    localStringBuilder.append("] onCalcFullShaOpDone errCode:");
    localStringBuilder.append(paramInt);
    UFTLog.b("[UFTTransfer] UFTC2CBigFileUploadTask", 1, localStringBuilder.toString());
    if (paramInt != 0) {
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqUftransferTaskUploadUFTUploadCbWrapper.a(this.jdField_a_of_type_ComTencentMobileqqUftransferApiImplUFTTransferKey, this.jdField_a_of_type_ComTencentMobileqqUftransferTaskTaskinfoUFTBaseTaskInfo.a());
    d();
    g();
  }
  
  protected void e()
  {
    super.e();
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqUftransferTaskCommonopUFTCalcHashOp;
    if (localObject != null)
    {
      ((UFTCalcHashOp)localObject).a();
      this.jdField_a_of_type_ComTencentMobileqqUftransferTaskCommonopUFTCalcHashOp = null;
    }
    localObject = this.jdField_a_of_type_ComTencentMobileqqUftransferTaskUploadUFTC2CFetchUploadUrlV2HitOp;
    if (localObject != null)
    {
      ((UFTC2CFetchUploadUrlV2HitOp)localObject).a();
      this.jdField_a_of_type_ComTencentMobileqqUftransferTaskUploadUFTC2CFetchUploadUrlV2HitOp = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.uftransfer.task.upload.UFTC2CExtfBigFileUploadTask
 * JD-Core Version:    0.7.0.1
 */