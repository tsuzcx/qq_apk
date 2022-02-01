package com.tencent.mobileqq.mini.notify;

import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.concurrent.ConcurrentLinkedQueue;

public class MiniAppNotify
{
  static final String TAG = "MiniAppNotify";
  public static MiniAppNotify g = null;
  private ConcurrentLinkedQueue<MiniAppNotify.IMiniAppNotifyListener> listenerList = new ConcurrentLinkedQueue();
  
  static
  {
    if (g == null) {
      g = new MiniAppNotify();
    }
  }
  
  public void notify(String paramString1, int paramInt, String paramString2, String paramString3, long paramLong)
  {
    QLog.d("MiniAppNotify", 1, "appid:" + paramString1 + " scene:" + paramInt + " via:" + paramString2 + " event:" + paramString3 + " timestamp:" + paramLong);
    Iterator localIterator = this.listenerList.iterator();
    while (localIterator.hasNext()) {
      ((MiniAppNotify.IMiniAppNotifyListener)localIterator.next()).onNotify(paramString1, paramInt, paramString2, paramString3, paramLong);
    }
  }
  
  public void register(MiniAppNotify.IMiniAppNotifyListener paramIMiniAppNotifyListener)
  {
    this.listenerList.add(paramIMiniAppNotifyListener);
  }
  
  public void remove(MiniAppNotify.IMiniAppNotifyListener paramIMiniAppNotifyListener)
  {
    this.listenerList.remove(paramIMiniAppNotifyListener);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.mini.notify.MiniAppNotify
 * JD-Core Version:    0.7.0.1
 */