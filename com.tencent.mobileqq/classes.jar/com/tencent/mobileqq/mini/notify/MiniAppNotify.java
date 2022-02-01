package com.tencent.mobileqq.mini.notify;

import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.concurrent.ConcurrentLinkedQueue;

public class MiniAppNotify
{
  static final String TAG = "MiniAppNotify";
  public static MiniAppNotify g;
  private ConcurrentLinkedQueue<MiniAppNotify.IMiniAppNotifyListener> listenerList = new ConcurrentLinkedQueue();
  
  static
  {
    if (g == null) {
      g = new MiniAppNotify();
    }
  }
  
  public void notify(String paramString1, int paramInt, String paramString2, String paramString3, long paramLong)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("appid:");
    ((StringBuilder)localObject).append(paramString1);
    ((StringBuilder)localObject).append(" scene:");
    ((StringBuilder)localObject).append(paramInt);
    ((StringBuilder)localObject).append(" via:");
    ((StringBuilder)localObject).append(paramString2);
    ((StringBuilder)localObject).append(" event:");
    ((StringBuilder)localObject).append(paramString3);
    ((StringBuilder)localObject).append(" timestamp:");
    ((StringBuilder)localObject).append(paramLong);
    QLog.d("MiniAppNotify", 1, ((StringBuilder)localObject).toString());
    localObject = this.listenerList.iterator();
    while (((Iterator)localObject).hasNext()) {
      ((MiniAppNotify.IMiniAppNotifyListener)((Iterator)localObject).next()).onNotify(paramString1, paramInt, paramString2, paramString3, paramLong);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.mini.notify.MiniAppNotify
 * JD-Core Version:    0.7.0.1
 */