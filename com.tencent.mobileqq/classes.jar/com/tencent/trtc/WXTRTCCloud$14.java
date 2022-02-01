package com.tencent.trtc;

import android.os.Bundle;
import com.tencent.rtmp.ITXLivePlayListener;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Set;

class WXTRTCCloud$14
  implements Runnable
{
  WXTRTCCloud$14(WXTRTCCloud paramWXTRTCCloud, byte[] paramArrayOfByte, String paramString) {}
  
  public void run()
  {
    Object localObject = this.a;
    if ((localObject != null) && (localObject.length > 0))
    {
      localObject = null;
      if (WXTRTCCloud.access$200(this.c).keySet().contains(this.b)) {
        localObject = (WeakReference)WXTRTCCloud.access$200(this.c).get(this.b);
      } else if (WXTRTCCloud.access$300(this.c).keySet().contains(this.b)) {
        localObject = (WeakReference)WXTRTCCloud.access$300(this.c).get(this.b);
      }
      if (localObject != null)
      {
        localObject = (ITXLivePlayListener)((WeakReference)localObject).get();
        if (localObject != null)
        {
          Bundle localBundle = new Bundle();
          localBundle.putByteArray("EVT_GET_MSG", this.a);
          ((ITXLivePlayListener)localObject).onPlayEvent(2012, localBundle);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.trtc.WXTRTCCloud.14
 * JD-Core Version:    0.7.0.1
 */