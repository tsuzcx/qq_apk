package com.tencent.mobileqq.multicard;

import com.tencent.qphone.base.util.QLog;

class MultiCardFragment$MultiCardShowArrow
  implements Runnable
{
  private MultiCardFragment$MultiCardShowArrow(MultiCardFragment paramMultiCardFragment) {}
  
  public void run()
  {
    if (QLog.isColorLevel()) {
      QLog.d("MultiCardFragment", 2, "run() called MiniAIOScrollToNewMsg");
    }
    if (MultiCardFragment.b(this.this$0) != null) {
      MultiCardFragment.b(this.this$0).c();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.multicard.MultiCardFragment.MultiCardShowArrow
 * JD-Core Version:    0.7.0.1
 */