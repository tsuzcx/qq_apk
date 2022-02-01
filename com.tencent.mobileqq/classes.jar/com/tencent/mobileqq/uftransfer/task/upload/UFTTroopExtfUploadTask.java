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
  protected UFTTroopUploadTask b = null;
  
  protected UFTTroopExtfUploadTask(AppRuntime paramAppRuntime, UFTTransferKey paramUFTTransferKey, UFTTroopUploadTaskInfo paramUFTTroopUploadTaskInfo, IUFTTaskCallback paramIUFTTaskCallback, IUFTUploadCallback paramIUFTUploadCallback)
  {
    super(paramAppRuntime, paramUFTTransferKey, paramUFTTroopUploadTaskInfo, paramIUFTTaskCallback, paramIUFTUploadCallback);
    this.a = paramIUFTUploadCallback;
  }
  
  public static UFTTroopExtfUploadTask a(AppRuntime paramAppRuntime, UFTTransferKey paramUFTTransferKey, UFTTroopUploadTaskInfo paramUFTTroopUploadTaskInfo, IUFTTaskCallback paramIUFTTaskCallback, IUFTUploadCallback paramIUFTUploadCallback)
  {
    if (a(paramAppRuntime, paramUFTTransferKey, paramUFTTroopUploadTaskInfo, paramIUFTTaskCallback, "[UFTTransfer] UFTTroopExtfUploadTask")) {
      return new UFTTroopExtfUploadTask(paramAppRuntime, paramUFTTransferKey, paramUFTTroopUploadTaskInfo, paramIUFTTaskCallback, paramIUFTUploadCallback);
    }
    return null;
  }
  
  protected void a(int paramInt, Bundle paramBundle)
  {
    f();
    super.a(paramInt, paramBundle);
  }
  
  protected void a(int paramInt, ExcitingTransferUploadResultRp paramExcitingTransferUploadResultRp)
  {
    UFTTroopExtfReportData.ResultReport localResultReport = e();
    localResultReport.a(paramInt);
    boolean bool = true;
    int i = 0;
    if (paramExcitingTransferUploadResultRp != null)
    {
      if (paramExcitingTransferUploadResultRp.mnResult != 0L) {
        bool = false;
      }
      localResultReport.a(paramExcitingTransferUploadResultRp);
      paramInt = UFTDependFeatureApi.j(paramExcitingTransferUploadResultRp.mstrServerIp);
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
      if (this.j.g() > 0L) {
        paramExcitingTransferUploadResultRp.mu64HttpTime = (System.currentTimeMillis() - this.j.g());
      }
      if (this.j.k() > 0L) {
        paramExcitingTransferUploadResultRp.mu64StartSize = this.j.k();
      }
      if (this.j.j() > 0L) {
        paramExcitingTransferUploadResultRp.mu64TransferSize = this.j.j();
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
    localResultReport.b(bool);
  }
  
  protected void a(int paramInt, ExcitingTransferUploaderRp paramExcitingTransferUploaderRp)
  {
    if (paramExcitingTransferUploaderRp == null) {
      return;
    }
    UFTTroopUploadTaskInfo localUFTTroopUploadTaskInfo = (UFTTroopUploadTaskInfo)this.h;
    UFTTroopExtfReportData.UpladerReport localUpladerReport = new UFTTroopExtfReportData.UpladerReport(this.f);
    localUpladerReport.a(this.h.n());
    String str = UFTDependFeatureApi.g(localUFTTroopUploadTaskInfo.b());
    localUpladerReport.a(paramInt);
    long l = Long.valueOf(localUFTTroopUploadTaskInfo.a()).longValue();
    localUpladerReport.a(l, l, localUFTTroopUploadTaskInfo.o(), str, localUFTTroopUploadTaskInfo.p());
    localUpladerReport.a(paramExcitingTransferUploaderRp);
    localUpladerReport.b(n());
    localUpladerReport.c(UFTDependFeatureApi.j(paramExcitingTransferUploaderRp.mstrServerIp));
    localUpladerReport.c(o());
    boolean bool;
    if (paramInt == 0) {
      bool = true;
    } else {
      bool = false;
    }
    localUpladerReport.b(bool);
  }
  
  protected void a(int paramInt, UFTTroopUploadTask.UFTToopUploadTaskCompParam paramUFTToopUploadTaskCompParam)
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
    ((StringBuilder)localObject).append(paramUFTToopUploadTaskCompParam.i);
    UFTLog.b("[UFTTransfer] UFTTroopExtfUploadTask", 1, ((StringBuilder)localObject).toString());
    j();
    localObject = this.j.s();
    if (paramInt != 0)
    {
      if ((this.h.s().a().b()) && (paramUFTToopUploadTaskCompParam.l))
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("TId[");
        ((StringBuilder)localObject).append(m());
        ((StringBuilder)localObject).append("] ready to do safeGuard upload...");
        UFTLog.c("[UFTTransfer] UFTTroopExtfUploadTask", 1, ((StringBuilder)localObject).toString());
        b(paramInt, paramUFTToopUploadTaskCompParam);
        return;
      }
      this.j.b(System.currentTimeMillis());
      if (!paramUFTToopUploadTaskCompParam.l) {
        b(this.j.j(), paramUFTToopUploadTaskCompParam);
      }
      b(paramUFTToopUploadTaskCompParam);
      int j = paramUFTToopUploadTaskCompParam.g;
      int i;
      if (paramUFTToopUploadTaskCompParam.l)
      {
        i = j;
        if (j != 0) {}
      }
      else
      {
        i = UFTTaskUtils.f(paramUFTToopUploadTaskCompParam.b);
      }
      if ((paramUFTToopUploadTaskCompParam.a != 8) && (paramUFTToopUploadTaskCompParam.a != 11) && (paramUFTToopUploadTaskCompParam.a != 12)) {
        a(i, (ExcitingTransferUploadResultRp)localObject);
      } else {
        f();
      }
    }
    else
    {
      this.j.b(System.currentTimeMillis());
      p();
      a(0, (ExcitingTransferUploadResultRp)localObject);
    }
    this.k.a(this.g, paramInt, a(paramUFTToopUploadTaskCompParam));
    b(paramInt);
  }
  
  protected void a(long paramLong, UFTTroopUploadTask.UFTToopUploadTaskCompParam paramUFTToopUploadTaskCompParam)
  {
    ExcitingTransferUploaderRp localExcitingTransferUploaderRp = paramUFTToopUploadTaskCompParam.a();
    if (paramUFTToopUploadTaskCompParam.a != 0)
    {
      if (localExcitingTransferUploaderRp != null)
      {
        paramUFTToopUploadTaskCompParam.m = localExcitingTransferUploaderRp.mu64HttpTime;
        paramUFTToopUploadTaskCompParam.n = localExcitingTransferUploaderRp.mu64TransferSpeed;
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
    if (this.b != null)
    {
      this.j.b(System.currentTimeMillis());
      this.i = true;
      c(3);
      this.b.a(paramBundle);
      this.b = null;
      return;
    }
    super.a(paramBundle);
  }
  
  protected void a(UFTBaseUploadFileOp.UploadFileOpRetData paramUploadFileOpRetData)
  {
    int i = paramUploadFileOpRetData.a();
    UFTTroopUploadTask.UFTToopUploadTaskCompParam localUFTToopUploadTaskCompParam = b(4, paramUploadFileOpRetData.b());
    localUFTToopUploadTaskCompParam.l = paramUploadFileOpRetData.h();
    if ((i != 3) && (i != 4))
    {
      int j = UFTTaskUtils.b(i);
      int k = UFTTaskUtils.c(i);
      int m = UFTTaskUtils.d(i);
      localUFTToopUploadTaskCompParam.a(j, k, 3, UFTTaskUtils.e(i));
      Object localObject2 = null;
      Object localObject1 = localObject2;
      if (paramUploadFileOpRetData.f() != null)
      {
        localObject1 = localObject2;
        if ((paramUploadFileOpRetData.f() instanceof ExcitingTransferUploadResultRp)) {
          localObject1 = (ExcitingTransferUploadResultRp)paramUploadFileOpRetData.f();
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
    this.c = false;
    g();
  }
  
  protected void b(int paramInt, UFTTroopUploadTask.UFTToopUploadTaskCompParam paramUFTToopUploadTaskCompParam)
  {
    Object localObject1 = this.j.s();
    a(paramUFTToopUploadTaskCompParam.g, (ExcitingTransferUploadResultRp)localObject1);
    localObject1 = (UFTTroopUploadTaskInfo)this.h;
    String str = ((UFTTroopUploadTaskInfo)localObject1).q();
    UFTUploadSrvBusiProp.TroopUploadSrvBusiProp localTroopUploadSrvBusiProp = ((UFTTroopUploadTaskInfo)localObject1).l();
    ((UFTTroopUploadTaskInfo)localObject1).b("");
    ((UFTTroopUploadTaskInfo)localObject1).s().a().a(false);
    ((UFTTroopUploadTaskInfo)localObject1).s().a().b(false);
    ((UFTTroopUploadTaskInfo)localObject1).a(null);
    Object localObject2 = new UFTTroopExtfUploadTask.2(this);
    UFTTroopExtfUploadTask.3 local3 = new UFTTroopExtfUploadTask.3(this);
    this.b = UFTTroopUploadTask.b(this.f, this.g, (UFTTroopUploadTaskInfo)localObject1, (IUFTTaskCallback)localObject2, local3);
    localObject2 = this.b;
    if ((localObject2 == null) || (!((UFTTroopUploadTask)localObject2).k()))
    {
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("TId[");
      ((StringBuilder)localObject2).append(m());
      ((StringBuilder)localObject2).append("] do safeGuard upload fail");
      UFTLog.d("[UFTTransfer] UFTTroopExtfUploadTask", 1, ((StringBuilder)localObject2).toString());
      this.j.b(System.currentTimeMillis());
      ((UFTTroopUploadTaskInfo)localObject1).b(str);
      ((UFTTroopUploadTaskInfo)localObject1).a(localTroopUploadSrvBusiProp);
      b(paramUFTToopUploadTaskCompParam);
      this.k.a(this.g, paramInt, a(paramUFTToopUploadTaskCompParam));
      b(paramInt);
    }
  }
  
  protected void b(Bundle paramBundle)
  {
    f();
    super.b(paramBundle);
  }
  
  protected void c()
  {
    if (this.l != null)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("TId[");
      ((StringBuilder)localObject).append(m());
      ((StringBuilder)localObject).append("] UploadFileOp had do");
      UFTLog.d("[UFTTransfer] UFTTroopExtfUploadTask", 1, ((StringBuilder)localObject).toString());
      return;
    }
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("TId[");
    ((StringBuilder)localObject).append(m());
    ((StringBuilder)localObject).append("] doUploadFileOp...");
    UFTLog.b("[UFTTransfer] UFTTroopExtfUploadTask", 1, ((StringBuilder)localObject).toString());
    this.j.g(System.currentTimeMillis());
    this.k.a(this.g, 4, null);
    this.l = new UFTTroopExtfUploadFileOp(this.f, (UFTTroopUploadTaskInfo)this.h, this.g, new UFTTroopExtfUploadTask.1(this));
    int i = this.l.e();
    if (i != 0)
    {
      localObject = new UFTBaseUploadFileOp.UploadFileOpRetData();
      ((UFTBaseUploadFileOp.UploadFileOpRetData)localObject).a(i);
      ((UFTBaseUploadFileOp.UploadFileOpRetData)localObject).a("start upload file op fail");
      b((UFTBaseUploadFileOp.UploadFileOpRetData)localObject);
      return;
    }
    this.j.a(this.l.m());
  }
  
  protected int d()
  {
    return 1;
  }
  
  protected boolean dy_()
  {
    this.b = null;
    return super.dy_();
  }
  
  protected UFTTroopExtfReportData.ResultReport e()
  {
    UFTTroopUploadTaskInfo localUFTTroopUploadTaskInfo = (UFTTroopUploadTaskInfo)this.h;
    UFTTroopExtfReportData.ResultReport localResultReport = new UFTTroopExtfReportData.ResultReport(this.f);
    localResultReport.a(this.h.n());
    String str = UFTDependFeatureApi.g(localUFTTroopUploadTaskInfo.b());
    long l = Long.valueOf(localUFTTroopUploadTaskInfo.a()).longValue();
    localResultReport.a(l, l, localUFTTroopUploadTaskInfo.o(), str, localUFTTroopUploadTaskInfo.p());
    localResultReport.b(n());
    localResultReport.d(o());
    localResultReport.c(this.j.i());
    l = System.currentTimeMillis() - this.j.a();
    if (l > 0L) {
      localResultReport.c(l);
    } else {
      localResultReport.c(0L);
    }
    l = this.j.d() - this.j.c();
    if (l > 0L)
    {
      localResultReport.b(l);
      return localResultReport;
    }
    localResultReport.b(0L);
    return localResultReport;
  }
  
  protected void f()
  {
    UFTTroopExtfReportData.ResultReport localResultReport = e();
    localResultReport.a(33);
    ExcitingTransferUploadResultRp localExcitingTransferUploadResultRp = new ExcitingTransferUploadResultRp();
    if (this.j.g() > 0L) {
      localExcitingTransferUploadResultRp.mu64HttpTime = (System.currentTimeMillis() - this.j.g());
    }
    if (this.j.k() > 0L) {
      localExcitingTransferUploadResultRp.mu64StartSize = this.j.k();
    }
    if (this.j.j() > 0L) {
      localExcitingTransferUploadResultRp.mu64TransferSize = this.j.j();
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
    localResultReport.b(false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.uftransfer.task.upload.UFTTroopExtfUploadTask
 * JD-Core Version:    0.7.0.1
 */