package com.tencent.mobileqq.hiboom;

import android.os.Handler;
import android.os.Message;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.SVIPHandler;
import com.tencent.mobileqq.data.ExtensionInfo;
import com.tencent.qphone.base.util.QLog;

class FontBubbleManager$1
  implements Runnable
{
  FontBubbleManager$1(FontBubbleManager paramFontBubbleManager, FontBubble paramFontBubble) {}
  
  public void run()
  {
    ExtensionInfo localExtensionInfo = ((FriendsManager)FontBubbleManager.a(this.this$0).getManager(QQManagerFactory.FRIENDS_MANAGER)).a(FontBubbleManager.a(this.this$0).getAccount());
    if (localExtensionInfo == null)
    {
      QLog.e("FontBubbleManager", 1, "setFontBubble fail no ExtensionInfo");
      return;
    }
    SVIPHandler localSVIPHandler = (SVIPHandler)FontBubbleManager.a(this.this$0).getBusinessHandler(BusinessHandlerFactory.SVIP_HANDLER);
    FontBubble localFontBubble = new FontBubble();
    localFontBubble.fontId = ((int)localExtensionInfo.uVipFont);
    localFontBubble.bubbleId = localSVIPHandler.b();
    FontBubbleManager.a(this.this$0).obtainMessage(1000, new Object[] { localFontBubble, this.a }).sendToTarget();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.hiboom.FontBubbleManager.1
 * JD-Core Version:    0.7.0.1
 */