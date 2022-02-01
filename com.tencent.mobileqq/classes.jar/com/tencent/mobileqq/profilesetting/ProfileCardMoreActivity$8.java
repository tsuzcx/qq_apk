package com.tencent.mobileqq.profilesetting;

import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.businessCard.BusinessCardManager;
import com.tencent.mobileqq.businessCard.BusinessCardObserver;
import com.tencent.mobileqq.businessCard.data.BusinessCard;
import com.tencent.qphone.base.util.QLog;

class ProfileCardMoreActivity$8
  extends BusinessCardObserver
{
  ProfileCardMoreActivity$8(ProfileCardMoreActivity paramProfileCardMoreActivity) {}
  
  public void a(boolean paramBoolean, String paramString)
  {
    super.a(paramBoolean, paramString);
  }
  
  public void a(boolean paramBoolean, String paramString, int paramInt)
  {
    super.a(paramBoolean, paramString, paramInt);
    if (paramBoolean)
    {
      localObject = ((BusinessCardManager)this.a.app.getManager(QQManagerFactory.BUSINESS_CARD_MANAGER)).a(paramString);
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onGetCardInfo success : cardId = ");
      localStringBuilder.append(paramString);
      QLog.i("BusinessCard_observer_ProfileCardMoreActivity", 4, localStringBuilder.toString());
      this.a.a((BusinessCard)localObject);
      this.a.a = ((BusinessCard)localObject);
      return;
    }
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("onGetCardInfo faild : cardId = ");
    ((StringBuilder)localObject).append(paramString);
    QLog.e("BusinessCard_observer_ProfileCardMoreActivity", 4, ((StringBuilder)localObject).toString());
  }
  
  public void b(boolean paramBoolean, String paramString)
  {
    super.b(paramBoolean, paramString);
  }
  
  public void b(boolean paramBoolean, String paramString, int paramInt)
  {
    super.b(paramBoolean, paramString, paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.profilesetting.ProfileCardMoreActivity.8
 * JD-Core Version:    0.7.0.1
 */