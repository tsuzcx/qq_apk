package com.tencent.mobileqq.qqpermission.view;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.View.OnClickListener;
import android.view.Window;
import android.view.WindowManager.LayoutParams;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import com.tencent.qqlive.module.videoreport.inject.dialog.ReportDialog;

public class PermissionRequestDialog
  extends ReportDialog
{
  private View.OnClickListener jdField_a_of_type_AndroidViewView$OnClickListener;
  private Button jdField_a_of_type_AndroidWidgetButton;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private View.OnClickListener jdField_b_of_type_AndroidViewView$OnClickListener;
  private Button jdField_b_of_type_AndroidWidgetButton;
  private TextView jdField_b_of_type_AndroidWidgetTextView;
  private TextView c;
  
  public PermissionRequestDialog(@NonNull Context paramContext, int paramInt)
  {
    super(paramContext, paramInt);
    setContentView(2131561266);
    a();
  }
  
  private void a()
  {
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131372458));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131372459));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131372460));
    this.c = ((TextView)findViewById(2131372455));
    this.jdField_a_of_type_AndroidWidgetButton = ((Button)findViewById(2131372456));
    this.jdField_b_of_type_AndroidWidgetButton = ((Button)findViewById(2131372457));
    this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(new PermissionRequestDialog.1(this));
    this.jdField_b_of_type_AndroidWidgetButton.setOnClickListener(new PermissionRequestDialog.2(this));
  }
  
  public void a(View.OnClickListener paramOnClickListener)
  {
    this.jdField_b_of_type_AndroidViewView$OnClickListener = paramOnClickListener;
  }
  
  public void a(CharSequence paramCharSequence)
  {
    this.jdField_b_of_type_AndroidWidgetTextView.setText(paramCharSequence);
  }
  
  public void b(CharSequence paramCharSequence)
  {
    this.c.setText(paramCharSequence);
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    paramBundle = getWindow();
    paramBundle.setGravity(80);
    WindowManager.LayoutParams localLayoutParams = paramBundle.getAttributes();
    localLayoutParams.width = -1;
    paramBundle.setAttributes(localLayoutParams);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.qqpermission.view.PermissionRequestDialog
 * JD-Core Version:    0.7.0.1
 */