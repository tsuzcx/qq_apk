package com.tencent.mobileqq.vas;

import axfu;
import bhyt;
import java.lang.ref.WeakReference;

class PobingDecoder$2
  implements Runnable
{
  PobingDecoder$2(PobingDecoder paramPobingDecoder, bhyt parambhyt) {}
  
  public void run()
  {
    axfu localaxfu = (axfu)this.this$0.a.get();
    if (localaxfu != null) {
      localaxfu.postQuery(this.a);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.vas.PobingDecoder.2
 * JD-Core Version:    0.7.0.1
 */