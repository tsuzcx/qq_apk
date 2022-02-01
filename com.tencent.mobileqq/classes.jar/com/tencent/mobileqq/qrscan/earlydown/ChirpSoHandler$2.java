package com.tencent.mobileqq.qrscan.earlydown;

import com.tencent.mobileqq.qrscan.chirp.IChirpSoDownload.Callback;
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
      while (localIterator.hasNext()) {
        ((IChirpSoDownload.Callback)localIterator.next()).o();
      }
      return;
    }
    for (;;)
    {
      throw localObject;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qrscan.earlydown.ChirpSoHandler.2
 * JD-Core Version:    0.7.0.1
 */