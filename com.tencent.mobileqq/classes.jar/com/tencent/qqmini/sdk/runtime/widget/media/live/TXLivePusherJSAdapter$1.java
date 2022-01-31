package com.tencent.qqmini.sdk.runtime.widget.media.live;

import bhlm;
import com.tencent.qqmini.sdk.log.QMLog;

public class TXLivePusherJSAdapter$1
  implements Runnable
{
  public void run()
  {
    bhlm.a(this.this$0, this.a);
    if (QMLog.isColorLevel()) {
      QMLog.d("TXLivePusherJSAdapter", "notifyOrientationChanged, angle:" + this.a + ", orientation:" + bhlm.a(this.this$0));
    }
    bhlm.a(this.this$0, this.a, bhlm.a(this.this$0));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.qqmini.sdk.runtime.widget.media.live.TXLivePusherJSAdapter.1
 * JD-Core Version:    0.7.0.1
 */