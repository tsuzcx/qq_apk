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
    this.itemView.findViewById(2131361956).setOnClickListener(paramCustomCoverFragment);
    this.itemView.findViewById(2131361966).setOnClickListener(paramCustomCoverFragment);
    this.itemView.findViewById(2131361950).setOnClickListener(paramCustomCoverFragment);
    CustomCoverFragment.a(paramCustomCoverFragment, this.itemView.findViewById(2131370088));
    CustomCoverFragment.a(paramCustomCoverFragment).setVisibility(8);
    CustomCoverFragment.a(paramCustomCoverFragment, (ImageView)this.itemView.findViewById(2131369602));
    CustomCoverFragment.a(paramCustomCoverFragment).setOnClickListener(paramCustomCoverFragment.a);
    AIOUtils.a(CustomCoverFragment.a(paramCustomCoverFragment), 0, 0, (int)(CustomCoverFragment.a(paramCustomCoverFragment) * 20.0F + 0.5F), (int)(CustomCoverFragment.b(paramCustomCoverFragment) * 20.0F + 0.5F));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.profile.CustomCoverFragment.HeaderViewHolder
 * JD-Core Version:    0.7.0.1
 */