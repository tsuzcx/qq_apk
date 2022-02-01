package com.tencent.mobileqq.extendfriend.widget;

import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.qqexpand.bean.entrance.BannerInfo;
import com.tencent.mobileqq.qqexpand.utils.IEntryExtendForbiddenUtils;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class ExtendFriendContactEntranceContainer$2
  implements View.OnClickListener
{
  ExtendFriendContactEntranceContainer$2(ExtendFriendContactEntranceContainer paramExtendFriendContactEntranceContainer) {}
  
  public void onClick(View paramView)
  {
    ExtendFriendContactEntranceContainer.a(this.a);
    if ((!((IEntryExtendForbiddenUtils)QRoute.api(IEntryExtendForbiddenUtils.class)).isNeedShowDiaLog(ExtendFriendContactEntranceContainer.b(this.a), ExtendFriendContactEntranceContainer.c(this.a))) && (ExtendFriendContactEntranceContainer.d(this.a) != null) && (!TextUtils.isEmpty(ExtendFriendContactEntranceContainer.d(this.a).c)))
    {
      ExtendFriendContactEntranceContainer localExtendFriendContactEntranceContainer = this.a;
      ExtendFriendContactEntranceContainer.a(localExtendFriendContactEntranceContainer, ExtendFriendContactEntranceContainer.d(localExtendFriendContactEntranceContainer).c);
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.extendfriend.widget.ExtendFriendContactEntranceContainer.2
 * JD-Core Version:    0.7.0.1
 */