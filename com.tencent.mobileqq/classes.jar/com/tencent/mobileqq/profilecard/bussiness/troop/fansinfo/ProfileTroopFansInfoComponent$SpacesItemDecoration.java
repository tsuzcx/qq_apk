package com.tencent.mobileqq.profilecard.bussiness.troop.fansinfo;

import android.graphics.Rect;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.ItemDecoration;
import android.support.v7.widget.RecyclerView.State;
import android.view.View;

public class ProfileTroopFansInfoComponent$SpacesItemDecoration
  extends RecyclerView.ItemDecoration
{
  private int space;
  
  public ProfileTroopFansInfoComponent$SpacesItemDecoration(int paramInt)
  {
    this.space = paramInt;
  }
  
  public void getItemOffsets(Rect paramRect, View paramView, RecyclerView paramRecyclerView, RecyclerView.State paramState)
  {
    paramRect.right = this.space;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.profilecard.bussiness.troop.fansinfo.ProfileTroopFansInfoComponent.SpacesItemDecoration
 * JD-Core Version:    0.7.0.1
 */