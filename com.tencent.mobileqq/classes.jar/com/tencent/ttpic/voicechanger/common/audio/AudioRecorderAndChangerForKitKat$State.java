package com.tencent.ttpic.voicechanger.common.audio;

import com.tencent.ttpic.baseutils.log.LogUtils;

public class AudioRecorderAndChangerForKitKat$State
{
  public static final int STATE_ERROR = 1;
  public static final int STATE_IDLE = 2;
  public static final int STATE_INITIALIZED = 4;
  public static final int STATE_PAUSED = 16;
  public static final int STATE_STARTED = 8;
  public static final int STATE_STOPPED = 32;
  protected int state = 2;
  
  public AudioRecorderAndChangerForKitKat$State(AudioRecorderAndChangerForKitKat paramAudioRecorderAndChangerForKitKat) {}
  
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
    return "State[" + this.state + "]";
  }
  
  public void transfer(int paramInt)
  {
    try
    {
      LogUtils.i(AudioRecorderCompat.TAG, "switch state: " + this.state + " -> " + paramInt);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.ttpic.voicechanger.common.audio.AudioRecorderAndChangerForKitKat.State
 * JD-Core Version:    0.7.0.1
 */