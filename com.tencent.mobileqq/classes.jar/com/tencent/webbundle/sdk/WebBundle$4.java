package com.tencent.webbundle.sdk;

import android.content.MutableContextWrapper;
import android.os.Handler;

class WebBundle$4
  implements Runnable
{
  WebBundle$4(WebBundle paramWebBundle, WebBundle.WebBundlePreloadState paramWebBundlePreloadState) {}
  
  public void run()
  {
    if (WebBundle.access$200(this.this$0).ordinal() >= this.val$state.ordinal()) {
      WebBundleManager.getInstance(WebBundle.access$000(this.this$0)).log(6, "WebBundle.WebBundle", new String[] { "ignore this invalidate state. current state is ", String.valueOf(WebBundle.access$200(this.this$0)), " new state is ", String.valueOf(this.val$state) });
    }
    do
    {
      return;
      WebBundle.access$202(this.this$0, this.val$state);
      WebBundle.access$300(this.this$0, this.val$state);
      if (WebBundle.access$200(this.this$0) == WebBundle.WebBundlePreloadState.SUCCESS)
      {
        ThreadManager.getUiHandler().removeCallbacks(WebBundle.access$400(this.this$0));
        this.this$0.resetContext(WebBundle.access$500(this.this$0).getApplicationContext());
        return;
      }
    } while (WebBundle.access$200(this.this$0) != WebBundle.WebBundlePreloadState.FAILED);
    this.this$0.destroy();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.webbundle.sdk.WebBundle.4
 * JD-Core Version:    0.7.0.1
 */