package com.tencent.tmediacodec.callback;

public abstract interface CodecCallback
{
  public abstract void onCreate(Boolean paramBoolean);
  
  public abstract void onRealRelease();
  
  public abstract void onReuseCodecAPIException(String paramString, Throwable paramThrowable);
  
  public abstract void onStarted(Boolean paramBoolean, String paramString);
  
  public abstract void onTransToKeepPool();
  
  public abstract void onTransToRunningPool();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.tmediacodec.callback.CodecCallback
 * JD-Core Version:    0.7.0.1
 */