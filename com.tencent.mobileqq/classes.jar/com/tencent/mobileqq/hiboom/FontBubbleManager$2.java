package com.tencent.mobileqq.hiboom;

import android.os.Handler;
import android.os.Message;
import aogu;
import avqr;
import avsi;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;

public class FontBubbleManager$2
  implements Runnable
{
  public FontBubbleManager$2(avqr paramavqr, BaseChatPie paramBaseChatPie) {}
  
  public void run()
  {
    avsi localavsi = avqr.a(this.this$0);
    if (localavsi != null)
    {
      aogu localaogu = (aogu)avqr.a(this.this$0).a(13);
      localaogu.a(localavsi.a.bubbleId);
      localaogu.a(localavsi.a.fontId, localavsi.a.engine);
      avqr.a(this.this$0).obtainMessage(1001, this.a).sendToTarget();
      return;
    }
    QLog.e("FontBubbleManager", 1, "auth ok but mClick is null");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.hiboom.FontBubbleManager.2
 * JD-Core Version:    0.7.0.1
 */