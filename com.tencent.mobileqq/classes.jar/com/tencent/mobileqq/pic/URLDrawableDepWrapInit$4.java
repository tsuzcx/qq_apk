package com.tencent.mobileqq.pic;

import android.os.HandlerThread;
import com.tencent.image.api.IThreadListener;
import com.tencent.image.api.IThreadManager;
import com.tencent.mobileqq.app.ThreadExcutor.IThreadListener;
import com.tencent.mobileqq.app.ThreadManagerV2;

final class URLDrawableDepWrapInit$4
  implements IThreadManager
{
  private ThreadExcutor.IThreadListener a(IThreadListener paramIThreadListener)
  {
    if (paramIThreadListener != null) {
      return new URLDrawableDepWrapInit.4.1(this, paramIThreadListener);
    }
    return null;
  }
  
  public void executeOnFileThreadExcutor(Runnable paramRunnable, IThreadListener paramIThreadListener, boolean paramBoolean)
  {
    ThreadManagerV2.excute(paramRunnable, 64, a(paramIThreadListener), paramBoolean);
  }
  
  public void executeOnNetThreadExcutor(Runnable paramRunnable, IThreadListener paramIThreadListener, boolean paramBoolean)
  {
    ThreadManagerV2.excute(paramRunnable, 128, a(paramIThreadListener), paramBoolean);
  }
  
  public HandlerThread getFileThread()
  {
    return (HandlerThread)ThreadManagerV2.getFileThread();
  }
  
  public HandlerThread getSubThread()
  {
    return (HandlerThread)ThreadManagerV2.getSubThread();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.pic.URLDrawableDepWrapInit.4
 * JD-Core Version:    0.7.0.1
 */