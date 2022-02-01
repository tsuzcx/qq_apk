package com.tencent.qidian;

import com.tencent.mobileqq.app.CardObserver;
import com.tencent.mobileqq.profilecard.data.AllInOne;
import com.tencent.mobileqq.profilecard.data.ProfileCardInfo;
import com.tencent.qidian.data.BmqqAccountType;
import com.tencent.qphone.base.util.QLog;

class QidianProfileCardActivity$19
  extends CardObserver
{
  QidianProfileCardActivity$19(QidianProfileCardActivity paramQidianProfileCardActivity) {}
  
  protected void onGetAccountType(boolean paramBoolean, BmqqAccountType paramBmqqAccountType)
  {
    super.onGetAccountType(paramBoolean, paramBmqqAccountType);
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onGetAccountType isSuccess: ");
      localStringBuilder.append(paramBoolean);
      localStringBuilder.append(" | type: ");
      localStringBuilder.append(paramBmqqAccountType);
      localStringBuilder.append(" | cardInfo.allinone.uin: ");
      localStringBuilder.append(this.a.e.allInOne.uin);
      QLog.d("QidianProfileCardActivity", 2, localStringBuilder.toString());
    }
    if ((paramBmqqAccountType != null) && (paramBmqqAccountType.getUin() != null) && (this.a.e != null) && (this.a.e.allInOne != null) && (paramBmqqAccountType.getUin().equals(this.a.e.allInOne.uin)))
    {
      this.a.m = paramBmqqAccountType.getAccountType();
      this.a.c();
      if (this.a.m == 1)
      {
        this.a.s.b(this.a, paramBmqqAccountType);
        return;
      }
      this.a.a();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.qidian.QidianProfileCardActivity.19
 * JD-Core Version:    0.7.0.1
 */