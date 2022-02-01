package com.tencent.mobileqq.uftransfer.guild;

import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.mobileqq.uftransfer.UFTLogicThread;
import com.tencent.mobileqq.uftransfer.api.IUFTUploadCallback;
import com.tencent.mobileqq.uftransfer.api.UFTFileUploadBusinessInfo;
import com.tencent.mobileqq.uftransfer.api.UFTTransferConfig;
import com.tencent.mobileqq.uftransfer.api.UFTTransferConfig.UploadConfig;
import com.tencent.mobileqq.uftransfer.api.impl.UFTTransferKey;
import com.tencent.mobileqq.uftransfer.depend.UFTDependFeatureApi;
import com.tencent.mobileqq.uftransfer.depend.UFTLog;
import com.tencent.mobileqq.uftransfer.proto.UFTProtoRequestor;
import com.tencent.mobileqq.uftransfer.task.IUFTTaskCallback;
import com.tencent.mobileqq.uftransfer.task.commonop.UFTCalcHashOp;
import com.tencent.mobileqq.uftransfer.task.taskinfo.UFTBaseTaskInfo;
import com.tencent.mobileqq.uftransfer.task.taskinfo.UFTUploadTaskRunNotesInfo;
import com.tencent.mobileqq.uftransfer.task.upload.UFTBaseUploadFileOp.UploadFileOpRetData;
import com.tencent.mobileqq.uftransfer.task.upload.UFTBaseUploadTask;
import com.tencent.mobileqq.uftransfer.task.upload.UFTUploadCbWrapper;
import com.tencent.mobileqq.uftransfer.task.upload.UFTUploadCompleteInfo;
import com.tencent.mobileqq.uftransfer.task.upload.UFTUploadTaskCompParam;
import com.tencent.mobileqq.uftransfer.utility.UFTTransferUtility;
import com.tencent.qphone.base.util.QLog;
import mqq.app.AppRuntime;

