package com.tencent.mobileqq.profile.PersonalityLabel;

import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.tencent.mobileqq.widget.MessageProgressView;

class PersonalityLabelGalleryActivity$RecyclerViewHolder
  extends RecyclerView.ViewHolder
{
  ImageView jdField_a_of_type_AndroidWidgetImageView;
  RelativeLayout jdField_a_of_type_AndroidWidgetRelativeLayout;
  MessageProgressView jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView;
  ImageView b;
  
  public PersonalityLabelGalleryActivity$RecyclerViewHolder(PersonalityLabelGalleryActivity paramPersonalityLabelGalleryActivity, View paramView)
  {
    super(paramView);
    float f = PersonalityLabelGalleryActivity.a(paramPersonalityLabelGalleryActivity) * 2.0F;
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)paramView.findViewById(2131372608));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131372550));
    ((CornerImageView)this.jdField_a_of_type_AndroidWidgetImageView).setRadius(f);
    ((CornerImageView)this.jdField_a_of_type_AndroidWidgetImageView).setPressMask(true);
    this.b = ((ImageView)paramView.findViewById(2131366456));
    ((CornerImageView)this.b).setRadius(f);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.profile.PersonalityLabel.PersonalityLabelGalleryActivity.RecyclerViewHolder
 * JD-Core Version:    0.7.0.1
 */