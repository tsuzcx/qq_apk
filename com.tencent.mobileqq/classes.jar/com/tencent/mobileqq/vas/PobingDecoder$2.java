package com.tencent.mobileqq.vas;

import askq;
import bbqj;
import java.lang.ref.WeakReference;

class PobingDecoder$2
  implements Runnable
{
  PobingDecoder$2(PobingDecoder paramPobingDecoder, bbqj parambbqj) {}
  
  public void run()
  {
    askq localaskq = (askq)this.this$0.a.get();
    if (localaskq != null) {
      localaskq.postQuery(this.a);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.vas.PobingDecoder.2
 * JD-Core Version:    0.7.0.1
 */