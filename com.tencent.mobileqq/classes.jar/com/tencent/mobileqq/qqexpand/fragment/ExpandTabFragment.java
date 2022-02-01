package com.tencent.mobileqq.qqexpand.fragment;

import com.tencent.mobileqq.fragment.QPublicBaseFragment;

public abstract class ExpandTabFragment
  extends QPublicBaseFragment
{
  protected int b = -1;
  protected ExpandTabFragment.OnTabRequiredListener c;
  
  public void b() {}
  
  public void b(int paramInt)
  {
    this.b = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqexpand.fragment.ExpandTabFragment
 * JD-Core Version:    0.7.0.1
 */