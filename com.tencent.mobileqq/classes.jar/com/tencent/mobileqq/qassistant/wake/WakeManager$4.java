package com.tencent.mobileqq.qassistant.wake;

import android.os.Handler;
import android.os.Message;
import com.tencent.mobileqq.qassistant.listener.IRecordStreamListener;

class WakeManager$4
  implements IRecordStreamListener
{
  WakeManager$4(WakeManager paramWakeManager, long paramLong) {}
  
  public void a(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    long l = System.currentTimeMillis();
    double d1 = l - this.b.i;
    double d2 = this.a;
    Double.isNaN(d2);
    if (d1 > d2 * 0.95D)
    {
      Object localObject = this.b;
      ((WakeManager)localObject).i = l;
      if (WakeManager.c((WakeManager)localObject) != null)
      {
        localObject = WakeManager.c(this.b).obtainMessage(1002);
        ((Message)localObject).obj = paramArrayOfByte;
        WakeManager.c(this.b).sendMessage((Message)localObject);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qassistant.wake.WakeManager.4
 * JD-Core Version:    0.7.0.1
 */