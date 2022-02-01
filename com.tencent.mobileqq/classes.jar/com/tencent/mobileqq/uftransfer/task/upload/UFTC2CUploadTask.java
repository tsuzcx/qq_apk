package com.tencent.mobileqq.uftransfer.task.upload;

import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.mobileqq.uftransfer.UFTLogicThread;
import com.tencent.mobileqq.uftransfer.api.IUFTUploadCallback;
import com.tencent.mobileqq.uftransfer.api.UFTFileLocalInfo;
import com.tencent.mobileqq.uftransfer.api.UFTFileUploadBusinessInfo;
import com.tencent.mobileqq.uftransfer.api.impl.UFTTransferKey;
import com.tencent.mobileqq.uftransfer.depend.UFTDependFeatureApi;
import com.tencent.mobileqq.uftransfer.depend.UFTLog;
import com.tencent.mobileqq.uftransfer.proto.UFTProtoRequestor;
import com.tencent.mobileqq.uftransfer.task.IUFTTaskCallback;
import com.tencent.mobileqq.uftransfer.task.commonop.UFTCalcHashOp;
import com.tencent.mobileqq.uftransfer.task.taskinfo.UFTBaseTaskInfo;
import com.tencent.mobileqq.uftransfer.task.taskinfo.UFTC2CUploadTaskInfo;
import com.tencent.mobileqq.uftransfer.task.taskinfo.UFTUploadSrvBusiProp.C2CUploadSrvBusiProp;
import com.tencent.mobileqq.uftransfer.task.taskinfo.UFTUploadTaskRunNotesInfo;
import mqq.app.AppRuntime;

