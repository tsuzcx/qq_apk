package com.tencent.mobileqq.search.presenter;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.addfriend.api.IAddFriendApi;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.search.adapter.GroupSearchAdapter;
import com.tencent.mobileqq.search.model.GroupBaseNetSearchModelItem;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class ActiveEntitySearchResultPresenter$4
  implements View.OnClickListener
{
  ActiveEntitySearchResultPresenter$4(ActiveEntitySearchResultPresenter paramActiveEntitySearchResultPresenter, GroupBaseNetSearchModelItem paramGroupBaseNetSearchModelItem) {}
  
  public void onClick(View paramView)
  {
    if (this.a.Y == 1)
    {
      ReportController.b(null, "dc00898", "", "", "0X800A33B", "0X800A33B", 0, 0, "", "", "", "");
      ReportController.b(null, "dc00898", "", "", "0X800A33B", "0X800A33B", 2, 0, "", "", "", "");
    }
    else
    {
      ReportController.b(null, "dc00898", "", "", "0X800A33B", "0X800A33B", 0, 0, "", "", "", "");
      ReportController.b(null, "dc00898", "", "", "0X800A33B", "0X800A33B", 1, 0, "", "", "", "");
    }
    Object localObject = (FriendsManager)ActiveEntitySearchResultPresenter.c(this.b).getManager(QQManagerFactory.FRIENDS_MANAGER);
    if ((!((FriendsManager)localObject).n(this.a.b)) && (!((FriendsManager)localObject).v(this.a.b)))
    {
      boolean bool = this.a.m();
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("click add mobileNumberResult = ");
        ((StringBuilder)localObject).append(bool);
        ((StringBuilder)localObject).append(",id = ");
        ((StringBuilder)localObject).append(this.a.b);
        QLog.d("Q.uniteSearch.ActiveEntitySearchResultPresenter", 2, ((StringBuilder)localObject).toString());
      }
      if (bool)
      {
        localObject = ((IAddFriendApi)QRoute.api(IAddFriendApi.class)).startAddFriend(paramView.getContext(), 2, this.a.b, null, 3014, 1, this.a.c, null, null, HardCodeUtil.a(2131898212), null);
        ((IAddFriendApi)QRoute.api(IAddFriendApi.class)).launchAddFriend(paramView.getContext(), (Intent)localObject);
      }
      else
      {
        int i;
        if (this.a.m == 99) {
          i = 4;
        } else {
          i = 3;
        }
        localObject = ((IAddFriendApi)QRoute.api(IAddFriendApi.class)).startAddFriend(paramView.getContext(), 1, this.a.b, null, 3020, i, this.a.c, null, null, paramView.getContext().getString(2131886199), null);
        ((IAddFriendApi)QRoute.api(IAddFriendApi.class)).launchAddFriend(paramView.getContext(), (Intent)localObject);
      }
    }
    else if (((FriendsManager)localObject).n(this.a.b))
    {
      this.a.X = 2;
      ActiveEntitySearchResultPresenter.g(this.b).notifyDataSetChanged();
    }
    else
    {
      this.a.X = 1;
      ActiveEntitySearchResultPresenter.g(this.b).notifyDataSetChanged();
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.search.presenter.ActiveEntitySearchResultPresenter.4
 * JD-Core Version:    0.7.0.1
 */