package com.tencent.thumbplayer.core.common;

import android.util.Log;

public class TPNativeLog
{
  public static final int LEVEL_DEBUG = 1;
  public static final int LEVEL_ERROR = 4;
  public static final int LEVEL_INFO = 2;
  public static final int LEVEL_VERBOSE = 0;
  public static final int LEVEL_WARN = 3;
  private static final String TAG = "PlayerCore";
  private static ITPNativeLogCallback mLogCallback;
  
  @TPMethodCalledByNative
  private static void onPrintLog(int paramInt1, byte[] paramArrayOfByte1, int paramInt2, byte[] paramArrayOfByte2, int paramInt3)
  {
    int i = 0;
    for (;;)
    {
      try
      {
        paramArrayOfByte1 = new String(paramArrayOfByte1, 0, paramInt2, "UTF-8");
        paramArrayOfByte2 = new String(paramArrayOfByte2, 0, paramInt3, "UTF-8");
        if (paramInt1 == 0) {
          break label87;
        }
        if (paramInt1 == 1) {
          break label82;
        }
        if (paramInt1 == 2) {
          break label77;
        }
        if (paramInt1 != 3)
        {
          paramInt1 = i;
          printLog(paramInt1, paramArrayOfByte1, paramArrayOfByte2);
          return;
        }
      }
      catch (Exception paramArrayOfByte1)
      {
        printLog(4, paramArrayOfByte1.getMessage());
        return;
      }
      paramInt1 = 1;
      continue;
      label77:
      paramInt1 = 2;
      continue;
      label82:
      paramInt1 = 3;
      continue;
      label87:
      paramInt1 = 4;
    }
  }
  
  public static void printLog(int paramInt, String paramString)
  {
    printLog(paramInt, "PlayerCore", paramString);
  }
  
  public static void printLog(int paramInt, String paramString1, String paramString2)
  {
    ITPNativeLogCallback localITPNativeLogCallback = mLogCallback;
    if (localITPNativeLogCallback != null)
    {
      localITPNativeLogCallback.onPrintLog(paramInt, paramString1, paramString2);
      return;
    }
    printLogDefault(paramInt, paramString1, paramString2);
  }
  
  public static void printLogDefault(int paramInt, String paramString1, String paramString2)
  {
    if (paramInt != 0)
    {
      if (paramInt != 1)
      {
        if (paramInt != 2)
        {
          if (paramInt != 3)
          {
            if (paramInt != 4)
            {
              Log.v(paramString1, paramString2);
              return;
            }
            Log.e(paramString1, paramString2);
            return;
          }
          Log.w(paramString1, paramString2);
          return;
        }
        Log.i(paramString1, paramString2);
        return;
      }
      Log.d(paramString1, paramString2);
      return;
    }
    Log.v(paramString1, paramString2);
  }
  
  public static void setLogCallback(ITPNativeLogCallback paramITPNativeLogCallback)
  {
    mLogCallback = paramITPNativeLogCallback;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.thumbplayer.core.common.TPNativeLog
 * JD-Core Version:    0.7.0.1
 */