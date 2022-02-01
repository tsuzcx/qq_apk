package com.tencent.thumbplayer.api;

import android.util.SparseArray;
import com.tencent.thumbplayer.adapter.player.ITPPlayerBaseListener.IOnStateChangeListener;

public class TPPlayerState
{
  public static final int COMPLETE = 7;
  public static final int ERROR = 10;
  public static final int IDLE = 1;
  public static final int INDEX = 0;
  public static final int INITIALIZED = 2;
  private static final SparseArray<String> NS_STATES = new SparseArray();
  public static final int PAUSE = 6;
  public static final int PREPARED = 4;
  public static final int PREPARING = 3;
  public static final int RELEASED = 11;
  public static final int START = 5;
  public static final int STOPPED = 9;
  public static final int STOPPING = 8;
  private int mCurState = 1;
  private int mInnerPlayState = 1;
  private int mLastState = 1;
  private int mPreState = 1;
  private ITPPlayerBaseListener.IOnStateChangeListener mStateChangeListener;
  
  static
  {
    NS_STATES.put(1, "IDLE");
    NS_STATES.put(2, "INITIALIZED");
    NS_STATES.put(3, "PREPARING");
    NS_STATES.put(4, "PREPARED");
    NS_STATES.put(5, "START");
    NS_STATES.put(6, "PAUSE");
    NS_STATES.put(7, "COMPLETE");
    NS_STATES.put(8, "STOPPING");
    NS_STATES.put(9, "STOPPED");
    NS_STATES.put(10, "ERROR");
    NS_STATES.put(11, "RELEASED");
  }
  
  public void changeState(int paramInt)
  {
    try
    {
      if (this.mCurState != paramInt)
      {
        this.mPreState = this.mCurState;
        this.mCurState = paramInt;
        if (this.mStateChangeListener != null) {
          this.mStateChangeListener.onStateChange(this.mPreState, this.mCurState);
        }
      }
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public int innerPlayState()
  {
    try
    {
      int i = this.mInnerPlayState;
      return i;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public boolean is(int paramInt)
  {
    try
    {
      int i = this.mCurState;
      boolean bool;
      if (i == paramInt) {
        bool = true;
      } else {
        bool = false;
      }
      return bool;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public int lastState()
  {
    try
    {
      int i = this.mLastState;
      return i;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public int preState()
  {
    try
    {
      int i = this.mPreState;
      return i;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public void setInnerPlayStateState(int paramInt)
  {
    try
    {
      if (this.mInnerPlayState != paramInt) {
        this.mInnerPlayState = paramInt;
      }
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public void setLastState(int paramInt)
  {
    try
    {
      if (this.mLastState != paramInt) {
        this.mLastState = paramInt;
      }
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public void setOnPlayerStateChangeListener(ITPPlayerBaseListener.IOnStateChangeListener paramIOnStateChangeListener)
  {
    this.mStateChangeListener = paramIOnStateChangeListener;
  }
  
  public int state()
  {
    try
    {
      int i = this.mCurState;
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
    try
    {
      String str1 = (String)NS_STATES.get(this.mCurState);
      String str2 = (String)NS_STATES.get(this.mPreState);
      String str3 = (String)NS_STATES.get(this.mLastState);
      String str4 = (String)NS_STATES.get(this.mInnerPlayState);
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("state[ cur : ");
      localStringBuilder.append(str1);
      localStringBuilder.append(" , pre : ");
      localStringBuilder.append(str2);
      localStringBuilder.append(" , last : ");
      localStringBuilder.append(str3);
      localStringBuilder.append(" , inner play : ");
      localStringBuilder.append(str4);
      localStringBuilder.append(" ]");
      str1 = localStringBuilder.toString();
      return str1;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.thumbplayer.api.TPPlayerState
 * JD-Core Version:    0.7.0.1
 */