package com.tencent.mobileqq.utils;

import com.tencent.mobileqq.qqaudio.audioprocessor.IAudioProcessor;
import com.tencent.mobileqq.qqaudio.audioprocessor.IAudioProcessor.ProcessData;

public abstract interface QQRecorder$RecorderProcessorListener
{
  public abstract void a(IAudioProcessor paramIAudioProcessor, IAudioProcessor.ProcessData paramProcessData);
  
  public abstract void b(IAudioProcessor paramIAudioProcessor, IAudioProcessor.ProcessData paramProcessData);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.utils.QQRecorder.RecorderProcessorListener
 * JD-Core Version:    0.7.0.1
 */