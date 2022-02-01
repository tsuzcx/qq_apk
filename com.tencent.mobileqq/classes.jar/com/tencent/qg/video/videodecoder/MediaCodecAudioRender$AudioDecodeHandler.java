package com.tencent.qg.video.videodecoder;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.tencent.util.Pair;

public class MediaCodecAudioRender$AudioDecodeHandler
  extends Handler
{
  public MediaCodecAudioRender$AudioDecodeHandler(MediaCodecAudioRender paramMediaCodecAudioRender, Looper paramLooper)
  {
    super(paramLooper);
  }
  
  public void handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    default: 
      return;
    }
    paramMessage = (Pair)paramMessage.obj;
    MediaCodecAudioRender.a(this.a, MediaCodecAudioRender.a(this.a), (byte[])paramMessage.first, ((Integer)paramMessage.second).intValue());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.qg.video.videodecoder.MediaCodecAudioRender.AudioDecodeHandler
 * JD-Core Version:    0.7.0.1
 */