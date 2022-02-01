package com.tencent.qidian;

import com.tencent.biz.bmqq.app.BmqqBusinessObserver;
import com.tencent.mobileqq.data.BmqqUserSimpleInfo;
import com.tencent.mobileqq.profilecard.data.AllInOne;
import com.tencent.mobileqq.profilecard.data.ProfileCardInfo;
import com.tencent.qphone.base.util.QLog;

class QidianProfileCardActivity$22
  extends BmqqBusinessObserver
{
  QidianProfileCardActivity$22(QidianProfileCardActivity paramQidianProfileCardActivity) {}
  
  protected void a(boolean paramBoolean, BmqqUserSimpleInfo paramBmqqUserSimpleInfo)
  {
    this.a.a();
    if ((paramBoolean) && (paramBmqqUserSimpleInfo != null))
    {
      if (paramBmqqUserSimpleInfo.mBmqqUin.equals(this.a.e.allInOne.uin))
      {
        if ((paramBmqqUserSimpleInfo.equals(this.a.o) ^ true))
        {
          QidianProfileCardActivity localQidianProfileCardActivity = this.a;
          localQidianProfileCardActivity.o = paramBmqqUserSimpleInfo;
          localQidianProfileCardActivity.c(0);
          return;
        }
        if (QLog.isColorLevel()) {
          QLog.d("QidianProfileCardActivity", 2, "BmqqBusinessObserver not change");
        }
      }
      else if (QLog.isColorLevel())
      {
        QLog.d("QidianProfileCardActivity", 2, "BmqqBusinessObserver not current uin");
      }
    }
    else if (QLog.isColorLevel()) {
      QLog.d("QidianProfileCardActivity", 2, "BmqqBusinessObserver fail");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.qidian.QidianProfileCardActivity.22
 * JD-Core Version:    0.7.0.1
 */