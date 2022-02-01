package com.tencent.mobileqq.businessCard.activity;

import ProfileLogic.QC.setUserProfileRsp;
import com.tencent.mobileqq.activity.ProfileActivity;
import com.tencent.mobileqq.activity.ProfileActivity.AllInOne;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.SVIPObserver;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;

class CardPicGalleryActivity$11
  extends SVIPObserver
{
  CardPicGalleryActivity$11(CardPicGalleryActivity paramCardPicGalleryActivity) {}
  
  public void onDefaultCardRsp(boolean paramBoolean, Object paramObject)
  {
    if ((paramBoolean) && ((paramObject instanceof setUserProfileRsp)))
    {
      i = ((setUserProfileRsp)paramObject).ret;
      if (QLog.isColorLevel()) {
        QLog.d("qqBaseActivity", 2, "mSvipObserver: [setUserProfileRsp] ret=" + i);
      }
      if (i == 0)
      {
        if (this.a.app != null)
        {
          paramObject = new ProfileActivity.AllInOne(this.a.app.getCurrentAccountUin(), 0);
          paramObject.g = 1;
          paramObject.h = 8;
          ProfileActivity.b(this.a, paramObject);
          QQToast.a(this.a, 0, 2131720240, 0).a();
        }
        this.a.finish();
      }
    }
    while (!"profilelogic.setUserProfile".equals(paramObject))
    {
      int i;
      return;
      QQToast.a(this.a, 1, 2131720237, 0).a();
      return;
    }
    QQToast.a(this.a, 1, 2131720237, 0).a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.businessCard.activity.CardPicGalleryActivity.11
 * JD-Core Version:    0.7.0.1
 */