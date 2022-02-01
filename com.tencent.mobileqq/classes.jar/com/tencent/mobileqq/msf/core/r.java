package com.tencent.mobileqq.msf.core;

final class r
  implements Runnable
{
  r(q.a parama, Runnable paramRunnable) {}
  
  public void run()
  {
    q.a locala = this.a;
    if (locala != null) {
      locala.a();
    }
    this.b.run();
    locala = this.a;
    if (locala != null) {
      locala.b();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.msf.core.r
 * JD-Core Version:    0.7.0.1
 */