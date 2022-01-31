package com.tencent.mobileqq.vas;

import arok;
import banz;
import java.lang.ref.WeakReference;

class PobingDecoder$2
  implements Runnable
{
  PobingDecoder$2(PobingDecoder paramPobingDecoder, banz parambanz) {}
  
  public void run()
  {
    arok localarok = (arok)this.this$0.a.get();
    if (localarok != null) {
      localarok.postQuery(this.a);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.vas.PobingDecoder.2
 * JD-Core Version:    0.7.0.1
 */