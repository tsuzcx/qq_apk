package com.tencent.mobileqq.mini.entry.desktop;

import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.mobileqq.mini.entry.MiniAppUtils;

public class MiniAppDesktopAdapter$ModuleGuideViewHolder
  extends RecyclerView.ViewHolder
{
  private RelativeLayout emptyGuideLayout;
  private TextView emptyGuideTextView;
  
  public MiniAppDesktopAdapter$ModuleGuideViewHolder(View paramView)
  {
    super(paramView);
    this.emptyGuideLayout = ((RelativeLayout)paramView.findViewById(2131438425));
    this.emptyGuideTextView = ((TextView)paramView.findViewById(2131438426));
  }
  
  public void update()
  {
    if (MiniAppUtils.getAppInterface() != null)
    {
      RelativeLayout localRelativeLayout = this.emptyGuideLayout;
      if (localRelativeLayout != null) {
        localRelativeLayout.setBackgroundResource(2130841813);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.mini.entry.desktop.MiniAppDesktopAdapter.ModuleGuideViewHolder
 * JD-Core Version:    0.7.0.1
 */