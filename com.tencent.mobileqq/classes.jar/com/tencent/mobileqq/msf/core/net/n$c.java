package com.tencent.mobileqq.msf.core.net;

import com.tencent.mobileqq.msf.core.MsfCore;
import com.tencent.mobileqq.msf.core.c.j;

class n$c
  implements Runnable
{
  n$c(n paramn) {}
  
  public void run()
  {
    if (this.a.f.getStatReporter() != null) {
      this.a.f.getStatReporter().k();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.msf.core.net.n.c
 * JD-Core Version:    0.7.0.1
 */