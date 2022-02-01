package com.tencent.mobileqq.hiboom;

import anaj;
import android.os.Handler;
import android.os.Message;
import audt;
import aufk;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;

public class FontBubbleManager$2
  implements Runnable
{
  public FontBubbleManager$2(audt paramaudt, BaseChatPie paramBaseChatPie) {}
  
  public void run()
  {
    aufk localaufk = audt.a(this.this$0);
    if (localaufk != null)
    {
      anaj localanaj = (anaj)audt.a(this.this$0).getBusinessHandler(13);
      localanaj.a(localaufk.a.bubbleId);
      localanaj.a(localaufk.a.fontId, localaufk.a.engine);
      audt.a(this.this$0).obtainMessage(1001, this.a).sendToTarget();
      return;
    }
    QLog.e("FontBubbleManager", 1, "auth ok but mClick is null");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.hiboom.FontBubbleManager.2
 * JD-Core Version:    0.7.0.1
 */