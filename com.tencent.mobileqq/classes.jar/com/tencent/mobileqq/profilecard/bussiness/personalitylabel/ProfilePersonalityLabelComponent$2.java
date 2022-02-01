package com.tencent.mobileqq.profilecard.bussiness.personalitylabel;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.profile.PersonalityLabel.PersonalityLabelHandler;
import com.tencent.mobileqq.profilecard.data.AllInOne;
import com.tencent.mobileqq.profilecard.data.ProfileCardInfo;
import com.tencent.qphone.base.util.QLog;

class ProfilePersonalityLabelComponent$2
  extends BroadcastReceiver
{
  ProfilePersonalityLabelComponent$2(ProfilePersonalityLabelComponent paramProfilePersonalityLabelComponent) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    paramContext = paramIntent.getBundleExtra("key_bundle_data");
    if (paramContext != null)
    {
      boolean bool = paramContext.getBoolean("onTagChanged");
      if (QLog.isColorLevel()) {
        QLog.d("ProfilePersonalityLabelComponent", 2, String.format("onReceive addTag=%s", new Object[] { Boolean.valueOf(bool) }));
      }
      if (bool) {
        ((PersonalityLabelHandler)ProfilePersonalityLabelComponent.access$500(this.this$0).getBusinessHandler(BusinessHandlerFactory.PROFILE_PERSONALITY_LABEL)).a(((ProfileCardInfo)ProfilePersonalityLabelComponent.access$600(this.this$0)).allInOne.uin, 0);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.profilecard.bussiness.personalitylabel.ProfilePersonalityLabelComponent.2
 * JD-Core Version:    0.7.0.1
 */