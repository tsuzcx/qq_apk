package com.tencent.mobileqq.troop.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.profilecard.data.AllInOne;
import com.tencent.mobileqq.profilecard.utils.ProfileUtils;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class TroopAdminList$6
  implements View.OnClickListener
{
  TroopAdminList$6(TroopAdminList paramTroopAdminList) {}
  
  public void onClick(View paramView)
  {
    Object localObject1 = (TroopAdminList.ViewHolder)paramView.getTag();
    if (localObject1 != null)
    {
      localObject1 = ((TroopAdminList.ViewHolder)localObject1).y;
      if (this.a.app.getCurrentAccountUin().equals(localObject1))
      {
        localObject1 = new AllInOne((String)localObject1, 0);
      }
      else
      {
        int i = this.a.getIntent().getIntExtra("t_s_f", -1);
        Object localObject2 = ((FriendsManager)this.a.app.getManager(QQManagerFactory.FRIENDS_MANAGER)).m((String)localObject1);
        TroopInfo localTroopInfo = ((TroopManager)this.a.app.getManager(QQManagerFactory.TROOP_MANAGER)).f(this.a.i);
        if ((localObject2 != null) && (((Friends)localObject2).isFriend()))
        {
          if (localTroopInfo != null)
          {
            localObject1 = new AllInOne((String)localObject1, 20);
            ((AllInOne)localObject1).troopUin = this.a.j;
            ((AllInOne)localObject1).troopCode = this.a.i;
          }
          else
          {
            localObject1 = new AllInOne((String)localObject1, 1);
          }
          ((AllInOne)localObject1).nickname = ((Friends)localObject2).name;
          ((AllInOne)localObject1).remark = ((Friends)localObject2).remark;
        }
        else if (i == 1002)
        {
          localObject1 = new AllInOne((String)localObject1, 97);
        }
        else if (localTroopInfo != null)
        {
          localObject1 = new AllInOne((String)localObject1, 21);
          ((AllInOne)localObject1).troopUin = this.a.j;
          ((AllInOne)localObject1).troopCode = this.a.i;
          ((AllInOne)localObject1).subSourceId = 12;
        }
        else
        {
          localObject1 = new AllInOne((String)localObject1, 23);
          localObject2 = new Bundle();
          ((Bundle)localObject2).putString("troop_code", this.a.j);
          ((Bundle)localObject2).putString("troop_uin", this.a.i);
          ((AllInOne)localObject1).extras.putBundle("flc_extra_param", (Bundle)localObject2);
        }
      }
      ProfileUtils.openProfileCard(this.a, (AllInOne)localObject1);
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.troop.activity.TroopAdminList.6
 * JD-Core Version:    0.7.0.1
 */