package com.tencent.mobileqq.kandian.biz.ugc.selectmember;

import android.content.res.Resources;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import com.tencent.mobileqq.app.BaseFragment;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.kandian.biz.common.ReadInJoyUtils;
import com.tencent.mobileqq.kandian.biz.ugc.databinding.ObservableArrayList;
import com.tencent.mobileqq.kandian.repo.ugc.ResultRecord;
import com.tencent.widget.PinnedFooterExpandableListView;

public class FriendListFragment
  extends BaseFragment
{
  private View.OnClickListener jdField_a_of_type_AndroidViewView$OnClickListener;
  private ObservableArrayList<ResultRecord> jdField_a_of_type_ComTencentMobileqqKandianBizUgcDatabindingObservableArrayList;
  private SelectMemberBuddyListAdapter jdField_a_of_type_ComTencentMobileqqKandianBizUgcSelectmemberSelectMemberBuddyListAdapter;
  private SelectMemberLimit jdField_a_of_type_ComTencentMobileqqKandianBizUgcSelectmemberSelectMemberLimit;
  private PinnedFooterExpandableListView jdField_a_of_type_ComTencentWidgetPinnedFooterExpandableListView;
  private View.OnClickListener b;
  
  private SelectMemberBuddyListAdapter a()
  {
    SelectMemberLimit localSelectMemberLimit = this.jdField_a_of_type_ComTencentMobileqqKandianBizUgcSelectmemberSelectMemberLimit;
    if ((localSelectMemberLimit != null) && (localSelectMemberLimit.a() == 1)) {
      return new ReadInJoySelectMemberAQAdapter(getBaseActivity(), (QQAppInterface)ReadInJoyUtils.a(), this.jdField_a_of_type_ComTencentWidgetPinnedFooterExpandableListView, true, this.jdField_a_of_type_ComTencentMobileqqKandianBizUgcSelectmemberSelectMemberLimit);
    }
    return new SelectMemberBuddyListAdapter(getBaseActivity(), (QQAppInterface)ReadInJoyUtils.a(), this.jdField_a_of_type_ComTencentWidgetPinnedFooterExpandableListView, true);
  }
  
  public void a(View.OnClickListener paramOnClickListener)
  {
    this.jdField_a_of_type_AndroidViewView$OnClickListener = paramOnClickListener;
  }
  
  public void a(ObservableArrayList<ResultRecord> paramObservableArrayList)
  {
    this.jdField_a_of_type_ComTencentMobileqqKandianBizUgcDatabindingObservableArrayList = paramObservableArrayList;
  }
  
  public void a(SelectMemberLimit paramSelectMemberLimit)
  {
    this.jdField_a_of_type_ComTencentMobileqqKandianBizUgcSelectmemberSelectMemberLimit = paramSelectMemberLimit;
  }
  
  public void b(View.OnClickListener paramOnClickListener)
  {
    this.b = paramOnClickListener;
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    paramViewGroup = paramLayoutInflater.inflate(2131560273, paramViewGroup, false);
    this.jdField_a_of_type_ComTencentWidgetPinnedFooterExpandableListView = ((PinnedFooterExpandableListView)paramViewGroup.findViewById(2131366345));
    paramLayoutInflater = paramLayoutInflater.inflate(2131560274, this.jdField_a_of_type_ComTencentWidgetPinnedFooterExpandableListView, false);
    paramLayoutInflater.findViewById(2131364051).setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
    this.jdField_a_of_type_ComTencentWidgetPinnedFooterExpandableListView.addHeaderView(paramLayoutInflater);
    this.jdField_a_of_type_ComTencentMobileqqKandianBizUgcSelectmemberSelectMemberBuddyListAdapter = a();
    this.jdField_a_of_type_ComTencentMobileqqKandianBizUgcSelectmemberSelectMemberBuddyListAdapter.a(this.jdField_a_of_type_ComTencentMobileqqKandianBizUgcDatabindingObservableArrayList);
    this.jdField_a_of_type_ComTencentMobileqqKandianBizUgcSelectmemberSelectMemberBuddyListAdapter.a(this.b);
    this.jdField_a_of_type_ComTencentWidgetPinnedFooterExpandableListView.setAdapter(this.jdField_a_of_type_ComTencentMobileqqKandianBizUgcSelectmemberSelectMemberBuddyListAdapter);
    this.jdField_a_of_type_ComTencentWidgetPinnedFooterExpandableListView.setSelector(2131167333);
    this.jdField_a_of_type_ComTencentWidgetPinnedFooterExpandableListView.setGroupIndicator(getResources().getDrawable(2130839483));
    this.jdField_a_of_type_ComTencentWidgetPinnedFooterExpandableListView.setOnScrollListener(this.jdField_a_of_type_ComTencentMobileqqKandianBizUgcSelectmemberSelectMemberBuddyListAdapter);
    this.jdField_a_of_type_ComTencentWidgetPinnedFooterExpandableListView.setOnGroupExpandListener(new FriendListFragment.1(this));
    this.jdField_a_of_type_ComTencentWidgetPinnedFooterExpandableListView.setOnGroupCollapseListener(new FriendListFragment.2(this));
    return paramViewGroup;
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    SelectMemberBuddyListAdapter localSelectMemberBuddyListAdapter = this.jdField_a_of_type_ComTencentMobileqqKandianBizUgcSelectmemberSelectMemberBuddyListAdapter;
    if (localSelectMemberBuddyListAdapter != null) {
      localSelectMemberBuddyListAdapter.c();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.ugc.selectmember.FriendListFragment
 * JD-Core Version:    0.7.0.1
 */