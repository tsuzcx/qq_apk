package com.tencent.mobileqq.newnearby;

import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import com.tencent.hippy.qq.api.OpenHippyInfo;
import com.tencent.mobileqq.nearby.home.NearbyTabInfo;
import com.tencent.mobileqq.nearby.matchmaker.MatchMakerFragment;
import com.tencent.mobileqq.qroute.QRoute;
import java.util.List;

public class NearbyPagerAdapter
  extends FragmentPagerAdapter
{
  private NearbyHippyFragment a;
  private MatchMakerFragment b;
  private NearbyHippyFragment c;
  
  public NearbyPagerAdapter(FragmentManager paramFragmentManager, int paramInt)
  {
    super(paramFragmentManager, paramInt);
  }
  
  private MatchMakerFragment a()
  {
    MatchMakerFragment localMatchMakerFragment = new MatchMakerFragment();
    NearbyTabInfo localNearbyTabInfo = new NearbyTabInfo();
    localNearbyTabInfo.setTabUrl("https://qvideo.qq.com/qq/hongniang/index.html?asyncMode=3&from_id=20011&_wv=2");
    localMatchMakerFragment.a(localNearbyTabInfo);
    return localMatchMakerFragment;
  }
  
  private NearbyHippyFragment a(String paramString)
  {
    NearbyHippyFragment localNearbyHippyFragment = new NearbyHippyFragment();
    OpenHippyInfo localOpenHippyInfo = new OpenHippyInfo();
    localOpenHippyInfo.bundleName = "QQNearby";
    localOpenHippyInfo.processName = "tool";
    localOpenHippyInfo.url = paramString;
    localOpenHippyInfo.framework = "react";
    localOpenHippyInfo.isTransparent = true;
    localOpenHippyInfo.updateJsBundleType = 1;
    paramString = new Bundle();
    paramString.putBundle("params", localOpenHippyInfo.toBundle());
    localNearbyHippyFragment.setArguments(paramString);
    return localNearbyHippyFragment;
  }
  
  public NearbyHippyFragment a(int paramInt)
  {
    paramInt = ((INearbyTabBuilder)QRoute.api(INearbyTabBuilder.class)).getTabTypeByTabId(paramInt);
    if (paramInt != 1)
    {
      if (paramInt != 3) {
        return null;
      }
      return this.c;
    }
    return this.a;
  }
  
  public int getCount()
  {
    return ((INearbyTabBuilder)QRoute.api(INearbyTabBuilder.class)).getTabs().size();
  }
  
  @NonNull
  public Fragment getItem(int paramInt)
  {
    paramInt = ((INearbyTabBuilder)QRoute.api(INearbyTabBuilder.class)).getTabTypeByTabId(paramInt);
    if (paramInt != 1)
    {
      if (paramInt != 2)
      {
        if (paramInt != 3) {
          return new Fragment();
        }
        if (this.c == null) {
          this.c = a("nearby.qq.hippy/group");
        }
        return this.c;
      }
      if (this.b == null) {
        this.b = a();
      }
      return this.b;
    }
    if (this.a == null) {
      this.a = a("nearby.qq.hippy/live");
    }
    return this.a;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.newnearby.NearbyPagerAdapter
 * JD-Core Version:    0.7.0.1
 */