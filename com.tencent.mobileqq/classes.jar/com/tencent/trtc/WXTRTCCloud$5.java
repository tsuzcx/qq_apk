package com.tencent.trtc;

import java.util.HashMap;

class WXTRTCCloud$5
  implements Runnable
{
  WXTRTCCloud$5(WXTRTCCloud paramWXTRTCCloud, String paramString, boolean paramBoolean) {}
  
  public void run()
  {
    if (WXTRTCCloud.access$000(this.c).containsKey(this.a))
    {
      WXTRTCCloud.a locala = (WXTRTCCloud.a)WXTRTCCloud.access$000(this.c).get(this.a);
      if (locala != null)
      {
        if (this.b) {
          locala.c = null;
        } else {
          locala.b = null;
        }
        if ((locala.b == null) && (locala.c == null)) {
          WXTRTCCloud.access$000(this.c).remove(this.a);
        }
      }
      else
      {
        WXTRTCCloud.access$000(this.c).remove(this.a);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.trtc.WXTRTCCloud.5
 * JD-Core Version:    0.7.0.1
 */