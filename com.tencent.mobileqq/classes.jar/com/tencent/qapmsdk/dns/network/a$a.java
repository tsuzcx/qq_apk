package com.tencent.qapmsdk.dns.network;

import android.os.Handler;
import android.os.HandlerThread;

final class a$a
  implements a.b
{
  b.a a;
  b.a b;
  String c;
  Handler d;
  final Runnable e = new a.a.1(this);
  
  a$a()
  {
    HandlerThread localHandlerThread = new HandlerThread("httpdns_networkchanged");
    localHandlerThread.start();
    this.d = new Handler(localHandlerThread.getLooper());
  }
  
  public void a()
  {
    this.d.removeCallbacks(this.e);
    this.d.postDelayed(this.e, a.a());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.qapmsdk.dns.network.a.a
 * JD-Core Version:    0.7.0.1
 */