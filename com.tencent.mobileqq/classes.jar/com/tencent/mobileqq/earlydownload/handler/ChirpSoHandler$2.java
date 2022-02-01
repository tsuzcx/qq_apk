package com.tencent.mobileqq.earlydownload.handler;

import java.util.Iterator;
import java.util.LinkedList;

class ChirpSoHandler$2
  implements Runnable
{
  ChirpSoHandler$2(ChirpSoHandler paramChirpSoHandler) {}
  
  public void run()
  {
    synchronized (ChirpSoHandler.a(this.this$0))
    {
      Iterator localIterator = ChirpSoHandler.a(this.this$0).iterator();
      if (localIterator.hasNext()) {
        ((ChirpSoHandler.Callback)localIterator.next()).m();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.earlydownload.handler.ChirpSoHandler.2
 * JD-Core Version:    0.7.0.1
 */