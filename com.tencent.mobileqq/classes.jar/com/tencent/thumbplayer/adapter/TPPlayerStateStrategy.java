package com.tencent.thumbplayer.adapter;

import androidx.annotation.NonNull;
import com.tencent.thumbplayer.api.TPPlayerState;

public class TPPlayerStateStrategy
{
  public static final int API_GET_BUFFERED = 15;
  public static final int API_GET_DURATION = 11;
  public static final int API_GET_POSITION = 12;
  public static final int API_GET_STATUS = 14;
  public static final int API_GET_VIDEO_SIZE = 13;
  public static final int API_PAUSE = 6;
  public static final int API_PREPARE = 1;
  public static final int API_RELEASE = 16;
  public static final int API_RESET = 8;
  public static final int API_SEEK = 9;
  public static final int API_SELECT_PROGRAM = 18;
  public static final int API_SET_DATASOURCE = 2;
  public static final int API_SET_PARAMS = 3;
  public static final int API_SET_SURFACE = 4;
  public static final int API_START = 5;
  public static final int API_STOP = 7;
  public static final int API_SWITCH_DEF = 17;
  public static final int CB_ON_COMPLETE = 2;
  public static final int CB_ON_DATA_OUTPUT = 7;
  public static final int CB_ON_ERROR = 4;
  public static final int CB_ON_INFO = 3;
  public static final int CB_ON_PREPARED = 1;
  public static final int CB_ON_SEEK_COMPLETE = 5;
  public static final int CB_ON_VIDEO_SIZE_CHANGE = 6;
  private TPPlayerState mState;
  
  public TPPlayerStateStrategy(@NonNull TPPlayerState paramTPPlayerState)
  {
    this.mState = paramTPPlayerState;
  }
  
  private static boolean validCallGetBufferPercent(TPPlayerState paramTPPlayerState)
  {
    return (paramTPPlayerState.is(4)) || (paramTPPlayerState.is(5)) || (paramTPPlayerState.is(6)) || (paramTPPlayerState.is(8)) || (paramTPPlayerState.is(9)) || (paramTPPlayerState.is(7));
  }
  
  private static boolean validCallGetDuration(TPPlayerState paramTPPlayerState)
  {
    return (paramTPPlayerState.is(4)) || (paramTPPlayerState.is(5)) || (paramTPPlayerState.is(6)) || (paramTPPlayerState.is(8)) || (paramTPPlayerState.is(9)) || (paramTPPlayerState.is(7));
  }
  
  private static boolean validCallGetPosition(TPPlayerState paramTPPlayerState)
  {
    boolean bool2 = true;
    boolean bool1 = bool2;
    if (!paramTPPlayerState.is(1))
    {
      bool1 = bool2;
      if (!paramTPPlayerState.is(2))
      {
        bool1 = bool2;
        if (!paramTPPlayerState.is(3))
        {
          bool1 = bool2;
          if (!paramTPPlayerState.is(4))
          {
            bool1 = bool2;
            if (!paramTPPlayerState.is(5))
            {
              bool1 = bool2;
              if (!paramTPPlayerState.is(6))
              {
                bool1 = bool2;
                if (!paramTPPlayerState.is(8))
                {
                  bool1 = bool2;
                  if (!paramTPPlayerState.is(9))
                  {
                    if (paramTPPlayerState.is(7)) {
                      return true;
                    }
                    bool1 = false;
                  }
                }
              }
            }
          }
        }
      }
    }
    return bool1;
  }
  
  private static boolean validCallGetStatus(TPPlayerState paramTPPlayerState)
  {
    boolean bool2 = true;
    boolean bool1 = bool2;
    if (!paramTPPlayerState.is(1))
    {
      bool1 = bool2;
      if (!paramTPPlayerState.is(2))
      {
        bool1 = bool2;
        if (!paramTPPlayerState.is(3))
        {
          bool1 = bool2;
          if (!paramTPPlayerState.is(4))
          {
            bool1 = bool2;
            if (!paramTPPlayerState.is(5))
            {
              bool1 = bool2;
              if (!paramTPPlayerState.is(6))
              {
                bool1 = bool2;
                if (!paramTPPlayerState.is(8))
                {
                  bool1 = bool2;
                  if (!paramTPPlayerState.is(9))
                  {
                    if (paramTPPlayerState.is(7)) {
                      return true;
                    }
                    bool1 = false;
                  }
                }
              }
            }
          }
        }
      }
    }
    return bool1;
  }
  
  private static boolean validCallGetVideoSize(TPPlayerState paramTPPlayerState)
  {
    boolean bool2 = true;
    boolean bool1 = bool2;
    if (!paramTPPlayerState.is(1))
    {
      bool1 = bool2;
      if (!paramTPPlayerState.is(2))
      {
        bool1 = bool2;
        if (!paramTPPlayerState.is(3))
        {
          bool1 = bool2;
          if (!paramTPPlayerState.is(4))
          {
            bool1 = bool2;
            if (!paramTPPlayerState.is(5))
            {
              bool1 = bool2;
              if (!paramTPPlayerState.is(6))
              {
                bool1 = bool2;
                if (!paramTPPlayerState.is(8))
                {
                  bool1 = bool2;
                  if (!paramTPPlayerState.is(9))
                  {
                    if (paramTPPlayerState.is(7)) {
                      return true;
                    }
                    bool1 = false;
                  }
                }
              }
            }
          }
        }
      }
    }
    return bool1;
  }
  
