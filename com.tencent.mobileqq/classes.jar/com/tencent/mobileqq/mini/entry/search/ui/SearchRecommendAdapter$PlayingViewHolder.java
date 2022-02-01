package com.tencent.mobileqq.mini.entry.search.ui;

import android.app.Activity;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.common.app.AppInterface;
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
    this.icon = ((ImageView)paramView.findViewById(2131371154));
    this.ranking = ((ImageView)paramView.findViewById(2131371156));
    this.name = ((TextView)paramView.findViewById(2131371158));
    this.category = ((TextView)paramView.findViewById(2131371159));
  }
  
  public void update(SearchInfo paramSearchInfo, Activity paramActivity, int paramInt)
  {
    MiniAppInfo localMiniAppInfo = paramSearchInfo.getMiniAppInfo();
    this.icon.setImageDrawable(MiniAppUtils.getIcon(this.itemView.getContext(), localMiniAppInfo.iconUrl, false, 0, 32));
    this.name.setText(localMiniAppInfo.name);
    this.category.setText(paramSearchInfo.getCategoryDesc());
    int i = paramSearchInfo.getPosition();
    if (i > 2) {
      this.ranking.setVisibility(8);
    }
    for (;;)
    {
      this.itemView.setOnClickListener(new SearchRecommendAdapter.PlayingViewHolder.1(this, paramActivity, localMiniAppInfo, paramInt));
      paramSearchInfo = (MiniAppExposureManager)MiniAppUtils.getAppInterface().getManager(322);
      paramActivity = new MiniAppConfig(localMiniAppInfo);
      paramActivity.launchParam.scene = paramInt;
      paramSearchInfo.addSearchItemAndCheckReport(new MiniAppExposureManager.MiniAppModuleExposureData(paramActivity, "page_view", "expo"));
      return;
      this.ranking.setVisibility(0);
      if (i == 0) {
        this.ranking.setImageResource(2130840984);
      } else if (i == 1) {
        this.ranking.setImageResource(2130840985);
      } else if (i == 2) {
        this.ranking.setImageResource(2130840986);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.mini.entry.search.ui.SearchRecommendAdapter.PlayingViewHolder
 * JD-Core Version:    0.7.0.1
 */