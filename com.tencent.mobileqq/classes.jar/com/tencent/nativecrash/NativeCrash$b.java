package com.tencent.nativecrash;

class NativeCrash$b
  implements Runnable
{
  boolean a = false;
  Throwable b = null;
  final NativeCrash.c c;
  final NativeCrash.a d;
  final int e;
  final String f;
  final String g;
  
  NativeCrash$b(boolean paramBoolean, int paramInt, String paramString1, String paramString2)
  {
    if (paramBoolean)
    {
      this.c = null;
      this.d = NativeCrash.anrCallback();
    }
    else
    {
      this.c = NativeCrash.crashCallback();
      this.d = null;
    }
    this.e = paramInt;
    this.f = paramString1;
    this.g = paramString2;
  }
  
  boolean a()
  {
    if ((this.c == null) && (this.d == null)) {
      return false;
    }
    Thread localThread = new Thread(this, "NativeCrash Dump Callback");
    localThread.start();
    localThread.join(5000L);
    return this.a;
  }
  
  public void run()
  {
    try
    {
      if (this.d != null)
      {
        this.a = this.d.a(this.e, this.g);
        return;
      }
      if (this.c != null)
      {
        this.a = this.c.a(this.e, this.f, this.g);
        return;
      }
      this.a = false;
      return;
    }
    catch (Throwable localThrowable)
    {
      this.b = localThrowable;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.nativecrash.NativeCrash.b
 * JD-Core Version:    0.7.0.1
 */