package com.tencent.mobileqq.transfile.predownload;

import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Message;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;

public class RunnableTask
  extends AbsPreDownloadTask
  implements Handler.Callback
{
  private Runnable mRunnable;
  private Handler mSubHandler;
  private long mTimeoutInterval;
  
  public RunnableTask(QQAppInterface paramQQAppInterface, String paramString, Runnable paramRunnable, long paramLong)
  {
    super(paramQQAppInterface, paramString);
    this.mRunnable = paramRunnable;
    this.mTimeoutInterval = paramLong;
    this.mSubHandler = new Handler(ThreadManager.getSubThreadLooper(), this);
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    if (paramMessage.what == 0) {
      this.ctrl.onTaskEnd(this);
    }
    return true;
  }
  
  protected void realCancel()
  {
    this.mSubHandler.removeCallbacks(this.mRunnable);
  }
  
  protected void realStart()
  {
    this.mSubHandler.post(this.mRunnable);
    this.mSubHandler.sendEmptyMessageDelayed(0, this.mTimeoutInterval);
  }
  
  public String toString()
  {
    return super.toString() + "[" + this.mRunnable + ", " + this.mTimeoutInterval + "]";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.transfile.predownload.RunnableTask
 * JD-Core Version:    0.7.0.1
 */