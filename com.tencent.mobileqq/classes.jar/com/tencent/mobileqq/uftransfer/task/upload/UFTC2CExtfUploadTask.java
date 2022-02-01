package com.tencent.mobileqq.uftransfer.task.upload;

import android.os.Bundle;
import com.tencent.mobileqq.filemanager.excitingtransfer.excitingtransfersdk.ExcitingTransferUploadResultRp;
import com.tencent.mobileqq.filemanager.excitingtransfer.excitingtransfersdk.ExcitingTransferUploaderRp;
import com.tencent.mobileqq.uftransfer.api.IUFTUploadCallback;
import com.tencent.mobileqq.uftransfer.api.UFTTransferConfig;
import com.tencent.mobileqq.uftransfer.api.UFTTransferConfig.UploadConfig;
import com.tencent.mobileqq.uftransfer.api.impl.UFTTransferKey;
import com.tencent.mobileqq.uftransfer.depend.UFTDependFeatureApi;
import com.tencent.mobileqq.uftransfer.depend.UFTLog;
import com.tencent.mobileqq.uftransfer.task.IUFTTaskCallback;
import com.tencent.mobileqq.uftransfer.task.commonop.UFTCalcHashOp;
import com.tencent.mobileqq.uftransfer.task.taskinfo.UFTBaseTaskInfo;
import com.tencent.mobileqq.uftransfer.task.taskinfo.UFTC2CUploadTaskInfo;
import com.tencent.mobileqq.uftransfer.task.taskinfo.UFTUploadSrvBusiProp.C2CUploadSrvBusiProp;
import com.tencent.mobileqq.uftransfer.task.taskinfo.UFTUploadTaskRunNotesInfo;
import com.tencent.mobileqq.uftransfer.task.utils.UFTTaskUtils;
import mqq.app.AppRuntime;

