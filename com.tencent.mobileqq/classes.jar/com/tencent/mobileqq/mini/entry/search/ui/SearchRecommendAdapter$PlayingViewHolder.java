package com.tencent.mobileqq.mini.entry.search.ui;

import android.app.Activity;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.mini.apkg.MiniAppConfig;
import com.tencent.mobileqq.mini.apkg.MiniAppInfo;
import com.tencent.mobileqq.mini.entry.MiniAppExposureManager;
import com.tencent.mobileqq.mini.entry.MiniAppExposureManager.MiniAppModuleExposureData;
import com.tencent.mobileqq.mini.entry.MiniAppUtils;
import com.tencent.mobileqq.mini.entry.search.comm.SearchInfo;

class SearchRecommendAdapter$PlayingViewHolder
  extends RecyclerView.ViewHolder
{
  private TextView category;
  private ImageView icon;
  private TextView name;
  private ImageView ranking;
  
  public SearchRecommendAdapter$PlayingViewHolder(View paramView)
  {
    super(paramView);
    this.icon = ((ImageView)paramView.findViewById(2131438562));
    this.ranking = ((ImageView)paramView.findViewById(2131438564));
    this.name = ((TextView)paramView.findViewById(2131438566));
    this.category = ((TextView)paramView.findViewById(2131438567));
  }
  
  public void update(SearchInfo paramSearchInfo, Activity paramActivity, int paramInt)
  {
    Object localObject = paramSearchInfo.getMiniAppInfo();
    this.icon.setImageDrawable(MiniAppUtils.getIcon(this.itemView.getContext(), ((MiniAppInfo)localObject).iconUrl, false, 0, 32));
    this.name.setText(((MiniAppInfo)localObject).name);
    this.category.setText(paramSearchInfo.getCategoryDesc());
    paramInt = paramSearchInfo.getPosition();
    if ((paramInt <= 2) && (paramSearchInfo.getType() != 4))
    {
      this.ranking.setVisibility(0);
      if (paramInt == 0) {
        this.ranking.setImageResource(2130841853);
      } else if (paramInt == 1) {
        this.ranking.setImageResource(2130841854);
      } else if (paramInt == 2) {
        this.ranking.setImageResource(2130841855);
      }
    }
    else
    {
      this.ranking.setVisibility(8);
    }
    this.itemView.setOnClickListener(new SearchRecommendAdapter.PlayingViewHolder.1(this, paramActivity, (MiniAppInfo)localObject, paramSearchInfo));
    paramActivity = (MiniAppExposureManager)MiniAppUtils.getAppInterface().getManager(QQManagerFactory.MINI_APP_EXPOSURE_MANAGER);
    localObject = new MiniAppConfig((MiniAppInfo)localObject);
    ((MiniAppConfig)localObject).launchParam.scene = 3024;
    if (paramSearchInfo.getType() == 4) {
      ((MiniAppConfig)localObject).launchParam.scene = 3029;
    }
    paramActivity.addSearchItemAndCheckReport(new MiniAppExposureManager.MiniAppModuleExposureData((MiniAppConfig)localObject, "desktop", "expo"));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.mini.entry.search.ui.SearchRecommendAdapter.PlayingViewHolder
 * JD-Core Version:    0.7.0.1
 */