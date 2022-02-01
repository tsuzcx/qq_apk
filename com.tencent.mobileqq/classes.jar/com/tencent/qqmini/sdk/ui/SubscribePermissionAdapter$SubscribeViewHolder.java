package com.tencent.qqmini.sdk.ui;

import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.qqmini.sdk.launcher.widget.Switch;
import com.tencent.qqmini.sdk.server.R.id;

public class SubscribePermissionAdapter$SubscribeViewHolder
  extends RecyclerView.ViewHolder
{
  Switch authSwitch;
  TextView contentTextView;
  ImageView detailImageView;
  
  public SubscribePermissionAdapter$SubscribeViewHolder(View paramView)
  {
    super(paramView);
    this.contentTextView = ((TextView)paramView.findViewById(R.id.tv_auth_title));
    this.detailImageView = ((ImageView)paramView.findViewById(R.id.iv_auth_detail));
    this.authSwitch = ((Switch)paramView.findViewById(R.id.sw_auth));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.qqmini.sdk.ui.SubscribePermissionAdapter.SubscribeViewHolder
 * JD-Core Version:    0.7.0.1
 */