  private static boolean validCallPause(TPPlayerState paramTPPlayerState)
  {
    return (paramTPPlayerState.is(5)) || (paramTPPlayerState.is(6)) || (paramTPPlayerState.is(7));
  }
  
  private static boolean validCallPrepare(TPPlayerState paramTPPlayerState)
  {
    return (paramTPPlayerState.is(2)) || (paramTPPlayerState.is(8)) || (paramTPPlayerState.is(9));
  }
  
  private static boolean validCallRelease(TPPlayerState paramTPPlayerState)
  {
    boolean bool2 = true;
    boolean bool1 = bool2;
    if (!paramTPPlayerState.is(1))
    {
      bool1 = bool2;
      if (!paramTPPlayerState.is(2))
      {
        bool1 = bool2;
        if (!paramTPPlayerState.is(3))
        {
          bool1 = bool2;
          if (!paramTPPlayerState.is(4))
          {
            bool1 = bool2;
            if (!paramTPPlayerState.is(5))
            {
              bool1 = bool2;
              if (!paramTPPlayerState.is(6))
              {
                bool1 = bool2;
                if (!paramTPPlayerState.is(8))
                {
                  bool1 = bool2;
                  if (!paramTPPlayerState.is(9))
                  {
                    bool1 = bool2;
                    if (!paramTPPlayerState.is(7))
                    {
                      if (paramTPPlayerState.is(10)) {
                        return true;
                      }
                      bool1 = false;
                    }
                  }
                }
              }
            }
          }
        }
      }
    }
    return bool1;
  }
  
  private static boolean validCallReset(TPPlayerState paramTPPlayerState)
  {
    boolean bool2 = true;
    boolean bool1 = bool2;
    if (!paramTPPlayerState.is(1))
    {
      bool1 = bool2;
      if (!paramTPPlayerState.is(2))
      {
        bool1 = bool2;
        if (!paramTPPlayerState.is(3))
        {
          bool1 = bool2;
          if (!paramTPPlayerState.is(4))
          {
            bool1 = bool2;
            if (!paramTPPlayerState.is(5))
            {
              bool1 = bool2;
              if (!paramTPPlayerState.is(6))
              {
                bool1 = bool2;
                if (!paramTPPlayerState.is(8))
                {
                  bool1 = bool2;
                  if (!paramTPPlayerState.is(9))
                  {
                    bool1 = bool2;
                    if (!paramTPPlayerState.is(7))
                    {
                      if (paramTPPlayerState.is(10)) {
                        return true;
                      }
                      bool1 = false;
                    }
                  }
                }
              }
            }
          }
        }
      }
    }
    return bool1;
  }
  
  private static boolean validCallSeek(TPPlayerState paramTPPlayerState)
  {
    return (paramTPPlayerState.is(4)) || (paramTPPlayerState.is(5)) || (paramTPPlayerState.is(6)) || (paramTPPlayerState.is(7));
  }
  
  private static boolean validCallSelectProgram(TPPlayerState paramTPPlayerState)
  {
    return (paramTPPlayerState.is(4)) || (paramTPPlayerState.is(5)) || (paramTPPlayerState.is(8)) || (paramTPPlayerState.is(9)) || (paramTPPlayerState.is(6)) || (paramTPPlayerState.is(7));
  }
  
  private static boolean validCallSetDataSource(TPPlayerState paramTPPlayerState)
  {
    return paramTPPlayerState.is(1);
  }
  
  private static boolean validCallSetParams(TPPlayerState paramTPPlayerState)
  {
    boolean bool2 = true;
    boolean bool1 = bool2;
    if (!paramTPPlayerState.is(1))
    {
      bool1 = bool2;
      if (!paramTPPlayerState.is(2))
      {
        bool1 = bool2;
        if (!paramTPPlayerState.is(3))
        {
          bool1 = bool2;
          if (!paramTPPlayerState.is(4))
          {
            bool1 = bool2;
            if (!paramTPPlayerState.is(5))
            {
              bool1 = bool2;
              if (!paramTPPlayerState.is(6))
              {
                bool1 = bool2;
                if (!paramTPPlayerState.is(7))
                {
                  bool1 = bool2;
                  if (!paramTPPlayerState.is(8))
                  {
                    if (paramTPPlayerState.is(9)) {
                      return true;
                    }
                    bool1 = false;
                  }
                }
              }
            }
          }
        }
      }
    }
    return bool1;
  }
  
  private static boolean validCallSetSurface(TPPlayerState paramTPPlayerState)
  {
    return true;
  }
  
