package com.tencent.mobileqq.richmediabrowser;

import axug;
import axvd;
import com.tencent.richmediabrowser.log.BrowserLogHelper;
import com.tencent.richmediabrowser.log.IBrowserLog;

class ImmersionHelper$ImmersionTimerRunnable
  implements Runnable
{
  private ImmersionHelper$ImmersionTimerRunnable(ImmersionHelper paramImmersionHelper) {}
  
  public void run()
  {
    BrowserLogHelper.getInstance().getGalleryLog().d("ImmersionHelper", 2, "ImmersionTimerRunnable run");
    this.this$0.a = true;
    if (ImmersionHelper.a(this.this$0).a != null) {
      ImmersionHelper.a(this.this$0).a.d(false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.richmediabrowser.ImmersionHelper.ImmersionTimerRunnable
 * JD-Core Version:    0.7.0.1
 */