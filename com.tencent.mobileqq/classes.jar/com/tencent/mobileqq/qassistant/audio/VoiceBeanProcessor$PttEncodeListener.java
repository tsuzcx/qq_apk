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
  private int jdField_a_of_type_Int;
  private Context jdField_a_of_type_AndroidContentContext = BaseApplication.getContext();
  
  public int a()
  {
    return Math.max(2000, this.jdField_a_of_type_Int);
  }
  
  public void a(IAudioProcessor paramIAudioProcessor, IAudioProcessor.ProcessData paramProcessData) {}
  
  public void b(IAudioProcessor paramIAudioProcessor, IAudioProcessor.ProcessData paramProcessData)
  {
    this.jdField_a_of_type_Int = ((int)AudioHelper.a(this.jdField_a_of_type_AndroidContentContext, paramProcessData.jdField_a_of_type_ArrayOfByte, paramProcessData.jdField_a_of_type_Int, 1.0F));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.qassistant.audio.VoiceBeanProcessor.PttEncodeListener
 * JD-Core Version:    0.7.0.1
 */