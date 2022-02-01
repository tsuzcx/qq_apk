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
  protected UFTDiscFetchUploadUrlOp b;
  protected UFTDiscUploadFileOp c;
  
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
  
  protected void a(int paramInt)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("TId[");
    localStringBuilder.append(m());
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
    this.k.a(this.g, this.h.r());
    d();
  }
  
  protected void a(int paramInt, Bundle paramBundle)
  {
    int i;
    if ((paramInt != 1) && (paramInt != 2)) {
      i = 0;
    } else {
      i = 1;
    }
    g();
    super.a(paramBundle);
    if (i != 0)
    {
      paramBundle = c(9004, "net changed");
      paramBundle.b(paramInt);
      this.k.a(this.g, 9004, paramBundle);
      return;
    }
    this.k.a(true);
  }
  
  protected void a(int paramInt, String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("TId[");
    localStringBuilder.append(m());
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
    paramString.a(this.h.q());
    this.k.a(this.g, paramString);
    e();
  }
  
  protected void a(int paramInt, String paramString1, String paramString2)
  {
    if (this.i) {
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("TId[");
    localStringBuilder.append(m());
    localStringBuilder.append("] do upload completed errCode:");
    localStringBuilder.append(paramInt);
    localStringBuilder.append(" errMsg:");
    localStringBuilder.append(paramString1);
    UFTLog.b("[UFTTransfer] UFTDiscUploadTask", 1, localStringBuilder.toString());
    g();
    this.j.b(System.currentTimeMillis());
    if (paramInt != 0)
    {
      b(this.j.j(), paramInt, paramString1, paramString2);
      a(this.j.j(), paramInt, paramString1, paramString2);
    }
    else
    {
      a(paramString2);
    }
    this.k.a(this.g, paramInt, c(paramInt, paramString1));
    b(paramInt);
  }
  
  protected void a(int paramInt, boolean paramBoolean, String paramString1, String paramString2)
  {
    this.j.h(System.currentTimeMillis());
    this.j.a(paramBoolean);
    this.j.b(paramString2);
    if (this.c != null)
    {
      this.j.a(this.c.m());
      this.j.j(this.c.j());
      this.j.a(this.c.l());
      this.j.k(this.c.b());
      this.j.l(this.c.d());
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("TId[");
    localStringBuilder.append(m());
    localStringBuilder.append("] on upload file op done. errCode:");
    localStringBuilder.append(paramInt);
    localStringBuilder.append(" flash:");
    localStringBuilder.append(this.j.i());
    localStringBuilder.append(" speed:");
    localStringBuilder.append(this.j.u());
    localStringBuilder.append(" httpTime:");
    localStringBuilder.append(this.j.t());
    localStringBuilder.append(" url:");
    localStringBuilder.append(this.j.m());
    localStringBuilder.append(" upStartSize:");
    localStringBuilder.append(this.j.k());
    localStringBuilder.append(" upEndSize:");
    localStringBuilder.append(this.j.j());
    UFTLog.b("[UFTTransfer] UFTDiscUploadTask", 1, localStringBuilder.toString());
    if (paramInt != 0)
    {
      a(paramInt, paramString1, paramString2);
      return;
    }
    this.j.i(this.h.p());
    if (((UFTDiscUploadTaskInfo)this.h).d())
    {
      f();
      return;
    }
    a(0, "", null);
  }
  
  protected void a(long paramLong, int paramInt, String paramString1, String paramString2)
  {
    UFTDiscReportData localUFTDiscReportData = h();
    localUFTDiscReportData.a = paramInt;
    localUFTDiscReportData.b = paramString1;
    localUFTDiscReportData.m = paramLong;
    localUFTDiscReportData.q = paramString2;
    localUFTDiscReportData.b();
  }
  
  public void a(Bundle paramBundle)
  {
    if (this.j.g() > 0L) {
      this.j.h(System.currentTimeMillis());
    }
    if (this.c != null)
    {
      this.j.i(this.c.k());
      this.j.k(this.c.b());
      this.j.l(this.c.d());
    }
    int i = 0;
    if (paramBundle != null) {
      i = paramBundle.getInt("REASON");
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("TId[");
    localStringBuilder.append(m());
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
    UFTDiscReportData localUFTDiscReportData = h();
    localUFTDiscReportData.a = 0L;
    localUFTDiscReportData.b = "";
    localUFTDiscReportData.m = this.h.p();
    localUFTDiscReportData.q = paramString;
    localUFTDiscReportData.b();
  }
  
  protected void b()
  {
    c();
  }
  
  protected void b(int paramInt, String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("TId[");
    localStringBuilder.append(m());
    localStringBuilder.append("] on send msg op done errCode:");
    localStringBuilder.append(paramInt);
    localStringBuilder.append(" errMsg:");
    localStringBuilder.append(paramString);
    UFTLog.b("[UFTTransfer] UFTDiscUploadTask", 1, localStringBuilder.toString());
    a(paramInt, paramString, null);
  }
  
  protected void b(long paramLong, int paramInt, String paramString1, String paramString2)
  {
    UFTDiscReportData localUFTDiscReportData = h();
    localUFTDiscReportData.a = paramInt;
    localUFTDiscReportData.b = paramString1;
    localUFTDiscReportData.m = paramLong;
    localUFTDiscReportData.q = paramString2;
    localUFTDiscReportData.a();
  }
  
  protected void b(Bundle paramBundle)
  {
    this.k.a(true);
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("userCancel");
    ((StringBuilder)localObject).append(System.currentTimeMillis());
    localObject = ((StringBuilder)localObject).toString();
    long l = this.j.j();
    UFTDiscUploadFileOp localUFTDiscUploadFileOp = this.c;
    if (localUFTDiscUploadFileOp != null) {
      l = localUFTDiscUploadFileOp.k();
    }
    b(l, 9037, (String)localObject, null);
    a(l, 9037, (String)localObject, null);
    g();
    super.a(paramBundle);
  }
  
  protected UFTUploadCompleteInfo c(int paramInt, String paramString)
  {
    paramString = new UFTUploadCompleteInfo();
    UFTDiscUploadTaskInfo localUFTDiscUploadTaskInfo = (UFTDiscUploadTaskInfo)this.h;
    paramString.a(this.j.i());
    paramString.a(localUFTDiscUploadTaskInfo.q());
    paramString.c(this.j.m());
    if ((!TextUtils.isEmpty(localUFTDiscUploadTaskInfo.e())) && (!UFTProtoRequestor.a(paramInt))) {
      paramString.b(localUFTDiscUploadTaskInfo.e());
    }
    return paramString;
  }
  
  protected void c()
  {
    if (this.a != null)
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("TId[");
      localStringBuilder.append(m());
      localStringBuilder.append("] calc hash op had do");
      UFTLog.d("[UFTTransfer] UFTDiscUploadTask", 1, localStringBuilder.toString());
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("TId[");
    localStringBuilder.append(m());
    localStringBuilder.append("] do calc hash op ...");
    UFTLog.b("[UFTTransfer] UFTDiscUploadTask", 1, localStringBuilder.toString());
    this.k.a(this.g, 2, null);
    this.a = new UFTCalcHashOp(this.f, this.h, this.g, i(), 25L, new UFTDiscUploadTask.2(this));
    int i = this.a.e();
    if (i != 0) {
      a(i);
    }
  }
  
  protected void d()
  {
    if (this.b != null)
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("TId[");
      localStringBuilder.append(m());
      localStringBuilder.append("] fetch url op had do");
      UFTLog.d("[UFTTransfer] UFTDiscUploadTask", 1, localStringBuilder.toString());
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("TId[");
    localStringBuilder.append(m());
    localStringBuilder.append("] do fetch url op ...");
    UFTLog.b("[UFTTransfer] UFTDiscUploadTask", 1, localStringBuilder.toString());
    this.k.a(this.g, 3, null);
    this.b = new UFTDiscFetchUploadUrlOp(this.f, (UFTDiscUploadTaskInfo)this.h, this.g, new UFTDiscUploadTask.3(this));
    int i = this.b.e();
    if (i != 0) {
      a(i, this.b.h());
    }
  }
  
  public boolean dy_()
  {
    this.j.v();
    this.k.a(false);
    this.j.a(System.currentTimeMillis());
    this.k.a(this.g);
    UFTLogicThread.a().a(new UFTDiscUploadTask.1(this));
    return true;
  }
  
  protected void e()
  {
    if (this.c != null)
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("TId[");
      localStringBuilder.append(m());
      localStringBuilder.append("] upload file had do");
      UFTLog.d("[UFTTransfer] UFTDiscUploadTask", 1, localStringBuilder.toString());
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("TId[");
    localStringBuilder.append(m());
    localStringBuilder.append("] do upload file op ...");
    UFTLog.b("[UFTTransfer] UFTDiscUploadTask", 1, localStringBuilder.toString());
    this.j.g(System.currentTimeMillis());
    this.k.a(this.g, 4, null);
    this.c = new UFTDiscUploadFileOp(this.f, (UFTDiscUploadTaskInfo)this.h, this.g, new UFTDiscUploadTask.4(this));
    int i = this.c.e();
    if (i != 0)
    {
      a(i, false, this.c.h(), null);
      return;
    }
    this.j.a(this.c.m());
  }
  
  protected void f()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("TId[");
    localStringBuilder.append(m());
    localStringBuilder.append("] do send msg op ...");
    UFTLog.b("[UFTTransfer] UFTDiscUploadTask", 1, localStringBuilder.toString());
    this.k.a(this.g, 6, null);
    if (this.k.a(this.g, null, new UFTDiscUploadTask.5(this)) != 0) {
      b(90460, "send msg fail");
    }
  }
  
  protected void g()
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("TId[");
    ((StringBuilder)localObject).append(m());
    ((StringBuilder)localObject).append("] cancel all Op...");
    UFTLog.c("[UFTTransfer] UFTDiscUploadTask", 1, ((StringBuilder)localObject).toString());
    localObject = this.a;
    if (localObject != null)
    {
      ((UFTCalcHashOp)localObject).f();
      this.a = null;
    }
    localObject = this.b;
    if (localObject != null)
    {
      ((UFTDiscFetchUploadUrlOp)localObject).f();
      this.b = null;
    }
    localObject = this.c;
    if (localObject != null)
    {
      ((UFTDiscUploadFileOp)localObject).f();
      this.c = null;
    }
  }
  
  protected UFTDiscReportData h()
  {
    Object localObject = (UFTDiscUploadTaskInfo)this.h;
    UFTDiscReportData localUFTDiscReportData = new UFTDiscReportData(this.f, this.f.getCurrentUin());
    localUFTDiscReportData.i = this.j.m();
    localUFTDiscReportData.j = ((UFTDiscUploadTaskInfo)localObject).c();
    localUFTDiscReportData.k = 3000;
    localUFTDiscReportData.l = ((UFTDiscUploadTaskInfo)localObject).q();
    localUFTDiscReportData.o = ((UFTDiscUploadTaskInfo)localObject).p();
    localObject = this.c;
    int i;
    if (localObject != null) {
      i = ((UFTDiscUploadFileOp)localObject).l();
    } else {
      i = 0;
    }
    localUFTDiscReportData.p = i;
    localUFTDiscReportData.c = this.g.b();
    localUFTDiscReportData.e = this.j.e();
    localUFTDiscReportData.e = this.j.f();
    localUFTDiscReportData.f = this.j.g();
    localUFTDiscReportData.g = this.j.h();
    return localUFTDiscReportData;
  }
  
  public String i()
  {
    return ((UFTDiscUploadTaskInfo)this.h).a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.uftransfer.task.upload.UFTDiscUploadTask
 * JD-Core Version:    0.7.0.1
 */