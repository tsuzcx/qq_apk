package com.tencent.mobileqq.search.fragment;

import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.UnifySearchHandler;
import mqq.os.MqqHandler;

class HotWordsForSubBussFragment$2
  implements Runnable
{
  HotWordsForSubBussFragment$2(HotWordsForSubBussFragment paramHotWordsForSubBussFragment, boolean paramBoolean) {}
  
  public void run()
  {
    byte[] arrayOfByte = this.this$0.f.b(UnifySearchHandler.d);
    ThreadManager.getUIHandler().post(new HotWordsForSubBussFragment.2.1(this, arrayOfByte));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.search.fragment.HotWordsForSubBussFragment.2
 * JD-Core Version:    0.7.0.1
 */