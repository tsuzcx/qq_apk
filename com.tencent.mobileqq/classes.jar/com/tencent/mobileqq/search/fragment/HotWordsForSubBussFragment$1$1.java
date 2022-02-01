package com.tencent.mobileqq.search.fragment;

import com.tencent.mobileqq.app.UniteSearchHandler;
import com.tencent.qphone.base.util.QLog;

class HotWordsForSubBussFragment$1$1
  implements Runnable
{
  HotWordsForSubBussFragment$1$1(HotWordsForSubBussFragment.1 param1, byte[] paramArrayOfByte) {}
  
  public void run()
  {
    if (this.a != null)
    {
      QLog.d(HotWordsForSubBussFragment.a, 1, "use cache!");
      this.b.this$0.e.a(null, 1000, this.a);
      return;
    }
    if (!this.b.a)
    {
      if (QLog.isColorLevel()) {
        QLog.d(HotWordsForSubBussFragment.a, 2, "hot word list cache is null！");
      }
      this.b.this$0.e.a();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.search.fragment.HotWordsForSubBussFragment.1.1
 * JD-Core Version:    0.7.0.1
 */