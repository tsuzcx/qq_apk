package com.tencent.mobileqq.profilecard.bussiness.anonymous.api.impl;

import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.profilesetting.CardSettingObserver;
import com.tencent.mobileqq.profilesetting.api.IProfileSettingApi;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import org.jetbrains.annotations.Nullable;

class AnonymousServiceImpl$1
  extends CardSettingObserver
{
  AnonymousServiceImpl$1(AnonymousServiceImpl paramAnonymousServiceImpl) {}
  
  public void onGetCardDisplaySetting(boolean paramBoolean, @Nullable String paramString, @Nullable Card paramCard)
  {
    boolean bool2 = QLog.isColorLevel();
    boolean bool1 = false;
    if (bool2) {
      QLog.d("AnonymousServiceImpl", 2, String.format("onGetCardDisplaySetting isSuccess=%s", new Object[] { Boolean.valueOf(paramBoolean) }));
    }
    if ((paramBoolean) && (paramCard != null))
    {
      paramBoolean = bool1;
      if (((IProfileSettingApi)QRoute.api(IProfileSettingApi.class)).getProfileDisplaySettingStateFromCard(42425, paramCard, null) == 0) {
        paramBoolean = true;
      }
      this.this$0.updateBusinessSwitch(paramBoolean);
    }
    if (this.this$0.mApp != null) {
      ((AppInterface)this.this$0.mApp).removeObserver(AnonymousServiceImpl.access$000(this.this$0));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.profilecard.bussiness.anonymous.api.impl.AnonymousServiceImpl.1
 * JD-Core Version:    0.7.0.1
 */