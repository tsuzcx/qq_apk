package com.tencent.mobileqq.nearby.profilecard;

import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import com.tencent.mobileqq.app.BaseFragment;
import com.tencent.mobileqq.app.QBaseFragment;
import java.util.List;

public class NearbyProfileDisplayPanel$NearbyProfilePagerAdapter
  extends FragmentPagerAdapter
{
  private List<BaseFragment> b;
  
  NearbyProfileDisplayPanel$NearbyProfilePagerAdapter(FragmentManager paramFragmentManager, List<BaseFragment> paramList)
  {
    super(paramList);
    Object localObject;
    this.b = localObject;
  }
  
  public QBaseFragment a(int paramInt)
  {
    List localList = this.b;
    if ((localList != null) && (localList.size() > paramInt)) {
      return (QBaseFragment)this.b.get(paramInt);
    }
    return null;
  }
  
  public BaseFragment b(int paramInt)
  {
    return (BaseFragment)this.b.get(paramInt);
  }
  
  public int getCount()
  {
    return 2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.profilecard.NearbyProfileDisplayPanel.NearbyProfilePagerAdapter
 * JD-Core Version:    0.7.0.1
 */