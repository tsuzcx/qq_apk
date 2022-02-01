package com.tencent.mobileqq.profilecard.base.component;

import com.tencent.mobileqq.avatar.observer.AvatarObserver;
import com.tencent.mobileqq.profilecard.base.view.AbsProfileHeaderView;
import com.tencent.mobileqq.profilecard.data.AllInOne;
import com.tencent.mobileqq.profilecard.data.ProfileCardInfo;
import com.tencent.mobileqq.profilecard.utils.ProfileUtils;
import com.tencent.qphone.base.util.QLog;

class AbsProfileHeaderComponent$4
  extends AvatarObserver
{
  AbsProfileHeaderComponent$4(AbsProfileHeaderComponent paramAbsProfileHeaderComponent) {}
  
  protected void onUpdateCustomHead(boolean paramBoolean, String paramString)
  {
    if ((paramBoolean) && (paramString.equals(((ProfileCardInfo)AbsProfileHeaderComponent.access$1000(this.this$0)).allInOne.uin)) && (this.this$0.mHeaderView != null)) {
      this.this$0.mHeaderView.updateAvatar(((ProfileCardInfo)AbsProfileHeaderComponent.access$1100(this.this$0)).allInOne);
    }
  }
  
  protected void onUpdateMobileQQHead(boolean paramBoolean, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AbsProfileHeaderComponent", 2, String.format("onUpdateMobileQQHead isSuccess=%s mobileNumber=%s", new Object[] { Boolean.valueOf(paramBoolean), paramString }));
    }
    if ((paramBoolean) && (((ProfileCardInfo)AbsProfileHeaderComponent.access$700(this.this$0)).allInOne != null))
    {
      String str = ProfileUtils.getMobileNumberWithNationCode(((ProfileCardInfo)AbsProfileHeaderComponent.access$800(this.this$0)).allInOne);
      if ((str != null) && (str.equals(paramString)) && (this.this$0.mHeaderView != null)) {
        this.this$0.mHeaderView.updateAvatar(((ProfileCardInfo)AbsProfileHeaderComponent.access$900(this.this$0)).allInOne, 1, str, false);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.profilecard.base.component.AbsProfileHeaderComponent.4
 * JD-Core Version:    0.7.0.1
 */