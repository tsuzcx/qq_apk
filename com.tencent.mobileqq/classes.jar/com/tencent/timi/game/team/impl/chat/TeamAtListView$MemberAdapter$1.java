package com.tencent.timi.game.team.impl.chat;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.CheckBox;
import androidx.recyclerview.widget.RecyclerView.ViewHolder;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.timi.game.userinfo.api.view.AvatarTextView;
import java.util.List;
import trpc.yes.common.CommonOuterClass.QQUserId;
import trpc.yes.common.YoloRoomOuterClass.YoloRoomSpeakingPosInfo;

class TeamAtListView$MemberAdapter$1
  implements View.OnClickListener
{
  TeamAtListView$MemberAdapter$1(TeamAtListView.MemberAdapter paramMemberAdapter, RecyclerView.ViewHolder paramViewHolder, YoloRoomOuterClass.YoloRoomSpeakingPosInfo paramYoloRoomSpeakingPosInfo) {}
  
  public void onClick(View paramView)
  {
    ((TeamAtListView.MemberViewHolder)this.a).a.performClick();
    TeamAtListView.AtMember localAtMember = new TeamAtListView.AtMember(this.c.a);
    localAtMember.a = ((TeamAtListView.MemberViewHolder)this.a).c.f();
    localAtMember.b = ((CommonOuterClass.QQUserId)this.b.user_id.get());
    if (((TeamAtListView.MemberViewHolder)this.a).a.isChecked()) {
      TeamAtListView.TeamAtListViewModel.b(TeamAtListView.b(this.c.a)).add(localAtMember);
    } else {
      TeamAtListView.TeamAtListViewModel.b(TeamAtListView.b(this.c.a)).remove(localAtMember);
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.team.impl.chat.TeamAtListView.MemberAdapter.1
 * JD-Core Version:    0.7.0.1
 */