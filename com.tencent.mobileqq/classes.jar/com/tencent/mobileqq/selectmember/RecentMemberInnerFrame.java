package com.tencent.mobileqq.selectmember;

import android.content.Context;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.InnerFrameManager;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.proxy.RecentUserProxy;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.mobileqq.proxy.api.IRecentUserProxyService;
import com.tencent.mobileqq.search.business.contact.fragment.ContactSearchFragment;
import com.tencent.mobileqq.search.util.SearchUtils;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.XListView;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class RecentMemberInnerFrame
  extends SelectMemberInnerFrame
  implements View.OnClickListener
{
  private EditText jdField_a_of_type_AndroidWidgetEditText;
  private RecentMemberInnerFrame.RecentMemberAdapter jdField_a_of_type_ComTencentMobileqqSelectmemberRecentMemberInnerFrame$RecentMemberAdapter;
  private XListView jdField_a_of_type_ComTencentWidgetXListView;
  private List<RecentUser> jdField_a_of_type_JavaUtilList = new ArrayList();
  
  public RecentMemberInnerFrame(Context paramContext)
  {
    super(paramContext);
  }
  
  public RecentMemberInnerFrame(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public RecentMemberInnerFrame(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  private void g()
  {
    this.jdField_a_of_type_JavaUtilList.clear();
    Object localObject1 = ((IRecentUserProxyService)this.jdField_a_of_type_ComTencentCommonAppAppInterface.getRuntimeService(IRecentUserProxyService.class, "")).getRecentUserCache();
    Object localObject2;
    if (localObject1 != null)
    {
      localObject2 = ((RecentUserProxy)localObject1).a(true);
      if (localObject2 != null)
      {
        localObject1 = this.jdField_a_of_type_ComTencentCommonAppAppInterface.getCurrentAccountUin();
        localObject2 = ((List)localObject2).iterator();
      }
    }
    for (;;)
    {
      RecentUser localRecentUser;
      if (((Iterator)localObject2).hasNext())
      {
        localRecentUser = (RecentUser)((Iterator)localObject2).next();
        if (localRecentUser == null) {}
      }
      else
      {
        try
        {
          if ((localRecentUser.getType() != 0) || (Long.parseLong(localRecentUser.uin) < 10000L) || (localRecentUser.uin.equals(localObject1)) || (this.jdField_a_of_type_ComTencentMobileqqSelectmemberSelectMemberActivity.mUinsToHide.contains(localRecentUser.uin))) {
            continue;
          }
          Friends localFriends = SearchUtils.a(this.jdField_a_of_type_ComTencentCommonAppAppInterface, localRecentUser.uin);
          if ((localFriends == null) || (!localFriends.isFriend())) {
            continue;
          }
          this.jdField_a_of_type_JavaUtilList.add(localRecentUser);
        }
        catch (NumberFormatException localNumberFormatException) {}
        return;
      }
    }
  }
  
  public ContactSearchFragment a()
  {
    return ((SelectMemberInnerFrame)this.jdField_a_of_type_ComTencentCommonAppInnerFrameManager.getChildAt(1)).a();
  }
  
  public String a()
  {
    return "-1";
  }
  
  public void a(Bundle paramBundle)
  {
    super.a(paramBundle);
    setContentView(2131562830);
    this.jdField_a_of_type_ComTencentWidgetXListView = ((XListView)findViewById(2131381293));
    this.jdField_a_of_type_ComTencentWidgetXListView.setSelector(2131167333);
    paramBundle = (RelativeLayout)this.jdField_a_of_type_ComTencentMobileqqSelectmemberSelectMemberActivity.getLayoutInflater().inflate(2131562770, this.jdField_a_of_type_ComTencentWidgetXListView, false);
    this.jdField_a_of_type_AndroidWidgetEditText = ((EditText)paramBundle.findViewById(2131366333));
    ((Button)paramBundle.findViewById(2131363868)).setVisibility(8);
    this.jdField_a_of_type_ComTencentWidgetXListView.addHeaderView(paramBundle);
    g();
    this.jdField_a_of_type_ComTencentMobileqqSelectmemberRecentMemberInnerFrame$RecentMemberAdapter = new RecentMemberInnerFrame.RecentMemberAdapter(this);
    this.jdField_a_of_type_ComTencentWidgetXListView.setAdapter(this.jdField_a_of_type_ComTencentMobileqqSelectmemberRecentMemberInnerFrame$RecentMemberAdapter);
  }
  
  public void b(Bundle paramBundle)
  {
    super.b(paramBundle);
    this.jdField_a_of_type_ComTencentMobileqqSelectmemberSelectMemberActivity.setupTitleBar(true, this.jdField_a_of_type_ComTencentMobileqqSelectmemberSelectMemberActivity.getString(2131718718), HardCodeUtil.a(2131713129));
    paramBundle = this.jdField_a_of_type_ComTencentMobileqqSelectmemberRecentMemberInnerFrame$RecentMemberAdapter;
    if (paramBundle != null) {
      paramBundle.notifyDataSetChanged();
    }
  }
  
  public void d()
  {
    RecentMemberInnerFrame.RecentMemberAdapter localRecentMemberAdapter = this.jdField_a_of_type_ComTencentMobileqqSelectmemberRecentMemberInnerFrame$RecentMemberAdapter;
    if (localRecentMemberAdapter != null) {
      localRecentMemberAdapter.a();
    }
    super.d();
  }
  
  public void f()
  {
    this.jdField_a_of_type_ComTencentMobileqqSelectmemberRecentMemberInnerFrame$RecentMemberAdapter.notifyDataSetChanged();
  }
  
  public void onClick(View paramView)
  {
    RecentMemberInnerFrame.ViewHolder localViewHolder = (RecentMemberInnerFrame.ViewHolder)paramView.getTag();
    if ((localViewHolder != null) && (localViewHolder.jdField_a_of_type_JavaLangString != null) && (localViewHolder.jdField_a_of_type_AndroidWidgetCheckBox != null) && (localViewHolder.jdField_a_of_type_AndroidWidgetTextView != null) && (localViewHolder.jdField_a_of_type_AndroidWidgetCheckBox.isEnabled()))
    {
      boolean bool = this.jdField_a_of_type_ComTencentMobileqqSelectmemberSelectMemberActivity.onListViewItemClick(localViewHolder.jdField_a_of_type_JavaLangString, localViewHolder.jdField_a_of_type_AndroidWidgetTextView.getText().toString(), 0, "-1");
      localViewHolder.jdField_a_of_type_AndroidWidgetCheckBox.setChecked(bool);
      if (AppSetting.d)
      {
        StringBuilder localStringBuilder;
        if (localViewHolder.jdField_a_of_type_AndroidWidgetCheckBox.isChecked())
        {
          localStringBuilder = new StringBuilder();
          localStringBuilder.append(localViewHolder.jdField_a_of_type_AndroidWidgetTextView.getText().toString());
          localStringBuilder.append(HardCodeUtil.a(2131713127));
          paramView.setContentDescription(localStringBuilder.toString());
        }
        else
        {
          localStringBuilder = new StringBuilder();
          localStringBuilder.append(localViewHolder.jdField_a_of_type_AndroidWidgetTextView.getText().toString());
          localStringBuilder.append(HardCodeUtil.a(2131713130));
          paramView.setContentDescription(localStringBuilder.toString());
        }
      }
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.selectmember.RecentMemberInnerFrame
 * JD-Core Version:    0.7.0.1
 */