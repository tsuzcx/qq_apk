package com.tencent.mobileqq.kandian.biz.playfeeds;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

public class VideoFeedsGestureUIManager
{
  private int jdField_a_of_type_Int = 0;
  private ViewGroup jdField_a_of_type_AndroidViewViewGroup;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private VideoFeedsGestureProgressView jdField_a_of_type_ComTencentMobileqqKandianBizPlayfeedsVideoFeedsGestureProgressView;
  private ViewGroup jdField_b_of_type_AndroidViewViewGroup;
  private ImageView jdField_b_of_type_AndroidWidgetImageView;
  private TextView jdField_b_of_type_AndroidWidgetTextView;
  private VideoFeedsGestureProgressView jdField_b_of_type_ComTencentMobileqqKandianBizPlayfeedsVideoFeedsGestureProgressView;
  private ViewGroup c;
  private ViewGroup d;
  private ViewGroup e;
  
  public void a()
  {
    ViewGroup localViewGroup = this.c;
    if (localViewGroup != null) {
      localViewGroup.setVisibility(8);
    }
    localViewGroup = this.d;
    if (localViewGroup != null) {
      localViewGroup.setVisibility(8);
    }
    localViewGroup = this.e;
    if (localViewGroup != null) {
      localViewGroup.setVisibility(8);
    }
  }
  
  public void a(int paramInt, float paramFloat, long paramLong1, long paramLong2)
  {
    if (paramInt != 0)
    {
      if (paramInt != 1)
      {
        if (paramInt != 2)
        {
          if (paramInt == 3)
          {
            String str1 = VideoFeedsHelper.a(paramLong1);
            String str2 = VideoFeedsHelper.a(paramLong2);
            TextView localTextView = this.jdField_a_of_type_AndroidWidgetTextView;
            StringBuilder localStringBuilder = new StringBuilder();
            localStringBuilder.append(str1);
            localStringBuilder.append("/");
            localTextView.setText(localStringBuilder.toString());
            this.jdField_b_of_type_AndroidWidgetTextView.setText(str2);
            if (paramFloat > 0.0F) {
              this.jdField_b_of_type_AndroidWidgetImageView.setBackgroundResource(2130843273);
            } else {
              this.jdField_b_of_type_AndroidWidgetImageView.setBackgroundResource(2130843271);
            }
            if (this.c.getVisibility() == 8) {
              VideoFeedsHelper.a(this.c, 0, 300);
            }
          }
        }
        else
        {
          this.jdField_a_of_type_ComTencentMobileqqKandianBizPlayfeedsVideoFeedsGestureProgressView.setProgress(paramFloat);
          if (this.d.getVisibility() == 8) {
            VideoFeedsHelper.a(this.d, 0, 300);
          }
        }
      }
      else
      {
        this.jdField_b_of_type_ComTencentMobileqqKandianBizPlayfeedsVideoFeedsGestureProgressView.setProgress(paramFloat);
        if (paramFloat == 0.0F) {
          this.jdField_a_of_type_AndroidWidgetImageView.setBackgroundResource(2130843178);
        } else {
          this.jdField_a_of_type_AndroidWidgetImageView.setBackgroundResource(2130843179);
        }
        if (this.e.getVisibility() == 8) {
          VideoFeedsHelper.a(this.e, 0, 300);
        }
      }
    }
    else
    {
      int i = this.jdField_a_of_type_Int;
      if (i != 0) {
        if (i == 3)
        {
          if (this.c.getVisibility() == 0) {
            VideoFeedsHelper.a(this.c, 8, 300);
          }
        }
        else if (i == 2)
        {
          if (this.d.getVisibility() == 0) {
            VideoFeedsHelper.a(this.d, 8, 300);
          }
        }
        else if ((i == 1) && (this.e.getVisibility() == 0)) {
          VideoFeedsHelper.a(this.e, 8, 300);
        }
      }
    }
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public void a(Context paramContext, ViewGroup paramViewGroup)
  {
    this.jdField_a_of_type_AndroidViewViewGroup = paramViewGroup;
    this.jdField_b_of_type_AndroidViewViewGroup = ((ViewGroup)((LayoutInflater)paramContext.getSystemService("layout_inflater")).inflate(2131560323, paramViewGroup));
    this.c = ((ViewGroup)this.jdField_b_of_type_AndroidViewViewGroup.findViewById(2131373156));
    this.d = ((ViewGroup)this.jdField_b_of_type_AndroidViewViewGroup.findViewById(2131363802));
    this.e = ((ViewGroup)this.jdField_b_of_type_AndroidViewViewGroup.findViewById(2131380992));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)this.jdField_b_of_type_AndroidViewViewGroup.findViewById(2131373154));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)this.jdField_b_of_type_AndroidViewViewGroup.findViewById(2131373158));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_b_of_type_AndroidViewViewGroup.findViewById(2131380991));
    this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_b_of_type_AndroidViewViewGroup.findViewById(2131373155));
    this.jdField_a_of_type_ComTencentMobileqqKandianBizPlayfeedsVideoFeedsGestureProgressView = ((VideoFeedsGestureProgressView)this.jdField_b_of_type_AndroidViewViewGroup.findViewById(2131363803));
    this.jdField_b_of_type_ComTencentMobileqqKandianBizPlayfeedsVideoFeedsGestureProgressView = ((VideoFeedsGestureProgressView)this.jdField_b_of_type_AndroidViewViewGroup.findViewById(2131380993));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.playfeeds.VideoFeedsGestureUIManager
 * JD-Core Version:    0.7.0.1
 */