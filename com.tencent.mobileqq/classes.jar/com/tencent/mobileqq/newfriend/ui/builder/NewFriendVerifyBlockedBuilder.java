package com.tencent.mobileqq.newfriend.ui.builder;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.newfriend.api.INewFriendApi;
import com.tencent.mobileqq.newfriend.msg.NewFriendMessage;
import com.tencent.mobileqq.newfriend.msg.NewFriendVerifyBlockedMsg;
import com.tencent.mobileqq.newfriend.ui.adapter.SystemMsgListAdapter;
import com.tencent.mobileqq.newfriend.ui.adapter.SystemMsgListBaseAdapter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class NewFriendVerifyBlockedBuilder
  extends NewFriendBaseBuilder
  implements View.OnClickListener
{
  public NewFriendVerifyBlockedBuilder(Context paramContext, AppInterface paramAppInterface, SystemMsgListAdapter paramSystemMsgListAdapter, NewFriendMessage paramNewFriendMessage)
  {
    super(paramContext, paramAppInterface, paramSystemMsgListAdapter, paramNewFriendMessage);
  }
  
  public View a(int paramInt, View paramView)
  {
    NewFriendVerifyBlockedBuilder.NewFriendVerifyBlockedHolder localNewFriendVerifyBlockedHolder;
    if ((paramView != null) && ((paramView.getTag() instanceof NewFriendVerifyBlockedBuilder.NewFriendVerifyBlockedHolder)))
    {
      localNewFriendVerifyBlockedHolder = (NewFriendVerifyBlockedBuilder.NewFriendVerifyBlockedHolder)paramView.getTag();
    }
    else
    {
      paramView = LayoutInflater.from(this.c).inflate(2131627877, null);
      localNewFriendVerifyBlockedHolder = new NewFriendVerifyBlockedBuilder.NewFriendVerifyBlockedHolder();
      localNewFriendVerifyBlockedHolder.w = ((ImageView)paramView.findViewById(2131434878));
      paramView.setOnClickListener(this);
      paramView.setTag(localNewFriendVerifyBlockedHolder);
    }
    String str = ((NewFriendVerifyBlockedMsg)this.g).a;
    localNewFriendVerifyBlockedHolder.D = str;
    localNewFriendVerifyBlockedHolder.w.setImageBitmap(this.e.a(1, str));
    ((INewFriendApi)QRoute.api(INewFriendApi.class)).setUiBuilderExposeCnt(((INewFriendApi)QRoute.api(INewFriendApi.class)).getUiBuilderExposeCnt() + 1);
    return paramView;
  }
  
  public void onClick(View paramView)
  {
    if (QLog.isColorLevel()) {
      QLog.d("NewFriendVerifyBlockedBuilder", 2, "start PhoneLaunchActivity");
    }
    ((INewFriendApi)QRoute.api(INewFriendApi.class)).jumpToNewFriendVerifyListAct((Activity)this.c);
    ReportController.b(null, "dc00898", "", "", "0X800A3A4", "0X800A3A4", 0, 0, "", "", "", "");
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.newfriend.ui.builder.NewFriendVerifyBlockedBuilder
 * JD-Core Version:    0.7.0.1
 */