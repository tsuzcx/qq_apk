package com.tencent.upload.network.session;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.tencent.upload.utils.Const.UploadRetCode;
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
    default: 
    case 110001: 
      if (SessionPool.access$200())
      {
        UploadLog.d("SessionPool", "receive msg MSG_REBUILD_SESSIONS hasNetwork:true");
        paramMessage = this.mRef;
        if ((paramMessage != null) && (paramMessage.get() != null))
        {
          paramMessage = (SessionPool)this.mRef.get();
          if ((SessionPool.access$300(paramMessage).size() == 0) && (SessionPool.access$400(paramMessage).size() == 0)) {
            paramMessage.reset();
          }
          this.n = 1;
        }
      }
      else
      {
        paramMessage = new StringBuilder();
        paramMessage.append("receive msg MSG_REBUILD_SESSIONS n == ");
        paramMessage.append(this.n);
        UploadLog.d("SessionPool", paramMessage.toString());
        if (this.n <= 6)
        {
          paramMessage = obtainMessage(110001);
          int i = this.n;
          this.n = (i + 1);
          sendMessageDelayed(paramMessage, (1 << i) * 1000);
          return;
        }
        paramMessage = this.mRef;
        if ((paramMessage != null) && (paramMessage.get() != null))
        {
          paramMessage = (SessionPool)this.mRef.get();
          if (SessionPool.access$500(paramMessage) != null) {
            SessionPool.access$500(paramMessage).onNetWorkConnectFail(paramMessage, Const.UploadRetCode.NETWORK_NOT_AVAILABLE.getCode());
          }
        }
        else
        {
          UploadLog.w("SessionPool", "mRef == null or mRef.get() == null");
          return;
        }
      }
      break;
    case 110000: 
      paramMessage = this.mRef;
      if ((paramMessage != null) && (paramMessage.get() != null))
      {
        UploadLog.d("SessionPool", "receive msg MSG_CLOSE_POOL");
        ((SessionPool)this.mRef.get()).close();
      }
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.upload.network.session.SessionPool.WorkThreadHandler
 * JD-Core Version:    0.7.0.1
 */