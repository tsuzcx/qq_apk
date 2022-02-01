package com.tencent.mobileqq.colornote.swipeback.impl;

import com.tencent.mobileqq.colornote.smallscreen.IServiceSyncListener;
import com.tencent.qphone.base.util.QLog;

class SwipePostTableLayoutImpl$1
  implements IServiceSyncListener
{
  SwipePostTableLayoutImpl$1(SwipePostTableLayoutImpl paramSwipePostTableLayoutImpl) {}
  
  public void onServiceSyncSucc(boolean paramBoolean)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("result: ");
    localStringBuilder.append(paramBoolean);
    QLog.d("SwipePostTableLayout", 1, localStringBuilder.toString());
    this.a.enablePostTable();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.colornote.swipeback.impl.SwipePostTableLayoutImpl.1
 * JD-Core Version:    0.7.0.1
 */