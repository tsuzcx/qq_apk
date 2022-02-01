package com.tencent.mobileqq.mini.entry.search.ui;

import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.View;
import android.widget.TextView;
import com.tencent.mobileqq.mini.entry.search.comm.TitleInfo;

class SearchRecommendAdapter$TitleViewHolder
  extends RecyclerView.ViewHolder
{
  private TextView title;
  
  public SearchRecommendAdapter$TitleViewHolder(View paramView)
  {
    super(paramView);
    this.title = ((TextView)paramView.findViewById(2131371120));
  }
  
  public void update(TitleInfo paramTitleInfo)
  {
    this.title.setText(paramTitleInfo.mTitle);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.mini.entry.search.ui.SearchRecommendAdapter.TitleViewHolder
 * JD-Core Version:    0.7.0.1
 */