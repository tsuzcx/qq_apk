package com.tencent.mobileqq.nearby.home.impl;

import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import com.tencent.mobileqq.app.QBaseFragment;
import com.tencent.mobileqq.fragment.CommonTabFragment;
import com.tencent.mobileqq.fragment.HotChatFragment;
import com.tencent.mobileqq.fragment.NearbyBaseFragment;
import com.tencent.mobileqq.fragment.NearbyHybridFragment;
import com.tencent.mobileqq.fragment.NearbyMsgFragment;
import com.tencent.mobileqq.fragment.NowLiveFragment;
import com.tencent.mobileqq.nearby.home.INearbyFragmentPagerAdapter;
import com.tencent.mobileqq.nearby.home.NearbyTabInfo;
import com.tencent.mobileqq.nearby.matchmaker.MatchMakerFragment;
import java.util.List;

public class NearbyFragmentPagerAdapterImpl
  extends FragmentPagerAdapter
  implements INearbyFragmentPagerAdapter
{
  private FragmentManager mFragmentManager;
  private HotChatFragment mHotChatFragment;
  private NearbyHybridFragment mNearbyHybridFragment;
  private NearbyMsgFragment mNearbyMsgFragment;
  private NowLiveFragment mNowLiveFragment;
  private List<NearbyTabInfo> mTabInfos;
  
  public NearbyFragmentPagerAdapterImpl(FragmentManager paramFragmentManager)
  {
    super(paramFragmentManager);
  }
  
  public NearbyFragmentPagerAdapterImpl(FragmentManager paramFragmentManager, List<NearbyTabInfo> paramList)
  {
    super(paramFragmentManager);
    setFragmentManager(paramFragmentManager);
    this.mTabInfos = paramList;
  }
  
  public int getCount()
  {
    List localList = this.mTabInfos;
    if (localList == null) {
      return 0;
    }
    return localList.size();
  }
  
  public NearbyBaseFragment getFragmentByIndex(int paramInt)
  {
    if ((paramInt >= 0) && (paramInt < this.mTabInfos.size()))
    {
      NearbyTabInfo localNearbyTabInfo = (NearbyTabInfo)this.mTabInfos.get(paramInt);
      return (NearbyBaseFragment)this.mFragmentManager.findFragmentByTag(localNearbyTabInfo.getTabTag());
    }
    return null;
  }
  
  public FragmentManager getFragmentManager()
  {
    return this.mFragmentManager;
  }
  
  public Object getHotChatFragment()
  {
    return this.mHotChatFragment;
  }
  
  public QBaseFragment getItem(int paramInt)
  {
    Object localObject1 = getFragmentByIndex(paramInt);
    Object localObject2 = localObject1;
    if (localObject1 == null)
    {
      NearbyTabInfo localNearbyTabInfo = (NearbyTabInfo)this.mTabInfos.get(paramInt);
      if (localNearbyTabInfo.getTabType() == 2)
      {
        if (this.mNowLiveFragment == null) {
          setNowLiveFragment(new NowLiveFragment());
        }
        localObject1 = this.mNowLiveFragment;
      }
      else if (localNearbyTabInfo.getTabType() == 3)
      {
        if (this.mHotChatFragment == null) {
          setHotChatFragment(new HotChatFragment());
        }
        localObject1 = this.mHotChatFragment;
      }
      else if (localNearbyTabInfo.getTabType() == 4)
      {
        localObject1 = new CommonTabFragment();
      }
      else if (localNearbyTabInfo.getTabType() == 5)
      {
        if (this.mNearbyHybridFragment == null) {
          setNearbyHybridFragment(new NearbyHybridFragment());
        }
        localObject1 = this.mNearbyHybridFragment;
      }
      else if (localNearbyTabInfo.getTabType() == 6)
      {
        if (this.mNearbyMsgFragment == null) {
          setNearbyMsgFragment(new NearbyMsgFragment());
        }
        localObject1 = this.mNearbyMsgFragment;
      }
      else if (localNearbyTabInfo.getTabType() == 8)
      {
        localObject1 = new CommonTabFragment();
      }
      else if (localNearbyTabInfo.getTabType() == 7)
      {
        localObject1 = new MatchMakerFragment();
      }
      else
      {
        localObject1 = new CommonTabFragment();
      }
      localObject2 = localObject1;
      if (localObject1 != null)
      {
        ((NearbyBaseFragment)localObject1).a(localNearbyTabInfo);
        localObject2 = localObject1;
      }
    }
    return localObject2;
  }
  
  public Object getNearbyHybridFragment()
  {
    return this.mNearbyHybridFragment;
  }
  
  public Object getNearbyMsgFragment()
  {
    return this.mNearbyMsgFragment;
  }
  
  public Object getNowLiveFragment()
  {
    return this.mNowLiveFragment;
  }
  
  public List<Object> getTabInfos()
  {
    return this.mTabInfos;
  }
  
  public void setFragmentManager(FragmentManager paramFragmentManager)
  {
    this.mFragmentManager = paramFragmentManager;
  }
  
  public void setHotChatFragment(Object paramObject)
  {
    this.mHotChatFragment = ((HotChatFragment)paramObject);
  }
  
  public void setNearbyHybridFragment(Object paramObject)
  {
    this.mNearbyHybridFragment = ((NearbyHybridFragment)paramObject);
  }
  
  public void setNearbyMsgFragment(Object paramObject)
  {
    this.mNearbyMsgFragment = ((NearbyMsgFragment)paramObject);
  }
  
  public void setNowLiveFragment(Object paramObject)
  {
    this.mNowLiveFragment = ((NowLiveFragment)paramObject);
  }
  
  public void setTabInfos(List<Object> paramList)
  {
    this.mTabInfos = paramList;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.home.impl.NearbyFragmentPagerAdapterImpl
 * JD-Core Version:    0.7.0.1
 */