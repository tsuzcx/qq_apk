package com.tencent.mobileqq.hiboom;

import android.os.Handler;
import android.os.Message;
import anyw;
import aogu;
import avqr;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ExtensionInfo;
import com.tencent.qphone.base.util.QLog;

public class FontBubbleManager$1
  implements Runnable
{
  public FontBubbleManager$1(avqr paramavqr, FontBubble paramFontBubble) {}
  
  public void run()
  {
    ExtensionInfo localExtensionInfo = ((anyw)avqr.a(this.this$0).getManager(51)).a(avqr.a(this.this$0).getAccount());
    if (localExtensionInfo == null)
    {
      QLog.e("FontBubbleManager", 1, "setFontBubble fail no ExtensionInfo");
      return;
    }
    aogu localaogu = (aogu)avqr.a(this.this$0).a(13);
    FontBubble localFontBubble = new FontBubble();
    localFontBubble.fontId = ((int)localExtensionInfo.uVipFont);
    localFontBubble.bubbleId = localaogu.b();
    avqr.a(this.this$0).obtainMessage(1000, new Object[] { localFontBubble, this.a }).sendToTarget();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.hiboom.FontBubbleManager.1
 * JD-Core Version:    0.7.0.1
 */