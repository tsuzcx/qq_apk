package com.tencent.mobileqq.mini.entry.desktop;

import agtk;
import android.content.res.Resources;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.common.app.AppInterface;
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
    this.emptyGuideLayout = ((RelativeLayout)paramView.findViewById(2131304493));
    this.emptyGuideTextView = ((TextView)paramView.findViewById(2131304494));
  }
  
  public void update()
  {
    Object localObject = MiniAppUtils.getAppInterface();
    if (localObject != null)
    {
      localObject = (agtk)((AppInterface)localObject).getManager(342);
      if ((localObject == null) || (!((agtk)localObject).h())) {
        break label62;
      }
      if (this.emptyGuideLayout != null) {
        this.emptyGuideLayout.setBackgroundResource(2130840582);
      }
      if (this.emptyGuideTextView != null) {
        this.emptyGuideTextView.setTextColor(-1);
      }
    }
    label62:
    do
    {
      return;
      if (this.emptyGuideLayout != null) {
        this.emptyGuideLayout.setBackgroundResource(2130840581);
      }
    } while (this.emptyGuideTextView == null);
    this.emptyGuideTextView.setTextColor(BaseApplicationImpl.getContext().getResources().getColor(2131101336));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.mini.entry.desktop.MiniAppDesktopAdapter.ModuleGuideViewHolder
 * JD-Core Version:    0.7.0.1
 */