package com.tencent.mobileqq.kandian.biz.viola.barrage;

import android.os.Handler.Callback;
import android.os.Message;
import kotlin.Metadata;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "it", "Landroid/os/Message;", "kotlin.jvm.PlatformType", "handleMessage"}, k=3, mv={1, 1, 16})
final class BarrageController$handler$1
  implements Handler.Callback
{
  public static final 1 a = new 1();
  
  public final boolean handleMessage(Message paramMessage)
  {
    if (paramMessage != null) {
      paramMessage = Integer.valueOf(paramMessage.what);
    } else {
      paramMessage = null;
    }
    if (paramMessage != null) {
      paramMessage.intValue();
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.viola.barrage.BarrageController.handler.1
 * JD-Core Version:    0.7.0.1
 */