package com.tencent.mobileqq.extendfriend.fragment;

import aqfb;
import aqfh;
import com.tencent.qphone.base.util.QLog;

public class ExtendFriendSquareFragment$3$1
  implements Runnable
{
  public ExtendFriendSquareFragment$3$1(aqfb paramaqfb) {}
  
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.extendfriend.fragment.ExtendFriendSquareFragment.3.1
 * JD-Core Version:    0.7.0.1
 */