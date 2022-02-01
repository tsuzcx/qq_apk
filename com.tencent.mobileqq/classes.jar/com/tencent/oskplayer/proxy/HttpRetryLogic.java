package com.tencent.oskplayer.proxy;

import java.util.List;
import java.util.Map;

public abstract interface HttpRetryLogic
{
  public abstract String getRetryUrl(String paramString, int paramInt1, int paramInt2, Map<String, List<String>> paramMap);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.oskplayer.proxy.HttpRetryLogic
 * JD-Core Version:    0.7.0.1
 */