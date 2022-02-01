package com.tencent.mobileqq.profilecard.bussiness.anonymous.manager;

import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.profilesetting.CardSettingObserver;
import com.tencent.mobileqq.profilesetting.ProfileSettingUtils;
import com.tencent.mobileqq.profilesetting.ProfileSettingUtils.Companion;
import com.tencent.qphone.base.util.QLog;
import org.jetbrains.annotations.Nullable;

class AnonymousManager$1
  extends CardSettingObserver
{
  AnonymousManager$1(AnonymousManager paramAnonymousManager) {}
  
  public void onGetCardDisplaySetting(boolean paramBoolean, @Nullable String paramString, @Nullable Card paramCard)
  {
    boolean bool = true;
    if (QLog.isColorLevel()) {
      QLog.d("AnonymousManager", 2, String.format("onGetCardDisplaySetting isSuccess=%s", new Object[] { Boolean.valueOf(paramBoolean) }));
    }
    if ((paramBoolean) && (paramCard != null)) {
      if (ProfileSettingUtils.a.a(42425, paramCard, null) != 0) {
        break label91;
      }
    }
    label91:
    for (paramBoolean = bool;; paramBoolean = false)
    {
      this.this$0.updateBusinessSwitch(paramBoolean);
      if (AnonymousManager.access$000(this.this$0) != null) {
        AnonymousManager.access$000(this.this$0).removeObserver(AnonymousManager.access$100(this.this$0));
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.profilecard.bussiness.anonymous.manager.AnonymousManager.1
 * JD-Core Version:    0.7.0.1
 */