package com.tencent.mobileqq.nearby.home;

import androidx.fragment.app.FragmentManager;
import com.tencent.mobileqq.app.QBaseFragment;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import com.tencent.mobileqq.qroute.annotation.QRouteFactory;
import java.util.List;

@QAPI(process={"all"})
@QRouteFactory(singleton=false)
public abstract interface INearbyFragmentPagerAdapter
  extends QRouteApi
{
  public abstract int getCount();
  
  public abstract Object getFragmentByIndex(int paramInt);
  
  public abstract FragmentManager getFragmentManager();
  
  public abstract Object getHotChatFragment();
  
  public abstract QBaseFragment getItem(int paramInt);
  
  public abstract Object getNearbyHybridFragment();
  
  public abstract Object getNearbyMsgFragment();
  
  public abstract Object getNowLiveFragment();
  
  public abstract List<Object> getTabInfos();
  
  public abstract void setFragmentManager(FragmentManager paramFragmentManager);
  
  public abstract void setHotChatFragment(Object paramObject);
  
  public abstract void setNearbyHybridFragment(Object paramObject);
  
  public abstract void setNearbyMsgFragment(Object paramObject);
  
  public abstract void setNowLiveFragment(Object paramObject);
  
  public abstract void setTabInfos(List<Object> paramList);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.home.INearbyFragmentPagerAdapter
 * JD-Core Version:    0.7.0.1
 */