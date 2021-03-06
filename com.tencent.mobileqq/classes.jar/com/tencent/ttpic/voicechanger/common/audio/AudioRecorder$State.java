package com.tencent.ttpic.voicechanger.common.audio;

import com.tencent.ttpic.baseutils.log.LogUtils;

public class AudioRecorder$State
{
  public static final int STATE_ERROR = 0;
  public static final int STATE_IDLE = 1;
  public static final int STATE_INITIALIZED = 2;
  public static final int STATE_PAUSED = 8;
  public static final int STATE_STARTED = 4;
  public static final int STATE_STOPPED = 16;
  private int state = 1;
  
  public AudioRecorder$State(AudioRecorder paramAudioRecorder) {}
  
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
    localStringBuilder.append(this.state);
    localStringBuilder.append("]");
    return localStringBuilder.toString();
  }
  
  public void transfer(int paramInt)
  {
    try
    {
      String str = AudioRecorder.access$000();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("switch state: ");
      localStringBuilder.append(this.state);
      localStringBuilder.append(" -> ");
      localStringBuilder.append(paramInt);
      LogUtils.i(str, localStringBuilder.toString());
      this.state = paramInt;
      AudioRecorder.access$100(this.this$0).notifyAll();
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
 * Qualified Name:     com.tencent.ttpic.voicechanger.common.audio.AudioRecorder.State
 * JD-Core Version:    0.7.0.1
 */