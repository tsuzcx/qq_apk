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
    if (paramInt != 2)
    {
      if (paramInt != 4)
      {
        if (paramInt != 8)
        {
          if (paramInt != 16)
          {
            if (paramInt != 32) {
              return "STATE_ERROR";
            }
            return "STATE_STOPPED";
          }
          return "STATE_PAUSED";
        }
        return "STATE_STARTED";
      }
      return "STATE_INITIALIZED";
    }
    return "STATE_IDLE";
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
    for (;;)
    {
      throw paramVarArgs;
    }
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
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("State[");
    localStringBuilder.append(getStateName(this.state));
    localStringBuilder.append("]");
    return localStringBuilder.toString();
  }
  
  public void transfer(int paramInt)
  {
    try
    {
      String str = AudioRecorderCompat.TAG;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("switch state: ");
      localStringBuilder.append(getStateName(this.state));
      localStringBuilder.append(" -> ");
      localStringBuilder.append(getStateName(paramInt));
      LogUtils.i(str, localStringBuilder.toString());
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.ttpic.voicechanger.common.audio.AudioRecorderCompat.State
 * JD-Core Version:    0.7.0.1
 */