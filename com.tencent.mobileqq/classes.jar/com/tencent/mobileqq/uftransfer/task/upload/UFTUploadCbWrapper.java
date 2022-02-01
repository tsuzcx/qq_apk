package com.tencent.mobileqq.uftransfer.task.upload;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import com.tencent.mobileqq.uftransfer.api.IUFTTransferKey;
import com.tencent.mobileqq.uftransfer.api.IUFTUploadCallback;
import com.tencent.mobileqq.uftransfer.api.IUFTUploadCompleteInfo;
import com.tencent.mobileqq.uftransfer.api.IUFTUploadSendMsgCallback;
import com.tencent.mobileqq.uftransfer.api.UFTFileLocalInfo;
import com.tencent.mobileqq.uftransfer.api.UFTFileUploadBusinessInfo;

public class UFTUploadCbWrapper
  implements IUFTUploadCallback
{
  final IUFTUploadCallback a;
  final UFTUploadCbWrapper.IWrapperHost b;
  final Handler c;
  long d = 0L;
  boolean e = false;
  
  public UFTUploadCbWrapper(UFTUploadCbWrapper.IWrapperHost paramIWrapperHost, IUFTUploadCallback paramIUFTUploadCallback)
  {
    this.b = paramIWrapperHost;
    this.a = paramIUFTUploadCallback;
    this.c = new Handler(Looper.getMainLooper());
  }
  
  private boolean a()
  {
    UFTUploadCbWrapper.IWrapperHost localIWrapperHost = this.b;
    if (localIWrapperHost != null) {
      return localIWrapperHost.a();
    }
    return false;
  }
  
  public int a(IUFTTransferKey paramIUFTTransferKey, Bundle paramBundle, IUFTUploadSendMsgCallback paramIUFTUploadSendMsgCallback)
  {
    this.c.post(new UFTUploadCbWrapper.7(this, paramIUFTTransferKey, paramBundle, paramIUFTUploadSendMsgCallback));
    return 0;
  }
  
  public void a(IUFTTransferKey paramIUFTTransferKey)
  {
    if (a()) {
      return;
    }
    this.c.post(new UFTUploadCbWrapper.1(this, paramIUFTTransferKey));
  }
  
  public void a(IUFTTransferKey paramIUFTTransferKey, int paramInt, Bundle paramBundle)
  {
    if (a()) {
      return;
    }
    this.c.post(new UFTUploadCbWrapper.4(this, paramIUFTTransferKey, paramInt, paramBundle));
  }
  
  public void a(IUFTTransferKey paramIUFTTransferKey, int paramInt, IUFTUploadCompleteInfo paramIUFTUploadCompleteInfo)
  {
    this.c.post(new UFTUploadCbWrapper.3(this, paramIUFTTransferKey, paramInt, paramIUFTUploadCompleteInfo));
  }
  
  public void a(IUFTTransferKey paramIUFTTransferKey, long paramLong1, long paramLong2)
  {
    if (a()) {
      return;
    }
    IUFTUploadCallback localIUFTUploadCallback = this.a;
    if (localIUFTUploadCallback != null) {
      localIUFTUploadCallback.a(paramIUFTTransferKey, paramLong1, paramLong2);
    }
  }
  
  public void a(IUFTTransferKey paramIUFTTransferKey, long paramLong1, long paramLong2, long paramLong3)
  {
    if (a()) {
      return;
    }
    long l1 = System.currentTimeMillis();
    long l2 = this.d;
    if ((l2 == 0L) || (l1 - l2 >= 1000L))
    {
      this.d = l1;
      this.c.post(new UFTUploadCbWrapper.2(this, paramIUFTTransferKey, paramLong1, paramLong2, paramLong3));
    }
  }
  
  public void a(IUFTTransferKey paramIUFTTransferKey, UFTFileLocalInfo paramUFTFileLocalInfo)
  {
    if (a()) {
      return;
    }
    this.c.post(new UFTUploadCbWrapper.5(this, paramIUFTTransferKey, paramUFTFileLocalInfo));
  }
  
  public void a(IUFTTransferKey paramIUFTTransferKey, UFTFileUploadBusinessInfo paramUFTFileUploadBusinessInfo)
  {
    if (a()) {
      return;
    }
    this.c.post(new UFTUploadCbWrapper.6(this, paramIUFTTransferKey, paramUFTFileUploadBusinessInfo));
  }
  
  public void a(boolean paramBoolean)
  {
    this.e = paramBoolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.uftransfer.task.upload.UFTUploadCbWrapper
 * JD-Core Version:    0.7.0.1
 */