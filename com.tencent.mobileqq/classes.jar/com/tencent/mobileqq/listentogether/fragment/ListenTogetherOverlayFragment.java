package com.tencent.mobileqq.listentogether.fragment;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.fragment.PublicBaseFragment;
import com.tencent.mobileqq.listentogether.ListenTogetherManager;
import com.tencent.mobileqq.listentogether.ListenTogetherUtils;
import com.tencent.mobileqq.listentogether.lyrics.LyricsController;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.ActionSheet;

public class ListenTogetherOverlayFragment
  extends PublicBaseFragment
{
  private int jdField_a_of_type_Int = -1;
  private BaseActivity jdField_a_of_type_ComTencentMobileqqAppBaseActivity;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  QQCustomDialog jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog;
  private ActionSheet jdField_a_of_type_ComTencentWidgetActionSheet;
  private boolean jdField_a_of_type_Boolean = false;
  private int jdField_b_of_type_Int = -1;
  private boolean jdField_b_of_type_Boolean = false;
  
  private void a()
  {
    if (this.jdField_a_of_type_ComTencentWidgetActionSheet != null) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.i("ListenTogetherOverlayFragment", 2, "showActionSheet in");
    }
    LyricsController localLyricsController = ListenTogetherManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).a();
    this.jdField_a_of_type_ComTencentWidgetActionSheet = ActionSheet.create(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity);
    boolean bool = ListenTogetherUtils.a();
    if (bool) {
      this.jdField_a_of_type_ComTencentWidgetActionSheet.addButton(2131693671);
    }
    this.jdField_a_of_type_ComTencentWidgetActionSheet.addButton(2131693646);
    this.jdField_a_of_type_ComTencentWidgetActionSheet.addCancelButton(2131690728);
    this.jdField_a_of_type_ComTencentWidgetActionSheet.setOnDismissListener(new ListenTogetherOverlayFragment.1(this, localLyricsController));
    this.jdField_a_of_type_ComTencentWidgetActionSheet.setOnCancelListener(new ListenTogetherOverlayFragment.2(this, localLyricsController));
    this.jdField_a_of_type_ComTencentWidgetActionSheet.setOnButtonClickListener(new ListenTogetherOverlayFragment.3(this, bool, localLyricsController));
    this.jdField_a_of_type_ComTencentWidgetActionSheet.show();
    localLyricsController.b(true);
    ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "qq_vip", "0X800A5C1", 1, 0, "", "", "", "");
  }
  
  private void b()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog != null) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.i("ListenTogetherOverlayFragment", 2, "showPermissionDialog in");
    }
    this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog = DialogUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, 230).setMessage(2131695868).setNegativeButton(2131690728, new ListenTogetherOverlayFragment.5(this)).setPositiveButton(2131695870, new ListenTogetherOverlayFragment.4(this));
    this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.setTitle(2131695869);
    this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.setCancelable(false);
    this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.setCanceledOnTouchOutside(false);
    this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.show();
  }
  
  private void c()
  {
    if (this.jdField_a_of_type_ComTencentWidgetActionSheet != null) {
      return;
    }
    if (this.jdField_b_of_type_Boolean) {
      return;
    }
    this.jdField_b_of_type_Boolean = false;
    ListenTogetherManager localListenTogetherManager = ListenTogetherManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    this.jdField_a_of_type_ComTencentWidgetActionSheet = ActionSheet.create(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity);
    this.jdField_a_of_type_ComTencentWidgetActionSheet.addButton(2131716745);
    this.jdField_a_of_type_ComTencentWidgetActionSheet.addButton(2131693684, 3);
    this.jdField_a_of_type_ComTencentWidgetActionSheet.addCancelButton(2131690728);
    this.jdField_a_of_type_ComTencentWidgetActionSheet.setOnButtonClickListener(new ListenTogetherOverlayFragment.6(this, localListenTogetherManager));
    this.jdField_a_of_type_ComTencentWidgetActionSheet.setOnDismissListener(new ListenTogetherOverlayFragment.7(this));
    this.jdField_a_of_type_ComTencentWidgetActionSheet.show();
  }
  
  private void d()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog != null) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.i("ListenTogetherOverlayFragment", 2, "showExitDialog in");
    }
    ListenTogetherManager localListenTogetherManager = ListenTogetherManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    LyricsController localLyricsController = localListenTogetherManager.a();
    this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog = DialogUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, 230).setNegativeButton(2131690728, new ListenTogetherOverlayFragment.9(this, localListenTogetherManager, localLyricsController)).setPositiveButton(2131693683, new ListenTogetherOverlayFragment.8(this, localListenTogetherManager, localLyricsController));
    this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.setTitle(2131693648);
    this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.setOnDismissListener(new ListenTogetherOverlayFragment.10(this, localListenTogetherManager, localLyricsController));
    this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.setCanceledOnTouchOutside(false);
    this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.show();
    localLyricsController.b(true);
  }
  
  private void e()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog != null) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.i("ListenTogetherOverlayFragment", 2, "showExitDialog in");
    }
    int i;
    if (this.jdField_b_of_type_Int == 1) {
      i = 1;
    } else {
      i = 0;
    }
    LyricsController localLyricsController = ListenTogetherManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).a();
    QQCustomDialog localQQCustomDialog = DialogUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, 230);
    int j;
    if (i != 0) {
      j = 2131693650;
    } else {
      j = 2131693649;
    }
    this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog = localQQCustomDialog.setMessage(j).setNegativeButton(2131720163, new ListenTogetherOverlayFragment.11(this));
    localQQCustomDialog = this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog;
    if (i != 0) {
      i = 2131693652;
    } else {
      i = 2131693651;
    }
    localQQCustomDialog.setTitle(i);
    this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.setOnDismissListener(new ListenTogetherOverlayFragment.12(this, localLyricsController));
    this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.setCanceledOnTouchOutside(false);
    this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.show();
    localLyricsController.b(true);
  }
  
  public void initWindowStyleAndAnimation(Activity paramActivity)
  {
    super.initWindowStyleAndAnimation(paramActivity);
    paramActivity.overridePendingTransition(0, 0);
  }
  
  public boolean needImmersive()
  {
    return false;
  }
  
  public boolean needStatusTrans()
  {
    return false;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = getBaseActivity().app;
    this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity = getBaseActivity();
    paramBundle = this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getIntent();
    if (paramBundle != null)
    {
      this.jdField_a_of_type_Int = paramBundle.getIntExtra("type", 0);
      this.jdField_b_of_type_Int = paramBundle.getIntExtra("uinType", -1);
    }
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    if (QLog.isColorLevel()) {
      QLog.d("ListenTogetherOverlayFragment", 2, "onDestroy");
    }
  }
  
  public void onFinish()
  {
    super.onFinish();
    BaseActivity localBaseActivity = getBaseActivity();
    if (localBaseActivity == null) {
      return;
    }
    localBaseActivity.overridePendingTransition(0, 0);
  }
  
  public void onPause()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ListenTogetherOverlayFragment", 2, "onPause");
    }
    super.onPause();
  }
  
  public void onResume()
  {
    super.onResume();
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onResume mType: ");
      localStringBuilder.append(this.jdField_a_of_type_Int);
      localStringBuilder.append(" mHasGotoSetting:");
      localStringBuilder.append(this.jdField_a_of_type_Boolean);
      localStringBuilder.append(" mUinType:");
      localStringBuilder.append(this.jdField_b_of_type_Int);
      QLog.d("ListenTogetherOverlayFragment", 2, localStringBuilder.toString());
    }
    int i = this.jdField_a_of_type_Int;
    if (i == 1)
    {
      a();
      return;
    }
    if (i == 2)
    {
      if (this.jdField_a_of_type_Boolean)
      {
        this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.finish();
        return;
      }
      b();
      return;
    }
    if (i == 3)
    {
      c();
      return;
    }
    if (i == 4)
    {
      e();
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.listentogether.fragment.ListenTogetherOverlayFragment
 * JD-Core Version:    0.7.0.1
 */