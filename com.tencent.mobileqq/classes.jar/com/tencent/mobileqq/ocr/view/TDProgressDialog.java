package com.tencent.mobileqq.ocr.view;

import android.app.Dialog;
import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.view.WindowManager.LayoutParams;
import android.widget.TextView;
import com.tencent.qqlive.module.videoreport.inject.dialog.ReportDialog;

public class TDProgressDialog
  extends ReportDialog
{
  private Context jdField_a_of_type_AndroidContentContext;
  private LayoutInflater jdField_a_of_type_AndroidViewLayoutInflater;
  private View jdField_a_of_type_AndroidViewView;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private TDCircleProgressView jdField_a_of_type_ComTencentMobileqqOcrViewTDCircleProgressView;
  private View jdField_b_of_type_AndroidViewView;
  private TextView jdField_b_of_type_AndroidWidgetTextView;
  
  public TDProgressDialog(Context paramContext)
  {
    super(paramContext, 2131755842);
    a(paramContext);
  }
  
  private void a(Context paramContext)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_AndroidViewLayoutInflater = LayoutInflater.from(paramContext);
    this.jdField_a_of_type_AndroidViewView = this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2131559650, null);
    setCancelable(false);
    this.jdField_a_of_type_ComTencentMobileqqOcrViewTDCircleProgressView = ((TDCircleProgressView)this.jdField_a_of_type_AndroidViewView.findViewById(2131364756));
    this.jdField_a_of_type_ComTencentMobileqqOcrViewTDCircleProgressView.setCurrent(0);
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131380283));
    this.jdField_b_of_type_AndroidViewView = this.jdField_a_of_type_AndroidViewView.findViewById(2131381105);
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131380241));
  }
  
  public void a(int paramInt)
  {
    this.jdField_a_of_type_ComTencentMobileqqOcrViewTDCircleProgressView.setCurrent(paramInt);
  }
  
  public void a(View.OnClickListener paramOnClickListener)
  {
    if (paramOnClickListener != null) {
      this.jdField_b_of_type_AndroidWidgetTextView.setOnClickListener(paramOnClickListener);
    }
  }
  
  public void a(CharSequence paramCharSequence)
  {
    this.jdField_a_of_type_AndroidWidgetTextView.setText(paramCharSequence);
  }
  
  public void a(boolean paramBoolean)
  {
    if (paramBoolean) {}
    for (int i = 0;; i = 8)
    {
      this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(i);
      this.jdField_b_of_type_AndroidViewView.setVisibility(i);
      return;
    }
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    paramBundle = getWindow();
    paramBundle.setContentView(this.jdField_a_of_type_AndroidViewView);
    int i;
    WindowManager.LayoutParams localLayoutParams;
    float f;
    if (this.jdField_b_of_type_AndroidWidgetTextView.getVisibility() == 0)
    {
      i = 1;
      localLayoutParams = paramBundle.getAttributes();
      f = this.jdField_a_of_type_AndroidContentContext.getResources().getDisplayMetrics().density;
      localLayoutParams.width = ((int)(320.0F * f + 0.5F));
      if (i != 0) {
        break label97;
      }
    }
    label97:
    for (localLayoutParams.height = ((int)(145.0F * f + 0.5F));; localLayoutParams.height = ((int)(200.0F * f + 0.5F)))
    {
      paramBundle.setAttributes(localLayoutParams);
      setCanceledOnTouchOutside(false);
      return;
      i = 0;
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.ocr.view.TDProgressDialog
 * JD-Core Version:    0.7.0.1
 */