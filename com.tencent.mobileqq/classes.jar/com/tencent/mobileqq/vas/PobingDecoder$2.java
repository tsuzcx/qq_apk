package com.tencent.mobileqq.vas;

import aubp;
import bdpd;
import java.lang.ref.WeakReference;

class PobingDecoder$2
  implements Runnable
{
  PobingDecoder$2(PobingDecoder paramPobingDecoder, bdpd parambdpd) {}
  
  public void run()
  {
    aubp localaubp = (aubp)this.this$0.a.get();
    if (localaubp != null) {
      localaubp.postQuery(this.a);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.vas.PobingDecoder.2
 * JD-Core Version:    0.7.0.1
 */