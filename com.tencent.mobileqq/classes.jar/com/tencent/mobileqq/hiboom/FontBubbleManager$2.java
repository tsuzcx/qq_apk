package com.tencent.mobileqq.hiboom;

import android.os.Handler;
import android.os.Message;
import anuk;
import auyq;
import avah;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;

public class FontBubbleManager$2
  implements Runnable
{
  public FontBubbleManager$2(auyq paramauyq, BaseChatPie paramBaseChatPie) {}
  
  public void run()
  {
    avah localavah = auyq.a(this.this$0);
    if (localavah != null)
    {
      anuk localanuk = (anuk)auyq.a(this.this$0).a(13);
      localanuk.a(localavah.a.bubbleId);
      localanuk.a(localavah.a.fontId, localavah.a.engine);
      auyq.a(this.this$0).obtainMessage(1001, this.a).sendToTarget();
      return;
    }
    QLog.e("FontBubbleManager", 1, "auth ok but mClick is null");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.hiboom.FontBubbleManager.2
 * JD-Core Version:    0.7.0.1
 */