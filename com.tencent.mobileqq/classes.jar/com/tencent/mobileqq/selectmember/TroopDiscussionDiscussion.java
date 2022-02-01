package com.tencent.mobileqq.selectmember;

import android.os.Bundle;
import com.tencent.common.app.InnerFrameManager;
import com.tencent.mobileqq.data.DiscussionInfo;
import com.tencent.mobileqq.selectmember.adapter.DiscussionListAdapter2;
import com.tencent.mobileqq.selectmember.adapter.DiscussionListAdapter2.DiscussionListListener;
import com.tencent.widget.XListView;

public class TroopDiscussionDiscussion
  extends TroopDiscussionBaseV
  implements DiscussionListAdapter2.DiscussionListListener
{
  private DiscussionListAdapter2 jdField_a_of_type_ComTencentMobileqqSelectmemberAdapterDiscussionListAdapter2;
  private XListView jdField_a_of_type_ComTencentWidgetXListView;
  
  public TroopDiscussionDiscussion(SelectMemberActivity paramSelectMemberActivity)
  {
    super(paramSelectMemberActivity);
  }
  
  public void a(Bundle paramBundle)
  {
    a(2131562830);
    this.jdField_a_of_type_ComTencentWidgetXListView = ((XListView)findViewById(2131381293));
    this.jdField_a_of_type_ComTencentWidgetXListView.setSelector(2131167333);
    this.jdField_a_of_type_ComTencentMobileqqSelectmemberAdapterDiscussionListAdapter2 = new DiscussionListAdapter2(this.jdField_a_of_type_ComTencentMobileqqSelectmemberSelectMemberActivity, this, this.jdField_a_of_type_ComTencentWidgetXListView, this.jdField_a_of_type_ComTencentCommonAppAppInterface, false);
    this.jdField_a_of_type_ComTencentMobileqqSelectmemberAdapterDiscussionListAdapter2.a(true);
    this.jdField_a_of_type_ComTencentWidgetXListView.setAdapter(this.jdField_a_of_type_ComTencentMobileqqSelectmemberAdapterDiscussionListAdapter2);
    this.jdField_a_of_type_ComTencentMobileqqSelectmemberAdapterDiscussionListAdapter2.notifyDataSetChanged();
  }
  
  public void a(DiscussionInfo paramDiscussionInfo)
  {
    if (paramDiscussionInfo != null)
    {
      Bundle localBundle = new Bundle();
      localBundle.putString("group_uin", paramDiscussionInfo.uin);
      localBundle.putString("group_name", paramDiscussionInfo.discussionName);
      this.jdField_a_of_type_ComTencentCommonAppInnerFrameManager.a(7, localBundle);
    }
  }
  
  public void b()
  {
    super.b();
    this.jdField_a_of_type_ComTencentMobileqqSelectmemberAdapterDiscussionListAdapter2.a();
  }
  
  public void b(Bundle paramBundle) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.selectmember.TroopDiscussionDiscussion
 * JD-Core Version:    0.7.0.1
 */