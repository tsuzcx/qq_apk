package com.tencent.mobileqq.newfriend.ui.builder;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.newfriend.msg.NewFriendMessage;
import com.tencent.mobileqq.newfriend.ui.adapter.SystemMsgListAdapter;

public class NewFriendSysEmptyBuilder
  extends NewFriendBaseBuilder
  implements View.OnClickListener
{
  public NewFriendSysEmptyBuilder(Context paramContext, AppInterface paramAppInterface, SystemMsgListAdapter paramSystemMsgListAdapter, NewFriendMessage paramNewFriendMessage)
  {
    super(paramContext, paramAppInterface, paramSystemMsgListAdapter, paramNewFriendMessage);
  }
  
  public View a(int paramInt, View paramView)
  {
    NewFriendSysEmptyBuilder.NewFriendSysEmptyHolder localNewFriendSysEmptyHolder;
    if ((paramView != null) && ((paramView.getTag() instanceof NewFriendSysEmptyBuilder.NewFriendSysEmptyHolder)))
    {
      localNewFriendSysEmptyHolder = (NewFriendSysEmptyBuilder.NewFriendSysEmptyHolder)paramView.getTag();
    }
    else
    {
      localNewFriendSysEmptyHolder = new NewFriendSysEmptyBuilder.NewFriendSysEmptyHolder();
      paramView = LayoutInflater.from(this.c).inflate(2131627610, null);
      paramView.setTag(localNewFriendSysEmptyHolder);
    }
    paramView.setOnClickListener(this);
    return paramView;
  }
  
  public void onClick(View paramView) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.newfriend.ui.builder.NewFriendSysEmptyBuilder
 * JD-Core Version:    0.7.0.1
 */