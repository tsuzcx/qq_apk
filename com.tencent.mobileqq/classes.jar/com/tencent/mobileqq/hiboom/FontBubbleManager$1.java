package com.tencent.mobileqq.hiboom;

import ajxl;
import akfv;
import android.os.Handler;
import android.os.Message;
import aqwp;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ExtensionInfo;
import com.tencent.qphone.base.util.QLog;

public class FontBubbleManager$1
  implements Runnable
{
  public FontBubbleManager$1(aqwp paramaqwp, FontBubble paramFontBubble) {}
  
  public void run()
  {
    ExtensionInfo localExtensionInfo = ((ajxl)aqwp.a(this.this$0).getManager(51)).a(aqwp.a(this.this$0).getAccount());
    if (localExtensionInfo == null)
    {
      QLog.e("FontBubbleManager", 1, "setFontBubble fail no ExtensionInfo");
      return;
    }
    akfv localakfv = (akfv)aqwp.a(this.this$0).a(13);
    FontBubble localFontBubble = new FontBubble();
    localFontBubble.fontId = ((int)localExtensionInfo.uVipFont);
    localFontBubble.bubbleId = localakfv.b();
    aqwp.a(this.this$0).obtainMessage(1000, new Object[] { localFontBubble, this.a }).sendToTarget();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.mobileqq.hiboom.FontBubbleManager.1
 * JD-Core Version:    0.7.0.1
 */