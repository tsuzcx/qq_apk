package com.tencent.timi.game.room.impl.doublecheck;

import android.graphics.Rect;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.ItemDecoration;
import androidx.recyclerview.widget.RecyclerView.State;

class RoomGameDoubleCheckDialog$1
  extends RecyclerView.ItemDecoration
{
  RoomGameDoubleCheckDialog$1(RoomGameDoubleCheckDialog paramRoomGameDoubleCheckDialog, int paramInt) {}
  
  public void getItemOffsets(@NonNull Rect paramRect, @NonNull View paramView, @NonNull RecyclerView paramRecyclerView, @NonNull RecyclerView.State paramState)
  {
    super.getItemOffsets(paramRect, paramView, paramRecyclerView, paramState);
    if (paramRecyclerView.getChildAdapterPosition(paramView) == 0)
    {
      paramRect.set(0, 0, 0, 0);
      return;
    }
    paramRect.set(this.a, 0, 0, 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.room.impl.doublecheck.RoomGameDoubleCheckDialog.1
 * JD-Core Version:    0.7.0.1
 */