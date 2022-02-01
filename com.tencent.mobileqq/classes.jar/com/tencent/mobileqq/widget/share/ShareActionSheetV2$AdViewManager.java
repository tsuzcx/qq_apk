package com.tencent.mobileqq.widget.share;

import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;

public class ShareActionSheetV2$AdViewManager
{
  private View jdField_a_of_type_AndroidViewView;
  private ViewGroup jdField_a_of_type_AndroidViewViewGroup;
  
  private void a()
  {
    if ((this.jdField_a_of_type_AndroidViewViewGroup != null) && (this.jdField_a_of_type_AndroidViewView != null))
    {
      if (this.jdField_a_of_type_AndroidViewView.getParent() != null) {
        ((ViewGroup)this.jdField_a_of_type_AndroidViewView.getParent()).removeView(this.jdField_a_of_type_AndroidViewView);
      }
      this.jdField_a_of_type_AndroidViewViewGroup.addView(this.jdField_a_of_type_AndroidViewView);
    }
  }
  
  private void a(View paramView)
  {
    if (paramView != null)
    {
      paramView = paramView.getParent();
      if ((paramView != null) && ((paramView instanceof ViewGroup))) {
        a((ViewGroup)paramView);
      }
    }
  }
  
  private void a(ViewGroup paramViewGroup)
  {
    if (paramViewGroup != null) {
      paramViewGroup.removeAllViews();
    }
  }
  
  void a(int paramInt)
  {
    if (this.jdField_a_of_type_AndroidViewViewGroup != null) {
      this.jdField_a_of_type_AndroidViewViewGroup.setBackgroundColor(paramInt);
    }
  }
  
  void a(View paramView, RelativeLayout.LayoutParams paramLayoutParams)
  {
    a(this.jdField_a_of_type_AndroidViewView);
    a(paramView);
    if (paramView != null) {
      paramView.setLayoutParams(paramLayoutParams);
    }
    this.jdField_a_of_type_AndroidViewView = paramView;
    a();
  }
  
  public void a(RelativeLayout paramRelativeLayout)
  {
    a(this.jdField_a_of_type_AndroidViewViewGroup);
    a(paramRelativeLayout);
    this.jdField_a_of_type_AndroidViewViewGroup = paramRelativeLayout;
    a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.widget.share.ShareActionSheetV2.AdViewManager
 * JD-Core Version:    0.7.0.1
 */