package com.tencent.mobileqq.triton.audio;

import android.os.Handler;
import android.os.HandlerThread;

public class AudioHandleThread
  extends HandlerThread
{
  private static Handler handler;
  private static volatile AudioHandleThread instance;
  
  private AudioHandleThread(String paramString)
  {
    super(paramString);
  }
  
  public static AudioHandleThread getInstance()
  {
    if (instance == null) {}
    try
    {
      if (instance == null)
      {
        AudioHandleThread localAudioHandleThread = new AudioHandleThread(AudioHandleThread.class.getSimpleName());
        localAudioHandleThread.start();
        handler = new Handler(localAudioHandleThread.getLooper());
        instance = localAudioHandleThread;
      }
      return instance;
    }
    finally {}
  }
  
  public Handler getHandler()
  {
    return handler;
  }
  
  public final void post(Runnable paramRunnable)
  {
    handler.post(paramRunnable);
  }
  
  public final void postDelayed(Runnable paramRunnable, long paramLong)
  {
    handler.postDelayed(paramRunnable, paramLong);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.triton.audio.AudioHandleThread
 * JD-Core Version:    0.7.0.1
 */