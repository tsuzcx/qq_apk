package com.tencent.mobileqq.search.fragment;

import com.tencent.mobileqq.app.UnifySearchHandler;
import com.tencent.qphone.base.util.QLog;

class HotWordsForSubBussFragment$2$1
  implements Runnable
{
  HotWordsForSubBussFragment$2$1(HotWordsForSubBussFragment.2 param2, byte[] paramArrayOfByte) {}
  
  public void run()
  {
    if (this.a != null)
    {
      QLog.d(HotWordsForSubBussFragment.a, 1, "UnifySearchHandler use cache!");
      this.b.this$0.f.a(null, 1000, this.a);
      return;
    }
    if (!this.b.a)
    {
      if (QLog.isColorLevel()) {
        QLog.d(HotWordsForSubBussFragment.a, 2, "UnifySearchHandler hot word list cache is null！");
      }
      this.b.this$0.f.a();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.search.fragment.HotWordsForSubBussFragment.2.1
 * JD-Core Version:    0.7.0.1
 */