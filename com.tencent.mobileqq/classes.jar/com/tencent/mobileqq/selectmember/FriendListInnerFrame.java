package com.tencent.mobileqq.selectmember;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
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
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.data.Groups;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.search.business.contact.fragment.ContactSearchFragment;
import com.tencent.mobileqq.search.util.SearchUtils;
import com.tencent.mobileqq.utils.ChnToSpell;
import com.tencent.mobileqq.widget.IndexView;
import com.tencent.mobileqq.widget.IndexView.OnIndexChangedListener;
import com.tencent.mobileqq.widget.PinnedDividerListView;
import com.tencent.mobileqq.widget.PinnedDividerListView.OnLayoutListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class FriendListInnerFrame
  extends SelectMemberInnerFrame
  implements View.OnClickListener, IndexView.OnIndexChangedListener, PinnedDividerListView.OnLayoutListener
{
  private int jdField_a_of_type_Int = -2147483648;
  private Handler jdField_a_of_type_AndroidOsHandler = new FriendListInnerFrame.1(this);
  private EditText jdField_a_of_type_AndroidWidgetEditText;
  RelativeLayout jdField_a_of_type_AndroidWidgetRelativeLayout;
  private FriendListInnerFrame.FriendListAdapter jdField_a_of_type_ComTencentMobileqqSelectmemberFriendListInnerFrame$FriendListAdapter;
  private IndexView jdField_a_of_type_ComTencentMobileqqWidgetIndexView;
  PinnedDividerListView jdField_a_of_type_ComTencentMobileqqWidgetPinnedDividerListView;
  private String jdField_a_of_type_JavaLangString;
  List<Friends> jdField_a_of_type_JavaUtilList = new ArrayList();
  private int b;
  
  public FriendListInnerFrame(Context paramContext)
  {
    super(paramContext);
  }
  
  public FriendListInnerFrame(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public FriendListInnerFrame(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  static String a(Friends paramFriends)
  {
    String str = paramFriends.getFriendNick();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(str);
    localStringBuilder.append("-");
    localStringBuilder.append(paramFriends.uin);
    return localStringBuilder.toString();
  }
  
  private void g()
  {
    this.jdField_a_of_type_ComTencentMobileqqWidgetPinnedDividerListView = ((PinnedDividerListView)findViewById(2131364470));
    this.jdField_a_of_type_ComTencentMobileqqWidgetIndexView = ((IndexView)findViewById(2131368761));
    this.jdField_a_of_type_ComTencentMobileqqWidgetIndexView.setIndex(new String[] { "$", "A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z", "#" });
    this.jdField_a_of_type_ComTencentMobileqqWidgetIndexView.setOnIndexChangedListener(this);
    this.jdField_a_of_type_ComTencentMobileqqWidgetPinnedDividerListView.setSelector(2131167333);
    this.jdField_a_of_type_ComTencentMobileqqWidgetPinnedDividerListView.setOnLayoutListener(this);
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)this.jdField_a_of_type_ComTencentMobileqqSelectmemberSelectMemberActivity.getLayoutInflater().inflate(2131562770, this.jdField_a_of_type_ComTencentMobileqqWidgetPinnedDividerListView, false));
    this.jdField_a_of_type_AndroidWidgetEditText = ((EditText)this.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131366333));
    ((Button)this.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131363868)).setVisibility(8);
    this.jdField_a_of_type_ComTencentMobileqqWidgetPinnedDividerListView.addHeaderView(this.jdField_a_of_type_AndroidWidgetRelativeLayout);
  }
  
  private void h()
  {
    this.jdField_a_of_type_JavaUtilList.clear();
    String str = this.jdField_a_of_type_ComTencentCommonAppAppInterface.getCurrentAccountUin();
    Object localObject1 = SearchUtils.a(this.jdField_a_of_type_ComTencentCommonAppAppInterface, String.valueOf(this.b));
    Object localObject2;
    if (localObject1 != null)
    {
      localObject1 = ((List)localObject1).iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (Entity)((Iterator)localObject1).next();
        if (localObject2 != null)
        {
          localObject2 = (Friends)localObject2;
          if (((this.jdField_a_of_type_ComTencentMobileqqSelectmemberSelectMemberActivity.mShowMyself) || (!((Friends)localObject2).uin.equals(str))) && (!this.jdField_a_of_type_ComTencentMobileqqSelectmemberSelectMemberActivity.mUinsToHide.contains(((Friends)localObject2).uin))) {
            this.jdField_a_of_type_JavaUtilList.add(localObject2);
          }
        }
      }
    }
    if ((this.jdField_a_of_type_ComTencentMobileqqSelectmemberSelectMemberActivity.mShowMyself) && (this.b == 0))
    {
      int j = 0;
      localObject1 = SearchUtils.a(this.jdField_a_of_type_ComTencentCommonAppAppInterface);
      int i = j;
      if (localObject1 != null)
      {
        i = j;
        if (((List)localObject1).size() > 0)
        {
          localObject1 = ((List)localObject1).iterator();
          do
          {
            while (!((Iterator)localObject2).hasNext())
            {
              do
              {
                i = j;
                if (!((Iterator)localObject1).hasNext()) {
                  break;
                }
                localObject2 = (Groups)((Iterator)localObject1).next();
                localObject2 = SearchUtils.a(this.jdField_a_of_type_ComTencentCommonAppAppInterface, String.valueOf(((Groups)localObject2).group_id));
              } while ((localObject2 == null) || (((List)localObject2).size() <= 0));
              localObject2 = ((List)localObject2).iterator();
            }
          } while (!((Friends)((Iterator)localObject2).next()).uin.equals(str));
          i = 1;
        }
      }
      if (i == 0)
      {
        localObject1 = new Friends();
        ((Friends)localObject1).uin = str;
        ((Friends)localObject1).name = this.jdField_a_of_type_ComTencentCommonAppAppInterface.getCurrentNickname();
        ((Friends)localObject1).mCompareSpell = ChnToSpell.a(a((Friends)localObject1), 1);
        this.jdField_a_of_type_JavaUtilList.add(localObject1);
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
    setContentView(2131562810);
    g();
    this.jdField_a_of_type_ComTencentMobileqqSelectmemberFriendListInnerFrame$FriendListAdapter = new FriendListInnerFrame.FriendListAdapter(this);
    this.jdField_a_of_type_ComTencentMobileqqWidgetPinnedDividerListView.setAdapter(this.jdField_a_of_type_ComTencentMobileqqSelectmemberFriendListInnerFrame$FriendListAdapter);
  }
  
  public void a(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if (((this.jdField_a_of_type_ComTencentMobileqqWidgetPinnedDividerListView.getFirstVisiblePosition() > 0) || ((this.jdField_a_of_type_ComTencentMobileqqWidgetPinnedDividerListView.getFirstVisiblePosition() == 0) && (this.jdField_a_of_type_ComTencentMobileqqWidgetPinnedDividerListView.getChildCount() < this.jdField_a_of_type_ComTencentMobileqqSelectmemberFriendListInnerFrame$FriendListAdapter.getCount() + this.jdField_a_of_type_ComTencentMobileqqWidgetPinnedDividerListView.getHeaderViewsCount()))) && (!this.jdField_a_of_type_ComTencentMobileqqSelectmemberSelectMemberActivity.isSoftInputShowing()))
    {
      this.jdField_a_of_type_ComTencentMobileqqWidgetIndexView.setVisibility(0);
      this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(1);
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqWidgetIndexView.setVisibility(4);
    this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(2);
  }
  
  public void b(Bundle paramBundle)
  {
    super.b(paramBundle);
    this.b = paramBundle.getInt("friend_team_id");
    this.jdField_a_of_type_JavaLangString = paramBundle.getString("group_name");
    this.jdField_a_of_type_ComTencentMobileqqSelectmemberSelectMemberActivity.setupTitleBar(true, this.jdField_a_of_type_ComTencentMobileqqSelectmemberSelectMemberActivity.getString(2131718718), this.jdField_a_of_type_JavaLangString);
    if (this.b != this.jdField_a_of_type_Int)
    {
      h();
      this.jdField_a_of_type_ComTencentMobileqqSelectmemberFriendListInnerFrame$FriendListAdapter.a();
      this.jdField_a_of_type_ComTencentMobileqqWidgetPinnedDividerListView.setSelection(0);
      this.jdField_a_of_type_Int = this.b;
      return;
    }
    paramBundle = this.jdField_a_of_type_ComTencentMobileqqSelectmemberFriendListInnerFrame$FriendListAdapter;
    if (paramBundle != null) {
      paramBundle.notifyDataSetChanged();
    }
  }
  
  public void d()
  {
    FriendListInnerFrame.FriendListAdapter localFriendListAdapter = this.jdField_a_of_type_ComTencentMobileqqSelectmemberFriendListInnerFrame$FriendListAdapter;
    if (localFriendListAdapter != null) {
      localFriendListAdapter.c();
    }
    super.d();
  }
  
  public void f()
  {
    this.jdField_a_of_type_ComTencentMobileqqSelectmemberFriendListInnerFrame$FriendListAdapter.notifyDataSetChanged();
  }
  
  public void onClick(View paramView)
  {
    FriendListInnerFrame.ViewHolder localViewHolder = (FriendListInnerFrame.ViewHolder)paramView.getTag();
    if ((localViewHolder != null) && (localViewHolder.jdField_a_of_type_AndroidWidgetCheckBox != null) && (localViewHolder.d != null) && (localViewHolder.jdField_a_of_type_AndroidWidgetCheckBox.isEnabled()))
    {
      boolean bool = this.jdField_a_of_type_ComTencentMobileqqSelectmemberSelectMemberActivity.onListViewItemClick(localViewHolder.jdField_a_of_type_JavaLangString, localViewHolder.d.getText().toString(), 0, "-1");
      localViewHolder.jdField_a_of_type_AndroidWidgetCheckBox.setChecked(bool);
      if (AppSetting.d)
      {
        StringBuilder localStringBuilder;
        if (localViewHolder.jdField_a_of_type_AndroidWidgetCheckBox.isChecked())
        {
          localStringBuilder = new StringBuilder();
          localStringBuilder.append(localViewHolder.d.getText().toString());
          localStringBuilder.append(HardCodeUtil.a(2131704974));
          paramView.setContentDescription(localStringBuilder.toString());
        }
        else
        {
          localStringBuilder = new StringBuilder();
          localStringBuilder.append(localViewHolder.d.getText().toString());
          localStringBuilder.append(HardCodeUtil.a(2131704977));
          paramView.setContentDescription(localStringBuilder.toString());
        }
      }
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
  
  public void onIndexChanged(String paramString)
  {
    if ("$".equals(paramString))
    {
      this.jdField_a_of_type_ComTencentMobileqqWidgetPinnedDividerListView.setSelection(0);
      return;
    }
    int i = this.jdField_a_of_type_ComTencentMobileqqSelectmemberFriendListInnerFrame$FriendListAdapter.a(paramString);
    if (i != -1)
    {
      paramString = this.jdField_a_of_type_ComTencentMobileqqWidgetPinnedDividerListView;
      paramString.setSelection(i + paramString.getHeaderViewsCount());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.selectmember.FriendListInnerFrame
 * JD-Core Version:    0.7.0.1
 */