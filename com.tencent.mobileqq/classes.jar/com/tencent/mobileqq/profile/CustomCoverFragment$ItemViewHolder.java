package com.tencent.mobileqq.profile;

import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

class CustomCoverFragment$ItemViewHolder
  extends RecyclerView.ViewHolder
{
  int jdField_a_of_type_Int;
  Button jdField_a_of_type_AndroidWidgetButton;
  ImageView jdField_a_of_type_AndroidWidgetImageView;
  TextView jdField_a_of_type_AndroidWidgetTextView;
  
  public CustomCoverFragment$ItemViewHolder(CustomCoverFragment paramCustomCoverFragment, View paramView)
  {
    super(paramView);
    paramView.setTag(this);
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131368486));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131378475));
    this.jdField_a_of_type_AndroidWidgetButton = ((Button)paramView.findViewById(2131364149));
    this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(paramCustomCoverFragment.a);
    this.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(paramCustomCoverFragment.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.profile.CustomCoverFragment.ItemViewHolder
 * JD-Core Version:    0.7.0.1
 */