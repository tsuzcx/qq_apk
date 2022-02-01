package com.tencent.mobileqq.litelivesdk.commoncustomized.roombizmodules.webmodule.dialog;

import android.app.Dialog;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager.LayoutParams;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.falco.utils.UIUtil;
import com.tencent.smtt.sdk.WebView;

public class HalfSizeWebviewDialog
  extends BaseWebDialogFragment
{
  protected float a;
  protected int a;
  protected View a;
  protected ViewGroup a;
  protected ImageView a;
  protected TextView a;
  protected int b;
  protected ImageView b;
  protected boolean b;
  protected int c;
  protected boolean c;
  protected boolean d = false;
  protected boolean e = false;
  
  public HalfSizeWebviewDialog()
  {
    this.jdField_b_of_type_Boolean = false;
    this.jdField_b_of_type_Int = 0;
    this.jdField_c_of_type_Int = 0;
    this.jdField_a_of_type_Float = 1.0F;
  }
  
  private void c()
  {
    if (this.jdField_c_of_type_Int == 0)
    {
      this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
      return;
    }
    this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
  }
  
  public int a()
  {
    return 2131559360;
  }
  
  public FrameLayout a(View paramView)
  {
    return (FrameLayout)paramView.findViewById(2131381848);
  }
  
  protected void a()
  {
    this.jdField_a_of_type_ComTencentSmttSdkWebView.setWebChromeClient(new HalfSizeWebviewDialog.1(this));
  }
  
  public void a(Dialog paramDialog)
  {
    if (paramDialog == null) {
      return;
    }
    paramDialog.setCanceledOnTouchOutside(true);
    Window localWindow = paramDialog.getWindow();
    WindowManager.LayoutParams localLayoutParams;
    if (localWindow != null)
    {
      localLayoutParams = localWindow.getAttributes();
      if (getActivity() != null)
      {
        if (this.d) {
          break label118;
        }
        localWindow.setWindowAnimations(2131755691);
        localLayoutParams.gravity = 80;
      }
      label50:
      if (this.jdField_a_of_type_Int != 0) {
        break label132;
      }
      localLayoutParams.width = -1;
      label62:
      if (this.jdField_b_of_type_Int != 0) {
        break label143;
      }
    }
    label132:
    label143:
    for (localLayoutParams.height = (UIUtil.getScreenHeight(paramDialog.getContext()) / 2);; localLayoutParams.height = this.jdField_b_of_type_Int)
    {
      localWindow.setAttributes(localLayoutParams);
      localWindow.setDimAmount(this.jdField_a_of_type_Float);
      if (this.jdField_b_of_type_Boolean) {
        a();
      }
      if (this.e) {
        break;
      }
      b();
      return;
      label118:
      localWindow.setWindowAnimations(2131755692);
      localLayoutParams.gravity = 5;
      break label50;
      localLayoutParams.width = this.jdField_a_of_type_Int;
      break label62;
    }
  }
  
  public void a(View paramView)
  {
    b(paramView);
  }
  
  public FrameLayout b(View paramView)
  {
    return (FrameLayout)paramView.findViewById(2131381848);
  }
  
  protected void b()
  {
    this.jdField_a_of_type_AndroidViewView.setVisibility(8);
  }
  
  protected void b(View paramView)
  {
    this.jdField_a_of_type_AndroidViewViewGroup = ((ViewGroup)paramView.findViewById(2131368595));
    ViewGroup localViewGroup = this.jdField_a_of_type_AndroidViewViewGroup;
    if (this.jdField_b_of_type_Boolean) {}
    for (int i = 0;; i = 8)
    {
      localViewGroup.setVisibility(i);
      this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131368594));
      this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131368596));
      this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131368597));
      this.jdField_b_of_type_AndroidWidgetImageView.setOnClickListener(new HalfSizeWebviewDialog.2(this));
      this.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(new HalfSizeWebviewDialog.3(this));
      this.jdField_a_of_type_AndroidViewView = paramView.findViewById(2131379677);
      return;
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    paramBundle = getArguments();
    if (paramBundle != null)
    {
      this.jdField_a_of_type_Int = paramBundle.getInt("width");
      this.jdField_b_of_type_Int = paramBundle.getInt("height");
      this.jdField_b_of_type_Boolean = paramBundle.getBoolean("showTitleBar", false);
      this.d = paramBundle.getBoolean("isLandscape", false);
      this.jdField_a_of_type_Float = paramBundle.getFloat("dimAmount", 1.0F);
      this.jdField_c_of_type_Boolean = paramBundle.getBoolean("leftClickClose", false);
      this.jdField_a_of_type_Boolean = paramBundle.getBoolean("plantCookieWhenResume", false);
      this.e = paramBundle.getBoolean("needTopRadius", false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.litelivesdk.commoncustomized.roombizmodules.webmodule.dialog.HalfSizeWebviewDialog
 * JD-Core Version:    0.7.0.1
 */