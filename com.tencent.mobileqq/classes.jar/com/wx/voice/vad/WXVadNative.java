package com.wx.voice.vad;

public class WXVadNative
{
  public static final int VAD_ERROR = 1;
  public static final int VAD_OK = 0;
  public static final int VAD_SILENCE = 3;
  public static final int VAD_SPEAK = 2;
  public static final int VAD_UNKNOW = 4;
  
  public native WXVadData GetOnlineProcessDataSize(long paramLong);
  
  public native long Init(String paramString1, String paramString2);
  
  public native long InitUserParam(WXVadParam paramWXVadParam);
  
  public native WXVadData OfflineProcess(long paramLong1, short[] paramArrayOfShort, long paramLong2);
  
  public native WXVadData OnlineProcess(long paramLong1, short[] paramArrayOfShort, long paramLong2, int paramInt);
  
  public native int Release(long paramLong);
  
  public native int Reset(long paramLong);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.wx.voice.vad.WXVadNative
 * JD-Core Version:    0.7.0.1
 */