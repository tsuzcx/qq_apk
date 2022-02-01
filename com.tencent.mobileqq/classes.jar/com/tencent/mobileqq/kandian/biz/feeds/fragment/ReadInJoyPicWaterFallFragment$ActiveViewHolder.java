package com.tencent.mobileqq.kandian.biz.feeds.fragment;

import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.view.View;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.TextView;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.activity.aio.AIOUtils;

class ReadInJoyPicWaterFallFragment$ActiveViewHolder
  extends ReadInJoyPicWaterFallFragment.BaseViewHolder
{
  ImageView jdField_a_of_type_AndroidWidgetImageView;
  URLImageView jdField_a_of_type_ComTencentImageURLImageView;
  
  ReadInJoyPicWaterFallFragment$ActiveViewHolder(ReadInJoyPicWaterFallFragment paramReadInJoyPicWaterFallFragment, View paramView)
  {
    super(paramReadInJoyPicWaterFallFragment, paramView);
    this.b = ((URLImageView)paramView.findViewById(2131365261));
    this.b.setScaleType(ImageView.ScaleType.CENTER_CROP);
    this.jdField_a_of_type_ComTencentImageURLImageView = ((URLImageView)paramView.findViewById(2131362663));
    this.jdField_a_of_type_ComTencentImageURLImageView.setImageDrawable(new ColorDrawable(Color.parseColor("#7f000000")));
    AIOUtils.b(3.0F, paramReadInJoyPicWaterFallFragment.getResources());
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131362023));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131378784));
    paramView.setOnClickListener(new ReadInJoyPicWaterFallFragment.ActiveViewHolder.1(this, paramReadInJoyPicWaterFallFragment));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.feeds.fragment.ReadInJoyPicWaterFallFragment.ActiveViewHolder
 * JD-Core Version:    0.7.0.1
 */