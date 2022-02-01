package com.tencent.mobileqq.kandian.biz.ugc.coverselect;

import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import com.tencent.mobileqq.app.BaseFragment;
import java.util.List;
import org.jetbrains.annotations.NotNull;

class CoverSelectTabFragment$1
  extends FragmentPagerAdapter
{
  CoverSelectTabFragment$1(CoverSelectTabFragment paramCoverSelectTabFragment, FragmentManager paramFragmentManager)
  {
    super(paramFragmentManager);
  }
  
  @NotNull
  public BaseFragment a(int paramInt)
  {
    return (BaseFragment)CoverSelectTabFragment.a(this.a).get(paramInt);
  }
  
  public int getCount()
  {
    return CoverSelectTabFragment.a(this.a).size();
  }
  
  public CharSequence getPageTitle(int paramInt)
  {
    return CoverSelectTabFragment.a()[paramInt];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.ugc.coverselect.CoverSelectTabFragment.1
 * JD-Core Version:    0.7.0.1
 */