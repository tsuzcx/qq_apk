package com.tencent.mobileqq.webview.api.impl;

import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.webview.api.IWebProcessPreload;
import com.tencent.mobileqq.webview.util.WebProcessStartListener;
import java.lang.ref.WeakReference;
import java.util.concurrent.atomic.AtomicBoolean;

class WebProcessManagerServiceImpl$WebProcessPreloadJob
  implements Runnable
{
  int jdField_a_of_type_Int;
  WeakReference<WebProcessStartListener> jdField_a_of_type_JavaLangRefWeakReference;
  WeakReference<WebProcessManagerServiceImpl> b;
  
  WebProcessManagerServiceImpl$WebProcessPreloadJob(int paramInt, WebProcessStartListener paramWebProcessStartListener, WebProcessManagerServiceImpl paramWebProcessManagerServiceImpl)
  {
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramWebProcessStartListener);
    this.b = new WeakReference(paramWebProcessManagerServiceImpl);
  }
  
  public void run()
  {
    WebProcessStartListener localWebProcessStartListener = (WebProcessStartListener)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    if (!((IWebProcessPreload)QRoute.api(IWebProcessPreload.class)).isWebProcessExist())
    {
      if ((WebProcessManagerServiceImpl)this.b.get() != null)
      {
        ((IWebProcessPreload)QRoute.api(IWebProcessPreload.class)).setPreloadWebProcess(true);
        ((IWebProcessPreload)QRoute.api(IWebProcessPreload.class)).preloadWebProcess(this.jdField_a_of_type_Int);
      }
      if (localWebProcessStartListener != null) {
        localWebProcessStartListener.onResult(true);
      }
    }
    for (;;)
    {
      WebProcessManagerServiceImpl.access$000().set(false);
      return;
      if (localWebProcessStartListener != null) {
        localWebProcessStartListener.onResult(false);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.webview.api.impl.WebProcessManagerServiceImpl.WebProcessPreloadJob
 * JD-Core Version:    0.7.0.1
 */