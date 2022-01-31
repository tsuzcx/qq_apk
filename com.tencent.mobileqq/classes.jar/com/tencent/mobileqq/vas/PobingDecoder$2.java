package com.tencent.mobileqq.vas;

import aufy;
import bdtm;
import java.lang.ref.WeakReference;

class PobingDecoder$2
  implements Runnable
{
  PobingDecoder$2(PobingDecoder paramPobingDecoder, bdtm parambdtm) {}
  
  public void run()
  {
    aufy localaufy = (aufy)this.this$0.a.get();
    if (localaufy != null) {
      localaufy.postQuery(this.a);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.vas.PobingDecoder.2
 * JD-Core Version:    0.7.0.1
 */