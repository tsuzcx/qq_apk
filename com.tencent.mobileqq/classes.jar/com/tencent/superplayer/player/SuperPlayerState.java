package com.tencent.superplayer.player;

import com.tencent.superplayer.utils.LogUtil;

class SuperPlayerState
  implements ISuperPlayerState
{
  private static final String FILENAME = "SuperPlayerState.java";
  private String TAG;
  private volatile int mCurState = 0;
  private volatile int mPreState = 0;
  private volatile ISuperPlayerState.OnPlayStateChangeListener mStateListener;
  private Object mStateLock = new Object();
  
  public SuperPlayerState(String paramString)
  {
    this.TAG = (paramString + "_" + "SuperPlayerState.java");
  }
  
  public static String getStateStr(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return " UNKNOW ";
    case 0: 
      return " IDLE ";
    case 1: 
      return " CGIING ";
    case 2: 
      return " CGIED ";
    case 3: 
      return " PREPARING ";
    case 4: 
      return " PREPARED ";
    case 5: 
      return " STARTED ";
    case 6: 
      return " PAUSED ";
    case 7: 
      return " COMPLETE ";
    case 8: 
      return " STOPPED ";
    case 9: 
      return " ERROR ";
    }
    return " RELEASED ";
  }
  
  public void changeStateAndNotify(int paramInt)
  {
    synchronized (this.mStateLock)
    {
      int i = this.mCurState;
      if (paramInt != i)
      {
        this.mCurState = paramInt;
        this.mPreState = i;
        if (this.mStateListener != null) {
          this.mStateListener.onStateChange(copy());
        }
        LogUtil.i(this.TAG, "changeStateAndNotify(), " + getStateStr(i) + " ==> " + getStateStr(paramInt));
      }
      return;
    }
  }
  
  public SuperPlayerState copy()
  {
    SuperPlayerState localSuperPlayerState = new SuperPlayerState(this.TAG);
    localSuperPlayerState.mCurState = this.mCurState;
    localSuperPlayerState.mPreState = this.mPreState;
    return localSuperPlayerState;
  }
  
  public final int getCurState()
  {
    synchronized (this.mStateLock)
    {
      int i = this.mCurState;
      return i;
    }
  }
  
  public final int getPreState()
  {
    synchronized (this.mStateLock)
    {
      int i = this.mPreState;
      return i;
    }
  }
  
  public void setOnPlayStateListener(ISuperPlayerState.OnPlayStateChangeListener paramOnPlayStateChangeListener)
  {
    this.mStateListener = paramOnPlayStateChangeListener;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("FCCPlayerState[ mPreState:").append(getStateStr(this.mPreState)).append("/n");
    localStringBuilder.append("mCurState:").append(getStateStr(this.mCurState)).append("/n");
    localStringBuilder.append("]");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.superplayer.player.SuperPlayerState
 * JD-Core Version:    0.7.0.1
 */