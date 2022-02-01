package com.tencent.mobileqq.extendfriend.fragment;

import com.tencent.mobileqq.fragment.PublicBaseFragment;

abstract class ExtendFriendTabFragment
  extends PublicBaseFragment
{
  protected ExtendFriendFragment.OnTabRequiredListener a;
  protected int j = -1;
  
  public void a(ExtendFriendFragment.OnTabRequiredListener paramOnTabRequiredListener)
  {
    this.a = paramOnTabRequiredListener;
  }
  
  public void i(int paramInt)
  {
    this.j = paramInt;
  }
  
  public void j() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.extendfriend.fragment.ExtendFriendTabFragment
 * JD-Core Version:    0.7.0.1
 */