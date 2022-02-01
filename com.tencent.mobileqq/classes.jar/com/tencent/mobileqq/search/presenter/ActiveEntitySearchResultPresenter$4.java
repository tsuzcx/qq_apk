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
    if (this.jdField_a_of_type_ComTencentMobileqqSearchModelGroupBaseNetSearchModelItem.o == 1)
    {
      ReportController.b(null, "dc00898", "", "", "0X800A33B", "0X800A33B", 0, 0, "", "", "", "");
      ReportController.b(null, "dc00898", "", "", "0X800A33B", "0X800A33B", 2, 0, "", "", "", "");
    }
    else
    {
      ReportController.b(null, "dc00898", "", "", "0X800A33B", "0X800A33B", 0, 0, "", "", "", "");
      ReportController.b(null, "dc00898", "", "", "0X800A33B", "0X800A33B", 1, 0, "", "", "", "");
    }
    Object localObject = (FriendsManager)ActiveEntitySearchResultPresenter.a(this.jdField_a_of_type_ComTencentMobileqqSearchPresenterActiveEntitySearchResultPresenter).getManager(QQManagerFactory.FRIENDS_MANAGER);
    if ((!((FriendsManager)localObject).b(this.jdField_a_of_type_ComTencentMobileqqSearchModelGroupBaseNetSearchModelItem.b)) && (!((FriendsManager)localObject).d(this.jdField_a_of_type_ComTencentMobileqqSearchModelGroupBaseNetSearchModelItem.b)))
    {
      boolean bool = this.jdField_a_of_type_ComTencentMobileqqSearchModelGroupBaseNetSearchModelItem.b();
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("click add mobileNumberResult = ");
        ((StringBuilder)localObject).append(bool);
        ((StringBuilder)localObject).append(",id = ");
        ((StringBuilder)localObject).append(this.jdField_a_of_type_ComTencentMobileqqSearchModelGroupBaseNetSearchModelItem.b);
        QLog.d("Q.uniteSearch.ActiveEntitySearchResultPresenter", 2, ((StringBuilder)localObject).toString());
      }
      if (bool)
      {
        localObject = ((IAddFriendApi)QRoute.api(IAddFriendApi.class)).startAddFriend(paramView.getContext(), 2, this.jdField_a_of_type_ComTencentMobileqqSearchModelGroupBaseNetSearchModelItem.b, null, 3014, 1, this.jdField_a_of_type_ComTencentMobileqqSearchModelGroupBaseNetSearchModelItem.c, null, null, HardCodeUtil.a(2131707994), null);
        ((IAddFriendApi)QRoute.api(IAddFriendApi.class)).launchAddFriend(paramView.getContext(), (Intent)localObject);
      }
      else
      {
        int i;
        if (this.jdField_a_of_type_ComTencentMobileqqSearchModelGroupBaseNetSearchModelItem.a == 99) {
          i = 4;
        } else {
          i = 3;
        }
        localObject = ((IAddFriendApi)QRoute.api(IAddFriendApi.class)).startAddFriend(paramView.getContext(), 1, this.jdField_a_of_type_ComTencentMobileqqSearchModelGroupBaseNetSearchModelItem.b, null, 3020, i, this.jdField_a_of_type_ComTencentMobileqqSearchModelGroupBaseNetSearchModelItem.c, null, null, paramView.getContext().getString(2131689589), null);
        ((IAddFriendApi)QRoute.api(IAddFriendApi.class)).launchAddFriend(paramView.getContext(), (Intent)localObject);
      }
    }
    else if (((FriendsManager)localObject).b(this.jdField_a_of_type_ComTencentMobileqqSearchModelGroupBaseNetSearchModelItem.b))
    {
      this.jdField_a_of_type_ComTencentMobileqqSearchModelGroupBaseNetSearchModelItem.n = 2;
      ActiveEntitySearchResultPresenter.a(this.jdField_a_of_type_ComTencentMobileqqSearchPresenterActiveEntitySearchResultPresenter).notifyDataSetChanged();
    }
    else
    {
      this.jdField_a_of_type_ComTencentMobileqqSearchModelGroupBaseNetSearchModelItem.n = 1;
      ActiveEntitySearchResultPresenter.a(this.jdField_a_of_type_ComTencentMobileqqSearchPresenterActiveEntitySearchResultPresenter).notifyDataSetChanged();
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.search.presenter.ActiveEntitySearchResultPresenter.4
 * JD-Core Version:    0.7.0.1
 */