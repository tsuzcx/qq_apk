package com.tencent.mobileqq.data;

import com.tencent.qphone.base.util.QLog;

class MessageForNearbyMarketGrayTips$HightlightClickableSpan$3
  implements Runnable
{
  MessageForNearbyMarketGrayTips$HightlightClickableSpan$3(MessageForNearbyMarketGrayTips.HightlightClickableSpan paramHightlightClickableSpan) {}
  
  public void run()
  {
    Object localObject = this.this$0;
    localObject = ((MessageForNearbyMarketGrayTips.HightlightClickableSpan)localObject).a(MessageForNearbyMarketGrayTips.HightlightClickableSpan.a((MessageForNearbyMarketGrayTips.HightlightClickableSpan)localObject), true);
    this.this$0.c((String)localObject);
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("ACTION_AUTO_INPUT_FACE_SCORE. from file. FaceScoreWording=");
      localStringBuilder.append((String)localObject);
      QLog.d("MessageForNearbyMarketGrayTipsQ..troop.faceScore", 2, localStringBuilder.toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.data.MessageForNearbyMarketGrayTips.HightlightClickableSpan.3
 * JD-Core Version:    0.7.0.1
 */