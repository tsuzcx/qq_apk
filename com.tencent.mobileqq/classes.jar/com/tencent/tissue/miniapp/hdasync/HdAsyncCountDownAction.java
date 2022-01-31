package com.tencent.tissue.miniapp.hdasync;

import android.os.Looper;
import java.util.concurrent.atomic.AtomicInteger;

public abstract class HdAsyncCountDownAction
  extends BaseAction
{
  private AtomicInteger countDownNum;
  
  public HdAsyncCountDownAction(Looper paramLooper)
  {
    super(paramLooper);
  }
  
  public abstract HdAsyncCountDownResult call(Object paramObject);
  
  public HdAsyncCountDownResult doNextByCountDown(boolean paramBoolean)
  {
    return doNextByCountDown(paramBoolean, null);
  }
  
  public HdAsyncCountDownResult doNextByCountDown(boolean paramBoolean, Object paramObject)
  {
    if ((!paramBoolean) || (this.countDownNum == null)) {
      return new HdAsyncCountDownResult(false, paramObject);
    }
    if (this.countDownNum.decrementAndGet() == 0) {
      return new HdAsyncCountDownResult(true, paramObject);
    }
    return new HdAsyncCountDownResult(false, paramObject);
  }
  
  public void setCountDownNum(AtomicInteger paramAtomicInteger)
  {
    this.countDownNum = paramAtomicInteger;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.tissue.miniapp.hdasync.HdAsyncCountDownAction
 * JD-Core Version:    0.7.0.1
 */