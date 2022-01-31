package com.tencent.mobileqq.richmediabrowser.view;

import android.app.Activity;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import axyy;
import ayao;
import ayap;

public class AIOVideoView$1$1
  implements Runnable
{
  public AIOVideoView$1$1(ayap paramayap, String paramString) {}
  
  public void run()
  {
    this.jdField_a_of_type_Ayap.a.a.onLoadFinish(this.jdField_a_of_type_Ayap.a.a.getSelectedIndex(), true);
    if (this.jdField_a_of_type_JavaLangString != null) {}
    for (String str = this.jdField_a_of_type_JavaLangString;; str = this.jdField_a_of_type_Ayap.a.mContext.getString(2131720129))
    {
      this.jdField_a_of_type_Ayap.a.f(false);
      this.jdField_a_of_type_Ayap.a.e(false);
      this.jdField_a_of_type_Ayap.a.jdField_b_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
      ayao.a(this.jdField_a_of_type_Ayap.a).setVisibility(0);
      ayao.a(this.jdField_a_of_type_Ayap.a).setVisibility(8);
      this.jdField_a_of_type_Ayap.a.jdField_b_of_type_AndroidWidgetImageView.setImageResource(2130845706);
      ayao.a(this.jdField_a_of_type_Ayap.a, false);
      TextView localTextView = (TextView)ayao.a(this.jdField_a_of_type_Ayap.a).findViewById(2131365828);
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