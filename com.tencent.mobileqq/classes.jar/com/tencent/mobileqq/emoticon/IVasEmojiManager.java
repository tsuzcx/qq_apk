package com.tencent.mobileqq.emoticon;

import android.os.Bundle;
import java.util.concurrent.ConcurrentHashMap;

public abstract interface IVasEmojiManager
{
  public static final String TAG = "VasEmojiManager";
  
  public abstract void complete(String paramString, int paramInt);
  
  public abstract ConcurrentHashMap<String, Bundle> getParamMap();
  
  public abstract void onProgress(String paramString, long paramLong1, long paramLong2);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.emoticon.IVasEmojiManager
 * JD-Core Version:    0.7.0.1
 */