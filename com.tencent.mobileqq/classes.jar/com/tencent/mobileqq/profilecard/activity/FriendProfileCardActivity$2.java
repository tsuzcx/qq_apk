package com.tencent.mobileqq.profilecard.activity;

import com.tencent.mobileqq.profilecard.base.config.IProfileConfigListener;
import com.tencent.qphone.base.util.QLog;

class FriendProfileCardActivity$2
  implements IProfileConfigListener
{
  FriendProfileCardActivity$2(FriendProfileCardActivity paramFriendProfileCardActivity) {}
  
  public void onConfigUpdate(int paramInt, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("FriendProfileCardActivity", 2, String.format("onConfigUpdate configId=%s tag=%s", new Object[] { Integer.valueOf(paramInt), paramString }));
    }
    if ("profile_switch_config".equals(paramString)) {
      FriendProfileCardActivity.access$100(this.this$0, null);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.profilecard.activity.FriendProfileCardActivity.2
 * JD-Core Version:    0.7.0.1
 */