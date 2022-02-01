package com.tencent.mobileqq.businessCard.activity;

import ProfileLogic.QC.setUserProfileRsp;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.SVIPObserver;
import com.tencent.mobileqq.profilecard.data.AllInOne;
import com.tencent.mobileqq.profilecard.utils.ProfileUtils;
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
      int i = ((setUserProfileRsp)paramObject).ret;
      if (QLog.isColorLevel())
      {
        paramObject = new StringBuilder();
        paramObject.append("mSvipObserver: [setUserProfileRsp] ret=");
        paramObject.append(i);
        QLog.d("qqBaseActivity", 2, paramObject.toString());
      }
      if (i == 0)
      {
        if (this.a.app != null)
        {
          paramObject = new AllInOne(this.a.app.getCurrentAccountUin(), 0);
          paramObject.lastActivity = 1;
          paramObject.profileEntryType = 8;
          ProfileUtils.openProfileCard(this.a, paramObject);
          QQToast.makeText(this.a, 0, 2131917578, 0).show();
        }
        this.a.finish();
        return;
      }
      QQToast.makeText(this.a, 1, 2131917575, 0).show();
      return;
    }
    if ("profilelogic.setUserProfile".equals(paramObject)) {
      QQToast.makeText(this.a, 1, 2131917575, 0).show();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.businessCard.activity.CardPicGalleryActivity.11
 * JD-Core Version:    0.7.0.1
 */