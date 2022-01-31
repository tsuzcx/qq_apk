package com.tencent.mobileqq.hiboom;

import ajrm;
import android.os.Handler;
import android.os.Message;
import aqcl;
import aqdx;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;

public class FontBubbleManager$2
  implements Runnable
{
  public FontBubbleManager$2(aqcl paramaqcl, BaseChatPie paramBaseChatPie) {}
  
  public void run()
  {
    aqdx localaqdx = aqcl.a(this.this$0);
    if (localaqdx != null)
    {
      ajrm localajrm = (ajrm)aqcl.a(this.this$0).a(13);
      localajrm.a(localaqdx.a.bubbleId);
      localajrm.a(localaqdx.a.fontId, localaqdx.a.engine);
      aqcl.a(this.this$0).obtainMessage(1001, this.a).sendToTarget();
      return;
    }
    QLog.e("FontBubbleManager", 1, "auth ok but mClick is null");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.mobileqq.hiboom.FontBubbleManager.2
 * JD-Core Version:    0.7.0.1
 */