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

public class UFTC2CBigFileUploadTask
  extends UFTC2CUploadTask
{
  protected UFTCalcHashOp a;
  protected UFTC2CFetchUploadUrlV2HitOp b;
  
  protected UFTC2CBigFileUploadTask(AppRuntime paramAppRuntime, UFTTransferKey paramUFTTransferKey, UFTC2CUploadTaskInfo paramUFTC2CUploadTaskInfo, IUFTTaskCallback paramIUFTTaskCallback, IUFTUploadCallback paramIUFTUploadCallback)
  {
    super(paramAppRuntime, paramUFTTransferKey, paramUFTC2CUploadTaskInfo, paramIUFTTaskCallback, paramIUFTUploadCallback);
  }
  
  public static UFTC2CUploadTask a(AppRuntime paramAppRuntime, UFTTransferKey paramUFTTransferKey, UFTC2CUploadTaskInfo paramUFTC2CUploadTaskInfo, IUFTTaskCallback paramIUFTTaskCallback, IUFTUploadCallback paramIUFTUploadCallback)
  {
    if (a(paramAppRuntime, paramUFTTransferKey, paramUFTC2CUploadTaskInfo, paramIUFTTaskCallback, "[UFTTransfer] UFTC2CBigFileUploadTask")) {
      return new UFTC2CBigFileUploadTask(paramAppRuntime, paramUFTTransferKey, paramUFTC2CUploadTaskInfo, paramIUFTTaskCallback, paramIUFTUploadCallback);
    }
    return null;
  }
  
  protected void a(int paramInt)
  {
    super.a(paramInt);
    if (paramInt == 0) {
      d();
    }
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
      paramString.append("] on fetch url op done. getted sha and do hit");
      UFTLog.b("[UFTTransfer] UFTC2CBigFileUploadTask", 1, paramString.toString());
      this.k.a(this.g, this.h.r());
      paramString = this.a;
      if (paramString != null)
      {
        paramString.f();
        this.a = null;
      }
      e();
    }
    h();
  }
  
  protected void a(UFTBaseUploadFileOp.UploadFileOpRetData paramUploadFileOpRetData)
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
    super.a(paramUploadFileOpRetData);
  }
  
  protected void a(boolean paramBoolean)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("TId[");
    ((StringBuilder)localObject).append(m());
    ((StringBuilder)localObject).append("] on upload hit done. hit:");
    ((StringBuilder)localObject).append(paramBoolean);
    UFTLog.b("[UFTTransfer] UFTC2CBigFileUploadTask", 1, ((StringBuilder)localObject).toString());
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
    if (this.l != null)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("TId[");
      ((StringBuilder)localObject).append(m());
      ((StringBuilder)localObject).append("] calc hash op had do");
      UFTLog.d("[UFTTransfer] UFTC2CBigFileUploadTask", 1, ((StringBuilder)localObject).toString());
      return;
    }
    Object localObject = this.h.r().d();
    byte[] arrayOfByte = this.h.r().b();
    if ((localObject != null) && (localObject.length > 0) && (arrayOfByte != null) && (arrayOfByte.length > 0))
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("TId[");
      ((StringBuilder)localObject).append(m());
      ((StringBuilder)localObject).append("] file hash exist and calc hash done");
      UFTLog.b("[UFTTransfer] UFTC2CBigFileUploadTask", 1, ((StringBuilder)localObject).toString());
      a(0);
      return;
    }
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("TId[");
    ((StringBuilder)localObject).append(m());
    ((StringBuilder)localObject).append("] calc hash op ...");
    UFTLog.b("[UFTTransfer] UFTC2CBigFileUploadTask", 1, ((StringBuilder)localObject).toString());
    this.k.a(this.g, 2, null);
    this.l = new UFTCalcHashOp(this.f, this.h, this.g, i(), 21L, new UFTC2CBigFileUploadTask.1(this));
    this.l.a(true);
    int i = this.l.e();
    if (i != 0) {
      a(i);
    }
  }
  
  protected void c()
  {
    if (this.m != null)
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("TId[");
      localStringBuilder.append(m());
      localStringBuilder.append("] fetch url op had do");
      UFTLog.d("[UFTTransfer] UFTC2CBigFileUploadTask", 1, localStringBuilder.toString());
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("TId[");
    localStringBuilder.append(m());
    localStringBuilder.append("] fetch url op ...");
    UFTLog.b("[UFTTransfer] UFTC2CBigFileUploadTask", 1, localStringBuilder.toString());
    this.k.a(this.g, 3, null);
    this.m = new UFTC2CFetchUploadUrlV2Op(this.f, (UFTC2CUploadTaskInfo)this.h, this.g, new UFTC2CBigFileUploadTask.2(this));
    int i = this.m.e();
    if (i != 0) {
      a(i, this.m.h());
    }
  }
  
  protected void d()
  {
    if (this.a != null)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("TId[");
      ((StringBuilder)localObject).append(m());
      ((StringBuilder)localObject).append("] calc full sha op had do");
      UFTLog.d("[UFTTransfer] UFTC2CBigFileUploadTask", 1, ((StringBuilder)localObject).toString());
      return;
    }
    Object localObject = this.h.r().e();
    if ((localObject != null) && (localObject.length > 0))
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("TId[");
      ((StringBuilder)localObject).append(m());
      ((StringBuilder)localObject).append("] file hash exist and calc full sha done");
      UFTLog.b("[UFTTransfer] UFTC2CBigFileUploadTask", 1, ((StringBuilder)localObject).toString());
      d(0);
      return;
    }
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("TId[");
    ((StringBuilder)localObject).append(m());
    ((StringBuilder)localObject).append("] calc full sha op...");
    UFTLog.b("[UFTTransfer] UFTC2CBigFileUploadTask", 1, ((StringBuilder)localObject).toString());
    this.a = new UFTCalcHashOp(this.f, this.h, this.g, i(), 8L, new UFTC2CBigFileUploadTask.3(this));
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
    localStringBuilder.append("] on calc full sha done. errCode:");
    localStringBuilder.append(paramInt);
    UFTLog.b("[UFTTransfer] UFTC2CBigFileUploadTask", 1, localStringBuilder.toString());
    if (paramInt != 0) {
      return;
    }
    this.k.a(this.g, this.h.r());
    e();
  }
  
  protected void e()
  {
    if (this.b != null)
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("TId[");
      localStringBuilder.append(m());
      localStringBuilder.append("] upload hit op had do");
      UFTLog.d("[UFTTransfer] UFTC2CBigFileUploadTask", 1, localStringBuilder.toString());
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("TId[");
    localStringBuilder.append(m());
    localStringBuilder.append("] upload hit op ...");
    UFTLog.b("[UFTTransfer] UFTC2CBigFileUploadTask", 1, localStringBuilder.toString());
    this.b = new UFTC2CFetchUploadUrlV2HitOp(this.f, (UFTC2CUploadTaskInfo)this.h, this.g, new UFTC2CBigFileUploadTask.4(this));
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
 * Qualified Name:     com.tencent.mobileqq.uftransfer.task.upload.UFTC2CBigFileUploadTask
 * JD-Core Version:    0.7.0.1
 */