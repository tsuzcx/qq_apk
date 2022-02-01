package com.tencent.mobileqq.kandian.biz.feeds.fragment;

import android.graphics.Color;
import android.view.View;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.TextView;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.kandian.base.view.widget.HeadImageWithRing;
import com.tencent.mobileqq.kandian.biz.common.widget.ReadInJoyNickNameTextView;
import com.tencent.mobileqq.widget.presseffect.PressEffectSelectorDrawable;

class ReadInJoyPicWaterFallFragment$NormalViewHolder
  extends ReadInJoyPicWaterFallFragment.BaseViewHolder
{
  View jdField_a_of_type_AndroidViewView;
  ImageView jdField_a_of_type_AndroidWidgetImageView;
  HeadImageWithRing jdField_a_of_type_ComTencentMobileqqKandianBaseViewWidgetHeadImageWithRing;
  ReadInJoyNickNameTextView jdField_a_of_type_ComTencentMobileqqKandianBizCommonWidgetReadInJoyNickNameTextView;
  View jdField_b_of_type_AndroidViewView;
  ImageView jdField_b_of_type_AndroidWidgetImageView;
  TextView jdField_b_of_type_AndroidWidgetTextView;
  View jdField_c_of_type_AndroidViewView;
  ImageView jdField_c_of_type_AndroidWidgetImageView;
  TextView jdField_c_of_type_AndroidWidgetTextView;
  TextView d;
  TextView e;
  
  ReadInJoyPicWaterFallFragment$NormalViewHolder(ReadInJoyPicWaterFallFragment paramReadInJoyPicWaterFallFragment, View paramView)
  {
    super(paramReadInJoyPicWaterFallFragment, paramView);
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131378784));
    this.jdField_c_of_type_AndroidViewView = paramView.findViewById(2131378504);
    this.jdField_c_of_type_AndroidViewView.setBackgroundDrawable(new PressEffectSelectorDrawable(Color.parseColor("#D9D9D8"), 0));
    this.jdField_b_of_type_ComTencentImageURLImageView = ((URLImageView)paramView.findViewById(2131365261));
    this.jdField_b_of_type_ComTencentImageURLImageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
    this.jdField_b_of_type_AndroidViewView = paramView.findViewById(2131371970);
    this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131371968));
    this.jdField_c_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131371954));
    this.e = ((TextView)paramView.findViewById(2131371974));
    this.jdField_a_of_type_ComTencentMobileqqKandianBizCommonWidgetReadInJoyNickNameTextView = ((ReadInJoyNickNameTextView)paramView.findViewById(2131371862));
    this.jdField_a_of_type_ComTencentMobileqqKandianBaseViewWidgetHeadImageWithRing = ((HeadImageWithRing)paramView.findViewById(2131369082));
    this.jdField_a_of_type_ComTencentMobileqqKandianBaseViewWidgetHeadImageWithRing.setAttrs(AIOUtils.b(0.5F, paramReadInJoyPicWaterFallFragment.getResources()), Color.parseColor("#0c000000"));
    this.jdField_a_of_type_ComTencentMobileqqKandianBaseViewWidgetHeadImageWithRing.setDrawRing(true);
    this.jdField_a_of_type_ComTencentMobileqqKandianBaseViewWidgetHeadImageWithRing.setCorner(AIOUtils.b(12.0F, paramReadInJoyPicWaterFallFragment.getResources()) / 2);
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131370028));
    this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131379809));
    this.d = ((TextView)paramView.findViewById(2131379053));
    this.jdField_a_of_type_AndroidViewView = paramView.findViewById(2131379044);
    this.jdField_a_of_type_AndroidViewView.setBackgroundDrawable(new PressEffectSelectorDrawable(Color.parseColor("#D9D9D8"), 0));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131379043));
    paramView.setOnClickListener(new ReadInJoyPicWaterFallFragment.NormalViewHolder.1(this, paramReadInJoyPicWaterFallFragment));
    this.jdField_c_of_type_AndroidWidgetImageView.setOnClickListener(new ReadInJoyPicWaterFallFragment.NormalViewHolder.2(this, paramReadInJoyPicWaterFallFragment));
    this.jdField_a_of_type_AndroidViewView.setOnClickListener(new ReadInJoyPicWaterFallFragment.NormalViewHolder.3(this, paramReadInJoyPicWaterFallFragment));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.feeds.fragment.ReadInJoyPicWaterFallFragment.NormalViewHolder
 * JD-Core Version:    0.7.0.1
 */