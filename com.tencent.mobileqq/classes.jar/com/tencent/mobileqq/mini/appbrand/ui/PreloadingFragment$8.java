package com.tencent.mobileqq.mini.appbrand.ui;

import bcpw;
import com.tencent.qphone.base.util.QLog;

class PreloadingFragment$8
  implements Runnable
{
  PreloadingFragment$8(PreloadingFragment paramPreloadingFragment, String paramString) {}
  
  public void run()
  {
    try
    {
      bcpw.a(this.this$0.getActivity(), this.val$msg, 0).a();
      return;
    }
    catch (Throwable localThrowable)
    {
      QLog.e("PreloadingFragment", 1, "", localThrowable);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.mini.appbrand.ui.PreloadingFragment.8
 * JD-Core Version:    0.7.0.1
 */