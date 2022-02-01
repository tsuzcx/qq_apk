package com.tencent.mobileqq.uftransfer.task;

import com.tencent.mobileqq.uftransfer.UFTLogicThread;
import com.tencent.mobileqq.uftransfer.api.impl.UFTTransferKey;
import com.tencent.mobileqq.uftransfer.task.taskinfo.UFTBaseTaskInfo;
import mqq.app.AppRuntime;

public abstract class UFTBaseOp
{
  private UFTBaseOp.UFTOpCallback a;
  private String b;
  protected final AppRuntime g;
  protected final UFTBaseTaskInfo h;
  protected final UFTTransferKey i;
  protected boolean j = false;
  protected UFTBaseOp.OpRetData k;
  protected long l = 0L;
  protected long m = 0L;
  
  public UFTBaseOp(AppRuntime paramAppRuntime, UFTBaseTaskInfo paramUFTBaseTaskInfo, UFTTransferKey paramUFTTransferKey, UFTBaseOp.UFTOpCallback paramUFTOpCallback)
  {
    this.g = paramAppRuntime;
    this.h = paramUFTBaseTaskInfo;
    this.i = paramUFTTransferKey;
    this.a = paramUFTOpCallback;
  }
  
  protected final void a(UFTBaseOp.OpRetData paramOpRetData)
  {
    if (this.j) {
      return;
    }
    this.m = System.currentTimeMillis();
    this.b = paramOpRetData.b();
    UFTBaseOp.OpRetData.a(paramOpRetData, this.l);
    UFTBaseOp.OpRetData.b(paramOpRetData, this.m);
    this.k = paramOpRetData;
    if (this.a == null) {
      return;
    }
    UFTLogicThread.a().a(new UFTBaseOp.1(this, paramOpRetData));
  }
  
  protected final void b(long paramLong1, long paramLong2)
  {
    if (this.j) {
      return;
    }
    UFTBaseOp.UFTOpCallback localUFTOpCallback = this.a;
    if (localUFTOpCallback != null) {
      localUFTOpCallback.a(paramLong1, paramLong2);
    }
  }
  
  protected abstract int c();
  
  public void c(String paramString)
  {
    this.b = paramString;
    f();
  }
  
  public int e()
  {
    this.l = System.currentTimeMillis();
    this.m = 0L;
    this.j = false;
    return c();
  }
  
  public void f()
  {
    this.m = System.currentTimeMillis();
    this.j = true;
    this.a = null;
  }
  
  public String h()
  {
    return this.b;
  }
  
  public long i()
  {
    return this.i.b();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.uftransfer.task.UFTBaseOp
 * JD-Core Version:    0.7.0.1
 */