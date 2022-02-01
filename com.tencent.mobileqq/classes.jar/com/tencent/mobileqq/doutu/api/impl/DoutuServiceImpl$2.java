package com.tencent.mobileqq.doutu.api.impl;

import com.tencent.mobileqq.doutu.DoutuEmotionHorizonListView.HorizonListViewTouchListener;
import mqq.os.MqqHandler;

class DoutuServiceImpl$2
  implements DoutuEmotionHorizonListView.HorizonListViewTouchListener
{
  DoutuServiceImpl$2(DoutuServiceImpl paramDoutuServiceImpl, MqqHandler paramMqqHandler) {}
  
  public void a(int paramInt)
  {
    MqqHandler localMqqHandler;
    if (paramInt != 0)
    {
      if ((paramInt != 1) && (paramInt != 3)) {
        return;
      }
      localMqqHandler = this.jdField_a_of_type_MqqOsMqqHandler;
      if (localMqqHandler != null) {
        localMqqHandler.sendEmptyMessageDelayed(80, 5000L);
      }
    }
    else
    {
      localMqqHandler = this.jdField_a_of_type_MqqOsMqqHandler;
      if (localMqqHandler != null) {
        localMqqHandler.removeMessages(80);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.doutu.api.impl.DoutuServiceImpl.2
 * JD-Core Version:    0.7.0.1
 */