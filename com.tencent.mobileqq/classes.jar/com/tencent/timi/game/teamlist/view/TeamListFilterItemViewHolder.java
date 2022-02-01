package com.tencent.timi.game.teamlist.view;

import android.view.View;
import android.widget.CheckBox;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView.ViewHolder;

public class TeamListFilterItemViewHolder
  extends RecyclerView.ViewHolder
{
  public CheckBox a;
  private View b;
  
  public TeamListFilterItemViewHolder(@NonNull View paramView)
  {
    super(paramView);
    this.b = paramView;
    this.a = ((CheckBox)paramView.findViewById(2131430670));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.teamlist.view.TeamListFilterItemViewHolder
 * JD-Core Version:    0.7.0.1
 */