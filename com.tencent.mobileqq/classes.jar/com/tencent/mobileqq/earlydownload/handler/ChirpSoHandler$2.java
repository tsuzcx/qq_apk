package com.tencent.mobileqq.earlydownload.handler;

import apgs;
import apgt;
import java.util.Iterator;
import java.util.LinkedList;

public class ChirpSoHandler$2
  implements Runnable
{
  public ChirpSoHandler$2(apgs paramapgs) {}
  
  public void run()
  {
    synchronized (apgs.a(this.this$0))
    {
      Iterator localIterator = apgs.a(this.this$0).iterator();
      if (localIterator.hasNext()) {
        ((apgt)localIterator.next()).k();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.earlydownload.handler.ChirpSoHandler.2
 * JD-Core Version:    0.7.0.1
 */