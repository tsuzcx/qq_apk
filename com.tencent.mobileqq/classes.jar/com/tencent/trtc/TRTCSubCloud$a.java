package com.tencent.trtc;

import android.os.Handler;
import com.tencent.liteav.trtc.impl.TRTCRoomInfo;
import java.lang.ref.WeakReference;
import java.util.ArrayList;

class TRTCSubCloud$a
  implements Runnable
{
  private WeakReference<TRTCSubCloud> a;
  
  TRTCSubCloud$a(TRTCSubCloud paramTRTCSubCloud)
  {
    this.a = new WeakReference(paramTRTCSubCloud);
  }
  
  public void run()
  {
    Object localObject = this.a;
    if (localObject != null) {
      localObject = (TRTCSubCloud)((WeakReference)localObject).get();
    } else {
      localObject = null;
    }
    if (localObject != null)
    {
      ArrayList localArrayList = new ArrayList();
      TRTCSubCloud.access$6200((TRTCSubCloud)localObject).forEachUser(new TRTCSubCloud.a.1(this, localArrayList));
      TRTCSubCloud.access$6400((TRTCSubCloud)localObject, new TRTCSubCloud.a.2(this, TRTCSubCloud.access$6300((TRTCSubCloud)localObject), localArrayList));
      if (TRTCSubCloud.access$6500((TRTCSubCloud)localObject) > 0) {
        TRTCSubCloud.access$6800((TRTCSubCloud)localObject).postDelayed(TRTCSubCloud.access$6600((TRTCSubCloud)localObject), TRTCSubCloud.access$6700((TRTCSubCloud)localObject));
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.trtc.TRTCSubCloud.a
 * JD-Core Version:    0.7.0.1
 */