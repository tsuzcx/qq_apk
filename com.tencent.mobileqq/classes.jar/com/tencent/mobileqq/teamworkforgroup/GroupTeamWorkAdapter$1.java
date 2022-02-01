package com.tencent.mobileqq.teamworkforgroup;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class GroupTeamWorkAdapter$1
  implements View.OnClickListener
{
  GroupTeamWorkAdapter$1(GroupTeamWorkAdapter paramGroupTeamWorkAdapter) {}
  
  public void onClick(View paramView)
  {
    if ((paramView.getTag() instanceof CloudFileItemBuilder.CloudFileHolder))
    {
      CloudFileItemBuilder.CloudFileHolder localCloudFileHolder = (CloudFileItemBuilder.CloudFileHolder)paramView.getTag();
      if ((this.a.d != null) && (localCloudFileHolder.a.isClickable())) {
        this.a.d.onClick(paramView);
      }
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.teamworkforgroup.GroupTeamWorkAdapter.1
 * JD-Core Version:    0.7.0.1
 */