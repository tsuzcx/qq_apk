package com.tencent.mobileqq.qqexpand.fragment;

import com.tencent.qphone.base.util.QLog;

class ExtendFriendSquareFragment$3$1
  implements Runnable
{
  ExtendFriendSquareFragment$3$1(ExtendFriendSquareFragment.3 param3) {}
  
  public void run()
  {
    try
    {
      this.a.a.a.a(0, true);
      return;
    }
    catch (Exception localException)
    {
      QLog.e("ExtendFriendSquareFragment", 1, "onScrolled fail.", localException);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.qqexpand.fragment.ExtendFriendSquareFragment.3.1
 * JD-Core Version:    0.7.0.1
 */