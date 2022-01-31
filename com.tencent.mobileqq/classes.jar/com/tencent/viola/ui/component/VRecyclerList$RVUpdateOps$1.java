package com.tencent.viola.ui.component;

import java.util.Iterator;
import java.util.List;

class VRecyclerList$RVUpdateOps$1
  implements Runnable
{
  VRecyclerList$RVUpdateOps$1(VRecyclerList.RVUpdateOps paramRVUpdateOps) {}
  
  public void run()
  {
    Iterator localIterator = VRecyclerList.RVUpdateOps.access$200(this.this$1).iterator();
    while (localIterator.hasNext())
    {
      VRecyclerList.UpdateOp localUpdateOp = (VRecyclerList.UpdateOp)localIterator.next();
      VRecyclerList.RVUpdateOps.access$300(this.this$1, localUpdateOp);
    }
    VRecyclerList.RVUpdateOps.access$200(this.this$1).clear();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.viola.ui.component.VRecyclerList.RVUpdateOps.1
 * JD-Core Version:    0.7.0.1
 */