public class UFTC2CUploadTask
  extends UFTBaseUploadTask
{
  protected UFTC2CFetchUploadUrlOp a;
  protected UFTC2CSetUploadSucOp a;
  protected UFTC2CUploadFileOp a;
  protected UFTCalcHashOp b;
  
  protected UFTC2CUploadTask(AppRuntime paramAppRuntime, UFTTransferKey paramUFTTransferKey, UFTC2CUploadTaskInfo paramUFTC2CUploadTaskInfo, IUFTTaskCallback paramIUFTTaskCallback, IUFTUploadCallback paramIUFTUploadCallback)
  {
    super(paramAppRuntime, paramUFTTransferKey, paramUFTC2CUploadTaskInfo, paramIUFTTaskCallback, paramIUFTUploadCallback);
  }
  
  public static UFTC2CUploadTask b(AppRuntime paramAppRuntime, UFTTransferKey paramUFTTransferKey, UFTC2CUploadTaskInfo paramUFTC2CUploadTaskInfo, IUFTTaskCallback paramIUFTTaskCallback, IUFTUploadCallback paramIUFTUploadCallback)
  {
    if (a(paramAppRuntime, paramUFTTransferKey, paramUFTC2CUploadTaskInfo, paramIUFTTaskCallback, "[UFTTransfer] UFTC2CUploadTask")) {
      return new UFTC2CUploadTask(paramAppRuntime, paramUFTTransferKey, paramUFTC2CUploadTaskInfo, paramIUFTTaskCallback, paramIUFTUploadCallback);
    }
    return null;
  }
  
  protected int a()
  {
    return 0;
  }
  
  protected UFTC2CReportData a(boolean paramBoolean)
  {
    UFTC2CUploadTaskInfo localUFTC2CUploadTaskInfo = (UFTC2CUploadTaskInfo)this.jdField_a_of_type_ComTencentMobileqqUftransferTaskTaskinfoUFTBaseTaskInfo;
    UFTC2CReportData localUFTC2CReportData = new UFTC2CReportData(this.jdField_a_of_type_MqqAppAppRuntime, a(), localUFTC2CUploadTaskInfo.d(), localUFTC2CUploadTaskInfo.b(), a());
    localUFTC2CReportData.jdField_c_of_type_JavaLangString = UFTDependFeatureApi.b(this.jdField_a_of_type_ComTencentMobileqqUftransferTaskTaskinfoUFTBaseTaskInfo.a().a());
    localUFTC2CReportData.jdField_b_of_type_JavaLangString = localUFTC2CUploadTaskInfo.b();
    localUFTC2CReportData.jdField_b_of_type_Int = this.jdField_a_of_type_ComTencentMobileqqUftransferTaskTaskinfoUFTUploadTaskRunNotesInfo.a();
    localUFTC2CReportData.jdField_e_of_type_Long = this.jdField_a_of_type_ComTencentMobileqqUftransferTaskTaskinfoUFTUploadTaskRunNotesInfo.a();
    localUFTC2CReportData.jdField_d_of_type_Int = UFTDependFeatureApi.a(this.jdField_a_of_type_ComTencentMobileqqUftransferTaskTaskinfoUFTUploadTaskRunNotesInfo.a());
    localUFTC2CReportData.jdField_a_of_type_Boolean = d();
    localUFTC2CReportData.jdField_c_of_type_Int = b();
    localUFTC2CReportData.jdField_d_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqUftransferTaskTaskinfoUFTUploadTaskRunNotesInfo.a();
    localUFTC2CReportData.i = this.jdField_a_of_type_ComTencentMobileqqUftransferTaskTaskinfoUFTUploadTaskRunNotesInfo.a();
    localUFTC2CReportData.jdField_c_of_type_Long = 1L;
    if (this.jdField_a_of_type_ComTencentMobileqqUftransferTaskTaskinfoUFTUploadTaskRunNotesInfo.i() > this.jdField_a_of_type_ComTencentMobileqqUftransferTaskTaskinfoUFTUploadTaskRunNotesInfo.j()) {
      localUFTC2CReportData.jdField_c_of_type_Long = (this.jdField_a_of_type_ComTencentMobileqqUftransferTaskTaskinfoUFTUploadTaskRunNotesInfo.i() - this.jdField_a_of_type_ComTencentMobileqqUftransferTaskTaskinfoUFTUploadTaskRunNotesInfo.j());
    }
    return localUFTC2CReportData;
  }
  
  protected UFTUploadCompleteInfo a(int paramInt, UFTUploadTaskCompParam paramUFTUploadTaskCompParam)
  {
    UFTUploadCompleteInfo localUFTUploadCompleteInfo = new UFTUploadCompleteInfo();
    UFTC2CUploadTaskInfo localUFTC2CUploadTaskInfo = (UFTC2CUploadTaskInfo)this.jdField_a_of_type_ComTencentMobileqqUftransferTaskTaskinfoUFTBaseTaskInfo;
    localUFTUploadCompleteInfo.a(this.jdField_a_of_type_ComTencentMobileqqUftransferTaskTaskinfoUFTUploadTaskRunNotesInfo.a());
    localUFTUploadCompleteInfo.a(localUFTC2CUploadTaskInfo.b());
    localUFTUploadCompleteInfo.d(localUFTC2CUploadTaskInfo.f());
    localUFTUploadCompleteInfo.c(this.jdField_a_of_type_ComTencentMobileqqUftransferTaskTaskinfoUFTUploadTaskRunNotesInfo.a());
    if ((!TextUtils.isEmpty(localUFTC2CUploadTaskInfo.g())) && (!UFTProtoRequestor.a(paramInt))) {
      localUFTUploadCompleteInfo.b(localUFTC2CUploadTaskInfo.g());
    }
    localUFTUploadCompleteInfo.a(paramUFTUploadTaskCompParam.h);
    return localUFTUploadCompleteInfo;
  }
  
  protected UFTUploadTaskCompParam a(int paramInt, String paramString)
  {
    paramString = new UFTUploadTaskCompParam(paramInt, paramString);
    paramString.jdField_b_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqUftransferTaskTaskinfoUFTUploadTaskRunNotesInfo.c();
    paramString.jdField_a_of_type_JavaLangObject = this.jdField_a_of_type_ComTencentMobileqqUftransferTaskTaskinfoUFTUploadTaskRunNotesInfo.a();
    paramString.jdField_a_of_type_Long = this.jdField_a_of_type_ComTencentMobileqqUftransferTaskTaskinfoUFTUploadTaskRunNotesInfo.k();
    paramString.jdField_b_of_type_Long = this.jdField_a_of_type_ComTencentMobileqqUftransferTaskTaskinfoUFTUploadTaskRunNotesInfo.l();
    return paramString;
  }
  
  public String a()
  {
    return ((UFTC2CUploadTaskInfo)this.jdField_a_of_type_ComTencentMobileqqUftransferTaskTaskinfoUFTBaseTaskInfo).c();
  }
  
  protected void a()
  {
    if (this.b != null)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("TId[");
      ((StringBuilder)localObject).append(a());
      ((StringBuilder)localObject).append("] calc hash op had do");
      UFTLog.d("[UFTTransfer] UFTC2CUploadTask", 1, ((StringBuilder)localObject).toString());
      return;
    }
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqUftransferTaskTaskinfoUFTBaseTaskInfo.a().d();
    byte[] arrayOfByte = this.jdField_a_of_type_ComTencentMobileqqUftransferTaskTaskinfoUFTBaseTaskInfo.a().a();
    if ((localObject != null) && (localObject.length > 0) && (arrayOfByte != null) && (arrayOfByte.length > 0))
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("TId[");
      ((StringBuilder)localObject).append(a());
      ((StringBuilder)localObject).append("] file hash exist and calc hash done");
      UFTLog.b("[UFTTransfer] UFTC2CUploadTask", 1, ((StringBuilder)localObject).toString());
      c(0);
      return;
    }
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("TId[");
    ((StringBuilder)localObject).append(a());
    ((StringBuilder)localObject).append("] do calc hash op ...");
    UFTLog.b("[UFTTransfer] UFTC2CUploadTask", 1, ((StringBuilder)localObject).toString());
    this.jdField_a_of_type_ComTencentMobileqqUftransferTaskTaskinfoUFTUploadTaskRunNotesInfo.c(System.currentTimeMillis());
    this.jdField_a_of_type_ComTencentMobileqqUftransferTaskUploadUFTUploadCbWrapper.a(this.jdField_a_of_type_ComTencentMobileqqUftransferApiImplUFTTransferKey, 2, null);
    this.b = new UFTCalcHashOp(this.jdField_a_of_type_MqqAppAppRuntime, this.jdField_a_of_type_ComTencentMobileqqUftransferTaskTaskinfoUFTBaseTaskInfo, this.jdField_a_of_type_ComTencentMobileqqUftransferApiImplUFTTransferKey, a(), 25L, new UFTC2CUploadTask.2(this));
    int i = this.b.a();
    if (i != 0) {
      c(i);
    }
  }
  
  protected void a(int paramInt, Bundle paramBundle)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("exception broken");
    ((StringBuilder)localObject).append(System.currentTimeMillis());
    localObject = ((StringBuilder)localObject).toString();
    int i;
    if ((paramInt != 1) && (paramInt != 2)) {
      i = 0;
    } else {
      i = 1;
    }
    e();
    super.a(paramBundle);
    if (i != 0)
    {
      paramBundle = a(9004, a(7, (String)localObject));
      paramBundle.b(paramInt);
      this.jdField_a_of_type_ComTencentMobileqqUftransferTaskUploadUFTUploadCbWrapper.a(this.jdField_a_of_type_ComTencentMobileqqUftransferApiImplUFTTransferKey, 9004, paramBundle);
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqUftransferTaskUploadUFTUploadCbWrapper.a(true);
  }
  
  protected void a(int paramInt, UFTUploadTaskCompParam paramUFTUploadTaskCompParam)
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
    localStringBuilder.append(paramUFTUploadTaskCompParam.jdField_a_of_type_JavaLangString);
    UFTLog.b("[UFTTransfer] UFTC2CUploadTask", 1, localStringBuilder.toString());
    e();
    this.jdField_a_of_type_ComTencentMobileqqUftransferTaskTaskinfoUFTUploadTaskRunNotesInfo.b(System.currentTimeMillis());
    if (paramInt != 0)
    {
      c(this.jdField_a_of_type_ComTencentMobileqqUftransferTaskTaskinfoUFTUploadTaskRunNotesInfo.i(), paramInt, paramUFTUploadTaskCompParam);
      b(this.jdField_a_of_type_ComTencentMobileqqUftransferTaskTaskinfoUFTUploadTaskRunNotesInfo.i(), paramInt, paramUFTUploadTaskCompParam);
    }
    else
    {
      n();
    }
    this.jdField_a_of_type_ComTencentMobileqqUftransferTaskUploadUFTUploadCbWrapper.a(this.jdField_a_of_type_ComTencentMobileqqUftransferApiImplUFTTransferKey, paramInt, a(paramInt, paramUFTUploadTaskCompParam));
    a(paramInt);
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
    UFTLog.b("[UFTTransfer] UFTC2CUploadTask", 1, localStringBuilder.toString());
    this.jdField_a_of_type_ComTencentMobileqqUftransferTaskTaskinfoUFTUploadTaskRunNotesInfo.f(System.currentTimeMillis());
    if (paramInt != 0)
    {
      a(paramInt, a(3, paramString));
      return;
    }
    j();
    if (((UFTC2CUploadTaskInfo)this.jdField_a_of_type_ComTencentMobileqqUftransferTaskTaskinfoUFTBaseTaskInfo).b())
    {
      k();
      return;
    }
    g();
  }
  
  protected void a(int paramInt1, String paramString, int paramInt2, long paramLong)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("TId[");
    localStringBuilder.append(a());
    localStringBuilder.append("] on send msg op done. errCode:");
    localStringBuilder.append(paramInt1);
    localStringBuilder.append(" errMsg:");
    localStringBuilder.append(paramString);
    localStringBuilder.append(" seq:");
    localStringBuilder.append(paramInt2);
    localStringBuilder.append(" uniSeq:");
    localStringBuilder.append(paramLong);
    UFTLog.b("[UFTTransfer] UFTC2CUploadTask", 1, localStringBuilder.toString());
    a(paramInt1, a(6, paramString));
  }
  
  public void a(Bundle paramBundle)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqUftransferTaskTaskinfoUFTUploadTaskRunNotesInfo.g() > 0L) {
      this.jdField_a_of_type_ComTencentMobileqqUftransferTaskTaskinfoUFTUploadTaskRunNotesInfo.h(System.currentTimeMillis());
    }
    if (this.jdField_a_of_type_ComTencentMobileqqUftransferTaskUploadUFTC2CUploadFileOp != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqUftransferTaskTaskinfoUFTUploadTaskRunNotesInfo.i(this.jdField_a_of_type_ComTencentMobileqqUftransferTaskUploadUFTC2CUploadFileOp.c());
      this.jdField_a_of_type_ComTencentMobileqqUftransferTaskTaskinfoUFTUploadTaskRunNotesInfo.k(this.jdField_a_of_type_ComTencentMobileqqUftransferTaskUploadUFTC2CUploadFileOp.d());
      this.jdField_a_of_type_ComTencentMobileqqUftransferTaskTaskinfoUFTUploadTaskRunNotesInfo.l(this.jdField_a_of_type_ComTencentMobileqqUftransferTaskUploadUFTC2CUploadFileOp.e());
    }
    int i = 0;
    if (paramBundle != null) {
      i = paramBundle.getInt("REASON");
    }
    this.jdField_a_of_type_ComTencentMobileqqUftransferTaskTaskinfoUFTUploadTaskRunNotesInfo.b(System.currentTimeMillis());
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("TId[");
    localStringBuilder.append(a());
    localStringBuilder.append("] stop ...");
    localStringBuilder.append(i);
    UFTLog.c("[UFTTransfer] UFTC2CUploadTask", 1, localStringBuilder.toString());
    if (i == 0)
    {
      b(paramBundle);
      return;
    }
    a(i, paramBundle);
  }
  
  protected void a(UFTBaseUploadFileOp.UploadFileOpRetData paramUploadFileOpRetData)
  {
    this.jdField_a_of_type_ComTencentMobileqqUftransferTaskTaskinfoUFTUploadTaskRunNotesInfo.h(System.currentTimeMillis());
    this.jdField_a_of_type_ComTencentMobileqqUftransferTaskTaskinfoUFTUploadTaskRunNotesInfo.a(paramUploadFileOpRetData.a());
    this.jdField_a_of_type_ComTencentMobileqqUftransferTaskTaskinfoUFTUploadTaskRunNotesInfo.b(paramUploadFileOpRetData.c());
    this.jdField_a_of_type_ComTencentMobileqqUftransferTaskTaskinfoUFTUploadTaskRunNotesInfo.a(paramUploadFileOpRetData.a());
    if (this.jdField_a_of_type_ComTencentMobileqqUftransferTaskUploadUFTC2CUploadFileOp != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqUftransferTaskTaskinfoUFTUploadTaskRunNotesInfo.a(this.jdField_a_of_type_ComTencentMobileqqUftransferTaskUploadUFTC2CUploadFileOp.b());
      this.jdField_a_of_type_ComTencentMobileqqUftransferTaskTaskinfoUFTUploadTaskRunNotesInfo.j(this.jdField_a_of_type_ComTencentMobileqqUftransferTaskUploadUFTC2CUploadFileOp.b());
      this.jdField_a_of_type_ComTencentMobileqqUftransferTaskTaskinfoUFTUploadTaskRunNotesInfo.i(this.jdField_a_of_type_ComTencentMobileqqUftransferTaskUploadUFTC2CUploadFileOp.c());
      this.jdField_a_of_type_ComTencentMobileqqUftransferTaskTaskinfoUFTUploadTaskRunNotesInfo.a(this.jdField_a_of_type_ComTencentMobileqqUftransferTaskUploadUFTC2CUploadFileOp.c());
      this.jdField_a_of_type_ComTencentMobileqqUftransferTaskTaskinfoUFTUploadTaskRunNotesInfo.k(this.jdField_a_of_type_ComTencentMobileqqUftransferTaskUploadUFTC2CUploadFileOp.d());
      this.jdField_a_of_type_ComTencentMobileqqUftransferTaskTaskinfoUFTUploadTaskRunNotesInfo.l(this.jdField_a_of_type_ComTencentMobileqqUftransferTaskUploadUFTC2CUploadFileOp.e());
    }
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("TId[");
    ((StringBuilder)localObject).append(a());
    ((StringBuilder)localObject).append("] on upload file op done. errCode:");
    ((StringBuilder)localObject).append(paramUploadFileOpRetData.a());
    ((StringBuilder)localObject).append(" flash:");
    ((StringBuilder)localObject).append(this.jdField_a_of_type_ComTencentMobileqqUftransferTaskTaskinfoUFTUploadTaskRunNotesInfo.a());
    ((StringBuilder)localObject).append(" speed:");
    ((StringBuilder)localObject).append(this.jdField_a_of_type_ComTencentMobileqqUftransferTaskTaskinfoUFTUploadTaskRunNotesInfo.l());
    ((StringBuilder)localObject).append(" httpTime:");
    ((StringBuilder)localObject).append(this.jdField_a_of_type_ComTencentMobileqqUftransferTaskTaskinfoUFTUploadTaskRunNotesInfo.k());
    ((StringBuilder)localObject).append(" url:");
    ((StringBuilder)localObject).append(this.jdField_a_of_type_ComTencentMobileqqUftransferTaskTaskinfoUFTUploadTaskRunNotesInfo.a());
    ((StringBuilder)localObject).append(" upStartSize:");
    ((StringBuilder)localObject).append(this.jdField_a_of_type_ComTencentMobileqqUftransferTaskTaskinfoUFTUploadTaskRunNotesInfo.j());
    ((StringBuilder)localObject).append(" upEndSize:");
    ((StringBuilder)localObject).append(this.jdField_a_of_type_ComTencentMobileqqUftransferTaskTaskinfoUFTUploadTaskRunNotesInfo.i());
    UFTLog.b("[UFTTransfer] UFTC2CUploadTask", 1, ((StringBuilder)localObject).toString());
    if (paramUploadFileOpRetData.a() != 0)
    {
      localObject = a(4, paramUploadFileOpRetData.a());
      ((UFTUploadTaskCompParam)localObject).jdField_a_of_type_Boolean = paramUploadFileOpRetData.c();
      a(paramUploadFileOpRetData.a(), (UFTUploadTaskCompParam)localObject);
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqUftransferTaskTaskinfoUFTUploadTaskRunNotesInfo.i(this.jdField_a_of_type_ComTencentMobileqqUftransferTaskTaskinfoUFTBaseTaskInfo.b());
    l();
  }
  
  protected int b()
  {
    UFTUploadSrvBusiProp.C2CUploadSrvBusiProp localC2CUploadSrvBusiProp = ((UFTC2CUploadTaskInfo)this.jdField_a_of_type_ComTencentMobileqqUftransferTaskTaskinfoUFTBaseTaskInfo).a();
    if ((localC2CUploadSrvBusiProp != null) && (localC2CUploadSrvBusiProp.b()))
    {
      if (localC2CUploadSrvBusiProp.c()) {
        return 3;
      }
      return 2;
    }
    return 1;
  }
  
  protected void b()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqUftransferTaskUploadUFTC2CFetchUploadUrlOp != null)
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("TId[");
      localStringBuilder.append(a());
      localStringBuilder.append("] fetch url op had do");
      UFTLog.d("[UFTTransfer] UFTC2CUploadTask", 1, localStringBuilder.toString());
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("TId[");
    localStringBuilder.append(a());
    localStringBuilder.append("] do fetch url op ...");
    UFTLog.b("[UFTTransfer] UFTC2CUploadTask", 1, localStringBuilder.toString());
    this.jdField_a_of_type_ComTencentMobileqqUftransferTaskTaskinfoUFTUploadTaskRunNotesInfo.e(System.currentTimeMillis());
    this.jdField_a_of_type_ComTencentMobileqqUftransferTaskUploadUFTUploadCbWrapper.a(this.jdField_a_of_type_ComTencentMobileqqUftransferApiImplUFTTransferKey, 3, null);
    this.jdField_a_of_type_ComTencentMobileqqUftransferTaskUploadUFTC2CFetchUploadUrlOp = new UFTC2CFetchUploadUrlV3Op(this.jdField_a_of_type_MqqAppAppRuntime, (UFTC2CUploadTaskInfo)this.jdField_a_of_type_ComTencentMobileqqUftransferTaskTaskinfoUFTBaseTaskInfo, this.jdField_a_of_type_ComTencentMobileqqUftransferApiImplUFTTransferKey, new UFTC2CUploadTask.3(this));
    int i = this.jdField_a_of_type_ComTencentMobileqqUftransferTaskUploadUFTC2CFetchUploadUrlOp.a();
    if (i != 0) {
      a(i, this.jdField_a_of_type_ComTencentMobileqqUftransferTaskUploadUFTC2CFetchUploadUrlOp.a());
    }
  }
  
  protected void b(int paramInt, String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("TId[");
    localStringBuilder.append(a());
    localStringBuilder.append("] on set uploadsuc done errCode:");
    localStringBuilder.append(paramInt);
    localStringBuilder.append(" errMsg:");
    localStringBuilder.append(paramString);
    UFTLog.b("[UFTTransfer] UFTC2CUploadTask", 1, localStringBuilder.toString());
    if (paramInt != 0)
    {
      a(paramInt, a(5, paramString));
      return;
    }
    if (((UFTC2CUploadTaskInfo)this.jdField_a_of_type_ComTencentMobileqqUftransferTaskTaskinfoUFTBaseTaskInfo).c())
    {
      m();
      return;
    }
    a(0, a(5, ""));
  }
  
  protected final void b(long paramLong, int paramInt, UFTUploadTaskCompParam paramUFTUploadTaskCompParam)
  {
    UFTC2CReportData localUFTC2CReportData = a(false);
    localUFTC2CReportData.jdField_h_of_type_Long = paramInt;
    localUFTC2CReportData.jdField_f_of_type_JavaLangString = paramUFTUploadTaskCompParam.jdField_a_of_type_JavaLangString;
    localUFTC2CReportData.jdField_h_of_type_JavaLangString = paramUFTUploadTaskCompParam.jdField_b_of_type_JavaLangString;
    localUFTC2CReportData.jdField_g_of_type_JavaLangString = paramUFTUploadTaskCompParam.jdField_a_of_type_JavaLangString;
    if (paramLong > this.jdField_a_of_type_ComTencentMobileqqUftransferTaskTaskinfoUFTUploadTaskRunNotesInfo.j()) {
      localUFTC2CReportData.jdField_c_of_type_Long = (paramLong - this.jdField_a_of_type_ComTencentMobileqqUftransferTaskTaskinfoUFTUploadTaskRunNotesInfo.j());
    }
    localUFTC2CReportData.jdField_d_of_type_Long = paramLong;
    localUFTC2CReportData.jdField_f_of_type_Long = this.jdField_a_of_type_ComTencentMobileqqUftransferTaskTaskinfoUFTUploadTaskRunNotesInfo.k();
    localUFTC2CReportData.jdField_g_of_type_Long = this.jdField_a_of_type_ComTencentMobileqqUftransferTaskTaskinfoUFTUploadTaskRunNotesInfo.l();
    localUFTC2CReportData.a();
  }
  
  protected void b(Bundle paramBundle)
  {
    this.jdField_a_of_type_ComTencentMobileqqUftransferTaskUploadUFTUploadCbWrapper.a(true);
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("userCancel");
    ((StringBuilder)localObject).append(System.currentTimeMillis());
    localObject = ((StringBuilder)localObject).toString();
    long l = this.jdField_a_of_type_ComTencentMobileqqUftransferTaskTaskinfoUFTUploadTaskRunNotesInfo.i();
    UFTC2CUploadFileOp localUFTC2CUploadFileOp = this.jdField_a_of_type_ComTencentMobileqqUftransferTaskUploadUFTC2CUploadFileOp;
    if (localUFTC2CUploadFileOp != null) {
      l = localUFTC2CUploadFileOp.c();
    }
    localObject = a(7, (String)localObject);
    c(l, 9037, (UFTUploadTaskCompParam)localObject);
    b(l, 9037, (UFTUploadTaskCompParam)localObject);
    e();
    super.a(paramBundle);
  }
  
  protected void c(int paramInt)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("TId[");
    localStringBuilder.append(a());
    localStringBuilder.append("] on calc hash op done retCode:");
    localStringBuilder.append(paramInt);
    UFTLog.b("[UFTTransfer] UFTC2CUploadTask", 1, localStringBuilder.toString());
    this.jdField_a_of_type_ComTencentMobileqqUftransferTaskTaskinfoUFTUploadTaskRunNotesInfo.d(System.currentTimeMillis());
    if (paramInt != 0)
    {
      int i = 9041;
      if (paramInt == 1) {
        i = 9042;
      }
      a(i, a(2, "get md5 failed"));
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqUftransferTaskUploadUFTUploadCbWrapper.a(this.jdField_a_of_type_ComTencentMobileqqUftransferApiImplUFTTransferKey, this.jdField_a_of_type_ComTencentMobileqqUftransferTaskTaskinfoUFTBaseTaskInfo.a());
    b();
  }
  
  protected final void c(long paramLong, int paramInt, UFTUploadTaskCompParam paramUFTUploadTaskCompParam)
  {
    UFTC2CReportData localUFTC2CReportData = a(false);
    localUFTC2CReportData.jdField_h_of_type_Long = paramInt;
    localUFTC2CReportData.jdField_f_of_type_JavaLangString = paramUFTUploadTaskCompParam.jdField_a_of_type_JavaLangString;
    localUFTC2CReportData.jdField_h_of_type_JavaLangString = paramUFTUploadTaskCompParam.jdField_b_of_type_JavaLangString;
    localUFTC2CReportData.jdField_g_of_type_JavaLangString = paramUFTUploadTaskCompParam.jdField_a_of_type_JavaLangString;
    if (paramLong > this.jdField_a_of_type_ComTencentMobileqqUftransferTaskTaskinfoUFTUploadTaskRunNotesInfo.j()) {
      localUFTC2CReportData.jdField_c_of_type_Long = (paramLong - this.jdField_a_of_type_ComTencentMobileqqUftransferTaskTaskinfoUFTUploadTaskRunNotesInfo.j());
    }
    localUFTC2CReportData.jdField_d_of_type_Long = paramLong;
    localUFTC2CReportData.jdField_f_of_type_Long = paramUFTUploadTaskCompParam.jdField_a_of_type_Long;
    localUFTC2CReportData.jdField_g_of_type_Long = paramUFTUploadTaskCompParam.jdField_b_of_type_Long;
    localUFTC2CReportData.b();
  }
  
  protected boolean c()
  {
    this.jdField_a_of_type_ComTencentMobileqqUftransferTaskTaskinfoUFTUploadTaskRunNotesInfo.a();
    this.jdField_a_of_type_ComTencentMobileqqUftransferTaskUploadUFTUploadCbWrapper.a(false);
    this.jdField_a_of_type_ComTencentMobileqqUftransferTaskTaskinfoUFTUploadTaskRunNotesInfo.a(System.currentTimeMillis());
    this.jdField_a_of_type_ComTencentMobileqqUftransferTaskUploadUFTUploadCbWrapper.a(this.jdField_a_of_type_ComTencentMobileqqUftransferApiImplUFTTransferKey);
    UFTLogicThread.a().a(new UFTC2CUploadTask.1(this));
    return true;
  }
  
  protected boolean d()
  {
    UFTUploadSrvBusiProp.C2CUploadSrvBusiProp localC2CUploadSrvBusiProp = ((UFTC2CUploadTaskInfo)this.jdField_a_of_type_ComTencentMobileqqUftransferTaskTaskinfoUFTBaseTaskInfo).a();
    if (localC2CUploadSrvBusiProp != null) {
      return localC2CUploadSrvBusiProp.a();
    }
    return false;
  }
  
  protected void e()
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("TId[");
    ((StringBuilder)localObject).append(a());
    ((StringBuilder)localObject).append("] cancel all Op...");
    UFTLog.c("[UFTTransfer] UFTC2CUploadTask", 1, ((StringBuilder)localObject).toString());
    localObject = this.b;
    if (localObject != null)
    {
      ((UFTCalcHashOp)localObject).a();
      this.b = null;
    }
    localObject = this.jdField_a_of_type_ComTencentMobileqqUftransferTaskUploadUFTC2CFetchUploadUrlOp;
    if (localObject != null)
    {
      ((UFTC2CFetchUploadUrlOp)localObject).a();
      this.jdField_a_of_type_ComTencentMobileqqUftransferTaskUploadUFTC2CFetchUploadUrlOp = null;
    }
    localObject = this.jdField_a_of_type_ComTencentMobileqqUftransferTaskUploadUFTC2CUploadFileOp;
    if (localObject != null)
    {
      ((UFTC2CUploadFileOp)localObject).a();
      this.jdField_a_of_type_ComTencentMobileqqUftransferTaskUploadUFTC2CUploadFileOp = null;
    }
    localObject = this.jdField_a_of_type_ComTencentMobileqqUftransferTaskUploadUFTC2CSetUploadSucOp;
    if (localObject != null)
    {
      ((UFTC2CSetUploadSucOp)localObject).a();
      this.jdField_a_of_type_ComTencentMobileqqUftransferTaskUploadUFTC2CSetUploadSucOp = null;
    }
  }
  
  protected void g()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqUftransferTaskUploadUFTC2CUploadFileOp != null)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("TId[");
      ((StringBuilder)localObject).append(a());
      ((StringBuilder)localObject).append("] upload file had do");
      UFTLog.d("[UFTTransfer] UFTC2CUploadTask", 1, ((StringBuilder)localObject).toString());
      return;
    }
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("TId[");
    ((StringBuilder)localObject).append(a());
    ((StringBuilder)localObject).append("] do upload file op ...");
    UFTLog.b("[UFTTransfer] UFTC2CUploadTask", 1, ((StringBuilder)localObject).toString());
    this.jdField_a_of_type_ComTencentMobileqqUftransferTaskTaskinfoUFTUploadTaskRunNotesInfo.g(System.currentTimeMillis());
    this.jdField_a_of_type_ComTencentMobileqqUftransferTaskUploadUFTUploadCbWrapper.a(this.jdField_a_of_type_ComTencentMobileqqUftransferApiImplUFTTransferKey, 4, null);
    this.jdField_a_of_type_ComTencentMobileqqUftransferTaskUploadUFTC2CUploadFileOp = new UFTC2CUploadFileOp(this.jdField_a_of_type_MqqAppAppRuntime, (UFTC2CUploadTaskInfo)this.jdField_a_of_type_ComTencentMobileqqUftransferTaskTaskinfoUFTBaseTaskInfo, this.jdField_a_of_type_ComTencentMobileqqUftransferApiImplUFTTransferKey, new UFTC2CUploadTask.4(this));
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
  
  protected void i()
  {
    a();
  }
  
  protected void j()
  {
    UFTC2CUploadTaskInfo localUFTC2CUploadTaskInfo = (UFTC2CUploadTaskInfo)this.jdField_a_of_type_ComTencentMobileqqUftransferTaskTaskinfoUFTBaseTaskInfo;
    UFTFileUploadBusinessInfo localUFTFileUploadBusinessInfo = new UFTFileUploadBusinessInfo();
    localUFTFileUploadBusinessInfo.a(localUFTC2CUploadTaskInfo.b());
    localUFTFileUploadBusinessInfo.a(localUFTC2CUploadTaskInfo.a());
    localUFTFileUploadBusinessInfo.c(localUFTC2CUploadTaskInfo.f());
    this.jdField_a_of_type_ComTencentMobileqqUftransferTaskUploadUFTUploadCbWrapper.a(this.jdField_a_of_type_ComTencentMobileqqUftransferApiImplUFTTransferKey, localUFTFileUploadBusinessInfo);
  }
  
  protected void k()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("TId[");
    localStringBuilder.append(a());
    localStringBuilder.append("] file is hit");
    UFTLog.b("[UFTTransfer] UFTC2CUploadTask", 1, localStringBuilder.toString());
    if (this.jdField_a_of_type_ComTencentMobileqqUftransferTaskTaskinfoUFTUploadTaskRunNotesInfo.g() > 0L) {
      this.jdField_a_of_type_ComTencentMobileqqUftransferTaskTaskinfoUFTUploadTaskRunNotesInfo.h(System.currentTimeMillis());
    }
    this.jdField_a_of_type_ComTencentMobileqqUftransferTaskTaskinfoUFTUploadTaskRunNotesInfo.a(true);
    this.jdField_a_of_type_ComTencentMobileqqUftransferTaskTaskinfoUFTUploadTaskRunNotesInfo.j(this.jdField_a_of_type_ComTencentMobileqqUftransferTaskTaskinfoUFTBaseTaskInfo.b());
    this.jdField_a_of_type_ComTencentMobileqqUftransferTaskTaskinfoUFTUploadTaskRunNotesInfo.i(this.jdField_a_of_type_ComTencentMobileqqUftransferTaskTaskinfoUFTBaseTaskInfo.b());
    l();
  }
  
  protected void l()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqUftransferTaskUploadUFTC2CSetUploadSucOp != null)
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("TId[");
      localStringBuilder.append(a());
      localStringBuilder.append("] set upload suc op had do");
      UFTLog.d("[UFTTransfer] UFTC2CUploadTask", 1, localStringBuilder.toString());
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("TId[");
    localStringBuilder.append(a());
    localStringBuilder.append("] do set upload suc op ...");
    UFTLog.b("[UFTTransfer] UFTC2CUploadTask", 1, localStringBuilder.toString());
    this.jdField_a_of_type_ComTencentMobileqqUftransferTaskUploadUFTUploadCbWrapper.a(this.jdField_a_of_type_ComTencentMobileqqUftransferApiImplUFTTransferKey, 5, null);
    this.jdField_a_of_type_ComTencentMobileqqUftransferTaskUploadUFTC2CSetUploadSucOp = new UFTC2CSetUploadSucOp(this.jdField_a_of_type_MqqAppAppRuntime, (UFTC2CUploadTaskInfo)this.jdField_a_of_type_ComTencentMobileqqUftransferTaskTaskinfoUFTBaseTaskInfo, this.jdField_a_of_type_ComTencentMobileqqUftransferApiImplUFTTransferKey, new UFTC2CUploadTask.5(this));
    int i = this.jdField_a_of_type_ComTencentMobileqqUftransferTaskUploadUFTC2CSetUploadSucOp.a();
    if (i != 0) {
      b(i, "set upload suc fail");
    }
  }
  
  protected void m()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("TId[");
    localStringBuilder.append(a());
    localStringBuilder.append("] do send msg op ...");
    UFTLog.b("[UFTTransfer] UFTC2CUploadTask", 1, localStringBuilder.toString());
    this.jdField_a_of_type_ComTencentMobileqqUftransferTaskUploadUFTUploadCbWrapper.a(this.jdField_a_of_type_ComTencentMobileqqUftransferApiImplUFTTransferKey, 6, null);
    if (this.jdField_a_of_type_ComTencentMobileqqUftransferTaskUploadUFTUploadCbWrapper.a(this.jdField_a_of_type_ComTencentMobileqqUftransferApiImplUFTTransferKey, null, new UFTC2CUploadTask.6(this)) != 0) {
      a(90460, "send msg fail", 0, 0L);
    }
  }
  
  protected final void n()
  {
    UFTC2CReportData localUFTC2CReportData = a(true);
    localUFTC2CReportData.jdField_h_of_type_Long = 0L;
    if ((!this.jdField_a_of_type_ComTencentMobileqqUftransferTaskTaskinfoUFTUploadTaskRunNotesInfo.a()) && (this.jdField_a_of_type_ComTencentMobileqqUftransferTaskTaskinfoUFTBaseTaskInfo.a().a() > this.jdField_a_of_type_ComTencentMobileqqUftransferTaskTaskinfoUFTUploadTaskRunNotesInfo.j())) {
      localUFTC2CReportData.jdField_c_of_type_Long = (this.jdField_a_of_type_ComTencentMobileqqUftransferTaskTaskinfoUFTBaseTaskInfo.a().a() - this.jdField_a_of_type_ComTencentMobileqqUftransferTaskTaskinfoUFTUploadTaskRunNotesInfo.j());
    }
    localUFTC2CReportData.jdField_d_of_type_Long = this.jdField_a_of_type_ComTencentMobileqqUftransferTaskTaskinfoUFTBaseTaskInfo.a().a();
    localUFTC2CReportData.jdField_f_of_type_Long = this.jdField_a_of_type_ComTencentMobileqqUftransferTaskTaskinfoUFTUploadTaskRunNotesInfo.k();
    localUFTC2CReportData.jdField_g_of_type_Long = this.jdField_a_of_type_ComTencentMobileqqUftransferTaskTaskinfoUFTUploadTaskRunNotesInfo.l();
    Object localObject = null;
    if (this.jdField_a_of_type_ComTencentMobileqqUftransferTaskTaskinfoUFTUploadTaskRunNotesInfo.b() > 0)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("ChangedUrlCount[");
      ((StringBuilder)localObject).append(this.jdField_a_of_type_ComTencentMobileqqUftransferTaskTaskinfoUFTUploadTaskRunNotesInfo.b());
      ((StringBuilder)localObject).append("]");
      localObject = ((StringBuilder)localObject).toString();
    }
    localUFTC2CReportData.jdField_e_of_type_JavaLangString = ((String)localObject);
    localUFTC2CReportData.c();
    localUFTC2CReportData.d();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.uftransfer.task.upload.UFTC2CUploadTask
 * JD-Core Version:    0.7.0.1
 */