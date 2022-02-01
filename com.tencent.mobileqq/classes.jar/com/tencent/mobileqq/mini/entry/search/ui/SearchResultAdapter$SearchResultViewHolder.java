package com.tencent.mobileqq.mini.entry.search.ui;

import NS_STORE_APP_CLIENT.STORE_APP_CLIENT.StRankingList;
import NS_STORE_APP_CLIENT.STORE_APP_CLIENT.StUserInfo;
import NS_STORE_APP_SEARCH.MiniAppSearch.CouponInfo;
import NS_STORE_APP_SEARCH.MiniAppSearch.SearchExtInfo;
import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.mini.apkg.MiniAppConfig;
import com.tencent.mobileqq.mini.apkg.MiniAppInfo;
import com.tencent.mobileqq.mini.entry.MiniAppExposureManager;
import com.tencent.mobileqq.mini.entry.MiniAppExposureManager.BaseExposureReport;
import com.tencent.mobileqq.mini.entry.MiniAppExposureManager.MiniAppModuleExposureData;
import com.tencent.mobileqq.mini.entry.MiniAppUtils;
import com.tencent.mobileqq.mini.entry.search.comm.SearchInfo;
import com.tencent.mobileqq.mini.report.MiniProgramLpReportDC04239;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.utils.ViewUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

class SearchResultAdapter$SearchResultViewHolder
{
  LinearLayout avatarContainer;
  TextView category;
  LinearLayout couponContainer;
  ViewGroup couponScrollView;
  TextView couponTitle;
  TextView desc;
  View divider;
  ImageView icon;
  ArrayList<SearchResultAdapter.Item> mRanking = new ArrayList();
  TextView name;
  TextView payingFriendsDesc;
  RelativeLayout pkRankingContainer;
  TextView userNumDesc;
  
  private void resetPkAndCouponView(View paramView)
  {
    this.pkRankingContainer.setVisibility(8);
    this.couponContainer.removeAllViews();
    this.couponScrollView.setVisibility(8);
    this.couponTitle.setVisibility(8);
    paramView.setBackgroundDrawable(null);
  }
  
