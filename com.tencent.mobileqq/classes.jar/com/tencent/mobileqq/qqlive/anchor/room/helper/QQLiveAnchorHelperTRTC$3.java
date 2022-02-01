package com.tencent.mobileqq.qqlive.anchor.room.helper;

import android.widget.FrameLayout;
import com.tencent.mobileqq.qqlive.data.anchor.room.QQLiveAnchorRoomConfig;
import com.tencent.mobileqq.qqlive.trtc.TRTCEngineProxy;

class QQLiveAnchorHelperTRTC$3
  implements Runnable
{
  QQLiveAnchorHelperTRTC$3(QQLiveAnchorHelperTRTC paramQQLiveAnchorHelperTRTC, FrameLayout paramFrameLayout, QQLiveAnchorRoomConfig paramQQLiveAnchorRoomConfig) {}
  
  public void run()
  {
    QQLiveAnchorHelperTRTC.a(this.this$0).a(this.a);
    QQLiveAnchorHelperTRTC.a(this.this$0).c();
    QQLiveAnchorHelperTRTC.a(this.this$0).d(this.b.cameraMirror);
    this.this$0.b = true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqlive.anchor.room.helper.QQLiveAnchorHelperTRTC.3
 * JD-Core Version:    0.7.0.1
 */