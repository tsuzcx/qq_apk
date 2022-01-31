package com.tencent.qqmini.sdk.core.manager;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import bgnz;

public class ThreadManager
{
  private static volatile Handler jdField_a_of_type_AndroidOsHandler;
  private static HandlerThread jdField_a_of_type_AndroidOsHandlerThread;
  private static volatile Handler jdField_b_of_type_AndroidOsHandler;
  private static HandlerThread jdField_b_of_type_AndroidOsHandlerThread;
  private static volatile Handler c;
  
  public static Handler a()
  {
    if (jdField_b_of_type_AndroidOsHandler == null) {}
    try
    {
      if (jdField_b_of_type_AndroidOsHandler == null)
      {
        jdField_a_of_type_AndroidOsHandlerThread = new HandlerThread("MINIAPP_SUB", 0);
        jdField_a_of_type_AndroidOsHandlerThread.start();
        jdField_b_of_type_AndroidOsHandler = new Handler(jdField_a_of_type_AndroidOsHandlerThread.getLooper());
      }
      return jdField_b_of_type_AndroidOsHandler;
    }
    finally {}
  }
  
  public static void a(Runnable paramRunnable, int paramInt, bgnz parambgnz, boolean paramBoolean)
  {
    new Thread(new ThreadManager.Job(paramRunnable, parambgnz)).start();
  }
  
  public static Handler b()
  {
    if (c == null) {}
    try
    {
      if (c == null)
      {
        jdField_b_of_type_AndroidOsHandlerThread = new HandlerThread("MINIAPP_FILE", 0);
        jdField_b_of_type_AndroidOsHandlerThread.start();
        c = new Handler(jdField_b_of_type_AndroidOsHandlerThread.getLooper());
      }
      return c;
    }
    finally {}
  }
  
  public static Handler c()
  {
    if (jdField_a_of_type_AndroidOsHandler == null) {}
    try
    {
      if (jdField_a_of_type_AndroidOsHandler == null) {
        jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper());
      }
      return jdField_a_of_type_AndroidOsHandler;
    }
    finally {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.qqmini.sdk.core.manager.ThreadManager
 * JD-Core Version:    0.7.0.1
 */