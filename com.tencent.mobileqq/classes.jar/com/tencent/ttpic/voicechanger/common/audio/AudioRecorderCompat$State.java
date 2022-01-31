package com.tencent.ttpic.voicechanger.common.audio;

import com.tencent.ttpic.baseutils.log.LogUtils;

public class AudioRecorderCompat$State
{
  public static final int STATE_ERROR = 1;
  public static final int STATE_IDLE = 2;
  public static final int STATE_INITIALIZED = 4;
  public static final int STATE_PAUSED = 16;
  public static final int STATE_STARTED = 8;
  public static final int STATE_STOPPED = 32;
  protected int state = 2;
  
  public AudioRecorderCompat$State(AudioRecorderCompat paramAudioRecorderCompat) {}
  
  private String getStateName(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return null;
    case 1: 
      return "STATE_ERROR";
    case 2: 
      return "STATE_IDLE";
    case 4: 
      return "STATE_INITIALIZED";
    case 8: 
      return "STATE_STARTED";
    case 16: 
      return "STATE_PAUSED";
    }
    return "STATE_STOPPED";
  }
  
  public boolean equalState(int... paramVarArgs)
  {
    boolean bool = false;
    int j = 0;
    int i = 0;
    try
    {
      while (j < paramVarArgs.length)
      {
        i |= paramVarArgs[j];
        j += 1;
      }
      j = this.state;
      if ((j & i) != 0) {
        bool = true;
      }
      return bool;
    }
    finally {}
  }
  
  public int state()
  {
    try
    {
      int i = this.state;
      return i;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public String toString()
  {
    return "State[" + getStateName(this.state) + "]";
  }
  
  public void transfer(int paramInt)
  {
    try
    {
      LogUtils.i(AudioRecorderCompat.TAG, "switch state: " + getStateName(this.state) + " -> " + getStateName(paramInt));
      this.state = paramInt;
      this.this$0.mCurrentState.notifyAll();
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.ttpic.voicechanger.common.audio.AudioRecorderCompat.State
 * JD-Core Version:    0.7.0.1
 */