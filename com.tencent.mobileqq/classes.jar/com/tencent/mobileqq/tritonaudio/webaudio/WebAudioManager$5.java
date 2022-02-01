package com.tencent.mobileqq.tritonaudio.webaudio;

import android.os.Build.VERSION;
import android.os.Environment;
import com.tencent.mobileqq.triton.script.Argument;
import java.io.File;

class WebAudioManager$5
  implements Runnable
{
  WebAudioManager$5(WebAudioManager paramWebAudioManager, int paramInt, Argument paramArgument, byte[] paramArrayOfByte) {}
  
  public void run()
  {
    AudioDecoder localAudioDecoder = new AudioDecoder();
    localAudioDecoder.setOnDecodeProcessListener(new WebAudioManager.5.1(this, localAudioDecoder));
    if (Build.VERSION.SDK_INT >= 23) {
      localAudioDecoder.decodeInMemory(this.val$audioData, this.val$decodeId);
    }
    while (Build.VERSION.SDK_INT < 16) {
      return;
    }
    String str = Environment.getExternalStorageDirectory().getPath() + "/minigame/audio_" + System.currentTimeMillis();
    this.this$0.writeFile(this.val$audioData, str, false, this.val$audioData.length);
    localAudioDecoder.decodeByPath(str, this.val$decodeId);
    this.this$0.deleteFile(str);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.tritonaudio.webaudio.WebAudioManager.5
 * JD-Core Version:    0.7.0.1
 */