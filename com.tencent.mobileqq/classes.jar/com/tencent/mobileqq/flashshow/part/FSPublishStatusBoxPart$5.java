package com.tencent.mobileqq.flashshow.part;

import android.os.Handler;
import com.tencent.biz.richframework.delegate.impl.RFThreadManager;
import com.tencent.mobileqq.flashshow.widgets.RoundProgressBar;

class FSPublishStatusBoxPart$5
  implements Runnable
{
  FSPublishStatusBoxPart$5(FSPublishStatusBoxPart paramFSPublishStatusBoxPart) {}
  
  public void run()
  {
    FSPublishStatusBoxPart.d(this.this$0);
    RoundProgressBar localRoundProgressBar = FSPublishStatusBoxPart.g(this.this$0);
    FSPublishStatusBoxPart localFSPublishStatusBoxPart = this.this$0;
    localRoundProgressBar.setProgress(FSPublishStatusBoxPart.a(localFSPublishStatusBoxPart, FSPublishStatusBoxPart.e(localFSPublishStatusBoxPart), FSPublishStatusBoxPart.f(this.this$0)));
    RFThreadManager.getUIHandler().postDelayed(this.this$0.b, 200L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.flashshow.part.FSPublishStatusBoxPart.5
 * JD-Core Version:    0.7.0.1
 */