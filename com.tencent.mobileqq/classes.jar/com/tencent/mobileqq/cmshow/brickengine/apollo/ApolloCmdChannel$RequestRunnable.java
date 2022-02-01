package com.tencent.mobileqq.cmshow.brickengine.apollo;

import android.text.TextUtils;
import com.tencent.mobileqq.apollo.channel.HandleResult;
import com.tencent.mobileqq.apollo.channel.IRequestHandler;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.List;

class ApolloCmdChannel$RequestRunnable
  implements Runnable
{
  private WeakReference<ApolloCmdChannel> a;
  private long b;
  private String c;
  private String d;
  
  ApolloCmdChannel$RequestRunnable(ApolloCmdChannel paramApolloCmdChannel, long paramLong, String paramString1, String paramString2)
  {
    this.a = new WeakReference(paramApolloCmdChannel);
    this.b = paramLong;
    this.c = paramString1;
    this.d = paramString2;
  }
  
  public void run()
  {
    ??? = this.a;
    if (??? == null) {
      return;
    }
    ApolloCmdChannel localApolloCmdChannel = (ApolloCmdChannel)((WeakReference)???).get();
    if (localApolloCmdChannel == null) {
      return;
    }
    if ((this.b != -1L) && (!TextUtils.isEmpty(this.c)))
    {
      if (TextUtils.isEmpty(this.d)) {
        return;
      }
      synchronized (ApolloCmdChannel.access$000(localApolloCmdChannel))
      {
        Iterator localIterator = ApolloCmdChannel.access$000(localApolloCmdChannel).iterator();
        while (localIterator.hasNext())
        {
          HandleResult localHandleResult = ((IRequestHandler)localIterator.next()).a(this.b, this.c, this.d);
          if (localHandleResult != null)
          {
            if (localHandleResult.b) {
              localIterator.remove();
            }
            if (localHandleResult.c) {
              localApolloCmdChannel.callbackFromRequest(this.b, 0, this.c, localHandleResult.a);
            }
          }
        }
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.cmshow.brickengine.apollo.ApolloCmdChannel.RequestRunnable
 * JD-Core Version:    0.7.0.1
 */