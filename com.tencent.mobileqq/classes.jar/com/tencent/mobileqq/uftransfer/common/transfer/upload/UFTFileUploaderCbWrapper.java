package com.tencent.mobileqq.uftransfer.common.transfer.upload;

import com.tencent.mobileqq.uftransfer.UFTLogicThread;
import com.tencent.mobileqq.uftransfer.common.transfer.IUFTFileUploaderCallback;

public abstract class UFTFileUploaderCbWrapper
  implements IUFTFileUploaderCallback
{
  protected IUFTFileUploaderCallback a;
  protected boolean b = false;
  protected long e = 0L;
  
  public final void a(long paramLong1, long paramLong2, long paramLong3)
  {
    long l1 = System.currentTimeMillis();
    long l2 = this.e;
    if ((l2 == 0L) || (l1 - l2 >= 1000L))
    {
      this.e = l1;
      IUFTFileUploaderCallback localIUFTFileUploaderCallback = this.a;
      if (localIUFTFileUploaderCallback != null) {
        localIUFTFileUploaderCallback.a(paramLong1, paramLong2, paramLong3);
      }
    }
  }
  
  public final void a(long paramLong, String paramString1, String paramString2)
  {
    UFTLogicThread.a().a(new UFTFileUploaderCbWrapper.2(this, paramLong, paramString1, paramString2));
  }
  
  public void a(Object paramObject)
  {
    UFTLogicThread.a().a(new UFTFileUploaderCbWrapper.7(this, paramObject));
  }
  
  public final void a(String paramString)
  {
    UFTLogicThread.a().a(new UFTFileUploaderCbWrapper.5(this, paramString));
  }
  
  public void a(boolean paramBoolean)
  {
    this.b = paramBoolean;
  }
  
  public final void a(boolean paramBoolean, int paramInt, long paramLong, String paramString1, String paramString2, Object paramObject)
  {
    UFTLogicThread.a().a(new UFTFileUploaderCbWrapper.4(this, paramBoolean, paramInt, paramLong, paramString1, paramString2, paramObject));
  }
  
  public final void a(boolean paramBoolean, Object paramObject)
  {
    UFTLogicThread.a().a(new UFTFileUploaderCbWrapper.1(this, paramBoolean, paramObject));
  }
  
  public final void aS_()
  {
    UFTLogicThread.a().a(new UFTFileUploaderCbWrapper.3(this));
  }
  
  protected void b(IUFTFileUploaderCallback paramIUFTFileUploaderCallback)
  {
    this.a = paramIUFTFileUploaderCallback;
  }
  
  public final void b(String paramString)
  {
    UFTLogicThread.a().a(new UFTFileUploaderCbWrapper.6(this, paramString));
  }
  
  public abstract boolean c();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.uftransfer.common.transfer.upload.UFTFileUploaderCbWrapper
 * JD-Core Version:    0.7.0.1
 */