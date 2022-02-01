package com.tencent.trtc;

import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.liteav.trtc.impl.TRTCRoomInfo;
import com.tencent.rtmp.ITXLivePlayListener;
import com.tencent.rtmp.ITXLivePushListener;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Set;

class WXTRTCCloud$9
  implements Runnable
{
  WXTRTCCloud$9(WXTRTCCloud paramWXTRTCCloud, String paramString, int paramInt, Bundle paramBundle) {}
  
  public void run()
  {
    Object localObject;
    if ((!TextUtils.isEmpty(this.a)) && ((WXTRTCCloud.access$4000(this.d).userId == null) || (!this.a.equalsIgnoreCase(WXTRTCCloud.access$4100(this.d).userId))))
    {
      int i = this.c.getInt("EVT_STREAM_TYPE", 2);
      if (WXTRTCCloud.access$4300(this.d).getUser(this.a) != null)
      {
        localObject = null;
        if (i == 7)
        {
          if (WXTRTCCloud.access$300(this.d).keySet().contains(this.a)) {
            localObject = (WeakReference)WXTRTCCloud.access$300(this.d).get(this.a);
          }
        }
        else if (WXTRTCCloud.access$200(this.d).keySet().contains(this.a)) {
          localObject = (WeakReference)WXTRTCCloud.access$200(this.d).get(this.a);
        }
        if (localObject != null)
        {
          localObject = (ITXLivePlayListener)((WeakReference)localObject).get();
          if (localObject != null) {
            ((ITXLivePlayListener)localObject).onPlayEvent(this.b, this.c);
          }
        }
      }
    }
    else if (WXTRTCCloud.access$4200(this.d) != null)
    {
      localObject = (ITXLivePushListener)WXTRTCCloud.access$4200(this.d).get();
      if (localObject != null) {
        ((ITXLivePushListener)localObject).onPushEvent(this.b, this.c);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.trtc.WXTRTCCloud.9
 * JD-Core Version:    0.7.0.1
 */