public class UFTC2CExtfUploadTask
  extends UFTC2CUploadTask
{
  protected IUFTUploadCallback a;
  protected UFTC2CUploadTask a;
  protected boolean b;
  
  protected UFTC2CExtfUploadTask(AppRuntime paramAppRuntime, UFTTransferKey paramUFTTransferKey, UFTC2CUploadTaskInfo paramUFTC2CUploadTaskInfo, IUFTTaskCallback paramIUFTTaskCallback, IUFTUploadCallback paramIUFTUploadCallback)
  {
    super(paramAppRuntime, paramUFTTransferKey, paramUFTC2CUploadTaskInfo, paramIUFTTaskCallback, paramIUFTUploadCallback);
    this.jdField_a_of_type_ComTencentMobileqqUftransferTaskUploadUFTC2CUploadTask = null;
    this.jdField_b_of_type_Boolean = paramUFTC2CUploadTaskInfo.a().a().f();
    this.jdField_a_of_type_ComTencentMobileqqUftransferApiIUFTUploadCallback = paramIUFTUploadCallback;
  }
  
  public static UFTC2CExtfUploadTask a(AppRuntime paramAppRuntime, UFTTransferKey paramUFTTransferKey, UFTC2CUploadTaskInfo paramUFTC2CUploadTaskInfo, IUFTTaskCallback paramIUFTTaskCallback, IUFTUploadCallback paramIUFTUploadCallback)
  {
    if (a(paramAppRuntime, paramUFTTransferKey, paramUFTC2CUploadTaskInfo, paramIUFTTaskCallback, "[UFTTransfer] UFTC2CExtfUploadTask")) {
      return new UFTC2CExtfUploadTask(paramAppRuntime, paramUFTTransferKey, paramUFTC2CUploadTaskInfo, paramIUFTTaskCallback, paramIUFTUploadCallback);
    }
    return null;
  }
  
  protected int a()
  {
    return 1;
  }
  
  protected UFTC2CUploadTask a(IUFTTaskCallback paramIUFTTaskCallback, IUFTUploadCallback paramIUFTUploadCallback)
  {
    return UFTC2CUploadTask.b(this.jdField_a_of_type_MqqAppAppRuntime, this.jdField_a_of_type_ComTencentMobileqqUftransferApiImplUFTTransferKey, (UFTC2CUploadTaskInfo)this.jdField_a_of_type_ComTencentMobileqqUftransferTaskTaskinfoUFTBaseTaskInfo, paramIUFTTaskCallback, paramIUFTUploadCallback);
  }
  
  protected UFTUploadCompleteInfo a(int paramInt, UFTUploadTaskCompParam paramUFTUploadTaskCompParam)
  {
    paramUFTUploadTaskCompParam = super.a(paramInt, paramUFTUploadTaskCompParam);
    paramUFTUploadTaskCompParam.b(true);
    return paramUFTUploadTaskCompParam;
  }
  
  protected void a()
  {
    if (this.jdField_b_of_type_Boolean)
    {
      f();
      return;
    }
    super.a();
  }
  
  protected void a(int paramInt, ExcitingTransferUploadResultRp paramExcitingTransferUploadResultRp)
  {
    if (paramInt == 9037)
    {
      h();
      return;
    }
    UFTC2CUploadTaskInfo localUFTC2CUploadTaskInfo = (UFTC2CUploadTaskInfo)this.jdField_a_of_type_ComTencentMobileqqUftransferTaskTaskinfoUFTBaseTaskInfo;
    UFTC2CExtfReportData.ResultReport localResultReport = new UFTC2CExtfReportData.ResultReport(this.jdField_a_of_type_MqqAppAppRuntime);
    boolean bool2 = true;
    boolean bool1 = true;
    if (paramExcitingTransferUploadResultRp != null)
    {
      paramInt = UFTDependFeatureApi.b(paramExcitingTransferUploadResultRp.mstrServerIp);
      if (paramExcitingTransferUploadResultRp.mnResult != 0L) {
        bool1 = false;
      }
      localResultReport.a(paramExcitingTransferUploadResultRp);
    }
    else
    {
      if (paramInt == 0) {
        bool1 = bool2;
      } else {
        bool1 = false;
      }
      if (!bool1)
      {
        if (this.jdField_a_of_type_ComTencentMobileqqUftransferTaskTaskinfoUFTUploadTaskRunNotesInfo.g() == 0L) {
          localResultReport.a(paramInt);
        } else {
          localResultReport.a(17);
        }
      }
      else {
        localResultReport.a(0);
      }
      paramInt = 0;
    }
    localResultReport.a(localUFTC2CUploadTaskInfo.a());
    paramExcitingTransferUploadResultRp = UFTDependFeatureApi.c(localUFTC2CUploadTaskInfo.a());
    localResultReport.a(Long.valueOf(localUFTC2CUploadTaskInfo.d()).longValue(), 0L, localUFTC2CUploadTaskInfo.a(), paramExcitingTransferUploadResultRp, localUFTC2CUploadTaskInfo.b());
    localResultReport.a(this.jdField_a_of_type_ComTencentMobileqqUftransferTaskTaskinfoUFTUploadTaskRunNotesInfo.a());
    long l = this.jdField_a_of_type_ComTencentMobileqqUftransferTaskTaskinfoUFTUploadTaskRunNotesInfo.b() - this.jdField_a_of_type_ComTencentMobileqqUftransferTaskTaskinfoUFTUploadTaskRunNotesInfo.a();
    if (l > 0L) {
      localResultReport.c(l);
    } else {
      localResultReport.c(0L);
    }
    l = this.jdField_a_of_type_ComTencentMobileqqUftransferTaskTaskinfoUFTUploadTaskRunNotesInfo.d() - this.jdField_a_of_type_ComTencentMobileqqUftransferTaskTaskinfoUFTUploadTaskRunNotesInfo.c();
    if (l > 0L) {
      localResultReport.b(l);
    } else {
      localResultReport.b(0L);
    }
    localResultReport.b(b());
    localResultReport.c(paramInt);
    localResultReport.b(false);
    localResultReport.c(bool1);
  }
  
  protected void a(int paramInt, ExcitingTransferUploaderRp paramExcitingTransferUploaderRp)
  {
    if (paramExcitingTransferUploaderRp == null) {
      return;
    }
    UFTC2CUploadTaskInfo localUFTC2CUploadTaskInfo = (UFTC2CUploadTaskInfo)this.jdField_a_of_type_ComTencentMobileqqUftransferTaskTaskinfoUFTBaseTaskInfo;
    Object localObject = localUFTC2CUploadTaskInfo.a();
    int i;
    if ((localObject != null) && (((UFTUploadSrvBusiProp.C2CUploadSrvBusiProp)localObject).b()))
    {
      if (((UFTUploadSrvBusiProp.C2CUploadSrvBusiProp)localObject).c()) {
        i = 3;
      } else {
        i = 2;
      }
    }
    else {
      i = 1;
    }
    localObject = new UFTC2CExtfReportData.UploaderReport(this.jdField_a_of_type_MqqAppAppRuntime);
    ((UFTC2CExtfReportData.UploaderReport)localObject).a(a());
    String str = UFTDependFeatureApi.c(this.jdField_a_of_type_ComTencentMobileqqUftransferTaskTaskinfoUFTBaseTaskInfo.a());
    ((UFTC2CExtfReportData.UploaderReport)localObject).a(paramInt);
    ((UFTC2CExtfReportData.UploaderReport)localObject).a(Long.valueOf(localUFTC2CUploadTaskInfo.d()).longValue(), 0L, localUFTC2CUploadTaskInfo.a(), str, localUFTC2CUploadTaskInfo.b());
    ((UFTC2CExtfReportData.UploaderReport)localObject).a(paramExcitingTransferUploaderRp);
    ((UFTC2CExtfReportData.UploaderReport)localObject).b(i);
    ((UFTC2CExtfReportData.UploaderReport)localObject).c(UFTDependFeatureApi.b(paramExcitingTransferUploaderRp.mstrServerIp));
    boolean bool = false;
    ((UFTC2CExtfReportData.UploaderReport)localObject).a(false);
    if (paramInt == 0) {
      bool = true;
    }
    ((UFTC2CExtfReportData.UploaderReport)localObject).b(bool);
  }
  
  protected void a(int paramInt, UFTUploadTaskCompParam paramUFTUploadTaskCompParam)
  {
    if (this.jdField_a_of_type_Boolean) {
      return;
    }
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("TId[");
    ((StringBuilder)localObject).append(a());
    ((StringBuilder)localObject).append("] do upload completed errCode:");
    ((StringBuilder)localObject).append(paramInt);
    ((StringBuilder)localObject).append(" errMsg:");
    ((StringBuilder)localObject).append(paramUFTUploadTaskCompParam.jdField_a_of_type_JavaLangString);
    UFTLog.b("[UFTTransfer] UFTC2CExtfUploadTask", 1, ((StringBuilder)localObject).toString());
    e();
    localObject = this.jdField_a_of_type_ComTencentMobileqqUftransferTaskTaskinfoUFTUploadTaskRunNotesInfo.a();
    if (paramInt != 0)
    {
      if ((this.jdField_a_of_type_ComTencentMobileqqUftransferTaskTaskinfoUFTBaseTaskInfo.a().a().b()) && (paramUFTUploadTaskCompParam.jdField_a_of_type_Boolean))
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("TId[");
        ((StringBuilder)localObject).append(a());
        ((StringBuilder)localObject).append("] ready to do safeGuard upload");
        UFTLog.c("[UFTTransfer] UFTC2CExtfUploadTask", 1, ((StringBuilder)localObject).toString());
        b(paramInt, paramUFTUploadTaskCompParam);
        return;
      }
      this.jdField_a_of_type_ComTencentMobileqqUftransferTaskTaskinfoUFTUploadTaskRunNotesInfo.b(System.currentTimeMillis());
      int i;
      if (paramUFTUploadTaskCompParam.jdField_a_of_type_Boolean)
      {
        i = UFTTaskUtils.a(paramInt);
      }
      else
      {
        c(this.jdField_a_of_type_ComTencentMobileqqUftransferTaskTaskinfoUFTUploadTaskRunNotesInfo.i(), paramInt, paramUFTUploadTaskCompParam);
        i = paramInt;
      }
      b(this.jdField_a_of_type_ComTencentMobileqqUftransferTaskTaskinfoUFTUploadTaskRunNotesInfo.i(), i, paramUFTUploadTaskCompParam);
      a(paramInt, (ExcitingTransferUploadResultRp)localObject);
    }
    else
    {
      this.jdField_a_of_type_ComTencentMobileqqUftransferTaskTaskinfoUFTUploadTaskRunNotesInfo.b(System.currentTimeMillis());
      n();
      a(0, (ExcitingTransferUploadResultRp)localObject);
    }
    this.jdField_a_of_type_ComTencentMobileqqUftransferTaskUploadUFTUploadCbWrapper.a(this.jdField_a_of_type_ComTencentMobileqqUftransferApiImplUFTTransferKey, paramInt, a(paramInt, paramUFTUploadTaskCompParam));
    a(paramInt);
  }
  
  protected void a(long paramLong, int paramInt, UFTUploadTaskCompParam paramUFTUploadTaskCompParam)
  {
    ExcitingTransferUploaderRp localExcitingTransferUploaderRp = paramUFTUploadTaskCompParam.a();
    if (paramInt != 0)
    {
      int i = UFTTaskUtils.a(paramInt);
      if (localExcitingTransferUploaderRp != null)
      {
        paramUFTUploadTaskCompParam.jdField_a_of_type_Long = localExcitingTransferUploaderRp.mu64HttpTime;
        paramUFTUploadTaskCompParam.b = localExcitingTransferUploaderRp.mu64TransferSpeed;
      }
      c(paramLong, i, paramUFTUploadTaskCompParam);
    }
    if (localExcitingTransferUploaderRp != null) {
      a(paramInt, localExcitingTransferUploaderRp);
    }
  }
  
  public void a(Bundle paramBundle)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqUftransferTaskUploadUFTC2CUploadTask != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqUftransferTaskTaskinfoUFTUploadTaskRunNotesInfo.b(System.currentTimeMillis());
      this.jdField_a_of_type_Boolean = true;
      b(3);
      this.jdField_a_of_type_ComTencentMobileqqUftransferTaskUploadUFTC2CUploadTask.a(paramBundle);
      this.jdField_a_of_type_ComTencentMobileqqUftransferTaskUploadUFTC2CUploadTask = null;
      return;
    }
    super.a(paramBundle);
  }
  
  protected void b(int paramInt, UFTUploadTaskCompParam paramUFTUploadTaskCompParam)
  {
    a(paramInt, this.jdField_a_of_type_ComTencentMobileqqUftransferTaskTaskinfoUFTUploadTaskRunNotesInfo.a());
    UFTC2CUploadTaskInfo localUFTC2CUploadTaskInfo = (UFTC2CUploadTaskInfo)this.jdField_a_of_type_ComTencentMobileqqUftransferTaskTaskinfoUFTBaseTaskInfo;
    String str = localUFTC2CUploadTaskInfo.b();
    UFTUploadSrvBusiProp.C2CUploadSrvBusiProp localC2CUploadSrvBusiProp = localUFTC2CUploadTaskInfo.a();
    boolean bool = localUFTC2CUploadTaskInfo.a().a().f();
    localUFTC2CUploadTaskInfo.b("");
    localUFTC2CUploadTaskInfo.a().a().a(false);
    localUFTC2CUploadTaskInfo.a().a().b(false);
    localUFTC2CUploadTaskInfo.a().a().f(false);
    localUFTC2CUploadTaskInfo.a(null);
    this.jdField_a_of_type_ComTencentMobileqqUftransferTaskUploadUFTC2CUploadTask = a(new UFTC2CExtfUploadTask.3(this), new UFTC2CExtfUploadTask.4(this));
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqUftransferTaskUploadUFTC2CUploadTask;
    if ((localObject == null) || (!((UFTC2CUploadTask)localObject).b()))
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("TId[");
      ((StringBuilder)localObject).append(a());
      ((StringBuilder)localObject).append("] do safeGuard upload fail");
      UFTLog.d("[UFTTransfer] UFTC2CExtfUploadTask", 1, ((StringBuilder)localObject).toString());
      this.jdField_a_of_type_ComTencentMobileqqUftransferTaskTaskinfoUFTUploadTaskRunNotesInfo.b(System.currentTimeMillis());
      localUFTC2CUploadTaskInfo.b(str);
      localUFTC2CUploadTaskInfo.a(localC2CUploadSrvBusiProp);
      localUFTC2CUploadTaskInfo.a().a().f(bool);
      int i = UFTTaskUtils.a(paramInt);
      b(this.jdField_a_of_type_ComTencentMobileqqUftransferTaskTaskinfoUFTUploadTaskRunNotesInfo.i(), i, paramUFTUploadTaskCompParam);
      this.jdField_a_of_type_ComTencentMobileqqUftransferTaskUploadUFTUploadCbWrapper.a(this.jdField_a_of_type_ComTencentMobileqqUftransferApiImplUFTTransferKey, paramInt, a(paramInt, paramUFTUploadTaskCompParam));
      a(paramInt);
    }
  }
  
  protected void b(Bundle paramBundle)
  {
    h();
    super.b(paramBundle);
  }
  
  protected boolean c()
  {
    this.jdField_a_of_type_ComTencentMobileqqUftransferTaskUploadUFTC2CUploadTask = null;
    return super.c();
  }
  
  protected void f()
  {
    if (this.jdField_b_of_type_ComTencentMobileqqUftransferTaskCommonopUFTCalcHashOp != null)
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("TId[");
      localStringBuilder.append(a());
      localStringBuilder.append("] CalcHashOp had do");
      UFTLog.d("[UFTTransfer] UFTC2CExtfUploadTask", 1, localStringBuilder.toString());
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("TId[");
    localStringBuilder.append(a());
    localStringBuilder.append("] doCalcHashOp...");
    UFTLog.b("[UFTTransfer] UFTC2CExtfUploadTask", 1, localStringBuilder.toString());
    this.jdField_a_of_type_ComTencentMobileqqUftransferTaskUploadUFTUploadCbWrapper.a(this.jdField_a_of_type_ComTencentMobileqqUftransferApiImplUFTTransferKey, 2, null);
    this.jdField_b_of_type_ComTencentMobileqqUftransferTaskCommonopUFTCalcHashOp = new UFTCalcHashOp(this.jdField_a_of_type_MqqAppAppRuntime, this.jdField_a_of_type_ComTencentMobileqqUftransferTaskTaskinfoUFTBaseTaskInfo, this.jdField_a_of_type_ComTencentMobileqqUftransferApiImplUFTTransferKey, a(), 31L, new UFTC2CExtfUploadTask.1(this));
    int i = this.jdField_b_of_type_ComTencentMobileqqUftransferTaskCommonopUFTCalcHashOp.a();
    if (i != 0) {
      c(i);
    }
  }
  
  protected void g()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqUftransferTaskUploadUFTC2CUploadFileOp != null)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("TId[");
      ((StringBuilder)localObject).append(a());
      ((StringBuilder)localObject).append("] UploadFileOp had do");
      UFTLog.d("[UFTTransfer] UFTC2CExtfUploadTask", 1, ((StringBuilder)localObject).toString());
      return;
    }
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("TId[");
    ((StringBuilder)localObject).append(a());
    ((StringBuilder)localObject).append("] doUploadFileOp...");
    UFTLog.b("[UFTTransfer] UFTC2CExtfUploadTask", 1, ((StringBuilder)localObject).toString());
    this.jdField_a_of_type_ComTencentMobileqqUftransferTaskTaskinfoUFTUploadTaskRunNotesInfo.g(System.currentTimeMillis());
    this.jdField_a_of_type_ComTencentMobileqqUftransferTaskUploadUFTUploadCbWrapper.a(this.jdField_a_of_type_ComTencentMobileqqUftransferApiImplUFTTransferKey, 4, null);
    this.jdField_a_of_type_ComTencentMobileqqUftransferTaskUploadUFTC2CUploadFileOp = new UFTC2CExtfUploadFileOp(this.jdField_a_of_type_MqqAppAppRuntime, (UFTC2CUploadTaskInfo)this.jdField_a_of_type_ComTencentMobileqqUftransferTaskTaskinfoUFTBaseTaskInfo, this.jdField_a_of_type_ComTencentMobileqqUftransferApiImplUFTTransferKey, new UFTC2CExtfUploadTask.2(this));
    int i = this.jdField_a_of_type_ComTencentMobileqqUftransferTaskUploadUFTC2CUploadFileOp.a();
    if (i != 0)
    {
      localObject = new UFTBaseUploadFileOp.UploadFileOpRetData();
      ((UFTBaseUploadFileOp.UploadFileOpRetData)localObject).a(i);
      ((UFTBaseUploadFileOp.UploadFileOpRetData)localObject).a(this.jdField_a_of_type_ComTencentMobileqqUftransferTaskUploadUFTC2CUploadFileOp.a());
      a((UFTBaseUploadFileOp.UploadFileOpRetData)localObject);
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqUftransferTaskTaskinfoUFTUploadTaskRunNotesInfo.a(this.jdField_a_of_type_ComTencentMobileqqUftransferTaskUploadUFTC2CUploadFileOp.b());
  }
  
  protected void h()
  {
    Object localObject = (UFTC2CUploadTaskInfo)this.jdField_a_of_type_ComTencentMobileqqUftransferTaskTaskinfoUFTBaseTaskInfo;
    UFTC2CExtfReportData.ResultReport localResultReport = new UFTC2CExtfReportData.ResultReport(this.jdField_a_of_type_MqqAppAppRuntime);
    localResultReport.a(33);
    localResultReport.a(((UFTC2CUploadTaskInfo)localObject).a());
    String str = UFTDependFeatureApi.c(((UFTC2CUploadTaskInfo)localObject).a());
    localResultReport.a(Long.valueOf(((UFTC2CUploadTaskInfo)localObject).d()).longValue(), 0L, ((UFTC2CUploadTaskInfo)localObject).a(), str, ((UFTC2CUploadTaskInfo)localObject).b());
    localResultReport.a(this.jdField_a_of_type_ComTencentMobileqqUftransferTaskTaskinfoUFTUploadTaskRunNotesInfo.a());
    long l = this.jdField_a_of_type_ComTencentMobileqqUftransferTaskTaskinfoUFTUploadTaskRunNotesInfo.b() - this.jdField_a_of_type_ComTencentMobileqqUftransferTaskTaskinfoUFTUploadTaskRunNotesInfo.a();
    if (l > 0L) {
      localResultReport.c(l);
    } else {
      localResultReport.c(0L);
    }
    l = this.jdField_a_of_type_ComTencentMobileqqUftransferTaskTaskinfoUFTUploadTaskRunNotesInfo.d() - this.jdField_a_of_type_ComTencentMobileqqUftransferTaskTaskinfoUFTUploadTaskRunNotesInfo.c();
    if (l > 0L) {
      localResultReport.b(l);
    } else {
      localResultReport.b(0L);
    }
    localObject = new ExcitingTransferUploadResultRp();
    ((ExcitingTransferUploadResultRp)localObject).mbIsXTFValid = true;
    ((ExcitingTransferUploadResultRp)localObject).mnResult = 33;
    localResultReport.a((ExcitingTransferUploadResultRp)localObject);
    localResultReport.b(b());
    localResultReport.b(false);
    localResultReport.c(false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.uftransfer.task.upload.UFTC2CExtfUploadTask
 * JD-Core Version:    0.7.0.1
 */