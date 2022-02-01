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
    return 2131559235;
  }
  
  public FrameLayout a(View paramView)
  {
    return (FrameLayout)paramView.findViewById(2131381062);
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
    if (localWindow != null)
    {
      WindowManager.LayoutParams localLayoutParams = localWindow.getAttributes();
      if (getActivity() != null) {
        if (!this.d)
        {
          localWindow.setWindowAnimations(2131756038);
          localLayoutParams.gravity = 80;
        }
        else
        {
          localWindow.setWindowAnimations(2131756039);
          localLayoutParams.gravity = 5;
        }
      }
      int i = this.jdField_a_of_type_Int;
      if (i == 0) {
        localLayoutParams.width = -1;
      } else {
        localLayoutParams.width = i;
      }
      i = this.jdField_b_of_type_Int;
      if (i == 0) {
        localLayoutParams.height = (UIUtil.getScreenHeight(paramDialog.getContext()) / 2);
      } else {
        localLayoutParams.height = i;
      }
      localWindow.setAttributes(localLayoutParams);
      localWindow.setDimAmount(this.jdField_a_of_type_Float);
    }
    if (this.jdField_b_of_type_Boolean) {
      a();
    }
    if (!this.e) {
      b();
    }
  }
  
  public void a(View paramView)
  {
    b(paramView);
  }
  
  public FrameLayout b(View paramView)
  {
    return (FrameLayout)paramView.findViewById(2131381062);
  }
  
  protected void b()
  {
    this.jdField_a_of_type_AndroidViewView.setVisibility(8);
  }
  
  protected void b(View paramView)
  {
    this.jdField_a_of_type_AndroidViewViewGroup = ((ViewGroup)paramView.findViewById(2131368335));
    ViewGroup localViewGroup = this.jdField_a_of_type_AndroidViewViewGroup;
    int i;
    if (this.jdField_b_of_type_Boolean) {
      i = 0;
    } else {
      i = 8;
    }
    localViewGroup.setVisibility(i);
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131368334));
    this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131368336));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131368337));
    this.jdField_b_of_type_AndroidWidgetImageView.setOnClickListener(new HalfSizeWebviewDialog.2(this));
    this.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(new HalfSizeWebviewDialog.3(this));
    this.jdField_a_of_type_AndroidViewView = paramView.findViewById(2131379019);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.litelivesdk.commoncustomized.roombizmodules.webmodule.dialog.HalfSizeWebviewDialog
 * JD-Core Version:    0.7.0.1
 */