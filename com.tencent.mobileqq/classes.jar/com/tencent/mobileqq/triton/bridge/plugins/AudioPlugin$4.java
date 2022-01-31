package com.tencent.mobileqq.triton.bridge.plugins;

import com.tencent.mobileqq.triton.audio.TTAudioPlayerManager;

class AudioPlugin$4
  implements Runnable
{
  AudioPlugin$4(AudioPlugin paramAudioPlugin, int paramInt) {}
  
  public void run()
  {
    AudioPlugin.access$000(this.this$0).destroyAudioContext(this.val$id);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.triton.bridge.plugins.AudioPlugin.4
 * JD-Core Version:    0.7.0.1
 */