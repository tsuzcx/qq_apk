package com.tencent.viola.ui.component;

import com.tencent.viola.ui.view.list.VRecyclerView;

class VRecyclerList$2
  implements Runnable
{
  VRecyclerList$2(VRecyclerList paramVRecyclerList) {}
  
  public void run()
  {
    if (this.this$0.getHostView() != null) {
      ((VRecyclerView)this.this$0.getHostView()).loadMoreFinish(Boolean.valueOf(false));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.viola.ui.component.VRecyclerList.2
 * JD-Core Version:    0.7.0.1
 */