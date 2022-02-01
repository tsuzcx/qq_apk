package com.tencent.mobileqq.fragment;

import android.text.TextUtils;
import android.widget.LinearLayout;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.NearbyObserver;
import com.tencent.mobileqq.config.NearbyDataManager;
import com.tencent.mobileqq.nearby.NearPeopleFilters;
import com.tencent.mobileqq.nearby.NearbyConstants;
import com.tencent.mobileqq.nearby.NearbyFragmentEnterAdapter;
import com.tencent.mobileqq.nearby.api.INearbyAppInterface;
import com.tencent.mobileqq.nearby.redtouch.INearbyRecommendPeopleInfo;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.pb.now.ilive_feeds_near_anchor.NearAnchorInfo;
import com.tencent.protobuf.nearbyPeopleRecommend.nearbyPeopleRecommend.QueryRspItem;
import com.tencent.qphone.base.util.QLog;
import java.util.List;

class NearbyHybridFragment$18
  extends NearbyObserver
{
  NearbyHybridFragment$18(NearbyHybridFragment paramNearbyHybridFragment) {}
  
  public void a(List<nearbyPeopleRecommend.QueryRspItem> paramList)
  {
    if ((this.a.t.getVisibility() == 0) && (paramList != null))
    {
      paramList = (nearbyPeopleRecommend.QueryRspItem)paramList.get(0);
      ((INearbyRecommendPeopleInfo)QRoute.api(INearbyRecommendPeopleInfo.class)).setLatestRecommendList(paramList.msg_id.get(), paramList.rd_people.get());
      NearbyHybridFragment.a(this.a);
    }
  }
  
  public void a(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8, int paramInt9, String paramString1, String paramString2, String paramString3)
  {
    if (QLog.isColorLevel()) {
      QLog.d("nearby.NearbyHybridFragment", 2, "onSetFilterList");
    }
    NearPeopleFilters localNearPeopleFilters = new NearPeopleFilters();
    localNearPeopleFilters.a(paramInt1);
    localNearPeopleFilters.b(paramInt2);
    localNearPeopleFilters.c(paramInt3);
    localNearPeopleFilters.d(paramInt4);
    localNearPeopleFilters.e(paramInt9);
    localNearPeopleFilters.f(paramInt5);
    localNearPeopleFilters.g()[0] = String.valueOf(paramInt6);
    localNearPeopleFilters.g()[1] = String.valueOf(paramInt7);
    localNearPeopleFilters.g()[2] = String.valueOf(paramInt8);
    localNearPeopleFilters.h = paramString1;
    localNearPeopleFilters.i = paramString2;
    localNearPeopleFilters.j = paramString3;
    StringBuilder localStringBuilder = new StringBuilder();
    if (!TextUtils.isEmpty(paramString1)) {
      localStringBuilder.append(paramString1);
    }
    if (!TextUtils.isEmpty(paramString2))
    {
      localStringBuilder.append("-");
      localStringBuilder.append(paramString2);
    }
    if (!TextUtils.isEmpty(paramString3))
    {
      localStringBuilder.append("-");
      localStringBuilder.append(paramString3);
    }
    paramString2 = localStringBuilder.toString();
    paramString1 = paramString2;
    if (TextUtils.isEmpty(paramString2)) {
      paramString1 = "不限";
    }
    localNearPeopleFilters.g = paramString1;
    if (!localNearPeopleFilters.equals(this.a.A)) {
      localNearPeopleFilters.f = true;
    }
    paramString1 = this.a;
    paramString1.A = localNearPeopleFilters;
    if ((((NearbyDataManager)paramString1.k.getManager(NearbyConstants.d)).a() == 0) && (this.a.A != null) && (this.a.A.f)) {
      NearPeopleFilters.a(this.a.k.getCurrentAccountUin(), this.a.A);
    }
  }
  
  protected void a(boolean paramBoolean, List<ilive_feeds_near_anchor.NearAnchorInfo> paramList)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onNearbyLiveFeedAnchor isSucc:");
    localStringBuilder.append(paramBoolean);
    QLog.e("nearby.NearbyHybridFragment", 2, localStringBuilder.toString());
    if ((paramBoolean) && (paramList.size() > 0))
    {
      this.a.s.b(paramList);
      return;
    }
    this.a.s.b(null);
  }
  
  public void b()
  {
    this.a.ag.finish();
    this.a.ag.overridePendingTransition(0, 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.fragment.NearbyHybridFragment.18
 * JD-Core Version:    0.7.0.1
 */