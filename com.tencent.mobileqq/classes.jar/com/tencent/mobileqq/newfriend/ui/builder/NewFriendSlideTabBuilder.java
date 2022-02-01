package com.tencent.mobileqq.newfriend.ui.builder;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.activity.contact.connections.ConnectionsTabInfo;
import com.tencent.mobileqq.activity.contact.connections.ThemeTabLayout;
import com.tencent.mobileqq.newfriend.msg.NewFriendMessage;
import com.tencent.mobileqq.newfriend.msg.NewFriendSlideTabMessage;
import com.tencent.mobileqq.newfriend.ui.adapter.SystemMsgListAdapter;
import com.tencent.mobileqq.newfriend.ui.adapter.SystemMsgListBaseAdapter;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.vas.theme.api.ThemeUtil;
import com.tencent.mobileqq.widget.TabLayoutCompat.OnTabSelectedListener;
import com.tencent.mobileqq.widget.TabLayoutCompat.Tab;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;

public class NewFriendSlideTabBuilder
  extends NewFriendBaseBuilder
  implements TabLayoutCompat.OnTabSelectedListener
{
  public NewFriendSlideTabBuilder(Context paramContext, AppInterface paramAppInterface, SystemMsgListAdapter paramSystemMsgListAdapter, NewFriendMessage paramNewFriendMessage)
  {
    super(paramContext, paramAppInterface, paramSystemMsgListAdapter, paramNewFriendMessage);
  }
  
  public View a(int paramInt, View paramView)
  {
    paramInt = this.jdField_a_of_type_ComTencentMobileqqNewfriendUiAdapterSystemMsgListBaseAdapter.c();
    int i = this.jdField_a_of_type_ComTencentMobileqqNewfriendUiAdapterSystemMsgListBaseAdapter.b();
    NewFriendSlideTabBuilder.NewFriendSildeTabHolder localNewFriendSildeTabHolder;
    Object localObject;
    if ((paramView != null) && ((paramView.getTag() instanceof NewFriendSlideTabBuilder.NewFriendSildeTabHolder)))
    {
      localNewFriendSildeTabHolder = (NewFriendSlideTabBuilder.NewFriendSildeTabHolder)paramView.getTag();
    }
    else
    {
      localNewFriendSildeTabHolder = new NewFriendSlideTabBuilder.NewFriendSildeTabHolder();
      paramView = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131561245, null);
      localNewFriendSildeTabHolder.a = ((ThemeTabLayout)paramView.findViewById(2131378236));
      localNewFriendSildeTabHolder.a.a(this);
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("getView new ConnectionsTabLayout tabPosition  ->");
        ((StringBuilder)localObject).append(paramInt);
        ((StringBuilder)localObject).append(", tabId =");
        ((StringBuilder)localObject).append(i);
        QLog.d("NewFriendSlideTabBuilder", 2, ((StringBuilder)localObject).toString());
      }
      if ((this.jdField_a_of_type_ComTencentMobileqqNewfriendMsgNewFriendMessage != null) || ((this.jdField_a_of_type_ComTencentMobileqqNewfriendMsgNewFriendMessage instanceof NewFriendSlideTabMessage))) {
        localNewFriendSildeTabHolder.a.a(((NewFriendSlideTabMessage)this.jdField_a_of_type_ComTencentMobileqqNewfriendMsgNewFriendMessage).a, i);
      }
      localNewFriendSildeTabHolder.a.setOnTabSelectedListener(this);
      paramView.setTag(localNewFriendSildeTabHolder);
    }
    c(paramView);
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("getView update tabPosition = ");
      ((StringBuilder)localObject).append(paramInt);
      ((StringBuilder)localObject).append(", tabId =");
      ((StringBuilder)localObject).append(i);
      QLog.d("NewFriendSlideTabBuilder", 2, ((StringBuilder)localObject).toString());
    }
    if ((localNewFriendSildeTabHolder != null) && (localNewFriendSildeTabHolder.a != null) && ((this.jdField_a_of_type_ComTencentMobileqqNewfriendMsgNewFriendMessage != null) || ((this.jdField_a_of_type_ComTencentMobileqqNewfriendMsgNewFriendMessage instanceof NewFriendSlideTabMessage))))
    {
      localObject = ((NewFriendSlideTabMessage)this.jdField_a_of_type_ComTencentMobileqqNewfriendMsgNewFriendMessage).a;
      localNewFriendSildeTabHolder.a.b((ArrayList)localObject, i);
    }
    return paramView;
  }
  
  public ArrayList<ConnectionsTabInfo> a()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqNewfriendMsgNewFriendMessage == null) && (!(this.jdField_a_of_type_ComTencentMobileqqNewfriendMsgNewFriendMessage instanceof NewFriendSlideTabMessage))) {
      return null;
    }
    return ((NewFriendSlideTabMessage)this.jdField_a_of_type_ComTencentMobileqqNewfriendMsgNewFriendMessage).a;
  }
  
  public void a(TabLayoutCompat.Tab paramTab)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("builder onTabSelected tab ->");
      localStringBuilder.append(paramTab.a());
      QLog.d("NewFriendSlideTabBuilder", 2, localStringBuilder.toString());
    }
    if ((this.jdField_a_of_type_ComTencentMobileqqNewfriendUiAdapterSystemMsgListBaseAdapter != null) && (paramTab != null))
    {
      this.jdField_a_of_type_ComTencentMobileqqNewfriendUiAdapterSystemMsgListBaseAdapter.b(((Integer)paramTab.a()).intValue(), paramTab.a());
      int i = this.jdField_a_of_type_ComTencentMobileqqNewfriendUiAdapterSystemMsgListBaseAdapter.b();
      ReportController.b(this.jdField_a_of_type_ComTencentCommonAppAppInterface, "dc00898", "", "", "frd_recom", "frd_tab_clk", i, 0, "0", "3", "", "");
    }
  }
  
  public void b(TabLayoutCompat.Tab paramTab) {}
  
  public void c(View paramView)
  {
    if (paramView == null) {
      return;
    }
    if (ThemeUtil.isDefaultTheme())
    {
      paramView.setBackgroundResource(2130839393);
      return;
    }
    paramView.setBackgroundResource(2130850578);
  }
  
  public void c(TabLayoutCompat.Tab paramTab) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.newfriend.ui.builder.NewFriendSlideTabBuilder
 * JD-Core Version:    0.7.0.1
 */