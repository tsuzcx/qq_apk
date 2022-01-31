package com.tencent.mobileqq.hiboom;

import alxl;
import android.os.Handler;
import android.os.Message;
import asnd;
import asop;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;

public class FontBubbleManager$2
  implements Runnable
{
  public FontBubbleManager$2(asnd paramasnd, BaseChatPie paramBaseChatPie) {}
  
  public void run()
  {
    asop localasop = asnd.a(this.this$0);
    if (localasop != null)
    {
      alxl localalxl = (alxl)asnd.a(this.this$0).a(13);
      localalxl.a(localasop.a.bubbleId);
      localalxl.a(localasop.a.fontId, localasop.a.engine);
      asnd.a(this.this$0).obtainMessage(1001, this.a).sendToTarget();
      return;
    }
    QLog.e("FontBubbleManager", 1, "auth ok but mClick is null");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.hiboom.FontBubbleManager.2
 * JD-Core Version:    0.7.0.1
 */