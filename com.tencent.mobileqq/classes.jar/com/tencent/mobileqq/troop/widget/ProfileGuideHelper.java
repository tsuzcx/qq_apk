package com.tencent.mobileqq.troop.widget;

import ajst;
import android.app.Activity;
import android.app.Dialog;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.graphics.Color;
import android.graphics.Rect;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;

public class ProfileGuideHelper
{
  private Activity jdField_a_of_type_AndroidAppActivity;
  private Dialog jdField_a_of_type_AndroidAppDialog;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  
  public ProfileGuideHelper(Activity paramActivity, QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_AndroidAppActivity = paramActivity;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
  }
  
  private int a()
  {
    Rect localRect = new Rect();
    Window localWindow = this.jdField_a_of_type_AndroidAppActivity.getWindow();
    localWindow.getDecorView().getWindowVisibleDisplayFrame(localRect);
    int i = localRect.top;
    return localWindow.findViewById(16908290).getTop() - i;
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_AndroidAppDialog != null)
    {
      this.jdField_a_of_type_AndroidAppDialog.dismiss();
      if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null) {
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getSharedPreferences(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), 0).edit().putBoolean("750_troo_game_guide", false).apply();
      }
      if (QLog.isColorLevel()) {
        QLog.d("ProfileGuideHelper", 2, "750 game guide clicked");
      }
    }
  }
  
  public void a(int paramInt1, int paramInt2, int paramInt3)
  {
    if (this.jdField_a_of_type_AndroidAppDialog != null)
    {
      this.jdField_a_of_type_AndroidAppDialog.dismiss();
      if (QLog.isColorLevel()) {
        QLog.d("ProfileGuideHelper", 2, "guide has shown");
      }
    }
    this.jdField_a_of_type_AndroidAppDialog = new Dialog(this.jdField_a_of_type_AndroidAppActivity, 2131624575);
    if (this.jdField_a_of_type_AndroidAppDialog.getWindow() != null) {
      this.jdField_a_of_type_AndroidAppDialog.getWindow().clearFlags(2);
    }
    int i = a();
    RelativeLayout localRelativeLayout1 = new RelativeLayout(this.jdField_a_of_type_AndroidAppActivity);
    localRelativeLayout1.setPadding(0, 0, 0, 0);
    RelativeLayout localRelativeLayout2 = (RelativeLayout)LayoutInflater.from(this.jdField_a_of_type_AndroidAppActivity).inflate(2130971694, null);
    localRelativeLayout2.setBackgroundColor(Color.parseColor("#B3000000"));
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-1, i + paramInt1);
    localLayoutParams.addRule(10);
    localLayoutParams.addRule(9);
    ((Button)localRelativeLayout2.findViewById(2131375373)).setOnClickListener(new ajst(this));
    localRelativeLayout1.addView(localRelativeLayout2, localLayoutParams);
    localRelativeLayout2 = new RelativeLayout(this.jdField_a_of_type_AndroidAppActivity);
    localRelativeLayout2.setBackgroundColor(Color.parseColor("#B3000000"));
    localLayoutParams = new RelativeLayout.LayoutParams(-1, paramInt3 - paramInt1 - paramInt2);
    localLayoutParams.addRule(12);
    localLayoutParams.addRule(9);
    localRelativeLayout1.addView(localRelativeLayout2, localLayoutParams);
    this.jdField_a_of_type_AndroidAppDialog.setContentView(localRelativeLayout1);
    this.jdField_a_of_type_AndroidAppDialog.show();
    if (QLog.isColorLevel()) {
      QLog.d("ProfileGuideHelper", 2, "guide showed");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp\aaa.jar
 * Qualified Name:     com.tencent.mobileqq.troop.widget.ProfileGuideHelper
 * JD-Core Version:    0.7.0.1
 */