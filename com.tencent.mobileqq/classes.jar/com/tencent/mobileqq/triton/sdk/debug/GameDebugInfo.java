package com.tencent.mobileqq.triton.sdk.debug;

import android.text.TextUtils;

public class GameDebugInfo
{
  public static final int DEFAULT_DEBUG_PORT = 2507;
  public int debugPort;
  public String roomId;
  public String wsUrl;
  
  public GameDebugInfo(String paramString1, String paramString2)
  {
    this(paramString1, paramString2, 2507);
  }
  
  public GameDebugInfo(String paramString1, String paramString2, int paramInt)
  {
    this.wsUrl = paramString1;
    this.roomId = paramString2;
    this.debugPort = paramInt;
  }
  
  public boolean isValid()
  {
    return (!TextUtils.isEmpty(this.wsUrl)) && (!TextUtils.isEmpty(this.roomId));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.triton.sdk.debug.GameDebugInfo
 * JD-Core Version:    0.7.0.1
 */