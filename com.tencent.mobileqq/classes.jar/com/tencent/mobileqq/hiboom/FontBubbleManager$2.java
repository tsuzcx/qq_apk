package com.tencent.mobileqq.hiboom;

import akfw;
import android.os.Handler;
import android.os.Message;
import aqwn;
import aqxz;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;

public class FontBubbleManager$2
  implements Runnable
{
  public FontBubbleManager$2(aqwn paramaqwn, BaseChatPie paramBaseChatPie) {}
  
  public void run()
  {
    aqxz localaqxz = aqwn.a(this.this$0);
    if (localaqxz != null)
    {
      akfw localakfw = (akfw)aqwn.a(this.this$0).a(13);
      localakfw.a(localaqxz.a.bubbleId);
      localakfw.a(localaqxz.a.fontId, localaqxz.a.engine);
      aqwn.a(this.this$0).obtainMessage(1001, this.a).sendToTarget();
      return;
    }
    QLog.e("FontBubbleManager", 1, "auth ok but mClick is null");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.mobileqq.hiboom.FontBubbleManager.2
 * JD-Core Version:    0.7.0.1
 */