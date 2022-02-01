package com.tencent.timi.game.team.impl.chat;

import android.view.View;
import android.widget.CheckBox;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView.ViewHolder;
import com.tencent.timi.game.userinfo.api.view.AvatarRoundImageView;
import com.tencent.timi.game.userinfo.api.view.AvatarTextView;

class TeamAtListView$MemberViewHolder
  extends RecyclerView.ViewHolder
{
  CheckBox a;
  AvatarRoundImageView b;
  AvatarTextView c;
  
  public TeamAtListView$MemberViewHolder(TeamAtListView paramTeamAtListView, @NonNull View paramView)
  {
    super(paramView);
    this.a = ((CheckBox)paramView.findViewById(2131428823));
    this.b = ((AvatarRoundImageView)paramView.findViewById(2131428822));
    this.c = ((AvatarTextView)paramView.findViewById(2131428824));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.team.impl.chat.TeamAtListView.MemberViewHolder
 * JD-Core Version:    0.7.0.1
 */