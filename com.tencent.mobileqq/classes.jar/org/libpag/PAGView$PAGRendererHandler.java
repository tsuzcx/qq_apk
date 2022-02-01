package org.libpag;

import android.graphics.SurfaceTexture;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

class PAGView$PAGRendererHandler
  extends Handler
{
  private final Object lock = new Object();
  private List<PAGView> needsUpdateViews = new ArrayList();
  
  PAGView$PAGRendererHandler(Looper paramLooper)
  {
    super(paramLooper);
  }
  
  public void handleMessage(Message arg1)
  {
    super.handleMessage(???);
    int i = ???.arg1;
    if (i != 0)
    {
      if (i != 1)
      {
        if (i != 2) {
          return;
        }
        new Handler(Looper.getMainLooper()).post(new PAGView.PAGRendererHandler.1(this));
        return;
      }
      if (!(???.obj instanceof SurfaceTexture)) {
        return;
      }
      ((SurfaceTexture)???.obj).release();
      return;
    }
    synchronized (this.lock)
    {
      Object localObject1 = new ArrayList(this.needsUpdateViews);
      this.needsUpdateViews.clear();
      ??? = new ArrayList();
      localObject1 = ((List)localObject1).iterator();
      while (((Iterator)localObject1).hasNext())
      {
        Object localObject3 = ((Iterator)localObject1).next();
        if ((localObject3 instanceof PAGView))
        {
          localObject3 = (PAGView)localObject3;
          if (!???.contains(localObject3))
          {
            PAGView.access$000((PAGView)localObject3);
            ???.add(localObject3);
          }
        }
      }
      return;
    }
    for (;;)
    {
      throw localObject2;
    }
  }
  
  void needsUpdateView(PAGView paramPAGView)
  {
    synchronized (this.lock)
    {
      if (this.needsUpdateViews.isEmpty())
      {
        Message localMessage = obtainMessage();
        localMessage.arg1 = 0;
        sendMessage(localMessage);
      }
      this.needsUpdateViews.add(paramPAGView);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     org.libpag.PAGView.PAGRendererHandler
 * JD-Core Version:    0.7.0.1
 */