public class UFTGuildExtfUploadTask
  extends UFTBaseUploadTask
{
  protected boolean a;
  protected UFTCalcHashOp b;
  protected UFTGuildFetchUploadUrlOp c;
  protected UFTGuildUploadSuccOp d;
  protected UFTGuildUploadFileOp e;
  
  protected UFTGuildExtfUploadTask(AppRuntime paramAppRuntime, UFTTransferKey paramUFTTransferKey, UFTGuildUploadTaskInfo paramUFTGuildUploadTaskInfo, IUFTTaskCallback paramIUFTTaskCallback, IUFTUploadCallback paramIUFTUploadCallback)
  {
    super(paramAppRuntime, paramUFTTransferKey, paramUFTGuildUploadTaskInfo, paramIUFTTaskCallback, paramIUFTUploadCallback);
    this.a = paramUFTGuildUploadTaskInfo.s().a().f();
  }
  
  public static UFTGuildExtfUploadTask a(AppRuntime paramAppRuntime, UFTTransferKey paramUFTTransferKey, UFTGuildUploadTaskInfo paramUFTGuildUploadTaskInfo, IUFTTaskCallback paramIUFTTaskCallback, IUFTUploadCallback paramIUFTUploadCallback)
  {
    if (a(paramAppRuntime, paramUFTTransferKey, paramUFTGuildUploadTaskInfo, paramIUFTTaskCallback, "[UFTTransfer] UFTGuildExtfUploadTask")) {
      return new UFTGuildExtfUploadTask(paramAppRuntime, paramUFTTransferKey, paramUFTGuildUploadTaskInfo, paramIUFTTaskCallback, paramIUFTUploadCallback);
    }
    return null;
  }
  
  private boolean a(String paramString)
  {
    if (!UFTDependFeatureApi.c())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("TId[");
      localStringBuilder.append(m());
      localStringBuilder.append("] send local file[");
      localStringBuilder.append(paramString);
      localStringBuilder.append("] no network");
      UFTLog.d("[UFTTransfer] UFTGuildExtfUploadTask", 1, localStringBuilder.toString());
      a(9004, c(1, "NoNetWork"));
      return false;
    }
    return true;
  }
  
  private boolean b(String paramString)
  {
    StringBuilder localStringBuilder;
    if (TextUtils.isEmpty(paramString))
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("TId[");
      localStringBuilder.append(m());
      localStringBuilder.append("] send local file[");
      localStringBuilder.append(paramString);
      localStringBuilder.append("] strFilePath is null");
      UFTLog.d("[UFTTransfer] UFTGuildExtfUploadTask", 1, localStringBuilder.toString());
      a(9005, c(1, "strFilePath is null"));
      return false;
    }
    if (!UFTTransferUtility.b(paramString))
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("TId[");
      localStringBuilder.append(m());
      localStringBuilder.append("] send local file[");
      localStringBuilder.append(paramString);
      localStringBuilder.append("] strFilePath is not exist");
      UFTLog.d("[UFTTransfer] UFTGuildExtfUploadTask", 1, localStringBuilder.toString());
      a(9042, c(1, "fileNotExists"));
      return false;
    }
    if (UFTTransferUtility.a(paramString) == 0L)
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("TId[");
      localStringBuilder.append(m());
      localStringBuilder.append("] send local file[");
      localStringBuilder.append(paramString);
      localStringBuilder.append("] strFilePath is empty file");
      UFTLog.d("[UFTTransfer] UFTGuildExtfUploadTask", 1, localStringBuilder.toString());
      a(9071, c(1, "fileExistsEmpty"));
      return false;
    }
    return true;
  }
  
  protected void a(int paramInt)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("TId[");
    localStringBuilder.append(m());
    localStringBuilder.append("] on calc hash op done retCode:");
    localStringBuilder.append(paramInt);
    UFTLog.b("[UFTTransfer] UFTGuildExtfUploadTask", 1, localStringBuilder.toString());
    this.j.d(System.currentTimeMillis());
    if (paramInt != 0)
    {
      int i = 9041;
      if (paramInt == 1) {
        i = 9042;
      }
      a(i, c(2, "get md5 failed"));
      return;
    }
    this.k.a(this.g, this.h.r());
    d();
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
    j();
    super.a(paramBundle);
    if (i != 0)
    {
      paramBundle = b(9004, c(7, (String)localObject));
      paramBundle.b(paramInt);
      this.k.a(this.g, 9004, paramBundle);
      return;
    }
    this.k.a(true);
  }
  
  protected void a(int paramInt, UFTUploadTaskCompParam paramUFTUploadTaskCompParam)
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
    UFTLog.b("[UFTTransfer] UFTGuildExtfUploadTask", 1, localStringBuilder.toString());
    j();
    this.j.b(System.currentTimeMillis());
    this.k.a(this.g, paramInt, b(paramInt, paramUFTUploadTaskCompParam));
    b(paramInt);
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
    UFTLog.b("[UFTTransfer] UFTGuildExtfUploadTask", 1, localStringBuilder.toString());
    this.j.f(System.currentTimeMillis());
    if (paramInt != 0)
    {
      a(paramInt, c(3, paramString));
      return;
    }
    e();
    if (((UFTGuildUploadTaskInfo)this.h).f())
    {
      g();
      return;
    }
    f();
  }
  
  public void a(Bundle paramBundle)
  {
    if (this.j.g() > 0L) {
      this.j.h(System.currentTimeMillis());
    }
    if (this.e != null)
    {
      this.j.i(this.e.k());
      this.j.k(this.e.b());
      this.j.l(this.e.d());
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
    UFTLog.c("[UFTTransfer] UFTGuildExtfUploadTask", 1, localStringBuilder.toString());
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
    if (this.e != null)
    {
      this.j.a(this.e.m());
      this.j.j(this.e.j());
      this.j.i(this.e.k());
      this.j.a(this.e.l());
      this.j.k(this.e.b());
      this.j.l(this.e.d());
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
    UFTLog.b("[UFTTransfer] UFTGuildExtfUploadTask", 1, ((StringBuilder)localObject).toString());
    if (paramUploadFileOpRetData.a() != 0)
    {
      localObject = c(4, paramUploadFileOpRetData.b());
      ((UFTUploadTaskCompParam)localObject).l = paramUploadFileOpRetData.h();
      a(paramUploadFileOpRetData.a(), (UFTUploadTaskCompParam)localObject);
      return;
    }
    this.j.i(this.h.p());
    h();
  }
  
  protected UFTUploadCompleteInfo b(int paramInt, UFTUploadTaskCompParam paramUFTUploadTaskCompParam)
  {
    UFTUploadCompleteInfo localUFTUploadCompleteInfo = new UFTUploadCompleteInfo();
    UFTGuildUploadTaskInfo localUFTGuildUploadTaskInfo = (UFTGuildUploadTaskInfo)this.h;
    localUFTUploadCompleteInfo.a(this.j.i());
    localUFTUploadCompleteInfo.a(localUFTGuildUploadTaskInfo.q());
    localUFTUploadCompleteInfo.d("");
    localUFTUploadCompleteInfo.c(this.j.m());
    if ((!TextUtils.isEmpty(localUFTGuildUploadTaskInfo.m())) && (!UFTProtoRequestor.a(paramInt))) {
      localUFTUploadCompleteInfo.b(localUFTGuildUploadTaskInfo.m());
    }
    localUFTUploadCompleteInfo.a(paramUFTUploadTaskCompParam.h);
    return localUFTUploadCompleteInfo;
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
    localStringBuilder.append("] on set uploadsuc done errCode:");
    localStringBuilder.append(paramInt);
    localStringBuilder.append(" errMsg:");
    localStringBuilder.append(paramString);
    UFTLog.b("[UFTTransfer] UFTGuildExtfUploadTask", 1, localStringBuilder.toString());
    if (paramInt != 0)
    {
      a(paramInt, c(5, paramString));
      return;
    }
    if (((UFTGuildUploadTaskInfo)this.h).b())
    {
      QLog.e("[UFTTransfer] UFTGuildExtfUploadTask", 1, "error! guild file not need send msg!!!");
      return;
    }
    a(0, c(5, ""));
  }
  
  protected void b(Bundle paramBundle)
  {
    this.k.a(true);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("userCancel");
    localStringBuilder.append(System.currentTimeMillis());
    localStringBuilder.toString();
    QLog.d("[UFTTransfer] UFTGuildExtfUploadTask", 2, "userCancel");
    j();
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
    if (!this.a)
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("TId[");
      localStringBuilder.append(m());
      localStringBuilder.append("] calc hash mUseMediaPlatform == false");
      UFTLog.d("[UFTTransfer] UFTGuildExtfUploadTask", 1, localStringBuilder.toString());
      return;
    }
    if (this.b != null)
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("TId[");
      localStringBuilder.append(m());
      localStringBuilder.append("] calc hash op had do");
      UFTLog.d("[UFTTransfer] UFTGuildExtfUploadTask", 1, localStringBuilder.toString());
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("TId[");
    localStringBuilder.append(m());
    localStringBuilder.append("] do calc hash op ...");
    UFTLog.b("[UFTTransfer] UFTGuildExtfUploadTask", 1, localStringBuilder.toString());
    this.j.c(System.currentTimeMillis());
    this.k.a(this.g, 2, null);
    this.b = new UFTCalcHashOp(this.f, this.h, this.g, i(), 30L, new UFTGuildExtfUploadTask.2(this));
    int i = this.b.e();
    if (i != 0) {
      a(i);
    }
  }
  
  protected void d()
  {
    if (this.c != null)
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("TId[");
      localStringBuilder.append(m());
      localStringBuilder.append("] fetch url op had do");
      UFTLog.d("[UFTTransfer] UFTGuildExtfUploadTask", 1, localStringBuilder.toString());
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("TId[");
    localStringBuilder.append(m());
    localStringBuilder.append("] do fetch url op ...");
    UFTLog.b("[UFTTransfer] UFTGuildExtfUploadTask", 1, localStringBuilder.toString());
    this.j.e(System.currentTimeMillis());
    this.k.a(this.g, 3, null);
    this.c = new UFTGuildFetchUploadUrlOp(this.f, (UFTGuildUploadTaskInfo)this.h, this.g, new UFTGuildExtfUploadTask.3(this));
    int i = this.c.e();
    if (i != 0) {
      a(i, this.c.h());
    }
  }
  
  protected boolean dy_()
  {
    this.j.v();
    this.k.a(false);
    this.j.a(System.currentTimeMillis());
    this.k.a(this.g);
    UFTLogicThread.a().a(new UFTGuildExtfUploadTask.1(this));
    return true;
  }
  
  protected void e()
  {
    UFTGuildUploadTaskInfo localUFTGuildUploadTaskInfo = (UFTGuildUploadTaskInfo)this.h;
    UFTFileUploadBusinessInfo localUFTFileUploadBusinessInfo = new UFTFileUploadBusinessInfo();
    localUFTFileUploadBusinessInfo.a(localUFTGuildUploadTaskInfo.q());
    localUFTFileUploadBusinessInfo.a(true);
    localUFTFileUploadBusinessInfo.c("");
    this.k.a(this.g, localUFTFileUploadBusinessInfo);
  }
  
  protected void f()
  {
    if (this.e != null)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("TId[");
      ((StringBuilder)localObject).append(m());
      ((StringBuilder)localObject).append("] upload file had do");
      UFTLog.d("[UFTTransfer] UFTGuildExtfUploadTask", 1, ((StringBuilder)localObject).toString());
      return;
    }
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("TId[");
    ((StringBuilder)localObject).append(m());
    ((StringBuilder)localObject).append("] do upload file op ...");
    UFTLog.b("[UFTTransfer] UFTGuildExtfUploadTask", 1, ((StringBuilder)localObject).toString());
    this.j.g(System.currentTimeMillis());
    this.k.a(this.g, 4, null);
    this.e = new UFTGuildUploadFileOp(this.f, (UFTGuildUploadTaskInfo)this.h, this.g, new UFTGuildExtfUploadTask.4(this));
    int i = this.e.e();
    if (i != 0)
    {
      localObject = new UFTBaseUploadFileOp.UploadFileOpRetData();
      ((UFTBaseUploadFileOp.UploadFileOpRetData)localObject).a(i);
      ((UFTBaseUploadFileOp.UploadFileOpRetData)localObject).a(this.e.h());
      a((UFTBaseUploadFileOp.UploadFileOpRetData)localObject);
      return;
    }
    this.j.a(this.e.m());
  }
  
  protected void g()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("TId[");
    localStringBuilder.append(m());
    localStringBuilder.append("] file is hit");
    UFTLog.b("[UFTTransfer] UFTGuildExtfUploadTask", 1, localStringBuilder.toString());
    if (this.j.g() > 0L) {
      this.j.h(System.currentTimeMillis());
    }
    this.j.a(true);
    this.j.j(this.h.p());
    this.j.i(this.h.p());
    h();
  }
  
  protected void h()
  {
    if (this.d != null)
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("TId[");
      localStringBuilder.append(m());
      localStringBuilder.append("] set upload suc op had do");
      UFTLog.d("[UFTTransfer] UFTGuildExtfUploadTask", 1, localStringBuilder.toString());
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("TId[");
    localStringBuilder.append(m());
    localStringBuilder.append("] do set upload suc op ...");
    UFTLog.b("[UFTTransfer] UFTGuildExtfUploadTask", 1, localStringBuilder.toString());
    this.k.a(this.g, 5, null);
    this.d = new UFTGuildUploadSuccOp(this.f, (UFTGuildUploadTaskInfo)this.h, this.g, new UFTGuildExtfUploadTask.5(this));
    int i = this.d.e();
    if (i != 0) {
      b(i, "set upload suc fail");
    }
  }
  
  public String i()
  {
    return ((UFTGuildUploadTaskInfo)this.h).a();
  }
  
  protected void j()
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("TId[");
    ((StringBuilder)localObject).append(m());
    ((StringBuilder)localObject).append("] cancel all Op...");
    UFTLog.c("[UFTTransfer] UFTGuildExtfUploadTask", 1, ((StringBuilder)localObject).toString());
    localObject = this.b;
    if (localObject != null)
    {
      ((UFTCalcHashOp)localObject).f();
      this.b = null;
    }
    localObject = this.c;
    if (localObject != null)
    {
      ((UFTGuildFetchUploadUrlOp)localObject).f();
      this.c = null;
    }
    localObject = this.e;
    if (localObject != null)
    {
      ((UFTGuildUploadFileOp)localObject).f();
      this.e = null;
    }
    localObject = this.d;
    if (localObject != null)
    {
      ((UFTGuildUploadSuccOp)localObject).f();
      this.d = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.uftransfer.guild.UFTGuildExtfUploadTask
 * JD-Core Version:    0.7.0.1
 */