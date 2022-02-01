package com.tencent.trtc;

import java.lang.ref.WeakReference;
import java.util.HashMap;

class WXTRTCCloud$4
  implements Runnable
{
  WXTRTCCloud$4(WXTRTCCloud paramWXTRTCCloud, String paramString, boolean paramBoolean, WXTRTCCloud.ITXAudioVolumeEvaluationListener paramITXAudioVolumeEvaluationListener) {}
  
  public void run()
  {
    WXTRTCCloud.a locala;
    if (WXTRTCCloud.access$000(this.d).containsKey(this.a))
    {
      locala = (WXTRTCCloud.a)WXTRTCCloud.access$000(this.d).get(this.a);
    }
    else
    {
      locala = new WXTRTCCloud.a(null);
      locala.a = 0;
    }
    if (locala != null)
    {
      if (this.b) {
        locala.c = new WeakReference(this.c);
      } else {
        locala.b = new WeakReference(this.c);
      }
      WXTRTCCloud.access$000(this.d).put(this.a, locala);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.trtc.WXTRTCCloud.4
 * JD-Core Version:    0.7.0.1
 */