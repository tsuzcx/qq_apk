package com.tencent.mobileqq.triton.audio;

import com.tencent.mobileqq.triton.sdk.audio.IAudioPlayer;
import com.tencent.mobileqq.triton.sdk.audio.IAudioPlayerBuilder;

public class InnerAudioPlayerBuilder
  implements IAudioPlayerBuilder
{
  public IAudioPlayer build()
  {
    return new InnerAudioPlayer();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.triton.audio.InnerAudioPlayerBuilder
 * JD-Core Version:    0.7.0.1
 */