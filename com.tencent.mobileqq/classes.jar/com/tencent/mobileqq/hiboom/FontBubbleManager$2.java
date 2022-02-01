package com.tencent.mobileqq.hiboom;

import android.os.Handler;
import android.os.Message;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.vas.svip.api.ISVIPHandler;
import com.tencent.qphone.base.util.QLog;

class FontBubbleManager$2
  implements Runnable
{
  FontBubbleManager$2(FontBubbleManager paramFontBubbleManager, BaseChatPie paramBaseChatPie) {}
  
  public void run()
  {
    SetFontBubble localSetFontBubble = FontBubbleManager.a(this.this$0);
    if (localSetFontBubble != null)
    {
      ISVIPHandler localISVIPHandler = (ISVIPHandler)FontBubbleManager.a(this.this$0).getBusinessHandler(BusinessHandlerFactory.SVIP_HANDLER);
      localISVIPHandler.a(localSetFontBubble.a.bubbleId);
      localISVIPHandler.a(localSetFontBubble.a.fontId, localSetFontBubble.a.engine);
      FontBubbleManager.a(this.this$0).obtainMessage(1001, this.a).sendToTarget();
      return;
    }
    QLog.e("FontBubbleManager", 1, "auth ok but mClick is null");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.hiboom.FontBubbleManager.2
 * JD-Core Version:    0.7.0.1
 */