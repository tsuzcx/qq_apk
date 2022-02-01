package com.tencent.mobileqq.triton.api;

import com.tencent.mobileqq.triton.engine.TTEngine;
import com.tencent.mobileqq.triton.sdk.IQQEnv;
import com.tencent.mobileqq.triton.sdk.callback.DialogCallback;

class TTChannel$a
  implements DialogCallback
{
  TTChannel$a(TTChannel paramTTChannel) {}
  
  public void onCancel()
  {
    TTChannel localTTChannel = this.a;
    localTTChannel.nativeCancelErrorDialog(TTChannel.a(localTTChannel).k());
  }
  
  public void onConfirm()
  {
    this.a.nativeConfirmErrorDialog();
    TTChannel.a(this.a).l().cleanCache();
    TTChannel.a(this.a).l().killSelf(TTChannel.a(this.a).b());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.triton.api.TTChannel.a
 * JD-Core Version:    0.7.0.1
 */