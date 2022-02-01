package com.tencent.mobileqq.hiboom;

import android.os.Handler;
import android.os.Message;
import aocy;
import avjn;
import avle;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;

public class FontBubbleManager$2
  implements Runnable
{
  public FontBubbleManager$2(avjn paramavjn, BaseChatPie paramBaseChatPie) {}
  
  public void run()
  {
    avle localavle = avjn.a(this.this$0);
    if (localavle != null)
    {
      aocy localaocy = (aocy)avjn.a(this.this$0).getBusinessHandler(BusinessHandlerFactory.SVIP_HANDLER);
      localaocy.a(localavle.a.bubbleId);
      localaocy.a(localavle.a.fontId, localavle.a.engine);
      avjn.a(this.this$0).obtainMessage(1001, this.a).sendToTarget();
      return;
    }
    QLog.e("FontBubbleManager", 1, "auth ok but mClick is null");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.hiboom.FontBubbleManager.2
 * JD-Core Version:    0.7.0.1
 */