package com.tencent.mobileqq.qwallet.hb.send.view.impl;

import android.os.Bundle;
import android.os.Message;

class RollTextView$ContentSupplyThread
  implements Runnable
{
  RollTextView$ContentSupplyThread(RollTextView paramRollTextView) {}
  
  public void run()
  {
    if (RollTextView.e(this.this$0)) {
      try
      {
        Thread.sleep(RollTextView.f(this.this$0) * 170);
      }
      catch (InterruptedException localInterruptedException1)
      {
        localInterruptedException1.printStackTrace();
      }
    }
    Bundle localBundle;
    while ((RollTextView.g(this.this$0) != RollTextView.h(this.this$0)) && (this.this$0.a)) {
      try
      {
        int i = RollTextView.g(this.this$0);
        Message localMessage1 = RollTextView.i(this.this$0).obtainMessage();
        localMessage1.what = 1;
        localBundle = new Bundle();
        localBundle.putString("content", Integer.toString(i % 10));
        localMessage1.setData(localBundle);
        RollTextView.i(this.this$0).sendMessage(localMessage1);
        Thread.sleep(170L);
        if (RollTextView.g(this.this$0) > RollTextView.h(this.this$0)) {
          RollTextView.j(this.this$0);
        } else {
          RollTextView.k(this.this$0);
        }
      }
      catch (InterruptedException localInterruptedException2)
      {
        localInterruptedException2.printStackTrace();
      }
    }
    if (RollTextView.g(this.this$0) == RollTextView.h(this.this$0))
    {
      Message localMessage2 = RollTextView.i(this.this$0).obtainMessage();
      localMessage2.what = 1;
      localBundle = new Bundle();
      localBundle.putString("content", Integer.toString(RollTextView.g(this.this$0) % 10));
      localMessage2.setData(localBundle);
      RollTextView.i(this.this$0).sendMessage(localMessage2);
    }
    if (RollTextView.a(this.this$0) != null) {
      RollTextView.a(this.this$0).b();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.qwallet.hb.send.view.impl.RollTextView.ContentSupplyThread
 * JD-Core Version:    0.7.0.1
 */