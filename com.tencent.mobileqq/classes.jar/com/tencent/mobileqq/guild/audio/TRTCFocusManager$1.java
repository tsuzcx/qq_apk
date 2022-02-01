package com.tencent.mobileqq.guild.audio;

import com.tencent.mobileqq.guild.api.IGuildTRTCFocusApi.TRTCFocusListener;
import mqq.util.WeakReference;

class TRTCFocusManager$1
  implements Runnable
{
  TRTCFocusManager$1(TRTCFocusManager paramTRTCFocusManager) {}
  
  public void run()
  {
    if (TRTCFocusManager.a(this.this$0) != null)
    {
      TRTCFocusManager localTRTCFocusManager = this.this$0;
      localTRTCFocusManager.a((IGuildTRTCFocusApi.TRTCFocusListener)TRTCFocusManager.a(localTRTCFocusManager).get());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.guild.audio.TRTCFocusManager.1
 * JD-Core Version:    0.7.0.1
 */