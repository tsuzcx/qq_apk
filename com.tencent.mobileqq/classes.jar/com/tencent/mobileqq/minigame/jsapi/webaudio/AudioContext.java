package com.tencent.mobileqq.minigame.jsapi.webaudio;

import com.tencent.mobileqq.triton.sdk.audio.IAudioNativeManager;
import java.util.ArrayList;
import java.util.Iterator;

public class AudioContext
{
  private ArrayList<Integer> audioBufferSourceNodeList = new ArrayList();
  private IAudioNativeManager mAudioNativeManager;
  public float sampleRate;
  private long startTime = System.currentTimeMillis();
  public String state;
  
  public AudioContext(IAudioNativeManager paramIAudioNativeManager)
  {
    if (paramIAudioNativeManager != null)
    {
      this.mAudioNativeManager = paramIAudioNativeManager;
      this.mAudioNativeManager.initAudioContext();
    }
  }
  
  public int createBufferSource()
  {
    if (this.mAudioNativeManager != null)
    {
      int i = this.mAudioNativeManager.createBufferSource();
      this.audioBufferSourceNodeList.add(Integer.valueOf(i));
      return i;
    }
    return -1;
  }
  
  public float getCurrentGain(int paramInt)
  {
    if (this.mAudioNativeManager != null) {
      return this.mAudioNativeManager.getCurrentGain(paramInt);
    }
    return 0.0F;
  }
  
  public long getCurrentTime()
  {
    return System.currentTimeMillis() - this.startTime;
  }
  
  public void setBufferSourceLoop(int paramInt, boolean paramBoolean)
  {
    if (this.mAudioNativeManager != null) {
      this.mAudioNativeManager.setBufferSourceLoop(paramInt, paramBoolean);
    }
  }
  
  public void setCurrentGain(int paramInt, double paramDouble)
  {
    if (this.mAudioNativeManager != null) {
      this.mAudioNativeManager.setCurrentGain(paramInt, (float)paramDouble);
    }
  }
  
  public void stopAllChannels()
  {
    if (this.mAudioNativeManager != null)
    {
      Iterator localIterator = this.audioBufferSourceNodeList.iterator();
      while (localIterator.hasNext())
      {
        int i = ((Integer)localIterator.next()).intValue();
        this.mAudioNativeManager.stopSource(i);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.minigame.jsapi.webaudio.AudioContext
 * JD-Core Version:    0.7.0.1
 */