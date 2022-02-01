package com.tencent.mobileqq.listentogether.fragment;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
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
  private FragmentActivity jdField_a_of_type_AndroidSupportV4AppFragmentActivity;
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
    this.jdField_a_of_type_ComTencentWidgetActionSheet = ActionSheet.create(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity);
    boolean bool = ListenTogetherUtils.a();
    if (bool) {
      this.jdField_a_of_type_ComTencentWidgetActionSheet.addButton(2131693718);
    }
    this.jdField_a_of_type_ComTencentWidgetActionSheet.addButton(2131693693);
    this.jdField_a_of_type_ComTencentWidgetActionSheet.addCancelButton(2131690800);
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
    this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog = DialogUtil.a(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, 230).setMessage(2131695854).setNegativeButton(2131690800, new ListenTogetherOverlayFragment.5(this)).setPositiveButton(2131695858, new ListenTogetherOverlayFragment.4(this));
    this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.setTitle(2131695856);
    this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.setCancelable(false);
    this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.setCanceledOnTouchOutside(false);
    this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.show();
  }
  
  private void c()
  {
    if (this.jdField_a_of_type_ComTencentWidgetActionSheet != null) {}
    while (this.jdField_b_of_type_Boolean) {
      return;
    }
    this.jdField_b_of_type_Boolean = false;
    ListenTogetherManager localListenTogetherManager = ListenTogetherManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    this.jdField_a_of_type_ComTencentWidgetActionSheet = ActionSheet.create(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity);
    this.jdField_a_of_type_ComTencentWidgetActionSheet.addButton(2131717086);
    this.jdField_a_of_type_ComTencentWidgetActionSheet.addButton(2131693731, 3);
    this.jdField_a_of_type_ComTencentWidgetActionSheet.addCancelButton(2131690800);
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
    this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog = DialogUtil.a(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, 230).setNegativeButton(2131690800, new ListenTogetherOverlayFragment.9(this, localListenTogetherManager, localLyricsController)).setPositiveButton(2131693730, new ListenTogetherOverlayFragment.8(this, localListenTogetherManager, localLyricsController));
    this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.setTitle(2131693695);
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
    LyricsController localLyricsController;
    QQCustomDialog localQQCustomDialog;
    int j;
    if (this.jdField_b_of_type_Int == 1)
    {
      i = 1;
      localLyricsController = ListenTogetherManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).a();
      localQQCustomDialog = DialogUtil.a(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, 230);
      if (i == 0) {
        break label146;
      }
      j = 2131693697;
      label62:
      this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog = localQQCustomDialog.setMessage(j).setNegativeButton(2131720448, new ListenTogetherOverlayFragment.11(this));
      localQQCustomDialog = this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog;
      if (i == 0) {
        break label152;
      }
    }
    label146:
    label152:
    for (int i = 2131693699;; i = 2131693698)
    {
      localQQCustomDialog.setTitle(i);
      this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.setOnDismissListener(new ListenTogetherOverlayFragment.12(this, localLyricsController));
      this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.setCanceledOnTouchOutside(false);
      this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.show();
      localLyricsController.b(true);
      return;
      i = 0;
      break;
      j = 2131693696;
      break label62;
    }
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
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = getActivity().app;
    this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity = getActivity();
    paramBundle = this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getIntent();
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
    FragmentActivity localFragmentActivity = getActivity();
    if (localFragmentActivity == null) {
      return;
    }
    localFragmentActivity.overridePendingTransition(0, 0);
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
    if (QLog.isColorLevel()) {
      QLog.d("ListenTogetherOverlayFragment", 2, "onResume mType: " + this.jdField_a_of_type_Int + " mHasGotoSetting:" + this.jdField_a_of_type_Boolean + " mUinType:" + this.jdField_b_of_type_Int);
    }
    if (this.jdField_a_of_type_Int == 1)
    {
      a();
      return;
    }
    if (this.jdField_a_of_type_Int == 2)
    {
      if (this.jdField_a_of_type_Boolean)
      {
        this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.finish();
        return;
      }
      b();
      return;
    }
    if (this.jdField_a_of_type_Int == 3)
    {
      c();
      return;
    }
    if (this.jdField_a_of_type_Int == 4)
    {
      e();
      return;
    }
    this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.listentogether.fragment.ListenTogetherOverlayFragment
 * JD-Core Version:    0.7.0.1
 */