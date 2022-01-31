package com.tencent.qg.sdk.doraemon.impl;

import com.tencent.qg.sdk.doraemon.DoraemonApiWrapper.ApiCallback;

class DoraemonApiWrapperMockImpl$1$1
  implements Runnable
{
  DoraemonApiWrapperMockImpl$1$1(DoraemonApiWrapperMockImpl.1 param1, DoraemonApiWrapper.ApiCallback paramApiCallback, String paramString) {}
  
  public void run()
  {
    this.val$apiCallback.onSuccess(this.val$result);
    this.val$apiCallback.onComplete();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.qg.sdk.doraemon.impl.DoraemonApiWrapperMockImpl.1.1
 * JD-Core Version:    0.7.0.1
 */