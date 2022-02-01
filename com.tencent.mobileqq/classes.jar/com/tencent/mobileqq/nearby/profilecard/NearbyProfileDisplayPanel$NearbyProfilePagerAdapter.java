package com.tencent.mobileqq.nearby.profilecard;

import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import com.tencent.mobileqq.app.BaseFragment;
import com.tencent.mobileqq.app.QBaseFragment;
import java.util.List;

public class NearbyProfileDisplayPanel$NearbyProfilePagerAdapter
  extends FragmentPagerAdapter
{
  private List<BaseFragment> jdField_a_of_type_JavaUtilList;
  
  NearbyProfileDisplayPanel$NearbyProfilePagerAdapter(FragmentManager paramFragmentManager, List<BaseFragment> paramList)
  {
    super(paramList);
    Object localObject;
    this.jdField_a_of_type_JavaUtilList = localObject;
  }
  
  public BaseFragment a(int paramInt)
  {
    return (BaseFragment)this.jdField_a_of_type_JavaUtilList.get(paramInt);
  }
  
  public QBaseFragment a(int paramInt)
  {
    List localList = this.jdField_a_of_type_JavaUtilList;
    if ((localList != null) && (localList.size() > paramInt)) {
      return (QBaseFragment)this.jdField_a_of_type_JavaUtilList.get(paramInt);
    }
    return null;
  }
  
  public int getCount()
  {
    return 2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.profilecard.NearbyProfileDisplayPanel.NearbyProfilePagerAdapter
 * JD-Core Version:    0.7.0.1
 */