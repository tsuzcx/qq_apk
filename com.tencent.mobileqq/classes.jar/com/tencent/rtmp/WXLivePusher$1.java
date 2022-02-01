package com.tencent.rtmp;

import android.os.Bundle;
import com.tencent.liteav.audio.impl.TXCAudioEngineJNI.a;
import java.lang.ref.WeakReference;

class WXLivePusher$1
  implements TXCAudioEngineJNI.a
{
  WXLivePusher$1(WXLivePusher paramWXLivePusher) {}
  
  public void onLocalAudioWriteFailed()
  {
    if (WXLivePusher.access$000(this.this$0) != null)
    {
      ITXLivePushListener localITXLivePushListener = (ITXLivePushListener)WXLivePusher.access$000(this.this$0).get();
      if (localITXLivePushListener != null)
      {
        Bundle localBundle = new Bundle();
        localBundle.putString("EVT_MSG", "write file failed when recording audio");
        localITXLivePushListener.onPushEvent(7001, localBundle);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.rtmp.WXLivePusher.1
 * JD-Core Version:    0.7.0.1
 */