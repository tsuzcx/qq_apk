package com.tencent.mobileqq.qassistant.wake.aicore;

import com.tencent.mobileqq.qassistant.core.AssistantUtils;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.concurrent.atomic.AtomicBoolean;

class WakeDataSaveHelper$1
  implements Runnable
{
  WakeDataSaveHelper$1(WakeDataSaveHelper paramWakeDataSaveHelper, LinkedList paramLinkedList, float paramFloat, int paramInt) {}
  
  public void run()
  {
    WakeDataSaveHelper.a(this.this$0, this.a, Float.valueOf(this.b), this.c);
    ((AtomicBoolean)this.this$0.c.get(this.c)).set(false);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("saveData ");
    localStringBuilder.append(this.c);
    localStringBuilder.append(":");
    localStringBuilder.append(this.b);
    AssistantUtils.a("HelloQQWake", localStringBuilder.toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qassistant.wake.aicore.WakeDataSaveHelper.1
 * JD-Core Version:    0.7.0.1
 */