package com.tencent.mobileqq.qqexpand.fragment;

import com.tencent.qphone.base.util.QLog;

class ExtendFriendSearchFragment$6$1
  implements Runnable
{
  ExtendFriendSearchFragment$6$1(ExtendFriendSearchFragment.6 param6) {}
  
  public void run()
  {
    try
    {
      this.a.a.m.a(0, true);
      return;
    }
    catch (Exception localException)
    {
      QLog.e("ExtendFriendSearchFragment", 1, "onScrolled fail.", localException);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.qqexpand.fragment.ExtendFriendSearchFragment.6.1
 * JD-Core Version:    0.7.0.1
 */