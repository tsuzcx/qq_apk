package com.tencent.mobileqq.flashshow.fragment.list;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import java.util.List;

class FSPublicListFragment$MultiFragmentsAdapter
  extends FragmentPagerAdapter
{
  private FSPublicListFragment$MultiFragmentsAdapter(FSPublicListFragment paramFSPublicListFragment, FragmentManager paramFragmentManager)
  {
    super(paramFragmentManager);
  }
  
  public int getCount()
  {
    return this.a.e.size();
  }
  
  public Fragment getItem(int paramInt)
  {
    if (paramInt < this.a.e.size()) {
      return (Fragment)this.a.e.get(paramInt);
    }
    return null;
  }
  
  public int getItemPosition(Object paramObject)
  {
    return -2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.flashshow.fragment.list.FSPublicListFragment.MultiFragmentsAdapter
 * JD-Core Version:    0.7.0.1
 */