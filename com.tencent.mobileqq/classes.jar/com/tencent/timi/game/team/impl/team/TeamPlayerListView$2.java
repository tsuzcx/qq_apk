package com.tencent.timi.game.team.impl.team;

import android.graphics.Rect;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.ItemDecoration;
import androidx.recyclerview.widget.RecyclerView.State;

class TeamPlayerListView$2
  extends RecyclerView.ItemDecoration
{
  TeamPlayerListView$2(TeamPlayerListView paramTeamPlayerListView, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void getItemOffsets(@NonNull Rect paramRect, @NonNull View paramView, @NonNull RecyclerView paramRecyclerView, @NonNull RecyclerView.State paramState)
  {
    super.getItemOffsets(paramRect, paramView, paramRecyclerView, paramState);
    int i = paramRecyclerView.getChildAdapterPosition(paramView);
    if (i == 0)
    {
      paramRect.set(this.a, 0, 0, 0);
      return;
    }
    if (i == this.b - 1)
    {
      paramRect.set(this.c, 0, this.a, 0);
      return;
    }
    paramRect.set(this.c, 0, 0, 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.team.impl.team.TeamPlayerListView.2
 * JD-Core Version:    0.7.0.1
 */