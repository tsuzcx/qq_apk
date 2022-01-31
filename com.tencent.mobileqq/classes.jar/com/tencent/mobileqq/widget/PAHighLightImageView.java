package com.tencent.mobileqq.widget;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import com.tencent.mobileqq.activity.aio.AIOUtils;

public class PAHighLightImageView
  extends PAImageView
{
  private Context jdField_a_of_type_AndroidContentContext;
  private PAHighLightImageView.ViewOnTouchListener jdField_a_of_type_ComTencentMobileqqWidgetPAHighLightImageView$ViewOnTouchListener;
  
  public PAHighLightImageView(Context paramContext)
  {
    super(paramContext);
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_ComTencentMobileqqWidgetPAHighLightImageView$ViewOnTouchListener = new PAHighLightImageView.ViewOnTouchListener(this, paramContext);
    setOnTouchListener(this.jdField_a_of_type_ComTencentMobileqqWidgetPAHighLightImageView$ViewOnTouchListener);
  }
  
  public PAHighLightImageView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_ComTencentMobileqqWidgetPAHighLightImageView$ViewOnTouchListener = new PAHighLightImageView.ViewOnTouchListener(this, paramContext);
    setOnTouchListener(this.jdField_a_of_type_ComTencentMobileqqWidgetPAHighLightImageView$ViewOnTouchListener);
  }
  
  public PAHighLightImageView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_ComTencentMobileqqWidgetPAHighLightImageView$ViewOnTouchListener = new PAHighLightImageView.ViewOnTouchListener(this, paramContext);
    setOnTouchListener(this.jdField_a_of_type_ComTencentMobileqqWidgetPAHighLightImageView$ViewOnTouchListener);
  }
  
  public void a()
  {
    ViewGroup localViewGroup = (ViewGroup)getParent();
    if (localViewGroup != null)
    {
      View localView = localViewGroup.findViewById(2131362174);
      if (localView != null) {
        localViewGroup.removeView(localView);
      }
    }
  }
  
  public void a(Context paramContext, boolean paramBoolean)
  {
    ViewGroup localViewGroup = (ViewGroup)getParent();
    if ((localViewGroup != null) && (localViewGroup.findViewById(2131362174) == null))
    {
      View localView = new View(paramContext);
      localView.setId(2131362174);
      GradientDrawable localGradientDrawable = new GradientDrawable();
      localGradientDrawable.setColor(Color.argb(77, 0, 0, 0));
      if (paramBoolean) {
        localGradientDrawable.setCornerRadius(AIOUtils.a(5.0F, paramContext.getResources()));
      }
      localView.setBackgroundDrawable(localGradientDrawable);
      localViewGroup.addView(localView, new ViewGroup.LayoutParams(getLayoutParams()));
    }
  }
  
  public void a(View paramView, MotionEvent paramMotionEvent)
  {
    if ((paramMotionEvent.getAction() == 1) || (paramMotionEvent.getAction() == 3)) {
      a();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\b.jar
 * Qualified Name:     com.tencent.mobileqq.widget.PAHighLightImageView
 * JD-Core Version:    0.7.0.1
 */