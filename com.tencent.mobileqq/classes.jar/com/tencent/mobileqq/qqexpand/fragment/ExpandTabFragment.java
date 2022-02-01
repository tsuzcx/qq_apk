package com.tencent.mobileqq.qqexpand.fragment;

import com.tencent.mobileqq.fragment.QPublicBaseFragment;

public abstract class ExpandTabFragment
  extends QPublicBaseFragment
{
  protected int a = -1;
  protected ExpandTabFragment.OnTabRequiredListener a;
  
  public void b() {}
  
  public void b(int paramInt)
  {
    this.a = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.qqexpand.fragment.ExpandTabFragment
 * JD-Core Version:    0.7.0.1
 */