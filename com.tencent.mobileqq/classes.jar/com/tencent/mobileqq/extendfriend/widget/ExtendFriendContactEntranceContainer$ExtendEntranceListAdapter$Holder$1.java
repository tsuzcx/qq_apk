package com.tencent.mobileqq.extendfriend.widget;

import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.qqexpand.bean.entrance.EntranceInfo;
import com.tencent.mobileqq.qqexpand.utils.IEntryExtendForbiddenUtils;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class ExtendFriendContactEntranceContainer$ExtendEntranceListAdapter$Holder$1
  implements View.OnClickListener
{
  ExtendFriendContactEntranceContainer$ExtendEntranceListAdapter$Holder$1(ExtendFriendContactEntranceContainer.ExtendEntranceListAdapter.Holder paramHolder, EntranceInfo paramEntranceInfo) {}
  
  public void onClick(View paramView)
  {
    ExtendFriendContactEntranceContainer.a(this.b.a.a, this.a);
    if ((!((IEntryExtendForbiddenUtils)QRoute.api(IEntryExtendForbiddenUtils.class)).isNeedShowDiaLog(ExtendFriendContactEntranceContainer.ExtendEntranceListAdapter.Holder.a(this.b), ExtendFriendContactEntranceContainer.c(this.b.a.a))) && (!TextUtils.isEmpty(this.a.f))) {
      ExtendFriendContactEntranceContainer.a(this.b.a.a, this.a.f);
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.extendfriend.widget.ExtendFriendContactEntranceContainer.ExtendEntranceListAdapter.Holder.1
 * JD-Core Version:    0.7.0.1
 */