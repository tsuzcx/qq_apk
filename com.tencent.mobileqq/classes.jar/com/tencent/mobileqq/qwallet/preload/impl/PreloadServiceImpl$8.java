package com.tencent.mobileqq.qwallet.preload.impl;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.qwallet.preload.IPreloadService.FlowControlObj;
import java.lang.ref.WeakReference;
import java.util.LinkedList;

class PreloadServiceImpl$8
  extends Handler
{
  private LinkedList<IPreloadService.FlowControlObj> b = new LinkedList();
  private boolean c = false;
  
  PreloadServiceImpl$8(PreloadServiceImpl paramPreloadServiceImpl, Looper paramLooper)
  {
    super(paramLooper);
  }
  
  private void a()
  {
    WeakReference localWeakReference = new WeakReference(this.a);
    IPreloadService.FlowControlObj localFlowControlObj = (IPreloadService.FlowControlObj)this.b.getFirst();
    this.b.removeFirst();
    ThreadManager.excute(new PreloadServiceImpl.8.1(this, localWeakReference, localFlowControlObj), 64, null, false);
  }
  
  public void handleMessage(Message paramMessage)
  {
    if (this.a.mIsOnDestroy) {
      return;
    }
    int i = paramMessage.what;
    if (i != 1)
    {
      if (i != 2) {
        return;
      }
      if (this.b.size() > 0)
      {
        a();
        return;
      }
      this.c = false;
      return;
    }
    this.b.addLast((IPreloadService.FlowControlObj)paramMessage.obj);
    if (!this.c)
    {
      this.c = true;
      sendEmptyMessage(2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.qwallet.preload.impl.PreloadServiceImpl.8
 * JD-Core Version:    0.7.0.1
 */