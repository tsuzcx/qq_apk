package com.tencent.timi.game.team.impl.chat;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView.Adapter;
import androidx.recyclerview.widget.RecyclerView.ViewHolder;
import com.tencent.timi.game.userinfo.api.view.AvatarRoundImageView;
import com.tencent.timi.game.userinfo.api.view.AvatarTextView;
import java.util.List;
import trpc.yes.common.CommonOuterClass.QQUserId;
import trpc.yes.common.YoloRoomOuterClass.YoloRoomSpeakingPosInfo;

class TeamAtListView$MemberAdapter
  extends RecyclerView.Adapter
{
  private TeamAtListView$MemberAdapter(TeamAtListView paramTeamAtListView) {}
  
  public int getItemCount()
  {
    return TeamAtListView.TeamAtListViewModel.a(TeamAtListView.b(this.a)).size();
  }
  
  public void onBindViewHolder(@NonNull RecyclerView.ViewHolder paramViewHolder, int paramInt)
  {
    if ((paramViewHolder instanceof TeamAtListView.MemberViewHolder))
    {
      YoloRoomOuterClass.YoloRoomSpeakingPosInfo localYoloRoomSpeakingPosInfo = (YoloRoomOuterClass.YoloRoomSpeakingPosInfo)TeamAtListView.TeamAtListViewModel.a(TeamAtListView.b(this.a)).get(paramInt);
      TeamAtListView.MemberViewHolder localMemberViewHolder = (TeamAtListView.MemberViewHolder)paramViewHolder;
      localMemberViewHolder.b.setUserId((CommonOuterClass.QQUserId)localYoloRoomSpeakingPosInfo.user_id.get());
      localMemberViewHolder.c.setUserId((CommonOuterClass.QQUserId)localYoloRoomSpeakingPosInfo.user_id.get());
      if (TeamAtListView.a(this.a).a)
      {
        localMemberViewHolder.a.setVisibility(0);
        paramViewHolder.itemView.setOnClickListener(new TeamAtListView.MemberAdapter.1(this, paramViewHolder, localYoloRoomSpeakingPosInfo));
        return;
      }
      localMemberViewHolder.a.setVisibility(8);
      paramViewHolder.itemView.setOnClickListener(new TeamAtListView.MemberAdapter.2(this, paramViewHolder, localYoloRoomSpeakingPosInfo));
    }
  }
  
  @NonNull
  public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup paramViewGroup, int paramInt)
  {
    paramViewGroup = LayoutInflater.from(paramViewGroup.getContext()).inflate(2131629488, paramViewGroup, false);
    return new TeamAtListView.MemberViewHolder(this.a, paramViewGroup);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.team.impl.chat.TeamAtListView.MemberAdapter
 * JD-Core Version:    0.7.0.1
 */