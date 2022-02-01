package com.tencent.trtc;

import com.tencent.rtmp.ITXLivePlayListener;
import java.lang.ref.WeakReference;
import java.util.HashMap;

class WXTRTCCloud$7
  implements Runnable
{
  WXTRTCCloud$7(WXTRTCCloud paramWXTRTCCloud, boolean paramBoolean, String paramString, ITXLivePlayListener paramITXLivePlayListener) {}
  
  public void run()
  {
    if (this.a)
    {
      WXTRTCCloud.access$300(this.d).put(this.b, new WeakReference(this.c));
      return;
    }
    WXTRTCCloud.access$200(this.d).put(this.b, new WeakReference(this.c));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.trtc.WXTRTCCloud.7
 * JD-Core Version:    0.7.0.1
 */