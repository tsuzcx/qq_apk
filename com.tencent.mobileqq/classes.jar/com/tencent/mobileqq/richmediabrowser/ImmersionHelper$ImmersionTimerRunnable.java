package com.tencent.mobileqq.richmediabrowser;

import com.tencent.mobileqq.richmediabrowser.presenter.AIOBrowserBasePresenter;
import com.tencent.mobileqq.richmediabrowser.view.AIOBrowserBaseView;
import com.tencent.richmediabrowser.log.BrowserLogHelper;
import com.tencent.richmediabrowser.log.IBrowserLog;

class ImmersionHelper$ImmersionTimerRunnable
  implements Runnable
{
  private ImmersionHelper$ImmersionTimerRunnable(ImmersionHelper paramImmersionHelper) {}
  
  public void run()
  {
    BrowserLogHelper.getInstance().getGalleryLog().d("ImmersionHelper", 2, "ImmersionTimerRunnable run");
    ImmersionHelper localImmersionHelper = this.this$0;
    localImmersionHelper.a = true;
    if (ImmersionHelper.a(localImmersionHelper).b != null) {
      ImmersionHelper.a(this.this$0).b.e(false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.richmediabrowser.ImmersionHelper.ImmersionTimerRunnable
 * JD-Core Version:    0.7.0.1
 */