package com.tencent.mobileqq.newfriend.ui.builder;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.newfriend.api.INewFriendApi;
import com.tencent.mobileqq.newfriend.api.INewFriendService;
import com.tencent.mobileqq.newfriend.data.NewFriendMoreInfo;
import com.tencent.mobileqq.newfriend.msg.NewFriendMessage;
import com.tencent.mobileqq.newfriend.msg.NewFriendMoreInfoMessage;
import com.tencent.mobileqq.newfriend.ui.adapter.SystemMsgListAdapter;
import com.tencent.mobileqq.newfriend.ui.adapter.SystemMsgListBaseAdapter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.relation.api.IAddFriendTempApi;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.vas.theme.api.ThemeUtil;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class NewFriendMoreInfoBuilder
  extends NewFriendBaseBuilder
  implements View.OnClickListener
{
  public NewFriendMoreInfoBuilder(Context paramContext, AppInterface paramAppInterface, SystemMsgListAdapter paramSystemMsgListAdapter, NewFriendMessage paramNewFriendMessage)
  {
    super(paramContext, paramAppInterface, paramSystemMsgListAdapter, paramNewFriendMessage);
  }
  
  public View a(int paramInt, View paramView)
  {
    NewFriendMoreInfoBuilder.NewFriendMoreInfoHolder localNewFriendMoreInfoHolder;
    if ((paramView != null) && ((paramView.getTag() instanceof NewFriendMoreInfoBuilder.NewFriendMoreInfoHolder)))
    {
      localNewFriendMoreInfoHolder = (NewFriendMoreInfoBuilder.NewFriendMoreInfoHolder)paramView.getTag();
    }
    else
    {
      localNewFriendMoreInfoHolder = new NewFriendMoreInfoBuilder.NewFriendMoreInfoHolder();
      paramView = LayoutInflater.from(this.c).inflate(2131627608, null);
      localNewFriendMoreInfoHolder.a = ((TextView)paramView.findViewById(2131438864));
      if (ThemeUtil.isDefaultTheme()) {
        paramView.setBackgroundResource(2130839637);
      } else {
        paramView.setBackgroundResource(2130839574);
      }
      paramView.setTag(localNewFriendMoreInfoHolder);
    }
    NewFriendMoreInfo localNewFriendMoreInfo = ((NewFriendMoreInfoMessage)this.g).a;
    localNewFriendMoreInfoHolder.a.setText(localNewFriendMoreInfo.a);
    paramView.setOnClickListener(this);
    return paramView;
  }
  
  public void onClick(View paramView)
  {
    Object localObject = paramView.getTag();
    if ((localObject != null) && ((localObject instanceof NewFriendMoreInfoBuilder.NewFriendMoreInfoHolder)))
    {
      int i = ((NewFriendMoreInfoMessage)this.g).a.b;
      if (i != 1000)
      {
        if (i == 1001)
        {
          ((IAddFriendTempApi)QRoute.api(IAddFriendTempApi.class)).startAddContactsActivity(this.c, 4, 226);
          ((INewFriendService)this.d.getRuntimeService(INewFriendService.class, "")).markAllDataReaded();
        }
      }
      else
      {
        i = this.e.i();
        ((INewFriendApi)QRoute.api(INewFriendApi.class)).startNewFriendMoreSysMsgActivityForResult((Activity)this.c, 225, i);
        ReportController.b(this.d, "dc00898", "", "", "0X8007704", "0X8007704", 0, 0, "", "", "", "");
      }
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.newfriend.ui.builder.NewFriendMoreInfoBuilder
 * JD-Core Version:    0.7.0.1
 */