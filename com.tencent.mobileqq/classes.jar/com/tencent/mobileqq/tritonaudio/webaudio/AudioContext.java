package com.tencent.mobileqq.tritonaudio.webaudio;

import java.util.ArrayList;
import java.util.Iterator;

class AudioContext
{
  private ArrayList<Integer> audioBufferSourceNodeList = new ArrayList();
  private long startTime = System.currentTimeMillis();
  
  public AudioContext()
  {
    AudioNativeManager.initAudioContext();
  }
  
  public int createBufferSource()
  {
    int i = AudioNativeManager.createBufferSource();
    this.audioBufferSourceNodeList.add(Integer.valueOf(i));
    return i;
  }
  
  public float getCurrentGain(int paramInt)
  {
    return AudioNativeManager.getCurrentGain(paramInt);
  }
  
  public long getCurrentTime()
  {
    return System.currentTimeMillis() - this.startTime;
  }
  
  public void setBufferSourceLoop(int paramInt, boolean paramBoolean)
  {
    AudioNativeManager.setBufferSourceLoop(paramInt, paramBoolean);
  }
  
  public void setCurrentGain(int paramInt, double paramDouble)
  {
    AudioNativeManager.setCurrentGain(paramInt, (float)paramDouble);
  }
  
  public void stopAllChannels()
  {
    Iterator localIterator = this.audioBufferSourceNodeList.iterator();
    while (localIterator.hasNext()) {
      AudioNativeManager.stopSource(((Integer)localIterator.next()).intValue());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.tritonaudio.webaudio.AudioContext
 * JD-Core Version:    0.7.0.1
 */