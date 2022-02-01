package com.tencent.mobileqq.tribe.fragment;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.mobileqq.tribe.playvideo.TribeVideoADItem;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class TribeVideoListPlayerFragment$ADViewHolder
  extends TribeVideoListPlayerFragment.BaseVideoViewHolder
  implements View.OnClickListener
{
  View jdField_a_of_type_AndroidViewView;
  ImageView jdField_a_of_type_AndroidWidgetImageView;
  LinearLayout jdField_a_of_type_AndroidWidgetLinearLayout;
  RelativeLayout jdField_a_of_type_AndroidWidgetRelativeLayout;
  TextView jdField_a_of_type_AndroidWidgetTextView;
  TribeVideoADItem jdField_a_of_type_ComTencentMobileqqTribePlayvideoTribeVideoADItem;
  
  TribeVideoListPlayerFragment$ADViewHolder(TribeVideoListPlayerFragment paramTribeVideoListPlayerFragment, View paramView)
  {
    super(paramView);
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      this.jdField_a_of_type_ComTencentMobileqqTribeFragmentTribeVideoListPlayerFragment.a(this.jdField_a_of_type_ComTencentMobileqqTribePlayvideoTribeVideoADItem);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.tribe.fragment.TribeVideoListPlayerFragment.ADViewHolder
 * JD-Core Version:    0.7.0.1
 */