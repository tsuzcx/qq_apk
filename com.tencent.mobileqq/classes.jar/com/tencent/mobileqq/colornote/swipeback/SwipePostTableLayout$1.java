package com.tencent.mobileqq.colornote.swipeback;

import com.tencent.TMG.utils.QLog;
import com.tencent.mobileqq.colornote.smallscreen.IServiceSyncListener;

class SwipePostTableLayout$1
  implements IServiceSyncListener
{
  SwipePostTableLayout$1(SwipePostTableLayout paramSwipePostTableLayout) {}
  
  public void onServiceSyncSucc(boolean paramBoolean)
  {
    QLog.d("SwipePostTableLayout", 1, "result: " + paramBoolean);
    this.a.k();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.colornote.swipeback.SwipePostTableLayout.1
 * JD-Core Version:    0.7.0.1
 */