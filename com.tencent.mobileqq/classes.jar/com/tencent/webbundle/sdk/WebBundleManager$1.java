package com.tencent.webbundle.sdk;

class WebBundleManager$1
  implements Runnable
{
  WebBundleManager$1(WebBundleManager paramWebBundleManager) {}
  
  public void run()
  {
    if ((WebBundleManager.access$000(this.this$0)) && (WebBundleManager.access$100(this.this$0) != null) && (WebBundleManager.access$100(this.this$0).getContext() != null))
    {
      HybridIdleTaskHelper.PreloadWebBundleTask localPreloadWebBundleTask = new HybridIdleTaskHelper.PreloadWebBundleTask(WebBundleManager.access$100(this.this$0).getContext(), WebBundleManager.access$200(this.this$0));
      HybridIdleTaskHelper.getInstance().addIdleTask(localPreloadWebBundleTask);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.webbundle.sdk.WebBundleManager.1
 * JD-Core Version:    0.7.0.1
 */