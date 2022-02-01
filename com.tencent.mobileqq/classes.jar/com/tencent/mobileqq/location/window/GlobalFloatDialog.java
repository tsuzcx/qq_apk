package com.tencent.mobileqq.location.window;

import android.os.Build.VERSION;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.WindowManager;
import android.view.WindowManager.LayoutParams;
import android.widget.TextView;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.qphone.base.util.BaseApplication;

public class GlobalFloatDialog
{
  private final View jdField_a_of_type_AndroidViewView = View.inflate(BaseApplication.getContext(), 2131559067, null);
  private WindowManager jdField_a_of_type_AndroidViewWindowManager = (WindowManager)BaseApplication.getContext().getSystemService("window");
  private final TextView jdField_a_of_type_AndroidWidgetTextView = (TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131365796);
  private CanBackFrameLayout jdField_a_of_type_ComTencentMobileqqLocationWindowCanBackFrameLayout = (CanBackFrameLayout)this.jdField_a_of_type_AndroidViewView.findViewById(2131365829);
  private GlobalFloatDialogEventReceiver jdField_a_of_type_ComTencentMobileqqLocationWindowGlobalFloatDialogEventReceiver;
  private final TextView b;
  private final TextView c;
  
  public GlobalFloatDialog()
  {
    this.jdField_a_of_type_AndroidWidgetTextView.setOnClickListener(new GlobalFloatDialog.1(this));
    this.b = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131365802));
    this.b.setOnClickListener(new GlobalFloatDialog.2(this));
    this.c = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131365811));
    this.c.setVisibility(8);
    this.jdField_a_of_type_ComTencentMobileqqLocationWindowGlobalFloatDialogEventReceiver = new GlobalFloatDialogEventReceiver();
  }
  
  public void a()
  {
    WindowManager.LayoutParams localLayoutParams = new WindowManager.LayoutParams();
    if (Build.VERSION.SDK_INT >= 26) {}
    for (localLayoutParams.type = 2038;; localLayoutParams.type = 2002)
    {
      localLayoutParams.format = -3;
      localLayoutParams.height = ViewUtils.b();
      localLayoutParams.width = ViewUtils.a();
      this.jdField_a_of_type_AndroidViewWindowManager.addView(this.jdField_a_of_type_AndroidViewView, localLayoutParams);
      this.jdField_a_of_type_ComTencentMobileqqLocationWindowGlobalFloatDialogEventReceiver.a(this);
      return;
    }
  }
  
  public void a(View.OnClickListener paramOnClickListener)
  {
    this.jdField_a_of_type_AndroidWidgetTextView.setOnClickListener(new GlobalFloatDialog.3(this, paramOnClickListener));
  }
  
  public void a(String paramString)
  {
    ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131365807)).setText(paramString);
  }
  
  public void b()
  {
    this.jdField_a_of_type_AndroidViewWindowManager.removeView(this.jdField_a_of_type_AndroidViewView);
    this.jdField_a_of_type_ComTencentMobileqqLocationWindowGlobalFloatDialogEventReceiver.a();
  }
  
  public void b(View.OnClickListener paramOnClickListener)
  {
    this.b.setOnClickListener(new GlobalFloatDialog.4(this, paramOnClickListener));
  }
  
  public void b(String paramString)
  {
    this.jdField_a_of_type_AndroidWidgetTextView.setText(paramString);
  }
  
  public void c()
  {
    this.jdField_a_of_type_AndroidViewView.setVisibility(8);
  }
  
  public void c(View.OnClickListener paramOnClickListener)
  {
    this.jdField_a_of_type_ComTencentMobileqqLocationWindowCanBackFrameLayout.setBackKeyListener(new GlobalFloatDialog.5(this, paramOnClickListener));
  }
  
  public void c(String paramString)
  {
    this.b.setText(paramString);
  }
  
  public void d()
  {
    this.jdField_a_of_type_AndroidViewView.setVisibility(0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.location.window.GlobalFloatDialog
 * JD-Core Version:    0.7.0.1
 */