package com.tencent.mobileqq.msf.core.net;

import java.util.ArrayList;
import java.util.Iterator;

class o
  extends Thread
{
  o(m paramm) {}
  
  public void run()
  {
    Iterator localIterator = this.a.v.iterator();
    while (localIterator.hasNext()) {
      ((m.a)localIterator.next()).a();
    }
    this.a.w.addAll(this.a.v);
    this.a.v.clear();
    this.a.x = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.msf.core.net.o
 * JD-Core Version:    0.7.0.1
 */