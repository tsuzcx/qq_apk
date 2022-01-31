package com.tencent.mobileqq.triton.api;

import com.tencent.mobileqq.triton.engine.TTEngine;
import com.tencent.mobileqq.triton.sdk.IQQEnv;
import com.tencent.mobileqq.triton.sdk.callback.DialogCallback;

class TTChannel$1
  implements DialogCallback
{
  TTChannel$1(TTChannel paramTTChannel) {}
  
  public void onCancel()
  {
    this.this$0.nativeCancelErrorDialog(TTChannel.access$000(this.this$0).getNativeTTAppHandle());
  }
  
  public void onConfirm()
  {
    this.this$0.nativeConfirmErrorDialog();
    TTChannel.access$000(this.this$0).getQQEnv().cleanCache();
    TTChannel.access$000(this.this$0).getQQEnv().killSelf(TTChannel.access$000(this.this$0).getAttachedActivity());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.triton.api.TTChannel.1
 * JD-Core Version:    0.7.0.1
 */