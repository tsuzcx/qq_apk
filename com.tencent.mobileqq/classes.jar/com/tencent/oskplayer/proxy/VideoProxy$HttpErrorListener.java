package com.tencent.oskplayer.proxy;

import java.util.List;
import java.util.Map;

public abstract interface VideoProxy$HttpErrorListener
{
  public static final String MSG_KEY_ERR_MSG = "error_msg";
  public static final String MSG_KEY_PRIORITY = "priority";
  
  public abstract void onHttpError(String paramString1, String paramString2, int paramInt1, Map<String, Object> paramMap, Map<String, List<String>> paramMap1, int paramInt2, long paramLong1, long paramLong2);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.oskplayer.proxy.VideoProxy.HttpErrorListener
 * JD-Core Version:    0.7.0.1
 */