package com.tencent.mobileqq.qqexpand.fragment;

import com.tencent.mobileqq.tianshu.observer.RedpointObserver;
import com.tencent.qphone.base.util.QLog;

class ExpandNewFragment$1
  extends RedpointObserver
{
  ExpandNewFragment$1(ExpandNewFragment paramExpandNewFragment) {}
  
  public void a(boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.i("ExtendFriendNewFragment", 2, String.format("onDataChange success=%s", new Object[] { Boolean.valueOf(paramBoolean) }));
    }
    ExpandNewFragment.a(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.qqexpand.fragment.ExpandNewFragment.1
 * JD-Core Version:    0.7.0.1
 */