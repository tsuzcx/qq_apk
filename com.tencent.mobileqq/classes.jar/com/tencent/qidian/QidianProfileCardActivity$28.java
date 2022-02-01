package com.tencent.qidian;

import android.text.TextUtils;
import com.tencent.mobileqq.activity.ProfileActivity.AllInOne;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.profile.ProfileCardInfo;
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
    QZoneHelper.forwardToUserHome(this.this$0, (QZoneHelper.UserInfo)localObject2, this.this$0.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.a.a, this.this$0.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.a.g, -1, 5, this.this$0.jdField_a_of_type_ComTencentMobileqqHitratePreloadProcHitPluginSession, this.a, false);
    QidianProfileCardActivity.b(this.this$0, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.qidian.QidianProfileCardActivity.28
 * JD-Core Version:    0.7.0.1
 */