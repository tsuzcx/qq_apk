package com.tencent.rmonitor.jvmti;

import java.util.concurrent.ConcurrentHashMap;

final class JvmtiHelper$1
  implements Runnable
{
  public void run()
  {
    if (JvmtiHelper.canUseJvmTi()) {
      JvmtiHelper.access$000().clear();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.rmonitor.jvmti.JvmtiHelper.1
 * JD-Core Version:    0.7.0.1
 */