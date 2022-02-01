package com.tencent.mobileqq.mini.servlet;

import android.os.Bundle;
import com.tencent.qphone.base.util.QLog;

class MiniAppObserver$1
  implements Runnable
{
  MiniAppObserver$1(MiniAppObserver paramMiniAppObserver, int paramInt, boolean paramBoolean, Bundle paramBundle) {}
  
  public void run()
  {
    try
    {
      this.this$0.doOnReceive(this.val$id, this.val$isSuc, this.val$data);
      return;
    }
    catch (Throwable localThrowable)
    {
      QLog.e("[mini] MiniAppObserver", 1, "MiniAppObserver onReceive exception!", localThrowable);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.mini.servlet.MiniAppObserver.1
 * JD-Core Version:    0.7.0.1
 */