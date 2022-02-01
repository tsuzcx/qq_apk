package com.tencent.mobileqq.qqaudio.audioprocessor;

import java.util.ArrayList;
import java.util.Iterator;

public class AudioCompositeProcessor
  implements IAudioProcessor
{
  private ArrayList<IAudioProcessor> a = new ArrayList();
  private IAudioProcessorListener b;
  
  public IAudioProcessor.ProcessData a(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    paramArrayOfByte = new IAudioProcessor.ProcessData(paramArrayOfByte, paramInt1, paramInt2);
    Iterator localIterator = this.a.iterator();
    Object localObject2;
    for (;;)
    {
      localObject2 = paramArrayOfByte;
      if (!localIterator.hasNext()) {
        break;
      }
      IAudioProcessor localIAudioProcessor = (IAudioProcessor)localIterator.next();
      Object localObject1 = this.b;
      if (localObject1 != null) {
        ((IAudioProcessorListener)localObject1).a(localIAudioProcessor, paramArrayOfByte);
      }
      localObject1 = localIAudioProcessor.a(paramArrayOfByte.c, paramArrayOfByte.b, paramArrayOfByte.a);
      localObject2 = localObject1;
      if (localObject1 == null) {
        break;
      }
      localObject2 = localObject1;
      if (((IAudioProcessor.ProcessData)localObject1).c == null) {
        break;
      }
      if (((IAudioProcessor.ProcessData)localObject1).a == 0) {
        return localObject1;
      }
      localObject2 = this.b;
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
    Iterator localIterator = this.a.iterator();
    while (localIterator.hasNext()) {
      ((IAudioProcessor)localIterator.next()).a();
    }
  }
  
  public void a(int paramInt1, int paramInt2, int paramInt3)
  {
    Iterator localIterator = this.a.iterator();
    while (localIterator.hasNext()) {
      ((IAudioProcessor)localIterator.next()).a(paramInt1, paramInt2, paramInt3);
    }
  }
  
  public void a(IAudioProcessor paramIAudioProcessor)
  {
    this.a.add(paramIAudioProcessor);
  }
  
  public void a(IAudioProcessorListener paramIAudioProcessorListener)
  {
    this.b = paramIAudioProcessorListener;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqaudio.audioprocessor.AudioCompositeProcessor
 * JD-Core Version:    0.7.0.1
 */