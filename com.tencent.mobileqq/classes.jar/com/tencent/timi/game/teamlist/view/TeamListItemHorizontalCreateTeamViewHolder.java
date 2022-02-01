package com.tencent.timi.game.teamlist.view;

import android.view.View;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView.ViewHolder;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.timi.game.ui.widget.rc.RCImageView;

public class TeamListItemHorizontalCreateTeamViewHolder
  extends RecyclerView.ViewHolder
{
  private RCImageView a;
  
  public TeamListItemHorizontalCreateTeamViewHolder(@NonNull View paramView)
  {
    super(paramView);
    this.a = ((RCImageView)paramView.findViewById(2131446876));
    this.a.setRadius(ViewUtils.dip2px(15.0F));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.teamlist.view.TeamListItemHorizontalCreateTeamViewHolder
 * JD-Core Version:    0.7.0.1
 */