package com.tencent.mobileqq.utils;

import android.app.Dialog;
import android.widget.ImageView;
import android.widget.TextView;

public class QQCustomDialogDevLock
  extends Dialog
{
  ImageView jdField_a_of_type_AndroidWidgetImageView;
  TextView jdField_a_of_type_AndroidWidgetTextView;
  ImageView jdField_b_of_type_AndroidWidgetImageView;
  TextView jdField_b_of_type_AndroidWidgetTextView;
  TextView c;
  TextView d;
  TextView e;
  
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
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131365337));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131372239));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131363896));
    this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131372241));
    this.c = ((TextView)findViewById(2131363901));
    this.d = ((TextView)findViewById(2131364037));
    this.e = ((TextView)findViewById(2131364038));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.utils.QQCustomDialogDevLock
 * JD-Core Version:    0.7.0.1
 */