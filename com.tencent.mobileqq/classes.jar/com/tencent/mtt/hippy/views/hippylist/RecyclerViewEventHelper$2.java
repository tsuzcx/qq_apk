package com.tencent.mtt.hippy.views.hippylist;

import com.tencent.mtt.hippy.uimanager.HippyViewEvent;

class RecyclerViewEventHelper$2
  implements Runnable
{
  RecyclerViewEventHelper$2(RecyclerViewEventHelper paramRecyclerViewEventHelper) {}
  
  public void run()
  {
    new HippyViewEvent("initialListReady").send(this.this$0.getParentView(), null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mtt.hippy.views.hippylist.RecyclerViewEventHelper.2
 * JD-Core Version:    0.7.0.1
 */