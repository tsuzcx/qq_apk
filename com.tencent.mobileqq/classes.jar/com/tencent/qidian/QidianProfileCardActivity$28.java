package com.tencent.qidian;

import android.content.Context;
import android.text.TextUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.profilecard.data.AllInOne;
import com.tencent.mobileqq.profilecard.data.ProfileCardInfo;
import cooperation.qzone.QZoneHelper;
import cooperation.qzone.QZoneHelper.UserInfo;

class QidianProfileCardActivity$28
  implements Runnable
{
  QidianProfileCardActivity$28(QidianProfileCardActivity paramQidianProfileCardActivity, byte[] paramArrayOfByte) {}
  
  public void run()
  {
    Object localObject2 = this.this$0.app.getCurrentNickname();
    Object localObject1 = localObject2;
    if (TextUtils.isEmpty((CharSequence)localObject2)) {
      localObject1 = this.this$0.app.getCurrentNickname();
    }
    localObject2 = QZoneHelper.UserInfo.getInstance();
    ((QZoneHelper.UserInfo)localObject2).qzone_uin = this.this$0.app.getCurrentAccountUin();
    ((QZoneHelper.UserInfo)localObject2).nickname = ((String)localObject1);
    localObject1 = this.this$0;
    QZoneHelper.forwardToUserHome((Context)localObject1, (QZoneHelper.UserInfo)localObject2, ((QidianProfileCardActivity)localObject1).jdField_a_of_type_ComTencentMobileqqProfilecardDataProfileCardInfo.allInOne.uin, this.this$0.jdField_a_of_type_ComTencentMobileqqProfilecardDataProfileCardInfo.allInOne.lastActivity, -1, 5, this.this$0.jdField_a_of_type_ComTencentMobileqqHitratePreloadProcHitPluginSession, this.a, false);
    QidianProfileCardActivity.b(this.this$0, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qidian.QidianProfileCardActivity.28
 * JD-Core Version:    0.7.0.1
 */