  public void update(SearchResultViewHolder paramSearchResultViewHolder, View paramView, SearchInfo paramSearchInfo, Activity paramActivity, String paramString, int paramInt)
  {
    MiniAppInfo localMiniAppInfo = paramSearchInfo.getMiniAppInfo();
    this.icon.setImageDrawable(MiniAppUtils.getIcon(paramView.getContext(), localMiniAppInfo.iconUrl, false, 0, 48));
    this.name.setText(SearchResultAdapter.highLightKeyword(-14763268, localMiniAppInfo.name, paramString));
    this.category.setText(paramSearchInfo.getCategoryDesc());
    this.desc.setText(localMiniAppInfo.desc);
    this.userNumDesc.setText(paramSearchInfo.getUseNumberDesc());
    this.payingFriendsDesc.setText(paramSearchInfo.playingFriendsDesc);
    if (paramSearchInfo.userInfoList.size() == 0)
    {
      this.avatarContainer.setVisibility(8);
      this.divider.setVisibility(8);
    }
    int j;
    for (;;)
    {
      this.pkRankingContainer.setVisibility(8);
      this.couponScrollView.setVisibility(8);
      this.couponTitle.setVisibility(8);
      if (paramSearchInfo.getSearchExtInfo() == null) {
        break label797;
      }
      localObject2 = (MiniAppSearch.SearchExtInfo)paramSearchInfo.getSearchExtInfo().get();
      localObject1 = ((MiniAppSearch.SearchExtInfo)localObject2).coupon.get();
      localObject2 = ((MiniAppSearch.SearchExtInfo)localObject2).pkRank.get();
      if ((localObject2 == null) || (((List)localObject2).size() <= 0)) {
        break label637;
      }
      this.pkRankingContainer.setVisibility(0);
      paramView.setBackgroundResource(2130841185);
      int i = 0;
      for (;;)
      {
        j = i;
        if (i >= ((List)localObject2).size()) {
          break;
        }
        j = i;
        if (i >= this.mRanking.size()) {
          break;
        }
        ((SearchResultAdapter.Item)this.mRanking.get(i)).setData(paramView.getContext(), (STORE_APP_CLIENT.StRankingList)((List)localObject2).get(i));
        i += 1;
      }
      this.avatarContainer.removeAllViews();
      this.avatarContainer.setVisibility(0);
      this.divider.setVisibility(0);
      i = 0;
      while ((i < 3) && (i < paramSearchInfo.userInfoList.size()))
      {
        localObject2 = ((STORE_APP_CLIENT.StUserInfo)paramSearchInfo.userInfoList.get(i)).avatar.get();
        if (!TextUtils.isEmpty((CharSequence)localObject2))
        {
          localObject1 = new ImageView(paramView.getContext());
          ((ImageView)localObject1).setImageDrawable(SearchResultAdapter.getAvatarDrawable(paramView.getContext(), (String)localObject2));
          j = ViewUtils.b(12.0F);
          localObject2 = new LinearLayout.LayoutParams(j, j);
          if (i > 0) {
            ((LinearLayout.LayoutParams)localObject2).leftMargin = (-ViewUtils.b(2.0F));
          }
          ((ImageView)localObject1).setLayoutParams((ViewGroup.LayoutParams)localObject2);
          this.avatarContainer.addView((View)localObject1);
        }
        i += 1;
      }
    }
    while (j < this.mRanking.size())
    {
      ((SearchResultAdapter.Item)this.mRanking.get(j)).gone();
      j += 1;
    }
    paramSearchResultViewHolder = "pk_result_click";
    Object localObject1 = "pk_result_expo";
    this.name.setTextColor(-16578534);
    Object localObject2 = paramSearchResultViewHolder;
    for (paramSearchResultViewHolder = (SearchResultViewHolder)localObject1;; paramSearchResultViewHolder = "result_expo")
    {
      paramView.setOnClickListener(new SearchResultAdapter.SearchResultViewHolder.1(this, paramActivity, localMiniAppInfo, paramSearchInfo, paramString, (String)localObject2));
      paramView = (MiniAppExposureManager)MiniAppUtils.getAppInterface().getManager(QQManagerFactory.MINI_APP_EXPOSURE_MANAGER);
      paramActivity = new MiniAppConfig(localMiniAppInfo);
      paramActivity.launchParam.scene = paramInt;
      localObject1 = new MiniAppExposureManager.MiniAppModuleExposureData(paramActivity, "page_view", "expo");
      paramActivity.launchParam.scene = 3026;
      if (paramSearchInfo.getType() == 5) {
        paramActivity.launchParam.scene = 3028;
      }
      MiniProgramLpReportDC04239.reportAsync(paramActivity, "desktop", "search", paramSearchResultViewHolder, paramString);
      paramView.addSearchItemAndCheckReport((MiniAppExposureManager.BaseExposureReport)localObject1);
      return;
      label637:
      if ((localObject1 != null) && (((List)localObject1).size() > 0))
      {
        this.couponScrollView.setVisibility(0);
        this.couponTitle.setText("本游戏可使用" + ((List)localObject1).size() + "张抵扣券");
        this.couponTitle.setVisibility(0);
        paramView.setBackgroundResource(2130841176);
        paramSearchResultViewHolder.couponContainer.removeAllViews();
        localObject1 = ((List)localObject1).iterator();
        while (((Iterator)localObject1).hasNext())
        {
          localObject2 = SearchResultAdapter.access$000((MiniAppSearch.CouponInfo)((Iterator)localObject1).next(), paramView);
          paramSearchResultViewHolder.couponContainer.addView((View)localObject2);
        }
        paramSearchResultViewHolder = "ticket_result_click";
        localObject1 = "ticket_result_expo";
        break;
      }
      resetPkAndCouponView(paramView);
      paramSearchResultViewHolder = "result_click";
      localObject1 = "result_expo";
      break;
      label797:
      this.name.setTextColor(paramView.getContext().getResources().getColor(2131167040));
      resetPkAndCouponView(paramView);
      localObject2 = "result_click";
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.mini.entry.search.ui.SearchResultAdapter.SearchResultViewHolder
 * JD-Core Version:    0.7.0.1
 */