package com.tencent.timi.game.trtc.tools;

import com.tencent.trtc.TRTCCloudListener;
import java.lang.ref.WeakReference;
import java.util.ArrayList;

public class CloudListenerInformer
  extends TRTCCloudListener
{
  static ArrayList<WeakReference<TRTCCloudListener>> a = new ArrayList();
  
  public void a(CloudListenerInformer.IInformCallback paramIInformCallback)
  {
    int i = a.size() - 1;
    while (i >= 0)
    {
      TRTCCloudListener localTRTCCloudListener = (TRTCCloudListener)((WeakReference)a.get(i)).get();
      if (localTRTCCloudListener != null) {
        paramIInformCallback.a(localTRTCCloudListener);
      } else {
        a.remove(i);
      }
      i -= 1;
    }
  }
  
  public void a(TRTCCloudListener paramTRTCCloudListener)
  {
    a.add(new WeakReference(paramTRTCCloudListener));
  }
  
  public void b(TRTCCloudListener paramTRTCCloudListener)
  {
    int i = a.size() - 1;
    while (i >= 0)
    {
      TRTCCloudListener localTRTCCloudListener = (TRTCCloudListener)((WeakReference)a.get(i)).get();
      if (localTRTCCloudListener != null)
      {
        if (paramTRTCCloudListener == localTRTCCloudListener) {
          a.remove(i);
        }
      }
      else {
        a.remove(i);
      }
      i -= 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.trtc.tools.CloudListenerInformer
 * JD-Core Version:    0.7.0.1
 */