package com.tencent.mobileqq.together.ui;

import android.view.View;
import android.view.Window;
import android.view.WindowManager.LayoutParams;
import android.view.inputmethod.InputMethodManager;
import android.widget.PopupWindow.OnDismissListener;
import com.tencent.mobileqq.activity.aio.core.TroopChatPie;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.together.TogetherControlManager;
import com.tencent.qphone.base.util.QLog;

public class TogetherPanel
  implements PopupWindow.OnDismissListener
{
  BaseActivity jdField_a_of_type_ComTencentMobileqqAppBaseActivity;
  TogetherPopupDialog jdField_a_of_type_ComTencentMobileqqTogetherUiTogetherPopupDialog;
  
  public TogetherPanel(BaseActivity paramBaseActivity)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity = paramBaseActivity;
  }
  
  public void a()
  {
    if (QLog.isColorLevel()) {
      QLog.d("TogetherPanel", 2, "destroyPanel");
    }
    a();
    this.jdField_a_of_type_ComTencentMobileqqTogetherUiTogetherPopupDialog.d();
    this.jdField_a_of_type_ComTencentMobileqqTogetherUiTogetherPopupDialog = null;
  }
  
  public void a(TroopChatPie paramTroopChatPie, View paramView, int paramInt)
  {
    paramView = (InputMethodManager)this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getSystemService("input_method");
    if (paramView.isActive()) {
      paramView.hideSoftInputFromWindow(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getWindow().getDecorView().getWindowToken(), 0);
    }
    if (this.jdField_a_of_type_ComTencentMobileqqTogetherUiTogetherPopupDialog == null)
    {
      this.jdField_a_of_type_ComTencentMobileqqTogetherUiTogetherPopupDialog = TogetherPopupDialog.a(paramTroopChatPie, this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, -1, -1, paramInt);
      this.jdField_a_of_type_ComTencentMobileqqTogetherUiTogetherPopupDialog.setOnDismissListener(this);
      TogetherControlManager.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.app).a();
    }
    for (;;)
    {
      paramTroopChatPie = this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getWindow();
      if (paramTroopChatPie != null)
      {
        paramView = paramTroopChatPie.getAttributes();
        paramView.alpha = 0.5F;
        paramTroopChatPie.setAttributes(paramView);
      }
      this.jdField_a_of_type_ComTencentMobileqqTogetherUiTogetherPopupDialog.setAnimationStyle(2131755406);
      this.jdField_a_of_type_ComTencentMobileqqTogetherUiTogetherPopupDialog.showAtLocation(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getWindow().getDecorView(), 80, 0, 0);
      this.jdField_a_of_type_ComTencentMobileqqTogetherUiTogetherPopupDialog.b();
      return;
      if (paramInt == 1) {
        this.jdField_a_of_type_ComTencentMobileqqTogetherUiTogetherPopupDialog.c();
      }
    }
  }
  
  public boolean a()
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (this.jdField_a_of_type_ComTencentMobileqqTogetherUiTogetherPopupDialog != null)
    {
      bool1 = bool2;
      if (this.jdField_a_of_type_ComTencentMobileqqTogetherUiTogetherPopupDialog.isShowing())
      {
        this.jdField_a_of_type_ComTencentMobileqqTogetherUiTogetherPopupDialog.dismiss();
        bool1 = true;
      }
    }
    return bool1;
  }
  
  public void onDismiss()
  {
    TogetherControlManager.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.app).a(false);
    Window localWindow = this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getWindow();
    if (localWindow != null)
    {
      WindowManager.LayoutParams localLayoutParams = localWindow.getAttributes();
      localLayoutParams.alpha = 1.0F;
      localWindow.setAttributes(localLayoutParams);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.together.ui.TogetherPanel
 * JD-Core Version:    0.7.0.1
 */