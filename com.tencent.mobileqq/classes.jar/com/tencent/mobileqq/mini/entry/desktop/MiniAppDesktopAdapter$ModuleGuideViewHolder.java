package com.tencent.mobileqq.mini.entry.desktop;

import android.content.res.Resources;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.mini.entry.MiniAppUtils;
import com.tencent.qphone.base.util.BaseApplication;

public class MiniAppDesktopAdapter$ModuleGuideViewHolder
  extends RecyclerView.ViewHolder
{
  private RelativeLayout emptyGuideLayout;
  private TextView emptyGuideTextView;
  
  public MiniAppDesktopAdapter$ModuleGuideViewHolder(View paramView)
  {
    super(paramView);
    this.emptyGuideLayout = ((RelativeLayout)paramView.findViewById(2131371185));
    this.emptyGuideTextView = ((TextView)paramView.findViewById(2131371186));
  }
  
  public void update()
  {
    if (MiniAppUtils.getAppInterface() != null)
    {
      if (this.emptyGuideLayout != null) {
        this.emptyGuideLayout.setBackgroundResource(2130841015);
      }
      if (this.emptyGuideTextView != null) {
        this.emptyGuideTextView.setTextColor(BaseApplicationImpl.getContext().getResources().getColor(2131167110));
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.mini.entry.desktop.MiniAppDesktopAdapter.ModuleGuideViewHolder
 * JD-Core Version:    0.7.0.1
 */