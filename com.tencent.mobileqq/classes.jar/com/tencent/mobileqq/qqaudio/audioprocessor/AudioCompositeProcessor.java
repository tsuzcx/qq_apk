package com.tencent.mobileqq.qqaudio.audioprocessor;

import java.util.ArrayList;
import java.util.Iterator;

public class AudioCompositeProcessor
  implements IAudioProcessor
{
  private IAudioProcessorListener jdField_a_of_type_ComTencentMobileqqQqaudioAudioprocessorIAudioProcessorListener;
  private ArrayList<IAudioProcessor> jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  
  public IAudioProcessor.ProcessData a(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    paramArrayOfByte = new IAudioProcessor.ProcessData(paramArrayOfByte, paramInt1, paramInt2);
    Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
    for (;;)
    {
      Object localObject = paramArrayOfByte;
      IAudioProcessor localIAudioProcessor;
      IAudioProcessor.ProcessData localProcessData;
      if (localIterator.hasNext())
      {
        localIAudioProcessor = (IAudioProcessor)localIterator.next();
        if (this.jdField_a_of_type_ComTencentMobileqqQqaudioAudioprocessorIAudioProcessorListener != null) {
          this.jdField_a_of_type_ComTencentMobileqqQqaudioAudioprocessorIAudioProcessorListener.a(localIAudioProcessor, paramArrayOfByte);
        }
        localProcessData = localIAudioProcessor.a(paramArrayOfByte.jdField_a_of_type_ArrayOfByte, paramArrayOfByte.b, paramArrayOfByte.jdField_a_of_type_Int);
        localObject = localProcessData;
        if (localProcessData != null)
        {
          localObject = localProcessData;
          if (localProcessData.jdField_a_of_type_ArrayOfByte != null)
          {
            if (localProcessData.jdField_a_of_type_Int != 0) {
              break label121;
            }
            localObject = localProcessData;
          }
        }
      }
      return localObject;
      label121:
      paramArrayOfByte = localProcessData;
      if (this.jdField_a_of_type_ComTencentMobileqqQqaudioAudioprocessorIAudioProcessorListener != null)
      {
        this.jdField_a_of_type_ComTencentMobileqqQqaudioAudioprocessorIAudioProcessorListener.b(localIAudioProcessor, localProcessData);
        paramArrayOfByte = localProcessData;
      }
    }
  }
  
  public void a()
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
    while (localIterator.hasNext()) {
      ((IAudioProcessor)localIterator.next()).a();
    }
  }
  
  public void a(int paramInt1, int paramInt2, int paramInt3)
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
    while (localIterator.hasNext()) {
      ((IAudioProcessor)localIterator.next()).a(paramInt1, paramInt2, paramInt3);
    }
  }
  
  public void a(IAudioProcessor paramIAudioProcessor)
  {
    this.jdField_a_of_type_JavaUtilArrayList.add(paramIAudioProcessor);
  }
  
  public void a(IAudioProcessorListener paramIAudioProcessorListener)
  {
    this.jdField_a_of_type_ComTencentMobileqqQqaudioAudioprocessorIAudioProcessorListener = paramIAudioProcessorListener;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.qqaudio.audioprocessor.AudioCompositeProcessor
 * JD-Core Version:    0.7.0.1
 */