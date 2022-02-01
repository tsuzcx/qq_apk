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
import com.tencent.mobileqq.uftransfer.task.taskinfo.UFTBaseTaskInfo;
import com.tencent.mobileqq.uftransfer.task.taskinfo.UFTTroopUploadTaskInfo;
import com.tencent.mobileqq.uftransfer.task.taskinfo.UFTUploadSrvBusiProp.TroopUploadSrvBusiProp;
import com.tencent.mobileqq.uftransfer.task.taskinfo.UFTUploadTaskRunNotesInfo;
import com.tencent.mobileqq.uftransfer.task.utils.UFTTaskUtils;
import mqq.app.AppRuntime;

public class UFTTroopExtfUploadTask
  extends UFTTroopUploadTask
{
  protected IUFTUploadCallback a;
  protected UFTTroopUploadTask a;
  
  protected UFTTroopExtfUploadTask(AppRuntime paramAppRuntime, UFTTransferKey paramUFTTransferKey, UFTTroopUploadTaskInfo paramUFTTroopUploadTaskInfo, IUFTTaskCallback paramIUFTTaskCallback, IUFTUploadCallback paramIUFTUploadCallback)
  {
    super(paramAppRuntime, paramUFTTransferKey, paramUFTTroopUploadTaskInfo, paramIUFTTaskCallback, paramIUFTUploadCallback);
    this.jdField_a_of_type_ComTencentMobileqqUftransferTaskUploadUFTTroopUploadTask = null;
    this.jdField_a_of_type_ComTencentMobileqqUftransferApiIUFTUploadCallback = paramIUFTUploadCallback;
  }
  
  public static UFTTroopExtfUploadTask a(AppRuntime paramAppRuntime, UFTTransferKey paramUFTTransferKey, UFTTroopUploadTaskInfo paramUFTTroopUploadTaskInfo, IUFTTaskCallback paramIUFTTaskCallback, IUFTUploadCallback paramIUFTUploadCallback)
  {
    if (a(paramAppRuntime, paramUFTTransferKey, paramUFTTroopUploadTaskInfo, paramIUFTTaskCallback, "[UFTTransfer] UFTTroopExtfUploadTask")) {
      return new UFTTroopExtfUploadTask(paramAppRuntime, paramUFTTransferKey, paramUFTTroopUploadTaskInfo, paramIUFTTaskCallback, paramIUFTUploadCallback);
    }
    return null;
  }
  
  protected int a()
  {
    return 1;
  }
  
  protected UFTTroopExtfReportData.ResultReport a()
  {
    UFTTroopUploadTaskInfo localUFTTroopUploadTaskInfo = (UFTTroopUploadTaskInfo)this.jdField_a_of_type_ComTencentMobileqqUftransferTaskTaskinfoUFTBaseTaskInfo;
    UFTTroopExtfReportData.ResultReport localResultReport = new UFTTroopExtfReportData.ResultReport(this.jdField_a_of_type_MqqAppAppRuntime);
    localResultReport.a(this.jdField_a_of_type_ComTencentMobileqqUftransferTaskTaskinfoUFTBaseTaskInfo.a());
    String str = UFTDependFeatureApi.c(localUFTTroopUploadTaskInfo.d());
    long l = Long.valueOf(localUFTTroopUploadTaskInfo.c()).longValue();
    localResultReport.a(l, l, localUFTTroopUploadTaskInfo.a(), str, localUFTTroopUploadTaskInfo.b());
    localResultReport.b(b());
    localResultReport.c(d());
    localResultReport.b(this.jdField_a_of_type_ComTencentMobileqqUftransferTaskTaskinfoUFTUploadTaskRunNotesInfo.a());
    l = System.currentTimeMillis() - this.jdField_a_of_type_ComTencentMobileqqUftransferTaskTaskinfoUFTUploadTaskRunNotesInfo.a();
    if (l > 0L) {
      localResultReport.c(l);
    } else {
      localResultReport.c(0L);
    }
    l = this.jdField_a_of_type_ComTencentMobileqqUftransferTaskTaskinfoUFTUploadTaskRunNotesInfo.d() - this.jdField_a_of_type_ComTencentMobileqqUftransferTaskTaskinfoUFTUploadTaskRunNotesInfo.c();
    if (l > 0L)
    {
      localResultReport.b(l);
      return localResultReport;
    }
    localResultReport.b(0L);
    return localResultReport;
  }
  
  protected void a()
  {
    this.b = false;
    d();
  }
  
  protected void a(int paramInt, Bundle paramBundle)
  {
    c();
    super.a(paramInt, paramBundle);
  }
  
  protected void a(int paramInt, ExcitingTransferUploadResultRp paramExcitingTransferUploadResultRp)
  {
    UFTTroopExtfReportData.ResultReport localResultReport = a();
    localResultReport.a(paramInt);
    boolean bool = true;
    int i = 0;
    if (paramExcitingTransferUploadResultRp != null)
    {
      if (paramExcitingTransferUploadResultRp.mnResult != 0L) {
        bool = false;
      }
      localResultReport.a(paramExcitingTransferUploadResultRp);
      paramInt = UFTDependFeatureApi.b(paramExcitingTransferUploadResultRp.mstrServerIp);
    }
    else
    {
      if (paramInt == 0) {
        bool = true;
      } else {
        bool = false;
      }
      paramExcitingTransferUploadResultRp = new ExcitingTransferUploadResultRp();
      paramExcitingTransferUploadResultRp.mnResult = paramInt;
      if (this.jdField_a_of_type_ComTencentMobileqqUftransferTaskTaskinfoUFTUploadTaskRunNotesInfo.g() > 0L) {
        paramExcitingTransferUploadResultRp.mu64HttpTime = (System.currentTimeMillis() - this.jdField_a_of_type_ComTencentMobileqqUftransferTaskTaskinfoUFTUploadTaskRunNotesInfo.g());
      }
      if (this.jdField_a_of_type_ComTencentMobileqqUftransferTaskTaskinfoUFTUploadTaskRunNotesInfo.j() > 0L) {
        paramExcitingTransferUploadResultRp.mu64StartSize = this.jdField_a_of_type_ComTencentMobileqqUftransferTaskTaskinfoUFTUploadTaskRunNotesInfo.j();
      }
      if (this.jdField_a_of_type_ComTencentMobileqqUftransferTaskTaskinfoUFTUploadTaskRunNotesInfo.i() > 0L) {
        paramExcitingTransferUploadResultRp.mu64TransferSize = this.jdField_a_of_type_ComTencentMobileqqUftransferTaskTaskinfoUFTUploadTaskRunNotesInfo.i();
      }
      if ((paramExcitingTransferUploadResultRp.mu64HttpTime > 0L) && (paramExcitingTransferUploadResultRp.mu64TransferSize > 0L))
      {
        float f = (float)paramExcitingTransferUploadResultRp.mu64HttpTime / 1000.0F;
        paramExcitingTransferUploadResultRp.mu64TransferSpeed = (((float)paramExcitingTransferUploadResultRp.mu64TransferSize / f));
      }
      else
      {
        paramExcitingTransferUploadResultRp.mu64TransferSpeed = 0L;
      }
      paramExcitingTransferUploadResultRp.mbIsXTFValid = true;
      localResultReport.a(paramExcitingTransferUploadResultRp);
      paramInt = i;
    }
    localResultReport.c(paramInt);
    localResultReport.a(bool);
  }
  
  protected void a(int paramInt, ExcitingTransferUploaderRp paramExcitingTransferUploaderRp)
  {
    if (paramExcitingTransferUploaderRp == null) {
      return;
    }
    UFTTroopUploadTaskInfo localUFTTroopUploadTaskInfo = (UFTTroopUploadTaskInfo)this.jdField_a_of_type_ComTencentMobileqqUftransferTaskTaskinfoUFTBaseTaskInfo;
    UFTTroopExtfReportData.UpladerReport localUpladerReport = new UFTTroopExtfReportData.UpladerReport(this.jdField_a_of_type_MqqAppAppRuntime);
    localUpladerReport.a(this.jdField_a_of_type_ComTencentMobileqqUftransferTaskTaskinfoUFTBaseTaskInfo.a());
    String str = UFTDependFeatureApi.c(localUFTTroopUploadTaskInfo.d());
    localUpladerReport.a(paramInt);
    long l = Long.valueOf(localUFTTroopUploadTaskInfo.c()).longValue();
    localUpladerReport.a(l, l, localUFTTroopUploadTaskInfo.a(), str, localUFTTroopUploadTaskInfo.b());
    localUpladerReport.a(paramExcitingTransferUploaderRp);
    localUpladerReport.b(b());
    localUpladerReport.c(UFTDependFeatureApi.b(paramExcitingTransferUploaderRp.mstrServerIp));
    localUpladerReport.b(d());
    boolean bool;
    if (paramInt == 0) {
      bool = true;
    } else {
      bool = false;
    }
    localUpladerReport.a(bool);
  }
  
  protected void a(int paramInt, UFTTroopUploadTask.UFTToopUploadTaskCompParam paramUFTToopUploadTaskCompParam)
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
    ((StringBuilder)localObject).append(paramUFTToopUploadTaskCompParam.jdField_a_of_type_JavaLangString);
    UFTLog.b("[UFTTransfer] UFTTroopExtfUploadTask", 1, ((StringBuilder)localObject).toString());
    f();
    localObject = this.jdField_a_of_type_ComTencentMobileqqUftransferTaskTaskinfoUFTUploadTaskRunNotesInfo.a();
    if (paramInt != 0)
    {
      if ((this.jdField_a_of_type_ComTencentMobileqqUftransferTaskTaskinfoUFTBaseTaskInfo.a().a().b()) && (paramUFTToopUploadTaskCompParam.jdField_a_of_type_Boolean))
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("TId[");
        ((StringBuilder)localObject).append(a());
        ((StringBuilder)localObject).append("] ready to do safeGuard upload...");
        UFTLog.c("[UFTTransfer] UFTTroopExtfUploadTask", 1, ((StringBuilder)localObject).toString());
        b(paramInt, paramUFTToopUploadTaskCompParam);
        return;
      }
      this.jdField_a_of_type_ComTencentMobileqqUftransferTaskTaskinfoUFTUploadTaskRunNotesInfo.b(System.currentTimeMillis());
      if (!paramUFTToopUploadTaskCompParam.jdField_a_of_type_Boolean) {
        b(this.jdField_a_of_type_ComTencentMobileqqUftransferTaskTaskinfoUFTUploadTaskRunNotesInfo.i(), paramUFTToopUploadTaskCompParam);
      }
      a(paramUFTToopUploadTaskCompParam);
      int j = paramUFTToopUploadTaskCompParam.g;
      int i;
      if (paramUFTToopUploadTaskCompParam.jdField_a_of_type_Boolean)
      {
        i = j;
        if (j != 0) {}
      }
      else
      {
        i = UFTTaskUtils.f(paramUFTToopUploadTaskCompParam.jdField_b_of_type_Int);
      }
      if ((paramUFTToopUploadTaskCompParam.jdField_a_of_type_Int != 8) && (paramUFTToopUploadTaskCompParam.jdField_a_of_type_Int != 11) && (paramUFTToopUploadTaskCompParam.jdField_a_of_type_Int != 12)) {
        a(i, (ExcitingTransferUploadResultRp)localObject);
      } else {
        c();
      }
    }
    else
    {
      this.jdField_a_of_type_ComTencentMobileqqUftransferTaskTaskinfoUFTUploadTaskRunNotesInfo.b(System.currentTimeMillis());
      g();
      a(0, (ExcitingTransferUploadResultRp)localObject);
    }
    this.jdField_a_of_type_ComTencentMobileqqUftransferTaskUploadUFTUploadCbWrapper.a(this.jdField_a_of_type_ComTencentMobileqqUftransferApiImplUFTTransferKey, paramInt, a(paramUFTToopUploadTaskCompParam));
    a(paramInt);
  }
  
  protected void a(long paramLong, UFTTroopUploadTask.UFTToopUploadTaskCompParam paramUFTToopUploadTaskCompParam)
  {
    ExcitingTransferUploaderRp localExcitingTransferUploaderRp = paramUFTToopUploadTaskCompParam.a();
    if (paramUFTToopUploadTaskCompParam.jdField_a_of_type_Int != 0)
    {
      if (localExcitingTransferUploaderRp != null)
      {
        paramUFTToopUploadTaskCompParam.jdField_a_of_type_Long = localExcitingTransferUploaderRp.mu64HttpTime;
        paramUFTToopUploadTaskCompParam.jdField_b_of_type_Long = localExcitingTransferUploaderRp.mu64TransferSpeed;
      }
      super.b(paramLong, paramUFTToopUploadTaskCompParam);
    }
    int i = paramUFTToopUploadTaskCompParam.g;
    if (localExcitingTransferUploaderRp != null) {
      a(i, localExcitingTransferUploaderRp);
    }
  }
  
  public void a(Bundle paramBundle)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqUftransferTaskUploadUFTTroopUploadTask != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqUftransferTaskTaskinfoUFTUploadTaskRunNotesInfo.b(System.currentTimeMillis());
      this.jdField_a_of_type_Boolean = true;
      b(3);
      this.jdField_a_of_type_ComTencentMobileqqUftransferTaskUploadUFTTroopUploadTask.a(paramBundle);
      this.jdField_a_of_type_ComTencentMobileqqUftransferTaskUploadUFTTroopUploadTask = null;
      return;
    }
    super.a(paramBundle);
  }
  
  protected void a(UFTBaseUploadFileOp.UploadFileOpRetData paramUploadFileOpRetData)
  {
    int i = paramUploadFileOpRetData.a();
    UFTTroopUploadTask.UFTToopUploadTaskCompParam localUFTToopUploadTaskCompParam = a(4, paramUploadFileOpRetData.a());
    localUFTToopUploadTaskCompParam.jdField_a_of_type_Boolean = paramUploadFileOpRetData.c();
    if ((i != 3) && (i != 4))
    {
      int j = UFTTaskUtils.b(i);
      int k = UFTTaskUtils.c(i);
      int m = UFTTaskUtils.d(i);
      localUFTToopUploadTaskCompParam.a(j, k, 3, UFTTaskUtils.e(i));
      Object localObject2 = null;
      Object localObject1 = localObject2;
      if (paramUploadFileOpRetData.a() != null)
      {
        localObject1 = localObject2;
        if ((paramUploadFileOpRetData.a() instanceof ExcitingTransferUploadResultRp)) {
          localObject1 = (ExcitingTransferUploadResultRp)paramUploadFileOpRetData.a();
        }
      }
      long l;
      if (localObject1 != null) {
        l = ((ExcitingTransferUploadResultRp)localObject1).mnSrvReturCode;
      } else {
        l = 0L;
      }
      localUFTToopUploadTaskCompParam.b((int)l);
      localUFTToopUploadTaskCompParam.g = i;
      a(m, localUFTToopUploadTaskCompParam);
      return;
    }
    localUFTToopUploadTaskCompParam.a(9, 904, 1, 112);
    localUFTToopUploadTaskCompParam.g = 7;
    a(1, localUFTToopUploadTaskCompParam);
  }
  
  protected void b()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqUftransferTaskUploadUFTTroopUploadFileOp != null)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("TId[");
      ((StringBuilder)localObject).append(a());
      ((StringBuilder)localObject).append("] UploadFileOp had do");
      UFTLog.d("[UFTTransfer] UFTTroopExtfUploadTask", 1, ((StringBuilder)localObject).toString());
      return;
    }
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("TId[");
    ((StringBuilder)localObject).append(a());
    ((StringBuilder)localObject).append("] doUploadFileOp...");
    UFTLog.b("[UFTTransfer] UFTTroopExtfUploadTask", 1, ((StringBuilder)localObject).toString());
    this.jdField_a_of_type_ComTencentMobileqqUftransferTaskTaskinfoUFTUploadTaskRunNotesInfo.g(System.currentTimeMillis());
    this.jdField_a_of_type_ComTencentMobileqqUftransferTaskUploadUFTUploadCbWrapper.a(this.jdField_a_of_type_ComTencentMobileqqUftransferApiImplUFTTransferKey, 4, null);
    this.jdField_a_of_type_ComTencentMobileqqUftransferTaskUploadUFTTroopUploadFileOp = new UFTTroopExtfUploadFileOp(this.jdField_a_of_type_MqqAppAppRuntime, (UFTTroopUploadTaskInfo)this.jdField_a_of_type_ComTencentMobileqqUftransferTaskTaskinfoUFTBaseTaskInfo, this.jdField_a_of_type_ComTencentMobileqqUftransferApiImplUFTTransferKey, new UFTTroopExtfUploadTask.1(this));
    int i = this.jdField_a_of_type_ComTencentMobileqqUftransferTaskUploadUFTTroopUploadFileOp.a();
    if (i != 0)
    {
      localObject = new UFTBaseUploadFileOp.UploadFileOpRetData();
      ((UFTBaseUploadFileOp.UploadFileOpRetData)localObject).a(i);
      ((UFTBaseUploadFileOp.UploadFileOpRetData)localObject).a("start upload file op fail");
      b((UFTBaseUploadFileOp.UploadFileOpRetData)localObject);
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqUftransferTaskTaskinfoUFTUploadTaskRunNotesInfo.a(this.jdField_a_of_type_ComTencentMobileqqUftransferTaskUploadUFTTroopUploadFileOp.b());
  }
  
  protected void b(int paramInt, UFTTroopUploadTask.UFTToopUploadTaskCompParam paramUFTToopUploadTaskCompParam)
  {
    Object localObject1 = this.jdField_a_of_type_ComTencentMobileqqUftransferTaskTaskinfoUFTUploadTaskRunNotesInfo.a();
    a(paramUFTToopUploadTaskCompParam.g, (ExcitingTransferUploadResultRp)localObject1);
    localObject1 = (UFTTroopUploadTaskInfo)this.jdField_a_of_type_ComTencentMobileqqUftransferTaskTaskinfoUFTBaseTaskInfo;
    String str = ((UFTTroopUploadTaskInfo)localObject1).b();
    UFTUploadSrvBusiProp.TroopUploadSrvBusiProp localTroopUploadSrvBusiProp = ((UFTTroopUploadTaskInfo)localObject1).a();
    ((UFTTroopUploadTaskInfo)localObject1).b("");
    ((UFTTroopUploadTaskInfo)localObject1).a().a().a(false);
    ((UFTTroopUploadTaskInfo)localObject1).a().a().b(false);
    ((UFTTroopUploadTaskInfo)localObject1).a(null);
    Object localObject2 = new UFTTroopExtfUploadTask.2(this);
    UFTTroopExtfUploadTask.3 local3 = new UFTTroopExtfUploadTask.3(this);
    this.jdField_a_of_type_ComTencentMobileqqUftransferTaskUploadUFTTroopUploadTask = UFTTroopUploadTask.a(this.jdField_a_of_type_MqqAppAppRuntime, this.jdField_a_of_type_ComTencentMobileqqUftransferApiImplUFTTransferKey, (UFTTroopUploadTaskInfo)localObject1, (IUFTTaskCallback)localObject2, local3);
    localObject2 = this.jdField_a_of_type_ComTencentMobileqqUftransferTaskUploadUFTTroopUploadTask;
    if ((localObject2 == null) || (!((UFTTroopUploadTask)localObject2).b()))
    {
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("TId[");
      ((StringBuilder)localObject2).append(a());
      ((StringBuilder)localObject2).append("] do safeGuard upload fail");
      UFTLog.d("[UFTTransfer] UFTTroopExtfUploadTask", 1, ((StringBuilder)localObject2).toString());
      this.jdField_a_of_type_ComTencentMobileqqUftransferTaskTaskinfoUFTUploadTaskRunNotesInfo.b(System.currentTimeMillis());
      ((UFTTroopUploadTaskInfo)localObject1).b(str);
      ((UFTTroopUploadTaskInfo)localObject1).a(localTroopUploadSrvBusiProp);
      a(paramUFTToopUploadTaskCompParam);
      this.jdField_a_of_type_ComTencentMobileqqUftransferTaskUploadUFTUploadCbWrapper.a(this.jdField_a_of_type_ComTencentMobileqqUftransferApiImplUFTTransferKey, paramInt, a(paramUFTToopUploadTaskCompParam));
      a(paramInt);
    }
  }
  
  protected void b(Bundle paramBundle)
  {
    c();
    super.b(paramBundle);
  }
  
  protected void c()
  {
    UFTTroopExtfReportData.ResultReport localResultReport = a();
    localResultReport.a(33);
    ExcitingTransferUploadResultRp localExcitingTransferUploadResultRp = new ExcitingTransferUploadResultRp();
    if (this.jdField_a_of_type_ComTencentMobileqqUftransferTaskTaskinfoUFTUploadTaskRunNotesInfo.g() > 0L) {
      localExcitingTransferUploadResultRp.mu64HttpTime = (System.currentTimeMillis() - this.jdField_a_of_type_ComTencentMobileqqUftransferTaskTaskinfoUFTUploadTaskRunNotesInfo.g());
    }
    if (this.jdField_a_of_type_ComTencentMobileqqUftransferTaskTaskinfoUFTUploadTaskRunNotesInfo.j() > 0L) {
      localExcitingTransferUploadResultRp.mu64StartSize = this.jdField_a_of_type_ComTencentMobileqqUftransferTaskTaskinfoUFTUploadTaskRunNotesInfo.j();
    }
    if (this.jdField_a_of_type_ComTencentMobileqqUftransferTaskTaskinfoUFTUploadTaskRunNotesInfo.i() > 0L) {
      localExcitingTransferUploadResultRp.mu64TransferSize = this.jdField_a_of_type_ComTencentMobileqqUftransferTaskTaskinfoUFTUploadTaskRunNotesInfo.i();
    }
    if ((localExcitingTransferUploadResultRp.mu64HttpTime > 0L) && (localExcitingTransferUploadResultRp.mu64TransferSize > 0L))
    {
      float f = (float)localExcitingTransferUploadResultRp.mu64HttpTime / 1000.0F;
      localExcitingTransferUploadResultRp.mu64TransferSpeed = (((float)localExcitingTransferUploadResultRp.mu64TransferSize / f));
    }
    else
    {
      localExcitingTransferUploadResultRp.mu64TransferSpeed = 0L;
    }
    localExcitingTransferUploadResultRp.mbIsXTFValid = true;
    localExcitingTransferUploadResultRp.mnResult = 33;
    localResultReport.a(localExcitingTransferUploadResultRp);
    localResultReport.a(false);
  }
  
  protected boolean c()
  {
    this.jdField_a_of_type_ComTencentMobileqqUftransferTaskUploadUFTTroopUploadTask = null;
    return super.c();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.uftransfer.task.upload.UFTTroopExtfUploadTask
 * JD-Core Version:    0.7.0.1
 */