package com.tencent.mobileqq.richmediabrowser.view;

import android.app.Activity;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import axup;
import axwf;
import axwg;

public class AIOVideoView$1$1
  implements Runnable
{
  public AIOVideoView$1$1(axwg paramaxwg, String paramString) {}
  
  public void run()
  {
    this.jdField_a_of_type_Axwg.a.a.onLoadFinish(this.jdField_a_of_type_Axwg.a.a.getSelectedIndex(), true);
    if (this.jdField_a_of_type_JavaLangString != null) {}
    for (String str = this.jdField_a_of_type_JavaLangString;; str = this.jdField_a_of_type_Axwg.a.mContext.getString(2131720117))
    {
      this.jdField_a_of_type_Axwg.a.f(false);
      this.jdField_a_of_type_Axwg.a.e(false);
      this.jdField_a_of_type_Axwg.a.jdField_b_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
      axwf.a(this.jdField_a_of_type_Axwg.a).setVisibility(0);
      axwf.a(this.jdField_a_of_type_Axwg.a).setVisibility(8);
      this.jdField_a_of_type_Axwg.a.jdField_b_of_type_AndroidWidgetImageView.setImageResource(2130845634);
      axwf.a(this.jdField_a_of_type_Axwg.a, false);
      TextView localTextView = (TextView)axwf.a(this.jdField_a_of_type_Axwg.a).findViewById(2131365826);
      if (localTextView != null) {
        localTextView.setText(str);
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.richmediabrowser.view.AIOVideoView.1.1
 * JD-Core Version:    0.7.0.1
 */