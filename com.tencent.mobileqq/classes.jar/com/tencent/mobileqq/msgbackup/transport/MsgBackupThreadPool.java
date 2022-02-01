package com.tencent.mobileqq.msgbackup.transport;

import android.os.Handler;
import android.os.HandlerThread;
import com.tencent.mobileqq.msgbackup.util.MsgBackupUtil;

@Deprecated
public class MsgBackupThreadPool
{
  private static short c = 0;
  private static boolean d = false;
  private HandlerThread[] a;
  private Handler[] b;
  
  private MsgBackupThreadPool()
  {
    MsgBackupUtil.a("MsgBackupMsgBackupThreadPool", "MsgBackupThreadPool constructor--------->", new Object[0]);
    d = true;
    a();
  }
  
  private void a()
  {
    this.a = new HandlerThread[5];
    this.b = new Handler[5];
    int i = 0;
    while (i < 5)
    {
      HandlerThread[] arrayOfHandlerThread = this.a;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("msgbackup_thread_");
      localStringBuilder.append(i);
      arrayOfHandlerThread[i] = new HandlerThread(localStringBuilder.toString());
      this.a[i].start();
      this.b[i] = new Handler(this.a[i].getLooper());
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.msgbackup.transport.MsgBackupThreadPool
 * JD-Core Version:    0.7.0.1
 */