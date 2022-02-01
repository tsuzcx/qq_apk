package com.tencent.qqmini.sdk.runtime;

class BaseUIProxy$2
  implements BaseRuntimeLoader.OnAppRuntimeLoadListener
{
  BaseUIProxy$2(BaseUIProxy paramBaseUIProxy) {}
  
  public void onResult(int paramInt, String paramString, BaseRuntimeLoader paramBaseRuntimeLoader)
  {
    if ((paramInt == 0) && (paramBaseRuntimeLoader != null))
    {
      if (paramBaseRuntimeLoader == this.this$0.mCurrRuntimeLoader) {
        this.this$0.onRuntimeReady();
      }
    }
    else {
      this.this$0.onRuntimeFail(paramInt, paramString);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.qqmini.sdk.runtime.BaseUIProxy.2
 * JD-Core Version:    0.7.0.1
 */