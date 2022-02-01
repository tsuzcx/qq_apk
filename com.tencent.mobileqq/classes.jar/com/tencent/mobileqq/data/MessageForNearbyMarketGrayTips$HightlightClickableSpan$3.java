package com.tencent.mobileqq.data;

import com.tencent.qphone.base.util.QLog;

class MessageForNearbyMarketGrayTips$HightlightClickableSpan$3
  implements Runnable
{
  MessageForNearbyMarketGrayTips$HightlightClickableSpan$3(MessageForNearbyMarketGrayTips.HightlightClickableSpan paramHightlightClickableSpan) {}
  
  public void run()
  {
    String str = this.this$0.a(MessageForNearbyMarketGrayTips.HightlightClickableSpan.a(this.this$0), true);
    this.this$0.c(str);
    if (QLog.isColorLevel()) {
      QLog.d("MessageForNearbyMarketGrayTipsQ..troop.faceScore", 2, "ACTION_AUTO_INPUT_FACE_SCORE. from file. FaceScoreWording=" + str);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.data.MessageForNearbyMarketGrayTips.HightlightClickableSpan.3
 * JD-Core Version:    0.7.0.1
 */