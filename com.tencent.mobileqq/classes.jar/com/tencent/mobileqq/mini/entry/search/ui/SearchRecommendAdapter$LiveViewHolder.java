package com.tencent.mobileqq.mini.entry.search.ui;

import android.content.Context;
import android.content.res.Resources;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.View;
import android.widget.TextView;
import bgtn;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.mini.entry.MiniAppExposureManager;
import com.tencent.mobileqq.mini.entry.MiniAppExposureManager.CommonExposureData;
import com.tencent.mobileqq.mini.entry.MiniAppUtils;
import com.tencent.mobileqq.mini.entry.search.comm.LiveInfo;

class SearchRecommendAdapter$LiveViewHolder
  extends RecyclerView.ViewHolder
{
  private TextView sequenceNumberTextView;
  private TextView title;
  
  public SearchRecommendAdapter$LiveViewHolder(View paramView)
  {
    super(paramView);
    this.title = ((TextView)paramView.findViewById(2131371045));
    this.sequenceNumberTextView = ((TextView)paramView.findViewById(2131371044));
  }
  
  public void update(LiveInfo paramLiveInfo, int paramInt)
  {
    this.title.setText(paramLiveInfo.mHotWords);
    paramInt = paramLiveInfo.getPosition();
    this.sequenceNumberTextView.setText(String.valueOf(paramInt + 1));
    if (paramInt == 0)
    {
      this.sequenceNumberTextView.setBackgroundResource(2130840973);
      this.sequenceNumberTextView.setTextColor(-1);
    }
    for (;;)
    {
      this.itemView.setOnClickListener(new SearchRecommendAdapter.LiveViewHolder.1(this, paramLiveInfo));
      ((MiniAppExposureManager)MiniAppUtils.getAppInterface().getManager(322)).addSearchItemAndCheckReport(new MiniAppExposureManager.CommonExposureData("desktop", "search", "hot_expo", paramLiveInfo.mHotWords, null));
      return;
      if (paramInt == 1)
      {
        this.sequenceNumberTextView.setBackgroundResource(2130840971);
        this.sequenceNumberTextView.setTextColor(-1);
      }
      else if (paramInt == 2)
      {
        this.sequenceNumberTextView.setBackgroundResource(2130840972);
        this.sequenceNumberTextView.setTextColor(-1);
      }
      else
      {
        this.sequenceNumberTextView.setBackgroundDrawable(null);
        this.sequenceNumberTextView.setPadding(bgtn.b(5.0F), 0, 0, 0);
        this.sequenceNumberTextView.setTextColor(this.itemView.getContext().getResources().getColor(2131167064));
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.mini.entry.search.ui.SearchRecommendAdapter.LiveViewHolder
 * JD-Core Version:    0.7.0.1
 */