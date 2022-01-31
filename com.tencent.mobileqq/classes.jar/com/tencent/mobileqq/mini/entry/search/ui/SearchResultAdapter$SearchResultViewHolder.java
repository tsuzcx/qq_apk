package com.tencent.mobileqq.mini.entry.search.ui;

import NS_STORE_APP_CLIENT.STORE_APP_CLIENT.StUserInfo;
import android.app.Activity;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import bdkf;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.mini.apkg.MiniAppConfig;
import com.tencent.mobileqq.mini.apkg.MiniAppInfo;
import com.tencent.mobileqq.mini.entry.MiniAppExposureManager;
import com.tencent.mobileqq.mini.entry.MiniAppExposureManager.MiniAppModuleExposureData;
import com.tencent.mobileqq.mini.entry.MiniAppUtils;
import com.tencent.mobileqq.mini.entry.search.comm.SearchInfo;
import com.tencent.mobileqq.pb.PBStringField;
import java.util.List;

class SearchResultAdapter$SearchResultViewHolder
{
  LinearLayout avatarContainer;
  TextView category;
  TextView desc;
  View divider;
  ImageView icon;
  TextView name;
  TextView payingFriendsDesc;
  TextView userNumDesc;
  
  public void update(View paramView, SearchInfo paramSearchInfo, Activity paramActivity, String paramString)
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
    for (;;)
    {
      paramView.setOnClickListener(new SearchResultAdapter.SearchResultViewHolder.1(this, paramActivity, localMiniAppInfo, paramString));
      paramView = (MiniAppExposureManager)MiniAppUtils.getAppInterface().getManager(322);
      paramSearchInfo = new MiniAppConfig(localMiniAppInfo);
      paramSearchInfo.launchParam.scene = 2077;
      paramView.addSearchItemAndCheckReport(new MiniAppExposureManager.MiniAppModuleExposureData(paramSearchInfo, "page_view", "expo"));
      return;
      this.avatarContainer.removeAllViews();
      this.avatarContainer.setVisibility(0);
      this.divider.setVisibility(0);
      int i = 0;
      while ((i < 3) && (i < paramSearchInfo.userInfoList.size()))
      {
        Object localObject = ((STORE_APP_CLIENT.StUserInfo)paramSearchInfo.userInfoList.get(i)).avatar.get();
        if (!TextUtils.isEmpty((CharSequence)localObject))
        {
          ImageView localImageView = new ImageView(paramView.getContext());
          localImageView.setImageDrawable(SearchResultAdapter.getAvatarDrawable(paramView.getContext(), (String)localObject));
          int j = bdkf.b(12.0F);
          localObject = new LinearLayout.LayoutParams(j, j);
          if (i > 0) {
            ((LinearLayout.LayoutParams)localObject).leftMargin = (-bdkf.b(2.0F));
          }
          localImageView.setLayoutParams((ViewGroup.LayoutParams)localObject);
          this.avatarContainer.addView(localImageView);
        }
        i += 1;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.mini.entry.search.ui.SearchResultAdapter.SearchResultViewHolder
 * JD-Core Version:    0.7.0.1
 */