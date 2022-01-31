package com.tencent.mobileqq.hiboom;

import akfv;
import android.os.Handler;
import android.os.Message;
import aqwp;
import aqyb;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;

public class FontBubbleManager$2
  implements Runnable
{
  public FontBubbleManager$2(aqwp paramaqwp, BaseChatPie paramBaseChatPie) {}
  
  public void run()
  {
    aqyb localaqyb = aqwp.a(this.this$0);
    if (localaqyb != null)
    {
      akfv localakfv = (akfv)aqwp.a(this.this$0).a(13);
      localakfv.a(localaqyb.a.bubbleId);
      localakfv.a(localaqyb.a.fontId, localaqyb.a.engine);
      aqwp.a(this.this$0).obtainMessage(1001, this.a).sendToTarget();
      return;
    }
    QLog.e("FontBubbleManager", 1, "auth ok but mClick is null");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.mobileqq.hiboom.FontBubbleManager.2
 * JD-Core Version:    0.7.0.1
 */