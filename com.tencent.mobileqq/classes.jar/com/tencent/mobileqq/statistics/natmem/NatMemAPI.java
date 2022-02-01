package com.tencent.mobileqq.statistics.natmem;

import android.content.Context;
import com.tencent.mobileqq.app.ThreadManagerV2;
import mqq.app.MobileQQ;

public class NatMemAPI
{
  public static void a()
  {
    NativeMemoryUtils.a();
    c();
  }
  
  public static void a(Context paramContext)
  {
    NativeMemoryUtils.c();
  }
  
  public static void b()
  {
    NativeMemoryUtils.a(false);
    if (MobileQQ.sProcessId == 1) {
      NativeMemoryUtils.a(0);
    }
  }
  
  public static void c()
  {
    ThreadManagerV2.executeOnSubThread(new NatMemAPI.1());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.statistics.natmem.NatMemAPI
 * JD-Core Version:    0.7.0.1
 */