  private static boolean validCallStart(TPPlayerState paramTPPlayerState)
  {
    return (paramTPPlayerState.is(4)) || (paramTPPlayerState.is(5)) || (paramTPPlayerState.is(6)) || (paramTPPlayerState.is(7));
  }
  
  private static boolean validCallStop(TPPlayerState paramTPPlayerState)
  {
    return (paramTPPlayerState.is(3)) || (paramTPPlayerState.is(4)) || (paramTPPlayerState.is(5)) || (paramTPPlayerState.is(8)) || (paramTPPlayerState.is(9)) || (paramTPPlayerState.is(6)) || (paramTPPlayerState.is(7));
  }
  
  private static boolean validCallSwitchDef(TPPlayerState paramTPPlayerState)
  {
    return (paramTPPlayerState.is(4)) || (paramTPPlayerState.is(5)) || (paramTPPlayerState.is(6)) || (paramTPPlayerState.is(7));
  }
  
  private static boolean validCallbackOnComplete(TPPlayerState paramTPPlayerState)
  {
    return (paramTPPlayerState.is(4)) || (paramTPPlayerState.is(5)) || (paramTPPlayerState.is(6));
  }
  
  private static boolean validCallbackOnDataOutput(TPPlayerState paramTPPlayerState)
  {
    return (paramTPPlayerState.is(5)) || (paramTPPlayerState.is(6));
  }
  
  private static boolean validCallbackOnError(TPPlayerState paramTPPlayerState)
  {
    return (paramTPPlayerState.is(2)) || (paramTPPlayerState.is(3)) || (paramTPPlayerState.is(4)) || (paramTPPlayerState.is(5)) || (paramTPPlayerState.is(6));
  }
  
  private static boolean validCallbackOnInfo(TPPlayerState paramTPPlayerState)
  {
    return (paramTPPlayerState.is(3)) || (paramTPPlayerState.is(4)) || (paramTPPlayerState.is(5)) || (paramTPPlayerState.is(6));
  }
  
  private static boolean validCallbackOnPrepared(TPPlayerState paramTPPlayerState)
  {
    return paramTPPlayerState.is(3);
  }
  
  private static boolean validCallbackOnSeekComplete(TPPlayerState paramTPPlayerState)
  {
    return (paramTPPlayerState.is(4)) || (paramTPPlayerState.is(5)) || (paramTPPlayerState.is(6));
  }
  
  private static boolean validCallbackOnSizeChange(TPPlayerState paramTPPlayerState)
  {
    return (paramTPPlayerState.is(3)) || (paramTPPlayerState.is(4)) || (paramTPPlayerState.is(5)) || (paramTPPlayerState.is(6));
  }
  
  public final boolean validStateCall(int paramInt)
  {
    if (paramInt == 1) {
      return validCallPrepare(this.mState);
    }
    if (paramInt == 2) {
      return validCallSetDataSource(this.mState);
    }
    if (paramInt == 3) {
      return validCallSetParams(this.mState);
    }
    if (paramInt == 4) {
      return validCallSetSurface(this.mState);
    }
    if (paramInt == 5) {
      return validCallStart(this.mState);
    }
    if (paramInt == 6) {
      return validCallPause(this.mState);
    }
    if (paramInt == 7) {
      return validCallStop(this.mState);
    }
    if (paramInt == 8) {
      return validCallReset(this.mState);
    }
    if (paramInt == 9) {
      return validCallSeek(this.mState);
    }
    if (paramInt == 11) {
      return validCallGetDuration(this.mState);
    }
    if (paramInt == 12) {
      return validCallGetPosition(this.mState);
    }
    if (paramInt == 13) {
      return validCallGetVideoSize(this.mState);
    }
    if (paramInt == 14) {
      return validCallGetStatus(this.mState);
    }
    if (paramInt == 15) {
      return validCallGetBufferPercent(this.mState);
    }
    if (paramInt == 16) {
      return validCallRelease(this.mState);
    }
    if (paramInt == 17) {
      return validCallSwitchDef(this.mState);
    }
    if (paramInt == 18) {
      return validCallSelectProgram(this.mState);
    }
    return false;
  }
  
  public final boolean validStateCallback(int paramInt)
  {
    if (paramInt == 1) {
      return validCallbackOnPrepared(this.mState);
    }
    if (paramInt == 2) {
      return validCallbackOnComplete(this.mState);
    }
    if (paramInt == 3) {
      return validCallbackOnInfo(this.mState);
    }
    if (paramInt == 4) {
      return validCallbackOnError(this.mState);
    }
    if (paramInt == 5) {
      return validCallbackOnSeekComplete(this.mState);
    }
    if (paramInt == 6) {
      return validCallbackOnSizeChange(this.mState);
    }
    if (paramInt == 7) {
      return validCallbackOnDataOutput(this.mState);
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.thumbplayer.adapter.TPPlayerStateStrategy
 * JD-Core Version:    0.7.0.1
 */