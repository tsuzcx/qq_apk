package com.tencent.mobileqq.selectmember;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface.OnClickListener;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.common.app.AppInterface;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.data.DiscussionInfo;
import com.tencent.mobileqq.data.DiscussionMemberInfo;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qwallet.IQWalletApi;
import com.tencent.mobileqq.search.business.contact.fragment.ContactSearchFragment;
import com.tencent.mobileqq.selectmember.util.CommonUtils;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.troop.api.IDiscussionService;
import com.tencent.mobileqq.utils.ChnToSpell;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.widget.IndexView;
import com.tencent.mobileqq.widget.IndexView.OnIndexChangedListener;
import com.tencent.mobileqq.widget.PinnedDividerListView;
import com.tencent.mobileqq.widget.PinnedDividerListView.OnLayoutListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class DiscussionMemberListInnerFrame
  extends SelectMemberInnerFrame
  implements View.OnClickListener, CompoundButton.OnCheckedChangeListener, IndexView.OnIndexChangedListener, PinnedDividerListView.OnLayoutListener
{
  private Handler jdField_a_of_type_AndroidOsHandler = new DiscussionMemberListInnerFrame.2(this);
  CheckBox jdField_a_of_type_AndroidWidgetCheckBox;
  RelativeLayout jdField_a_of_type_AndroidWidgetRelativeLayout;
  private DiscussionMemberListInnerFrame.DiscussionMemberListAdapter jdField_a_of_type_ComTencentMobileqqSelectmemberDiscussionMemberListInnerFrame$DiscussionMemberListAdapter;
  private IndexView jdField_a_of_type_ComTencentMobileqqWidgetIndexView;
  PinnedDividerListView jdField_a_of_type_ComTencentMobileqqWidgetPinnedDividerListView;
  private String jdField_a_of_type_JavaLangString = "";
  List<DiscussionMemberInfo> jdField_a_of_type_JavaUtilList = new ArrayList();
  boolean jdField_a_of_type_Boolean;
  private String b;
  private String c;
  
  public DiscussionMemberListInnerFrame(Context paramContext)
  {
    super(paramContext);
  }
  
  public DiscussionMemberListInnerFrame(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public DiscussionMemberListInnerFrame(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  private void a(String paramString, boolean paramBoolean)
  {
    RelativeLayout localRelativeLayout = this.jdField_a_of_type_AndroidWidgetRelativeLayout;
    if ((localRelativeLayout != null) && (localRelativeLayout.getVisibility() == 0))
    {
      boolean bool = false;
      if ((paramString != null) && (!paramBoolean) && (this.jdField_a_of_type_AndroidWidgetCheckBox.isChecked()))
      {
        paramBoolean = bool;
      }
      else
      {
        int j = this.jdField_a_of_type_ComTencentMobileqqSelectmemberDiscussionMemberListInnerFrame$DiscussionMemberListAdapter.getCount();
        int i = 0;
        while (i < j)
        {
          paramString = (DiscussionMemberInfo)this.jdField_a_of_type_ComTencentMobileqqSelectmemberDiscussionMemberListInnerFrame$DiscussionMemberListAdapter.getItem(i);
          if ((paramString != null) && (!this.jdField_a_of_type_ComTencentMobileqqSelectmemberSelectMemberActivity.isResultListContainFriend(paramString.memberUin)))
          {
            paramBoolean = bool;
            break label108;
          }
          i += 1;
        }
        paramBoolean = true;
      }
      label108:
      this.jdField_a_of_type_AndroidWidgetCheckBox.setChecked(paramBoolean);
    }
  }
  
  private void g()
  {
    this.jdField_a_of_type_ComTencentMobileqqWidgetPinnedDividerListView = ((PinnedDividerListView)findViewById(2131364470));
    this.jdField_a_of_type_ComTencentMobileqqWidgetIndexView = ((IndexView)findViewById(2131368761));
    this.jdField_a_of_type_ComTencentMobileqqWidgetIndexView.setIndex(new String[] { "A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z", "#" });
    this.jdField_a_of_type_ComTencentMobileqqWidgetIndexView.setOnIndexChangedListener(this);
    this.jdField_a_of_type_ComTencentMobileqqWidgetPinnedDividerListView.setSelector(2131167333);
    this.jdField_a_of_type_ComTencentMobileqqWidgetPinnedDividerListView.setOnLayoutListener(this);
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)findViewById(2131376735));
    LinearLayout localLinearLayout = (LinearLayout)this.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131370305);
    this.jdField_a_of_type_AndroidWidgetCheckBox = ((CheckBox)findViewById(2131364377));
    localLinearLayout.setOnClickListener(this);
  }
  
  private void h()
  {
    this.jdField_a_of_type_JavaUtilList.clear();
    Object localObject = (ArrayList)((IDiscussionService)this.jdField_a_of_type_ComTencentCommonAppAppInterface.getRuntimeService(IDiscussionService.class, "")).getDiscussionMemberInfoListByUin(this.b);
    if (localObject != null)
    {
      String str = this.jdField_a_of_type_ComTencentCommonAppAppInterface.getCurrentAccountUin();
      localObject = ((List)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        DiscussionMemberInfo localDiscussionMemberInfo = (DiscussionMemberInfo)((Iterator)localObject).next();
        if ((localDiscussionMemberInfo != null) && ((this.jdField_a_of_type_ComTencentMobileqqSelectmemberSelectMemberActivity.mShowMyself) || (!str.equalsIgnoreCase(localDiscussionMemberInfo.memberUin))) && (!this.jdField_a_of_type_ComTencentMobileqqSelectmemberSelectMemberActivity.mUinsToHide.contains(localDiscussionMemberInfo.memberUin)))
        {
          localDiscussionMemberInfo.displayedNamePinyinFirst = ChnToSpell.a(CommonUtils.a(localDiscussionMemberInfo, this.jdField_a_of_type_ComTencentCommonAppAppInterface), 2);
          this.jdField_a_of_type_JavaUtilList.add(localDiscussionMemberInfo);
        }
      }
    }
    this.jdField_a_of_type_ComTencentMobileqqSelectmemberSelectMemberActivity.afterMemberFilter(this.jdField_a_of_type_JavaUtilList.size());
  }
  
  public ContactSearchFragment a()
  {
    return ContactSearchFragment.a(-1, 4096, this.b, this.jdField_a_of_type_ComTencentMobileqqSelectmemberSelectMemberActivity.mUinsToHide, this.jdField_a_of_type_ComTencentMobileqqSelectmemberSelectMemberActivity);
  }
  
  public String a()
  {
    return this.b;
  }
  
  public void a(Bundle paramBundle)
  {
    super.a(paramBundle);
    setContentView(2131562810);
    g();
    this.jdField_a_of_type_ComTencentMobileqqSelectmemberDiscussionMemberListInnerFrame$DiscussionMemberListAdapter = new DiscussionMemberListInnerFrame.DiscussionMemberListAdapter(this);
    this.jdField_a_of_type_ComTencentMobileqqWidgetPinnedDividerListView.setAdapter(this.jdField_a_of_type_ComTencentMobileqqSelectmemberDiscussionMemberListInnerFrame$DiscussionMemberListAdapter);
  }
  
  public void a(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if (((this.jdField_a_of_type_ComTencentMobileqqWidgetPinnedDividerListView.getFirstVisiblePosition() > 0) || ((this.jdField_a_of_type_ComTencentMobileqqWidgetPinnedDividerListView.getFirstVisiblePosition() == 0) && (this.jdField_a_of_type_ComTencentMobileqqWidgetPinnedDividerListView.getChildCount() < this.jdField_a_of_type_ComTencentMobileqqSelectmemberDiscussionMemberListInnerFrame$DiscussionMemberListAdapter.getCount() + this.jdField_a_of_type_ComTencentMobileqqWidgetPinnedDividerListView.getHeaderViewsCount()))) && (!this.jdField_a_of_type_ComTencentMobileqqSelectmemberSelectMemberActivity.isSoftInputShowing()))
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
    this.jdField_a_of_type_ComTencentMobileqqSelectmemberSelectMemberActivity.mSelectedAndSearchBar.b();
    this.b = paramBundle.getString("group_uin");
    this.c = paramBundle.getString("group_name");
    boolean bool = paramBundle.getBoolean("param_enable_all_select", false);
    paramBundle = this.jdField_a_of_type_AndroidWidgetRelativeLayout;
    int i;
    if (bool) {
      i = 0;
    } else {
      i = 8;
    }
    paramBundle.setVisibility(i);
    if ((TextUtils.isEmpty(this.c)) && (!TextUtils.isEmpty(this.b)))
    {
      paramBundle = (DiscussionInfo)((IDiscussionService)this.jdField_a_of_type_ComTencentCommonAppAppInterface.getRuntimeService(IDiscussionService.class, "")).findDiscussionInfoByID(this.b);
      if (paramBundle != null) {
        this.c = paramBundle.discussionName;
      }
    }
    if (this.jdField_a_of_type_ComTencentMobileqqSelectmemberSelectMemberActivity.mOnlyDiscussionMember) {
      this.jdField_a_of_type_ComTencentMobileqqSelectmemberSelectMemberActivity.setupTitleBar(false, "", this.c);
    } else {
      this.jdField_a_of_type_ComTencentMobileqqSelectmemberSelectMemberActivity.setupTitleBar(true, HardCodeUtil.a(2131703528), this.c);
    }
    if ((!TextUtils.isEmpty(this.b)) && (!this.b.equals(this.jdField_a_of_type_JavaLangString)))
    {
      h();
      this.jdField_a_of_type_ComTencentMobileqqSelectmemberDiscussionMemberListInnerFrame$DiscussionMemberListAdapter.a();
      this.jdField_a_of_type_ComTencentMobileqqWidgetPinnedDividerListView.setSelection(0);
      this.jdField_a_of_type_JavaLangString = this.b;
    }
    else
    {
      this.jdField_a_of_type_ComTencentMobileqqSelectmemberDiscussionMemberListInnerFrame$DiscussionMemberListAdapter.notifyDataSetChanged();
    }
    if ((!this.jdField_a_of_type_Boolean) && (this.jdField_a_of_type_ComTencentMobileqqSelectmemberSelectMemberActivity.mIsSelectAllMembers))
    {
      this.jdField_a_of_type_Boolean = true;
      this.jdField_a_of_type_AndroidWidgetCheckBox.setChecked(true);
      paramBundle = this.jdField_a_of_type_AndroidWidgetCheckBox;
      onCheckedChanged(paramBundle, paramBundle.isChecked());
    }
  }
  
  public void d()
  {
    DiscussionMemberListInnerFrame.DiscussionMemberListAdapter localDiscussionMemberListAdapter = this.jdField_a_of_type_ComTencentMobileqqSelectmemberDiscussionMemberListInnerFrame$DiscussionMemberListAdapter;
    if (localDiscussionMemberListAdapter != null) {
      localDiscussionMemberListAdapter.c();
    }
    super.d();
  }
  
  public void f()
  {
    this.jdField_a_of_type_ComTencentMobileqqSelectmemberDiscussionMemberListInnerFrame$DiscussionMemberListAdapter.notifyDataSetChanged();
    a(null, false);
  }
  
  public void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean)
  {
    if (2131364377 == paramCompoundButton.getId())
    {
      if (paramBoolean)
      {
        ArrayList localArrayList = new ArrayList();
        int j = this.jdField_a_of_type_ComTencentMobileqqSelectmemberDiscussionMemberListInnerFrame$DiscussionMemberListAdapter.getCount();
        int i = 0;
        while (i < j)
        {
          DiscussionMemberInfo localDiscussionMemberInfo = (DiscussionMemberInfo)this.jdField_a_of_type_ComTencentMobileqqSelectmemberDiscussionMemberListInnerFrame$DiscussionMemberListAdapter.getItem(i);
          if (localDiscussionMemberInfo != null)
          {
            SelectMemberActivity localSelectMemberActivity = this.jdField_a_of_type_ComTencentMobileqqSelectmemberSelectMemberActivity;
            localArrayList.add(SelectMemberActivity.constructAResultRecord(localDiscussionMemberInfo.memberUin, CommonUtils.a(localDiscussionMemberInfo, this.jdField_a_of_type_ComTencentCommonAppAppInterface), 2, this.b));
          }
          i += 1;
        }
        if (this.jdField_a_of_type_ComTencentMobileqqSelectmemberSelectMemberActivity.mEntrance == 31) {
          ReportController.b(this.jdField_a_of_type_ComTencentCommonAppAppInterface, "dc00898", "", "", "0X8007CFB", "0X8007CFB", 0, 0, "", "", "", "");
        }
        this.jdField_a_of_type_ComTencentMobileqqSelectmemberSelectMemberActivity.addFriendResults(localArrayList, false, true);
      }
      else
      {
        this.jdField_a_of_type_ComTencentMobileqqSelectmemberSelectMemberActivity.removeAllFriendResult();
      }
      this.jdField_a_of_type_ComTencentMobileqqSelectmemberDiscussionMemberListInnerFrame$DiscussionMemberListAdapter.notifyDataSetChanged();
    }
    EventCollector.getInstance().onCheckedChanged(paramCompoundButton, paramBoolean);
  }
  
  public void onClick(View paramView)
  {
    Object localObject2;
    if (2131370305 != paramView.getId())
    {
      localObject1 = (DiscussionMemberListInnerFrame.ViewHolder)paramView.getTag();
      if ((localObject1 != null) && (((DiscussionMemberListInnerFrame.ViewHolder)localObject1).jdField_a_of_type_AndroidWidgetCheckBox != null) && (((DiscussionMemberListInnerFrame.ViewHolder)localObject1).d != null) && (((DiscussionMemberListInnerFrame.ViewHolder)localObject1).jdField_a_of_type_AndroidWidgetCheckBox.isEnabled()))
      {
        boolean bool = this.jdField_a_of_type_ComTencentMobileqqSelectmemberSelectMemberActivity.onListViewItemClick(((DiscussionMemberListInnerFrame.ViewHolder)localObject1).jdField_a_of_type_JavaLangString, ((DiscussionMemberListInnerFrame.ViewHolder)localObject1).d.getText().toString(), 2, this.b);
        ((DiscussionMemberListInnerFrame.ViewHolder)localObject1).jdField_a_of_type_AndroidWidgetCheckBox.setChecked(bool);
        a(((DiscussionMemberListInnerFrame.ViewHolder)localObject1).jdField_a_of_type_JavaLangString, bool);
        if (AppSetting.d) {
          if (((DiscussionMemberListInnerFrame.ViewHolder)localObject1).jdField_a_of_type_AndroidWidgetCheckBox.isChecked())
          {
            localObject2 = new StringBuilder();
            ((StringBuilder)localObject2).append(((DiscussionMemberListInnerFrame.ViewHolder)localObject1).d.getText().toString());
            ((StringBuilder)localObject2).append(HardCodeUtil.a(2131703501));
            paramView.setContentDescription(((StringBuilder)localObject2).toString());
          }
          else
          {
            localObject2 = new StringBuilder();
            ((StringBuilder)localObject2).append(((DiscussionMemberListInnerFrame.ViewHolder)localObject1).d.getText().toString());
            ((StringBuilder)localObject2).append(HardCodeUtil.a(2131703517));
            paramView.setContentDescription(((StringBuilder)localObject2).toString());
          }
        }
      }
    }
    else if (((this.jdField_a_of_type_ComTencentMobileqqSelectmemberSelectMemberActivity.mEntrance == 32) || (this.jdField_a_of_type_ComTencentMobileqqSelectmemberSelectMemberActivity.mEntrance == 43)) && (!this.jdField_a_of_type_AndroidWidgetCheckBox.isChecked()) && (this.jdField_a_of_type_ComTencentMobileqqSelectmemberSelectMemberActivity.mMaxSelectNumber < this.jdField_a_of_type_ComTencentMobileqqSelectmemberDiscussionMemberListInnerFrame$DiscussionMemberListAdapter.b()))
    {
      localObject1 = new DiscussionMemberListInnerFrame.1(this);
      localObject2 = MessageFormat.format(this.jdField_a_of_type_ComTencentMobileqqSelectmemberSelectMemberActivity.getString(2131718717), new Object[] { Integer.valueOf(this.jdField_a_of_type_ComTencentMobileqqSelectmemberSelectMemberActivity.mMaxSelectNumber) });
      localObject1 = DialogUtil.a(this.jdField_a_of_type_ComTencentMobileqqSelectmemberSelectMemberActivity, 232, this.jdField_a_of_type_ComTencentMobileqqSelectmemberSelectMemberActivity.getResources().getString(2131719632), (String)localObject2, 2131690728, 2131698946, (DialogInterface.OnClickListener)localObject1, (DialogInterface.OnClickListener)localObject1);
    }
    try
    {
      ((Dialog)localObject1).show();
    }
    catch (Throwable localThrowable)
    {
      break label424;
    }
    Object localObject1 = this.jdField_a_of_type_AndroidWidgetCheckBox;
    ((CheckBox)localObject1).setChecked(true ^ ((CheckBox)localObject1).isChecked());
    localObject1 = this.jdField_a_of_type_AndroidWidgetCheckBox;
    onCheckedChanged((CompoundButton)localObject1, ((CheckBox)localObject1).isChecked());
    if (this.jdField_a_of_type_ComTencentMobileqqSelectmemberSelectMemberActivity.mEntrance == 32)
    {
      localObject2 = (IQWalletApi)QRoute.api(IQWalletApi.class);
      if (this.jdField_a_of_type_AndroidWidgetCheckBox.isChecked()) {
        localObject1 = "friendsfinder.all.confirm";
      } else {
        localObject1 = "friendsfinder.all.cancel";
      }
      ((IQWalletApi)localObject2).reportTenpay(0, (String)localObject1);
    }
    label424:
    EventCollector.getInstance().onViewClicked(paramView);
  }
  
  public void onIndexChanged(String paramString)
  {
    if ("$".equals(paramString))
    {
      this.jdField_a_of_type_ComTencentMobileqqWidgetPinnedDividerListView.setSelection(0);
      return;
    }
    int i = this.jdField_a_of_type_ComTencentMobileqqSelectmemberDiscussionMemberListInnerFrame$DiscussionMemberListAdapter.a(paramString);
    if (i != -1)
    {
      paramString = this.jdField_a_of_type_ComTencentMobileqqWidgetPinnedDividerListView;
      paramString.setSelection(i + paramString.getHeaderViewsCount());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.selectmember.DiscussionMemberListInnerFrame
 * JD-Core Version:    0.7.0.1
 */