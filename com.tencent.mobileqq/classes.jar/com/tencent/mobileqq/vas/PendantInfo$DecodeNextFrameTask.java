package com.tencent.mobileqq.vas;

import android.os.AsyncTask;
import android.os.Message;
import android.os.SystemClock;
import com.tencent.qphone.base.util.QLog;
import mqq.os.MqqHandler;

public class PendantInfo$DecodeNextFrameTask
  extends AsyncTask<Long, Void, Void>
{
  Object a;
  long b;
  
  public PendantInfo$DecodeNextFrameTask(PendantInfo paramPendantInfo, Object paramObject, long paramLong)
  {
    this.a = paramObject;
    this.b = paramLong;
  }
  
  protected Void a(Long... paramVarArgs)
  {
    try
    {
      long l1 = paramVarArgs[0].longValue();
      long l2 = paramVarArgs[1].longValue();
      long l3 = paramVarArgs[2].longValue();
      paramVarArgs = this.c.a((int)l3, this.a, (int)l2);
      if ((paramVarArgs != null) && (!isCancelled()))
      {
        l2 = SystemClock.uptimeMillis();
        Message localMessage = this.c.w.obtainMessage(17);
        if (PendantInfo.a(localMessage, this.b))
        {
          localMessage.obj = paramVarArgs;
          if (l2 < l1) {
            this.c.w.sendMessageDelayed(localMessage, l1 - l2);
          } else {
            this.c.w.sendMessage(localMessage);
          }
        }
      }
    }
    catch (Throwable paramVarArgs)
    {
      if (QLog.isDevelopLevel()) {
        QLog.e("PendantInfo", 4, "", paramVarArgs);
      }
      this.c.x = true;
    }
    return null;
  }
  
  protected void a(Void paramVoid)
  {
    this.c.y = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.vas.PendantInfo.DecodeNextFrameTask
 * JD-Core Version:    0.7.0.1
 */