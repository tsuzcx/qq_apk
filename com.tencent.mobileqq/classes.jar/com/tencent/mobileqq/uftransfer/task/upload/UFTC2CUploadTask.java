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
  protected UFTCalcHashOp l;
  protected UFTC2CFetchUploadUrlOp m;
  protected UFTC2CUploadFileOp n;
  protected UFTC2CSetUploadSucOp o;
  
  protected UFTC2CUploadTask(AppRuntime paramAppRuntime, UFTTransferKey paramUFTTransferKey, UFTC2CUploadTaskInfo paramUFTC2CUploadTaskInfo, IUFTTaskCallback paramIUFTTaskCallback, IUFTUploadCallback paramIUFTUploadCallback)
  {
    super(paramAppRuntime, paramUFTTransferKey, paramUFTC2CUploadTaskInfo, paramIUFTTaskCallback, paramIUFTUploadCallback);
  }
  
  public static UFTC2CUploadTask c(AppRuntime paramAppRuntime, UFTTransferKey paramUFTTransferKey, UFTC2CUploadTaskInfo paramUFTC2CUploadTaskInfo, IUFTTaskCallback paramIUFTTaskCallback, IUFTUploadCallback paramIUFTUploadCallback)
  {
    if (a(paramAppRuntime, paramUFTTransferKey, paramUFTC2CUploadTaskInfo, paramIUFTTaskCallback, "[UFTTransfer] UFTC2CUploadTask")) {
      return new UFTC2CUploadTask(paramAppRuntime, paramUFTTransferKey, paramUFTC2CUploadTaskInfo, paramIUFTTaskCallback, paramIUFTUploadCallback);
    }
    return null;
  }
  
  protected UFTUploadCompleteInfo a(int paramInt, UFTUploadTaskCompParam paramUFTUploadTaskCompParam)
  {
    UFTUploadCompleteInfo localUFTUploadCompleteInfo = new UFTUploadCompleteInfo();
    UFTC2CUploadTaskInfo localUFTC2CUploadTaskInfo = (UFTC2CUploadTaskInfo)this.h;
    localUFTUploadCompleteInfo.a(this.j.i());
    localUFTUploadCompleteInfo.a(localUFTC2CUploadTaskInfo.q());
    localUFTUploadCompleteInfo.d(localUFTC2CUploadTaskInfo.g());
    localUFTUploadCompleteInfo.c(this.j.m());
    if ((!TextUtils.isEmpty(localUFTC2CUploadTaskInfo.j())) && (!UFTProtoRequestor.a(paramInt))) {
      localUFTUploadCompleteInfo.b(localUFTC2CUploadTaskInfo.j());
    }
    localUFTUploadCompleteInfo.a(paramUFTUploadTaskCompParam.h);
    return localUFTUploadCompleteInfo;
  }
  
  protected void a(int paramInt)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("TId[");
    localStringBuilder.append(m());
    localStringBuilder.append("] on calc hash op done retCode:");
    localStringBuilder.append(paramInt);
    UFTLog.b("[UFTTransfer] UFTC2CUploadTask", 1, localStringBuilder.toString());
    this.j.d(System.currentTimeMillis());
    if (paramInt != 0)
    {
      int i = 9041;
      if (paramInt == 1) {
        i = 9042;
      }
      b(i, c(2, "get md5 failed"));
      return;
    }
    this.k.a(this.g, this.h.r());
    c();
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
    f();
    super.a(paramBundle);
    if (i != 0)
    {
      paramBundle = a(9004, c(7, (String)localObject));
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
    UFTLog.b("[UFTTransfer] UFTC2CUploadTask", 1, localStringBuilder.toString());
    this.j.f(System.currentTimeMillis());
    if (paramInt != 0)
    {
      b(paramInt, c(3, paramString));
      return;
    }
    p();
    if (((UFTC2CUploadTaskInfo)this.h).i())
    {
      q();
      return;
    }
    h();
  }
  
  protected void a(int paramInt1, String paramString, int paramInt2, long paramLong)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("TId[");
    localStringBuilder.append(m());
    localStringBuilder.append("] on send msg op done. errCode:");
    localStringBuilder.append(paramInt1);
    localStringBuilder.append(" errMsg:");
    localStringBuilder.append(paramString);
    localStringBuilder.append(" seq:");
    localStringBuilder.append(paramInt2);
    localStringBuilder.append(" uniSeq:");
    localStringBuilder.append(paramLong);
    UFTLog.b("[UFTTransfer] UFTC2CUploadTask", 1, localStringBuilder.toString());
    b(paramInt1, c(6, paramString));
  }
  
  public void a(Bundle paramBundle)
  {
    if (this.j.g() > 0L) {
      this.j.h(System.currentTimeMillis());
    }
    if (this.n != null)
    {
      this.j.i(this.n.k());
      this.j.k(this.n.b());
      this.j.l(this.n.d());
    }
    int i = 0;
    if (paramBundle != null) {
      i = paramBundle.getInt("REASON");
    }
    this.j.b(System.currentTimeMillis());
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("TId[");
    localStringBuilder.append(m());
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
    this.j.h(System.currentTimeMillis());
    this.j.a(paramUploadFileOpRetData.d());
    this.j.b(paramUploadFileOpRetData.e());
    this.j.a(paramUploadFileOpRetData.f());
    if (this.n != null)
    {
      this.j.a(this.n.m());
      this.j.j(this.n.j());
      this.j.i(this.n.k());
      this.j.a(this.n.l());
      this.j.k(this.n.b());
      this.j.l(this.n.d());
    }
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("TId[");
    ((StringBuilder)localObject).append(m());
    ((StringBuilder)localObject).append("] on upload file op done. errCode:");
    ((StringBuilder)localObject).append(paramUploadFileOpRetData.a());
    ((StringBuilder)localObject).append(" flash:");
    ((StringBuilder)localObject).append(this.j.i());
    ((StringBuilder)localObject).append(" speed:");
    ((StringBuilder)localObject).append(this.j.u());
    ((StringBuilder)localObject).append(" httpTime:");
    ((StringBuilder)localObject).append(this.j.t());
    ((StringBuilder)localObject).append(" url:");
    ((StringBuilder)localObject).append(this.j.m());
    ((StringBuilder)localObject).append(" upStartSize:");
    ((StringBuilder)localObject).append(this.j.k());
    ((StringBuilder)localObject).append(" upEndSize:");
    ((StringBuilder)localObject).append(this.j.j());
    UFTLog.b("[UFTTransfer] UFTC2CUploadTask", 1, ((StringBuilder)localObject).toString());
    if (paramUploadFileOpRetData.a() != 0)
    {
      localObject = c(4, paramUploadFileOpRetData.b());
      ((UFTUploadTaskCompParam)localObject).l = paramUploadFileOpRetData.h();
      b(paramUploadFileOpRetData.a(), (UFTUploadTaskCompParam)localObject);
      return;
    }
    this.j.i(this.h.p());
    r();
  }
  
  protected UFTC2CReportData b(boolean paramBoolean)
  {
    UFTC2CUploadTaskInfo localUFTC2CUploadTaskInfo = (UFTC2CUploadTaskInfo)this.h;
    UFTC2CReportData localUFTC2CReportData = new UFTC2CReportData(this.f, m(), localUFTC2CUploadTaskInfo.c(), localUFTC2CUploadTaskInfo.p(), j());
    localUFTC2CReportData.g = UFTDependFeatureApi.b(this.h.r().b());
    localUFTC2CReportData.f = localUFTC2CUploadTaskInfo.q();
    localUFTC2CReportData.k = this.j.l();
    localUFTC2CReportData.m = this.j.a();
    localUFTC2CReportData.q = UFTDependFeatureApi.i(this.j.m());
    localUFTC2CReportData.r = u();
    localUFTC2CReportData.p = t();
    localUFTC2CReportData.h = this.j.m();
    localUFTC2CReportData.w = this.j.m();
    localUFTC2CReportData.i = 1L;
    if (this.j.j() > this.j.k()) {
      localUFTC2CReportData.i = (this.j.j() - this.j.k());
    }
    return localUFTC2CReportData;
  }
  
  protected void b()
  {
    if (this.l != null)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("TId[");
      ((StringBuilder)localObject).append(m());
      ((StringBuilder)localObject).append("] calc hash op had do");
      UFTLog.d("[UFTTransfer] UFTC2CUploadTask", 1, ((StringBuilder)localObject).toString());
      return;
    }
    Object localObject = this.h.r().e();
    byte[] arrayOfByte = this.h.r().b();
    if ((localObject != null) && (localObject.length > 0) && (arrayOfByte != null) && (arrayOfByte.length > 0))
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("TId[");
      ((StringBuilder)localObject).append(m());
      ((StringBuilder)localObject).append("] file hash exist and calc hash done");
      UFTLog.b("[UFTTransfer] UFTC2CUploadTask", 1, ((StringBuilder)localObject).toString());
      a(0);
      return;
    }
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("TId[");
    ((StringBuilder)localObject).append(m());
    ((StringBuilder)localObject).append("] do calc hash op ...");
    UFTLog.b("[UFTTransfer] UFTC2CUploadTask", 1, ((StringBuilder)localObject).toString());
    this.j.c(System.currentTimeMillis());
    this.k.a(this.g, 2, null);
    this.l = new UFTCalcHashOp(this.f, this.h, this.g, i(), 25L, new UFTC2CUploadTask.2(this));
    int i = this.l.e();
    if (i != 0) {
      a(i);
    }
  }
  
  protected void b(int paramInt, UFTUploadTaskCompParam paramUFTUploadTaskCompParam)
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
    localStringBuilder.append(paramUFTUploadTaskCompParam.i);
    UFTLog.b("[UFTTransfer] UFTC2CUploadTask", 1, localStringBuilder.toString());
    f();
    this.j.b(System.currentTimeMillis());
    if (paramInt != 0)
    {
      c(this.j.j(), paramInt, paramUFTUploadTaskCompParam);
      b(this.j.j(), paramInt, paramUFTUploadTaskCompParam);
    }
    else
    {
      v();
    }
    this.k.a(this.g, paramInt, a(paramInt, paramUFTUploadTaskCompParam));
    b(paramInt);
  }
  
  protected void b(int paramInt, String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("TId[");
    localStringBuilder.append(m());
    localStringBuilder.append("] on set uploadsuc done errCode:");
    localStringBuilder.append(paramInt);
    localStringBuilder.append(" errMsg:");
    localStringBuilder.append(paramString);
    UFTLog.b("[UFTTransfer] UFTC2CUploadTask", 1, localStringBuilder.toString());
    if (paramInt != 0)
    {
      b(paramInt, c(5, paramString));
      return;
    }
    if (((UFTC2CUploadTaskInfo)this.h).k())
    {
      s();
      return;
    }
    b(0, c(5, ""));
  }
  
  protected final void b(long paramLong, int paramInt, UFTUploadTaskCompParam paramUFTUploadTaskCompParam)
  {
    UFTC2CReportData localUFTC2CReportData = b(false);
    localUFTC2CReportData.s = paramInt;
    localUFTC2CReportData.t = paramUFTUploadTaskCompParam.i;
    localUFTC2CReportData.v = paramUFTUploadTaskCompParam.j;
    localUFTC2CReportData.u = paramUFTUploadTaskCompParam.i;
    if (paramLong > this.j.k()) {
      localUFTC2CReportData.i = (paramLong - this.j.k());
    }
    localUFTC2CReportData.j = paramLong;
    localUFTC2CReportData.n = this.j.t();
    localUFTC2CReportData.o = this.j.u();
    localUFTC2CReportData.a();
  }
  
  protected void b(Bundle paramBundle)
  {
    this.k.a(true);
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("userCancel");
    ((StringBuilder)localObject).append(System.currentTimeMillis());
    localObject = ((StringBuilder)localObject).toString();
    long l1 = this.j.j();
    UFTC2CUploadFileOp localUFTC2CUploadFileOp = this.n;
    if (localUFTC2CUploadFileOp != null) {
      l1 = localUFTC2CUploadFileOp.k();
    }
    localObject = c(7, (String)localObject);
    c(l1, 9037, (UFTUploadTaskCompParam)localObject);
    b(l1, 9037, (UFTUploadTaskCompParam)localObject);
    f();
    super.a(paramBundle);
  }
  
  protected UFTUploadTaskCompParam c(int paramInt, String paramString)
  {
    paramString = new UFTUploadTaskCompParam(paramInt, paramString);
    paramString.j = this.j.q();
    paramString.k = this.j.r();
    paramString.m = this.j.t();
    paramString.n = this.j.u();
    return paramString;
  }
  
  protected void c()
  {
    if (this.m != null)
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("TId[");
      localStringBuilder.append(m());
      localStringBuilder.append("] fetch url op had do");
      UFTLog.d("[UFTTransfer] UFTC2CUploadTask", 1, localStringBuilder.toString());
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("TId[");
    localStringBuilder.append(m());
    localStringBuilder.append("] do fetch url op ...");
    UFTLog.b("[UFTTransfer] UFTC2CUploadTask", 1, localStringBuilder.toString());
    this.j.e(System.currentTimeMillis());
    this.k.a(this.g, 3, null);
    this.m = new UFTC2CFetchUploadUrlV3Op(this.f, (UFTC2CUploadTaskInfo)this.h, this.g, new UFTC2CUploadTask.3(this));
    int i = this.m.e();
    if (i != 0) {
      a(i, this.m.h());
    }
  }
  
  protected final void c(long paramLong, int paramInt, UFTUploadTaskCompParam paramUFTUploadTaskCompParam)
  {
    UFTC2CReportData localUFTC2CReportData = b(false);
    localUFTC2CReportData.s = paramInt;
    localUFTC2CReportData.t = paramUFTUploadTaskCompParam.i;
    localUFTC2CReportData.v = paramUFTUploadTaskCompParam.j;
    localUFTC2CReportData.u = paramUFTUploadTaskCompParam.i;
    if (paramLong > this.j.k()) {
      localUFTC2CReportData.i = (paramLong - this.j.k());
    }
    localUFTC2CReportData.j = paramLong;
    localUFTC2CReportData.n = paramUFTUploadTaskCompParam.m;
    localUFTC2CReportData.o = paramUFTUploadTaskCompParam.n;
    localUFTC2CReportData.b();
  }
  
  protected boolean dy_()
  {
    this.j.v();
    this.k.a(false);
    this.j.a(System.currentTimeMillis());
    this.k.a(this.g);
    UFTLogicThread.a().a(new UFTC2CUploadTask.1(this));
    return true;
  }
  
  protected void f()
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("TId[");
    ((StringBuilder)localObject).append(m());
    ((StringBuilder)localObject).append("] cancel all Op...");
    UFTLog.c("[UFTTransfer] UFTC2CUploadTask", 1, ((StringBuilder)localObject).toString());
    localObject = this.l;
    if (localObject != null)
    {
      ((UFTCalcHashOp)localObject).f();
      this.l = null;
    }
    localObject = this.m;
    if (localObject != null)
    {
      ((UFTC2CFetchUploadUrlOp)localObject).f();
      this.m = null;
    }
    localObject = this.n;
    if (localObject != null)
    {
      ((UFTC2CUploadFileOp)localObject).f();
      this.n = null;
    }
    localObject = this.o;
    if (localObject != null)
    {
      ((UFTC2CSetUploadSucOp)localObject).f();
      this.o = null;
    }
  }
  
  protected void h()
  {
    if (this.n != null)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("TId[");
      ((StringBuilder)localObject).append(m());
      ((StringBuilder)localObject).append("] upload file had do");
      UFTLog.d("[UFTTransfer] UFTC2CUploadTask", 1, ((StringBuilder)localObject).toString());
      return;
    }
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("TId[");
    ((StringBuilder)localObject).append(m());
    ((StringBuilder)localObject).append("] do upload file op ...");
    UFTLog.b("[UFTTransfer] UFTC2CUploadTask", 1, ((StringBuilder)localObject).toString());
    this.j.g(System.currentTimeMillis());
    this.k.a(this.g, 4, null);
    this.n = new UFTC2CUploadFileOp(this.f, (UFTC2CUploadTaskInfo)this.h, this.g, new UFTC2CUploadTask.4(this));
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
  
  public String i()
  {
    return ((UFTC2CUploadTaskInfo)this.h).a();
  }
  
  protected int j()
  {
    return 0;
  }
  
  protected void o()
  {
    b();
  }
  
  protected void p()
  {
    UFTC2CUploadTaskInfo localUFTC2CUploadTaskInfo = (UFTC2CUploadTaskInfo)this.h;
    UFTFileUploadBusinessInfo localUFTFileUploadBusinessInfo = new UFTFileUploadBusinessInfo();
    localUFTFileUploadBusinessInfo.a(localUFTC2CUploadTaskInfo.q());
    localUFTFileUploadBusinessInfo.a(localUFTC2CUploadTaskInfo.h());
    localUFTFileUploadBusinessInfo.c(localUFTC2CUploadTaskInfo.g());
    this.k.a(this.g, localUFTFileUploadBusinessInfo);
  }
  
  protected void q()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("TId[");
    localStringBuilder.append(m());
    localStringBuilder.append("] file is hit");
    UFTLog.b("[UFTTransfer] UFTC2CUploadTask", 1, localStringBuilder.toString());
    if (this.j.g() > 0L) {
      this.j.h(System.currentTimeMillis());
    }
    this.j.a(true);
    this.j.j(this.h.p());
    this.j.i(this.h.p());
    r();
  }
  
  protected void r()
  {
    if (this.o != null)
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("TId[");
      localStringBuilder.append(m());
      localStringBuilder.append("] set upload suc op had do");
      UFTLog.d("[UFTTransfer] UFTC2CUploadTask", 1, localStringBuilder.toString());
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("TId[");
    localStringBuilder.append(m());
    localStringBuilder.append("] do set upload suc op ...");
    UFTLog.b("[UFTTransfer] UFTC2CUploadTask", 1, localStringBuilder.toString());
    this.k.a(this.g, 5, null);
    this.o = new UFTC2CSetUploadSucOp(this.f, (UFTC2CUploadTaskInfo)this.h, this.g, new UFTC2CUploadTask.5(this));
    int i = this.o.e();
    if (i != 0) {
      b(i, "set upload suc fail");
    }
  }
  
  protected void s()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("TId[");
    localStringBuilder.append(m());
    localStringBuilder.append("] do send msg op ...");
    UFTLog.b("[UFTTransfer] UFTC2CUploadTask", 1, localStringBuilder.toString());
    this.k.a(this.g, 6, null);
    if (this.k.a(this.g, null, new UFTC2CUploadTask.6(this)) != 0) {
      a(90460, "send msg fail", 0, 0L);
    }
  }
  
  protected int t()
  {
    UFTUploadSrvBusiProp.C2CUploadSrvBusiProp localC2CUploadSrvBusiProp = ((UFTC2CUploadTaskInfo)this.h).l();
    if ((localC2CUploadSrvBusiProp != null) && (localC2CUploadSrvBusiProp.e()))
    {
      if (localC2CUploadSrvBusiProp.f()) {
        return 3;
      }
      return 2;
    }
    return 1;
  }
  
  protected boolean u()
  {
    UFTUploadSrvBusiProp.C2CUploadSrvBusiProp localC2CUploadSrvBusiProp = ((UFTC2CUploadTaskInfo)this.h).l();
    if (localC2CUploadSrvBusiProp != null) {
      return localC2CUploadSrvBusiProp.c();
    }
    return false;
  }
  
  protected final void v()
  {
    UFTC2CReportData localUFTC2CReportData = b(true);
    localUFTC2CReportData.s = 0L;
    if ((!this.j.i()) && (this.h.r().a() > this.j.k())) {
      localUFTC2CReportData.i = (this.h.r().a() - this.j.k());
    }
    localUFTC2CReportData.j = this.h.r().a();
    localUFTC2CReportData.n = this.j.t();
    localUFTC2CReportData.o = this.j.u();
    Object localObject = null;
    if (this.j.n() > 0)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("ChangedUrlCount[");
      ((StringBuilder)localObject).append(this.j.n());
      ((StringBuilder)localObject).append("]");
      localObject = ((StringBuilder)localObject).toString();
    }
    localUFTC2CReportData.l = ((String)localObject);
    localUFTC2CReportData.c();
    localUFTC2CReportData.d();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.uftransfer.task.upload.UFTC2CUploadTask
 * JD-Core Version:    0.7.0.1
 */