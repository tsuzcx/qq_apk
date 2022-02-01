package com.tencent.mobileqq.videoplatform.imp;

import android.os.Build.VERSION;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import com.tencent.mobileqq.videoplatform.api.IThreadMgr;
import com.tencent.mobileqq.videoplatform.util.LogUtil;

public class ThreadMgrImp
  implements IThreadMgr
{
  Handler mMainHandler;
  Handler mSubHandler;
  volatile HandlerThread mSubThread;
  
  private String getLogTag()
  {
    return "[VideoPlatForm]ThreadMgrImp";
  }
  
  public void postOnSubThread(Runnable paramRunnable)
  {
    try
    {
      if (this.mSubThread == null)
      {
        this.mSubThread = new HandlerThread("VideoPlatfom_SUB", 0);
        this.mSubThread.start();
        this.mSubHandler = new Handler(this.mSubThread.getLooper());
        if (LogUtil.isColorLevel()) {
          LogUtil.d(getLogTag(), 2, "new sub thread");
        }
      }
      this.mSubHandler.post(paramRunnable);
      return;
    }
    finally {}
  }
  
  public void postOnSubThreadDelayed(Runnable paramRunnable, long paramLong)
  {
    try
    {
      if (this.mSubThread == null)
      {
        this.mSubThread = new HandlerThread("VideoPlatfom_SUB", 0);
        this.mSubThread.start();
        this.mSubHandler = new Handler(this.mSubThread.getLooper());
        if (LogUtil.isColorLevel()) {
          LogUtil.d(getLogTag(), 2, "new sub thread");
        }
      }
      this.mSubHandler.postDelayed(paramRunnable, paramLong);
      return;
    }
    finally {}
  }
  
  public void postOnUIThread(Runnable paramRunnable)
  {
    try
    {
      if (this.mMainHandler == null) {
        this.mMainHandler = new Handler(Looper.getMainLooper());
      }
      this.mMainHandler.post(paramRunnable);
      return;
    }
    finally {}
  }
  
  public void postOnUIThreadDelayed(Runnable paramRunnable, long paramLong)
  {
    try
    {
      if (this.mMainHandler == null) {
        this.mMainHandler = new Handler(Looper.getMainLooper());
      }
      this.mMainHandler.postDelayed(paramRunnable, paramLong);
      return;
    }
    finally {}
  }
  
  public void quitSubThread()
  {
    if (LogUtil.isColorLevel()) {
      LogUtil.d(getLogTag(), 2, "quitSubThread");
    }
    try
    {
      if (this.mSubThread != null) {
        if (Build.VERSION.SDK_INT >= 18) {
          this.mSubThread.quitSafely();
        } else {
          this.mSubThread.quit();
        }
      }
      this.mSubHandler = null;
      this.mSubThread = null;
      return;
    }
    finally {}
  }
  
  public void removeCallbackOnSubHandler(Runnable paramRunnable)
  {
    try
    {
      if (this.mSubHandler != null) {
        this.mSubHandler.removeCallbacks(paramRunnable);
      }
      return;
    }
    finally {}
  }
  
  public void removeCallbackOnUIHandler(Runnable paramRunnable)
  {
    try
    {
      if (this.mMainHandler != null) {
        this.mMainHandler.removeCallbacks(paramRunnable);
      }
      return;
    }
    finally {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.videoplatform.imp.ThreadMgrImp
 * JD-Core Version:    0.7.0.1
 */