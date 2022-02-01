package com.tencent.mobileqq.qqexpand.widget;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.qqexpand.entrance.IExpandFragmentRouter;
import com.tencent.mobileqq.qroute.QRoute;

class ExtendFriendCardOnHeadIconClick$1
  implements View.OnClickListener
{
  ExtendFriendCardOnHeadIconClick$1(ExtendFriendCardOnHeadIconClick paramExtendFriendCardOnHeadIconClick) {}
  
  public void onClick(View paramView)
  {
    paramView = new Intent();
    paramView.putExtra("key_extend_friend_info_json", ExtendFriendCardOnHeadIconClick.a(this.a));
    ((IExpandFragmentRouter)QRoute.api(IExpandFragmentRouter.class)).launchNewEditFragmentForResult(this.a.getQBaseActivity(), paramView, 8000);
    ExtendFriendCardOnHeadIconClick.b(this.a);
    paramView = this.a;
    ExtendFriendCardOnHeadIconClick.a(paramView, "click", "data_page", "edit_data_btn", ExtendFriendCardOnHeadIconClick.c(paramView));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.qqexpand.widget.ExtendFriendCardOnHeadIconClick.1
 * JD-Core Version:    0.7.0.1
 */