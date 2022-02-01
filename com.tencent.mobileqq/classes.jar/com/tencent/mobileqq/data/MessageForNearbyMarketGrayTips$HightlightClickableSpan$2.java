package com.tencent.mobileqq.data;

import android.text.TextUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.nearby.INearbyCardManager;
import com.tencent.qphone.base.util.QLog;

class MessageForNearbyMarketGrayTips$HightlightClickableSpan$2
  implements Runnable
{
  MessageForNearbyMarketGrayTips$HightlightClickableSpan$2(MessageForNearbyMarketGrayTips.HightlightClickableSpan paramHightlightClickableSpan, QQAppInterface paramQQAppInterface) {}
  
  public void run()
  {
    Object localObject1 = (INearbyCardManager)this.a.getManager(QQManagerFactory.NEARBY_CARD_MANAGER);
    MessageForNearbyMarketGrayTips.HightlightClickableSpan.a(this.this$0, ((INearbyCardManager)localObject1).c());
    localObject1 = this.this$0;
    Object localObject2 = ((MessageForNearbyMarketGrayTips.HightlightClickableSpan)localObject1).a(MessageForNearbyMarketGrayTips.HightlightClickableSpan.a((MessageForNearbyMarketGrayTips.HightlightClickableSpan)localObject1), false);
    localObject1 = localObject2;
    if (TextUtils.isEmpty((CharSequence)localObject2))
    {
      localObject1 = this.this$0;
      localObject1 = ((MessageForNearbyMarketGrayTips.HightlightClickableSpan)localObject1).a(MessageForNearbyMarketGrayTips.HightlightClickableSpan.a((MessageForNearbyMarketGrayTips.HightlightClickableSpan)localObject1), true);
    }
    this.this$0.c((String)localObject1);
    if (QLog.isColorLevel())
    {
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("ACTION_AUTO_INPUT_FACE_SCORE  faceScoreWording=");
      ((StringBuilder)localObject2).append((String)localObject1);
      QLog.d("MessageForNearbyMarketGrayTipsQ..troop.faceScore", 2, ((StringBuilder)localObject2).toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.data.MessageForNearbyMarketGrayTips.HightlightClickableSpan.2
 * JD-Core Version:    0.7.0.1
 */