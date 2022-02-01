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
    Object localObject2;
    for (;;)
    {
      localObject2 = paramArrayOfByte;
      if (!localIterator.hasNext()) {
        break;
      }
      IAudioProcessor localIAudioProcessor = (IAudioProcessor)localIterator.next();
      Object localObject1 = this.jdField_a_of_type_ComTencentMobileqqQqaudioAudioprocessorIAudioProcessorListener;
      if (localObject1 != null) {
        ((IAudioProcessorListener)localObject1).a(localIAudioProcessor, paramArrayOfByte);
      }
      localObject1 = localIAudioProcessor.a(paramArrayOfByte.jdField_a_of_type_ArrayOfByte, paramArrayOfByte.b, paramArrayOfByte.jdField_a_of_type_Int);
      localObject2 = localObject1;
      if (localObject1 == null) {
        break;
      }
      localObject2 = localObject1;
      if (((IAudioProcessor.ProcessData)localObject1).jdField_a_of_type_ArrayOfByte == null) {
        break;
      }
      if (((IAudioProcessor.ProcessData)localObject1).jdField_a_of_type_Int == 0) {
        return localObject1;
      }
      localObject2 = this.jdField_a_of_type_ComTencentMobileqqQqaudioAudioprocessorIAudioProcessorListener;
      paramArrayOfByte = (byte[])localObject1;
      if (localObject2 != null)
      {
        ((IAudioProcessorListener)localObject2).b(localIAudioProcessor, (IAudioProcessor.ProcessData)localObject1);
        paramArrayOfByte = (byte[])localObject1;
      }
    }
    return localObject2;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.qqaudio.audioprocessor.AudioCompositeProcessor
 * JD-Core Version:    0.7.0.1
 */