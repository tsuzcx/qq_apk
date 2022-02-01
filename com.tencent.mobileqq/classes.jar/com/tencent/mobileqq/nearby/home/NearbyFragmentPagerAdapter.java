package com.tencent.mobileqq.nearby.home;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import com.tencent.mobileqq.fragment.CommonTabFragment;
import com.tencent.mobileqq.fragment.HotChatFragment;
import com.tencent.mobileqq.fragment.NearbyBaseFragment;
import com.tencent.mobileqq.fragment.NearbyHybridFragment;
import com.tencent.mobileqq.fragment.NearbyMsgFragment;
import com.tencent.mobileqq.fragment.NowLiveFragment;
import com.tencent.mobileqq.nearby.matchmaker.MatchMakerFragment;
import java.util.List;

public class NearbyFragmentPagerAdapter
  extends FragmentPagerAdapter
{
  private final FragmentManager jdField_a_of_type_AndroidSupportV4AppFragmentManager;
  private HotChatFragment jdField_a_of_type_ComTencentMobileqqFragmentHotChatFragment;
  private NearbyHybridFragment jdField_a_of_type_ComTencentMobileqqFragmentNearbyHybridFragment;
  private NearbyMsgFragment jdField_a_of_type_ComTencentMobileqqFragmentNearbyMsgFragment;
  private NowLiveFragment jdField_a_of_type_ComTencentMobileqqFragmentNowLiveFragment;
  private List<NearbyTabInfo> jdField_a_of_type_JavaUtilList;
  
  public NearbyFragmentPagerAdapter(FragmentManager paramFragmentManager, List<NearbyTabInfo> paramList)
  {
    super(paramFragmentManager);
    this.jdField_a_of_type_AndroidSupportV4AppFragmentManager = paramFragmentManager;
    this.jdField_a_of_type_JavaUtilList = paramList;
  }
  
  public HotChatFragment a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqFragmentHotChatFragment;
  }
  
  public NearbyBaseFragment a(int paramInt)
  {
    Object localObject2 = null;
    Object localObject1 = localObject2;
    if (paramInt >= 0)
    {
      localObject1 = localObject2;
      if (paramInt < this.jdField_a_of_type_JavaUtilList.size())
      {
        localObject1 = (NearbyTabInfo)this.jdField_a_of_type_JavaUtilList.get(paramInt);
        localObject1 = (NearbyBaseFragment)this.jdField_a_of_type_AndroidSupportV4AppFragmentManager.findFragmentByTag(((NearbyTabInfo)localObject1).getTabTag());
      }
    }
    return localObject1;
  }
  
  public NearbyHybridFragment a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqFragmentNearbyHybridFragment;
  }
  
  public NowLiveFragment a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqFragmentNowLiveFragment;
  }
  
  public void a(NearbyHybridFragment paramNearbyHybridFragment)
  {
    this.jdField_a_of_type_ComTencentMobileqqFragmentNearbyHybridFragment = paramNearbyHybridFragment;
  }
  
  public int getCount()
  {
    if (this.jdField_a_of_type_JavaUtilList == null) {
      return 0;
    }
    return this.jdField_a_of_type_JavaUtilList.size();
  }
  
  public Fragment getItem(int paramInt)
  {
    Object localObject1 = a(paramInt);
    Object localObject2 = localObject1;
    NearbyTabInfo localNearbyTabInfo;
    if (localObject1 == null)
    {
      localNearbyTabInfo = (NearbyTabInfo)this.jdField_a_of_type_JavaUtilList.get(paramInt);
      if (localNearbyTabInfo.tabType != 2) {
        break label78;
      }
      if (this.jdField_a_of_type_ComTencentMobileqqFragmentNowLiveFragment == null) {
        this.jdField_a_of_type_ComTencentMobileqqFragmentNowLiveFragment = new NowLiveFragment();
      }
      localObject1 = this.jdField_a_of_type_ComTencentMobileqqFragmentNowLiveFragment;
    }
    for (;;)
    {
      localObject2 = localObject1;
      if (localObject1 != null)
      {
        ((NearbyBaseFragment)localObject1).a(localNearbyTabInfo);
        localObject2 = localObject1;
      }
      return localObject2;
      label78:
      if (localNearbyTabInfo.tabType == 3)
      {
        if (this.jdField_a_of_type_ComTencentMobileqqFragmentHotChatFragment == null) {
          this.jdField_a_of_type_ComTencentMobileqqFragmentHotChatFragment = new HotChatFragment();
        }
        localObject1 = this.jdField_a_of_type_ComTencentMobileqqFragmentHotChatFragment;
      }
      else if (localNearbyTabInfo.tabType == 4)
      {
        localObject1 = new CommonTabFragment();
      }
      else if (localNearbyTabInfo.tabType == 5)
      {
        if (this.jdField_a_of_type_ComTencentMobileqqFragmentNearbyHybridFragment == null) {
          this.jdField_a_of_type_ComTencentMobileqqFragmentNearbyHybridFragment = new NearbyHybridFragment();
        }
        localObject1 = this.jdField_a_of_type_ComTencentMobileqqFragmentNearbyHybridFragment;
      }
      else if (localNearbyTabInfo.tabType == 6)
      {
        if (this.jdField_a_of_type_ComTencentMobileqqFragmentNearbyMsgFragment == null) {
          this.jdField_a_of_type_ComTencentMobileqqFragmentNearbyMsgFragment = new NearbyMsgFragment();
        }
        localObject1 = this.jdField_a_of_type_ComTencentMobileqqFragmentNearbyMsgFragment;
      }
      else if (localNearbyTabInfo.tabType == 8)
      {
        localObject1 = new CommonTabFragment();
      }
      else if (localNearbyTabInfo.tabType == 7)
      {
        localObject1 = new MatchMakerFragment();
      }
      else
      {
        localObject1 = new CommonTabFragment();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.home.NearbyFragmentPagerAdapter
 * JD-Core Version:    0.7.0.1
 */