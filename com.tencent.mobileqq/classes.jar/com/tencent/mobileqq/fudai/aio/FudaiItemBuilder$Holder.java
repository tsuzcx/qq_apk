package com.tencent.mobileqq.fudai.aio;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mobileqq.activity.aio.BaseBubbleBuilder.ViewHolder;
import com.tencent.mobileqq.data.MessageForFuDai;
import com.tencent.mobileqq.widget.FilterRelativeLayout;

public class FudaiItemBuilder$Holder
  extends BaseBubbleBuilder.ViewHolder
{
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private FilterRelativeLayout jdField_a_of_type_ComTencentMobileqqWidgetFilterRelativeLayout;
  private ImageView jdField_b_of_type_AndroidWidgetImageView;
  private TextView jdField_b_of_type_AndroidWidgetTextView;
  private ImageView c;
  private ImageView d;
  private int e;
  
  private void a(View paramView)
  {
    this.jdField_a_of_type_ComTencentMobileqqWidgetFilterRelativeLayout = ((FilterRelativeLayout)paramView.findViewById(2131367394));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131367389));
    this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131367392));
    this.c = ((ImageView)paramView.findViewById(2131367393));
    this.d = ((ImageView)paramView.findViewById(2131367390));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131367395));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131367396));
  }
  
  private void a(MessageForFuDai paramMessageForFuDai)
  {
    this.e = paramMessageForFuDai.themeId;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.fudai.aio.FudaiItemBuilder.Holder
 * JD-Core Version:    0.7.0.1
 */