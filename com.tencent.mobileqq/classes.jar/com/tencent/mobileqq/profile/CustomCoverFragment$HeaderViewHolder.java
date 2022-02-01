package com.tencent.mobileqq.profile;

import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.View;
import android.widget.ImageView;
import com.tencent.mobileqq.activity.aio.AIOUtils;

class CustomCoverFragment$HeaderViewHolder
  extends RecyclerView.ViewHolder
{
  public CustomCoverFragment$HeaderViewHolder(CustomCoverFragment paramCustomCoverFragment, View paramView)
  {
    super(paramView);
    this.itemView.setTag(this);
    this.itemView.findViewById(2131427524).setOnClickListener(paramCustomCoverFragment);
    this.itemView.findViewById(2131427541).setOnClickListener(paramCustomCoverFragment);
    this.itemView.findViewById(2131427518).setOnClickListener(paramCustomCoverFragment);
    CustomCoverFragment.a(paramCustomCoverFragment, this.itemView.findViewById(2131436893));
    CustomCoverFragment.c(paramCustomCoverFragment).setVisibility(8);
    CustomCoverFragment.a(paramCustomCoverFragment, (ImageView)this.itemView.findViewById(2131436310));
    CustomCoverFragment.s(paramCustomCoverFragment).setOnClickListener(paramCustomCoverFragment.a);
    AIOUtils.a(CustomCoverFragment.s(paramCustomCoverFragment), 0, 0, (int)(CustomCoverFragment.t(paramCustomCoverFragment) * 20.0F + 0.5F), (int)(CustomCoverFragment.u(paramCustomCoverFragment) * 20.0F + 0.5F));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.profile.CustomCoverFragment.HeaderViewHolder
 * JD-Core Version:    0.7.0.1
 */