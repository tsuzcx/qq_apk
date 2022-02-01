package com.tencent.mobileqq.uftransfer.task.upload;

import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.mobileqq.uftransfer.UFTLogicThread;
import com.tencent.mobileqq.uftransfer.api.IUFTUploadCallback;
import com.tencent.mobileqq.uftransfer.api.UFTFileUploadBusinessInfo;
import com.tencent.mobileqq.uftransfer.api.impl.UFTTransferKey;
import com.tencent.mobileqq.uftransfer.depend.UFTLog;
import com.tencent.mobileqq.uftransfer.proto.UFTProtoRequestor;
import com.tencent.mobileqq.uftransfer.task.IUFTTaskCallback;
import com.tencent.mobileqq.uftransfer.task.commonop.UFTCalcHashOp;
import com.tencent.mobileqq.uftransfer.task.taskinfo.UFTBaseTaskInfo;
import com.tencent.mobileqq.uftransfer.task.taskinfo.UFTDiscUploadTaskInfo;
import com.tencent.mobileqq.uftransfer.task.taskinfo.UFTUploadTaskRunNotesInfo;
import mqq.app.AppRuntime;

public class UFTDiscUploadTask
  extends UFTBaseUploadTask
{
  protected UFTCalcHashOp a;
  protected UFTDiscFetchUploadUrlOp a;
  protected UFTDiscUploadFileOp a;
  
  protected UFTDiscUploadTask(AppRuntime paramAppRuntime, UFTTransferKey paramUFTTransferKey, UFTDiscUploadTaskInfo paramUFTDiscUploadTaskInfo, IUFTTaskCallback paramIUFTTaskCallback, IUFTUploadCallback paramIUFTUploadCallback)
  {
    super(paramAppRuntime, paramUFTTransferKey, paramUFTDiscUploadTaskInfo, paramIUFTTaskCallback, paramIUFTUploadCallback);
  }
  
  public static UFTDiscUploadTask a(AppRuntime paramAppRuntime, UFTTransferKey paramUFTTransferKey, UFTDiscUploadTaskInfo paramUFTDiscUploadTaskInfo, IUFTTaskCallback paramIUFTTaskCallback, IUFTUploadCallback paramIUFTUploadCallback)
  {
    if (a(paramAppRuntime, paramUFTTransferKey, paramUFTDiscUploadTaskInfo, paramIUFTTaskCallback, "[UFTTransfer] UFTDiscUploadTask")) {
      return new UFTDiscUploadTask(paramAppRuntime, paramUFTTransferKey, paramUFTDiscUploadTaskInfo, paramIUFTTaskCallback, paramIUFTUploadCallback);
    }
    return null;
  }
  
  protected UFTDiscReportData a()
  {
    Object localObject = (UFTDiscUploadTaskInfo)this.jdField_a_of_type_ComTencentMobileqqUftransferTaskTaskinfoUFTBaseTaskInfo;
    UFTDiscReportData localUFTDiscReportData = new UFTDiscReportData(this.jdField_a_of_type_MqqAppAppRuntime, this.jdField_a_of_type_MqqAppAppRuntime.getCurrentUin());
    localUFTDiscReportData.jdField_b_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqUftransferTaskTaskinfoUFTUploadTaskRunNotesInfo.a();
    localUFTDiscReportData.c = ((UFTDiscUploadTaskInfo)localObject).d();
    localUFTDiscReportData.jdField_a_of_type_Int = 3000;
    localUFTDiscReportData.jdField_d_of_type_JavaLangString = ((UFTDiscUploadTaskInfo)localObject).b();
    localUFTDiscReportData.j = ((UFTDiscUploadTaskInfo)localObject).b();
    localObject = this.jdField_a_of_type_ComTencentMobileqqUftransferTaskUploadUFTDiscUploadFileOp;
    int i;
    if (localObject != null) {
      i = ((UFTDiscUploadFileOp)localObject).c();
    } else {
      i = 0;
    }
    localUFTDiscReportData.jdField_b_of_type_Int = i;
    localUFTDiscReportData.jdField_b_of_type_Long = this.jdField_a_of_type_ComTencentMobileqqUftransferApiImplUFTTransferKey.a();
    localUFTDiscReportData.jdField_d_of_type_Long = this.jdField_a_of_type_ComTencentMobileqqUftransferTaskTaskinfoUFTUploadTaskRunNotesInfo.e();
    localUFTDiscReportData.jdField_d_of_type_Long = this.jdField_a_of_type_ComTencentMobileqqUftransferTaskTaskinfoUFTUploadTaskRunNotesInfo.f();
    localUFTDiscReportData.jdField_e_of_type_Long = this.jdField_a_of_type_ComTencentMobileqqUftransferTaskTaskinfoUFTUploadTaskRunNotesInfo.g();
    localUFTDiscReportData.f = this.jdField_a_of_type_ComTencentMobileqqUftransferTaskTaskinfoUFTUploadTaskRunNotesInfo.h();
    return localUFTDiscReportData;
  }
  
  protected UFTUploadCompleteInfo a(int paramInt, String paramString)
  {
    paramString = new UFTUploadCompleteInfo();
    UFTDiscUploadTaskInfo localUFTDiscUploadTaskInfo = (UFTDiscUploadTaskInfo)this.jdField_a_of_type_ComTencentMobileqqUftransferTaskTaskinfoUFTBaseTaskInfo;
    paramString.a(this.jdField_a_of_type_ComTencentMobileqqUftransferTaskTaskinfoUFTUploadTaskRunNotesInfo.a());
    paramString.a(localUFTDiscUploadTaskInfo.b());
    paramString.c(this.jdField_a_of_type_ComTencentMobileqqUftransferTaskTaskinfoUFTUploadTaskRunNotesInfo.a());
    if ((!TextUtils.isEmpty(localUFTDiscUploadTaskInfo.e())) && (!UFTProtoRequestor.a(paramInt))) {
      paramString.b(localUFTDiscUploadTaskInfo.e());
    }
    return paramString;
  }
  
  public String a()
  {
    return ((UFTDiscUploadTaskInfo)this.jdField_a_of_type_ComTencentMobileqqUftransferTaskTaskinfoUFTBaseTaskInfo).c();
  }
  
  protected void a()
  {
    b();
  }
  
  protected void a(int paramInt, Bundle paramBundle)
  {
    int i;
    if ((paramInt != 1) && (paramInt != 2)) {
      i = 0;
    } else {
      i = 1;
    }
    f();
    super.a(paramBundle);
    if (i != 0)
    {
      paramBundle = a(9004, "net changed");
      paramBundle.b(paramInt);
      this.jdField_a_of_type_ComTencentMobileqqUftransferTaskUploadUFTUploadCbWrapper.a(this.jdField_a_of_type_ComTencentMobileqqUftransferApiImplUFTTransferKey, 9004, paramBundle);
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqUftransferTaskUploadUFTUploadCbWrapper.a(true);
  }
  
  protected void a(int paramInt, String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("TId[");
    localStringBuilder.append(a());
    localStringBuilder.append("] on fetch url op done errCode:");
    localStringBuilder.append(paramInt);
    localStringBuilder.append(" errMsg:");
    localStringBuilder.append(paramString);
    UFTLog.b("[UFTTransfer] UFTDiscUploadTask", 1, localStringBuilder.toString());
    if (paramInt != 0)
    {
      a(paramInt, paramString, null);
      return;
    }
    paramString = new UFTFileUploadBusinessInfo();
    paramString.a(this.jdField_a_of_type_ComTencentMobileqqUftransferTaskTaskinfoUFTBaseTaskInfo.b());
    this.jdField_a_of_type_ComTencentMobileqqUftransferTaskUploadUFTUploadCbWrapper.a(this.jdField_a_of_type_ComTencentMobileqqUftransferApiImplUFTTransferKey, paramString);
    d();
  }
  
  protected void a(int paramInt, String paramString1, String paramString2)
  {
    if (this.jdField_a_of_type_Boolean) {
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("TId[");
    localStringBuilder.append(a());
    localStringBuilder.append("] do upload completed errCode:");
    localStringBuilder.append(paramInt);
    localStringBuilder.append(" errMsg:");
    localStringBuilder.append(paramString1);
    UFTLog.b("[UFTTransfer] UFTDiscUploadTask", 1, localStringBuilder.toString());
    f();
    this.jdField_a_of_type_ComTencentMobileqqUftransferTaskTaskinfoUFTUploadTaskRunNotesInfo.b(System.currentTimeMillis());
    if (paramInt != 0)
    {
      b(this.jdField_a_of_type_ComTencentMobileqqUftransferTaskTaskinfoUFTUploadTaskRunNotesInfo.i(), paramInt, paramString1, paramString2);
      a(this.jdField_a_of_type_ComTencentMobileqqUftransferTaskTaskinfoUFTUploadTaskRunNotesInfo.i(), paramInt, paramString1, paramString2);
    }
    else
    {
      a(paramString2);
    }
    this.jdField_a_of_type_ComTencentMobileqqUftransferTaskUploadUFTUploadCbWrapper.a(this.jdField_a_of_type_ComTencentMobileqqUftransferApiImplUFTTransferKey, paramInt, a(paramInt, paramString1));
    a(paramInt);
  }
  
  protected void a(int paramInt, boolean paramBoolean, String paramString1, String paramString2)
  {
    this.jdField_a_of_type_ComTencentMobileqqUftransferTaskTaskinfoUFTUploadTaskRunNotesInfo.h(System.currentTimeMillis());
    this.jdField_a_of_type_ComTencentMobileqqUftransferTaskTaskinfoUFTUploadTaskRunNotesInfo.a(paramBoolean);
    this.jdField_a_of_type_ComTencentMobileqqUftransferTaskTaskinfoUFTUploadTaskRunNotesInfo.b(paramString2);
    if (this.jdField_a_of_type_ComTencentMobileqqUftransferTaskUploadUFTDiscUploadFileOp != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqUftransferTaskTaskinfoUFTUploadTaskRunNotesInfo.a(this.jdField_a_of_type_ComTencentMobileqqUftransferTaskUploadUFTDiscUploadFileOp.b());
      this.jdField_a_of_type_ComTencentMobileqqUftransferTaskTaskinfoUFTUploadTaskRunNotesInfo.j(this.jdField_a_of_type_ComTencentMobileqqUftransferTaskUploadUFTDiscUploadFileOp.b());
      this.jdField_a_of_type_ComTencentMobileqqUftransferTaskTaskinfoUFTUploadTaskRunNotesInfo.a(this.jdField_a_of_type_ComTencentMobileqqUftransferTaskUploadUFTDiscUploadFileOp.c());
      this.jdField_a_of_type_ComTencentMobileqqUftransferTaskTaskinfoUFTUploadTaskRunNotesInfo.k(this.jdField_a_of_type_ComTencentMobileqqUftransferTaskUploadUFTDiscUploadFileOp.d());
      this.jdField_a_of_type_ComTencentMobileqqUftransferTaskTaskinfoUFTUploadTaskRunNotesInfo.l(this.jdField_a_of_type_ComTencentMobileqqUftransferTaskUploadUFTDiscUploadFileOp.e());
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("TId[");
    localStringBuilder.append(a());
    localStringBuilder.append("] on upload file op done. errCode:");
    localStringBuilder.append(paramInt);
    localStringBuilder.append(" flash:");
    localStringBuilder.append(this.jdField_a_of_type_ComTencentMobileqqUftransferTaskTaskinfoUFTUploadTaskRunNotesInfo.a());
    localStringBuilder.append(" speed:");
    localStringBuilder.append(this.jdField_a_of_type_ComTencentMobileqqUftransferTaskTaskinfoUFTUploadTaskRunNotesInfo.l());
    localStringBuilder.append(" httpTime:");
    localStringBuilder.append(this.jdField_a_of_type_ComTencentMobileqqUftransferTaskTaskinfoUFTUploadTaskRunNotesInfo.k());
    localStringBuilder.append(" url:");
    localStringBuilder.append(this.jdField_a_of_type_ComTencentMobileqqUftransferTaskTaskinfoUFTUploadTaskRunNotesInfo.a());
    localStringBuilder.append(" upStartSize:");
    localStringBuilder.append(this.jdField_a_of_type_ComTencentMobileqqUftransferTaskTaskinfoUFTUploadTaskRunNotesInfo.j());
    localStringBuilder.append(" upEndSize:");
    localStringBuilder.append(this.jdField_a_of_type_ComTencentMobileqqUftransferTaskTaskinfoUFTUploadTaskRunNotesInfo.i());
    UFTLog.b("[UFTTransfer] UFTDiscUploadTask", 1, localStringBuilder.toString());
    if (paramInt != 0)
    {
      a(paramInt, paramString1, paramString2);
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqUftransferTaskTaskinfoUFTUploadTaskRunNotesInfo.i(this.jdField_a_of_type_ComTencentMobileqqUftransferTaskTaskinfoUFTBaseTaskInfo.b());
    if (((UFTDiscUploadTaskInfo)this.jdField_a_of_type_ComTencentMobileqqUftransferTaskTaskinfoUFTBaseTaskInfo).a())
    {
      e();
      return;
    }
    a(0, "", null);
  }
  
  protected void a(long paramLong, int paramInt, String paramString1, String paramString2)
  {
    UFTDiscReportData localUFTDiscReportData = a();
    localUFTDiscReportData.jdField_a_of_type_Long = paramInt;
    localUFTDiscReportData.jdField_a_of_type_JavaLangString = paramString1;
    localUFTDiscReportData.h = paramLong;
    localUFTDiscReportData.jdField_e_of_type_JavaLangString = paramString2;
    localUFTDiscReportData.b();
  }
  
  public void a(Bundle paramBundle)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqUftransferTaskTaskinfoUFTUploadTaskRunNotesInfo.g() > 0L) {
      this.jdField_a_of_type_ComTencentMobileqqUftransferTaskTaskinfoUFTUploadTaskRunNotesInfo.h(System.currentTimeMillis());
    }
    if (this.jdField_a_of_type_ComTencentMobileqqUftransferTaskUploadUFTDiscUploadFileOp != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqUftransferTaskTaskinfoUFTUploadTaskRunNotesInfo.i(this.jdField_a_of_type_ComTencentMobileqqUftransferTaskUploadUFTDiscUploadFileOp.c());
      this.jdField_a_of_type_ComTencentMobileqqUftransferTaskTaskinfoUFTUploadTaskRunNotesInfo.k(this.jdField_a_of_type_ComTencentMobileqqUftransferTaskUploadUFTDiscUploadFileOp.d());
      this.jdField_a_of_type_ComTencentMobileqqUftransferTaskTaskinfoUFTUploadTaskRunNotesInfo.l(this.jdField_a_of_type_ComTencentMobileqqUftransferTaskUploadUFTDiscUploadFileOp.e());
    }
    int i = 0;
    if (paramBundle != null) {
      i = paramBundle.getInt("REASON");
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("TId[");
    localStringBuilder.append(a());
    localStringBuilder.append("] stop ...");
    localStringBuilder.append(i);
    UFTLog.c("[UFTTransfer] UFTDiscUploadTask", 1, localStringBuilder.toString());
    if (i == 0)
    {
      b(paramBundle);
      return;
    }
    a(i, paramBundle);
  }
  
  protected void a(String paramString)
  {
    UFTDiscReportData localUFTDiscReportData = a();
    localUFTDiscReportData.jdField_a_of_type_Long = 0L;
    localUFTDiscReportData.jdField_a_of_type_JavaLangString = "";
    localUFTDiscReportData.h = this.jdField_a_of_type_ComTencentMobileqqUftransferTaskTaskinfoUFTBaseTaskInfo.b();
    localUFTDiscReportData.jdField_e_of_type_JavaLangString = paramString;
    localUFTDiscReportData.b();
  }
  
  protected void b()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqUftransferTaskCommonopUFTCalcHashOp != null)
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("TId[");
      localStringBuilder.append(a());
      localStringBuilder.append("] calc hash op had do");
      UFTLog.d("[UFTTransfer] UFTDiscUploadTask", 1, localStringBuilder.toString());
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("TId[");
    localStringBuilder.append(a());
    localStringBuilder.append("] do calc hash op ...");
    UFTLog.b("[UFTTransfer] UFTDiscUploadTask", 1, localStringBuilder.toString());
    this.jdField_a_of_type_ComTencentMobileqqUftransferTaskUploadUFTUploadCbWrapper.a(this.jdField_a_of_type_ComTencentMobileqqUftransferApiImplUFTTransferKey, 2, null);
    this.jdField_a_of_type_ComTencentMobileqqUftransferTaskCommonopUFTCalcHashOp = new UFTCalcHashOp(this.jdField_a_of_type_MqqAppAppRuntime, this.jdField_a_of_type_ComTencentMobileqqUftransferTaskTaskinfoUFTBaseTaskInfo, this.jdField_a_of_type_ComTencentMobileqqUftransferApiImplUFTTransferKey, a(), 25L, new UFTDiscUploadTask.2(this));
    int i = this.jdField_a_of_type_ComTencentMobileqqUftransferTaskCommonopUFTCalcHashOp.a();
    if (i != 0) {
      c(i);
    }
  }
  
  protected void b(int paramInt, String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("TId[");
    localStringBuilder.append(a());
    localStringBuilder.append("] on send msg op done errCode:");
    localStringBuilder.append(paramInt);
    localStringBuilder.append(" errMsg:");
    localStringBuilder.append(paramString);
    UFTLog.b("[UFTTransfer] UFTDiscUploadTask", 1, localStringBuilder.toString());
    a(paramInt, paramString, null);
  }
  
  protected void b(long paramLong, int paramInt, String paramString1, String paramString2)
  {
    UFTDiscReportData localUFTDiscReportData = a();
    localUFTDiscReportData.jdField_a_of_type_Long = paramInt;
    localUFTDiscReportData.jdField_a_of_type_JavaLangString = paramString1;
    localUFTDiscReportData.h = paramLong;
    localUFTDiscReportData.jdField_e_of_type_JavaLangString = paramString2;
    localUFTDiscReportData.a();
  }
  
  protected void b(Bundle paramBundle)
  {
    this.jdField_a_of_type_ComTencentMobileqqUftransferTaskUploadUFTUploadCbWrapper.a(true);
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("userCancel");
    ((StringBuilder)localObject).append(System.currentTimeMillis());
    localObject = ((StringBuilder)localObject).toString();
    long l = this.jdField_a_of_type_ComTencentMobileqqUftransferTaskTaskinfoUFTUploadTaskRunNotesInfo.i();
    UFTDiscUploadFileOp localUFTDiscUploadFileOp = this.jdField_a_of_type_ComTencentMobileqqUftransferTaskUploadUFTDiscUploadFileOp;
    if (localUFTDiscUploadFileOp != null) {
      l = localUFTDiscUploadFileOp.c();
    }
    b(l, 9037, (String)localObject, null);
    a(l, 9037, (String)localObject, null);
    f();
    super.a(paramBundle);
  }
  
  protected void c()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqUftransferTaskUploadUFTDiscFetchUploadUrlOp != null)
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("TId[");
      localStringBuilder.append(a());
      localStringBuilder.append("] fetch url op had do");
      UFTLog.d("[UFTTransfer] UFTDiscUploadTask", 1, localStringBuilder.toString());
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("TId[");
    localStringBuilder.append(a());
    localStringBuilder.append("] do fetch url op ...");
    UFTLog.b("[UFTTransfer] UFTDiscUploadTask", 1, localStringBuilder.toString());
    this.jdField_a_of_type_ComTencentMobileqqUftransferTaskUploadUFTUploadCbWrapper.a(this.jdField_a_of_type_ComTencentMobileqqUftransferApiImplUFTTransferKey, 3, null);
    this.jdField_a_of_type_ComTencentMobileqqUftransferTaskUploadUFTDiscFetchUploadUrlOp = new UFTDiscFetchUploadUrlOp(this.jdField_a_of_type_MqqAppAppRuntime, (UFTDiscUploadTaskInfo)this.jdField_a_of_type_ComTencentMobileqqUftransferTaskTaskinfoUFTBaseTaskInfo, this.jdField_a_of_type_ComTencentMobileqqUftransferApiImplUFTTransferKey, new UFTDiscUploadTask.3(this));
    int i = this.jdField_a_of_type_ComTencentMobileqqUftransferTaskUploadUFTDiscFetchUploadUrlOp.a();
    if (i != 0) {
      a(i, this.jdField_a_of_type_ComTencentMobileqqUftransferTaskUploadUFTDiscFetchUploadUrlOp.a());
    }
  }
  
  protected void c(int paramInt)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("TId[");
    localStringBuilder.append(a());
    localStringBuilder.append("] on calc hash op done retCode:");
    localStringBuilder.append(paramInt);
    UFTLog.b("[UFTTransfer] UFTDiscUploadTask", 1, localStringBuilder.toString());
    if (paramInt != 0)
    {
      int i = 9041;
      if (paramInt == 1) {
        i = 9042;
      }
      a(i, "get md5 failed", null);
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqUftransferTaskUploadUFTUploadCbWrapper.a(this.jdField_a_of_type_ComTencentMobileqqUftransferApiImplUFTTransferKey, this.jdField_a_of_type_ComTencentMobileqqUftransferTaskTaskinfoUFTBaseTaskInfo.a());
    c();
  }
  
  public boolean c()
  {
    this.jdField_a_of_type_ComTencentMobileqqUftransferTaskTaskinfoUFTUploadTaskRunNotesInfo.a();
    this.jdField_a_of_type_ComTencentMobileqqUftransferTaskUploadUFTUploadCbWrapper.a(false);
    this.jdField_a_of_type_ComTencentMobileqqUftransferTaskTaskinfoUFTUploadTaskRunNotesInfo.a(System.currentTimeMillis());
    this.jdField_a_of_type_ComTencentMobileqqUftransferTaskUploadUFTUploadCbWrapper.a(this.jdField_a_of_type_ComTencentMobileqqUftransferApiImplUFTTransferKey);
    UFTLogicThread.a().a(new UFTDiscUploadTask.1(this));
    return true;
  }
  
  protected void d()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqUftransferTaskUploadUFTDiscUploadFileOp != null)
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("TId[");
      localStringBuilder.append(a());
      localStringBuilder.append("] upload file had do");
      UFTLog.d("[UFTTransfer] UFTDiscUploadTask", 1, localStringBuilder.toString());
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("TId[");
    localStringBuilder.append(a());
    localStringBuilder.append("] do upload file op ...");
    UFTLog.b("[UFTTransfer] UFTDiscUploadTask", 1, localStringBuilder.toString());
    this.jdField_a_of_type_ComTencentMobileqqUftransferTaskTaskinfoUFTUploadTaskRunNotesInfo.g(System.currentTimeMillis());
    this.jdField_a_of_type_ComTencentMobileqqUftransferTaskUploadUFTUploadCbWrapper.a(this.jdField_a_of_type_ComTencentMobileqqUftransferApiImplUFTTransferKey, 4, null);
    this.jdField_a_of_type_ComTencentMobileqqUftransferTaskUploadUFTDiscUploadFileOp = new UFTDiscUploadFileOp(this.jdField_a_of_type_MqqAppAppRuntime, (UFTDiscUploadTaskInfo)this.jdField_a_of_type_ComTencentMobileqqUftransferTaskTaskinfoUFTBaseTaskInfo, this.jdField_a_of_type_ComTencentMobileqqUftransferApiImplUFTTransferKey, new UFTDiscUploadTask.4(this));
    int i = this.jdField_a_of_type_ComTencentMobileqqUftransferTaskUploadUFTDiscUploadFileOp.a();
    if (i != 0)
    {
      a(i, false, this.jdField_a_of_type_ComTencentMobileqqUftransferTaskUploadUFTDiscUploadFileOp.a(), null);
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqUftransferTaskTaskinfoUFTUploadTaskRunNotesInfo.a(this.jdField_a_of_type_ComTencentMobileqqUftransferTaskUploadUFTDiscUploadFileOp.b());
  }
  
  protected void e()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("TId[");
    localStringBuilder.append(a());
    localStringBuilder.append("] do send msg op ...");
    UFTLog.b("[UFTTransfer] UFTDiscUploadTask", 1, localStringBuilder.toString());
    this.jdField_a_of_type_ComTencentMobileqqUftransferTaskUploadUFTUploadCbWrapper.a(this.jdField_a_of_type_ComTencentMobileqqUftransferApiImplUFTTransferKey, 6, null);
    if (this.jdField_a_of_type_ComTencentMobileqqUftransferTaskUploadUFTUploadCbWrapper.a(this.jdField_a_of_type_ComTencentMobileqqUftransferApiImplUFTTransferKey, null, new UFTDiscUploadTask.5(this)) != 0) {
      b(90460, "send msg fail");
    }
  }
  
  protected void f()
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("TId[");
    ((StringBuilder)localObject).append(a());
    ((StringBuilder)localObject).append("] cancel all Op...");
    UFTLog.c("[UFTTransfer] UFTDiscUploadTask", 1, ((StringBuilder)localObject).toString());
    localObject = this.jdField_a_of_type_ComTencentMobileqqUftransferTaskCommonopUFTCalcHashOp;
    if (localObject != null)
    {
      ((UFTCalcHashOp)localObject).a();
      this.jdField_a_of_type_ComTencentMobileqqUftransferTaskCommonopUFTCalcHashOp = null;
    }
    localObject = this.jdField_a_of_type_ComTencentMobileqqUftransferTaskUploadUFTDiscFetchUploadUrlOp;
    if (localObject != null)
    {
      ((UFTDiscFetchUploadUrlOp)localObject).a();
      this.jdField_a_of_type_ComTencentMobileqqUftransferTaskUploadUFTDiscFetchUploadUrlOp = null;
    }
    localObject = this.jdField_a_of_type_ComTencentMobileqqUftransferTaskUploadUFTDiscUploadFileOp;
    if (localObject != null)
    {
      ((UFTDiscUploadFileOp)localObject).a();
      this.jdField_a_of_type_ComTencentMobileqqUftransferTaskUploadUFTDiscUploadFileOp = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.uftransfer.task.upload.UFTDiscUploadTask
 * JD-Core Version:    0.7.0.1
 */