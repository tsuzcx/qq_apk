package com.tencent.mobileqq.uftransfer.task.upload;

import android.text.TextUtils;
import com.tencent.mobileqq.uftransfer.api.UFTFileLocalInfo;
import com.tencent.mobileqq.uftransfer.api.impl.UFTTransferKey;
import com.tencent.mobileqq.uftransfer.common.transfer.IUFTFileUploader;
import com.tencent.mobileqq.uftransfer.common.transfer.IUFTFileUploaderCallback;
import com.tencent.mobileqq.uftransfer.depend.UFTLog;
import com.tencent.mobileqq.uftransfer.task.UFTBaseOp;
import com.tencent.mobileqq.uftransfer.task.taskinfo.UFTBaseTaskInfo;
import mqq.app.AppRuntime;

public abstract class UFTBaseUploadFileOp
  extends UFTBaseOp
  implements IUFTFileUploaderCallback
{
  protected IUFTFileUploader c;
  protected UFTBaseUploadFileOp.UFTUploadFileOpCallback d;
  protected boolean e = false;
  
  public UFTBaseUploadFileOp(AppRuntime paramAppRuntime, UFTBaseTaskInfo paramUFTBaseTaskInfo, UFTTransferKey paramUFTTransferKey, UFTBaseUploadFileOp.UFTUploadFileOpCallback paramUFTUploadFileOpCallback)
  {
    super(paramAppRuntime, paramUFTBaseTaskInfo, paramUFTTransferKey, paramUFTUploadFileOpCallback);
    this.d = paramUFTUploadFileOpCallback;
  }
  
  public void a(long paramLong1, long paramLong2, long paramLong3)
  {
    if ((!this.j) && (this.d != null))
    {
      if (UFTLog.a())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("TId[");
        localStringBuilder.append(i());
        localStringBuilder.append("] on upload progress. fsize:");
        localStringBuilder.append(this.h.r().a());
        localStringBuilder.append(" tsize:");
        localStringBuilder.append(paramLong1);
        localStringBuilder.append(" speed:");
        localStringBuilder.append(paramLong3);
        UFTLog.a("[UFTTransfer] UFTUploadFileBaseOp", 4, localStringBuilder.toString());
      }
      this.d.a(paramLong1, paramLong2, paramLong3);
    }
  }
  
  public void a(long paramLong, String paramString1, String paramString2)
  {
    if ((!this.j) && (this.d != null))
    {
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append("TId[");
      ((StringBuilder)localObject).append(i());
      ((StringBuilder)localObject).append("] on upload roll back. rollbackPos:");
      ((StringBuilder)localObject).append(paramLong);
      UFTLog.c("[UFTTransfer] UFTUploadFileBaseOp", 1, ((StringBuilder)localObject).toString());
      localObject = paramString1;
      if (TextUtils.isEmpty(paramString1))
      {
        paramString1 = new StringBuilder();
        paramString1.append("errMsgString_ServerRollback[");
        paramString1.append(9009);
        paramString1.append("]");
        localObject = paramString1.toString();
      }
      paramString1 = this.c;
      if (paramString1 != null) {
        paramLong = paramString1.e();
      } else {
        paramLong = 0L;
      }
      this.d.a(9009, (String)localObject, paramLong, paramString2, null);
    }
  }
  
  protected void a(UFTBaseUploadFileOp.UploadFileOpRetData paramUploadFileOpRetData)
  {
    a(paramUploadFileOpRetData);
  }
  
  public void a(Object paramObject)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("TId[");
    ((StringBuilder)localObject).append(i());
    ((StringBuilder)localObject).append("] on sub uploader success");
    UFTLog.b("[UFTTransfer] UFTUploadFileBaseOp", 1, ((StringBuilder)localObject).toString());
    if ((!this.j) && (this.d != null))
    {
      localObject = this.c;
      long l;
      if (localObject != null) {
        l = ((IUFTFileUploader)localObject).e();
      } else {
        l = 0L;
      }
      this.d.a(0, "", l, null, paramObject);
    }
  }
  
  public void a(String paramString)
  {
    if (!this.j)
    {
      UFTBaseUploadFileOp.UFTUploadFileOpCallback localUFTUploadFileOpCallback = this.d;
      if (localUFTUploadFileOpCallback != null) {
        localUFTUploadFileOpCallback.a(paramString);
      }
    }
  }
  
  public void a(boolean paramBoolean, int paramInt, long paramLong, String paramString1, String paramString2, Object paramObject)
  {
    if ((!this.j) && (this.d != null))
    {
      if (paramInt == 0) {
        paramInt = 9001;
      }
      String str = paramString1;
      if (TextUtils.isEmpty(paramString1))
      {
        paramString1 = new StringBuilder();
        paramString1.append("errMsgString_NUll_retCode[");
        paramString1.append(paramInt);
        paramString1.append("]");
        str = paramString1.toString();
      }
      paramString1 = new StringBuilder();
      paramString1.append("TId[");
      paramString1.append(i());
      paramString1.append("] on upload err. finished:");
      paramString1.append(paramBoolean);
      paramString1.append(" errcode:");
      paramString1.append(paramInt);
      paramString1.append(" errmsg:");
      paramString1.append(str);
      paramString1.append(" tsize:");
      paramString1.append(paramLong);
      paramString1.append(" rspheader:");
      paramString1.append(paramString2);
      UFTLog.d("[UFTTransfer] UFTUploadFileBaseOp", 1, paramString1.toString());
      if (paramBoolean)
      {
        paramString1 = new UFTBaseUploadFileOp.UploadFileOpRetData();
        paramString1.a(paramInt);
        paramString1.a(str);
        UFTBaseUploadFileOp.UploadFileOpRetData.a(paramString1, paramObject);
        UFTBaseUploadFileOp.UploadFileOpRetData.a(paramString1, paramString2);
        paramString2 = this.c;
        if (paramString2 != null) {
          UFTBaseUploadFileOp.UploadFileOpRetData.b(paramString1, paramString2.c());
        }
        UFTBaseUploadFileOp.UploadFileOpRetData.c(paramString1, a());
        a(paramString1);
        return;
      }
      this.d.a(paramInt, str, paramLong, paramString2, paramObject);
    }
  }
  
  public void a(boolean paramBoolean, Object paramObject)
  {
    this.e = paramBoolean;
    if ((!this.j) && (this.d != null))
    {
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append("TId[");
      ((StringBuilder)localObject).append(i());
      ((StringBuilder)localObject).append("] on upload suc. isflash:");
      ((StringBuilder)localObject).append(paramBoolean);
      UFTLog.b("[UFTTransfer] UFTUploadFileBaseOp", 1, ((StringBuilder)localObject).toString());
      localObject = new UFTBaseUploadFileOp.UploadFileOpRetData();
      ((UFTBaseUploadFileOp.UploadFileOpRetData)localObject).a(0);
      UFTBaseUploadFileOp.UploadFileOpRetData.a((UFTBaseUploadFileOp.UploadFileOpRetData)localObject, paramBoolean);
      UFTBaseUploadFileOp.UploadFileOpRetData.a((UFTBaseUploadFileOp.UploadFileOpRetData)localObject, paramObject);
      paramObject = this.c;
      if (paramObject != null) {
        UFTBaseUploadFileOp.UploadFileOpRetData.b((UFTBaseUploadFileOp.UploadFileOpRetData)localObject, paramObject.c());
      }
      UFTBaseUploadFileOp.UploadFileOpRetData.c((UFTBaseUploadFileOp.UploadFileOpRetData)localObject, a());
      a((UFTBaseUploadFileOp.UploadFileOpRetData)localObject);
    }
  }
  
  public abstract boolean a();
  
  public long b()
  {
    if (this.l > 0L)
    {
      long l1;
      if (this.m > this.l) {
        l1 = this.m;
      }
      for (long l2 = this.l;; l2 = this.l)
      {
        return l1 - l2;
        l1 = System.currentTimeMillis();
        if (l1 <= this.l) {
          break;
        }
      }
    }
    return 0L;
  }
  
  public void b(String paramString) {}
  
  public long d()
  {
    if (this.e) {
      return 0L;
    }
    long l2 = b();
    if (l2 <= 0L) {
      return 0L;
    }
    long l1;
    if (k() > j()) {
      l1 = k() - j();
    } else {
      l1 = 0L;
    }
    if (l1 < 1024L) {
      return 0L;
    }
    float f = (float)l2 / 1000.0F;
    return ((float)l1 / f);
  }
  
  public void dx_()
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("TId[");
    ((StringBuilder)localObject).append(i());
    ((StringBuilder)localObject).append("] on upload url or file id outdate");
    UFTLog.d("[UFTTransfer] UFTUploadFileBaseOp", 1, ((StringBuilder)localObject).toString());
    if (!this.j)
    {
      localObject = this.d;
      if (localObject != null) {
        ((UFTBaseUploadFileOp.UFTUploadFileOpCallback)localObject).a();
      }
    }
  }
  
  public int e()
  {
    this.e = false;
    return super.e();
  }
  
  public void f()
  {
    super.f();
    this.d = null;
    IUFTFileUploader localIUFTFileUploader = this.c;
    if (localIUFTFileUploader != null) {
      localIUFTFileUploader.a();
    }
  }
  
  public long j()
  {
    IUFTFileUploader localIUFTFileUploader = this.c;
    if (localIUFTFileUploader != null) {
      return localIUFTFileUploader.f();
    }
    return 0L;
  }
  
  public long k()
  {
    IUFTFileUploader localIUFTFileUploader = this.c;
    if (localIUFTFileUploader != null) {
      return localIUFTFileUploader.e();
    }
    return 0L;
  }
  
  public int l()
  {
    IUFTFileUploader localIUFTFileUploader = this.c;
    if (localIUFTFileUploader != null) {
      return localIUFTFileUploader.b();
    }
    return 0;
  }
  
  public String m()
  {
    IUFTFileUploader localIUFTFileUploader = this.c;
    if (localIUFTFileUploader != null) {
      return localIUFTFileUploader.d();
    }
    return "";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.uftransfer.task.upload.UFTBaseUploadFileOp
 * JD-Core Version:    0.7.0.1
 */