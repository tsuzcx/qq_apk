package com.tencent.mobileqq.mini.widget.media.live;

import com.tencent.qphone.base.util.QLog;

class TXLivePusherJSAdapter$1
  implements Runnable
{
  TXLivePusherJSAdapter$1(TXLivePusherJSAdapter paramTXLivePusherJSAdapter, int paramInt) {}
  
  public void run()
  {
    TXLivePusherJSAdapter.access$002(this.this$0, this.val$angle);
    if (QLog.isColorLevel()) {
      QLog.d("TXLivePusherJSAdapter", 2, "notifyOrientationChanged, angle:" + this.val$angle + ", orientation:" + TXLivePusherJSAdapter.access$100(this.this$0));
    }
    TXLivePusherJSAdapter.access$200(this.this$0, this.val$angle, TXLivePusherJSAdapter.access$100(this.this$0));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.mini.widget.media.live.TXLivePusherJSAdapter.1
 * JD-Core Version:    0.7.0.1
 */