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
    if (Build.VERSION.SDK_INT >= 23)
    {
      localAudioDecoder.decodeInMemory(this.val$audioData, this.val$decodeId);
      return;
    }
    if (Build.VERSION.SDK_INT >= 16)
    {
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append(Environment.getExternalStorageDirectory().getPath());
      ((StringBuilder)localObject).append("/minigame/audio_");
      ((StringBuilder)localObject).append(System.currentTimeMillis());
      localObject = ((StringBuilder)localObject).toString();
      WebAudioManager localWebAudioManager = this.this$0;
      byte[] arrayOfByte = this.val$audioData;
      localWebAudioManager.writeFile(arrayOfByte, (String)localObject, false, arrayOfByte.length);
      localAudioDecoder.decodeByPath((String)localObject, this.val$decodeId);
      this.this$0.deleteFile((String)localObject);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.tritonaudio.webaudio.WebAudioManager.5
 * JD-Core Version:    0.7.0.1
 */