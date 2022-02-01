package com.tencent.mobileqq.earlydownload.handler;

import aqxj;
import aqxk;
import java.util.Iterator;
import java.util.LinkedList;

public class ChirpSoHandler$2
  implements Runnable
{
  public ChirpSoHandler$2(aqxj paramaqxj) {}
  
  public void run()
  {
    synchronized (aqxj.a(this.this$0))
    {
      Iterator localIterator = aqxj.a(this.this$0).iterator();
      if (localIterator.hasNext()) {
        ((aqxk)localIterator.next()).m();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.earlydownload.handler.ChirpSoHandler.2
 * JD-Core Version:    0.7.0.1
 */