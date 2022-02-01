package com.tencent.mobileqq.profilecard.base.container;

import android.content.Context;
import android.content.Intent;
import com.tencent.mobileqq.activity.phone.DenyRunnable.OnCancelAction;
import com.tencent.mobileqq.activity.phone.GuideBindPhoneActivity;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.profilecard.data.AllInOne;
import com.tencent.mobileqq.profilecard.data.ProfileCardInfo;
import com.tencent.mobileqq.widget.QQToast;

class ProfileBottomContainer$2
  implements DenyRunnable.OnCancelAction
{
  ProfileBottomContainer$2(ProfileBottomContainer paramProfileBottomContainer) {}
  
  public void onCancel(Context paramContext, boolean paramBoolean)
  {
    if (paramBoolean)
    {
      QQToast.a(ProfileBottomContainer.access$800(this.this$0), 1, HardCodeUtil.a(2131704993), 0).a();
      return;
    }
    paramContext = new Intent(ProfileBottomContainer.access$900(this.this$0), GuideBindPhoneActivity.class);
    paramContext.putExtra("fromKeyForContactBind", 5);
    paramContext.putExtra("key_contact_name", ((ProfileCardInfo)ProfileBottomContainer.access$1000(this.this$0)).allInOne.contactName);
    paramContext.putExtra("key_contact_phone", ((ProfileCardInfo)ProfileBottomContainer.access$1100(this.this$0)).allInOne.uin);
    ProfileBottomContainer.access$1200(this.this$0).startActivity(paramContext);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.profilecard.base.container.ProfileBottomContainer.2
 * JD-Core Version:    0.7.0.1
 */