package com.tencent.mobileqq.qwallet.hb.send.view.impl;

import android.os.Bundle;
import android.os.Message;

class RollTextView$ContentSupplyThread
  implements Runnable
{
  RollTextView$ContentSupplyThread(RollTextView paramRollTextView) {}
  
  public void run()
  {
    if (RollTextView.a(this.this$0)) {
      try
      {
        Thread.sleep(RollTextView.c(this.this$0) * 170);
      }
      catch (InterruptedException localInterruptedException1)
      {
        localInterruptedException1.printStackTrace();
      }
    }
    Bundle localBundle;
    while ((RollTextView.d(this.this$0) != RollTextView.e(this.this$0)) && (this.this$0.a)) {
      try
      {
        int i = RollTextView.d(this.this$0);
        Message localMessage1 = RollTextView.a(this.this$0).obtainMessage();
        localMessage1.what = 1;
        localBundle = new Bundle();
        localBundle.putString("content", Integer.toString(i % 10));
        localMessage1.setData(localBundle);
        RollTextView.a(this.this$0).sendMessage(localMessage1);
        Thread.sleep(170L);
        if (RollTextView.d(this.this$0) > RollTextView.e(this.this$0)) {
          RollTextView.f(this.this$0);
        } else {
          RollTextView.g(this.this$0);
        }
      }
      catch (InterruptedException localInterruptedException2)
      {
        localInterruptedException2.printStackTrace();
      }
    }
    if (RollTextView.d(this.this$0) == RollTextView.e(this.this$0))
    {
      Message localMessage2 = RollTextView.a(this.this$0).obtainMessage();
      localMessage2.what = 1;
      localBundle = new Bundle();
      localBundle.putString("content", Integer.toString(RollTextView.d(this.this$0) % 10));
      localMessage2.setData(localBundle);
      RollTextView.a(this.this$0).sendMessage(localMessage2);
    }
    if (RollTextView.a(this.this$0) != null) {
      RollTextView.a(this.this$0).b();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.qwallet.hb.send.view.impl.RollTextView.ContentSupplyThread
 * JD-Core Version:    0.7.0.1
 */