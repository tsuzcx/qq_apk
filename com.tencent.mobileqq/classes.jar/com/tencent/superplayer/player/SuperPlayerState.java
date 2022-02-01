package com.tencent.superplayer.player;

import com.tencent.superplayer.utils.LogUtil;

class SuperPlayerState
  implements ISuperPlayerState
{
  private static final String FILENAME = "SuperPlayerState.java";
  private volatile int mCurState = 0;
  private volatile int mPreState = 0;
  private volatile ISuperPlayerState.OnPlayStateChangeListener mStateListener;
  private final Object mStateLock = new Object();
  private String mTAG;
  
  SuperPlayerState(String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramString);
    localStringBuilder.append("-");
    localStringBuilder.append("SuperPlayerState.java");
    this.mTAG = localStringBuilder.toString();
  }
  
  static String getStateStr(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return " UNKNOW ";
    case 10: 
      return " RELEASED ";
    case 9: 
      return " ERROR ";
    case 8: 
      return " STOPPED ";
    case 7: 
      return " COMPLETE ";
    case 6: 
      return " PAUSED ";
    case 5: 
      return " STARTED ";
    case 4: 
      return " PREPARED ";
    case 3: 
      return " PREPARING ";
    case 2: 
      return " CGIED ";
    case 1: 
      return " CGIING ";
    }
    return " IDLE ";
  }
  
  void changeStateAndNotify(int paramInt)
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
        String str = this.mTAG;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("changeStateAndNotify(), ");
        localStringBuilder.append(getStateStr(i));
        localStringBuilder.append(" ==> ");
        localStringBuilder.append(getStateStr(paramInt));
        LogUtil.i(str, localStringBuilder.toString());
      }
      return;
    }
  }
  
  SuperPlayerState copy()
  {
    SuperPlayerState localSuperPlayerState = new SuperPlayerState(this.mTAG);
    localSuperPlayerState.mCurState = this.mCurState;
    localSuperPlayerState.mPreState = this.mPreState;
    return localSuperPlayerState;
  }
  
  int getCurState()
  {
    synchronized (this.mStateLock)
    {
      int i = this.mCurState;
      return i;
    }
  }
  
  int getPreState()
  {
    synchronized (this.mStateLock)
    {
      int i = this.mPreState;
      return i;
    }
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("SuperPlayerState[ mPreState:");
    localStringBuilder.append(getStateStr(this.mPreState));
    localStringBuilder.append("/n");
    localStringBuilder.append("mCurState:");
    localStringBuilder.append(getStateStr(this.mCurState));
    localStringBuilder.append("/n");
    localStringBuilder.append("]");
    return localStringBuilder.toString();
  }
  
  void updatePlayerTag(String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramString);
    localStringBuilder.append("-");
    localStringBuilder.append("SuperPlayerState.java");
    this.mTAG = localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.superplayer.player.SuperPlayerState
 * JD-Core Version:    0.7.0.1
 */