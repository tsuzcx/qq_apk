package com.tencent.mobileqq.now;

import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.tencent.mobileqq.now.focusanchor.commonwidget.FrameAnimationView;
import com.tencent.mobileqq.now.widget.CircleImageView;
import com.tencent.mobileqq.now.widget.RoundedRectImageView;

public class VideoCardHolder
  extends RecyclerHolder
{
  public int a;
  public View a;
  public FrameLayout a;
  public TextView a;
  public FrameAnimationView a;
  public CircleImageView a;
  public RoundedRectImageView a;
  public FrameLayout b;
  public TextView b;
  public TextView c;
  
  public VideoCardHolder(View paramView)
  {
    super(paramView);
    this.jdField_a_of_type_Int = -1;
    this.jdField_a_of_type_AndroidViewView = paramView;
    this.jdField_a_of_type_ComTencentMobileqqNowWidgetRoundedRectImageView = ((RoundedRectImageView)paramView.findViewById(2131364410));
    this.jdField_a_of_type_ComTencentMobileqqNowWidgetCircleImageView = ((CircleImageView)paramView.findViewById(2131362720));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131362723));
    this.jdField_a_of_type_AndroidWidgetFrameLayout = ((FrameLayout)paramView.findViewById(2131362721));
    this.jdField_b_of_type_AndroidWidgetFrameLayout = ((FrameLayout)paramView.findViewById(2131362725));
    this.jdField_a_of_type_ComTencentMobileqqNowFocusanchorCommonwidgetFrameAnimationView = ((FrameAnimationView)paramView.findViewById(2131362724));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131381803));
    this.c = ((TextView)paramView.findViewById(2131377353));
    paramView.setTag(this);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.now.VideoCardHolder
 * JD-Core Version:    0.7.0.1
 */