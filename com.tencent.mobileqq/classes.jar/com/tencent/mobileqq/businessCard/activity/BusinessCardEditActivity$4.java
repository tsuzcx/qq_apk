package com.tencent.mobileqq.businessCard.activity;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.profilecard.data.AllInOne;
import com.tencent.mobileqq.profilecard.utils.ProfileUtils;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class BusinessCardEditActivity$4
  implements View.OnClickListener
{
  BusinessCardEditActivity$4(BusinessCardEditActivity paramBusinessCardEditActivity) {}
  
  public void onClick(View paramView)
  {
    Object localObject = (BusinessCardEditActivity.ItemHolder)paramView.getTag();
    int i;
    if (!((FriendsManager)this.a.app.getManager(QQManagerFactory.FRIENDS_MANAGER)).n(((BusinessCardEditActivity.ItemHolder)localObject).a)) {
      i = 35;
    } else {
      i = 1;
    }
    localObject = new AllInOne(((BusinessCardEditActivity.ItemHolder)localObject).a, i);
    ProfileUtils.openProfileCardForResult(this.a, (AllInOne)localObject, 1016);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.businessCard.activity.BusinessCardEditActivity.4
 * JD-Core Version:    0.7.0.1
 */