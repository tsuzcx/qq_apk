package com.tencent.timi.game.teamlist.view;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.OnScrollListener;

class TeamListView$1
  extends RecyclerView.OnScrollListener
{
  TeamListView$1(TeamListView paramTeamListView) {}
  
  public void onScrollStateChanged(@NonNull RecyclerView paramRecyclerView, int paramInt)
  {
    super.onScrollStateChanged(paramRecyclerView, paramInt);
    TeamListView.a(this.a, paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.teamlist.view.TeamListView.1
 * JD-Core Version:    0.7.0.1
 */