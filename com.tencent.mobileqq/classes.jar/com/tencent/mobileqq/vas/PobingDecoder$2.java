package com.tencent.mobileqq.vas;

import awzc;
import bhny;
import java.lang.ref.WeakReference;

class PobingDecoder$2
  implements Runnable
{
  PobingDecoder$2(PobingDecoder paramPobingDecoder, bhny parambhny) {}
  
  public void run()
  {
    awzc localawzc = (awzc)this.this$0.a.get();
    if (localawzc != null) {
      localawzc.postQuery(this.a);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.vas.PobingDecoder.2
 * JD-Core Version:    0.7.0.1
 */