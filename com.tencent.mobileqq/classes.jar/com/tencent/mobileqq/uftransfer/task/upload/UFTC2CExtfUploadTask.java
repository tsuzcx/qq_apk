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
  protected boolean c;
  protected IUFTUploadCallback d;
  protected UFTC2CUploadTask e = null;
  
  protected UFTC2CExtfUploadTask(AppRuntime paramAppRuntime, UFTTransferKey paramUFTTransferKey, UFTC2CUploadTaskInfo paramUFTC2CUploadTaskInfo, IUFTTaskCallback paramIUFTTaskCallback, IUFTUploadCallback paramIUFTUploadCallback)
  {
    super(paramAppRuntime, paramUFTTransferKey, paramUFTC2CUploadTaskInfo, paramIUFTTaskCallback, paramIUFTUploadCallback);
    this.c = paramUFTC2CUploadTaskInfo.s().a().f();
    this.d = paramIUFTUploadCallback;
  }
  
  public static UFTC2CExtfUploadTask b(AppRuntime paramAppRuntime, UFTTransferKey paramUFTTransferKey, UFTC2CUploadTaskInfo paramUFTC2CUploadTaskInfo, IUFTTaskCallback paramIUFTTaskCallback, IUFTUploadCallback paramIUFTUploadCallback)
  {
    if (a(paramAppRuntime, paramUFTTransferKey, paramUFTC2CUploadTaskInfo, paramIUFTTaskCallback, "[UFTTransfer] UFTC2CExtfUploadTask")) {
      return new UFTC2CExtfUploadTask(paramAppRuntime, paramUFTTransferKey, paramUFTC2CUploadTaskInfo, paramIUFTTaskCallback, paramIUFTUploadCallback);
    }
    return null;
  }
  
  protected UFTC2CUploadTask a(IUFTTaskCallback paramIUFTTaskCallback, IUFTUploadCallback paramIUFTUploadCallback)
  {
    return UFTC2CUploadTask.c(this.f, this.g, (UFTC2CUploadTaskInfo)this.h, paramIUFTTaskCallback, paramIUFTUploadCallback);
  }
  
  protected UFTUploadCompleteInfo a(int paramInt, UFTUploadTaskCompParam paramUFTUploadTaskCompParam)
  {
    paramUFTUploadTaskCompParam = super.a(paramInt, paramUFTUploadTaskCompParam);
    paramUFTUploadTaskCompParam.b(true);
    return paramUFTUploadTaskCompParam;
  }
  
  protected void a(int paramInt, ExcitingTransferUploadResultRp paramExcitingTransferUploadResultRp)
  {
    if (paramInt == 9037)
    {
      n();
      return;
    }
    UFTC2CUploadTaskInfo localUFTC2CUploadTaskInfo = (UFTC2CUploadTaskInfo)this.h;
    UFTC2CExtfReportData.ResultReport localResultReport = new UFTC2CExtfReportData.ResultReport(this.f);
    boolean bool2 = true;
    boolean bool1 = true;
    if (paramExcitingTransferUploadResultRp != null)
    {
      paramInt = UFTDependFeatureApi.j(paramExcitingTransferUploadResultRp.mstrServerIp);
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
        if (this.j.g() == 0L) {
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
    localResultReport.a(localUFTC2CUploadTaskInfo.n());
    paramExcitingTransferUploadResultRp = UFTDependFeatureApi.g(localUFTC2CUploadTaskInfo.o());
    localResultReport.a(Long.valueOf(localUFTC2CUploadTaskInfo.c()).longValue(), 0L, localUFTC2CUploadTaskInfo.o(), paramExcitingTransferUploadResultRp, localUFTC2CUploadTaskInfo.p());
    localResultReport.a(this.j.i());
    long l = this.j.b() - this.j.a();
    if (l > 0L) {
      localResultReport.c(l);
    } else {
      localResultReport.c(0L);
    }
    l = this.j.d() - this.j.c();
    if (l > 0L) {
      localResultReport.b(l);
    } else {
      localResultReport.b(0L);
    }
    localResultReport.b(t());
    localResultReport.c(paramInt);
    localResultReport.b(false);
    localResultReport.c(bool1);
  }
  
  protected void a(int paramInt, ExcitingTransferUploaderRp paramExcitingTransferUploaderRp)
  {
    if (paramExcitingTransferUploaderRp == null) {
      return;
    }
    UFTC2CUploadTaskInfo localUFTC2CUploadTaskInfo = (UFTC2CUploadTaskInfo)this.h;
    Object localObject = localUFTC2CUploadTaskInfo.l();
    int i;
    if ((localObject != null) && (((UFTUploadSrvBusiProp.C2CUploadSrvBusiProp)localObject).e()))
    {
      if (((UFTUploadSrvBusiProp.C2CUploadSrvBusiProp)localObject).f()) {
        i = 3;
      } else {
        i = 2;
      }
    }
    else {
      i = 1;
    }
    localObject = new UFTC2CExtfReportData.UploaderReport(this.f);
    ((UFTC2CExtfReportData.UploaderReport)localObject).a(m());
    String str = UFTDependFeatureApi.g(this.h.o());
    ((UFTC2CExtfReportData.UploaderReport)localObject).a(paramInt);
    ((UFTC2CExtfReportData.UploaderReport)localObject).a(Long.valueOf(localUFTC2CUploadTaskInfo.c()).longValue(), 0L, localUFTC2CUploadTaskInfo.o(), str, localUFTC2CUploadTaskInfo.p());
    ((UFTC2CExtfReportData.UploaderReport)localObject).a(paramExcitingTransferUploaderRp);
    ((UFTC2CExtfReportData.UploaderReport)localObject).b(i);
    ((UFTC2CExtfReportData.UploaderReport)localObject).c(UFTDependFeatureApi.j(paramExcitingTransferUploaderRp.mstrServerIp));
    boolean bool = false;
    ((UFTC2CExtfReportData.UploaderReport)localObject).a(false);
    if (paramInt == 0) {
      bool = true;
    }
    ((UFTC2CExtfReportData.UploaderReport)localObject).b(bool);
  }
  
  protected void a(long paramLong, int paramInt, UFTUploadTaskCompParam paramUFTUploadTaskCompParam)
  {
    ExcitingTransferUploaderRp localExcitingTransferUploaderRp = paramUFTUploadTaskCompParam.a();
    if (paramInt != 0)
    {
      int i = UFTTaskUtils.a(paramInt);
      if (localExcitingTransferUploaderRp != null)
      {
        paramUFTUploadTaskCompParam.m = localExcitingTransferUploaderRp.mu64HttpTime;
        paramUFTUploadTaskCompParam.n = localExcitingTransferUploaderRp.mu64TransferSpeed;
      }
      c(paramLong, i, paramUFTUploadTaskCompParam);
    }
    if (localExcitingTransferUploaderRp != null) {
      a(paramInt, localExcitingTransferUploaderRp);
    }
  }
  
  public void a(Bundle paramBundle)
  {
    if (this.e != null)
    {
      this.j.b(System.currentTimeMillis());
      this.i = true;
      c(3);
      this.e.a(paramBundle);
      this.e = null;
      return;
    }
    super.a(paramBundle);
  }
  
  protected void b()
  {
    if (this.c)
    {
      g();
      return;
    }
    super.b();
  }
  
  protected void b(int paramInt, UFTUploadTaskCompParam paramUFTUploadTaskCompParam)
  {
    if (this.i) {
      return;
    }
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("TId[");
    ((StringBuilder)localObject).append(m());
    ((StringBuilder)localObject).append("] do upload completed errCode:");
    ((StringBuilder)localObject).append(paramInt);
    ((StringBuilder)localObject).append(" errMsg:");
    ((StringBuilder)localObject).append(paramUFTUploadTaskCompParam.i);
    UFTLog.b("[UFTTransfer] UFTC2CExtfUploadTask", 1, ((StringBuilder)localObject).toString());
    f();
    localObject = this.j.s();
    if (paramInt != 0)
    {
      if ((this.h.s().a().b()) && (paramUFTUploadTaskCompParam.l))
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("TId[");
        ((StringBuilder)localObject).append(m());
        ((StringBuilder)localObject).append("] ready to do safeGuard upload");
        UFTLog.c("[UFTTransfer] UFTC2CExtfUploadTask", 1, ((StringBuilder)localObject).toString());
        c(paramInt, paramUFTUploadTaskCompParam);
        return;
      }
      this.j.b(System.currentTimeMillis());
      int i;
      if (paramUFTUploadTaskCompParam.l)
      {
        i = UFTTaskUtils.a(paramInt);
      }
      else
      {
        c(this.j.j(), paramInt, paramUFTUploadTaskCompParam);
        i = paramInt;
      }
      b(this.j.j(), i, paramUFTUploadTaskCompParam);
      a(paramInt, (ExcitingTransferUploadResultRp)localObject);
    }
    else
    {
      this.j.b(System.currentTimeMillis());
      v();
      a(0, (ExcitingTransferUploadResultRp)localObject);
    }
    this.k.a(this.g, paramInt, a(paramInt, paramUFTUploadTaskCompParam));
    b(paramInt);
  }
  
  protected void b(Bundle paramBundle)
  {
    n();
    super.b(paramBundle);
  }
  
  protected void c(int paramInt, UFTUploadTaskCompParam paramUFTUploadTaskCompParam)
  {
    a(paramInt, this.j.s());
    UFTC2CUploadTaskInfo localUFTC2CUploadTaskInfo = (UFTC2CUploadTaskInfo)this.h;
    String str = localUFTC2CUploadTaskInfo.q();
    UFTUploadSrvBusiProp.C2CUploadSrvBusiProp localC2CUploadSrvBusiProp = localUFTC2CUploadTaskInfo.l();
    boolean bool = localUFTC2CUploadTaskInfo.s().a().f();
    localUFTC2CUploadTaskInfo.b("");
    localUFTC2CUploadTaskInfo.s().a().a(false);
    localUFTC2CUploadTaskInfo.s().a().b(false);
    localUFTC2CUploadTaskInfo.s().a().f(false);
    localUFTC2CUploadTaskInfo.a(null);
    this.e = a(new UFTC2CExtfUploadTask.3(this), new UFTC2CExtfUploadTask.4(this));
    Object localObject = this.e;
    if ((localObject == null) || (!((UFTC2CUploadTask)localObject).k()))
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("TId[");
      ((StringBuilder)localObject).append(m());
      ((StringBuilder)localObject).append("] do safeGuard upload fail");
      UFTLog.d("[UFTTransfer] UFTC2CExtfUploadTask", 1, ((StringBuilder)localObject).toString());
      this.j.b(System.currentTimeMillis());
      localUFTC2CUploadTaskInfo.b(str);
      localUFTC2CUploadTaskInfo.a(localC2CUploadSrvBusiProp);
      localUFTC2CUploadTaskInfo.s().a().f(bool);
      int i = UFTTaskUtils.a(paramInt);
      b(this.j.j(), i, paramUFTUploadTaskCompParam);
      this.k.a(this.g, paramInt, a(paramInt, paramUFTUploadTaskCompParam));
      b(paramInt);
    }
  }
  
  protected boolean dy_()
  {
    this.e = null;
    return super.dy_();
  }
  
  protected void g()
  {
    if (this.l != null)
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("TId[");
      localStringBuilder.append(m());
      localStringBuilder.append("] CalcHashOp had do");
      UFTLog.d("[UFTTransfer] UFTC2CExtfUploadTask", 1, localStringBuilder.toString());
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("TId[");
    localStringBuilder.append(m());
    localStringBuilder.append("] doCalcHashOp...");
    UFTLog.b("[UFTTransfer] UFTC2CExtfUploadTask", 1, localStringBuilder.toString());
    this.k.a(this.g, 2, null);
    this.l = new UFTCalcHashOp(this.f, this.h, this.g, i(), 31L, new UFTC2CExtfUploadTask.1(this));
    int i = this.l.e();
    if (i != 0) {
      a(i);
    }
  }
  
  protected void h()
  {
    if (this.n != null)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("TId[");
      ((StringBuilder)localObject).append(m());
      ((StringBuilder)localObject).append("] UploadFileOp had do");
      UFTLog.d("[UFTTransfer] UFTC2CExtfUploadTask", 1, ((StringBuilder)localObject).toString());
      return;
    }
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("TId[");
    ((StringBuilder)localObject).append(m());
    ((StringBuilder)localObject).append("] doUploadFileOp...");
    UFTLog.b("[UFTTransfer] UFTC2CExtfUploadTask", 1, ((StringBuilder)localObject).toString());
    this.j.g(System.currentTimeMillis());
    this.k.a(this.g, 4, null);
    this.n = new UFTC2CExtfUploadFileOp(this.f, (UFTC2CUploadTaskInfo)this.h, this.g, new UFTC2CExtfUploadTask.2(this));
    int i = this.n.e();
    if (i != 0)
    {
      localObject = new UFTBaseUploadFileOp.UploadFileOpRetData();
      ((UFTBaseUploadFileOp.UploadFileOpRetData)localObject).a(i);
      ((UFTBaseUploadFileOp.UploadFileOpRetData)localObject).a(this.n.h());
      a((UFTBaseUploadFileOp.UploadFileOpRetData)localObject);
      return;
    }
    this.j.a(this.n.m());
  }
  
  protected int j()
  {
    return 1;
  }
  
  protected void n()
  {
    Object localObject = (UFTC2CUploadTaskInfo)this.h;
    UFTC2CExtfReportData.ResultReport localResultReport = new UFTC2CExtfReportData.ResultReport(this.f);
    localResultReport.a(33);
    localResultReport.a(((UFTC2CUploadTaskInfo)localObject).n());
    String str = UFTDependFeatureApi.g(((UFTC2CUploadTaskInfo)localObject).o());
    localResultReport.a(Long.valueOf(((UFTC2CUploadTaskInfo)localObject).c()).longValue(), 0L, ((UFTC2CUploadTaskInfo)localObject).o(), str, ((UFTC2CUploadTaskInfo)localObject).p());
    localResultReport.a(this.j.i());
    long l = this.j.b() - this.j.a();
    if (l > 0L) {
      localResultReport.c(l);
    } else {
      localResultReport.c(0L);
    }
    l = this.j.d() - this.j.c();
    if (l > 0L) {
      localResultReport.b(l);
    } else {
      localResultReport.b(0L);
    }
    localObject = new ExcitingTransferUploadResultRp();
    ((ExcitingTransferUploadResultRp)localObject).mbIsXTFValid = true;
    ((ExcitingTransferUploadResultRp)localObject).mnResult = 33;
    localResultReport.a((ExcitingTransferUploadResultRp)localObject);
    localResultReport.b(t());
    localResultReport.b(false);
    localResultReport.c(false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.uftransfer.task.upload.UFTC2CExtfUploadTask
 * JD-Core Version:    0.7.0.1
 */