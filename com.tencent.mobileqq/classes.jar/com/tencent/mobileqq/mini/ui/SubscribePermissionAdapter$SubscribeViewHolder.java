package com.tencent.mobileqq.mini.ui;

import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.widget.Switch;

public class SubscribePermissionAdapter$SubscribeViewHolder
  extends RecyclerView.ViewHolder
{
  Switch authSwitch;
  TextView contentTextView;
  ImageView detailImageView;
  
  public SubscribePermissionAdapter$SubscribeViewHolder(View paramView)
  {
    super(paramView);
    this.contentTextView = ((TextView)paramView.findViewById(2131448276));
    this.detailImageView = ((ImageView)paramView.findViewById(2131436264));
    this.authSwitch = ((Switch)paramView.findViewById(2131446658));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.mini.ui.SubscribePermissionAdapter.SubscribeViewHolder
 * JD-Core Version:    0.7.0.1
 */