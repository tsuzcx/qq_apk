package com.tencent.mobileqq.data;

import android.text.TextUtils;
import apaq;
import auqc;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;

public class MessageForNearbyMarketGrayTips$HightlightClickableSpan$2
  implements Runnable
{
  public MessageForNearbyMarketGrayTips$HightlightClickableSpan$2(apaq paramapaq, QQAppInterface paramQQAppInterface) {}
  
  public void run()
  {
    Object localObject = (auqc)this.a.getManager(106);
    apaq.a(this.this$0, ((auqc)localObject).b());
    String str = this.this$0.a(apaq.a(this.this$0), false);
    localObject = str;
    if (TextUtils.isEmpty(str)) {
      localObject = this.this$0.a(apaq.a(this.this$0), true);
    }
    this.this$0.c((String)localObject);
    if (QLog.isColorLevel()) {
      QLog.d("MessageForNearbyMarketGrayTipsQ..troop.faceScore", 2, "ACTION_AUTO_INPUT_FACE_SCORE  faceScoreWording=" + (String)localObject);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.data.MessageForNearbyMarketGrayTips.HightlightClickableSpan.2
 * JD-Core Version:    0.7.0.1
 */