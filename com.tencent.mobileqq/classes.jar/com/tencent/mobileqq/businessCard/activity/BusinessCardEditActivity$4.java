package com.tencent.mobileqq.businessCard.activity;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.ProfileActivity;
import com.tencent.mobileqq.activity.ProfileActivity.AllInOne;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class BusinessCardEditActivity$4
  implements View.OnClickListener
{
  BusinessCardEditActivity$4(BusinessCardEditActivity paramBusinessCardEditActivity) {}
  
  public void onClick(View paramView)
  {
    Object localObject = (BusinessCardEditActivity.ItemHolder)paramView.getTag();
    if (!((FriendsManager)this.a.app.getManager(QQManagerFactory.FRIENDS_MANAGER)).b(((BusinessCardEditActivity.ItemHolder)localObject).a)) {}
    for (int i = 35;; i = 1)
    {
      localObject = new ProfileActivity.AllInOne(((BusinessCardEditActivity.ItemHolder)localObject).a, i);
      ProfileActivity.a(this.a, (ProfileActivity.AllInOne)localObject, 1016);
      EventCollector.getInstance().onViewClicked(paramView);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.businessCard.activity.BusinessCardEditActivity.4
 * JD-Core Version:    0.7.0.1
 */