package com.tencent.mobileqq.profilesetting;

import android.view.View;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.widget.ActionSheet;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

class InterestSwitchEditActivity$4
  implements ActionSheetPrivacySelectAdapter.PrivacySelectActionSheetClickListener
{
  InterestSwitchEditActivity$4(InterestSwitchEditActivity paramInterestSwitchEditActivity, ProfileDisplaySettingItem paramProfileDisplaySettingItem, ActionSheet paramActionSheet) {}
  
  public void a(@NotNull View paramView, @Nullable ActionSheetPrivacySelectAdapter.ActionSheetPrivacySelectBean paramActionSheetPrivacySelectBean)
  {
    if ((paramActionSheetPrivacySelectBean != null) && (this.a.i() != paramActionSheetPrivacySelectBean.a()))
    {
      InterestSwitchEditActivity.a(this.c, paramActionSheetPrivacySelectBean.a(), this.a);
      if (!NetworkUtil.isNetSupport(BaseApplication.getContext()))
      {
        QQToast.makeText(BaseApplicationImpl.sApplication, 2131892102, 0).show(this.c.getTitleBarHeight());
        return;
      }
      InterestSwitchEditActivity.a(this.c, this.a, paramActionSheetPrivacySelectBean.a());
    }
    this.b.dismiss();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.profilesetting.InterestSwitchEditActivity.4
 * JD-Core Version:    0.7.0.1
 */