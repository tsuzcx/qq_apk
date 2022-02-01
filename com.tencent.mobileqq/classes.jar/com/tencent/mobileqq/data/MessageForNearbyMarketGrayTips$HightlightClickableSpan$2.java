package com.tencent.mobileqq.data;

import android.text.TextUtils;
import arut;
import axny;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.qphone.base.util.QLog;

public class MessageForNearbyMarketGrayTips$HightlightClickableSpan$2
  implements Runnable
{
  public MessageForNearbyMarketGrayTips$HightlightClickableSpan$2(arut paramarut, QQAppInterface paramQQAppInterface) {}
  
  public void run()
  {
    Object localObject = (axny)this.a.getManager(QQManagerFactory.NEARBY_CARD_MANAGER);
    arut.a(this.this$0, ((axny)localObject).b());
    String str = this.this$0.a(arut.a(this.this$0), false);
    localObject = str;
    if (TextUtils.isEmpty(str)) {
      localObject = this.this$0.a(arut.a(this.this$0), true);
    }
    this.this$0.c((String)localObject);
    if (QLog.isColorLevel()) {
      QLog.d("MessageForNearbyMarketGrayTipsQ..troop.faceScore", 2, "ACTION_AUTO_INPUT_FACE_SCORE  faceScoreWording=" + (String)localObject);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.data.MessageForNearbyMarketGrayTips.HightlightClickableSpan.2
 * JD-Core Version:    0.7.0.1
 */