package com.tencent.mobileqq.mini.appbrand.ui;

import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;

class PreloadingFragment$10
  implements Runnable
{
  PreloadingFragment$10(PreloadingFragment paramPreloadingFragment, String paramString) {}
  
  public void run()
  {
    try
    {
      QQToast.makeText(this.this$0.getBaseActivity(), this.val$msg, 0).show();
      return;
    }
    catch (Throwable localThrowable)
    {
      QLog.e("PreloadingFragment", 1, "", localThrowable);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.mini.appbrand.ui.PreloadingFragment.10
 * JD-Core Version:    0.7.0.1
 */