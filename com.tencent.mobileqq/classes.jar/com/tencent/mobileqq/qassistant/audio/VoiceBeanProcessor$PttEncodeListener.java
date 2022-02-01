package com.tencent.mobileqq.qassistant.audio;

import android.content.Context;
import com.tencent.mobileqq.qqaudio.audioprocessor.IAudioProcessor;
import com.tencent.mobileqq.qqaudio.audioprocessor.IAudioProcessor.ProcessData;
import com.tencent.mobileqq.qqaudio.audioprocessor.IAudioProcessorListener;
import com.tencent.mobileqq.utils.AudioHelper;
import com.tencent.qphone.base.util.BaseApplication;

public class VoiceBeanProcessor$PttEncodeListener
  implements IAudioProcessorListener
{
  private Context a = BaseApplication.getContext();
  private int b;
  
  public int a()
  {
    return Math.max(2000, this.b);
  }
  
  public void a(IAudioProcessor paramIAudioProcessor, IAudioProcessor.ProcessData paramProcessData) {}
  
  public void b(IAudioProcessor paramIAudioProcessor, IAudioProcessor.ProcessData paramProcessData)
  {
    this.b = ((int)AudioHelper.a(this.a, paramProcessData.c, paramProcessData.a, 1.0F));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qassistant.audio.VoiceBeanProcessor.PttEncodeListener
 * JD-Core Version:    0.7.0.1
 */