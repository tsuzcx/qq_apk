package com.tencent.mobileqq.selectmember;

import android.content.res.Resources;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.LinearLayout;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.InnerFrameManager;
import com.tencent.mobileqq.phonecontact.api.IPhoneContactService;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.PinnedFooterExpandableListView;

public class FriendTabView
  extends TroopDiscussionBaseV
  implements View.OnClickListener
{
  private SelectMemberBuddyListAdapter jdField_a_of_type_ComTencentMobileqqSelectmemberSelectMemberBuddyListAdapter;
  private PinnedFooterExpandableListView jdField_a_of_type_ComTencentWidgetPinnedFooterExpandableListView;
  boolean jdField_a_of_type_Boolean = false;
  boolean b = false;
  
  public FriendTabView(SelectMemberActivity paramSelectMemberActivity)
  {
    super(paramSelectMemberActivity);
    this.jdField_a_of_type_ComTencentMobileqqSelectmemberSelectMemberActivity = paramSelectMemberActivity;
  }
  
  public void a()
  {
    super.a();
    if ((this.b) && (this.jdField_a_of_type_ComTencentCommonAppAppInterface != null))
    {
      IPhoneContactService localIPhoneContactService = (IPhoneContactService)this.jdField_a_of_type_ComTencentCommonAppAppInterface.getRuntimeService(IPhoneContactService.class, "");
      if (localIPhoneContactService != null)
      {
        int i = localIPhoneContactService.getSelfBindState();
        if ((i == 8) || (i == 9)) {
          try
          {
            this.jdField_a_of_type_ComTencentCommonAppInnerFrameManager.a(0);
            return;
          }
          finally
          {
            this.b = false;
          }
        }
      }
    }
  }
  
  public void a(Bundle paramBundle)
  {
    super.a(paramBundle);
    a(2131560456);
    this.jdField_a_of_type_ComTencentWidgetPinnedFooterExpandableListView = ((PinnedFooterExpandableListView)findViewById(2131366345));
    this.jdField_a_of_type_Boolean = false;
    if (QLog.isColorLevel())
    {
      paramBundle = new StringBuilder();
      paramBundle.append("firstUserClicked is ");
      paramBundle.append(this.jdField_a_of_type_Boolean);
      QLog.d("FriendTabView", 2, paramBundle.toString());
    }
    if (!this.jdField_a_of_type_Boolean) {
      this.jdField_a_of_type_ComTencentWidgetPinnedFooterExpandableListView.setFooterEnable(true);
    } else {
      this.jdField_a_of_type_ComTencentWidgetPinnedFooterExpandableListView.setFooterEnable(false);
    }
    this.jdField_a_of_type_ComTencentWidgetPinnedFooterExpandableListView.setListener(new FriendTabView.1(this));
    paramBundle = (LinearLayout)this.jdField_a_of_type_ComTencentMobileqqSelectmemberSelectMemberActivity.getLayoutInflater().inflate(2131562963, null);
    this.jdField_a_of_type_ComTencentWidgetPinnedFooterExpandableListView.addHeaderView(paramBundle);
    paramBundle.findViewById(2131364096).setOnClickListener(new FriendTabView.2(this));
    QLog.d("FriendTabView", 2, "----->onCreate");
    this.jdField_a_of_type_ComTencentMobileqqSelectmemberSelectMemberBuddyListAdapter = new SelectMemberBuddyListAdapter(this.jdField_a_of_type_ComTencentMobileqqSelectmemberSelectMemberActivity, this.jdField_a_of_type_ComTencentCommonAppAppInterface, this.jdField_a_of_type_ComTencentWidgetPinnedFooterExpandableListView, new FriendTabView.3(this), true);
    this.jdField_a_of_type_ComTencentWidgetPinnedFooterExpandableListView.setAdapter(this.jdField_a_of_type_ComTencentMobileqqSelectmemberSelectMemberBuddyListAdapter);
    this.jdField_a_of_type_ComTencentWidgetPinnedFooterExpandableListView.setSelector(2131167333);
    this.jdField_a_of_type_ComTencentWidgetPinnedFooterExpandableListView.setGroupIndicator(this.jdField_a_of_type_ComTencentMobileqqSelectmemberSelectMemberActivity.getResources().getDrawable(2130839483));
    this.jdField_a_of_type_ComTencentWidgetPinnedFooterExpandableListView.setOnScrollListener(this.jdField_a_of_type_ComTencentMobileqqSelectmemberSelectMemberBuddyListAdapter);
    paramBundle = (IPhoneContactService)this.jdField_a_of_type_ComTencentCommonAppAppInterface.getRuntimeService(IPhoneContactService.class, "");
    if ((paramBundle != null) && (!paramBundle.isBindContactOk())) {
      paramBundle.getSelfBindState();
    }
  }
  
  public void b()
  {
    super.b();
    SelectMemberBuddyListAdapter localSelectMemberBuddyListAdapter = this.jdField_a_of_type_ComTencentMobileqqSelectmemberSelectMemberBuddyListAdapter;
    if (localSelectMemberBuddyListAdapter != null) {
      localSelectMemberBuddyListAdapter.b();
    }
  }
  
  public void b(Bundle paramBundle)
  {
    super.b(paramBundle);
    c();
  }
  
  public void c()
  {
    SelectMemberBuddyListAdapter localSelectMemberBuddyListAdapter = this.jdField_a_of_type_ComTencentMobileqqSelectmemberSelectMemberBuddyListAdapter;
    if (localSelectMemberBuddyListAdapter != null) {
      localSelectMemberBuddyListAdapter.a();
    }
  }
  
  public void onClick(View paramView) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.selectmember.FriendTabView
 * JD-Core Version:    0.7.0.1
 */