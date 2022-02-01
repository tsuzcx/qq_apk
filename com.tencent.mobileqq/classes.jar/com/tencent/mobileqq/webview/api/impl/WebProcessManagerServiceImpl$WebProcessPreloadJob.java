package com.tencent.mobileqq.webview.api.impl;

import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.webview.api.IWebProcessPreload;
import com.tencent.mobileqq.webview.util.WebProcessStartListener;
import java.lang.ref.WeakReference;
import java.util.concurrent.atomic.AtomicBoolean;

class WebProcessManagerServiceImpl$WebProcessPreloadJob
  implements Runnable
{
  int a;
  WeakReference<WebProcessStartListener> b;
  WeakReference<WebProcessManagerServiceImpl> c;
  
  WebProcessManagerServiceImpl$WebProcessPreloadJob(int paramInt, WebProcessStartListener paramWebProcessStartListener, WebProcessManagerServiceImpl paramWebProcessManagerServiceImpl)
  {
    this.a = paramInt;
    this.b = new WeakReference(paramWebProcessStartListener);
    this.c = new WeakReference(paramWebProcessManagerServiceImpl);
  }
  
  public void run()
  {
    WebProcessStartListener localWebProcessStartListener = (WebProcessStartListener)this.b.get();
    if (!((IWebProcessPreload)QRoute.api(IWebProcessPreload.class)).isWebProcessExist())
    {
      if ((WebProcessManagerServiceImpl)this.c.get() != null)
      {
        ((IWebProcessPreload)QRoute.api(IWebProcessPreload.class)).setPreloadWebProcess(true);
        ((IWebProcessPreload)QRoute.api(IWebProcessPreload.class)).preloadWebProcess(this.a);
      }
      if (localWebProcessStartListener != null) {
        localWebProcessStartListener.onResult(true);
      }
    }
    else if (localWebProcessStartListener != null)
    {
      localWebProcessStartListener.onResult(false);
    }
    WebProcessManagerServiceImpl.access$000().set(false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.webview.api.impl.WebProcessManagerServiceImpl.WebProcessPreloadJob
 * JD-Core Version:    0.7.0.1
 */