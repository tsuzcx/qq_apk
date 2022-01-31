package com.tencent.mobileqq.earlydownload.handler;

import anpl;
import anpm;
import java.util.Iterator;
import java.util.LinkedList;

public class ChirpSoHandler$2
  implements Runnable
{
  public ChirpSoHandler$2(anpl paramanpl) {}
  
  public void run()
  {
    synchronized (anpl.a(this.this$0))
    {
      Iterator localIterator = anpl.a(this.this$0).iterator();
      if (localIterator.hasNext()) {
        ((anpm)localIterator.next()).k();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.earlydownload.handler.ChirpSoHandler.2
 * JD-Core Version:    0.7.0.1
 */