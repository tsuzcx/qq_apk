package com.tencent.mobileqq.vas;

import avtb;
import bgfe;
import java.lang.ref.WeakReference;

class PobingDecoder$2
  implements Runnable
{
  PobingDecoder$2(PobingDecoder paramPobingDecoder, bgfe parambgfe) {}
  
  public void run()
  {
    avtb localavtb = (avtb)this.this$0.a.get();
    if (localavtb != null) {
      localavtb.postQuery(this.a);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.vas.PobingDecoder.2
 * JD-Core Version:    0.7.0.1
 */