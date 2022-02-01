package com.tencent.qqmini.sdk.runtime;

class AppUIProxy$4
  implements Runnable
{
  AppUIProxy$4(AppUIProxy paramAppUIProxy) {}
  
  public void run()
  {
    if (this.this$0.mCurrRuntimeLoader != null)
    {
      if (this.this$0.mCurrRuntimeLoader.dismissLoadingAfterLoaded()) {
        break label87;
      }
      this.this$0.mCurrRuntimeLoader.addRuntimeStateObserver(new AppUIProxy.4.1(this));
    }
    for (;;)
    {
      this.this$0.mCurrRuntimeLoader.startLoadMiniAppContent(this.this$0.mCurrRuntimeLoader.needReloadPage());
      this.this$0.mCurrRuntimeLoader.onAttachActivity(this.this$0.mActivity, null, this.this$0.mRootLayout);
      return;
      label87:
      this.this$0.hideLoading();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.qqmini.sdk.runtime.AppUIProxy.4
 * JD-Core Version:    0.7.0.1
 */