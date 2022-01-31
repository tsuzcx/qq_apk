package com.tencent.mobileqq.utils;

import android.app.Dialog;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.widget.ListView;

public class QQCustomSplitDialog
  extends Dialog
{
  ImageView jdField_a_of_type_AndroidWidgetImageView;
  LinearLayout jdField_a_of_type_AndroidWidgetLinearLayout;
  TextView jdField_a_of_type_AndroidWidgetTextView;
  ListView jdField_a_of_type_ComTencentWidgetListView;
  ImageView jdField_b_of_type_AndroidWidgetImageView;
  TextView jdField_b_of_type_AndroidWidgetTextView;
  TextView c;
  TextView d;
  
  public void dismiss()
  {
    try
    {
      super.dismiss();
      return;
    }
    catch (Exception localException) {}
  }
  
  public void setContentView(int paramInt)
  {
    super.setContentView(paramInt);
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131364010));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131362758));
    this.c = ((TextView)findViewById(2131364013));
    this.d = ((TextView)findViewById(2131364014));
    this.c.setVisibility(8);
    this.d.setVisibility(8);
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131364011));
    this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)findViewById(2131363771));
    this.jdField_a_of_type_ComTencentWidgetListView = ((ListView)findViewById(2131364021));
    this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131364022));
  }
  
  public void setTitle(int paramInt)
  {
    this.jdField_a_of_type_AndroidWidgetTextView.setText(paramInt);
    this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
    this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.utils.QQCustomSplitDialog
 * JD-Core Version:    0.7.0.1
 */