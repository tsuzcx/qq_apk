package com.tencent.mobileqq.mini.entry.search.ui;

import android.app.Activity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mobileqq.mini.apkg.MiniAppInfo;
import com.tencent.mobileqq.mini.entry.MiniAppUtils;
import com.tencent.mobileqq.mini.entry.search.comm.SearchInfo;

class HotSearchAdapter$HotSearchViewHolder
{
  TextView category;
  ImageView icon;
  TextView name;
  ImageView ranking;
  
  public void update(View paramView, SearchInfo paramSearchInfo, Activity paramActivity, int paramInt)
  {
    MiniAppInfo localMiniAppInfo = paramSearchInfo.getMiniAppInfo();
    this.icon.setImageDrawable(MiniAppUtils.getIcon(paramView.getContext(), localMiniAppInfo.iconUrl, false, 0, 32));
    this.name.setText(localMiniAppInfo.name);
    this.category.setText(paramSearchInfo.getCategoryDesc());
    if (paramInt > 2) {
      this.ranking.setVisibility(8);
    }
    for (;;)
    {
      paramView.setOnClickListener(new HotSearchAdapter.HotSearchViewHolder.1(this, paramActivity, localMiniAppInfo));
      return;
      this.ranking.setVisibility(0);
      if (paramInt == 0) {
        this.ranking.setImageResource(2130840765);
      } else if (paramInt == 1) {
        this.ranking.setImageResource(2130840766);
      } else if (paramInt == 2) {
        this.ranking.setImageResource(2130840767);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.mini.entry.search.ui.HotSearchAdapter.HotSearchViewHolder
 * JD-Core Version:    0.7.0.1
 */