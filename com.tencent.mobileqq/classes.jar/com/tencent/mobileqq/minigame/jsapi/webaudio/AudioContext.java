package com.tencent.mobileqq.minigame.jsapi.webaudio;

import java.util.ArrayList;
import java.util.Iterator;

public class AudioContext
{
  private ArrayList<Integer> audioBufferSourceNodeList = new ArrayList();
  public float sampleRate;
  private long startTime = System.currentTimeMillis();
  public String state;
  
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.minigame.jsapi.webaudio.AudioContext
 * JD-Core Version:    0.7.0.1
 */