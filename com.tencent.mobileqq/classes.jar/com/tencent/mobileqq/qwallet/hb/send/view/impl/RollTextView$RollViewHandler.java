package com.tencent.mobileqq.qwallet.hb.send.view.impl;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import java.lang.ref.WeakReference;

class RollTextView$RollViewHandler
  extends Handler
{
  WeakReference<RollTextView> a;
  
  RollTextView$RollViewHandler(RollTextView paramRollTextView)
  {
    this.a = new WeakReference(paramRollTextView);
  }
  
  public void handleMessage(Message paramMessage)
  {
    RollTextView localRollTextView = (RollTextView)this.a.get();
    if (localRollTextView == null) {
      return;
    }
    Bundle localBundle = paramMessage.getData();
    if (localBundle == null) {
      return;
    }
    if (paramMessage.what != 1) {
      return;
    }
    localRollTextView.setText(localBundle.getString("content"));
    if (RollTextView.a(localRollTextView) != null) {
      RollTextView.a(localRollTextView).a(null);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.qwallet.hb.send.view.impl.RollTextView.RollViewHandler
 * JD-Core Version:    0.7.0.1
 */