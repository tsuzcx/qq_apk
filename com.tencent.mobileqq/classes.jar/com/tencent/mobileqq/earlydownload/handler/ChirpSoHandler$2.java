package com.tencent.mobileqq.earlydownload.handler;

import aplb;
import aplc;
import java.util.Iterator;
import java.util.LinkedList;

public class ChirpSoHandler$2
  implements Runnable
{
  public ChirpSoHandler$2(aplb paramaplb) {}
  
  public void run()
  {
    synchronized (aplb.a(this.this$0))
    {
      Iterator localIterator = aplb.a(this.this$0).iterator();
      if (localIterator.hasNext()) {
        ((aplc)localIterator.next()).k();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.earlydownload.handler.ChirpSoHandler.2
 * JD-Core Version:    0.7.0.1
 */