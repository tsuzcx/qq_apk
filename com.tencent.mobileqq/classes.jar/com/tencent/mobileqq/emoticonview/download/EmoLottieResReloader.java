package com.tencent.mobileqq.emoticonview.download;

import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class EmoLottieResReloader
  implements Handler.Callback
{
  protected static final int MSG_RELOAD_DRAWABLE = 10002;
  public static final String TAG = "EmoLottieResReloader";
  private Handler mHandler = new Handler(Looper.getMainLooper(), this);
  private final Lock mLoadingLock = new ReentrantLock();
  private EmoLottieResReloader.IResReloadListener mResReloadListener;
  protected ArrayList<String> mWaitingReloadList;
  
  public EmoLottieResReloader(EmoLottieResReloader.IResReloadListener paramIResReloadListener)
  {
    this.mResReloadListener = paramIResReloadListener;
  }
  
  public void addReloadList(String paramString)
  {
    this.mLoadingLock.lock();
    try
    {
      if (this.mWaitingReloadList == null)
      {
        this.mWaitingReloadList = new ArrayList();
        triggerDownloadRes();
      }
      if (!this.mWaitingReloadList.contains(paramString))
      {
        this.mWaitingReloadList.add(0, paramString);
        if (QLog.isColorLevel()) {
          QLog.d("EmoLottieResReloader", 2, new Object[] { "addReloadLottieDrawable key:", paramString, " ,size:", Integer.valueOf(this.mWaitingReloadList.size()) });
        }
      }
      return;
    }
    finally
    {
      this.mLoadingLock.unlock();
    }
  }
  
  public void clearReloadList()
  {
    ArrayList localArrayList = this.mWaitingReloadList;
    if ((localArrayList != null) && (localArrayList.size() > 0))
    {
      this.mLoadingLock.lock();
      try
      {
        if (this.mWaitingReloadList.size() > 0) {
          this.mWaitingReloadList.clear();
        }
        return;
      }
      finally
      {
        this.mLoadingLock.unlock();
      }
    }
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    if (paramMessage.what != 10002) {
      return false;
    }
    paramMessage = null;
    Object localObject = this.mWaitingReloadList;
    if ((localObject != null) && (((ArrayList)localObject).size() > 0))
    {
      this.mLoadingLock.lock();
      try
      {
        if (this.mWaitingReloadList.size() > 0) {
          paramMessage = (String)this.mWaitingReloadList.remove(0);
        }
        this.mLoadingLock.unlock();
        if (paramMessage != null)
        {
          localObject = this.mResReloadListener;
          if (localObject != null) {
            ((EmoLottieResReloader.IResReloadListener)localObject).startReloadDrawable(paramMessage);
          }
          if (this.mWaitingReloadList.size() > 0)
          {
            this.mHandler.sendEmptyMessageDelayed(10002, 300L);
            return false;
          }
          if (QLog.isColorLevel())
          {
            QLog.d("EmoLottieResReloader", 2, "finish reloading");
            return false;
          }
        }
      }
      finally
      {
        this.mLoadingLock.unlock();
      }
    }
    return false;
  }
  
  public void nofityReloadList()
  {
    this.mHandler.sendEmptyMessage(10002);
  }
  
  protected void triggerDownloadRes()
  {
    EmoLottieResReloader.IResReloadListener localIResReloadListener = this.mResReloadListener;
    if (localIResReloadListener != null) {
      localIResReloadListener.triggerDownloadRes();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.emoticonview.download.EmoLottieResReloader
 * JD-Core Version:    0.7.0.1
 */