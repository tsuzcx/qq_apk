package com.tencent.trackrecordlib.e;

import android.content.Context;
import android.os.PowerManager;

public class b
  implements a
{
  private static final String a = b.class.getSimpleName();
  private boolean b;
  private PowerManager c;
  private boolean d;
  
  public b(Context paramContext)
  {
    this.c = ((PowerManager)paramContext.getSystemService("power"));
    this.b = false;
    this.d = true;
  }
  
  public void a()
  {
    new Thread(new b.1(this), "PowerKeyMonitorThread").start();
  }
  
  public void b()
  {
    this.b = true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.trackrecordlib.e.b
 * JD-Core Version:    0.7.0.1
 */