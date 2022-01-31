package com.tencent.qqmini.sdk.minigame.utils;

import android.os.Handler;
import android.os.HandlerThread;
import bdew;

public class TTHandleThread
  extends HandlerThread
{
  private static Handler jdField_a_of_type_AndroidOsHandler;
  private static volatile TTHandleThread jdField_a_of_type_ComTencentQqminiSdkMinigameUtilsTTHandleThread;
  
  private TTHandleThread(String paramString)
  {
    super(paramString);
  }
  
  public static TTHandleThread a()
  {
    if (jdField_a_of_type_ComTencentQqminiSdkMinigameUtilsTTHandleThread == null) {}
    try
    {
      if (jdField_a_of_type_ComTencentQqminiSdkMinigameUtilsTTHandleThread == null)
      {
        TTHandleThread localTTHandleThread = new TTHandleThread("TTIOThread");
        localTTHandleThread.start();
        jdField_a_of_type_AndroidOsHandler = new Handler(localTTHandleThread.getLooper());
        jdField_a_of_type_ComTencentQqminiSdkMinigameUtilsTTHandleThread = localTTHandleThread;
      }
      return jdField_a_of_type_ComTencentQqminiSdkMinigameUtilsTTHandleThread;
    }
    finally {}
  }
  
  public final void a(Runnable paramRunnable)
  {
    bdew.b().post(paramRunnable);
  }
  
  public final void a(Runnable paramRunnable, long paramLong)
  {
    jdField_a_of_type_AndroidOsHandler.postDelayed(paramRunnable, paramLong);
  }
  
  public final void b(Runnable paramRunnable)
  {
    jdField_a_of_type_AndroidOsHandler.post(paramRunnable);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.sdk.minigame.utils.TTHandleThread
 * JD-Core Version:    0.7.0.1
 */