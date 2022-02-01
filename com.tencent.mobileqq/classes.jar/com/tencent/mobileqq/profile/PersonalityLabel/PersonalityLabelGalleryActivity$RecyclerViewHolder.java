package com.tencent.mobileqq.profile.PersonalityLabel;

import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.tencent.mobileqq.widget.MessageProgressView;

class PersonalityLabelGalleryActivity$RecyclerViewHolder
  extends RecyclerView.ViewHolder
{
  RelativeLayout a;
  ImageView b;
  ImageView c;
  MessageProgressView d;
  
  public PersonalityLabelGalleryActivity$RecyclerViewHolder(PersonalityLabelGalleryActivity paramPersonalityLabelGalleryActivity, View paramView)
  {
    super(paramView);
    float f = PersonalityLabelGalleryActivity.f(paramPersonalityLabelGalleryActivity) * 2.0F;
    this.a = ((RelativeLayout)paramView.findViewById(2131440148));
    this.b = ((ImageView)paramView.findViewById(2131440088));
    ((CornerImageView)this.b).setRadius(f);
    ((CornerImageView)this.b).setPressMask(true);
    this.c = ((ImageView)paramView.findViewById(2131432774));
    ((CornerImageView)this.c).setRadius(f);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.profile.PersonalityLabel.PersonalityLabelGalleryActivity.RecyclerViewHolder
 * JD-Core Version:    0.7.0.1
 */