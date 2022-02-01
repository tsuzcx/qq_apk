package com.tencent.mobileqq.search.fragment;

import aokg;
import com.tencent.mobileqq.app.ThreadManager;
import mqq.os.MqqHandler;

class HotWordsForSubBussFragment$1
  implements Runnable
{
  HotWordsForSubBussFragment$1(HotWordsForSubBussFragment paramHotWordsForSubBussFragment, boolean paramBoolean) {}
  
  public void run()
  {
    byte[] arrayOfByte = this.this$0.a.a(aokg.a);
    ThreadManager.getUIHandler().post(new HotWordsForSubBussFragment.1.1(this, arrayOfByte));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.search.fragment.HotWordsForSubBussFragment.1
 * JD-Core Version:    0.7.0.1
 */