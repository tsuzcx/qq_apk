package com.tencent.mobileqq.hiboom;

import android.os.Handler;
import android.os.Message;
import anvk;
import aocy;
import avjn;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.data.ExtensionInfo;
import com.tencent.qphone.base.util.QLog;

public class FontBubbleManager$1
  implements Runnable
{
  public FontBubbleManager$1(avjn paramavjn, FontBubble paramFontBubble) {}
  
  public void run()
  {
    ExtensionInfo localExtensionInfo = ((anvk)avjn.a(this.this$0).getManager(QQManagerFactory.FRIENDS_MANAGER)).a(avjn.a(this.this$0).getAccount());
    if (localExtensionInfo == null)
    {
      QLog.e("FontBubbleManager", 1, "setFontBubble fail no ExtensionInfo");
      return;
    }
    aocy localaocy = (aocy)avjn.a(this.this$0).getBusinessHandler(BusinessHandlerFactory.SVIP_HANDLER);
    FontBubble localFontBubble = new FontBubble();
    localFontBubble.fontId = ((int)localExtensionInfo.uVipFont);
    localFontBubble.bubbleId = localaocy.b();
    avjn.a(this.this$0).obtainMessage(1000, new Object[] { localFontBubble, this.a }).sendToTarget();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.hiboom.FontBubbleManager.1
 * JD-Core Version:    0.7.0.1
 */