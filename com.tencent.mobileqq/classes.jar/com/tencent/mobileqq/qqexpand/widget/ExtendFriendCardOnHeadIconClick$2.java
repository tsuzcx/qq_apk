package com.tencent.mobileqq.qqexpand.widget;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.addfriend.api.IAddFriendApi;
import com.tencent.mobileqq.qqexpand.bean.profile.ExpandUserInfo;
import com.tencent.mobileqq.qroute.QRoute;

class ExtendFriendCardOnHeadIconClick$2
  implements View.OnClickListener
{
  ExtendFriendCardOnHeadIconClick$2(ExtendFriendCardOnHeadIconClick paramExtendFriendCardOnHeadIconClick) {}
  
  public void onClick(View paramView)
  {
    paramView = ((IAddFriendApi)QRoute.api(IAddFriendApi.class)).startAddFriend(this.a.getActivity(), 1, ExtendFriendCardOnHeadIconClick.d(this.a), null, ExtendFriendCardOnHeadIconClick.e(this.a), ExpandUserInfo.getReportSubId(ExtendFriendCardOnHeadIconClick.f(this.a)), ExtendFriendCardOnHeadIconClick.g(this.a), null, null, null, null);
    ((IAddFriendApi)QRoute.api(IAddFriendApi.class)).launchAddFriendForResult(this.a.getActivity(), paramView, 1);
    ExtendFriendCardOnHeadIconClick.b(this.a);
    paramView = this.a;
    ExtendFriendCardOnHeadIconClick.a(paramView, "click", "data_cpage", "add_friends_all", ExtendFriendCardOnHeadIconClick.c(paramView));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.qqexpand.widget.ExtendFriendCardOnHeadIconClick.2
 * JD-Core Version:    0.7.0.1
 */