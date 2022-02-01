package com.tencent.mobileqq.tofumsg;

import com.tencent.mobileqq.data.NewBeancurdMsg;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

class TofuManagerNew$3
  implements Runnable
{
  TofuManagerNew$3(TofuManagerNew paramTofuManagerNew, CopyOnWriteArrayList paramCopyOnWriteArrayList) {}
  
  public void run()
  {
    Iterator localIterator = this.a.iterator();
    while (localIterator.hasNext())
    {
      NewBeancurdMsg localNewBeancurdMsg = (NewBeancurdMsg)localIterator.next();
      TofuLimitMsg localTofuLimitMsg = TofuLimitMsg.create(localNewBeancurdMsg);
      TofuManagerNew.a(this.this$0, localNewBeancurdMsg, localTofuLimitMsg);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.tofumsg.TofuManagerNew.3
 * JD-Core Version:    0.7.0.1
 */