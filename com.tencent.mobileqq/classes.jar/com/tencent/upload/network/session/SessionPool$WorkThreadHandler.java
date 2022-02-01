package com.tencent.upload.network.session;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.tencent.upload.utils.UploadLog;
import java.lang.ref.WeakReference;
import java.util.List;
import java.util.concurrent.BlockingQueue;

class SessionPool$WorkThreadHandler
  extends Handler
{
  private WeakReference<SessionPool> mRef;
  private int n = 1;
  
  public SessionPool$WorkThreadHandler(SessionPool paramSessionPool, Looper paramLooper)
  {
    super(paramLooper);
    this.mRef = new WeakReference(paramSessionPool);
  }
  
  public void handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    }
    do
    {
      do
      {
        do
        {
          return;
        } while ((this.mRef == null) || (this.mRef.get() == null));
        UploadLog.d("SessionPool", "receive msg MSG_CLOSE_POOL");
        ((SessionPool)this.mRef.get()).close();
        return;
        if (!SessionPool.access$200()) {
          break;
        }
        UploadLog.d("SessionPool", "receive msg MSG_REBUILD_SESSIONS hasNetwork:true");
      } while ((this.mRef == null) || (this.mRef.get() == null));
      paramMessage = (SessionPool)this.mRef.get();
      if ((SessionPool.access$300(paramMessage).size() == 0) && (SessionPool.access$400(paramMessage).size() == 0)) {
        paramMessage.reset();
      }
      this.n = 1;
      return;
      UploadLog.d("SessionPool", "receive msg MSG_REBUILD_SESSIONS n == " + this.n);
    } while (this.n > 6);
    paramMessage = obtainMessage(110001);
    int i = this.n;
    this.n = (i + 1);
    sendMessageDelayed(paramMessage, (1 << i) * 1000);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.upload.network.session.SessionPool.WorkThreadHandler
 * JD-Core Version:    0.7.0.1
 */