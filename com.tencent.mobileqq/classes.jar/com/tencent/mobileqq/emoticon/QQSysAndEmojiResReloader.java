package com.tencent.mobileqq.emoticon;

import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import mqq.os.MqqHandler;

public class QQSysAndEmojiResReloader
  implements Handler.Callback
{
  protected static final int MSG_RELOAD_DRAWABLE = 10001;
  public static final String TAG = "QQSysAndEmojiResReloader";
  private Handler mHandler = new Handler(Looper.getMainLooper(), this);
  private final Lock mLoadingLock = new ReentrantLock();
  private QQSysAndEmojiResReloader.IResReloadListener mResReloadListener;
  protected ArrayList<Integer> mWaitingReloadList;
  
  public QQSysAndEmojiResReloader(QQSysAndEmojiResReloader.IResReloadListener paramIResReloadListener)
  {
    this.mResReloadListener = paramIResReloadListener;
  }
  
  public void addReloadList(int paramInt)
  {
    this.mLoadingLock.lock();
    try
    {
      if (this.mWaitingReloadList == null)
      {
        this.mWaitingReloadList = new ArrayList();
        triggerDownloadRes();
      }
      if (!this.mWaitingReloadList.contains(Integer.valueOf(paramInt)))
      {
        this.mWaitingReloadList.add(0, Integer.valueOf(paramInt));
        if (QLog.isColorLevel()) {
          QLog.d("QQSysAndEmojiResReloader", 2, new Object[] { "addReloadDrawable idx:", Integer.valueOf(paramInt), " ,size:", Integer.valueOf(this.mWaitingReloadList.size()) });
        }
      }
      return;
    }
    finally
    {
      this.mLoadingLock.unlock();
    }
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    }
    do
    {
      return false;
    } while ((this.mWaitingReloadList == null) || (this.mWaitingReloadList.size() <= 0));
    this.mLoadingLock.lock();
    for (;;)
    {
      try
      {
        if (this.mWaitingReloadList.size() <= 0) {
          break label162;
        }
        i = ((Integer)this.mWaitingReloadList.remove(0)).intValue();
        this.mLoadingLock.unlock();
        if (i <= -1) {
          break;
        }
        if (this.mResReloadListener != null) {
          this.mResReloadListener.startReloadDrawable(i);
        }
        if (this.mWaitingReloadList.size() > 0)
        {
          this.mHandler.sendEmptyMessageDelayed(10001, 300L);
          return false;
        }
      }
      finally
      {
        this.mLoadingLock.unlock();
      }
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d("QQSysAndEmojiResReloader", 2, "finish reloading");
      return false;
      label162:
      int i = -1;
    }
  }
  
  public void nofityReloadList()
  {
    this.mHandler.sendEmptyMessage(10001);
  }
  
  protected void triggerDownloadRes()
  {
    ThreadManager.getSubThreadHandler().post(new QQSysAndEmojiResReloader.1(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.emoticon.QQSysAndEmojiResReloader
 * JD-Core Version:    0.7.0.1
 */