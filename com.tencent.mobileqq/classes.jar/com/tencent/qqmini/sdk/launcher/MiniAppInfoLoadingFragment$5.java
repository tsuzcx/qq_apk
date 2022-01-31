package com.tencent.qqmini.sdk.launcher;

import bdit;
import bdnw;

class MiniAppInfoLoadingFragment$5
  implements Runnable
{
  MiniAppInfoLoadingFragment$5(MiniAppInfoLoadingFragment paramMiniAppInfoLoadingFragment, String paramString) {}
  
  public void run()
  {
    try
    {
      bdit.a(this.this$0.getActivity(), this.a, 0).a();
      return;
    }
    catch (Throwable localThrowable)
    {
      bdnw.d("MiniAppInfoLoadingFragment", "", localThrowable);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.sdk.launcher.MiniAppInfoLoadingFragment.5
 * JD-Core Version:    0.7.0.1
 */