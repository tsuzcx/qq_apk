package com.tencent.mobileqq.profile;

import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

class CustomCoverFragment$ItemViewHolder
  extends RecyclerView.ViewHolder
{
  int a;
  ImageView b;
  TextView c;
  Button d;
  
  public CustomCoverFragment$ItemViewHolder(CustomCoverFragment paramCustomCoverFragment, View paramView)
  {
    super(paramView);
    paramView.setTag(this);
    this.b = ((ImageView)paramView.findViewById(2131435388));
    this.c = ((TextView)paramView.findViewById(2131447089));
    this.d = ((Button)paramView.findViewById(2131430116));
    this.d.setOnClickListener(paramCustomCoverFragment.a);
    this.b.setOnClickListener(paramCustomCoverFragment.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.profile.CustomCoverFragment.ItemViewHolder
 * JD-Core Version:    0.7.0.1
 */