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
  protected UFTC2CFetchUploadUrlV2HitOp b;
  
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
    byte[] arrayOfByte1 = this.h.r().e();
    byte[] arrayOfByte2 = this.h.r().b();
    if ((arrayOfByte1 != null) && (arrayOfByte1.length > 0) && (arrayOfByte2 != null) && (arrayOfByte2.length > 0)) {
      return UFTC2CUploadTask.c(this.f, this.g, (UFTC2CUploadTaskInfo)this.h, paramIUFTTaskCallback, paramIUFTUploadCallback);
    }
    return UFTC2CBigFileUploadTask.a(this.f, this.g, (UFTC2CUploadTaskInfo)this.h, paramIUFTTaskCallback, paramIUFTUploadCallback);
  }
  
  protected void a(int paramInt)
  {
    super.a(paramInt);
    if (this.c) {
      return;
    }
    if (paramInt == 0) {
      d();
    }
  }
  
  protected void a(int paramInt, String paramString)
  {
    if (this.c)
    {
      super.a(paramInt, paramString);
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("TId[");
    localStringBuilder.append(m());
    localStringBuilder.append("] onFetchUrlOpDone errCode:");
    localStringBuilder.append(paramInt);
    localStringBuilder.append(" errMsg:");
    localStringBuilder.append(paramString);
    UFTLog.b("[UFTTransfer] UFTC2CBigFileUploadTask", 1, localStringBuilder.toString());
    if (paramInt != 0)
    {
      b(paramInt, c(3, paramString));
      return;
    }
    p();
    if ((this.h.r().e() != null) && (this.h.r().e().length > 0))
    {
      paramString = new StringBuilder();
      paramString.append("TId[");
      paramString.append(m());
      paramString.append("] onFetchUrlOpDone getted sha and do hit");
      UFTLog.b("[UFTTransfer] UFTC2CBigFileUploadTask", 1, paramString.toString());
      this.k.a(this.g, this.h.r());
      paramString = this.a;
      if (paramString != null)
      {
        paramString.f();
        this.a = null;
      }
      e();
      h();
    }
  }
  
  protected void a(UFTBaseUploadFileOp.UploadFileOpRetData paramUploadFileOpRetData)
  {
    if (!this.c)
    {
      Object localObject = this.a;
      if (localObject != null)
      {
        ((UFTCalcHashOp)localObject).f();
        this.a = null;
      }
      localObject = this.b;
      if (localObject != null)
      {
        ((UFTC2CFetchUploadUrlV2HitOp)localObject).f();
        this.b = null;
      }
    }
    super.a(paramUploadFileOpRetData);
  }
  
  protected void a(boolean paramBoolean)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("TId[");
    ((StringBuilder)localObject).append(m());
    ((StringBuilder)localObject).append("] onUploadHitOpDone hit:");
    ((StringBuilder)localObject).append(paramBoolean);
    UFTLog.d("[UFTTransfer] UFTC2CBigFileUploadTask", 1, ((StringBuilder)localObject).toString());
    if (!paramBoolean) {
      return;
    }
    p();
    localObject = this.a;
    if (localObject != null)
    {
      ((UFTCalcHashOp)localObject).f();
      this.a = null;
    }
    if (this.n != null)
    {
      this.n.f();
      this.n = null;
    }
    q();
  }
  
  protected void b()
  {
    if (this.c)
    {
      super.b();
      return;
    }
    if (this.l != null)
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("TId[");
      localStringBuilder.append(m());
      localStringBuilder.append("] CalcHashOp had do");
      UFTLog.d("[UFTTransfer] UFTC2CBigFileUploadTask", 1, localStringBuilder.toString());
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("TId[");
    localStringBuilder.append(m());
    localStringBuilder.append("] doCalcHashOp...");
    UFTLog.b("[UFTTransfer] UFTC2CBigFileUploadTask", 1, localStringBuilder.toString());
    this.l = new UFTCalcHashOp(this.f, this.h, this.g, i(), 21L, new UFTC2CExtfBigFileUploadTask.1(this));
    int i = this.l.e();
    if (i != 0) {
      a(i);
    }
  }
  
  protected void c()
  {
    if (this.c)
    {
      super.c();
      return;
    }
    if (this.m != null)
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("TId[");
      localStringBuilder.append(m());
      localStringBuilder.append("] FetchUrlOp had do");
      UFTLog.d("[UFTTransfer] UFTC2CBigFileUploadTask", 1, localStringBuilder.toString());
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("TId[");
    localStringBuilder.append(m());
    localStringBuilder.append("] doFetchUrlOp...");
    UFTLog.b("[UFTTransfer] UFTC2CBigFileUploadTask", 1, localStringBuilder.toString());
    this.m = new UFTC2CFetchUploadUrlV2Op(this.f, (UFTC2CUploadTaskInfo)this.h, this.g, new UFTC2CExtfBigFileUploadTask.2(this));
    int i = this.m.e();
    if (i != 0) {
      a(i, this.m.h());
    }
  }
  
  protected void d()
  {
    if (this.a != null)
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("TId[");
      localStringBuilder.append(m());
      localStringBuilder.append("] CalcFullShaOp had do");
      UFTLog.d("[UFTTransfer] UFTC2CBigFileUploadTask", 1, localStringBuilder.toString());
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("TId[");
    localStringBuilder.append(m());
    localStringBuilder.append("] doCalcFullShaOp...");
    UFTLog.b("[UFTTransfer] UFTC2CBigFileUploadTask", 1, localStringBuilder.toString());
    this.a = new UFTCalcHashOp(this.f, this.h, this.g, i(), 8L, new UFTC2CExtfBigFileUploadTask.3(this));
    int i = this.a.e();
    if (i != 0) {
      d(i);
    }
  }
  
  protected void d(int paramInt)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("TId[");
    localStringBuilder.append(m());
    localStringBuilder.append("] onCalcFullShaOpDone errCode:");
    localStringBuilder.append(paramInt);
    UFTLog.b("[UFTTransfer] UFTC2CBigFileUploadTask", 1, localStringBuilder.toString());
    if (paramInt != 0) {
      return;
    }
    this.k.a(this.g, this.h.r());
    e();
    h();
  }
  
  protected void e()
  {
    if (this.b != null)
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("TId[");
      localStringBuilder.append(m());
      localStringBuilder.append("] UploadHitOp had do");
      UFTLog.d("[UFTTransfer] UFTC2CBigFileUploadTask", 1, localStringBuilder.toString());
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("TId[");
    localStringBuilder.append(m());
    localStringBuilder.append("] doUploadHitOp...");
    UFTLog.b("[UFTTransfer] UFTC2CBigFileUploadTask", 1, localStringBuilder.toString());
    this.b = new UFTC2CFetchUploadUrlV2HitOp(this.f, (UFTC2CUploadTaskInfo)this.h, this.g, new UFTC2CExtfBigFileUploadTask.4(this));
    this.b.e();
  }
  
  protected void f()
  {
    super.f();
    Object localObject = this.a;
    if (localObject != null)
    {
      ((UFTCalcHashOp)localObject).f();
      this.a = null;
    }
    localObject = this.b;
    if (localObject != null)
    {
      ((UFTC2CFetchUploadUrlV2HitOp)localObject).f();
      this.b = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.uftransfer.task.upload.UFTC2CExtfBigFileUploadTask
 * JD-Core Version:    0.7.0.1
 */