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
    Object localObject1 = this.icon;
    Object localObject2 = paramView.getContext();
    Object localObject3 = localMiniAppInfo.iconUrl;
    int j = 0;
    ((ImageView)localObject1).setImageDrawable(MiniAppUtils.getIcon((Context)localObject2, (String)localObject3, false, 0, 48));
    this.name.setText(SearchResultAdapter.highLightKeyword(-14763268, localMiniAppInfo.name, paramString));
    this.category.setText(paramSearchInfo.getCategoryDesc());
    this.desc.setText(localMiniAppInfo.desc);
    this.userNumDesc.setText(paramSearchInfo.getUseNumberDesc());
    this.payingFriendsDesc.setText(paramSearchInfo.playingFriendsDesc);
    int i;
    if (paramSearchInfo.userInfoList.size() == 0)
    {
      this.avatarContainer.setVisibility(8);
      this.divider.setVisibility(8);
    }
    else
    {
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
          int k = ViewUtils.dpToPx(12.0F);
          localObject2 = new LinearLayout.LayoutParams(k, k);
          if (i > 0) {
            ((LinearLayout.LayoutParams)localObject2).leftMargin = (-ViewUtils.dpToPx(2.0F));
          }
          ((ImageView)localObject1).setLayoutParams((ViewGroup.LayoutParams)localObject2);
          this.avatarContainer.addView((View)localObject1);
        }
        i += 1;
      }
    }
    localObject1 = "result_expo";
    localObject2 = "result_click";
    this.pkRankingContainer.setVisibility(8);
    this.couponScrollView.setVisibility(8);
    this.couponTitle.setVisibility(8);
    if (paramSearchInfo.getSearchExtInfo() != null)
    {
      Object localObject4 = (MiniAppSearch.SearchExtInfo)paramSearchInfo.getSearchExtInfo().get();
      localObject3 = ((MiniAppSearch.SearchExtInfo)localObject4).coupon.get();
      localObject4 = ((MiniAppSearch.SearchExtInfo)localObject4).pkRank.get();
      if ((localObject4 != null) && (((List)localObject4).size() > 0))
      {
        this.pkRankingContainer.setVisibility(0);
        paramView.setBackgroundResource(2130841852);
        i = j;
        for (;;)
        {
          j = i;
          if (i >= ((List)localObject4).size()) {
            break;
          }
          j = i;
          if (i >= this.mRanking.size()) {
            break;
          }
          ((SearchResultAdapter.Item)this.mRanking.get(i)).setData(paramView.getContext(), (STORE_APP_CLIENT.StRankingList)((List)localObject4).get(i));
          i += 1;
        }
        while (j < this.mRanking.size())
        {
          ((SearchResultAdapter.Item)this.mRanking.get(j)).gone();
          j += 1;
        }
        localObject1 = "pk_result_expo";
        paramSearchResultViewHolder = "pk_result_click";
      }
      else
      {
        if ((localObject3 == null) || (((List)localObject3).size() <= 0)) {
          break label688;
        }
        this.couponScrollView.setVisibility(0);
        localObject1 = this.couponTitle;
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("本游戏可使用");
        ((StringBuilder)localObject2).append(((List)localObject3).size());
        ((StringBuilder)localObject2).append("张抵扣券");
        ((TextView)localObject1).setText(((StringBuilder)localObject2).toString());
        this.couponTitle.setVisibility(0);
        paramView.setBackgroundResource(2130841843);
        paramSearchResultViewHolder.couponContainer.removeAllViews();
        localObject1 = ((List)localObject3).iterator();
        while (((Iterator)localObject1).hasNext())
        {
          localObject2 = SearchResultAdapter.access$000((MiniAppSearch.CouponInfo)((Iterator)localObject1).next(), paramView);
          paramSearchResultViewHolder.couponContainer.addView((View)localObject2);
        }
        localObject1 = "ticket_result_expo";
        paramSearchResultViewHolder = "ticket_result_click";
      }
      break label696;
      label688:
      resetPkAndCouponView(paramView);
      paramSearchResultViewHolder = (SearchResultViewHolder)localObject2;
      label696:
      this.name.setTextColor(-16578534);
    }
    else
    {
      this.name.setTextColor(paramView.getContext().getResources().getColor(2131168001));
      resetPkAndCouponView(paramView);
      paramSearchResultViewHolder = (SearchResultViewHolder)localObject2;
    }
    paramView.setOnClickListener(new SearchResultAdapter.SearchResultViewHolder.1(this, paramSearchInfo, localMiniAppInfo, paramActivity, paramString, paramSearchResultViewHolder));
    paramSearchResultViewHolder = (MiniAppExposureManager)MiniAppUtils.getAppInterface().getManager(QQManagerFactory.MINI_APP_EXPOSURE_MANAGER);
    paramView = new MiniAppConfig(localMiniAppInfo);
    paramView.launchParam.scene = paramInt;
    paramActivity = new MiniAppExposureManager.MiniAppModuleExposureData(paramView, "page_view", "expo");
    paramView.launchParam.scene = 3026;
    if (paramSearchInfo.getType() == 5) {
      paramView.launchParam.scene = 3028;
    }
    MiniProgramLpReportDC04239.reportAsync(paramView, "desktop", "search", (String)localObject1, paramString);
    paramSearchResultViewHolder.addSearchItemAndCheckReport(paramActivity);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.mini.entry.search.ui.SearchResultAdapter.SearchResultViewHolder
 * JD-Core Version:    0.7.0.1
 */