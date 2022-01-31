package com.tencent.mobileqq.hiboom;

import amca;
import android.os.Handler;
import android.os.Message;
import asrm;
import assy;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;

public class FontBubbleManager$2
  implements Runnable
{
  public FontBubbleManager$2(asrm paramasrm, BaseChatPie paramBaseChatPie) {}
  
  public void run()
  {
    assy localassy = asrm.a(this.this$0);
    if (localassy != null)
    {
      amca localamca = (amca)asrm.a(this.this$0).a(13);
      localamca.a(localassy.a.bubbleId);
      localamca.a(localassy.a.fontId, localassy.a.engine);
      asrm.a(this.this$0).obtainMessage(1001, this.a).sendToTarget();
      return;
    }
    QLog.e("FontBubbleManager", 1, "auth ok but mClick is null");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.hiboom.FontBubbleManager.2
 * JD-Core Version:    0.7.0.1
 */