package com.tencent.mobileqq.mini.entry.search.ui;

import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.mini.entry.MiniAppExposureManager;
import com.tencent.mobileqq.mini.entry.MiniAppExposureManager.CommonExposureData;
import com.tencent.mobileqq.mini.entry.MiniAppUtils;
import com.tencent.mobileqq.mini.entry.search.comm.TitleInfo;

class SearchRecommendAdapter$TitleViewHolder
  extends RecyclerView.ViewHolder
{
  private ImageView refreshView;
  private TextView title;
  
  public SearchRecommendAdapter$TitleViewHolder(View paramView)
  {
    super(paramView);
    this.title = ((TextView)paramView.findViewById(2131371596));
    this.refreshView = ((ImageView)paramView.findViewById(2131371595));
  }
  
  public void update(TitleInfo paramTitleInfo)
  {
    this.title.setText(paramTitleInfo.mTitle);
    if (paramTitleInfo.showRefreshButton)
    {
      this.refreshView.setVisibility(0);
      this.refreshView.setOnClickListener(new SearchRecommendAdapter.TitleViewHolder.1(this));
      ((MiniAppExposureManager)MiniAppUtils.getAppInterface().getManager(QQManagerFactory.MINI_APP_EXPOSURE_MANAGER)).addSearchItemAndCheckReport(new MiniAppExposureManager.CommonExposureData("desktop", "inference", "refresh_expo", null, null));
      return;
    }
    this.refreshView.setVisibility(8);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.mini.entry.search.ui.SearchRecommendAdapter.TitleViewHolder
 * JD-Core Version:    0.7.0.1
 */