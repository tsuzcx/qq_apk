package com.tencent.mobileqq.profilesetting;

import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;

class InterestSwitchEditActivity$1
  extends CardSettingObserver
{
  InterestSwitchEditActivity$1(InterestSwitchEditActivity paramInterestSwitchEditActivity) {}
  
  public void onGetCardDisplaySetting(boolean paramBoolean, String paramString, Card paramCard)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onGetCardDisplaySetting isSuccess=");
      localStringBuilder.append(paramBoolean);
      localStringBuilder.append(" uin=");
      localStringBuilder.append(paramString);
      QLog.i("InterestSwitchEditActivity", 2, localStringBuilder.toString());
    }
    if (!TextUtils.equals(this.a.app.getCurrentAccountUin(), paramString)) {
      return;
    }
    if (paramBoolean)
    {
      paramString = this.a;
      if (paramCard == null) {
        paramCard = InterestSwitchEditActivity.a(paramString);
      }
      InterestSwitchEditActivity.a(paramString, paramCard);
      ProfileSettingUtils.a.a(this.a.app, InterestSwitchEditActivity.a(this.a), InterestSwitchEditActivity.b(this.a), InterestSwitchEditActivity.c(this.a));
      InterestSwitchEditActivity.d(this.a);
      return;
    }
    QQToast.makeText(this.a, HardCodeUtil.a(2131903759), 0).show(this.a.getTitleBarHeight());
  }
  
  public void onSetCardDisplaySetting(boolean paramBoolean, String paramString, Card paramCard, ArrayList<ReqSetSettingItem> paramArrayList)
  {
    if (QLog.isColorLevel())
    {
      paramCard = new StringBuilder();
      paramCard.append("onSetCardDisplaySetting isSuccess=");
      paramCard.append(paramBoolean);
      paramCard.append(" uin=");
      paramCard.append(paramString);
      QLog.i("InterestSwitchEditActivity", 2, paramCard.toString());
    }
    if (!TextUtils.equals(this.a.app.getCurrentAccountUin(), paramString)) {
      return;
    }
    if (!paramBoolean)
    {
      QQToast.makeText(BaseApplicationImpl.sApplication, 2131916977, 0).show(this.a.getTitleBarHeight());
      if (paramArrayList != null)
      {
        paramString = paramArrayList.iterator();
        while (paramString.hasNext())
        {
          paramCard = (ReqSetSettingItem)paramString.next();
          ProfileSettingUtils.a.a(paramCard.a(), InterestSwitchEditActivity.c(this.a)).c(paramCard.b());
        }
      }
    }
    InterestSwitchEditActivity.d(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.profilesetting.InterestSwitchEditActivity.1
 * JD-Core Version:    0.7.0.1
 */