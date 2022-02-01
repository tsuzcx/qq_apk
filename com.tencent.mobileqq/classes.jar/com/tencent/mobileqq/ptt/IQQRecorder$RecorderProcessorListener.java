package com.tencent.mobileqq.ptt;

import com.tencent.mobileqq.qqaudio.audioprocessor.IAudioProcessor;
import com.tencent.mobileqq.qqaudio.audioprocessor.IAudioProcessor.ProcessData;

public abstract interface IQQRecorder$RecorderProcessorListener
{
  public abstract void afterProcess(IAudioProcessor paramIAudioProcessor, IAudioProcessor.ProcessData paramProcessData);
  
  public abstract void beforeProcess(IAudioProcessor paramIAudioProcessor, IAudioProcessor.ProcessData paramProcessData);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.ptt.IQQRecorder.RecorderProcessorListener
 * JD-Core Version:    0.7.0.1
 */