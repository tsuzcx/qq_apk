package com.tencent.mobileqq.search.fragment;

import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.UniteSearchHandler;
import mqq.os.MqqHandler;

class HotWordsForSubBussFragment$1
  implements Runnable
{
  HotWordsForSubBussFragment$1(HotWordsForSubBussFragment paramHotWordsForSubBussFragment, boolean paramBoolean) {}
  
  public void run()
  {
    byte[] arrayOfByte = this.this$0.a.a(UniteSearchHandler.a);
    ThreadManager.getUIHandler().post(new HotWordsForSubBussFragment.1.1(this, arrayOfByte));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.search.fragment.HotWordsForSubBussFragment.1
 * JD-Core Version:    0.7.0.1
 */