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
    if (paramMessage.what != 1) {
      return;
    }
    paramMessage = (Pair)paramMessage.obj;
    MediaCodecAudioRender localMediaCodecAudioRender = this.a;
    MediaCodecAudioRender.a(localMediaCodecAudioRender, MediaCodecAudioRender.a(localMediaCodecAudioRender), (byte[])paramMessage.first, ((Integer)paramMessage.second).intValue());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qg.video.videodecoder.MediaCodecAudioRender.AudioDecodeHandler
 * JD-Core Version:    0.7.0.1
 */