package com.tencent.qqmini.miniapp.widget.media.live;

import com.tencent.qqmini.sdk.launcher.log.QMLog;

class TXLivePusherJSAdapter$1
  implements Runnable
{
  TXLivePusherJSAdapter$1(TXLivePusherJSAdapter paramTXLivePusherJSAdapter, int paramInt) {}
  
  public void run()
  {
    TXLivePusherJSAdapter.access$002(this.this$0, this.val$angle);
    if (QMLog.isColorLevel()) {
      QMLog.d("TXLivePusherJSAdapter", "notifyOrientationChanged, angle:" + this.val$angle + ", orientation:" + TXLivePusherJSAdapter.access$100(this.this$0));
    }
    TXLivePusherJSAdapter.access$200(this.this$0, this.val$angle, TXLivePusherJSAdapter.access$100(this.this$0));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.miniapp.widget.media.live.TXLivePusherJSAdapter.1
 * JD-Core Version:    0.7.0.1
 */