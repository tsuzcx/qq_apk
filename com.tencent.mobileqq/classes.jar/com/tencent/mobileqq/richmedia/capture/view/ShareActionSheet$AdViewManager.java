package com.tencent.mobileqq.richmedia.capture.view;

import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;

public class ShareActionSheet$AdViewManager
{
  private View jdField_a_of_type_AndroidViewView;
  private ViewGroup jdField_a_of_type_AndroidViewViewGroup;
  
  private void a()
  {
    if ((this.jdField_a_of_type_AndroidViewViewGroup != null) && (this.jdField_a_of_type_AndroidViewView != null)) {
      this.jdField_a_of_type_AndroidViewViewGroup.addView(this.jdField_a_of_type_AndroidViewView);
    }
  }
  
  private void a(ViewGroup paramViewGroup)
  {
    if (paramViewGroup != null) {
      paramViewGroup.removeAllViews();
    }
  }
  
  public void a(RelativeLayout paramRelativeLayout)
  {
    a(this.jdField_a_of_type_AndroidViewViewGroup);
    a(paramRelativeLayout);
    this.jdField_a_of_type_AndroidViewViewGroup = paramRelativeLayout;
    a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.mobileqq.richmedia.capture.view.ShareActionSheet.AdViewManager
 * JD-Core Version:    0.7.0.1
 */