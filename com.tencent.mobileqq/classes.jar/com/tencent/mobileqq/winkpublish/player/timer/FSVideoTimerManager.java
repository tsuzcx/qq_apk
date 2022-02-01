package com.tencent.mobileqq.winkpublish.player.timer;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class FSVideoTimerManager
{
  private static volatile FSVideoTimerManager a;
  private final Handler b;
  private final HandlerThread c = new HandlerThread("QCircleVideoTimerManager");
  private final List<IFSVideoTimerListener> d;
  
  private FSVideoTimerManager()
  {
    this.c.start();
    this.b = new FSVideoTimerManager.1(this, this.c.getLooper());
    this.d = new ArrayList();
  }
  
  public static FSVideoTimerManager a()
  {
    if (a == null) {
      try
      {
        if (a == null) {
          a = new FSVideoTimerManager();
        }
      }
      finally {}
    }
    return a;
  }
  
  private void b()
  {
    if (this.d.size() <= 0) {
      return;
    }
    Iterator localIterator = this.d.iterator();
    while (localIterator.hasNext()) {
      ((IFSVideoTimerListener)localIterator.next()).d();
    }
    c();
  }
  
  private void c()
  {
    Message localMessage = Message.obtain();
    localMessage.what = 3;
    this.b.sendMessageDelayed(localMessage, 33L);
  }
  
  private void c(IFSVideoTimerListener paramIFSVideoTimerListener)
  {
    if (paramIFSVideoTimerListener == null) {
      return;
    }
    this.d.add(paramIFSVideoTimerListener);
    paramIFSVideoTimerListener = new StringBuilder();
    paramIFSVideoTimerListener.append("handlerRegister, listener size:");
    paramIFSVideoTimerListener.append(this.d.size());
    QLog.i("QCircleVideoTimerManager", 4, paramIFSVideoTimerListener.toString());
    if (this.d.size() == 1) {
      b();
    }
  }
  
  private void d(IFSVideoTimerListener paramIFSVideoTimerListener)
  {
    if (paramIFSVideoTimerListener == null) {
      return;
    }
    this.d.remove(paramIFSVideoTimerListener);
    paramIFSVideoTimerListener = new StringBuilder();
    paramIFSVideoTimerListener.append("handlerUnRegister, listener size:");
    paramIFSVideoTimerListener.append(this.d.size());
    QLog.i("QCircleVideoTimerManager", 4, paramIFSVideoTimerListener.toString());
    if (this.d.size() == 0) {
      this.b.removeMessages(3);
    }
  }
  
  public void a(IFSVideoTimerListener paramIFSVideoTimerListener)
  {
    if (paramIFSVideoTimerListener == null) {
      return;
    }
    Message localMessage = Message.obtain();
    localMessage.what = 1;
    localMessage.obj = paramIFSVideoTimerListener;
    this.b.sendMessage(localMessage);
    QLog.i("QCircleVideoTimerManager", 4, "registerTimerListener");
  }
  
  public void b(IFSVideoTimerListener paramIFSVideoTimerListener)
  {
    if (paramIFSVideoTimerListener == null) {
      return;
    }
    Message localMessage = Message.obtain();
    localMessage.what = 2;
    localMessage.obj = paramIFSVideoTimerListener;
    this.b.sendMessage(localMessage);
    QLog.i("QCircleVideoTimerManager", 4, "unRegisterTimerListener");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mobileqq.winkpublish.player.timer.FSVideoTimerManager
 * JD-Core Version:    0.7.0.1
 */