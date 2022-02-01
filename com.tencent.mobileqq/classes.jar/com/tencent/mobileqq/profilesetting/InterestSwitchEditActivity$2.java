package com.tencent.mobileqq.profilesetting;

import android.view.View;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.music.QQPlayerService;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import dov.com.qq.im.ae.util.AEFastClickThrottle;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

class InterestSwitchEditActivity$2
  implements ProfileBasePrivacySettingAdapter.PrivacySettingClickListener
{
  InterestSwitchEditActivity$2(InterestSwitchEditActivity paramInterestSwitchEditActivity) {}
  
  public void a(@NotNull View paramView, ProfileDisplaySettingItem paramProfileDisplaySettingItem)
  {
    if (AEFastClickThrottle.a(paramView)) {
      return;
    }
    InterestSwitchEditActivity.a(this.a, paramProfileDisplaySettingItem);
    InterestSwitchEditActivity.b(this.a, paramProfileDisplaySettingItem);
  }
  
  public void b(@NotNull View paramView, @Nullable ProfileDisplaySettingItem paramProfileDisplaySettingItem)
  {
    int j = 0;
    if (!NetworkUtil.d(BaseApplication.getContext())) {
      QQToast.a(BaseApplicationImpl.sApplication, 2131694457, 0).b(this.a.getTitleBarHeight());
    }
    while (paramProfileDisplaySettingItem == null) {
      return;
    }
    if (paramProfileDisplaySettingItem.b()) {}
    for (int i = 1;; i = 0)
    {
      if (ProfileSettingUtils.a.a(paramProfileDisplaySettingItem.b())) {
        if (i != 0) {}
      }
      for (j = 1;; j = i)
      {
        if ((paramProfileDisplaySettingItem.b() == 42340) && (j == 1) && (QQPlayerService.a())) {
          QQPlayerService.c(BaseApplicationImpl.getContext());
        }
        InterestSwitchEditActivity.a(this.a, paramProfileDisplaySettingItem, j);
        InterestSwitchEditActivity.c(this.a, paramProfileDisplaySettingItem);
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.profilesetting.InterestSwitchEditActivity.2
 * JD-Core Version:    0.7.0.1
 */