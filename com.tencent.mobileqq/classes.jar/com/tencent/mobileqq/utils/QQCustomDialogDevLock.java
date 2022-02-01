package com.tencent.mobileqq.utils;

import android.app.Dialog;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.qqlive.module.videoreport.inject.dialog.ReportDialog;

public class QQCustomDialogDevLock
  extends ReportDialog
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
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131365680));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131368388));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131378461));
    this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131368389));
    this.c = ((TextView)findViewById(2131378463));
    this.d = ((TextView)findViewById(2131365633));
    this.e = ((TextView)findViewById(2131365639));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.utils.QQCustomDialogDevLock
 * JD-Core Version:    0.7.0.1
 */