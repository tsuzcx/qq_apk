package com.tencent.mobileqq.selectmember;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.mobileqq.search.util.SearchUtils;
import com.tencent.mobileqq.selectmember.adapter.FacePreloadBaseAdapter;
import com.tencent.mobileqq.selectmember.util.CommonUtils;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;
import java.util.List;

class RecentMemberInnerFrame$RecentMemberAdapter
  extends FacePreloadBaseAdapter
{
  public RecentMemberInnerFrame$RecentMemberAdapter(RecentMemberInnerFrame paramRecentMemberInnerFrame)
  {
    super(paramRecentMemberInnerFrame.jdField_a_of_type_ComTencentMobileqqSelectmemberSelectMemberActivity, paramRecentMemberInnerFrame.jdField_a_of_type_ComTencentCommonAppAppInterface, RecentMemberInnerFrame.a(paramRecentMemberInnerFrame), 1, true);
  }
  
  public int getCount()
  {
    if (RecentMemberInnerFrame.a(this.a) == null) {
      return 0;
    }
    return RecentMemberInnerFrame.a(this.a).size();
  }
  
  public Object getItem(int paramInt)
  {
    if ((paramInt >= 0) && (paramInt < RecentMemberInnerFrame.a(this.a).size())) {
      return RecentMemberInnerFrame.a(this.a).get(paramInt);
    }
    return null;
  }
  
  public long getItemId(int paramInt)
  {
    return 0L;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    Object localObject1;
    if ((paramView != null) && (paramView.getTag() != null))
    {
      localObject1 = (RecentMemberInnerFrame.ViewHolder)paramView.getTag();
    }
    else
    {
      localObject1 = new RecentMemberInnerFrame.ViewHolder(this.a, null);
      paramView = this.a.jdField_a_of_type_ComTencentMobileqqSelectmemberSelectMemberActivity.getLayoutInflater().inflate(2131562820, paramViewGroup, false);
      ((RecentMemberInnerFrame.ViewHolder)localObject1).jdField_a_of_type_AndroidWidgetCheckBox = ((CheckBox)paramView.findViewById(2131364613));
      ((RecentMemberInnerFrame.ViewHolder)localObject1).c = ((ImageView)paramView.findViewById(2131368343));
      ((RecentMemberInnerFrame.ViewHolder)localObject1).jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131371697));
      paramView.setTag(localObject1);
    }
    RecentUser localRecentUser = (RecentUser)getItem(paramInt);
    if (localRecentUser != null)
    {
      if (this.a.jdField_a_of_type_ComTencentMobileqqSelectmemberSelectMemberActivity.isResultListContainFriend(localRecentUser.uin)) {
        ((RecentMemberInnerFrame.ViewHolder)localObject1).jdField_a_of_type_AndroidWidgetCheckBox.setChecked(true);
      } else {
        ((RecentMemberInnerFrame.ViewHolder)localObject1).jdField_a_of_type_AndroidWidgetCheckBox.setChecked(false);
      }
      ((RecentMemberInnerFrame.ViewHolder)localObject1).c.setImageBitmap(a(1, localRecentUser.uin));
      Object localObject2 = SearchUtils.a(this.a.jdField_a_of_type_ComTencentCommonAppAppInterface, localRecentUser.uin);
      if (localObject2 == null) {
        localObject2 = "";
      } else {
        localObject2 = CommonUtils.a((Friends)localObject2);
      }
      ((RecentMemberInnerFrame.ViewHolder)localObject1).jdField_a_of_type_AndroidWidgetTextView.setText((CharSequence)localObject2);
      ((RecentMemberInnerFrame.ViewHolder)localObject1).jdField_a_of_type_JavaLangString = localRecentUser.uin;
      if ((this.a.jdField_a_of_type_ComTencentMobileqqSelectmemberSelectMemberActivity.mUinsSelectedDefault != null) && (this.a.jdField_a_of_type_ComTencentMobileqqSelectmemberSelectMemberActivity.mUinsSelectedDefault.contains(localRecentUser.uin))) {
        ((RecentMemberInnerFrame.ViewHolder)localObject1).jdField_a_of_type_AndroidWidgetCheckBox.setEnabled(false);
      } else {
        ((RecentMemberInnerFrame.ViewHolder)localObject1).jdField_a_of_type_AndroidWidgetCheckBox.setEnabled(true);
      }
      if (AppSetting.d) {
        if ((((RecentMemberInnerFrame.ViewHolder)localObject1).jdField_a_of_type_AndroidWidgetCheckBox.isChecked()) && (((RecentMemberInnerFrame.ViewHolder)localObject1).jdField_a_of_type_AndroidWidgetCheckBox.isEnabled()))
        {
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append((String)localObject2);
          ((StringBuilder)localObject1).append(HardCodeUtil.a(2131713131));
          paramView.setContentDescription(((StringBuilder)localObject1).toString());
        }
        else
        {
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append((String)localObject2);
          ((StringBuilder)localObject1).append(HardCodeUtil.a(2131713128));
          paramView.setContentDescription(((StringBuilder)localObject1).toString());
        }
      }
      paramView.setOnClickListener(this.a);
    }
    EventCollector.getInstance().onListGetView(paramInt, paramView, paramViewGroup, getItemId(paramInt));
    return paramView;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.selectmember.RecentMemberInnerFrame.RecentMemberAdapter
 * JD-Core Version:    0.7.0.1
 */